#!/usr/bin/env python3
"""
sparse-bootstrap.py

Given a seed module directory, walks its parent chain, BOM-import graph, and
regular <dependency> edges that resolve to other poms in this monorepo, adds
the discovered directories to the sparse checkout, and installs them into
~/.m2 in dependency order.

Prerequisites:
    git clone --sparse git@github.com:googleapis/google-cloud-java.git
    cd google-cloud-java
    git sparse-checkout set <seed-module>

Usage (from repo root):
    python java-bigtable/scripts/sparse-bootstrap.py <seed-dir> [--dry-run]

Example:
    python java-bigtable/scripts/sparse-bootstrap.py java-bigtable
"""

import io
import os
import subprocess
import sys
import xml.etree.ElementTree as ET
from collections import defaultdict, deque
from dataclasses import dataclass
from pathlib import Path
from typing import Optional

NS = '{http://maven.apache.org/POM/4.0.0}'


@dataclass(frozen=True)
class Coord:
    group_id: Optional[str]
    artifact_id: Optional[str]


@dataclass(frozen=True)
class GitBlob:
    sha: str
    path: Path


@dataclass(frozen=True)
class ParentRef:
    coord: Coord
    version: str
    relative_path: str  # '' means <relativePath/> was explicit → fetch from ~/.m2


@dataclass
class InstallCommand:
    cwd: str
    cmd: list[str]


# ── git helpers ────────────────────────────────────────────────────────────────

def ls_tree_poms() -> list[GitBlob]:
    """Return a GitBlob for every pom.xml in HEAD."""
    # Each output line is:  <mode> <type> <sha>\t<path>
    # e.g.: 100644 blob abc123def\tjava-bigtable/pom.xml
    out = subprocess.run(
        ['git', 'ls-tree', '-r', 'HEAD'],
        capture_output=True, text=True, check=True,
    ).stdout
    results: list[GitBlob] = []
    for line in out.splitlines():
        meta, path = line.split('\t', 1)
        # Match the basename exactly — endswith('pom.xml') would also accept
        # things like src/test/resources/gax-example-pom.xml.
        if Path(path).name != 'pom.xml':
            continue
        _, _, sha = meta.split()
        results.append(GitBlob(sha=sha, path=Path(path)))
    return results


def batch_cat(pom_refs: list[GitBlob]) -> dict[Path, str]:
    """Read many git blobs in one subprocess call. Returns {path: text}."""
    if not pom_refs:
        return {}
    # stdin:  one sha per line
    # stdout: for each sha, either:
    #   "<sha> blob <size>\n<content bytes>\n"
    #   "<sha> missing\n"
    raw = subprocess.run(
        ['git', 'cat-file', '--batch', '--buffer'],
        input='\n'.join(ref.sha for ref in pom_refs).encode(),
        capture_output=True,
        check=True,
    ).stdout
    contents: dict[Path, str] = {}
    buf = io.BytesIO(raw)
    for ref in pom_refs:
        header = buf.readline().decode()
        expected = f'{ref.sha} blob '
        if not header.startswith(expected):
            raise RuntimeError(f'unexpected git cat-file response for {ref.path}: {header.strip()!r}')
        size = int(header[len(expected):])
        text = buf.read(size).decode('utf-8', errors='replace')
        buf.read(1)  # trailing newline after each blob
        if text.lstrip().startswith('<'):
            contents[ref.path] = text
        else:
            print(f'  skipping non-XML pom: {ref.path}')
    return contents


# ── pom parsing ────────────────────────────────────────────────────────────────

def t(name: str) -> str:
    return f'{NS}{name}'


def child_text(elem: ET.Element, path: str) -> Optional[str]:
    e = elem.find('/'.join(t(tag) for tag in path.split('/')))
    return e.text.strip() if e is not None and e.text else None


def get_coordinates(root: ET.Element) -> Coord:
    g = child_text(root, 'groupId') or child_text(root, 'parent/groupId')
    a = child_text(root, 'artifactId')
    return Coord(group_id=g, artifact_id=a)


def get_version(root: ET.Element) -> Optional[str]:
    """The pom's own version (or inherited from <parent><version>)."""
    return child_text(root, 'version') or child_text(root, 'parent/version')


def get_parent(root: ET.Element) -> Optional[ParentRef]:
    p = root.find(t('parent'))
    if p is None:
        return None
    rel_elem = p.find(t('relativePath'))
    if rel_elem is None:
        rel = '../pom.xml'                   # Maven default when element is absent
    else:
        rel = (rel_elem.text or '').strip()  # empty string → remote
    return ParentRef(
        coord=Coord(
            group_id=child_text(p, 'groupId'),
            artifact_id=child_text(p, 'artifactId'),
        ),
        version=child_text(p, 'version') or '',
        relative_path=rel,
    )


def get_bom_imports(root: ET.Element) -> list[tuple[Coord, str]]:
    """(Coord, version) for every scope=import dependency."""
    results: list[tuple[Coord, str]] = []
    for dep in root.findall(
        f'.//{t("dependencyManagement")}/{t("dependencies")}/{t("dependency")}'
    ):
        if child_text(dep, 'scope') == 'import':
            g = child_text(dep, 'groupId')
            a = child_text(dep, 'artifactId')
            v = child_text(dep, 'version')
            if g and a and v:
                results.append((Coord(group_id=g, artifact_id=a), v))
    return results


def get_regular_deps(root: ET.Element) -> list[tuple[Coord, Optional[str]]]:
    """(Coord, version) for every <dependency> under <dependencies>.

    version is None when the dep relies on dependencyManagement to supply it.
    """
    results: list[tuple[Coord, Optional[str]]] = []
    deps = root.find(t('dependencies'))
    if deps is None:
        return results
    for dep in deps.findall(t('dependency')):
        g = child_text(dep, 'groupId')
        a = child_text(dep, 'artifactId')
        v = child_text(dep, 'version')
        if g and a:
            results.append((Coord(group_id=g, artifact_id=a), v))
    return results


# ── dependency discovery ───────────────────────────────────────────────────────

def find_needed_modules(
    seed_dir: Path,
    pom_contents: dict[Path, str],
    coord_to_pom: dict[Coord, Path],
) -> tuple[set[Path], dict[Path, set[Path]]]:
    """BFS from all poms under seed_dir following parent chain and BOM imports.

    Returns:
        needed_poms: set of pom paths outside seed_dir that must be installed
        dep_edges:   {pom_path: {pom_paths it depends on}} for topological sort
    """
    needed: set[Path] = set()
    dep_edges: dict[Path, set[Path]] = defaultdict(set)
    visited: set[Path] = set()
    queue: deque[Path] = deque()

    def enqueue(pom_path: Path, required_by: Optional[Path] = None) -> None:
        if required_by:
            dep_edges[required_by].add(pom_path)
        if pom_path in visited:
            return
        visited.add(pom_path)
        needed.add(pom_path)
        queue.append(pom_path)

    def resolve_local(coord: Coord, declared_version: Optional[str]) -> Optional[Path]:
        """Local pom whose version matches the declared version, or None.

        - No coord match in the monorepo → None.
        - declared_version is None (regular dep inheriting from depMgmt) → follow
          the local pom optimistically; we'd need full Maven evaluation to know
          the resolved version, and in this monorepo unversioned deps virtually
          always inherit from a SNAPSHOT BOM.
        - Either version contains a Maven property (${…}) → follow optimistically.
        - Otherwise the versions must equal.
        """
        local = coord_to_pom.get(coord)
        if local is None:
            return None
        if declared_version is None:
            return local
        local_version = get_version(ET.fromstring(pom_contents[local])) or ''
        if '${' in declared_version or '${' in local_version:
            return local
        return local if local_version == declared_version else None

    # Seed: every pom under seed_dir — pre-visited so they won't enter `needed`
    for path in pom_contents:
        if path.is_relative_to(seed_dir):
            visited.add(path)
            queue.append(path)

    while queue:
        pom_path = queue.popleft()
        root = ET.fromstring(pom_contents[pom_path])

        # Follow <parent> chain
        parent = get_parent(root)
        if parent:
            resolved = None
            if parent.relative_path:
                # normpath collapses '..' without making the path absolute
                local_parent = Path(os.path.normpath(pom_path.parent / parent.relative_path))
                # <relativePath> may point to a directory; Maven appends pom.xml in that case
                if local_parent.name != 'pom.xml':
                    local_parent = local_parent / 'pom.xml'
                if local_parent in pom_contents:
                    # Maven only uses the pom at <relativePath> if its coords AND
                    # version match <parent>; otherwise it falls back to the repo.
                    # The default ../pom.xml routinely resolves to an unrelated
                    # repo-root pom.
                    local_root = ET.fromstring(pom_contents[local_parent])
                    if (get_coordinates(local_root) == parent.coord
                            and (get_version(local_root) or '') == parent.version):
                        resolved = local_parent
            # fall back to coordinate lookup if relativePath missing, not found
            # locally, or the local pom didn't match the declared parent
            if resolved is None:
                resolved = resolve_local(parent.coord, parent.version)
            if resolved is not None:
                enqueue(resolved, required_by=pom_path)

        # Follow BOM imports
        for coord, version in get_bom_imports(root):
            local = resolve_local(coord, version)
            if local is not None:
                enqueue(local, required_by=pom_path)

        # Follow regular <dependency> edges that resolve to another pom in this repo
        for coord, version in get_regular_deps(root):
            local = resolve_local(coord, version)
            if local is not None:
                enqueue(local, required_by=pom_path)

        # Operational dep on the project's aggregator pom: we'll `cd <project>`
        # to run mvn, which forces Maven to load <project>/pom.xml regardless
        # of -pl, so its parent chain must already be installed. The aggregator
        # is often unrelated to the module's own parent chain (e.g. pubsub-bom
        # parents to a shared pom, not java-pubsub/pom.xml).
        project_root = Path(pom_path.parts[0]) / 'pom.xml'
        if project_root != pom_path and project_root in pom_contents:
            enqueue(project_root, required_by=pom_path)

    return needed, dep_edges


# ── topological sort ───────────────────────────────────────────────────────────

def topo_sort(
    nodes: set[Path],
    dep_edges: dict[Path, set[Path]],
) -> list[Path]:
    """Returns nodes ordered so each node appears after its dependencies."""
    visited: set[Path] = set()
    order: list[Path] = []

    def visit(n: Path) -> None:
        if n in visited:
            return
        visited.add(n)
        for dep in sorted(dep_edges.get(n, [])):
            visit(dep)
        order.append(n)

    for n in sorted(nodes):
        visit(n)
    return order


# ── install command generation ─────────────────────────────────────────────────

def make_install_commands(sorted_poms: list[Path]) -> list[InstallCommand]:
    """One mvn install per consecutive run of poms in the same top-level project.

    We can't collapse all poms under a project into a single mvn invocation:
    the topo order may interleave projects (e.g. A1, A2, B1, A3) when A3 has
    a cross-project dep on B1. Flushing on project change preserves the order.
    """
    groups: list[tuple[str, list[str]]] = []  # [(project, [module_rel_paths])]

    for pom_path in sorted_poms:
        project = pom_path.parts[0]
        pom_dir = pom_path.parent
        rel = str(pom_dir.relative_to(project)) if pom_dir != Path(project) else '.'

        if groups and groups[-1][0] == project:
            modules = groups[-1][1]
            if rel not in modules:
                modules.append(rel)
        else:
            groups.append((project, [rel]))

    commands: list[InstallCommand] = []
    for project, modules in groups:
        sub_modules = [m for m in modules if m != '.']
        cmd = ['mvn', 'install', '-T', '1C', '-DskipTests', '-P', 'quick-build']
        if sub_modules:
            for m in sub_modules:
                cmd += ['-pl', m]
            cmd.append('-am')
        else:
            cmd.append('-N')  # root pom only — skip recursive submodule build
        commands.append(InstallCommand(cwd=project, cmd=cmd))
    return commands


# ── main ───────────────────────────────────────────────────────────────────────

def main() -> None:
    raw_args = [a for a in sys.argv[1:] if not a.startswith('--')]
    dry_run = '--dry-run' in sys.argv

    if not raw_args:
        sys.exit(f'usage: {sys.argv[0]} <seed-module-dir> [--dry-run]')

    seed_dir = Path(raw_args[0])

    if not seed_dir.is_dir():
        sys.exit(f'error: seed directory not found: {seed_dir!r}')
    if not (seed_dir / 'pom.xml').is_file():
        sys.exit(f'error: no pom.xml in {seed_dir!r}')

    print(f'Seed module: {seed_dir}')

    print('Listing pom.xml files in repo...')
    pom_refs = ls_tree_poms()
    print(f'  {len(pom_refs)} pom files')

    print('Reading all pom files from git object store...')
    pom_contents = batch_cat(pom_refs)
    print(f'  {len(pom_contents)} pom files read')

    print('Building coordinate → pom path index...')
    coord_to_pom: dict[Coord, Path] = {}
    for path, content in pom_contents.items():
        root = ET.fromstring(content)
        coord = get_coordinates(root)
        if coord.group_id and coord.artifact_id:
            coord_to_pom[coord] = path
    print(f'  {len(coord_to_pom)} artifacts indexed')

    print(f'Walking dependency graph from {seed_dir}...')
    needed_poms, dep_edges = find_needed_modules(seed_dir, pom_contents, coord_to_pom)
    sorted_poms = topo_sort(needed_poms, dep_edges)

    # root-level files are always present in cone mode — only add subdirectories
    top_dirs = sorted({p.parts[0] for p in needed_poms if len(p.parts) > 1})
    print(f'\nTop-level directories needed:')
    for d in top_dirs:
        print(f'  {d}')

    print(f'\nPom files to install ({len(sorted_poms)}):')
    for p in sorted_poms:
        print(f'  {p}')

    install_cmds = make_install_commands(sorted_poms)
    print('\nInstall commands (in order):')
    for ic in install_cmds:
        print(f'  (cd {ic.cwd} && {" ".join(ic.cmd)})')

    if dry_run:
        print('\n--dry-run: stopping before making changes')
        return

    if top_dirs:
        print('\nUpdating sparse checkout...')
        subprocess.run(['git', 'sparse-checkout', 'add'] + top_dirs, check=True)

    print('\nInstalling...')
    for ic in install_cmds:
        print(f'\n>>> cd {ic.cwd} && {" ".join(ic.cmd)}')
        result = subprocess.run(ic.cmd, cwd=ic.cwd)
        if result.returncode != 0:
            sys.exit(f'error: install failed in {ic.cwd}')

    print(f'\nBootstrap complete. You can now develop in {seed_dir}.')


if __name__ == '__main__':
    main()

#!/usr/bin/env python3
"""
sparse-bootstrap.py

Given a seed module directory, walks its parent-chain and BOM-import graph,
adds the discovered dependency directories to the sparse checkout, and
installs them into ~/.m2 in dependency order.

Prerequisites:
    git clone --sparse git@github.com:googleapis/google-cloud-java.git
    cd google-cloud-java
    git sparse-checkout init --cone
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
        if not path.endswith('pom.xml'):
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
        relative_path=rel,
    )


def get_bom_imports(root: ET.Element) -> list[Coord]:
    """Coord for every scope=import dependency."""
    results: list[Coord] = []
    for dep in root.findall(
        f'.//{t("dependencyManagement")}/{t("dependencies")}/{t("dependency")}'
    ):
        if child_text(dep, 'scope') == 'import':
            g = child_text(dep, 'groupId')
            a = child_text(dep, 'artifactId')
            if g and a:
                results.append(Coord(group_id=g, artifact_id=a))
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
            if parent.relative_path:
                # normpath collapses '..' without making the path absolute
                local_parent = Path(os.path.normpath(pom_path.parent / parent.relative_path))
                if local_parent in pom_contents:
                    enqueue(local_parent, required_by=pom_path)
            elif parent.coord in coord_to_pom:
                enqueue(coord_to_pom[parent.coord], required_by=pom_path)

        # Follow BOM imports
        for coord in get_bom_imports(root):
            if coord in coord_to_pom:
                enqueue(coord_to_pom[coord], required_by=pom_path)

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
    """One mvn install command per top-level project, in dependency order."""
    by_project: dict[str, list[str]] = defaultdict(list)
    project_order: list[str] = []
    seen_projects: set[str] = set()

    for pom_path in sorted_poms:
        project = pom_path.parts[0]
        if project not in seen_projects:
            seen_projects.add(project)
            project_order.append(project)

        pom_dir = pom_path.parent
        rel = str(pom_dir.relative_to(project)) if pom_dir != Path(project) else '.'
        if rel not in by_project[project]:
            by_project[project].append(rel)

    commands: list[InstallCommand] = []
    for project in project_order:
        sub_modules = [m for m in by_project[project] if m != '.']
        cmd = ['mvn', 'install', '-T', '1C', '-DskipTests', '-P', 'quick-build']
        for m in sub_modules:
            cmd += ['-pl', m]
        if sub_modules:
            cmd.append('-am')
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

    top_dirs = sorted({p.parts[0] for p in needed_poms})
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

#!/usr/bin/env python3
# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import argparse
import os
import sys
import xml.etree.ElementTree as ET
from collections import defaultdict
from typing import Dict, List, Set, Tuple

# Maven XML namespace
NS = {'mvn': 'http://maven.apache.org/POM/4.0.0'}

class Module:
    def __init__(self, path: str, group_id: str, artifact_id: str, parent: Tuple[str, str] = None):
        self.path = path
        self.group_id = group_id
        self.artifactId = artifact_id
        self.parent = parent
        self.dependencies: Set[Tuple[str, str]] = set()

    @property
    def key(self) -> Tuple[str, str]:
        return (self.group_id, self.artifactId)

    def __repr__(self):
        return f"{self.group_id}:{self.artifactId}"

def parse_pom(path: str) -> Module:
    try:
        tree = ET.parse(path)
        root = tree.getroot()
    except ET.ParseError as e:
        print(f"Error parsing {path}: {e}", file=sys.stderr)
        return None

    # Handle namespace if present
    # XML tags in ElementTree are {namespace}tag
    # We'll use find with namespaces for robustness, but simple logic for extraction
    
    # Helper to clean tag name
    def local_name(tag):
        if '}' in tag:
            return tag.split('}', 1)[1]
        return tag

    parent_elem = root.find('mvn:parent', NS)
    parent_coords = None
    parent_group_id = None
    if parent_elem is not None:
        p_group = parent_elem.find('mvn:groupId', NS).text
        p_artifact = parent_elem.find('mvn:artifactId', NS).text
        parent_coords = (p_group, p_artifact)
        parent_group_id = p_group

    group_id_elem = root.find('mvn:groupId', NS)
    # Inherit groupId from parent if not specified
    if group_id_elem is not None:
        group_id = group_id_elem.text
    elif parent_group_id:
        group_id = parent_group_id
    else:
        # Fallback or error? For now, use artifactId as heuristic or empty
        group_id = "unknown"

    artifact_id = root.find('mvn:artifactId', NS).text
    
    module = Module(path, group_id, artifact_id, parent_coords)

    # Dependencies
    def add_dependencies(section):
        if section is not None:
            for dep in section.findall('mvn:dependency', NS):
                d_group = dep.find('mvn:groupId', NS)
                d_artifact = dep.find('mvn:artifactId', NS)
                if d_group is not None and d_artifact is not None:
                    module.dependencies.add((d_group.text, d_artifact.text))

    add_dependencies(root.find('mvn:dependencies', NS))
    
    dep_mgmt = root.find('mvn:dependencyManagement', NS)
    if dep_mgmt is not None:
        add_dependencies(dep_mgmt.find('mvn:dependencies', NS))

    # Plugin dependencies
    build = root.find('mvn:build', NS)
    if build is not None:
        plugins = build.find('mvn:plugins', NS)
        if plugins is not None:
            for plugin in plugins.findall('mvn:plugin', NS):
                # Plugin itself
                p_group = plugin.find('mvn:groupId', NS)
                p_artifact = plugin.find('mvn:artifactId', NS)
                if p_group is not None and p_artifact is not None:
                    module.dependencies.add((p_group.text, p_artifact.text))
                
                # Plugin dependencies
                add_dependencies(plugin.find('mvn:dependencies', NS))
        
        # Plugin Management
        plugin_mgmt = build.find('mvn:pluginManagement', NS)
        if plugin_mgmt is not None:
             plugins = plugin_mgmt.find('mvn:plugins', NS)
             if plugins is not None:
                for plugin in plugins.findall('mvn:plugin', NS):
                    # Plugin itself
                    p_group = plugin.find('mvn:groupId', NS)
                    p_artifact = plugin.find('mvn:artifactId', NS)
                    if p_group is not None and p_artifact is not None:
                        module.dependencies.add((p_group.text, p_artifact.text))

                    add_dependencies(plugin.find('mvn:dependencies', NS))

    return module

def find_poms(root_dir: str) -> List[str]:
    pom_files = []
    for dirpath, dirnames, filenames in os.walk(root_dir):
        # Skip hidden directories and known non-module dirs
        dirnames[:] = [d for d in dirnames if not d.startswith('.')]
        
        if 'pom.xml' in filenames:
            pom_files.append(os.path.join(dirpath, 'pom.xml'))
    return pom_files

def build_graph(root_dir: str) -> Tuple[Dict[Tuple[str, str], Module], Dict[Tuple[str, str], Set[Tuple[str, str]]]]:
    pom_paths = find_poms(root_dir)
    modules: Dict[Tuple[str, str], Module] = {}
    
    # First pass: load all modules
    for path in pom_paths:
        module = parse_pom(path)
        if module:
            modules[module.key] = module

    # Build adjacency list: dependent -> dependencies (upstream)
    # Only include dependencies that are present in the repo
    graph: Dict[Tuple[str, str], Set[Tuple[str, str]]] = defaultdict(set)
    
    for key, module in modules.items():
        # Parent dependency
        if module.parent and module.parent in modules:
            graph[key].add(module.parent)
        
        # Regular dependencies
        for dep_key in module.dependencies:
            if dep_key in modules:
                graph[key].add(dep_key)
                
    return modules, graph

def get_transitive_dependencies(
    start_nodes: List[Tuple[str, str]], 
    graph: Dict[Tuple[str, str], Set[Tuple[str, str]]]
) -> Set[Tuple[str, str]]:
    visited = set()
    stack = list(start_nodes)
    
    while stack:
        node = stack.pop()
        if node not in visited:
            visited.add(node)
            # Add upstream dependencies to stack
            if node in graph:
                for upstream in graph[node]:
                    if upstream not in visited:
                        stack.append(upstream)
    
    return visited

def resolve_modules_from_inputs(inputs: List[str], modules_by_path: Dict[str, Module], modules_by_key: Dict[Tuple[str, str], Module]) -> List[Tuple[str, str]]:
    resolved = set()
    for item in inputs:
        # Check if item is a path
        abs_item = os.path.abspath(item)
        
        # If it's a file, try to find the nearest pom.xml
        if os.path.isfile(abs_item) or (not item.endswith('pom.xml') and os.path.isdir(abs_item)):
             # Heuristic: if it's a file, find containing pom
             # if it's a dir, look for pom.xml inside or check if it matches a module path
             candidate_path = abs_item
             if os.path.isfile(candidate_path) and not candidate_path.endswith('pom.xml'):
                 candidate_path = os.path.dirname(candidate_path)
             
             # Traverse up to find pom.xml
             while candidate_path.startswith(os.getcwd()) and len(candidate_path) >= len(os.getcwd()):
                 pom_path = os.path.join(candidate_path, 'pom.xml')
                 if pom_path in modules_by_path:
                     resolved.add(modules_by_path[pom_path].key)
                     break
                 candidate_path = os.path.dirname(candidate_path)
        elif item.endswith('pom.xml') and os.path.abspath(item) in modules_by_path:
             resolved.add(modules_by_path[os.path.abspath(item)].key)
        else:
            # Try to match simple name (artifactId) or groupId:artifactId
            found = False
            for key, module in modules_by_key.items():
                if item == module.artifactId or item == f"{module.group_id}:{module.artifactId}":
                    resolved.add(key)
                    found = True
                    break
            if not found:
                print(f"Warning: Could not resolve input '{item}' to a module.", file=sys.stderr)
    
    return list(resolved)

def main():
    parser = argparse.ArgumentParser(description='Identify upstream dependencies for partial builds.')
    parser.add_argument('modules', nargs='+', help='List of modified modules or file paths')
    args = parser.parse_args()

    root_dir = os.getcwd()
    modules_by_key, graph = build_graph(root_dir)
    modules_by_path = {m.path: m for m in modules_by_key.values()}

    start_nodes = resolve_modules_from_inputs(args.modules, modules_by_path, modules_by_key)
    
    if not start_nodes:
        print("No valid modules found from input.", file=sys.stderr)
        return

    # Get transitive upstream dependencies
    # We include the start nodes themselves in the output set if they are dependencies of other start nodes? 
    # Usually we want: Dependencies of (Start Nodes) NOT INCLUDING Start Nodes themselves, unless A depends on B and both are modified.
    # But for "installing dependencies", we generally want EVERYTHING upstream of the modified set.
    # If I modified A, and A depends on B, I want to install B.
    # If I modified A and B, and A depends on B, I want to install B (before A).
    # But usually the build system will build A and B if I say "build A and B".
    # The request is: "determine which modules will need to be compiled and installed to the local maven repository"
    # This implies we want the COMPLEMENT set of the modified modules, restricted to the upstream graph.
    
    all_dependencies = get_transitive_dependencies(start_nodes, graph)
    
    # Filter out the start nodes themselves, because they are the "modified" ones 
    # that will presumably be built by the test command itself?
    # Actually, usually 'dependencies.sh' installs everything needed for the tests.
    # If I am testing A, I need B installed.
    # If I am testing A and B, I need C (upstream of B) installed.
    # So I need (TransitiveClosure(StartNodes) - StartNodes).
    
    upstream_only = all_dependencies - set(start_nodes)
    
    # Map back to paths or artifactIds?
    # `mvn -pl` takes directory paths or [groupId]:artifactId
    # Directory paths are safer if artifactIds are not unique (rare but possible)
    # relpath is good.
    
    results = []
    for key in upstream_only:
        module = modules_by_key[key]
        rel_path = os.path.relpath(os.path.dirname(module.path), root_dir)
        # Maven -pl expects project dir or group:artifact
        results.append(rel_path)
        
    print(','.join(sorted(results)))

if __name__ == '__main__':
    main()

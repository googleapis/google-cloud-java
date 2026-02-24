# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import argparse
import sys
import re
import os
import subprocess
import tempfile
import xml.etree.ElementTree as ET

def get_managed_dependencies(pom_path):
    """Runs mvn help:effective-pom and extracts non-snapshot managed dependencies."""
    managed_deps = {}
    if not os.path.exists(pom_path):
        return managed_deps

    with tempfile.NamedTemporaryFile(suffix='.xml', delete=True) as tmp:
        try:
            # We use -Doutput to write to the temp file
            # We use -DskipTests for speed, and -B for batch mode
            cmd = [
                'mvn', 'help:effective-pom',
                '-f', pom_path,
                '-Doutput=' + tmp.name,
                '-DskipTests',
                '-B',
                '-q'
            ]
            print(f"Resolving managed dependencies from {pom_path}...")
            subprocess.run(cmd, check=True)
            
            tree = ET.parse(tmp.name)
            root = tree.getroot()
            
            # Namespace handling for Maven POM
            ns = {'mvn': 'http://maven.apache.org/POM/4.0.0'}
            
            # Use XPath to find managed dependencies
            deps_selection = root.findall('.//mvn:dependencyManagement/mvn:dependencies/mvn:dependency', ns)
            for dep in deps_selection:
                gid_node = dep.find('mvn:groupId', ns)
                aid_node = dep.find('mvn:artifactId', ns)
                ver_node = dep.find('mvn:version', ns)
                
                if gid_node is not None and aid_node is not None and ver_node is not None:
                    group_id = gid_node.text.strip()
                    artifact_id = aid_node.text.strip()
                    version = ver_node.text.strip()
                    
                    if version and '-SNAPSHOT' not in version:
                        managed_deps[(group_id, artifact_id)] = version
        except Exception as e:
            print(f"Warning: Failed to get managed dependencies from {pom_path}: {e}")
            
    return managed_deps


def get_pom_properties(pom_path):
    """Extracts all properties from the <properties> section of a pom.xml."""
    properties = {}
    if not os.path.exists(pom_path):
        return properties

    try:
        # We'll use a simple regex-based parser to avoid complex namespace issues with ET
        # and to handle property names that might not be valid XML tags if not careful
        with open(pom_path, 'r') as f:
            content = f.read()

        props_match = re.search(r'<properties>(.*?)</properties>', content, re.DOTALL)
        if props_match:
            props_content = props_match.group(1)
            # Find all tag pairs inside properties
            for match in re.finditer(r'<([^/ >]+)>([^<]*)</\1>', props_content):
                tag = match.group(1)
                value = match.group(2).strip()
                properties[tag] = value
    except Exception as e:
        print(f"Warning: Failed to get properties from {pom_path}: {e}")

    return properties


def parse_pom_for_version(file_path):
    """Extracts artifactId and version from a pom.xml file."""
    artifact_id = None
    version = None
    parent_version = None
    
    try:
        with open(file_path, 'r') as f:
            in_parent = False
            in_skipped_section = False
            # Sections to skip to avoid capturing artifactId/version from dependencies or plugins
            skip_tags = ['dependencies', 'dependencyManagement', 'plugins', 'build', 'reporting', 'profiles']
            
            for line in f:
                stripped = line.strip()
                if not stripped: continue
                
                # Check for skipped sections
                section_start = False
                for tag in skip_tags:
                    if f'<{tag}>' in stripped:
                        in_skipped_section = True
                        section_start = True
                        break
                if section_start: continue
                
                section_end = False
                for tag in skip_tags:
                    if f'</{tag}>' in stripped:
                        in_skipped_section = False
                        section_end = True
                        break
                if section_end: continue
                
                if in_skipped_section: continue
                
                if '<parent>' in stripped:
                    in_parent = True
                    continue
                if '</parent>' in stripped:
                    in_parent = False
                    continue
                    
                if '<artifactId>' in stripped and not artifact_id and not in_parent:
                    match = re.search(r'<artifactId>(.*?)</artifactId>', stripped)
                    if match:
                        artifact_id = match.group(1).strip()
                
                if '<version>' in stripped:
                    match = re.search(r'<version>(.*?)</version>', stripped)
                    if match:
                        v = match.group(1).strip()
                        if in_parent:
                            parent_version = v
                        elif not version:
                            version = v
                
                if artifact_id and version:
                    break
    except Exception as e:
        print(f"Warning: Could not parse {file_path}: {e}")
                
    return artifact_id, version or parent_version

def get_monorepo_versions(monorepo_root='.'):
    """Scans all pom.xml files in the monorepo to build a map of artifactId to version."""
    versions = {}
    for root, dirs, files in os.walk(monorepo_root):
        # Skip common directories to improve performance and avoid noise
        dirs[:] = [d for d in dirs if d not in ['samples', 'test', 'target', '.git', '.cloud', 'verification', 'test_data']]
        
        if 'pom.xml' in files:
            pom_path = os.path.join(root, 'pom.xml')
            artifactId, version = parse_pom_for_version(pom_path)
            if artifactId and version:
                versions[artifactId] = version
    return versions

def modernize_pom(file_path, parent_version, source_repo_name=None, parent_artifactId='google-cloud-jar-parent', relative_path='../google-cloud-jar-parent/pom.xml', monorepo_versions=None, parent_managed_deps=None, keep_parent=False):
    with open(file_path, 'r') as f:
        lines = f.readlines()

    new_lines = []
    
    # Pre-parse properties for resolution
    pom_properties = get_pom_properties(file_path)
    
    in_parent = False
    in_dep_mgmt = False
    in_dependencies = False
    in_dependency = False
    in_reporting = False
    in_plugins = False
    in_plugin = False
    in_configuration = False
    in_ignored_deps = False
    current_plugin_artifactId = None
    has_javax_annotation = False
    ignored_deps_lines = []
    current_dependency_lines = []
    should_preserve = False
    current_group_id = None
    has_version = False

    for line in lines:
        # URL Modernization
        if any(tag in line for tag in ['<url>', '<connection>', '<developerConnection>']):
            if 'github.com' in line and 'googleapis/' in line:
                if source_repo_name:
                    repo_pattern = re.escape(source_repo_name)
                else:
                    repo_pattern = r'[a-zA-Z0-9-]+'

                # Replace HTTPS URLs
                line = re.sub(
                    r'https://github\.com/googleapis/' + repo_pattern,
                    'https://github.com/googleapis/google-cloud-java',
                    line
                )
                # Replace Git SSH URLs
                line = re.sub(
                    r'git@github\.com:googleapis/' + repo_pattern + r'(\.git)?',
                    'git@github.com:googleapis/google-cloud-java.git',
                    line
                )
                # Handle scm:git: prefix if it has https
                line = re.sub(
                    r'scm:git:https://github\.com/googleapis/' + repo_pattern,
                    'scm:git:https://github.com/googleapis/google-cloud-java.git',
                    line
                )

        # Profile renaming
        if '<id>customNative</id>' in line:
            line = line.replace('<id>customNative</id>', '<id>native</id>')

        # Parent section modernization
        if not keep_parent:
            if '<parent>' in line and not in_parent:
                in_parent = True
                indent = line[:line.find('<')]
                new_lines.append(f"{indent}<parent>\n")
                new_lines.append(f"{indent}  <groupId>com.google.cloud</groupId>\n")
                new_lines.append(f"{indent}  <artifactId>{parent_artifactId}</artifactId>\n")
                new_lines.append(f"{indent}  <version>{parent_version}</version><!-- {{x-version-update:google-cloud-java:current}} -->\n")
                new_lines.append(f"{indent}  <relativePath>{relative_path}</relativePath>\n")
                continue
            if '</parent>' in line and in_parent:
                in_parent = False
                new_lines.append(line)
                continue
            if in_parent:
                continue # skip original parent content

        # Dependency Management pruning
        if '<dependencyManagement>' in line:
            in_dep_mgmt = True
            new_lines.append(line)
            continue
        if '</dependencyManagement>' in line:
            in_dep_mgmt = False
            new_lines.append(line)
            continue

        # if in_dep_mgmt:
        if '<dependencies>' in line:
            in_dependencies = True
            new_lines.append(line)
            continue
        if '</dependencies>' in line:
            in_dependencies = False
            new_lines.append(line)
            continue

        if in_dependencies:
            if '<dependency>' in line:
                in_dependency = True
                current_dependency_lines = [line]
                should_preserve = False
                current_group_id = None
                current_artifact_id = None
                has_version = False
                extracted_dep = None
                continue
            if '</dependency>' in line:
                in_dependency = False
                
                if extracted_dep:
                    # Remove version tag from current_dependency_lines if it was extracted
                    # We do this before further checks
                    current_dependency_lines = [l for l in current_dependency_lines if '<version>' not in l]
                    has_version = False # It's now managed
                    should_preserve = True # We want to keep the dependency entry
                # Monorepo version alignment and annotation
                if monorepo_versions and current_artifact_id and current_artifact_id in monorepo_versions:
                    new_version = monorepo_versions[current_artifact_id]
                    marker_artifact = current_artifact_id.replace('-bom', '')
                    annotation = f"<!-- {{x-version-update:{marker_artifact}:current}} -->"
                    version_line_content = f"<version>{new_version}</version>{annotation}\n"
                    
                    if has_version:
                        # Replace existing version line
                        for i, d_line in enumerate(current_dependency_lines):
                            if '<version>' in d_line:
                                indent = d_line[:d_line.find('<')]
                                current_dependency_lines[i] = f"{indent}{version_line_content}"
                                break
                    else:
                        # Add missing version line before </dependency>
                        indent = "      " # Default indent
                        if len(current_dependency_lines) > 0:
                            first_line = current_dependency_lines[0]
                            indent = first_line[:first_line.find('<')] + "  "
                        current_dependency_lines.append(f"{indent}{version_line_content}")
                    
                    should_preserve = True

                current_dependency_lines.append(line)

                if current_artifact_id == 'google-cloud-shared-dependencies':
                    continue

                # Prune if already managed by parent mit same version
                if in_dep_mgmt and parent_managed_deps and (current_group_id, current_artifact_id) in parent_managed_deps:
                    managed_version = parent_managed_deps[(current_group_id, current_artifact_id)]
                    
                    # Extract current version to compare
                    current_version = None
                    for d_line in current_dependency_lines:
                        v_match = re.search(r'<version>(.*?)</version>', d_line)
                        if v_match:
                            current_version = v_match.group(1).strip()
                            break
                    
                    if current_version == managed_version:
                        continue


                # Preservation logic:
                # 1. Has x-version-update comment
                # 2. Is NOT com.google group AND has a version tag
                # 3. Is com.google.cloud group AND artifactId starts with google-cloud- AND has a version tag
                is_external = current_group_id and not current_group_id.startswith('com.google')
                is_google_cloud_lib = current_group_id == 'com.google.cloud' and current_artifact_id and current_artifact_id.startswith('google-cloud-')
                
                # Skip gapic-libraries-bom in dependencyManagement
                if in_dep_mgmt and current_artifact_id == 'gapic-libraries-bom':
                    continue

                # Skip boms for artifacts managed in the monorepo as their individual versions will be updated via x-version-update
                if in_dep_mgmt and current_artifact_id.endswith('-bom') and current_artifact_id in monorepo_versions:
                    continue

                if not in_dep_mgmt or should_preserve or (is_external and has_version) or (is_google_cloud_lib and has_version):
                    new_lines.extend(current_dependency_lines)
                continue

            if in_dependency:
                if '<groupId>' in line:
                    match = re.search(r'<groupId>(.*?)</groupId>', line)
                    if match:
                        current_group_id = match.group(1).strip()
                if '<artifactId>' in line:
                    match = re.search(r'<artifactId>(.*?)</artifactId>', line)
                    if match:
                        current_artifact_id = match.group(1).strip()
                if '<version>' in line:
                    has_version = True
                    match = re.search(r'<version>(.*?)</version>', line)
                    if match:
                        current_version = match.group(1).strip()
                        
                        # Resolve version if it's a property
                        resolved_version = current_version
                        if current_version.startswith("${") and current_version.endswith("}"):
                            prop_name = current_version[2:-1]
                            if prop_name in pom_properties:
                                resolved_version = pom_properties[prop_name]

                        if current_artifact_id and current_artifact_id.startswith('google-api-services-'):
                            if not parent_managed_deps or (current_group_id, current_artifact_id) not in parent_managed_deps:
                                # Only extract if not already managed
                                extracted_dep = (current_group_id, current_artifact_id, resolved_version)
                                print(f"EXTRACT_DEP:{current_group_id}:{current_artifact_id}:{resolved_version}")
                            else:
                                # Even if already managed, we should remove the local version
                                extracted_dep = (current_group_id, current_artifact_id, resolved_version)

                # if current_artifact_id and current_artifact_id.startswith('google-api-services-'):
                #     should_preserve = True
                
                current_dependency_lines.append(line)
                if '{x-version-update:' in line:
                    should_preserve = True
                continue

            # Prune comments and extra whitespace in depMgmt for a cleaner result
            if not line.strip():
                new_lines.append(line)
            continue

        # Plugin management (for maven-dependency-plugin configuration)
        if '<plugins>' in line:
            in_plugins = True
        if '</plugins>' in line:
            in_plugins = False

        if in_plugins:
            if '<plugin>' in line:
                in_plugin = True
                current_plugin_artifactId = None
                has_javax_annotation = False
            if '</plugin>' in line:
                in_plugin = False
            
            if in_plugin:
                if '<artifactId>' in line and not in_configuration:
                     match = re.search(r'<artifactId>(.*?)</artifactId>', line)
                     if match:
                         current_plugin_artifactId = match.group(1).strip()
                
                if current_plugin_artifactId == 'maven-dependency-plugin':
                    if '<configuration>' in line:
                        in_configuration = True
                    if '</configuration>' in line:
                        in_configuration = False
                    
                    if in_configuration:
                        if '<ignoredUnusedDeclaredDependencies>' in line:
                            in_ignored_deps = True
                            ignored_deps_lines = [line]
                            continue
                        
                        if in_ignored_deps:
                            if 'javax.annotation:javax.annotation-api' in line:
                                has_javax_annotation = True
                            
                            if '</ignoredUnusedDeclaredDependencies>' in line:
                                if not has_javax_annotation:
                                    # Try to find a good indentation
                                    indent = "            " # Default
                                    if len(ignored_deps_lines) > 1:
                                        last_line = ignored_deps_lines[-1]
                                        match = re.search(r'^(\s+)', last_line)
                                        if match:
                                            indent = match.group(1)
                                    elif len(ignored_deps_lines) == 1:
                                        # Only the start tag
                                        match = re.search(r'^(\s+)', ignored_deps_lines[0])
                                        if match:
                                            indent = match.group(1) + "  "
                                    
                                    ignored_deps_lines.append(f"{indent}<ignoredUnusedDeclaredDependency>javax.annotation:javax.annotation-api</ignoredUnusedDeclaredDependency>\n")
                                
                                new_lines.extend(ignored_deps_lines)
                                new_lines.append(line)
                                in_ignored_deps = False
                                continue
                            else:
                                ignored_deps_lines.append(line)
                                continue

        # Reporting section removal
        if '<reporting>' in line:
            in_reporting = True
            continue
        if '</reporting>' in line:
            in_reporting = False
            continue
        if in_reporting:
            continue

        new_lines.append(line)

    with open(file_path, 'w') as f:
        # Clean up double empty lines potentially introduced by pruning
        content = "".join(new_lines)
        content = re.sub(r'\n\s*\n\s*\n', '\n\n', content)
        f.write(content)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Modernize a pom.xml file for the monorepo.")
    parser.add_argument("file_path", help="Path to the pom.xml file to modernize.")
    parser.add_argument("parent_version", help="Version of the parent POM.")
    parser.add_argument("--source-repo", help="Name of the source repository (e.g., java-logging).")
    parser.add_argument("--parent-artifactId", default="google-cloud-jar-parent", help="Artifact ID of the parent POM.")
    parser.add_argument("--relative-path", default="../google-cloud-jar-parent/pom.xml", help="Relative path to the parent POM.")
    parser.add_argument("--keep-parent", action="store_true", help="Keep the existing parent section.")

    args = parser.parse_args()

    # Monorepo root is likely the parent of the directory containing this script
    script_dir = os.path.dirname(os.path.abspath(__file__))
    monorepo_root = os.path.dirname(script_dir)
    
    print(f"Scanning monorepo at {monorepo_root} for versions...")
    monorepo_versions = get_monorepo_versions(monorepo_root)
    print(f"Found {len(monorepo_versions)} artifacts.")
    
    parent_pom_path = os.path.join(monorepo_root, 'google-cloud-jar-parent', 'pom.xml')
    parent_managed_deps = get_managed_dependencies(parent_pom_path)
    print(f"Loaded {len(parent_managed_deps)} managed dependencies from parent.")

    modernize_pom(
        args.file_path,
        args.parent_version,
        args.source_repo,
        args.parent_artifactId,
        args.relative_path,
        monorepo_versions,
        parent_managed_deps,
        args.keep_parent
    )


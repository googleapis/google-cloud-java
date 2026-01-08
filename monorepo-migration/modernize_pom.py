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

import sys
import re

def modernize_pom(file_path, parent_version):
    with open(file_path, 'r') as f:
        lines = f.readlines()

    new_lines = []
    in_parent = False
    in_dep_mgmt = False
    in_dependencies = False
    in_dependency = False
    in_reporting = False
    current_dependency_lines = []
    has_x_version_update = False

    for line in lines:
        # Parent section modernization
        if '<parent>' in line and not in_parent:
            in_parent = True
            indent = line[:line.find('<')]
            new_lines.append(f"{indent}<parent>\n")
            new_lines.append(f"{indent}  <groupId>com.google.cloud</groupId>\n")
            new_lines.append(f"{indent}  <artifactId>google-cloud-jar-parent</artifactId>\n")
            new_lines.append(f"{indent}  <version>{parent_version}</version><!-- {{x-version-update:google-cloud-java:current}} -->\n")
            new_lines.append(f"{indent}  <relativePath>../google-cloud-jar-parent/pom.xml</relativePath>\n")
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
        
        if in_dep_mgmt:
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
                    has_x_version_update = False
                    continue
                if '</dependency>' in line:
                    in_dependency = False
                    current_dependency_lines.append(line)
                    if has_x_version_update:
                        new_lines.extend(current_dependency_lines)
                    continue
                
                if in_dependency:
                    current_dependency_lines.append(line)
                    if '{x-version-update:' in line:
                        has_x_version_update = True
                    continue
                
                # Prune comments and extra whitespace in depMgmt for a cleaner result
                if not line.strip():
                    new_lines.append(line)
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
    if len(sys.argv) > 2:
        modernize_pom(sys.argv[1], sys.argv[2])
    else:
        print("Usage: python3 modernize_pom.py <file_path> <parent_version>")
        sys.exit(1)

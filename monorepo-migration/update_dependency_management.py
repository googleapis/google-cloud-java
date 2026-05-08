#!/usr/bin/env python3
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
import os
import re

def update_dependency_management(pom_path, group_id, artifact_id, version):
    with open(pom_path, 'r') as f:
        content = f.read()

    # Find <dependencyManagement>
    dm_match = re.search(r'<dependencyManagement>.*?</dependencyManagement>', content, re.DOTALL)
    if not dm_match:
        print(f"Error: <dependencyManagement> section not found in {pom_path}")
        sys.exit(1)

    dm_content = dm_match.group(0)
    
    # Find <dependencies> inside <dependencyManagement>
    deps_match = re.search(r'<dependencies>(.*?)</dependencies>', dm_content, re.DOTALL)
    if not deps_match:
        print(f"Error: <dependencies> section not found inside <dependencyManagement> in {pom_path}")
        sys.exit(1)

    inner_deps_content = deps_match.group(1)
    
    # Check if dependency already exists
    dep_pattern = fr'<artifactId>{re.escape(artifact_id)}</artifactId>'
    if dep_pattern in inner_deps_content:
        # Check if version matches
        if fr'<version>{re.escape(version)}</version>' in inner_deps_content:
            print(f"Dependency {group_id}:{artifact_id}:{version} already exists in {pom_path}")
            return
        else:
            # Update version? Requirement says "move it", but if it exists with different version, maybe we should update it?
            # For now, let's just append if it's not EXACTLY same. 
            # Actually, usually there should be only one.
            # Let's replace if artifactId matches but version is different.
            
            new_inner_deps = re.sub(
                fr'(<dependency>\s*<groupId>{re.escape(group_id)}</groupId>\s*<artifactId>{re.escape(artifact_id)}</artifactId>\s*<version>).*?(</version>.*?</dependency>)',
                fr'\g<1>{version}\g<2>',
                inner_deps_content,
                flags=re.DOTALL
            )
            if new_inner_deps != inner_deps_content:
                print(f"Updated {group_id}:{artifact_id} to version {version} in {pom_path}")
                new_dm_content = dm_content.replace(inner_deps_content, new_inner_deps)
                new_content = content.replace(dm_content, new_dm_content)
                with open(pom_path, 'w') as f:
                    f.write(new_content)
                return

    # If not found or not updated, append it
    new_dep = f"""      <dependency>
        <groupId>{group_id}</groupId>
        <artifactId>{artifact_id}</artifactId>
        <version>{version}</version>
      </dependency>
"""
    # Find the last </dependency> and insert after it, or just before </dependencies>
    last_dep_end = inner_deps_content.rfind('</dependency>')
    if last_dep_end != -1:
        # Check if there is anything after last </dependency> that is not just whitespace
        insert_pos = last_dep_end + len('</dependency>')
        # Ensure we insert before </dependencies>
        new_inner_deps = inner_deps_content[:insert_pos] + "\n" + new_dep + inner_deps_content[insert_pos:]
    else:
        # No dependencies found, just insert at beginning
        new_inner_deps = "\n" + new_dep + inner_deps_content

    new_dm_content = dm_content.replace(inner_deps_content, new_inner_deps)
    new_content = content.replace(dm_content, new_dm_content)
    
    with open(pom_path, 'w') as f:
        f.write(new_content)
    print(f"Added {group_id}:{artifact_id}:{version} to {pom_path}")

if __name__ == "__main__":
    if len(sys.argv) != 5:
        print("Usage: update_dependency_management.py <pom_path> <groupId> <artifactId> <version>")
        sys.exit(1)
    update_dependency_management(sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4])

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

def update_root_pom(pom_path, module_name):
    new_module = f'    <module>{module_name}</module>\n'
    with open(pom_path, 'r') as f:
        content = f.read()

    start_tag = '<modules>'
    end_tag = '</modules>'
    start_idx = content.find(start_tag)
    end_idx = content.find(end_tag)

    if start_idx == -1 or end_idx == -1:
        print(f"Error: {start_tag} or {end_tag} not found in {pom_path}")
        sys.exit(1)

    modules_section = content[start_idx + len(start_tag):end_idx]
    lines = [l for l in modules_section.splitlines(keepends=True) if l.strip()]

    java_indices = [i for i, l in enumerate(lines) if '<module>java-' in l]
    if java_indices:
        start_java = java_indices[0]
        end_java = java_indices[-1] + 1
        java_lines = lines[start_java:end_java]
        if not any(f'<module>{module_name}</module>' in l for l in java_lines):
            java_lines.append(new_module)
            java_lines.sort()
            lines = lines[:start_java] + java_lines + lines[end_java:]
    else:
        if not any(f'<module>{module_name}</module>' in l for l in lines):
            lines.append(new_module)

    new_content = content[:start_idx + len(start_tag)] + '\n' + ''.join(lines) + '  ' + content[end_idx:]
    with open(pom_path, 'w') as f:
        f.write(new_content)

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: update_root_pom.py <pom_path> <module_name>")
        sys.exit(1)
    update_root_pom(sys.argv[1], sys.argv[2])

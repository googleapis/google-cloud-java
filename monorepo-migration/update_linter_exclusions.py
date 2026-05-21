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

def update_linter(file_path, lib_name):
    with open(file_path, 'r') as f:
        content = f.read()
    
    target = '      [[ "${pomFile}" =~ .*java-vertexai.* ]] || \\'
    replacement = f'      [[ "${{pomFile}}" =~ .*{lib_name}.* ]] || \\\n{target}'
    
    if target in content:
        content = content.replace(target, replacement)
        with open(file_path, 'w') as f:
            f.write(content)
        print(f"Successfully added {lib_name} to linter exclusions.")
    else:
        print(f"Target not found in {file_path}")

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print(f"Usage: {sys.argv[0]} file_path lib_name")
        sys.exit(1)
    update_linter(sys.argv[1], sys.argv[2])

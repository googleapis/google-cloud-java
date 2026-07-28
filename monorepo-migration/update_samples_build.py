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
import re

def main():
    if len(sys.argv) < 3:
        print("Usage: update_samples_build.py <path_to_yaml> <library_name>")
        sys.exit(1)
        
    file_path = sys.argv[1]
    library_name = sys.argv[2]
    
    with open(file_path, 'r') as f:
        content = f.read()
        
    if 'BUILD_SUBDIR=' in content:
        print(f"BUILD_SUBDIR already present in {file_path}. Skipping.")
        sys.exit(0)
        
    # Find the 'env:' line and insert 'BUILD_SUBDIR' after it
    lines = content.splitlines()
    new_lines = []
    modified = False
    
    for line in lines:
        new_lines.append(line)
        match = re.match(r'^(\s*)env:\s*$', line)
        if match and not modified:
            indent = match.group(1)
            # Insert BUILD_SUBDIR under env:
            new_lines.append(f"{indent}- 'BUILD_SUBDIR={library_name}'")
            modified = True
            
    if modified:
        with open(file_path, 'w') as f:
            f.write('\n'.join(new_lines) + '\n')
        print(f"Successfully added BUILD_SUBDIR={library_name} to {file_path}")
    else:
        print(f"Warning: Could not find 'env:' block in {file_path}")

if __name__ == '__main__':
    main()

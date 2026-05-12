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

def update_ci_filters(ci_yaml, lib_name):
    with open(ci_yaml, 'r') as f:
        content = f.read()
        
    # match `!(...)` pattern in ci.yaml
    pattern = r'!\(([^)]+)\)'
    
    def repl(match):
        modules = match.group(1).split('|')
        if lib_name not in modules:
            modules.append(lib_name)
            modules.sort()
        return '!(' + '|'.join(modules) + ')'
        
    new_content = re.sub(pattern, repl, content)
    with open(ci_yaml, 'w') as f:
        f.write(new_content)
    print(f"Successfully added {lib_name} to CI exclusions in {ci_yaml}.")

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print(f"Usage: {sys.argv[0]} <ci_yaml> <lib_name>")
        sys.exit(1)
    update_ci_filters(sys.argv[1], sys.argv[2])

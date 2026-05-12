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

def update_changes_filters(ci_yaml, lib_name):
    with open(ci_yaml, 'r') as f:
        content = f.read()
        
    target = '  split-units:'
    new_filter = f'''          {lib_name}:
            - '{lib_name}/**'
            - 'google-auth-library-java/**/*.java'
            - 'google-auth-library-java/**/pom.xml'
            - 'sdk-platform-java/**/*.java'
            - 'sdk-platform-java/java-shared-dependencies/**/pom.xml'
            - 'sdk-platform-java/gapic-generator-java-pom-parent/pom.xml'
'''
    if new_filter not in content:
        content = content.replace(target, new_filter + target)
        with open(ci_yaml, 'w') as f:
            f.write(content)
        print(f"Successfully added {lib_name} to changes job in {ci_yaml}.")
    else:
        print(f"{lib_name} is already configured in {ci_yaml}.")

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print(f"Usage: {sys.argv[0]} <ci_yaml> <lib_name>")
        sys.exit(1)
    update_changes_filters(sys.argv[1], sys.argv[2])

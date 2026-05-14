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
import yaml

def update_config(target_path, source_path):
    """
    Appends the library configuration from the source_path to the target_path.
    This avoids rewriting the entire target YAML, preserving all comments and ordering.
    """
    with open(source_path, 'r') as f:
        source_data = yaml.safe_load(f) or {}

    source_libs = source_data.get('libraries', [])
    if not source_libs:
        print("No libraries found in source config.")
        return

    # In standalone repos, there is usually only one library definition.
    new_libs = []
    for s_lib in source_libs:
        # Clean up source library (remove repo fields as they are now internal to monorepo)
        if 'repo' in s_lib:
            del s_lib['repo']
        if 'repo_short' in s_lib:
            del s_lib['repo_short']
        new_libs.append(s_lib)

    # Dump the new library entries as a YAML string
    # sort_keys=False preserves the field ordering (e.g., api_shortname first)
    new_yaml_str = yaml.dump(new_libs, sort_keys=False, default_flow_style=False, indent=2)

    # Append to the existing monorepo generation_config.yaml
    # This ensures we don't rewrite the file and lose comments/ordering.
    with open(target_path, 'a') as f:
        f.write(new_yaml_str.rstrip() + "\n")

    print(f"Appended {len(new_libs)} libraries to {target_path}")

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python3 update_generation_config.py <target_config> <source_config>")
        sys.exit(1)
    
    target_path = sys.argv[1]
    source_path = sys.argv[2]
    update_config(target_path, source_path)

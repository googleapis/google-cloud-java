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

import argparse
import os

def update_ci_filters(ci_yaml, repo_name):
    if not os.path.exists(ci_yaml):
        print(f"Error: {ci_yaml} does not exist.")
        return

    with open(ci_yaml, "r") as f:
        lines = f.readlines()

    final_lines = []
    in_filters = False
    filter_lines = []
    new_filter = f"          {repo_name}: {repo_name}/**\n"

    for line in lines:
        if "filters: |" in line:
            final_lines.append(line)
            in_filters = True
            continue
        
        if in_filters:
            # End of filter block is an empty line or line with less indentation
            if line.strip() == "" or not line.startswith("          "):
                if not any(f"          {repo_name}:" in l for l in filter_lines):
                    filter_lines.append(new_filter)
                filter_lines.sort()
                final_lines.extend(filter_lines)
                final_lines.append(line)
                in_filters = False
            else:
                filter_lines.append(line)
        else:
            final_lines.append(line)

    if in_filters:
        if not any(f"          {repo_name}:" in l for l in filter_lines):
            filter_lines.append(new_filter)
        filter_lines.sort()
        final_lines.extend(filter_lines)

    with open(ci_yaml, "w") as f:
        f.writelines(final_lines)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Update central ci.yaml filters.")
    parser.add_argument("ci_yaml", help="Path to the ci.yaml file.")
    parser.add_argument("repo_name", help="Name of the repository to add to filters.")
    args = parser.parse_args()
    
    update_ci_filters(args.ci_yaml, args.repo_name)

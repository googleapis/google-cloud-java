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
import re

def update_config(target_path, source_path, prefix):
    """
    Reads source_path, prepends prefix to paths in deep-remove-regex and deep-preserve-regex,
    and writes to target_path.
    """
    with open(source_path, 'r') as f:
        source_content = f.read()

    # Load source data
    source_data = yaml.safe_load(source_content) or {}

    # Define fields to update
    fields_to_update = ['deep-remove-regex', 'deep-preserve-regex']

    for field in fields_to_update:
        if field in source_data:
            updated_list = []
            for item in source_data[field]:
                # If item is a string, prepend prefix
                # Regex might need handling if it starts with ^
                # But usually these are just paths.
                # Assuming simple concatenation for now as per requirement.
                # "When referencing paths in the deep-remove-regex and deep-preserve-regex, the new directory name should be prefixed"
                
                # If the regex starts with ^, insert the prefix after it.
                if item.startswith('^'):
                    updated_list.append(f"^{prefix}/{item[1:]}")
                else:
                    updated_list.append(f"/{prefix}{item}")
            source_data[field] = updated_list

    if 'deep-copy-regex' in source_data:
        for item in source_data['deep-copy-regex']:
            if 'dest' in item and item['dest'].startswith('/owl-bot-staging/'):
                item['dest'] = item['dest'].replace('/owl-bot-staging/', f'/owl-bot-staging/{prefix}/', 1)

    # Write to target_path
    with open(target_path, 'w') as f:
        # Check if there was a license header in the original file
        # Match a block of lines starting with # at the beginning of the file
        header_match = re.search(r'^((?:#[^\n]*\n)+)', source_content)
        if header_match:
            f.write(header_match.group(1))
            f.write("\n") # Add a newline after the header
        
        # Use yaml.dump to write the data.
        yaml.dump(source_data, f, sort_keys=False, default_flow_style=False, indent=2)

if __name__ == "__main__":
    if len(sys.argv) != 4:
        print("Usage: python3 update_owlbot_hermetic.py <target_file> <source_file> <prefix>")
        sys.exit(1)
    
    target_path = sys.argv[1]
    source_path = sys.argv[2]
    prefix = sys.argv[3]
    
    update_config(target_path, source_path, prefix)

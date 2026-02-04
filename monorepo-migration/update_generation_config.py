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

def get_library_id(lib):
    """
    Returns a unique identifier for a library.
    Prefer 'library_name', then 'api_shortname'.
    """
    if 'library_name' in lib:
        return f"java-{lib['library_name']}"
    if 'api_shortname' in lib:
        return f"java-{lib['api_shortname']}"
    return "unknown"

def merge_libraries(target_libs, source_libs):
    """
    Merges source_libs into target_libs.
    Libraries are matched by get_library_id.
    GAPICs are merged and deduplicated by proto_path.
    The final list is sorted by library_id.
    """
    # Map from library_id to library dict
    target_map = {get_library_id(lib): lib for lib in target_libs}

    for s_lib in source_libs:
        lib_id = get_library_id(s_lib)
        
        # Clean up source library (remove repo fields)
        s_lib_cleaned = {k: v for k, v in s_lib.items() if k not in ('repo', 'repo_short')}
        
        if lib_id in target_map:
            t_lib = target_map[lib_id]
            # Merge GAPICs
            t_gapics_list = t_lib.get('GAPICs', [])
            s_gapics_list = s_lib_cleaned.get('GAPICs', [])
            
            # Map by proto_path for deduplication
            proto_map = {g['proto_path']: g for g in t_gapics_list}
            for g in s_gapics_list:
                proto_map[g['proto_path']] = g
            
            # Sort GAPICs by proto_path
            sorted_protos = sorted(proto_map.keys())
            t_lib['GAPICs'] = [proto_map[p] for p in sorted_protos]
            
            # Update other fields from source
            for k, v in s_lib_cleaned.items():
                if k != 'GAPICs':
                    t_lib[k] = v
        else:
            target_map[lib_id] = s_lib_cleaned

    # Return sorted list of libraries
    sorted_ids = sorted(target_map.keys())
    return [target_map[lib_id] for lib_id in sorted_ids]

def update_config(target_path, source_path):
    with open(target_path, 'r') as f:
        target_content = f.read()
    
    with open(source_path, 'r') as f:
        source_data = yaml.safe_load(f) or {}

    # Load target data
    target_data = yaml.safe_load(target_content) or {}
    
    target_libs = target_data.get('libraries', [])
    source_libs = source_data.get('libraries', [])
    
    merged_libs = merge_libraries(target_libs, source_libs)
    target_data['libraries'] = merged_libs

    # Write back
    with open(target_path, 'w') as f:
        # Check if there was a license header in the original file
        header_match = re.search(r'^(#.*?\n\n)', target_content, re.DOTALL)
        if header_match:
            f.write(header_match.group(1))
        
        # Use yaml.dump to write the data.
        # sort_keys=False to preserve order of fields within libraries if possible (YAML 1.2+ usually does, but pyyaml depends)
        yaml.dump(target_data, f, sort_keys=False, default_flow_style=False, indent=2)

if __name__ == "__main__":
    if len(sys.argv) != 3:
        print("Usage: python3 update_generation_config.py <target_config> <source_config>")
        sys.exit(1)
    
    target_path = sys.argv[1]
    source_path = sys.argv[2]
    update_config(target_path, source_path)

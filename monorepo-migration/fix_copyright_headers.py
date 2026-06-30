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

import os
import re
import sys

def fix_copyright(path):
    if os.path.isfile(path):
        if path.endswith(".java"):
            _fix_file(path)
    elif os.path.isdir(path):
        for root, _, files in os.walk(path):
            for file in files:
                if file.endswith(".java"):
                    _fix_file(os.path.join(root, file))

def _fix_file(file_path):
    with open(file_path, 'r') as f:
        content = f.read()
    
    # Replace "Copyright [Year] Google LLC" or "Copyright [Year] Google Inc."
    # with "Copyright 2026 Google LLC"
    new_content = re.sub(
        r'Copyright \d{4} Google (Inc\.|LLC)',
        'Copyright 2026 Google LLC',
        content
    )
    
    if new_content != content:
        with open(file_path, 'w') as f:
            f.write(new_content)
        print(f"Updated copyright in {file_path}")

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: fix_copyright_headers.py <file_or_directory_path> ...")
        sys.exit(1)
    
    for arg in sys.argv[1:]:
        fix_copyright(arg)

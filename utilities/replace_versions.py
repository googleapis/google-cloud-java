# Copyright 2018 Google LLC
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

# Use case: Update all the versions in README.md and pom.xml files based on
# the versions in versions.txt
#
#    python utilities/replace_versions.py
#
# Use case: Update the versions in a particular file
#
#    python utilities/replace_versions.py my-file
#
# The script must be run at the root of google-cloud-java.

import argparse
import os
import re

version_update_marker = re.compile(r'\{x-version-update:([^:]+):([^}]+)\}')
version_update_start_marker = re.compile(r'\{x-version-update-start:([^:]+):([^}]+)\}')
version_update_end_marker = re.compile(r'\{x-version-update-end\}')
version_regex_str = r'\d+\.\d+\.\d+(?:-\w+)?(?:-\w+)?'
version_regex = re.compile(version_regex_str)

class CodeModule:
    def __init__(self, module_str):
        (name, released, current) = module_str.split(':')
        self.name = name
        self.released = released
        self.current = current.strip()

def replace_versions(version_map, target):
    newlines = []
    repl_open, repl_thisline = False, False
    with open(target) as f:
        for line in f:
            repl_thisline = repl_open
            match = version_update_marker.search(line)
            if match:
                module_name, version_type = match.group(1), match.group(2)
                repl_thisline = True
            else:
                match = version_update_start_marker.search(line)
                if match:
                    module_name, version_type = match.group(1), match.group(2)
                    repl_open, repl_thisline = True, True
                else:
                    match = version_update_end_marker.search(line)
                    if match:
                        repl_open, repl_thisline = False, False

            if repl_thisline:
                if module_name not in version_map:
                    raise ValueError('module not found in version.txt: {}'.format(module_name))
                module = version_map[module_name]
                new_version = ''
                if version_type == 'current':
                    new_version = module.current
                elif version_type == 'released':
                    new_version = module.released
                else:
                    raise ValueError('invalid version type: {}'.format(version_type))

                newline = re.sub(version_regex_str, new_version, line)
                newlines.append(newline)
            else:
                newlines.append(line)

            if not repl_open:
                module_name, version_type = '', ''

    with open(target, 'w') as f:
        for line in newlines:
            f.write(line)

def replace_versions_all(target):
    version_map = {}
    with open('versions.txt') as f:
        for line in f:
            version_line = line.strip()
            if not version_line or version_line.startswith('#'):
                continue
            module = CodeModule(version_line)
            version_map[module.name] = module

    if target:
        replace_versions(version_map, target)
    else:
        for root, _, files in os.walk("."):
            for file_name in files:
                file_path = root + os.sep + file_name
                if file_name == 'README.md' or file_name == 'pom.xml':
                    replace_versions(version_map, file_path)

def main():
    parser = argparse.ArgumentParser(description='Replace version numbers in poms and READMEs.')
    parser.add_argument('target', nargs='?', help='File to update - all files scanned if omitted')
    args = parser.parse_args()

    replace_versions_all(args.target)

if __name__ == '__main__':
    main()

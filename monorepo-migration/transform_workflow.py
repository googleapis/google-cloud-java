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

def transform(content, lib_name):
    lines = content.splitlines()
    new_lines = []
    inserted_defaults = False
    
    filter_job = f"""  filter:
    runs-on: ubuntu-latest
    outputs:
      library: ${{{{ steps.filter.outputs.library }}}}
    steps:
    - uses: actions/checkout@v4
    - uses: dorny/paths-filter@v3
      id: filter
      with:
        filters: |
          library:
            - '{lib_name}/**'"""

    in_jobs = False
    skip_current_job = False
    current_job_is_windows = False
    
    for line in lines:
        if line.startswith('name:') and not in_jobs:
            name_match = re.match(r'^name:\s*(.*)', line)
            if name_match:
                orig_name = name_match.group(1).strip()
                # Remove quotes if they exist
                orig_name = orig_name.strip("\"'")
                new_lines.append(f"name: {lib_name} {orig_name}")
                continue

        if line.startswith('jobs:'):
            if not inserted_defaults:
                new_lines.append("env:")
                new_lines.append(f"  BUILD_SUBDIR: {lib_name}")
                inserted_defaults = True
            new_lines.append(line)
            new_lines.append(filter_job)
            in_jobs = True
            continue
            
        if in_jobs and line.startswith('  ') and not line.startswith('    ') and line.strip() and not line.strip().startswith('#'):
            job_match = re.match(r'^  ([\w-]+):', line)
            if job_match:
                job_name = job_match.group(1)
                current_job_is_windows = False # Reset for new job
                if job_name == 'clirr':
                    skip_current_job = True
                    continue
                else:
                    skip_current_job = False
                
                if job_name != 'filter':
                    new_lines.append(line)
                    new_lines.append("    needs: filter")
                    new_lines.append(f"    if: ${{{{ needs.filter.outputs.library == 'true' }}}}")
                    continue
        
        if not skip_current_job:
            if 'runs-on:' in line and 'windows' in line:
                current_job_is_windows = True
            
            if line.strip() == 'steps:' and current_job_is_windows:
                new_lines.append(line)
                new_lines.append("    - name: Support longpaths")
                new_lines.append("      run: git config --system core.longpaths true")
                continue

            if 'run: echo "SUREFIRE_JVM_OPT=' in line and '!java17' not in line:
                line = line.replace('" >> $GITHUB_ENV', ' -P !java17" >> $GITHUB_ENV')
            if 'build.bat' in line:
                line = line.replace('build.bat', 'build.sh')

            new_lines.append(line)
    return "\n".join(new_lines)

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 transform_workflow.py <library_name>")
        sys.exit(1)
    lib = sys.argv[1]
    print(transform(sys.stdin.read(), lib))

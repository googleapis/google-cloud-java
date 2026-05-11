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

    clirr_template = f"""  clirr:
    needs: filter
    if: ${{{{ needs.filter.outputs.library == 'true' }}}}
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v4
    - uses: actions/setup-java@v4
      with:
        distribution: temurin
        java-version: 11
    - run: java -version
    - run: .kokoro/build.sh
      env:
        JOB_TYPE: clirr
        BUILD_SUBDIR: {lib_name}"""

    in_jobs = False
    skip_current_job = False
    current_job_is_windows = False
    current_job_is_lint = False
    
    skip_lines_count = 0
    
    for line in lines:
        if skip_lines_count > 0:
            skip_lines_count -= 1
            continue

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
                current_job_is_lint = (job_name == 'lint')
                skip_current_job = False
                if job_name == 'clirr':
                    skip_current_job = True
                    new_lines.extend(clirr_template.splitlines())
                    continue
                
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

            if 'name: Support longpaths' in line and current_job_is_windows:
                skip_lines_count = 1
                continue

            if '- uses: actions/checkout' in line and current_job_is_lint:
                new_lines.append("    - uses: actions/checkout@v4")
                new_lines.append("      with:")
                new_lines.append("        fetch-depth: 0")
                continue

            if 'JOB_TYPE: lint' in line and current_job_is_lint:
                new_lines.append(line)
                new_lines.append("        HEAD_SHA: ${{ github.event.pull_request.head.sha }}")
                new_lines.append("        BASE_SHA: ${{ github.event.pull_request.base.sha }}")
                continue

            if 'run: echo "SUREFIRE_JVM_OPT=' in line and '!java17' not in line:
                line = line.replace('" >> $GITHUB_ENV', ' -P !java17" >> $GITHUB_ENV')
            if 'build.bat' in line:
                line = line.replace('build.bat', 'build.sh')
            if '.kokoro/conformance.sh' in line:
                short_name = lib_name.replace('java-', '')
                line = line.replace('.kokoro/conformance.sh', f'.kokoro/{short_name}-conformance.sh')

            new_lines.append(line)
    return "\n".join(new_lines)

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 transform_workflow.py <library_name>")
        sys.exit(1)
    lib = sys.argv[1]
    print(transform(sys.stdin.read(), lib))

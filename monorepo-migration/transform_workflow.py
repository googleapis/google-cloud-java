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
                new_lines.append("defaults:")
                new_lines.append("  run:")
                new_lines.append(f"    working-directory: {lib_name}")
                inserted_defaults = True
            new_lines.append(line)
            new_lines.append(filter_job)
            in_jobs = True
            continue
            
        if in_jobs and line.startswith('  ') and not line.startswith('    ') and line.strip() and not line.strip().startswith('#'):
            job_match = re.match(r'^  ([\w-]+):', line)
            if job_match:
                job_name = job_match.group(1)
                if job_name != 'filter':
                    new_lines.append(line)
                    new_lines.append("    needs: filter")
                    new_lines.append(f"    if: ${{{{ needs.filter.outputs.library == 'true' }}}}")
                    continue
        
        new_lines.append(line)
    return "\n".join(new_lines)

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 transform_workflow.py <library_name>")
        sys.exit(1)
    lib = sys.argv[1]
    print(transform(sys.stdin.read(), lib))

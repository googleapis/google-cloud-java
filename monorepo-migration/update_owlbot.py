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

import ast
import sys
import os

def extract_info(source_code):
    """Extracts excludes and replacement calls from the source owlbot.py."""
    excludes = []
    replacements = []
    
    try:
        tree = ast.parse(source_code)
    except SyntaxError:
        return excludes, replacements

    for node in ast.walk(tree):
        # Look for s.replace(...) calls
        if isinstance(node, ast.Call):
            if isinstance(node.func, ast.Attribute) and node.func.attr == 'replace':
                # We found a replace call. We want to reconstruct the source code for this call.
                # However, ast.unparse is only available in Python 3.9+.
                # If we are on an older python, we might need a workaround or just grab the line range.
                # Since we likely have 3.9+, let's try ast.unparse if available, otherwise strict extraction.
                if sys.version_info >= (3, 9):
                    replacements.append(ast.unparse(node))
                else:
                    # Fallback for older python: just comment it needs manual migration or try simple extraction
                    # For now assume 3.9+ which is standard in this environment
                    pass
        
        # Look for java.common_templates or common.java_library calls to find excludes
        if isinstance(node, ast.Call):
            is_common_templates = False
            if isinstance(node.func, ast.Attribute):
                 if node.func.attr == 'common_templates':
                     is_common_templates = True
                 elif node.func.attr == 'java_library': # older name
                     is_common_templates = True
            
            if is_common_templates:
                for keyword in node.keywords:
                    if keyword.arg == 'excludes':
                        if isinstance(keyword.value, ast.List):
                            for elt in keyword.value.elts:
                                if isinstance(elt, ast.Constant): # Python 3.8+
                                    excludes.append(elt.value)
                                elif isinstance(elt, ast.Str): # Python < 3.8
                                    excludes.append(elt.s)
                        break
    return excludes, replacements


def generate_target_content(excludes, replacements, standard_excludes=None):
    # Default excludes for monorepo if no template is provided
    if standard_excludes is None:
        standard_excludes = {
            ".github/*",
            ".kokoro/*",
            "samples/*",
            "CODE_OF_CONDUCT.md",
            "CONTRIBUTING.md",
            "LICENSE",
            "SECURITY.md",
            "java.header",
            "license-checks.xml",
            "renovate.json",
            ".gitignore"
        }
    
    # Merge excludes
    # User requested to ignore source excludes and strictly use standard excludes
    final_excludes = sorted(list(set(standard_excludes)))
    
    # Format replacements with indentation
    formatted_replacements = ""
    for rep in replacements:
        formatted_replacements += "    " + rep + "\n"
        
    excludes_str = ",\n        ".join([f'"{e}"' for e in final_excludes])

    content = f"""# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import synthtool as s
from synthtool.languages import java

for library in s.get_staging_dirs():
    # put any special-case replacements here
    s.move(library)
{formatted_replacements}
s.remove_staging_dirs()
java.common_templates(monorepo=True, excludes=[
        {excludes_str}
])
"""
    return content

def main():
    if len(sys.argv) < 3:
        print("Usage: update_owlbot.py <target_file> <source_file> [template_file]")
        sys.exit(1)

    target_file = sys.argv[1]
    source_file = sys.argv[2]
    template_file = sys.argv[3] if len(sys.argv) > 3 else None

    if not os.path.exists(source_file):
        print(f"Source file {source_file} not found.")
        sys.exit(1)

    with open(source_file, 'r') as f:
        source_code = f.read()

    excludes, replacements = extract_info(source_code)
    
    standard_excludes = None
    if template_file:
        if os.path.exists(template_file):
            with open(template_file, 'r') as f:
                template_code = f.read()
            template_excludes, _ = extract_info(template_code)
            standard_excludes = template_excludes
        else:
            print(f"Template file {template_file} not found. using default excludes.")

    target_content = generate_target_content(excludes, replacements, standard_excludes)
    
    os.makedirs(os.path.dirname(target_file), exist_ok=True)
    with open(target_file, 'w') as f:
        f.write(target_content)
    
    print(f"Generated {target_file}")

if __name__ == "__main__":
    main()

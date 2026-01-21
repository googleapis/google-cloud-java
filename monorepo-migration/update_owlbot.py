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

def is_call_to(node, name_parts):
    """
    Checks if an AST node is a call to a specific function.
    name_parts: list of strings, e.g. ['s', 'move'] for s.move()
                or ['java', 'common_templates']
    """
    if not isinstance(node, ast.Call):
        return False
    
    func = node.func
    # Handle attribute access (e.g. s.move)
    if isinstance(func, ast.Attribute):
        if len(name_parts) == 2:
            # Check object and attr
            obj = func.value
            if isinstance(obj, ast.Name) and obj.id == name_parts[0] and func.attr == name_parts[1]:
                return True
        elif len(name_parts) == 1:
            if func.attr == name_parts[0]:
                return True
    # Handle direct name (e.g. if imported directly, though less common for these)
    elif isinstance(func, ast.Name):
        if len(name_parts) == 1 and func.id == name_parts[0]:
            return True
        
    return False

def extract_excludes_from_call(call_node):
    excludes = []
    for keyword in call_node.keywords:
        if keyword.arg == 'excludes':
            if isinstance(keyword.value, ast.List):
                for elt in keyword.value.elts:
                    if isinstance(elt, ast.Constant): # Python 3.8+
                        excludes.append(elt.value)
                    elif isinstance(elt, ast.Str): # Python < 3.8
                        excludes.append(elt.s)
            break
    return excludes

def extract_info(source_code):
    excludes = []
    loop_body_lines = []
    top_level_lines = []

    try:
        tree = ast.parse(source_code)
    except SyntaxError:
        return excludes, top_level_lines, loop_body_lines

    for node in tree.body:
        # Some nodes are wrapped in Expr, e.g. s.remove_staging_dirs()
        inner_node = node
        if isinstance(node, ast.Expr):
            inner_node = node.value

        # Ignore standard imports (we will inject them)
        if isinstance(node, (ast.Import, ast.ImportFrom)):
            # We assume we only care about synthtool/java imports which we regenerate.
            # If there are other imports, we should probably preserve them.
            # Heuristic: if it mentions 'synthtool', ignore it.
            if isinstance(node, ast.Import):
                if any('synthtool' in alias.name for alias in node.names):
                    continue
            if isinstance(node, ast.ImportFrom):
                if node.module and 'synthtool' in node.module:
                    continue
            # Preserve other imports
            if sys.version_info >= (3, 9):
                top_level_lines.append(ast.unparse(node))
            continue

        # Check for java.common_templates (top level)
        if is_call_to(inner_node, ['java', 'common_templates']) or is_call_to(inner_node, ['common', 'java_library']):
            excludes.extend(extract_excludes_from_call(inner_node))
            continue

        # Check for s.remove_staging_dirs()
        if is_call_to(inner_node, ['s', 'remove_staging_dirs']):
            continue

        # Check for the main loop: for library in s.get_staging_dirs():
        if isinstance(node, ast.For):
            is_staging_loop = False
            if isinstance(node.iter, ast.Call):
                # Check for s.get_staging_dirs()
                if is_call_to(node.iter, ['s', 'get_staging_dirs']):
                    is_staging_loop = True
            
            if is_staging_loop:
                # Extract body
                for child in node.body:
                    child_inner = child
                    if isinstance(child, ast.Expr):
                        child_inner = child.value

                    # Check for nested common_templates (rare but possible)
                    if is_call_to(child_inner, ['java', 'common_templates']) or is_call_to(child_inner, ['common', 'java_library']):
                        excludes.extend(extract_excludes_from_call(child_inner))
                        continue
                    
                    if sys.version_info >= (3, 9):
                        loop_body_lines.append(ast.unparse(child))
                continue
            # else fall through to preserve other loops

        # Preserve everything else (constants, functions, other logic)
        if sys.version_info >= (3, 9):
            top_level_lines.append(ast.unparse(node))

    return excludes, top_level_lines, loop_body_lines

def generate_target_content(excludes, top_level_lines, loop_body_lines, standard_excludes=None):
    if standard_excludes is None:
        standard_excludes = {
            ".github/*",
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
    
    final_excludes = sorted(list(set(standard_excludes)))
    excludes_str = ",\n    ".join([f'"{e}"' for e in final_excludes])

    # Reconstruct content
    lines = []
    lines.append("# Copyright 2026 Google LLC")
    lines.append("#")
    lines.append("# Licensed under the Apache License, Version 2.0 (the \"License\");")
    lines.append("# you may not use this file except in compliance with the License.")
    lines.append("# You may obtain a copy of the License at")
    lines.append("#")
    lines.append("#     https://www.apache.org/licenses/LICENSE-2.0")
    lines.append("#")
    lines.append("# Unless required by applicable law or agreed to in writing, software")
    lines.append("# distributed under the License is distributed on an \"AS IS\" BASIS,")
    lines.append("# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.")
    lines.append("# See the License for the specific language governing permissions and")
    lines.append("# limitations under the License.")
    lines.append("")
    lines.append("import synthtool as s")
    lines.append("from synthtool.languages import java")
    lines.append("")
    
    if top_level_lines:
        lines.extend(top_level_lines)
        lines.append("")

    lines.append("for library in s.get_staging_dirs():")
    lines.append("    # put any special-case replacements here")
    for l in loop_body_lines:
        # Indent loop body
        for sl in l.split('\n'):
             lines.append("    " + sl)
    
    lines.append("s.remove_staging_dirs()")
    lines.append(f"java.common_templates(monorepo=True, excludes=[")
    lines.append(f"    {excludes_str}")
    lines.append("])")
    
    return "\n".join(lines) + "\n"

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

    excludes, top_level_lines, loop_body_lines = extract_info(source_code)
    
    standard_excludes = None
    if template_file:
        if os.path.exists(template_file):
            with open(template_file, 'r') as f:
                template_code = f.read()
            template_excludes, _, _ = extract_info(template_code)
            standard_excludes = template_excludes
        else:
            print(f"Template file {template_file} not found using default excludes.")

    target_content = generate_target_content(excludes, top_level_lines, loop_body_lines, standard_excludes)
    
    if os.path.dirname(target_file):
        os.makedirs(os.path.dirname(target_file), exist_ok=True)
    with open(target_file, 'w') as f:
        f.write(target_content)
    
    print(f"Generated {target_file}")

if __name__ == "__main__":
    main()

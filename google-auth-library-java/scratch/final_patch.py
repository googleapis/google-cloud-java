import re
import sys

def parse_and_fix(errors_file):
    with open(errors_file, 'r') as f:
        errors = f.readlines()
        
    fixes = {}
    for line in errors:
        match = re.search(r'\[ERROR\] .*?\.java:\[(\d+)(?:,\d+)?\] (.*)', line)
        if match:
            path_match = re.search(r'\[ERROR\] (.*?\.java)', line)
            
            # MUST prepend oauth2_http/ since checkstyle output strips it because it runs per-module
            file_path = "/usr/local/google/home/mcastelaz/google-cloud-java/google-auth-library-java/oauth2_http/" + path_match.group(1)
            line_num = int(match.group(1)) - 1 # 0-indexed
            msg = match.group(2)
            
            try:
                if file_path not in fixes:
                    with open(file_path, 'r') as code_file:
                        fixes[file_path] = code_file.readlines()
            except FileNotFoundError:
                print(f"Skipping {file_path}")
                continue
                
            code_lines = fixes[file_path]
            
            # Simple heuristic fixes
            if "(javadoc)" in msg and ("Missing a Javadoc comment" in msg or "MissingJavadocMethod" in msg):
                if "/**" not in code_lines[line_num - 1]:
                    indent = len(code_lines[line_num]) - len(code_lines[line_num].lstrip())
                    code_lines[line_num] = (" " * indent) + "/** Javadoc. */\n" + code_lines[line_num]
            elif "(misc) FinalParameters:" in msg:
                param_match = re.search(r'Parameter (\w+) should be final', msg)
                if param_match:
                    param = param_match.group(1)
                    code_lines[line_num] = re.sub(r'\b([\w<>\[\]?]+\s+)(' + param + r')\b', r'final \1\2', code_lines[line_num])
            elif "(design) VisibilityModifier:" in msg and "must be private" in msg:
                var_match = re.search(r'Variable \'(\w+)\' must be private', msg)
                if var_match:
                    var = var_match.group(1)
                    code_lines[line_num] = code_lines[line_num].replace(f"final {var}", f"private final {var}")
                    code_lines[line_num] = code_lines[line_num].replace(f"{var}", f"private {var}")

    for file_path, code_lines in fixes.items():
        with open(file_path, 'w') as f:
            f.writelines(code_lines)

if __name__ == '__main__':
    parse_and_fix(sys.argv[1])

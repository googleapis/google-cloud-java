import re
import sys

def parse_errors(error_file):
    errors = {}
    with open(error_file, 'r') as f:
        for line in f:
            if not line.startswith('[ERROR]'):
                continue
            # Extract file path, line number and error message
            # [ERROR] java/com/google/auth/oauth2/AgentIdentityUtils.java[63] (sizes) LineLength: ...
            # or [ERROR] ... [63,3]
            match = re.search(r'\[ERROR\] (.*?\.java)\[(\d+)(?:,\d+)?\] (.*)', line)
            if match:
                file_path = match.group(1)
                line_num = int(match.group(2))
                msg = match.group(3)
                
                if file_path not in errors:
                    errors[file_path] = {}
                if line_num not in errors[file_path]:
                    errors[file_path][line_num] = []
                errors[file_path][line_num].append(msg)
    return errors

def print_errors(errors):
    for f, errs in errors.items():
        if "AgentIdentityUtils" in f or "ComputeEngineCredentials" in f:
            print(f"File: {f}")
            # we want to print just the first 5 errors to get a feel
            for l, ms in list(errs.items())[:5]:
                print(f"  Line {l}: {ms}")

if __name__ == '__main__':
    errs = parse_errors('checkstyle_errors.txt')
    print_errors(errs)

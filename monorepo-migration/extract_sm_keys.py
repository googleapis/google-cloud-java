import re
import sys

def extract_sm_keys(file_path):
    try:
        with open(file_path, 'r') as f:
            content = f.read()
        
        # Regex to match key: "SECRET_MANAGER_KEYS" and its value
        match = re.search(r'key:\s*"SECRET_MANAGER_KEYS"\s*value:\s*"([^"]+)"', content, re.MULTILINE)
        if match:
            return match.group(1).strip()
    except Exception as e:
        print(f"Error reading {file_path}: {e}", file=sys.stderr)
    return None

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: extract_sm_keys.py <path_to_cfg>", file=sys.stderr)
        sys.exit(1)
    
    keys = extract_sm_keys(sys.argv[1])
    if keys:
        print(keys)

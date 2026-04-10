import os
import re

def process_file(file_path, module_name):
    print(f"Processing {file_path}...")
    try:
        with open(file_path, 'r') as f:
            content = f.read()
    except Exception as e:
        print(f"  Error reading {file_path}: {e}")
        return

    line_to_add = f'- "/{module_name}/google-.*/src/main/java/com/google/cloud/.*/v.*/stub/Version.java"'

    if line_to_add in content:
        print(f"  Already present in {file_path}")
        return

    # Find deep-preserve-regex:
    match = re.search(r'(deep-preserve-regex:\s*\n)', content)
    if match:
        pos = match.end()
        new_content = content[:pos] + f"{line_to_add}\n" + content[pos:]
        try:
            with open(file_path, 'w') as f:
                f.write(new_content)
            print(f"  Updated {file_path}")
        except Exception as e:
            print(f"  Error writing {file_path}: {e}")
    else:
        print(f"  Could not find deep-preserve-regex: in {file_path}")

def main():
    root_dir = "."
    updated_count = 0
    for item in os.listdir(root_dir):
        if item.startswith("java-") and os.path.isdir(item):
            file_path = os.path.join(item, ".OwlBot-hermetic.yaml")
            if os.path.exists(file_path):
                process_file(file_path, item)
                updated_count += 1
    print(f"Total files processed: {updated_count}")

if __name__ == "__main__":
    main()

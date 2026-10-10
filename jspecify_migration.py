import os
import re

def migrate_file(file_path):
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()

    original_content = content
    
    # 1. Add JSpecify NullMarked import if not present
    package_match = re.search(r"^\s*package\s+[\w\.]+\s*;", content, re.MULTILINE)
    if package_match and "org.jspecify.annotations.NullMarked" not in content and "@NullMarked" not in content:
        end_pos = package_match.end()
        content = content[:end_pos] + "\nimport org.jspecify.annotations.NullMarked;" + content[end_pos:]
        
        # 2. Add @NullMarked before class/interface/enum declaration
        class_match = re.search(
            r"(\n|^)\s*(?:(?:public|protected|private|abstract|final|static|sealed|non-sealed)\s+)*(?:class|interface|enum|record)\s+\w+",
            content
        )
        if class_match:
            class_start = class_match.start()
            if class_start == 0:
                content = "@NullMarked\n" + content
            else:
                prefix = content[:class_start]
                lines = prefix.split("\n")
                
                # Find the correct insertion point (before other class-level annotations)
                insert_idx = len(lines)
                for i in range(len(lines) - 1, -1, -1):
                    line = lines[i].strip()
                    if line.startswith("@") and not line.startswith("@Override") and not line.startswith("@Test"):
                        insert_idx = i
                    elif line == "" or line.startswith("//") or line.startswith("/*") or line.startswith("*"):
                        break
                    else:
                        break
                lines.insert(insert_idx, "@NullMarked")
                content = "\n".join(lines) + content[class_start:]

    # 3. Replace legacy javax Nullable import
    content = content.replace("import javax.annotation.Nullable;", "import org.jspecify.annotations.Nullable;")

    # 4. Remove legacy javax Nonnull import and annotations
    content = re.sub(r"import\s+javax\.annotation\.Nonnull;\s*\r?\n", "", content)
    content = re.sub(r"^[ \t]*@(javax\.annotation\.)?Nonnull[ \t]*\r?\n", "", content, flags=re.MULTILINE)
    content = re.sub(r"\b@(javax\.annotation\.)?Nonnull\s+", "", content)

    # 5. Reposition @Nullable to be after all modifiers (type-use position)
    # This single regex handles any combination of modifiers (including package-private, final parameters, etc.)
    modifier_pattern = r"@Nullable\s+((?:(?:public|private|protected|static|final|abstract|synchronized|volatile|transient|native|strictfp|sealed|non-sealed)\s+)+)"
    content = re.sub(modifier_pattern, r"\1@Nullable ", content)

    # Save changes if modified
    if content != original_content:
        with open(file_path, "w", encoding="utf-8") as f:
            f.write(content)

def walk_and_migrate(directory):
    for root, _, files in os.walk(directory):
        for file in files:
            if file.endswith(".java") and file != "package-info.java":
                migrate_file(os.path.join(root, file))

if __name__ == "__main__":
    import sys
    if len(sys.argv) > 1:
        walk_and_migrate(sys.argv[1])
    else:
        print("Usage: python jspecify_migration.py <directory_path>")

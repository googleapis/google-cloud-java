import os
import re

def migrate_file(file_path):
    with open(file_path, "r", encoding="utf-8") as f:
        content = f.read()

    original_content = content
    
    # 1. Add JSpecify NullMarked import if not present
    package_match = re.search(r"^(package\s+[\w\.]+;)", content, re.MULTILINE)
    if package_match and "org.jspecify.annotations.NullMarked" not in content and "@NullMarked" not in content:
        package_line = package_match.group(1)
        content = content.replace(package_line, package_line + "\nimport org.jspecify.annotations.NullMarked;")
        
        # 2. Add @NullMarked before class/interface/enum declaration
        class_match = re.search(r"\n(public\s+)?(abstract\s+)?(final\s+)?(class|interface|enum)\s+\w+", content)
        if class_match:
            class_start = class_match.start()
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

    # 4. Reposition @Nullable from declaration to type-use position
    # (immediately before the type name, after class modifiers)
    patterns = [
        (r"@Nullable\s+public\s+abstract\s+final\s+(\w+)", r"public abstract final @Nullable \1"),
        (r"@Nullable\s+public\s+abstract\s+(\w+)", r"public abstract @Nullable \1"),
        (r"@Nullable\s+public\s+static\s+final\s+(\w+)", r"public static final @Nullable \1"),
        (r"@Nullable\s+public\s+static\s+(\w+)", r"public static @Nullable \1"),
        (r"@Nullable\s+public\s+final\s+(\w+)", r"public final @Nullable \1"),
        (r"@Nullable\s+public\s+(\w+)", r"public @Nullable \1"),
        (r"@Nullable\s+private\s+static\s+final\s+(\w+)", r"private static final @Nullable \1"),
        (r"@Nullable\s+private\s+static\s+(\w+)", r"private static @Nullable \1"),
        (r"@Nullable\s+private\s+final\s+(\w+)", r"private final @Nullable \1"),
        (r"@Nullable\s+private\s+(\w+)", r"private @Nullable \1"),
        (r"@Nullable\s+protected\s+static\s+final\s+(\w+)", r"protected static final @Nullable \1"),
        (r"@Nullable\s+protected\s+static\s+(\w+)", r"protected static @Nullable \1"),
        (r"@Nullable\s+protected\s+final\s+(\w+)", r"protected final @Nullable \1"),
        (r"@Nullable\s+protected\s+(\w+)", r"protected @Nullable \1"),
    ]

    for pattern, replacement in patterns:
        content = re.sub(pattern, replacement, content)

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

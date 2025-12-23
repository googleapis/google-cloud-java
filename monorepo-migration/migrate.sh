#!/bin/bash

# Exit on error
set -e

# Configuration
MONOREPO_URL="https://github.com/googleapis/google-cloud-java"
SOURCE_REPO_URL="https://github.com/googleapis/java-logging"

# Derive names from URLs to avoid duplication
SOURCE_REPO_NAME="${SOURCE_REPO_URL##*/}"
MONOREPO_NAME="${MONOREPO_URL##*/}"

# Use a temporary working directory sibling to the current monorepo
WORKING_DIR="../../migration-work"
SOURCE_DIR="$WORKING_DIR/$SOURCE_REPO_NAME-source"
TARGET_DIR="$WORKING_DIR/$MONOREPO_NAME-target"

echo "Starting migration using git read-tree with isolated clones..."

# 0. Create working directory
mkdir -p "$WORKING_DIR"

# 1. Clone the source repository
if [ ! -d "$SOURCE_DIR" ]; then
    echo "Cloning source repo: $SOURCE_REPO_URL into $SOURCE_DIR"
    git clone "$SOURCE_REPO_URL" "$SOURCE_DIR"
else
    echo "Source directory $SOURCE_DIR already exists. Ensuring it is clean and up-to-date..."
    cd "$SOURCE_DIR"
    git fetch origin
    git checkout -f main
    git reset --hard origin/main
    git clean -fd
    cd - > /dev/null
fi

# 2. Clone the target monorepo (the "isolated clone")
if [ ! -d "$TARGET_DIR" ]; then
    echo "Cloning target monorepo: $MONOREPO_URL into $TARGET_DIR"
    git clone "$MONOREPO_URL" "$TARGET_DIR"
else
    echo "Target directory $TARGET_DIR already exists. Ensuring it is clean and up-to-date..."
    cd "$TARGET_DIR"
    git fetch origin
    git checkout -f main
    git reset --hard origin/main
    git clean -fd
    cd - > /dev/null
fi

cd "$TARGET_DIR"

# Ensure we are on a clean main branch in the target clone
echo "Ensuring clean state in target monorepo..."
git fetch origin
git reset --hard HEAD
git clean -fd
git checkout -f main
git reset --hard origin/main

# 2.5 Create a new feature branch for the migration
BRANCH_NAME="migrate-$SOURCE_REPO_NAME"
echo "Creating feature branch: $BRANCH_NAME"
if git rev-parse --verify "$BRANCH_NAME" >/dev/null 2>&1; then
    git branch -D "$BRANCH_NAME"
fi
git checkout -b "$BRANCH_NAME"

# 3. Add the source repo as a remote
echo "Adding remote for $SOURCE_REPO_NAME: $SOURCE_DIR"
if git remote | grep -q "^$SOURCE_REPO_NAME$"; then
    git remote remove "$SOURCE_REPO_NAME"
fi
git remote add "$SOURCE_REPO_NAME" "../$SOURCE_REPO_NAME-source"

# 4. Fetch the source repo
echo "Fetching $SOURCE_REPO_NAME..."
git fetch "$SOURCE_REPO_NAME"

# 5. Merge the histories using 'ours' strategy to keep monorepo content
echo "Merging histories (strategy: ours)..."
git merge --allow-unrelated-histories --no-ff "$SOURCE_REPO_NAME/main" -s ours --no-commit -m "chore($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"

# 6. Read the tree from the source repo into the desired subdirectory
echo "Reading tree into prefix $SOURCE_REPO_NAME/..."
if [ -d "$SOURCE_REPO_NAME" ]; then
    rm -rf "$SOURCE_REPO_NAME"
fi
git read-tree --prefix="$SOURCE_REPO_NAME/" -u "$SOURCE_REPO_NAME/main"

# 7. Commit the migration
echo "Committing migration..."
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"

# 7.5 Migrate GitHub Actions workflows
echo "Checking for GitHub Actions workflows..."
if [ -d "$SOURCE_REPO_NAME/.github/workflows" ]; then
    echo "Migrating workflows to root .github/workflows/..."
    mkdir -p .github/workflows
    
    # Create a temporary python script for robust YAML transformation
    cat << 'EOF' > transform_workflow.py
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
    lib = sys.argv[1]
    print(transform(sys.stdin.read(), lib))
EOF

    for workflow in "$SOURCE_REPO_NAME/.github/workflows/"*; do
        if [ -f "$workflow" ]; then
            filename=$(basename "$workflow")
            new_filename="${SOURCE_REPO_NAME}-${filename}"
            target_path=".github/workflows/$new_filename"
            
            echo "Migrating and adapting $filename to $target_path"
            python3 transform_workflow.py "$SOURCE_REPO_NAME" < "$workflow" > "$target_path"
        fi
    done
    
    rm transform_workflow.py
    
    # Cleanup empty .github directory if it exists
    rm -rf "$SOURCE_REPO_NAME/.github"
    
    echo "Committing workflow migration..."
    git add .github/workflows
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate and adapt GitHub Actions workflows"
fi

# 8. Cleanup
echo "Cleaning up temporary source clone..."
rm -rf "$SOURCE_DIR"

echo "Migration complete!"
echo "The migrated codebase is available in: $TARGET_DIR"
echo "You are on the $BRANCH_NAME branch in that clone."

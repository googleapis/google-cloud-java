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

# Get absolute path to the transformation script before any cd
TRANSFORM_SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
TRANSFORM_SCRIPT="$TRANSFORM_SCRIPT_DIR/transform_workflow.py"
MODERNIZE_POM_SCRIPT="$TRANSFORM_SCRIPT_DIR/modernize_pom.py"

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
    
    for workflow in "$SOURCE_REPO_NAME/.github/workflows/"*; do
        if [ -f "$workflow" ]; then
            filename=$(basename "$workflow")

            # Skip redundant workflows as requested by user
            case "$filename" in
                "hermetic_library_generation.yaml" | "update_generation_config.yaml" | \
                "approve-readme.yaml" | "auto-release.yaml" | "renovate_config_check.yaml" | \
                "samples.yaml" | "unmanaged_dependency_check.yaml")
                    echo "Skipping redundant workflow: $filename"
                    continue
                    ;;
            esac
            
            new_filename="${SOURCE_REPO_NAME}-${filename}"
            target_path=".github/workflows/$new_filename"
            
            echo "Migrating and adapting $filename to $target_path"
            python3 "$TRANSFORM_SCRIPT" "$SOURCE_REPO_NAME" < "$workflow" > "$target_path"
        fi
    done
    
    # Cleanup empty .github directory if it exists
    rm -rf "$SOURCE_REPO_NAME/.github"
    
    echo "Committing workflow migration..."
    git add .github/workflows
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate and adapt GitHub Actions workflows"
fi

# 7.6 Update generation_config.yaml
echo "Updating generation_config.yaml..."
SOURCE_CONFIG="$SOURCE_REPO_NAME/generation_config.yaml"
if [ -f "$SOURCE_CONFIG" ]; then
    # Extract the library entry (starts with - api_shortname)
    # This assumes the source config only has one library or we want the first one
    ENTRY=$(awk '/^  - api_shortname:/{flag=1; print $0; next} /^  - / && flag{flag=0} flag' "$SOURCE_CONFIG")
    
    # Simple cleanup: remove repo and repo_short if they exist
    # Adjust indentation to match monorepo (0 spaces for -)
    CLEAN_ENTRY=$(echo "$ENTRY" | sed '/repo:/d' | sed '/repo_short:/d' | sed 's/^  //')
    
    # Append to target generation_config.yaml
    echo "" >> generation_config.yaml
    echo "$CLEAN_ENTRY" >> generation_config.yaml
    
    echo "Committing generation_config.yaml update..."
    git add generation_config.yaml
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): add library to generation_config.yaml"
fi

# 7.7 Consolidate versions.txt
echo "Consolidating versions.txt..."
SOURCE_VERSIONS="$SOURCE_REPO_NAME/versions.txt"
if [ -f "$SOURCE_VERSIONS" ]; then
    # Append data lines only to root versions.txt (exclude comments/headers)
    grep "^[a-zA-Z0-9]" "$SOURCE_VERSIONS" >> versions.txt
    
    # Remove the migrated subdirectory's versions.txt
    rm "$SOURCE_VERSIONS"
    
    echo "Committing versions.txt update..."
    git add versions.txt "$SOURCE_VERSIONS"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): consolidate versions.txt into root"
fi

# 7.8 Fix copyright headers in Java files
echo "Fixing copyright headers in Java files..."
find "$SOURCE_REPO_NAME" -name "*.java" -exec python3 -c "import sys, re; p = sys.argv[1]; c = open(p).read(); new_c = re.sub(r'Copyright \d{4} Google (Inc\.|LLC)', 'Copyright 2025 Google LLC', c); open(p, 'w').write(new_c)" {} \;

echo "Committing copyright header fixes..."
git add "$SOURCE_REPO_NAME"
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): update copyright headers to 2025 Google LLC"

# 7.9 Modernize root pom.xml
echo "Modernizing root pom.xml..."
PARENT_VERSION=$(grep -m 1 "<version>.*{x-version-update:google-cloud-java:current}" google-cloud-jar-parent/pom.xml | sed -E 's/.*<version>(.*)<\/version>.*/\1/')
python3 "$MODERNIZE_POM_SCRIPT" "$SOURCE_REPO_NAME/pom.xml" "$PARENT_VERSION"

echo "Committing root pom.xml modernization..."
git add "$SOURCE_REPO_NAME/pom.xml"
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): modernize root pom.xml"

# 7.10 Verify compilation
echo "Verifying compilation..."
(cd "$SOURCE_REPO_NAME" && mvn compile -DskipTests -T 1C)

# 8. Cleanup
echo "Cleaning up temporary source clone..."
rm -rf "$SOURCE_DIR"

echo "Migration complete!"
echo "The migrated codebase is available in: $TARGET_DIR"
echo "You are on the $BRANCH_NAME branch in that clone."

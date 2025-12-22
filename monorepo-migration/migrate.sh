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
WORKING_DIR="../../../migration-work"
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
BRANCH_NAME="feat/migrate-$SOURCE_REPO_NAME"
echo "Creating feature branch: $BRANCH_NAME"
if git branch | grep -q "$BRANCH_NAME"; then
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
git merge --allow-unrelated-histories --no-ff "$SOURCE_REPO_NAME/main" -s ours --no-commit -m "feat($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"

# 6. Read the tree from the source repo into the desired subdirectory
echo "Reading tree into prefix $SOURCE_REPO_NAME/..."
if [ -d "$SOURCE_REPO_NAME" ]; then
    rm -rf "$SOURCE_REPO_NAME"
fi
git read-tree --prefix="$SOURCE_REPO_NAME/" -u "$SOURCE_REPO_NAME/main"

# 7. Commit the changes
echo "Committing migration..."
git commit -n --no-gpg-sign -m "feat($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"

# 8. Update the root pom.xml to include the new module
echo "Updating root pom.xml..."
if [ -f "pom.xml" ]; then
    # Check if module already exists
    if grep -q "<module>$SOURCE_REPO_NAME</module>" pom.xml; then
        echo "Module $SOURCE_REPO_NAME already exists in pom.xml"
    else
        # Insert the module before the closing </modules> tag
        sed -i '' "/<\/modules>/i\\
\\    <module>$SOURCE_REPO_NAME</module>
" pom.xml
        echo "Added $SOURCE_REPO_NAME to pom.xml"
    fi
else
    echo "Warning: root pom.xml not found"
fi

# 9. Cleanup
echo "Cleaning up temporary source clone..."
rm -rf "$SOURCE_DIR"

echo "Migration complete!"
echo "The migrated codebase is available in: $TARGET_DIR"
echo "You are on the $BRANCH_NAME branch in that clone."

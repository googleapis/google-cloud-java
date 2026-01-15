#!/bin/bash
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


# Exit on error
set -e

# Function to check if a command exists
check_command() {
    if ! command -v "$1" >/dev/null 2>&1; then
        echo "Error: $1 is not installed or not in PATH." >&2
        exit 1
    fi
}

# Check for necessary CLI binaries
check_command git
check_command python3
check_command mvn

# Configuration
MONOREPO_URL="https://github.com/googleapis/google-cloud-java"
if [ -z "$SOURCE_REPO_URL" ]; then
    read -p "Enter SOURCE_REPO_URL [https://github.com/googleapis/java-logging]: " input_url
    SOURCE_REPO_URL="${input_url:-https://github.com/googleapis/java-logging}"
fi
CODEOWNER="${CODEOWNER:-}"

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
UPDATE_ROOT_POM_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_root_pom.py"
FIX_COPYRIGHT_SCRIPT="$TRANSFORM_SCRIPT_DIR/fix_copyright_headers.py"
UPDATE_GENERATION_CONFIG_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_generation_config.py"
UPDATE_OWLBOT_HERMETIC_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_owlbot_hermetic.py"
TRANSFORM_OWLBOT_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_owlbot.py"

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

# 1.5 Extract CODEOWNERS from source repository as default
if [ -z "$CODEOWNER" ]; then
    echo "Attempting to find default CODEOWNER from source repository..."
    CODEOWNERS_FILE=""
    if [ -f "$SOURCE_DIR/.github/CODEOWNERS" ]; then
        CODEOWNERS_FILE="$SOURCE_DIR/.github/CODEOWNERS"
    elif [ -f "$SOURCE_DIR/CODEOWNERS" ]; then
        CODEOWNERS_FILE="$SOURCE_DIR/CODEOWNERS"
    fi

    DEFAULT_CODEOWNER=""
    if [ -n "$CODEOWNERS_FILE" ]; then
        # Extract the line(s) starting with * (global owners)
        # Use grep to find the line, then sed to remove the '*' and standard team handle
        EXTRACTED_OWNERS=$(grep "^\*" "$CODEOWNERS_FILE" | sed 's/^\*[[:space:]]*//' | sed 's/@googleapis\/cloud-java-team-teamsync//g' | xargs)
        if [ -n "$EXTRACTED_OWNERS" ]; then
            DEFAULT_CODEOWNER="$EXTRACTED_OWNERS"
            echo "Found default CODEOWNER: $DEFAULT_CODEOWNER"
        fi
    fi

    if [ -n "$DEFAULT_CODEOWNER" ]; then
        read -p "Enter CODEOWNER [$DEFAULT_CODEOWNER]: " input_owner
        CODEOWNER="${input_owner:-$DEFAULT_CODEOWNER}"
    else
        read -p "Enter CODEOWNER (e.g., @chingor13): " CODEOWNER
    fi
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
git clean -fdx

# Check if the repository is already migrated
if [ -d "$SOURCE_REPO_NAME" ]; then
    echo "Error: Directory $SOURCE_REPO_NAME already exists in the monorepo." >&2
    echo "This repository seems to have already been migrated." >&2
    exit 1
fi


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
git read-tree --prefix="$SOURCE_REPO_NAME/" -u "$SOURCE_REPO_NAME/main"

# 6.5 Remove common files from the root of the migrated library
echo "Removing common files from the root of $SOURCE_REPO_NAME/..."
rm -f "$SOURCE_REPO_NAME/.gitignore"
rm -f "$SOURCE_REPO_NAME/renovate.json"
rm -f "$SOURCE_REPO_NAME/LICENSE"
rm -f "$SOURCE_REPO_NAME/java.header"
rm -rf "$SOURCE_REPO_NAME/.kokoro"
rm -f "$SOURCE_REPO_NAME/codecov.yaml"
rm -f "$SOURCE_REPO_NAME/synth.metadata"
rm -f "$SOURCE_REPO_NAME/license-checks.xml"
find "$SOURCE_REPO_NAME" -maxdepth 1 -name "*.md" ! -name "CHANGELOG.md" ! -name "README.md" -delete

# 7. Commit the migration
echo "Committing migration..."
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"

# 7.1 Update CODEOWNERS
if [ -n "$CODEOWNER" ]; then
    echo "Updating .github/CODEOWNERS..."
    mkdir -p .github
    echo "/$SOURCE_REPO_NAME/ $CODEOWNER @googleapis/cloud-java-team-teamsync" >> .github/CODEOWNERS

    echo "Committing CODEOWNERS update..."
    git add .github/CODEOWNERS
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): add code owners for $SOURCE_REPO_NAME"
fi

# 7.2 Update root pom.xml modules
echo "Updating root pom.xml modules..."
python3 "$UPDATE_ROOT_POM_SCRIPT" "pom.xml" "$SOURCE_REPO_NAME"

echo "Committing root pom.xml modules update..."
git add pom.xml
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): add module to root pom.xml"


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
    python3 "$UPDATE_GENERATION_CONFIG_SCRIPT" "generation_config.yaml" "$SOURCE_CONFIG"
    
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

# 7.8 Migrate .OwlBot-hermetic.yaml
echo "Migrating .OwlBot-hermetic.yaml..."
if [ -f "$SOURCE_DIR/.github/.OwlBot-hermetic.yaml" ]; then
    SOURCE_OWLBOT="$SOURCE_DIR/.github/.OwlBot-hermetic.yaml"
else
    SOURCE_OWLBOT=""
fi

if [ -n "$SOURCE_OWLBOT" ]; then
    TARGET_OWLBOT="$SOURCE_REPO_NAME/.OwlBot-hermetic.yaml"
    python3 "$UPDATE_OWLBOT_HERMETIC_SCRIPT" "$TARGET_OWLBOT" "$SOURCE_OWLBOT" "$SOURCE_REPO_NAME"
    
    echo "Committing .OwlBot-hermetic.yaml migration..."
    git add "$TARGET_OWLBOT"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate .OwlBot-hermetic.yaml"
fi


# 7.8b Migrate owlbot.py
echo "Migrating owlbot.py..."
if [ -f "$SOURCE_DIR/owlbot.py" ]; then
    TARGET_OWLBOT="$SOURCE_REPO_NAME/owlbot.py"
    
    # Check for a template owlbot.py to source common excludes from
    TEMPLATE_OWLBOT=""
    if [ -f "java-workstations/owlbot.py" ]; then
        TEMPLATE_OWLBOT="java-workstations/owlbot.py"
        echo "Using $TEMPLATE_OWLBOT as template for excludes."
    fi

    if [ -n "$TEMPLATE_OWLBOT" ]; then
        python3 "$TRANSFORM_OWLBOT_SCRIPT" "$TARGET_OWLBOT" "$SOURCE_DIR/owlbot.py" "$TEMPLATE_OWLBOT"
    else
        python3 "$TRANSFORM_OWLBOT_SCRIPT" "$TARGET_OWLBOT" "$SOURCE_DIR/owlbot.py"
    fi

    echo "Committing owlbot.py migration..."
    git add "$TARGET_OWLBOT"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate owlbot.py"
fi

# 7.9 Fix copyright headers in Java files
echo "Fixing copyright headers in Java files..."
python3 "$FIX_COPYRIGHT_SCRIPT" "$SOURCE_REPO_NAME"

echo "Committing copyright header fixes..."
git add "$SOURCE_REPO_NAME"
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): update copyright headers to 2026 Google LLC"

# 7.10 Modernize root pom.xml
echo "Modernizing root pom.xml..."
PARENT_VERSION=$(grep -m 1 "<version>.*{x-version-update:google-cloud-java:current}" google-cloud-jar-parent/pom.xml | sed -E 's/.*<version>(.*)<\/version>.*/\1/')
python3 "$MODERNIZE_POM_SCRIPT" "$SOURCE_REPO_NAME/pom.xml" "$PARENT_VERSION" "$SOURCE_REPO_NAME"

echo "Committing root pom.xml modernization..."
git add "$SOURCE_REPO_NAME/pom.xml"
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): modernize root pom.xml"

# 7.11 Verify compilation
echo "Verifying compilation..."
(cd "$SOURCE_REPO_NAME" && mvn compile -DskipTests -T 1C)

# 8. Cleanup
echo "Cleaning up temporary source clone..."
rm -rf "$SOURCE_DIR"

echo "Migration complete!"
echo "The migrated codebase is available in: $TARGET_DIR"
echo "You are on the $BRANCH_NAME branch in that clone."

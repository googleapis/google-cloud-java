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
EXTRACT_SM_KEYS_SCRIPT="$TRANSFORM_SCRIPT_DIR/extract_sm_keys.py"

# Track number of commits made by this script
COMMIT_COUNT=0

echo "Starting migration using git read-tree with isolated clones..."

# 0. Create working directory
mkdir -p "$WORKING_DIR"

MIGRATION_HEAD_BRANCH="${MIGRATION_HEAD_BRANCH:-main}"
echo "Basing migration branch on: ${MIGRATION_HEAD_BRANCH}"

# 1. Clone the source repository
if [ ! -d "$SOURCE_DIR" ]; then
    echo "Cloning source repo: $SOURCE_REPO_URL into $SOURCE_DIR"
    git clone "$SOURCE_REPO_URL" "$SOURCE_DIR"
else
    echo "Source directory $SOURCE_DIR already exists. Ensuring it is clean and up-to-date..."
    cd "$SOURCE_DIR"
    git fetch origin
    git checkout -f "main"
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
        EXTRACTED_OWNERS=$(grep "^\* " "$CODEOWNERS_FILE" | sed 's/^\*[[:space:]]*//' | sed -E 's/@googleapis\/(cloud-java-team-teamsync|yoshi-java|cloud-sdk-java-team)//g' | xargs)
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
    git checkout -f "${MIGRATION_HEAD_BRANCH}"
    git reset --hard origin/${MIGRATION_HEAD_BRANCH}
else
    echo "Target directory $TARGET_DIR already exists. Ensuring it is clean and up-to-date..."
    cd "$TARGET_DIR"
    git fetch origin
    git checkout -f "${MIGRATION_HEAD_BRANCH}"
    git reset --hard origin/${MIGRATION_HEAD_BRANCH}
    git clean -fd
    cd - > /dev/null
fi

cd "$TARGET_DIR"

# Ensure we are on a clean main branch in the target clone
echo "Ensuring clean state in target monorepo..."
git fetch origin
git reset --hard HEAD
git clean -fd
git checkout -f "${MIGRATION_HEAD_BRANCH}"
git reset --hard origin/${MIGRATION_HEAD_BRANCH}
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
# rm -rf "$SOURCE_REPO_NAME/.kokoro/continuous"  "$SOURCE_REPO_NAME/.kokoro/nightly"  "$SOURCE_REPO_NAME/.kokoro/presubmit"

# 6.6 Create split integration config if needed
SOURCE_INTEGRATION_CFG="$SOURCE_DIR/.kokoro/presubmit/integration.cfg"
if [ -f "$SOURCE_INTEGRATION_CFG" ]; then
    echo "Creating split integration config for $SOURCE_REPO_NAME..."
    SHORT_NAME="${SOURCE_REPO_NAME#java-}"
    TARGET_INTEGRATION_CFG=".kokoro/presubmit/${SHORT_NAME}-integration.cfg"
    
    # Extract SECRET_MANAGER_KEYS from source config
    SM_KEYS=$(python3 "$EXTRACT_SM_KEYS_SCRIPT" "$SOURCE_INTEGRATION_CFG")

    cat <<EOF > "$TARGET_INTEGRATION_CFG"
# Format: //devtools/kokoro/config/proto/build.proto

# Configure the docker image for kokoro-trampoline.
env_vars: {
  key: "TRAMPOLINE_IMAGE"
  value: "gcr.io/cloud-devrel-kokoro-resources/java11"
}

env_vars: {
  key: "JOB_TYPE"
  value: "integration-single"
}

# TODO: remove this after we've migrated all tests and scripts
env_vars: {
  key: "GCLOUD_PROJECT"
  value: "cloud-java-ci-test"
}

env_vars: {
  key: "GOOGLE_CLOUD_PROJECT"
  value: "cloud-java-ci-test"
}

env_vars: {
  key: "GOOGLE_APPLICATION_CREDENTIALS"
  value: "secret_manager/cloud-java-ci-it-service-account"
}
EOF

    if [ -n "$SM_KEYS" ]; then
        cat <<EOF >> "$TARGET_INTEGRATION_CFG"

env_vars: {
  key: "SECRET_MANAGER_KEYS"
  value: "$SM_KEYS"
}
EOF
    fi

    cat <<EOF >> "$TARGET_INTEGRATION_CFG"

env_vars: {
  key: "BUILD_SUBDIR"
  value: "$SOURCE_REPO_NAME"
}
EOF

    echo "Committing split integration config..."
    git add "$TARGET_INTEGRATION_CFG"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): create split integration config"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

# 6.7 Update excluded_modules in .kokoro/common.sh
COMMON_SH=".kokoro/common.sh"
if [ -f "$COMMON_SH" ]; then
    echo "Updating excluded_modules in $COMMON_SH..."
    # Insert the new module name before the closing parenthesis of the excluded_modules array
    sed -i "/^excluded_modules=(/,/^)/ s/^)/  '$SOURCE_REPO_NAME'\n)/" "$COMMON_SH"

    echo "Committing excluded_modules update..."
    git add "$COMMON_SH"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): add to excluded_modules in .kokoro/common.sh"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi
rm -f "$SOURCE_REPO_NAME/codecov.yaml"
rm -f "$SOURCE_REPO_NAME/synth.metadata"
rm -f "$SOURCE_REPO_NAME/license-checks.xml"
find "$SOURCE_REPO_NAME" -maxdepth 1 -name "*.md" ! -name "CHANGELOG.md" ! -name "README.md" -delete

# 7. Commit the migration
echo "Committing migration..."
git add "$SOURCE_REPO_NAME"
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"
COMMIT_COUNT=$((COMMIT_COUNT + 1))

# 7.1 Update CODEOWNERS
if [ -n "$CODEOWNER" ]; then
    echo "Updating .github/CODEOWNERS..."
    mkdir -p .github
    echo "/$SOURCE_REPO_NAME/ $CODEOWNER @googleapis/cloud-sdk-java-team" >> .github/CODEOWNERS

    echo "Committing CODEOWNERS update..."
    git add .github/CODEOWNERS
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): add code owners for $SOURCE_REPO_NAME"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

# 7.2 Update root pom.xml modules
echo "Updating root pom.xml modules..."
python3 "$UPDATE_ROOT_POM_SCRIPT" "pom.xml" "$SOURCE_REPO_NAME"

echo "Committing root pom.xml modules update..."
git add pom.xml
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): add module to root pom.xml"
COMMIT_COUNT=$((COMMIT_COUNT + 1))

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
    git add -- "$SOURCE_REPO_NAME/.github"
    
    echo "Committing workflow migration..."
    git add .github/workflows
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate and adapt GitHub Actions workflows"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

# 7.6 Update generation_config.yaml
echo "Updating generation_config.yaml..."
SOURCE_CONFIG="$SOURCE_REPO_NAME/generation_config.yaml"
if [ -f "$SOURCE_CONFIG" ]; then
    python3 "$UPDATE_GENERATION_CONFIG_SCRIPT" "generation_config.yaml" "$SOURCE_CONFIG"
    
    # Remove the source generation_config.yaml as it is now merged
    rm "$SOURCE_CONFIG"

    echo "Committing generation_config.yaml update..."
    git add generation_config.yaml "$SOURCE_CONFIG"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): add library to generation_config.yaml"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
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
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
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
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi


# 7.8b Migrate owlbot.py
echo "Migrating owlbot.py..."
if [ -f "$SOURCE_DIR/owlbot.py" ]; then
    TARGET_OWLBOT="$SOURCE_REPO_NAME/owlbot.py"
    
    python3 "$TRANSFORM_OWLBOT_SCRIPT" "$TARGET_OWLBOT" "$SOURCE_DIR/owlbot.py"

    echo "Committing owlbot.py migration..."
    git add "$TARGET_OWLBOT"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate owlbot.py"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

# 7.9 Fix copyright headers in Java files
# echo "Fixing copyright headers in Java files..."
# python3 "$FIX_COPYRIGHT_SCRIPT" "$SOURCE_REPO_NAME"

# echo "Committing copyright header fixes..."
# git add "$SOURCE_REPO_NAME"
# git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): update copyright headers to 2026 Google LLC"
# COMMIT_COUNT=$((COMMIT_COUNT + 1))

# 7.11 Modernize root pom.xml
echo "Modernizing root pom.xml..."
PARENT_VERSION=$(grep -m 1 "<version>.*{x-version-update:google-cloud-java:current}" google-cloud-jar-parent/pom.xml | sed -E 's/.*<version>(.*)<\/version>.*/\1/')
python3 "$MODERNIZE_POM_SCRIPT" "$SOURCE_REPO_NAME/pom.xml" "$PARENT_VERSION" "$SOURCE_REPO_NAME"

echo "Committing root pom.xml modernization..."
git add "$SOURCE_REPO_NAME/pom.xml"
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): modernize root pom.xml"
COMMIT_COUNT=$((COMMIT_COUNT + 1))

# 7.12 Modernize BOM pom.xml
echo "Modernizing BOM pom.xml..."
# Find potential BOM POMs (usually in a subdirectory ending with -bom)
# Use process substitution or just a loop over the output of find to avoid subshell issues with counters
while read -r bom_pom; do
    echo "Modernizing BOM: $bom_pom"
    # BOMs should inherit from google-cloud-pom-parent
    python3 "$MODERNIZE_POM_SCRIPT" "$bom_pom" "$PARENT_VERSION" "$SOURCE_REPO_NAME" "google-cloud-pom-parent" "../../google-cloud-pom-parent/pom.xml"
    
    echo "Committing BOM pom.xml modernization for $bom_pom..."
    git add "$bom_pom"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): modernize BOM pom.xml"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
done < <(find "$SOURCE_REPO_NAME" -name "pom.xml" | grep "\-bom/pom.xml" | grep -v "samples")

# 7.11 Verify compilation
echo "Verifying compilation..."
BUILD_SUBDIR="${SOURCE_REPO_NAME}" JOB_TYPE=test .kokoro/build.sh
# (cd "$SOURCE_REPO_NAME" && mvn compile -DskipTests -T 1C)

# 7.13 Squash commits
if [ "${SQUASH_COMMITS:-false}" = "true" ]; then
    echo "Squashing $COMMIT_COUNT commits..."
    if [ "$COMMIT_COUNT" -gt 1 ]; then
        # Reset soft to the first commit of the migration
        # We want to keep the very first commit message, or maybe a combined one?
        # The requirement is "squash all the commits it's made into a single migration commit"
        # The first commit we made was "chore($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"
        
        # We can do this by soft resetting back COMMIT_COUNT-1 commits
        # This leaves the first commit as HEAD, but with changes from subsequent commits staged.
        # NO. Soft reset back N commits.
        # If we made 3 commits: C1, C2, C3. HEAD is C3.
        # reset --soft HEAD~2 results in HEAD at C1, with changes from C2 and C3 staged.
        # then commit --amend adds those staged changes to C1.
        
        git reset --soft "HEAD~$((COMMIT_COUNT - 1))"
        git commit --amend --no-edit --no-gpg-sign
        echo "Squashed everything into one commit."
    fi
fi

# 8. Cleanup
echo "Cleaning up temporary source clone..."
rm -rf "$SOURCE_DIR"

echo "Migration complete!"
echo "The migrated codebase is available in: $TARGET_DIR"
echo "You are on the $BRANCH_NAME branch in that clone."

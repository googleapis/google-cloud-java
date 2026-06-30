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

# Get absolute path to the script directory
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
MONOREPO_ROOT="$(dirname "$SCRIPT_DIR")"

# Ensure git-filter-repo is available in PATH
if ! command -v git-filter-repo >/dev/null 2>&1; then
    LOCAL_FILTER_REPO_DIR="${SCRIPT_DIR}/.git-filter-repo"
    LOCAL_FILTER_REPO="${LOCAL_FILTER_REPO_DIR}/git-filter-repo"
    
    if [ ! -f "$LOCAL_FILTER_REPO" ]; then
        echo "git-filter-repo not found locally or in PATH. Downloading version v2.45.0..."
        mkdir -p "$LOCAL_FILTER_REPO_DIR"
        curl -sSL -o "$LOCAL_FILTER_REPO" "https://raw.githubusercontent.com/newren/git-filter-repo/v2.45.0/git-filter-repo"
        chmod +x "$LOCAL_FILTER_REPO"
    fi
    
    echo "Injecting local .git-filter-repo into PATH..."
    export PATH="${LOCAL_FILTER_REPO_DIR}:$PATH"
fi

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
check_command git-filter-repo

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

# Use a temporary working directory sibling to the current monorepo, anchored to script location
WORKING_DIR="$(cd "${SCRIPT_DIR}/../.." && pwd)/migration-work"
SOURCE_DIR="$WORKING_DIR/$SOURCE_REPO_NAME-source"
TARGET_DIR="$WORKING_DIR/$MONOREPO_NAME-target"

TRANSFORM_SCRIPT_DIR="${SCRIPT_DIR}"
TRANSFORM_SCRIPT="$TRANSFORM_SCRIPT_DIR/transform_workflow.py"
MODERNIZE_POM_SCRIPT="$TRANSFORM_SCRIPT_DIR/modernize_pom.py"
UPDATE_ROOT_POM_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_root_pom.py"
FIX_COPYRIGHT_SCRIPT="$TRANSFORM_SCRIPT_DIR/fix_copyright_headers.py"
UPDATE_GENERATION_CONFIG_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_generation_config.py"
UPDATE_OWLBOT_HERMETIC_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_owlbot_hermetic.py"
TRANSFORM_OWLBOT_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_owlbot.py"
UPDATE_SAMPLES_BUILD_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_samples_build.py"
UPDATE_LINTER_EXCLUSIONS_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_linter_exclusions.py"
UPDATE_CI_FILTERS_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_ci_filters.py"
UPDATE_CHANGES_FILTERS_SCRIPT="$TRANSFORM_SCRIPT_DIR/update_changes_filters.py"

# Track number of commits made by this script
COMMIT_COUNT=0

echo "Starting migration using git read-tree with isolated clones..."

# 0. Create working directory
mkdir -p "$WORKING_DIR"

MIGRATION_HEAD_BRANCH="main"
echo "Basing migration branch on: ${MIGRATION_HEAD_BRANCH}"

# 1. Clone the source repository
if [ "${SKIP_SOURCE_UPDATE:-false}" = "true" ] && [ -d "$SOURCE_DIR" ]; then
    echo "Skipping source repository update and reusing existing directory..."
else
    echo "Ensuring clean slate for history filters by removing existing source directory..."
    rm -rf "$SOURCE_DIR"
    echo "Cloning source repo: $SOURCE_REPO_URL into $SOURCE_DIR"
    git clone --branch main --single-branch "$SOURCE_REPO_URL" "$SOURCE_DIR"
fi

if [ "${SKIP_SOURCE_UPDATE:-false}" != "true" ]; then
    # 1.2 Rewrite history of the split repo to move files to the target subdirectory
    echo "Moving files to destination path: ${SOURCE_REPO_NAME} in history..."
    cd "$SOURCE_DIR"
    git filter-repo --to-subdirectory-filter "${SOURCE_REPO_NAME}" --force
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
    git clone --branch main --single-branch --depth 1 "$MONOREPO_URL" "$TARGET_DIR"
else
    echo "Target directory $TARGET_DIR already exists. Ensuring it is clean and up-to-date..."
    cd "$TARGET_DIR"
    git fetch --depth 1 origin main
    git checkout -f "main"
    git reset --hard origin/main
    git clean -fd
    cd - > /dev/null
fi

cd "$TARGET_DIR"
if [ "$(pwd)" = "$MONOREPO_ROOT" ]; then
    echo "CRITICAL ERROR: Script failed to change directory or attempted to run destructive Git operations inside the active workspace!" >&2
    exit 1
fi

# Ensure we are on a clean main branch in the target clone
echo "Ensuring clean state in target monorepo..."
git fetch --depth 1 origin main
git reset --hard HEAD
git clean -fd
git checkout -f "main"
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

# 5. Merge the histories to pull all rewritten files into their subdirectory directly
echo "Merging histories..."
git merge --allow-unrelated-histories --no-edit --no-gpg-sign "$SOURCE_REPO_NAME/main" -m "chore($SOURCE_REPO_NAME): migrate $SOURCE_REPO_NAME into monorepo"
COMMIT_COUNT=$((COMMIT_COUNT + 1))

# 6.4b Migrate GraalVM Native presubmit config if present
if [ -f "$SOURCE_REPO_NAME/.kokoro/presubmit/graalvm-native-a.cfg" ]; then
    echo "Migrating graalvm-native-a.cfg to monorepo root .kokoro/presubmit/${SOURCE_REPO_NAME#java-}-graalvm-native-presubmit.cfg..."
    mkdir -p .kokoro/presubmit
    sed -e 's/value: "graalvm"/value: "graalvm-single"/' \
        "$SOURCE_REPO_NAME/.kokoro/presubmit/graalvm-native-a.cfg" > ".kokoro/presubmit/${SOURCE_REPO_NAME#java-}-graalvm-native-presubmit.cfg"
    
    # Append BUILD_SUBDIR
    cat <<EOF >> ".kokoro/presubmit/${SOURCE_REPO_NAME#java-}-graalvm-native-presubmit.cfg"

env_vars: {
  key: "BUILD_SUBDIR"
  value: "${SOURCE_REPO_NAME}"
}
EOF
    git add ".kokoro/presubmit/${SOURCE_REPO_NAME#java-}-graalvm-native-presubmit.cfg"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate GraalVM Native presubmit config"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

# 6.4c Migrate Integration presubmit configurations if present
if ls "$SOURCE_REPO_NAME/.kokoro/presubmit/integration"*.cfg >/dev/null 2>&1; then
    mkdir -p .kokoro/presubmit
    for cfg_file in "$SOURCE_REPO_NAME/.kokoro/presubmit/integration"*.cfg; do
        if [ -f "$cfg_file" ]; then
            filename=$(basename "$cfg_file")
            new_filename="${filename/integration/${SOURCE_REPO_NAME#java-}-integration}"
            target_cfg=".kokoro/presubmit/${new_filename}"
            
            echo "Migrating and adapting $filename to $target_cfg..."
            sed -e 's/value: "integration"/value: "integration-single"/' \
                -e 's/java8/java11/' \
                "$cfg_file" > "$target_cfg"
            
            # Append BUILD_SUBDIR
            cat <<EOF >> "$target_cfg"

env_vars: {
  key: "BUILD_SUBDIR"
  value: "${SOURCE_REPO_NAME}"
}
EOF
            git add "$target_cfg"
        fi
    done
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate Integration presubmit configurations"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

# 6.4c(2) Migrate custom conformance execution script if present
if [ -f "$SOURCE_REPO_NAME/.kokoro/conformance.sh" ]; then
    echo "Migrating conformance.sh to monorepo root .kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh..."
    mkdir -p .kokoro
    cp "$SOURCE_REPO_NAME/.kokoro/conformance.sh" ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    echo "Adapting conformance script paths and build scopes for monorepo root..."
    
    # 1. Append popd to the end of the original install block (-T 1C)
    sed -i.bak 's|-T 1C|-T 1C\n  popd|' ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    
    # 2. Construct the unified pre-installation block and pushd subdirectory scoping
    if [ -n "${PRE_INSTALL_DEPS}" ]; then
        PRE_INSTALL_BLOCK="echo \"Installing toolchain and external prerequisites recursively using monorepo install_modules...\"\ninstall_modules \"${PRE_INSTALL_DEPS}\"\n"
    else
        PRE_INSTALL_BLOCK="echo \"Installing platform toolchain recursively using monorepo install_modules...\"\ninstall_modules\n"
    fi
    PRE_INSTALL_BLOCK="${PRE_INSTALL_BLOCK}\npushd ${SOURCE_REPO_NAME}\n# attempt to install 3 times"
    
    # 3. Inject the pre-installation and pushd block
    sed -i.bak "s|# attempt to install 3 times|${PRE_INSTALL_BLOCK}|" ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    
    # 4. Adapt other paths to monorepo root
    sed -i.bak "s|cd test-proxy|cd ${SOURCE_REPO_NAME}/test-proxy|" ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    sed -i.bak "s|-jar test-proxy/target/|-jar ${SOURCE_REPO_NAME}/test-proxy/target/|" ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    sed -i.bak "s|kill \${proxyPID}|kill \${proxyPID} \&\& sleep 5|" ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    sed -i.bak "s|../../test-proxy/known_failures.txt|../../${SOURCE_REPO_NAME}/test-proxy/known_failures.txt|" ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    sed -i.bak 's|mvn install -B -V|mvn install -U -B -V|' ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    sed -i.bak 's|mvn clean install -DskipTests|mvn clean install -U -DskipTests|' ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    rm -f ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh.bak"
    
    if [ -f "${SOURCE_REPO_NAME}/test-proxy/pom.xml" ]; then
        echo "Fixing protoc-gen-grpc-java version in test-proxy/pom.xml for Apple Silicon (osx-aarch_64) support..."
        sed -i.bak "s|1.24.0:exe:\${os.detected.classifier}|1.62.2:exe:\${os.detected.classifier}|" "${SOURCE_REPO_NAME}/test-proxy/pom.xml"
        rm -f "${SOURCE_REPO_NAME}/test-proxy/pom.xml.bak"
        
        echo "Patching monorepo core .kokoro/build.sh inside target clone to exclude test-proxy from changed-modules linting..."
        sed -i.bak 's|unmanaged-dependency-check" \]\] \&\& \\|unmanaged-dependency-check" \]\] \&\& \\\n                       \[\[ "$(basename "${dir}")" != \*"test-proxy"\* \]\] \&\& \\|' ".kokoro/build.sh"
        rm -f ".kokoro/build.sh.bak"
        
        git add "${SOURCE_REPO_NAME}/test-proxy/pom.xml" ".kokoro/build.sh"
        git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): fix test-proxy compilation and exclude from linter changes matrix"
        COMMIT_COUNT=$((COMMIT_COUNT + 1))
    fi
    
    git add ".kokoro/${SOURCE_REPO_NAME#java-}-conformance.sh"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): migrate and adapt conformance execution script"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

# 6.4d Update repo and repo_short in .repo-metadata.json
REPO_METADATA="$SOURCE_REPO_NAME/.repo-metadata.json"
if [ -f "$REPO_METADATA" ]; then
    echo "Updating repo and repo_short in $REPO_METADATA..."
    python3 -c "import json; f = '$REPO_METADATA'; d = json.load(open(f)); d['repo'] = 'googleapis/google-cloud-java'; json.dump(d, open(f, 'w'), indent=2); open(f, 'a').write('\n')"
    
    git add "$REPO_METADATA"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): update .repo-metadata.json"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
fi

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
find "$SOURCE_REPO_NAME" -maxdepth 1 -name "*.md" ! -name "CHANGELOG.md" ! -name "README.md" ! -name "GEMINI.md" ! -name "DEVELOPMENT.md" -delete

echo "Committing removal of common files..."
git add "$SOURCE_REPO_NAME"
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): remove common files from module root"
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
                "samples.yaml" | "unmanaged_dependency_check.yaml" | "unmanaged-dependency-check.yaml")
                    echo "Skipping redundant workflow: $filename"
                    continue
                    ;;
            esac
            
            new_filename="${SOURCE_REPO_NAME}-${filename}"
            target_path=".github/workflows/$new_filename"
            
            echo "Migrating and adapting $filename to $target_path"
            python3 "$TRANSFORM_SCRIPT" "$SOURCE_REPO_NAME" < "$workflow" > "$target_path"
            sed -i.bak "s|java-version: 8|java-version: 11|" "$target_path"
            sed -i.bak "s|github.event.pull_request.head.sha|github.event.pull_request.head.sha \|\| github.sha|g" "$target_path"
            sed -i.bak "s|github.event.pull_request.base.sha|github.event.pull_request.base.sha \|\| github.event.before|g" "$target_path"
            rm -f "${target_path}.bak"
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

# 7.5b Adapt samples_build.yaml if present
SAMPLES_BUILD_YAML="$SOURCE_REPO_NAME/.cloudbuild/samples_build.yaml"
if [ -f "$SAMPLES_BUILD_YAML" ]; then
    echo "Adapting samples_build.yaml..."
    python3 "$UPDATE_SAMPLES_BUILD_SCRIPT" "$SAMPLES_BUILD_YAML" "$SOURCE_REPO_NAME"
    
    echo "Committing samples_build.yaml update..."
    git add "$SAMPLES_BUILD_YAML"
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): adapt samples_build.yaml for monorepo"
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
if [ -f "$SOURCE_DIR/$SOURCE_REPO_NAME/.github/.OwlBot-hermetic.yaml" ]; then
    SOURCE_OWLBOT="$SOURCE_DIR/$SOURCE_REPO_NAME/.github/.OwlBot-hermetic.yaml"
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
if [ -f "$SOURCE_DIR/$SOURCE_REPO_NAME/owlbot.py" ]; then
    TARGET_OWLBOT="$SOURCE_REPO_NAME/owlbot.py"
    
    python3 "$TRANSFORM_OWLBOT_SCRIPT" "$TARGET_OWLBOT" "$SOURCE_DIR/$SOURCE_REPO_NAME/owlbot.py"

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

# 7.12b Align all version markers across the monorepo
echo "Aligning all version markers using apply_versions.sh..."
bash generation/apply_versions.sh versions.txt current

# 7.12c Sync all owlbot.py formatting
echo "Syncing all owlbot.py formatting..."
bash generation/update_owlbot_postprocessor_config.sh "$SOURCE_REPO_NAME" || true

git add -u
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): align versions and format owlbot configurations"
COMMIT_COUNT=$((COMMIT_COUNT + 1))

# 7.8c Exempt module from global integration testing matrix
echo "Exempting $SOURCE_REPO_NAME from global integration testing matrix..."
sed -i.bak "s/'java-storage-nio'/'java-storage-nio'\n  '${SOURCE_REPO_NAME}'/" ".kokoro/common.sh"
python3 "$UPDATE_CI_FILTERS_SCRIPT" ".github/workflows/ci.yaml" "$SOURCE_REPO_NAME"
python3 "$UPDATE_CHANGES_FILTERS_SCRIPT" ".github/workflows/ci.yaml" "$SOURCE_REPO_NAME"

if [ -n "${PRE_INSTALL_DEPS}" ]; then
    echo "Injecting explicit dependencies into always_install_deps list inside .kokoro/common.sh..."
    for dep in $(echo "${PRE_INSTALL_DEPS}" | tr ',' ' '); do
        sed -i.bak "s|always_install_deps_list=(|always_install_deps_list=(\n      '${dep}'|" ".kokoro/common.sh"
    done
    rm -f .kokoro/common.sh.bak
fi

echo "Committing common.sh and ci.yaml updates..."
git add .kokoro/common.sh .github/workflows/ci.yaml
git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): exempt from global integration testing matrix"
COMMIT_COUNT=$((COMMIT_COUNT + 1))

# 7.9b Conditionally skip version check if unmanaged dependencies exist
echo "Verifying non-release-please version compliance..."
if ! (./generation/check_non_release_please_versions.sh > /dev/null 2>&1); then
    echo "Unmanaged dependency versions detected. Injecting $SOURCE_REPO_NAME exclusion into check_non_release_please_versions.sh..."
    python3 "$UPDATE_LINTER_EXCLUSIONS_SCRIPT" "generation/check_non_release_please_versions.sh" "$SOURCE_REPO_NAME"
    
    echo "Committing linter adjustment..."
    git add generation/check_non_release_please_versions.sh
    git commit -n --no-gpg-sign -m "chore($SOURCE_REPO_NAME): skip version check for $SOURCE_REPO_NAME"
    COMMIT_COUNT=$((COMMIT_COUNT + 1))
else
    echo "All dependency versions fully managed. No linter adjustments required."
fi

# 7.11 Verify compilation
echo "Verifying compilation..."
BUILD_SUBDIR="${SOURCE_REPO_NAME}" JOB_TYPE=test .kokoro/build.sh

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
if [ "${SKIP_SOURCE_UPDATE:-false}" != "true" ]; then
    echo "Cleaning up temporary source clone..."
    rm -rf "$SOURCE_DIR"
fi

echo "Migration complete!"
echo "The migrated codebase is available in: $TARGET_DIR"
echo "You are on the $BRANCH_NAME branch in that clone."

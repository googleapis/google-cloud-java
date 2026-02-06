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

# migrate_issues.sh - Transfer open GitHub issues from one repo to another using gh CLI.

set -e

usage() {
  echo "Usage: $0 <source-repo> <target-repo> [--label <label>] [--dry-run]"
  echo "Example: $0 googleapis/python-storage googleapis/google-cloud-python --label 'api: storage'"
  exit 1
}

if [[ $# -lt 2 ]]; then
  usage
fi

SOURCE_REPO=$1
TARGET_REPO=$2
shift 2

DRY_RUN=false
REQUIRED_LABEL=""

while [[ "$#" -gt 0 ]]; do
  case $1 in
    --dry-run) DRY_RUN=true; shift ;;
    --label) REQUIRED_LABEL="$2"; shift 2 ;;
    *) echo "Unknown parameter passed: $1"; usage ;;
  esac
done

# Check if gh is installed
if ! command -v gh &> /dev/null; then
  echo "Error: gh (GitHub CLI) is not installed."
  exit 1
fi

# Check if authenticated
if ! gh auth status &> /dev/null; then
  echo "Error: gh is not authenticated. Run 'gh auth login' first."
  exit 1
fi

echo "Transferring open issues from $SOURCE_REPO to $TARGET_REPO..."
if [ "$DRY_RUN" = true ]; then
  echo "--- DRY RUN MODE ---"
fi

# Ensure label exists in target repo
if [[ -n "$REQUIRED_LABEL" ]]; then
  echo "Ensuring label '$REQUIRED_LABEL' exists in $TARGET_REPO..."
  if ! gh label list --repo "$TARGET_REPO" --json name --jq '.[].name' | grep -fxq "$REQUIRED_LABEL"; then
    if [ "$DRY_RUN" = true ]; then
      echo "  [DRY RUN] Would create label '$REQUIRED_LABEL' in $TARGET_REPO"
    else
      echo "  Creating label '$REQUIRED_LABEL' in $TARGET_REPO..."
      gh label create "$REQUIRED_LABEL" --repo "$TARGET_REPO" --color "ededed"
    fi
  else
    echo "  Label '$REQUIRED_LABEL' already exists."
  fi
fi

# Fetch all open issues from source repo
# We use --limit 1000 to get a reasonable amount of issues. Adjust if needed.
ISSUE_NUMBERS=$(gh issue list --repo "$SOURCE_REPO" --state open --limit 1000 --json number --jq '.[].number')

if [[ -z "$ISSUE_NUMBERS" ]]; then
  echo "No open issues found in $SOURCE_REPO."
  exit 0
fi

# Extract short name from SOURCE_REPO (e.g., java-bigquery from googleapis/java-bigquery)
REPO_SHORT_NAME=$(echo "$SOURCE_REPO" | cut -d'/' -f2)

# Process each issue
for ISSUE_NUMBER in $ISSUE_NUMBERS; do
  echo "Processing Issue #$ISSUE_NUMBER..."

  # Get the current title
  TITLE=$(gh issue view "$ISSUE_NUMBER" --repo "$SOURCE_REPO" --json title --jq '.title')
  NEW_TITLE="[$REPO_SHORT_NAME] $TITLE"

  if [ "$DRY_RUN" = true ]; then
    echo "  [DRY RUN] Would transfer #$ISSUE_NUMBER to $TARGET_REPO"
    echo "  [DRY RUN] Would update title to: $NEW_TITLE"
    if [[ -n "$REQUIRED_LABEL" ]]; then
      echo "  [DRY RUN] Would add label '$REQUIRED_LABEL' to transferred issue"
    fi
  else
    echo "  Transferring #$ISSUE_NUMBER..."
    # Capture the output of transfer to get the new issue URL
    TRANSFER_OUTPUT=$(gh issue transfer "$ISSUE_NUMBER" "$TARGET_REPO" --repo "$SOURCE_REPO")
    
    # The output is typically something like: https://github.com/googleapis/google-cloud-java/issues/1234
    NEW_ISSUE_URL=$(echo "$TRANSFER_OUTPUT" | grep -o 'https://github.com/[^ ]*')
    NEW_ISSUE_NUMBER=$(echo "$NEW_ISSUE_URL" | awk -F'/' '{print $NF}')

    if [[ -n "$NEW_ISSUE_NUMBER" ]]; then
      echo "  Transferred to $TARGET_REPO as #$NEW_ISSUE_NUMBER. Updating issue..."
      
      # Prepare edit command arguments
      EDIT_ARGS=("--title" "$NEW_TITLE")
      if [[ -n "$REQUIRED_LABEL" ]]; then
        EDIT_ARGS+=("--add-label" "$REQUIRED_LABEL")
      fi
      
      gh issue edit "$NEW_ISSUE_NUMBER" --repo "$TARGET_REPO" "${EDIT_ARGS[@]}"
      echo "  Issue updated."
    else
      echo "  Warning: Could not determine new issue number from output: $TRANSFER_OUTPUT"
    fi
  fi
done

echo "Transfer completed."

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
  echo "Usage: $0 <source-repo> <target-repo> [--dry-run]"
  echo "Example: $0 googleapis/python-storage googleapis/google-cloud-python"
  exit 1
}

SOURCE_REPO=$1
TARGET_REPO=$2
DRY_RUN=false

if [[ "$3" == "--dry-run" ]]; then
  DRY_RUN=true
fi

if [[ -z "$SOURCE_REPO" || -z "$TARGET_REPO" ]]; then
  usage
fi

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
  else
    echo "  Transferring #$ISSUE_NUMBER..."
    # Capture the output of transfer to get the new issue URL
    TRANSFER_OUTPUT=$(gh issue transfer "$ISSUE_NUMBER" "$TARGET_REPO" --repo "$SOURCE_REPO")
    
    # The output is typically something like: https://github.com/googleapis/google-cloud-java/issues/1234
    NEW_ISSUE_URL=$(echo "$TRANSFER_OUTPUT" | grep -o 'https://github.com/[^ ]*')
    NEW_ISSUE_NUMBER=$(echo "$NEW_ISSUE_URL" | awk -F'/' '{print $NF}')

    if [[ -n "$NEW_ISSUE_NUMBER" ]]; then
      echo "  Transferred to $TARGET_REPO as #$NEW_ISSUE_NUMBER. Updating title..."
      gh issue edit "$NEW_ISSUE_NUMBER" --repo "$TARGET_REPO" --title "$NEW_TITLE"
      echo "  Title updated."
    else
      echo "  Warning: Could not determine new issue number from output: $TRANSFER_OUTPUT"
    fi
  fi
done

echo "Transfer completed."

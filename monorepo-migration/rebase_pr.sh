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
set -eo pipefail

branch=$1

if [ -z "$branch" ]; then
    echo "Usage: $0 <branch>"
    exit 1
fi

WORKING_DIR="$(realpath ~/migration-work/google-cloud-java-target)"

# create workspace
if [ ! -d "$WORKING_DIR" ]; then
    echo "Workspace doesn't exist -- cloning google-cloud-java into $WORKING_DIR..."
    mkdir -p "$WORKING_DIR"
    git clone "git@github.com:googleapis/google-cloud-java.git" "$WORKING_DIR"
fi

pushd "$WORKING_DIR"

diff_file=$(mktemp)
new_branch="${branch}-2"

echo "Fetching origin..."
git fetch origin

# cleanup from previous runs, if necessary
echo "Deleting $new_branch if it exists..."
git checkout main
git branch -D "$new_branch" || true

# ensure branch is up-to-date with main-backup
echo "Updating $branch with main-backup..."
git checkout main-backup
git pull origin main-backup
git checkout $branch
git merge main-backup

# grab the file diffs from old main
echo "Capturing diff to $diff_file..."
git diff HEAD..main-backup > "$diff_file"

# create new branch from main and apply changes
echo "Creating new branch $new_branch from main..."
git checkout -b "$new_branch" origin/main
echo "Applying diff to $new_branch..."
git apply "$diff_file"
git add .
git commit -am "chore: rebase $branch to main"

popd
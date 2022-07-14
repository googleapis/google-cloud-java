#!/bin/bash

# This script takes target branch name to create a pull request.
# The pull request contains the GAPIC library changes from the commits between
# the last update of the branch (recorded in googleapis_commit.txt) and the
# latest master branch of https://github.com/googleapis/googleapis.

set -ef

pr_destination=$1

if [ -z "${pr_destination}" ]; then
  echo "Please specify destination branch. 'main' or 'monorepo_main'"
  exit 1
fi

BASEDIR=$(dirname "$0")

WORKSPACE=$(mktemp -d -t workspace-XXXXX)
export GOOGLEAPIS_DIR="${WORKSPACE}/googleapis"
export GOOGLE_CLOUD_JAVA_DIR="${WORKSPACE}/google-cloud-java"
export GOOGLEAPIS_COMMIT_FILE=googleapis_commit.txt

pushd "$WORKSPACE"

git clone https://github.com/googleapis/googleapis
git clone --branch "${pr_destination}" https://github.com/googleapis/google-cloud-java

pushd "${GOOGLE_CLOUD_JAVA_DIR}"
start_commit=$(cat "${GOOGLEAPIS_COMMIT_FILE}")

if [ -z "${start_commit}" ]; then
  echo "Couldn't read start_commit from ${GOOGLEAPIS_COMMIT_FILE}"
  exit 1
else
  echo "$(date): start_commit: ${start_commit}"
fi

branch_name="googleapis-sync-${WORKSPACE}"
git checkout -b "${branch_name}"

echo "$(date): Creating commits based on googleapis's ${start_commit} to origin/master"

"${BASEDIR}/create_commits_from_googleapis_commits.sh" "${start_commit}" origin/master

echo "$(date): Pushing commits to remote branch ${branch_name}"

git push -u origin "${branch_name}"

echo "$(date): Creating pull request"

# This reads GITHUB_TOKEN environment variable
gh pr create --title="googleapis sync: $(date '+%Y%m%d %H:%M')" \
    --base "${pr_destination}"




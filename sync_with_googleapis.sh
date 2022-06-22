#!/bin/bash

set -ef

pr_destination=$1

if [ -z "${pr_destination}" ]; then
  echo "Please specify destination branhc. 'main' or 'monorepo_main' "
  exit 1
fi

WORKSPACE=$(mktemp -d -t workspace-XXXXX)
export GOOGLEAPIS_DIR="${WORKSPACE}/googleapis"
export GOOGLE_CLOUD_JAVA_DIR="${WORKSPACE}/google-cloud-java"
export GOOGLEAPIS_COMMIT_FILE=googleapis_commit.txt

cd "$WORKSPACE"

git clone https://github.com/googleapis/googleapis
git clone https://github.com/googleapis/google-cloud-java
pushd "${GOOGLE_CLOUD_JAVA_DIR}"

start_commit=$(cat "${GOOGLEAPIS_COMMIT_FILE}")

if [ -z "${start_commit}" ]; then
  echo "Couldn't read start_commit from ${GOOGLEAPIS_COMMIT_FILE}"
  exit 1
fi


branch_name="sync-with-googleapis-${WORKSPACE}"
git checkout -b "${branch_name}"

./create_commits_from_googleapis_commits.sh "${start_commit}" origin/master

git push -u origin "${branch_name}"

# This reads GITHUB_TOKEN environment variable
gh pr create --title="googleapis sync: $(date '+%Y%m%d %H:%M')" \
    --base "${pr_destination}"




#!/bin/bash

# This script reads the last googleapis (https://github.com/googleapis/googleapis)
# commit applied to the google-cloud-java repository. It then applies new GAPIC
# library changes to the repository between the commit and the latest master of
# the googleapis repository. (This script uses
# create_commits_from_googleapis_commits.sh to generate the Git commits).
# The caller of this script then can create a pull request to apply the changes
# to google-cloud-java repository.
# The location of google-cloud-java repository is specified by
# GOOGLE_CLOUD_JAVA_DIR environment variable.

set -ef

BASEDIR=$(dirname "$0")

if [ -z "${WORKSPACE}" ]; then
  export WORKSPACE=$(mktemp -d -t workspace-XXXXX)
fi

if [ -z "${GOOGLE_CLOUD_JAVA_DIR}" ]; then
  echo "GOOGLE_CLOUD_JAVA_DIR is not set"
  exit 1
fi

export GOOGLEAPIS_DIR="${WORKSPACE}/googleapis"

# TODO: It may be better to read the last googleapis's commit from the Git
# commit messages.
export GOOGLEAPIS_COMMIT_FILE=googleapis_commit.txt

pushd "$WORKSPACE"

BAZEL_VERSION=5.2.0
BAZEL_DOWNLOAD_URL="https://github.com/bazelbuild/bazel/releases/download/${BAZEL_VERSION}/bazel-${BAZEL_VERSION}-linux-x86_64"
curl "${BAZEL_DOWNLOAD_URL}" --output bazel
chmod 755 bazel
export PATH=$WORKSPACE:$PATH
echo "$(date): Downloaded bazel: $(which bazel)"
bazel version

git clone --quiet --branch master https://github.com/googleapis/googleapis

pushd "${GOOGLE_CLOUD_JAVA_DIR}"
start_commit=$(cat "${GOOGLEAPIS_COMMIT_FILE}")

if [ -z "${start_commit}" ]; then
  echo "Couldn't read start_commit from ${GOOGLEAPIS_COMMIT_FILE}"
  exit 1
else
  echo "$(date): start_commit: ${start_commit}"
fi

echo "$(date): Creating commits based on googleapis's ${start_commit} to origin/master"

"${BASEDIR}/create_commits_from_googleapis_commits.sh" "${start_commit}" origin/master

echo "$(date): Finished creating commits in ${GOOGLE_CLOUD_JAVA_DIR}"

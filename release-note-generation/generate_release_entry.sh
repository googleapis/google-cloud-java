#!/bin/bash

# Run this script at the root of the google-cloud-java monorepo.

# Environment variable
#   MODULE: the name of the module to generate release note entry
# Input:
#   - The paths to the file containing commit messages since the
#     last release (in the format of "%B"). The filename should be the
#     <commit hash>.txt.
# Output: prints the changelog entry in markdown format since the
#     last release tag of the repository.

# MODULE=java-kms release-note-generation/generate_release_entry.sh message1.txt message2.txt ...

# Usually the last release tag can be get:
# tag=$(git describe --tags $(git rev-list --tags --max-count=1))
# You can get the commit message files:
#   for H in $(git log v1.11.0..v1.12.0 --pretty=format:"%H"); do
#     git log -1 "${H}" --pretty=format:"%B" > commit_log/${H}.txt
#   done

set -e

if [ -z "${REPO}" ]; then
  REPO=google-cloud-java
fi
COMMIT_URL_PREFIX="https://github.com/googleapis/${REPO}/commit/"

# Name of the module in the monorepo that contains CHANGELOG.md
# and pom.xml. e.g., java-kms
module=$MODULE

if [ -z "${module}" ]; then
  echo "MODULE environment variable is empty"
  exit 1
fi

service=${module/java-/}

# The argument is chronological order with the latest commit comes first.
# The file name must be <commit hash>.txt.
module_specific_change=""
repository_wide_change=""
for commit_message_file in "$@"; do
  filename=$(basename $commit_message_file)
  commit_hash=${filename/.txt/}
  short_hash=${filename:0:7}
  message=$(cat "${commit_message_file}")
  matching_change=$(echo "${message}" |grep "feat: \\[${service}\\]" || true)
  if [ -n "${matching_change}" ]; then
    module_specific_change+="- ${matching_change} [${short_hash}](${COMMIT_URL_PREFIX}${commit_hash})"
  fi
  matching_change=$(echo "${message}" |grep "feat: \\[Many APIs\\]" || true)
  repository_wide_change+=$matching_change
done

today=$(date +"%Y-%m-%d")
module_version=$(sed -e 's/xmlns=".*"//' "${module}/pom.xml" | xmllint --xpath '/project/version/text()' -)

echo "## ${module_version} (${today})"
echo
echo "${module_specific_change}"

if [ -n "${repository_wide_change}" ]; then
  echo "${repository_wide_change}"
fi


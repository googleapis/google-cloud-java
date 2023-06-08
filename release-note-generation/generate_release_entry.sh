#!/bin/bash

# Run this script at the root of the google-cloud-java monorepo.

# Environment variable
#   MODULE: the name of the module to generate release note entry
# Input:
#   - The paths to the file containing commit messages since the
#     last release (in the format of "%H %B")
# Output: prints the changelog entry in markdown format since the
#     last release tag of the repository

# MODULE=java-kms release-note-generation/generate_release_entry.sh message1.txt message2.txt ...

# Usually the last release tag can be get:
# tag=$(git describe --tags $(git rev-list --tags --max-count=1))
# You can get the commit messages
# git log v1.11.0..v1.12.0 --pretty=format:"%H %s"

set -e

# Name of the module in the monorepo that contains CHANGELOG.md
# and pom.xml. e.g., java-kms
module=$MODULE

if [ -z "${module}" ]; then
  echo "MODULE environment variable is empty"
  exit 1
fi

for commit_message_file in "$@"; do
  echo "Processing argument: ${commit_message_file}"
done



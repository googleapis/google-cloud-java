#!/bin/bash
# This script generates showcase in place and checks for git diffs to verify.

echo "******** Verifying Showcase ********"

set -ex
readonly SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
readonly ROOT_DIR="${SCRIPT_DIR}/../.."
readonly SHOWCASE_DIR="${SCRIPT_DIR}/.."
# generate sources in place
bash "${SCRIPT_DIR}/generate_showcase.sh"

# check if there are changes in java-showcase directory
if [ -n "$(git status --porcelain ${SHOWCASE_DIR})" ]; then
  git diff ${SHOWCASE_DIR}
  echo "Error: Showcase generated files are out of sync. Please run 'mvn compile -P update' inside java-showcase to update them."
  exit 1
fi

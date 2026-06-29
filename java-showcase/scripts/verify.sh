#!/bin/bash
# This script generates showcase in place and checks for git diffs to verify.

echo "******** Verifying Showcase ********"

set -ex
readonly SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
readonly ROOT_DIR="${SCRIPT_DIR}/../.."
readonly SHOWCASE_DIR="${SCRIPT_DIR}/.."
readonly GENERATED_DIRS="${SHOWCASE_DIR}/gapic-showcase/src/main ${SHOWCASE_DIR}/grpc-gapic-showcase-v1beta1/src/main ${SHOWCASE_DIR}/proto-gapic-showcase-v1beta1/src/main"

# generate sources in place
bash "${SCRIPT_DIR}/generate_showcase.sh"

# check if there are changes in generated directories
if [ -n "$(git status --porcelain ${GENERATED_DIRS})" ]; then
  git diff ${GENERATED_DIRS}
  echo "Error: Showcase generated files are out of sync. Please run 'mvn compile -P update' inside java-showcase to update them."
  exit 1
fi

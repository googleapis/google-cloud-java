#!/bin/bash
# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -exo pipefail

REQUESTED_TAG="$1"
TARGET_BRANCH="$2"
shift 2

# Parse arguments using '--' as delimiter
DOCKER_OPTS=()
CONTAINER_CMD=()
found_delimiter=false

for arg in "$@"; do
  if [ "$arg" == "--" ]; then
    found_delimiter=true
    continue
  fi
  if $found_delimiter; then
    CONTAINER_CMD+=("$arg")
  else
    DOCKER_OPTS+=("$arg")
  fi
done

IMAGE_NAME="gcr.io/cloud-devrel-public-resources/java-library-generation"
# Support both local git and GitHub Actions environment variables
CURRENT_BRANCH="${GITHUB_HEAD_REF:-${GITHUB_REF_NAME:-$(git branch --show-current)}}"
IMAGE_TAG="$REQUESTED_TAG"

# Fallback logic on Release PR branches
if [[ "$CURRENT_BRANCH" =~ ^release-please-- ]]; then
  echo "Detected release PR branch: $CURRENT_BRANCH"
  if ! docker pull "${IMAGE_NAME}:${IMAGE_TAG}"; then
    echo "Image not found for version ${IMAGE_TAG}. Falling back to previous version from ${TARGET_BRANCH}."
    # Extract tag from target branch's versions.txt using explicit fetch
    git fetch origin "${TARGET_BRANCH}" --depth=1 || true
    PREVIOUS_TAG=$(git show FETCH_HEAD:versions.txt | grep "^gapic-generator-java:" | cut -d ':' -f 2 || true)
    if [ -n "$PREVIOUS_TAG" ]; then
      echo "Using previous image version: $PREVIOUS_TAG"
      IMAGE_TAG="$PREVIOUS_TAG"
    else
      echo "Failed to extract fallback tag. Proceeding with requested tag."
    fi
  fi
fi

# Execute Docker run with proper ordering
docker run --rm "${DOCKER_OPTS[@]}" "${IMAGE_NAME}:${IMAGE_TAG}" "${CONTAINER_CMD[@]}"

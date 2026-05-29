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

set -eo pipefail

BASE_REF=$1
if [ -z "$BASE_REF" ]; then
  echo "Usage: $0 <base-ref>"
  exit 1
fi

echo "Comparing changes against origin/${BASE_REF}"

# Fetch the base branch to ensure it exists locally
git fetch origin "${BASE_REF}" --depth=1 || true

# List changed files
CHANGED_FILES=$(git diff --name-only "origin/${BASE_REF}...HEAD")

# Ignored files at root
declare -A IGNORED_FILES
IGNORED_FILES=(
  ["README.md"]=1
  ["CHANGELOG.md"]=1
  ["LICENSE"]=1
  ["CODE_OF_CONDUCT.md"]=1
  ["CONTRIBUTING.md"]=1
  ["DEVELOPMENT.md"]=1
  [".gitignore"]=1
  [".gitattributes"]=1
  ["renovate.json"]=1
  [".tool-versions"]=1
  [".release-please-manifest.json"]=1
  ["release-please-config.json"]=1
  ["changelog.json"]=1
  ["settings.xml"]=1
  ["versions.txt"]=1
)

run_all=false
has_relevant_changes=false
declare -A libraries_to_generate

for file in $CHANGED_FILES; do
  # Check if file is ignored
  if [[ -n "${IGNORED_FILES[$file]}" ]]; then
    continue
  fi

  # Check if file starts with java-
  if [[ "$file" =~ ^java-([^/]+)/ ]]; then
    lib="${BASH_REMATCH[1]}"
    libraries_to_generate["$lib"]=1
    has_relevant_changes=true
  else
    # Global file change
    echo "Global or config file changed: $file"
    run_all=true
    has_relevant_changes=true
  fi
done

if [ "$has_relevant_changes" = false ]; then
  echo "No relevant changes to verify. Skipping generation check."
  exit 0
fi

if [ "$run_all" = true ]; then
  echo "Running librarian generate --all"
  librarian generate --all
else
  for lib in "${!libraries_to_generate[@]}"; do
    echo "Running librarian generate $lib"
    librarian generate "$lib"
  done
fi

#!/bin/bash
# Copyright 2023 Google LLC
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

# Comma-delimited list of repos to test with the local java-shared-dependencies
if [ -z "${REPOS_UNDER_TEST}" ]; then
  echo "REPOS_UNDER_TEST must be set to run downstream-compatibility.sh"
  exit 1
fi


# Get the directory of the build script
scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
cd "${scriptDir}/../.." # cd to the root of this repo
source "$scriptDir/common.sh"

setup_maven_mirror

install_repo_modules '!gapic-generator-java'
SHARED_DEPS_VERSION=$(parse_pom_version java-shared-dependencies)
echo "Install complete. java-shared-dependencies = $SHARED_DEPS_VERSION"

pushd java-shared-dependencies/target
for repo in ${REPOS_UNDER_TEST//,/ }; do # Split on comma
  # Perform testing on last release, not HEAD
  last_release=$(find_last_release_version "$repo")
  git clone "https://github.com/googleapis/$repo.git" --depth=1 --branch "v$last_release"
  update_all_poms_dependency "$repo" google-cloud-shared-dependencies "$SHARED_DEPS_VERSION"
  pushd "$repo"
  JOB_TYPE="test" ./.kokoro/build.sh
  popd
done
popd

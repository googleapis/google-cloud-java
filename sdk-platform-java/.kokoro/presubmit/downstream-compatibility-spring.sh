#!/bin/bash
# Copyright 2024 Google LLC
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

# This script is only meant to test spring-cloud-gpc, specifically on its
# autoconfig generation workflow

set -eox pipefail

# Get the directory of the build script
scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
cd "${scriptDir}/../.." # cd to the root of this repo
source "$scriptDir/common.sh"

install_repo_modules
GAPIC_GENERATOR_VERSION=$(parse_pom_version "gapic-generator-java-bom")
echo "Install complete. gapic-generator-java-bom = $GAPIC_GENERATOR_VERSION"

pushd gapic-generator-java/target
# Download and configure spring-cloud-gcp for testing
last_release=$(find_last_release_version "spring-cloud-gcp" "main" "GoogleCloudPlatform")
git clone "https://github.com/GoogleCloudPlatform/spring-cloud-gcp.git" --depth=1 --branch "v$last_release"
update_all_poms_dependency "spring-cloud-gcp" "gapic-generator-java-bom" "${GAPIC_GENERATOR_VERSION}"

# Install spring-cloud-gcp modules
pushd spring-cloud-gcp
./mvnw \
  -U \
  --batch-mode \
  --no-transfer-progress \
  --show-version \
  --threads 1.5C \
  --define maven.test.skip=true \
  --define maven.javadoc.skip=true \
  install


# Generate showcase autoconfig
pushd spring-cloud-generator
# The script is not executable for non-owners. Here we manually chmod it.
# TODO(diegomarquezp): remove this line after
# https://github.com/GoogleCloudPlatform/spring-cloud-gcp/pull/3183 is merged and released.
chmod 755 ./scripts/generate-showcase.sh
./scripts/generate-showcase.sh
pushd showcase/showcase-spring-starter
mvn verify
popd # showcase/showcase-spring-starter

popd # spring-cloud-generator
popd # spring-cloud-gcp
popd # gapic-generator-java/target

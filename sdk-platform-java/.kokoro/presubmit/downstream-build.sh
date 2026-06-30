#!/bin/bash
# Copyright 2019 Google LLC
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

if [ -z "${MODULES_UNDER_TEST}" ]; then
  echo "MODULES_UNDER_TEST must be set to run downstream-build.sh"
  exit 1
fi

## Get the directory of the build script
scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
cd "${scriptDir}/../.." # git repo root
source "$scriptDir/common.sh"

# Publish this repo's modules to local maven to make them available for downstream libraries
mvn install --projects '!gapic-generator-java' \
  -Danimal.sniffer.skip \
  -Dcheckstyle.skip \
  -Dclirr.skip \
  -Dfmt.skip \
  -DskipTests \
  -B -ntp \
  -Dorg.slf4j.simpleLogger.showDateTime=true \
  -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS

SHARED_DEPS_VERSION=$(parse_pom_version java-shared-dependencies)

# Update the shared-dependencies version in google-cloud-jar-parent
git clone "https://github.com/googleapis/google-cloud-java.git" --depth=1
update_all_poms_dependency google-cloud-java google-cloud-shared-dependencies "$SHARED_DEPS_VERSION"

# Run the updated java-shared-dependencies BOM against google-cloud-java integration tests
cd google-cloud-java
source ./.kokoro/common.sh
RETURN_CODE=0
setup_application_credentials
setup_cloud "$MODULES_UNDER_TEST"
install_modules "$MODULES_UNDER_TEST"
run_graalvm_tests "$MODULES_UNDER_TEST"
# Exit must occur in google-cloud-java directory to correctly destroy IT resources
exit "$RETURN_CODE"

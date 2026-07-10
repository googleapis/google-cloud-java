#!/bin/bash
# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eo pipefail
set -x

function modify_shared_config() {
  xmllint --shell pom.xml <<EOF
  setns x=http://maven.apache.org/POM/4.0.0
  cd .//x:artifactId[text()="google-cloud-shared-config"]
  cd ../x:version
  set ${SHARED_CONFIG_VERSION}
  save pom.xml
EOF
}

## Get the directory of the build script and install all modules in the monorepo
scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
## cd to the parent directory, i.e. the root of the git repo
cd "${scriptDir}/../.."

source "${scriptDir}/../common.sh"
install_http_client_snapshot

# Build and install the entire monorepo to local cache (including the under-test java-shared-config)
mvn -B -ntp install -Dcheckstyle.skip -Dfmt.skip -DskipTests

# Get the version of java-shared-config under test
VERSION_POM=java-shared-config/java-shared-config/pom.xml
SHARED_CONFIG_VERSION=$(sed -e 's/xmlns=".*"//' ${VERSION_POM} | xmllint --xpath '/project/version/text()' -)

# Use GCP Maven Mirror (as in original script)
mkdir -p "${HOME}/.m2"
cp java-shared-config/settings.xml "${HOME}/.m2"

# Update the shared-config version in the local java-showcase parent
pushd java-showcase
modify_shared_config
popd

# Parse showcase version from the local directory
pushd java-showcase/gapic-showcase
SHOWCASE_VERSION=$(mvn help:evaluate -Dexpression=gapic-showcase.version -q -DforceStdout)
popd

# Start showcase server
mkdir -p /usr/src/showcase
curl --location https://github.com/googleapis/gapic-showcase/releases/download/v"${SHOWCASE_VERSION}"/gapic-showcase-"${SHOWCASE_VERSION}"-linux-amd64.tar.gz --output /usr/src/showcase/showcase-"${SHOWCASE_VERSION}"-linux-amd64.tar.gz
pushd /usr/src/showcase/
tar -xf showcase-*
./gapic-showcase run &
popd

# Run showcase tests with `native` profile in java-showcase
pushd java-showcase
mvn test -Pnative,showcase -Denforcer.skip=true -ntp -B
RETURN_CODE=$?
popd

# Revert local showcase modifications
git checkout -- java-showcase/pom.xml

exit $RETURN_CODE

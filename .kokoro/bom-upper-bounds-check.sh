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

# Presubmit to ensure the dependencies of the Google Libraries BOM, with the modification of change
# in the PR, pick up the highest versions among transitive dependencies.
# https://maven.apache.org/enforcer/enforcer-rules/requireUpperBoundDeps.html

set -eo pipefail
# Display commands being run.
set -x

cd github/google-cloud-java/

# Print out tool version
echo $JOB_TYPE
java -version
mvn -version
git version

# Make artifacts available for 'mvn validate' at the bottom
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -Dgcloud.download.skip=true -B -V

# The property key for this repository in Google Libraries BOM
VERSION_KEY=google.cloud.java.version
# Read the version of POM. Example version: '0.116.1-alpha-SNAPSHOT'
VERSION_POM=google-cloud-bom/pom.xml
# Namespace (xmlns) prevents xmllint from specifying tag names in XPath
VERSION=`sed -e 's/xmlns=".*"//' $VERSION_POM | xmllint --xpath '/project/version/text()' -`

if [ -z "${VERSION}" ]; then
  echo "Version is not found in ${VERSION_POM}"
  exit 1
fi
echo "Version: ${VERSION}"

# Run the upper bound check against Google Libraries BOM in cloud-opensource-java
git clone https://github.com/GoogleCloudPlatform/cloud-opensource-java.git

cd cloud-opensource-java/boms/cloud-oss-bom
mvn install

# This upper-bounds-check project has the enforcer rule with requireUpperBoundDeps
cd ../upper-bounds-check
mvn validate -D${VERSION_KEY}=${VERSION}

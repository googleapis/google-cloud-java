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

# Presubmit to ensure the dependencies of the Google Libraries BOM, with the modification of change
# in the PR, pick up the highest versions among transitive dependencies.
# https://maven.apache.org/enforcer/enforcer-rules/requireUpperBoundDeps.html

set -eo pipefail
# Display commands being run.
set -x

function get_current_version_from_versions_txt() {
  versions=$1
  key=$2
  version=$(grep "$key:" "${versions}" | cut -d: -f3) # 3rd field is current
  echo "${version}"
}

function get_released_version_from_versions_txt() {
  versions=$1
  key=$2
  version=$(grep "$key:" "${versions}" | cut -d: -f2) # 2nd field is release
  echo "${version}"
}

function replace_java_shared_config_version() {
  version=$1
  # replace version
  xmllint --shell <(cat pom.xml) << EOF
  setns x=http://maven.apache.org/POM/4.0.0
  cd .//x:artifactId[text()="google-cloud-shared-config"]
  cd ../x:version
  set ${version}
  save pom.xml
EOF
}

function replace_java_shared_dependencies_version() {
  version=$1
  # replace version
  xmllint --shell <(cat pom.xml) << EOF
  setns x=http://maven.apache.org/POM/4.0.0
  cd .//x:properties/x:google-cloud-shared-dependencies.version
  set ${version}
  save pom.xml
EOF
}

function replace_sdk_platform_java_config_version() {
  version=$1
  # replace version
  xmllint --shell <(cat pom.xml) << EOF
  setns x=http://maven.apache.org/POM/4.0.0
  cd .//x:artifactId[text()="sdk-platform-java-config"]
  cd ../x:version
  set ${version}
  save pom.xml
EOF
}
REPO=$1
# Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
## cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/..

# Make artifacts available for 'mvn validate' at the bottom
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -Dgcloud.download.skip=true -B -V -q --no-transfer-progress

# Get version of doclet used to generate Cloud RAD for javadoc testing with the doclet below
rm -rf java-docfx-doclet
git clone https://github.com/googleapis/java-docfx-doclet.git
pushd java-docfx-doclet/third_party/docfx-doclet-143274
git checkout 1.9.0
mvn package -Dmaven.test.skip=true -B -V --no-transfer-progress

# work from the root directory
popd
docletPath=$(realpath "java-docfx-doclet/third_party/docfx-doclet-143274/target/docfx-doclet-1.0-SNAPSHOT-jar-with-dependencies.jar")
echo "This is the doclet path: ${docletPath}"

# Read the current version of this BOM in the POM. Example version: '0.116.1-alpha-SNAPSHOT'
VERSION_POM=java-shared-config/pom.xml
# Namespace (xmlns) prevents xmllint from specifying tag names in XPath
JAVA_SHARED_CONFIG_VERSION=`sed -e 's/xmlns=".*"//' ${VERSION_POM} | xmllint --xpath '/project/version/text()' -`

if [ -z "${JAVA_SHARED_CONFIG_VERSION}" ]; then
  echo "Version is not found in ${VERSION_POM}"
  exit 1
fi
echo "Version: ${JAVA_SHARED_CONFIG_VERSION}"

# Update java-shared-config in sdk-platform-java-config
rm -rf google-cloud-java
# Find the latest tag matching v* and use it
LATEST_TAG=$(git ls-remote --tags https://github.com/googleapis/google-cloud-java.git | grep 'refs/tags/v' | sort -k2,2 -V | tail -n 1 | awk '{print $2}' | sed 's|refs/tags/||')
echo "Cloning google-cloud-java at tag: ${LATEST_TAG}"
git clone "https://github.com/googleapis/google-cloud-java.git" -b "${LATEST_TAG}" --depth=1
pushd google-cloud-java/sdk-platform-java
SDK_PLATFORM_JAVA_CONFIG_VERSION=$(sed -e 's/xmlns=".*"//' sdk-platform-java-config/pom.xml | xmllint --xpath '/project/version/text()' -)

pushd sdk-platform-java-config
# Use released version of google-cloud-shared-dependencies to avoid verifying SNAPSHOT changes.
replace_java_shared_config_version "${JAVA_SHARED_CONFIG_VERSION}"
echo "The diff in sdk-platform-java-config:"
git --no-pager diff
echo "--------"
mvn install "-DskipTests=true" "-Dmaven.javadoc.skip=true" "-Dgcloud.download.skip=true" "-Dcheckstyle.skip=true" -B -V -q --no-transfer-progress
popd

# Check javadoc generation with the doclet
rm -rf "${REPO}"
git clone "https://github.com/googleapis/${REPO}.git" --depth=1

pushd ${REPO}
replace_sdk_platform_java_config_version "${SDK_PLATFORM_JAVA_CONFIG_VERSION}"

mvn clean -B --no-transfer-progress \
    -P docFX \
    -DdocletPath="${docletPath}" \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dorg.slf4j.simpleLogger.showDateTime=true -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
    -Dcheckstyle.skip=true \
    -Dflatten.skip=true \
    -Danimal.sniffer.skip=true \
    javadoc:aggregate

RETURN_CODE=$?
if [ "${RETURN_CODE}" == 0 ]; then
  echo "Javadocs generated successfully with doclet"
else
  echo "Javadoc generation FAILED with doclet"
fi

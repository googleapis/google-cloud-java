#!/bin/bash
# Copyright 2021 Google LLC
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

if [[ $# -ne 2 ]];
then
  echo "Usage: $0 <repo-name> <job-type>"
  echo "where repo-name is java-XXX and check-type is dependencies, lint, or clirr"
  exit 1
fi
REPO=$1
# build.sh uses this environment variable
export JOB_TYPE=$2

## Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
## cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/..

# Make artifacts available for 'mvn validate' at the bottom
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -Dgcloud.download.skip=true -B -V -q

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
git clone "https://github.com/googleapis/sdk-platform-java.git" --depth=1
pushd sdk-platform-java
SDK_PLATFORM_JAVA_CONFIG_VERSION=$(get_current_version_from_versions_txt versions.txt "google-cloud-shared-dependencies")
RELEASED_SHARED_DEPENDENCIES_VERSION=$(get_released_version_from_versions_txt versions.txt "google-cloud-shared-dependencies")
pushd sdk-platform-java-config

# Use released version of google-cloud-shared-dependencies to avoid verifying SNAPSHOT changes.
replace_java_shared_config_version "${JAVA_SHARED_CONFIG_VERSION}"
replace_java_shared_dependencies_version "${RELEASED_SHARED_DEPENDENCIES_VERSION}"
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -Dgcloud.download.skip=true -B -V -q
popd
popd

# Check this BOM against a few java client libraries
# java-bigquery
if [ -z "${REPO_TAG}" ]; then
  git clone "https://github.com/googleapis/${REPO}.git" --depth=1
else
  git clone "https://github.com/googleapis/${REPO}.git" --depth=1 --branch "${REPO_TAG}"
fi

pushd ${REPO}

# If using an older version of java-storage, continue replacing java-shared-config version otherwise replace
# the version of sdk-platform-java-config.
if [ "${REPO_TAG}" == "v2.9.3" ] && [ "${REPO}" == "java-storage" ]; then
  replace_java_shared_config_version "${JAVA_SHARED_CONFIG_VERSION}"
else
  replace_sdk_platform_java_config_version "${SDK_PLATFORM_JAVA_CONFIG_VERSION}"
fi

case ${JOB_TYPE} in
dependencies)
    .kokoro/dependencies.sh
    RETURN_CODE=$?
    ;;
flatten-plugin)
    # This creates .flattened-pom.xml
    echo "Before running .kokoro/build.sh"
    .kokoro/build.sh
    echo "After running .kokoro/build.sh"
    pushd google-cloud-*
    mvn dependency:list -f .flattened-pom.xml -DincludeScope=runtime -Dsort=true \
        | grep '\[INFO]    .*:.*:.*:.*:.*' |awk '{print $2}' > .actual-flattened-dependencies-list.txt
    echo "Diff from the expected file (${EXPECTED_DEPENDENCIES_LIST}):"
    diff "${scriptDir}/${EXPECTED_DEPENDENCIES_LIST}" .actual-flattened-dependencies-list.txt
    RETURN_CODE=$?
    if [ "${RETURN_CODE}" == 0 ]; then
      echo "No diff."
    else
      echo "There was a diff."
    fi
    popd
    ;;
*)
    # Here we replace the com.coveo fmt plugin with the spotify version.
	# This `sed` won't be needed once downstream repositories update
	# `.kokoro/build.sh` to use the `com.spotify.fmt` group ID.
    sed -i 's/com.coveo:fmt-maven-plugin/com.spotify.fmt:fmt-maven-plugin/' .kokoro/build.sh
    # This reads the JOB_TYPE environmental variable
    .kokoro/build.sh
    RETURN_CODE=$?
    ;;
esac

echo "exiting with ${RETURN_CODE}"
exit ${RETURN_CODE}

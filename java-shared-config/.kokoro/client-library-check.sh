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
VERSION=`sed -e 's/xmlns=".*"//' ${VERSION_POM} | xmllint --xpath '/project/version/text()' -`

if [ -z "${VERSION}" ]; then
  echo "Version is not found in ${VERSION_POM}"
  exit 1
fi
echo "Version: ${VERSION}"

# Check this BOM against a few java client libraries
# java-bigquery
if [ -z "${REPO_TAG}" ]; then
  git clone "https://github.com/googleapis/${REPO}.git" --depth=1
else
  git clone "https://github.com/googleapis/${REPO}.git" --depth=1 --branch "${REPO_TAG}"
fi

pushd ${REPO}

# replace version
xmllint --shell <(cat pom.xml) << EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="google-cloud-shared-config"]
cd ../x:version
set ${VERSION}
save pom.xml
EOF

case ${JOB_TYPE} in
dependencies)
    .kokoro/dependencies.sh
    RETURN_CODE=$?
    ;;
flatten-plugin)
    # This creates .flattened-pom.xml
    .kokoro/build.sh
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
    # This reads the JOB_TYPE environmental variable
    .kokoro/build.sh
    RETURN_CODE=$?
    ;;
esac

echo "exiting with ${RETURN_CODE}"
exit ${RETURN_CODE}

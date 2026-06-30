#!/bin/bash
#
# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

set -e

# Find the directory of this script (root of google-cloud-java)
MONOREPO_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
PARENT_DIR="$(cd "${MONOREPO_DIR}/.." && pwd)"

# Path to the google-http-java-client repository
HTTP_CLIENT_DIR="${HTTP_CLIENT_DIR:-${PARENT_DIR}/google-http-java-client}"
HTTP_CLIENT_BRANCH="${HTTP_CLIENT_BRANCH:-pqc-support-conscrypt}"


HTTP_CLIENT_VERSION="${HTTP_CLIENT_VERSION:-2.1.2-SNAPSHOT}"

echo "========================================================================="
echo "Building and installing google-http-java-client snapshot..."
echo "Using path: ${HTTP_CLIENT_DIR}"
echo "========================================================================="

if [ ! -d "${HTTP_CLIENT_DIR}" ]; then
  echo "Error: google-http-java-client directory not found at: ${HTTP_CLIENT_DIR}"
  echo "You can specify its location by setting the HTTP_CLIENT_DIR environment variable."
  exit 1
fi

# Check if the snapshot jar is already built in the local maven repository
M2_JAR_PATH="${HOME}/.m2/repository/com/google/http-client/google-http-client/${HTTP_CLIENT_VERSION}/google-http-client-${HTTP_CLIENT_VERSION}.jar"

if [ -f "${M2_JAR_PATH}" ] && [ "${FORCE_REBUILD}" != "true" ]; then
  echo "Found existing google-http-client snapshot at ${M2_JAR_PATH}."
  echo "Skipping build. (To force rebuild, run with FORCE_REBUILD=true)"
else
  # Store current directory and build http client
  pushd "${HTTP_CLIENT_DIR}"
    echo "Switching to branch ${HTTP_CLIENT_BRANCH} in google-http-java-client..."
    git checkout "${HTTP_CLIENT_BRANCH}"
    
    echo "Running maven install..."
    mvn clean install -pl google-http-client -am -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dclirr.skip=true
  popd
fi

echo "========================================================================="
echo "Building and verifying gapic-showcase with PQC in google-cloud-java..."
echo "========================================================================="

# Run the showcase tests
mvn test -pl java-showcase/gapic-showcase -Dtest=ITPqc

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

# Use JDK 17 by default for compiling and formatting (required for Spotify fmt plugin)
# If SDKMAN is installed, try using its JDK 17
if [ -d "$HOME/.sdkman/candidates/java/17.0.19-tem" ]; then
  export JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.19-tem"
elif [ -d "/usr/lib/jvm/java-17-openjdk-amd64" ]; then
  export JAVA_HOME="/usr/lib/jvm/java-17-openjdk-amd64"
fi

if [ -n "$JAVA_HOME" ]; then
  echo "Using JAVA_HOME: $JAVA_HOME"
  export PATH="$JAVA_HOME/bin:$PATH"
else
  echo "WARNING: JAVA_HOME for JDK 17 was not found. Using default java: $(java -version 2>&1 | head -n 1)"
fi

echo "========================================================================="
echo "Building and installing google-http-java-client snapshot..."
echo "Using path: ${HTTP_CLIENT_DIR}"
echo "========================================================================="

if [ ! -d "${HTTP_CLIENT_DIR}" ]; then
  echo "Error: google-http-java-client directory not found at: ${HTTP_CLIENT_DIR}"
  echo "You can specify its location by setting the HTTP_CLIENT_DIR environment variable."
  exit 1
fi

# Store current directory and build http client
pushd "${HTTP_CLIENT_DIR}"
  echo "Switching to branch ${HTTP_CLIENT_BRANCH} in google-http-java-client..."
  git checkout "${HTTP_CLIENT_BRANCH}"
  
  echo "Running maven install..."
  mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dclirr.skip=true
popd

echo "========================================================================="
echo "Building and verifying gapic-showcase with PQC in google-cloud-java..."
echo "========================================================================="

# We need Java 21+ to run the showcase tests because of Conscrypt TLS requirements,
# but if the user has custom JDK, we will respect it.
# Let's try to locate JDK 21 for showcase run if it exists, or just use the active JDK.
if [ -d "$HOME/.sdkman/candidates/java/17.0.19-tem" ]; then
  # JDK 17 also works for running show-case tests if Conscrypt loads successfully
  export JAVA_HOME="$HOME/.sdkman/candidates/java/17.0.19-tem"
elif [ -d "/usr/lib/jvm/java-21-openjdk-amd64" ]; then
  export JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
fi

if [ -n "$JAVA_HOME" ]; then
  export PATH="$JAVA_HOME/bin:$PATH"
fi

# Run the showcase tests
mvn test -pl java-showcase/gapic-showcase -Dtest=ITPqc -Dshowcase.ca.cert="${HOME}/pqc-certs/ca.crt"

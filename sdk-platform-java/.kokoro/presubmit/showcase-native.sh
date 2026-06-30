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

set -eo pipefail

## Get the directory of the build script
scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
cd "${scriptDir}/../.." # git repo root
source "$scriptDir/common.sh"

# Use GCP Maven Mirror
mkdir -p "${HOME}/.m2"
cp settings.xml "${HOME}/.m2"

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

# Run showcase integration tests in GraalVM
pushd java-showcase/gapic-showcase
SHOWCASE_VERSION=$(mvn help:evaluate -Dexpression=gapic-showcase.version -q -DforceStdout)
popd
# Start showcase server
mkdir -p /usr/src/showcase
curl \
  --location https://github.com/googleapis/gapic-showcase/releases/download/v"${SHOWCASE_VERSION}"/gapic-showcase-"${SHOWCASE_VERSION}"-linux-amd64.tar.gz \
  --output /usr/src/showcase/showcase-"${SHOWCASE_VERSION}"-linux-amd64.tar.gz
pushd /usr/src/showcase/
tar -xf showcase-*
./gapic-showcase run &
popd

# Run showcase tests with `native` profile
pushd java-showcase
mvn test -Pnative,-showcase \
  -Denforcer.skip=true \
  -Dcheckstyle.skip \
  -Dfmt.skip \
  -ntp -B \
  -Dorg.slf4j.simpleLogger.showDateTime=true \
  -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS
popd

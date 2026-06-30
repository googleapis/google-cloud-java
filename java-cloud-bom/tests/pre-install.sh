#!/usr/bin/env bash
# Copyright 2026 Google LLC
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

(
  for f in $(find . -mindepth 2 -name "pom.xml" | grep "\-bom/pom.xml" | grep -v "samples" | grep -v "/tests/" | grep -v "/resources/" | grep -v "java-cloud-bom"); do
    grep -q "<packaging>pom</packaging>" "$f" && echo "$f"
  done | sed 's|^\./||' | sed 's|/pom.xml$||'
  echo "sdk-platform-java/java-shared-dependencies"
  echo "sdk-platform-java/java-shared-dependencies/first-party-dependencies"
  echo "sdk-platform-java/java-shared-dependencies/third-party-dependencies"
  echo "sdk-platform-java/java-core"
  echo "sdk-platform-java/java-core/google-cloud-core"
  echo "sdk-platform-java/java-core/google-cloud-core-http"
  echo "sdk-platform-java/java-core/google-cloud-core-grpc"
  echo "google-auth-library-java"
  echo "grpc-gcp-java"
  for f in $(find . -maxdepth 1 -name "java-*" | grep -v "java-cloud-bom" | grep -v "java-shared-config" | grep -v "java-showcase" | grep -v "java-samples"); do
    echo "$f" | sed 's|^\./||'
  done
) | tr -d '\r' | tr '\n' ',' | sed 's/,$//' > bom_projects.txt

if ! mvn install -pl $(cat bom_projects.txt) -am -amd -DskipTests=true -Dmaven.javadoc.skip=true -Dcheckstyle.skip=true -Denforcer.skip=true -Danimal.sniffer.skip=true -Dclirr.skip=true -Dgcloud.download.skip=true -B -V -T 1C -l java-cloud-bom/tests/mvn-install.log; then
  echo "========================================================================"
  echo "mvn install failed! Printing the last 200 lines of mvn-install.log:"
  echo "========================================================================"
  tail -n 200 java-cloud-bom/tests/mvn-install.log
  exit 1
fi
rm bom_projects.txt

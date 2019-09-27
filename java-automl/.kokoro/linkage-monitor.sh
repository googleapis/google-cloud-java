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
# Display commands being run.
set -x

cd github/google-cloud-java/

# Print out Java version
java -version
echo ${JOB_TYPE}

mvn install -DskipTests=true -Dmaven.javadoc.skip=true -Dgcloud.download.skip=true -B -V

# Kokoro job cloud-opensource-java/ubuntu/linkage-monitor-gcs creates this JAR
JAR=linkage-monitor-latest-all-deps.jar
curl -v -O "https://storage.googleapis.com/cloud-opensource-java-linkage-monitor/${JAR}"

# Fails if there's new linkage errors compared with baseline
java -jar ${JAR} com.google.cloud:libraries-bom

#!/bin/bash
# Copyright 2023 Google LLC
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

scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
source "${scriptDir}/common.sh"

validate_protobuf_compatibility_script_inputs

# REPOS_UNDER_TEST Env Var accepts a comma separated list of googleapis repos to test. For Github CI,
# this will be a single repo as Github will build a matrix of repos with each repo being tested in parallel.
# For local invocation, you can pass a list of repos to test multiple repos together.
for repo in ${REPOS_UNDER_TEST//,/ }; do # Split on comma
  # Perform source-compatibility testing on main (latest changes)
  git clone "https://github.com/googleapis/$repo.git" --depth=1
  pushd "$repo"

  # Compile with Java 11 and run the tests with Java 8 JVM
  mvn compile -T 1C

  # JAVA8_HOME is set by the GH Actions CI
  if [ -n "${JAVA8_HOME}" ]; then
    surefire_opt="-Djvm=${JAVA8_HOME}/bin/java"
  else
    # Provide a default value for local executions that don't configure JAVA8_HOME
    surefire_opt="-Djvm=${JAVA_HOME}/bin/java"
  fi

  # Compile the Handwritten Library with the Protobuf-Java version to test source compatibility
  # Run unit tests to help check for any behavior differences (dependant on coverage)
  if [ "${repo}" == "google-cloud-java" ]; then
    # The `-am` command also builds anything these libraries depend on (i.e. proto-* and grpc-* sub modules)
    mvn test -B -V -ntp \
      -Dclirr.skip \
      -Denforcer.skip \
      -Dmaven.javadoc.skip \
      -Denforcer.skip \
      -Dprotobuf.version=${PROTOBUF_RUNTIME_VERSION} \
      -pl "${google_cloud_java_handwritten_maven_args}" -am \
      "${surefire_opt}" \
      -T 1C
  else
    mvn test -B -V -ntp \
      -Dclirr.skip \
      -Denforcer.skip \
      -Dmaven.javadoc.skip \
      -Denforcer.skip \
      -Dprotobuf.version=${PROTOBUF_RUNTIME_VERSION} \
      "${surefire_opt}" \
      -T 1C
  fi

  popd
done
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

monorepoRoot=$(realpath "${scriptDir}/../../..")

# Use GCP Maven Mirror from monorepo root
mkdir -p "${HOME}/.m2"
cp "${monorepoRoot}/settings.xml" "${HOME}/.m2"

# MODULES_UNDER_TEST Env Var accepts a comma separated list of monorepo submodules to test. For Github CI,
# this will be a single module as Github will build a matrix of modules with each being tested in parallel.
# For local invocation, you can pass a list of modules to test multiple modules together.
for module in ${MODULES_UNDER_TEST//,/ }; do # Split on comma
  module_dir="${monorepoRoot}/${module}"
  if [ ! -d "${module_dir}" ]; then
    echo "Directory ${module_dir} does not exist. Skipping or failed." >&2
    exit 1
  fi

  pushd "${module_dir}"

  # Compile with Java 11 and run the tests with Java 8 JVM
  mvn compile -T 1C

  declare -a test_opts=()
  # JAVA8_HOME is set by the GH Actions CI
  if [ -n "${JAVA8_HOME}" ]; then
    jvm_opt="-Djvm=${JAVA8_HOME}/bin/java"
    # Required for JDK 8 to bypass Java 11 LogbackServiceProvider and exclude JDK 11 Jqwik property tests
    test_opts=(
      "-Dslf4j.provider=org.slf4j.helpers.NOP_FallbackServiceProvider"
      "-P!jqwik-tests"
      "-Pexclude-jqwik-on-java8"
    )
  else
    # Provide a default value for local executions that don't configure JAVA8_HOME
    jvm_opt="-Djvm=${JAVA_HOME}/bin/java"
  fi

  # Compile the library with the Protobuf-Java version to test source compatibility
  # Run unit tests to help check for any behavior differences (dependant on coverage)
  mvn test -B -V -ntp \
    -Dclirr.skip \
    -Denforcer.skip \
    -Dmaven.javadoc.skip \
    -Dprotobuf.version=${PROTOBUF_RUNTIME_VERSION} \
    "${jvm_opt}" \
    "${test_opts[@]}" \
    -T 1C

  popd
done
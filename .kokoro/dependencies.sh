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
shopt -s nullglob

## Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
## cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/..

# include common functions
source ${scriptDir}/common.sh
setup_maven_mirror

# Print out Java
java -version
echo $JOB_TYPE

function determineMavenOpts() {
  local javaVersion=$(
    # filter down to the version line, then pull out the version between quotes,
    # then trim the version number down to its minimal number (removing any
    # update or suffix number).
    java -version 2>&1 | grep "version" \
      | sed -E 's/^.*"(.*?)".*$/\1/g' \
      | sed -E 's/^(1\.[0-9]\.0).*$/\1/g'
  )

  if [[ $javaVersion == 1.* ]]
    then
      echo -n "-Xmx3072m -XX:MaxPermSize=256m"
  else
      echo -n "-Xmx3072m"
  fi
}

export MAVEN_OPTS=$(determineMavenOpts)

if [[ -n "${BUILD_SUBDIR}" ]]
then
  echo "Compiling and building all modules for ${BUILD_SUBDIR}"
  install_modules "${BUILD_SUBDIR}"
  echo "Running in subdir: ${BUILD_SUBDIR}"
  pushd "${BUILD_SUBDIR}"
fi

# We use the 'test-compile' lifecycle phase (with -DskipTests=true) for the following reasons:
# 1. Why test-compile over compile? 'compile' only builds src/main/java. 'dependency:analyze'
#    inspects bytecode in both target/classes and target/test-classes. If test classes are not
#    compiled, test-scoped dependencies (such as test mocks and stubs) will be falsely flagged
#    as "Unused declared dependencies" by maven-dependency-plugin.
# 2. Why test-compile over package/install? 'package' and 'install' build and bundle JAR archives
#    and install them into ~/.m2/repository. Packaging JARs adds significant build time (5-15 mins)
#    and is unnecessary for static dependency analysis and enforcer verification. 'test-compile'
#    produces the required bytecode in target/classes and target/test-classes in seconds.
# 3. Why -DskipTests=true? Ensures test classes are compiled without executing tests during analysis.
mvn test-compile -B -V -ntp \
  -Pquick-build -DskipTests=true -Dmaven.javadoc.skip=true -Denforcer.skip=false -T 1C

mvn -B dependency:analyze -Pquick-build -DfailOnWarning=true -Dmdep.analyze.skip=false -T 1C

if [[ -n "${BUILD_SUBDIR}" ]]
then
  echo "Leaving subdir: ${BUILD_SUBDIR}"
  popd
fi

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

  if [[ $javaVersion == 17* ]]
    then
      # MaxPermSize is no longer supported as of jdk 17
      echo -n "-Xmx1024m"
  else
      echo -n "-Xmx1024m -XX:MaxPermSize=128m"
  fi
}

export MAVEN_OPTS=$(determineMavenOpts)

# this should run maven enforcer
retry_with_backoff 3 10 \
  mvn install -B -V -ntp \
    -DskipTests=true \
    -Dmaven.javadoc.skip=true \
    -Dclirr.skip=true

mvn -B dependency:analyze -DfailOnWarning=true

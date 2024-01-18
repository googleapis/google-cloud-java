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

echo "****************** DEPENDENCY LIST COMPLETENESS CHECK *******************"
## Run dependency list completeness check
function completenessCheck() {
  # Output dep list with compile scope generated using the original pom
  # Running mvn dependency:list on Java versions that support modules will also include the module of the dependency.
  # This is stripped from the output as it is not present in the flattened pom.
  # Only dependencies with 'compile' or 'runtime' scope are included from original dependency list.
  msg "Generating dependency list using original pom..."
  mvn dependency:list -f pom.xml -DincludeScope=runtime -Dsort=true | grep '\[INFO]    .*:.*:.*:.*:.*' | sed -e 's/ --.*//' >.org-list.txt

  # Output dep list generated using the flattened pom (only 'compile' and 'runtime' scopes)
  msg "Generating dependency list using flattened pom..."
  mvn dependency:list -f .flattened-pom.xml -DincludeScope=runtime -Dsort=true | grep '\[INFO]    .*:.*:.*:.*:.*' >.new-list.txt

  # Compare two dependency lists
  msg "Comparing dependency lists..."
  diff .org-list.txt .new-list.txt >.diff.txt
  if [[ $? == 0 ]]
    then
      msg "Success. No diff!"
  else
    msg "Diff found. See below: "
    msg "You can also check .diff.txt file located in $1."
    cat .diff.txt
    return 1
  fi
}

# Allow failures to continue running the script
set +e

error_count=0
for path in **/.flattened-pom.xml
do
  # Check flattened pom in each dir that contains it for completeness
  dir=$(dirname "$path")
  pushd "$dir"
  completenessCheck "$dir"
  error_count=$(($error_count + $?))
  popd
done

if [[ $error_count == 0 ]]
then
  msg "All checks passed."
  exit 0
else
  msg "Errors found. See log statements above."
  exit 1
fi

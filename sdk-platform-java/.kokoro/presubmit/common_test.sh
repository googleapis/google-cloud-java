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

scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
cd "${scriptDir}/../.." # cd to the root of this repo
source "$scriptDir/common.sh"
mkdir -p target
cd target

function test_find_all_poms_with_versioned_dependency {
  mkdir -p test_find_all_poms_with_dependency
  pushd test_find_all_poms_with_dependency
  cp ../../java-showcase/gapic-showcase/pom.xml pom.xml

  find_all_poms_with_versioned_dependency 'truth'
  if [ "${#POMS[@]}" != 1 ]; then
    echo 'find_all_poms_with_versioned_dependency did not find the expected pom'
    exit 1
  elif [ "${POMS[0]}" != './pom.xml' ]; then
    echo "find_all_poms_with_versioned_dependency found ${POMS[0]} instead of expected ./pom.xml"
    exit 1
  fi

  find_all_poms_with_versioned_dependency 'gax-grpc' # Versioned by shared-deps
  if [ "${#POMS[@]}" != 0 ]; then
    echo 'find_all_poms_with_versioned_dependency found unexpected pom'
    exit 1
  fi

  popd
}

function test_update_pom_dependency {
  mkdir -p test_update_pom_dependency
  pushd test_update_pom_dependency
  cp ../../java-showcase/gapic-showcase/pom.xml pom.xml

  update_pom_dependency . truth "99.88.77"

  xmllint --shell pom.xml &>/dev/null <<EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="truth"]
cd ../x:version
write found-version.txt
EOF
  if ! grep 99.88.77 found-version.txt &>/dev/null; then
    echo "update_pom_dependency failed to change version to expected value."
    exit 1
  fi
  rm found-version.txt
  popd
}

function test_parse_pom_version {
  mkdir -p test_parse_pom_version
  pushd test_parse_pom_version
  cp ../../java-showcase/gapic-showcase/pom.xml pom.xml

  VERSION=$(parse_pom_version .)
  if [ "$VERSION" != "0.0.1-SNAPSHOT" ]; then
    echo "parse_pom_version failed to read expected version of gapic-showcase."
  fi
  popd
}

test_find_all_poms_with_versioned_dependency
test_update_pom_dependency
test_parse_pom_version

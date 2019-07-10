#!/bin/bash
# Copyright 2019 Google Inc.
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

set -o errexit -o errtrace -o nounset -o pipefail

function errNotify() {
    echo "Error while generating conformance tests" >&2;
    echo "See generate.log for details" >&2;
    return 1
}
trap errNotify ERR

function generateFirestore() {
  rm generate.log 2> /dev/null || true

  local javaPackage="com/google/cloud/conformance/firestore/v1"

  msg "Cleaning existing generated protos"
  rm -rf src/main/java/${javaPackage}/*
  msg "Cleaning existing test definitions"
  rm -rf src/main/resources/${javaPackage}/*
  msg "Cleaning existing proto files"
  rm -rf src/main/proto/google/cloud/conformance/firestore/v1/*

  msg "Copying new proto files"
  cp -R -t src/main/proto/ conformance-tests/firestore/v1/proto/*
  msg "Copying new test definitions"
  cp -R -t "src/main/resources/${javaPackage}/" conformance-tests/firestore/v1/*.json

  msg "Generating protos"
  mvn -Pgen-conformance-protos clean verify > generate.log 2>&1

  msg "Adding copyright header to generated sources"
  ## java classes generated from protoc do not include the copyright header
  ## prepend it to the generated files
  local moduleDir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
  pushd target/generated-sources/protobuf/java/${javaPackage}
  for f in $(find ./ -type f -name '*.java'); do
    echo "Processing $f"
    mv ${f} ${f}.tmp
    cat ${moduleDir}/copyright-header.txt > ${f}
    cat ${f}.tmp >> ${f}
    rm ${f}.tmp
  done
  popd

  ## move generated proto class(es) into the main src root
  cp -R -t src/main/java/${javaPackage} target/generated-sources/protobuf/java/${javaPackage}/*

  ## cleanup any generated files that may have not been moved over
  mvn clean > /dev/null 2>&1

  msg "Building module"
  ## ensure building of the module still works
  mvn clean package

}

function main() {
  generateFirestore
}

function now { date +"%Y-%m-%d %H:%M:%S" | tr -d '\n' ;}
function msg { println "$*" >&2 ;}
function println { printf '%s\n' "$(now) $*" ;}

main

#!/bin/bash
# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -e

scripts_root=$1
templates_dir=$(realpath $(dirname "${BASH_SOURCE[0]}")/../templates/clirr)

# restore default clirr-ignored-differences.xml for protos if the file does not exist
for dir in `ls -d proto-google-*`
do
  if [ ! -f "${dir}/clirr-ignored-differences.xml" ]
  then
    tmp_dir=$(mktemp -d -t ci-XXXXXXXXXX)
    pushd ${dir}
    pushd src/main/java
    find * -name *OrBuilder.java | xargs dirname | sort -u | jq -Rns ' (inputs | rtrimstr("\n") | split("\n") ) as $data | {proto_paths: $data}' > ${tmp_dir}/paths.json
    popd
    python3 "${scripts_root}/owlbot/src/gen-template.py" --data=${tmp_dir}/paths.json --folder=${templates_dir}
    popd
  fi
done

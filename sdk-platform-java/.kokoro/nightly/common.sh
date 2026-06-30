#!/bin/bash
# Copyright 2025 Google LLC
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

# For google-cloud-java, only test specific handwritten libraries included in the monorepo. This is to
# help speed up the execution as building the entire repo is an expensive operation. Specify the nested
# `google-cloud-*` path (except for grafeas as it doesn't have one) because maven -pl will only build the
# specified folder (i.e. parent folder) and ignore all the related sub-modules inside
google_cloud_java_handwritten_maven_args="java-grafeas,java-vertexai/google-cloud-vertexai,java-resourcemanager/google-cloud-resourcemanager,java-translate/google-cloud-translate"

# Checks that the protobuf compatibility scripts provide non-empty input
function validate_protobuf_compatibility_script_inputs {
  # Comma-delimited list of repos to test
  if [ -z "${REPOS_UNDER_TEST}" ]; then
    echo "REPOS_UNDER_TEST Env Var must be set. This script expects a"
    echo "comma-delimited list: i.e REPOS_UNDER_TEST=\"java-bigtable,java-bigquery\""
    exit 1
  fi

  # A single version of Protobuf-Java runtime to test
  if [ -z "${PROTOBUF_RUNTIME_VERSION}" ]; then
    echo "PROTOBUF_RUNTIME_VERSION Env Var must be set. This script expects a single "
    echo "Protobuf-Java runtime version i.e. PROTOBUF_RUNTIME_VERSION=\"4.28.3\""
    exit 1
  fi
}
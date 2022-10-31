#
# Copyright 2022 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
set -eo pipefail

function allow_failure () {
  # store current flag state, then allow failures
  flags=$-
  set +e
  unset IFS

  command=( "$@" )
  "${command[@]}"
  exit_code=$?

  # restore "e" flag
  if [[ ${flags} =~ e ]]
  then set -e
  else set +e
  fi

  return $exit_code
}

# Find all directories starting with 'java-', sort them, then join
# with ',' as the delimiter.
function listAllModules() {
  # Ensure current directory is repo root.
  helperDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
  pushd "$helperDir/../.." >/dev/null

  ls -1 -d java-* | sort | paste -s -d, -

  popd >/dev/null
}

# Replaces '-' with '_' to get a Terraform output-friendly label
function getFriendlyOutputName() {
  echo "$1" | tr '-' _
}

# Get the output object in JSON format for the given module.
function getOutput() {
  friendlyName=$(getFriendlyOutputName "$1")
  terraform output -json "$friendlyName"
}

# Parse stdin and get the value associated with the given key.
function parseJson() {
  python3 -c "import sys, json; print(json.load(sys.stdin)['$1'])"
}

# Example use: getModuleOutput java-redis redis_network
function getModuleOutput() {
  getOutput "$1" | parseJson "$2"
}

# @returns exit code 0 if list $1 contains entry $2.
function contains() {
  echo "$1" | grep -w -q "$2"
}

# @returns a new-line delimited list of active terraform modules
function getActiveTerraformModules() {
  terraform state list | awk -F'[/.]' '{print $2}' | uniq
}

function getTerraformServiceAccountName() {
  echo "terraform-service-account"
}

function getTerraformServiceAccountEmail() {
  if [ -z "${GOOGLE_CLOUD_PROJECT}" ]; then
    echo "GOOGLE_CLOUD_PROJECT must be defined."
    exit 1
  fi
  echo "$(getTerraformServiceAccountName)@$GOOGLE_CLOUD_PROJECT.iam.gserviceaccount.com"
}

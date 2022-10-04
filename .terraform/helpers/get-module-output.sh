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

# Get the output object in JSON format for the given module.
function getOutput() {
  friendlyName=$(source ./helpers/get-output-friendly-name.sh "$1")
  terraform output -json "$friendlyName" || exit
}

# Parse stdin and get the value associated with the given key.
function parseJson() {
  python3 -c "import sys, json; print(json.load(sys.stdin)['$1'])"
}

# Example use: ./get-module-output.sh java-redis redis_network
function getModuleOutput() {
  getOutput "$1" | parseJson "$2"
}

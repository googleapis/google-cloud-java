#!/bin/bash
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

function getOutput() {
  terraform output -json java_notification || exit
}
function parseJson() {
  python3 -c "import sys, json; print(json.load(sys.stdin)['$1'])"
}

GOOGLE_STORAGE_SERVICE_AGENT=$(getOutput | parseJson storage_service_agent)
echo "Setting environment variable GOOGLE_STORAGE_SERVICE_AGENT=$GOOGLE_STORAGE_SERVICE_AGENT"
export GOOGLE_STORAGE_SERVICE_AGENT

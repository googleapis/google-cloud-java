#!/bin/bash 
# Copyright 2023 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
set -ex

function save_to_temp_then_file() {
    TEMP_FILE="$(echo mktemp)"
    # Redirect output to temporary file TEMP_FILE
    cat > $TEMP_FILE
    # Replace the original file
    mv -f $TEMP_FILE "${1}"
}


MONO_REPO_NAME="google-cloud-java"
WORKSPACE_DIR="/workspace"
PATH_TO_CONTAINER_VARS="$WORKSPACE_DIR/interContainerVars.json"

# workaround for local development (docker run -v
# path_to_monorepo:/workspace/google-cloud-java)
git config --global --add safe.directory /workspace/google-cloud-java

cd $WORKSPACE_DIR/$MONO_REPO_NAME
git checkout owlbot-bootstrapper-experiment
pyenv local 3.9.13
cd "$WORKSPACE_DIR/$MONO_REPO_NAME"

python -m pip install -r generation/new_client/requirements.txt

python generation/new_client/new-client.py generate \
  --api_shortname=telcoautomation \
  --proto-path=google/cloud/telcoautomation \
  --name-pretty="Telco Automation API" \
  --product-docs="https://cloud.google.com/telcoautomation/docs/overview" \
  --api-description="Telecom Network Automation is a Google-managed,
  cloud implementation of Nephio, a Linux Foundation open source project that
  can deliver simple, carrier-grade, Kubernetes-based, multi-cloud,
  multi-vendor, cloud-native intent automation via common automation blueprints."



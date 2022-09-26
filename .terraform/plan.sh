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

# Ensure current directory is same as script.
scriptDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
pushd "$scriptDir" >/dev/null || exit

source ./helpers/gcloud-login.sh
source ./helpers/create-project.sh

# Create a single-use project if one is not already provided via GOOGLE_CLOUD_PROJECT env var.
if [ -z "${GOOGLE_CLOUD_PROJECT+x}" ]; then
  echo "GOOGLE_CLOUD_PROJECT environment variable not set. Creating single-use project!"
  createProject
fi

# Use the project ID in gcloud set-quota-project. Clear the existing quota project directly from
# the configuration, and re-set.
gcloud config set project "$GOOGLE_CLOUD_PROJECT"
sed -i.bak '/quota_project_id/d' ~/.config/gcloud/application_default_credentials.json
gcloud auth application-default set-quota-project "$GOOGLE_CLOUD_PROJECT"

export TF_VAR_project_id=$GOOGLE_CLOUD_PROJECT
terraform plan -out generated.tfplan
terraform show -json generated.tfplan >generated.tfplan.json

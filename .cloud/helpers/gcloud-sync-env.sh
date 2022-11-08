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

if ! terraform output -json project_id &>/dev/null; then
  if ! terraform refresh &>/dev/null; then
    echo "No terraform state found."
    exit 1
  fi
  if ! terraform output -json project_id &>/dev/null; then
    echo "No project found in terraform state."
    exit 1
  fi
fi

# Ensure the gcloud project matches Terraform's current state.
terraform_project_id=$(terraform output -raw project_id)
gcloud_project_id=$(gcloud config get project) || ""
if [[ "$terraform_project_id" != "$gcloud_project_id" ]]; then
  echo -n "Do you want to make $terraform_project_id your current gcloud project? (Y/n): "
  read -r shouldSwitch
  if [[ "$shouldSwitch" == n* ]] || [[ "$shouldSwitch" == N* ]]; then
    exit
  fi
  gcloud config set project "$terraform_project_id"
fi

GOOGLE_CLOUD_PROJECT="$terraform_project_id"
export GOOGLE_CLOUD_PROJECT

source ./helpers/common.sh
GOOGLE_IMPERSONATE_SERVICE_ACCOUNT=$(getTerraformServiceAccountEmail)
export GOOGLE_IMPERSONATE_SERVICE_ACCOUNT

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

# Ensure the gcloud project matches Terraform's current state.
terraform_project_id=$(terraform output -raw project_id) || exit
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
GOOGLE_IMPERSONATE_SERVICE_ACCOUNT=$(terraform output -raw service_account)
export GOOGLE_IMPERSONATE_SERVICE_ACCOUNT

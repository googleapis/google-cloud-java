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

# Use the project ID in gcloud set-quota-project. Clear the existing quota project directly from
# the configuration, and re-set.
gcloud config set project "$GOOGLE_CLOUD_PROJECT"
sed -i.bak '/quota_project_id/d' ~/.config/gcloud/application_default_credentials.json
gcloud auth application-default set-quota-project "$GOOGLE_CLOUD_PROJECT"

# Assign permission for current gcloud account to impersonate a service account.
gcloud_account=$(gcloud config get account)
gcloud projects add-iam-policy-binding "$GOOGLE_CLOUD_PROJECT" \
  --member="user:$gcloud_account" \
  --role="roles/iam.serviceAccountTokenCreator" >/dev/null

# Set up service account for impersonation
source ./helpers/common.sh
service_account_name=$(getTerraformServiceAccountName)
service_account_email=$(getTerraformServiceAccountEmail)
# If it doesn't already exist, create the service account.
set +e
gcloud iam service-accounts describe "$service_account_email" &>/dev/null
if [[ $? -ne 0 ]]; then
  gcloud iam service-accounts create "$service_account_name"
  createdServiceAccount=true
else
  createdServiceAccount=false
fi
set -e

# Assign permissions to the service account.
gcloud projects add-iam-policy-binding "$GOOGLE_CLOUD_PROJECT" \
  --member="serviceAccount:$service_account_email" \
  --role="roles/owner" >/dev/null
gcloud projects add-iam-policy-binding "$GOOGLE_CLOUD_PROJECT" \
  --member="serviceAccount:$service_account_email" \
  --role="roles/resourcemanager.projectIamAdmin" >/dev/null

# See https://cloud.google.com/blog/topics/developers-practitioners/using-google-cloud-service-account-impersonation-your-terraform-code
export GOOGLE_IMPERSONATE_SERVICE_ACCOUNT=$service_account_email

if $createdServiceAccount; then
  echo "Waiting 2m for service account permissions to take effect... [0s elapsed]"
  sleep 30
  echo "Waiting 2m for service account permissions to take effect... [30s elapsed]"
  sleep 30
  echo "Waiting 2m for service account permissions to take effect... [1m0s elapsed]"
  sleep 30
  echo "Waiting 2m for service account permissions to take effect... [1m30s elapsed]"
  sleep 30
fi

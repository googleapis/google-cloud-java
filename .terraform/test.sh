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

#####################
# This script uses the Terraform configurations found in the submodules
# of this repository to provision a given GCP project with the correct
# resources, perform integration testing, and then destroying the used
# resources.
#
# Expected Environment Variables:
#   GOOGLE_CLOUD_PROJECT :
#     If defined, no GCP project will be created or destroyed.
#     If not defined, a GCP project will be created for single-use, then destroyed.
#
#   If GOOGLE_CLOUD_PROJECT is not defined, the following environment variables
#   are used. If not available, their values will be requested by prompt:
#     TF_VAR_folder_id : Folder in which new GCP projects will be created
#     TF_VAR_billing_account : Billing account to be used for created GCP projects
#     TF_VAR_project_prefix : Prefix to use for all created GCP projects
#
#####################
# Single Module Usage:
# ./.terraform/test.sh <module> :: Tests only the given module
#   ex: ./.terraform/test.sh java-accessapproval
#
# All Module Usage:
# ./.terraform/test.sh :: Tests all modules in modules-under-test.txt

# Ensure current directory is root repo folder
scriptDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
cd "$scriptDir/.." || exit

source ./.terraform/helpers/gcloud-login.sh
source ./.terraform/helpers/create-project.sh
source ./.terraform/helpers/test-module.sh

# Create a single-use project if one is not already provided via GOOGLE_CLOUD_PROJECT env var.
if [ -z "${GOOGLE_CLOUD_PROJECT+x}" ]; then
  echo "GOOGLE_CLOUD_PROJECT environment variable not set. Creating single-use project!"
  createProject
  createdProject=true
else
  createdProject=false
fi

# Use the project ID in gcloud set-quota-project. Clear the existing quota project directly from
# the configuration, and re-set.
gcloud config set project "$GOOGLE_CLOUD_PROJECT"
sed -i.bak '/quota_project_id/d' ~/.config/gcloud/application_default_credentials.json
gcloud auth application-default set-quota-project "$GOOGLE_CLOUD_PROJECT"

if [ -n "$1" ]; then
  # If shell script given a specific module as its argument
  performTest "$1"
else
  # Otherwise, iterate through the list found in modules-under-test.txt
  while IFS= read -r module; do
    # Ignore lines starting with '#'
    [[ "$module" =~ ^#.* ]] && continue

    performTest "$module"
  done <"./.terraform/modules-under-test.txt"
fi

if [ $createdProject ]; then
  echo "Destroying single-use project $GOOGLE_CLOUD_PROJECT created at start."
  destroyProject
  export -n GOOGLE_CLOUD_PROJECT
fi

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
# This script uses the Terraform configurations found in the subprojects
# of this repository to provision a given GCP project with the correct
# resources, perform integration testing, and then destroying the used
# resources.
#
# Expected Environment Variables:
#   TF_VAR_folder_id : Folder in which new GCP projects will be created
#   TF_VAR_billing_account : Billing account to be used for created projects
#   TF_VAR_project_prefix : Prefix to use for all created GCP projects
#####################
# Single Module Usage:
# ./.terraform/test.sh <project> :: Tests only the given project
#   ex: ./.terraform/test.sh java-accessapproval
#
# All Project Usage:
# ./.terraform/test.sh :: Tests all projects in projects.txt

function performTest() {
  # Provision project with configuration found in './<proj>/.terraform' directory
  pushd ./"$1"/.terraform || exit
  terraform init || exit
  terraform plan || exit
  terraform apply -auto-approve || exit

  # Use the project ID created by Terraform to set env and gcloud set-quota-project
  GOOGLE_CLOUD_PROJECT=$(terraform output -raw project_id)
  export GOOGLE_CLOUD_PROJECT
  gcloud config set project "$GOOGLE_CLOUD_PROJECT"

  # Set module-specific environment variables for upcoming integration test(s)
  if [[ -f "./env.sh" ]]; then
    source "./env.sh"
  fi

  # Perform integration testing
  pushd ../ || exit
  mvn -B ${INTEGRATION_TEST_ARGS} \
    -ntp \
    -Penable-integration-tests \
    -DtrimStackTrace=false \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dcheckstyle.skip=true \
    -fae \
    verify

  exit_code=$?
  popd || exit

  # Clean up provisioned resources regardless of exit code
  terraform destroy -auto-approve || exit
  popd || exit

  # Stop execution if integration test failed
  if [[ $exit_code != 0 ]]; then
    echo "Execution stopped with error in $1"
    exit
  fi
}

# Ensure required environment variables are set.
if [ -z "${TF_VAR_folder_id+x}" ]; then
  echo -n "Which GCP folder should be used when creating new GCP projects? Set TF_VAR_folder_id environment variable: "
  read -r folder_id
  export TF_VAR_folder_id="${folder_id}"
fi
if [ -z "${TF_VAR_billing_account+x}" ]; then
  echo -n "Which GCP billing account should be assigned to created GCP projects? Set TF_VAR_billing_account environment variable: "
  read -r billing_acct
  export TF_VAR_billing_account="${billing_acct}"
fi
if [ -z "${TF_VAR_project_prefix+x}" ]; then
  echo -n "What should be the project prefix for any created GCP project? Set TF_VAR_project_prefix environment variable: "
  read -r prefix
  export TF_VAR_project_prefix="${prefix}"
fi

# Perform gcloud auth login if no current credentials are available.
if gcloud auth application-default print-access-token &>/dev/null; then
  true
else
  if ! gcloud auth application-default login; then
    exit
  fi
fi
if gcloud auth print-access-token &>/dev/null; then
  true
else
  if ! gcloud auth login; then
    exit
  fi
fi

# Ensure current directory is root repo folder
scriptDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
cd "$scriptDir/.." || exit

if [ -n "$1" ]; then
  # If shell script given a specific project as its argument
  performTest "$1"
else
  # Otherwise, iterate through the list found in projects.txt
  projects="./.terraform/projects.txt"
  while IFS= read -r project; do
    # Ignore lines starting with '#'
    [[ "$project" =~ ^#.* ]] && continue

    performTest "$project"
  done <"$projects"
fi

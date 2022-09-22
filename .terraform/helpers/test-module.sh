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

function performTest() {
  if [ -z "${GOOGLE_CLOUD_PROJECT+x}" ]; then
    echo "Error: GOOGLE_CLOUD_PROJECT environment variable not set."
    exit
  fi

  # Provision resources for module with configuration found in './<module>/.terraform' directory
  pushd ./"$1"/.terraform || exit
  terraform init || exit
  terraform plan -var="project_id=$GOOGLE_CLOUD_PROJECT" || exit
  terraform apply -auto-approve -var="project_id=$GOOGLE_CLOUD_PROJECT" || exit

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
  if [[ -f "./predestroy.sh" ]]; then
    source "./predestroy.sh"
  fi
  terraform destroy -auto-approve -var="project_id=$GOOGLE_CLOUD_PROJECT" || exit
  popd || exit

  # Stop execution if integration test failed
  if [[ $exit_code != 0 ]]; then
    echo "Execution stopped with error in $1"
    exit
  fi
}

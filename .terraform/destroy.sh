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

scriptDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
pushd "$scriptDir" >/dev/null || exit

# Ensure GCP project environment variables are initialized.
if [[ $(terraform state list) == "" ]]; then
  echo "Nothing to destroy."
  exit
fi

# @returns exit code 0 if list $1 contains entry $2.
function contains() {
  echo "$1" | grep -w -q "$2"
}

source ./helpers/sync-env.sh

# Execute 'predestroy.sh' scripts for any active modules
allModules=$(source ./helpers/list-all-modules.sh)
activeModules=$(terraform state list | awk -F'[/.]' '{print $2}' | uniq)
IFS=':'
for module in $allModules; do
  friendlyName=$(source ./helpers/get-output-friendly-name.sh "$module")
  if ! contains "$activeModules" "$friendlyName"; then
    continue # Skip unless active.
  fi

  if [[ -f "../$module/.terraform/predestroy.sh" ]]; then
    # shellcheck disable=SC1090
    source "../$module/.terraform/predestroy.sh"
  fi
done

terraform destroy -auto-approve || exit

# Always verify whether or not to destroy the project.
echo -n "Delete project ($terraform_project_id)? (y/N): "
read -r shouldDestroy
if [[ "$shouldDestroy" == y* ]] || [[ "$shouldDestroy" == Y* ]]; then
  # Do not use service account when attempting to delete the project
  unset GOOGLE_IMPERSONATE_SERVICE_ACCOUNT

  source ./helpers/create-project.sh
  deleteProject
  rm ./generated.auto.tfvars
fi

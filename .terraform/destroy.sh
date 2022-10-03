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

source ./helpers/sync-env.sh

# Either use given module list, or get a list of all modules in the parent directory.
# TODO: Gather module list from terraform state.
if [ -n "$1" ] && [[ $1 != "y" ]]; then
  modules=$1
else
  modules=$(source ./helpers/list-all-modules.sh)
fi

# Execute 'predestroy.sh' scripts for any active modules
IFS=':'
for module in $modules; do
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

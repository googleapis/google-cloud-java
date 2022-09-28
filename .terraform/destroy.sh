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

pushd "$scriptDir/modules/create-project" >/dev/null || exit

# Ensure GCP project environment variables are initialized.
if [[ -z "${TF_VAR_project_id+x}" ]]; then
  if [[ -z "${GOOGLE_CLOUD_PROJECT+x}" ]]; then
    if [[ $(terraform state list) == "" ]]; then
      echo "Terraform is not currently managing a GCP project resource, and GOOGLE_CLOUD_PROJECT is not defined."
      exit 1
    fi

    GOOGLE_CLOUD_PROJECT=$(terraform output -raw project_id)
    export GOOGLE_CLOUD_PROJECT
  fi
  export TF_VAR_project_id=$GOOGLE_CLOUD_PROJECT
fi

# Always verify whether or not to destroy the project.
if [[ $(terraform state list) != "" ]]; then
  if [[ $1 == "y" ]]; then
    shouldDestroy="y"
  else
    echo "Destroy project? (y/N): "
    read -r shouldDestroy
  fi

  if [[ "$shouldDestroy" == y* ]] || [[ "$shouldDestroy" == Y* ]]; then
    source ../../helpers/create-project.sh
    destroyProject
    exit 0
    # If we've destroyed the project, exit early.
  fi
fi

popd >/dev/null || exit
pushd "$scriptDir" >/dev/null || exit

# Either use given module list, or get a list of all modules in the parent directory.
if [ -n "$1" ] && [[ $1 != "y" ]]; then
  modules=$1
else
  modules=$(source ./helpers/list-all-modules.sh)
fi

# Execute 'predestroy.sh' scripts for any active modules
IFS=':'
for module in $modules; do
  if [ -f "../$module/.terraform/predestroy.sh" ]; then
    pushd "../$module/.terraform" >/dev/null || exit
    source "./predestroy.sh" &>/dev/null &
    popd >/dev/null || exit
  fi
done

terraform destroy -auto-approve || exit

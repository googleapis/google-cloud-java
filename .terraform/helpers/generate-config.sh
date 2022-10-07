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

function initializeGeneratedFiles() {
  cp ./helpers/generated-main.template.tf generated-main.tf
  cp ./helpers/generated-outputs.template.tf generated-outputs.tf
  cp ./helpers/generated-variables.template.tf generated-variables.tf
}

function appendModule() {
  friendlyName=$(getFriendlyOutputName "$1")

  # Append the given module to the generated-main.tf configuration to be
  # included in the project's resources during 'terraform apply'.
  echo "module \"$friendlyName\" {
    source = \"./../$1/.terraform\"
    inputs = local.data
    depends_on = [time_sleep.for_1m_allowBaseCloudApisToFullyEnable]
  }" >>generated-main.tf

  # Append the given module to the generated-output.tf file to provide
  # all of this module's outputs as an object.
  # See https://www.terraform.io/cli/commands/output
  echo "output \"$friendlyName\" {
    value = module.$friendlyName
    sensitive = true
  }" >>generated-outputs.tf
}

function appendAllModules() {
  # Either use given module list, or get a list of all modules in the parent directory.
  if [ -n "$1" ]; then
    modules=$1
  else
    modules=$(listAllModules)
  fi
  IFS=','
  for module in $modules; do
    # Only include modules with a .terraform subdirectory in the generated config.
    if [ -d "../$module/.terraform" ]; then
      appendModule "${module%/}" # Remove possible trailing '/'
    fi
  done
}

# Ensure current directory is <root>/.terraform.
generateDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
pushd "$generateDir/.." >/dev/null || exit

source ./helpers/common.sh
initializeGeneratedFiles
appendAllModules "$1"

popd >/dev/null || exit

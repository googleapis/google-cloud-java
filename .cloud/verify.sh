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
scriptDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"

# Prepare the environment
pushd "$scriptDir" >/dev/null
source ./helpers/gcloud-sync-env.sh
source ./helpers/populate-env.sh
popd >/dev/null

# Perform integration testing using Kokoro's mvn syntax.
pushd "$scriptDir/.." >/dev/null
source ./.kokoro/common.sh
if [ -n "$1" ]; then
  # If given a specific module list, only perform integration tests on those.
  run_integration_tests "$1"
else
  # If not given an argument list, integration test the parent project.
  run_integration_tests -:google-cloud-os-login,-:google-cloud-recommender,-:google-cloud-talent
fi
popd >/dev/null

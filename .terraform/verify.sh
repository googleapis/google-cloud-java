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

function mvnVerify() {
  mvn "$@" \
    ${INTEGRATION_TEST_ARGS} \
    -T 1C \
    -B \
    -ntp \
    -Penable-integration-tests \
    -DtrimStackTrace=false \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dcheckstyle.skip=true \
    -fae \
    verify || exit

  # TODO: Add multiple threads w/ -T 1C
}

function testSingle() {
  # Set module-specific environment variables for upcoming integration test(s)
  if [[ -f "../$1/.terraform/env.sh" ]]; then
    # shellcheck disable=SC1090
    source "../$1/.terraform/env.sh"
  fi
  pushd "../$1" >/dev/null || exit
  mvnVerify
  popd >/dev/null || exit
}

function testAll() {
  # Execute 'env.sh' scripts for any active modules
  IFS=':'
  for module in $(source ./helpers/list-all-modules.sh); do
    if [ -f "../$module/.terraform/env.sh" ]; then
      # shellcheck disable=SC1090
      source "../$module/.terraform/env.sh"
    fi
  done

  # Perform mvn verify on parent project, excluding the given submodules
  pushd "../" >/dev/null || exit
  mvnVerify -pl -java-os-login,-java-recommender,-java-scheduler,-java-talent
  popd >/dev/null || exit
}

# Ensure current directory is script directory.
scriptDir="$(cd -P -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd -P)"
pushd "$scriptDir" >/dev/null || exit

if [ -n "$1" ]; then
  # If given a specific module list, only perform integration tests on those.
  IFS=':'
  for module in $1; do
    testSingle "$module" &
  done
  wait
else
  # If not given an argument list, integration test the parent project.
  testAll
fi

popd >/dev/null || exit

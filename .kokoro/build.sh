#!/bin/bash
# Copyright 2019 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eo pipefail

## Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
## cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/..

# include common functions
source ${scriptDir}/common.sh

# Use GCP Maven Mirror
mkdir -p ${HOME}/.m2
cp settings.xml ${HOME}/.m2

# if GOOGLE_APPLICATION_CREDENTIALS is specified as a relative path, prepend Kokoro root directory onto it
if [[ ! -z "${GOOGLE_APPLICATION_CREDENTIALS}" && "${GOOGLE_APPLICATION_CREDENTIALS}" != /* ]]; then
  export GOOGLE_APPLICATION_CREDENTIALS=$(realpath ${KOKORO_GFILE_DIR}/${GOOGLE_APPLICATION_CREDENTIALS})
fi

if [ -f "${KOKORO_GFILE_DIR}/secret_manager/java-bigqueryconnection-samples-secrets" ]; then
  source "${KOKORO_GFILE_DIR}/secret_manager/java-bigqueryconnection-samples-secrets"
fi

RETURN_CODE=0

case ${JOB_TYPE} in
  integration)
    generate_modified_modules_list
    if [[ ${#modified_module_list[@]} -gt 0 ]]; then
      # Combine each entry with a comma
      module_list=$(
        IFS=,
        echo "${modified_module_list[*]}"
      )
      install_modules
      printf "Running Integration Tests for:\n%s\n" "${module_list}"
      mvn -B ${INTEGRATION_TEST_ARGS} \
        -pl "${module_list},!CoverageAggregator" \
        -amd \
        -ntp \
        -Penable-integration-tests \
        -DtrimStackTrace=false \
        -Dclirr.skip=true \
        -Denforcer.skip=true \
        -Dcheckstyle.skip=true \
        -Dflatten.skip=true \
        -Danimal.sniffer.skip=true \
        -Djacoco.skip=true \
        -DskipUnitTests=true \
        -fae \
        -T 1C \
        verify
      RETURN_CODE=$?
      printf "Finished Integration Tests for:\n%s\n" "${module_list}"
    else
      echo "No Integration Tests to run"
    fi
    ;;
  graalvm)
    generate_graalvm_modules_list
    install_modules
    run_graalvm_tests
    ;;
  graalvm17)
    generate_graalvm_modules_list
    install_modules
    run_graalvm_tests
    ;;
  samples)
    mvn -B \
      -ntp \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dcheckstyle.skip=true \
      -Dflatten.skip=true \
      -Danimal.sniffer.skip=true \
      -DskipTests=true \
      -Djacoco.skip=true \
      -T 1C \
      install

    SAMPLES_DIR=samples
    # only run ITs in snapshot/ on presubmit PRs. run ITs in all 3 samples/ submodules otherwise.
    if [[ ! -z ${KOKORO_GITHUB_PULL_REQUEST_NUMBER} ]]; then
      SAMPLES_DIR=samples/snapshot
    fi

    if [[ -f ${SAMPLES_DIR}/pom.xml ]]; then
      for FILE in ${KOKORO_GFILE_DIR}/secret_manager/*-samples-secrets; do
        [[ -f "$FILE" ]] || continue
        source "$FILE"
      done

      pushd ${SAMPLES_DIR}
      mvn -B \
        -ntp \
        -DtrimStackTrace=false \
        -Dclirr.skip=true \
        -fae \
        verify
      RETURN_CODE=$?
      popd
    else
      echo "no sample pom.xml found - skipping sample tests"
    fi
    ;;
  *) ;;

esac

if [ "${REPORT_COVERAGE}" == "true" ]; then
  bash ${KOKORO_GFILE_DIR}/codecov.sh
fi

# fix output location of logs
bash .kokoro/coerce_logs.sh

if [[ "${ENABLE_FLAKYBOT}" == "true" ]]; then
  chmod +x ${KOKORO_GFILE_DIR}/linux_amd64/flakybot
  ${KOKORO_GFILE_DIR}/linux_amd64/flakybot -repo=googleapis/google-cloud-java
fi

echo "exiting with ${RETURN_CODE}"
exit ${RETURN_CODE}

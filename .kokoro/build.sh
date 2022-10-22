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
  test)
    retry_with_backoff 3 10 \
      mvn -B -ntp \
        -Dclirr.skip=true \
        -Denforcer.skip=true \
        -Dcheckstyle.skip=true \
        -Dflatten.skip=true \
        -Danimal.sniffer.skip=true \
        -Dmaven.wagon.http.retryHandler.count=5 \
        -T 1C \
        test
    RETURN_CODE=$?
    echo "Finished running unit tests"
    ;;
  integration)
    generate_modified_modules_list
    if [[ ${#modified_module_list[@]} -gt 0 ]]; then
      module_list=$(
        IFS=,
        echo "${modified_module_list[*]}"
      )
      install_modules
      printf "Running Integration Tests for:\n%s\n" "${module_list}"
      mvn -B ${INTEGRATION_TEST_ARGS} \
        -pl "${module_list}" \
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
        -Dmaven.wagon.http.retryHandler.count=5 \
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
    if [ ! -z "${module_list}" ]; then
      printf "Running GraalVM checks for:\n%s\n" "${module_list}"
      install_modules
      run_graalvm_tests
    else
      echo "Not running GraalVM checks -- No changes in relevant modules"
    fi
    ;;
  graalvm17)
    generate_graalvm_modules_list
    if [ ! -z "${module_list}" ]; then
      printf "Running GraalVM 17 checks for:\n%s\n" "${module_list}"
      install_modules
      run_graalvm_tests
    else
      echo "Not running GraalVM 17 checks -- No changes in relevant modules"
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

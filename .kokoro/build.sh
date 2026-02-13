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

setup_application_credentials

if [ -f "${KOKORO_GFILE_DIR}/secret_manager/java-bigqueryconnection-samples-secrets" ]; then
  source "${KOKORO_GFILE_DIR}/secret_manager/java-bigqueryconnection-samples-secrets"
fi

env

RETURN_CODE=0

case ${JOB_TYPE} in
  test)
    if [[ -n "${BUILD_SUBDIR}" ]]
    then
      echo "Compiling and building all modules for ${BUILD_SUBDIR}"
      install_modules "${BUILD_SUBDIR}"
      echo "Running in subdir: ${BUILD_SUBDIR}"
      pushd "${BUILD_SUBDIR}"
    fi
    echo "SUREFIRE_JVM_OPT: ${SUREFIRE_JVM_OPT}"
    retry_with_backoff 3 10 \
      mvn test \
        -B -ntp \
        -Dorg.slf4j.simpleLogger.showDateTime=true \
        -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
        -Dclirr.skip=true \
        -Denforcer.skip=true \
        -Dcheckstyle.skip=true \
        -Dflatten.skip=true \
        -Danimal.sniffer.skip=true \
        -Dmaven.wagon.http.retryHandler.count=5 \
        -T 1C ${SUREFIRE_JVM_OPT}
    RETURN_CODE=$?

    if [[ -n "${BUILD_SUBDIR}" ]]
    then
      echo "restoring directory"
      popd
    fi
    echo "Finished running unit tests"
    ;;
  integration)
    generate_modified_modules_list
    if [[ "$(release_please_snapshot_pull_request)" == "true" ]]; then
      echo "Skipping integration tests as this is Release Please SNAPSHOT pull request."
    elif [[ ${#modified_module_list[@]} -gt 0 ]]; then
      module_list=$(
        IFS=,
        echo "${modified_module_list[*]}"
      )
      setup_cloud "$module_list"
      install_modules "$module_list"
      run_integration_tests "$module_list"
    else
      echo "No Integration Tests to run"
    fi
    ;;
  integration-single)
    generate_modified_modules_list false
    if [[ "$(release_please_snapshot_pull_request)" == "true" ]]; then
      echo "Not running integration checks -- this is Release Please SNAPSHOT pull request."
    elif [[ ! " ${modified_module_list[*]} " =~ " ${BUILD_SUBDIR} " ]]; then
      echo "${BUILD_SUBDIR} not modified, skipping split integration test"
    else
      echo "${BUILD_SUBDIR} modified, running split integration test"
      echo "Compiling and building all modules for ${BUILD_SUBDIR}"
      install_modules "${BUILD_SUBDIR}"
      echo "Running in subdir: ${BUILD_SUBDIR}"
      pushd "${BUILD_SUBDIR}"
      echo "SUREFIRE_JVM_OPT: ${SUREFIRE_JVM_OPT}"
      echo "INTEGRATION_TEST_ARGS: ${INTEGRATION_TEST_ARGS}"
      mvn verify -Penable-integration-tests \
        ${INTEGRATION_TEST_ARGS} \
        -B -ntp -fae \
        -DtrimStackTrace=false \
        -Dclirr.skip=true \
        -Denforcer.skip=true \
        -Dorg.slf4j.simpleLogger.showDateTime=true \
        -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
        -Dcheckstyle.skip=true \
        -Dflatten.skip=true \
        -Danimal.sniffer.skip=true \
        -Djacoco.skip=true \
        -DskipUnitTests=true \
        -Dmaven.wagon.http.retryHandler.count=5 \
        -T 1C ${SUREFIRE_JVM_OPT}

      RETURN_CODE=$?
      popd
      printf "Finished integration tests for modules:\n%s\n" "${BUILD_SUBDIR}"
    fi
    ;;
  graalvm-presubmit)
    generate_graalvm_presubmit_modules_list
    if [[ "$(release_please_snapshot_pull_request)" == "true" ]]; then
      echo "Not running GraalVM checks -- this is Release Please SNAPSHOT pull request."
    else
      printf "Running GraalVM presubmit checks for:\n%s\n" "${module_list}"
      setup_cloud "$module_list"
      install_modules "$module_list"
      run_graalvm_tests "$module_list"
    fi
    ;;
  graalvm)
    generate_graalvm_modules_list
    if [[ "$(release_please_snapshot_pull_request)" == "true" ]]; then
      echo "Not running GraalVM checks -- this is Release Please SNAPSHOT pull request."
    elif [ ! -z "${module_list}" ]; then
      printf "Running GraalVM checks for:\n%s\n" "${module_list}"
      setup_cloud "$module_list"
      install_modules "$module_list"
      run_graalvm_tests "$module_list"
    else
      echo "Not running GraalVM checks -- No changes in relevant modules"
    fi
    ;;
  graalvm-single)
    generate_modified_modules_list false    
    if [[ "$(release_please_snapshot_pull_request)" == "true" ]]; then
      echo "Not running GraalVM checks -- this is Release Please SNAPSHOT pull request."
    elif [[ ! " ${modified_module_list[*]} " =~ " ${BUILD_SUBDIR} " ]]; then
      echo "${BUILD_SUBDIR} not modified, skipping split GraalVM test"
    else
      echo "${BUILD_SUBDIR} modified, running split GraalVM test"
      echo "Compiling and building all modules for ${BUILD_SUBDIR}"
      install_modules "${BUILD_SUBDIR}"
      echo "Running in subdir: ${BUILD_SUBDIR}"
      pushd "${BUILD_SUBDIR}"
      echo "INTEGRATION_TEST_ARGS: ${INTEGRATION_TEST_ARGS}"
      mvn test -Pnative \
        ${INTEGRATION_TEST_ARGS} \
        -B -ntp -fae \
        -DtrimStackTrace=false \
        -Dclirr.skip=true \
        -Denforcer.skip=true \
        -Dorg.slf4j.simpleLogger.showDateTime=true \
        -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
        -Dcheckstyle.skip=true \
        -Dflatten.skip=true \
        -Danimal.sniffer.skip=true

      RETURN_CODE=$?
      popd
      printf "Finished GraalVM ITs for modules:\n%s\n" "${BUILD_SUBDIR}"
    fi
    ;;
  lint)
    if [[ -n "${BUILD_SUBDIR}" ]]
    then
      echo "Compiling and building all modules for ${BUILD_SUBDIR}"
      install_modules "${BUILD_SUBDIR}"
      echo "Running in subdir: ${BUILD_SUBDIR}"
      pushd "${BUILD_SUBDIR}"
    fi
    if [ -n "${BASE_SHA}" ] && [ -n "${HEAD_SHA}" ]; then
        changed_file_list=$(git diff --name-only "${BASE_SHA}" "${HEAD_SHA}")
        echo "${changed_file_list}"
        
        has_code_change="false"
        
        while IFS= read -r changed_file; do
            # Checks if the line is not empty AND if it matches a .java file
            if [ -n "${changed_file}" ] && [[ "${changed_file}" == *.java ]]; then
                echo "Matched: ${changed_file}"
                has_code_change="true"
                break
            fi
        done <<< "${changed_file_list}"
        
        if [ "${has_code_change}" == "false" ]; then
            echo "No java modules affected. Skipping linter check."
            exit 0
        fi
    else
        echo "BASE_SHA or HEAD_SHA is empty. Skipping file difference check."
    fi
    
    mvn -B -ntp \
      -T 1.5C \
      com.spotify.fmt:fmt-maven-plugin:check
    mvn -B -ntp checkstyle:check@checkstyle

    if [[ -n "${BUILD_SUBDIR}" ]]
    then
      echo "restoring directory"
      popd
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

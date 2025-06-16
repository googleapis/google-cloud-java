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

RETURN_CODE=0

case ${JOB_TYPE} in
  test)
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
        -T 1C
    RETURN_CODE=$?
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
  lint)
    git checkout "${BASE_BRANCH}"
    git checkout "${HEAD_BRANCH}"
    changed_file_list="$(git diff --name-only "${BASE_BRANCH}" HEAD)"
    declare -A java_modules_map
    java_modules=""
    while IFS= read -r changed_file; do
        if [ -n "${changed_file}" ] && [[ "${changed_file}" == *.java ]]; then
            echo "Processing file: ${changed_file}"
            first_dir=$(echo "${changed_file}" | cut -d '/' -f1)
            if [[ "${first_dir}" == java-* ]]; then
                if [ -z "${java_modules_map[${first_dir}]}" ]; then
                    java_modules_map["${first_dir}"]=1
                    echo "Found new Java module: ${first_dir}"
                    java_modules="${java_modules}.*${first_dir}/.*|"
                fi
            fi
        fi
    done <<< "${changed_file_list}"
    if [ "${java_modules}" == "" ]; then
        printf "No java modules affected."
        exit 0
    fi
    # Remove the tailing "|"
    java_modules="${java_modules%|}"
    java_modules="(${java_modules})"
    printf "Running linter checks against \n%s\n" "${java_modules}"
    mvn -B -ntp \
      com.spotify.fmt:fmt-maven-plugin:check \
      -T 1.5C \
      -DfilesNamePattern="${java_modules}"
    mvn -B -ntp checkstyle:check@checkstyle
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

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

function assign_modules_to_job() {
  modules=$(mvn help:evaluate -Dexpression=project.modules | grep '<.*>.*</.*>' | sed -e 's/<.*>\(.*\)<\/.*>/\1/g')
  module_list=()
  num=0
  for module in $modules
  do
    # Add 1 as JOB_NUMBER is 1-indexed instead of 0-indexed
    mod_num=$((num % NUM_JOBS + 1))
    if [[ ! "${excluded_modules[*]}" =~ $module ]] && [[ $mod_num -eq $JOB_NUMBER ]]; then
      module_list+=($module)
    fi
    num=$((num + 1))
  done
  module_list=$(IFS=, ; echo "${module_list[*]}")
}

excluded_modules=('CoverageAggregator' 'google-cloud-gapic-bom')

mvn -B -pl "!google-cloud-gapic-bom,!CoverageAggregator" \
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
    mvn test -B -ntp -Dclirr.skip=true -Denforcer.skip=true
    RETURN_CODE=$?
    ;;
  lint)
    mvn com.coveo:fmt-maven-plugin:check -B -ntp
    RETURN_CODE=$?
    ;;
  javadoc)
    mvn javadoc:javadoc javadoc:test-javadoc -B -ntp
    RETURN_CODE=$?
    ;;
  integration)
    TEST_ALL=false
    # Find the files changed from when the PR branched to the last commit
    # Filter for java modules and get all the unique elements
    # grep returns 1 (error code) and exits the pipeline if there is no match
    # If there is no match, it will return true so the rest of the commands can run
    modified_files=$(git diff --name-only $KOKORO_GITHUB_PULL_REQUEST_COMMIT $KOKORO_GITHUB_PULL_REQUEST_TARGET_BRANCH)
    printf "Modified files:\n%s\n" "${modified_files}"

    # If root pom.xml is touched, run ITs on all the modules
    root_pom_modified=$(echo "${modified_files}" | grep -e '^pom.xml$' || true)
    if [[ -n $root_pom_modified ]]; then
      TEST_ALL=true
      echo "Testing the entire monorepo"
    else
      directories=$(echo "${modified_files}" | grep -e 'java-.*' || true)
      printf "Files in java modules:\n%s\n" "${directories}"
      if [[ -n $directories ]]; then
        directories=$(echo "${directories}" | cut -d '/' -f1 | sort -u)
        dir_list=()
        for directory in $directories
        do
          dir_list+=($directory)
        done
        # Combine each entry with a comma
        module_list=$(IFS=, ; echo "${dir_list[*]}")
      fi
      printf "Module List:\n%s\n" "${module_list}"
    fi

    if [ ${TEST_ALL} ]; then
      mvn -B ${INTEGRATION_TEST_ARGS} \
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
    elif [[ -n $module_list ]]; then
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
    assign_modules_to_job
    printf "Running GraalVM Native ITs on:\n%s\n" "${module_list[*]}"

    # Run Unit and Integration Tests with Native Image
    if [[ -n $module_list ]]; then
      mvn -B ${INTEGRATION_TEST_ARGS} \
          -pl "${module_list}" \
          -amd \
          -ntp \
          -DtrimStackTrace=false \
          -Dclirr.skip=true \
          -Denforcer.skip=true \
          -Dcheckstyle.skip=true \
          -Dflatten.skip=true \
          -Danimal.sniffer.skip=true \
          -Penable-integration-tests \
          -Pnative \
          -fae \
          verify
      RETURN_CODE=$?
      printf "Finished Unit and Integration Tests for GraalVM Native:\n%s\n" "${module_list}"
    else
      echo "No Unit and Integration Tests to run for GraalVM Native"
    fi
    ;;
  graalvm17)
    assign_modules_to_job
    printf "Running GraalVM Native-17 ITs on:\n%s\n" "${module_list[*]}"

    # Run Unit and Integration Tests with Native Image
    if [[ -n $module_list ]]; then
      mvn -B ${INTEGRATION_TEST_ARGS} \
          -pl "${module_list}" \
          -amd \
          -ntp \
          -DtrimStackTrace=false \
          -Dclirr.skip=true \
          -Denforcer.skip=true \
          -Dcheckstyle.skip=true \
          -Dflatten.skip=true \
          -Danimal.sniffer.skip=true \
          -Penable-integration-tests \
          -Pnative \
          -fae \
          verify
      RETURN_CODE=$?
      printf "Finished Unit and Integration Tests for GraalVM Native 17:\n%s\n" "${module_list}"
    else
      echo "No Unit and Integration Tests to run for GraalVM Native 17"
    fi
    ;;
  samples)
    SAMPLES_DIR=samples
    # only run ITs in snapshot/ on presubmit PRs. run ITs in all 3 samples/ subdirectories otherwise.
    if [[ ! -z ${KOKORO_GITHUB_PULL_REQUEST_NUMBER} ]]
    then
      SAMPLES_DIR=samples/snapshot
    fi

    if [[ -f ${SAMPLES_DIR}/pom.xml ]]
    then
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
  clirr)
    mvn -B -ntp -Denforcer.skip=true clirr:check
    RETURN_CODE=$?
    ;;
  *)
    ;;
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

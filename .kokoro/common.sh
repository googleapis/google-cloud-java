#!/bin/bash
# Copyright 2020 Google LLC
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

excluded_modules=('gapic-libraries-bom' 'google-cloud-jar-parent' 'google-cloud-pom-parent')

function retry_with_backoff {
    attempts_left=$1
    sleep_seconds=$2
    shift 2
    command=$@


    # store current flag state
    flags=$-
    
    # allow a failures to continue
    set +e
    unset IFS
    ${command}
    exit_code=$?

    # restore "e" flag
    if [[ ${flags} =~ e ]]
    then set -e
    else set +e
    fi

    if [[ $exit_code == 0 ]]
    then
        return 0
    fi

    # failure
    if [[ ${attempts_left} -gt 0 ]]
    then
        echo "failure (${exit_code}), sleeping ${sleep_seconds}..."
        sleep ${sleep_seconds}
        new_attempts=$((${attempts_left} - 1))
        new_sleep=$((${sleep_seconds} * 2))
        retry_with_backoff ${new_attempts} ${new_sleep} ${command}
    fi

    return $exit_code
}

## Helper functions
function now() { date +"%Y-%m-%d %H:%M:%S" | tr -d '\n'; }
function msg() { println "$*" >&2; }
function println() { printf '%s\n' "$(now) $*"; }

function generate_modified_modules_list() {
  # Find the files changed from when the PR branched to the last commit
  # Filter for java modules and get all the unique elements
  # grep returns 1 (error code) and exits the pipeline if there is no match
  # If there is no match, it will return true so the rest of the commands can run
  modified_files=$(git diff --name-only "${KOKORO_GITHUB_PULL_REQUEST_TARGET_BRANCH}...${KOKORO_GITHUB_PULL_REQUEST_COMMIT}")
  printf "Modified files:\n%s\n" "${modified_files}"

  # Generate the list of valid maven modules
  maven_modules_list=$(mvn help:evaluate -Dexpression=project.modules | grep '<.*>.*</.*>' | sed -e 's/<.*>\(.*\)<\/.*>/\1/g')
  maven_modules=()
  for module in $maven_modules_list; do
    if [[ ! " ${excluded_modules[*]} " =~ " ${module} " ]]; then
      maven_modules+=("${module}")
    fi
  done

  modified_module_list=()
  # If either parent pom.xml is touched, run ITs on all the modules
  parent_pom_modified=$(echo "${modified_files}" | grep -E '^google-cloud-(pom|jar)-parent/pom.xml$' || true)
  if [[ ( -n $parent_pom_modified ) || ( "${TEST_ALL_MODULES}" == "true" ) ]]; then
    modified_module_list=(${maven_modules[*]})
    echo "Testing the entire monorepo"
  else
    modules=$(echo "${modified_files}" | grep -E 'java-.*' || true)
    printf "Files in java modules:\n%s\n" "${modules}"
    if [[ -n $modules ]]; then
      modules=$(echo "${modules}" | cut -d '/' -f1 | sort -u)
      for module in $modules; do
        if [[ ! " ${excluded_modules[*]} " =~ " ${module} " && " ${maven_modules[*]} " =~ " ${module} " ]]; then
          modified_module_list+=("${module}")
        fi
      done
    else
      echo "Found no changes in the java modules"
    fi
  fi
}

function run_integration_tests() {
  printf "Running Integration Tests for:\n%s\n" "$1"
  mvn -B ${INTEGRATION_TEST_ARGS} \
    -pl "$1" \
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
  printf "Finished Integration Tests for:\n%s\n" "$1"
}

function run_graalvm_tests() {
  printf "Running GraalVM ITs on:\n%s\n" "${module_list[*]}"

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
    -Pnative \
    -fae \
    test

  RETURN_CODE=$?
  printf "Finished Unit and Integration Tests for GraalVM:\n%s\n" "${module_list}"
}

function generate_graalvm_modules_list() {
  modules_assigned_list=()
  generate_modified_modules_list
  if [[ "${TEST_ALL_MODULES}" == "true" ]]; then
    # Assign the modules to modules_assigned_list (based on num jobs)
    num=0
    for module in "${modified_module_list[@]}"; do
      # Add 1 as JOB_NUMBER is 1-indexed instead of 0-indexed
      mod_num=$((num % NUM_JOBS + 1))
      # Spaces are intentionally added -- Query is regex and array elements are space separated
      # It tries to match the *exact* `module` text
      if [[ ! " ${excluded_modules[*]} " =~ " ${module} " ]] && [[ $mod_num -eq $JOB_NUMBER ]]; then
        modules_assigned_list+=("${module}")
      fi
      num=$((num + 1))
    done
  elif [[ ${#modified_module_list[@]} -gt 0 ]]; then
    # MAVEN_MODULES ENV_VAR is expecting comma delimited string (similar to mvn -pl)
    # This will get all the modules and put all the elements into an array
    maven_modules_list=($(echo "${MAVEN_MODULES}" | tr ',' ' '))
    for maven_module in "${maven_modules_list[@]}"; do
      # Check that the modified_module_list contains a module from MAVEN_MODULES
      # Spaces are intentionally added -- Query is regex and array elements are space separated
      # It tries to match the *exact* `maven_module` text
      if [[ " ${modified_module_list[*]} " =~ " ${maven_module} " ]]; then
        modules_assigned_list+=("${module}")
      fi
    done
  fi
  module_list=$(
    IFS=,
    echo "${modules_assigned_list[*]}"
  )
}

function install_modules() {
  retry_with_backoff 3 10 \
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
}
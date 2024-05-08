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
  if [[ ${flags} =~ e ]]; then
    set -e
  else
    set +e
  fi

  if [[ $exit_code == 0 ]]; then
    return 0
  fi

  # failure
  if [[ ${attempts_left} -gt 0 ]]; then
    echo "failure (${exit_code}), sleeping ${sleep_seconds}..."
    sleep ${sleep_seconds}
    new_attempts=$((${attempts_left} - 1))
    new_sleep=$((${sleep_seconds} * 2))
    retry_with_backoff ${new_attempts} ${new_sleep} ${command}
  fi

  return $exit_code
}

# Given a folder containing a maven multi-module, assign the variable 'submodules' to a
# comma-delimited list of <folder>/<submodule>.
function parse_submodules() {
  pushd "$1" >/dev/null

  # New-line-delimited string containing the current folder's pom.xml <module> names.
  mvn_submodules=$(mvn help:evaluate -Dexpression=project.modules \
        | grep '<.*>.*</.*>' \
        | sed -e 's/<.*>\(.*\)<\/.*>/\1/g')

  submodules_array=()
  for submodule in $mvn_submodules; do
    # Each entry = <folder>/<submodule>
    submodules_array+=("$1/${submodule}");
  done

  # Convert from array to comma-delimited string
  submodules=$(
    IFS=,
    echo "${submodules_array[*]}"
  )
  export submodules

  popd >/dev/null
}

# Given a list of folders containing maven multi-modules, assign the variable 'all_submodules' to a
# comma-delimited list of <folder>/<submodule>.
#
# See also parse_submodules()
function parse_all_submodules() {
  # Parse the comma-delimited input into an array.
  IFS=',' read -ra input_modules <<< "$1"

  all_submodules_array=()
  for module in "${input_modules[@]}"; do
    # For each module, parse its submodules and store the result in an array.
    parse_submodules "$module"
    all_submodules_array+=("$submodules")
  done

  # Convert from array to comma-delimited string
  all_submodules=$(
    IFS=,
    echo "${all_submodules_array[*]}"
  )
  export all_submodules
}

## Helper functions
function now() { date +"%Y-%m-%d %H:%M:%S" | tr -d '\n'; }
function msg() { println "$*" >&2; }
function println() { printf '%s\n' "$(now) $*"; }

function setup_application_credentials() {
  # if GOOGLE_APPLICATION_CREDENTIALS is specified as a relative path, prepend Kokoro root directory onto it
  if [[ ! -z "${GOOGLE_APPLICATION_CREDENTIALS}" && "${GOOGLE_APPLICATION_CREDENTIALS}" != /* ]]; then
    export GOOGLE_APPLICATION_CREDENTIALS=$(realpath "${KOKORO_GFILE_DIR}/${GOOGLE_APPLICATION_CREDENTIALS}")
  fi
}

function setup_cloud() {
  gcloud config set project "$GOOGLE_CLOUD_PROJECT"

  terraform -version &&
    source ./.cloud/helpers/init.sh "$1" &&
    source ./.cloud/helpers/plan.sh "$1" &&
    source ./.cloud/helpers/apply.sh &&
    source ./.cloud/helpers/populate-env.sh

  destroy() {
    arguments=$?
    time source ./.cloud/helpers/destroy.sh
    exit $arguments
  }
  trap destroy EXIT
}

function generate_modified_modules_list() {
  # Find the files changed from when the PR branched to the last commit
  # Filter for java modules and get all the unique elements
  # grep returns 1 (error code) and exits the pipeline if there is no match
  # If there is no match, it will return true so the rest of the commands can run
  git config --global --add safe.directory $(realpath .)
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
  shared_dependencies_modified=$(echo "${modified_files}" | grep -E '^java-shared-dependencies' || true)
  if [[ (-n $parent_pom_modified) || (-n $shared_dependencies_modified) || ("${TEST_ALL_MODULES}" == "true") ]]; then
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
  parse_all_submodules "$1"
  printf "Running integration tests for modules:\n%s\n" "$1"
  printf "Running integration tests for submodules:\n%s\n" "$all_submodules"

  mvn verify -Penable-integration-tests --projects "$all_submodules" \
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
    -T 1C

  RETURN_CODE=$?
  printf "Finished integration tests for modules:\n%s\n" "$1"
}

function run_graalvm_tests() {
  parse_all_submodules "$1"
  printf "Running GraalVM ITs for modules:\n%s\n" "$1"
  printf "Running GraalVM ITs for submodules:\n%s\n" "$all_submodules"

  mvn test -Pnative --projects "$all_submodules" \
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
  printf "Finished GraalVM ITs for modules:\n%s\n" "$1"
}

function generate_graalvm_presubmit_modules_list() {
  modules_assigned_list=()
  generate_modified_modules_list
  if [[ ${#modified_module_list[@]} -gt 0 && ${#modified_module_list[@]} -lt 5 ]]; then
    # If only a few modules have been modified, focus presubmit testing only on them.
    module_list=$(
      IFS=,
      echo "${modified_module_list[*]}"
    )
  else
    # If no modules have been modified or if too many have been modified, just test the modules
    # specified in the MAVEN_MODULES env var.
    if [ -z "${MAVEN_MODULES}" ]; then
      echo "MAVEN_MODULES not defined in environment."
      exit 1
    fi
    module_list=${MAVEN_MODULES}
  fi
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
  if [ -z "$1" ]; then
    mvn install \
      -B -ntp \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dorg.slf4j.simpleLogger.showDateTime=true \
      -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
      -Dcheckstyle.skip=true \
      -Dflatten.skip=true \
      -Danimal.sniffer.skip=true \
      -DskipTests=true \
      -Djacoco.skip=true \
      -T 1C
  else
    printf "Installing modules:\n%s\n" "$1"
    parse_all_submodules "$1"
    printf "Installing submodules:\n%s\n" "$all_submodules"

    # When working with a maven multi-module project containing other multi-module projects,
    # to build a module with its dependencies and without building its dependents:
    # Perform the install command on a grandchild module with the --also-make flag.
    #
    # Examples:
    #
    #   mvn install --projects java-asset --also-make
    #      ! Does not work. Maven reactor will not build java-asset's child modules, such as the
    #        gapic, proto, and grpc modules.
    #
    #   mvn install --projects java-kms --also-make-dependents
    #      ! Does not work. Maven reactor will include java-kmsinventory in its build.
    #
    #   mvn install --projects java-kms/google-cloud-kms --also-make
    #      Correctly builds dependencies without building dependents.
    mvn install --projects "$all_submodules" --also-make \
      -B -ntp \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dorg.slf4j.simpleLogger.showDateTime=true \
      -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
      -Dcheckstyle.skip=true \
      -Dflatten.skip=true \
      -Danimal.sniffer.skip=true \
      -DskipTests=true \
      -Djacoco.skip=true \
      -T 1C
  fi
}

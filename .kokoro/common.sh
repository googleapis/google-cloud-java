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

commonScriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
excluded_modules=(
  'gapic-libraries-bom'
  'google-cloud-jar-parent'
  'google-cloud-pom-parent'
  'java-vertexai'
  'java-logging'
  'java-bigquery'
  'java-bigquery-jdbc'
  'java-bigquerystorage'
  'java-datastore'
  'java-logging-logback'
  'sdk-platform-java'
  'sdk-platform-java/java-shared-dependencies/dependency-analyzer'
  'sdk-platform-java/java-shared-dependencies/dependency-convergence-check'
  'java-showcase'
  'sdk-platform-java/java-showcase-3.21.0'
  'sdk-platform-java/java-showcase-3.25.8'
  'java-spanner'
  'java-spanner-jdbc'
  'google-auth-library-java'
  'google-auth-library-java/oauth2_http'
  'java-storage'
  'java-storage-nio'
  'java-cloud-bom'
  'java-shared-config'
  'java-firestore'
  'java-bigtable'
  'java-pubsub'
  'java-common-protos'
  'java-iam'
)

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

# Helper function to reliably extract the text between <module> tags strictly
# within the default <modules> block, natively ignoring <profiles>.
# Uses a pure Bash loop to avoid spawning slower external processes like awk or sed,
# and naturally survives single-module components without throwing exit signals.
function extract_pom_modules() {
  local pom_file="$1"
  if [[ ! -f "${pom_file}" ]]; then
    return 1
  fi
  local line module
  local in_profiles=false
  local in_modules=false
  local -a modules=()

  while IFS= read -r line || [[ -n "${line}" ]]; do
    if [[ "${line}" == *"<profiles>"* ]]; then
      in_profiles=true
    elif [[ "${line}" == *"</profiles>"* ]]; then
      in_profiles=false
    elif [[ "${line}" == *"<modules>"* && "${in_profiles}" == "false" ]]; then
      in_modules=true
    elif [[ "${line}" == *"</modules>"* && "${in_profiles}" == "false" ]]; then
      in_modules=false
      break
    elif [[ "${in_modules}" == "true" && "${line}" == *"<module>"* ]]; then
      # Extract text between tags
      module="${line#*<module>}"
      module="${module%</module>*}"

      # Trim leading/trailing whitespace without spawning external processes
      module="${module#"${module%%[![:space:]]*}"}"
      module="${module%"${module##*[![:space:]]}"}"

      if [[ -n "${module}" ]]; then
        modules+=("${module}")
      fi
    fi
  done < "${pom_file}"

  echo "${modules[*]}"
}

# Given a folder containing a maven multi-module, assign the variable 'submodules' to a
# comma-delimited list of <folder>/<submodule>.
function parse_submodules() {
  submodules_array=()
  if [[ -f "$1/pom.xml" ]]; then
    local modules
    local submodule

    # Use pure Bash extraction to find the modules in the aggregator pom file.
    # Faster than invoking mvn help:evaluate to list all the project modules,
    # cleanly ignores optional <profiles>, and gracefully skips flat POMs.
    modules=$(extract_pom_modules "$1/pom.xml")
    if [[ -n "${modules}" ]]; then
      for submodule in ${modules}; do
        # Each entry = <folder>/<submodule>
        submodules_array+=("$1/${submodule}")
      done
    else
      # If this module contains no submodules, select the module itself.
      submodules_array+=("$1")
    fi
  else
    echo "Module does not have a pom.xml file: $1"
    exit 1
  fi

  # Convert array to a comma-delimited string:
  # Declaring 'local IFS=,' restricts delimiter changes to this function's scope,
  # preventing global IFS pollution (which breaks word splitting in subsequent code).
  # Expanding "${submodules_array[*]}" joins elements using IFS entirely in-memory
  # without spawning a subshell process.
  local IFS=,
  submodules="${submodules_array[*]}"
  export submodules
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

  # 'local IFS=,' safely joins array elements within function scope without subshells:
  local IFS=,
  all_submodules="${all_submodules_array[*]}"
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
    echo "Exiting via destroy()"

    ## Get the directory of the build script
    scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
    ## cd to the parent directory, i.e. the root of the git repo
    cd ${scriptDir}/..

    time source ./.cloud/helpers/destroy.sh
    exit $arguments
  }
  trap destroy EXIT
}

# Prints "true" if this pull pull request is made by Release Please
# SNAPSHOT pull request.
# If a CI runs on a Release Please SNAPSHOT pull request, there's no point in running
# integration tests because it only changes the versions in pom.xml and we merge
# the pull requests without any additional changes (b/370011322).
function release_please_snapshot_pull_request() {
  # Example value: "+google-cloud-java:1.48.0:1.49.0-SNAPSHOT"
  changedLine=$(git diff origin/main -- versions.txt 2>/dev/null | grep '^+google-cloud-java:')
  if [[ "$changedLine" =~ "SNAPSHOT"$ ]]; then
    echo "true"
  else
    echo "false"
  fi
}

# Returns the list of modified files in the current PR diff via git diff.
function get_modified_files() {
  # In Kokoro Docker containers, the build runs as root (UID 0) while repository files
  # belong to the host user (UID 1000). Git 2.35.2+ flags this UID mismatch as 'dubious ownership'
  # and aborts git commands; safe.directory allows Git to operate in this directory.
  git config --global --add safe.directory "$(realpath .)" 2>/dev/null || true

  # '${VAR:-DEFAULT}' uses $VAR if set and non-empty, otherwise falls back to DEFAULT.
  # This allows developers to run these scripts locally outside the Kokoro CI environment.
  local target_branch="${KOKORO_GITHUB_PULL_REQUEST_TARGET_BRANCH:-origin/main}"
  local target_commit="${KOKORO_GITHUB_PULL_REQUEST_COMMIT:-HEAD}"

  # 'git diff A...B' (triple-dot) diffs between the merge-base (common ancestor) of
  # target_branch and target_commit, listing only files changed in this branch.
  git diff --name-only "${target_branch}...${target_commit}"
}

# Determines if the entire monorepo must be tested.
#
# Monorepo-wide testing is triggered under four conditions:
# 1. TEST_ALL_MODULES is set to "true" (used by nightly and scheduled CI builds).
# 2. Root parent POMs (google-cloud-jar-parent or google-cloud-pom-parent) are modified,
#    as changes to parent POMs affect shared dependency versions and compiler/build plugins.
# 3. Core SDK platform libraries (sdk-platform-java) are modified, as gax, generators,
#    and core transport changes can break downstream client library integration tests.
# 4. Core authentication libraries (google-auth-library-java) are modified, as auth/credential
#    changes affect all client libraries.
function should_test_all_modules() {
  local files
  files=$(get_modified_files)

  # '<<< STRING' is a Bash "here-string" that feeds the string variable directly to
  # stdin of grep, avoiding an external subshell pipeline (like 'echo "$var" | grep').
  if [[ "${TEST_ALL_MODULES}" == "true" ]] || \
     grep -q -E '^google-cloud-(pom|jar)-parent/pom.xml$' <<< "${files}" || \
     grep -q -E '^sdk-platform-java/' <<< "${files}" || \
     grep -q -E '^google-auth-library-java/' <<< "${files}"; then
    return 0
  fi
  return 1
}

# Generates the list of modified Maven modules for batch integration/GraalVM test jobs.
# Sets global variables:
# - maven_modules: list of all Maven modules defined in the root POM.
# - modified_module_list: modules that need to be tested for the current PR.
#
# Positional parameter $1 (default "true") specifies whether to filter out modules
# defined in the 'excluded_modules' array.
function generate_modified_modules_list() {
  local files
  files=$(get_modified_files)
  printf "Modified files:\n%s\n" "${files}"

  # Extract valid maven modules directly from pom.xml in pure Bash (~0.02s).
  # This replaces 'mvn help:evaluate -Dexpression=project.modules' which previously
  # spent 20-30+ seconds booting a JVM and evaluating the monorepo POMs on every run.
  local root_pom="${commonScriptDir}/../pom.xml"
  if [[ ! -f "${root_pom}" ]]; then
    root_pom="pom.xml"
  fi
  local maven_modules_list
  maven_modules_list=$(extract_pom_modules "${root_pom}")
  maven_modules=()

  # Positional parameter $1 specifies whether to apply the exclusion list (defaults to true).
  local use_exclusion_list="${1:-true}"
  local -a all_modules=()
  read -r -a all_modules <<< "${maven_modules_list}"

  local module
  if [[ "${use_exclusion_list}" == "true" ]]; then
    echo "Excluding modules from the global exclusion list"
    for module in "${all_modules[@]}"; do
      if [[ ! " ${excluded_modules[*]} " == *" ${module} "* ]]; then
        maven_modules+=("${module}")
      fi
    done
  else
    maven_modules=("${all_modules[@]}")
  fi

  modified_module_list=()
  # If either parent pom.xml or core shared dependency is touched, run ITs on all the modules
  if should_test_all_modules; then
    # '("${maven_modules[@]}")' copies the array elements safely.
    modified_module_list=("${maven_modules[@]}")
    echo "Testing the entire monorepo"
  else
    # Extract the top-level directory from each modified file path:
    # 'cut -d '/' -f1' takes the first path segment (e.g. 'java-bigquery/src/...' -> 'java-bigquery').
    # 'sort -u' sorts and deduplicates the candidate directory names.
    local modules
    modules=$(cut -d '/' -f1 <<< "${files}" | sort -u)
    printf "Files in java modules:\n%s\n" "${modules}"
    for module in ${modules}; do
      # If this top-level directory is a recognized Maven module, add it to our list.
      if [[ " ${maven_modules[*]} " == *" ${module} "* ]]; then
        modified_module_list+=("${module}")
      fi
    done
    if [[ ${#modified_module_list[@]} -eq 0 ]]; then
      echo "Found no changes in the java modules"
    fi

    # Also include downstream modules if any of their upstream dependencies were modified,
    # ensuring batch integration tests cover dependent client libraries.
    for module in "${maven_modules[@]}"; do
      if is_upstream_module_modified "${module}"; then
        if [[ ! " ${modified_module_list[*]} " =~ " ${module} " ]]; then
          modified_module_list+=("${module}")
        fi
      fi
    done
  fi
}

# Checks if files within a specific module directory were modified in the PR diff.
#
# Uses exact directory prefix matching ('^${module}/') to prevent substring collisions
# where modifying one module triggers tests for another module that shares its prefix
# (e.g. java-bigquery vs java-bigquerystorage).
function is_module_modified() {
  local module="$1"
  if [[ -z "${module}" ]]; then
    return 1
  fi

  local files
  files=$(get_modified_files)
  # '<<< "${files}"' feeds the diff string directly to grep via stdin.
  grep -q -E "^${module}/" <<< "${files}"
}

# Maps a module to its intra-monorepo upstream dependencies.
#
# Certain libraries in this repository directly depend on sibling modules (for example,
# java-bigquery depends on java-bigquerystorage, JDBC drivers wrap client SDKs, and
# java-spanner depends on grpc-gcp-java). Without this mapping, changes to an upstream
# dependency would not trigger integration tests for downstream consumers in PR CI.
#
# Returns space-separated module names that the given module depends on, or empty if none.
function get_upstream_modules() {
  local module="$1"
  case "${module}" in
    java-bigquery)
      echo "java-bigquerystorage"
      ;;
    java-bigquery-jdbc)
      echo "java-bigquery java-bigquerystorage"
      ;;
    java-spanner)
      echo "grpc-gcp-java"
      ;;
    java-spanner-jdbc)
      echo "java-spanner grpc-gcp-java"
      ;;
    java-storage-nio)
      echo "java-storage"
      ;;
    java-logging-logback)
      echo "java-logging"
      ;;
    *)
      ;;
  esac
}

# Checks if any upstream dependency of the given module was modified in the PR diff.
#
# Takes a module name (e.g. BUILD_SUBDIR), retrieves its upstream dependencies using
# get_upstream_modules, and checks if any of those upstream directories were touched.
# Returns 0 (true) if an upstream module was modified, triggering downstream tests;
# otherwise returns 1 (false).
function is_upstream_module_modified() {
  local module="$1"
  if [[ -z "${module}" ]]; then
    return 1
  fi

  local upstream
  for upstream in $(get_upstream_modules "${module}"); do
    if is_module_modified "${upstream}"; then
      return 0
    fi
  done
  return 1
}

# Filters the modified_module_list to only include modules that contain
# integration test files (matching IT*.java or *IT.java in src/test/java).
# Not all modules will have ITs written and there is not need to test
# modules without ITs.
function filter_modules_with_integration_tests() {
  filtered_it_module_list=()
  for module in "${modified_module_list[@]}"; do
    # 1. Search for files in the Java test directory (*/src/test/java/*)
    # 2. Filter for ITs that match the typical file name (IT prefix or suffix)
    # 3. Stop searching when a single file match has been found
    if find "$module" -path '*/src/test/java/*' \( -name 'IT*.java' -o -name '*IT.java' \) -print -quit 2>/dev/null | grep -q .; then
      filtered_it_module_list+=("$module")
    fi
  done
  printf "Modules with integration tests:\n"
  printf "  %s\n" "${filtered_it_module_list[@]}"
  echo "Found ${#filtered_it_module_list[@]} modules with integration tests (out of ${#modified_module_list[@]} modified modules)"
}

function run_integration_tests() {
  printf "Running integration tests for modules:\n%s\n" "$1"
  parse_all_submodules "$1"
  printf "Running integration tests for submodules:\n%s\n" "$all_submodules"

  mvn verify -Penable-integration-tests -Pquick-build --projects "$all_submodules" \
    ${INTEGRATION_TEST_ARGS} \
    -B -ntp -fae \
    --also-make \
    -PbulkTests \
    -DtrimStackTrace=false \
    -Dorg.slf4j.simpleLogger.showDateTime=true \
    -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
    -DskipUnitTests=true \
    -Dmaven.wagon.http.retryHandler.count=5 \
    -T 1C

  RETURN_CODE=$?
  printf "Finished integration tests for modules:\n%s\n" "$1"
}

function run_graalvm_tests() {
  printf "Running GraalVM ITs for modules:\n%s\n" "$1"
  parse_all_submodules "$1"
  printf "Running GraalVM ITs for submodules:\n%s\n" "$all_submodules"

  mvn test -Pnative -Pquick-build --projects "$all_submodules" \
    ${INTEGRATION_TEST_ARGS} \
    -B -ntp -fae \
    -DtrimStackTrace=false \
    -Dorg.slf4j.simpleLogger.showDateTime=true \
    -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS

  RETURN_CODE=$?
  printf "Finished GraalVM ITs for modules:\n%s\n" "$1"
}

function generate_graalvm_presubmit_modules_list() {
  modules_assigned_list=()
  generate_modified_modules_list
  if [[ ${#modified_module_list[@]} -gt 0 && ${#modified_module_list[@]} -lt 5 ]]; then
    # If only a few modules have been modified, focus presubmit testing only on them.
    # Join array into comma-delimited string without subshell:
    local IFS=,
    module_list="${modified_module_list[*]}"
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
    # Parse comma-delimited MAVEN_MODULES into array using pure Bash:
    IFS=',' read -ra maven_modules_list <<< "${MAVEN_MODULES}"
    for maven_module in "${maven_modules_list[@]}"; do
      # Check that the modified_module_list contains a module from MAVEN_MODULES
      # Spaces are intentionally added -- Query is regex and array elements are space separated
      # It tries to match the *exact* `maven_module` text
      if [[ " ${modified_module_list[*]} " =~ " ${maven_module} " ]]; then
        modules_assigned_list+=("${maven_module}")
      fi
    done
  fi
  # Join array into comma-delimited string without subshell:
  local IFS=,
  module_list="${modules_assigned_list[*]}"
}

function install_modules() {
  if [ -z "$1" ]; then
    mvn install \
      -B -ntp \
      -Pquick-build \
      -DtrimStackTrace=false \
      -Dorg.slf4j.simpleLogger.showDateTime=true \
      -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
      -DskipTests=true \
      -Dmaven.javadoc.skip=true \
      -Dgcloud.download.skip=true \
      -T 1C
  else
    printf "Installing modules:\n%s\n" "$1"
    parse_all_submodules "$1"
    printf "Installing submodules:\n%s\n" "$all_submodules"

    always_install_deps_list=(
      # Required upstream dependency for java-spanner and java-spanner-jdbc
      'grpc-gcp-java'
      'java-monitoring/google-cloud-monitoring'
      'java-monitoring/google-cloud-monitoring-bom'
      'java-kms/google-cloud-kms'
      'java-kms/proto-google-cloud-kms-v1'
      'java-kms/grpc-google-cloud-kms-v1'
      'google-auth-library-java/appengine'
      'google-auth-library-java/bom'
      'google-auth-library-java/cab-token-generator'
      'google-auth-library-java/credentials'
      'google-auth-library-java/oauth2_http'
      'java-common-protos/grpc-google-common-protos'
      'java-common-protos/proto-google-common-protos'
      'java-iam/grpc-google-iam-v1'
      'java-iam/grpc-google-iam-v2'
      'java-iam/grpc-google-iam-v2beta'
      'java-iam/grpc-google-iam-v3'
      'java-iam/grpc-google-iam-v3beta'
      'java-iam/proto-google-iam-v1'
      'java-iam/proto-google-iam-v2'
      'java-iam/proto-google-iam-v2beta'
      'java-iam/proto-google-iam-v3'
      'java-iam/proto-google-iam-v3beta'
      'gapic-libraries-bom'
      # Required upstream dependency for gax-java, google-cloud-core, and all client libraries
      'sdk-platform-java/api-common-java'
      'sdk-platform-java/java-shared-dependencies'
      'sdk-platform-java/java-shared-dependencies/first-party-dependencies'
      'sdk-platform-java/java-shared-dependencies/third-party-dependencies'
      'sdk-platform-java/gapic-generator-java-bom'
      'sdk-platform-java/java-core/google-cloud-core-bom'
      'sdk-platform-java/java-core/google-cloud-core'
      'sdk-platform-java/java-core/google-cloud-core-grpc'
      'sdk-platform-java/java-core/google-cloud-core-http'
      'sdk-platform-java/gax-java/gax-bom'
      'sdk-platform-java/gax-java/gax'
      'sdk-platform-java/gax-java/gax-grpc'
      'sdk-platform-java/gax-java/gax-httpjson'
    )
    # Join dependencies into comma-delimited string without subshell:
    local IFS=,
    always_install_deps="${always_install_deps_list[*]}"
    printf "with always_install_deps:\n%s\n" "$all_submodules,$always_install_deps"

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
    mvn install --projects "$all_submodules,$always_install_deps" --also-make \
      -B -ntp \
      -Pquick-build \
      -DtrimStackTrace=false \
      -Dorg.slf4j.simpleLogger.showDateTime=true \
      -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
      -DskipTests=true \
      -Dmaven.javadoc.skip=true \
      -Dgcloud.download.skip=true \
      -T 1C
  fi
}


# In the given directory ($1),
#   update the pom.xml's dependency on the given artifact ($2) to the given version ($3)
# ex: update_dependency google-cloud-java/google-cloud-jar-parent google-cloud-shared-dependencies 1.2.3
function update_pom_dependency {
  pushd "$1" || exit 1
  xmllint --shell pom.xml &>/dev/null <<EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="$2"]
cd ../x:version
set $3
save pom.xml
EOF
  popd || exit 1
}

# Find all pom.xml files that declare a specific version for the given artifact ($1).
# Pre-filters candidate files with grep -rl to avoid executing xmllint across hundreds
# of unrelated POM files in the repository.
function find_all_poms_with_versioned_dependency {
  POMS=()
  local found=()
  local pom

  # Stream matching pom.xml paths line-by-line via process substitution '< <(...)',
  # which executes the while loop in the current shell process so 'found' array mutations persist:
  while IFS= read -r pom; do
    [[ -z "${pom}" ]] && continue
    # Verify the POM declares an explicit <version> tag following the target <artifactId>:
    if xmllint --xpath "//*[local-name()='artifactId' and text()='$1']/following-sibling::*[local-name()='version']" "$pom" &>/dev/null; then
      found+=("$pom")
    fi
  done < <(
    # Fast pre-filter using 'grep' to avoid parsing hundreds of unrelated POMs:
    # - '-r': recursively scans directories.
    # - '-l': prints each matching file path once (stops scanning a file on first match,
    #         preventing duplicate paths in the stream and saving I/O on large POMs).
    # - '--include="pom.xml"': scopes search exclusively to POMs, ignoring non-POM files.
    # - '<artifactId>...${1}...</artifactId>': matches tags around $1 with optional whitespace.
    # - '2>/dev/null || true': silences errors and prevents 'set -e' failure when 0 files match.
    grep -rlE "<artifactId>[[:space:]]*${1}[[:space:]]*</artifactId>" \
      --include="pom.xml" \
      . 2>/dev/null || true
  )

  POMS=("${found[@]}")
  export POMS
}

# In the given directory ($1),
#   find and update all pom.xmls' dependencies on the given artifact ($2) to the given version ($3)
# ex: update_all_poms_dependency google-cloud-java google-cloud-shared-dependencies 1.2.3
function update_all_poms_dependency {
  pushd "$1" || exit 1
  find_all_poms_with_versioned_dependency "$2"
  # Quote "${POMS[@]}" so the loop iterates over each array element safely:
  for pom in "${POMS[@]}"; do
    # Use '${pom%/*}' to extract the parent directory in pure Bash without a 'dirname' subshell:
    update_pom_dependency "${pom%/*}" "$2" "$3"
  done
  git diff
  popd || exit 1
}

# Parse the version of the pom.xml file in the given directory ($1)
# ex: VERSION=$(parse_pom_version java-shared-dependencies)
function parse_pom_version {
  # Namespace (xmlns) prevents xmllint from specifying tag names in XPath
  result=$(sed -e 's/xmlns=".*"//' "$1/pom.xml" | xmllint --xpath '/project/version/text()' -)

  if [ -z "${result}" ]; then
    echo "Version is not found in $1"
    exit 1
  fi
  echo "$result"
}

# ex: find_last_release_version java-bigtable
# ex: find_last_release_version java-storage 2.22.x
function find_last_release_version {
  repo=$1
  branch=${2-"main"} # Default to using main branch
  org=${3-"googleapis"}
  curl -s -o "versions_${repo}.txt" "https://raw.githubusercontent.com/${org}/${repo}/${branch}/versions.txt"

  # First check to see if there's an entry for the overall repo. Used for google-cloud-java.
  primary_artifact=$(grep -E "^${repo}" "versions_${repo}.txt" | head -n 1)
  if [ -z "${primary_artifact}" ]; then
    # Otherwise, use the first google-cloud-* artifact's version.
    primary_artifact=$(grep -E "^google-cloud-" "versions_$1.txt" | head -n 1)
  fi
  if [ -z "${primary_artifact}" ]; then
    echo "Unable to identify primary artifact for $1"
    exit 1
  fi

  parts=($(echo "$primary_artifact" | tr ":" "\n"))
  echo "${parts[1]}"
}

# copies settings.xml from the root of sdk-platform-java into Maven's home
# folder
function setup_maven_mirror {
  echo "Setup maven mirror"
  mkdir -p "${HOME}/.m2"
  cp "${commonScriptDir}/../settings.xml" "${HOME}/.m2"
}

function install_repo_modules {
  target_projects="$1"
  projects_arg=""
  if [ -n "${target_projects}" ]; then
    projects_arg="--projects ${target_projects}"
  fi
  echo "Installing this repo's modules to local maven."
  mvn -q -B -ntp install ${projects_arg} \
    -Dcheckstyle.skip -Dfmt.skip -DskipTests -T 1C
}

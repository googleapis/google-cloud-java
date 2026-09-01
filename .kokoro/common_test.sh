#!/bin/bash
# Copyright 2023 Google LLC
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

scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
cd "${scriptDir}/.." # cd to the root of this repo
source "$scriptDir/common.sh"
mkdir -p target
cd target

# Mock get_modified_files for unit testing to avoid running Git commands.
# Individual tests set TEST_MODIFIED_FILES to simulate changed files.
function get_modified_files() {
  printf '%s\n' "${TEST_MODIFIED_FILES:-}"
}

function test_find_all_poms_with_versioned_dependency {
  mkdir -p test_find_all_poms_with_dependency
  pushd test_find_all_poms_with_dependency
  cp ../../java-showcase/gapic-showcase/pom.xml pom.xml

  find_all_poms_with_versioned_dependency 'truth'
  if [ "${#POMS[@]}" != 1 ]; then
    echo 'find_all_poms_with_versioned_dependency did not find the expected pom'
    exit 1
  elif [ "${POMS[0]}" != './pom.xml' ]; then
    echo "find_all_poms_with_versioned_dependency found ${POMS[0]} instead of expected ./pom.xml"
    exit 1
  fi

  find_all_poms_with_versioned_dependency 'gax-grpc' # Versioned by shared-deps
  if [ "${#POMS[@]}" != 0 ]; then
    echo 'find_all_poms_with_versioned_dependency found unexpected pom'
    exit 1
  fi

  popd
}

function test_update_pom_dependency {
  mkdir -p test_update_pom_dependency
  pushd test_update_pom_dependency
  cp ../../java-showcase/gapic-showcase/pom.xml pom.xml

  update_pom_dependency . truth "99.88.77"

  xmllint --shell pom.xml &>/dev/null <<EOF
setns x=http://maven.apache.org/POM/4.0.0
cd .//x:artifactId[text()="truth"]
cd ../x:version
write found-version.txt
EOF
  if ! grep 99.88.77 found-version.txt &>/dev/null; then
    echo "update_pom_dependency failed to change version to expected value."
    exit 1
  fi
  rm found-version.txt
  popd
}

function test_parse_pom_version {
  mkdir -p test_parse_pom_version
  pushd test_parse_pom_version
  cp ../../java-showcase/gapic-showcase/pom.xml pom.xml

  VERSION=$(parse_pom_version .)
  if [ "$VERSION" != "0.0.1-SNAPSHOT" ]; then
    echo "parse_pom_version failed to read expected version of gapic-showcase."
  fi
  popd
}

# Tests that is_module_modified strictly matches the module directory prefix,
# preventing prefix collisions (e.g. java-bigquery vs java-bigquerystorage).
function test_is_module_modified {
  if is_module_modified ""; then
    echo "is_module_modified should return non-zero for empty module name"
    exit 1
  fi

  # Touching 'java-bigquery' should not match 'java-bigquerystorage', 'java-bigquery-jdbc', etc.
  TEST_MODIFIED_FILES="java-bigquery/google-cloud-bigquery/src/main/java/com/google/cloud/bigquery/BigQuery.java
java-bigquery/pom.xml"

  if ! is_module_modified "java-bigquery"; then
    echo "is_module_modified failed to detect java-bigquery modification"
    exit 1
  fi
  if is_module_modified "java-bigquerystorage"; then
    echo "is_module_modified incorrectly matched java-bigquerystorage for java-bigquery"
    exit 1
  fi
  if is_module_modified "java-bigquery-jdbc"; then
    echo "is_module_modified incorrectly matched java-bigquery-jdbc for java-bigquery"
    exit 1
  fi
  if is_module_modified "java-bigqueryconnection"; then
    echo "is_module_modified incorrectly matched java-bigqueryconnection for java-bigquery"
    exit 1
  fi

  # Touching 'java-bigquerystorage' should match only java-bigquerystorage
  TEST_MODIFIED_FILES="java-bigquerystorage/google-cloud-bigquerystorage/src/main/java/Foo.java"
  if is_module_modified "java-bigquery"; then
    echo "is_module_modified incorrectly matched java-bigquery for java-bigquerystorage"
    exit 1
  fi
  if ! is_module_modified "java-bigquerystorage"; then
    echo "is_module_modified failed to detect java-bigquerystorage modification"
    exit 1
  fi

  # External / root files should not be considered module modifications
  TEST_MODIFIED_FILES="google-cloud-jar-parent/pom.xml
sdk-platform-java/java-shared-dependencies/pom.xml"
  if is_module_modified "java-bigquery"; then
    echo "is_module_modified should return false for java-bigquery when only external files changed"
    exit 1
  fi

  unset TEST_MODIFIED_FILES
}

# Test should_test_all_modules triggers properly on global changes.
function test_should_test_all_modules {
  # When only a normal library is modified, should return false (1)
  TEST_MODIFIED_FILES="java-bigquery/pom.xml"
  if should_test_all_modules; then
    echo "should_test_all_modules should return false for single module change"
    exit 1
  fi

  # Root jar parent pom
  TEST_MODIFIED_FILES="google-cloud-jar-parent/pom.xml"
  if ! should_test_all_modules; then
    echo "should_test_all_modules should return true for google-cloud-jar-parent change"
    exit 1
  fi

  # Root pom parent
  TEST_MODIFIED_FILES="google-cloud-pom-parent/pom.xml"
  if ! should_test_all_modules; then
    echo "should_test_all_modules should return true for google-cloud-pom-parent change"
    exit 1
  fi

  # Core SDK platform
  TEST_MODIFIED_FILES="sdk-platform-java/gapic-generator/src/main/Foo.java"
  if ! should_test_all_modules; then
    echo "should_test_all_modules should return true for sdk-platform-java change"
    exit 1
  fi

  # Prefix collision check: sibling paths starting with sdk-platform-java must not match
  TEST_MODIFIED_FILES="sdk-platform-java-extra/pom.xml"
  if should_test_all_modules; then
    echo "should_test_all_modules should return false for sdk-platform-java prefix match"
    exit 1
  fi

  # Core auth library
  TEST_MODIFIED_FILES="google-auth-library-java/oauth2_http/src/main/Foo.java"
  if ! should_test_all_modules; then
    echo "should_test_all_modules should return true for google-auth-library-java change"
    exit 1
  fi

  # Prefix collision check: sibling paths starting with google-auth-library-java must not match
  TEST_MODIFIED_FILES="google-auth-library-java-extra/pom.xml"
  if should_test_all_modules; then
    echo "should_test_all_modules should return false for google-auth-library-java prefix match"
    exit 1
  fi

  # TEST_ALL_MODULES=true
  TEST_MODIFIED_FILES=""
  if ! TEST_ALL_MODULES="true" should_test_all_modules; then
    echo "should_test_all_modules should return true when TEST_ALL_MODULES is true"
    exit 1
  fi

  unset TEST_MODIFIED_FILES
}

# Test is_upstream_module_modified triggers correctly for downstream components.
function test_is_upstream_module_modified {
  # Empty input should return false (1)
  if is_upstream_module_modified ""; then
    echo "is_upstream_module_modified should return false for empty input"
    exit 1
  fi

  # 1. java-bigquerystorage modified:
  #    - java-bigquery should trigger
  #    - java-bigquery-jdbc should trigger
  #    - java-bigquerystorage itself should NOT have upstream trigger
  TEST_MODIFIED_FILES="java-bigquerystorage/src/main/Foo.java"
  if ! is_upstream_module_modified "java-bigquery"; then
    echo "is_upstream_module_modified should return true for java-bigquery when java-bigquerystorage is modified"
    exit 1
  fi
  if ! is_upstream_module_modified "java-bigquery-jdbc"; then
    echo "is_upstream_module_modified should return true for java-bigquery-jdbc when java-bigquerystorage is modified"
    exit 1
  fi
  if is_upstream_module_modified "java-bigquerystorage"; then
    echo "is_upstream_module_modified should return false for java-bigquerystorage when java-bigquerystorage is modified"
    exit 1
  fi

  # 2. java-bigquery modified:
  #    - java-bigquery-jdbc should trigger
  #    - java-bigquerystorage should NOT trigger
  TEST_MODIFIED_FILES="java-bigquery/src/main/Foo.java"
  if ! is_upstream_module_modified "java-bigquery-jdbc"; then
    echo "is_upstream_module_modified should return true for java-bigquery-jdbc when java-bigquery is modified"
    exit 1
  fi
  if is_upstream_module_modified "java-bigquerystorage"; then
    echo "is_upstream_module_modified should return false for java-bigquerystorage when java-bigquery is modified"
    exit 1
  fi

  # 3. grpc-gcp-java modified:
  #    - java-spanner should trigger
  #    - java-spanner-jdbc should trigger
  TEST_MODIFIED_FILES="grpc-gcp-java/src/main/Foo.java"
  if ! is_upstream_module_modified "java-spanner"; then
    echo "is_upstream_module_modified should return true for java-spanner when grpc-gcp-java is modified"
    exit 1
  fi
  if ! is_upstream_module_modified "java-spanner-jdbc"; then
    echo "is_upstream_module_modified should return true for java-spanner-jdbc when grpc-gcp-java is modified"
    exit 1
  fi

  # 4. java-spanner modified:
  #    - java-spanner-jdbc should trigger
  #    - java-spanner itself should NOT have upstream trigger
  TEST_MODIFIED_FILES="java-spanner/src/main/Foo.java"
  if ! is_upstream_module_modified "java-spanner-jdbc"; then
    echo "is_upstream_module_modified should return true for java-spanner-jdbc when java-spanner is modified"
    exit 1
  fi
  if is_upstream_module_modified "java-spanner"; then
    echo "is_upstream_module_modified should return false for java-spanner when java-spanner is modified"
    exit 1
  fi

  # 5. java-storage modified:
  #    - java-storage-nio should trigger
  #    - java-storage itself should NOT have upstream trigger
  TEST_MODIFIED_FILES="java-storage/src/main/Foo.java"
  if ! is_upstream_module_modified "java-storage-nio"; then
    echo "is_upstream_module_modified should return true for java-storage-nio when java-storage is modified"
    exit 1
  fi
  if is_upstream_module_modified "java-storage"; then
    echo "is_upstream_module_modified should return false for java-storage when java-storage is modified"
    exit 1
  fi

  # 6. java-logging modified:
  #    - java-logging-logback should trigger
  #    - java-logging itself should NOT have upstream trigger
  TEST_MODIFIED_FILES="java-logging/src/main/Foo.java"
  if ! is_upstream_module_modified "java-logging-logback"; then
    echo "is_upstream_module_modified should return true for java-logging-logback when java-logging is modified"
    exit 1
  fi
  if is_upstream_module_modified "java-logging"; then
    echo "is_upstream_module_modified should return false for java-logging when java-logging is modified"
    exit 1
  fi

  # 7. Unrelated module modified:
  TEST_MODIFIED_FILES="java-asset/src/main/Foo.java"
  if is_upstream_module_modified "java-asset" || \
     is_upstream_module_modified "java-spanner" || \
     is_upstream_module_modified "java-bigquery"; then
    echo "is_upstream_module_modified should return false when only an unrelated module is modified"
    exit 1
  fi

  unset TEST_MODIFIED_FILES
}

# Test mock get_modified_files returns simulated files.
function test_mock_get_modified_files {
  TEST_MODIFIED_FILES="dummy/file.txt"
  local files
  files=$(get_modified_files)
  if [[ "${files}" != "dummy/file.txt" ]]; then
    echo "mock get_modified_files failed to return expected files"
    exit 1
  fi
  unset TEST_MODIFIED_FILES
}

test_find_all_poms_with_versioned_dependency
test_update_pom_dependency
test_parse_pom_version
test_mock_get_modified_files
test_should_test_all_modules
test_is_module_modified
test_is_upstream_module_modified

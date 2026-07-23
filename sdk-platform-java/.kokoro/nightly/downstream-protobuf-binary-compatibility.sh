#!/bin/bash
# Copyright 2025 Google LLC
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

scriptDir=$(realpath "$(dirname "${BASH_SOURCE[0]}")")
source "${scriptDir}/common.sh"

validate_protobuf_compatibility_script_inputs

monorepoRoot=$(realpath "${scriptDir}/../../..")

# Declare a map of downstream handwritten libraries and the relevant artifacts to test. The map stores a
# K/V pairing of (Key: module name, Value: comma separate list of Group ID:Artifact ID pairings). Note: The
# value list doesn't hold the version and this needs to be parsed from the monorepo's versions.txt file
declare -A module_linkage_checker_arguments
module_linkage_checker_arguments["java-grafeas"]="io.grafeas:grafeas"
module_linkage_checker_arguments["java-resourcemanager"]="com.google.cloud:google-cloud-resourcemanager,com.google.api.grpc:grpc-google-cloud-resourcemanager-v3"
module_linkage_checker_arguments["java-translate"]="com.google.cloud:google-cloud-translate,com.google.api.grpc:grpc-google-cloud-translate-v3,com.google.api.grpc:grpc-google-cloud-translate-v3beta1"
module_linkage_checker_arguments["java-bigtable"]="com.google.cloud:google-cloud-bigtable,com.google.api.grpc:grpc-google-cloud-bigtable-admin-v2,com.google.api.grpc:grpc-google-cloud-bigtable-v2"
module_linkage_checker_arguments["java-bigquery"]="com.google.cloud:google-cloud-bigquery"
module_linkage_checker_arguments["java-bigquerystorage"]="com.google.cloud:google-cloud-bigquerystorage,com.google.api.grpc:grpc-google-cloud-bigquerystorage-v1beta1,com.google.api.grpc:grpc-google-cloud-bigquerystorage-v1beta2,com.google.api.grpc:grpc-google-cloud-bigquerystorage-v1,com.google.api.grpc:grpc-google-cloud-bigquerystorage-v1alpha"
module_linkage_checker_arguments["java-datastore"]="com.google.cloud:google-cloud-datastore,com.google.cloud.datastre:datastore-v1-proto-client,com.google.api.grpc:grpc-google-cloud-datastore-admin-v1"
module_linkage_checker_arguments["java-firestore"]="com.google.cloud:google-cloud-firestore,com.google.cloud:google-cloud-firestore-admin,com.google.api.grpc:grpc-google-cloud-firestore-admin-v1,com.google.api.grpc:grpc-google-cloud-firestore-v1"
module_linkage_checker_arguments["java-logging"]="com.google.cloud:google-cloud-logging,com.google.api.grpc:grpc-google-cloud-logging-v2"
module_linkage_checker_arguments["java-logging-logback"]="com.google.cloud:google-cloud-logging-logback"
module_linkage_checker_arguments["java-pubsub"]="com.google.cloud:google-cloud-pubsub,com.google.api.grpc:grpc-google-cloud-pubsub-v1"
module_linkage_checker_arguments["java-showcase"]="com.google.showcase:gapic-showcase,com.google.api.grpc:grpc-gapic-showcase-v1beta1"
module_linkage_checker_arguments["java-spanner-jdbc"]="com.google.cloud:google-cloud-spanner-jdbc"
module_linkage_checker_arguments["java-spanner"]="com.google.cloud:google-cloud-spanner,com.google.cloud:google-cloud-spanner-executor,com.google.api.grpc:grpc-google-cloud-spanner-v1,com.google.api.grpc:grpc-google-cloud-spanner-admin-instance-v1,com.google.api.grpc:grpc-google-cloud-spanner-admin-database-v1,com.google.api.grpc:grpc-google-cloud-spanner-executor-v1"
module_linkage_checker_arguments["java-storage"]="com.google.cloud:google-cloud-storage,com.google.api.grpc:gapic-google-cloud-storage-v2,com.google.api.grpc:grpc-google-cloud-storage-v2,com.google.cloud:google-cloud-storage-control,com.google.api.grpc:grpc-google-cloud-storage-control-v2"
module_linkage_checker_arguments["java-storage-nio"]="com.google.cloud:google-cloud-nio"

# This function requires access to the versions.txt to retrieve the versions for the artifacts
# It will try to match the artifact_id in the versions.txt file and attach it to form the GAV
# The GAV list is required by Linkage Checker as program arguments
function build_program_arguments() {
  artifact_list="${module_linkage_checker_arguments[$1]}"

  for artifact in ${artifact_list//,/ }; do # Split on comma
    artifact_id=$(echo "${artifact}" | cut -d ':' -f2)

    # The grep query tries to match `{artifact_id}:{released_version}:{current_version}`.
    # The artifact_id must be exact otherwise multiple entries may match
    version=$(cat "${monorepoRoot}/versions.txt" | grep -E "^${artifact_id}:.*:.*$" | cut -d ':' -f3 || true)
    # Unreleased internal test modules like java-showcase are not tracked in versions.txt,
    # so fallback to 0.0.1-SNAPSHOT for linkage checking.
    if [ -z "${version}" ]; then
      version="0.0.1-SNAPSHOT"
    fi
    module_gav_coordinate="${artifact}:${version}"

    # The first entry added is not separated with a comma. Avoids generating `,{ARTIFACT_LIST}`
    if [ -z "${linkage_checker_arguments}" ]; then
      linkage_checker_arguments="${module_gav_coordinate}"
    else
      linkage_checker_arguments="${linkage_checker_arguments},${module_gav_coordinate}"
    fi
  done
}

# TODO(https://github.com/GoogleCloudPlatform/cloud-opensource-java/issues/2395): Java 17+ support for Linkage Checker
# cloud-opensource-java contains the Linkage Checker tool
git clone https://github.com/GoogleCloudPlatform/cloud-opensource-java.git
pushd cloud-opensource-java
mvn -B -ntp clean compile -T 1C
# Linkage Checker tool resides in the /dependencies subfolder
pushd dependencies

# MODULES_UNDER_TEST Env Var accepts a comma separated list of monorepo submodules to test. For Github CI,
# this will be a single module as Github will build a matrix of modules with each being tested in parallel.
# For local invocation, you can pass a list of modules to test multiple modules together.
for module in ${MODULES_UNDER_TEST//,/ }; do # Split on comma
  module_dir="${monorepoRoot}/${module}"
  if [ ! -d "${module_dir}" ]; then
    echo "Directory ${module_dir} does not exist. Skipping or failed."
    exit 1
  fi

  pushd "${module_dir}"
  # Install all module artifacts to ~/.m2 (there can be multiple relevant artifacts to test i.e. core, admin, control)
  mvn clean install -B -V -ntp -T 1C -DskipTests -Dclirr.skip -Denforcer.skip -Dmaven.javadoc.skip

  linkage_checker_arguments=""
  build_program_arguments "${module}"

  # Linkage Checker /dependencies
  popd

  echo "Artifact List: ${linkage_checker_arguments}"
  # The `-s` argument filters the linkage check problems that stem from the artifact
  program_args="-r --artifacts ${linkage_checker_arguments},com.google.protobuf:protobuf-java:${PROTOBUF_RUNTIME_VERSION},com.google.protobuf:protobuf-java-util:${PROTOBUF_RUNTIME_VERSION} -s ${linkage_checker_arguments}"
  echo "Running Linkage Checker on the module's handwritten artifacts"
  echo "Linkage Checker Program Arguments: ${program_args}"
  mvn -B -ntp exec:java -Dexec.args="${program_args}" -P exec-linkage-checker
done
popd
popd

#!/bin/bash
# Copyright 2026 Google LLC
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

echo "Compiling and building all modules for java-bigtable"
install_modules "java-bigtable"

pushd java-bigtable
RETURN_CODE=0
for instance in google-cloud-bigtable google-cloud-bigtable-session; do
  echo "Cleaning up stale resources in instance: ${instance}"
  mvn -B -ntp -pl google-cloud-bigtable \
    test-compile exec:java@cleanup-stale-resources \
    -Dbigtable.project="${GOOGLE_CLOUD_PROJECT:-gcloud-devel}" \
    -Dbigtable.instance="${instance}" \
    -Dbigtable.table=integration-tests || RETURN_CODE=$?
done
popd

echo "exiting with ${RETURN_CODE}"
exit ${RETURN_CODE}

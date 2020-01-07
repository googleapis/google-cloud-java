#!/bin/bash
# Copyright 2019 Google Inc.
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

# `-e` enables the script to automatically fail when a command fails
# `-o pipefail` sets the exit code to the rightmost comment to exit with a non-zero
set -eo pipefail
# Enables `**` to include files nested inside sub-folders
shopt -s globstar

# Update `gcloud` and log versioning for debugging.
gcloud components install beta --quiet
gcloud components update --quiet
echo "********** GCLOUD INFO ***********"
gcloud -v
echo "********** MAVEN INFO  ***********"
mvn -v

# Setup required env variables
source ${KOKORO_GFILE_DIR}/bigquery_secrets.txt
echo "********** Successfully Set All Environment Variables **********"

# Activate service account
gcloud auth activate-service-account \
    --key-file="$GOOGLE_APPLICATION_CREDENTIALS" \
    --project="$GOOGLE_CLOUD_PROJECT"

# Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
# Move into the samples directory
cd ${scriptDir}/../samples/

echo -e "\n******************** RUNNING SAMPLE TESTS ********************"
RTN=0

mvn --fail-at-end clean verify

EXIT=$?
if [[ $EXIT -ne 0 ]]; then
  RTN=1
  echo -e "\n Testing failed: Maven returned a non-zero exit code. \n"
else
  echo -e "\n Testing completed.\n"
fi

exit "$RTN"
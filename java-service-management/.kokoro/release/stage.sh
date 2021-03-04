#!/bin/bash
# Copyright 2018 Google Inc.
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

# Start the releasetool reporter
python3 -m pip install gcp-releasetool
python3 -m releasetool publish-reporter-script > /tmp/publisher-script; source /tmp/publisher-script

source $(dirname "$0")/common.sh
source $(dirname "$0")/../common.sh
MAVEN_SETTINGS_FILE=$(realpath $(dirname "$0")/../../)/settings.xml
pushd $(dirname "$0")/../../

setup_environment_secrets
create_settings_xml_file "settings.xml"

# attempt to stage 3 times with exponential backoff (starting with 10 seconds)
retry_with_backoff 3 10 \
  mvn clean install deploy -B \
    --settings ${MAVEN_SETTINGS_FILE} \
    -DskipTests=true \
    -DperformRelease=true \
    -Dgpg.executable=gpg \
    -Dgpg.passphrase=${GPG_PASSPHRASE} \
    -Dgpg.homedir=${GPG_HOMEDIR}

if [[ -n "${AUTORELEASE_PR}" ]]
then
  mvn nexus-staging:release -B \
    -DperformRelease=true \
    --settings=settings.xml
fi
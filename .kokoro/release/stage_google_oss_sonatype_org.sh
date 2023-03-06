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
requirementsFile=$(realpath $(dirname "$0")/../../)/.kokoro/requirements.txt
python3 -m pip install --require-hashes -r $requirementsFile
python3 -m releasetool publish-reporter-script > /tmp/publisher-script; source /tmp/publisher-script

source $(dirname "$0")/common.sh
MAVEN_SETTINGS_FILE=$(realpath $(dirname "$0")/../../)/settings.xml
pushd $(dirname "$0")/../../

setup_environment_secrets
create_settings_xml_file "settings.xml"

echo "Deploying artifacts to staging repositories in google.oss.sonatype.org"

# Excluding modules that cannot be published to the google.oss.sonatype.org
# publishing host.
# https://github.com/googleapis/google-cloud-java/issues/9045
excludedNonCloudModules=$(find java-maps-* -name 'pom.xml'  \
    |sed -e 's/^/!/' -e 's|/pom.xml$||' |xargs  |sed -e 's/ /,/g')
echo "Excluded modules: ${excludedNonCloudModules}"

mvn clean deploy -B \
  -DskipTests=true \
  -Dclirr.skip=true \
  --settings ${MAVEN_SETTINGS_FILE} \
  -Dorg.slf4j.simpleLogger.showDateTime=true -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
  -Dgpg.executable=gpg \
  -Dgpg.passphrase=${GPG_PASSPHRASE} \
  -Dgpg.homedir=${GPG_HOMEDIR} \
  --projects "${excludedNonCloudModules}" \
  -P release

# The job triggered by Release Please (release-trigger) has this AUTORELEASE_PR
# environment variable. Fusion also lets us to specify this variable.
if [[ -n "${AUTORELEASE_PR}" ]]
then
  echo "Releasing the staging repositories"
  mvn nexus-staging:release -B \
    -Dorg.slf4j.simpleLogger.showDateTime=true -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss:SSS \
    -DperformRelease=true \
    --settings=${MAVEN_SETTINGS_FILE}
else
  echo "AUTORELEASE_PR is not set. Not releasing."
fi



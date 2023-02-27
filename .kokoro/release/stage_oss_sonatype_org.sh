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

# This stage_oss_sonatype_org.sh publishes the artifacts to oss.sonatype.org publishing
# host, not google.oss.sonatype.org. A group ID of Maven artifact can belong to
# one publishing host. As of February 2023, com.google.maps group
# ID is not part of the google.oss.sonatype.org publishing host. In future when
# we move com.google.maps (and others) to the
# google.oss.sonatype.org publishing host, we can stop this job separated.

# Start the releasetool reporter
requirementsFile=$(realpath $(dirname "$0")/../../)/.kokoro/requirements.txt
python3 -m pip install --require-hashes -r $requirementsFile
python3 -m releasetool publish-reporter-script > /tmp/publisher-script; source /tmp/publisher-script

source $(dirname "$0")/common.sh
MAVEN_SETTINGS_FILE=$(realpath $(dirname "$0")/../../)/settings.xml
pushd $(dirname "$0")/../../

setup_environment_secrets
create_settings_xml_file "settings.xml"

echo "Deploying non-Cloud artifacts to staging repositories in oss.sonatype.org"

# Lists modules for Google Maps artifacts, including their submodules.
IncludedNonCloudModules=$(find java-maps-* -name 'pom.xml'  \
    |sed -e 's|/pom.xml$||' |xargs  |sed -e 's/ /,/g')
echo "Included modules: ${IncludedNonCloudModules}"

mvn clean deploy -B \
  -DskipTests=true \
  -Dclirr.skip=true \
  --settings ${MAVEN_SETTINGS_FILE} \
  -Dgpg.executable=gpg \
  -Dgpg.passphrase=${GPG_PASSPHRASE} \
  -Dgpg.homedir=${GPG_HOMEDIR} \
  --projects "${IncludedNonCloudModules}" \
  -P release \
  -DserverId=nexus \
  -DnexusUrl=https://oss.sonatype.org/


# The job triggered by Release Please (release-trigger) has this AUTORELEASE_PR
# environment variable. Fusion also lets us to specify this variable.
if [[ -n "${AUTORELEASE_PR}" ]]
then
  echo "Releasing the staging repositories"
  mvn nexus-staging:release -B \
    -DperformRelease=true \
    --settings=${MAVEN_SETTINGS_FILE} \
    -DserverId=nexus \
    -DnexusUrl=https://oss.sonatype.org/
else
  echo "AUTORELEASE_PR is not set. Not releasing."
fi



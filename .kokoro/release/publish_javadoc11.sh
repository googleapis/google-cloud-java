#!/bin/bash
# Copyright 2022 Google LLC
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

if [[ -z "${CREDENTIALS}" ]]; then
  CREDENTIALS=${KOKORO_KEYSTORE_DIR}/73713_docuploader_service_account
fi

if [[ -z "${STAGING_BUCKET_V2}" ]]; then
  echo "Need to set STAGING_BUCKET_V2 environment variable"
  exit 1
fi

# work from the git root directory
pushd $(dirname "$0")/../../

# install docuploader package
python3 -m pip install gcp-docuploader

# TODO: Change this to env_var
doclet_name="java-docfx-doclet-1.7.0.jar"

mvn -B -ntp \
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

# Retrieve list of modules from aggregator pom
modules=$(mvn help:evaluate -Dexpression=project.modules | grep '<.*>.*</.*>' | sed -e 's/<.*>\(.*\)<\/.*>/\1/g')
excluded_modules=('gapic-libraries-bom' 'google-cloud-jar-parent')

failed_modules=()

for module in $modules; do
  # Proceed if module is not excluded
  if [[ ! "${excluded_modules[*]}" =~ $module ]]; then
    pushd $module
    # Extract Cloud RAD module name from `distribution_name` in .repo-metadata.json
    NAME=$(grep -o '"distribution_name": "[^"]*' .repo-metadata.json | grep -o '[^"]*$' | cut -d ':' -f 2)
    # Extract (current) version from versions.txt and remove `-SNAPSHOT`
    VERSION=$(grep "^${NAME}:" versions.txt | cut -d: -f3 | sed -e 's/-SNAPSHOT//g')
    echo "Running for ${NAME}-${VERSION}"

    # cloud RAD generation
    mvn clean javadoc:aggregate -B -P docFX -DdocletPath=${KOKORO_GFILE_DIR}/${doclet_name}
    if [ "$?" -ne "0" ]; then
      failed_modules+=("${module}")
      continue
    fi
    # include CHANGELOG if exists
    if [ -e CHANGELOG.md ]; then
      cp CHANGELOG.md target/docfx-yml/history.md
    fi

    pushd target/docfx-yml

    # create metadata
    python3 -m docuploader create-metadata \
      --name ${NAME} \
      --version ${VERSION} \
      --xrefs devsite://java/gax \
      --xrefs devsite://java/google-cloud-core \
      --xrefs devsite://java/api-common \
      --xrefs devsite://java/proto-google-common-protos \
      --xrefs devsite://java/google-api-client \
      --xrefs devsite://java/google-http-client \
      --xrefs devsite://java/protobuf \
      --language java

    # upload yml to production bucket
    python3 -m docuploader upload . \
      --credentials ${CREDENTIALS} \
      --staging-bucket ${STAGING_BUCKET_V2} \
      --destination-prefix docfx

    popd # out of target/docfx-yml
    popd # out of $module
  fi
done

if [ ${#failed_modules[@]} -eq 0 ]; then
  echo "All modules uploaded to CloudRAD"
else
  echo "These modules failed: ${failed_modules[*]}"
  exit 1
fi

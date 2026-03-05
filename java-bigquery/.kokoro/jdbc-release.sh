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

set -euo pipefail

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd "${DIR}/../google-cloud-bigquery-jdbc"

FOLDER="$(pwd)/release"
DATE=$(date '+%Y-%m-%d')
COMMIT=$(git rev-parse --short HEAD)
PACKAGE="google-cloud-bigquery-jdbc"
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
BUCKET=${NIGHTLY_RELEASE_GCS_BUCKET}
NIGHTLY_BUILD_DESTINATION="${BUCKET}/nightly/${VERSION}/${DATE}"

# All dependencies release
mkdir -p "${FOLDER}"
make docker-package PACKAGE_DESTINATION="${FOLDER}"
NAME=${PACKAGE}-${VERSION}-${COMMIT}

gsutil cp -r "${FOLDER}/${PACKAGE}-${VERSION}.zip" "${NIGHTLY_BUILD_DESTINATION}/${NAME}.zip"
gsutil cp -r "${FOLDER}/${PACKAGE}-${VERSION}-all.jar" "${NIGHTLY_BUILD_DESTINATION}/${NAME}-all.jar"

rm -rf "${FOLDER}"

# # Update latest version
gsutil cp "${NIGHTLY_BUILD_DESTINATION}/${NAME}.zip" "${BUCKET}/${PACKAGE}-latest.zip"
gsutil cp "${NIGHTLY_BUILD_DESTINATION}/${NAME}-all.jar" "${BUCKET}/${PACKAGE}-latest-all.jar"

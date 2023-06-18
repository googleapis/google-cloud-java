#!/usr/bin/env bash

set -e
LIBRARY_GENERATION="$(dirname "$(readlink -f "$0")")"
REPO_ROOT="${LIBRARY_GENERATION}"/..
cd "${REPO_ROOT}"
# pull library generation tools from sdk-platform-java.
git clone https://github.com/googleapis/sdk-platform-java
SDK_PLATFORM_JAVA_ROOT=${REPO_ROOT}/sdk-platform-java
cd "${SDK_PLATFORM_JAVA_ROOT}"
git checkout feat/library-generation-tools
cp -r library_generation/* "${LIBRARY_GENERATION}"
rm -rf "${SDK_PLATFORM_JAVA_ROOT}"
# generate libraries in the proto path list.
cd "${LIBRARY_GENERATION}"
while IFS= read -r line
do
  PROTO_PATH=$(echo "${line}" | awk '{print $1}')
  CONTAINS_CLOUD=$(echo "${line}" | awk '{print $2}')
  TRANSPORT=$(echo "${line}" | awk '{print $3}')
  REST_NUMERIC_ENUMS=$(echo "${line}" | awk '{print $4}')
  INCLUDE_SAMPLES=$(echo "${line}" | awk '{print $5}')
  echo "Generate library in ${PROTO_PATH}"
  ./generate_library_with_fixed_dependencies.sh "${PROTO_PATH}" "${CONTAINS_CLOUD}" "${TRANSPORT}" "${REST_NUMERIC_ENUMS}" "${INCLUDE_SAMPLES}"
done < proto_path.txt

#!/usr/bin/env bash

set -e

LIBRARY_GEN_OUT=$(pwd)/../library_gen_out

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3

##################### Section 0 #####################
# prepare tooling
#####################################################
# proto files from googleapis repository
REPO_ROOT=$(pwd)/..
cd "${REPO_ROOT}"

if [ ! -d googleapis ]; then
  git clone https://github.com/googleapis/googleapis.git
fi

GOOGLEAPIS_ROOT=${REPO_ROOT}/googleapis
cd "${GOOGLEAPIS_ROOT}"
git checkout 53a0be29c4a95a1d3b4c0d3a7a2ac8b52af2a3c0
PROTO_FILES=$(ls google/monitoring/v3/*.proto)
# pull protoc executable from maven central
cd "${LIBRARY_GEN_OUT}"
curl -LJ -o protoc https://repo1.maven.org/maven2/com/google/protobuf/protoc/3.21.12/protoc-3.21.12-linux-x86_64.exe
chmod +x protoc
PROTOC_ROOT="${LIBRARY_GEN_OUT}"
echo "protoc version: $("${PROTOC_ROOT}"/protoc --version)"
# pull protoc-gen-grpc-java plugin from maven central
cd "${LIBRARY_GEN_OUT}"
curl -LJ -o protoc-gen-grpc-java https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/1.54.1/protoc-gen-grpc-java-1.54.1-linux-x86_64.exe
chmod +x protoc-gen-grpc-java
# gapic-generator-java
curl -LJ -o gapic-generator-java.jar https://repo1.maven.org/maven2/com/google/api/gapic-generator-java/2.19.0/gapic-generator-java-2.19.0.jar
##################### Section 1 #####################
# generate grpc-*/
#####################################################
cd "${GOOGLEAPIS_ROOT}"
"${PROTOC_ROOT}"/protoc "--plugin=protoc-gen-rpc-plugin=${LIBRARY_GEN_OUT}/protoc-gen-grpc-java" \
"--rpc-plugin_out=:${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_grpc-proto-gensrc.jar" \
${PROTO_FILES}

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/src/main/java
unzip -q -o "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_grpc-proto-gensrc.jar -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/src/main/java
rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/src/main/java/META-INF
# Remove empty files. If there are no resource names, one such file might have
# been created. See java_gapic.bzl.
find "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read -r f; do rm -f "${f}"; done
if [ -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
    mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/src/main/java/samples "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java
fi
##################### Section 2 #####################
# generate gapic-*/, proto-*/, samples/
#####################################################
"${PROTOC_ROOT}"/protoc --experimental_allow_proto3_optional \
"--plugin=protoc-gen-java_gapic=${REPO_ROOT}/gapic-generator-java-wrapper" \
"--java_gapic_out=metadata:${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip" \
"--java_gapic_opt=transport=grpc,rest-numeric-enums,grpc-service-config=google/monitoring/v3/monitoring_grpc_service_config.json,gapic-config=google/monitoring/v3/monitoring_gapic.yaml,api-service-config=google/monitoring/v3/monitoring.yaml" \
${PROTO_FILES} google/cloud/common_resources.proto

unzip -o -q "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/
# Sync'\''d to the output file name in Writer.java.
unzip -o -q "${LIBRARY_GEN_OUT}"/google/monitoring/v3/temp-codegen.srcjar -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar
# Resource name source files.
PROTO_DIR=${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar/proto/src/main/java
if [ ! -d "${PROTO_DIR}" ]
then
  # Some APIs don'\''t have resource name helpers, like BigQuery v2.
  # Create an empty file so we can finish building. Gating the resource name rule definition
  # on file existences go against Bazel'\''s design patterns, so we'\''ll simply delete all empty
  # files during the final packaging process (see java_gapic_pkg.bzl)
  mkdir -p "${PROTO_DIR}"
  touch "${PROTO_DIR}"/PlaceholderFile.java
fi
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar/proto/src/main/java
zip -r "${LIBRARY_GEN_OUT}"/monitoring_java_gapic_srcjar-resource-name.srcjar ./

cd "${LIBRARY_GEN_OUT}"
# Main source files.
mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/main
cp -r "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar/src/main/java "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/main
rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/main/java/META-INF
# Remove empty files. If there are no resource names, one such file might have
# been created. See java_gapic.bzl.
find "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read f; do rm -f "${f}"; done

if [ -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
    mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/main/java/samples "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java
fi
# Test source files.
mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/test
cp -r "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar/src/test/java -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/test
rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/src/test/java/META-INF
# Sample source files.
mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/samples/snippets/generated/
cp -r "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar/samples/snippets/generated/src/main/java/com -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/samples/snippets/generated/
##################### Section 3 #####################
# generate proto-*/
#####################################################
cd "${GOOGLEAPIS_ROOT}"
"${PROTOC_ROOT}"/protoc "--java_out=${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_proto-speed-src.jar" ${PROTO_FILES}

for src in ${LIBRARY_GEN_OUT}/monitoring_java_gapic_srcjar-resource-name.srcjar ${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_proto-speed-src.jar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/java
    unzip -q -o "${src}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/java
    rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/java/META-INF

    # Remove empty files. If there are no resource names, one such file might have
    # been created. See java_gapic.bzl.
    find "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read -r f; do rm -f "${f}"; done

    if [ -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
        mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/java/samples "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java
    fi
done
for proto_src in ${PROTO_FILES}; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/proto
    cp -f --parents "${proto_src}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/src/main/proto
done
##################### Section 4 #####################
# compare source code with googleapis-gen
#####################################################
echo "Compare source code with googleapis-gen"
cd "${REPO_ROOT}"
./compare.sh

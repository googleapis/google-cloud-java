#!/usr/bin/env bash

set -e

GOOGLEAPIS_COMMIT=$1
PROTOBUF_VERSION=$2
GRPC_VERSION=$3
GAPIC_GENERATOR_VERSION=$4
PROTO_PATH=$5
IS_CLOUD_SDK=$6
JAVA_GAPIC_OPT=$7
OUT_LAYER_FOLDER="${PROTO_PATH////-}-java"
if [ "${IS_CLOUD_SDK}" == true ]; then
  OUT_LAYER_FOLDER="${OUT_LAYER_FOLDER//google/google-cloud}"
fi

LIBRARY_GEN_OUT=$(pwd)/../library_gen_out
mkdir -p "${LIBRARY_GEN_OUT}/${PROTO_PATH}"

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
git checkout "${GOOGLEAPIS_COMMIT}"
PROTO_FILES=$(ls "${PROTO_PATH}"/*.proto)
# pull proto files and protoc from protobuf repository
# maven central doesn't have proto files
cd "${LIBRARY_GEN_OUT}"
curl -LJ -o protobuf.zip https://github.com/protocolbuffers/protobuf/releases/download/v"${PROTOBUF_VERSION}"/protoc-"${PROTOBUF_VERSION}"-linux-x86_64.zip
unzip -o -q protobuf.zip -d protobuf/
cp -r protobuf/include/google "${GOOGLEAPIS_ROOT}"
PROTOC_ROOT=${LIBRARY_GEN_OUT}/protobuf/bin
echo "protoc version: $("${PROTOC_ROOT}"/protoc --version)"
# pull protoc-gen-grpc-java plugin from maven central
cd "${LIBRARY_GEN_OUT}"
curl -LJ -o protoc-gen-grpc-java https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/"${GRPC_VERSION}"/protoc-gen-grpc-java-"${GRPC_VERSION}"-linux-x86_64.exe
chmod +x protoc-gen-grpc-java
# gapic-generator-java
curl -LJ -o gapic-generator-java.jar https://repo1.maven.org/maven2/com/google/api/gapic-generator-java/"${GAPIC_GENERATOR_VERSION}"/gapic-generator-java-"${GAPIC_GENERATOR_VERSION}".jar
# define utility functions
remove_empty_files() {
  FOLDER=$1
  find "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/main/java -type f -size 0 | while read -r f; do rm -f "${f}"; done
  if [ -d "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/main/java/samples ]; then
      mv "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/main/java/samples "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER}"-"${OUT_LAYER_FOLDER}"
  fi
}

mv_src_files() {
  FOLDER=$1 # one of gapic, proto, samples
  TYPE=$2 # one of main, test
  if [ "${FOLDER}" == "samples" ]; then
    FOLDER_SUFFIX="samples/snippets/generated"
    SRC_SUFFIX="samples/snippets/generated/src/main/java/com"
  elif [ "${FOLDER}" == "proto" ]; then
    FOLDER_SUFFIX="${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/"${TYPE}"
    SRC_SUFFIX="${FOLDER}/src/${TYPE}/java"
  else
    FOLDER_SUFFIX="${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/"${TYPE}"
    SRC_SUFFIX="src/${TYPE}/java"
  fi
  mkdir -p "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER_SUFFIX}"
  cp -r "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/java_gapic_srcjar/"${SRC_SUFFIX}" "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER_SUFFIX}"
  if [ "${FOLDER}" != "samples" ]; then
    rm -r -f "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER_SUFFIX}"/java/META-INF
  fi
}

unzip_src_files() {
  FOLDER=$1
  JAR_FILE=java_"${FOLDER}".jar
  mkdir -p "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/main/java
  unzip -q -o "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${JAR_FILE}" -d "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/main/java
  rm -r -f "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/"${FOLDER}"-"${OUT_LAYER_FOLDER}"/src/main/java/META-INF
}

##################### Section 1 #####################
# generate grpc-*/
#####################################################
cd "${GOOGLEAPIS_ROOT}"
"${PROTOC_ROOT}"/protoc "--plugin=protoc-gen-rpc-plugin=${LIBRARY_GEN_OUT}/protoc-gen-grpc-java" \
"--rpc-plugin_out=:${LIBRARY_GEN_OUT}/${PROTO_PATH}/java_grpc.jar" \
${PROTO_FILES}

unzip_src_files "grpc"
remove_empty_files "grpc"
##################### Section 2 #####################
# generate gapic-*/, proto-*/, samples/
#####################################################
"${PROTOC_ROOT}"/protoc --experimental_allow_proto3_optional \
"--plugin=protoc-gen-java_gapic=${REPO_ROOT}/library_generation/gapic-generator-java-wrapper" \
"--java_gapic_out=metadata:${LIBRARY_GEN_OUT}/${PROTO_PATH}/java_gapic_srcjar_raw.srcjar.zip" \
"--java_gapic_opt=${JAVA_GAPIC_OPT}" \
${PROTO_FILES} google/cloud/common_resources.proto

unzip -o -q "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/java_gapic_srcjar_raw.srcjar.zip -d "${LIBRARY_GEN_OUT}"/${PROTO_PATH}
# Sync'\''d to the output file name in Writer.java.
unzip -o -q "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/temp-codegen.srcjar -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/java_gapic_srcjar
# Resource name source files.
PROTO_DIR=${LIBRARY_GEN_OUT}/${PROTO_PATH}/java_gapic_srcjar/proto/src/main/java
if [ ! -d "${PROTO_DIR}" ]
then
  # Some APIs don'\''t have resource name helpers, like BigQuery v2.
  # Create an empty file so we can finish building. Gating the resource name rule definition
  # on file existences go against Bazel'\''s design patterns, so we'\''ll simply delete all empty
  # files during the final packaging process (see java_gapic_pkg.bzl)
  mkdir -p "${PROTO_DIR}"
  touch "${PROTO_DIR}"/PlaceholderFile.java
fi

cd "${LIBRARY_GEN_OUT}"
# Main source files.
mv_src_files "gapic" "main"
remove_empty_files "gapic"
# Test source files.
mv_src_files "gapic" "test"
# Sample source files.
mv_src_files "samples" "main"
##################### Section 3 #####################
# generate proto-*/
#####################################################
cd "${GOOGLEAPIS_ROOT}"
"${PROTOC_ROOT}"/protoc "--java_out=${LIBRARY_GEN_OUT}/${PROTO_PATH}/java_proto.jar" ${PROTO_FILES}
mv_src_files "proto" "main"
unzip_src_files "proto"
remove_empty_files "proto"

for proto_src in ${PROTO_FILES}; do
    mkdir -p "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/proto-"${OUT_LAYER_FOLDER}"/src/main/proto
    cp -f --parents "${proto_src}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/"${OUT_LAYER_FOLDER}"/proto-"${OUT_LAYER_FOLDER}"/src/main/proto
done
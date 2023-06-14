#!/usr/bin/env bash

set -xe

GOOGLEAPIS_COMMIT=$1
PROTOBUF_VERSION=$2
GRPC_VERSION=$3
GAPIC_GENERATOR_VERSION=$4
PROTO_PATH=$5
CONTAINS_CLOUD=$6
TRANSPORT=$7 # grpc+rest or grpc
REST_NUMERIC_ENUMS=$8 # true or false
INCLUDE_SAMPLES=$9 # true or false
if [ -z "${INCLUDE_SAMPLES}" ]; then
  INCLUDE_SAMPLES="true"
fi
OUT_LAYER_FOLDER="${PROTO_PATH////-}-java"
if [ "${CONTAINS_CLOUD}" == true ]; then
  OUT_LAYER_FOLDER="${OUT_LAYER_FOLDER//google/google-cloud}"
fi

LIBRARY_GEN_OUT=$(dirname "$(readlink -f "$0")")/../library_gen_out
REPO_ROOT="${LIBRARY_GEN_OUT}"/..
mkdir -p "${LIBRARY_GEN_OUT}/${PROTO_PATH}"

##################### Section 0 #####################
# prepare tooling
#####################################################
# proto files from googleapis repository
cd "${REPO_ROOT}"

if [ ! -d googleapis ]; then
  git clone https://github.com/googleapis/googleapis.git
fi

GOOGLEAPIS_ROOT=${REPO_ROOT}/googleapis
cd "${GOOGLEAPIS_ROOT}"
git checkout "${GOOGLEAPIS_COMMIT}"
# the order of services entries in gapic_metadata.json is relevant to the
# order of proto file, sort the proto files with respect to their name to
# get a fixed order.
PROTO_FILES=$(find "${PROTO_PATH}" -type f  -name "*.proto" | sort)
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

find_additional_protos_in_yaml() {
  PATTERN=$1
  FIND_RESULT=$(grep --include=\*.yaml -rw "${PROTO_PATH}" -e "${PATTERN}")
  if [ -n "${FIND_RESULT}" ]; then
    echo "${FIND_RESULT}"
  fi
}

search_additional_protos() {
  ADDITIONAL_PROTOS="google/cloud/common_resources.proto" # used by every library
  IAM_POLICY=$(find_additional_protos_in_yaml "name: google.iam.v1.IAMPolicy")
  if [ -n "${IAM_POLICY}" ]; then
    ADDITIONAL_PROTOS="${ADDITIONAL_PROTOS} google/iam/v1/iam_policy.proto"
  fi
  LOCATIONS=$(find_additional_protos_in_yaml "name: google.cloud.location.Locations")
  if [ -n "${LOCATIONS}" ]; then
    ADDITIONAL_PROTOS="${ADDITIONAL_PROTOS} google/cloud/location/locations.proto"
  fi
  echo "${ADDITIONAL_PROTOS}"
}

get_gapic_opts() {
  GAPIC_CONFIG=$(find "${PROTO_PATH}" -type f -name "*gapic.yaml")
  if [ -z "${GAPIC_CONFIG}" ]; then
    GAPIC_CONFIG=""
  else
    GAPIC_CONFIG="gapic-config=${GAPIC_CONFIG},"
  fi
  GRPC_SERVICE_CONFIG=$(find "${PROTO_PATH}" -type f -name "*service_config.json")
  API_SERVICE_CONFIG=$(find "${PROTO_PATH}" -maxdepth 1 -type f \( -name "*.yaml" ! -name "*gapic.yaml" \))
  if [ "${REST_NUMERIC_ENUMS}" == "true" ]; then
    REST_NUMERIC_ENUMS="rest-numeric-enums,"
  else
    REST_NUMERIC_ENUMS=""
  fi
  echo "transport=${TRANSPORT},${REST_NUMERIC_ENUMS}grpc-service-config=${GRPC_SERVICE_CONFIG},${GAPIC_CONFIG}api-service-config=${API_SERVICE_CONFIG}"
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
"--java_gapic_opt=$(get_gapic_opts)" \
${PROTO_FILES} $(search_additional_protos)

unzip -o -q "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/java_gapic_srcjar_raw.srcjar.zip -d "${LIBRARY_GEN_OUT}"/${PROTO_PATH}
# Sync'\''d to the output file name in Writer.java.
unzip -o -q "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/temp-codegen.srcjar -d "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/java_gapic_srcjar
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
if [ "${INCLUDE_SAMPLES}" == "true" ]; then
  # Sample source files.
  mv_src_files "samples" "main"
fi
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
    cp -f --parents "${proto_src}" "${LIBRARY_GEN_OUT}"/"${PROTO_PATH}"/"${OUT_LAYER_FOLDER}"/proto-"${OUT_LAYER_FOLDER}"/src/main/proto
done
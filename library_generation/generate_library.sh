#!/usr/bin/env bash

set -e

GOOGLEAPIS_COMMIT=$1
PROTOBUF_VERSION=$2
GRPC_VERSION=$3
GAPIC_GENERATOR_VERSION=$4


LIBRARY_GEN_OUT=$(pwd)/../library_gen_out
mkdir -p "${LIBRARY_GEN_OUT}"

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
# pull protoc executable from maven central
cd "${LIBRARY_GEN_OUT}"
curl -LJ -o protoc https://repo1.maven.org/maven2/com/google/protobuf/protoc/"${PROTOBUF_VERSION}"/protoc-"${PROTOBUF_VERSION}"-linux-x86_64.exe
chmod +x protoc
PROTOC_ROOT="${LIBRARY_GEN_OUT}"
echo "protoc version: $("${PROTOC_ROOT}"/protoc --version)"
# pull protoc-gen-grpc-java plugin from maven central
cd "${LIBRARY_GEN_OUT}"
curl -LJ -o protoc-gen-grpc-java https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/"${GRPC_VERSION}"/protoc-gen-grpc-java-"${GRPC_VERSION}"-linux-x86_64.exe
chmod +x protoc-gen-grpc-java
# gapic-generator-java
curl -LJ -o gapic-generator-java.jar https://repo1.maven.org/maven2/com/google/api/gapic-generator-java/"${GAPIC_GENERATOR_VERSION}"/gapic-generator-java-"${GAPIC_GENERATOR_VERSION}".jar

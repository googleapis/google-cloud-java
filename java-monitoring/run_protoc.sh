#!/usr/bin/env bash

set -e

LIBRARY_GEN_OUT=$(pwd)/../library_gen_out

mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf
mkdir -p "${LIBRARY_GEN_OUT}"/google/api
mkdir -p "${LIBRARY_GEN_OUT}"/google/rpc
mkdir -p "${LIBRARY_GEN_OUT}"/google/type
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
# pull proto files and protoc from protobuf repository
# maven central doesn't have proto files
cd "${REPO_ROOT}"
curl -LJ -o protobuf.zip https://github.com/protocolbuffers/protobuf/releases/download/v21.12/protoc-21.12-linux-x86_64.zip
unzip -o -q protobuf.zip -d protobuf/
cp -r protobuf/include/google "${GOOGLEAPIS_ROOT}"
PROTOC_ROOT=${REPO_ROOT}/protobuf/bin
echo "protoc version: $("${PROTOC_ROOT}"/protoc --version)"
# pull protoc-gen-grpc-java plugin from maven central
cd "${LIBRARY_GEN_OUT}"
curl -LJ -o protoc-gen-grpc-java https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/1.54.1/protoc-gen-grpc-java-1.54.1-linux-x86_64.exe
chmod +x protoc-gen-grpc-java
# gapic-generator-java
curl -LJ -o gapic-generator-java.jar https://repo1.maven.org/maven2/com/google/api/gapic-generator-java/2.19.0/gapic-generator-java-2.19.0.jar
##################### Section 1 #####################
# generate grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz
#####################################################
cd "${GOOGLEAPIS_ROOT}"
"${PROTOC_ROOT}"/protoc "--plugin=protoc-gen-rpc-plugin=${LIBRARY_GEN_OUT}/protoc-gen-grpc-java" "--rpc-plugin_out=:${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_grpc-proto-gensrc.jar" ${PROTO_FILES} \

for src in ${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_grpc-proto-gensrc.jar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java
    unzip -q -o "${src}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java
    rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java/META-INF

    # Remove empty files. If there are no resource names, one such file might have
    # been created. See java_gapic.bzl.
    find "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read -r f; do rm -f "${f}"; done

    if [ -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
        mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java/samples "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java
    fi
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/..
tar -zchpf grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz grpc-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

##################### Section 2 #####################
# generate gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz
#####################################################
"${PROTOC_ROOT}"/protoc --experimental_allow_proto3_optional \
"--plugin=protoc-gen-java_gapic=${REPO_ROOT}/gapic-generator-java-wrapper" \
"--java_gapic_out=metadata:${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip" \
"--java_gapic_opt=transport=grpc,rest-numeric-enums,grpc-service-config=google/monitoring/v3/monitoring_grpc_service_config.json,gapic-config=google/monitoring/v3/monitoring_gapic.yaml,api-service-config=google/monitoring/v3/monitoring.yaml" \
${PROTO_FILES} google/cloud/common_resources.proto

unzip -o -q "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/
# Sync'\''d to the output file name in Writer.java.
unzip -o -q "${LIBRARY_GEN_OUT}"/google/monitoring/v3/temp-codegen.srcjar -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar

# Main source files.
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar/src/main/java
zip -r "${LIBRARY_GEN_OUT}"/monitoring_java_gapic_srcjar.srcjar ./

# Resource name source files.
PROTO_DIR=${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar/proto/src/main/java
PROTO_SRCJAR=${LIBRARY_GEN_OUT}/monitoring_java_gapic_srcjar-resource-name.srcjar
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
zip -r "${PROTO_SRCJAR}" ./

# Test source files.
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar/src/test/java
zip -r "${LIBRARY_GEN_OUT}"/monitoring_java_gapic_srcjar-tests.srcjar ./

# Sample source files.
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar/samples/snippets/generated/src/main/java
zip -r "${LIBRARY_GEN_OUT}"/monitoring_java_gapic_srcjar-samples.srcjar ./

cd "${LIBRARY_GEN_OUT}"

mv monitoring_java_gapic_srcjar.srcjar "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar.srcjar
mv monitoring_java_gapic_srcjar-resource-name.srcjar "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar-resource-name.srcjar
mv monitoring_java_gapic_srcjar-tests.srcjar "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar-test.srcjar
mv monitoring_java_gapic_srcjar-samples.srcjar "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar-samples.srcjar

unzip -o -q  "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar
# Sync'\''d to the output file name in Writer.java.
unzip -o -q "${LIBRARY_GEN_OUT}"/google/monitoring/v3/temp-codegen.srcjar -d  "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_samples

# Sample source files.
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_samples/samples/snippets/generated/src/main/java
zip -r "${LIBRARY_GEN_OUT}"/monitoring_java_gapic_samples-samples.srcjar ./
cd "${LIBRARY_GEN_OUT}"
mv monitoring_java_gapic_samples-samples.srcjar "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar

for s in ${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
    unzip -o -q "${s}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
done

for src in ${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar.srcjar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java
    unzip -q -o "${src}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java
    rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java/META-INF

    # Remove empty files. If there are no resource names, one such file might have
    # been created. See java_gapic.bzl.
    find "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read f; do rm -f "${f}"; done

    if [ -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
        mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java/samples "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java
    fi
done

for test_src in ${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar-test.srcjar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/test/java
    unzip -q -o "${test_src}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/test/java
    rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/test/java/META-INF
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/..
tar -zchpf gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz gapic-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

##################### Section 3 #####################
# generate proto-google-cloud-monitoring-v3-java-resources.tar.gz
#####################################################
cd "${GOOGLEAPIS_ROOT}"
"${PROTOC_ROOT}"/protoc "--java_out=${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_proto-speed-src.jar" ${PROTO_FILES}

for src in ${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar-resource-name.srcjar ${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_proto-speed-src.jar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java
    unzip -q -o "${src}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java
    rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java/META-INF

    # Remove empty files. If there are no resource names, one such file might have
    # been created. See java_gapic.bzl.
    find "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read -r f; do rm -f "${f}"; done

    if [ -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
        mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java/samples "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java
    fi
done
for proto_src in google/monitoring/v3/alert.proto google/monitoring/v3/alert_service.proto google/monitoring/v3/common.proto google/monitoring/v3/dropped_labels.proto google/monitoring/v3/group.proto google/monitoring/v3/group_service.proto google/monitoring/v3/metric.proto google/monitoring/v3/metric_service.proto google/monitoring/v3/mutation_record.proto google/monitoring/v3/notification.proto google/monitoring/v3/notification_service.proto google/monitoring/v3/query_service.proto google/monitoring/v3/service.proto google/monitoring/v3/service_service.proto google/monitoring/v3/snooze.proto google/monitoring/v3/snooze_service.proto google/monitoring/v3/span_context.proto google/monitoring/v3/uptime.proto google/monitoring/v3/uptime_service.proto; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/proto
    cp -f --parents "${proto_src}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/proto
done

cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/..
tar -zchpf proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz proto-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java

##################### Section 5 #####################
# generate grpc-google-cloud-monitoring-v3-java.tar.gz
#####################################################
mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java
for dep in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf "${dep}" -C "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/.

tar -zchpf ./grpc-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java.tar.gz
rm -rf "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java

##################### Section 6 #####################
# generate proto-google-cloud-monitoring-v3-java.tar.gz
#####################################################
mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java
for dep in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf "${dep}" -C "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/.

tar -zchpf ./proto-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java.tar.gz
rm -rf "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java

##################### Section 7 #####################
# generate gapic-google-cloud-monitoring-v3-java.tar.gz
#####################################################
mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java
for dep in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf "${dep}" -C "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/.

tar -zchpf ./gapic-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java.tar.gz
rm -rf "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java

##################### Section 8 #####################
# generate google-cloud-monitoring-v3-java.tar.gz
#####################################################
for s in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
    unzip -q -o "${s}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
done

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
for dep in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java.tar.gz; do
    tar -xzpf "${dep}" -C "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/..

tar -zchpf google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java.tar.gz
rm -rf "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java

for s in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
    unzip -q -o "${s}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
done

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
for dep in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java.tar.gz; do
    tar -xzpf "${dep}" -C "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/..

tar -zchpf google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java.tar.gz
rm -rf "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java

##################### Section 9 #####################
# compare source code with googleapis-gen
#####################################################
echo "Compare source code with googleapis-gen"
cd "${REPO_ROOT}"
./compare.sh

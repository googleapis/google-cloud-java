#!/usr/bin/env bash

set -e

LIBRARY_GEN_OUT=$(pwd)/../library_gen_out

mkdir -p "${LIBRARY_GEN_OUT}"/gapic_generator_java/rules_java_gapic
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/descriptor_proto
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/duration_proto
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/any_proto
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/timestamp_proto
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/struct_proto
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/empty_proto
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/field_mask_proto
mkdir -p "${LIBRARY_GEN_OUT}"/com_google_protobuf/wrappers_proto
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
# generate descriptor files
#####################################################
cd "${GOOGLEAPIS_ROOT}"
# http.proto is a transitive dependency of google/api/annotations.proto, which is from monitoring_proto in google/monitoring/v3:BUILD
"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/http.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:http_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/http_proto-descriptor-set.proto.bin" \
--include_source_info \
--experimental_allow_proto3_optional \
"-Igoogle/api/http.proto=google/api/http.proto" \
google/api/http.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/any.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:any_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/any_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/any_proto" \
--include_source_info \
--experimental_allow_proto3_optional \
"-Igoogle/protobuf/any.proto=google/protobuf/any.proto" \
google/protobuf/any.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/descriptor.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:descriptor_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
--include_source_info \
--experimental_allow_proto3_optional \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
google/protobuf/descriptor.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/duration.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:duration_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/duration_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/duration_proto" \
"-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto" \
google/protobuf/duration.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/empty.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:empty_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/empty_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/empty_proto" \
--include_source_info \
--experimental_allow_proto3_optional \
"-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto" \
google/protobuf/empty.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/field_mask.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:field_mask_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/field_mask_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/field_mask_proto" \
"-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto" \
google/protobuf/field_mask.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/struct.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:struct_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/struct_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/struct_proto" \
--include_source_info \
--experimental_allow_proto3_optional \
"-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto" \
google/protobuf/struct.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/timestamp.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:timestamp_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/timestamp_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/timestamp_proto" \
--include_source_info \
--experimental_allow_proto3_optional \
"-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto" \
google/protobuf/timestamp.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/wrappers.proto \
"--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:wrappers_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/com_google_protobuf/wrappers_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/wrappers_proto" \
"-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto" \
google/protobuf/wrappers.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/launch_stage.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:launch_stage_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/launch_stage_proto-descriptor-set.proto.bin" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
google/api/launch_stage.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/http.proto:google/protobuf/descriptor.proto:google/api/annotations.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:annotations_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/annotations_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
"-Igoogle/api/annotations.proto=google/api/annotations.proto" \
"-Igoogle/api/http.proto=google/api/http.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
google/api/annotations.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/launch_stage.proto:google/protobuf/descriptor.proto:google/protobuf/duration.proto:google/api/client.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:client_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/client_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/duration_proto" \
"-Igoogle/api/client.proto=google/api/client.proto" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
"-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto" \
google/api/client.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/annotations.proto:google/protobuf/any.proto:google/protobuf/timestamp.proto:google/api/distribution.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:distribution_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/distribution_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/any_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/timestamp_proto" \
"-Igoogle/api/distribution.proto=google/api/distribution.proto" \
"-Igoogle/api/annotations.proto=google/api/annotations.proto" \
"-Igoogle/api/http.proto=google/api/http.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
"-Igoogle/protobuf/any.proto=google/protobuf/any.proto" \
"-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto" \
google/api/distribution.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/descriptor.proto:google/api/field_behavior.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:field_behavior_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/field_behavior_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
"-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
google/api/field_behavior.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/label.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:label_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/label_proto-descriptor-set.proto.bin" \
--include_source_info \
--experimental_allow_proto3_optional \
"-Igoogle/api/label.proto=google/api/label.proto" \
google/api/label.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/launch_stage.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:launch_stage_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/launch_stage_proto-descriptor-set.proto.bin" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
google/api/launch_stage.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/label.proto:google/api/launch_stage.proto:google/protobuf/duration.proto:google/api/metric.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:metric_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/metric_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/duration_proto" \
"-Igoogle/api/metric.proto=google/api/metric.proto" \
"-Igoogle/api/label.proto=google/api/label.proto" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
"-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto" \
google/api/metric.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/label.proto:google/api/launch_stage.proto:google/protobuf/struct.proto:google/api/monitored_resource.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:monitored_resource_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/monitored_resource_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/struct_proto" \
"-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto" \
"-Igoogle/api/label.proto=google/api/label.proto" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
"-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto" \
google/api/monitored_resource.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/descriptor.proto:google/api/resource.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/api:resource_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/api/resource_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
"-Igoogle/api/resource.proto=google/api/resource.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
google/api/resource.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/protobuf/any.proto:google/rpc/status.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/rpc:status_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/rpc/status_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/any_proto" \
"-Igoogle/rpc/status.proto=google/rpc/status.proto" \
"-Igoogle/protobuf/any.proto=google/protobuf/any.proto" \
google/rpc/status.proto

"${PROTOC_ROOT}"/protoc --direct_dependencies google/type/calendar_period.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/type:calendar_period_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/type/calendar_period_proto-descriptor-set.proto.bin" \
"-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto" \
google/type/calendar_period.proto

# use all proto files to generate ${WORKING_DIR}/google/monitoring/v3/monitoring_proto-descriptor-set.proto.bin
"${PROTOC_ROOT}"/protoc --direct_dependencies google/api/annotations.proto:google/api/client.proto:google/api/distribution.proto:google/api/field_behavior.proto:google/api/label.proto:google/api/launch_stage.proto:google/api/metric.proto:google/api/monitored_resource.proto:google/api/resource.proto:google/rpc/status.proto:google/type/calendar_period.proto:google/protobuf/duration.proto:google/protobuf/empty.proto:google/protobuf/field_mask.proto:google/protobuf/timestamp.proto:google/protobuf/wrappers.proto:google/monitoring/v3/alert.proto:google/monitoring/v3/alert_service.proto:google/monitoring/v3/common.proto:google/monitoring/v3/dropped_labels.proto:google/monitoring/v3/group.proto:google/monitoring/v3/group_service.proto:google/monitoring/v3/metric.proto:google/monitoring/v3/metric_service.proto:google/monitoring/v3/mutation_record.proto:google/monitoring/v3/notification.proto:google/monitoring/v3/notification_service.proto:google/monitoring/v3/query_service.proto:google/monitoring/v3/service.proto:google/monitoring/v3/service_service.proto:google/monitoring/v3/snooze.proto:google/monitoring/v3/snooze_service.proto:google/monitoring/v3/span_context.proto:google/monitoring/v3/uptime.proto:google/monitoring/v3/uptime_service.proto \
"--direct_dependencies_violation_msg=%s is imported, but //google/monitoring/v3:monitoring_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it." \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_proto-descriptor-set.proto.bin" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/duration_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/any_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/timestamp_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/struct_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/empty_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/field_mask_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/wrappers_proto" \
"-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto" \
"-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto" \
"-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto" \
"-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto" \
"-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto" \
"-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto" \
"-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto" \
"-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto" \
"-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto" \
"-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto" \
"-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto" \
"-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto" \
"-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto" \
"-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto" \
"-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto" \
"-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto" \
"-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto" \
"-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto" \
"-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto" \
"-Igoogle/api/annotations.proto=google/api/annotations.proto" \
"-Igoogle/api/http.proto=google/api/http.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
"-Igoogle/api/client.proto=google/api/client.proto" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
"-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto" \
"-Igoogle/api/distribution.proto=google/api/distribution.proto" \
"-Igoogle/protobuf/any.proto=google/protobuf/any.proto" \
"-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto" \
"-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto" \
"-Igoogle/api/label.proto=google/api/label.proto" \
"-Igoogle/api/metric.proto=google/api/metric.proto" \
"-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto" \
"-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto" \
"-Igoogle/api/resource.proto=google/api/resource.proto" \
"-Igoogle/rpc/status.proto=google/rpc/status.proto" \
"-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto" \
"-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto" \
"-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto" \
"-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto" \
google/monitoring/v3/alert.proto \
google/monitoring/v3/alert_service.proto \
google/monitoring/v3/common.proto \
google/monitoring/v3/dropped_labels.proto \
google/monitoring/v3/group.proto \
google/monitoring/v3/group_service.proto \
google/monitoring/v3/metric.proto \
google/monitoring/v3/metric_service.proto \
google/monitoring/v3/mutation_record.proto \
google/monitoring/v3/notification.proto \
google/monitoring/v3/notification_service.proto \
google/monitoring/v3/query_service.proto \
google/monitoring/v3/service.proto \
google/monitoring/v3/service_service.proto \
google/monitoring/v3/snooze.proto \
google/monitoring/v3/snooze_service.proto \
google/monitoring/v3/span_context.proto \
google/monitoring/v3/uptime.proto \
google/monitoring/v3/uptime_service.proto

##################### Section 2 #####################
# generate descriptor files (proto_library_with_info)
#####################################################
"${PROTOC_ROOT}"/protoc --include_imports \
--include_source_info \
--experimental_allow_proto3_optional \
"--descriptor_set_out=${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_proto_with_info-set.proto.bin" \
"-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto" \
"-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto" \
"-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto" \
"-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto" \
"-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto" \
"-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto" \
"-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto" \
"-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto" \
"-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto" \
"-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto" \
"-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto" \
"-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto" \
"-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto" \
"-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto" \
"-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto" \
"-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto" \
"-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto" \
"-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto" \
"-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto" \
"-Igoogle/api/annotations.proto=google/api/annotations.proto" \
"-Igoogle/api/http.proto=google/api/http.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
"-Igoogle/api/client.proto=google/api/client.proto" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
"-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto" \
"-Igoogle/api/distribution.proto=google/api/distribution.proto" \
"-Igoogle/protobuf/any.proto=google/protobuf/any.proto" \
"-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto" \
"-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto" \
"-Igoogle/api/label.proto=google/api/label.proto" \
"-Igoogle/api/metric.proto=google/api/metric.proto" \
"-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto" \
"-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto" \
"-Igoogle/api/resource.proto=google/api/resource.proto" \
"-Igoogle/rpc/status.proto=google/rpc/status.proto" \
"-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto" \
"-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto" \
"-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto" \
"-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto" \
"-Igoogle/cloud/common_resources.proto=google/cloud/common_resources.proto" \
google/monitoring/v3/alert.proto \
google/monitoring/v3/alert_service.proto \
google/monitoring/v3/common.proto \
google/monitoring/v3/dropped_labels.proto \
google/monitoring/v3/group.proto \
google/monitoring/v3/group_service.proto \
google/monitoring/v3/metric.proto \
google/monitoring/v3/metric_service.proto \
google/monitoring/v3/mutation_record.proto \
google/monitoring/v3/notification.proto \
google/monitoring/v3/notification_service.proto \
google/monitoring/v3/query_service.proto \
google/monitoring/v3/service.proto \
google/monitoring/v3/service_service.proto \
google/monitoring/v3/snooze.proto \
google/monitoring/v3/snooze_service.proto \
google/monitoring/v3/span_context.proto \
google/monitoring/v3/uptime.proto \
google/monitoring/v3/uptime_service.proto \
google/cloud/common_resources.proto

##################### Section 2 #####################
# generate grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz
#####################################################
"${PROTOC_ROOT}"/protoc "--plugin=protoc-gen-rpc-plugin=${LIBRARY_GEN_OUT}/protoc-gen-grpc-java" \
"--rpc-plugin_out=:${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_grpc-proto-gensrc.jar" \
--descriptor_set_in "${LIBRARY_GEN_OUT}"/google/api/http_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/descriptor_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/annotations_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/launch_stage_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/duration_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/client_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/any_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/timestamp_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/distribution_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/field_behavior_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/label_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/metric_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/struct_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/monitored_resource_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/api/resource_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/rpc/status_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/type/calendar_period_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/empty_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/field_mask_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/com_google_protobuf/wrappers_proto-descriptor-set.proto.bin:"${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_proto-descriptor-set.proto.bin \
google/monitoring/v3/alert.proto \
google/monitoring/v3/alert_service.proto \
google/monitoring/v3/common.proto \
google/monitoring/v3/dropped_labels.proto \
google/monitoring/v3/group.proto \
google/monitoring/v3/group_service.proto \
google/monitoring/v3/metric.proto \
google/monitoring/v3/metric_service.proto \
google/monitoring/v3/mutation_record.proto \
google/monitoring/v3/notification.proto \
google/monitoring/v3/notification_service.proto \
google/monitoring/v3/query_service.proto \
google/monitoring/v3/service.proto \
google/monitoring/v3/service_service.proto \
google/monitoring/v3/snooze.proto \
google/monitoring/v3/snooze_service.proto \
google/monitoring/v3/span_context.proto \
google/monitoring/v3/uptime.proto \
google/monitoring/v3/uptime_service.proto

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
for proto_src in ; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/proto
    cp -f --parents "${proto_src}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/proto
done
for test_src in ; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/test/java
    unzip -q -o "${test_src}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/test/java
    rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/test/java/META-INF
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/..
tar -zchpf grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz grpc-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

##################### Section 3 #####################
# generate gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz
#####################################################
"${PROTOC_ROOT}"/protoc --experimental_allow_proto3_optional \
"--plugin=protoc-gen-java_gapic=${REPO_ROOT}/gapic-generator-java-wrapper" \
"--java_gapic_out=metadata:${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip" \
"--java_gapic_opt=transport=grpc,rest-numeric-enums,grpc-service-config=google/monitoring/v3/monitoring_grpc_service_config.json,gapic-config=google/monitoring/v3/monitoring_gapic.yaml,api-service-config=google/monitoring/v3/monitoring.yaml" \
"-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto" \
"-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto" \
"-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto" \
"-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto" \
"-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto" \
"-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto" \
"-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto" \
"-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto" \
"-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto" \
"-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto" \
"-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto" \
"-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto" \
"-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto" \
"-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto" \
"-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto" \
"-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto" \
"-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto" \
"-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto" \
"-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto" \
"-Igoogle/api/annotations.proto=google/api/annotations.proto" \
"-Igoogle/api/http.proto=google/api/http.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
"-Igoogle/api/client.proto=google/api/client.proto" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
"-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto" \
"-Igoogle/api/distribution.proto=google/api/distribution.proto" \
"-Igoogle/protobuf/any.proto=google/protobuf/any.proto" \
"-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto" \
"-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto" \
"-Igoogle/api/label.proto=google/api/label.proto" \
"-Igoogle/api/metric.proto=google/api/metric.proto" \
"-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto" \
"-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto" \
"-Igoogle/api/resource.proto=google/api/resource.proto" \
"-Igoogle/rpc/status.proto=google/rpc/status.proto" \
"-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto" \
"-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto" \
"-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto" \
"-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto" \
"-Igoogle/cloud/common_resources.proto=google/cloud/common_resources.proto" \
google/monitoring/v3/alert.proto \
google/monitoring/v3/alert_service.proto \
google/monitoring/v3/common.proto \
google/monitoring/v3/dropped_labels.proto \
google/monitoring/v3/group.proto \
google/monitoring/v3/group_service.proto \
google/monitoring/v3/metric.proto \
google/monitoring/v3/metric_service.proto \
google/monitoring/v3/mutation_record.proto \
google/monitoring/v3/notification.proto \
google/monitoring/v3/notification_service.proto \
google/monitoring/v3/query_service.proto \
google/monitoring/v3/service.proto \
google/monitoring/v3/service_service.proto \
google/monitoring/v3/snooze.proto \
google/monitoring/v3/snooze_service.proto \
google/monitoring/v3/span_context.proto \
google/monitoring/v3/uptime.proto \
google/monitoring/v3/uptime_service.proto \
google/cloud/common_resources.proto

unzip -o -q "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/
# Sync'\''d to the output file name in Writer.java.
unzip -o -q "${LIBRARY_GEN_OUT}"/google/monitoring/v3/temp-codegen.srcjar -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/monitoring_java_gapic_srcjar
# This may fail if there are spaces and/or too many files (exceed max length of command length).
# <generated file external/gapic_generator_java/google_java_format_binary> --replace $(find google/monitoring/v3/monitoring_java_gapic_srcjar -type f -printf "%p ")

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
# This may fail if there are spaces and/or too many files (exceed max length of command length).
# <generated file external/gapic_generator_java/google_java_format_binary> --replace $(find  sandbox/google/monitoring/v3/monitoring_java_gapic_samples -type f -printf "%p ")

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

for proto_src in ; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/proto
    cp -f --parents "${proto_src}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/proto
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

##################### Section 4 #####################
# generate proto-google-cloud-monitoring-v3-java-resources.tar.gz
#####################################################
cd "${GOOGLEAPIS_ROOT}"
"${PROTOC_ROOT}"/protoc "--java_out=${LIBRARY_GEN_OUT}/google/monitoring/v3/monitoring_proto-speed-src.jar" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/descriptor_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/duration_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/any_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/timestamp_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/struct_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/empty_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/field_mask_proto" \
"--proto_path=${LIBRARY_GEN_OUT}/com_google_protobuf/wrappers_proto" \
"-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto" \
"-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto" \
"-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto" \
"-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto" \
"-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto" \
"-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto" \
"-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto" \
"-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto" \
"-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto" \
"-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto" \
"-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto" \
"-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto" \
"-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto" \
"-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto" \
"-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto" \
"-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto" \
"-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto" \
"-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto" \
"-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto" \
"-Igoogle/api/annotations.proto=google/api/annotations.proto" \
"-Igoogle/api/http.proto=google/api/http.proto" \
"-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto" \
"-Igoogle/api/client.proto=google/api/client.proto" \
"-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto" \
"-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto" \
"-Igoogle/api/distribution.proto=google/api/distribution.proto" \
"-Igoogle/protobuf/any.proto=google/protobuf/any.proto" \
"-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto" \
"-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto" \
"-Igoogle/api/label.proto=google/api/label.proto" \
"-Igoogle/api/metric.proto=google/api/metric.proto" \
"-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto" \
"-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto" \
"-Igoogle/api/resource.proto=google/api/resource.proto" \
"-Igoogle/rpc/status.proto=google/rpc/status.proto" \
"-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto" \
"-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto" \
"-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto" \
"-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto" \
google/monitoring/v3/alert.proto \
google/monitoring/v3/alert_service.proto \
google/monitoring/v3/common.proto \
google/monitoring/v3/dropped_labels.proto \
google/monitoring/v3/group.proto \
google/monitoring/v3/group_service.proto \
google/monitoring/v3/metric.proto \
google/monitoring/v3/metric_service.proto \
google/monitoring/v3/mutation_record.proto \
google/monitoring/v3/notification.proto \
google/monitoring/v3/notification_service.proto \
google/monitoring/v3/query_service.proto \
google/monitoring/v3/service.proto \
google/monitoring/v3/service_service.proto \
google/monitoring/v3/snooze.proto \
google/monitoring/v3/snooze_service.proto \
google/monitoring/v3/span_context.proto \
google/monitoring/v3/uptime.proto \
google/monitoring/v3/uptime_service.proto

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

for test_src in ; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/test/java
    unzip -q -o "${test_src}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/test/java
    rm -r -f "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/test/java/META-INF
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/..
tar -zchpf proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz proto-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

for s in ; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/././samples/snippets/generated/
    unzip -o -q "${s}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/././samples/snippets/generated/
done

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java
#for templ in ${LIBRARY_GEN_OUT}/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/build.gradle; do
#    cp "${templ}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/
#done
#chmod 644 "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/*
#cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/..
#tar -zchpf proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz proto-google-cloud-monitoring-v3-java/*
#cd - > /dev/null
#mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources.tar.gz

###################### Section 5 #####################
## generate google-cloud-monitoring-v3-java-resources.tar.gz
######################################################
#mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources
#for templ in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/build.gradle ${LIBRARY_GEN_OUT}/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/settings.gradle; do
#    cp "${templ}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/
#done
#chmod 644 "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/*
#cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/.
#tar -zchpf ./google-cloud-monitoring-v3-java-resources.tar.gz ./*
#cd - > /dev/null
#mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/google-cloud-monitoring-v3-java-resources.tar.gz

###################### Section 6 #####################
## generate gapic-google-cloud-monitoring-v3-java-resources.tar.gz
######################################################
#mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java
#for templ in ${LIBRARY_GEN_OUT}/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/build.gradle; do
#    cp "${templ}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/
#done
#chmod 644 "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/*
#cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/..
#tar -zchpf gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz gapic-google-cloud-monitoring-v3-java/*
#cd - > /dev/null
#mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources.tar.gz

###################### Section 7 #####################
## generate grpc-google-cloud-monitoring-v3-java-resources.tar.gz
######################################################
#mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java
#for templ in ${LIBRARY_GEN_OUT}/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/build.gradle; do
#    cp "${templ}" "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/
#done
#chmod 644 "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/*
#cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/..
#tar -zchpf grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz grpc-google-cloud-monitoring-v3-java/*
#cd - > /dev/null
#mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources.tar.gz

##################### Section 8 #####################
# generate grpc-google-cloud-monitoring-v3-java.tar.gz
#####################################################
for s in ; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/././samples/snippets/generated/
    unzip -q -o "${s}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/././samples/snippets/generated/
done

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java
for dep in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf "${dep}" -C "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/.

tar -zchpf ./grpc-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java.tar.gz
rm -rf "${LIBRARY_GEN_OUT}"/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java

##################### Section 9 #####################
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

##################### Section 10 #####################
# generate gapic-google-cloud-monitoring-v3-java.tar.gz
#####################################################
for s in ; do
    mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/././samples/snippets/generated/
    unzip -q "${s}" -d "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/././samples/snippets/generated/
done

mkdir -p "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java
for dep in "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf "${dep}" -C "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java
done
cd "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/.

tar -zchpf ./gapic-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java.tar.gz
rm -rf "${LIBRARY_GEN_OUT}"/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java

##################### Section 11 #####################
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

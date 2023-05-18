#!/usr/bin/env bash

mkdir -p sandbox/gapic_generator_java/rules_java_gapic
mkdir -p sandbox/com_google_protobuf/descriptor_proto
mkdir -p sandbox/com_google_protobuf/duration_proto
mkdir -p sandbox/com_google_protobuf/any_proto
mkdir -p sandbox/com_google_protobuf/timestamp_proto
mkdir -p sandbox/com_google_protobuf/struct_proto
mkdir -p sandbox/com_google_protobuf/empty_proto
mkdir -p sandbox/com_google_protobuf/field_mask_proto
mkdir -p sandbox/com_google_protobuf/wrappers_proto
mkdir -p sandbox/google/api
mkdir -p sandbox/google/rpc
mkdir -p sandbox/google/type
mkdir -p sandbox/google/monitoring/v3

# Section 0: prepare toolings
# proto files from protobuf repository
# protoc
# grpc plugin
# gapic-generator-java

##################### Section 1 ##################### 
# generate descriptor files
#####################################################
# http.proto is a transitive dependency of google/api/annotations.proto, which is from monitoring_proto in google/monitoring/v3:BUILD
protoc --direct_dependencies google/api/http.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:http_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/http_proto-descriptor-set.proto.bin' \
--include_source_info \
--experimental_allow_proto3_optional \
'-Igoogle/api/http.proto=google/api/http.proto' \
google/api/http.proto

protoc --direct_dependencies google/protobuf/any.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:any_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/any_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/any_proto' \
--include_source_info \
--experimental_allow_proto3_optional \
'-Igoogle/protobuf/any.proto=google/protobuf/any.proto' \
google/protobuf/any.proto

protoc --direct_dependencies google/protobuf/descriptor.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:descriptor_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/descriptor_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
--include_source_info \
--experimental_allow_proto3_optional \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
google/protobuf/descriptor.proto

protoc --direct_dependencies google/protobuf/duration.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:duration_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/duration_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/duration_proto' \
'-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto' \
google/protobuf/duration.proto

protoc --direct_dependencies google/protobuf/empty.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:empty_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/empty_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/empty_proto' \
--include_source_info \
--experimental_allow_proto3_optional \
'-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto' \
google/protobuf/empty.proto

protoc --direct_dependencies google/protobuf/field_mask.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:field_mask_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/field_mask_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/field_mask_proto' \
'-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto' \
google/protobuf/field_mask.proto

protoc --direct_dependencies google/protobuf/struct.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:struct_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/struct_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/struct_proto' \
--include_source_info \
--experimental_allow_proto3_optional \
'-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto' \
google/protobuf/struct.proto

protoc --direct_dependencies google/protobuf/timestamp.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:timestamp_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/timestamp_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/timestamp_proto' \
--include_source_info \
--experimental_allow_proto3_optional \
'-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto' \
google/protobuf/timestamp.proto

protoc --direct_dependencies google/protobuf/wrappers.proto \
'--direct_dependencies_violation_msg=%s is imported, but @com_google_protobuf//:wrappers_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/com_google_protobuf/wrappers_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/wrappers_proto' \
'-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto' \
google/protobuf/wrappers.proto

protoc --direct_dependencies google/api/launch_stage.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:launch_stage_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/launch_stage_proto-descriptor-set.proto.bin' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
google/api/launch_stage.proto

protoc --direct_dependencies google/api/http.proto:google/protobuf/descriptor.proto:google/api/annotations.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:annotations_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/annotations_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
'-Igoogle/api/annotations.proto=google/api/annotations.proto' \
'-Igoogle/api/http.proto=google/api/http.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
google/api/annotations.proto

protoc --direct_dependencies google/api/launch_stage.proto:google/protobuf/descriptor.proto:google/protobuf/duration.proto:google/api/client.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:client_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/client_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
'--proto_path=sandbox/com_google_protobuf/duration_proto' \
'-Igoogle/api/client.proto=google/api/client.proto' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
'-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto' \
google/api/client.proto

protoc --direct_dependencies google/api/annotations.proto:google/protobuf/any.proto:google/protobuf/timestamp.proto:google/api/distribution.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:distribution_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/distribution_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
'--proto_path=sandbox/com_google_protobuf/any_proto' \
'--proto_path=sandbox/com_google_protobuf/timestamp_proto' \
'-Igoogle/api/distribution.proto=google/api/distribution.proto' \
'-Igoogle/api/annotations.proto=google/api/annotations.proto' \
'-Igoogle/api/http.proto=google/api/http.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
'-Igoogle/protobuf/any.proto=google/protobuf/any.proto' \
'-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto' \
google/api/distribution.proto

protoc --direct_dependencies google/protobuf/descriptor.proto:google/api/field_behavior.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:field_behavior_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/field_behavior_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
'-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
google/api/field_behavior.proto

protoc --direct_dependencies google/api/label.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:label_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/label_proto-descriptor-set.proto.bin' \
--include_source_info \
--experimental_allow_proto3_optional \
'-Igoogle/api/label.proto=google/api/label.proto' \
google/api/label.proto

protoc --direct_dependencies google/api/launch_stage.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:launch_stage_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/launch_stage_proto-descriptor-set.proto.bin' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
google/api/launch_stage.proto

protoc --direct_dependencies google/api/label.proto:google/api/launch_stage.proto:google/protobuf/duration.proto:google/api/metric.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:metric_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/metric_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/duration_proto' \
'-Igoogle/api/metric.proto=google/api/metric.proto' \
'-Igoogle/api/label.proto=google/api/label.proto' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
'-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto' \
google/api/metric.proto

protoc --direct_dependencies google/api/label.proto:google/api/launch_stage.proto:google/protobuf/struct.proto:google/api/monitored_resource.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:monitored_resource_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/monitored_resource_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/struct_proto' \
'-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto' \
'-Igoogle/api/label.proto=google/api/label.proto' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
'-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto' \
google/api/monitored_resource.proto

protoc --direct_dependencies google/protobuf/descriptor.proto:google/api/resource.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/api:resource_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/api/resource_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
'-Igoogle/api/resource.proto=google/api/resource.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
google/api/resource.proto

protoc --direct_dependencies google/protobuf/any.proto:google/rpc/status.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/rpc:status_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/rpc/status_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/any_proto' \
'-Igoogle/rpc/status.proto=google/rpc/status.proto' \
'-Igoogle/protobuf/any.proto=google/protobuf/any.proto' \
google/rpc/status.proto

protoc --direct_dependencies google/type/calendar_period.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/type:calendar_period_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/type/calendar_period_proto-descriptor-set.proto.bin' \
'-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto' \
google/type/calendar_period.proto

# use all proto files to generate sandbox/google/monitoring/v3/monitoring_proto-descriptor-set.proto.bin
protoc --direct_dependencies google/api/annotations.proto:google/api/client.proto:google/api/distribution.proto:google/api/field_behavior.proto:google/api/label.proto:google/api/launch_stage.proto:google/api/metric.proto:google/api/monitored_resource.proto:google/api/resource.proto:google/rpc/status.proto:google/type/calendar_period.proto:google/protobuf/duration.proto:google/protobuf/empty.proto:google/protobuf/field_mask.proto:google/protobuf/timestamp.proto:google/protobuf/wrappers.proto:google/monitoring/v3/alert.proto:google/monitoring/v3/alert_service.proto:google/monitoring/v3/common.proto:google/monitoring/v3/dropped_labels.proto:google/monitoring/v3/group.proto:google/monitoring/v3/group_service.proto:google/monitoring/v3/metric.proto:google/monitoring/v3/metric_service.proto:google/monitoring/v3/mutation_record.proto:google/monitoring/v3/notification.proto:google/monitoring/v3/notification_service.proto:google/monitoring/v3/query_service.proto:google/monitoring/v3/service.proto:google/monitoring/v3/service_service.proto:google/monitoring/v3/snooze.proto:google/monitoring/v3/snooze_service.proto:google/monitoring/v3/span_context.proto:google/monitoring/v3/uptime.proto:google/monitoring/v3/uptime_service.proto \
'--direct_dependencies_violation_msg=%s is imported, but //google/monitoring/v3:monitoring_proto doesn'\''t directly depend on a proto_library that '\''srcs'\'' it.' \
'--descriptor_set_out=sandbox/google/monitoring/v3/monitoring_proto-descriptor-set.proto.bin' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
'--proto_path=sandbox/com_google_protobuf/duration_proto' \
'--proto_path=sandbox/com_google_protobuf/any_proto' \
'--proto_path=sandbox/com_google_protobuf/timestamp_proto' \
'--proto_path=sandbox/com_google_protobuf/struct_proto' \
'--proto_path=sandbox/com_google_protobuf/empty_proto' \
'--proto_path=sandbox/com_google_protobuf/field_mask_proto' \
'--proto_path=sandbox/com_google_protobuf/wrappers_proto' \
'-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto' \
'-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto' \
'-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto' \
'-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto' \
'-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto' \
'-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto' \
'-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto' \
'-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto' \
'-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto' \
'-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto' \
'-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto' \
'-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto' \
'-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto' \
'-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto' \
'-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto' \
'-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto' \
'-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto' \
'-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto' \
'-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto' \
'-Igoogle/api/annotations.proto=google/api/annotations.proto' \
'-Igoogle/api/http.proto=google/api/http.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
'-Igoogle/api/client.proto=google/api/client.proto' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
'-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto' \
'-Igoogle/api/distribution.proto=google/api/distribution.proto' \
'-Igoogle/protobuf/any.proto=google/protobuf/any.proto' \
'-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto' \
'-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto' \
'-Igoogle/api/label.proto=google/api/label.proto' \
'-Igoogle/api/metric.proto=google/api/metric.proto' \
'-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto' \
'-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto' \
'-Igoogle/api/resource.proto=google/api/resource.proto' \
'-Igoogle/rpc/status.proto=google/rpc/status.proto' \
'-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto' \
'-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto' \
'-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto' \
'-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto' \
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
protoc --include_imports \
--include_source_info \
--experimental_allow_proto3_optional \
'--descriptor_set_out=google/monitoring/v3/monitoring_proto_with_info-set.proto.bin' \
'-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto' \
'-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto' \
'-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto' \
'-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto' \
'-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto' \
'-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto' \
'-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto' \
'-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto' \
'-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto' \
'-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto' \
'-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto' \
'-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto' \
'-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto' \
'-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto' \
'-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto' \
'-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto' \
'-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto' \
'-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto' \
'-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto' \
'-Igoogle/api/annotations.proto=google/api/annotations.proto' \
'-Igoogle/api/http.proto=google/api/http.proto' \
'-Igoogle/protobuf/descriptor.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/descriptor_proto/google/protobuf/descriptor.proto' \
'-Igoogle/api/client.proto=google/api/client.proto' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
'-Igoogle/protobuf/duration.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/duration_proto/google/protobuf/duration.proto' \
'-Igoogle/api/distribution.proto=google/api/distribution.proto' \
'-Igoogle/protobuf/any.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/any_proto/google/protobuf/any.proto' \
'-Igoogle/protobuf/timestamp.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/timestamp_proto/google/protobuf/timestamp.proto' \
'-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto' \
'-Igoogle/api/label.proto=google/api/label.proto' \
'-Igoogle/api/metric.proto=google/api/metric.proto' \
'-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto' \
'-Igoogle/protobuf/struct.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/struct_proto/google/protobuf/struct.proto' \
'-Igoogle/api/resource.proto=google/api/resource.proto' \
'-Igoogle/rpc/status.proto=google/rpc/status.proto' \
'-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto' \
'-Igoogle/protobuf/empty.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/empty_proto/google/protobuf/empty.proto' \
'-Igoogle/protobuf/field_mask.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/field_mask_proto/google/protobuf/field_mask.proto' \
'-Igoogle/protobuf/wrappers.proto=bazel-out/darwin_arm64-fastbuild/bin/external/com_google_protobuf/_virtual_imports/wrappers_proto/google/protobuf/wrappers.proto' \
'-Igoogle/cloud/common_resources.proto=google/cloud/common_resources.proto' \
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
protoc '--plugin=protoc-gen-rpc-plugin=sandbox/grpc_java_plugin' \
'--rpc-plugin_out=:sandbox/google/monitoring/v3/monitoring_java_grpc-proto-gensrc.jar' \
--descriptor_set_in sandbox/google/api/http_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/descriptor_proto-descriptor-set.proto.bin:sandbox/google/api/annotations_proto-descriptor-set.proto.bin:sandbox/google/api/launch_stage_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/duration_proto-descriptor-set.proto.bin:sandbox/google/api/client_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/any_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/timestamp_proto-descriptor-set.proto.bin:sandbox/google/api/distribution_proto-descriptor-set.proto.bin:sandbox/google/api/field_behavior_proto-descriptor-set.proto.bin:sandbox/google/api/label_proto-descriptor-set.proto.bin:sandbox/google/api/metric_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/struct_proto-descriptor-set.proto.bin:sandbox/google/api/monitored_resource_proto-descriptor-set.proto.bin:sandbox/google/api/resource_proto-descriptor-set.proto.bin:sandbox/google/rpc/status_proto-descriptor-set.proto.bin:sandbox/google/type/calendar_period_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/empty_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/field_mask_proto-descriptor-set.proto.bin:sandbox/com_google_protobuf/wrappers_proto-descriptor-set.proto.bin:sandbox/google/monitoring/v3/monitoring_proto-descriptor-set.proto.bin \
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

for src in sandbox/google/monitoring/v3/monitoring_java_grpc-proto-gensrc.jar; do
    mkdir -p sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java
    unzip -q -o $src -d sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java
    rm -r -f sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java/META-INF

    # Remove empty files. If there are no resource names, one such file might have
    # been created. See java_gapic.bzl.
    find sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read f; do rm -f $f; done

    if [ -d sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
        mv sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/java/samples sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java
    fi
done
for proto_src in ; do
    mkdir -p sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/proto
    cp -f --parents $proto_src sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/main/proto
done
for test_src in ; do
    mkdir -p sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/test/java
    unzip -q -o $test_src -d sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/test/java
    rm -r -f sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/src/test/java/META-INF
done
cd sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/..
tar -zchpf grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz grpc-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

##################### Section 3 ##################### 
# generate gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz
#####################################################
protoc --experimental_allow_proto3_optional \
'--plugin=protoc-gen-java_gapic=sandbox/protoc-gen-java_gapic' \
'--java_gapic_out=metadata:sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip' \
'--java_gapic_opt=transport=grpc,rest-numeric-enums,grpc-service-config=google/monitoring/v3/monitoring_grpc_service_config.json,gapic-config=google/monitoring/v3/monitoring_gapic.yaml,api-service-config=google/monitoring/v3/monitoring.yaml' \
'-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto' \
'-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto' \
'-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto' \
'-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto' \
'-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto' \
'-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto' \
'-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto' \
'-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto' \
'-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto' \
'-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto' \
'-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto' \
'-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto' \
'-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto' \
'-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto' \
'-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto' \
'-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto' \
'-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto' \
'-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto' \
'-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto' \
'-Igoogle/api/annotations.proto=google/api/annotations.proto' \
'-Igoogle/api/http.proto=google/api/http.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
'-Igoogle/api/client.proto=google/api/client.proto' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
'-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto' \
'-Igoogle/api/distribution.proto=google/api/distribution.proto' \
'-Igoogle/protobuf/any.proto=google/protobuf/any.proto' \
'-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto' \
'-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto' \
'-Igoogle/api/label.proto=google/api/label.proto' \
'-Igoogle/api/metric.proto=google/api/metric.proto' \
'-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto' \
'-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto' \
'-Igoogle/api/resource.proto=google/api/resource.proto' \
'-Igoogle/rpc/status.proto=google/rpc/status.proto' \
'-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto' \
'-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto' \
'-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto' \
'-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto' \
'-Igoogle/cloud/common_resources.proto=google/cloud/common_resources.proto' \
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

mv sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar.zip sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar
unzip -q sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar -d sandbox/google/monitoring/v3/
# Sync'\''d to the output file name in Writer.java.
unzip -q sandbox/google/monitoring/v3/temp-codegen.srcjar -d sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar
# # This may fail if there are spaces and/or too many files (exceed max length of command length).
# <generated file external/gapic_generator_java/google_java_format_binary> --replace $(find google/monitoring/v3/monitoring_java_gapic_srcjar -type f -printf "%p ")
WORKING_DIR=`pwd`

echo $WORKING_DIR

# Main source files.
cd sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar/src/main/java
zip -r $WORKING_DIR/sandbox/monitoring_java_gapic_srcjar.srcjar ./

# Resource name source files.
PROTO_DIR=$WORKING_DIR/sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar/proto/src/main/java
PROTO_SRCJAR=$WORKING_DIR/sandbox/monitoring_java_gapic_srcjar-resource-name.srcjar
if [ ! -d $PROTO_DIR ]
then
  # Some APIs don'\''t have resource name helpers, like BigQuery v2.
  # Create an empty file so we can finish building. Gating the resource name rule definition
  # on file existences go against Bazel'\''s design patterns, so we'\''ll simply delete all empty
  # files during the final packaging process (see java_gapic_pkg.bzl)
  mkdir -p $PROTO_DIR
  touch $PROTO_DIR/PlaceholderFile.java
fi
cd $WORKING_DIR/sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar/proto/src/main/java
zip -r $PROTO_SRCJAR ./

# Test source files.
cd $WORKING_DIR/sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar/src/test/java
zip -r $WORKING_DIR/sandbox/monitoring_java_gapic_srcjar-tests.srcjar ./

# Sample source files.
cd $WORKING_DIR/sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar/samples/snippets/generated/src/main/java
zip -r $WORKING_DIR/sandbox/monitoring_java_gapic_srcjar-samples.srcjar ./

cd $WORKING_DIR

mv sandbox/monitoring_java_gapic_srcjar.srcjar sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar.srcjar
mv sandbox/monitoring_java_gapic_srcjar-resource-name.srcjar sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar-resource-name.srcjar
mv sandbox/monitoring_java_gapic_srcjar-tests.srcjar sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar-test.srcjar
mv sandbox/monitoring_java_gapic_srcjar-samples.srcjar sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar-samples.srcjar

unzip -q  sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar_raw.srcjar
# Sync'\''d to the output file name in Writer.java.
unzip -q sandbox/google/monitoring/v3/temp-codegen.srcjar -d  sandbox/google/monitoring/v3/monitoring_java_gapic_samples
# This may fail if there are spaces and/or too many files (exceed max length of command length).
# <generated file external/gapic_generator_java/google_java_format_binary> --replace $(find  sandbox/google/monitoring/v3/monitoring_java_gapic_samples -type f -printf "%p ")
WORKING_DIR=`pwd`

# Sample source files.
cd $WORKING_DIR/sandbox/google/monitoring/v3/monitoring_java_gapic_samples/samples/snippets/generated/src/main/java
zip -r $WORKING_DIR/sandbox/monitoring_java_gapic_samples-samples.srcjar ./

cd $WORKING_DIR

mv sandbox/monitoring_java_gapic_samples-samples.srcjar sandbox/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar

for s in sandbox/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar; do
    mkdir -p sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
    unzip -q ./$s -d sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
done

cp sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar.srcjar sandbox/google/monitoring/v3/libmonitoring_java_gapic-src.jar
cp sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar-test.srcjar sandbox/google/monitoring/v3/libmonitoring_java_gapic_test-src.jar
for src in sandbox/google/monitoring/v3/libmonitoring_java_gapic-src.jar; do
    mkdir -p sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java
    unzip -q -o $src -d sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java
    rm -r -f sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java/META-INF

    # Remove empty files. If there are no resource names, one such file might have
    # been created. See java_gapic.bzl.
    find sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read f; do rm -f $f; done

    if [ -d sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
        mv sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/java/samples sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java
    fi
done
for proto_src in ; do
    mkdir -p sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/proto
    cp -f --parents $proto_src sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/main/proto
done
for test_src in sandbox/google/monitoring/v3/libmonitoring_java_gapic_test-src.jar; do
    mkdir -p sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/test/java
    unzip -q -o $test_src -d sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/test/java
    rm -r -f sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/src/test/java/META-INF
done
cd sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/..
tar -zchpf gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz gapic-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

##################### Section 4 ##################### 
# generate proto-google-cloud-monitoring-v3-java-resources.tar.gz
#####################################################
protoc '--java_out=sandbox/google/monitoring/v3/monitoring_proto-speed-src.jar' \
'--proto_path=sandbox/com_google_protobuf/descriptor_proto' \
'--proto_path=sandbox/com_google_protobuf/duration_proto' \
'--proto_path=sandbox/com_google_protobuf/any_proto' \
'--proto_path=sandbox/com_google_protobuf/timestamp_proto' \
'--proto_path=sandbox/com_google_protobuf/struct_proto' \
'--proto_path=sandbox/com_google_protobuf/empty_proto' \
'--proto_path=sandbox/com_google_protobuf/field_mask_proto' \
'--proto_path=sandbox/com_google_protobuf/wrappers_proto' \
'-Igoogle/monitoring/v3/alert.proto=google/monitoring/v3/alert.proto' \
'-Igoogle/monitoring/v3/alert_service.proto=google/monitoring/v3/alert_service.proto' \
'-Igoogle/monitoring/v3/common.proto=google/monitoring/v3/common.proto' \
'-Igoogle/monitoring/v3/dropped_labels.proto=google/monitoring/v3/dropped_labels.proto' \
'-Igoogle/monitoring/v3/group.proto=google/monitoring/v3/group.proto' \
'-Igoogle/monitoring/v3/group_service.proto=google/monitoring/v3/group_service.proto' \
'-Igoogle/monitoring/v3/metric.proto=google/monitoring/v3/metric.proto' \
'-Igoogle/monitoring/v3/metric_service.proto=google/monitoring/v3/metric_service.proto' \
'-Igoogle/monitoring/v3/mutation_record.proto=google/monitoring/v3/mutation_record.proto' \
'-Igoogle/monitoring/v3/notification.proto=google/monitoring/v3/notification.proto' \
'-Igoogle/monitoring/v3/notification_service.proto=google/monitoring/v3/notification_service.proto' \
'-Igoogle/monitoring/v3/query_service.proto=google/monitoring/v3/query_service.proto' \
'-Igoogle/monitoring/v3/service.proto=google/monitoring/v3/service.proto' \
'-Igoogle/monitoring/v3/service_service.proto=google/monitoring/v3/service_service.proto' \
'-Igoogle/monitoring/v3/snooze.proto=google/monitoring/v3/snooze.proto' \
'-Igoogle/monitoring/v3/snooze_service.proto=google/monitoring/v3/snooze_service.proto' \
'-Igoogle/monitoring/v3/span_context.proto=google/monitoring/v3/span_context.proto' \
'-Igoogle/monitoring/v3/uptime.proto=google/monitoring/v3/uptime.proto' \
'-Igoogle/monitoring/v3/uptime_service.proto=google/monitoring/v3/uptime_service.proto' \
'-Igoogle/api/annotations.proto=google/api/annotations.proto' \
'-Igoogle/api/http.proto=google/api/http.proto' \
'-Igoogle/protobuf/descriptor.proto=google/protobuf/descriptor.proto' \
'-Igoogle/api/client.proto=google/api/client.proto' \
'-Igoogle/api/launch_stage.proto=google/api/launch_stage.proto' \
'-Igoogle/protobuf/duration.proto=google/protobuf/duration.proto' \
'-Igoogle/api/distribution.proto=google/api/distribution.proto' \
'-Igoogle/protobuf/any.proto=google/protobuf/any.proto' \
'-Igoogle/protobuf/timestamp.proto=google/protobuf/timestamp.proto' \
'-Igoogle/api/field_behavior.proto=google/api/field_behavior.proto' \
'-Igoogle/api/label.proto=google/api/label.proto' \
'-Igoogle/api/metric.proto=google/api/metric.proto' \
'-Igoogle/api/monitored_resource.proto=google/api/monitored_resource.proto' \
'-Igoogle/protobuf/struct.proto=google/protobuf/struct.proto' \
'-Igoogle/api/resource.proto=google/api/resource.proto' \
'-Igoogle/rpc/status.proto=google/rpc/status.proto' \
'-Igoogle/type/calendar_period.proto=google/type/calendar_period.proto' \
'-Igoogle/protobuf/empty.proto=google/protobuf/empty.proto' \
'-Igoogle/protobuf/field_mask.proto=google/protobuf/field_mask.proto' \
'-Igoogle/protobuf/wrappers.proto=google/protobuf/wrappers.proto' \
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

# 
cp sandbox/google/monitoring/v3/monitoring_java_gapic_srcjar-resource-name.srcjar sandbox/google/monitoring/v3/libmonitoring_java_gapic_resource_name-src.jar
for src in sandbox/google/monitoring/v3/libmonitoring_java_gapic_resource_name-src.jar sandbox/google/monitoring/v3/monitoring_proto-speed-src.jar; do
    mkdir -p sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java
    unzip -q -o $src -d sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java
    rm -r -f sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java/META-INF

    # Remove empty files. If there are no resource names, one such file might have
    # been created. See java_gapic.bzl.
    find sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java -type f -size 0 | while read f; do rm -f $f; done

    if [ -d sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java/samples ]; then
        mv sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/java/samples sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java
    fi
done
for proto_src in google/monitoring/v3/alert.proto google/monitoring/v3/alert_service.proto google/monitoring/v3/common.proto google/monitoring/v3/dropped_labels.proto google/monitoring/v3/group.proto google/monitoring/v3/group_service.proto google/monitoring/v3/metric.proto google/monitoring/v3/metric_service.proto google/monitoring/v3/mutation_record.proto google/monitoring/v3/notification.proto google/monitoring/v3/notification_service.proto google/monitoring/v3/query_service.proto google/monitoring/v3/service.proto google/monitoring/v3/service_service.proto google/monitoring/v3/snooze.proto google/monitoring/v3/snooze_service.proto google/monitoring/v3/span_context.proto google/monitoring/v3/uptime.proto google/monitoring/v3/uptime_service.proto; do
    mkdir -p sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/proto
    cp -f --parents $proto_src sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/main/proto
done

for test_src in ; do
    mkdir -p sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/test/java
    unzip -q -o $test_src -d sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/test/java
    rm -r -f sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/src/test/java/META-INF
done
cd sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/..
tar -zchpf proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz proto-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz

for s in ; do
    mkdir -p sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/././samples/snippets/generated/
    unzip -q ./$s -d sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/././samples/snippets/generated/
done

mkdir -p sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java
for templ in sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/build.gradle; do
    cp $templ sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/
done
chmod 644 sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/*
cd sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/..
tar -zchpf proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz proto-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources.tar.gz

##################### Section 5 ##################### 
# generate google-cloud-monitoring-v3-java-resources.tar.gz
#####################################################
mkdir -p sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources
for templ in sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/build.gradle sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/settings.gradle; do
    cp $templ sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/
done
chmod 644 sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/*
cd sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/.
tar -zchpf ./google-cloud-monitoring-v3-java-resources.tar.gz ./*
cd - > /dev/null
mv sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources/google-cloud-monitoring-v3-java-resources.tar.gz sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources.tar.gz

##################### Section 6 ##################### 
# generate gapic-google-cloud-monitoring-v3-java-resources.tar.gz
#####################################################
mkdir -p sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java
for templ in sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/build.gradle; do
    cp $templ sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/
done
chmod 644 sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/*
cd sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/..
tar -zchpf gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz gapic-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources.tar.gz

##################### Section 7 ##################### 
# generate grpc-google-cloud-monitoring-v3-java-resources.tar.gz
#####################################################
mkdir -p sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java
for templ in sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/build.gradle; do
    cp $templ sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/
done
chmod 644 sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/*
cd sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/..
tar -zchpf grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz grpc-google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources.tar.gz

##################### Section 8 ##################### 
# generate grpc-google-cloud-monitoring-v3-java.tar.gz
#####################################################
for s in ; do
    mkdir -p sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/././samples/snippets/generated/
    unzip -q ./$s -d sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/././samples/snippets/generated/
done

mkdir -p sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java
for dep in sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-resources.tar.gz sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf $dep -C sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java
done
cd sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/.

tar -zchpf ./grpc-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java.tar.gz
rm -rf sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java/grpc-google-cloud-monitoring-v3-java

##################### Section 9 ##################### 
# generate proto-google-cloud-monitoring-v3-java.tar.gz
#####################################################
mkdir -p sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java
for dep in sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-resources.tar.gz sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf $dep -C sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java
done
cd sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/.

tar -zchpf ./proto-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java.tar.gz
rm -rf sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java/proto-google-cloud-monitoring-v3-java

##################### Section 10 ##################### 
# generate gapic-google-cloud-monitoring-v3-java.tar.gz
#####################################################
for s in ; do
    mkdir -p sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/././samples/snippets/generated/
    unzip -q ./$s -d sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/././samples/snippets/generated/
done

mkdir -p sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java
for dep in sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-resources.tar.gz sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java-srcs_pkg.tar.gz; do
    tar -xzpf $dep -C sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java
done
cd sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/.

tar -zchpf ./gapic-google-cloud-monitoring-v3-java.tar.gz ./*
cd - > /dev/null
mv sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java.tar.gz
rm -rf sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java/gapic-google-cloud-monitoring-v3-java

##################### Section 11 ##################### 
# generate google-cloud-monitoring-v3-java.tar.gz
#####################################################
for s in sandbox/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar; do
    mkdir -p sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
    unzip -q ./$s -d sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
done

mkdir -p sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
for dep in sandbox/gapic_generator_java/rules_java_gapic/gradlew.tar.gz sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources.tar.gz sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java.tar.gz; do
    tar -xzpf $dep -C sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
done
cd sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/..

tar -zchpf google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java.tar.gz
rm -rf sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java

for s in sandbox/google/monitoring/v3/monitoring_java_gapic_samples-samples.srcjar; do
    mkdir -p sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
    unzip -q ./$s -d sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/../google-cloud-monitoring-v3-java/samples/snippets/generated/
done

mkdir -p sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
for dep in sandbox/gapic_generator_java/rules_java_gapic/gradlew.tar.gz sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java-resources.tar.gz sandbox/google/monitoring/v3/proto-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/grpc-google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/gapic-google-cloud-monitoring-v3-java.tar.gz; do
    tar -xzpf $dep -C sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
done
cd sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/..

tar -zchpf google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz google-cloud-monitoring-v3-java/*
cd - > /dev/null
mv sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java.tar.gz sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java.tar.gz
rm -rf sandbox/google/monitoring/v3/google-cloud-monitoring-v3-java/google-cloud-monitoring-v3-java
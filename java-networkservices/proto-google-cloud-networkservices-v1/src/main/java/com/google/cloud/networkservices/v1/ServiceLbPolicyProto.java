/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/networkservices/v1/service_lb_policy.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.networkservices.v1;

public final class ServiceLbPolicyProto {
  private ServiceLbPolicyProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_AutoCapacityDrain_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_AutoCapacityDrain_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_FailoverConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_FailoverConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_IsolationConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_IsolationConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_LabelsEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_GetServiceLbPolicyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_GetServiceLbPolicyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_UpdateServiceLbPolicyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_UpdateServiceLbPolicyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_networkservices_v1_DeleteServiceLbPolicyRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_networkservices_v1_DeleteServiceLbPolicyRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n"
          + "7google/cloud/networkservices/v1/service_lb_policy.proto\022\037google.cloud.networks"
          + "ervices.v1\032\037google/api/field_behavior.proto\032\031google/api/resource.proto\032"
          + " google/protobuf/field_mask.proto\032\037google/protobuf/timestamp.proto\"\272\013\n"
          + "\017ServiceLbPolicy\022\021\n"
          + "\004name\030\001 \001(\tB\003\340A\010\0224\n"
          + "\013create_time\030\002 \001(\0132\032.google.protobuf.TimestampB\003\340A\003\0224\n"
          + "\013update_time\030\003 \001(\0132\032.google.protobuf.TimestampB\003\340A\003\022Q\n"
          + "\006labels\030\004 \003(\0132<.google.cloud.netw"
          + "orkservices.v1.ServiceLbPolicy.LabelsEntryB\003\340A\001\022\030\n"
          + "\013description\030\005 \001(\tB\003\340A\001\022n\n"
          + "\030load_balancing_algorithm\030\006 \001(\0162G.google.clo"
          + "ud.networkservices.v1.ServiceLbPolicy.LoadBalancingAlgorithmB\003\340A\001\022d\n"
          + "\023auto_capacity_drain\030\010 \001(\0132B.google.cloud.networkser"
          + "vices.v1.ServiceLbPolicy.AutoCapacityDrainB\003\340A\001\022]\n"
          + "\017failover_config\030\n"
          + " \001(\0132?.googl"
          + "e.cloud.networkservices.v1.ServiceLbPolicy.FailoverConfigB\003\340A\001\022_\n"
          + "\020isolation_config\030\013 \001(\0132@.google.cloud.networkservices."
          + "v1.ServiceLbPolicy.IsolationConfigB\003\340A\001\032(\n"
          + "\021AutoCapacityDrain\022\023\n"
          + "\006enable\030\001 \001(\010B\003\340A\001\0328\n"
          + "\016FailoverConfig\022&\n"
          + "\031failover_health_threshold\030\001 \001(\005B\003\340A\001\032\331\001\n"
          + "\017IsolationConfig\022i\n"
          + "\025isolation_granularity\030\001 \001(\0162E.google."
          + "cloud.networkservices.v1.ServiceLbPolicy.IsolationGranularityB\003\340A\001\022[\n"
          + "\016isolation_mode\030\002 \001(\0162>.google.cloud.networkservice"
          + "s.v1.ServiceLbPolicy.IsolationModeB\003\340A\001\032-\n"
          + "\013LabelsEntry\022\013\n"
          + "\003key\030\001 \001(\t\022\r\n"
          + "\005value\030\002 \001(\t:\0028\001\"\233\001\n"
          + "\026LoadBalancingAlgorithm\022(\n"
          + "$LOAD_BALANCING_ALGORITHM_UNSPECIFIED\020\000\022\022\n"
          + "\016SPRAY_TO_WORLD\020\003\022\023\n"
          + "\017SPRAY_TO_REGION\020\004\022\027\n"
          + "\023WATERFALL_BY_REGION\020\005\022\025\n"
          + "\021WATERFALL_BY_ZONE\020\006\"I\n"
          + "\024IsolationGranularity\022%\n"
          + "!ISOLATION_GRANULARITY_UNSPECIFIED\020\000\022\n\n"
          + "\006REGION\020\001\"H\n\r"
          + "IsolationMode\022\036\n"
          + "\032ISOLATION_MODE_UNSPECIFIED\020\000\022\013\n"
          + "\007NEAREST\020\001\022\n\n"
          + "\006STRICT\020\002:\202\001\352A\177\n"
          + ".networkservices.googleapis.com/ServiceLbPolicy\022Mprojects/{project}/locations/{l"
          + "ocation}/serviceLbPolicies/{service_lb_policy}\"\215\001\n"
          + "\034ListServiceLbPoliciesRequest\022F\n"
          + "\006parent\030\001 \001("
          + "\tB6\340A\002\372A0\022.networkservices.googleapis.com/ServiceLbPolicy\022\021\n"
          + "\tpage_size\030\002 \001(\005\022\022\n\n"
          + "page_token\030\003 \001(\t\"\234\001\n"
          + "\035ListServiceLbPoliciesResponse\022M\n"
          + "\023service_lb_policies\030\001"
          + " \003(\01320.google.cloud.networkservices.v1.ServiceLbPolicy\022\027\n"
          + "\017next_page_token\030\002 \001(\t\022\023\n"
          + "\013unreachable\030\003 \003(\t\"a\n"
          + "\031GetServiceLbPolicyRequest\022D\n"
          + "\004name\030\001 \001(\tB6\340A\002\372A0\n"
          + ".networkservices.googleapis.com/ServiceLbPolicy\"\333\001\n"
          + "\034CreateServiceLbPolicyRequest\022F\n"
          + "\006parent\030\001 \001("
          + "\tB6\340A\002\372A0\022.networkservices.googleapis.com/ServiceLbPolicy\022!\n"
          + "\024service_lb_policy_id\030\002 \001(\tB\003\340A\002\022P\n"
          + "\021service_lb_policy\030\003"
          + " \001(\01320.google.cloud.networkservices.v1.ServiceLbPolicyB\003\340A\002\"\246\001\n"
          + "\034UpdateServiceLbPolicyRequest\0224\n"
          + "\013update_mask\030\001 \001(\0132\032.google.protobuf.FieldMaskB\003\340A\001\022P\n"
          + "\021service_lb_policy\030\002 \001(\01320.google.cloud."
          + "networkservices.v1.ServiceLbPolicyB\003\340A\002\"d\n"
          + "\034DeleteServiceLbPolicyRequest\022D\n"
          + "\004name\030\001 \001(\tB6\340A\002\372A0\n"
          + ".networkservices.googleapis.com/ServiceLbPolicyB\365\001\n"
          + "#com.google.cloud.networkservices.v1B\024ServiceLbPolicyPr"
          + "otoP\001ZMcloud.google.com/go/networkservices/apiv1/networkservicespb;networkservic"
          + "espb\252\002\037Google.Cloud.NetworkServices.V1\312\002"
          + "\037Google\\Cloud\\NetworkServices\\V1\352\002\"Googl"
          + "e::Cloud::NetworkServices::V1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.protobuf.FieldMaskProto.getDescriptor(),
              com.google.protobuf.TimestampProto.getDescriptor(),
            });
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_descriptor,
            new java.lang.String[] {
              "Name",
              "CreateTime",
              "UpdateTime",
              "Labels",
              "Description",
              "LoadBalancingAlgorithm",
              "AutoCapacityDrain",
              "FailoverConfig",
              "IsolationConfig",
            });
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_AutoCapacityDrain_descriptor =
        internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_AutoCapacityDrain_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_AutoCapacityDrain_descriptor,
            new java.lang.String[] {
              "Enable",
            });
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_FailoverConfig_descriptor =
        internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_descriptor
            .getNestedTypes()
            .get(1);
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_FailoverConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_FailoverConfig_descriptor,
            new java.lang.String[] {
              "FailoverHealthThreshold",
            });
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_IsolationConfig_descriptor =
        internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_descriptor
            .getNestedTypes()
            .get(2);
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_IsolationConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_IsolationConfig_descriptor,
            new java.lang.String[] {
              "IsolationGranularity", "IsolationMode",
            });
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_LabelsEntry_descriptor =
        internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_descriptor
            .getNestedTypes()
            .get(3);
    internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_LabelsEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ServiceLbPolicy_LabelsEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageSize", "PageToken",
            });
    internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesResponse_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_ListServiceLbPoliciesResponse_descriptor,
            new java.lang.String[] {
              "ServiceLbPolicies", "NextPageToken", "Unreachable",
            });
    internal_static_google_cloud_networkservices_v1_GetServiceLbPolicyRequest_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_networkservices_v1_GetServiceLbPolicyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_GetServiceLbPolicyRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_CreateServiceLbPolicyRequest_descriptor,
            new java.lang.String[] {
              "Parent", "ServiceLbPolicyId", "ServiceLbPolicy",
            });
    internal_static_google_cloud_networkservices_v1_UpdateServiceLbPolicyRequest_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_networkservices_v1_UpdateServiceLbPolicyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_UpdateServiceLbPolicyRequest_descriptor,
            new java.lang.String[] {
              "UpdateMask", "ServiceLbPolicy",
            });
    internal_static_google_cloud_networkservices_v1_DeleteServiceLbPolicyRequest_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_networkservices_v1_DeleteServiceLbPolicyRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_networkservices_v1_DeleteServiceLbPolicyRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

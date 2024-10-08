/*
 * Copyright 2024 Google LLC
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
// source: google/cloud/aiplatform/v1beta1/persistent_resource.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.aiplatform.v1beta1;

public final class PersistentResourceProto {
  private PersistentResourceProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_LabelsEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_AutoscalingSpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_AutoscalingSpec_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntimeSpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntimeSpec_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RaySpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RaySpec_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RaySpec_ResourcePoolImagesEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RaySpec_ResourcePoolImagesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_AccessUrisEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_AccessUrisEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ServiceAccountSpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ServiceAccountSpec_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RayMetricSpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RayMetricSpec_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RayLogsSpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RayLogsSpec_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n9google/cloud/aiplatform/v1beta1/persis"
          + "tent_resource.proto\022\037google.cloud.aiplat"
          + "form.v1beta1\032\037google/api/field_behavior."
          + "proto\032\031google/api/resource.proto\0325google"
          + "/cloud/aiplatform/v1beta1/encryption_spe"
          + "c.proto\0327google/cloud/aiplatform/v1beta1"
          + "/machine_resources.proto\0328google/cloud/a"
          + "iplatform/v1beta1/service_networking.pro"
          + "to\032\037google/protobuf/timestamp.proto\032\027goo"
          + "gle/rpc/status.proto\"\324\t\n\022PersistentResou"
          + "rce\022\021\n\004name\030\001 \001(\tB\003\340A\005\022\031\n\014display_name\030\002"
          + " \001(\tB\003\340A\001\022J\n\016resource_pools\030\004 \003(\0132-.goog"
          + "le.cloud.aiplatform.v1beta1.ResourcePool"
          + "B\003\340A\002\022M\n\005state\030\005 \001(\01629.google.cloud.aipl"
          + "atform.v1beta1.PersistentResource.StateB"
          + "\003\340A\003\022&\n\005error\030\006 \001(\0132\022.google.rpc.StatusB"
          + "\003\340A\003\0224\n\013create_time\030\007 \001(\0132\032.google.proto"
          + "buf.TimestampB\003\340A\003\0223\n\nstart_time\030\010 \001(\0132\032"
          + ".google.protobuf.TimestampB\003\340A\003\0224\n\013updat"
          + "e_time\030\t \001(\0132\032.google.protobuf.Timestamp"
          + "B\003\340A\003\022T\n\006labels\030\n \003(\0132?.google.cloud.aip"
          + "latform.v1beta1.PersistentResource.Label"
          + "sEntryB\003\340A\001\0227\n\007network\030\013 \001(\tB&\340A\001\372A \n\036co"
          + "mpute.googleapis.com/Network\022V\n\024psc_inte"
          + "rface_config\030\021 \001(\01323.google.cloud.aiplat"
          + "form.v1beta1.PscInterfaceConfigB\003\340A\001\022M\n\017"
          + "encryption_spec\030\014 \001(\0132/.google.cloud.aip"
          + "latform.v1beta1.EncryptionSpecB\003\340A\001\022X\n\025r"
          + "esource_runtime_spec\030\r \001(\01324.google.clou"
          + "d.aiplatform.v1beta1.ResourceRuntimeSpec"
          + "B\003\340A\001\022O\n\020resource_runtime\030\016 \001(\01320.google"
          + ".cloud.aiplatform.v1beta1.ResourceRuntim"
          + "eB\003\340A\003\022\037\n\022reserved_ip_ranges\030\017 \003(\tB\003\340A\001\032"
          + "-\n\013LabelsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001"
          + "(\t:\0028\001\"s\n\005State\022\025\n\021STATE_UNSPECIFIED\020\000\022\020"
          + "\n\014PROVISIONING\020\001\022\013\n\007RUNNING\020\003\022\014\n\010STOPPIN"
          + "G\020\004\022\t\n\005ERROR\020\005\022\r\n\tREBOOTING\020\006\022\014\n\010UPDATIN"
          + "G\020\007:\205\001\352A\201\001\n,aiplatform.googleapis.com/Pe"
          + "rsistentResource\022Qprojects/{project}/loc"
          + "ations/{location}/persistentResources/{p"
          + "ersistent_resource}\"\352\003\n\014ResourcePool\022\017\n\002"
          + "id\030\001 \001(\tB\003\340A\005\022J\n\014machine_spec\030\002 \001(\0132,.go"
          + "ogle.cloud.aiplatform.v1beta1.MachineSpe"
          + "cB\006\340A\002\340A\005\022\037\n\rreplica_count\030\003 \001(\003B\003\340A\001H\000\210"
          + "\001\001\022A\n\tdisk_spec\030\004 \001(\0132).google.cloud.aip"
          + "latform.v1beta1.DiskSpecB\003\340A\001\022\037\n\022used_re"
          + "plica_count\030\006 \001(\003B\003\340A\003\022\\\n\020autoscaling_sp"
          + "ec\030\007 \001(\0132=.google.cloud.aiplatform.v1bet"
          + "a1.ResourcePool.AutoscalingSpecB\003\340A\001\032\207\001\n"
          + "\017AutoscalingSpec\022#\n\021min_replica_count\030\001 "
          + "\001(\003B\003\340A\001H\000\210\001\001\022#\n\021max_replica_count\030\002 \001(\003"
          + "B\003\340A\001H\001\210\001\001B\024\n\022_min_replica_countB\024\n\022_max"
          + "_replica_countB\020\n\016_replica_count\"\256\001\n\023Res"
          + "ourceRuntimeSpec\022V\n\024service_account_spec"
          + "\030\002 \001(\01323.google.cloud.aiplatform.v1beta1"
          + ".ServiceAccountSpecB\003\340A\001\022?\n\010ray_spec\030\001 \001"
          + "(\0132(.google.cloud.aiplatform.v1beta1.Ray"
          + "SpecB\003\340A\001\"\202\003\n\007RaySpec\022\026\n\timage_uri\030\001 \001(\t"
          + "B\003\340A\001\022c\n\024resource_pool_images\030\006 \003(\0132@.go"
          + "ogle.cloud.aiplatform.v1beta1.RaySpec.Re"
          + "sourcePoolImagesEntryB\003\340A\001\022\'\n\032head_node_"
          + "resource_pool_id\030\007 \001(\tB\003\340A\001\022L\n\017ray_metri"
          + "c_spec\030\010 \001(\0132..google.cloud.aiplatform.v"
          + "1beta1.RayMetricSpecB\003\340A\001\022H\n\rray_logs_sp"
          + "ec\030\n \001(\0132,.google.cloud.aiplatform.v1bet"
          + "a1.RayLogsSpecB\003\340A\001\0329\n\027ResourcePoolImage"
          + "sEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\"\200"
          + "\002\n\017ResourceRuntime\022Z\n\013access_uris\030\001 \003(\0132"
          + "@.google.cloud.aiplatform.v1beta1.Resour"
          + "ceRuntime.AccessUrisEntryB\003\340A\003\022^\n\031notebo"
          + "ok_runtime_template\030\002 \001(\tB;\030\001\340A\003\372A3\n1aip"
          + "latform.googleapis.com/NotebookRuntimeTe"
          + "mplate\0321\n\017AccessUrisEntry\022\013\n\003key\030\001 \001(\t\022\r"
          + "\n\005value\030\002 \001(\t:\0028\001\"^\n\022ServiceAccountSpec\022"
          + "*\n\035enable_custom_service_account\030\001 \001(\010B\003"
          + "\340A\002\022\034\n\017service_account\030\002 \001(\tB\003\340A\001\"&\n\rRay"
          + "MetricSpec\022\025\n\010disabled\030\001 \001(\010B\003\340A\001\"$\n\013Ray"
          + "LogsSpec\022\025\n\010disabled\030\001 \001(\010B\003\340A\001B\356\001\n#com."
          + "google.cloud.aiplatform.v1beta1B\027Persist"
          + "entResourceProtoP\001ZCcloud.google.com/go/"
          + "aiplatform/apiv1beta1/aiplatformpb;aipla"
          + "tformpb\252\002\037Google.Cloud.AIPlatform.V1Beta"
          + "1\312\002\037Google\\Cloud\\AIPlatform\\V1beta1\352\002\"Go"
          + "ogle::Cloud::AIPlatform::V1beta1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.EncryptionSpecProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.MachineResourcesProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.ServiceNetworkingProto.getDescriptor(),
              com.google.protobuf.TimestampProto.getDescriptor(),
              com.google.rpc.StatusProto.getDescriptor(),
            });
    internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_descriptor,
            new java.lang.String[] {
              "Name",
              "DisplayName",
              "ResourcePools",
              "State",
              "Error",
              "CreateTime",
              "StartTime",
              "UpdateTime",
              "Labels",
              "Network",
              "PscInterfaceConfig",
              "EncryptionSpec",
              "ResourceRuntimeSpec",
              "ResourceRuntime",
              "ReservedIpRanges",
            });
    internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_LabelsEntry_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_LabelsEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_PersistentResource_LabelsEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_descriptor,
            new java.lang.String[] {
              "Id",
              "MachineSpec",
              "ReplicaCount",
              "DiskSpec",
              "UsedReplicaCount",
              "AutoscalingSpec",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_AutoscalingSpec_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_AutoscalingSpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ResourcePool_AutoscalingSpec_descriptor,
            new java.lang.String[] {
              "MinReplicaCount", "MaxReplicaCount",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntimeSpec_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntimeSpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntimeSpec_descriptor,
            new java.lang.String[] {
              "ServiceAccountSpec", "RaySpec",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RaySpec_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_aiplatform_v1beta1_RaySpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RaySpec_descriptor,
            new java.lang.String[] {
              "ImageUri",
              "ResourcePoolImages",
              "HeadNodeResourcePoolId",
              "RayMetricSpec",
              "RayLogsSpec",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RaySpec_ResourcePoolImagesEntry_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_RaySpec_descriptor.getNestedTypes().get(0);
    internal_static_google_cloud_aiplatform_v1beta1_RaySpec_ResourcePoolImagesEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RaySpec_ResourcePoolImagesEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_descriptor,
            new java.lang.String[] {
              "AccessUris", "NotebookRuntimeTemplate",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_AccessUrisEntry_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_AccessUrisEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ResourceRuntime_AccessUrisEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ServiceAccountSpec_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_aiplatform_v1beta1_ServiceAccountSpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ServiceAccountSpec_descriptor,
            new java.lang.String[] {
              "EnableCustomServiceAccount", "ServiceAccount",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RayMetricSpec_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_aiplatform_v1beta1_RayMetricSpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RayMetricSpec_descriptor,
            new java.lang.String[] {
              "Disabled",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RayLogsSpec_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_aiplatform_v1beta1_RayLogsSpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RayLogsSpec_descriptor,
            new java.lang.String[] {
              "Disabled",
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
    com.google.cloud.aiplatform.v1beta1.EncryptionSpecProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.MachineResourcesProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.ServiceNetworkingProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

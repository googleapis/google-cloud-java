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
// source: google/cloud/gkehub/v1/feature.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.gkehub.v1;

public final class FeatureProto {
  private FeatureProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_Feature_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_Feature_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_Feature_LabelsEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_Feature_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_Feature_MembershipSpecsEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_Feature_MembershipSpecsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_Feature_MembershipStatesEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_Feature_MembershipStatesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_FeatureResourceState_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_FeatureResourceState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_FeatureState_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_FeatureState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_CommonFeatureSpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_CommonFeatureSpec_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_CommonFeatureState_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_CommonFeatureState_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_MembershipFeatureSpec_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_MembershipFeatureSpec_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_gkehub_v1_MembershipFeatureState_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_gkehub_v1_MembershipFeatureState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n$google/cloud/gkehub/v1/feature.proto\022\026"
          + "google.cloud.gkehub.v1\032\037google/api/field"
          + "_behavior.proto\032\031google/api/resource.pro"
          + "to\032>google/cloud/gkehub/v1/configmanagem"
          + "ent/configmanagement.proto\032Dgoogle/cloud"
          + "/gkehub/v1/multiclusteringress/multiclus"
          + "teringress.proto\032\037google/protobuf/timest"
          + "amp.proto\"\317\007\n\007Feature\022\021\n\004name\030\001 \001(\tB\003\340A\003"
          + "\022;\n\006labels\030\002 \003(\0132+.google.cloud.gkehub.v"
          + "1.Feature.LabelsEntry\022I\n\016resource_state\030"
          + "\003 \001(\0132,.google.cloud.gkehub.v1.FeatureRe"
          + "sourceStateB\003\340A\003\022<\n\004spec\030\004 \001(\0132).google."
          + "cloud.gkehub.v1.CommonFeatureSpecB\003\340A\001\022S"
          + "\n\020membership_specs\030\005 \003(\01324.google.cloud."
          + "gkehub.v1.Feature.MembershipSpecsEntryB\003"
          + "\340A\001\022>\n\005state\030\006 \001(\0132*.google.cloud.gkehub"
          + ".v1.CommonFeatureStateB\003\340A\003\022U\n\021membershi"
          + "p_states\030\007 \003(\01325.google.cloud.gkehub.v1."
          + "Feature.MembershipStatesEntryB\003\340A\003\0224\n\013cr"
          + "eate_time\030\010 \001(\0132\032.google.protobuf.Timest"
          + "ampB\003\340A\003\0224\n\013update_time\030\t \001(\0132\032.google.p"
          + "rotobuf.TimestampB\003\340A\003\0224\n\013delete_time\030\n "
          + "\001(\0132\032.google.protobuf.TimestampB\003\340A\003\032-\n\013"
          + "LabelsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:"
          + "\0028\001\032e\n\024MembershipSpecsEntry\022\013\n\003key\030\001 \001(\t"
          + "\022<\n\005value\030\002 \001(\0132-.google.cloud.gkehub.v1"
          + ".MembershipFeatureSpec:\0028\001\032g\n\025Membership"
          + "StatesEntry\022\013\n\003key\030\001 \001(\t\022=\n\005value\030\002 \001(\0132"
          + "..google.cloud.gkehub.v1.MembershipFeatu"
          + "reState:\0028\001:^\352A[\n\035gkehub.googleapis.com/"
          + "Feature\022:projects/{project}/locations/{l"
          + "ocation}/features/{feature}\"\306\001\n\024FeatureR"
          + "esourceState\022A\n\005state\030\001 \001(\01622.google.clo"
          + "ud.gkehub.v1.FeatureResourceState.State\""
          + "k\n\005State\022\025\n\021STATE_UNSPECIFIED\020\000\022\014\n\010ENABL"
          + "ING\020\001\022\n\n\006ACTIVE\020\002\022\r\n\tDISABLING\020\003\022\014\n\010UPDA"
          + "TING\020\004\022\024\n\020SERVICE_UPDATING\020\005\"\313\001\n\014Feature"
          + "State\0227\n\004code\030\001 \001(\0162).google.cloud.gkehu"
          + "b.v1.FeatureState.Code\022\023\n\013description\030\002 "
          + "\001(\t\022/\n\013update_time\030\003 \001(\0132\032.google.protob"
          + "uf.Timestamp\"<\n\004Code\022\024\n\020CODE_UNSPECIFIED"
          + "\020\000\022\006\n\002OK\020\001\022\013\n\007WARNING\020\002\022\t\n\005ERROR\020\003\"{\n\021Co"
          + "mmonFeatureSpec\022V\n\023multiclusteringress\030f"
          + " \001(\01327.google.cloud.gkehub.multiclusteri"
          + "ngress.v1.FeatureSpecH\000B\016\n\014feature_spec\""
          + "N\n\022CommonFeatureState\0228\n\005state\030\001 \001(\0132$.g"
          + "oogle.cloud.gkehub.v1.FeatureStateB\003\340A\003\""
          + "|\n\025MembershipFeatureSpec\022S\n\020configmanage"
          + "ment\030j \001(\01327.google.cloud.gkehub.configm"
          + "anagement.v1.MembershipSpecH\000B\016\n\014feature"
          + "_spec\"\264\001\n\026MembershipFeatureState\022T\n\020conf"
          + "igmanagement\030j \001(\01328.google.cloud.gkehub"
          + ".configmanagement.v1.MembershipStateH\000\0223"
          + "\n\005state\030\001 \001(\0132$.google.cloud.gkehub.v1.F"
          + "eatureStateB\017\n\rfeature_stateB\256\001\n\032com.goo"
          + "gle.cloud.gkehub.v1B\014FeatureProtoP\001Z2clo"
          + "ud.google.com/go/gkehub/apiv1/gkehubpb;g"
          + "kehubpb\252\002\026Google.Cloud.GkeHub.V1\312\002\026Googl"
          + "e\\Cloud\\GkeHub\\V1\352\002\031Google::Cloud::GkeHu"
          + "b::V1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.gkehub.configmanagement.v1.ConfigManagementProto.getDescriptor(),
              com.google.cloud.gkehub.multiclusteringress.v1.MultiClusterIngressProto
                  .getDescriptor(),
              com.google.protobuf.TimestampProto.getDescriptor(),
            });
    internal_static_google_cloud_gkehub_v1_Feature_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_gkehub_v1_Feature_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_Feature_descriptor,
            new java.lang.String[] {
              "Name",
              "Labels",
              "ResourceState",
              "Spec",
              "MembershipSpecs",
              "State",
              "MembershipStates",
              "CreateTime",
              "UpdateTime",
              "DeleteTime",
            });
    internal_static_google_cloud_gkehub_v1_Feature_LabelsEntry_descriptor =
        internal_static_google_cloud_gkehub_v1_Feature_descriptor.getNestedTypes().get(0);
    internal_static_google_cloud_gkehub_v1_Feature_LabelsEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_Feature_LabelsEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_gkehub_v1_Feature_MembershipSpecsEntry_descriptor =
        internal_static_google_cloud_gkehub_v1_Feature_descriptor.getNestedTypes().get(1);
    internal_static_google_cloud_gkehub_v1_Feature_MembershipSpecsEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_Feature_MembershipSpecsEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_gkehub_v1_Feature_MembershipStatesEntry_descriptor =
        internal_static_google_cloud_gkehub_v1_Feature_descriptor.getNestedTypes().get(2);
    internal_static_google_cloud_gkehub_v1_Feature_MembershipStatesEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_Feature_MembershipStatesEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_gkehub_v1_FeatureResourceState_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_gkehub_v1_FeatureResourceState_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_FeatureResourceState_descriptor,
            new java.lang.String[] {
              "State",
            });
    internal_static_google_cloud_gkehub_v1_FeatureState_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_gkehub_v1_FeatureState_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_FeatureState_descriptor,
            new java.lang.String[] {
              "Code", "Description", "UpdateTime",
            });
    internal_static_google_cloud_gkehub_v1_CommonFeatureSpec_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_gkehub_v1_CommonFeatureSpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_CommonFeatureSpec_descriptor,
            new java.lang.String[] {
              "Multiclusteringress", "FeatureSpec",
            });
    internal_static_google_cloud_gkehub_v1_CommonFeatureState_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_gkehub_v1_CommonFeatureState_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_CommonFeatureState_descriptor,
            new java.lang.String[] {
              "State",
            });
    internal_static_google_cloud_gkehub_v1_MembershipFeatureSpec_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_gkehub_v1_MembershipFeatureSpec_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_MembershipFeatureSpec_descriptor,
            new java.lang.String[] {
              "Configmanagement", "FeatureSpec",
            });
    internal_static_google_cloud_gkehub_v1_MembershipFeatureState_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_gkehub_v1_MembershipFeatureState_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_gkehub_v1_MembershipFeatureState_descriptor,
            new java.lang.String[] {
              "Configmanagement", "State", "FeatureState",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.ResourceProto.resource);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.gkehub.configmanagement.v1.ConfigManagementProto.getDescriptor();
    com.google.cloud.gkehub.multiclusteringress.v1.MultiClusterIngressProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

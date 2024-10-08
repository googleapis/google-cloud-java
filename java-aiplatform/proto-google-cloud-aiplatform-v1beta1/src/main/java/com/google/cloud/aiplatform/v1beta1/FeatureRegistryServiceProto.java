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
// source: google/cloud/aiplatform/v1beta1/feature_registry_service.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.aiplatform.v1beta1;

public final class FeatureRegistryServiceProto {
  private FeatureRegistryServiceProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_GetFeatureGroupRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_GetFeatureGroupRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_DeleteFeatureGroupRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_DeleteFeatureGroupRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupOperationMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupOperationMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupOperationMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupOperationMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_CreateRegistryFeatureOperationMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_CreateRegistryFeatureOperationMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureOperationMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureOperationMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n>google/cloud/aiplatform/v1beta1/featur"
          + "e_registry_service.proto\022\037google.cloud.a"
          + "iplatform.v1beta1\032\034google/api/annotation"
          + "s.proto\032\027google/api/client.proto\032\037google"
          + "/api/field_behavior.proto\032\031google/api/re"
          + "source.proto\032-google/cloud/aiplatform/v1"
          + "beta1/feature.proto\0323google/cloud/aiplat"
          + "form/v1beta1/feature_group.proto\032:google"
          + "/cloud/aiplatform/v1beta1/featurestore_s"
          + "ervice.proto\032/google/cloud/aiplatform/v1"
          + "beta1/operation.proto\032#google/longrunnin"
          + "g/operations.proto\032\033google/protobuf/empt"
          + "y.proto\032 google/protobuf/field_mask.prot"
          + "o\"\305\001\n\031CreateFeatureGroupRequest\022>\n\006paren"
          + "t\030\001 \001(\tB.\340A\002\372A(\022&aiplatform.googleapis.c"
          + "om/FeatureGroup\022I\n\rfeature_group\030\002 \001(\0132-"
          + ".google.cloud.aiplatform.v1beta1.Feature"
          + "GroupB\003\340A\002\022\035\n\020feature_group_id\030\003 \001(\tB\003\340A"
          + "\002\"V\n\026GetFeatureGroupRequest\022<\n\004name\030\001 \001("
          + "\tB.\340A\002\372A(\n&aiplatform.googleapis.com/Fea"
          + "tureGroup\"\243\001\n\030ListFeatureGroupsRequest\022>"
          + "\n\006parent\030\001 \001(\tB.\340A\002\372A(\022&aiplatform.googl"
          + "eapis.com/FeatureGroup\022\016\n\006filter\030\002 \001(\t\022\021"
          + "\n\tpage_size\030\003 \001(\005\022\022\n\npage_token\030\004 \001(\t\022\020\n"
          + "\010order_by\030\005 \001(\t\"{\n\031ListFeatureGroupsResp"
          + "onse\022E\n\016feature_groups\030\001 \003(\0132-.google.cl"
          + "oud.aiplatform.v1beta1.FeatureGroup\022\027\n\017n"
          + "ext_page_token\030\002 \001(\t\"\227\001\n\031UpdateFeatureGr"
          + "oupRequest\022I\n\rfeature_group\030\001 \001(\0132-.goog"
          + "le.cloud.aiplatform.v1beta1.FeatureGroup"
          + "B\003\340A\002\022/\n\013update_mask\030\002 \001(\0132\032.google.prot"
          + "obuf.FieldMask\"h\n\031DeleteFeatureGroupRequ"
          + "est\022<\n\004name\030\001 \001(\tB.\340A\002\372A(\n&aiplatform.go"
          + "ogleapis.com/FeatureGroup\022\r\n\005force\030\002 \001(\010"
          + "\"z\n#CreateFeatureGroupOperationMetadata\022"
          + "S\n\020generic_metadata\030\001 \001(\01329.google.cloud"
          + ".aiplatform.v1beta1.GenericOperationMeta"
          + "data\"z\n#UpdateFeatureGroupOperationMetad"
          + "ata\022S\n\020generic_metadata\030\001 \001(\01329.google.c"
          + "loud.aiplatform.v1beta1.GenericOperation"
          + "Metadata\"}\n&CreateRegistryFeatureOperati"
          + "onMetadata\022S\n\020generic_metadata\030\001 \001(\01329.g"
          + "oogle.cloud.aiplatform.v1beta1.GenericOp"
          + "erationMetadata\"u\n\036UpdateFeatureOperatio"
          + "nMetadata\022S\n\020generic_metadata\030\001 \001(\01329.go"
          + "ogle.cloud.aiplatform.v1beta1.GenericOpe"
          + "rationMetadata2\277\023\n\026FeatureRegistryServic"
          + "e\022\235\002\n\022CreateFeatureGroup\022:.google.cloud."
          + "aiplatform.v1beta1.CreateFeatureGroupReq"
          + "uest\032\035.google.longrunning.Operation\"\253\001\312A"
          + "3\n\014FeatureGroup\022#CreateFeatureGroupOpera"
          + "tionMetadata\332A%parent,feature_group,feat"
          + "ure_group_id\202\323\344\223\002G\"6/v1beta1/{parent=pro"
          + "jects/*/locations/*}/featureGroups:\rfeat"
          + "ure_group\022\300\001\n\017GetFeatureGroup\0227.google.c"
          + "loud.aiplatform.v1beta1.GetFeatureGroupR"
          + "equest\032-.google.cloud.aiplatform.v1beta1"
          + ".FeatureGroup\"E\332A\004name\202\323\344\223\0028\0226/v1beta1/{"
          + "name=projects/*/locations/*/featureGroup"
          + "s/*}\022\323\001\n\021ListFeatureGroups\0229.google.clou"
          + "d.aiplatform.v1beta1.ListFeatureGroupsRe"
          + "quest\032:.google.cloud.aiplatform.v1beta1."
          + "ListFeatureGroupsResponse\"G\332A\006parent\202\323\344\223"
          + "\0028\0226/v1beta1/{parent=projects/*/location"
          + "s/*}/featureGroups\022\237\002\n\022UpdateFeatureGrou"
          + "p\022:.google.cloud.aiplatform.v1beta1.Upda"
          + "teFeatureGroupRequest\032\035.google.longrunni"
          + "ng.Operation\"\255\001\312A3\n\014FeatureGroup\022#Update"
          + "FeatureGroupOperationMetadata\332A\031feature_"
          + "group,update_mask\202\323\344\223\002U2D/v1beta1/{featu"
          + "re_group.name=projects/*/locations/*/fea"
          + "tureGroups/*}:\rfeature_group\022\357\001\n\022DeleteF"
          + "eatureGroup\022:.google.cloud.aiplatform.v1"
          + "beta1.DeleteFeatureGroupRequest\032\035.google"
          + ".longrunning.Operation\"~\312A0\n\025google.prot"
          + "obuf.Empty\022\027DeleteOperationMetadata\332A\nna"
          + "me,force\202\323\344\223\0028*6/v1beta1/{name=projects/"
          + "*/locations/*/featureGroups/*}\022\202\002\n\rCreat"
          + "eFeature\0225.google.cloud.aiplatform.v1bet"
          + "a1.CreateFeatureRequest\032\035.google.longrun"
          + "ning.Operation\"\232\001\312A)\n\007Feature\022\036CreateFea"
          + "tureOperationMetadata\332A\031parent,feature,f"
          + "eature_id\202\323\344\223\002L\"A/v1beta1/{parent=projec"
          + "ts/*/locations/*/featureGroups/*}/featur"
          + "es:\007feature\022\274\001\n\nGetFeature\0222.google.clou"
          + "d.aiplatform.v1beta1.GetFeatureRequest\032("
          + ".google.cloud.aiplatform.v1beta1.Feature"
          + "\"P\332A\004name\202\323\344\223\002C\022A/v1beta1/{name=projects"
          + "/*/locations/*/featureGroups/*/features/"
          + "*}\022\317\001\n\014ListFeatures\0224.google.cloud.aipla"
          + "tform.v1beta1.ListFeaturesRequest\0325.goog"
          + "le.cloud.aiplatform.v1beta1.ListFeatures"
          + "Response\"R\332A\006parent\202\323\344\223\002C\022A/v1beta1/{par"
          + "ent=projects/*/locations/*/featureGroups"
          + "/*}/features\022\204\002\n\rUpdateFeature\0225.google."
          + "cloud.aiplatform.v1beta1.UpdateFeatureRe"
          + "quest\032\035.google.longrunning.Operation\"\234\001\312"
          + "A)\n\007Feature\022\036UpdateFeatureOperationMetad"
          + "ata\332A\023feature,update_mask\202\323\344\223\002T2I/v1beta"
          + "1/{feature.name=projects/*/locations/*/f"
          + "eatureGroups/*/features/*}:\007feature\022\353\001\n\r"
          + "DeleteFeature\0225.google.cloud.aiplatform."
          + "v1beta1.DeleteFeatureRequest\032\035.google.lo"
          + "ngrunning.Operation\"\203\001\312A0\n\025google.protob"
          + "uf.Empty\022\027DeleteOperationMetadata\332A\004name"
          + "\202\323\344\223\002C*A/v1beta1/{name=projects/*/locati"
          + "ons/*/featureGroups/*/features/*}\032M\312A\031ai"
          + "platform.googleapis.com\322A.https://www.go"
          + "ogleapis.com/auth/cloud-platformB\362\001\n#com"
          + ".google.cloud.aiplatform.v1beta1B\033Featur"
          + "eRegistryServiceProtoP\001ZCcloud.google.co"
          + "m/go/aiplatform/apiv1beta1/aiplatformpb;"
          + "aiplatformpb\252\002\037Google.Cloud.AIPlatform.V"
          + "1Beta1\312\002\037Google\\Cloud\\AIPlatform\\V1beta1"
          + "\352\002\"Google::Cloud::AIPlatform::V1beta1b\006p"
          + "roto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.FeatureProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.FeatureGroupProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.OperationProto.getDescriptor(),
              com.google.longrunning.OperationsProto.getDescriptor(),
              com.google.protobuf.EmptyProto.getDescriptor(),
              com.google.protobuf.FieldMaskProto.getDescriptor(),
            });
    internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupRequest_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupRequest_descriptor,
            new java.lang.String[] {
              "Parent", "FeatureGroup", "FeatureGroupId",
            });
    internal_static_google_cloud_aiplatform_v1beta1_GetFeatureGroupRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_aiplatform_v1beta1_GetFeatureGroupRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_GetFeatureGroupRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "Filter", "PageSize", "PageToken", "OrderBy",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsResponse_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ListFeatureGroupsResponse_descriptor,
            new java.lang.String[] {
              "FeatureGroups", "NextPageToken",
            });
    internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupRequest_descriptor,
            new java.lang.String[] {
              "FeatureGroup", "UpdateMask",
            });
    internal_static_google_cloud_aiplatform_v1beta1_DeleteFeatureGroupRequest_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_aiplatform_v1beta1_DeleteFeatureGroupRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_DeleteFeatureGroupRequest_descriptor,
            new java.lang.String[] {
              "Name", "Force",
            });
    internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupOperationMetadata_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupOperationMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_CreateFeatureGroupOperationMetadata_descriptor,
            new java.lang.String[] {
              "GenericMetadata",
            });
    internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupOperationMetadata_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupOperationMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureGroupOperationMetadata_descriptor,
            new java.lang.String[] {
              "GenericMetadata",
            });
    internal_static_google_cloud_aiplatform_v1beta1_CreateRegistryFeatureOperationMetadata_descriptor =
        getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_aiplatform_v1beta1_CreateRegistryFeatureOperationMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_CreateRegistryFeatureOperationMetadata_descriptor,
            new java.lang.String[] {
              "GenericMetadata",
            });
    internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureOperationMetadata_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureOperationMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_UpdateFeatureOperationMetadata_descriptor,
            new java.lang.String[] {
              "GenericMetadata",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resourceReference);
    registry.add(com.google.longrunning.OperationsProto.operationInfo);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.FeatureProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.FeatureGroupProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.OperationProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

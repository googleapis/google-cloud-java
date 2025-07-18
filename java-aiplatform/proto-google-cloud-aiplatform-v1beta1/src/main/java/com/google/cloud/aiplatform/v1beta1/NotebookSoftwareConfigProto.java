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
// source: google/cloud/aiplatform/v1beta1/notebook_software_config.proto

// Protobuf Java Version: 3.25.8
package com.google.cloud.aiplatform.v1beta1;

public final class NotebookSoftwareConfigProto {
  private NotebookSoftwareConfigProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_PostStartupScriptConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_PostStartupScriptConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_ColabImage_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_ColabImage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_NotebookSoftwareConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_NotebookSoftwareConfig_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n>google/cloud/aiplatform/v1beta1/notebo"
          + "ok_software_config.proto\022\037google.cloud.a"
          + "iplatform.v1beta1\032\037google/api/field_beha"
          + "vior.proto\032-google/cloud/aiplatform/v1be"
          + "ta1/env_var.proto\"\361\002\n\027PostStartupScriptC"
          + "onfig\022 \n\023post_startup_script\030\001 \001(\tB\003\340A\001\022"
          + "$\n\027post_startup_script_url\030\002 \001(\tB\003\340A\001\022}\n"
          + "\034post_startup_script_behavior\030\003 \001(\0162R.go"
          + "ogle.cloud.aiplatform.v1beta1.PostStartu"
          + "pScriptConfig.PostStartupScriptBehaviorB"
          + "\003\340A\001\"\216\001\n\031PostStartupScriptBehavior\022,\n(PO"
          + "ST_STARTUP_SCRIPT_BEHAVIOR_UNSPECIFIED\020\000"
          + "\022\014\n\010RUN_ONCE\020\001\022\023\n\017RUN_EVERY_START\020\002\022 \n\034D"
          + "OWNLOAD_AND_RUN_EVERY_START\020\003\"A\n\nColabIm"
          + "age\022\031\n\014release_name\030\001 \001(\tB\003\340A\001\022\030\n\013descri"
          + "ption\030\002 \001(\tB\003\340A\003\"\220\002\n\026NotebookSoftwareCon"
          + "fig\022G\n\013colab_image\030\005 \001(\0132+.google.cloud."
          + "aiplatform.v1beta1.ColabImageB\003\340A\001H\000\0229\n\003"
          + "env\030\001 \003(\0132\'.google.cloud.aiplatform.v1be"
          + "ta1.EnvVarB\003\340A\001\022a\n\032post_startup_script_c"
          + "onfig\030\002 \001(\01328.google.cloud.aiplatform.v1"
          + "beta1.PostStartupScriptConfigB\003\340A\001B\017\n\rru"
          + "ntime_imageB\362\001\n#com.google.cloud.aiplatf"
          + "orm.v1beta1B\033NotebookSoftwareConfigProto"
          + "P\001ZCcloud.google.com/go/aiplatform/apiv1"
          + "beta1/aiplatformpb;aiplatformpb\252\002\037Google"
          + ".Cloud.AIPlatform.V1Beta1\312\002\037Google\\Cloud"
          + "\\AIPlatform\\V1beta1\352\002\"Google::Cloud::AIP"
          + "latform::V1beta1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.EnvVarProto.getDescriptor(),
            });
    internal_static_google_cloud_aiplatform_v1beta1_PostStartupScriptConfig_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_aiplatform_v1beta1_PostStartupScriptConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_PostStartupScriptConfig_descriptor,
            new java.lang.String[] {
              "PostStartupScript", "PostStartupScriptUrl", "PostStartupScriptBehavior",
            });
    internal_static_google_cloud_aiplatform_v1beta1_ColabImage_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_aiplatform_v1beta1_ColabImage_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_ColabImage_descriptor,
            new java.lang.String[] {
              "ReleaseName", "Description",
            });
    internal_static_google_cloud_aiplatform_v1beta1_NotebookSoftwareConfig_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_aiplatform_v1beta1_NotebookSoftwareConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_NotebookSoftwareConfig_descriptor,
            new java.lang.String[] {
              "ColabImage", "Env", "PostStartupScriptConfig", "RuntimeImage",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.EnvVarProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

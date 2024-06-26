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
// source: google/cloud/discoveryengine/v1beta/document_processing_config.proto

// Protobuf Java Version: 3.25.3
package com.google.cloud.discoveryengine.v1beta;

public final class DocumentProcessingConfigProto {
  private DocumentProcessingConfigProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_DigitalParsingConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_DigitalParsingConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_OcrParsingConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_OcrParsingConfig_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfigOverridesEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfigOverridesEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\nDgoogle/cloud/discoveryengine/v1beta/do"
          + "cument_processing_config.proto\022#google.c"
          + "loud.discoveryengine.v1beta\032\037google/api/"
          + "field_behavior.proto\032\031google/api/resourc"
          + "e.proto\"\305\010\n\030DocumentProcessingConfig\022\014\n\004"
          + "name\030\001 \001(\t\022k\n\026default_parsing_config\030\004 \001"
          + "(\0132K.google.cloud.discoveryengine.v1beta"
          + ".DocumentProcessingConfig.ParsingConfig\022"
          + "{\n\030parsing_config_overrides\030\005 \003(\0132Y.goog"
          + "le.cloud.discoveryengine.v1beta.Document"
          + "ProcessingConfig.ParsingConfigOverridesE"
          + "ntry\032\226\003\n\rParsingConfig\022\202\001\n\026digital_parsi"
          + "ng_config\030\001 \001(\0132`.google.cloud.discovery"
          + "engine.v1beta.DocumentProcessingConfig.P"
          + "arsingConfig.DigitalParsingConfigH\000\022z\n\022o"
          + "cr_parsing_config\030\002 \001(\0132\\.google.cloud.d"
          + "iscoveryengine.v1beta.DocumentProcessing"
          + "Config.ParsingConfig.OcrParsingConfigH\000\032"
          + "\026\n\024DigitalParsingConfig\032S\n\020OcrParsingCon"
          + "fig\022&\n\032enhanced_document_elements\030\001 \003(\tB"
          + "\002\030\001\022\027\n\017use_native_text\030\002 \001(\010B\027\n\025type_ded"
          + "icated_config\032\212\001\n\033ParsingConfigOverrides"
          + "Entry\022\013\n\003key\030\001 \001(\t\022Z\n\005value\030\002 \001(\0132K.goog"
          + "le.cloud.discoveryengine.v1beta.Document"
          + "ProcessingConfig.ParsingConfig:\0028\001:\212\002\352A\206"
          + "\002\n7discoveryengine.googleapis.com/Docume"
          + "ntProcessingConfig\022Xprojects/{project}/l"
          + "ocations/{location}/dataStores/{data_sto"
          + "re}/documentProcessingConfig\022qprojects/{"
          + "project}/locations/{location}/collection"
          + "s/{collection}/dataStores/{data_store}/d"
          + "ocumentProcessingConfigB\244\002\n\'com.google.c"
          + "loud.discoveryengine.v1betaB\035DocumentPro"
          + "cessingConfigProtoP\001ZQcloud.google.com/g"
          + "o/discoveryengine/apiv1beta/discoveryeng"
          + "inepb;discoveryenginepb\242\002\017DISCOVERYENGIN"
          + "E\252\002#Google.Cloud.DiscoveryEngine.V1Beta\312"
          + "\002#Google\\Cloud\\DiscoveryEngine\\V1beta\352\002&"
          + "Google::Cloud::DiscoveryEngine::V1betab\006"
          + "proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
            });
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_descriptor,
            new java.lang.String[] {
              "Name", "DefaultParsingConfig", "ParsingConfigOverrides",
            });
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_descriptor =
        internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_descriptor,
            new java.lang.String[] {
              "DigitalParsingConfig", "OcrParsingConfig", "TypeDedicatedConfig",
            });
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_DigitalParsingConfig_descriptor =
        internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_DigitalParsingConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_DigitalParsingConfig_descriptor,
            new java.lang.String[] {});
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_OcrParsingConfig_descriptor =
        internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_descriptor
            .getNestedTypes()
            .get(1);
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_OcrParsingConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfig_OcrParsingConfig_descriptor,
            new java.lang.String[] {
              "EnhancedDocumentElements", "UseNativeText",
            });
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfigOverridesEntry_descriptor =
        internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_descriptor
            .getNestedTypes()
            .get(1);
    internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfigOverridesEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_discoveryengine_v1beta_DocumentProcessingConfig_ParsingConfigOverridesEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ResourceProto.resource);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

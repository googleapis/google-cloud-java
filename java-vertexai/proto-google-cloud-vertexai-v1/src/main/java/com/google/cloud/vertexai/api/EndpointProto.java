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
// source: google/cloud/vertexai/v1/endpoint.proto

// Protobuf Java Version: 3.25.3
package com.google.cloud.vertexai.api;

public final class EndpointProto {
  private EndpointProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_vertexai_v1_Endpoint_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_vertexai_v1_Endpoint_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_vertexai_v1_Endpoint_TrafficSplitEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_vertexai_v1_Endpoint_TrafficSplitEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_vertexai_v1_Endpoint_LabelsEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_vertexai_v1_Endpoint_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_vertexai_v1_DeployedModel_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_vertexai_v1_DeployedModel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_vertexai_v1_PrivateEndpoints_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_vertexai_v1_PrivateEndpoints_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_vertexai_v1_PredictRequestResponseLoggingConfig_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_vertexai_v1_PredictRequestResponseLoggingConfig_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\'google/cloud/vertexai/v1/endpoint.prot"
          + "o\022\030google.cloud.vertexai.v1\032\037google/api/"
          + "field_behavior.proto\032\031google/api/resourc"
          + "e.proto\032.google/cloud/vertexai/v1/encryp"
          + "tion_spec.proto\032*google/cloud/vertexai/v"
          + "1/explanation.proto\032!google/cloud/vertex"
          + "ai/v1/io.proto\0320google/cloud/vertexai/v1"
          + "/machine_resources.proto\0321google/cloud/v"
          + "ertexai/v1/service_networking.proto\032\037goo"
          + "gle/protobuf/timestamp.proto\"\235\n\n\010Endpoin"
          + "t\022\021\n\004name\030\001 \001(\tB\003\340A\003\022\031\n\014display_name\030\002 \001"
          + "(\tB\003\340A\002\022\023\n\013description\030\003 \001(\t\022E\n\017deployed"
          + "_models\030\004 \003(\0132\'.google.cloud.vertexai.v1"
          + ".DeployedModelB\003\340A\003\022K\n\rtraffic_split\030\005 \003"
          + "(\01324.google.cloud.vertexai.v1.Endpoint.T"
          + "rafficSplitEntry\022\014\n\004etag\030\006 \001(\t\022>\n\006labels"
          + "\030\007 \003(\0132..google.cloud.vertexai.v1.Endpoi"
          + "nt.LabelsEntry\0224\n\013create_time\030\010 \001(\0132\032.go"
          + "ogle.protobuf.TimestampB\003\340A\003\0224\n\013update_t"
          + "ime\030\t \001(\0132\032.google.protobuf.TimestampB\003\340"
          + "A\003\022A\n\017encryption_spec\030\n \001(\0132(.google.clo"
          + "ud.vertexai.v1.EncryptionSpec\0227\n\007network"
          + "\030\r \001(\tB&\340A\001\372A \n\036compute.googleapis.com/N"
          + "etwork\022*\n\036enable_private_service_connect"
          + "\030\021 \001(\010B\002\030\001\022b\n\036private_service_connect_co"
          + "nfig\030\025 \001(\01325.google.cloud.vertexai.v1.Pr"
          + "ivateServiceConnectConfigB\003\340A\001\022g\n\037model_"
          + "deployment_monitoring_job\030\016 \001(\tB>\340A\003\372A8\n"
          + "6aiplatform.googleapis.com/ModelDeployme"
          + "ntMonitoringJob\022n\n\'predict_request_respo"
          + "nse_logging_config\030\022 \001(\0132=.google.cloud."
          + "vertexai.v1.PredictRequestResponseLoggin"
          + "gConfig\022\"\n\032dedicated_endpoint_enabled\030\030 "
          + "\001(\010\022#\n\026dedicated_endpoint_dns\030\031 \001(\tB\003\340A\003"
          + "\022\032\n\rsatisfies_pzs\030\033 \001(\010B\003\340A\003\022\032\n\rsatisfie"
          + "s_pzi\030\034 \001(\010B\003\340A\003\0323\n\021TrafficSplitEntry\022\013\n"
          + "\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\005:\0028\001\032-\n\013LabelsE"
          + "ntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001:\265\001\352"
          + "A\261\001\n\"aiplatform.googleapis.com/Endpoint\022"
          + "<projects/{project}/locations/{location}"
          + "/endpoints/{endpoint}\022Mprojects/{project"
          + "}/locations/{location}/publishers/{publi"
          + "sher}/models/{model}\"\322\005\n\rDeployedModel\022K"
          + "\n\023dedicated_resources\030\007 \001(\0132,.google.clo"
          + "ud.vertexai.v1.DedicatedResourcesH\000\022K\n\023a"
          + "utomatic_resources\030\010 \001(\0132,.google.cloud."
          + "vertexai.v1.AutomaticResourcesH\000\022Q\n\020shar"
          + "ed_resources\030\021 \001(\tB5\372A2\n0aiplatform.goog"
          + "leapis.com/DeploymentResourcePoolH\000\022\017\n\002i"
          + "d\030\001 \001(\tB\003\340A\005\0226\n\005model\030\002 \001(\tB\'\340A\002\372A!\n\037aip"
          + "latform.googleapis.com/Model\022\035\n\020model_ve"
          + "rsion_id\030\022 \001(\tB\003\340A\003\022\024\n\014display_name\030\003 \001("
          + "\t\0224\n\013create_time\030\006 \001(\0132\032.google.protobuf"
          + ".TimestampB\003\340A\003\022C\n\020explanation_spec\030\t \001("
          + "\0132).google.cloud.vertexai.v1.Explanation"
          + "Spec\022\034\n\024disable_explanations\030\023 \001(\010\022\027\n\017se"
          + "rvice_account\030\013 \001(\t\022!\n\031disable_container"
          + "_logging\030\017 \001(\010\022\035\n\025enable_access_logging\030"
          + "\r \001(\010\022J\n\021private_endpoints\030\016 \001(\0132*.googl"
          + "e.cloud.vertexai.v1.PrivateEndpointsB\003\340A"
          + "\003B\026\n\024prediction_resources\"\217\001\n\020PrivateEnd"
          + "points\022\035\n\020predict_http_uri\030\001 \001(\tB\003\340A\003\022\035\n"
          + "\020explain_http_uri\030\002 \001(\tB\003\340A\003\022\034\n\017health_h"
          + "ttp_uri\030\003 \001(\tB\003\340A\003\022\037\n\022service_attachment"
          + "\030\004 \001(\tB\003\340A\003\"\232\001\n#PredictRequestResponseLo"
          + "ggingConfig\022\017\n\007enabled\030\001 \001(\010\022\025\n\rsampling"
          + "_rate\030\002 \001(\001\022K\n\024bigquery_destination\030\003 \001("
          + "\0132-.google.cloud.vertexai.v1.BigQueryDes"
          + "tinationB\312\001\n\035com.google.cloud.vertexai.a"
          + "piB\rEndpointProtoP\001Z>cloud.google.com/go"
          + "/aiplatform/apiv1/aiplatformpb;aiplatfor"
          + "mpb\252\002\032Google.Cloud.AIPlatform.V1\312\002\032Googl"
          + "e\\Cloud\\AIPlatform\\V1\352\002\035Google::Cloud::A"
          + "IPlatform::V1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.vertexai.api.EncryptionSpecProto.getDescriptor(),
              com.google.cloud.vertexai.api.ExplanationProto.getDescriptor(),
              com.google.cloud.vertexai.api.IoProto.getDescriptor(),
              com.google.cloud.vertexai.api.MachineResourcesProto.getDescriptor(),
              com.google.cloud.vertexai.api.ServiceNetworkingProto.getDescriptor(),
              com.google.protobuf.TimestampProto.getDescriptor(),
            });
    internal_static_google_cloud_vertexai_v1_Endpoint_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_vertexai_v1_Endpoint_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_vertexai_v1_Endpoint_descriptor,
            new java.lang.String[] {
              "Name",
              "DisplayName",
              "Description",
              "DeployedModels",
              "TrafficSplit",
              "Etag",
              "Labels",
              "CreateTime",
              "UpdateTime",
              "EncryptionSpec",
              "Network",
              "EnablePrivateServiceConnect",
              "PrivateServiceConnectConfig",
              "ModelDeploymentMonitoringJob",
              "PredictRequestResponseLoggingConfig",
              "DedicatedEndpointEnabled",
              "DedicatedEndpointDns",
              "SatisfiesPzs",
              "SatisfiesPzi",
            });
    internal_static_google_cloud_vertexai_v1_Endpoint_TrafficSplitEntry_descriptor =
        internal_static_google_cloud_vertexai_v1_Endpoint_descriptor.getNestedTypes().get(0);
    internal_static_google_cloud_vertexai_v1_Endpoint_TrafficSplitEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_vertexai_v1_Endpoint_TrafficSplitEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_vertexai_v1_Endpoint_LabelsEntry_descriptor =
        internal_static_google_cloud_vertexai_v1_Endpoint_descriptor.getNestedTypes().get(1);
    internal_static_google_cloud_vertexai_v1_Endpoint_LabelsEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_vertexai_v1_Endpoint_LabelsEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_cloud_vertexai_v1_DeployedModel_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_vertexai_v1_DeployedModel_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_vertexai_v1_DeployedModel_descriptor,
            new java.lang.String[] {
              "DedicatedResources",
              "AutomaticResources",
              "SharedResources",
              "Id",
              "Model",
              "ModelVersionId",
              "DisplayName",
              "CreateTime",
              "ExplanationSpec",
              "DisableExplanations",
              "ServiceAccount",
              "DisableContainerLogging",
              "EnableAccessLogging",
              "PrivateEndpoints",
              "PredictionResources",
            });
    internal_static_google_cloud_vertexai_v1_PrivateEndpoints_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_vertexai_v1_PrivateEndpoints_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_vertexai_v1_PrivateEndpoints_descriptor,
            new java.lang.String[] {
              "PredictHttpUri", "ExplainHttpUri", "HealthHttpUri", "ServiceAttachment",
            });
    internal_static_google_cloud_vertexai_v1_PredictRequestResponseLoggingConfig_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_vertexai_v1_PredictRequestResponseLoggingConfig_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_vertexai_v1_PredictRequestResponseLoggingConfig_descriptor,
            new java.lang.String[] {
              "Enabled", "SamplingRate", "BigqueryDestination",
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
    com.google.cloud.vertexai.api.EncryptionSpecProto.getDescriptor();
    com.google.cloud.vertexai.api.ExplanationProto.getDescriptor();
    com.google.cloud.vertexai.api.IoProto.getDescriptor();
    com.google.cloud.vertexai.api.MachineResourcesProto.getDescriptor();
    com.google.cloud.vertexai.api.ServiceNetworkingProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

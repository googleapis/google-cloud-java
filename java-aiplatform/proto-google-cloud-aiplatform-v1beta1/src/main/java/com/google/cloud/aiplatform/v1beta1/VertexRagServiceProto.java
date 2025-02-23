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
// source: google/cloud/aiplatform/v1beta1/vertex_rag_service.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.aiplatform.v1beta1;

public final class VertexRagServiceProto {
  private VertexRagServiceProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RagQuery_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RagQuery_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RagQuery_Ranking_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RagQuery_Ranking_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_RagResource_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_RagResource_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RagContexts_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RagContexts_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RagContexts_Context_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RagContexts_Context_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_Model_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_Model_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_Parameters_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_Parameters_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_Fact_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_Fact_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_aiplatform_v1beta1_Claim_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_aiplatform_v1beta1_Claim_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n8google/cloud/aiplatform/v1beta1/vertex"
          + "_rag_service.proto\022\037google.cloud.aiplatf"
          + "orm.v1beta1\032\034google/api/annotations.prot"
          + "o\032\027google/api/client.proto\032\037google/api/f"
          + "ield_behavior.proto\032\031google/api/resource"
          + ".proto\032-google/cloud/aiplatform/v1beta1/"
          + "content.proto\032*google/cloud/aiplatform/v"
          + "1beta1/tool.proto\"\232\002\n\010RagQuery\022\023\n\004text\030\001"
          + " \001(\tB\003\340A\001H\000\022\037\n\020similarity_top_k\030\002 \001(\005B\005\030"
          + "\001\340A\001\022I\n\007ranking\030\004 \001(\01321.google.cloud.aip"
          + "latform.v1beta1.RagQuery.RankingB\005\030\001\340A\001\022"
          + "V\n\024rag_retrieval_config\030\006 \001(\01323.google.c"
          + "loud.aiplatform.v1beta1.RagRetrievalConf"
          + "igB\003\340A\001\032,\n\007Ranking\022\027\n\005alpha\030\001 \001(\002B\003\340A\001H\000"
          + "\210\001\001B\010\n\006_alphaB\007\n\005query\"\337\004\n\027RetrieveConte"
          + "xtsRequest\022c\n\020vertex_rag_store\030\002 \001(\0132G.g"
          + "oogle.cloud.aiplatform.v1beta1.RetrieveC"
          + "ontextsRequest.VertexRagStoreH\000\0229\n\006paren"
          + "t\030\001 \001(\tB)\340A\002\372A#\n!locations.googleapis.co"
          + "m/Location\022=\n\005query\030\003 \001(\0132).google.cloud"
          + ".aiplatform.v1beta1.RagQueryB\003\340A\002\032\325\002\n\016Ve"
          + "rtexRagStore\022\032\n\013rag_corpora\030\001 \003(\tB\005\030\001\340A\001"
          + "\022o\n\rrag_resources\030\003 \003(\0132S.google.cloud.a"
          + "iplatform.v1beta1.RetrieveContextsReques"
          + "t.VertexRagStore.RagResourceB\003\340A\001\022-\n\031vec"
          + "tor_distance_threshold\030\002 \001(\001B\005\030\001\340A\001H\000\210\001\001"
          + "\032i\n\013RagResource\022?\n\nrag_corpus\030\001 \001(\tB+\340A\001"
          + "\372A%\n#aiplatform.googleapis.com/RagCorpus"
          + "\022\031\n\014rag_file_ids\030\002 \003(\tB\003\340A\001B\034\n\032_vector_d"
          + "istance_thresholdB\r\n\013data_source\"\361\001\n\013Rag"
          + "Contexts\022F\n\010contexts\030\001 \003(\01324.google.clou"
          + "d.aiplatform.v1beta1.RagContexts.Context"
          + "\032\231\001\n\007Context\022\022\n\nsource_uri\030\001 \001(\t\022\033\n\023sour"
          + "ce_display_name\030\005 \001(\t\022\014\n\004text\030\002 \001(\t\022\024\n\010d"
          + "istance\030\003 \001(\001B\002\030\001\022\033\n\017sparse_distance\030\004 \001"
          + "(\001B\002\030\001\022\022\n\005score\030\006 \001(\001H\000\210\001\001B\010\n\006_score\"Z\n\030"
          + "RetrieveContextsResponse\022>\n\010contexts\030\001 \001"
          + "(\0132,.google.cloud.aiplatform.v1beta1.Rag"
          + "Contexts\"\375\002\n\024AugmentPromptRequest\022P\n\020ver"
          + "tex_rag_store\030\004 \001(\0132/.google.cloud.aipla"
          + "tform.v1beta1.VertexRagStoreB\003\340A\001H\000\0229\n\006p"
          + "arent\030\001 \001(\tB)\340A\002\372A#\n!locations.googleapi"
          + "s.com/Location\022?\n\010contents\030\002 \003(\0132(.googl"
          + "e.cloud.aiplatform.v1beta1.ContentB\003\340A\001\022"
          + "O\n\005model\030\003 \001(\0132;.google.cloud.aiplatform"
          + ".v1beta1.AugmentPromptRequest.ModelB\003\340A\001"
          + "\0327\n\005Model\022\022\n\005model\030\001 \001(\tB\003\340A\001\022\032\n\rmodel_v"
          + "ersion\030\002 \001(\tB\003\340A\001B\r\n\013data_source\"\221\001\n\025Aug"
          + "mentPromptResponse\022B\n\020augmented_prompt\030\001"
          + " \003(\0132(.google.cloud.aiplatform.v1beta1.C"
          + "ontent\0224\n\005facts\030\002 \003(\0132%.google.cloud.aip"
          + "latform.v1beta1.Fact\"\361\002\n\031CorroborateCont"
          + "entRequest\0229\n\006parent\030\001 \001(\tB)\340A\002\372A#\n!loca"
          + "tions.googleapis.com/Location\022C\n\007content"
          + "\030\002 \001(\0132(.google.cloud.aiplatform.v1beta1"
          + ".ContentB\003\340A\001H\000\210\001\001\0229\n\005facts\030\003 \003(\0132%.goog"
          + "le.cloud.aiplatform.v1beta1.FactB\003\340A\001\022^\n"
          + "\nparameters\030\004 \001(\0132E.google.cloud.aiplatf"
          + "orm.v1beta1.CorroborateContentRequest.Pa"
          + "rametersB\003\340A\001\032-\n\nParameters\022\037\n\022citation_"
          + "threshold\030\001 \001(\001B\003\340A\001B\n\n\010_content\"\216\001\n\032Cor"
          + "roborateContentResponse\022 \n\023corroboration"
          + "_score\030\001 \001(\002H\000\210\001\001\0226\n\006claims\030\002 \003(\0132&.goog"
          + "le.cloud.aiplatform.v1beta1.ClaimB\026\n\024_co"
          + "rroboration_score\"\322\001\n\004Fact\022\022\n\005query\030\001 \001("
          + "\tH\000\210\001\001\022\022\n\005title\030\002 \001(\tH\001\210\001\001\022\020\n\003uri\030\003 \001(\tH"
          + "\002\210\001\001\022\024\n\007summary\030\004 \001(\tH\003\210\001\001\022 \n\017vector_dis"
          + "tance\030\005 \001(\001B\002\030\001H\004\210\001\001\022\022\n\005score\030\006 \001(\001H\005\210\001\001"
          + "B\010\n\006_queryB\010\n\006_titleB\006\n\004_uriB\n\n\010_summary"
          + "B\022\n\020_vector_distanceB\010\n\006_score\"\213\001\n\005Claim"
          + "\022\030\n\013start_index\030\001 \001(\005H\000\210\001\001\022\026\n\tend_index\030"
          + "\002 \001(\005H\001\210\001\001\022\024\n\014fact_indexes\030\003 \003(\005\022\022\n\005scor"
          + "e\030\004 \001(\002H\002\210\001\001B\016\n\014_start_indexB\014\n\n_end_ind"
          + "exB\010\n\006_score2\223\006\n\020VertexRagService\022\334\001\n\020Re"
          + "trieveContexts\0228.google.cloud.aiplatform"
          + ".v1beta1.RetrieveContextsRequest\0329.googl"
          + "e.cloud.aiplatform.v1beta1.RetrieveConte"
          + "xtsResponse\"S\332A\014parent,query\202\323\344\223\002>\"9/v1b"
          + "eta1/{parent=projects/*/locations/*}:ret"
          + "rieveContexts:\001*\022\341\001\n\rAugmentPrompt\0225.goo"
          + "gle.cloud.aiplatform.v1beta1.AugmentProm"
          + "ptRequest\0326.google.cloud.aiplatform.v1be"
          + "ta1.AugmentPromptResponse\"a\332A\035parent,mod"
          + "el,vertex_rag_store\202\323\344\223\002;\"6/v1beta1/{par"
          + "ent=projects/*/locations/*}:augmentPromp"
          + "t:\001*\022\354\001\n\022CorroborateContent\022:.google.clo"
          + "ud.aiplatform.v1beta1.CorroborateContent"
          + "Request\032;.google.cloud.aiplatform.v1beta"
          + "1.CorroborateContentResponse\"]\332A\024parent,"
          + "content,facts\202\323\344\223\002@\";/v1beta1/{parent=pr"
          + "ojects/*/locations/*}:corroborateContent"
          + ":\001*\032M\312A\031aiplatform.googleapis.com\322A.http"
          + "s://www.googleapis.com/auth/cloud-platfo"
          + "rmB\354\001\n#com.google.cloud.aiplatform.v1bet"
          + "a1B\025VertexRagServiceProtoP\001ZCcloud.googl"
          + "e.com/go/aiplatform/apiv1beta1/aiplatfor"
          + "mpb;aiplatformpb\252\002\037Google.Cloud.AIPlatfo"
          + "rm.V1Beta1\312\002\037Google\\Cloud\\AIPlatform\\V1b"
          + "eta1\352\002\"Google::Cloud::AIPlatform::V1beta"
          + "1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.ContentProto.getDescriptor(),
              com.google.cloud.aiplatform.v1beta1.ToolProto.getDescriptor(),
            });
    internal_static_google_cloud_aiplatform_v1beta1_RagQuery_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_aiplatform_v1beta1_RagQuery_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RagQuery_descriptor,
            new java.lang.String[] {
              "Text", "SimilarityTopK", "Ranking", "RagRetrievalConfig", "Query",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RagQuery_Ranking_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_RagQuery_descriptor.getNestedTypes().get(0);
    internal_static_google_cloud_aiplatform_v1beta1_RagQuery_Ranking_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RagQuery_Ranking_descriptor,
            new java.lang.String[] {
              "Alpha",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_descriptor,
            new java.lang.String[] {
              "VertexRagStore", "Parent", "Query", "DataSource",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_descriptor,
            new java.lang.String[] {
              "RagCorpora", "RagResources", "VectorDistanceThreshold",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_RagResource_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_RagResource_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsRequest_VertexRagStore_RagResource_descriptor,
            new java.lang.String[] {
              "RagCorpus", "RagFileIds",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RagContexts_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_aiplatform_v1beta1_RagContexts_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RagContexts_descriptor,
            new java.lang.String[] {
              "Contexts",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RagContexts_Context_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_RagContexts_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_RagContexts_Context_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RagContexts_Context_descriptor,
            new java.lang.String[] {
              "SourceUri", "SourceDisplayName", "Text", "Distance", "SparseDistance", "Score",
            });
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsResponse_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_RetrieveContextsResponse_descriptor,
            new java.lang.String[] {
              "Contexts",
            });
    internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_descriptor,
            new java.lang.String[] {
              "VertexRagStore", "Parent", "Contents", "Model", "DataSource",
            });
    internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_Model_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_Model_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptRequest_Model_descriptor,
            new java.lang.String[] {
              "Model", "ModelVersion",
            });
    internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptResponse_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_AugmentPromptResponse_descriptor,
            new java.lang.String[] {
              "AugmentedPrompt", "Facts",
            });
    internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_descriptor,
            new java.lang.String[] {
              "Parent", "Content", "Facts", "Parameters",
            });
    internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_Parameters_descriptor =
        internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_Parameters_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentRequest_Parameters_descriptor,
            new java.lang.String[] {
              "CitationThreshold",
            });
    internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentResponse_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_CorroborateContentResponse_descriptor,
            new java.lang.String[] {
              "CorroborationScore", "Claims",
            });
    internal_static_google_cloud_aiplatform_v1beta1_Fact_descriptor =
        getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_aiplatform_v1beta1_Fact_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_Fact_descriptor,
            new java.lang.String[] {
              "Query", "Title", "Uri", "Summary", "VectorDistance", "Score",
            });
    internal_static_google_cloud_aiplatform_v1beta1_Claim_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_aiplatform_v1beta1_Claim_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_aiplatform_v1beta1_Claim_descriptor,
            new java.lang.String[] {
              "StartIndex", "EndIndex", "FactIndexes", "Score",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resourceReference);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.ContentProto.getDescriptor();
    com.google.cloud.aiplatform.v1beta1.ToolProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

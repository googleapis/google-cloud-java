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
// source: google/cloud/dialogflow/cx/v3beta1/agent.proto

// Protobuf Java Version: 3.25.5
package com.google.cloud.dialogflow.cx.v3beta1;

public final class AgentProto {
  private AgentProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_SpeechToTextSettings_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_SpeechToTextSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_GithubSettings_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_GithubSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GenAppBuilderSettings_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GenAppBuilderSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_AnswerFeedbackSettings_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_AnswerFeedbackSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_PersonalizationSettings_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_PersonalizationSettings_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_CreateAgentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_CreateAgentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateAgentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateAgentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_DeleteAgentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_DeleteAgentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_GitDestination_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_GitDestination_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_GitSource_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_GitSource_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_ValidateAgentRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_ValidateAgentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentValidationResultRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentValidationResultRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_AgentValidationResult_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_AgentValidationResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_GetGenerativeSettingsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_GetGenerativeSettingsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateGenerativeSettingsRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateGenerativeSettingsRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n.google/cloud/dialogflow/cx/v3beta1/age"
          + "nt.proto\022\"google.cloud.dialogflow.cx.v3b"
          + "eta1\032\034google/api/annotations.proto\032\027goog"
          + "le/api/client.proto\032\037google/api/field_be"
          + "havior.proto\032\031google/api/resource.proto\032"
          + ":google/cloud/dialogflow/cx/v3beta1/adva"
          + "nced_settings.proto\0325google/cloud/dialog"
          + "flow/cx/v3beta1/audio_config.proto\032-goog"
          + "le/cloud/dialogflow/cx/v3beta1/flow.prot"
          + "o\032<google/cloud/dialogflow/cx/v3beta1/ge"
          + "nerative_settings.proto\032#google/longrunn"
          + "ing/operations.proto\032\033google/protobuf/em"
          + "pty.proto\032 google/protobuf/field_mask.pr"
          + "oto\032\034google/protobuf/struct.proto\"8\n\024Spe"
          + "echToTextSettings\022 \n\030enable_speech_adapt"
          + "ation\030\001 \001(\010\"\246\016\n\005Agent\022\014\n\004name\030\001 \001(\t\022\031\n\014d"
          + "isplay_name\030\002 \001(\tB\003\340A\002\022%\n\025default_langua"
          + "ge_code\030\003 \001(\tB\006\340A\002\340A\005\022 \n\030supported_langu"
          + "age_codes\030\004 \003(\t\022\026\n\ttime_zone\030\005 \001(\tB\003\340A\002\022"
          + "\023\n\013description\030\006 \001(\t\022\022\n\navatar_uri\030\007 \001(\t"
          + "\022Y\n\027speech_to_text_settings\030\r \001(\01328.goog"
          + "le.cloud.dialogflow.cx.v3beta1.SpeechToT"
          + "extSettings\0229\n\nstart_flow\030\020 \001(\tB#\372A \n\036di"
          + "alogflow.googleapis.com/FlowH\000\022A\n\016start_"
          + "playbook\030\' \001(\tB\'\372A$\n\"dialogflow.googleap"
          + "is.com/PlaybookH\000\022J\n\021security_settings\030\021"
          + " \001(\tB/\372A,\n*dialogflow.googleapis.com/Sec"
          + "uritySettings\022&\n\032enable_stackdriver_logg"
          + "ing\030\022 \001(\010B\002\030\001\022\037\n\027enable_spell_correction"
          + "\030\024 \001(\010\022+\n\036enable_multi_language_training"
          + "\030( \001(\010B\003\340A\001\022\016\n\006locked\030\033 \001(\010\022O\n\021advanced_"
          + "settings\030\026 \001(\01324.google.cloud.dialogflow"
          + ".cx.v3beta1.AdvancedSettings\022b\n\030git_inte"
          + "gration_settings\030\036 \001(\0132@.google.cloud.di"
          + "alogflow.cx.v3beta1.Agent.GitIntegration"
          + "Settings\022Y\n\027text_to_speech_settings\030\037 \001("
          + "\01328.google.cloud.dialogflow.cx.v3beta1.T"
          + "extToSpeechSettings\022f\n\030gen_app_builder_s"
          + "ettings\030! \001(\0132?.google.cloud.dialogflow."
          + "cx.v3beta1.Agent.GenAppBuilderSettingsH\001"
          + "\210\001\001\022g\n\030answer_feedback_settings\030& \001(\0132@."
          + "google.cloud.dialogflow.cx.v3beta1.Agent"
          + ".AnswerFeedbackSettingsB\003\340A\001\022h\n\030personal"
          + "ization_settings\030* \001(\0132A.google.cloud.di"
          + "alogflow.cx.v3beta1.Agent.Personalizatio"
          + "nSettingsB\003\340A\001\032\225\002\n\026GitIntegrationSetting"
          + "s\022j\n\017github_settings\030\001 \001(\0132O.google.clou"
          + "d.dialogflow.cx.v3beta1.Agent.GitIntegra"
          + "tionSettings.GithubSettingsH\000\032\177\n\016GithubS"
          + "ettings\022\024\n\014display_name\030\001 \001(\t\022\026\n\016reposit"
          + "ory_uri\030\002 \001(\t\022\027\n\017tracking_branch\030\003 \001(\t\022\024"
          + "\n\014access_token\030\004 \001(\t\022\020\n\010branches\030\005 \003(\tB\016"
          + "\n\014git_settings\032,\n\025GenAppBuilderSettings\022"
          + "\023\n\006engine\030\001 \001(\tB\003\340A\002\032=\n\026AnswerFeedbackSe"
          + "ttings\022#\n\026enable_answer_feedback\030\001 \001(\010B\003"
          + "\340A\001\032Z\n\027PersonalizationSettings\022?\n\031defaul"
          + "t_end_user_metadata\030\001 \001(\0132\027.google.proto"
          + "buf.StructB\003\340A\001:\\\352AY\n\037dialogflow.googlea"
          + "pis.com/Agent\0226projects/{project}/locati"
          + "ons/{location}/agents/{agent}B\030\n\026session"
          + "_entry_resourceB\033\n\031_gen_app_builder_sett"
          + "ings\"s\n\021ListAgentsRequest\0227\n\006parent\030\001 \001("
          + "\tB\'\340A\002\372A!\022\037dialogflow.googleapis.com/Age"
          + "nt\022\021\n\tpage_size\030\002 \001(\005\022\022\n\npage_token\030\003 \001("
          + "\t\"h\n\022ListAgentsResponse\0229\n\006agents\030\001 \003(\0132"
          + ").google.cloud.dialogflow.cx.v3beta1.Age"
          + "nt\022\027\n\017next_page_token\030\002 \001(\t\"H\n\017GetAgentR"
          + "equest\0225\n\004name\030\001 \001(\tB\'\340A\002\372A!\n\037dialogflow"
          + ".googleapis.com/Agent\"\214\001\n\022CreateAgentReq"
          + "uest\0227\n\006parent\030\001 \001(\tB\'\340A\002\372A!\022\037dialogflow"
          + ".googleapis.com/Agent\022=\n\005agent\030\002 \001(\0132).g"
          + "oogle.cloud.dialogflow.cx.v3beta1.AgentB"
          + "\003\340A\002\"\204\001\n\022UpdateAgentRequest\022=\n\005agent\030\001 \001"
          + "(\0132).google.cloud.dialogflow.cx.v3beta1."
          + "AgentB\003\340A\002\022/\n\013update_mask\030\002 \001(\0132\032.google"
          + ".protobuf.FieldMask\"K\n\022DeleteAgentReques"
          + "t\0225\n\004name\030\001 \001(\tB\'\340A\002\372A!\n\037dialogflow.goog"
          + "leapis.com/Agent\"\242\004\n\022ExportAgentRequest\022"
          + "5\n\004name\030\001 \001(\tB\'\340A\002\372A!\n\037dialogflow.google"
          + "apis.com/Agent\022\026\n\tagent_uri\030\002 \001(\tB\003\340A\001\022["
          + "\n\013data_format\030\003 \001(\0162A.google.cloud.dialo"
          + "gflow.cx.v3beta1.ExportAgentRequest.Data"
          + "FormatB\003\340A\001\022B\n\013environment\030\005 \001(\tB-\340A\001\372A\'"
          + "\n%dialogflow.googleapis.com/Environment\022"
          + "c\n\017git_destination\030\006 \001(\0132E.google.cloud."
          + "dialogflow.cx.v3beta1.ExportAgentRequest"
          + ".GitDestinationB\003\340A\001\022-\n include_bigquery"
          + "_export_settings\030\007 \001(\010B\003\340A\001\032A\n\016GitDestin"
          + "ation\022\027\n\017tracking_branch\030\001 \001(\t\022\026\n\016commit"
          + "_message\030\002 \001(\t\"E\n\nDataFormat\022\033\n\027DATA_FOR"
          + "MAT_UNSPECIFIED\020\000\022\010\n\004BLOB\020\001\022\020\n\014JSON_PACK"
          + "AGE\020\004\"b\n\023ExportAgentResponse\022\023\n\tagent_ur"
          + "i\030\001 \001(\tH\000\022\027\n\ragent_content\030\002 \001(\014H\000\022\024\n\nco"
          + "mmit_sha\030\003 \001(\tH\000B\007\n\005agent\"\252\003\n\023RestoreAge"
          + "ntRequest\0225\n\004name\030\001 \001(\tB\'\340A\002\372A!\n\037dialogf"
          + "low.googleapis.com/Agent\022\023\n\tagent_uri\030\002 "
          + "\001(\tH\000\022\027\n\ragent_content\030\003 \001(\014H\000\022W\n\ngit_so"
          + "urce\030\006 \001(\0132A.google.cloud.dialogflow.cx."
          + "v3beta1.RestoreAgentRequest.GitSourceH\000\022"
          + "]\n\016restore_option\030\005 \001(\0162E.google.cloud.d"
          + "ialogflow.cx.v3beta1.RestoreAgentRequest"
          + ".RestoreOption\032$\n\tGitSource\022\027\n\017tracking_"
          + "branch\030\001 \001(\t\"G\n\rRestoreOption\022\036\n\032RESTORE"
          + "_OPTION_UNSPECIFIED\020\000\022\010\n\004KEEP\020\001\022\014\n\010FALLB"
          + "ACK\020\002B\007\n\005agent\"d\n\024ValidateAgentRequest\0225"
          + "\n\004name\030\001 \001(\tB\'\340A\002\372A!\n\037dialogflow.googlea"
          + "pis.com/Agent\022\025\n\rlanguage_code\030\002 \001(\t\"\177\n\037"
          + "GetAgentValidationResultRequest\022E\n\004name\030"
          + "\001 \001(\tB7\340A\002\372A1\n/dialogflow.googleapis.com"
          + "/AgentValidationResult\022\025\n\rlanguage_code\030"
          + "\002 \001(\t\"\377\001\n\025AgentValidationResult\022\014\n\004name\030"
          + "\001 \001(\t\022Y\n\027flow_validation_results\030\002 \003(\01328"
          + ".google.cloud.dialogflow.cx.v3beta1.Flow"
          + "ValidationResult:}\352Az\n/dialogflow.google"
          + "apis.com/AgentValidationResult\022Gprojects"
          + "/{project}/locations/{location}/agents/{"
          + "agent}/validationResult\"\203\001\n\034GetGenerativ"
          + "eSettingsRequest\022G\n\004name\030\001 \001(\tB9\340A\002\372A3\n1"
          + "dialogflow.googleapis.com/AgentGenerativ"
          + "eSettings\022\032\n\rlanguage_code\030\002 \001(\tB\003\340A\002\"\261\001"
          + "\n\037UpdateGenerativeSettingsRequest\022X\n\023gen"
          + "erative_settings\030\001 \001(\01326.google.cloud.di"
          + "alogflow.cx.v3beta1.GenerativeSettingsB\003"
          + "\340A\002\0224\n\013update_mask\030\002 \001(\0132\032.google.protob"
          + "uf.FieldMaskB\003\340A\0012\270\023\n\006Agents\022\275\001\n\nListAge"
          + "nts\0225.google.cloud.dialogflow.cx.v3beta1"
          + ".ListAgentsRequest\0326.google.cloud.dialog"
          + "flow.cx.v3beta1.ListAgentsResponse\"@\332A\006p"
          + "arent\202\323\344\223\0021\022//v3beta1/{parent=projects/*"
          + "/locations/*}/agents\022\252\001\n\010GetAgent\0223.goog"
          + "le.cloud.dialogflow.cx.v3beta1.GetAgentR"
          + "equest\032).google.cloud.dialogflow.cx.v3be"
          + "ta1.Agent\">\332A\004name\202\323\344\223\0021\022//v3beta1/{name"
          + "=projects/*/locations/*/agents/*}\022\277\001\n\013Cr"
          + "eateAgent\0226.google.cloud.dialogflow.cx.v"
          + "3beta1.CreateAgentRequest\032).google.cloud"
          + ".dialogflow.cx.v3beta1.Agent\"M\332A\014parent,"
          + "agent\202\323\344\223\0028\"//v3beta1/{parent=projects/*"
          + "/locations/*}/agents:\005agent\022\312\001\n\013UpdateAg"
          + "ent\0226.google.cloud.dialogflow.cx.v3beta1"
          + ".UpdateAgentRequest\032).google.cloud.dialo"
          + "gflow.cx.v3beta1.Agent\"X\332A\021agent,update_"
          + "mask\202\323\344\223\002>25/v3beta1/{agent.name=project"
          + "s/*/locations/*/agents/*}:\005agent\022\235\001\n\013Del"
          + "eteAgent\0226.google.cloud.dialogflow.cx.v3"
          + "beta1.DeleteAgentRequest\032\026.google.protob"
          + "uf.Empty\">\332A\004name\202\323\344\223\0021*//v3beta1/{name="
          + "projects/*/locations/*/agents/*}\022\327\001\n\013Exp"
          + "ortAgent\0226.google.cloud.dialogflow.cx.v3"
          + "beta1.ExportAgentRequest\032\035.google.longru"
          + "nning.Operation\"q\312A-\n\023ExportAgentRespons"
          + "e\022\026google.protobuf.Struct\202\323\344\223\002;\"6/v3beta"
          + "1/{name=projects/*/locations/*/agents/*}"
          + ":export:\001*\022\334\001\n\014RestoreAgent\0227.google.clo"
          + "ud.dialogflow.cx.v3beta1.RestoreAgentReq"
          + "uest\032\035.google.longrunning.Operation\"t\312A/"
          + "\n\025google.protobuf.Empty\022\026google.protobuf"
          + ".Struct\202\323\344\223\002<\"7/v3beta1/{name=projects/*"
          + "/locations/*/agents/*}:restore:\001*\022\311\001\n\rVa"
          + "lidateAgent\0228.google.cloud.dialogflow.cx"
          + ".v3beta1.ValidateAgentRequest\0329.google.c"
          + "loud.dialogflow.cx.v3beta1.AgentValidati"
          + "onResult\"C\202\323\344\223\002=\"8/v3beta1/{name=project"
          + "s/*/locations/*/agents/*}:validate:\001*\022\353\001"
          + "\n\030GetAgentValidationResult\022C.google.clou"
          + "d.dialogflow.cx.v3beta1.GetAgentValidati"
          + "onResultRequest\0329.google.cloud.dialogflo"
          + "w.cx.v3beta1.AgentValidationResult\"O\332A\004n"
          + "ame\202\323\344\223\002B\022@/v3beta1/{name=projects/*/loc"
          + "ations/*/agents/*/validationResult}\022\362\001\n\025"
          + "GetGenerativeSettings\022@.google.cloud.dia"
          + "logflow.cx.v3beta1.GetGenerativeSettings"
          + "Request\0326.google.cloud.dialogflow.cx.v3b"
          + "eta1.GenerativeSettings\"_\332A\022name,languag"
          + "e_code\202\323\344\223\002D\022B/v3beta1/{name=projects/*/"
          + "locations/*/agents/*/generativeSettings}"
          + "\022\257\002\n\030UpdateGenerativeSettings\022C.google.c"
          + "loud.dialogflow.cx.v3beta1.UpdateGenerat"
          + "iveSettingsRequest\0326.google.cloud.dialog"
          + "flow.cx.v3beta1.GenerativeSettings\"\225\001\332A\037"
          + "generative_settings,update_mask\202\323\344\223\002m2V/"
          + "v3beta1/{generative_settings.name=projec"
          + "ts/*/locations/*/agents/*/generativeSett"
          + "ings}:\023generative_settings\032x\312A\031dialogflo"
          + "w.googleapis.com\322AYhttps://www.googleapi"
          + "s.com/auth/cloud-platform,https://www.go"
          + "ogleapis.com/auth/dialogflowB\304\001\n&com.goo"
          + "gle.cloud.dialogflow.cx.v3beta1B\nAgentPr"
          + "otoP\001Z6cloud.google.com/go/dialogflow/cx"
          + "/apiv3beta1/cxpb;cxpb\370\001\001\242\002\002DF\252\002\"Google.C"
          + "loud.Dialogflow.Cx.V3Beta1\352\002&Google::Clo"
          + "ud::Dialogflow::CX::V3beta1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.api.ClientProto.getDescriptor(),
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.api.ResourceProto.getDescriptor(),
              com.google.cloud.dialogflow.cx.v3beta1.AdvancedSettingsProto.getDescriptor(),
              com.google.cloud.dialogflow.cx.v3beta1.AudioConfigProto.getDescriptor(),
              com.google.cloud.dialogflow.cx.v3beta1.FlowProto.getDescriptor(),
              com.google.cloud.dialogflow.cx.v3beta1.GenerativeSettingsProto.getDescriptor(),
              com.google.longrunning.OperationsProto.getDescriptor(),
              com.google.protobuf.EmptyProto.getDescriptor(),
              com.google.protobuf.FieldMaskProto.getDescriptor(),
              com.google.protobuf.StructProto.getDescriptor(),
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_SpeechToTextSettings_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_dialogflow_cx_v3beta1_SpeechToTextSettings_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_SpeechToTextSettings_descriptor,
            new java.lang.String[] {
              "EnableSpeechAdaptation",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_descriptor,
            new java.lang.String[] {
              "Name",
              "DisplayName",
              "DefaultLanguageCode",
              "SupportedLanguageCodes",
              "TimeZone",
              "Description",
              "AvatarUri",
              "SpeechToTextSettings",
              "StartFlow",
              "StartPlaybook",
              "SecuritySettings",
              "EnableStackdriverLogging",
              "EnableSpellCorrection",
              "EnableMultiLanguageTraining",
              "Locked",
              "AdvancedSettings",
              "GitIntegrationSettings",
              "TextToSpeechSettings",
              "GenAppBuilderSettings",
              "AnswerFeedbackSettings",
              "PersonalizationSettings",
              "SessionEntryResource",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_descriptor =
        internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_descriptor.getNestedTypes().get(0);
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_descriptor,
            new java.lang.String[] {
              "GithubSettings", "GitSettings",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_GithubSettings_descriptor =
        internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_GithubSettings_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GitIntegrationSettings_GithubSettings_descriptor,
            new java.lang.String[] {
              "DisplayName", "RepositoryUri", "TrackingBranch", "AccessToken", "Branches",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GenAppBuilderSettings_descriptor =
        internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_descriptor.getNestedTypes().get(1);
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GenAppBuilderSettings_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_GenAppBuilderSettings_descriptor,
            new java.lang.String[] {
              "Engine",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_AnswerFeedbackSettings_descriptor =
        internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_descriptor.getNestedTypes().get(2);
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_AnswerFeedbackSettings_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_AnswerFeedbackSettings_descriptor,
            new java.lang.String[] {
              "EnableAnswerFeedback",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_PersonalizationSettings_descriptor =
        internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_descriptor.getNestedTypes().get(3);
    internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_PersonalizationSettings_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_Agent_PersonalizationSettings_descriptor,
            new java.lang.String[] {
              "DefaultEndUserMetadata",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsRequest_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsRequest_descriptor,
            new java.lang.String[] {
              "Parent", "PageSize", "PageToken",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsResponse_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_ListAgentsResponse_descriptor,
            new java.lang.String[] {
              "Agents", "NextPageToken",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentRequest_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_CreateAgentRequest_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_cloud_dialogflow_cx_v3beta1_CreateAgentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_CreateAgentRequest_descriptor,
            new java.lang.String[] {
              "Parent", "Agent",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateAgentRequest_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateAgentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateAgentRequest_descriptor,
            new java.lang.String[] {
              "Agent", "UpdateMask",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_DeleteAgentRequest_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_cloud_dialogflow_cx_v3beta1_DeleteAgentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_DeleteAgentRequest_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_descriptor =
        getDescriptor().getMessageTypes().get(8);
    internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_descriptor,
            new java.lang.String[] {
              "Name",
              "AgentUri",
              "DataFormat",
              "Environment",
              "GitDestination",
              "IncludeBigqueryExportSettings",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_GitDestination_descriptor =
        internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_GitDestination_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentRequest_GitDestination_descriptor,
            new java.lang.String[] {
              "TrackingBranch", "CommitMessage",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentResponse_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentResponse_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_ExportAgentResponse_descriptor,
            new java.lang.String[] {
              "AgentUri", "AgentContent", "CommitSha", "Agent",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_descriptor =
        getDescriptor().getMessageTypes().get(10);
    internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_descriptor,
            new java.lang.String[] {
              "Name", "AgentUri", "AgentContent", "GitSource", "RestoreOption", "Agent",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_GitSource_descriptor =
        internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_GitSource_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_RestoreAgentRequest_GitSource_descriptor,
            new java.lang.String[] {
              "TrackingBranch",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_ValidateAgentRequest_descriptor =
        getDescriptor().getMessageTypes().get(11);
    internal_static_google_cloud_dialogflow_cx_v3beta1_ValidateAgentRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_ValidateAgentRequest_descriptor,
            new java.lang.String[] {
              "Name", "LanguageCode",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentValidationResultRequest_descriptor =
        getDescriptor().getMessageTypes().get(12);
    internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentValidationResultRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_GetAgentValidationResultRequest_descriptor,
            new java.lang.String[] {
              "Name", "LanguageCode",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_AgentValidationResult_descriptor =
        getDescriptor().getMessageTypes().get(13);
    internal_static_google_cloud_dialogflow_cx_v3beta1_AgentValidationResult_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_AgentValidationResult_descriptor,
            new java.lang.String[] {
              "Name", "FlowValidationResults",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_GetGenerativeSettingsRequest_descriptor =
        getDescriptor().getMessageTypes().get(14);
    internal_static_google_cloud_dialogflow_cx_v3beta1_GetGenerativeSettingsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_GetGenerativeSettingsRequest_descriptor,
            new java.lang.String[] {
              "Name", "LanguageCode",
            });
    internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateGenerativeSettingsRequest_descriptor =
        getDescriptor().getMessageTypes().get(15);
    internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateGenerativeSettingsRequest_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_dialogflow_cx_v3beta1_UpdateGenerativeSettingsRequest_descriptor,
            new java.lang.String[] {
              "GenerativeSettings", "UpdateMask",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.api.ResourceProto.resource);
    registry.add(com.google.api.ResourceProto.resourceReference);
    registry.add(com.google.longrunning.OperationsProto.operationInfo);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.api.ResourceProto.getDescriptor();
    com.google.cloud.dialogflow.cx.v3beta1.AdvancedSettingsProto.getDescriptor();
    com.google.cloud.dialogflow.cx.v3beta1.AudioConfigProto.getDescriptor();
    com.google.cloud.dialogflow.cx.v3beta1.FlowProto.getDescriptor();
    com.google.cloud.dialogflow.cx.v3beta1.GenerativeSettingsProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.FieldMaskProto.getDescriptor();
    com.google.protobuf.StructProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}

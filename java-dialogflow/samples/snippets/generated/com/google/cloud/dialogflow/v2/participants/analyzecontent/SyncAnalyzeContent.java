/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.dialogflow.v2.samples;

// [START dialogflow_v2_generated_Participants_AnalyzeContent_sync]
import com.google.cloud.dialogflow.v2.AnalyzeContentRequest;
import com.google.cloud.dialogflow.v2.AnalyzeContentResponse;
import com.google.cloud.dialogflow.v2.AssistQueryParameters;
import com.google.cloud.dialogflow.v2.OutputAudioConfig;
import com.google.cloud.dialogflow.v2.ParticipantName;
import com.google.cloud.dialogflow.v2.ParticipantsClient;
import com.google.cloud.dialogflow.v2.QueryParameters;
import com.google.protobuf.Struct;

public class SyncAnalyzeContent {

  public static void main(String[] args) throws Exception {
    syncAnalyzeContent();
  }

  public static void syncAnalyzeContent() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ParticipantsClient participantsClient = ParticipantsClient.create()) {
      AnalyzeContentRequest request =
          AnalyzeContentRequest.newBuilder()
              .setParticipant(
                  ParticipantName.ofProjectConversationParticipantName(
                          "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                      .toString())
              .setReplyAudioConfig(OutputAudioConfig.newBuilder().build())
              .setQueryParams(QueryParameters.newBuilder().build())
              .setAssistQueryParams(AssistQueryParameters.newBuilder().build())
              .setCxParameters(Struct.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      AnalyzeContentResponse response = participantsClient.analyzeContent(request);
    }
  }
}
// [END dialogflow_v2_generated_Participants_AnalyzeContent_sync]

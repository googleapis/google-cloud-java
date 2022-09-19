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

package com.google.cloud.dialogflow.v2beta1.samples;

// [START dialogflow_v2beta1_generated_participantsclient_analyzecontent_stringaudioinput_sync]
import com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.AudioInput;
import com.google.cloud.dialogflow.v2beta1.ParticipantName;
import com.google.cloud.dialogflow.v2beta1.ParticipantsClient;

public class SyncAnalyzeContentStringAudioinput {

  public static void main(String[] args) throws Exception {
    syncAnalyzeContentStringAudioinput();
  }

  public static void syncAnalyzeContentStringAudioinput() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ParticipantsClient participantsClient = ParticipantsClient.create()) {
      String participant =
          ParticipantName.ofProjectConversationParticipantName(
                  "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
              .toString();
      AudioInput audioInput = AudioInput.newBuilder().build();
      AnalyzeContentResponse response = participantsClient.analyzeContent(participant, audioInput);
    }
  }
}
// [END dialogflow_v2beta1_generated_participantsclient_analyzecontent_stringaudioinput_sync]

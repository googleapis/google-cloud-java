/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dialogflow.cx;

// [START dialogflow_cx_v3_detect_intent_audio_input]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.cx.v3.AudioEncoding;
import com.google.cloud.dialogflow.cx.v3.AudioInput;
import com.google.cloud.dialogflow.cx.v3.DetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3.DetectIntentResponse;
import com.google.cloud.dialogflow.cx.v3.InputAudioConfig;
import com.google.cloud.dialogflow.cx.v3.QueryInput;
import com.google.cloud.dialogflow.cx.v3.QueryResult;
import com.google.cloud.dialogflow.cx.v3.SessionName;
import com.google.cloud.dialogflow.cx.v3.SessionsClient;
import com.google.cloud.dialogflow.cx.v3.SessionsSettings;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;

public class DetectIntentAudioInput {

  // DialogFlow API Detect Intent sample with Audio input.
  public static void main(String[] args) throws IOException, ApiException {
    /** TODO (developer): replace these values with your own values */
    String projectId = "my-project-id";
    String locationId = "global";
    String agentId = "my-agent-id";
    String audioFileName = "resources/book_a_room.wav";
    int sampleRateHertz = 16000;
    /*
     * A session ID is a string of at most 36 bytes in size.
     * Your system is responsible for generating unique session IDs.
     * They can be random numbers, hashed end-user identifiers,
     * or any other values that are convenient for you to generate.
     */
    String sessionId = "my-UUID";
    String languageCode = "en";

    detectIntent(
        projectId, locationId, agentId, audioFileName, sampleRateHertz, sessionId, languageCode);
  }

  public static void detectIntent(
      String projectId,
      String locationId,
      String agentId,
      String audioFileName,
      int sampleRateHertz,
      String sessionId,
      String languageCode)
      throws IOException, ApiException {

    SessionsSettings.Builder sessionsSettingsBuilder = SessionsSettings.newBuilder();
    if (locationId.equals("global")) {
      sessionsSettingsBuilder.setEndpoint("dialogflow.googleapis.com:443");
    } else {
      sessionsSettingsBuilder.setEndpoint(locationId + "-dialogflow.googleapis.com:443");
    }
    SessionsSettings sessionsSettings = sessionsSettingsBuilder.build();

    // Instantiates a client by setting the session name.
    // Format:`projects/<ProjectID>/locations/<LocationID>/agents/<AgentID>/sessions/<SessionID>`
    try (SessionsClient sessionsClient = SessionsClient.create(sessionsSettings)) {
      SessionName session =
          SessionName.ofProjectLocationAgentSessionName(projectId, locationId, agentId, sessionId);

      // TODO : Uncomment if you want to print session path
      // System.out.println("Session Path: " + session.toString());
      InputAudioConfig inputAudioConfig =
          InputAudioConfig.newBuilder()
              .setAudioEncoding(AudioEncoding.AUDIO_ENCODING_LINEAR_16)
              .setSampleRateHertz(sampleRateHertz)
              .build();

      try (FileInputStream audioStream = new FileInputStream(audioFileName)) {
        // Subsequent requests must **only** contain the audio data.
        // Following messages: audio chunks. We just read the file in fixed-size chunks. In reality
        // you would split the user input by time.
        byte[] buffer = new byte[4096];
        int bytes = audioStream.read(buffer);
        AudioInput audioInput =
            AudioInput.newBuilder()
                .setAudio(ByteString.copyFrom(buffer, 0, bytes))
                .setConfig(inputAudioConfig)
                .build();
        QueryInput queryInput =
            QueryInput.newBuilder()
                .setAudio(audioInput)
                .setLanguageCode("en-US") // languageCode = "en-US"
                .build();

        DetectIntentRequest request =
            DetectIntentRequest.newBuilder()
                .setSession(session.toString())
                .setQueryInput(queryInput)
                .build();

        // Performs the detect intent request.
        DetectIntentResponse response = sessionsClient.detectIntent(request);

        // Display the query result.
        QueryResult queryResult = response.getQueryResult();

        System.out.println("====================");
        System.out.format(
            "Detected Intent: %s (confidence: %f)\n",
            queryResult.getTranscript(), queryResult.getIntentDetectionConfidence());
      }
    }
  }
}
// [END dialogflow_cx_v3_detect_intent_audio_input]

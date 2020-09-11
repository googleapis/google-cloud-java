/*
 * Copyright 2020 Google LLC
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

// [START dialogflow_cx_detect_intent_streaming]

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.dialogflow.cx.v3beta1.AudioEncoding;
import com.google.cloud.dialogflow.cx.v3beta1.AudioInput;
import com.google.cloud.dialogflow.cx.v3beta1.InputAudioConfig;
import com.google.cloud.dialogflow.cx.v3beta1.QueryInput;
import com.google.cloud.dialogflow.cx.v3beta1.QueryResult;
import com.google.cloud.dialogflow.cx.v3beta1.SessionName;
import com.google.cloud.dialogflow.cx.v3beta1.SessionsClient;
import com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;

public class DetectIntentStream {

  // DialogFlow API Detect Intent sample with audio files processes as an audio stream.
  public static void detectIntentStream(
      String projectId, String locationId, String agentId, String sessionId, String audioFilePath)
      throws ApiException, IOException {
    // Instantiates a client
    try (SessionsClient sessionsClient = SessionsClient.create()) {
      // Set the session name using the projectID (my-project-id), locationID (global), agentID
      // (UUID), and sessionId (UUID).
      // Using the same `sessionId` between requests allows continuation of the conversation.
      SessionName session = SessionName.of(projectId, locationId, agentId, sessionId);

      // Instructs the speech recognizer how to process the audio content.
      // Note: hard coding audioEncoding and sampleRateHertz for simplicity.
      // Audio encoding of the audio content sent in the query request.
      InputAudioConfig inputAudioConfig =
          InputAudioConfig.newBuilder()
              .setAudioEncoding(AudioEncoding.AUDIO_ENCODING_LINEAR_16)
              .setSampleRateHertz(16000) // sampleRateHertz = 16000
              .build();

      // Build the AudioInput with the InputAudioConfig.
      AudioInput audioInput = AudioInput.newBuilder().setConfig(inputAudioConfig).build();

      // Build the query with the InputAudioConfig.
      QueryInput queryInput =
          QueryInput.newBuilder()
              .setAudio(audioInput)
              .setLanguageCode("en-US") // languageCode = "en-US"
              .build();

      // Create the Bidirectional stream
      BidiStream<StreamingDetectIntentRequest, StreamingDetectIntentResponse> bidiStream =
          sessionsClient.streamingDetectIntentCallable().call();

      // The first request must **only** contain the audio configuration:
      bidiStream.send(
          StreamingDetectIntentRequest.newBuilder()
              .setSession(session.toString())
              .setQueryInput(queryInput)
              .build());

      try (FileInputStream audioStream = new FileInputStream(audioFilePath)) {
        // Subsequent requests must **only** contain the audio data.
        // Following messages: audio chunks. We just read the file in fixed-size chunks. In reality
        // you would split the user input by time.
        byte[] buffer = new byte[4096];
        int bytes;
        while ((bytes = audioStream.read(buffer)) != -1) {
          AudioInput subAudioInput =
              AudioInput.newBuilder().setAudio(ByteString.copyFrom(buffer, 0, bytes)).build();
          QueryInput subQueryInput =
              QueryInput.newBuilder()
                  .setAudio(subAudioInput)
                  .setLanguageCode("en-US") // languageCode = "en-US"
                  .build();
          bidiStream.send(
              StreamingDetectIntentRequest.newBuilder().setQueryInput(subQueryInput).build());
        }
      }

      // Tell the service you are done sending data.
      bidiStream.closeSend();

      for (StreamingDetectIntentResponse response : bidiStream) {
        QueryResult queryResult = response.getDetectIntentResponse().getQueryResult();
        System.out.println("====================");
        System.out.format("Query Text: '%s'\n", queryResult.getTranscript());
        System.out.format(
            "Detected Intent: %s (confidence: %f)\n",
            queryResult.getIntent().getDisplayName(), queryResult.getIntentDetectionConfidence());
      }
    }
  }
}
// [END dialogflow_cx_detect_intent_streaming]

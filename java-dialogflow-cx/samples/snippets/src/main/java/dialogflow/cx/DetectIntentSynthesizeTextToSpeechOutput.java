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

// [START dialogflow_cx_v3_detect_intent_synthesize_tts_output]

import com.google.api.gax.rpc.ApiException;
import com.google.cloud.dialogflow.cx.v3.AudioEncoding;
import com.google.cloud.dialogflow.cx.v3.AudioInput;
import com.google.cloud.dialogflow.cx.v3.DetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3.DetectIntentResponse;
import com.google.cloud.dialogflow.cx.v3.InputAudioConfig;
import com.google.cloud.dialogflow.cx.v3.OutputAudioConfig;
import com.google.cloud.dialogflow.cx.v3.OutputAudioEncoding;
import com.google.cloud.dialogflow.cx.v3.QueryInput;
import com.google.cloud.dialogflow.cx.v3.SessionName;
import com.google.cloud.dialogflow.cx.v3.SessionsClient;
import com.google.cloud.dialogflow.cx.v3.SessionsSettings;
import com.google.cloud.dialogflow.cx.v3.SynthesizeSpeechConfig;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;

public class DetectIntentSynthesizeTextToSpeechOutput {

  // DialogFlow API Detect Intent sample with synthesize TTS output.
  public static void main(String[] args) throws IOException, ApiException {
    String projectId = "my-project-id";
    String locationId = "my-location-id";
    String agentId = "my-agent-id";
    String audioFileName = "my-audio-file-name";
    int sampleRateHertz = 16000;
    String sessionId = "my-session-id";
    String languageCode = "my-language-code";

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

    // Note: close() needs to be called on the SessionsClient object to clean up resources
    // such as threads. In the example below, try-with-resources is used,
    // which automatically calls close().
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

        SynthesizeSpeechConfig speechConfig =
            SynthesizeSpeechConfig.newBuilder().setSpeakingRate(1.25).setPitch(10.0).build();

        OutputAudioConfig outputAudioConfig =
            OutputAudioConfig.newBuilder()
                .setAudioEncoding(OutputAudioEncoding.OUTPUT_AUDIO_ENCODING_LINEAR_16)
                .setSynthesizeSpeechConfig(speechConfig)
                .build();

        DetectIntentRequest request =
            DetectIntentRequest.newBuilder()
                .setSession(session.toString())
                .setQueryInput(queryInput)
                .setOutputAudioConfig(outputAudioConfig)
                .build();

        // Performs the detect intent request.
        DetectIntentResponse response = sessionsClient.detectIntent(request);

        // Display the output audio config retrieved from the response.
        OutputAudioConfig audioConfigFromResponse = response.getOutputAudioConfig();

        System.out.println("====================");
        System.out.format("Output Audio Config: %s \n", audioConfigFromResponse.toString());
      }
    }
  }
}
// [END dialogflow_cx_v3_detect_intent_synthesize_tts_output]

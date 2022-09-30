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

// [START dialogflow_cx_v3_detect_intent_streaming_partial_response]

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.BidiStream;
import com.google.cloud.dialogflow.cx.v3.AudioEncoding;
import com.google.cloud.dialogflow.cx.v3.AudioInput;
import com.google.cloud.dialogflow.cx.v3.InputAudioConfig;
import com.google.cloud.dialogflow.cx.v3.OutputAudioConfig;
import com.google.cloud.dialogflow.cx.v3.OutputAudioEncoding;
import com.google.cloud.dialogflow.cx.v3.QueryInput;
import com.google.cloud.dialogflow.cx.v3.SessionName;
import com.google.cloud.dialogflow.cx.v3.SessionsClient;
import com.google.cloud.dialogflow.cx.v3.SessionsSettings;
import com.google.cloud.dialogflow.cx.v3.SsmlVoiceGender;
import com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3.StreamingDetectIntentResponse;
import com.google.cloud.dialogflow.cx.v3.SynthesizeSpeechConfig;
import com.google.cloud.dialogflow.cx.v3.VoiceSelectionParams;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;

public class DetectIntentStreamingPartialResponse {

  // DialogFlow API Detect Intent sample with audio files
  // that processes as an audio stream.
  public static void detectIntentStreamingPartialResponse(
      String projectId, String locationId, String agentId, String sessionId, String audioFilePath)
      throws ApiException, IOException {
    SessionsSettings.Builder sessionsSettingsBuilder = SessionsSettings.newBuilder();
    if (locationId.equals("global")) {
      sessionsSettingsBuilder.setEndpoint("dialogflow.googleapis.com:443");
    } else {
      sessionsSettingsBuilder.setEndpoint(locationId + "-dialogflow.googleapis.com:443");
    }
    SessionsSettings sessionsSettings = sessionsSettingsBuilder.build();

    // Instantiates a client by setting the session name.
    // Format:`projects/<ProjectID>/locations/<LocationID>/agents/<AgentID>/sessions/<SessionID>`
    // Using the same `sessionId` between requests allows continuation of the conversation.

    // Note: close() needs to be called on the SessionsClient object to clean up resources
    // such as threads. In the example below, try-with-resources is used,
    // which automatically calls close().
    try (SessionsClient sessionsClient = SessionsClient.create(sessionsSettings)) {
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

      // Specify sssml name and gender
      VoiceSelectionParams voiceSelection =
          // Voices that are available https://cloud.google.com/text-to-speech/docs/voices
          VoiceSelectionParams.newBuilder()
              .setName("en-GB-Standard-A")
              .setSsmlGender(SsmlVoiceGender.SSML_VOICE_GENDER_FEMALE)
              .build();

      SynthesizeSpeechConfig speechConfig =
          SynthesizeSpeechConfig.newBuilder().setVoice(voiceSelection).build();

      // Setup audio config
      OutputAudioConfig audioConfig =
          // Output encoding explanation
          // https://cloud.google.com/dialogflow/cx/docs/reference/rpc/google.cloud.dialogflow.cx.v3#outputaudioencoding
          OutputAudioConfig.newBuilder()
              .setAudioEncoding(OutputAudioEncoding.OUTPUT_AUDIO_ENCODING_UNSPECIFIED)
              .setAudioEncodingValue(1)
              .setSynthesizeSpeechConfig(speechConfig)
              .build();

      StreamingDetectIntentRequest streamingDetectIntentRequest =
          StreamingDetectIntentRequest.newBuilder()
              .setSession(session.toString())
              .setQueryInput(queryInput)
              .setEnablePartialResponse(true)
              .setOutputAudioConfig(audioConfig)
              .build();
      System.out.println(streamingDetectIntentRequest.toString());

      // The first request must **only** contain the audio configuration:
      bidiStream.send(streamingDetectIntentRequest);

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

      // TODO: Uncomment to print detectIntentResponse.

      //   for (StreamingDetectIntentResponse response : bidiStream) {
      //     QueryResult queryResult = response.getDetectIntentResponse().getQueryResult();
      //     System.out.println("====================");
      //     System.out.format("Query Text: '%s'\n", queryResult.getTranscript());
      //     System.out.format(
      //         "Detected Intent: %s (confidence: %f)\n",
      //         queryResult.getIntent()
      //         .getDisplayName(), queryResult.getIntentDetectionConfidence());
      //   }
    }
  }
}
// [END dialogflow_cx_v3_detect_intent_streaming_partial_response]

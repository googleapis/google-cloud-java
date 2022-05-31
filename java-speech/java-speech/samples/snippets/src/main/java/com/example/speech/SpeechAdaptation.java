/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.speech;

// [START speech_adaptation_beta]
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechContext;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import java.io.IOException;

public class SpeechAdaptation {

  public void speechAdaptation() throws IOException {
    String uriPath = "gs://cloud-samples-data/speech/brooklyn_bridge.mp3";
    speechAdaptation(uriPath);
  }

  public static void speechAdaptation(String uriPath) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SpeechClient speechClient = SpeechClient.create()) {

      // Provides "hints" to the speech recognizer to favor specific words and phrases in the
      // results.
      // https://cloud.google.com/speech-to-text/docs/reference/rpc/google.cloud.speech.v1p1beta1#google.cloud.speech.v1p1beta1.SpeechContext
      SpeechContext speechContext =
          SpeechContext.newBuilder().addPhrases("Brooklyn Bridge").setBoost(20.0F).build();
      // Configure recognition config to match your audio file.
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(RecognitionConfig.AudioEncoding.MP3)
              .setSampleRateHertz(44100)
              .setLanguageCode("en-US")
              .addSpeechContexts(speechContext)
              .build();
      // Set the path to your audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uriPath).build();

      // Make the request
      RecognizeRequest request =
          RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();

      // Display the results
      RecognizeResponse response = speechClient.recognize(request);
      for (SpeechRecognitionResult result : response.getResultsList()) {
        // First alternative is the most probable result
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript: %s\n", alternative.getTranscript());
      }
    }
  }
}
// [END speech_adaptation_beta]

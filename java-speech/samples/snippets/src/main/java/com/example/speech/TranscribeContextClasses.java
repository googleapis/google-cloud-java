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

// [START speech_context_classes]
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeRequest;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechContext;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import java.io.IOException;

class TranscribeContextClasses {

  void transcribeContextClasses() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String storageUri = "gs://YOUR_BUCKET_ID/path/to/your/file.wav";
    transcribeContextClasses(storageUri);
  }

  // Provides "hints" to the speech recognizer to favor specific classes of words in the results.
  static void transcribeContextClasses(String storageUri) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (SpeechClient speechClient = SpeechClient.create()) {
      // SpeechContext: to configure your speech_context see:
      // https://cloud.google.com/speech-to-text/docs/reference/rpc/google.cloud.speech.v1#speechcontext
      // Full list of supported phrases (class tokens) here:
      // https://cloud.google.com/speech-to-text/docs/class-tokens
      SpeechContext speechContext = SpeechContext.newBuilder().addPhrases("$TIME").build();

      // RecognitionConfig: to configure your encoding and sample_rate_hertz, see:
      // https://cloud.google.com/speech-to-text/docs/reference/rpc/google.cloud.speech.v1#recognitionconfig
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
              .setSampleRateHertz(8000)
              .setLanguageCode("en-US")
              .addSpeechContexts(speechContext)
              .build();

      // Set the path to your audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(storageUri).build();

      // Build the request
      RecognizeRequest request =
          RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();

      // Perform the request
      RecognizeResponse response = speechClient.recognize(request);

      for (SpeechRecognitionResult result : response.getResultsList()) {
        // First alternative is the most probable result
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcript: %s\n", alternative.getTranscript());
      }
    }
  }
}
// [END speech_context_classes]

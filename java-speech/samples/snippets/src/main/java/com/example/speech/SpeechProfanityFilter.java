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

// [START speech_transcribe_with_profanity_filter_gcs]
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import java.io.IOException;
import java.util.List;

public class SpeechProfanityFilter {

  public void speechProfanityFilter() throws Exception {
    String uriPath = "gs://cloud-samples-tests/speech/brooklyn.flac";
    speechProfanityFilter(uriPath);
  }

  /**
   * Transcribe a remote audio file with multi-channel recognition
   *
   * @param gcsUri the path to the audio file
   */
  public static void speechProfanityFilter(String gcsUri) throws Exception {
    // Instantiates a client with GOOGLE_APPLICATION_CREDENTIALS
    try (SpeechClient speech = SpeechClient.create()) {

      // Configure remote file request 
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.FLAC)
              .setLanguageCode("en-US")
              .setSampleRateHertz(16000)
              .setProfanityFilter(true)
              .build();

      // Set the remote path for the audio file
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(gcsUri).build();

      // Use blocking call to get audio transcript
      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      for (SpeechRecognitionResult result : results) {
        // There can be several alternative transcripts for a given chunk of speech. Just use the
        // first (most likely) one here.
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription: %s\n", alternative.getTranscript());
      }
    } 
  }
}
// [END speech_transcribe_with_profanity_filter_gcs]
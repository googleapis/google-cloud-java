/*
 * Copyright 2019 Google LLC
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
// DO NOT EDIT! This is a generated sample ("Request",  "samplegen_repeated_fields")
// sample-metadata:
//   title: Showing repeated fields (in request and response)
//   description: Showing repeated fields (in request and response)
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1p1beta1.SamplegenRepeatedFields

package com.google.cloud.examples.speech.v1p1beta1;

import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
import com.google.cloud.speech.v1p1beta1.SpeechClient;
import com.google.cloud.speech.v1p1beta1.SpeechContext;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
import java.util.Arrays;
import java.util.List;

public class SamplegenRepeatedFields {
  // [START samplegen_repeated_fields]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
   * import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
   * import com.google.cloud.speech.v1p1beta1.RecognizeRequest;
   * import com.google.cloud.speech.v1p1beta1.RecognizeResponse;
   * import com.google.cloud.speech.v1p1beta1.SpeechClient;
   * import com.google.cloud.speech.v1p1beta1.SpeechContext;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionAlternative;
   * import com.google.cloud.speech.v1p1beta1.SpeechRecognitionResult;
   * import java.util.Arrays;
   * import java.util.List;
   */

  /** Showing repeated fields (in request and response) */
  public static void sampleRecognize() {
    try (SpeechClient speechClient = SpeechClient.create()) {
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.MP3;

      // A list of strings containing words and phrases "hints"
      String phrasesElement = "Fox in socks";
      String phrasesElement2 = "Knox in box";
      List<String> phrases = Arrays.asList(phrasesElement, phrasesElement2);
      SpeechContext speechContextsElement =
          SpeechContext.newBuilder().addAllPhrases(phrases).build();
      List<SpeechContext> speechContexts = Arrays.asList(speechContextsElement);
      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(encoding)
              .addAllSpeechContexts(speechContexts)
              .build();
      String uri = "gs://[BUCKET]/[FILENAME]";
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uri).build();
      RecognizeRequest request =
          RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      RecognizeResponse response = speechClient.recognize(request);
      // Loop over all transcription results
      for (SpeechRecognitionResult result : response.getResultsList()) {
        // The first "alternative" of each result contains most likely transcription
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        System.out.printf("Transcription of result: %s\n", alternative.getTranscript());
      }
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_repeated_fields]

  public static void main(String[] args) {
    sampleRecognize();
  }
}

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
// DO NOT EDIT! This is a generated sample ("LongRunningRequestAsync",  "samplegen_lro")
// sample-metadata:
//   title: Calling Long-Running API method
//   description: Calling Long-Running API method
//   usage: gradle run -PmainClass=com.google.cloud.examples.speech.v1p1beta1.SamplegenLro

package com.google.cloud.examples.speech.v1p1beta1;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
import com.google.cloud.speech.v1p1beta1.SpeechClient;

public class SamplegenLro {
  // [START samplegen_lro]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.api.gax.longrunning.OperationFuture;
   * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeMetadata;
   * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeRequest;
   * import com.google.cloud.speech.v1p1beta1.LongRunningRecognizeResponse;
   * import com.google.cloud.speech.v1p1beta1.RecognitionAudio;
   * import com.google.cloud.speech.v1p1beta1.RecognitionConfig;
   * import com.google.cloud.speech.v1p1beta1.SpeechClient;
   */

  /** Calling Long-Running API method */
  public static void sampleLongRunningRecognize() {
    try (SpeechClient speechClient = SpeechClient.create()) {
      RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.MP3;
      RecognitionConfig config = RecognitionConfig.newBuilder().setEncoding(encoding).build();
      String uri = "gs://[BUCKET]/[FILENAME]";
      RecognitionAudio audio = RecognitionAudio.newBuilder().setUri(uri).build();
      LongRunningRecognizeRequest request =
          LongRunningRecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
      OperationFuture<LongRunningRecognizeResponse, LongRunningRecognizeMetadata> future =
          speechClient.longRunningRecognizeAsync(request);

      System.out.println("Waiting for operation to complete...");
      LongRunningRecognizeResponse response = future.get();
      // Your audio has been transcribed.
      System.out.printf(
          "Transcript: %s\n",
          response.getResultsList().get(0).getAlternativesList().get(0).getTranscript());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END samplegen_lro]

  public static void main(String[] args) {
    sampleLongRunningRecognize();
  }
}

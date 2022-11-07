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

package com.google.cloud.speech.v1.samples;

// [START speech_v1_generated_Speech_Recognize_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeRequest;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;

public class AsyncRecognize {

  public static void main(String[] args) throws Exception {
    asyncRecognize();
  }

  public static void asyncRecognize() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SpeechClient speechClient = SpeechClient.create()) {
      RecognizeRequest request =
          RecognizeRequest.newBuilder()
              .setConfig(RecognitionConfig.newBuilder().build())
              .setAudio(RecognitionAudio.newBuilder().build())
              .build();
      ApiFuture<RecognizeResponse> future = speechClient.recognizeCallable().futureCall(request);
      // Do something.
      RecognizeResponse response = future.get();
    }
  }
}
// [END speech_v1_generated_Speech_Recognize_async]

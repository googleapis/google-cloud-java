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

package com.google.cloud.texttospeech.v1beta1.samples;

// [START texttospeech_v1beta1_generated_texttospeechclient_listvoices_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.texttospeech.v1beta1.ListVoicesRequest;
import com.google.cloud.texttospeech.v1beta1.ListVoicesResponse;
import com.google.cloud.texttospeech.v1beta1.TextToSpeechClient;

public class AsyncListVoices {

  public static void main(String[] args) throws Exception {
    asyncListVoices();
  }

  public static void asyncListVoices() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (TextToSpeechClient textToSpeechClient = TextToSpeechClient.create()) {
      ListVoicesRequest request =
          ListVoicesRequest.newBuilder().setLanguageCode("languageCode-2092349083").build();
      ApiFuture<ListVoicesResponse> future =
          textToSpeechClient.listVoicesCallable().futureCall(request);
      // Do something.
      ListVoicesResponse response = future.get();
    }
  }
}
// [END texttospeech_v1beta1_generated_texttospeechclient_listvoices_async]

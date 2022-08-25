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

package com.google.cloud.translate.v3.samples;

// [START translation_v3_generated_translationserviceclient_detectlanguage_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.translate.v3.DetectLanguageRequest;
import com.google.cloud.translate.v3.DetectLanguageResponse;
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslationServiceClient;
import java.util.HashMap;

public class AsyncDetectLanguage {

  public static void main(String[] args) throws Exception {
    asyncDetectLanguage();
  }

  public static void asyncDetectLanguage() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      DetectLanguageRequest request =
          DetectLanguageRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setModel("model104069929")
              .setMimeType("mimeType-1392120434")
              .putAllLabels(new HashMap<String, String>())
              .build();
      ApiFuture<DetectLanguageResponse> future =
          translationServiceClient.detectLanguageCallable().futureCall(request);
      // Do something.
      DetectLanguageResponse response = future.get();
    }
  }
}
// [END translation_v3_generated_translationserviceclient_detectlanguage_async]

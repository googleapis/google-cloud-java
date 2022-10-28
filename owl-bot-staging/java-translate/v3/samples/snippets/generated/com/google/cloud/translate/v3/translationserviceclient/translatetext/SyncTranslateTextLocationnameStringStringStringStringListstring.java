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

// [START translate_v3_generated_translationserviceclient_translatetext_locationnamestringstringstringstringliststring_sync]
import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.TranslationServiceClient;
import java.util.ArrayList;
import java.util.List;

public class SyncTranslateTextLocationnameStringStringStringStringListstring {

  public static void main(String[] args) throws Exception {
    syncTranslateTextLocationnameStringStringStringStringListstring();
  }

  public static void syncTranslateTextLocationnameStringStringStringStringListstring()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String model = "model104069929";
      String mimeType = "mimeType-1392120434";
      String sourceLanguageCode = "sourceLanguageCode1645917472";
      String targetLanguageCode = "targetLanguageCode-106414698";
      List<String> contents = new ArrayList<>();
      TranslateTextResponse response =
          translationServiceClient.translateText(
              parent, model, mimeType, sourceLanguageCode, targetLanguageCode, contents);
    }
  }
}
// [END translate_v3_generated_translationserviceclient_translatetext_locationnamestringstringstringstringliststring_sync]

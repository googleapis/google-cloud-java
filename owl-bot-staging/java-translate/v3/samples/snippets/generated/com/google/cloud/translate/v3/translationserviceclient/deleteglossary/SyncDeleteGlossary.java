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

// [START translate_v3_generated_translationserviceclient_deleteglossary_sync]
import com.google.cloud.translate.v3.DeleteGlossaryRequest;
import com.google.cloud.translate.v3.DeleteGlossaryResponse;
import com.google.cloud.translate.v3.GlossaryName;
import com.google.cloud.translate.v3.TranslationServiceClient;

public class SyncDeleteGlossary {

  public static void main(String[] args) throws Exception {
    syncDeleteGlossary();
  }

  public static void syncDeleteGlossary() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TranslationServiceClient translationServiceClient = TranslationServiceClient.create()) {
      DeleteGlossaryRequest request =
          DeleteGlossaryRequest.newBuilder()
              .setName(GlossaryName.of("[PROJECT]", "[LOCATION]", "[GLOSSARY]").toString())
              .build();
      DeleteGlossaryResponse response = translationServiceClient.deleteGlossaryAsync(request).get();
    }
  }
}
// [END translate_v3_generated_translationserviceclient_deleteglossary_sync]

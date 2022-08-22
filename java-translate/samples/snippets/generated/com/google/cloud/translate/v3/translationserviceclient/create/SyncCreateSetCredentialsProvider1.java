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

// [START translation_v3_generated_translationserviceclient_create_setcredentialsprovider1_sync]
import com.google.cloud.translate.v3.TranslationServiceClient;
import com.google.cloud.translate.v3.TranslationServiceSettings;

public class SyncCreateSetCredentialsProvider1 {

  public static void main(String[] args) throws Exception {
    syncCreateSetCredentialsProvider1();
  }

  public static void syncCreateSetCredentialsProvider1() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    TranslationServiceSettings translationServiceSettings =
        TranslationServiceSettings.newBuilder()
            .setTransportChannelProvider(
                TranslationServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
            .build();
    TranslationServiceClient translationServiceClient =
        TranslationServiceClient.create(translationServiceSettings);
  }
}
// [END translation_v3_generated_translationserviceclient_create_setcredentialsprovider1_sync]

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

package com.google.cloud.dialogflow.v2.samples;

// [START dialogflow_v2_generated_intentsclient_getintent_sync]
import com.google.cloud.dialogflow.v2.GetIntentRequest;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.IntentName;
import com.google.cloud.dialogflow.v2.IntentView;
import com.google.cloud.dialogflow.v2.IntentsClient;

public class SyncGetIntent {

  public static void main(String[] args) throws Exception {
    syncGetIntent();
  }

  public static void syncGetIntent() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (IntentsClient intentsClient = IntentsClient.create()) {
      GetIntentRequest request =
          GetIntentRequest.newBuilder()
              .setName(IntentName.ofProjectIntentName("[PROJECT]", "[INTENT]").toString())
              .setLanguageCode("languageCode-2092349083")
              .setIntentView(IntentView.forNumber(0))
              .build();
      Intent response = intentsClient.getIntent(request);
    }
  }
}
// [END dialogflow_v2_generated_intentsclient_getintent_sync]

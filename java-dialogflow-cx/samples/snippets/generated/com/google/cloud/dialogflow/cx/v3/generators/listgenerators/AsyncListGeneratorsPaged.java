/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dialogflow.cx.v3.samples;

// [START dialogflow_v3_generated_Generators_ListGenerators_Paged_async]
import com.google.cloud.dialogflow.cx.v3.AgentName;
import com.google.cloud.dialogflow.cx.v3.Generator;
import com.google.cloud.dialogflow.cx.v3.GeneratorsClient;
import com.google.cloud.dialogflow.cx.v3.ListGeneratorsRequest;
import com.google.cloud.dialogflow.cx.v3.ListGeneratorsResponse;
import com.google.common.base.Strings;

public class AsyncListGeneratorsPaged {

  public static void main(String[] args) throws Exception {
    asyncListGeneratorsPaged();
  }

  public static void asyncListGeneratorsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GeneratorsClient generatorsClient = GeneratorsClient.create()) {
      ListGeneratorsRequest request =
          ListGeneratorsRequest.newBuilder()
              .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
              .setLanguageCode("languageCode-2092349083")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListGeneratorsResponse response = generatorsClient.listGeneratorsCallable().call(request);
        for (Generator element : response.getGeneratorsList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END dialogflow_v3_generated_Generators_ListGenerators_Paged_async]

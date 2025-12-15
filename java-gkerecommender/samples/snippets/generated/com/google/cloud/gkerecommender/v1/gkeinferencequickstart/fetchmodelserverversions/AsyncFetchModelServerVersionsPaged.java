/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.gkerecommender.v1.samples;

// [START gkerecommender_v1_generated_GkeInferenceQuickstart_FetchModelServerVersions_Paged_async]
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse;
import com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient;
import com.google.common.base.Strings;

public class AsyncFetchModelServerVersionsPaged {

  public static void main(String[] args) throws Exception {
    asyncFetchModelServerVersionsPaged();
  }

  public static void asyncFetchModelServerVersionsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GkeInferenceQuickstartClient gkeInferenceQuickstartClient =
        GkeInferenceQuickstartClient.create()) {
      FetchModelServerVersionsRequest request =
          FetchModelServerVersionsRequest.newBuilder()
              .setModel("model104069929")
              .setModelServer("modelServer475157452")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        FetchModelServerVersionsResponse response =
            gkeInferenceQuickstartClient.fetchModelServerVersionsCallable().call(request);
        for (String element : response.getModelServerVersionsList()) {
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
// [END gkerecommender_v1_generated_GkeInferenceQuickstart_FetchModelServerVersions_Paged_async]

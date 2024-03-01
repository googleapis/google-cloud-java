/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.networkconnectivity.v1.samples;

// [START networkconnectivity_v1_generated_HubService_ListHubSpokes_Paged_async]
import com.google.cloud.networkconnectivity.v1.HubName;
import com.google.cloud.networkconnectivity.v1.HubServiceClient;
import com.google.cloud.networkconnectivity.v1.ListHubSpokesRequest;
import com.google.cloud.networkconnectivity.v1.ListHubSpokesResponse;
import com.google.cloud.networkconnectivity.v1.Spoke;
import com.google.common.base.Strings;
import java.util.ArrayList;

public class AsyncListHubSpokesPaged {

  public static void main(String[] args) throws Exception {
    asyncListHubSpokesPaged();
  }

  public static void asyncListHubSpokesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HubServiceClient hubServiceClient = HubServiceClient.create()) {
      ListHubSpokesRequest request =
          ListHubSpokesRequest.newBuilder()
              .setName(HubName.of("[PROJECT]", "[HUB]").toString())
              .addAllSpokeLocations(new ArrayList<String>())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListHubSpokesResponse response = hubServiceClient.listHubSpokesCallable().call(request);
        for (Spoke element : response.getSpokesList()) {
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
// [END networkconnectivity_v1_generated_HubService_ListHubSpokes_Paged_async]

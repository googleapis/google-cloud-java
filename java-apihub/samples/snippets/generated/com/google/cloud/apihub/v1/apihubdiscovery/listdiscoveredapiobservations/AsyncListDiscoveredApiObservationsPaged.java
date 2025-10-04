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

package com.google.cloud.apihub.v1.samples;

// [START apihub_v1_generated_ApiHubDiscovery_ListDiscoveredApiObservations_Paged_async]
import com.google.cloud.apihub.v1.ApiHubDiscoveryClient;
import com.google.cloud.apihub.v1.DiscoveredApiObservation;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsResponse;
import com.google.cloud.apihub.v1.LocationName;
import com.google.common.base.Strings;

public class AsyncListDiscoveredApiObservationsPaged {

  public static void main(String[] args) throws Exception {
    asyncListDiscoveredApiObservationsPaged();
  }

  public static void asyncListDiscoveredApiObservationsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
      ListDiscoveredApiObservationsRequest request =
          ListDiscoveredApiObservationsRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListDiscoveredApiObservationsResponse response =
            apiHubDiscoveryClient.listDiscoveredApiObservationsCallable().call(request);
        for (DiscoveredApiObservation element : response.getDiscoveredApiObservationsList()) {
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
// [END apihub_v1_generated_ApiHubDiscovery_ListDiscoveredApiObservations_Paged_async]

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

package google.maps.fleetengine.delivery.v1.samples;

// [START fleetengine_v1_generated_DeliveryService_SearchTasks_Paged_async]
import com.google.common.base.Strings;
import google.maps.fleetengine.delivery.v1.DeliveryRequestHeader;
import google.maps.fleetengine.delivery.v1.DeliveryServiceClient;
import google.maps.fleetengine.delivery.v1.SearchTasksRequest;
import google.maps.fleetengine.delivery.v1.SearchTasksResponse;
import google.maps.fleetengine.delivery.v1.Task;

public class AsyncSearchTasksPaged {

  public static void main(String[] args) throws Exception {
    asyncSearchTasksPaged();
  }

  public static void asyncSearchTasksPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
      SearchTasksRequest request =
          SearchTasksRequest.newBuilder()
              .setHeader(DeliveryRequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setTrackingId("trackingId1168987698")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        SearchTasksResponse response = deliveryServiceClient.searchTasksCallable().call(request);
        for (Task element : response.getTasksList()) {
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
// [END fleetengine_v1_generated_DeliveryService_SearchTasks_Paged_async]

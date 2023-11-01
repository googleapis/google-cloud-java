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

// [START fleetengine_v1_generated_DeliveryService_ListTasks_Paged_async]
import com.google.common.base.Strings;
import google.maps.fleetengine.delivery.v1.DeliveryRequestHeader;
import google.maps.fleetengine.delivery.v1.DeliveryServiceClient;
import google.maps.fleetengine.delivery.v1.ListTasksRequest;
import google.maps.fleetengine.delivery.v1.ListTasksResponse;
import google.maps.fleetengine.delivery.v1.ProviderName;
import google.maps.fleetengine.delivery.v1.Task;

public class AsyncListTasksPaged {

  public static void main(String[] args) throws Exception {
    asyncListTasksPaged();
  }

  public static void asyncListTasksPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
      ListTasksRequest request =
          ListTasksRequest.newBuilder()
              .setHeader(DeliveryRequestHeader.newBuilder().build())
              .setParent(ProviderName.of("[PROVIDER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListTasksResponse response = deliveryServiceClient.listTasksCallable().call(request);
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
// [END fleetengine_v1_generated_DeliveryService_ListTasks_Paged_async]

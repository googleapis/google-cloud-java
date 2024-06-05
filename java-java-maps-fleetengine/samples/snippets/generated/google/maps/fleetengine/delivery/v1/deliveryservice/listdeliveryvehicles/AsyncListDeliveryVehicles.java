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

package google.maps.fleetengine.delivery.v1.samples;

// [START fleetengine_v1_generated_DeliveryService_ListDeliveryVehicles_async]
import com.google.api.core.ApiFuture;
import com.google.geo.type.Viewport;
import google.maps.fleetengine.delivery.v1.DeliveryRequestHeader;
import google.maps.fleetengine.delivery.v1.DeliveryServiceClient;
import google.maps.fleetengine.delivery.v1.DeliveryVehicle;
import google.maps.fleetengine.delivery.v1.ListDeliveryVehiclesRequest;
import google.maps.fleetengine.delivery.v1.ProviderName;

public class AsyncListDeliveryVehicles {

  public static void main(String[] args) throws Exception {
    asyncListDeliveryVehicles();
  }

  public static void asyncListDeliveryVehicles() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeliveryServiceClient deliveryServiceClient = DeliveryServiceClient.create()) {
      ListDeliveryVehiclesRequest request =
          ListDeliveryVehiclesRequest.newBuilder()
              .setHeader(DeliveryRequestHeader.newBuilder().build())
              .setParent(ProviderName.of("[PROVIDER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setViewport(Viewport.newBuilder().build())
              .build();
      ApiFuture<DeliveryVehicle> future =
          deliveryServiceClient.listDeliveryVehiclesPagedCallable().futureCall(request);
      // Do something.
      for (DeliveryVehicle element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END fleetengine_v1_generated_DeliveryService_ListDeliveryVehicles_async]

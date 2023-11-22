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

package google.maps.fleetengine.v1.samples;

// [START fleetengine_v1_generated_TripService_SearchTrips_async]
import com.google.api.core.ApiFuture;
import com.google.protobuf.Duration;
import google.maps.fleetengine.v1.RequestHeader;
import google.maps.fleetengine.v1.SearchTripsRequest;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.TripServiceClient;

public class AsyncSearchTrips {

  public static void main(String[] args) throws Exception {
    asyncSearchTrips();
  }

  public static void asyncSearchTrips() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
      SearchTripsRequest request =
          SearchTripsRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setVehicleId("vehicleId-1984135833")
              .setActiveTripsOnly(true)
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setMinimumStaleness(Duration.newBuilder().build())
              .build();
      ApiFuture<Trip> future = tripServiceClient.searchTripsPagedCallable().futureCall(request);
      // Do something.
      for (Trip element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END fleetengine_v1_generated_TripService_SearchTrips_async]

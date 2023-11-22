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

// [START fleetengine_v1_generated_TripService_GetTrip_async]
import com.google.api.core.ApiFuture;
import com.google.protobuf.Timestamp;
import google.maps.fleetengine.v1.GetTripRequest;
import google.maps.fleetengine.v1.PolylineFormatType;
import google.maps.fleetengine.v1.RequestHeader;
import google.maps.fleetengine.v1.Trip;
import google.maps.fleetengine.v1.TripName;
import google.maps.fleetengine.v1.TripServiceClient;
import google.maps.fleetengine.v1.TripView;

public class AsyncGetTrip {

  public static void main(String[] args) throws Exception {
    asyncGetTrip();
  }

  public static void asyncGetTrip() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TripServiceClient tripServiceClient = TripServiceClient.create()) {
      GetTripRequest request =
          GetTripRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setName(TripName.of("[PROVIDER]", "[TRIP]").toString())
              .setView(TripView.forNumber(0))
              .setCurrentRouteSegmentVersion(Timestamp.newBuilder().build())
              .setRemainingWaypointsVersion(Timestamp.newBuilder().build())
              .setRouteFormatType(PolylineFormatType.forNumber(0))
              .setCurrentRouteSegmentTrafficVersion(Timestamp.newBuilder().build())
              .setRemainingWaypointsRouteVersion(Timestamp.newBuilder().build())
              .build();
      ApiFuture<Trip> future = tripServiceClient.getTripCallable().futureCall(request);
      // Do something.
      Trip response = future.get();
    }
  }
}
// [END fleetengine_v1_generated_TripService_GetTrip_async]

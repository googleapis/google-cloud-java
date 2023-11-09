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

// [START fleetengine_v1_generated_VehicleService_ListVehicles_async]
import com.google.api.core.ApiFuture;
import com.google.geo.type.Viewport;
import com.google.protobuf.Duration;
import com.google.protobuf.Int32Value;
import google.maps.fleetengine.v1.ListVehiclesRequest;
import google.maps.fleetengine.v1.RequestHeader;
import google.maps.fleetengine.v1.TripType;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleServiceClient;
import google.maps.fleetengine.v1.VehicleState;
import java.util.ArrayList;

public class AsyncListVehicles {

  public static void main(String[] args) throws Exception {
    asyncListVehicles();
  }

  public static void asyncListVehicles() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
      ListVehiclesRequest request =
          ListVehiclesRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setMinimumCapacity(Int32Value.newBuilder().build())
              .addAllTripTypes(new ArrayList<TripType>())
              .setMaximumStaleness(Duration.newBuilder().build())
              .addAllVehicleTypeCategories(new ArrayList<Vehicle.VehicleType.Category>())
              .addAllRequiredAttributes(new ArrayList<String>())
              .addAllRequiredOneOfAttributes(new ArrayList<String>())
              .addAllRequiredOneOfAttributeSets(new ArrayList<String>())
              .setVehicleState(VehicleState.forNumber(0))
              .setOnTripOnly(true)
              .setFilter("filter-1274492040")
              .setViewport(Viewport.newBuilder().build())
              .build();
      ApiFuture<Vehicle> future =
          vehicleServiceClient.listVehiclesPagedCallable().futureCall(request);
      // Do something.
      for (Vehicle element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END fleetengine_v1_generated_VehicleService_ListVehicles_async]

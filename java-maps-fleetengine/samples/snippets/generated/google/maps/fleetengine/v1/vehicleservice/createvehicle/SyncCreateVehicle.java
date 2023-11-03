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

// [START fleetengine_v1_generated_VehicleService_CreateVehicle_sync]
import google.maps.fleetengine.v1.CreateVehicleRequest;
import google.maps.fleetengine.v1.RequestHeader;
import google.maps.fleetengine.v1.Vehicle;
import google.maps.fleetengine.v1.VehicleServiceClient;

public class SyncCreateVehicle {

  public static void main(String[] args) throws Exception {
    syncCreateVehicle();
  }

  public static void syncCreateVehicle() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VehicleServiceClient vehicleServiceClient = VehicleServiceClient.create()) {
      CreateVehicleRequest request =
          CreateVehicleRequest.newBuilder()
              .setHeader(RequestHeader.newBuilder().build())
              .setParent("parent-995424086")
              .setVehicleId("vehicleId-1984135833")
              .setVehicle(Vehicle.newBuilder().build())
              .build();
      Vehicle response = vehicleServiceClient.createVehicle(request);
    }
  }
}
// [END fleetengine_v1_generated_VehicleService_CreateVehicle_sync]

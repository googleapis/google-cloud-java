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

package com.google.cloud.configdelivery.v1beta.samples;

// [START configdelivery_v1beta_generated_ConfigDelivery_CreateFleetPackage_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.configdelivery.v1beta.ConfigDeliveryClient;
import com.google.cloud.configdelivery.v1beta.CreateFleetPackageRequest;
import com.google.cloud.configdelivery.v1beta.FleetPackage;
import com.google.cloud.configdelivery.v1beta.LocationName;
import com.google.cloud.configdelivery.v1beta.OperationMetadata;

public class AsyncCreateFleetPackageLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateFleetPackageLRO();
  }

  public static void asyncCreateFleetPackageLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
      CreateFleetPackageRequest request =
          CreateFleetPackageRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFleetPackageId("fleetPackageId-115835309")
              .setFleetPackage(FleetPackage.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<FleetPackage, OperationMetadata> future =
          configDeliveryClient.createFleetPackageOperationCallable().futureCall(request);
      // Do something.
      FleetPackage response = future.get();
    }
  }
}
// [END configdelivery_v1beta_generated_ConfigDelivery_CreateFleetPackage_LRO_async]

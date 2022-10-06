/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.iot.v1.samples;

// [START iot_v1_generated_devicemanagerclient_deletedeviceregistry_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.iot.v1.DeleteDeviceRegistryRequest;
import com.google.cloud.iot.v1.DeviceManagerClient;
import com.google.cloud.iot.v1.RegistryName;
import com.google.protobuf.Empty;

public class AsyncDeleteDeviceRegistry {

  public static void main(String[] args) throws Exception {
    asyncDeleteDeviceRegistry();
  }

  public static void asyncDeleteDeviceRegistry() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DeviceManagerClient deviceManagerClient = DeviceManagerClient.create()) {
      DeleteDeviceRegistryRequest request =
          DeleteDeviceRegistryRequest.newBuilder()
              .setName(RegistryName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]").toString())
              .build();
      ApiFuture<Empty> future =
          deviceManagerClient.deleteDeviceRegistryCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END iot_v1_generated_devicemanagerclient_deletedeviceregistry_async]

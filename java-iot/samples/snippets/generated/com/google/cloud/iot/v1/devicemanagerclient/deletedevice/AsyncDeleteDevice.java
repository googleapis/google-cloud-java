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

// [START iot_v1_generated_devicemanagerclient_deletedevice_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.iot.v1.DeleteDeviceRequest;
import com.google.cloud.iot.v1.DeviceManagerClient;
import com.google.cloud.iot.v1.DeviceName;
import com.google.protobuf.Empty;

public class AsyncDeleteDevice {

  public static void main(String[] args) throws Exception {
    asyncDeleteDevice();
  }

  public static void asyncDeleteDevice() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DeviceManagerClient deviceManagerClient = DeviceManagerClient.create()) {
      DeleteDeviceRequest request =
          DeleteDeviceRequest.newBuilder()
              .setName(
                  DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
              .build();
      ApiFuture<Empty> future = deviceManagerClient.deleteDeviceCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END iot_v1_generated_devicemanagerclient_deletedevice_async]

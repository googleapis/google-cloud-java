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

// [START iot_v1_generated_devicemanagerclient_sendcommandtodevice_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.iot.v1.DeviceManagerClient;
import com.google.cloud.iot.v1.DeviceName;
import com.google.cloud.iot.v1.SendCommandToDeviceRequest;
import com.google.cloud.iot.v1.SendCommandToDeviceResponse;
import com.google.protobuf.ByteString;

public class AsyncSendCommandToDevice {

  public static void main(String[] args) throws Exception {
    asyncSendCommandToDevice();
  }

  public static void asyncSendCommandToDevice() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (DeviceManagerClient deviceManagerClient = DeviceManagerClient.create()) {
      SendCommandToDeviceRequest request =
          SendCommandToDeviceRequest.newBuilder()
              .setName(
                  DeviceName.of("[PROJECT]", "[LOCATION]", "[REGISTRY]", "[DEVICE]").toString())
              .setBinaryData(ByteString.EMPTY)
              .setSubfolder("subfolder153561774")
              .build();
      ApiFuture<SendCommandToDeviceResponse> future =
          deviceManagerClient.sendCommandToDeviceCallable().futureCall(request);
      // Do something.
      SendCommandToDeviceResponse response = future.get();
    }
  }
}
// [END iot_v1_generated_devicemanagerclient_sendcommandtodevice_async]

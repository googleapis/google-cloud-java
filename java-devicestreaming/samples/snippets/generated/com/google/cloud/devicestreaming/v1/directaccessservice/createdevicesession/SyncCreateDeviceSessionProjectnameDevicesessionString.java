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

package com.google.cloud.devicestreaming.v1.samples;

// [START devicestreaming_v1_generated_DirectAccessService_CreateDeviceSession_ProjectnameDevicesessionString_sync]
import com.google.cloud.devicestreaming.v1.DeviceSession;
import com.google.cloud.devicestreaming.v1.DirectAccessServiceClient;
import com.google.cloud.devicestreaming.v1.ProjectName;

public class SyncCreateDeviceSessionProjectnameDevicesessionString {

  public static void main(String[] args) throws Exception {
    syncCreateDeviceSessionProjectnameDevicesessionString();
  }

  public static void syncCreateDeviceSessionProjectnameDevicesessionString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DirectAccessServiceClient directAccessServiceClient = DirectAccessServiceClient.create()) {
      ProjectName parent = ProjectName.of("[PROJECT]");
      DeviceSession deviceSession = DeviceSession.newBuilder().build();
      String deviceSessionId = "deviceSessionId-544276325";
      DeviceSession response =
          directAccessServiceClient.createDeviceSession(parent, deviceSession, deviceSessionId);
    }
  }
}
// [END devicestreaming_v1_generated_DirectAccessService_CreateDeviceSession_ProjectnameDevicesessionString_sync]

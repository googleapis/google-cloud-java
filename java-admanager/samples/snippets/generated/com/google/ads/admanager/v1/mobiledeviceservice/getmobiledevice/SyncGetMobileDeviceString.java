/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_MobileDeviceService_GetMobileDevice_String_sync]
import com.google.ads.admanager.v1.MobileDevice;
import com.google.ads.admanager.v1.MobileDeviceName;
import com.google.ads.admanager.v1.MobileDeviceServiceClient;

public class SyncGetMobileDeviceString {

  public static void main(String[] args) throws Exception {
    syncGetMobileDeviceString();
  }

  public static void syncGetMobileDeviceString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MobileDeviceServiceClient mobileDeviceServiceClient = MobileDeviceServiceClient.create()) {
      String name = MobileDeviceName.of("[NETWORK_CODE]", "[MOBILE_DEVICE]").toString();
      MobileDevice response = mobileDeviceServiceClient.getMobileDevice(name);
    }
  }
}
// [END admanager_v1_generated_MobileDeviceService_GetMobileDevice_String_sync]

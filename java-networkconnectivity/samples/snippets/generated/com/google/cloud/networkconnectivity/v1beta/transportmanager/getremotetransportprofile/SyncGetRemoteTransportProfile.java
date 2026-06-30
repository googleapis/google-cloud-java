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

package com.google.cloud.networkconnectivity.v1beta.samples;

// [START networkconnectivity_v1beta_generated_TransportManager_GetRemoteTransportProfile_sync]
import com.google.cloud.networkconnectivity.v1beta.GetRemoteTransportProfileRequest;
import com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfile;
import com.google.cloud.networkconnectivity.v1beta.RemoteTransportProfileName;
import com.google.cloud.networkconnectivity.v1beta.TransportManagerClient;

public class SyncGetRemoteTransportProfile {

  public static void main(String[] args) throws Exception {
    syncGetRemoteTransportProfile();
  }

  public static void syncGetRemoteTransportProfile() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TransportManagerClient transportManagerClient = TransportManagerClient.create()) {
      GetRemoteTransportProfileRequest request =
          GetRemoteTransportProfileRequest.newBuilder()
              .setName(
                  RemoteTransportProfileName.of(
                          "[PROJECT]", "[LOCATION]", "[REMOTE_TRANSPORT_PROFILE]")
                      .toString())
              .build();
      RemoteTransportProfile response = transportManagerClient.getRemoteTransportProfile(request);
    }
  }
}
// [END networkconnectivity_v1beta_generated_TransportManager_GetRemoteTransportProfile_sync]

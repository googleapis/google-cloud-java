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

package com.google.apps.meet.v2beta.samples;

// [START meet_v2beta_generated_SpacesService_ConnectActiveConference_sync]
import com.google.apps.meet.v2beta.ConnectActiveConferenceRequest;
import com.google.apps.meet.v2beta.ConnectActiveConferenceResponse;
import com.google.apps.meet.v2beta.SpaceName;
import com.google.apps.meet.v2beta.SpacesServiceClient;

public class SyncConnectActiveConference {

  public static void main(String[] args) throws Exception {
    syncConnectActiveConference();
  }

  public static void syncConnectActiveConference() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SpacesServiceClient spacesServiceClient = SpacesServiceClient.create()) {
      ConnectActiveConferenceRequest request =
          ConnectActiveConferenceRequest.newBuilder()
              .setName(SpaceName.of("[SPACE]").toString())
              .setOffer("offer105650780")
              .build();
      ConnectActiveConferenceResponse response =
          spacesServiceClient.connectActiveConference(request);
    }
  }
}
// [END meet_v2beta_generated_SpacesService_ConnectActiveConference_sync]

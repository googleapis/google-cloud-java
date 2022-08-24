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

package com.google.cloud.servicedirectory.v1beta1.samples;

// [START servicedirectory_v1beta1_generated_registrationserviceclient_updateendpoint_sync]
import com.google.cloud.servicedirectory.v1beta1.Endpoint;
import com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient;
import com.google.cloud.servicedirectory.v1beta1.UpdateEndpointRequest;
import com.google.protobuf.FieldMask;

public class SyncUpdateEndpoint {

  public static void main(String[] args) throws Exception {
    syncUpdateEndpoint();
  }

  public static void syncUpdateEndpoint() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (RegistrationServiceClient registrationServiceClient = RegistrationServiceClient.create()) {
      UpdateEndpointRequest request =
          UpdateEndpointRequest.newBuilder()
              .setEndpoint(Endpoint.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      Endpoint response = registrationServiceClient.updateEndpoint(request);
    }
  }
}
// [END servicedirectory_v1beta1_generated_registrationserviceclient_updateendpoint_sync]

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

package com.google.cloud.networksecurity.v1.samples;

// [START networksecurity_v1_generated_Mirroring_DeleteMirroringEndpointGroup_sync]
import com.google.cloud.networksecurity.v1.DeleteMirroringEndpointGroupRequest;
import com.google.cloud.networksecurity.v1.MirroringClient;
import com.google.cloud.networksecurity.v1.MirroringEndpointGroupName;
import com.google.protobuf.Empty;

public class SyncDeleteMirroringEndpointGroup {

  public static void main(String[] args) throws Exception {
    syncDeleteMirroringEndpointGroup();
  }

  public static void syncDeleteMirroringEndpointGroup() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (MirroringClient mirroringClient = MirroringClient.create()) {
      DeleteMirroringEndpointGroupRequest request =
          DeleteMirroringEndpointGroupRequest.newBuilder()
              .setName(
                  MirroringEndpointGroupName.of(
                          "[PROJECT]", "[LOCATION]", "[MIRRORING_ENDPOINT_GROUP]")
                      .toString())
              .setRequestId("requestId693933066")
              .build();
      mirroringClient.deleteMirroringEndpointGroupAsync(request).get();
    }
  }
}
// [END networksecurity_v1_generated_Mirroring_DeleteMirroringEndpointGroup_sync]

/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.compute.v1.samples;

// [START compute_v1_generated_StoragePools_TestIamPermissions_StringStringStringTestpermissionsrequest_sync]
import com.google.cloud.compute.v1.StoragePoolsClient;
import com.google.cloud.compute.v1.TestPermissionsRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;

public class SyncTestIamPermissionsStringStringStringTestpermissionsrequest {

  public static void main(String[] args) throws Exception {
    syncTestIamPermissionsStringStringStringTestpermissionsrequest();
  }

  public static void syncTestIamPermissionsStringStringStringTestpermissionsrequest()
      throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StoragePoolsClient storagePoolsClient = StoragePoolsClient.create()) {
      String project = "project-309310695";
      String zone = "zone3744684";
      String resource = "resource-341064690";
      TestPermissionsRequest testPermissionsRequestResource =
          TestPermissionsRequest.newBuilder().build();
      TestPermissionsResponse response =
          storagePoolsClient.testIamPermissions(
              project, zone, resource, testPermissionsRequestResource);
    }
  }
}
// [END compute_v1_generated_StoragePools_TestIamPermissions_StringStringStringTestpermissionsrequest_sync]

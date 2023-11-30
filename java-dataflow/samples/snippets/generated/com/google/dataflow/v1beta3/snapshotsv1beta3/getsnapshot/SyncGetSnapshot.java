/*
 * Copyright 2023 Google LLC
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

package com.google.dataflow.v1beta3.samples;

// [START dataflow_v1beta3_generated_SnapshotsV1Beta3_GetSnapshot_sync]
import com.google.dataflow.v1beta3.GetSnapshotRequest;
import com.google.dataflow.v1beta3.Snapshot;
import com.google.dataflow.v1beta3.SnapshotsV1Beta3Client;

public class SyncGetSnapshot {

  public static void main(String[] args) throws Exception {
    syncGetSnapshot();
  }

  public static void syncGetSnapshot() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SnapshotsV1Beta3Client snapshotsV1Beta3Client = SnapshotsV1Beta3Client.create()) {
      GetSnapshotRequest request =
          GetSnapshotRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setSnapshotId("snapshotId-1113817601")
              .setLocation("location1901043637")
              .build();
      Snapshot response = snapshotsV1Beta3Client.getSnapshot(request);
    }
  }
}
// [END dataflow_v1beta3_generated_SnapshotsV1Beta3_GetSnapshot_sync]

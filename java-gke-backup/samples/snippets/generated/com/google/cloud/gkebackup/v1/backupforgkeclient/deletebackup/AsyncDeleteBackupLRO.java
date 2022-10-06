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

package com.google.cloud.gkebackup.v1.samples;

// [START gkebackup_v1_generated_backupforgkeclient_deletebackup_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gkebackup.v1.BackupForGKEClient;
import com.google.cloud.gkebackup.v1.BackupName;
import com.google.cloud.gkebackup.v1.DeleteBackupRequest;
import com.google.cloud.gkebackup.v1.OperationMetadata;
import com.google.protobuf.Empty;

public class AsyncDeleteBackupLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteBackupLRO();
  }

  public static void asyncDeleteBackupLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
      DeleteBackupRequest request =
          DeleteBackupRequest.newBuilder()
              .setName(
                  BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
              .setEtag("etag3123477")
              .setForce(true)
              .build();
      OperationFuture<Empty, OperationMetadata> future =
          backupForGKEClient.deleteBackupOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END gkebackup_v1_generated_backupforgkeclient_deletebackup_lro_async]

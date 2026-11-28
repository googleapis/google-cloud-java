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

package com.google.cloud.secretmanager.v1.samples;

// [START secretmanager_v1_generated_SecretOperationsService_RestoreBackup_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.secretmanager.v1.BackupName;
import com.google.cloud.secretmanager.v1.CryptoKeyName;
import com.google.cloud.secretmanager.v1.ProjectName;
import com.google.cloud.secretmanager.v1.RestoreBackupRequest;
import com.google.cloud.secretmanager.v1.SecretOperationsServiceClient;
import com.google.longrunning.Operation;

public class AsyncRestoreBackup {

  public static void main(String[] args) throws Exception {
    asyncRestoreBackup();
  }

  public static void asyncRestoreBackup() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SecretOperationsServiceClient secretOperationsServiceClient =
        SecretOperationsServiceClient.create()) {
      RestoreBackupRequest request =
          RestoreBackupRequest.newBuilder()
              .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
              .setDestinationSecretParent(ProjectName.of("[PROJECT]").toString())
              .setDestinationSecretId("destinationSecretId171779609")
              .setKmsKeyName(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .build();
      ApiFuture<Operation> future =
          secretOperationsServiceClient.restoreBackupCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END secretmanager_v1_generated_SecretOperationsService_RestoreBackup_async]

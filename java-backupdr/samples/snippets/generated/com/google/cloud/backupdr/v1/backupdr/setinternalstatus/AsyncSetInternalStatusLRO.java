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

package com.google.cloud.backupdr.v1.samples;

// [START backupdr_v1_generated_BackupDR_SetInternalStatus_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.backupdr.v1.BackupConfigState;
import com.google.cloud.backupdr.v1.BackupDRClient;
import com.google.cloud.backupdr.v1.DataSourceName;
import com.google.cloud.backupdr.v1.OperationMetadata;
import com.google.cloud.backupdr.v1.SetInternalStatusRequest;
import com.google.cloud.backupdr.v1.SetInternalStatusResponse;
import com.google.protobuf.ByteString;

public class AsyncSetInternalStatusLRO {

  public static void main(String[] args) throws Exception {
    asyncSetInternalStatusLRO();
  }

  public static void asyncSetInternalStatusLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BackupDRClient backupDRClient = BackupDRClient.create()) {
      SetInternalStatusRequest request =
          SetInternalStatusRequest.newBuilder()
              .setDataSource(
                  DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
                      .toString())
              .setValue(ByteString.EMPTY)
              .setBackupConfigState(BackupConfigState.forNumber(0))
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<SetInternalStatusResponse, OperationMetadata> future =
          backupDRClient.setInternalStatusOperationCallable().futureCall(request);
      // Do something.
      SetInternalStatusResponse response = future.get();
    }
  }
}
// [END backupdr_v1_generated_BackupDR_SetInternalStatus_LRO_async]

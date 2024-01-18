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

package com.google.storagetransfer.v1.proto.samples;

// [START storagetransfer_v1_generated_StorageTransferService_CreateTransferJob_async]
import com.google.api.core.ApiFuture;
import com.google.storagetransfer.v1.proto.StorageTransferServiceClient;
import com.google.storagetransfer.v1.proto.TransferProto;
import com.google.storagetransfer.v1.proto.TransferTypes;

public class AsyncCreateTransferJob {

  public static void main(String[] args) throws Exception {
    asyncCreateTransferJob();
  }

  public static void asyncCreateTransferJob() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (StorageTransferServiceClient storageTransferServiceClient =
        StorageTransferServiceClient.create()) {
      TransferProto.CreateTransferJobRequest request =
          TransferProto.CreateTransferJobRequest.newBuilder()
              .setTransferJob(TransferTypes.TransferJob.newBuilder().build())
              .build();
      ApiFuture<TransferTypes.TransferJob> future =
          storageTransferServiceClient.createTransferJobCallable().futureCall(request);
      // Do something.
      TransferTypes.TransferJob response = future.get();
    }
  }
}
// [END storagetransfer_v1_generated_StorageTransferService_CreateTransferJob_async]

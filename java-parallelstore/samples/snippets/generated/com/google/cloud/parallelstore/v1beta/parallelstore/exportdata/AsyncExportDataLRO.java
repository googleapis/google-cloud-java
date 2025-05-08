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

package com.google.cloud.parallelstore.v1beta.samples;

// [START parallelstore_v1beta_generated_Parallelstore_ExportData_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.parallelstore.v1beta.ExportDataMetadata;
import com.google.cloud.parallelstore.v1beta.ExportDataRequest;
import com.google.cloud.parallelstore.v1beta.ExportDataResponse;
import com.google.cloud.parallelstore.v1beta.InstanceName;
import com.google.cloud.parallelstore.v1beta.ParallelstoreClient;
import com.google.cloud.parallelstore.v1beta.ServiceAccountName;
import com.google.cloud.parallelstore.v1beta.TransferMetadataOptions;

public class AsyncExportDataLRO {

  public static void main(String[] args) throws Exception {
    asyncExportDataLRO();
  }

  public static void asyncExportDataLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ParallelstoreClient parallelstoreClient = ParallelstoreClient.create()) {
      ExportDataRequest request =
          ExportDataRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .setRequestId("requestId693933066")
              .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
              .setMetadataOptions(TransferMetadataOptions.newBuilder().build())
              .build();
      OperationFuture<ExportDataResponse, ExportDataMetadata> future =
          parallelstoreClient.exportDataOperationCallable().futureCall(request);
      // Do something.
      ExportDataResponse response = future.get();
    }
  }
}
// [END parallelstore_v1beta_generated_Parallelstore_ExportData_LRO_async]

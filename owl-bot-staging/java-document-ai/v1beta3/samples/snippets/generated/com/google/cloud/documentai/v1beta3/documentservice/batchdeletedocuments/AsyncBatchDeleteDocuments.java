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

package com.google.cloud.documentai.v1beta3.samples;

// [START documentai_v1beta3_generated_DocumentService_BatchDeleteDocuments_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.documentai.v1beta3.BatchDatasetDocuments;
import com.google.cloud.documentai.v1beta3.BatchDeleteDocumentsRequest;
import com.google.cloud.documentai.v1beta3.DocumentServiceClient;
import com.google.longrunning.Operation;

public class AsyncBatchDeleteDocuments {

  public static void main(String[] args) throws Exception {
    asyncBatchDeleteDocuments();
  }

  public static void asyncBatchDeleteDocuments() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentServiceClient documentServiceClient = DocumentServiceClient.create()) {
      BatchDeleteDocumentsRequest request =
          BatchDeleteDocumentsRequest.newBuilder()
              .setDataset("dataset1443214456")
              .setDatasetDocuments(BatchDatasetDocuments.newBuilder().build())
              .build();
      ApiFuture<Operation> future =
          documentServiceClient.batchDeleteDocumentsCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END documentai_v1beta3_generated_DocumentService_BatchDeleteDocuments_async]

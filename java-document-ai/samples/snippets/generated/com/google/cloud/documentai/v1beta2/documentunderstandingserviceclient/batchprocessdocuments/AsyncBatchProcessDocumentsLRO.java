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

package com.google.cloud.documentai.v1beta2.samples;

// [START documentai_v1beta2_generated_documentunderstandingserviceclient_batchprocessdocuments_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsRequest;
import com.google.cloud.documentai.v1beta2.BatchProcessDocumentsResponse;
import com.google.cloud.documentai.v1beta2.DocumentUnderstandingServiceClient;
import com.google.cloud.documentai.v1beta2.OperationMetadata;
import com.google.cloud.documentai.v1beta2.ProcessDocumentRequest;
import java.util.ArrayList;

public class AsyncBatchProcessDocumentsLRO {

  public static void main(String[] args) throws Exception {
    asyncBatchProcessDocumentsLRO();
  }

  public static void asyncBatchProcessDocumentsLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentUnderstandingServiceClient documentUnderstandingServiceClient =
        DocumentUnderstandingServiceClient.create()) {
      BatchProcessDocumentsRequest request =
          BatchProcessDocumentsRequest.newBuilder()
              .addAllRequests(new ArrayList<ProcessDocumentRequest>())
              .setParent("parent-995424086")
              .build();
      OperationFuture<BatchProcessDocumentsResponse, OperationMetadata> future =
          documentUnderstandingServiceClient
              .batchProcessDocumentsOperationCallable()
              .futureCall(request);
      // Do something.
      BatchProcessDocumentsResponse response = future.get();
    }
  }
}
// [END documentai_v1beta2_generated_documentunderstandingserviceclient_batchprocessdocuments_lro_async]

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

package com.google.cloud.documentai.v1beta3.samples;

// [START documentai_v1beta3_generated_DocumentProcessorService_DisableProcessor_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.documentai.v1beta3.DisableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DisableProcessorRequest;
import com.google.cloud.documentai.v1beta3.DisableProcessorResponse;
import com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1beta3.ProcessorName;

public class AsyncDisableProcessorLRO {

  public static void main(String[] args) throws Exception {
    asyncDisableProcessorLRO();
  }

  public static void asyncDisableProcessorLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentProcessorServiceClient documentProcessorServiceClient =
        DocumentProcessorServiceClient.create()) {
      DisableProcessorRequest request =
          DisableProcessorRequest.newBuilder()
              .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
              .build();
      OperationFuture<DisableProcessorResponse, DisableProcessorMetadata> future =
          documentProcessorServiceClient.disableProcessorOperationCallable().futureCall(request);
      // Do something.
      DisableProcessorResponse response = future.get();
    }
  }
}
// [END documentai_v1beta3_generated_DocumentProcessorService_DisableProcessor_LRO_async]

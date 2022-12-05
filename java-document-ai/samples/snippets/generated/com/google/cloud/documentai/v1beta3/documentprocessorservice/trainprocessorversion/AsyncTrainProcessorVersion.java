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

// [START documentai_v1beta3_generated_DocumentProcessorService_TrainProcessorVersion_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1beta3.DocumentSchema;
import com.google.cloud.documentai.v1beta3.ProcessorName;
import com.google.cloud.documentai.v1beta3.ProcessorVersion;
import com.google.cloud.documentai.v1beta3.TrainProcessorVersionRequest;
import com.google.longrunning.Operation;

public class AsyncTrainProcessorVersion {

  public static void main(String[] args) throws Exception {
    asyncTrainProcessorVersion();
  }

  public static void asyncTrainProcessorVersion() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentProcessorServiceClient documentProcessorServiceClient =
        DocumentProcessorServiceClient.create()) {
      TrainProcessorVersionRequest request =
          TrainProcessorVersionRequest.newBuilder()
              .setParent(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
              .setProcessorVersion(ProcessorVersion.newBuilder().build())
              .setDocumentSchema(DocumentSchema.newBuilder().build())
              .setInputData(TrainProcessorVersionRequest.InputData.newBuilder().build())
              .setBaseProcessorVersion("baseProcessorVersion337709271")
              .build();
      ApiFuture<Operation> future =
          documentProcessorServiceClient.trainProcessorVersionCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END documentai_v1beta3_generated_DocumentProcessorService_TrainProcessorVersion_async]

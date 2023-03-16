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

package com.google.cloud.documentai.v1.samples;

// [START documentai_v1_generated_DocumentProcessorService_GetProcessorVersion_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.documentai.v1.DocumentProcessorServiceClient;
import com.google.cloud.documentai.v1.GetProcessorVersionRequest;
import com.google.cloud.documentai.v1.ProcessorVersion;
import com.google.cloud.documentai.v1.ProcessorVersionName;

public class AsyncGetProcessorVersion {

  public static void main(String[] args) throws Exception {
    asyncGetProcessorVersion();
  }

  public static void asyncGetProcessorVersion() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DocumentProcessorServiceClient documentProcessorServiceClient =
        DocumentProcessorServiceClient.create()) {
      GetProcessorVersionRequest request =
          GetProcessorVersionRequest.newBuilder()
              .setName(
                  ProcessorVersionName.of(
                          "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                      .toString())
              .build();
      ApiFuture<ProcessorVersion> future =
          documentProcessorServiceClient.getProcessorVersionCallable().futureCall(request);
      // Do something.
      ProcessorVersion response = future.get();
    }
  }
}
// [END documentai_v1_generated_DocumentProcessorService_GetProcessorVersion_async]

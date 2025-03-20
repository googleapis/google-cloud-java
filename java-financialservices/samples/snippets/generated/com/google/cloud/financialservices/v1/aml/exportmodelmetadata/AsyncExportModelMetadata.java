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

package com.google.cloud.financialservices.v1.samples;

// [START financialservices_v1_generated_AML_ExportModelMetadata_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.financialservices.v1.AMLClient;
import com.google.cloud.financialservices.v1.BigQueryDestination;
import com.google.cloud.financialservices.v1.ExportModelMetadataRequest;
import com.google.cloud.financialservices.v1.ModelName;
import com.google.longrunning.Operation;

public class AsyncExportModelMetadata {

  public static void main(String[] args) throws Exception {
    asyncExportModelMetadata();
  }

  public static void asyncExportModelMetadata() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AMLClient aMLClient = AMLClient.create()) {
      ExportModelMetadataRequest request =
          ExportModelMetadataRequest.newBuilder()
              .setModel(
                  ModelName.of("[PROJECT_NUM]", "[LOCATION]", "[INSTANCE]", "[MODEL]").toString())
              .setStructuredMetadataDestination(BigQueryDestination.newBuilder().build())
              .build();
      ApiFuture<Operation> future = aMLClient.exportModelMetadataCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END financialservices_v1_generated_AML_ExportModelMetadata_async]

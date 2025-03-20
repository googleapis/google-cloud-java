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

// [START financialservices_v1_generated_AML_ExportRegisteredParties_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.financialservices.v1.AMLClient;
import com.google.cloud.financialservices.v1.BigQueryDestination;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.InstanceName;
import com.google.cloud.financialservices.v1.LineOfBusiness;
import com.google.cloud.financialservices.v1.OperationMetadata;

public class AsyncExportRegisteredPartiesLRO {

  public static void main(String[] args) throws Exception {
    asyncExportRegisteredPartiesLRO();
  }

  public static void asyncExportRegisteredPartiesLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AMLClient aMLClient = AMLClient.create()) {
      ExportRegisteredPartiesRequest request =
          ExportRegisteredPartiesRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .setDataset(BigQueryDestination.newBuilder().build())
              .setLineOfBusiness(LineOfBusiness.forNumber(0))
              .build();
      OperationFuture<ExportRegisteredPartiesResponse, OperationMetadata> future =
          aMLClient.exportRegisteredPartiesOperationCallable().futureCall(request);
      // Do something.
      ExportRegisteredPartiesResponse response = future.get();
    }
  }
}
// [END financialservices_v1_generated_AML_ExportRegisteredParties_LRO_async]

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

// [START financialservices_v1_generated_AML_ImportRegisteredParties_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.financialservices.v1.AMLClient;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.InstanceName;
import com.google.cloud.financialservices.v1.LineOfBusiness;
import com.google.cloud.financialservices.v1.OperationMetadata;
import java.util.ArrayList;

public class AsyncImportRegisteredPartiesLRO {

  public static void main(String[] args) throws Exception {
    asyncImportRegisteredPartiesLRO();
  }

  public static void asyncImportRegisteredPartiesLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AMLClient aMLClient = AMLClient.create()) {
      ImportRegisteredPartiesRequest request =
          ImportRegisteredPartiesRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .addAllPartyTables(new ArrayList<String>())
              .setValidateOnly(true)
              .setLineOfBusiness(LineOfBusiness.forNumber(0))
              .build();
      OperationFuture<ImportRegisteredPartiesResponse, OperationMetadata> future =
          aMLClient.importRegisteredPartiesOperationCallable().futureCall(request);
      // Do something.
      ImportRegisteredPartiesResponse response = future.get();
    }
  }
}
// [END financialservices_v1_generated_AML_ImportRegisteredParties_LRO_async]

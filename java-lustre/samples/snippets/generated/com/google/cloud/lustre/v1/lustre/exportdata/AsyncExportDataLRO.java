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

package com.google.cloud.lustre.v1.samples;

// [START lustre_v1_generated_Lustre_ExportData_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.lustre.v1.ExportDataMetadata;
import com.google.cloud.lustre.v1.ExportDataRequest;
import com.google.cloud.lustre.v1.ExportDataResponse;
import com.google.cloud.lustre.v1.InstanceName;
import com.google.cloud.lustre.v1.LustreClient;
import com.google.cloud.lustre.v1.ServiceAccountName;

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
    try (LustreClient lustreClient = LustreClient.create()) {
      ExportDataRequest request =
          ExportDataRequest.newBuilder()
              .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
              .setRequestId("requestId693933066")
              .setServiceAccount(ServiceAccountName.of("[PROJECT]", "[SERVICE_ACCOUNT]").toString())
              .build();
      OperationFuture<ExportDataResponse, ExportDataMetadata> future =
          lustreClient.exportDataOperationCallable().futureCall(request);
      // Do something.
      ExportDataResponse response = future.get();
    }
  }
}
// [END lustre_v1_generated_Lustre_ExportData_LRO_async]

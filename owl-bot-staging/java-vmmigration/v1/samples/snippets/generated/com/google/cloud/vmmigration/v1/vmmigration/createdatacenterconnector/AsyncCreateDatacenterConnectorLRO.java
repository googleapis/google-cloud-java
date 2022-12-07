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

package com.google.cloud.vmmigration.v1.samples;

// [START vmmigration_v1_generated_VmMigration_CreateDatacenterConnector_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.DatacenterConnector;
import com.google.cloud.vmmigration.v1.OperationMetadata;
import com.google.cloud.vmmigration.v1.SourceName;
import com.google.cloud.vmmigration.v1.VmMigrationClient;

public class AsyncCreateDatacenterConnectorLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateDatacenterConnectorLRO();
  }

  public static void asyncCreateDatacenterConnectorLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (VmMigrationClient vmMigrationClient = VmMigrationClient.create()) {
      CreateDatacenterConnectorRequest request =
          CreateDatacenterConnectorRequest.newBuilder()
              .setParent(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
              .setDatacenterConnectorId("datacenterConnectorId-761889719")
              .setDatacenterConnector(DatacenterConnector.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<DatacenterConnector, OperationMetadata> future =
          vmMigrationClient.createDatacenterConnectorOperationCallable().futureCall(request);
      // Do something.
      DatacenterConnector response = future.get();
    }
  }
}
// [END vmmigration_v1_generated_VmMigration_CreateDatacenterConnector_LRO_async]

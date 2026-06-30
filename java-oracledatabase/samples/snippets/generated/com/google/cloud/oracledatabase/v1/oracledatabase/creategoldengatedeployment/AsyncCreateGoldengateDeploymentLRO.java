/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.oracledatabase.v1.samples;

// [START oracledatabase_v1_generated_OracleDatabase_CreateGoldengateDeployment_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.oracledatabase.v1.CreateGoldengateDeploymentRequest;
import com.google.cloud.oracledatabase.v1.GoldengateDeployment;
import com.google.cloud.oracledatabase.v1.LocationName;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.OracleDatabaseClient;

public class AsyncCreateGoldengateDeploymentLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateGoldengateDeploymentLRO();
  }

  public static void asyncCreateGoldengateDeploymentLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
      CreateGoldengateDeploymentRequest request =
          CreateGoldengateDeploymentRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setGoldengateDeploymentId("goldengateDeploymentId489140788")
              .setGoldengateDeployment(GoldengateDeployment.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<GoldengateDeployment, OperationMetadata> future =
          oracleDatabaseClient.createGoldengateDeploymentOperationCallable().futureCall(request);
      // Do something.
      GoldengateDeployment response = future.get();
    }
  }
}
// [END oracledatabase_v1_generated_OracleDatabase_CreateGoldengateDeployment_LRO_async]

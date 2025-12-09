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

package com.google.cloud.oracledatabase.v1.samples;

// [START oracledatabase_v1_generated_OracleDatabase_CreateOdbNetwork_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.oracledatabase.v1.CreateOdbNetworkRequest;
import com.google.cloud.oracledatabase.v1.LocationName;
import com.google.cloud.oracledatabase.v1.OdbNetwork;
import com.google.cloud.oracledatabase.v1.OperationMetadata;
import com.google.cloud.oracledatabase.v1.OracleDatabaseClient;

public class AsyncCreateOdbNetworkLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateOdbNetworkLRO();
  }

  public static void asyncCreateOdbNetworkLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
      CreateOdbNetworkRequest request =
          CreateOdbNetworkRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setOdbNetworkId("odbNetworkId-169900740")
              .setOdbNetwork(OdbNetwork.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<OdbNetwork, OperationMetadata> future =
          oracleDatabaseClient.createOdbNetworkOperationCallable().futureCall(request);
      // Do something.
      OdbNetwork response = future.get();
    }
  }
}
// [END oracledatabase_v1_generated_OracleDatabase_CreateOdbNetwork_LRO_async]

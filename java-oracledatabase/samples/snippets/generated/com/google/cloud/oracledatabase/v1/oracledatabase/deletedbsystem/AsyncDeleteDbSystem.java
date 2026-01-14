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

// [START oracledatabase_v1_generated_OracleDatabase_DeleteDbSystem_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.oracledatabase.v1.DbSystemName;
import com.google.cloud.oracledatabase.v1.DeleteDbSystemRequest;
import com.google.cloud.oracledatabase.v1.OracleDatabaseClient;
import com.google.longrunning.Operation;

public class AsyncDeleteDbSystem {

  public static void main(String[] args) throws Exception {
    asyncDeleteDbSystem();
  }

  public static void asyncDeleteDbSystem() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
      DeleteDbSystemRequest request =
          DeleteDbSystemRequest.newBuilder()
              .setName(DbSystemName.of("[PROJECT]", "[LOCATION]", "[DB_SYSTEM]").toString())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Operation> future =
          oracleDatabaseClient.deleteDbSystemCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END oracledatabase_v1_generated_OracleDatabase_DeleteDbSystem_async]

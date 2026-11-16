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

// [START oracledatabase_v1_generated_OracleDatabase_ExecuteSql_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.oracledatabase.v1.DatabaseConnectionName;
import com.google.cloud.oracledatabase.v1.ExecuteSqlRequest;
import com.google.cloud.oracledatabase.v1.ExecuteSqlResponse;
import com.google.cloud.oracledatabase.v1.OracleDatabaseClient;
import com.google.cloud.oracledatabase.v1.SqlParameter;
import java.util.ArrayList;

public class AsyncExecuteSql {

  public static void main(String[] args) throws Exception {
    asyncExecuteSql();
  }

  public static void asyncExecuteSql() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (OracleDatabaseClient oracleDatabaseClient = OracleDatabaseClient.create()) {
      ExecuteSqlRequest request =
          ExecuteSqlRequest.newBuilder()
              .setName(
                  DatabaseConnectionName.of("[PROJECT]", "[LOCATION]", "[DATABASE_CONNECTION]")
                      .toString())
              .setSqlStatement("sqlStatement937767745")
              .addAllParams(new ArrayList<SqlParameter>())
              .build();
      ApiFuture<ExecuteSqlResponse> future =
          oracleDatabaseClient.executeSqlCallable().futureCall(request);
      // Do something.
      ExecuteSqlResponse response = future.get();
    }
  }
}
// [END oracledatabase_v1_generated_OracleDatabase_ExecuteSql_async]

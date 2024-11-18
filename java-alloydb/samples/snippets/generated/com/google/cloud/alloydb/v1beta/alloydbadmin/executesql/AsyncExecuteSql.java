/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.alloydb.v1beta.samples;

// [START alloydb_v1beta_generated_AlloyDBAdmin_ExecuteSql_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.alloydb.v1beta.AlloyDBAdminClient;
import com.google.cloud.alloydb.v1beta.ExecuteSqlRequest;
import com.google.cloud.alloydb.v1beta.ExecuteSqlResponse;
import com.google.cloud.alloydb.v1beta.InstanceName;

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
    try (AlloyDBAdminClient alloyDBAdminClient = AlloyDBAdminClient.create()) {
      ExecuteSqlRequest request =
          ExecuteSqlRequest.newBuilder()
              .setInstance(
                  InstanceName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]", "[INSTANCE]").toString())
              .setDatabase("database1789464955")
              .setUser("user3599307")
              .setSqlStatement("sqlStatement937767745")
              .build();
      ApiFuture<ExecuteSqlResponse> future =
          alloyDBAdminClient.executeSqlCallable().futureCall(request);
      // Do something.
      ExecuteSqlResponse response = future.get();
    }
  }
}
// [END alloydb_v1beta_generated_AlloyDBAdmin_ExecuteSql_async]

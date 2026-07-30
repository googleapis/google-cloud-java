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

package com.google.cloud.sql.v1beta4.samples;

// [START sqladmin_v1beta4_generated_SqlDatabasesService_Delete_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.sql.v1beta4.Operation;
import com.google.cloud.sql.v1beta4.SqlDatabasesDeleteRequest;
import com.google.cloud.sql.v1beta4.SqlDatabasesServiceClient;

public class AsyncDelete {

  public static void main(String[] args) throws Exception {
    asyncDelete();
  }

  public static void asyncDelete() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SqlDatabasesServiceClient sqlDatabasesServiceClient = SqlDatabasesServiceClient.create()) {
      SqlDatabasesDeleteRequest request =
          SqlDatabasesDeleteRequest.newBuilder()
              .setDatabase("database1789464955")
              .setInstance("instance555127957")
              .setProject("project-309310695")
              .build();
      ApiFuture<Operation> future = sqlDatabasesServiceClient.deleteCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END sqladmin_v1beta4_generated_SqlDatabasesService_Delete_async]

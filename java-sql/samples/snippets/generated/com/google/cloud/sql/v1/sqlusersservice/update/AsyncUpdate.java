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

package com.google.cloud.sql.v1.samples;

// [START sqladmin_v1_generated_SqlUsersService_Update_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.sql.v1.Operation;
import com.google.cloud.sql.v1.SqlUsersServiceClient;
import com.google.cloud.sql.v1.SqlUsersUpdateRequest;
import com.google.cloud.sql.v1.User;
import java.util.ArrayList;

public class AsyncUpdate {

  public static void main(String[] args) throws Exception {
    asyncUpdate();
  }

  public static void asyncUpdate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SqlUsersServiceClient sqlUsersServiceClient = SqlUsersServiceClient.create()) {
      SqlUsersUpdateRequest request =
          SqlUsersUpdateRequest.newBuilder()
              .setHost("host3208616")
              .setInstance("instance555127957")
              .setName("name3373707")
              .setProject("project-309310695")
              .addAllDatabaseRoles(new ArrayList<String>())
              .setRevokeExistingRoles(true)
              .addAllServerRoles(new ArrayList<String>())
              .setRevokeExistingServerRoles(true)
              .setBody(User.newBuilder().build())
              .build();
      ApiFuture<Operation> future = sqlUsersServiceClient.updateCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END sqladmin_v1_generated_SqlUsersService_Update_async]

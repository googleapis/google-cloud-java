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

// [START sqladmin_v1beta4_generated_SqlFlagsService_List_sync]
import com.google.cloud.sql.v1beta4.FlagsListResponse;
import com.google.cloud.sql.v1beta4.SqlFlagScope;
import com.google.cloud.sql.v1beta4.SqlFlagsListRequest;
import com.google.cloud.sql.v1beta4.SqlFlagsServiceClient;

public class SyncList {

  public static void main(String[] args) throws Exception {
    syncList();
  }

  public static void syncList() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SqlFlagsServiceClient sqlFlagsServiceClient = SqlFlagsServiceClient.create()) {
      SqlFlagsListRequest request =
          SqlFlagsListRequest.newBuilder()
              .setDatabaseVersion("databaseVersion1250955997")
              .setFlagScope(SqlFlagScope.forNumber(0))
              .build();
      FlagsListResponse response = sqlFlagsServiceClient.list(request);
    }
  }
}
// [END sqladmin_v1beta4_generated_SqlFlagsService_List_sync]

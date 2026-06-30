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

package com.google.cloud.biglake.hive.v1beta.samples;

// [START biglake_v1beta_generated_HiveMetastoreService_ListHiveTables_Paged_async]
import com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient;
import com.google.cloud.biglake.hive.v1beta.HiveTable;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse;
import com.google.cloud.biglake.hive.v1beta.NamespaceName;
import com.google.common.base.Strings;

public class AsyncListHiveTablesPaged {

  public static void main(String[] args) throws Exception {
    asyncListHiveTablesPaged();
  }

  public static void asyncListHiveTablesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
        HiveMetastoreServiceClient.create()) {
      ListHiveTablesRequest request =
          ListHiveTablesRequest.newBuilder()
              .setParent(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListHiveTablesResponse response =
            hiveMetastoreServiceClient.listHiveTablesCallable().call(request);
        for (HiveTable element : response.getTablesList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END biglake_v1beta_generated_HiveMetastoreService_ListHiveTables_Paged_async]

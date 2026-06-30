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

// [START biglake_v1beta_generated_HiveMetastoreService_ListHiveCatalogs_Paged_async]
import com.google.cloud.biglake.hive.v1beta.HiveCatalog;
import com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse;
import com.google.cloud.biglake.hive.v1beta.ProjectName;
import com.google.common.base.Strings;

public class AsyncListHiveCatalogsPaged {

  public static void main(String[] args) throws Exception {
    asyncListHiveCatalogsPaged();
  }

  public static void asyncListHiveCatalogsPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
        HiveMetastoreServiceClient.create()) {
      ListHiveCatalogsRequest request =
          ListHiveCatalogsRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      while (true) {
        ListHiveCatalogsResponse response =
            hiveMetastoreServiceClient.listHiveCatalogsCallable().call(request);
        for (HiveCatalog element : response.getCatalogsList()) {
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
// [END biglake_v1beta_generated_HiveMetastoreService_ListHiveCatalogs_Paged_async]

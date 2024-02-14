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

// [START alloydb_v1beta_generated_AlloyDBAdmin_ListInstances_Paged_async]
import com.google.cloud.alloydb.v1beta.AlloyDBAdminClient;
import com.google.cloud.alloydb.v1beta.ClusterName;
import com.google.cloud.alloydb.v1beta.Instance;
import com.google.cloud.alloydb.v1beta.ListInstancesRequest;
import com.google.cloud.alloydb.v1beta.ListInstancesResponse;
import com.google.common.base.Strings;

public class AsyncListInstancesPaged {

  public static void main(String[] args) throws Exception {
    asyncListInstancesPaged();
  }

  public static void asyncListInstancesPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AlloyDBAdminClient alloyDBAdminClient = AlloyDBAdminClient.create()) {
      ListInstancesRequest request =
          ListInstancesRequest.newBuilder()
              .setParent(ClusterName.of("[PROJECT]", "[LOCATION]", "[CLUSTER]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListInstancesResponse response = alloyDBAdminClient.listInstancesCallable().call(request);
        for (Instance element : response.getInstancesList()) {
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
// [END alloydb_v1beta_generated_AlloyDBAdmin_ListInstances_Paged_async]

/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.gaming.v1beta.samples;

// [START gameservices_v1beta_generated_GameServerClustersService_ListGameServerClusters_Paged_async]
import com.google.cloud.gaming.v1beta.GameServerCluster;
import com.google.cloud.gaming.v1beta.GameServerClustersServiceClient;
import com.google.cloud.gaming.v1beta.ListGameServerClustersRequest;
import com.google.cloud.gaming.v1beta.ListGameServerClustersResponse;
import com.google.cloud.gaming.v1beta.RealmName;
import com.google.common.base.Strings;

public class AsyncListGameServerClustersPaged {

  public static void main(String[] args) throws Exception {
    asyncListGameServerClustersPaged();
  }

  public static void asyncListGameServerClustersPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GameServerClustersServiceClient gameServerClustersServiceClient =
        GameServerClustersServiceClient.create()) {
      ListGameServerClustersRequest request =
          ListGameServerClustersRequest.newBuilder()
              .setParent(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .setOrderBy("orderBy-1207110587")
              .build();
      while (true) {
        ListGameServerClustersResponse response =
            gameServerClustersServiceClient.listGameServerClustersCallable().call(request);
        for (GameServerCluster element : response.getGameServerClustersList()) {
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
// [END gameservices_v1beta_generated_GameServerClustersService_ListGameServerClusters_Paged_async]

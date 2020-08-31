/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.gameservices.clusters;

// [START cloud_game_servers_cluster_list]

import com.google.cloud.gaming.v1.GameServerCluster;
import com.google.cloud.gaming.v1.GameServerClustersServiceClient;
import com.google.cloud.gaming.v1.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;
import com.google.cloud.gaming.v1.ListGameServerClustersRequest;
import com.google.common.base.Strings;
import java.io.IOException;

public class ListClusters {

  public static void listGameServerClusters(String projectId, String regionId, String realmId)
      throws IOException {
    // String projectId = "your-project-id";
    // String regionId = "us-central1-f";
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (GameServerClustersServiceClient client = GameServerClustersServiceClient.create()) {
      String parent =
          String.format("projects/%s/locations/%s/realms/%s", projectId, regionId, realmId);

      ListGameServerClustersPagedResponse response = client.listGameServerClusters(parent);
      for (GameServerCluster cluster : response.iterateAll()) {
        System.out.println("Game Server Cluster found: " + cluster.getName());
      }

      while (!Strings.isNullOrEmpty(response.getNextPageToken())) {
        ListGameServerClustersRequest request =
            ListGameServerClustersRequest.newBuilder()
                .setParent(parent)
                .setPageToken(response.getNextPageToken())
                .build();
        response = client.listGameServerClusters(request);
        for (GameServerCluster cluster : response.iterateAll()) {
          System.out.println("Game Server Cluster found: " + cluster.getName());
        }
      }
    }
  }
}
// [END cloud_game_servers_cluster_list]

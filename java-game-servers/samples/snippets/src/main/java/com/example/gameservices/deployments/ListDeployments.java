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

package com.example.gameservices.deployments;

// [START cloud_game_servers_deployment_list]

import com.google.cloud.gaming.v1.GameServerDeployment;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;
import com.google.cloud.gaming.v1.ListGameServerDeploymentsRequest;
import com.google.common.base.Strings;
import java.io.IOException;

public class ListDeployments {
  public static void listGameServerDeployments(String projectId) throws IOException {
    // String projectId = "your-project-id";
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (GameServerDeploymentsServiceClient client = GameServerDeploymentsServiceClient.create()) {
      String parent = String.format("projects/%s/locations/global", projectId);

      ListGameServerDeploymentsPagedResponse response = client.listGameServerDeployments(parent);
      for (GameServerDeployment deployment : response.iterateAll()) {
        System.out.println("Game Server Deployment found: " + deployment.getName());
      }

      while (!Strings.isNullOrEmpty(response.getNextPageToken())) {
        ListGameServerDeploymentsRequest request =
            ListGameServerDeploymentsRequest.newBuilder()
                .setParent(parent)
                .setPageToken(response.getNextPageToken())
                .build();
        response = client.listGameServerDeployments(request);
        for (GameServerDeployment deployment : response.iterateAll()) {
          System.out.println("Game Server Deployment found: " + deployment.getName());
        }
      }
    }
  }
}
// [END cloud_game_servers_deployment_list]

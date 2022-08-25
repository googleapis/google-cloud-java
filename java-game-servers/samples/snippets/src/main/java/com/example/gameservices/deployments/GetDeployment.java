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

// [START cloud_game_servers_deployment_get]

import com.google.cloud.gaming.v1.GameServerDeployment;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient;
import java.io.IOException;

public class GetDeployment {
  public static void getGameServerDeployment(String projectId, String deploymentId)
      throws IOException {
    // String projectId = "your-project-id";
    // String deploymentId = "your-game-server-deployment-id";
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (GameServerDeploymentsServiceClient client = GameServerDeploymentsServiceClient.create()) {
      String deploymentName =
          String.format(
              "projects/%s/locations/global/gameServerDeployments/%s", projectId, deploymentId);

      GameServerDeployment deployment = client.getGameServerDeployment(deploymentName);

      System.out.println("Game Server Deployment found: " + deployment.getName());
    }
  }
}
// [END cloud_game_servers_deployment_get]

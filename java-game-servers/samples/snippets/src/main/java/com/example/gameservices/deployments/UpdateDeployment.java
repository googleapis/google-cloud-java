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

// [START cloud_game_servers_deployment_update]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gaming.v1.GameServerDeployment;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient;
import com.google.cloud.gaming.v1.OperationMetadata;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateDeployment {
  public static void updateGameServerDeployment(String projectId, String deploymentId)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // String projectId = "your-project-id";
    // String deploymentId = "your-game-server-deployment-id";
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (GameServerDeploymentsServiceClient client = GameServerDeploymentsServiceClient.create()) {
      String deploymentName =
          String.format(
              "projects/%s/locations/global/gameServerDeployments/%s", projectId, deploymentId);

      GameServerDeployment deployment =
          GameServerDeployment.newBuilder()
              .setName(deploymentName)
              .putLabels("key", "value")
              .build();

      FieldMask fieldMask = FieldMask.newBuilder().addPaths("labels").build();

      OperationFuture<GameServerDeployment, OperationMetadata> call =
          client.updateGameServerDeploymentAsync(deployment, fieldMask);

      GameServerDeployment updated = call.get(1, TimeUnit.MINUTES);
      System.out.println("Game Server Deployment updated: " + updated.getName());
    }
  }
}
// [END cloud_game_servers_deployment_update]

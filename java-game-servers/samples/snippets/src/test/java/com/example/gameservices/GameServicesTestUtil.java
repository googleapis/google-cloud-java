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

package com.example.gameservices;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gaming.v1.GameServerCluster;
import com.google.cloud.gaming.v1.GameServerClustersServiceClient;
import com.google.cloud.gaming.v1.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;
import com.google.cloud.gaming.v1.GameServerDeployment;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;
import com.google.cloud.gaming.v1.Realm;
import com.google.cloud.gaming.v1.RealmsServiceClient;
import com.google.cloud.gaming.v1.RealmsServiceClient.ListRealmsPagedResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

class GameServicesTestUtil {
  private static GameServerClustersServiceClient clustersClient;
  private static GameServerDeploymentsServiceClient deploymentsClient;
  private static RealmsServiceClient realmsClient;
  static String UID = UUID.randomUUID().toString().substring(0, 8);

  private static GameServerClustersServiceClient getClustersClient() throws IOException {
    if (clustersClient == null) {
      clustersClient = GameServerClustersServiceClient.create();
    }
    return clustersClient;
  }

  private static GameServerDeploymentsServiceClient getDeploymentsClient() throws IOException {
    if (deploymentsClient == null) {
      deploymentsClient = GameServerDeploymentsServiceClient.create();
    }
    return deploymentsClient;
  }

  private static RealmsServiceClient getRealmsClient() throws IOException {
    if (realmsClient == null) {
      realmsClient = RealmsServiceClient.create();
    }
    return realmsClient;
  }

  public static void deleteExistingClusters(String parent) {
    try {
      ListGameServerClustersPagedResponse response =
          getClustersClient().listGameServerClusters(parent);

      for (GameServerCluster cluster : response.iterateAll()) {
        System.out.println("Deleting game cluster " + cluster.getName());
        OperationFuture poll = getClustersClient().deleteGameServerClusterAsync(cluster.getName());
        poll.get(1, TimeUnit.MINUTES);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  public static void deleteExistingDeployments(String parent) {
    try {
      ListGameServerDeploymentsPagedResponse response =
          getDeploymentsClient().listGameServerDeployments(parent);

      for (GameServerDeployment deployment : response.iterateAll()) {
        System.out.println("Deleting game server deployment " + deployment.getName());
        OperationFuture poll =
            getDeploymentsClient().deleteGameServerDeploymentAsync(deployment.getName());
        poll.get(1, TimeUnit.MINUTES);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  public static void deleteExistingRealms(String parent) {
    try {
      ListRealmsPagedResponse response = getRealmsClient().listRealms(parent);

      for (Realm realm : response.iterateAll()) {
        System.out.println("Deleting realm " + realm.getName());
        OperationFuture poll = getRealmsClient().deleteRealmAsync(realm.getName());
        poll.get(1, TimeUnit.MINUTES);
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }
}

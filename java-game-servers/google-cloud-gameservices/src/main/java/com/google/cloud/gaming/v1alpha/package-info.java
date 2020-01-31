/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A client to Game Services API.
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=============================== GameServerClustersServiceClient
 * ===============================
 *
 * <p>Service Description: The game server cluster maps to Kubernetes clusters running Agones and is
 * used to manage fleets within clusters.
 *
 * <p>Sample for GameServerClustersServiceClient:
 *
 * <pre>
 * <code>
 * try (GameServerClustersServiceClient gameServerClustersServiceClient = GameServerClustersServiceClient.create()) {
 *   String formattedName = GameServerClustersServiceClient.formatGameServerClusterName("[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");
 *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(formattedName);
 * }
 * </code>
 * </pre>
 *
 * ================================== GameServerDeploymentsServiceClient
 * ==================================
 *
 * <p>Service Description: The game server deployment is used to control the deployment of game
 * server software to Agones fleets.
 *
 * <p>Sample for GameServerDeploymentsServiceClient:
 *
 * <pre>
 * <code>
 * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient = GameServerDeploymentsServiceClient.create()) {
 *   String formattedName = GameServerDeploymentsServiceClient.formatGameServerDeploymentName("[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");
 *   GameServerDeployment response = gameServerDeploymentsServiceClient.getGameServerDeployment(formattedName);
 * }
 * </code>
 * </pre>
 *
 * =================== RealmsServiceClient ===================
 *
 * <p>Service Description: Realm provides grouping of game server clusters that are serving a
 * particular gamer population.
 *
 * <p>Sample for RealmsServiceClient:
 *
 * <pre>
 * <code>
 * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
 *   String formattedName = RealmsServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
 *   Realm response = realmsServiceClient.getRealm(formattedName);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.gaming.v1alpha;

import javax.annotation.Generated;

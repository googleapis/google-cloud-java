/*
 * Copyright 2020 Google LLC
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

/**
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= GameServerClustersServiceClient =======================
 *
 * <p>Service Description: The game server cluster maps to Kubernetes clusters running Agones and is
 * used to manage fleets within clusters.
 *
 * <p>Sample for GameServerClustersServiceClient:
 *
 * <pre>{@code
 * try (GameServerClustersServiceClient gameServerClustersServiceClient =
 *     GameServerClustersServiceClient.create()) {
 *   GameServerClusterName name =
 *       GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");
 *   GameServerCluster response = gameServerClustersServiceClient.getGameServerCluster(name);
 * }
 * }</pre>
 *
 * <p>======================= GameServerConfigsServiceClient =======================
 *
 * <p>Service Description: The game server config configures the game servers in an Agones fleet.
 *
 * <p>Sample for GameServerConfigsServiceClient:
 *
 * <pre>{@code
 * try (GameServerConfigsServiceClient gameServerConfigsServiceClient =
 *     GameServerConfigsServiceClient.create()) {
 *   GameServerConfigName name =
 *       GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
 *   GameServerConfig response = gameServerConfigsServiceClient.getGameServerConfig(name);
 * }
 * }</pre>
 *
 * <p>======================= GameServerDeploymentsServiceClient =======================
 *
 * <p>Service Description: The game server deployment is used to control the deployment of Agones
 * fleets.
 *
 * <p>Sample for GameServerDeploymentsServiceClient:
 *
 * <pre>{@code
 * try (GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient =
 *     GameServerDeploymentsServiceClient.create()) {
 *   GameServerDeploymentName name =
 *       GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
 *   GameServerDeployment response =
 *       gameServerDeploymentsServiceClient.getGameServerDeployment(name);
 * }
 * }</pre>
 *
 * <p>======================= RealmsServiceClient =======================
 *
 * <p>Service Description: A realm is a grouping of game server clusters that are considered
 * interchangeable.
 *
 * <p>Sample for RealmsServiceClient:
 *
 * <pre>{@code
 * try (RealmsServiceClient realmsServiceClient = RealmsServiceClient.create()) {
 *   RealmName name = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
 *   Realm response = realmsServiceClient.getRealm(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.gaming.v1;

import javax.annotation.Generated;

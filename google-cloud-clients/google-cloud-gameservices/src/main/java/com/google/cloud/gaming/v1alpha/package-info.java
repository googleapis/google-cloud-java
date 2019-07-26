/*
 * Copyright 2019 Google LLC
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
 * A client to gameservices API (prod).
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>=============================== AllocationPoliciesServiceClient
 * ===============================
 *
 * <p>Service Description: The cloud gaming allocation policy is used as the controller's recipe for
 * the allocating game servers from clusters. The policy has three modes: 1. Default mode which is
 * not limited to time. 2. Time based mode which is temporary and overrides the default mode when
 * effective. 3. Periodic mode which follows the time base mode, but happens periodically using
 * local time, identified by cron specs.
 *
 * <p>Sample for AllocationPoliciesServiceClient:
 *
 * <pre>
 * <code>
 * try (AllocationPoliciesServiceClient allocationPoliciesServiceClient = AllocationPoliciesServiceClient.create()) {
 *   String formattedName = AllocationPoliciesServiceClient.formatAllocationPolicyName("[PROJECT]", "[LOCATION]", "[ALLOCATION_POLICY]");
 *   AllocationPolicy response = allocationPoliciesServiceClient.getAllocationPolicy(formattedName);
 * }
 * </code>
 * </pre>
 *
 * =============================== GameServerClustersServiceClient ===============================
 *
 * <p>Service Description: The game server cluster is used to capture the game server cluster's
 * settings which are used to manage game server clusters.
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
 * <p>Service Description: The game server deployment is used to configure the deployment of game
 * server software to Agones Fleets in game server clusters.
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
 * <p>Service Description: Realm provides grouping of game server clusters that are serving
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
 *
 * ============================ ScalingPoliciesServiceClient ============================
 *
 * <p>Service Description: The cloud gaming scaling policy is used to configure scaling parameters
 * for each fleet.
 *
 * <p>Sample for ScalingPoliciesServiceClient:
 *
 * <pre>
 * <code>
 * try (ScalingPoliciesServiceClient scalingPoliciesServiceClient = ScalingPoliciesServiceClient.create()) {
 *   String formattedName = ScalingPoliciesServiceClient.formatScalingPolicyName("[PROJECT]", "[LOCATION]", "[SCALING_POLICY]");
 *   ScalingPolicy response = scalingPoliciesServiceClient.getScalingPolicy(formattedName);
 * }
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
package com.google.cloud.gaming.v1alpha;

import javax.annotation.Generated;

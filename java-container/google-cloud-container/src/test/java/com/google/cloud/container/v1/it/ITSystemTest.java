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
package com.google.cloud.container.v1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.ServiceOptions;
import com.google.cloud.container.v1.ClusterManagerClient;
import com.google.container.v1.Cluster;
import com.google.container.v1.ListClustersResponse;
import com.google.container.v1.ListNodePoolsResponse;
import com.google.container.v1.ListOperationsResponse;
import com.google.container.v1.NodePool;
import com.google.container.v1.Operation;
import com.google.container.v1.Operation.Status;
import com.google.container.v1.ServerConfig;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static ClusterManagerClient client;
  private static Operation operation;

  private static final Logger LOG = Logger.getLogger(ITSystemTest.class.getName());
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String ZONE = "us-central1-a";
  private static final String CONTAINER_PREFIX = "it-test-container";
  private static final String CLUSTER_NAME =
      CONTAINER_PREFIX + "-cluster-" + UUID.randomUUID().toString().substring(0, 8);
  private static final String NODE_POOL_NAME =
      CONTAINER_PREFIX + "-node-pool-" + UUID.randomUUID().toString().substring(0, 8);
  private static final String DETAIL = "test-detail";
  private static final String STATUS_MESSAGE = "test-status-message";
  private static final String SELF_LINK =
      "https://container.googleapis.com/v1/projects/"
          + PROJECT_ID
          + "/zones/us-central1-a/clusters/"
          + CLUSTER_NAME;
  private static final String NODE_POOL_SEL_LINK = SELF_LINK + "/nodePools/" + NODE_POOL_NAME;
  private static final String CONTAINER_NETWORK_ENV_NAME = "CONTAINER_NETWORK_NAME";
  private static final String DEFAULT_NETWORK = "java-container-network";
  private static final String NETWORK = getContainerNetworkName();
  private static final int INITIAL_NODE_COUNT = 1;

  @BeforeClass
  public static void beforeClass() throws Exception {
    client = ClusterManagerClient.create();
    Util.cleanUpExistingInstanceCluster(client, PROJECT_ID, ZONE, CONTAINER_PREFIX);

    /* create node pool* */
    NodePool nodePool =
        NodePool.newBuilder()
            .setInitialNodeCount(INITIAL_NODE_COUNT)
            .setName(NODE_POOL_NAME)
            .setSelfLink(NODE_POOL_SEL_LINK)
            .setStatusMessage(STATUS_MESSAGE)
            .build();

    /* create cluster */
    Cluster cluster =
        Cluster.newBuilder()
            .setName(CLUSTER_NAME)
            .setLocation("us-central1")
            .setDescription(DETAIL)
            .setSelfLink(SELF_LINK)
            .addNodePools(nodePool)
            .setStatusMessage(STATUS_MESSAGE)
            .setNetwork(NETWORK)
            .build();
    operation = client.createCluster(PROJECT_ID, ZONE, cluster);

    Operation response = client.getOperation(PROJECT_ID, ZONE, operation.getName());
    // Busy Wait for one minute at a time until Cluster CREATE operation is complete
    while (response.getStatus() != Status.DONE) {
      LOG.info(String.format("Cluster CREATE Operation Status: %s", response.getStatus()));
      Thread.sleep(TimeUnit.MINUTES.toMillis(1));
      response = client.getOperation(PROJECT_ID, ZONE, operation.getName());
    }
    LOG.info(String.format("%s cluster created successfully.", CLUSTER_NAME));
    LOG.info(String.format("%s node pool created successfully.", NODE_POOL_NAME));
  }

  @AfterClass
  public static void afterClass() {
    client.deleteCluster(PROJECT_ID, ZONE, CLUSTER_NAME);
    LOG.info(String.format("%s cluster deleted successfully.", CLUSTER_NAME));
    client.close();
  }

  @Test
  public void getClusterTest() {
    Cluster cluster = client.getCluster(PROJECT_ID, ZONE, CLUSTER_NAME);
    NodePool nodePool = client.getNodePool(PROJECT_ID, ZONE, CLUSTER_NAME, NODE_POOL_NAME);
    assertEquals(CLUSTER_NAME, cluster.getName());
    assertEquals(DETAIL, cluster.getDescription());
    assertEquals(ZONE, cluster.getLocation());
    assertEquals(SELF_LINK, cluster.getSelfLink());
    assertEquals(NETWORK, cluster.getNetwork());
    assertEquals(INITIAL_NODE_COUNT, nodePool.getInitialNodeCount());
  }

  @Test
  public void listClusterTest() {
    ListClustersResponse clustersResponse = client.listClusters(PROJECT_ID, ZONE);
    List<Cluster> clusters = clustersResponse.getClustersList();
    NodePool nodePool = client.getNodePool(PROJECT_ID, ZONE, CLUSTER_NAME, NODE_POOL_NAME);
    for (Cluster cluster : clusters) {
      if (CLUSTER_NAME.equals(cluster.getName())) {
        assertEquals(CLUSTER_NAME, cluster.getName());
        assertEquals(DETAIL, cluster.getDescription());
        assertEquals(ZONE, cluster.getLocation());
        assertEquals(SELF_LINK, cluster.getSelfLink());
        assertEquals(NETWORK, cluster.getNetwork());
        assertEquals(INITIAL_NODE_COUNT, nodePool.getInitialNodeCount());
      }
    }
  }

  @Test
  public void getOperationTest() {
    Operation response = client.getOperation(PROJECT_ID, ZONE, operation.getName());
    assertEquals(operation.getName(), response.getName());
    assertEquals(ZONE, response.getZone());
  }

  @Test
  public void listOperationsTest() {
    ListOperationsResponse listOperations = client.listOperations(PROJECT_ID, ZONE);
    List<Operation> operations = listOperations.getOperationsList();
    for (Operation actualOperation : operations) {
      if (actualOperation.getName().equals(operation.getName())) {
        assertEquals(operation.getName(), actualOperation.getName());
        assertEquals(ZONE, actualOperation.getZone());
      }
    }
  }

  @Test
  public void getServerConfigTest() {
    ServerConfig config = client.getServerConfig(PROJECT_ID, ZONE);
    assertNotNull(config);
    assertEquals("COS_CONTAINERD", config.getDefaultImageType());
  }

  @Test
  public void getNodePoolTest() {
    NodePool nodePool = client.getNodePool(PROJECT_ID, ZONE, CLUSTER_NAME, NODE_POOL_NAME);
    assertEquals(NODE_POOL_NAME, nodePool.getName());
    assertEquals(INITIAL_NODE_COUNT, nodePool.getInitialNodeCount());
    assertEquals(NODE_POOL_SEL_LINK, nodePool.getSelfLink());
  }

  @Test
  public void listNodePoolsTest() {
    ListNodePoolsResponse response = client.listNodePools(PROJECT_ID, ZONE, CLUSTER_NAME);
    List<NodePool> nodePools = response.getNodePoolsList();
    for (NodePool nodePool : nodePools) {
      if (NODE_POOL_NAME.equals(nodePool.getName())) {
        assertEquals(NODE_POOL_NAME, nodePool.getName());
        assertEquals(INITIAL_NODE_COUNT, nodePool.getInitialNodeCount());
        assertEquals(NODE_POOL_SEL_LINK, nodePool.getSelfLink());
      }
    }
  }

  private static String getContainerNetworkName() {
    String name =
        System.getProperty(CONTAINER_NETWORK_ENV_NAME, System.getenv(CONTAINER_NETWORK_ENV_NAME));

    if (name == null) {
      return DEFAULT_NETWORK;
    }
    return name;
  }
}

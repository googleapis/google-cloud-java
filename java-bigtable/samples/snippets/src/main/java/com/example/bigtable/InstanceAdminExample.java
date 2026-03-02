/*
 * Copyright 2019 Google Inc.
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

package com.example.bigtable;

import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.StorageType;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import java.io.IOException;
import java.util.Map;

/**
 * An example of using Google Cloud Bigtable.
 *
 * <p>This example demonstrates the usage of BigtableInstanceAdminClient to create, configure, and
 * delete Cloud Bigtable Instances and Clusters.
 *
 * <ul>
 *   <li>creates production instance
 *   <li>lists instances
 *   <li>gets instance
 *   <li>lists clusters
 *   <li>adds cluster
 *   <li>deletes cluster
 *   <li>deletes instance
 * </ul>
 */
public class InstanceAdminExample {

  private static final String CLUSTER = "cluster";
  private final String projectId;
  private final String clusterId;
  private final String instanceId;
  private final BigtableInstanceAdminClient adminClient;

  public static void main(String[] args) throws IOException {

    if (args.length != 1) {
      System.out.println("Missing required project id");
      return;
    }
    String projectId = args[0];

    InstanceAdminExample instanceAdmin =
        new InstanceAdminExample(projectId, "ssd-instance", "ssd-cluster");
    instanceAdmin.run();
  }

  public InstanceAdminExample(String projectId, String instanceId, String clusterId)
      throws IOException {
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.clusterId = clusterId;

    // Creates the settings to configure a bigtable instance admin client.
    BigtableInstanceAdminSettings instanceAdminSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId).build();

    // Creates a bigtable instance admin client.
    adminClient = BigtableInstanceAdminClient.create(instanceAdminSettings);
  }

  public void run() {
    createProdInstance();
    listInstances();
    getInstance();
    listClusters();
    addCluster();
    deleteCluster();
    deleteInstance();
    close();
  }

  // Close the client
  void close() {
    adminClient.close();
  }

  /** Demonstrates how to create a Production instance within a provided project. */
  public void createProdInstance() {
    // Checks if instance exists, creates instance if does not exists.
    if (!adminClient.exists(instanceId)) {
      System.out.println("Instance does not exist, creating a PRODUCTION instance");
      // [START bigtable_create_prod_instance]
      // Creates a Production Instance with the ID "ssd-instance",
      // cluster id "ssd-cluster", 3 nodes and location "us-central1-f".
      String parent = "projects/" + projectId;
      Instance instanceObj =
          Instance.newBuilder()
              .setDisplayName(instanceId)
              .setType(Instance.Type.PRODUCTION)
              .putLabels("department", "accounting")
              .build();
      Cluster clusterObj =
          Cluster.newBuilder()
              .setLocation("projects/" + projectId + "/locations/us-central1-f")
              .setServeNodes(3)
              .setDefaultStorageType(StorageType.SSD)
              .build();
      CreateInstanceRequest request =
          CreateInstanceRequest.newBuilder()
              .setParent(parent)
              .setInstanceId(instanceId)
              .setInstance(instanceObj)
              .putClusters(clusterId, clusterObj)
              .build();
      // Creates a production instance with the given request.
      try {
        Instance instance = adminClient.getBaseClient().createInstanceAsync(request).get();
        System.out.printf("PRODUCTION type instance %s created successfully%n", instance.getName());
      } catch (Exception e) {
        System.err.println("Failed to create instance: " + e.getMessage());
        throw new RuntimeException(e);
      }
      // [END bigtable_create_prod_instance]
    }
  }

  /** Demonstrates how to list all instances within a project. */
  public void listInstances() {
    System.out.println("\nListing Instances");
    // [START bigtable_list_instances]
    try {
      String parent = "projects/" + projectId;
      ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
      ListInstancesResponse response = adminClient.getBaseClient().listInstances(request);
      for (Instance instance : response.getInstancesList()) {
        System.out.println(instance.getName());
      }
    } catch (Exception e) {
      System.err.println("Failed to list instances: " + e.getMessage());
    }
    // [END bigtable_list_instances]
  }

  /** Demonstrates how to get an instance. */
  public Instance getInstance() {
    System.out.println("\nGet Instance");
    // [START bigtable_get_instance]
    Instance instance = null;
    try {
      String name = "projects/" + projectId + "/instances/" + instanceId;
      GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
      instance = adminClient.getBaseClient().getInstance(request);
      System.out.println("Instance ID: " + instance.getName());
      System.out.println("Display Name: " + instance.getDisplayName());
      System.out.print("Labels: ");
      Map<String, String> labels = instance.getLabelsMap();
      for (String key : labels.keySet()) {
        System.out.printf("%s - %s", key, labels.get(key));
      }
      System.out.println("\nState: " + instance.getState());
      System.out.println("Type: " + instance.getType());
    } catch (NotFoundException e) {
      System.err.println("Failed to get non-existent instance: " + e.getMessage());
    }
    // [END bigtable_get_instance]
    return instance;
  }

  /** Demonstrates how to list clusters within an instance. */
  public void listClusters() {
    System.out.println("\nListing Clusters");
    // [START bigtable_get_clusters]
    try {
      String parent = "projects/" + projectId + "/instances/" + instanceId;
      ListClustersRequest request = ListClustersRequest.newBuilder().setParent(parent).build();
      ListClustersResponse response = adminClient.getBaseClient().listClusters(request);
      for (Cluster cluster : response.getClustersList()) {
        System.out.println(cluster.getName());
      }
    } catch (NotFoundException e) {
      System.err.println("Failed to list clusters from a non-existent instance: " + e.getMessage());
    }
    // [END bigtable_get_clusters]
  }

  /** Demonstrates how to delete an instance. */
  public void deleteInstance() {
    System.out.println("\nDeleting Instance");
    // [START bigtable_delete_instance]
    try {
      String name = "projects/" + projectId + "/instances/" + instanceId;
      DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
      adminClient.getBaseClient().deleteInstance(request);
      System.out.println("Instance deleted: " + instanceId);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete non-existent instance: " + e.getMessage());
    }
    // [END bigtable_delete_instance]
  }

  /** Demonstrates how to add a cluster to an instance. */
  public void addCluster() {
    System.out.printf("%nAdding cluster: %s to instance: %s%n", CLUSTER, instanceId);
    // [START bigtable_create_cluster]
    try {
      String parent = "projects/" + projectId + "/instances/" + instanceId;
      Cluster clusterObj =
          Cluster.newBuilder()
              .setLocation("projects/" + projectId + "/locations/us-central1-c")
              .setServeNodes(3)
              .setDefaultStorageType(StorageType.SSD)
              .build();
      CreateClusterRequest request =
          CreateClusterRequest.newBuilder()
              .setParent(parent)
              .setClusterId(CLUSTER)
              .setCluster(clusterObj)
              .build();
      adminClient.getBaseClient().createClusterAsync(request).get();
      System.out.printf("Cluster: %s created successfully%n", CLUSTER);
    } catch (Exception e) {
      System.err.println("Failed to add cluster: " + e.getMessage());
    }
    // [END bigtable_create_cluster]
  }

  /** Demonstrates how to delete a cluster from an instance. */
  public void deleteCluster() {
    System.out.printf("%nDeleting cluster: %s from instance: %s%n", CLUSTER, instanceId);
    // [START bigtable_delete_cluster]
    try {
      String name = "projects/" + projectId + "/instances/" + instanceId + "/clusters/" + CLUSTER;
      DeleteClusterRequest request = DeleteClusterRequest.newBuilder().setName(name).build();
      adminClient.getBaseClient().deleteCluster(request);
      System.out.printf("Cluster: %s deleted successfully%n", CLUSTER);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent cluster: " + e.getMessage());
    }
    // [END bigtable_delete_cluster]
  }
}

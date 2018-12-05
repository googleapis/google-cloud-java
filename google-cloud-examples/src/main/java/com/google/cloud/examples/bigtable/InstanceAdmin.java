/*
 * Copyright 2018 Google LLC.  All Rights Reserved.
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
package com.google.cloud.examples.bigtable;

import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.CreateClusterRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.Instance.Type;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InstanceAdmin {

  public static void main(String... args) {

    final String GCLOUD_PROJECT = args[0];
    final String PRODUCTION_INSTANCE = "ssd-instance";
    final String PRODUCTION_CLUSTER = "ssd-cluster";

    if (args.length < 1) {
      System.out.println("Missing required project id");
      return;
    }

    try {
      // Create the settings to configure a bigtable admin client
      BigtableInstanceAdminSettings instanceAdminSettings =
          BigtableInstanceAdminSettings.newBuilder().setProjectName(ProjectName.of(GCLOUD_PROJECT))
              .build();

      // Create bigtable admin client
      BigtableInstanceAdminClient adminClient =
          BigtableInstanceAdminClient.create(instanceAdminSettings);

      // Create PRODUCTION instance
      createProdInstance(adminClient, PRODUCTION_INSTANCE, PRODUCTION_CLUSTER);

      // List instances
      listInstances(adminClient);

      // Get PRODUCTION instance
      getInstance(adminClient, PRODUCTION_INSTANCE);

      // Get PRODUCTION clusters
      listClusters(adminClient, PRODUCTION_INSTANCE);

      // Add cluster to PRODUCTION instance
      addCluster(adminClient, PRODUCTION_INSTANCE, PRODUCTION_CLUSTER);

      // Delete cluster from PRODUCTION instance
      deleteCluster(adminClient, PRODUCTION_INSTANCE, PRODUCTION_CLUSTER);

      // End operations with deleting PRODUCTION instance
      deleteInstance(adminClient, PRODUCTION_INSTANCE);

    } catch (IOException ex) {
      System.out.println("Exception while running InstanceAdmin: " + ex.getMessage());
    }
  }

  public static Instance createProdInstance(BigtableInstanceAdminClient adminClient,
      String instanceID, String clusterID) {
    System.out.println("Check if instance exists:");
    // [START bigtable_check_instance_exists]
    boolean found = false;
    try {
      found = adminClient.exists(instanceID);
    } catch (Exception e) {
      System.out.println("Error checking if instance exists: " + e.getMessage());
    }

    Instance instance = null;
    // Create instance if does not exists
    if (!found) {
      System.out.println("Instance does not exist, creating a PRODUCTION instance:");
      // [START bigtable_create_prod_instance]
      // Creates a Production Instance with the ID "ssd-instance"
      // with cluster id "ssd-cluster", 3 nodes and location us-central1-f
      CreateInstanceRequest createInstanceRequest = CreateInstanceRequest.of(instanceID)
          .addCluster(clusterID, "us-central1-f", 3, StorageType.SSD).setType(Type.PRODUCTION)
          .addLabel("example", "instance_admin");
      // Create production instance with given request
      try {
        instance = adminClient.createInstance(createInstanceRequest);
        System.out.printf("PRODUCTION type instance: %s, created successfully", instance.getId());
      } catch (Exception e) {
        System.out.println("Error creating PRODUCTION instance: " + e.getMessage());
        System.exit(0);
      }
      // [END bigtable_create_prod_instance]
    } else {
      System.out.printf("Instance: %s exists", instanceID);
      instance = adminClient.getInstance(instanceID);
    }
    return instance;
  }

  public static List<Instance> listInstances(BigtableInstanceAdminClient adminClient) {
    System.out.println("\nListing Instances:");
    // [START bigtable_list_instances]
    List<Instance> instances = null;
    try {
      instances = adminClient.listInstances();
      for (Instance instance : instances) {
        System.out.println(instance.getId());
      }
    } catch (Exception e) {
      System.out.println("Error listing instances: " + e.getMessage());
    }
    // [END bigtable_list_instances]
    return instances;
  }

  public static Instance getInstance(BigtableInstanceAdminClient adminClient, String instanceID) {
    System.out.println("\nGet Instance:");
    // [START bigtable_get_instance]
    Instance instance = null;
    try {
      instance = adminClient.getInstance(instanceID);
      System.out.println("Instance ID: " + instance.getId());
      System.out.println("Instance Meta:");
      System.out.println("Display Name: " + instance.getDisplayName());
      System.out.println("Labels:");
      Map<String, String> labels = instance.getLabels();
      for (String key : labels.keySet()) {
        System.out.printf("%s: %s", key, labels.get(key));
      }
      System.out.println("State: " + instance.getState());
      System.out.println("Type: " + instance.getType());
    } catch (Exception e) {
      System.out.println("Error getting instance: " + e.getMessage());
    }
    // [END bigtable_get_instance]
    return instance;
  }

  public static List<Cluster> listClusters(BigtableInstanceAdminClient adminClient,
      String instanceID) {
    System.out.println("\nListing Clusters:");
    // [START bigtable_get_clusters]
    List<Cluster> clusters = null;
    try {
      clusters = adminClient.listClusters(instanceID);
      for (Cluster cluster : clusters) {
        System.out.println(cluster.getId());
      }
    } catch (Exception e) {
      System.out.println("Error listing clusters: " + e.getMessage());
    }
    // [END bigtable_get_clusters]
    return clusters;
  }

  public static void deleteInstance(BigtableInstanceAdminClient adminClient, String instanceID) {
    System.out.println("\nDeleting Instance:");
    // [START bigtable_delete_instance]
    try {
      adminClient.deleteInstance(instanceID);
      System.out.println("Instance deleted: " + instanceID);
    } catch (NotFoundException e) {
      System.out.println("Error deleting instance: " + instanceID);
      System.out.println(e.getMessage());
    }
    // [END bigtable_delete_instance]
  }

  public static Cluster addCluster(BigtableInstanceAdminClient adminClient, String instanceID,
      String clusterID) {
    Cluster cluster = null;
    System.out.println("\nAdding cluster to instance: " + instanceID);
    // [START bigtable_create_cluster]
    try {
      cluster = adminClient.createCluster(
          CreateClusterRequest.of(instanceID, clusterID).setZone("us-central1-c").setServeNodes(3)
              .setStorageType(StorageType.SSD));
      System.out.printf("Cluster: %s created successfully", cluster.getId());
    } catch (Exception e) {
      System.out.println("Error creating cluster: " + e.getMessage());
    }
    // [END bigtable_create_cluster]
    return cluster;
  }

  public static void deleteCluster(BigtableInstanceAdminClient adminClient, String instanceID,
      String clusterID) {
    // [START bigtable_delete_cluster]
    System.out.println("\nDeleting Cluster");
    // [START bigtable_delete_cluster]
    try {
      adminClient.deleteCluster(instanceID, clusterID);
      System.out.printf("Cluster: %s deleted successfully", clusterID);
    } catch (Exception e) {
      System.out.println("Error deleting cluster: " + e.getMessage());
    }
    // [END bigtable_delete_cluster]
  }
}

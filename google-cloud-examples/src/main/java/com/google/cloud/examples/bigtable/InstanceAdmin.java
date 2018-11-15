package com.google.cloud.examples.bigtable;

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

  public static void main(String[] args) throws IOException {

    String GCLOUD_PROJECT = System.getenv("GCLOUD_PROJECT");

    if (GCLOUD_PROJECT.length() == 0) {
      throw new Error("Environment variables GCLOUD_PROJECT must be set!");
    }

    BigtableInstanceAdminSettings instanceAdminSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectName(ProjectName.of(GCLOUD_PROJECT))
            .build();

    BigtableInstanceAdminClient adminClient =
        BigtableInstanceAdminClient.create(instanceAdminSettings);

    System.out.println("Create an instance (type: PRODUCTION) and run basic instance-operations");
    runInstanceOperations(adminClient, "ssd-instance", "ssd-cluster");

    System.out.println("Create DEVELOPMENT instance");
    createDevInstance(adminClient, "hdd-instance", "hdd-cluster");

    System.out.println("Delete the Instance");
    deleteInstance(adminClient, "hdd-instance");

    System.out.println("Add Cluster");
    addCluster(adminClient, "ssd-instance", "ssd-cluster");

    System.out.println("Delete the Cluster");
    deleteCluster(adminClient, "ssd-instance", "ssd-cluster");

    // end operations with deleting the pro-instance created in `runInstanceOperations`
    deleteInstance(adminClient, "ssd-instance");
  }

  public static void runInstanceOperations(BigtableInstanceAdminClient adminClient,
      String instanceID, String clusterID) {
    System.out.println("Check Instance Exists");
    // [START bigtable_check_instance_exists]
    boolean found = false;
    try {
      found = adminClient.exists(instanceID);
    } catch (Exception e) {
      System.out.println("Error checking if Instance exists: " + e.getMessage());
    }

    // Create instance if does not exists
    if (!found) {
      System.out.println("Creating a PRODUCTION Instance");
      // [START bigtable_create_prod_instance]
      // Creates a Production Instance with the ID "ssd-instance"
      // with cluster id "ssd-cluster", 3 nodes and location us-central1-f
      CreateInstanceRequest createInstanceRequest = CreateInstanceRequest.of(instanceID)
          .addCluster(clusterID, "us-central1-f", 3, StorageType.SSD).setType(Type.PRODUCTION)
          .addLabel("prod-label", "prod-label");
      // Create production instance with given request
      try {
        Instance instance = adminClient.createInstance(createInstanceRequest);
        System.out
            .println("PRODUCTION type instance : " + instance.getId() + " created successfully");

      } catch (Exception e) {
        System.out.println("Error creating prod-instance: " + e.getMessage());
      }
      // [END bigtable_create_prod_instance]
    } else {
      System.out.println("Instance " + instanceID + " exists");
    }

    System.out.println(); //for a new-line
    System.out.println("Listing Instances:");
    // [START bigtable_list_instances]
    try {
      List<Instance> instances = adminClient.listInstances();
      for (Instance instance : instances) {
        System.out.println(instance.getId());
      }
    } catch (Exception e) {
      System.out.println("Error listing instances: " + e.getMessage());
    }
    // [END bigtable_list_instances]

    System.out.println(); //for a new-line
    System.out.println("Get Instance:");
    // [START bigtable_get_instance]
    try {
      Instance instance = adminClient.getInstance(instanceID);
      System.out.println("Instance ID: " + instance.getId());
      System.out.println("Instance Meta:");
      System.out.println("Display Name: " + instance.getDisplayName());
      System.out.println("Labels:");
      Map<String, String> labels = instance.getLabels();
      for (String key : labels.keySet()) {
        System.out.println(key + ": " + labels.get(key));
      }
      System.out.println("State: " + instance.getState());
      System.out.println("Type: " + instance.getType());
    } catch (Exception e) {
      System.out.println("Error getting instance: " + e.getMessage());
    }
    // [END bigtable_get_instance]

    System.out.println(); //for a new-line
    System.out.println("Listing Clusters...");
    // [START bigtable_get_clusters]
    try {
      List<Cluster> clusters = adminClient.listClusters(instanceID);
      for (Cluster cluster : clusters) {
        System.out.println(cluster.getId());
      }
    } catch (Exception e) {
      System.out.println("Error listing clusters: " + e.getMessage());
    }
    // [END bigtable_get_clusters]
  }

  public static void createDevInstance(BigtableInstanceAdminClient adminClient, String instanceID,
      String clusterID) {
    // [START bigtable_create_dev_instance]
    System.out.println(); //for a new-line
    System.out.println("Creating a DEVELOPMENT Instance");
    // Creates a Development instance with the ID "hdd-instance"
    // with cluster ID "hdd-cluster" and location us-central1-f
    // Cluster nodes should not be set while creating Development Instance
    CreateInstanceRequest createInstanceRequest = CreateInstanceRequest.of(instanceID)
        .addCluster(clusterID, "us-central1-f", 1, StorageType.HDD).setType(Type.DEVELOPMENT)
        .addLabel("dev-label", "dev-label");
    // Create development instance with given request
    try {
      Instance instance = adminClient.createInstance(createInstanceRequest);
      System.out
          .println("DEVELOPMENT type instance : " + instance.getId() + " created successfully");
    } catch (Exception e) {
      System.out.println("Error creating dev-instance: " + e.getMessage());
    }
    // [END bigtable_create_dev_instance]
  }

  // Delete the Instance
  public static void deleteInstance(BigtableInstanceAdminClient adminClient, String instanceID) {
    // [START bigtable_delete_instance]
    System.out.println(); //for a new-line
    System.out.println("Deleting Instance");
    try {
      adminClient.deleteInstance(instanceID);
      System.out.println("Instance deleted: " + instanceID);
    } catch (Exception e) {
      System.out.println("Error deleting instance: " + instanceID);
    }
    // [END bigtable_delete_instance]
  }

  // Add Cluster
  public static void addCluster(BigtableInstanceAdminClient adminClient, String instanceID,
      String clusterID) {
    boolean found = false;
    try {
      found = adminClient.exists(instanceID);
    } catch (Exception e) {
      System.out.println("Error checking if Instance exists: " + e.getMessage());
    }
    if (!found) {
      System.out.println("Instance does not exist");
    } else {
      System.out.println(); //for a new-line
      System.out.println("Adding Cluster to Instance " + instanceID);
      // [START bigtable_create_cluster]
      CreateClusterRequest createClusterRequest =
          CreateClusterRequest.of(instanceID, clusterID).setServeNodes(3)
              .setStorageType(StorageType.SSD).setZone("us-central1-c");
      try {
        Cluster cluster = adminClient.createCluster(createClusterRequest);
        System.out.println("Cluster : " + cluster.getId() + " created successfully");
      } catch (Exception e) {
        System.out.println("Error creating cluster: " + e.getMessage());
      }
      // [END bigtable_create_cluster]
    }
  }

  // Delete the Cluster
  public static void deleteCluster(BigtableInstanceAdminClient adminClient, String instanceID,
      String clusterID) {
    // [START bigtable_delete_cluster]
    System.out.println(); //for a new-line
    System.out.println("Deleting Cluster");
    // [START bigtable_delete_cluster]
    try {
      adminClient.deleteCluster(instanceID, clusterID);
      System.out.println("Cluster : " + clusterID + " deleted successfully");
    } catch (Exception e) {
      System.out.println("Error deleting cluster: " + e.getMessage());
    }
    System.out.println("Cluster deleted: " + clusterID);
    // [END bigtable_delete_cluster]
  }
}
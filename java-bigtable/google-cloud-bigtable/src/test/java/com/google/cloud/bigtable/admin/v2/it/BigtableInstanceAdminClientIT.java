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
package com.google.cloud.bigtable.admin.v2.it;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.cloud.Policy;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.ClusterAutoscalingConfig;
import com.google.cloud.bigtable.admin.v2.models.CreateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateClusterRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.Instance.Type;
import com.google.cloud.bigtable.admin.v2.models.StaticClusterSize;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.admin.v2.models.UpdateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateInstanceRequest;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BigtableInstanceAdminClientIT {

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();
  @Rule public final PrefixGenerator prefixGenerator = new PrefixGenerator();

  private String instanceId = testEnvRule.env().getInstanceId();
  private BigtableInstanceAdminClient client;

  // TODO: Update this test once emulator supports InstanceAdmin operation
  // https://github.com/googleapis/google-cloud-go/issues/1069
  @BeforeClass
  public static void validatePlatform() {
    assume()
        .withMessage("BigtableInstanceAdminClient doesn't support on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);
  }

  @Before
  public void setUp() {
    client = testEnvRule.env().getInstanceAdminClient();
  }

  @Test
  public void appProfileTest() {
    String testAppProfile = prefixGenerator.newPrefix();

    AppProfile newlyCreatedAppProfile =
        client.createAppProfile(
            CreateAppProfileRequest.of(instanceId, testAppProfile)
                .setRoutingPolicy(AppProfile.MultiClusterRoutingPolicy.of())
                .setDescription("This is to test app profile"));

    AppProfile updated =
        client.updateAppProfile(
            UpdateAppProfileRequest.of(newlyCreatedAppProfile)
                .setDescription("This is to app profile operation"));

    AppProfile freshAppProfile = client.getAppProfile(instanceId, testAppProfile);
    assertThat(freshAppProfile.getDescription()).isEqualTo(updated.getDescription());

    assertThat(client.listAppProfiles(instanceId)).contains(freshAppProfile);

    Exception actualEx = null;
    try {
      client.deleteAppProfile(instanceId, testAppProfile, true);
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isNull();
  }

  @Test
  public void appProfileTestMultiClusterWithIds() {
    String newInstanceId = prefixGenerator.newPrefix();
    String newClusterId = newInstanceId + "-c1";
    String newClusterId2 = newInstanceId + "-c2";

    client.createInstance(
        CreateInstanceRequest.of(newInstanceId)
            .addCluster(newClusterId, testEnvRule.env().getPrimaryZone(), 1, StorageType.SSD)
            .addCluster(newClusterId2, testEnvRule.env().getSecondaryZone(), 1, StorageType.SSD)
            .setDisplayName("Multi-Cluster-Instance-Test")
            .addLabel("state", "readytodelete")
            .setType(Type.PRODUCTION));

    try {
      assertThat(client.exists(newInstanceId)).isTrue();

      String testAppProfile = "test-app-profile";

      CreateAppProfileRequest request =
          CreateAppProfileRequest.of(newInstanceId, testAppProfile)
              .setRoutingPolicy(AppProfile.MultiClusterRoutingPolicy.of(newClusterId))
              .setDescription("This is to test app profile");

      AppProfile newlyCreatedAppProfile = client.createAppProfile(request);

      AppProfile updated =
          client.updateAppProfile(
              UpdateAppProfileRequest.of(newlyCreatedAppProfile).setDescription("new description"));

      AppProfile freshAppProfile = client.getAppProfile(newInstanceId, testAppProfile);
      assertThat(freshAppProfile.getDescription()).isEqualTo(updated.getDescription());

      AppProfile.MultiClusterRoutingPolicy freshAppProfilePolicy =
          (AppProfile.MultiClusterRoutingPolicy) freshAppProfile.getPolicy();
      AppProfile.MultiClusterRoutingPolicy updatedAppProfilePolicy =
          (AppProfile.MultiClusterRoutingPolicy) updated.getPolicy();

      assertThat(freshAppProfilePolicy.getClusterIds()).containsExactly(newClusterId);
      assertThat(freshAppProfilePolicy.getClusterIds())
          .isEqualTo(updatedAppProfilePolicy.getClusterIds());
      assertThat(freshAppProfilePolicy).isEqualTo(updatedAppProfilePolicy);

      assertThat(client.listAppProfiles(newInstanceId)).contains(freshAppProfile);

      // update again with routing policy
      AppProfile updated2 =
          client.updateAppProfile(
              UpdateAppProfileRequest.of(updated)
                  .setRoutingPolicy(AppProfile.MultiClusterRoutingPolicy.of(newClusterId2)));

      AppProfile freshAppProfile2 = client.getAppProfile(newInstanceId, testAppProfile);
      assertThat(freshAppProfile2.getDescription()).isEqualTo(updated2.getDescription());

      AppProfile.MultiClusterRoutingPolicy freshAppProfilePolicy2 =
          (AppProfile.MultiClusterRoutingPolicy) freshAppProfile2.getPolicy();
      AppProfile.MultiClusterRoutingPolicy updatedAppProfilePolicy2 =
          (AppProfile.MultiClusterRoutingPolicy) updated2.getPolicy();

      assertThat(freshAppProfilePolicy2.getClusterIds()).containsExactly(newClusterId2);
      assertThat(freshAppProfilePolicy2.getClusterIds())
          .isEqualTo(updatedAppProfilePolicy2.getClusterIds());
      assertThat(freshAppProfilePolicy2).isEqualTo(updatedAppProfilePolicy2);

      assertThat(client.listAppProfiles(newInstanceId)).contains(freshAppProfile2);

      // update to single routing policy
      AppProfile updated3 =
          client.updateAppProfile(
              UpdateAppProfileRequest.of(updated)
                  .setRoutingPolicy(AppProfile.SingleClusterRoutingPolicy.of(newClusterId)));

      AppProfile freshAppProfile3 = client.getAppProfile(newInstanceId, testAppProfile);
      assertThat(freshAppProfile3.getDescription()).isEqualTo(updated3.getDescription());

      AppProfile.SingleClusterRoutingPolicy freshAppProfilePolicy3 =
          (AppProfile.SingleClusterRoutingPolicy) freshAppProfile3.getPolicy();
      AppProfile.SingleClusterRoutingPolicy updatedAppProfilePolicy3 =
          (AppProfile.SingleClusterRoutingPolicy) updated3.getPolicy();

      assertThat(freshAppProfilePolicy3.getClusterId()).isEqualTo(newClusterId);
      assertThat(freshAppProfilePolicy3.getClusterId())
          .isEqualTo(updatedAppProfilePolicy3.getClusterId());
      assertThat(freshAppProfilePolicy3).isEqualTo(updatedAppProfilePolicy3);

      assertThat(client.listAppProfiles(newInstanceId)).contains(freshAppProfile3);
    } finally {
      if (client.exists(newInstanceId)) {
        client.deleteInstance(newInstanceId);
      }
    }
  }

  @Test
  public void iamUpdateTest() {
    Policy policy = client.getIamPolicy(instanceId);
    assertThat(policy).isNotNull();

    Exception actualEx = null;
    try {
      assertThat(client.setIamPolicy(instanceId, policy)).isNotNull();
    } catch (Exception iamException) {
      actualEx = iamException;
    }
    assertThat(actualEx).isNull();

    List<String> permissions =
        client.testIamPermission(
            instanceId, "bigtable.tables.readRows", "bigtable.tables.mutateRows");
    assertThat(permissions).hasSize(2);
  }

  /** To optimize test run time, instance & cluster creation is tested at the same time */
  @Test
  public void instanceAndClusterCreationDeletionTest() {
    String newInstanceId = prefixGenerator.newPrefix();
    String newClusterId = newInstanceId;

    client.createInstance(
        CreateInstanceRequest.of(newInstanceId)
            .addCluster(newClusterId, testEnvRule.env().getPrimaryZone(), 3, StorageType.SSD)
            .setDisplayName("Fresh-Instance-Name")
            .addLabel("state", "readytodelete")
            .setType(Type.PRODUCTION));

    try {
      assertThat(client.exists(newInstanceId)).isTrue();

      client.updateInstance(
          UpdateInstanceRequest.of(newInstanceId).setDisplayName("Test-Instance-Name"));

      Instance instance = client.getInstance(newInstanceId);
      assertThat(instance.getDisplayName()).isEqualTo("Test-Instance-Name");

      assertThat(client.listInstances()).contains(instance);

      clusterCreationDeletionTestHelper(newInstanceId);
      basicClusterOperationTestHelper(newInstanceId, newClusterId);

      client.deleteInstance(newInstanceId);
      assertThat(client.exists(newInstanceId)).isFalse();
    } finally {
      if (client.exists(newInstanceId)) {
        client.deleteInstance(newInstanceId);
      }
    }
  }

  // To improve test runtime, piggyback off the instance creation/deletion test's fresh instance.
  // This will avoid the need to copy any existing tables and will also reduce flakiness in case a
  // previous run failed to clean up a cluster in the secondary zone.
  private void clusterCreationDeletionTestHelper(String newInstanceId) {
    String newClusterId = prefixGenerator.newPrefix();
    boolean isClusterDeleted = false;
    client.createCluster(
        CreateClusterRequest.of(newInstanceId, newClusterId)
            .setZone(testEnvRule.env().getSecondaryZone())
            .setStorageType(StorageType.SSD)
            .setServeNodes(3));
    try {
      assertThat(client.getCluster(newInstanceId, newClusterId)).isNotNull();

      client.deleteCluster(newInstanceId, newClusterId);
      isClusterDeleted = true;
    } finally {
      if (!isClusterDeleted) {
        client.deleteCluster(newInstanceId, newClusterId);
      }
    }
  }

  /* As cluster creation is very expensive operation, so reusing existing clusters to verify rest
  of the operation.*/
  @Test
  public void basicInstanceOperationTest() {
    assertThat(client.exists(instanceId)).isTrue();

    client.updateInstance(
        UpdateInstanceRequest.of(instanceId).setDisplayName("Updated-Instance-Name"));

    Instance instance = client.getInstance(instanceId);
    assertThat(instance.getDisplayName()).isEqualTo("Updated-Instance-Name");

    assertThat(client.listInstances()).contains(instance);
  }

  @Test
  public void createClusterWithAutoscalingTest() {
    String newInstanceId = prefixGenerator.newPrefix();
    String newClusterId = newInstanceId + "-c1";

    try {
      client.createInstance(
          CreateInstanceRequest.of(newInstanceId)
              .addCluster(newClusterId, testEnvRule.env().getPrimaryZone(), 1, StorageType.HDD)
              .setDisplayName("Multi-Cluster-Instance-Test")
              .addLabel("state", "readytodelete")
              .setType(Type.PRODUCTION));

      String clusterId = prefixGenerator.newPrefix();
      CreateClusterRequest createClusterRequest =
          CreateClusterRequest.of(newInstanceId, clusterId)
              .setZone(testEnvRule.env().getSecondaryZone())
              .setStorageType(StorageType.HDD)
              .setScalingMode(
                  ClusterAutoscalingConfig.of(newInstanceId, clusterId)
                      .setMaxNodes(4)
                      .setMinNodes(1)
                      .setCpuUtilizationTargetPercent(20)
                      .setStorageUtilizationGibPerNode(9200));

      Cluster cluster = client.createCluster(createClusterRequest);
      assertThat(cluster.getId()).contains(clusterId);
      assertThat(cluster.getServeNodes()).isEqualTo(0);
      assertThat(cluster.getAutoscalingMinServeNodes()).isEqualTo(1);
      assertThat(cluster.getAutoscalingMaxServeNodes()).isEqualTo(4);
      assertThat(cluster.getAutoscalingCpuPercentageTarget()).isEqualTo(20);
      assertThat(cluster.getStorageUtilizationGibPerNode()).isEqualTo(9200);
    } catch (Exception e) {
      Assert.fail("error in the test" + e.getMessage());
    } finally {
      client.deleteInstance(newInstanceId);
    }
  }

  @Test
  public void createClusterWithAutoscalingAndPartialUpdateTest() {
    String newInstanceId = prefixGenerator.newPrefix();
    String newClusterId = newInstanceId + "-c1";

    try {
      client.createInstance(
          CreateInstanceRequest.of(newInstanceId)
              .addCluster(newClusterId, testEnvRule.env().getPrimaryZone(), 1, StorageType.SSD)
              .setDisplayName("Multi-Cluster-Instance-Test")
              .addLabel("state", "readytodelete")
              .setType(Type.PRODUCTION));

      String clusterId = prefixGenerator.newPrefix();
      CreateClusterRequest createClusterRequest =
          CreateClusterRequest.of(newInstanceId, clusterId)
              .setZone(testEnvRule.env().getSecondaryZone())
              .setScalingMode(
                  ClusterAutoscalingConfig.of("ignored", clusterId)
                      .setMaxNodes(4)
                      .setMinNodes(1)
                      .setStorageUtilizationGibPerNode(2561)
                      .setCpuUtilizationTargetPercent(20));

      Cluster cluster = client.createCluster(createClusterRequest);
      assertThat(cluster.getId()).contains(clusterId);
      assertThat(cluster.getServeNodes()).isEqualTo(0);
      assertThat(cluster.getAutoscalingMinServeNodes()).isEqualTo(1);
      assertThat(cluster.getAutoscalingMaxServeNodes()).isEqualTo(4);
      assertThat(cluster.getAutoscalingCpuPercentageTarget()).isEqualTo(20);
      assertThat(cluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      Cluster retrievedCluster = client.getCluster(newInstanceId, clusterId);
      assertThat(retrievedCluster.getId()).contains(clusterId);
      assertThat(retrievedCluster.getAutoscalingMinServeNodes()).isEqualTo(1);
      assertThat(retrievedCluster.getAutoscalingMaxServeNodes()).isEqualTo(4);
      assertThat(retrievedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(20);
      assertThat(retrievedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      Cluster updatedCluster =
          client.updateClusterAutoscalingConfig(
              ClusterAutoscalingConfig.of(newInstanceId, clusterId).setMaxNodes(3));
      assertThat(updatedCluster.getAutoscalingMinServeNodes()).isEqualTo(1);
      assertThat(updatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(3);
      assertThat(updatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(20);
      assertThat(updatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      Cluster retrievedUpdatedCluster = client.getCluster(newInstanceId, clusterId);
      assertThat(retrievedUpdatedCluster.getAutoscalingMinServeNodes()).isEqualTo(1);
      assertThat(retrievedUpdatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(3);
      assertThat(retrievedUpdatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(20);
      assertThat(retrievedUpdatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      updatedCluster =
          client.updateClusterAutoscalingConfig(
              ClusterAutoscalingConfig.of(newInstanceId, clusterId).setMinNodes(2));
      assertThat(updatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(updatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(3);
      assertThat(updatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(20);
      assertThat(updatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      retrievedUpdatedCluster = client.getCluster(newInstanceId, clusterId);
      assertThat(retrievedUpdatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(retrievedUpdatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(3);
      assertThat(retrievedUpdatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(20);
      assertThat(retrievedUpdatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      updatedCluster =
          client.updateClusterAutoscalingConfig(
              ClusterAutoscalingConfig.of(newInstanceId, clusterId)
                  .setCpuUtilizationTargetPercent(40));
      assertThat(updatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(updatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(3);
      assertThat(updatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(40);
      assertThat(updatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      retrievedUpdatedCluster = client.getCluster(newInstanceId, clusterId);
      assertThat(retrievedUpdatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(retrievedUpdatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(3);
      assertThat(retrievedUpdatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(40);
      assertThat(retrievedUpdatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      updatedCluster =
          client.updateClusterAutoscalingConfig(
              ClusterAutoscalingConfig.of(newInstanceId, clusterId)
                  .setCpuUtilizationTargetPercent(45)
                  .setMaxNodes(5));
      assertThat(updatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(updatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(5);
      assertThat(updatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(45);
      assertThat(updatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      retrievedUpdatedCluster = client.getCluster(newInstanceId, clusterId);
      assertThat(retrievedUpdatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(retrievedUpdatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(5);
      assertThat(retrievedUpdatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(45);
      assertThat(retrievedUpdatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2561);

      updatedCluster =
          client.updateClusterAutoscalingConfig(
              ClusterAutoscalingConfig.of(newInstanceId, clusterId)
                  .setStorageUtilizationGibPerNode(2777));
      assertThat(updatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(updatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(5);
      assertThat(updatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(45);
      assertThat(updatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2777);

      retrievedUpdatedCluster = client.getCluster(newInstanceId, clusterId);
      assertThat(retrievedUpdatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(retrievedUpdatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(5);
      assertThat(retrievedUpdatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(45);
      assertThat(retrievedUpdatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2777);

      updatedCluster =
          client.updateClusterAutoscalingConfig(
              ClusterAutoscalingConfig.of(newInstanceId, clusterId)
                  // testing default case
                  .setStorageUtilizationGibPerNode(0));
      assertThat(updatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(updatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(5);
      assertThat(updatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(45);
      assertThat(updatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2560);

      retrievedUpdatedCluster = client.getCluster(newInstanceId, clusterId);
      assertThat(retrievedUpdatedCluster.getAutoscalingMinServeNodes()).isEqualTo(2);
      assertThat(retrievedUpdatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(5);
      assertThat(retrievedUpdatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(45);
      assertThat(retrievedUpdatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(2560);
    } catch (Exception e) {
      Assert.fail("error in the test: " + e.getMessage());
    } finally {
      client.deleteInstance(newInstanceId);
    }
  }

  @Test
  public void createClusterWithManualScalingTest() {
    String newInstanceId = prefixGenerator.newPrefix();
    String newClusterId = newInstanceId + "-c1";

    try {
      client.createInstance(
          CreateInstanceRequest.of(newInstanceId)
              .addCluster(newClusterId, testEnvRule.env().getPrimaryZone(), 1, StorageType.SSD)
              .setDisplayName("Multi-Cluster-Instance-Test")
              .addLabel("state", "readytodelete")
              .setType(Type.PRODUCTION));

      String clusterId = prefixGenerator.newPrefix();
      CreateClusterRequest createClusterRequest =
          CreateClusterRequest.of(newInstanceId, clusterId)
              .setZone(testEnvRule.env().getSecondaryZone())
              .setScalingMode(StaticClusterSize.of(5));

      Cluster cluster = client.createCluster(createClusterRequest);
      assertThat(cluster.getId()).contains(clusterId);
      assertThat(cluster.getServeNodes()).isEqualTo(5);
      assertThat(cluster.getAutoscalingMaxServeNodes()).isEqualTo(0);
      assertThat(cluster.getAutoscalingMinServeNodes()).isEqualTo(0);
      assertThat(cluster.getAutoscalingCpuPercentageTarget()).isEqualTo(0);
      assertThat(cluster.getStorageUtilizationGibPerNode()).isEqualTo(0);
    } catch (Exception e) {
      Assert.fail("error in the test: " + e.getMessage());
    } finally {
      client.deleteInstance(newInstanceId);
    }
  }

  // To improve test runtime, piggyback off the instance creation/deletion test's fresh instance.
  private void basicClusterOperationTestHelper(String targetInstanceId, String targetClusterId) {
    List<Cluster> clusters = client.listClusters(targetInstanceId);

    Cluster targetCluster = null;
    for (Cluster cluster : clusters) {
      if (cluster.getId().equals(targetClusterId)) {
        targetCluster = cluster;
      }
    }
    assertWithMessage("Failed to find target cluster id in listClusters")
        .that(targetCluster)
        .isNotNull();

    assertThat(client.getCluster(targetInstanceId, targetClusterId)).isEqualTo(targetCluster);

    int freshNumOfNodes = targetCluster.getServeNodes() + 1;

    Cluster resizeCluster =
        client.resizeCluster(targetInstanceId, targetClusterId, freshNumOfNodes);
    assertThat(resizeCluster.getServeNodes()).isEqualTo(freshNumOfNodes);

    ClusterAutoscalingConfig autoscalingConfig =
        ClusterAutoscalingConfig.of(targetInstanceId, targetClusterId)
            .setMinNodes(1)
            .setMaxNodes(4)
            .setStorageUtilizationGibPerNode(2877)
            .setCpuUtilizationTargetPercent(40);
    Cluster cluster = client.updateClusterAutoscalingConfig(autoscalingConfig);
    assertThat(cluster.getAutoscalingMaxServeNodes()).isEqualTo(4);
    assertThat(cluster.getAutoscalingMinServeNodes()).isEqualTo(1);
    assertThat(cluster.getAutoscalingCpuPercentageTarget()).isEqualTo(40);
    assertThat(cluster.getStorageUtilizationGibPerNode()).isEqualTo(2877);

    Cluster updatedCluster = client.disableClusterAutoscaling(targetInstanceId, targetClusterId, 3);
    assertThat(updatedCluster.getServeNodes()).isEqualTo(3);
    assertThat(updatedCluster.getAutoscalingMaxServeNodes()).isEqualTo(0);
    assertThat(updatedCluster.getAutoscalingMinServeNodes()).isEqualTo(0);
    assertThat(updatedCluster.getAutoscalingCpuPercentageTarget()).isEqualTo(0);
    assertThat(updatedCluster.getStorageUtilizationGibPerNode()).isEqualTo(0);
  }
}

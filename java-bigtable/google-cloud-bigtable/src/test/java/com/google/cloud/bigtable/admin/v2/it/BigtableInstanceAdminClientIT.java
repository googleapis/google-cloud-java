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
import com.google.cloud.bigtable.admin.v2.models.CreateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateClusterRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.Instance.Type;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.admin.v2.models.UpdateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateInstanceRequest;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import java.util.List;
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
  }
}

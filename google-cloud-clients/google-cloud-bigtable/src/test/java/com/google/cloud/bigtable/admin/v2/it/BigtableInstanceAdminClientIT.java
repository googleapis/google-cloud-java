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

import static com.google.cloud.bigtable.test_helpers.env.AbstractTestEnv.TEST_APP_PREFIX;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.cloud.Policy;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.models.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.CreateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateClusterRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.admin.v2.models.UpdateAppProfileRequest;
import com.google.cloud.bigtable.admin.v2.models.UpdateInstanceRequest;
import com.google.cloud.bigtable.test_helpers.env.AbstractTestEnv;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.threeten.bp.Instant;

public class BigtableInstanceAdminClientIT {

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

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
    String testAppProfile = TEST_APP_PREFIX + Instant.now().getEpochSecond();

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

  @Test
  public void instanceCreationDeletionTest() {
    String newInstanceId = AbstractTestEnv.TEST_INSTANCE_PREFIX + Instant.now().getEpochSecond();
    String newClusterId = newInstanceId + "-c1";

    client.createInstance(
        CreateInstanceRequest.of(newInstanceId)
            .addDevelopmentCluster(newClusterId, "us-central1-a", StorageType.SSD)
            .setDisplayName("Fresh-Instance-Name")
            .addLabel("state", "readytodelete")
            .setType(Instance.Type.DEVELOPMENT));

    try {
      assertThat(client.exists(newInstanceId)).isTrue();

      client.updateInstance(
          UpdateInstanceRequest.of(newInstanceId).setDisplayName("Test-Instance-Name"));

      Instance instance = client.getInstance(newInstanceId);
      assertThat(instance.getDisplayName()).isEqualTo("Test-Instance-Name");

      assertThat(client.listInstances()).contains(instance);

      client.deleteInstance(newInstanceId);
      assertThat(client.exists(newInstanceId)).isFalse();
    } finally {
      if (client.exists(newInstanceId)) {
        client.deleteInstance(newInstanceId);
      }
    }
  }

  @Test
  public void clusterCreationDeletionTest() {
    Instance currentInstance = client.getInstance(instanceId);
    assume()
        .withMessage("cluster replication test can only run on PRODUCTION instance")
        .that(currentInstance.getType())
        .isEqualTo(Instance.Type.PRODUCTION);

    String newClusterId = AbstractTestEnv.TEST_CLUSTER_PREFIX + Instant.now().getEpochSecond();
    boolean isClusterDeleted = false;
    client.createCluster(
        CreateClusterRequest.of(instanceId, newClusterId)
            .setZone("us-central1-f")
            .setStorageType(StorageType.SSD)
            .setServeNodes(3));
    try {
      assertThat(client.getCluster(instanceId, newClusterId)).isNotNull();

      client.deleteCluster(instanceId, newClusterId);
      isClusterDeleted = true;
    } finally {
      if (!isClusterDeleted) {
        client.deleteCluster(instanceId, newClusterId);
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

  /* As cluster creation is very expensive operation, so reusing existing clusters to verify rest
  of the operation.*/
  @Test
  public void basicClusterOperationTest() {
    List<Cluster> clusters = client.listClusters(instanceId);
    assertThat(clusters).isNotEmpty();

    Cluster existingCluster = clusters.get(0);
    String clusterId = existingCluster.getId();
    assertThat(client.getCluster(instanceId, clusterId)).isEqualTo(existingCluster);

    if (Instance.Type.PRODUCTION.equals(client.getInstance(instanceId).getType())) {
      int existingClusterNodeSize = existingCluster.getServeNodes();
      int freshNumOfNodes = existingClusterNodeSize + 1;

      Cluster resizeCluster = client.resizeCluster(instanceId, clusterId, freshNumOfNodes);
      assertThat(resizeCluster.getServeNodes()).isEqualTo(freshNumOfNodes);

      assertThat(client.resizeCluster(instanceId, clusterId, existingClusterNodeSize))
          .isEqualTo(existingClusterNodeSize);
    }
  }
}

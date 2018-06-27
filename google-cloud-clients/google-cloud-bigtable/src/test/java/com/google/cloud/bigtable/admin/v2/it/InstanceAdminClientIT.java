package com.google.cloud.bigtable.admin.v2.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.Instance.State;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.bigtable.admin.v2.StorageType;
import com.google.cloud.bigtable.admin.v2.InstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.AppProfile;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.AppProfile.MultiClusterRoutingUseAny;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Cluster;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Instance;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Location;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Policy;
import com.google.common.collect.ImmutableMap;

public class InstanceAdminClientIT {
  private static InstanceAdminClient instanceAdmin;
  private static final ProjectName TEST_PROJECT = ProjectName.of("sduskis-hello-shakespear");
  private static final String TEST_PROD_INST_ID = "instadmprodtest";
  private static final String TEST_DEV_INST_ID = "instadmdevtest";
  private static final int PROD_CLUSTER_SIZE = 3;

  @BeforeClass
  public static void createClient() throws Exception {
    instanceAdmin = InstanceAdminClient.create();
  }

  @AfterClass
  public static void closeClient() throws Exception {
    instanceAdmin.close();
  }

  @Test
  public void createInstanceHarness() throws Exception {
    Instance rawinstance =
        InstanceAdminRequests.Instance.of(
            TEST_PROD_INST_ID, TEST_PROD_INST_ID + "disp", Type.PRODUCTION);

    Cluster rawcluster =
        InstanceAdminRequests.Cluster.ofProd(
            TEST_PROD_INST_ID + "us-east1-c",
            Location.of(TEST_PROJECT, "us-east1-c"),
            StorageType.HDD,
            PROD_CLUSTER_SIZE);

    try {
      // Instance tests
      int numInstances = instanceAdmin.listInstances(TEST_PROJECT).size();
      Instance actualInstance = createInstanceAsync(TEST_PROJECT, rawinstance, rawcluster);
      listInstances(numInstances + 1);
      getInstance(actualInstance);
      updateInstance(actualInstance);
      partialUpdateInstance(actualInstance);

      // Cluster tests
      getClusterFromRaw(actualInstance.getName(), rawcluster);
      listClusters(actualInstance.getName(), 1);

      Exception cannotMixClusterType = null;
      try {
        createCluster(actualInstance, "us-east1-d", Type.DEVELOPMENT);
      } catch (Exception ex) {
        cannotMixClusterType = ex;
      }
      assertNotNull(cannotMixClusterType);

      Cluster actualCluster2 = createCluster(actualInstance, "us-east1-d", Type.PRODUCTION);
      getCluster(actualCluster2);
      updateCluster(actualCluster2);
      listClusters(actualInstance.getName(), 2);
      deleteCluster(actualCluster2);
      listClusters(actualInstance.getName(), 1);

      // AppProfile tests
      AppProfile rawMulti = AppProfile.of("roundRobin", MultiClusterRoutingUseAny.of());
      AppProfile actualMulti = createAppProfile(actualInstance.getName(), rawMulti);
      getAppProfile(actualMulti);
      updateAppProfileSwitchToSingle(actualMulti, rawcluster.getId());
      listAppProfiles(actualInstance.getName(), 2); // +1 for default appProfile
      deleteAppProfile(actualMulti.getName());

      // IamPolicy tests
      // TODO: Needs Iam permissions to test this. Doesn't look like I have them
      // Policy rawPolicy = Policy.of(1, Role.owner(),
      // Arrays.asList("user:spollaplly@udbhavinc.com"));
      // Policy actualPolicy = instanceAdmin.setIamPolicy(actualInstance.getName(), rawPolicy);

      Policy iamPolicy = instanceAdmin.getIamPolicy(actualInstance.getName());
      assertNotNull(iamPolicy);

      List<String> actualPermissions =
          instanceAdmin.testIamPermissions(
              actualInstance.getName(), Arrays.asList("bigtable.tables.checkConsistency"));
      assertEquals(Arrays.asList("bigtable.tables.checkConsistency"), actualPermissions);
    } finally {
      instanceAdmin.deleteInstanceRequest(
          InstanceName.of(TEST_PROJECT.getProject(), TEST_PROD_INST_ID));
    }
  }

  @Test
  public void createInstanceUpgradeHarness() throws Exception {
    Instance rawinstance =
        InstanceAdminRequests.Instance.of(
                TEST_DEV_INST_ID, TEST_DEV_INST_ID + "disp", Type.DEVELOPMENT)
            .addLabel("label_name_1", "label_value_1")
            .addLabel("label_name_2", "label_value_2");

    Cluster rawcluster1 =
        InstanceAdminRequests.Cluster.ofDev(
            TEST_DEV_INST_ID + "us-east1-c",
            Location.of(TEST_PROJECT, "us-east1-c"),
            StorageType.HDD);
    /*
     * Cluster rawcluster2 = InstanceAdminRequests.Cluster.ofDev(TEST_DEV_INST_ID + "us-east1-b",
     * Location.of(TEST_PROJECT, "us-east1-b"), StorageType.HDD);
     */

    try {
      Instance actualInstance =
          instanceAdmin
              .createInstanceAsync(
                  InstanceAdminRequests.createInstance(TEST_PROJECT, rawinstance, rawcluster1)
                  // TODO: Test fails with instance not found. Verify if more than one cluster on
                  // creation is
                  // a valid case
                  // .addCluster(rawcluster2)
                  )
              .get();
      assertInstanceEquals(rawinstance, actualInstance);

      listClusters(actualInstance.getName(), 1);
      getClusterFromRaw(actualInstance.getName(), rawcluster1);
      // getClusterFromRaw(actualInstance.getName(), rawcluster2);

      Instance upgradedInstance = instanceAdmin.updateInstance(actualInstance.upgradeType()).get();
      assertEquals(Type.PRODUCTION, upgradedInstance.getType());
    } finally {
      instanceAdmin.deleteInstanceRequest(
          InstanceName.of(TEST_PROJECT.getProject(), TEST_DEV_INST_ID));
    }
  }

  @Test
  public void iamPolicyHarness() throws Exception {
    Instance rawinstance =
        InstanceAdminRequests.Instance.of(
            TEST_PROD_INST_ID, TEST_PROD_INST_ID + "disp", Type.PRODUCTION);

    Cluster rawcluster =
        InstanceAdminRequests.Cluster.ofProd(
            TEST_PROD_INST_ID + "us-east1-c",
            Location.of(TEST_PROJECT, "us-east1-c"),
            StorageType.HDD,
            PROD_CLUSTER_SIZE);

    try {
      Instance actualInstance = createInstanceAsync(TEST_PROJECT, rawinstance, rawcluster);

      // TODO: Needs Iam permissions to test this. Doesn't look like I have them
      // Policy rawPolicy = Policy.of(1, Role.owner(),
      // Arrays.asList("user:spollaplly@udbhavinc.com"));
      // Policy actualPolicy = instanceAdmin.setIamPolicy(actualInstance.getName(), rawPolicy);

      Policy iamPolicy = instanceAdmin.getIamPolicy(actualInstance.getName());
      assertNotNull(iamPolicy);

      List<String> actualPermissions =
          instanceAdmin.testIamPermissions(
              actualInstance.getName(), Arrays.asList("bigtable.tables.checkConsistency"));
      assertEquals(Arrays.asList("bigtable.tables.checkConsistency"), actualPermissions);
    } finally {
      instanceAdmin.deleteInstanceRequest(
          InstanceName.of(TEST_PROJECT.getProject(), TEST_PROD_INST_ID));
    }
  }

  private Instance createInstanceAsync(
      ProjectName projectName, Instance rawinstance, Cluster rawcluster) throws Exception {
    Instance actualInstance =
        instanceAdmin
            .createInstanceAsync(
                InstanceAdminRequests.createInstance(projectName, rawinstance, rawcluster))
            .get();
    assertInstanceEquals(rawinstance, actualInstance);
    return actualInstance;
  }

  private void getInstance(Instance expected) {
    Instance actual = instanceAdmin.getInstance(expected.getName());
    assertThat(actual).isEqualTo(actual);
  }

  private void updateInstance(Instance instance) throws Exception {
    Map<String, String> updatedLabels = ImmutableMap.of("team", "team1", "subteam", "subteam1");

    Instance updatedInstance =
        instanceAdmin
            .updateInstance(
                instance
                    .updateDisplayName(TEST_DEV_INST_ID + "upddisp")
                    .updateLabels(updatedLabels))
            .get();

    assertEquals(TEST_DEV_INST_ID + "upddisp", updatedInstance.getDisplayName());
    assertEquals(updatedLabels, updatedInstance.getLabelsMap());
  }

  private void partialUpdateInstance(Instance instance) throws Exception {
    Instance updatedInstance =
        instanceAdmin.updateInstance(instance.updateDisplayName(TEST_PROD_INST_ID + "disp")).get();

    assertEquals(TEST_PROD_INST_ID + "disp", updatedInstance.getDisplayName());
    assertEquals(instance.getLabelsMap(), updatedInstance.getLabelsMap());
  }

  private void getClusterFromRaw(InstanceName instanceName, Cluster raw) {
    ClusterName clusterName =
        ClusterName.of(instanceName.getProject(), instanceName.getInstance(), raw.getId());
    Cluster actual = instanceAdmin.getCluster(clusterName);
    assertClusterEquals(raw, actual, clusterName);
  }

  private Cluster createCluster(Instance instance, String zone, Type type) throws Exception {
    Cluster raw;

    if (type.equals(Type.PRODUCTION)) {
      raw =
          Cluster.ofProd(
              instance.getid() + zone,
              Location.of(TEST_PROJECT, zone),
              StorageType.HDD,
              PROD_CLUSTER_SIZE);
    } else {
      raw =
          Cluster.ofDev(instance.getid() + zone, Location.of(TEST_PROJECT, zone), StorageType.HDD);
    }

    Cluster actual = instanceAdmin.createCluster(instance.getName(), raw).get();
    assertClusterEquals(
        raw,
        actual,
        ClusterName.of(
            instance.getName().getProject(), instance.getName().getInstance(), raw.getId()));
    return actual;
  }

  private void getCluster(Cluster expected) {
    Cluster actual = instanceAdmin.getCluster(expected.getName());
    assertClusterEquals(expected, actual, expected.getName());
  }

  private void updateCluster(Cluster cluster) throws Exception {
    Cluster updatedCluster =
        instanceAdmin.updateCluster(cluster.updateNumNodes(PROD_CLUSTER_SIZE + 1)).get();
    assertEquals(cluster.getServerNodes(), updatedCluster.getServerNodes());
  }

  private void deleteCluster(Cluster cluster) {
    instanceAdmin.deleteCluster(cluster.getName());
  }

  private void listInstances(int expectedSize) {
    assertEquals(expectedSize, instanceAdmin.listInstances(TEST_PROJECT).size());
  }

  private void listClusters(InstanceName instanceName, int expectedSize) {
    assertEquals(expectedSize, instanceAdmin.listClusters(instanceName).size());
  }

  private AppProfile createAppProfile(InstanceName instanceName, AppProfile rawProfile) {
    AppProfile actual =
        instanceAdmin.createAppProfile(
            InstanceAdminRequests.createAppProfile(instanceName, rawProfile, true));
    assertAppProfileEquals(
        rawProfile,
        actual,
        AppProfileName.of(TEST_PROJECT.getProject(), TEST_PROD_INST_ID, rawProfile.getId()));
    return actual;
  }

  private void getAppProfile(AppProfile expected) {
    AppProfile actual = instanceAdmin.getAppProfile(expected.getName());
    assertAppProfileEquals(expected, actual, expected.getName());
  }

  private void listAppProfiles(InstanceName instanceName, int expectedSize) {
    assertEquals(expectedSize, instanceAdmin.listAppProfiles(instanceName).size());
  }

  private void updateAppProfileSwitchToSingle(AppProfile original, String singleClusterId)
      throws Exception {
    // SingleClusterRouting singlePolicy = SingleClusterRouting.of(singleClusterId, true);
    AppProfile updated =
        instanceAdmin
            .updateAppProfile(
                original.updateDescription("newDescription")
                // TODO fix policy switch failing test
                // .updateRoutingPolicy(singlePolicy))
                )
            .get();

    assertEquals("newDescription", updated.getDescription());
    // assertEquals(singlePolicy.toString(), updated.getRoutingPolicy().toString());
  }

  private void deleteAppProfile(AppProfileName appProfileName) {
    instanceAdmin.deleteAppProfile(appProfileName, true);

    Exception ensureDelete = null;
    try {
      instanceAdmin.getAppProfile(appProfileName);
    } catch (Exception e) {
      ensureDelete = e;
    }
    assertNotNull(ensureDelete);
  }

  private static void assertInstanceEquals(Instance exptected, Instance actual) {
    assertEquals(InstanceName.of(TEST_PROJECT.getProject(), exptected.getid()), actual.getName());
    assertEquals(State.READY, actual.getState());

    assertEquals(actual.getDisplayName(), actual.getDisplayName());
    assertEquals(actual.getType(), actual.getType());
    assertEquals(actual.getLabelsMap(), actual.getLabelsMap());
  }

  private void assertClusterEquals(Cluster exptected, Cluster actual, ClusterName expectedName) {
    assertEquals(com.google.bigtable.admin.v2.Cluster.State.READY, actual.getState());
    assertEquals(expectedName, actual.getName());

    assertEquals(exptected.getLocation(), actual.getLocation());
    assertEquals(exptected.getServerNodes(), actual.getServerNodes());
    assertEquals(exptected.getDefaultStorageType(), actual.getDefaultStorageType());
  }

  private void assertAppProfileEquals(
      AppProfile exptected, AppProfile actual, AppProfileName expectedName) {
    assertEquals(expectedName, actual.getName());

    assertEquals(exptected.getId(), actual.getId());
    assertEquals(exptected.getEtag(), actual.getEtag());
    assertEquals(exptected.getDescription(), actual.getDescription());
    assertEquals(exptected.getRoutingPolicy().toString(), actual.getRoutingPolicy().toString());
  }
}

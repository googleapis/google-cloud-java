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
import com.google.bigtable.admin.v2.AppProfile.RoutingPolicyCase;
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
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.Cluster;
import com.google.cloud.bigtable.admin.v2.models.InstanceAdminRequests.CreateInstance;
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
    Instance newProdInstance = Instance.ofNewProdInstance(TEST_PROD_INST_ID, "disp");

    Cluster newCluster =
        Cluster.ofNewProdCluster(
            TEST_PROD_INST_ID + "us-east1-c",
            Location.of(TEST_PROJECT.getProject(), "us-east1-c"),
            PROD_CLUSTER_SIZE);

    try {
      // Instance tests
      int numInstances = instanceAdmin.listInstances(TEST_PROJECT).size();
      Instance createdInstance = createInstance(TEST_PROJECT, newProdInstance, newCluster);
      listInstances(numInstances + 1);
      getInstance(createdInstance);
      updateInstance(createdInstance);
      partialUpdateInstance(createdInstance);

      // Cluster tests
      getCluster(
          newCluster,
          ClusterName.of(TEST_PROJECT.getProject(), TEST_PROD_INST_ID, newCluster.getId()));
      listClusters(createdInstance.getName(), 1);

      Exception cannotMixClusterType = null;
      try {
        createCluster(
            createdInstance,
            Cluster.ofNewDevCluster(
                TEST_DEV_INST_ID + "us-east1-d",
                Location.of(TEST_PROJECT.getProject(), "us-east1-d")));
      } catch (Exception ex) {
        cannotMixClusterType = ex;
      }
      assertNotNull(cannotMixClusterType);

      Cluster createdCluster2 =
          createCluster(
              createdInstance,
              Cluster.ofNewProdCluster(
                  TEST_PROD_INST_ID + "us-east1-d",
                  Location.of(TEST_PROJECT.getProject(), "us-east1-d"),
                  PROD_CLUSTER_SIZE + 1));
      getCluster(createdCluster2);
      updateCluster(createdCluster2);
      listClusters(createdInstance.getName(), 2);

      // AppProfile tests
      AppProfile createdAny =
          createAppProfile(
              createdInstance.getName(), AppProfile.ofNewAppProfile("roundRobin").routeToAny());
      getAppProfile(createdAny);
      updateAppProfileToSingle(createdAny, createdCluster2.getId());
      listAppProfiles(createdInstance.getName(), 2); // +1 for default appProfile
      deleteAppProfile(createdAny.getName());

      // IamPolicy tests
      // TODO: Needs Iam permissions to test this.
      // Policy rawPolicy = Policy.of(1, Role.owner(),
      // Arrays.asList("user:user@domain.com"));
      // Policy actualPolicy = instanceAdmin.setIamPolicy(createdInstance.getName(), rawPolicy);

      Policy iamPolicy = instanceAdmin.getIamPolicy(createdInstance.getName());
      assertNotNull(iamPolicy);

      List<String> actualPermissions =
          instanceAdmin.testIamPermissions(
              createdInstance.getName(), Arrays.asList("bigtable.tables.checkConsistency"));
      assertEquals(Arrays.asList("bigtable.tables.checkConsistency"), actualPermissions);

      deleteCluster(createdCluster2);
      listClusters(createdInstance.getName(), 1);
    } finally {
      instanceAdmin.deleteInstanceRequest(
          InstanceName.of(TEST_PROJECT.getProject(), TEST_PROD_INST_ID));
    }
  }

  @Test
  public void createInstanceMultiCluster() throws Exception {
    CreateInstance request =
        InstanceAdminRequests.createInstance(
                TEST_PROJECT,
                Instance.ofNewProdInstance("multitest", "twoclusters"),
                Cluster.ofNewProdCluster(
                    "clusterone", Location.of(TEST_PROJECT.getProject(), "us-east1-c"), 3))
            .addCluster(
                Cluster.ofNewProdCluster(
                    "clustertwo", Location.of(TEST_PROJECT.getProject(), "us-east1-c"), 4));

    try {
      Instance createdInstance = instanceAdmin.createInstanceAsync(request).get();
      getInstance(createdInstance);
      listClusters(createdInstance.getName(), 2);
    } finally {
      instanceAdmin.deleteInstanceRequest(InstanceName.of(TEST_PROJECT.getProject(), "multitest"));
    }
  }

  @Test
  public void createInstanceUpgradeHarness() throws Exception {
    Instance newDevInstance =
        Instance.ofNewDevInstance(TEST_DEV_INST_ID, TEST_DEV_INST_ID + "disp")
            .addLabel("label_name_1", "label_value_1")
            .addLabel("label_name_2", "label_value_2");

    Cluster newDevCluster =
        Cluster.ofNewDevCluster(
            TEST_DEV_INST_ID + "us-east1-c", Location.of(TEST_PROJECT.getProject(), "us-east1-c"));
    try {
      Instance createdInstance =
          instanceAdmin
              .createInstanceAsync(
                  InstanceAdminRequests.createInstance(TEST_PROJECT, newDevInstance, newDevCluster))
              .get();
      assertInstanceEquals(newDevInstance, createdInstance);

      listClusters(createdInstance.getName(), 1);
      getCluster(
          newDevCluster,
          ClusterName.of(TEST_PROJECT.getProject(), TEST_DEV_INST_ID, newDevCluster.getId()));

      Instance upgradedInstance =
          instanceAdmin
              .updateInstance(Instance.ofUpdateInstance(createdInstance).upgradeType())
              .get();
      assertEquals(Type.PRODUCTION, upgradedInstance.getType());
    } finally {
      instanceAdmin.deleteInstanceRequest(
          InstanceName.of(TEST_PROJECT.getProject(), TEST_DEV_INST_ID));
    }
  }

  /** helpers to execute and assert * */
  private Instance createInstance(ProjectName projectName, Instance newInstance, Cluster newCluster)
      throws Exception {
    Instance actualInstance =
        instanceAdmin
            .createInstanceAsync(
                InstanceAdminRequests.createInstance(projectName, newInstance, newCluster))
            .get();
    assertInstanceEquals(newInstance, actualInstance);
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
                Instance.ofUpdateInstance(instance)
                    .updateDisplayName(TEST_DEV_INST_ID + "upddisp")
                    .updateLabels(updatedLabels))
            .get();

    assertEquals(TEST_DEV_INST_ID + "upddisp", updatedInstance.getDisplayName());
    assertEquals(updatedLabels, updatedInstance.getLabelsMap());
  }

  private void partialUpdateInstance(Instance instance) throws Exception {
    Instance updatedInstance =
        instanceAdmin
            .updateInstance(
                Instance.ofUpdateInstance(instance).updateDisplayName(TEST_PROD_INST_ID + "disp"))
            .get();

    assertEquals(TEST_PROD_INST_ID + "disp", updatedInstance.getDisplayName());
    assertEquals(instance.getLabelsMap(), updatedInstance.getLabelsMap());
  }

  private void getCluster(Cluster raw, ClusterName clusterName) {
    Cluster actual = instanceAdmin.getCluster(clusterName);
    assertClusterEquals(raw, actual, clusterName);
  }

  private Cluster createCluster(Instance instance, Cluster rawCluster) throws Exception {
    Cluster actual = instanceAdmin.createCluster(instance.getName(), rawCluster).get();
    assertClusterEquals(
        rawCluster,
        actual,
        ClusterName.of(
            instance.getName().getProject(), instance.getName().getInstance(), rawCluster.getId()));
    return actual;
  }

  private void getCluster(Cluster expected) {
    Cluster actual = instanceAdmin.getCluster(expected.getName());
    assertClusterEquals(expected, actual, expected.getName());
  }

  private void updateCluster(Cluster cluster) throws Exception {
    Cluster updatedCluster =
        instanceAdmin
            .updateCluster(
                Cluster.ofUpdateCluster(cluster).updateNumNodes(cluster.getServerNodes() + 1))
            .get();
    assertEquals(cluster.getServerNodes() + 1, updatedCluster.getServerNodes());
  }

  private void deleteCluster(Cluster cluster) {
    instanceAdmin.deleteCluster(cluster.getName());
  }

  private void listInstances(int expectedSize) {
    List<Instance> instances = instanceAdmin.listInstances(TEST_PROJECT);
    assertEquals(expectedSize, instances.size());

    for (Instance instance : instances) {
      getInstance(instance);
    }
  }

  private void listClusters(InstanceName instanceName, int expectedSize) {
    List<Cluster> clusters = instanceAdmin.listClusters(instanceName);
    assertEquals(expectedSize, clusters.size());

    for (Cluster cluster : clusters) {
      getCluster(cluster);
    }
  }

  private AppProfile createAppProfile(InstanceName instanceName, AppProfile rawProfile) {
    AppProfile actual = instanceAdmin.createAppProfile(instanceName, rawProfile);
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
    List<AppProfile> appProfiles = instanceAdmin.listAppProfiles(instanceName);
    assertEquals(expectedSize, appProfiles.size());

    for (AppProfile appProfile : appProfiles) {
      getAppProfile(appProfile);
    }
  }

  private void updateAppProfileToSingle(AppProfile original, String singleClusterId)
      throws Exception {
    AppProfile updated =
        instanceAdmin
            .updateAppProfile(
                AppProfile.ofUpdateAppProfile(original)
                    .updateDescription("newDescription")
                    .updateRouteToCluster(singleClusterId, false))
            .get();

    assertEquals("newDescription", updated.getDescription());
    assertEquals(RoutingPolicyCase.SINGLE_CLUSTER_ROUTING, updated.getRoutingPolicy().name());
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
    assertEquals(exptected.getId(), actual.getId());

    assertEquals(exptected.getLocation(), actual.getLocation());
    assertEquals(exptected.getServerNodes(), actual.getServerNodes());
    assertEquals(StorageType.SSD, actual.getDefaultStorageType());
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

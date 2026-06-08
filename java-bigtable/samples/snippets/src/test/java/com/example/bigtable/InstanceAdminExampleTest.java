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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.StorageType;
import com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClientV2;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link InstanceAdminExample} */
public class InstanceAdminExampleTest extends BigtableBaseTest {

  private static final String ID_PREFIX = "instanceadmin";
  private static final String CLUSTER = "cluster";
  private static BigtableInstanceAdminClientV2 adminClient;
  private String clusterId;
  private InstanceAdminExample instanceAdmin;

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    BaseBigtableInstanceAdminSettings instanceAdminSettings =
        BaseBigtableInstanceAdminSettings.newBuilder().build();
    adminClient = BigtableInstanceAdminClientV2.create(instanceAdminSettings);
  }

  private static boolean exists(String instanceId) {
    try {
      adminClient.getInstance(
          com.google.bigtable.admin.v2.GetInstanceRequest.newBuilder()
              .setName("projects/" + projectId + "/instances/" + instanceId)
              .build());
      return true;
    } catch (com.google.api.gax.rpc.NotFoundException e) {
      return false;
    }
  }

  @AfterClass
  public static void afterClass() {
    garbageCollect();
    adminClient.close();
  }

  @Before
  public void setup() throws Exception {
    instanceId = generateId();
    clusterId = generateId();
    instanceAdmin = new InstanceAdminExample(projectId, instanceId, clusterId);
    Instance instanceObj =
        Instance.newBuilder()
            .setDisplayName(instanceId)
            .setType(Instance.Type.PRODUCTION)
            .putLabels("example", "instance_admin")
            .build();
    Cluster clusterObj =
        Cluster.newBuilder()
            .setLocation("projects/" + projectId + "/locations/us-central1-f")
            .setServeNodes(3)
            .setDefaultStorageType(StorageType.SSD)
            .build();
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent("projects/" + projectId)
            .setInstanceId(instanceId)
            .setInstance(instanceObj)
            .putClusters(clusterId, clusterObj)
            .build();
    adminClient.createInstanceAsync(request).get();
  }

  @After
  public void after() {
    if (exists(instanceId)) {
      adminClient.deleteInstance("projects/" + projectId + "/instances/" + instanceId);
    }
    if (instanceAdmin != null) {
      instanceAdmin.close();
    }
  }

  @Test
  public void testCreateAndDeleteInstance() throws IOException {
    // Creates an instance.
    String testInstance = generateId();
    String testCluster = generateId();
    InstanceAdminExample testInstanceAdmin =
        new InstanceAdminExample(projectId, testInstance, testCluster);
    testInstanceAdmin.createProdInstance(false);
    assertTrue(exists(testInstance));

    // Deletes an instance.
    testInstanceAdmin.deleteInstance();
    assertFalse(exists(testInstance));
  }

  @Test
  public void testGetInstance() {
    // Gets an instance.
    com.google.bigtable.admin.v2.Instance instance = instanceAdmin.getInstance();
    assertNotNull(instance);
  }

  @Test
  public void testAddAndDeleteCluster() {
    // Adds a cluster.
    instanceAdmin.addCluster();
    Cluster cluster =
        adminClient.getCluster(
            "projects/" + projectId + "/instances/" + instanceId + "/clusters/" + CLUSTER);
    assertNotNull(cluster);

    // Deletes a cluster.
    instanceAdmin.deleteCluster();
    assertThrows(
        NotFoundException.class,
        () ->
            adminClient.getCluster(
                "projects/" + projectId + "/instances/" + instanceId + "/clusters/" + CLUSTER));
  }

  // TODO: add test for instanceAdmin.listInstances()
  // TODO: and test for instanceAdmin.listClusters()

  @Test
  public void testRunDoesNotFail() {
    instanceAdmin.run(false);
  }

  private static String generateId() {
    return String.format("%s-%x", ID_PREFIX, new Random().nextInt());
  }

  private static void garbageCollect() {
    Pattern timestampPattern = Pattern.compile(ID_PREFIX + "-([0-9a-f]+)");
    System.out.println();
    com.google.bigtable.admin.v2.ListInstancesRequest request =
        com.google.bigtable.admin.v2.ListInstancesRequest.newBuilder()
            .setParent("projects/" + projectId)
            .build();
    for (Instance instance : adminClient.listInstances(request).getInstancesList()) {
      String id = instance.getName().substring(instance.getName().lastIndexOf("/") + 1);
      Matcher matcher = timestampPattern.matcher(id);
      if (!matcher.matches()) {
        continue;
      }
      System.out.println("Garbage collecting orphaned table: " + instance.getName());
      adminClient.deleteInstance(instance.getName());
    }
  }
}

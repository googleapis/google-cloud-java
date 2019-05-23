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

package com.m.examples.bigtable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.Instance.Type;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link InstanceAdminExample} */
public class InstanceAdminExampleTest {

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String ID_PREFIX = "instanceadmin";
  private static final String CLUSTER = "cluster";
  private static String projectId;
  private static BigtableInstanceAdminClient adminClient;
  private String clusterId;
  private String instanceId;
  private InstanceAdminExample instanceAdmin;

  @BeforeClass
  public static void beforeClass() throws IOException {
    projectId = System.getProperty(PROJECT_PROPERTY_NAME);
    if (projectId == null) {
      adminClient = null;
      return;
    }
    BigtableInstanceAdminSettings instanceAdminSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectId(projectId).build();
    adminClient = BigtableInstanceAdminClient.create(instanceAdminSettings);
  }

  @AfterClass
  public static void afterClass() {
    garbageCollect();
    adminClient.close();
  }

  @Before
  public void setup() throws IOException {
    if (adminClient == null) {
      throw new AssumptionViolatedException(
          PROJECT_PROPERTY_NAME + " property is not set, skipping integration tests.");
    }
    instanceId = generateId();
    clusterId = generateId();
    instanceAdmin = new InstanceAdminExample(projectId, instanceId, clusterId);
    adminClient.createInstance(
        CreateInstanceRequest.of(instanceId)
            .addCluster(clusterId, "us-central1-f", 3, StorageType.SSD)
            .setType(Type.PRODUCTION)
            .addLabel("example", "instance_admin"));
  }

  @After
  public void after() {
    if (adminClient.exists(instanceId)) {
      adminClient.deleteInstance(instanceId);
    }
  }

  @Test
  public void testCreateAndDeleteInstance() throws IOException {
    // Creates an instance.
    String testInstance = generateId();
    String testCluster = generateId();
    InstanceAdminExample testInstanceAdmin =
        new InstanceAdminExample(projectId, testInstance, testCluster);
    testInstanceAdmin.createProdInstance();
    assertTrue(adminClient.exists(testInstance));

    // Deletes an instance.
    testInstanceAdmin.deleteInstance();
    assertFalse(adminClient.exists(testInstance));
  }

  @Test
  public void testGetInstance() {
    // Gets an instance.
    Instance instance = instanceAdmin.getInstance();
    assertNotNull(instance);
  }

  @Test(expected = NotFoundException.class)
  public void testAddAndDeleteCluster() {
    // Adds a cluster.
    instanceAdmin.addCluster();
    Cluster cluster = adminClient.getCluster(instanceId, CLUSTER);
    assertNotNull(cluster);

    // Deletes a cluster.
    instanceAdmin.deleteCluster();
    adminClient.getCluster(instanceId, CLUSTER);
  }

  // TODO: add test for instanceAdmin.listInstances()
  // TODO: and test for instanceAdmin.listClusters()

  @Test
  public void testRunDoesNotFail() {
    instanceAdmin.run();
  }

  private static String generateId() {
    return String.format("%s-%x", ID_PREFIX, new Random().nextInt());
  }

  private static void garbageCollect() {
    Pattern timestampPattern = Pattern.compile(ID_PREFIX + "-([0-9a-f]+)");
    System.out.println();
    for (Instance instance : adminClient.listInstances()) {
      Matcher matcher = timestampPattern.matcher(instance.getId());
      if (!matcher.matches()) {
        continue;
      }
      System.out.println("Garbage collecting orphaned table: " + instance);
      adminClient.deleteInstance(instance.getId());
    }
  }
}

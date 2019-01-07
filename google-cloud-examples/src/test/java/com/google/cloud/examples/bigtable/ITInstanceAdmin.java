/*
 * Copyright 2019 Google LLC.  All Rights Reserved.
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.ProjectName;
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

/** Integration tests for {@link com.google.cloud.examples.bigtable.InstanceAdmin} */
public class ITInstanceAdmin {

  private static final String INSTANCE_PROPERTY_NAME = "bigtable.instance";
  private static final String INSTANCE_PREFIX = "instanceadmin";
  private static final String CLUSTER = "cluster" + System.currentTimeMillis();
  private static String clusterId;
  private static String instanceId;
  private static BigtableInstanceAdminClient adminClient;
  private static InstanceAdmin instanceAdmin;
  private static ProjectName projectName;

  @BeforeClass
  public static void beforeClass() throws IOException {
    String targetProject = System.getProperty(INSTANCE_PROPERTY_NAME);
    if (targetProject == null) {
      adminClient = null;
      return;
    }
    projectName = ProjectName.of(InstanceName.parse(targetProject).getProject());
    BigtableInstanceAdminSettings instanceAdminSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectName(projectName).build();
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
          INSTANCE_PROPERTY_NAME + " property is not set, skipping integration tests.");
    }
    instanceId = generateId();
    clusterId = generateId();
    instanceAdmin = new InstanceAdmin(projectName.getProject(), instanceId, clusterId);
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
    String fakeInstance = generateId();
    String fakeCluster = generateId();
    InstanceAdmin testInstanceAdmin =
        new InstanceAdmin(projectName.getProject(), fakeInstance, fakeCluster);
    testInstanceAdmin.createProdInstance();
    assertTrue(adminClient.exists(fakeInstance));

    // Deletes an instance.
    testInstanceAdmin.deleteInstance();
    assertTrue(!adminClient.exists(fakeInstance));
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
    return String.format("%s-%x", INSTANCE_PREFIX, new Random().nextInt());
  }

  private static void garbageCollect() {
    Pattern timestampPattern = Pattern.compile(INSTANCE_PREFIX + "-([0-9a-f]+)");
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

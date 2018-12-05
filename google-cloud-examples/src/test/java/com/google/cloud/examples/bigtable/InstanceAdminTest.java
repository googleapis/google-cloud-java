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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.ProjectName;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.Cluster;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.Instance.Type;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class InstanceAdminTest {

  private static final String GCLOUD_PROJECT = "test-project"; // Replace with your project ID
  private static final String PRODUCTION_INSTANCE = "test-instance";
  private static final String PRODUCTION_CLUSTER = "test-cluster" + System.currentTimeMillis();
  private static BigtableInstanceAdminSettings instanceAdminSettings;
  private static BigtableInstanceAdminClient adminClient;

  @BeforeClass
  public static void beforeClass() throws IOException {
    instanceAdminSettings =
        BigtableInstanceAdminSettings.newBuilder().setProjectName(ProjectName.of(GCLOUD_PROJECT))
            .build();
    adminClient = BigtableInstanceAdminClient.create(instanceAdminSettings);
    if (!adminClient.exists(PRODUCTION_INSTANCE)) {
      adminClient.createInstance(CreateInstanceRequest.of(PRODUCTION_INSTANCE)
          .addCluster(PRODUCTION_INSTANCE, "us-central1-f", 3, StorageType.SSD)
          .setType(Type.PRODUCTION).addLabel("example", "instance_admin"));
    }
  }

  @AfterClass
  public static void afterClass() {
    adminClient.deleteInstance(PRODUCTION_INSTANCE);
    adminClient.close();
  }

  @Test
  public void testCreateAndDeleteInstance() {
    // Create instance
    Instance instance =
        InstanceAdmin.createProdInstance(adminClient, "fake-instance", "fake-cluster");
    assertNotNull(instance);

    // Delete instance
    InstanceAdmin.deleteInstance(adminClient, "fake-instance");
    assertTrue(!adminClient.exists("fake-instance"));
  }

  @Test
  public void testListInstances() {
    // List instances
    List<Instance> instance = InstanceAdmin.listInstances(adminClient);
    assertTrue(instance.size() > 0);
  }

  @Test
  public void testGetInstance() {
    // Get instance
    Instance instance = InstanceAdmin.getInstance(adminClient, PRODUCTION_INSTANCE);
    assertNotNull(instance);
  }

  @Test
  public void testListClusters() {
    // List clusters
    List<Cluster> clusters = InstanceAdmin.listClusters(adminClient, PRODUCTION_INSTANCE);
    assertTrue(clusters.size() > 0);
  }

  @Test(expected = NotFoundException.class)
  public void testAddAndDeleteCluster() {
    // Add cluster
    Cluster cluster =
        InstanceAdmin.addCluster(adminClient, PRODUCTION_INSTANCE, PRODUCTION_CLUSTER);
    assertNotNull(cluster);

    // Delete cluster
    InstanceAdmin.deleteCluster(adminClient, PRODUCTION_INSTANCE, PRODUCTION_CLUSTER);
    adminClient.getCluster(PRODUCTION_INSTANCE, PRODUCTION_CLUSTER);
  }
}

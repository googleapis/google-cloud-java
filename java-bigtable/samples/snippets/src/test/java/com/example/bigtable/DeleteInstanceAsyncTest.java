/*
 * Copyright 2026 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.NotFoundException;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.StorageType;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClientV2;
import java.io.IOException;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link DeleteInstanceAsync}. */
public class DeleteInstanceAsyncTest extends BigtableBaseTest {

  private static final String ID_PREFIX = "delasync";
  private static BigtableInstanceAdminClientV2 adminClient;
  private String testInstanceId;

  /** Initializes test variables and the instance admin client. */
  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    adminClient = BigtableInstanceAdminClientV2.create();
  }

  /** Closes the shared instance admin client. */
  @AfterClass
  public static void afterClass() {
    if (adminClient != null) {
      adminClient.close();
    }
  }

  /** Creates a temporary instance before the test runs. */
  @Before
  public void setup() throws Exception {
    testInstanceId = generateId();
    String testClusterId = generateId();
    Instance instanceObj =
        Instance.newBuilder()
            .setDisplayName(testInstanceId)
            .setType(Instance.Type.PRODUCTION)
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
            .setInstanceId(testInstanceId)
            .setInstance(instanceObj)
            .putClusters(testClusterId, clusterObj)
            .build();
    adminClient.createInstanceAsync(request).get();
  }

  /** Cleans up the temporary instance if it still exists after the test. */
  @After
  public void after() {
    if (testInstanceId != null && exists(testInstanceId)) {
      adminClient.deleteInstance("projects/" + projectId + "/instances/" + testInstanceId);
    }
  }

  /**
   * Verifies that {@link DeleteInstanceAsync#deleteInstanceAsync(String, String)} deletes an
   * instance.
   */
  @Test
  public void testDeleteInstanceAsync() throws Exception {
    assertTrue(exists(testInstanceId));

    DeleteInstanceAsync.deleteInstanceAsync(projectId, testInstanceId);

    assertFalse(exists(testInstanceId));
    assertThat(bout.toString()).contains("Instance deleted: " + testInstanceId);
  }

  /** Checks whether the specified instance exists in the test project. */
  private static boolean exists(String targetInstanceId) {
    try {
      adminClient.getInstance(
          GetInstanceRequest.newBuilder()
              .setName("projects/" + projectId + "/instances/" + targetInstanceId)
              .build());
      return true;
    } catch (NotFoundException e) {
      return false;
    }
  }

  /** Generates a unique lowercase resource ID matching Bigtable naming rules. */
  private static String generateId() {
    return String.format("%s-%08x", ID_PREFIX, new Random().nextInt());
  }
}

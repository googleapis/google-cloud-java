/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.admin.v2.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.fail;

import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateInstanceRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateMaterializedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Instance;
import com.google.cloud.bigtable.admin.v2.models.MaterializedView;
import com.google.cloud.bigtable.admin.v2.models.StorageType;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateMaterializedViewRequest;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@Ignore("Skipping while debugging root cause for failures")
public class BigtableMaterializedViewIT {
  @ClassRule public static final TestEnvRule testEnvRule = new TestEnvRule();
  @Rule public final PrefixGenerator prefixGenerator = new PrefixGenerator();
  private static final Logger LOGGER = Logger.getLogger(BigtableMaterializedViewIT.class.getName());
  private static final int[] BACKOFF_DURATION = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

  private static BigtableInstanceAdminClient client;
  private static BigtableTableAdminClient tableAdminClient;
  private static Table testTable;
  private static String instanceId = "";

  // TODO: Update this test once emulator supports InstanceAdmin operation
  // https://github.com/googleapis/google-cloud-go/issues/1069
  @BeforeClass
  public static void validatePlatform() throws IOException {
    assume()
        .withMessage("BigtableInstanceAdminClient doesn't support on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    createInstance();
  }

  public static void createInstance() throws IOException {
    client = testEnvRule.env().getInstanceAdminClient();

    Instance instance =
        client.createInstance(
            CreateInstanceRequest.of(new PrefixGenerator().newPrefix())
                .addCluster("my-cluster", "us-east1-c", 3, StorageType.SSD));
    instanceId = instance.getId();
    tableAdminClient =
        BigtableTableAdminClient.create(testEnvRule.env().getProjectId(), instanceId);
  }

  @AfterClass
  public static void deleteInstance() {
    if (!instanceId.isEmpty()) {
      client.deleteInstance(instanceId);
    }
  }

  @Before
  public void setUp() throws InterruptedException {
    testTable = createTestTable(tableAdminClient);
  }

  @Test
  public void createMaterializedViewAndGetMaterializedViewTest() {
    String materializedViewId = prefixGenerator.newPrefix();

    CreateMaterializedViewRequest request =
        CreateMaterializedViewRequest.of(instanceId, materializedViewId)
            .setQuery(getQuery())
            .setDeletionProtection(false);
    try {
      MaterializedView response = client.createMaterializedView(request);
      assertWithMessage("Got wrong materialized view Id in CreateMaterializedView")
          .that(response.getId())
          .isEqualTo(materializedViewId);
      assertWithMessage("Got wrong deletion protection in CreateMaterializedView")
          .that(response.isDeletionProtected())
          .isFalse();
      assertWithMessage("Got wrong deletion protection in CreateMaterializedView")
          .that(response.getQuery())
          .isEqualTo(getQuery());

      response = client.getMaterializedView(instanceId, materializedViewId);
      assertWithMessage("Got wrong materialized view Id in getMaterializedView")
          .that(response.getId())
          .isEqualTo(materializedViewId);
      assertWithMessage("Got wrong deletion protection in getMaterializedView")
          .that(response.isDeletionProtected())
          .isFalse();
      assertWithMessage("Got wrong deletion protection in getMaterializedView")
          .that(response.getQuery())
          .isEqualTo(getQuery());
    } finally {
      client.deleteMaterializedView(instanceId, materializedViewId);
    }
  }

  @Test
  public void listMaterializedViewsTest() {
    String materializedViewId = prefixGenerator.newPrefix();

    try {
      MaterializedView materializedView =
          client.createMaterializedView(createMaterializedViewRequest(materializedViewId));

      List<MaterializedView> response = client.listMaterializedViews(instanceId);
      assertWithMessage("Got wrong materialized view Ids in listMaterializedViews")
          .that(response)
          .contains(materializedView);
    } finally {
      client.deleteMaterializedView(instanceId, materializedViewId);
    }
  }

  @Test
  public void updateMaterializedViewAndDeleteMaterializedViewTest() throws InterruptedException {
    String materializedViewId = prefixGenerator.newPrefix();

    // Create a deletion-protected materialized view.
    CreateMaterializedViewRequest request =
        createMaterializedViewRequest(materializedViewId).setDeletionProtection(true);

    MaterializedView response = client.createMaterializedView(request);
    assertWithMessage("Got wrong deletion protection in CreateMaterializedView")
        .that(response.isDeletionProtected())
        .isTrue();

    // We should not be able to delete the materialized view.
    try {
      client.deleteMaterializedView(instanceId, materializedViewId);
      fail("A delete-protected materialized view should not have been able to be deleted");
    } catch (FailedPreconditionException e) {
      assertWithMessage("Incorrect exception type")
          .that(e.getCause())
          .isInstanceOf(StatusRuntimeException.class);
    }

    // Update the deletion protection bit of the materialized view.
    UpdateMaterializedViewRequest updateRequest =
        UpdateMaterializedViewRequest.of(response).setDeletionProtection(false);
    response = client.updateMaterializedView(updateRequest);
    assertWithMessage("Got wrong deletion protection in UpdateMaterializedView")
        .that(response.isDeletionProtected())
        .isFalse();

    // Now we should be able to successfully delete the MaterializedView.
    client.deleteMaterializedView(instanceId, materializedViewId);
    try {
      for (int i = 0; i < BACKOFF_DURATION.length; i++) {
        client.getMaterializedView(instanceId, materializedViewId);

        LOGGER.info(
            "Wait for "
                + BACKOFF_DURATION[i]
                + " seconds for deleting materialized view "
                + materializedViewId);
        Thread.sleep(BACKOFF_DURATION[i] * 1000);
      }
      fail("MaterializedView was not deleted.");
    } catch (NotFoundException e) {
      assertWithMessage("Incorrect exception type")
          .that(e.getCause())
          .isInstanceOf(StatusRuntimeException.class);
    }
  }

  private CreateMaterializedViewRequest createMaterializedViewRequest(String materializedViewId) {
    return CreateMaterializedViewRequest.of(instanceId, materializedViewId).setQuery(getQuery());
  }

  private String getQuery() {
    return "SELECT _key, MAX(cf1['column']) as column FROM `"
        + testTable.getId()
        + "` GROUP BY _key";
  }

  private static Table createTestTable(BigtableTableAdminClient tableAdmin)
      throws InterruptedException {
    String tableId = PrefixGenerator.newPrefix("BigtableMaterializedViewIT#createTestTable");
    Table testTable = tableAdmin.createTable(CreateTableRequest.of(tableId).addFamily("cf1"));

    return testTable;
  }
}

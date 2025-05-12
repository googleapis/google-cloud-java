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
import com.google.cloud.bigtable.admin.v2.models.CreateLogicalViewRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.LogicalView;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateLogicalViewRequest;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import io.grpc.StatusRuntimeException;
import java.util.List;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BigtableLogicalViewIT {
  @ClassRule public static final TestEnvRule testEnvRule = new TestEnvRule();
  @Rule public final PrefixGenerator prefixGenerator = new PrefixGenerator();
  private static final Logger LOGGER = Logger.getLogger(BigtableLogicalViewIT.class.getName());
  private static final int[] BACKOFF_DURATION = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

  private static BigtableInstanceAdminClient client;
  private static Table testTable;

  private String instanceId = testEnvRule.env().getInstanceId();

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
  public void setUp() throws InterruptedException {
    client = testEnvRule.env().getInstanceAdminClient();
    testTable = createTestTable(testEnvRule.env().getTableAdminClient());
  }

  @Test
  public void createLogicalViewAndGetLogicalViewTest() {
    String logicalViewId = prefixGenerator.newPrefix();

    CreateLogicalViewRequest request =
        CreateLogicalViewRequest.of(instanceId, logicalViewId)
            .setQuery(getQuery())
            .setDeletionProtection(false);
    try {
      LogicalView response = client.createLogicalView(request);
      assertWithMessage("Got wrong logical view Id in CreateLogicalView")
          .that(response.getId())
          .isEqualTo(logicalViewId);
      assertWithMessage("Got wrong deletion protection in CreateLogicalView")
          .that(response.isDeletionProtected())
          .isFalse();
      assertWithMessage("Got wrong query in CreateLogicalView")
          .that(response.getQuery())
          .isEqualTo(getQuery());

      response = client.getLogicalView(instanceId, logicalViewId);
      assertWithMessage("Got wrong logical view Id in getLogicalView")
          .that(response.getId())
          .isEqualTo(logicalViewId);
      assertWithMessage("Got wrong deletion protection in getLogicalView")
          .that(response.isDeletionProtected())
          .isFalse();
      assertWithMessage("Got wrong query in getLogicalView")
          .that(response.getQuery())
          .isEqualTo(getQuery());
    } finally {
      client.deleteLogicalView(instanceId, logicalViewId);
    }
  }

  @Test
  public void listLogicalViewsTest() {
    String logicalViewId = prefixGenerator.newPrefix();

    try {
      LogicalView logicalView = client.createLogicalView(createLogicalViewRequest(logicalViewId));

      List<LogicalView> response = client.listLogicalViews(instanceId);
      assertWithMessage("Got wrong logical view Ids in listLogicalViews")
          .that(response)
          .contains(logicalView);
    } finally {
      client.deleteLogicalView(instanceId, logicalViewId);
    }
  }

  @Test
  public void updateLogicalViewAndDeleteLogicalViewTest() throws InterruptedException {
    String logicalViewId = prefixGenerator.newPrefix();

    // Create a deletion-protected logical view.
    CreateLogicalViewRequest request =
        createLogicalViewRequest(logicalViewId).setDeletionProtection(true);

    LogicalView response = client.createLogicalView(request);
    assertWithMessage("Got wrong deletion protection in CreateLogicalView")
        .that(response.isDeletionProtected())
        .isTrue();

    // We should not be able to delete the logical view.
    try {
      client.deleteLogicalView(instanceId, logicalViewId);
      fail("A delete-protected logical view should not have been able to be deleted");
    } catch (FailedPreconditionException e) {
      assertWithMessage("Incorrect exception type")
          .that(e.getCause())
          .isInstanceOf(StatusRuntimeException.class);
    }

    // Update the deletion protection bit and query of the logical view.
    String query = "SELECT 1 AS value";
    UpdateLogicalViewRequest updateRequest =
        UpdateLogicalViewRequest.of(response).setQuery(query).setDeletionProtection(false);
    response = client.updateLogicalView(updateRequest);
    assertWithMessage("Got wrong deletion protection in UpdateLogicalView")
        .that(response.isDeletionProtected())
        .isFalse();
    assertWithMessage("Got wrong query in UpdateLogicalView")
        .that(response.getQuery())
        .isEqualTo(query);

    // Now we should be able to successfully delete the LogicalView.
    client.deleteLogicalView(instanceId, logicalViewId);
    try {
      for (int i = 0; i < BACKOFF_DURATION.length; i++) {
        client.getLogicalView(instanceId, logicalViewId);

        LOGGER.info(
            "Wait for "
                + BACKOFF_DURATION[i]
                + " seconds for deleting logical view "
                + logicalViewId);
        Thread.sleep(BACKOFF_DURATION[i] * 1000);
      }
      fail("LogicalView was not deleted.");
    } catch (NotFoundException e) {
      assertWithMessage("Incorrect exception type")
          .that(e.getCause())
          .isInstanceOf(StatusRuntimeException.class);
    }
  }

  private CreateLogicalViewRequest createLogicalViewRequest(String logicalViewId) {
    return CreateLogicalViewRequest.of(instanceId, logicalViewId).setQuery(getQuery());
  }

  private String getQuery() {
    return "SELECT _key, cf1['column'] as column FROM `" + testTable.getId() + "`";
  }

  private static Table createTestTable(BigtableTableAdminClient tableAdmin)
      throws InterruptedException {
    String tableId = PrefixGenerator.newPrefix("BigtableLogicalViewIT#createTestTable");
    Table testTable = tableAdmin.createTable(CreateTableRequest.of(tableId).addFamily("cf1"));

    return testTable;
  }
}

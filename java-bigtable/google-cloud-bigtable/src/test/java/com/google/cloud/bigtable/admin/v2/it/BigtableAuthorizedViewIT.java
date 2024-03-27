/*
 * Copyright 2024 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.fail;

import com.google.api.gax.batching.Batcher;
import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.Policy;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.admin.v2.models.CreateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.FamilySubsets;
import com.google.cloud.bigtable.admin.v2.models.SubsetView;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateAuthorizedViewRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.protobuf.ByteString;
import io.grpc.StatusRuntimeException;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BigtableAuthorizedViewIT {
  @ClassRule public static final TestEnvRule testEnvRule = new TestEnvRule();
  @Rule public final PrefixGenerator prefixGenerator = new PrefixGenerator();
  private static final Logger LOGGER = Logger.getLogger(BigtableAuthorizedViewIT.class.getName());
  private static final int[] BACKOFF_DURATION = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

  private static BigtableTableAdminClient tableAdmin;
  private static BigtableDataClient dataClient;
  private static Table testTable;

  @BeforeClass
  public static void setUpClass() throws InterruptedException {
    assume()
        .withMessage("BigtableInstanceAdminClient is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    tableAdmin = testEnvRule.env().getTableAdminClient();
    dataClient = testEnvRule.env().getDataClient();

    testTable = createAndPopulateTestTable(tableAdmin, dataClient);
  }

  @AfterClass
  public static void tearDownClass() {
    if (testTable != null) {
      try {
        tableAdmin.deleteTable(testTable.getId());
      } catch (Exception e) {
        // Ignore.
      }
    }
  }

  @Test
  public void createAuthorizedViewAndGetAuthorizedViewTest() {
    String authorizedViewId = prefixGenerator.newPrefix();

    CreateAuthorizedViewRequest request =
        CreateAuthorizedViewRequest.of(testTable.getId(), authorizedViewId)
            .setAuthorizedViewType(
                SubsetView.create()
                    .addRowPrefix("row#")
                    .setFamilySubsets(
                        "cf1",
                        FamilySubsets.create()
                            .addQualifier("qualifier")
                            .addQualifierPrefix("prefix#")))
            .setDeletionProtection(false);
    try {
      AuthorizedView response = tableAdmin.createAuthorizedView(request);
      assertWithMessage("Got wrong authorized view Id in CreateAuthorizedView")
          .that(response.getId())
          .isEqualTo(authorizedViewId);
      assertWithMessage("Got wrong deletion protection in CreateAuthorizedView")
          .that(response.isDeletionProtected())
          .isFalse();
      assertWithMessage("Got wrong subset view in CreateAuthorizedView")
          .that(((SubsetView) response.getAuthorizedViewType()).getRowPrefixes())
          .containsExactly(ByteString.copyFromUtf8("row#"));
      assertWithMessage("Got wrong family subsets in CreateAuthorizedView")
          .that(((SubsetView) response.getAuthorizedViewType()).getFamilySubsets())
          .containsExactly(
              "cf1",
              FamilySubsets.create().addQualifier("qualifier").addQualifierPrefix("prefix#"));

      response = tableAdmin.getAuthorizedView(testTable.getId(), authorizedViewId);
      assertWithMessage("Got wrong authorized view Id in getAuthorizedView")
          .that(response.getId())
          .isEqualTo(authorizedViewId);
      assertWithMessage("Got wrong deletion protection in getAuthorizedView")
          .that(response.isDeletionProtected())
          .isFalse();
      assertWithMessage("Got wrong subset view in getAuthorizedView")
          .that(((SubsetView) response.getAuthorizedViewType()).getRowPrefixes())
          .containsExactly(ByteString.copyFromUtf8("row#"));
      assertWithMessage("Got wrong family subsets in getAuthorizedView")
          .that(((SubsetView) response.getAuthorizedViewType()).getFamilySubsets())
          .containsExactly(
              "cf1",
              FamilySubsets.create().addQualifier("qualifier").addQualifierPrefix("prefix#"));
    } finally {
      tableAdmin.deleteAuthorizedView(testTable.getId(), authorizedViewId);
    }
  }

  @Test
  public void listAuthorizedViewsTest() {
    String authorizedViewId1 = prefixGenerator.newPrefix();
    String authorizedViewId2 = prefixGenerator.newPrefix();

    try {
      tableAdmin.createAuthorizedView(createAuthorizedViewRequest(authorizedViewId1));
      tableAdmin.createAuthorizedView(createAuthorizedViewRequest(authorizedViewId2));

      List<String> response = tableAdmin.listAuthorizedViews(testTable.getId());
      // Concurrent tests running may cause flakiness. Use containsAtLeast instead of
      // containsExactly.
      assertWithMessage("Got wrong authorized view Ids in listAuthorizedViews")
          .that(response)
          .containsAtLeast(
              tableAdmin.getAuthorizedView(testTable.getId(), authorizedViewId1).getId(),
              tableAdmin.getAuthorizedView(testTable.getId(), authorizedViewId2).getId());
    } finally {
      tableAdmin.deleteAuthorizedView(testTable.getId(), authorizedViewId1);
      tableAdmin.deleteAuthorizedView(testTable.getId(), authorizedViewId2);
    }
  }

  @Test
  public void updateAuthorizedViewAndDeleteAuthorizedViewTest() throws InterruptedException {
    String authorizedViewId = prefixGenerator.newPrefix();

    // Create a deletion-protected authorized view.
    CreateAuthorizedViewRequest request =
        createAuthorizedViewRequest(authorizedViewId).setDeletionProtection(true);

    AuthorizedView response = tableAdmin.createAuthorizedView(request);
    assertWithMessage("Got wrong deletion protection in CreateAuthorizedView")
        .that(response.isDeletionProtected())
        .isTrue();

    // We should not be able to delete the authorized view.
    try {
      tableAdmin.deleteAuthorizedView(testTable.getId(), authorizedViewId);
      fail("A delete-protected authorized view should not have been able to be deleted");
    } catch (FailedPreconditionException e) {
      assertWithMessage("Incorrect exception type")
          .that(e.getCause())
          .isInstanceOf(StatusRuntimeException.class);
    }

    // Update the deletion protection bit of the authorized view.
    UpdateAuthorizedViewRequest updateRequest =
        UpdateAuthorizedViewRequest.of(testTable.getId(), authorizedViewId)
            .setDeletionProtection(false);
    response = tableAdmin.updateAuthorizedView(updateRequest);
    assertWithMessage("Got wrong deletion protection in UpdateAuthorizedView")
        .that(response.isDeletionProtected())
        .isFalse();

    // Now we should be able to successfully delete the AuthorizedView.
    tableAdmin.deleteAuthorizedView(testTable.getId(), authorizedViewId);
    try {
      for (int i = 0; i < BACKOFF_DURATION.length; i++) {
        tableAdmin.getAuthorizedView(testTable.getId(), authorizedViewId);

        LOGGER.info(
            "Wait for "
                + BACKOFF_DURATION[i]
                + " seconds for deleting authorized view "
                + authorizedViewId);
        Thread.sleep(BACKOFF_DURATION[i] * 1000);
      }
      fail("AuthorizedView was not deleted.");
    } catch (NotFoundException e) {
      assertWithMessage("Incorrect exception type")
          .that(e.getCause())
          .isInstanceOf(StatusRuntimeException.class);
    }
  }

  @Test
  public void authorizedViewIamTest() {
    String authorizedViewId = prefixGenerator.newPrefix();

    try {
      tableAdmin.createAuthorizedView(createAuthorizedViewRequest(authorizedViewId));
      Policy policy = tableAdmin.getAuthorizedViewIamPolicy(testTable.getId(), authorizedViewId);
      assertThat(policy).isNotNull();

      Exception actualEx = null;
      try {
        assertThat(
                tableAdmin.setAuthorizedViewIamPolicy(testTable.getId(), authorizedViewId, policy))
            .isNotNull();
      } catch (Exception iamException) {
        actualEx = iamException;
      }
      assertThat(actualEx).isNull();

      List<String> permissions =
          tableAdmin.testAuthorizedViewIamPermission(
              testTable.getId(),
              authorizedViewId,
              "bigtable.authorizedViews.get",
              "bigtable.authorizedViews.update",
              "bigtable.authorizedViews.delete");
      assertThat(permissions).hasSize(3);
    } finally {
      tableAdmin.deleteAuthorizedView(testTable.getId(), authorizedViewId);
    }
  }

  private CreateAuthorizedViewRequest createAuthorizedViewRequest(String authorizedViewId) {
    return CreateAuthorizedViewRequest.of(testTable.getId(), authorizedViewId)
        .setAuthorizedViewType(SubsetView.create());
  }

  private static Table createAndPopulateTestTable(
      BigtableTableAdminClient tableAdmin, BigtableDataClient dataClient)
      throws InterruptedException {
    String tableId =
        PrefixGenerator.newPrefix("BigtableAuthorizedViewIT#createAndPopulateTestTable");
    Table testTable = tableAdmin.createTable(CreateTableRequest.of(tableId).addFamily("cf1"));

    // Populate test data.
    byte[] rowBytes = new byte[1024];
    Random random = new Random();
    random.nextBytes(rowBytes);

    try (Batcher<RowMutationEntry, Void> batcher = dataClient.newBulkMutationBatcher(tableId)) {
      for (int i = 0; i < 10; i++) {
        batcher.add(
            RowMutationEntry.create("test-row-" + i)
                .setCell("cf1", ByteString.EMPTY, ByteString.copyFrom(rowBytes)));
      }
    }
    return testTable;
  }
}

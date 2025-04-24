/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.data.v2.it;

import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.AUTHORIZED_VIEW_COLUMN_QUALIFIER;
import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.AUTHORIZED_VIEW_ROW_PREFIX;
import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.createTestAuthorizedView;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.Assert.fail;

import com.google.api.gax.batching.Batcher;
import com.google.api.gax.batching.BatcherImpl;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlEventStats;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BulkMutateIT {

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  @Test(timeout = 60 * 1000)
  public void test() throws IOException, InterruptedException {
    BigtableDataSettings settings = testEnvRule.env().getDataClientSettings();
    String rowPrefix = UUID.randomUUID().toString();
    // Set target latency really low so it'll trigger adjusting thresholds
    BigtableDataSettings.Builder builder =
        settings.toBuilder().enableBatchMutationLatencyBasedThrottling(2L);

    try (BigtableDataClient client = BigtableDataClient.create(builder.build());
        BatcherImpl<RowMutationEntry, Void, BulkMutation, Void> batcher =
            (BatcherImpl<RowMutationEntry, Void, BulkMutation, Void>)
                client.newBulkMutationBatcher(testEnvRule.env().getTableId())) {
      FlowControlEventStats events = batcher.getFlowController().getFlowControlEventStats();
      long initialThreashold =
          Objects.requireNonNull(batcher.getFlowController().getCurrentElementCountLimit());
      assertThat(batcher.getFlowController().getCurrentElementCountLimit())
          .isNotEqualTo(batcher.getFlowController().getMinElementCountLimit());
      assertThat(batcher.getFlowController().getCurrentElementCountLimit())
          .isNotEqualTo(batcher.getFlowController().getMaxElementCountLimit());

      String familyId = testEnvRule.env().getFamilyId();
      long initial = batcher.getFlowController().getCurrentElementCountLimit();
      for (long i = 0; i < initial * 3; i++) {
        String key = rowPrefix + "test-key" + i;
        batcher.add(RowMutationEntry.create(key).setCell(familyId, "qualifier", i));
      }
      batcher.flush();
      assertThat(events.getLastFlowControlEvent()).isNotNull();
      // Verify that the threshold is adjusted
      assertThat(batcher.getFlowController().getCurrentElementCountLimit())
          .isNotEqualTo(initialThreashold);
      // Query a key to make sure the write succeeded
      Row row =
          testEnvRule
              .env()
              .getDataClient()
              .readRowsCallable()
              .first()
              .call(
                  Query.create(testEnvRule.env().getTableId())
                      .rowKey(rowPrefix + "test-key" + initial));
      assertThat(row.getCells()).hasSize(1);
    }
  }

  @Test(timeout = 60 * 1000)
  public void testOnAuthorizedView() throws IOException, InterruptedException {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    BigtableDataSettings settings = testEnvRule.env().getDataClientSettings();
    String rowPrefix = AUTHORIZED_VIEW_ROW_PREFIX + UUID.randomUUID();
    // Set target latency really low so it'll trigger adjusting thresholds
    BigtableDataSettings.Builder builder =
        settings.toBuilder().enableBatchMutationLatencyBasedThrottling(2L);

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    try (BigtableDataClient client = BigtableDataClient.create(builder.build());
        Batcher<RowMutationEntry, Void> batcher =
            client.newBulkMutationBatcher(
                AuthorizedViewId.of(testEnvRule.env().getTableId(), testAuthorizedView.getId()))) {

      String familyId = testEnvRule.env().getFamilyId();

      batcher.add(
          RowMutationEntry.create(rowPrefix + "test-key")
              .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER, "value"));
      batcher.flush();

      // Query a key to make sure the write succeeded
      Row row =
          testEnvRule
              .env()
              .getDataClient()
              .readRowsCallable()
              .first()
              .call(Query.create(testEnvRule.env().getTableId()).rowKey(rowPrefix + "test-key"));
      assertThat(row.getCells()).hasSize(1);
    }

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(testEnvRule.env().getTableId(), testAuthorizedView.getId());
  }

  @Test
  public void testManyMutations() throws IOException, InterruptedException {
    // Emulator is very slow and will take a long time for the test to run
    assume()
        .withMessage("testManyMutations is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    BigtableDataSettings settings = testEnvRule.env().getDataClientSettings();
    String rowPrefix = UUID.randomUUID().toString();

    BatchingSettings batchingSettings =
        settings.getStubSettings().bulkMutateRowsSettings().getBatchingSettings();

    settings.toBuilder()
        .stubSettings()
        .bulkMutateRowsSettings()
        .setBatchingSettings(
            batchingSettings.toBuilder().setDelayThreshold(Duration.ofHours(1)).build());
    try (BigtableDataClient client = BigtableDataClient.create(settings);
        BatcherImpl<RowMutationEntry, Void, BulkMutation, Void> batcher =
            (BatcherImpl<RowMutationEntry, Void, BulkMutation, Void>)
                client.newBulkMutationBatcher(testEnvRule.env().getTableId())) {

      String familyId = testEnvRule.env().getFamilyId();
      for (int i = 0; i < 2; i++) {
        String key = rowPrefix + "test-key";
        RowMutationEntry rowMutationEntry = RowMutationEntry.create(key);
        // Create mutation entries with many columns. The batcher should flush every time.
        for (long j = 0; j < 50001; j++) {
          rowMutationEntry.setCell(familyId, "q" + j + i, j);
        }
        batcher.add(rowMutationEntry);
      }
      batcher.flush();
      // Query a key to make sure the write succeeded
      Row row =
          testEnvRule
              .env()
              .getDataClient()
              .readRowsCallable()
              .first()
              .call(Query.create(testEnvRule.env().getTableId()).rowKey(rowPrefix + "test-key"));
      assertThat(row.getCells()).hasSize(100002);
    }
  }

  @Test(timeout = 60 * 1000)
  public void testManyMutationsOnAuthorizedView() throws IOException, InterruptedException {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    BigtableDataSettings settings = testEnvRule.env().getDataClientSettings();
    String rowPrefix = AUTHORIZED_VIEW_ROW_PREFIX + UUID.randomUUID();

    BatchingSettings batchingSettings =
        settings.getStubSettings().bulkMutateRowsSettings().getBatchingSettings();

    settings.toBuilder()
        .stubSettings()
        .bulkMutateRowsSettings()
        .setBatchingSettings(
            batchingSettings.toBuilder().setDelayThreshold(Duration.ofHours(1)).build());
    try (BigtableDataClient client = BigtableDataClient.create(settings);
        Batcher<RowMutationEntry, Void> batcher =
            client.newBulkMutationBatcher(
                AuthorizedViewId.of(testEnvRule.env().getTableId(), testAuthorizedView.getId()))) {
      String familyId = testEnvRule.env().getFamilyId();
      for (int i = 0; i < 2; i++) {
        String key = rowPrefix + "test-key";
        RowMutationEntry rowMutationEntry = RowMutationEntry.create(key);
        // Create mutation entries with many columns. The batcher should flush every time.
        for (long j = 0; j < 50001; j++) {
          rowMutationEntry.setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER + j + i, j);
        }
        batcher.add(rowMutationEntry);
      }
      batcher.flush();
      // Query a key to make sure the write succeeded
      Row row =
          client
              .readRowsCallable()
              .first()
              .call(Query.create(testEnvRule.env().getTableId()).rowKey(rowPrefix + "test-key"));
      assertThat(row.getCells()).hasSize(100002);
    }

    // We should not be able to mutate rows outside the authorized view
    try {
      try (BigtableDataClient client = BigtableDataClient.create(settings);
          Batcher<RowMutationEntry, Void> batcherOutsideAuthorizedView =
              client.newBulkMutationBatcher(
                  AuthorizedViewId.of(
                      testEnvRule.env().getTableId(), testAuthorizedView.getId()))) {
        String keyOutsideAuthorizedView = UUID.randomUUID() + "-outside-authorized-view";
        RowMutationEntry rowMutationEntry = RowMutationEntry.create(keyOutsideAuthorizedView);
        rowMutationEntry.setCell(
            testEnvRule.env().getFamilyId(), AUTHORIZED_VIEW_COLUMN_QUALIFIER, "test-value");
        batcherOutsideAuthorizedView.add(rowMutationEntry);
        batcherOutsideAuthorizedView.flush();
      }
      fail("Should not be able to apply bulk mutation on rows outside authorized view");
    } catch (Exception e) {
      // Ignore.
    }

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(testEnvRule.env().getTableId(), testAuthorizedView.getId());
  }
}

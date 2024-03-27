/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.bigtable.misc_utilities.AuthorizedViewTestHelper.createTestAuthorizedView;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.Batcher;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BulkReadIT {

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();
  private static String AUTHORIZED_VIEW_ROW_PREFIX = "row#";
  private static String AUTHORIZED_VIEW_COLUMN_QUALIFIER = "qualifier";

  @Test
  public void testBulkRead() throws InterruptedException, ExecutionException {
    BigtableDataClient client = testEnvRule.env().getDataClient();
    String family = testEnvRule.env().getFamilyId();
    String rowPrefix = UUID.randomUUID().toString();
    int numRows = 10;

    BulkMutation bulkMutation = BulkMutation.create(testEnvRule.env().getTableId());
    List<Row> expectedRows = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      bulkMutation.add(
          RowMutationEntry.create(rowPrefix + "-" + i)
              .setCell(family, "qualifier", 10_000L, "value-" + i));
      expectedRows.add(
          Row.create(
              ByteString.copyFromUtf8(rowPrefix + "-" + i),
              ImmutableList.of(
                  RowCell.create(
                      family,
                      ByteString.copyFromUtf8("qualifier"),
                      10_000L,
                      ImmutableList.<String>of(),
                      ByteString.copyFromUtf8("value-" + i)))));
    }
    client.bulkMutateRows(bulkMutation);

    try (Batcher<ByteString, Row> batcher =
        client.newBulkReadRowsBatcher(testEnvRule.env().getTableId())) {

      List<ApiFuture<Row>> rowFutures = new ArrayList<>(numRows);

      for (int rowCount = 0; rowCount < numRows; rowCount++) {
        ApiFuture<Row> entryResponse =
            batcher.add(ByteString.copyFromUtf8(rowPrefix + "-" + rowCount));

        rowFutures.add(entryResponse);
      }

      batcher.flush();
      List<Row> actualRows = ApiFutures.allAsList(rowFutures).get();
      assertThat(actualRows).isEqualTo(expectedRows);

      // To verify non-existent and duplicate row keys
      rowFutures = new ArrayList<>();

      // non-existent row key
      rowFutures.add(batcher.add(ByteString.copyFromUtf8(UUID.randomUUID().toString())));

      // duplicate row key
      rowFutures.add(batcher.add(ByteString.copyFromUtf8(rowPrefix + "-" + 0)));
      rowFutures.add(batcher.add(ByteString.copyFromUtf8(rowPrefix + "-" + 0)));

      batcher.flush();
      actualRows = ApiFutures.allAsList(rowFutures).get();
      assertThat(actualRows.get(0)).isNull();
      assertThat(actualRows.get(1)).isEqualTo(expectedRows.get(0));
      assertThat(actualRows.get(2)).isEqualTo(expectedRows.get(0));
    }
  }

  @Test
  public void testBulkReadOnAuthorizedView() throws InterruptedException, ExecutionException {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    BigtableDataClient client = testEnvRule.env().getDataClient();
    String family = testEnvRule.env().getFamilyId();
    String rowPrefix = AUTHORIZED_VIEW_ROW_PREFIX + UUID.randomUUID();
    int numRows = 10;

    BulkMutation bulkMutation = BulkMutation.create(testEnvRule.env().getTableId());
    List<Row> expectedRows = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      bulkMutation.add(
          RowMutationEntry.create(rowPrefix + "-" + i)
              .setCell(family, AUTHORIZED_VIEW_COLUMN_QUALIFIER, 10_000L, "value-" + i));
      expectedRows.add(
          Row.create(
              ByteString.copyFromUtf8(rowPrefix + "-" + i),
              ImmutableList.of(
                  RowCell.create(
                      family,
                      ByteString.copyFromUtf8(AUTHORIZED_VIEW_COLUMN_QUALIFIER),
                      10_000L,
                      ImmutableList.<String>of(),
                      ByteString.copyFromUtf8("value-" + i)))));
    }
    // Add a row outside the authorized view.
    String rowPrefixForRowOutsideAuthorizedView = rowPrefix + numRows;
    bulkMutation.add(
        RowMutationEntry.create(rowPrefixForRowOutsideAuthorizedView)
            .setCell(family, "outside-authorized-view", 10_000L, "test-value"));
    client.bulkMutateRows(bulkMutation);

    try (Batcher<ByteString, Row> batcher =
        client.newBulkReadRowsBatcher(
            AuthorizedViewId.of(testEnvRule.env().getTableId(), testAuthorizedView.getId()))) {

      List<ApiFuture<Row>> rowFutures = new ArrayList<>(numRows);

      for (int rowCount = 0; rowCount < numRows; rowCount++) {
        ApiFuture<Row> entryResponse =
            batcher.add(ByteString.copyFromUtf8(rowPrefix + "-" + rowCount));

        rowFutures.add(entryResponse);
      }

      batcher.flush();
      List<Row> actualRows = ApiFutures.allAsList(rowFutures).get();
      assertThat(actualRows).isEqualTo(expectedRows);

      // To verify non-existent and duplicate row keys
      rowFutures = new ArrayList<>();

      // non-existent row key
      rowFutures.add(batcher.add(ByteString.copyFromUtf8(UUID.randomUUID().toString())));

      // duplicate row key
      rowFutures.add(batcher.add(ByteString.copyFromUtf8(rowPrefix + "-" + 0)));
      rowFutures.add(batcher.add(ByteString.copyFromUtf8(rowPrefix + "-" + 0)));

      // row key outside authorized view
      rowFutures.add(batcher.add(ByteString.copyFromUtf8(rowPrefixForRowOutsideAuthorizedView)));

      batcher.flush();
      actualRows = ApiFutures.allAsList(rowFutures).get();
      assertThat(actualRows.get(0)).isNull();
      assertThat(actualRows.get(1)).isEqualTo(expectedRows.get(0));
      assertThat(actualRows.get(2)).isEqualTo(expectedRows.get(0));
      assertThat(actualRows.get(3)).isNull();
    }

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(testEnvRule.env().getTableId(), testAuthorizedView.getId());
  }
}

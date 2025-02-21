/*
 * Copyright 2019 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.test_helpers.env.CloudEnv;
import com.google.cloud.bigtable.test_helpers.env.PrefixGenerator;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.protobuf.ByteString;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LargeRowIT {

  private static final Logger logger = Logger.getLogger(LargeRowIT.class.getName());

  @ClassRule public static final TestEnvRule testEnvRule = new TestEnvRule();

  private BigtableTableAdminClient tableAdminClient;
  private Table table;
  private String familyId = "cf";

  @Before
  public void setup() {
    tableAdminClient = testEnvRule.env().getTableAdminClient();
    String tableId = PrefixGenerator.newPrefix("LargeRowTest");
    table = tableAdminClient.createTable(CreateTableRequest.of(tableId).addFamily(familyId));
  }

  @After
  public void tearDown() {
    if (table != null) {
      tableAdminClient.deleteTable(table.getId());
    }
  }

  @Test
  public void testWriteRead() throws Exception {
    String rowKey = UUID.randomUUID().toString();
    String familyId = testEnvRule.env().getFamilyId();

    byte[] largeValueBytes = new byte[100 * 1024 * 1024];
    Random random = new Random();
    random.nextBytes(largeValueBytes);
    ByteString largeValue = ByteString.copyFrom(largeValueBytes);

    // Create a 200 MB row
    logger.info("Sending large row, this will take awhile");
    for (int i = 0; i < 2; i++) {
      testEnvRule
          .env()
          .getDataClient()
          .mutateRowAsync(
              RowMutation.create(testEnvRule.env().getTableId(), rowKey)
                  .setCell(familyId, ByteString.copyFromUtf8("q" + i), largeValue))
          .get(10, TimeUnit.MINUTES);
    }

    logger.info("Reading large row, this will take awhile");
    // Read it back
    Row row =
        testEnvRule
            .env()
            .getDataClient()
            .readRowsCallable()
            .first()
            .call(Query.create(testEnvRule.env().getTableId()).rowKey(rowKey));

    assertThat(row.getCells()).hasSize(2);
    assertThat(row.getCells().get(0).getValue()).isEqualTo(largeValue);
    assertThat(row.getCells().get(1).getValue()).isEqualTo(largeValue);
  }

  static class AccumulatingObserver implements ResponseObserver<Row> {

    final List<Row> responses = Lists.newArrayList();
    final SettableApiFuture<Void> completionFuture = SettableApiFuture.create();

    void awaitCompletion() throws Throwable {
      try {
        completionFuture.get(10, TimeUnit.MINUTES);
      } catch (ExecutionException e) {
        throw e.getCause();
      }
    }

    @Override
    public void onStart(StreamController controller) {}

    @Override
    public void onResponse(Row row) {
      responses.add(row);
    }

    @Override
    public void onError(Throwable t) {
      completionFuture.setException(t);
    }

    @Override
    public void onComplete() {
      completionFuture.set(null);
    }
  }

  // TODO: remove the ignore annotation once the server code (large row error with metadata) is
  // released on prod
  @Test
  @Ignore("large-row-error with metadata yet to be released on prod")
  public void read() throws Throwable {
    assume()
        .withMessage("Large row read errors are not supported by emulator")
        .that(testEnvRule.env())
        .isInstanceOf(CloudEnv.class);

    BigtableDataClient client = testEnvRule.env().getDataClient();
    String tableId = table.getId();
    String familyId = this.familyId;
    long timestampMicros = System.currentTimeMillis() * 1_000;

    // small row creations
    client.bulkMutateRows(
        BulkMutation.create(tableId)
            .add(
                RowMutationEntry.create("r1")
                    .setCell(familyId, "qualifier", timestampMicros, "my-value"))
            .add(
                RowMutationEntry.create("r4")
                    .setCell(familyId, "qualifier", timestampMicros, "my-value"))
            .add(
                RowMutationEntry.create("r5")
                    .setCell(familyId, "qualifier", timestampMicros, "my-value"))
            .add(
                RowMutationEntry.create("r6")
                    .setCell(familyId, "qualifier", timestampMicros, "my-value")));

    Row expectedRow1 =
        Row.create(
            ByteString.copyFromUtf8("r1"),
            ImmutableList.of(
                RowCell.create(
                    familyId,
                    ByteString.copyFromUtf8("qualifier"),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("my-value"))));

    Row expectedRow4 =
        Row.create(
            ByteString.copyFromUtf8("r4"),
            ImmutableList.of(
                RowCell.create(
                    familyId,
                    ByteString.copyFromUtf8("qualifier"),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("my-value"))));

    // large row creation
    byte[] largeValueBytes = new byte[3 * 1024 * 1024];
    ByteString largeValue = ByteString.copyFrom(largeValueBytes);

    for (int i = 0; i < 100; i++) {
      ByteString qualifier = ByteString.copyFromUtf8("qualifier1_" + "_" + String.valueOf(i));
      client.mutateRow(
          RowMutation.create(TableId.of(tableId), "r2").setCell(familyId, qualifier, largeValue));
      client.mutateRow(
          RowMutation.create(TableId.of(tableId), "r3").setCell(familyId, qualifier, largeValue));
    }

    // sync
    assertThat(
            client
                .skipLargeRowsCallable()
                .all()
                .call(
                    Query.create(tableId)
                        .range(ByteStringRange.unbounded().startClosed("r1").endOpen("r3"))))
        .containsExactly(expectedRow1);

    assertThat(
            client
                .skipLargeRowsCallable()
                .all()
                .call(
                    Query.create(tableId)
                        .range(ByteStringRange.unbounded().startClosed("r1").endClosed("r4"))))
        .containsExactly(expectedRow1, expectedRow4);

    List<Row> emptyRows =
        client
            .skipLargeRowsCallable()
            .all()
            .call(
                Query.create(tableId)
                    .range(ByteStringRange.unbounded().startClosed("r2").endClosed("r3")));
    assertThat(emptyRows).isEmpty();

    List<Row> startWithFaultyRow =
        client
            .skipLargeRowsCallable()
            .all()
            .call(
                Query.create(tableId)
                    .range(ByteStringRange.unbounded().startClosed("r2").endClosed("r4")));
    assertThat(startWithFaultyRow).containsExactly(expectedRow4);

    List<Row> endsWithFaultyRow =
        client
            .skipLargeRowsCallable()
            .all()
            .call(
                Query.create(tableId)
                    .range(ByteStringRange.unbounded().startClosed("r1").endClosed("r3")));
    assertThat(endsWithFaultyRow).containsExactly(expectedRow1);

    assertThat(
            client
                .skipLargeRowsCallable()
                .all()
                .call(
                    Query.create(tableId)
                        .range(ByteStringRange.unbounded().startClosed("r1").endClosed("r4"))))
        .containsExactly(expectedRow1, expectedRow4);
    // async
    AccumulatingObserver observer = new AccumulatingObserver();
    Query query = Query.create(tableId).range("r1", "r3");
    client.skipLargeRowsCallable().call(query, observer);
    observer.awaitCompletion();
    assertThat(observer.responses).containsExactly(expectedRow1);

    AccumulatingObserver observer2 = new AccumulatingObserver();
    Query query2 = Query.create(tableId).range("r1", "r5");
    client.skipLargeRowsCallable().call(query2, observer2);
    observer2.awaitCompletion();
    assertThat(observer2.responses).containsExactly(expectedRow1, expectedRow4);
  }
}

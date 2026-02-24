/*
 * Copyright 2018 Google LLC
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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.test_helpers.env.EmulatorEnv;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadIT {

  private String prefix;

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  @Before
  public void setUp() {
    prefix = UUID.randomUUID().toString();
  }

  @Test
  public void isRowExists() throws Exception {
    String rowKey = prefix + "-test-row-key";
    String tableId = testEnvRule.env().getTableId();
    testEnvRule
        .env()
        .getDataClient()
        .mutateRow(
            RowMutation.create(tableId, rowKey)
                .setCell(testEnvRule.env().getFamilyId(), "qualifier", "value"));

    assertThat(testEnvRule.env().getDataClient().exists(tableId, rowKey)).isTrue();

    String nonExistingKey = prefix + "non-existing-key";
    assertThat(testEnvRule.env().getDataClient().exists(tableId, nonExistingKey)).isFalse();

    // Async
    assertThat(testEnvRule.env().getDataClient().existsAsync(tableId, rowKey).get()).isTrue();
  }

  @Test
  public void isRowExistsOnAuthorizedView() throws Exception {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    BigtableDataClient dataClient = testEnvRule.env().getDataClient();
    String tableId = testEnvRule.env().getTableId();
    String rowKey = AUTHORIZED_VIEW_ROW_PREFIX + prefix + "-isRowExistsOnAuthorizedView";
    String rowKeyOutsideAuthorizedView = prefix + "-isRowExistsOnAuthorizedView";

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    dataClient.mutateRow(
        RowMutation.create(tableId, rowKey)
            .setCell(testEnvRule.env().getFamilyId(), AUTHORIZED_VIEW_COLUMN_QUALIFIER, "value"));
    dataClient.mutateRow(
        RowMutation.create(tableId, rowKeyOutsideAuthorizedView)
            .setCell(testEnvRule.env().getFamilyId(), AUTHORIZED_VIEW_COLUMN_QUALIFIER, "value"));

    assertThat(dataClient.exists(AuthorizedViewId.of(tableId, testAuthorizedView.getId()), rowKey))
        .isTrue();
    assertThat(
            dataClient.exists(
                AuthorizedViewId.of(tableId, testAuthorizedView.getId()),
                rowKeyOutsideAuthorizedView))
        .isFalse();

    // Async
    assertThat(
            dataClient
                .existsAsync(AuthorizedViewId.of(tableId, testAuthorizedView.getId()), rowKey)
                .get())
        .isTrue();
    assertThat(
            dataClient
                .existsAsync(
                    AuthorizedViewId.of(tableId, testAuthorizedView.getId()),
                    rowKeyOutsideAuthorizedView)
                .get())
        .isFalse();

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(tableId, testAuthorizedView.getId());
  }

  @Test
  public void readEmpty() throws Throwable {
    String uniqueKey = prefix + "-readEmpty";

    Query query = Query.create(testEnvRule.env().getTableId()).rowKey(uniqueKey);

    // Sync
    ArrayList<Row> rows = Lists.newArrayList(testEnvRule.env().getDataClient().readRows(query));
    assertThat(rows).isEmpty();

    // Async
    AccumulatingObserver observer = new AccumulatingObserver();
    testEnvRule.env().getDataClient().readRowsAsync(query, observer);
    observer.awaitCompletion();
    assertThat(observer.responses).isEmpty();
  }

  @Test
  public void readEmptyOnAuthorizedView() throws Throwable {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    String tableId = testEnvRule.env().getTableId();
    BigtableDataClient dataClient = testEnvRule.env().getDataClient();
    String uniqueKey = AUTHORIZED_VIEW_ROW_PREFIX + prefix + "-readEmptyOnAuthorizedView";
    String uniqueKeyOutsideAuthorizedView = prefix + "-readEmptyOnAuthorizedView";

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    Query query =
        Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId())).rowKey(uniqueKey);
    Query queryOutsideAuthorizedView =
        Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()))
            .rowKey(uniqueKeyOutsideAuthorizedView);

    // Sync
    ArrayList<Row> rows = Lists.newArrayList(dataClient.readRows(query));
    assertThat(rows).isEmpty();

    // Row exists on the table but outside the authorized view
    dataClient.mutateRow(
        RowMutation.create(tableId, uniqueKeyOutsideAuthorizedView)
            .setCell(testEnvRule.env().getFamilyId(), AUTHORIZED_VIEW_COLUMN_QUALIFIER, "value"));
    rows = Lists.newArrayList(dataClient.readRows(queryOutsideAuthorizedView));
    assertThat(rows).isEmpty();

    // Async
    AccumulatingObserver observer = new AccumulatingObserver();
    testEnvRule.env().getDataClient().readRowsAsync(query, observer);
    observer.awaitCompletion();
    assertThat(observer.responses).isEmpty();

    // Row exists on the table but outside the authorized view
    observer = new AccumulatingObserver();
    testEnvRule.env().getDataClient().readRowsAsync(queryOutsideAuthorizedView, observer);
    observer.awaitCompletion();
    assertThat(observer.responses).isEmpty();

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(tableId, testAuthorizedView.getId());
  }

  @Test
  public void read() throws Throwable {
    int numRows = 5;
    List<Row> expectedRows = Lists.newArrayList();
    String uniqueKey = prefix + "-read";

    long timestampMicros = System.currentTimeMillis() * 1_000;

    for (int i = 0; i < numRows; i++) {
      testEnvRule
          .env()
          .getDataClient()
          .mutateRowCallable()
          .call(
              RowMutation.create(testEnvRule.env().getTableId(), uniqueKey + "-" + i)
                  .setCell(testEnvRule.env().getFamilyId(), "q", timestampMicros, "my-value"));

      expectedRows.add(
          Row.create(
              ByteString.copyFromUtf8(uniqueKey + "-" + i),
              ImmutableList.of(
                  RowCell.create(
                      testEnvRule.env().getFamilyId(),
                      ByteString.copyFromUtf8("q"),
                      timestampMicros,
                      ImmutableList.<String>of(),
                      ByteString.copyFromUtf8("my-value")))));
    }

    String tableId = testEnvRule.env().getTableId();

    // Sync
    Query query = Query.create(tableId).range(uniqueKey + "-0", uniqueKey + "-" + numRows);
    ArrayList<Row> actualResults =
        Lists.newArrayList(testEnvRule.env().getDataClient().readRows(query));

    assertThat(actualResults).containsExactlyElementsIn(expectedRows);

    // Async
    AccumulatingObserver observer = new AccumulatingObserver();
    testEnvRule.env().getDataClient().readRowsAsync(query, observer);
    observer.awaitCompletion();
    assertThat(observer.responses).containsExactlyElementsIn(expectedRows);

    // Point Sync
    Row actualRow =
        testEnvRule.env().getDataClient().readRow(tableId, expectedRows.get(0).getKey());
    assertThat(actualRow).isEqualTo(expectedRows.get(0));

    // Point Async
    ApiFuture<Row> actualRowFuture =
        testEnvRule.env().getDataClient().readRowAsync(tableId, expectedRows.get(0).getKey());
    assertThat(actualRowFuture.get()).isEqualTo(expectedRows.get(0));
  }

  @Test
  public void readOnAuthorizedView() throws Throwable {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    int numRows = 5;
    List<Row> expectedRows = Lists.newArrayList();
    String uniqueKey = AUTHORIZED_VIEW_ROW_PREFIX + prefix + "-readOnAuthorizedView";
    String uniqueKeyOutsideAuthorizedView = prefix + "-readOnAuthorizedView";
    String tableId = testEnvRule.env().getTableId();
    BigtableDataClient dataClient = testEnvRule.env().getDataClient();

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    long timestampMicros = System.currentTimeMillis() * 1_000;

    for (int i = 0; i < numRows; i++) {
      dataClient
          .mutateRowCallable()
          .call(
              RowMutation.create(tableId, uniqueKey + "-" + i)
                  .setCell(
                      testEnvRule.env().getFamilyId(),
                      AUTHORIZED_VIEW_COLUMN_QUALIFIER,
                      timestampMicros,
                      "my-value"));

      expectedRows.add(
          Row.create(
              ByteString.copyFromUtf8(uniqueKey + "-" + i),
              ImmutableList.of(
                  RowCell.create(
                      testEnvRule.env().getFamilyId(),
                      ByteString.copyFromUtf8(AUTHORIZED_VIEW_COLUMN_QUALIFIER),
                      timestampMicros,
                      ImmutableList.<String>of(),
                      ByteString.copyFromUtf8("my-value")))));
    }
    // Add a few rows that outside the authorized view
    for (int i = 0; i < numRows; i++) {
      dataClient
          .mutateRowCallable()
          .call(
              RowMutation.create(tableId, uniqueKeyOutsideAuthorizedView + "-" + i)
                  .setCell(
                      testEnvRule.env().getFamilyId(),
                      AUTHORIZED_VIEW_COLUMN_QUALIFIER,
                      timestampMicros,
                      "my-value"));
    }

    // Sync
    Query query =
        Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()))
            .range(uniqueKey + "-0", uniqueKey + "-" + numRows);
    Query queryOutsideAuthorizedView =
        Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()))
            .range(
                uniqueKeyOutsideAuthorizedView + "-0",
                uniqueKeyOutsideAuthorizedView + "-" + numRows);

    ArrayList<Row> actualResults = Lists.newArrayList(dataClient.readRows(query));
    assertThat(actualResults).containsExactlyElementsIn(expectedRows);

    // rows exist but outside the authorized view
    ArrayList<Row> results = Lists.newArrayList(dataClient.readRows(queryOutsideAuthorizedView));
    assertThat(results).isEmpty();

    // Async
    AccumulatingObserver observer = new AccumulatingObserver();
    dataClient.readRowsAsync(query, observer);
    observer.awaitCompletion();
    assertThat(observer.responses).containsExactlyElementsIn(expectedRows);

    // Rows exist but outside the authorized view
    observer = new AccumulatingObserver();
    dataClient.readRowsAsync(queryOutsideAuthorizedView, observer);
    observer.awaitCompletion();
    assertThat(observer.responses).isEmpty();

    // Point Sync
    Row actualRow =
        dataClient.readRow(
            AuthorizedViewId.of(tableId, testAuthorizedView.getId()), expectedRows.get(0).getKey());
    assertThat(actualRow).isEqualTo(expectedRows.get(0));

    // Row exists but outside the authorized view
    assertThat(
            dataClient.readRow(
                AuthorizedViewId.of(tableId, testAuthorizedView.getId()),
                uniqueKeyOutsideAuthorizedView + "-0"))
        .isNull();

    // Point Async
    ApiFuture<Row> actualRowFuture =
        dataClient.readRowAsync(
            AuthorizedViewId.of(tableId, testAuthorizedView.getId()), expectedRows.get(0).getKey());
    assertThat(actualRowFuture.get()).isEqualTo(expectedRows.get(0));

    // Row exists but outside the authorized view
    assertThat(
            dataClient
                .readRowAsync(
                    AuthorizedViewId.of(tableId, testAuthorizedView.getId()),
                    uniqueKeyOutsideAuthorizedView + "-0")
                .get())
        .isNull();

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(tableId, testAuthorizedView.getId());
  }

  @Test
  public void rangeQueries() {
    BigtableDataClient client = testEnvRule.env().getDataClient();
    String tableId = testEnvRule.env().getTableId();
    String familyId = testEnvRule.env().getFamilyId();
    String uniqueKey = prefix + "-range-queries";
    String keyA = uniqueKey + "-" + "a";
    String keyZ = uniqueKey + "-" + "z";

    long timestampMicros = System.currentTimeMillis() * 1_000;

    client.bulkMutateRows(
        BulkMutation.create(tableId)
            .add(RowMutationEntry.create(keyA).setCell(familyId, "", timestampMicros, "A"))
            .add(RowMutationEntry.create(keyZ).setCell(familyId, "", timestampMicros, "Z")));

    Row expectedRowA =
        Row.create(
            ByteString.copyFromUtf8(keyA),
            ImmutableList.of(
                RowCell.create(
                    testEnvRule.env().getFamilyId(),
                    ByteString.copyFromUtf8(""),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("A"))));

    Row expectedRowZ =
        Row.create(
            ByteString.copyFromUtf8(keyZ),
            ImmutableList.of(
                RowCell.create(
                    testEnvRule.env().getFamilyId(),
                    ByteString.copyFromUtf8(""),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("Z"))));

    // Closed/Open
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(tableId)
                        .range(ByteStringRange.unbounded().startClosed(keyA).endOpen(keyZ)))))
        .containsExactly(expectedRowA);

    // Closed/Closed
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(tableId)
                        .range(ByteStringRange.unbounded().startClosed(keyA).endClosed(keyZ)))))
        .containsExactly(expectedRowA, expectedRowZ);

    // Open/Closed
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(tableId)
                        .range(ByteStringRange.unbounded().startOpen(keyA).endClosed(keyZ)))))
        .containsExactly(expectedRowZ);

    // Open/Open
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(tableId)
                        .range(ByteStringRange.unbounded().startOpen(keyA).endOpen(keyZ)))))
        .isEmpty();
  }

  @Test
  public void rangeQueriesOnAuthorizedView() throws InterruptedException {
    assume()
        .withMessage("AuthorizedView is not supported on Emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    BigtableDataClient client = testEnvRule.env().getDataClient();
    String tableId = testEnvRule.env().getTableId();
    String familyId = testEnvRule.env().getFamilyId();
    String uniqueKey = AUTHORIZED_VIEW_ROW_PREFIX + prefix + "-rangeQueriesOnAuthorizedView";
    String keyA = uniqueKey + "-" + "a";
    String keyZ = uniqueKey + "-" + "z";
    String keyOutsideAuthorizedView = prefix;

    AuthorizedView testAuthorizedView = createTestAuthorizedView(testEnvRule);

    long timestampMicros = System.currentTimeMillis() * 1_000;

    client.bulkMutateRows(
        BulkMutation.create(tableId)
            .add(
                RowMutationEntry.create(keyA)
                    .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER, timestampMicros, "A"))
            .add(
                RowMutationEntry.create(keyZ)
                    .setCell(familyId, AUTHORIZED_VIEW_COLUMN_QUALIFIER, timestampMicros, "Z"))
            .add(
                RowMutationEntry.create(keyOutsideAuthorizedView)
                    .setCell(
                        familyId,
                        AUTHORIZED_VIEW_COLUMN_QUALIFIER,
                        timestampMicros,
                        "outsideAuthorizedView")));

    Row expectedRowA =
        Row.create(
            ByteString.copyFromUtf8(keyA),
            ImmutableList.of(
                RowCell.create(
                    testEnvRule.env().getFamilyId(),
                    ByteString.copyFromUtf8(AUTHORIZED_VIEW_COLUMN_QUALIFIER),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("A"))));

    Row expectedRowZ =
        Row.create(
            ByteString.copyFromUtf8(keyZ),
            ImmutableList.of(
                RowCell.create(
                    testEnvRule.env().getFamilyId(),
                    ByteString.copyFromUtf8(AUTHORIZED_VIEW_COLUMN_QUALIFIER),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("Z"))));

    // Closed/Open
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()))
                        .range(ByteStringRange.unbounded().startClosed(keyA).endOpen(keyZ)))))
        .containsExactly(expectedRowA);

    // Closed/Closed
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()))
                        .range(ByteStringRange.unbounded().startClosed(keyA).endClosed(keyZ)))))
        .containsExactly(expectedRowA, expectedRowZ);

    // Open/Closed
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()))
                        .range(ByteStringRange.unbounded().startOpen(keyA).endClosed(keyZ)))))
        .containsExactly(expectedRowZ);

    // Open/Open
    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(AuthorizedViewId.of(tableId, testAuthorizedView.getId()))
                        .range(ByteStringRange.unbounded().startOpen(keyA).endOpen(keyZ)))))
        .isEmpty();

    testEnvRule
        .env()
        .getTableAdminClient()
        .deleteAuthorizedView(tableId, testAuthorizedView.getId());
  }

  @Test
  public void reversed() {
    assume()
        .withMessage("reverse scans are not supported in the emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);
    BigtableDataClient client = testEnvRule.env().getDataClient();
    String tableId = testEnvRule.env().getTableId();
    String familyId = testEnvRule.env().getFamilyId();
    String uniqueKey = prefix + "-rev-queries";
    String keyA = uniqueKey + "-" + "a";
    String keyB = uniqueKey + "-" + "b";
    String keyC = uniqueKey + "-" + "c";

    long timestampMicros = System.currentTimeMillis() * 1_000;

    client.bulkMutateRows(
        BulkMutation.create(tableId)
            .add(RowMutationEntry.create(keyA).setCell(familyId, "", timestampMicros, "A"))
            .add(RowMutationEntry.create(keyB).setCell(familyId, "", timestampMicros, "B"))
            .add(RowMutationEntry.create(keyC).setCell(familyId, "", timestampMicros, "C")));

    Row expectedRowA =
        Row.create(
            ByteString.copyFromUtf8(keyA),
            ImmutableList.of(
                RowCell.create(
                    testEnvRule.env().getFamilyId(),
                    ByteString.copyFromUtf8(""),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("A"))));

    Row expectedRowB =
        Row.create(
            ByteString.copyFromUtf8(keyB),
            ImmutableList.of(
                RowCell.create(
                    testEnvRule.env().getFamilyId(),
                    ByteString.copyFromUtf8(""),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("B"))));
    Row expectedRowC =
        Row.create(
            ByteString.copyFromUtf8(keyC),
            ImmutableList.of(
                RowCell.create(
                    testEnvRule.env().getFamilyId(),
                    ByteString.copyFromUtf8(""),
                    timestampMicros,
                    ImmutableList.<String>of(),
                    ByteString.copyFromUtf8("C"))));

    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(tableId).reversed(true).range(ByteStringRange.prefix(uniqueKey)))))
        .containsExactly(expectedRowC, expectedRowB, expectedRowA)
        .inOrder();

    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(tableId)
                        .reversed(true)
                        .range(ByteStringRange.prefix(uniqueKey))
                        .limit(2))))
        .containsExactly(expectedRowC, expectedRowB)
        .inOrder();

    assertThat(
            ImmutableList.copyOf(
                client.readRows(
                    Query.create(tableId)
                        .reversed(true)
                        .range(ByteStringRange.unbounded().endOpen(keyC))
                        .limit(2))))
        .containsExactly(expectedRowB, expectedRowA)
        .inOrder();
  }

  @Test
  @Ignore("Test taking too long to run, ignore for now")
  public void reversedWithForcedResumption() throws IOException, InterruptedException {
    assume()
        .withMessage("reverse scans are not supported in the emulator")
        .that(testEnvRule.env())
        .isNotInstanceOf(EmulatorEnv.class);

    BigtableDataClient client = testEnvRule.env().getDataClient();
    String tableId = testEnvRule.env().getTableId();
    String familyId = testEnvRule.env().getFamilyId();
    String uniqueKey = prefix + "-rev-queries2";

    // Add enough rows that ensures resumption logic is forced
    Random random;
    List<Row> expectedResults;
    try (Batcher<RowMutationEntry, Void> batcher = client.newBulkMutationBatcher(tableId)) {

      byte[] valueBytes = new byte[1024];
      random = new Random();

      expectedResults = new ArrayList<>();

      for (int i = 0; i < 2 * 1024; i++) {
        ByteString key = ByteString.copyFromUtf8(String.format("%s-%05d", uniqueKey, i));
        ByteString qualifier = ByteString.copyFromUtf8("q");
        long timestamp = System.currentTimeMillis() * 1000;
        random.nextBytes(valueBytes);
        ByteString value = ByteString.copyFrom(valueBytes);

        batcher.add(RowMutationEntry.create(key).setCell(familyId, qualifier, timestamp, value));
        expectedResults.add(
            Row.create(
                key,
                ImmutableList.of(
                    RowCell.create(familyId, qualifier, timestamp, ImmutableList.of(), value))));
      }
    }
    Collections.reverse(expectedResults);

    BigtableDataSettings.Builder settingsBuilder =
        testEnvRule.env().getDataClientSettings().toBuilder();

    settingsBuilder.stubSettings().readRowsSettings().retrySettings().setMaxAttempts(100);

    InstantiatingGrpcChannelProvider.Builder transport =
        ((InstantiatingGrpcChannelProvider)
                settingsBuilder.stubSettings().getTransportChannelProvider())
            .toBuilder();
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> oldConfigurator =
        transport.getChannelConfigurator();

    // Randomly camp the deadline to force a timeout to force a retry
    transport.setChannelConfigurator(
        (ManagedChannelBuilder c) -> {
          if (oldConfigurator != null) {
            c = oldConfigurator.apply(c);
          }
          return c.intercept(
              new ClientInterceptor() {
                @Override
                public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                    MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
                  if (method.getBareMethodName().equals("ReadRows")) {
                    callOptions =
                        callOptions.withDeadlineAfter(random.nextInt(200), TimeUnit.MILLISECONDS);
                  }

                  return next.newCall(method, callOptions);
                }
              });
        });
    settingsBuilder.stubSettings().setTransportChannelProvider(transport.build());

    try (BigtableDataClient patchedClient = BigtableDataClient.create(settingsBuilder.build())) {
      for (int i = 0; i < 10; i++) {
        List<Row> actualResults = new ArrayList<>();
        for (Row row :
            patchedClient.readRows(Query.create(tableId).prefix(uniqueKey).reversed(true))) {
          actualResults.add(row);
          Thread.sleep(1);
        }
        assertThat(actualResults).containsExactlyElementsIn(expectedResults).inOrder();
      }
    }
  }

  @Test
  public void readSingleNonexistentAsyncCallback() throws Exception {
    ApiFuture<Row> future =
        testEnvRule
            .env()
            .getDataClient()
            .readRowAsync(testEnvRule.env().getTableId(), "somenonexistentkey");

    final AtomicReference<Throwable> unexpectedError = new AtomicReference<>();
    final AtomicBoolean found = new AtomicBoolean();
    final CountDownLatch latch = new CountDownLatch(1);

    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<Row>() {
          @Override
          public void onFailure(Throwable t) {
            unexpectedError.set(t);
            latch.countDown();
          }

          @Override
          public void onSuccess(Row result) {
            found.set(true);
            latch.countDown();
          }
        },
        MoreExecutors.directExecutor());

    latch.await(1, TimeUnit.MINUTES);

    if (unexpectedError.get() != null) {
      throw new RuntimeException("Unexpected async error", unexpectedError.get());
    }
    assertThat(found.get()).isTrue();
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
}

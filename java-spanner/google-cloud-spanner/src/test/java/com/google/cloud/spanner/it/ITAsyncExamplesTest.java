/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.AsyncRunner;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for asynchronous APIs. */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITAsyncExamplesTest {
  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();
  private static final String TABLE_NAME = "TestTable";
  private static final String INDEX_NAME = "TestTableByValue";
  private static final List<String> ALL_COLUMNS = Arrays.asList("Key", "StringValue");
  private static final ImmutableList<String> ALL_VALUES_IN_PK_ORDER =
      ImmutableList.of(
          "v0", "v1", "v10", "v11", "v12", "v13", "v14", "v2", "v3", "v4", "v5", "v6", "v7", "v8",
          "v9");

  private static Database db;
  private static DatabaseClient client;
  private static ExecutorService executor;

  @BeforeClass
  public static void setUpDatabase() {
    db =
        env.getTestHelper()
            .createTestDatabase(
                "CREATE TABLE TestTable ("
                    + "  Key                STRING(MAX) NOT NULL,"
                    + "  StringValue        STRING(MAX),"
                    + ") PRIMARY KEY (Key)",
                "CREATE INDEX TestTableByValue ON TestTable(StringValue)",
                "CREATE INDEX TestTableByValueDesc ON TestTable(StringValue DESC)");
    client = env.getTestHelper().getDatabaseClient(db);

    // Includes k0..k14.  Note that strings k{10,14} sort between k1 and k2.
    List<Mutation> mutations = new ArrayList<>();
    for (int i = 0; i < 15; ++i) {
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to("k" + i)
              .set("StringValue")
              .to("v" + i)
              .build());
    }
    client.write(mutations);
    executor = Executors.newScheduledThreadPool(8);
  }

  @AfterClass
  public static void cleanup() {
    executor.shutdown();
  }

  @Test
  public void readAsync() throws Exception {
    final SettableApiFuture<List<String>> future = SettableApiFuture.create();
    try (AsyncResultSet rs = client.singleUse().readAsync(TABLE_NAME, KeySet.all(), ALL_COLUMNS)) {
      rs.setCallback(
          executor,
          new ReadyCallback() {
            final List<String> values = new LinkedList<>();

            @Override
            public CallbackResponse cursorReady(AsyncResultSet resultSet) {
              try {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case DONE:
                      future.set(values);
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case OK:
                      values.add(resultSet.getString("StringValue"));
                      break;
                  }
                }
              } catch (Throwable t) {
                future.setException(t);
                return CallbackResponse.DONE;
              }
            }
          });
    }
    assertThat(future.get()).containsExactlyElementsIn(ALL_VALUES_IN_PK_ORDER);
  }

  @Test
  public void readUsingIndexAsync() throws Exception {
    final SettableApiFuture<List<String>> future = SettableApiFuture.create();
    try (AsyncResultSet rs =
        client.singleUse().readUsingIndexAsync(TABLE_NAME, INDEX_NAME, KeySet.all(), ALL_COLUMNS)) {
      rs.setCallback(
          executor,
          new ReadyCallback() {
            final List<String> values = new LinkedList<>();

            @Override
            public CallbackResponse cursorReady(AsyncResultSet resultSet) {
              try {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case DONE:
                      future.set(values);
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case OK:
                      values.add(resultSet.getString("StringValue"));
                      break;
                  }
                }
              } catch (Throwable t) {
                future.setException(t);
                return CallbackResponse.DONE;
              }
            }
          });
    }
    assertThat(future.get()).containsExactlyElementsIn(ALL_VALUES_IN_PK_ORDER);
  }

  @Test
  public void readRowAsync() throws Exception {
    ApiFuture<Struct> row = client.singleUse().readRowAsync(TABLE_NAME, Key.of("k1"), ALL_COLUMNS);
    assertThat(row.get().getString("StringValue")).isEqualTo("v1");
  }

  @Test
  public void readRowUsingIndexAsync() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse()
            .readRowUsingIndexAsync(TABLE_NAME, INDEX_NAME, Key.of("v2"), ALL_COLUMNS);
    assertThat(row.get().getString("Key")).isEqualTo("k2");
  }

  @Test
  public void executeQueryAsync() throws Exception {
    final ImmutableList<String> keys = ImmutableList.of("k3", "k4");
    final SettableApiFuture<List<String>> future = SettableApiFuture.create();
    try (AsyncResultSet rs =
        client
            .singleUse()
            .executeQueryAsync(
                Statement.newBuilder("SELECT StringValue FROM TestTable WHERE Key IN UNNEST(@keys)")
                    .bind("keys")
                    .toStringArray(keys)
                    .build())) {
      rs.setCallback(
          executor,
          new ReadyCallback() {
            final List<String> values = new LinkedList<>();

            @Override
            public CallbackResponse cursorReady(AsyncResultSet resultSet) {
              try {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case DONE:
                      future.set(values);
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case OK:
                      values.add(resultSet.getString("StringValue"));
                      break;
                  }
                }
              } catch (Throwable t) {
                future.setException(t);
                return CallbackResponse.DONE;
              }
            }
          });
    }
    assertThat(future.get()).containsExactly("v3", "v4");
  }

  @Test
  public void runAsync() throws Exception {
    AsyncRunner runner = client.runAsync();
    ApiFuture<Long> insertCount =
        runner.runAsync(
            txn -> {
              // Even though this is a shoot-and-forget asynchronous DML statement, it is
              // guaranteed to be executed within the transaction before the commit is executed.
              return txn.executeUpdateAsync(
                  Statement.newBuilder(
                          "INSERT INTO TestTable (Key, StringValue) VALUES (@key, @value)")
                      .bind("key")
                      .to("k999")
                      .bind("value")
                      .to("v999")
                      .build());
            },
            executor);
    assertThat(insertCount.get()).isEqualTo(1L);
    if (env.getTestHelper().getOptions().getSessionPoolOptions().getUseMultiplexedSessionForRW()) {
      // The runAsync() method should only be called once on the runner.
      // However, due to a bug in regular sessions, it can be executed multiple times on the same
      // runner.
      runner = client.runAsync();
    }
    ApiFuture<Long> deleteCount =
        runner.runAsync(
            txn ->
                txn.executeUpdateAsync(
                    Statement.newBuilder("DELETE FROM TestTable WHERE Key=@key")
                        .bind("key")
                        .to("k999")
                        .build()),
            executor);
    assertThat(deleteCount.get()).isEqualTo(1L);
  }

  @Test
  public void runAsyncBatchUpdate() throws Exception {
    AsyncRunner runner = client.runAsync();
    ApiFuture<long[]> insertCount =
        runner.runAsync(
            txn -> {
              // Even though this is a shoot-and-forget asynchronous DML statement, it is
              // guaranteed to be executed within the transaction before the commit is executed.
              return txn.batchUpdateAsync(
                  ImmutableList.of(
                      Statement.newBuilder(
                              "INSERT INTO TestTable (Key, StringValue) VALUES (@key, @value)")
                          .bind("key")
                          .to("k997")
                          .bind("value")
                          .to("v997")
                          .build(),
                      Statement.newBuilder(
                              "INSERT INTO TestTable (Key, StringValue) VALUES (@key, @value)")
                          .bind("key")
                          .to("k998")
                          .bind("value")
                          .to("v998")
                          .build(),
                      Statement.newBuilder(
                              "INSERT INTO TestTable (Key, StringValue) VALUES (@key, @value)")
                          .bind("key")
                          .to("k999")
                          .bind("value")
                          .to("v999")
                          .build()));
            },
            executor);
    assertThat(insertCount.get()).asList().containsExactly(1L, 1L, 1L);
    if (env.getTestHelper().getOptions().getSessionPoolOptions().getUseMultiplexedSessionForRW()) {
      // The runAsync() method should only be called once on the runner.
      // However, due to a bug in regular sessions, it can be executed multiple times on the same
      // runner.
      runner = client.runAsync();
    }
    ApiFuture<long[]> deleteCount =
        runner.runAsync(
            txn ->
                txn.batchUpdateAsync(
                    ImmutableList.of(
                        Statement.newBuilder("DELETE FROM TestTable WHERE Key=@key")
                            .bind("key")
                            .to("k997")
                            .build(),
                        Statement.newBuilder("DELETE FROM TestTable WHERE Key=@key")
                            .bind("key")
                            .to("k998")
                            .build(),
                        Statement.newBuilder("DELETE FROM TestTable WHERE Key=@key")
                            .bind("key")
                            .to("k999")
                            .build())),
            executor);
    assertThat(deleteCount.get()).asList().containsExactly(1L, 1L, 1L);
  }

  @Test
  public void readOnlyTransaction() throws Exception {
    ImmutableList<String> keys1 = ImmutableList.of("k10", "k11", "k12");
    ImmutableList<String> keys2 = ImmutableList.of("k1", "k2", "k3");
    ApiFuture<List<String>> values1;
    ApiFuture<List<String>> values2;
    try (ReadOnlyTransaction tx = client.readOnlyTransaction()) {
      try (AsyncResultSet rs =
          tx.executeQueryAsync(
              Statement.newBuilder("SELECT * FROM TestTable WHERE Key IN UNNEST(@keys)")
                  .bind("keys")
                  .toStringArray(keys1)
                  .build())) {
        values1 = rs.toListAsync(input -> input.getString("StringValue"), executor);
      }
      try (AsyncResultSet rs =
          tx.executeQueryAsync(
              Statement.newBuilder("SELECT * FROM TestTable WHERE Key IN UNNEST(@keys)")
                  .bind("keys")
                  .toStringArray(keys2)
                  .build())) {
        values2 = rs.toListAsync(input -> input.getString("StringValue"), executor);
      }
    }

    ApiFuture<List<List<String>>> allAsListValues =
        ApiFutures.allAsList(Arrays.asList(values1, values2));
    ApiFuture<Iterable<String>> allValues =
        ApiFutures.transform(
            allAsListValues,
            input ->
                Iterables.mergeSorted(
                    input, Comparator.comparing(o -> Integer.valueOf(o.substring(1)))),
            executor);
    assertThat(allValues.get()).containsExactly("v1", "v2", "v3", "v10", "v11", "v12");
  }

  @Test
  public void pauseResume() throws Exception {
    Statement unevenStatement =
        Statement.of(
            "SELECT * FROM TestTable WHERE MOD(CAST(SUBSTR(Key, 2) AS INT64), 2) = 1 ORDER BY"
                + " CAST(SUBSTR(Key, 2) AS INT64)");
    Statement evenStatement =
        Statement.of(
            "SELECT * FROM TestTable WHERE MOD(CAST(SUBSTR(Key, 2) AS INT64), 2) = 0 ORDER BY"
                + " CAST(SUBSTR(Key, 2) AS INT64)");

    final Object lock = new Object();
    final SettableApiFuture<Boolean> evenFinished = SettableApiFuture.create();
    final SettableApiFuture<Boolean> unevenFinished = SettableApiFuture.create();
    final CountDownLatch evenReturnedFirstRow = new CountDownLatch(1);
    final Deque<String> allValues = new LinkedList<>();
    try (ReadOnlyTransaction tx = client.readOnlyTransaction()) {
      try (AsyncResultSet evenRs = tx.executeQueryAsync(evenStatement);
          AsyncResultSet unevenRs = tx.executeQueryAsync(unevenStatement)) {
        evenRs.setCallback(
            executor,
            resultSet -> {
              try {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case DONE:
                      evenFinished.set(true);
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case OK:
                      synchronized (lock) {
                        allValues.add(resultSet.getString("StringValue"));
                      }
                      evenReturnedFirstRow.countDown();
                      return CallbackResponse.PAUSE;
                  }
                }
              } catch (Throwable t) {
                evenFinished.setException(t);
                return CallbackResponse.DONE;
              }
            });

        unevenRs.setCallback(
            executor,
            resultSet -> {
              try {
                // Make sure the even result set has returned the first before we start the uneven
                // results.
                evenReturnedFirstRow.await();
                while (true) {
                  switch (resultSet.tryNext()) {
                    case DONE:
                      unevenFinished.set(true);
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case OK:
                      synchronized (lock) {
                        allValues.add(resultSet.getString("StringValue"));
                      }
                      return CallbackResponse.PAUSE;
                  }
                }
              } catch (Throwable t) {
                unevenFinished.setException(t);
                return CallbackResponse.DONE;
              }
            });
        while (!(evenFinished.isDone() && unevenFinished.isDone())) {
          synchronized (lock) {
            if (allValues.peekLast() != null) {
              if (Integer.parseInt(allValues.peekLast().substring(1)) % 2 == 1) {
                evenRs.resume();
              } else {
                unevenRs.resume();
              }
            }
            if (allValues.size() == 15) {
              unevenRs.resume();
              evenRs.resume();
            }
          }
        }
      }
    }
    assertThat(ApiFutures.allAsList(Arrays.asList(evenFinished, unevenFinished)).get())
        .containsExactly(Boolean.TRUE, Boolean.TRUE);
    assertThat(allValues)
        .containsExactly(
            "v0", "v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10", "v11", "v12", "v13",
            "v14");
  }

  @Test
  public void cancel() throws Exception {
    final List<String> values = new LinkedList<>();
    final SettableApiFuture<Boolean> finished = SettableApiFuture.create();
    final CountDownLatch receivedFirstRow = new CountDownLatch(1);
    final CountDownLatch cancelled = new CountDownLatch(1);
    try (AsyncResultSet rs = client.singleUse().readAsync(TABLE_NAME, KeySet.all(), ALL_COLUMNS)) {
      rs.setCallback(
          executor,
          resultSet -> {
            try {
              while (true) {
                switch (resultSet.tryNext()) {
                  case DONE:
                    finished.set(true);
                    return CallbackResponse.DONE;
                  case NOT_READY:
                    return CallbackResponse.CONTINUE;
                  case OK:
                    values.add(resultSet.getString("StringValue"));
                    receivedFirstRow.countDown();
                    cancelled.await();
                    break;
                }
              }
            } catch (Throwable t) {
              finished.setException(t);
              return CallbackResponse.DONE;
            }
          });
      receivedFirstRow.await();
      rs.cancel();
    }
    cancelled.countDown();
    try {
      finished.get();
      fail("missing expected exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(SpannerException.class);
      SpannerException se = (SpannerException) e.getCause();
      assertThat(se.getErrorCode()).isEqualTo(ErrorCode.CANCELLED);
      assertThat(values).containsExactly("v0");
    }
  }
}

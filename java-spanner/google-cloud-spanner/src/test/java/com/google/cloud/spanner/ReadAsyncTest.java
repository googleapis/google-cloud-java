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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.MockSpannerTestUtil.*;
import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadAsyncTest {
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static LocalChannelProvider channelProvider;

  private static ExecutorService executor;
  private Spanner spanner;
  private DatabaseClient client;

  @BeforeClass
  public static void setup() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.putStatementResult(
        StatementResult.query(READ_ONE_KEY_VALUE_STATEMENT, READ_ONE_KEY_VALUE_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.query(READ_ONE_EMPTY_KEY_VALUE_STATEMENT, EMPTY_KEY_VALUE_RESULTSET));
    mockSpanner.putStatementResult(
        StatementResult.query(
            READ_MULTIPLE_KEY_VALUE_STATEMENT, READ_MULTIPLE_KEY_VALUE_RESULTSET));

    String uniqueName = InProcessServerBuilder.generateName();
    server =
        InProcessServerBuilder.forName(uniqueName)
            .scheduledExecutorService(new ScheduledThreadPoolExecutor(1))
            .addService(mockSpanner)
            .build()
            .start();
    channelProvider = LocalChannelProvider.create(uniqueName);
    executor = Executors.newScheduledThreadPool(8);
  }

  @AfterClass
  public static void teardown() throws Exception {
    executor.shutdown();
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void before() {
    spanner =
        SpannerOptions.newBuilder()
            .setProjectId(TEST_PROJECT)
            .setChannelProvider(channelProvider)
            .setCredentials(NoCredentials.getInstance())
            .setSessionPoolOption(
                SessionPoolOptions.newBuilder().setFailOnSessionLeak().setMinSessions(0).build())
            .build()
            .getService();
    client = spanner.getDatabaseClient(DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));
  }

  @After
  public void after() {
    spanner.close();
    mockSpanner.removeAllExecutionTimes();
  }

  @Test
  public void readAsyncPropagatesError() throws Exception {
    ApiFuture<Void> result;
    try (AsyncResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .readAsync(EMPTY_READ_TABLE_NAME, KeySet.singleKey(Key.of("k99")), READ_COLUMN_NAMES)) {
      result =
          resultSet.setCallback(
              executor,
              ignored -> {
                throw SpannerExceptionFactory.newSpannerException(
                    ErrorCode.CANCELLED, "Don't want the data");
              });
    }
    SpannerException e = assertThrows(SpannerException.class, () -> get(result));
    assertThat(e.getErrorCode()).isEqualTo(ErrorCode.CANCELLED);
    assertThat(e.getMessage()).contains("Don't want the data");
  }

  @Test
  public void emptyReadAsync() throws Exception {
    ApiFuture<Void> result;
    try (AsyncResultSet resultSet =
        client
            .singleUse(TimestampBound.strong())
            .readAsync(EMPTY_READ_TABLE_NAME, KeySet.singleKey(Key.of("k99")), READ_COLUMN_NAMES)) {
      result =
          resultSet.setCallback(
              executor,
              rs -> {
                while (true) {
                  switch (rs.tryNext()) {
                    case OK:
                      fail("received unexpected data");
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      assertThat(rs.getType()).isEqualTo(READ_TABLE_TYPE);
                      return CallbackResponse.DONE;
                  }
                }
              });
    }
    assertThat(result.get()).isNull();
  }

  @Test
  public void pointReadAsync() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowAsync(READ_TABLE_NAME, Key.of("k1"), READ_COLUMN_NAMES);
    assertThat(row.get()).isNotNull();
    assertThat(row.get().getString(0)).isEqualTo("k1");
    assertThat(row.get().getString(1)).isEqualTo("v1");
  }

  @Test
  public void pointReadNotFound() throws Exception {
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowAsync(EMPTY_READ_TABLE_NAME, Key.of("k999"), READ_COLUMN_NAMES);
    assertThat(row.get()).isNull();
  }

  @Test
  public void invalidDatabase() {
    mockSpanner.setCreateSessionExecutionTime(
        SimulatedExecutionTime.stickyDatabaseNotFoundException("invalid-database"));
    mockSpanner.setBatchCreateSessionsExecutionTime(
        SimulatedExecutionTime.stickyDatabaseNotFoundException("invalid-database"));
    mockSpanner.freeze();
    DatabaseClient invalidClient =
        spanner.getDatabaseClient(DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, "invalid-database"));
    ApiFuture<Struct> row =
        invalidClient
            .singleUse(TimestampBound.strong())
            .readRowAsync(READ_TABLE_NAME, Key.of("k99"), READ_COLUMN_NAMES);
    mockSpanner.unfreeze();
    assertThrows(DatabaseNotFoundException.class, () -> get(row));
  }

  @Test
  public void tableNotFound() {
    mockSpanner.setStreamingReadExecutionTime(
        SimulatedExecutionTime.ofStickyException(
            Status.NOT_FOUND
                .withDescription("Table not found: BadTableName")
                .asRuntimeException()));
    ApiFuture<Struct> row =
        client
            .singleUse(TimestampBound.strong())
            .readRowAsync("BadTableName", Key.of("k1"), READ_COLUMN_NAMES);
    SpannerException e = assertThrows(SpannerException.class, () -> get(row));
    assertThat(e.getErrorCode()).isEqualTo(ErrorCode.NOT_FOUND);
    assertThat(e.getMessage()).contains("BadTableName");
  }

  /**
   * Ending a read-only transaction before an asynchronous query that was executed on that
   * transaction has finished fetching all rows should keep the session checked out of the pool
   * until all the rows have been returned. The session is then automatically returned to the
   * session.
   */
  @Test
  public void closeTransactionBeforeEndOfAsyncQuery() throws Exception {
    final BlockingQueue<String> results = new SynchronousQueue<>();
    final SettableApiFuture<Boolean> finished = SettableApiFuture.create();
    ApiFuture<Void> closed;
    DatabaseClientImpl clientImpl = (DatabaseClientImpl) client;

    final CountDownLatch dataReceived = new CountDownLatch(1);
    try (ReadOnlyTransaction tx = client.readOnlyTransaction()) {
      try (AsyncResultSet rs =
          tx.readAsync(READ_TABLE_NAME, KeySet.all(), READ_COLUMN_NAMES, Options.bufferRows(1))) {
        closed =
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
                          dataReceived.countDown();
                          results.put(resultSet.getString(0));
                      }
                    }
                  } catch (Throwable t) {
                    finished.setException(t);
                    return CallbackResponse.DONE;
                  }
                });
      }
      // Wait until at least one row has been fetched. At that moment there should be one session
      // checked out.
      dataReceived.await();
    }
    List<String> resultList = new ArrayList<>();
    do {
      results.drainTo(resultList);
    } while (!finished.isDone() || results.size() > 0);
    assertThat(finished.get()).isTrue();
    assertThat(resultList).containsExactly("k1", "k2", "k3");
    closed.get();
  }

  @Test
  public void readOnlyTransaction() throws Exception {
    Statement statement1 =
        Statement.of("SELECT * FROM TestTable WHERE Key IN ('k10', 'k11', 'k12')");
    Statement statement2 = Statement.of("SELECT * FROM TestTable WHERE Key IN ('k1', 'k2', 'k3");
    mockSpanner.putStatementResult(
        StatementResult.query(statement1, generateKeyValueResultSet(ContiguousSet.closed(10, 12))));
    mockSpanner.putStatementResult(
        StatementResult.query(statement2, generateKeyValueResultSet(ContiguousSet.closed(1, 3))));

    ApiFuture<List<String>> values1;
    ApiFuture<List<String>> values2;
    try (ReadOnlyTransaction tx = client.readOnlyTransaction()) {
      try (AsyncResultSet rs = tx.executeQueryAsync(statement1)) {
        values1 = rs.toListAsync(input -> input.getString("Value"), executor);
      }
      try (AsyncResultSet rs = tx.executeQueryAsync(statement2)) {
        values2 = rs.toListAsync(input -> input.getString("Value"), executor);
      }
    }

    ApiFuture<List<List<String>>> allValuesAsList =
        ApiFutures.allAsList(Arrays.asList(values1, values2));
    ApiFuture<Iterable<String>> allValues =
        ApiFutures.transform(
            allValuesAsList,
            input ->
                Iterables.mergeSorted(
                    input,
                    // Return in numerical order (i.e. without the preceding 'v').
                    Comparator.comparing(o -> Integer.valueOf(o.substring(1)))),
            executor);
    assertThat(allValues.get()).containsExactly("v1", "v2", "v3", "v10", "v11", "v12");
  }

  @Test
  public void pauseResume() throws Exception {
    Statement unevenStatement =
        Statement.of("SELECT * FROM TestTable WHERE MOD(CAST(SUBSTR(Key, 2) AS INT64), 2) = 1");
    Statement evenStatement =
        Statement.of("SELECT * FROM TestTable WHERE MOD(CAST(SUBSTR(Key, 2) AS INT64), 2) = 0");
    mockSpanner.putStatementResult(
        StatementResult.query(
            unevenStatement, generateKeyValueResultSet(ImmutableSet.of(1, 3, 5, 7, 9))));
    mockSpanner.putStatementResult(
        StatementResult.query(
            evenStatement, generateKeyValueResultSet(ImmutableSet.of(2, 4, 6, 8, 10))));

    final Object lock = new Object();
    ApiFuture<Void> evenFinished;
    ApiFuture<Void> unevenFinished;
    final CountDownLatch unevenReturnedFirstRow = new CountDownLatch(1);
    final Deque<String> allValues = new ConcurrentLinkedDeque<>();
    try (ReadOnlyTransaction tx = client.readOnlyTransaction()) {
      try (AsyncResultSet evenRs = tx.executeQueryAsync(evenStatement);
          AsyncResultSet unevenRs = tx.executeQueryAsync(unevenStatement)) {
        unevenFinished =
            unevenRs.setCallback(
                executor,
                resultSet -> {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        synchronized (lock) {
                          allValues.add(resultSet.getString("Value"));
                        }
                        unevenReturnedFirstRow.countDown();
                        return CallbackResponse.PAUSE;
                    }
                  }
                });
        evenFinished =
            evenRs.setCallback(
                executor,
                resultSet -> {
                  try {
                    // Make sure the uneven result set has returned the first before we start the
                    // even results.
                    unevenReturnedFirstRow.await();
                    while (true) {
                      switch (resultSet.tryNext()) {
                        case DONE:
                          return CallbackResponse.DONE;
                        case NOT_READY:
                          return CallbackResponse.CONTINUE;
                        case OK:
                          synchronized (lock) {
                            allValues.add(resultSet.getString("Value"));
                          }
                          return CallbackResponse.PAUSE;
                      }
                    }
                  } catch (InterruptedException e) {
                    throw SpannerExceptionFactory.propagateInterrupt(e);
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
            if (allValues.size() == 10) {
              unevenRs.resume();
              evenRs.resume();
            }
          }
        }
      }
    }
    assertThat(ApiFutures.allAsList(Arrays.asList(evenFinished, unevenFinished)).get())
        .containsExactly(null, null);
    assertThat(allValues)
        .containsExactly("v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10");
  }

  @Test
  public void cancel() throws Exception {
    final List<String> values = new LinkedList<>();
    final CountDownLatch receivedFirstRow = new CountDownLatch(1);
    final CountDownLatch cancelled = new CountDownLatch(1);
    final ApiFuture<Void> res;
    try (AsyncResultSet rs =
        client.singleUse().readAsync(READ_TABLE_NAME, KeySet.all(), READ_COLUMN_NAMES)) {
      res =
          rs.setCallback(
              executor,
              resultSet -> {
                try {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        values.add(resultSet.getString("Value"));
                        receivedFirstRow.countDown();
                        cancelled.await();
                        break;
                    }
                  }
                } catch (Throwable t) {
                  return CallbackResponse.DONE;
                }
              });
      receivedFirstRow.await();
      rs.cancel();
    }
    cancelled.countDown();
    SpannerException e = assertThrows(SpannerException.class, () -> get(res));
    assertThat(e.getErrorCode()).isEqualTo(ErrorCode.CANCELLED);
    assertThat(values).containsExactly("v1");
  }

  private boolean isMultiplexedSessionsEnabled() {
    if (spanner.getOptions() == null || spanner.getOptions().getSessionPoolOptions() == null) {
      return false;
    }
    return spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSession();
  }
}

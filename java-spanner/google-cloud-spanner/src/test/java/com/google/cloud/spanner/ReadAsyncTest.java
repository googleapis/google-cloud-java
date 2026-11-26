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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.CursorState;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.spanner.v1.ExecuteSqlRequest;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
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

  @Test(timeout = 10_000)
  public void concurrentQueriesOnSingleThreadAsyncExecutorDoNotBlockWhenPausedOrFrozen()
      throws Exception {
    Statement tenRowStatement =
        Statement.of("SELECT * FROM TestTable WHERE Key BETWEEN 'k1' AND 'k10'");
    mockSpanner.putStatementResult(
        StatementResult.query(
            tenRowStatement, generateKeyValueResultSet(ContiguousSet.closed(1, 10))));
    List<String> expectedValues =
        Arrays.asList("v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10");

    SpannerOptions.CloseableExecutorProvider singleThreadAsyncProvider =
        SpannerOptions.createAsyncExecutorProvider(1, 1L, TimeUnit.SECONDS);
    ExecutorService pausedCallbackExecutor = Executors.newSingleThreadExecutor();
    try (Spanner singleThreadSpanner = createSingleThreadSpanner(singleThreadAsyncProvider)) {
      DatabaseClient singleThreadClient =
          singleThreadSpanner.getDatabaseClient(
              DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));

      // Warm up session initialization before freezing mockSpanner so executeQueryAsync starts
      // ExecuteStreamingSql directly without waiting on CreateSession.
      try (AsyncResultSet warmup =
          singleThreadClient.singleUse().executeQueryAsync(READ_ONE_KEY_VALUE_STATEMENT)) {
        assertEquals(
            Collections.singletonList("v1"),
            warmup.toListAsync(row -> row.getString("Value"), executor).get(5, TimeUnit.SECONDS));
      }

      // 1. Stalled server stream (mockSpanner.freeze()) must not pin the 1 async executor thread.
      mockSpanner.freeze();
      ApiFuture<List<String>> frozenRowsFuture;
      try (AsyncResultSet frozenResultSet =
          singleThreadClient.singleUse().executeQueryAsync(tenRowStatement)) {
        frozenRowsFuture = frozenResultSet.toListAsync(row -> row.getString("Value"), executor);
        assertTrue(
            singleThreadAsyncProvider.getExecutor().submit(() -> true).get(5, TimeUnit.SECONDS));
        assertFalse(frozenRowsFuture.isDone());
        mockSpanner.unfreeze();
        assertEquals(expectedValues, frozenRowsFuture.get(5, TimeUnit.SECONDS));
      } finally {
        mockSpanner.unfreeze();
      }

      // 2. A PAUSED query with a full row buffer (bufferRows(2)) on a 10-row stream must yield the
      // 1 async executor thread so 3 concurrent streaming queries complete to DONE without
      // deadlocking before the paused query is resumed.
      CountDownLatch firstRowPausedLatch = new CountDownLatch(1);
      AtomicBoolean pauseOnFirstRow = new AtomicBoolean(true);
      List<String> pausedValues = Collections.synchronizedList(new ArrayList<>());
      try (AsyncResultSet pausedResultSet =
          singleThreadClient
              .singleUse()
              .executeQueryAsync(tenRowStatement, Options.bufferRows(2))) {
        ApiFuture<Void> pausedFinished =
            pausedResultSet.setCallback(
                pausedCallbackExecutor,
                cursor -> {
                  while (true) {
                    switch (cursor.tryNext()) {
                      case OK:
                        pausedValues.add(cursor.getString("Value"));
                        if (pauseOnFirstRow.compareAndSet(true, false)) {
                          firstRowPausedLatch.countDown();
                          return CallbackResponse.PAUSE;
                        }
                        break;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case DONE:
                        return CallbackResponse.DONE;
                    }
                  }
                });

        assertTrue(firstRowPausedLatch.await(5, TimeUnit.SECONDS));
        pausedCallbackExecutor.submit(() -> {}).get(5, TimeUnit.SECONDS);
        singleThreadAsyncProvider.getExecutor().submit(() -> null).get(5, TimeUnit.SECONDS);

        List<ApiFuture<List<String>>> concurrentFutures = new ArrayList<>();
        for (int queryIndex = 0; queryIndex < 3; queryIndex++) {
          try (AsyncResultSet concurrentResultSet =
              singleThreadClient.singleUse().executeQueryAsync(tenRowStatement)) {
            concurrentFutures.add(
                concurrentResultSet.toListAsync(row -> row.getString("Value"), executor));
          }
        }
        List<List<String>> concurrentResults =
            ApiFutures.allAsList(concurrentFutures).get(5, TimeUnit.SECONDS);
        for (List<String> rows : concurrentResults) {
          assertEquals(expectedValues, rows);
        }
        assertFalse(pausedFinished.isDone());

        pausedResultSet.resume();
        assertNull(pausedFinished.get(5, TimeUnit.SECONDS));
        assertEquals(expectedValues, pausedValues);
      }
    } finally {
      mockSpanner.unfreeze();
      pausedCallbackExecutor.shutdownNow();
      singleThreadAsyncProvider.close();
    }
  }

  @Test(timeout = 10_000)
  public void midStreamUnavailableResumesCleanlyOnSingleThreadAsyncExecutor() throws Exception {
    Statement tenRowStatement =
        Statement.of("SELECT * FROM TestTable WHERE Key BETWEEN 'k1' AND 'k10' ORDER BY Key");
    mockSpanner.putStatementResult(
        StatementResult.query(
            tenRowStatement, generateKeyValueResultSet(ContiguousSet.closed(1, 10))));
    List<String> expectedValues =
        Arrays.asList("v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10");

    SpannerOptions.CloseableExecutorProvider singleThreadAsyncProvider =
        SpannerOptions.createAsyncExecutorProvider(1, 1L, TimeUnit.SECONDS);
    try (Spanner singleThreadSpanner = createSingleThreadSpanner(singleThreadAsyncProvider)) {
      DatabaseClient singleThreadClient =
          singleThreadSpanner.getDatabaseClient(
              DatabaseId.of(TEST_PROJECT, TEST_INSTANCE, TEST_DATABASE));

      mockSpanner.clearRequests();
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofStreamException(Status.UNAVAILABLE.asRuntimeException(), 1));
      try (AsyncResultSet resultSet =
          singleThreadClient.singleUse().executeQueryAsync(tenRowStatement)) {
        List<String> actualValues =
            resultSet.toListAsync(row -> row.getString("Value"), executor).get(5, TimeUnit.SECONDS);
        assertEquals(expectedValues, actualValues);
      }

      List<ExecuteSqlRequest> sqlRequests = mockSpanner.getRequestsOfType(ExecuteSqlRequest.class);
      assertEquals(2, sqlRequests.size());
      assertTrue(sqlRequests.get(0).getResumeToken().isEmpty());
      assertFalse(sqlRequests.get(1).getResumeToken().isEmpty());
    } finally {
      singleThreadAsyncProvider.close();
    }
  }

  @Test(timeout = 10_000)
  public void schemaGettersWorkOnDoneForMultiRowAndEmptyQueries() throws Exception {
    assertSchemaGettersWorkOnDone(
        READ_MULTIPLE_KEY_VALUE_STATEMENT, Arrays.asList("v1", "v2", "v3"));
    assertSchemaGettersWorkOnDone(READ_ONE_EMPTY_KEY_VALUE_STATEMENT, Collections.emptyList());
  }

  private void assertSchemaGettersWorkOnDone(Statement statement, List<String> expectedValues)
      throws Exception {
    List<String> actualValues = Collections.synchronizedList(new ArrayList<>());
    AtomicBoolean assertedOnDone = new AtomicBoolean(false);
    try (AsyncResultSet resultSet = client.singleUse().executeQueryAsync(statement)) {
      ApiFuture<Void> finished =
          resultSet.setCallback(
              executor,
              cursor -> {
                while (true) {
                  CursorState state = cursor.tryNext();
                  switch (state) {
                    case OK:
                      actualValues.add(cursor.getString("Value"));
                      break;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                    case DONE:
                      assertEquals(READ_TABLE_TYPE, cursor.getType());
                      assertEquals(2, cursor.getColumnCount());
                      assertEquals(0, cursor.getColumnIndex("Key"));
                      assertEquals(1, cursor.getColumnIndex("Value"));
                      assertEquals(Type.string(), cursor.getColumnType(0));
                      assertEquals(Type.string(), cursor.getColumnType(1));
                      assertEquals(Type.string(), cursor.getColumnType("Key"));
                      assertEquals(Type.string(), cursor.getColumnType("Value"));
                      assertedOnDone.set(true);
                      return CallbackResponse.DONE;
                  }
                }
              });
      assertNull(finished.get(5, TimeUnit.SECONDS));
    }
    assertTrue(assertedOnDone.get());
    assertEquals(expectedValues, actualValues);
  }

  private Spanner createSingleThreadSpanner(
      SpannerOptions.CloseableExecutorProvider asyncExecutorProvider) {
    return SpannerOptions.newBuilder()
        .setProjectId(TEST_PROJECT)
        .setChannelProvider(channelProvider)
        .setCredentials(NoCredentials.getInstance())
        .setAsyncExecutorProvider(asyncExecutorProvider)
        .setSessionPoolOption(
            SessionPoolOptions.newBuilder().setFailOnSessionLeak().setMinSessions(0).build())
        .build()
        .getService();
  }

  private boolean isMultiplexedSessionsEnabled() {
    if (spanner.getOptions() == null || spanner.getOptions().getSessionPoolOptions() == null) {
      return false;
    }
    return spanner.getOptions().getSessionPoolOptions().getUseMultiplexedSession();
  }
}

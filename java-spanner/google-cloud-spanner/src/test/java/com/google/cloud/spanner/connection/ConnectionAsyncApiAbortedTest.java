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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.AsyncResultSet.ReadyCallback;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ConnectionOptions.Builder;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest.ITConnection;
import com.google.cloud.spanner.connection.StatementExecutor.StatementExecutorType;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Tests retry handling of read/write transactions using the Async Connection API. */
public class ConnectionAsyncApiAbortedTest extends AbstractMockServerTest {
  private static final class QueryResult {
    final ApiFuture<Void> finished;
    final AtomicInteger rowCount;

    QueryResult(ApiFuture<Void> finished, AtomicInteger rowCount) {
      this.finished = finished;
      this.rowCount = rowCount;
    }
  }

  private static final class RetryCounter implements TransactionRetryListener {
    final CountDownLatch latch;
    int retryCount = 0;

    RetryCounter() {
      this(0);
    }

    RetryCounter(int countDown) {
      latch = new CountDownLatch(countDown);
    }

    @Override
    public void retryStarting(Timestamp transactionStarted, long transactionId, int retryAttempt) {
      retryCount++;
      latch.countDown();
    }

    @Override
    public void retryFinished(
        Timestamp transactionStarted, long transactionId, int retryAttempt, RetryResult result) {}
  }

  private static final ExecutorService singleThreadedExecutor = Executors.newSingleThreadExecutor();
  private static final ExecutorService multiThreadedExecutor = Executors.newFixedThreadPool(8);
  public static final int RANDOM_RESULT_SET_ROW_COUNT_2 = 50;
  public static final Statement SELECT_RANDOM_STATEMENT_2 = Statement.of("SELECT * FROM RANDOM2");
  public static final com.google.spanner.v1.ResultSet RANDOM_RESULT_SET_2 =
      new RandomResultSetGenerator(RANDOM_RESULT_SET_ROW_COUNT_2).generate();

  @BeforeClass
  public static void setupAdditionalResults() {
    mockSpanner.putStatementResult(
        StatementResult.query(SELECT_RANDOM_STATEMENT_2, RANDOM_RESULT_SET_2));
  }

  @AfterClass
  public static void stopExecutor() {
    singleThreadedExecutor.shutdown();
    multiThreadedExecutor.shutdown();
  }

  @Before
  public void setup() {
    try (Connection connection = createConnection()) {
      connection.getDialect();
    }
  }

  @After
  public void reset() {
    mockSpanner.removeAllExecutionTimes();
  }

  ITConnection createConnection(TransactionRetryListener listener) {
    ITConnection connection =
        super.createConnection(ImmutableList.of(), ImmutableList.of(listener));
    connection.setAutocommit(false);
    return connection;
  }

  @Override
  protected Builder configureConnectionOptions(Builder builder) {
    return builder.setStatementExecutorType(StatementExecutorType.PLATFORM_THREAD);
  }

  @Test
  public void testSingleQueryAborted() {
    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofException(
              mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
      QueryResult res = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT);

      assertThat(get(res.finished)).isNull();
      assertThat(res.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertThat(counter.retryCount).isEqualTo(1);
    }
  }

  @Test
  public void testTwoQueriesSecondAborted() {
    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      QueryResult res1 = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT);
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofException(
              mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
      QueryResult res2 = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT_2);

      assertThat(get(res1.finished)).isNull();
      assertThat(res1.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertThat(get(res2.finished)).isNull();
      assertThat(res2.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT_2);
      assertThat(counter.retryCount).isEqualTo(1);
    }
  }

  @Test
  public void testTwoQueriesBothAborted() throws InterruptedException {
    RetryCounter counter = new RetryCounter(1);
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofException(
              mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
      QueryResult res1 = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT);
      // Wait until the first query aborted.
      assertThat(counter.latch.await(10L, TimeUnit.SECONDS)).isTrue();
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofException(
              mockSpanner.createAbortedException(ByteString.copyFromUtf8("test"))));
      QueryResult res2 = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT_2);

      assertThat(get(res1.finished)).isNull();
      assertThat(res1.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertThat(get(res2.finished)).isNull();
      assertThat(res2.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT_2);
      assertThat(counter.retryCount).isEqualTo(2);
    }
  }

  @Test
  public void testSingleQueryAbortedMidway() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test")),
            RANDOM_RESULT_SET_ROW_COUNT / 2));
    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      QueryResult res = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT);

      assertThat(get(res.finished)).isNull();
      assertThat(res.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertThat(counter.retryCount).isEqualTo(1);
    }
  }

  @Test
  public void testTwoQueriesSecondAbortedMidway() {
    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      QueryResult res1 = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT);
      mockSpanner.setExecuteStreamingSqlExecutionTime(
          SimulatedExecutionTime.ofStreamException(
              mockSpanner.createAbortedException(ByteString.copyFromUtf8("test")),
              RANDOM_RESULT_SET_ROW_COUNT_2 / 2));
      QueryResult res2 = executeQueryAsync(connection, SELECT_RANDOM_STATEMENT_2);

      assertThat(get(res1.finished)).isNull();
      assertThat(res1.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertThat(get(res2.finished)).isNull();
      assertThat(res2.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT_2);
      assertThat(counter.retryCount).isEqualTo(1);
    }
  }

  @Test
  public void testTwoQueriesOneAbortedMidway() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test")),
            Math.min(RANDOM_RESULT_SET_ROW_COUNT / 2, RANDOM_RESULT_SET_ROW_COUNT_2 / 2)));
    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      // These AsyncResultSets will be consumed in parallel. One of them will (at random) abort
      // halfway.
      QueryResult res1 =
          executeQueryAsync(connection, SELECT_RANDOM_STATEMENT, multiThreadedExecutor);
      QueryResult res2 =
          executeQueryAsync(connection, SELECT_RANDOM_STATEMENT_2, multiThreadedExecutor);

      assertThat(get(res1.finished)).isNull();
      assertThat(res1.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertThat(get(res2.finished)).isNull();
      assertThat(res2.rowCount.get()).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT_2);
      assertThat(counter.retryCount).isEqualTo(1);
    }
  }

  @Test
  public void testUpdateAndQueryAbortedMidway() throws InterruptedException {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test")),
            RANDOM_RESULT_SET_ROW_COUNT / 2));
    final RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      final SettableApiFuture<Long> rowCount = SettableApiFuture.create();
      final CountDownLatch updateLatch = new CountDownLatch(1);
      final CountDownLatch queryLatch = new CountDownLatch(1);
      ApiFuture<Void> finished;
      try (AsyncResultSet rs =
          connection.executeQueryAsync(
              SELECT_RANDOM_STATEMENT, Options.bufferRows(RANDOM_RESULT_SET_ROW_COUNT / 2 - 1))) {
        finished =
            rs.setCallback(
                singleThreadedExecutor,
                new ReadyCallback() {
                  long count;

                  @Override
                  public CallbackResponse cursorReady(AsyncResultSet resultSet) {
                    // Indicate that the query has been executed.
                    queryLatch.countDown();
                    try {
                      // Wait until the update is on its way.
                      updateLatch.await(10L, TimeUnit.SECONDS);
                      while (true) {
                        switch (resultSet.tryNext()) {
                          case OK:
                            count++;
                            break;
                          case DONE:
                            rowCount.set(count);
                            return CallbackResponse.DONE;
                          case NOT_READY:
                            return CallbackResponse.CONTINUE;
                        }
                      }
                    } catch (InterruptedException e) {
                      throw SpannerExceptionFactory.propagateInterrupt(e);
                    }
                  }
                });
      }
      // Wait until the query has actually executed.
      queryLatch.await(10L, TimeUnit.SECONDS);
      ApiFuture<Long> updateCount = connection.executeUpdateAsync(INSERT_STATEMENT);
      updateCount.addListener(updateLatch::countDown, MoreExecutors.directExecutor());

      // We should not commit before the AsyncResultSet has finished.
      assertThat(get(finished)).isNull();
      ApiFuture<Void> commit = connection.commitAsync();

      assertThat(get(rowCount)).isEqualTo(RANDOM_RESULT_SET_ROW_COUNT);
      assertThat(get(updateCount)).isEqualTo(UPDATE_COUNT);
      assertThat(get(commit)).isNull();
      assertThat(counter.retryCount).isEqualTo(1);

      // Verify the order of the statements on the server.
      List<? extends AbstractMessage> requests =
          Lists.newArrayList(
              Collections2.filter(
                  mockSpanner.getRequests(), input -> input instanceof ExecuteSqlRequest));
      // The entire transaction should be retried.
      assertThat(requests).hasSize(4);
      assertThat(((ExecuteSqlRequest) requests.get(0)).getSeqno()).isEqualTo(1L);
      assertThat(((ExecuteSqlRequest) requests.get(0)).getSql())
          .isEqualTo(SELECT_RANDOM_STATEMENT.getSql());
      assertThat(((ExecuteSqlRequest) requests.get(1)).getSeqno()).isEqualTo(2L);
      assertThat(((ExecuteSqlRequest) requests.get(1)).getSql())
          .isEqualTo(INSERT_STATEMENT.getSql());
      assertThat(((ExecuteSqlRequest) requests.get(2)).getSeqno()).isEqualTo(1L);
      assertThat(((ExecuteSqlRequest) requests.get(2)).getSql())
          .isEqualTo(SELECT_RANDOM_STATEMENT.getSql());
      assertThat(((ExecuteSqlRequest) requests.get(3)).getSeqno()).isEqualTo(2L);
      assertThat(((ExecuteSqlRequest) requests.get(3)).getSql())
          .isEqualTo(INSERT_STATEMENT.getSql());
    }
  }

  @Test
  public void testUpdateAndQueryAbortedMidway_UpdateCountChanged() throws InterruptedException {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test")),
            RANDOM_RESULT_SET_ROW_COUNT / 2));
    final RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      assertThat(counter.retryCount).isEqualTo(0);
      final CountDownLatch updateLatch = new CountDownLatch(1);
      final CountDownLatch queryLatch = new CountDownLatch(1);
      ApiFuture<Void> finished;
      try (AsyncResultSet rs =
          connection.executeQueryAsync(
              SELECT_RANDOM_STATEMENT, Options.bufferRows(RANDOM_RESULT_SET_ROW_COUNT / 2 - 1))) {
        finished =
            rs.setCallback(
                singleThreadedExecutor,
                resultSet -> {
                  // Indicate that the query has been executed.
                  queryLatch.countDown();
                  try {
                    // Wait until the update is on its way.
                    updateLatch.await(10L, TimeUnit.SECONDS);
                    while (true) {
                      switch (resultSet.tryNext()) {
                        case OK:
                          break;
                        case DONE:
                          return CallbackResponse.DONE;
                        case NOT_READY:
                          return CallbackResponse.CONTINUE;
                      }
                    }
                  } catch (InterruptedException e) {
                    throw SpannerExceptionFactory.propagateInterrupt(e);
                  }
                });
      }
      // Wait until the query has actually executed.
      queryLatch.await(10L, TimeUnit.SECONDS);
      // Execute an update statement and wait until it has finished before allowing the
      // AsyncResultSet to continue processing. Also change the result of the update statement after
      // it has finished. The AsyncResultSet will see an aborted transaction halfway, and then
      // during the retry, it will get a different result for this update statement. That will cause
      // the retry to be aborted.
      get(connection.executeUpdateAsync(INSERT_STATEMENT));
      try {
        mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, UPDATE_COUNT + 1));
        updateLatch.countDown();
        get(finished);
        fail("Missing expected exception");
      } catch (AbortedDueToConcurrentModificationException e) {
        assertThat(counter.retryCount).isEqualTo(1);
      } finally {
        mockSpanner.putStatementResult(StatementResult.update(INSERT_STATEMENT, UPDATE_COUNT));
      }

      // Verify the order of the statements on the server.
      List<? extends AbstractMessage> requests =
          Lists.newArrayList(
              Collections2.filter(
                  mockSpanner.getRequests(), input -> input instanceof ExecuteSqlRequest));
      // The entire transaction should be retried, but will not succeed as the result of the update
      // statement was different during the retry.
      assertThat(requests).hasSize(4);
      assertThat(((ExecuteSqlRequest) requests.get(0)).getSeqno()).isEqualTo(1L);
      assertThat(((ExecuteSqlRequest) requests.get(0)).getSql())
          .isEqualTo(SELECT_RANDOM_STATEMENT.getSql());
      assertThat(((ExecuteSqlRequest) requests.get(1)).getSeqno()).isEqualTo(2L);
      assertThat(((ExecuteSqlRequest) requests.get(1)).getSql())
          .isEqualTo(INSERT_STATEMENT.getSql());
      assertThat(((ExecuteSqlRequest) requests.get(2)).getSeqno()).isEqualTo(1L);
      assertThat(((ExecuteSqlRequest) requests.get(2)).getSql())
          .isEqualTo(SELECT_RANDOM_STATEMENT.getSql());
      assertThat(((ExecuteSqlRequest) requests.get(3)).getSeqno()).isEqualTo(2L);
      assertThat(((ExecuteSqlRequest) requests.get(3)).getSql())
          .isEqualTo(INSERT_STATEMENT.getSql());
    }
  }

  @Test
  public void testQueriesAbortedMidway_ResultsChanged() {
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofStreamException(
            mockSpanner.createAbortedException(ByteString.copyFromUtf8("test")),
            RANDOM_RESULT_SET_ROW_COUNT - 1));
    final Statement statement = Statement.of("SELECT * FROM TEST_TABLE");
    final RandomResultSetGenerator generator =
        new RandomResultSetGenerator(RANDOM_RESULT_SET_ROW_COUNT - 10);
    mockSpanner.putStatementResult(StatementResult.query(statement, generator.generate()));

    final CountDownLatch latch = new CountDownLatch(1);
    final RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      ApiFuture<Void> res1;
      try (AsyncResultSet rs =
          connection.executeQueryAsync(SELECT_RANDOM_STATEMENT, Options.bufferRows(5))) {
        res1 =
            rs.setCallback(
                multiThreadedExecutor,
                resultSet -> {
                  try {
                    latch.await(10L, TimeUnit.SECONDS);
                    while (true) {
                      switch (resultSet.tryNext()) {
                        case OK:
                          break;
                        case DONE:
                          return CallbackResponse.DONE;
                        case NOT_READY:
                          return CallbackResponse.CONTINUE;
                      }
                    }
                  } catch (Throwable t) {
                    throw SpannerExceptionFactory.asSpannerException(t);
                  }
                });
      }
      try (AsyncResultSet rs = connection.executeQueryAsync(statement, Options.bufferRows(5))) {
        rs.setCallback(
            multiThreadedExecutor,
            new ReadyCallback() {
              boolean replaced;

              @Override
              public CallbackResponse cursorReady(AsyncResultSet resultSet) {
                if (!replaced) {
                  // Replace the result of the query on the server after the first execution.
                  mockSpanner.putStatementResult(
                      StatementResult.query(statement, generator.generate()));
                  replaced = true;
                }
                while (true) {
                  switch (resultSet.tryNext()) {
                    case OK:
                      break;
                    case DONE:
                      latch.countDown();
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                  }
                }
              }
            });
      }
      try {
        get(res1);
        fail("Missing expected exception");
      } catch (AbortedDueToConcurrentModificationException e) {
        assertThat(counter.retryCount).isEqualTo(1);
      }
    }
  }

  @Test
  public void testBlindUpdateAborted() {
    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      mockSpanner.abortNextStatement();
      ApiFuture<Long> updateCount = connection.executeUpdateAsync(INSERT_STATEMENT);
      get(connection.commitAsync());

      assertThat(get(updateCount)).isEqualTo(UPDATE_COUNT);
      assertThat(counter.retryCount).isEqualTo(1);
    }
  }

  @Test
  public void testBlindUpdateAborted_WithConcurrentModification() {
    Statement update1 = Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=100");
    mockSpanner.putStatementResult(StatementResult.update(update1, 100));

    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      // Execute an update statement and then change the result for the next time it is executed.
      get(connection.executeUpdateAsync(update1));
      mockSpanner.putStatementResult(StatementResult.update(update1, 200));

      // Abort on the next statement. The retry should now fail because of the changed result of the
      // first update.
      mockSpanner.abortNextStatement();
      connection.executeUpdateAsync(INSERT_STATEMENT);

      try {
        get(connection.commitAsync());
        fail("Missing expected exception");
      } catch (AbortedDueToConcurrentModificationException e) {
        assertThat(counter.retryCount).isEqualTo(1);
      }
    }
  }

  @Test
  public void testMultipleBlindUpdatesAborted_WithConcurrentModification() {
    Statement update1 = Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=100");
    mockSpanner.putStatementResult(StatementResult.update(update1, 100));

    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      // Execute an update statement and then change the result for the next time it is executed.
      get(connection.executeUpdateAsync(update1));
      mockSpanner.putStatementResult(StatementResult.update(update1, 200));

      // Abort the transaction on the next statement. The retry should now fail because of the
      // changed result of the first update.
      mockSpanner.abortNextStatement();

      // Continue to (try to) execute blind updates. This should not cause any exceptions, although
      // all of the returned futures will fail.
      List<ApiFuture<Long>> futures = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
        futures.add(connection.executeUpdateAsync(INSERT_STATEMENT));
      }

      for (ApiFuture<Long> fut : futures) {
        try {
          get(fut);
          fail("Missing expected exception");
        } catch (AbortedDueToConcurrentModificationException e) {
          assertThat(counter.retryCount).isEqualTo(1);
        }
      }
    }
  }

  @Test
  public void testBlindUpdateAborted_ThenAsyncQuery_WithConcurrentModification() {
    Statement update1 = Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=100");
    mockSpanner.putStatementResult(StatementResult.update(update1, 100));

    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      // Execute an update statement and then change the result for the next time it is executed.
      get(connection.executeUpdateAsync(update1));
      mockSpanner.putStatementResult(StatementResult.update(update1, 200));

      // Abort on the next statement. The retry should now fail because of the changed result of the
      // first update.
      mockSpanner.abortNextStatement();
      connection.executeUpdateAsync(INSERT_STATEMENT);

      // Try to execute an async query. The callback should also receive the
      // AbortedDueToConcurrentModificationException.
      try (AsyncResultSet rs = connection.executeQueryAsync(SELECT_RANDOM_STATEMENT)) {
        ApiFuture<Void> fut =
            rs.setCallback(
                singleThreadedExecutor,
                resultSet -> {
                  // The following line should throw AbortedDueToConcurrentModificationException.
                  resultSet.tryNext();
                  return CallbackResponse.DONE;
                });
        try {
          assertThat(get(fut)).isNull();
          fail("Missing expected exception");
        } catch (AbortedDueToConcurrentModificationException e) {
          assertThat(counter.retryCount).isEqualTo(1);
        }
      }

      // Ensure that a rollback and then a new statement does succeed.
      connection.rollbackAsync();
      try (AsyncResultSet rs = connection.executeQueryAsync(SELECT_RANDOM_STATEMENT)) {
        ApiFuture<Void> fut =
            rs.setCallback(
                singleThreadedExecutor,
                resultSet -> {
                  resultSet.tryNext();
                  return CallbackResponse.DONE;
                });
        assertThat(get(fut)).isNull();
      }
      get(connection.commitAsync());
    }
  }

  @Test
  public void testBlindUpdateAborted_SelectResults() {
    final Statement update1 = Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=100");
    mockSpanner.putStatementResult(StatementResult.update(update1, 100));

    RetryCounter counter = new RetryCounter();
    try (Connection connection = createConnection(counter)) {
      // Execute an update statement and then change the result for the next time it is executed.
      connection.executeUpdate(update1);
      // Abort on the next statement. The retry should now fail because of the changed result of the
      // first update.
      mockSpanner.abortNextStatement();
      mockSpanner.putStatementResult(StatementResult.update(update1, 200));
      connection.executeUpdateAsync(INSERT_STATEMENT);
      ApiFuture<Void> commit = connection.commitAsync();

      try (AsyncResultSet rs = connection.executeQueryAsync(SELECT_RANDOM_STATEMENT)) {
        while (rs.next()) {}
      }
      get(connection.commitAsync());

      try {
        get(commit);
        fail("Missing expected exception");
      } catch (AbortedDueToConcurrentModificationException e) {
        assertThat(counter.retryCount).isEqualTo(1);
      }
    }
  }

  private QueryResult executeQueryAsync(Connection connection, Statement statement) {
    return executeQueryAsync(connection, statement, singleThreadedExecutor);
  }

  private QueryResult executeQueryAsync(
      Connection connection, Statement statement, Executor executor) {
    ApiFuture<Void> res;
    final AtomicInteger rowCount = new AtomicInteger();
    try (AsyncResultSet rs = connection.executeQueryAsync(statement, Options.bufferRows(5))) {
      res =
          rs.setCallback(
              executor,
              resultSet -> {
                while (true) {
                  switch (resultSet.tryNext()) {
                    case OK:
                      rowCount.incrementAndGet();
                      break;
                    case DONE:
                      return CallbackResponse.DONE;
                    case NOT_READY:
                      return CallbackResponse.CONTINUE;
                  }
                }
              });
      return new QueryResult(res, rowCount);
    }
  }
}

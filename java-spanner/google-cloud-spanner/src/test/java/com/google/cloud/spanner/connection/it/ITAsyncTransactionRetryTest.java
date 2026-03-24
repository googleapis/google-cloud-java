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

package com.google.cloud.spanner.connection.it;

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.AsyncResultSet.CallbackResponse;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.connection.TransactionRetryListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This integration test tests the different scenarios for automatically retrying read/write
 * transactions, both when possible and when the transaction must abort because of a concurrent
 * update.
 */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITAsyncTransactionRetryTest extends ITAbstractSpannerTest {
  private static final Logger logger =
      Logger.getLogger(ITAsyncTransactionRetryTest.class.getName());

  @Rule public TestName testName = new TestName();

  private static final ExecutorService executor = Executors.newFixedThreadPool(4);

  @AfterClass
  public static void shutdownExecutor() {
    executor.shutdown();
  }

  @Override
  protected void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=false;retryAbortsInternally=true");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  /** Clear the test table before each test run */
  @Before
  public void clearTable() {
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(Mutation.delete("TEST", KeySet.all()));
      get(connection.commitAsync());
    }
  }

  @Before
  public void clearStatistics() {
    RETRY_STATISTICS.clear();
  }

  @Before
  public void logStart() {
    logger.fine(
        "--------------------------------------------------------------\n"
            + testName.getMethodName()
            + " started");
  }

  @After
  public void logFinished() {
    logger.fine(
        "--------------------------------------------------------------\n"
            + testName.getMethodName()
            + " finished");
  }

  /** Simple data structure to keep track of retry statistics */
  private static class RetryStatistics {
    private int totalRetryAttemptsStarted;
    private int totalRetryAttemptsFinished;
    private int totalSuccessfulRetries;
    private int totalErroredRetries;
    private int totalNestedAborts;
    private int totalMaxAttemptsExceeded;
    private int totalConcurrentModifications;

    private void clear() {
      totalRetryAttemptsStarted = 0;
      totalRetryAttemptsFinished = 0;
      totalSuccessfulRetries = 0;
      totalErroredRetries = 0;
      totalNestedAborts = 0;
      totalMaxAttemptsExceeded = 0;
      totalConcurrentModifications = 0;
    }
  }

  /**
   * Static to allow access from the {@link CountTransactionRetryListener}. Statistics are
   * automatically cleared before each test case.
   */
  public static final RetryStatistics RETRY_STATISTICS = new RetryStatistics();

  /**
   * Simple {@link TransactionRetryListener} that keeps track of the total count of the different
   * transaction retry events of a {@link Connection}. Note that as {@link
   * TransactionRetryListener}s are instantiated once per connection, the listener keeps track of
   * the total statistics of a connection and not only of the last transaction.
   */
  public static class CountTransactionRetryListener implements TransactionRetryListener {

    @Override
    public void retryStarting(Timestamp transactionStarted, long transactionId, int retryAttempt) {
      RETRY_STATISTICS.totalRetryAttemptsStarted++;
    }

    @Override
    public void retryFinished(
        Timestamp transactionStarted, long transactionId, int retryAttempt, RetryResult result) {
      RETRY_STATISTICS.totalRetryAttemptsFinished++;
      switch (result) {
        case RETRY_ABORTED_AND_MAX_ATTEMPTS_EXCEEDED:
          RETRY_STATISTICS.totalMaxAttemptsExceeded++;
          break;
        case RETRY_ABORTED_AND_RESTARTING:
          RETRY_STATISTICS.totalNestedAborts++;
          break;
        case RETRY_ABORTED_DUE_TO_CONCURRENT_MODIFICATION:
          RETRY_STATISTICS.totalConcurrentModifications++;
          break;
        case RETRY_ERROR:
          RETRY_STATISTICS.totalErroredRetries++;
          break;
        case RETRY_SUCCESSFUL:
          RETRY_STATISTICS.totalSuccessfulRetries++;
          break;
        default:
          break;
      }
    }
  }

  private ApiFuture<Long> getTestRecordCountAsync(Connection connection) {
    final SettableApiFuture<Long> count = SettableApiFuture.create();
    try (AsyncResultSet rs =
        connection.executeQueryAsync(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
      rs.setCallback(
          executor,
          resultSet -> {
            while (true) {
              switch (resultSet.tryNext()) {
                case DONE:
                  return CallbackResponse.DONE;
                case NOT_READY:
                  return CallbackResponse.CONTINUE;
                case OK:
                  count.set(resultSet.getLong("C"));
                  break;
              }
            }
          });
    }
    return count;
  }

  private void verifyRecordCount(Connection connection, long expected) {
    try (AsyncResultSet rs =
        connection.executeQueryAsync(Statement.of("SELECT COUNT(*) AS C FROM TEST"))) {
      assertThat(rs.next()).isTrue();
      assertThat(rs.getLong("C")).isEqualTo(expected);
      assertThat(rs.next()).isFalse();
    }
  }

  /** Test successful retry when the commit aborts */
  @Test
  public void testCommitAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      ApiFuture<Long> count = getTestRecordCountAsync(connection);
      // do an insert
      ApiFuture<Long> updateCount =
          connection.executeUpdateAsync(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do a commit that will first abort, and then on retry will succeed
      ApiFuture<Void> commit = connection.commitAsync();

      assertThat(get(count)).isEqualTo(0L);
      // Wait until the commit has finished before checking retry stats.
      assertThat(get(commit)).isNull();
      assertThat(get(updateCount)).isEqualTo(1L);
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted >= 1).isTrue();
      assertThat(RETRY_STATISTICS.totalRetryAttemptsFinished >= 1).isTrue();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries >= 1).isTrue();
      assertThat(RETRY_STATISTICS.totalErroredRetries).isEqualTo(0);
      assertThat(RETRY_STATISTICS.totalConcurrentModifications).isEqualTo(0);
      assertThat(RETRY_STATISTICS.totalMaxAttemptsExceeded).isEqualTo(0);
      // verify that the insert succeeded
      verifyRecordCount(connection, 1L);
    }
  }

  /** Test successful retry when an insert statement aborts */
  @Test
  public void testInsertAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      ApiFuture<Long> count = getTestRecordCountAsync(connection);
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do an insert that will abort
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // do a commit
      ApiFuture<Void> commit = connection.commitAsync();
      assertThat(get(count)).isEqualTo(0L);
      assertThat(get(commit)).isNull();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries >= 1).isTrue();
      // verify that the insert succeeded
      verifyRecordCount(connection, 1L);
    }
  }

  /** Test successful retry when an update statement aborts */
  @Test
  public void testUpdateAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      ApiFuture<Long> count = getTestRecordCountAsync(connection);
      // insert a test record
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do an update that will abort
      connection.executeUpdateAsync(
          Statement.of("UPDATE TEST SET NAME='update aborted' WHERE ID=1"));
      // do a commit
      ApiFuture<Void> commit = connection.commitAsync();
      assertThat(get(count)).isEqualTo(0L);
      assertThat(get(commit)).isNull();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries >= 1).isTrue();
      // verify that the update succeeded
      try (AsyncResultSet rs =
          connection.executeQueryAsync(
              Statement.of(
                  "SELECT COUNT(*) AS C FROM TEST WHERE ID=1 AND NAME='update aborted'"))) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("C")).isEqualTo(1L);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  /** Test successful retry when a query aborts */
  @Test
  public void testQueryAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert a test record
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do a query that will abort
      final SettableApiFuture<Long> countAfterInsert = SettableApiFuture.create();
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
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
                      countAfterInsert.set(resultSet.getLong("C"));
                      break;
                  }
                }
              } catch (Throwable t) {
                countAfterInsert.setException(t);
                return CallbackResponse.DONE;
              }
            });
      }
      connection.commitAsync();
      assertThat(get(countAfterInsert)).isEqualTo(1L);
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries >= 1).isTrue();
      // verify that the update succeeded
      try (ResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("C")).isEqualTo(1L);
        assertThat(rs.next()).isFalse();
      }
    }
  }

  /** Test successful retry when a call to {@link ResultSet#next()} aborts */
  @Test
  public void testNextCallAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert two test records
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // do a query
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        // the first record should be accessible without any problems
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("ID")).isEqualTo(1L);

        // indicate that the next statement should abort
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("ID")).isEqualTo(2L);
        assertThat(RETRY_STATISTICS.totalSuccessfulRetries >= 1).isTrue();
        // there should be only two records
        assertThat(rs.next()).isFalse();
      }
      connection.commitAsync();
      // verify that the transaction succeeded
      verifyRecordCount(connection, 2L);
    }
  }

  /** Test successful retry after multiple aborts */
  @Test
  public void testMultipleAborts() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      ApiFuture<Long> count = getTestRecordCountAsync(connection);
      // do three inserts which all will abort and retry
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      get(
          connection.executeUpdateAsync(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')")));
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      get(
          connection.executeUpdateAsync(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')")));
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      get(
          connection.executeUpdateAsync(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')")));

      ApiFuture<Void> commit = connection.commitAsync();
      assertThat(get(count)).isEqualTo(0L);
      assertThat(get(commit)).isNull();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries).isAtLeast(3);
      // verify that the inserts succeeded
      verifyRecordCount(connection, 3L);
    }
  }

  /**
   * Tests that a transaction retry can be successful after a select, as long as the select returns
   * the same results during the retry
   */
  @Test
  public void testAbortAfterSelect() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      ApiFuture<Long> count = getTestRecordCountAsync(connection);
      // insert a test record
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      // select the test record
      final SettableApiFuture<Struct> initialRecord = SettableApiFuture.create();
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST WHERE ID=1"))) {
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
                      initialRecord.set(resultSet.getCurrentRowAsStruct());
                  }
                }
              } catch (Throwable t) {
                initialRecord.setException(t);
                return CallbackResponse.DONE;
              }
            });
      }
      // do another insert that will abort and retry
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));

      // select the first test record again
      final SettableApiFuture<Struct> secondRecord = SettableApiFuture.create();
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST WHERE ID=1"))) {
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
                      secondRecord.set(resultSet.getCurrentRowAsStruct());
                  }
                }
              } catch (Throwable t) {
                secondRecord.setException(t);
                return CallbackResponse.DONE;
              }
            });
      }
      ApiFuture<Void> commit = connection.commitAsync();
      assertThat(get(count)).isEqualTo(0L);
      assertThat(get(initialRecord)).isEqualTo(get(secondRecord));
      assertThat(get(commit)).isNull();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries >= 1).isTrue();
    }
  }

  /**
   * Test a successful retry when a {@link ResultSet} has been consumed half way. The {@link
   * ResultSet} should still be at the same position and still behave as if the original transaction
   * did not abort.
   */
  @Test
  public void testAbortWithResultSetHalfway() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert two test records
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        // iterate one step
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("ID")).isEqualTo(1L);
        // do another insert that will abort and retry
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        connection.executeUpdateAsync(
            Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        // iterate another step
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("ID")).isEqualTo(2L);
        // ensure we are at the end of the result set
        assertThat(rs.next()).isFalse();
      }
      get(connection.commitAsync());
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries).isAtLeast(1);
      // verify that all the inserts succeeded
      verifyRecordCount(connection, 3L);
    }
  }

  /** Test successful retry after a {@link ResultSet} has been fully consumed. */
  @Test
  public void testAbortWithResultSetFullyConsumed() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert two test records
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records and iterate over them
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        // do nothing, just consume the result set
        rs.setCallback(
            executor,
            resultSet -> {
              while (true) {
                switch (resultSet.tryNext()) {
                  case DONE:
                    return CallbackResponse.DONE;
                  case NOT_READY:
                    return CallbackResponse.CONTINUE;
                  case OK:
                    break;
                }
              }
            });
      }
      // do another insert that will abort and retry
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      get(connection.commitAsync());

      assertThat(RETRY_STATISTICS.totalSuccessfulRetries).isAtLeast(1);
      // verify that all the inserts succeeded
      verifyRecordCount(connection, 3L);
    }
  }

  @Test
  public void testAbortWithConcurrentInsert() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert two test records
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records and consume the entire result set
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        get(
            rs.setCallback(
                executor,
                resultSet -> {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        break;
                    }
                  }
                }));
      }
      // open a new connection and transaction and do an additional insert
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdateAsync(
            Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        get(connection2.commitAsync());
      }
      // now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      ApiFuture<Long> updateCount =
          connection.executeUpdateAsync(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (4, 'test 4')"));
      try {
        get(updateCount);
        fail("Missing expected exception");
      } catch (AbortedDueToConcurrentModificationException e) {
        assertRetryStatistics(1, 1, 0);
      }
    }
  }

  @Test
  public void testAbortWithConcurrentDelete() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      get(connection.commitAsync());
    }
    // open a new connection and select the two test records
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // select the test records and consume the entire result set
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        get(
            rs.setCallback(
                executor,
                resultSet -> {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        break;
                    }
                  }
                }));
      }
      // open a new connection and transaction and remove one of the test records
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdateAsync(Statement.of("DELETE FROM TEST WHERE ID=1"));
        get(connection2.commitAsync());
      }
      // now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      try {
        get(
            connection.executeUpdateAsync(
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')")));
        fail("Missing expected exception");
      } catch (AbortedDueToConcurrentModificationException e) {
        assertRetryStatistics(1, 1, 0);
      }
    }
  }

  @Test
  public void testAbortWithConcurrentUpdate() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      get(connection.commitAsync());
    }
    // open a new connection and select the two test records
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // select the test records and consume the entire result set
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        get(
            rs.setCallback(
                executor,
                resultSet -> {
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        break;
                    }
                  }
                }));
      }
      // open a new connection and transaction and update one of the test records
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdateAsync(
            Statement.of("UPDATE TEST SET NAME='test updated' WHERE ID=2"));
        get(connection2.commitAsync());
      }
      // now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      try {
        get(
            connection.executeUpdateAsync(
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')")));
        fail("Missing expected exception");
      } catch (AbortedDueToConcurrentModificationException e) {
        assertRetryStatistics(1, 1, 0);
      }
    }
  }

  /**
   * Test that shows that a transaction retry is possible even when there is a concurrent insert
   * that has an impact on a query that has been executed, as long as the user hasn't actually seen
   * the relevant part of the result of the query
   */
  @Test
  public void testAbortWithUnseenConcurrentInsert() throws InterruptedException {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert three test records
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.executeUpdateAsync(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      // select the test records and consume part of the result set
      final AtomicInteger count = new AtomicInteger();
      final AtomicLong lastSeenId = new AtomicLong();
      final CountDownLatch latch1 = new CountDownLatch(1);
      final CountDownLatch latch2 = new CountDownLatch(1);
      // Use buffer size 1. This means that the underlying result set will see 2 records (1 in the
      // buffer and 1 waiting to be put in the buffer).
      try (AsyncResultSet rs =
          connection.executeQueryAsync(
              Statement.of("SELECT * FROM TEST ORDER BY ID"), Options.bufferRows(1))) {
        ApiFuture<Void> finished =
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
                          count.incrementAndGet();
                          lastSeenId.set(resultSet.getLong("ID"));
                          break;
                      }
                      if (count.get() == 1) {
                        // Let the other transaction proceed.
                        latch1.countDown();
                        // Wait until the transaction has been aborted and retried.
                        if (!latch2.await(120L, TimeUnit.SECONDS)) {
                          throw SpannerExceptionFactory.newSpannerException(
                              ErrorCode.DEADLINE_EXCEEDED, "Timeout while waiting for latch2");
                        }
                      }
                    }
                  } catch (Throwable t) {
                    throw SpannerExceptionFactory.asSpannerException(t);
                  }
                });
        // Open a new connection and transaction and do an additional insert. This insert will be
        // included in a retry of the above query, but this has not yet been 'seen' by the user,
        // hence is not a problem for retrying the transaction.
        try (ITConnection connection2 = createConnection()) {
          assertThat(latch1.await(60L, TimeUnit.SECONDS)).isTrue();
          connection2.executeUpdateAsync(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (4, 'test 4')"));
          get(connection2.commitAsync());
        }
        // now try to do an insert that will abort. The retry should still succeed.
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        int currentRetryCount = RETRY_STATISTICS.totalRetryAttemptsStarted;
        get(
            connection.executeUpdateAsync(
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (5, 'test 5')")));
        assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted).isAtLeast(currentRetryCount + 1);
        // Consume the rest of the result set. The insert by the other transaction should now be
        // included in the result set as the transaction retried. Although this means that the
        // result
        // is different after a retry, it is not different as seen by the user, as the user didn't
        // know that the result set did not have any more results before the transaction retry.
        latch2.countDown();
        get(finished);
        // record with id 5 should not be visible, as it was added to the transaction after the
        // query
        // was executed
        assertThat(count.get()).isEqualTo(4);
        assertThat(lastSeenId.get()).isEqualTo(4L);
      }
      get(connection.commitAsync());
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries).isAtLeast(1);
    }
  }

  /** Test the successful retry of a transaction with a large {@link ResultSet} */
  @Test
  public void testRetryLargeResultSet() {
    final int NUMBER_OF_TEST_RECORDS = 100000;
    final long UPDATED_RECORDS = 1000L;
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection = createConnection()) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert test records
      for (int i = 0; i < NUMBER_OF_TEST_RECORDS; i++) {
        connection.bufferedWrite(
            Mutation.newInsertBuilder("TEST").set("ID").to(i).set("NAME").to("test " + i).build());
        if (i % 1000 == 0) {
          connection.commitAsync();
        }
      }
      get(connection.commitAsync());
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // select the test records and iterate over them
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        ApiFuture<Void> finished =
            rs.setCallback(
                executor,
                resultSet -> {
                  // do nothing, just consume the result set
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        break;
                    }
                  }
                });
        // Wait until the entire result set has been consumed.
        get(finished);
      }
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // Do an update that will abort and retry.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdateAsync(
          Statement.newBuilder("UPDATE TEST SET NAME='updated' WHERE ID<@max_id")
              .bind("max_id")
              .to(UPDATED_RECORDS)
              .build());
      connection.commitAsync();
      // verify that the update succeeded
      try (AsyncResultSet rs =
          connection.executeQueryAsync(
              Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE NAME='updated'"))) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("C")).isEqualTo(UPDATED_RECORDS);
        assertThat(rs.next()).isFalse();
      }
      // Verify that the transaction retried.
      assertRetryStatistics(1, 0, 1);
    }
  }

  /** Test the successful retry of a transaction with a high chance of multiple aborts */
  @Test
  public void testRetryHighAbortRate() {
    final int NUMBER_OF_TEST_RECORDS = 10000;
    final long UPDATED_RECORDS = 1000L;
    // abort on 25% of all statements
    AbortInterceptor interceptor = new AbortInterceptor(0.25D);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      interceptor.setUsingMultiplexedSession(
          isMultiplexedSessionsEnabledForRW(connection.getSpanner()));
      // insert test records
      for (int i = 0; i < NUMBER_OF_TEST_RECORDS; i++) {
        connection.bufferedWrite(
            Mutation.newInsertBuilder("TEST").set("ID").to(i).set("NAME").to("test " + i).build());
        if (i % 1000 == 0) {
          connection.commitAsync();
        }
      }
      connection.commitAsync();
      // select the test records and iterate over them
      // reduce the abort rate to 0.01% as each next() call could abort
      interceptor.setProbability(0.0001D);
      try (AsyncResultSet rs =
          connection.executeQueryAsync(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        ApiFuture<Void> finished =
            rs.setCallback(
                executor,
                resultSet -> {
                  // do nothing, just consume the result set
                  while (true) {
                    switch (resultSet.tryNext()) {
                      case DONE:
                        return CallbackResponse.DONE;
                      case NOT_READY:
                        return CallbackResponse.CONTINUE;
                      case OK:
                        break;
                    }
                  }
                });
        // Wait until the entire result set has been consumed.
        get(finished);
      }
      // increase the abort rate to 50%
      interceptor.setProbability(0.50D);
      connection.executeUpdateAsync(
          Statement.newBuilder("UPDATE TEST SET NAME='updated' WHERE ID<@max_id")
              .bind("max_id")
              .to(UPDATED_RECORDS)
              .build());
      // Wait for the commit to finish, as it could be that the transaction is aborted so many times
      // that the last update does not succeed.
      get(connection.commitAsync());
      // verify that the update succeeded
      try (AsyncResultSet rs =
          connection.executeQueryAsync(
              Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE NAME='updated'"))) {
        assertThat(rs.next()).isTrue();
        assertThat(rs.getLong("C")).isEqualTo(UPDATED_RECORDS);
        assertThat(rs.next()).isFalse();
      }
      get(connection.commitAsync());
    } catch (AbortedException e) {
      // This could happen if the number of aborts exceeds the max number of retries.
      logger.log(Level.FINE, "testRetryHighAbortRate aborted because of too many retries", e);
    }
    logger.fine("Total number of retries started: " + RETRY_STATISTICS.totalRetryAttemptsStarted);
    logger.fine("Total number of retries finished: " + RETRY_STATISTICS.totalRetryAttemptsFinished);
    logger.fine("Total number of retries successful: " + RETRY_STATISTICS.totalSuccessfulRetries);
    logger.fine("Total number of retries aborted: " + RETRY_STATISTICS.totalNestedAborts);
    logger.fine(
        "Total number of times the max retry count was exceeded: "
            + RETRY_STATISTICS.totalMaxAttemptsExceeded);
  }

  private void assertRetryStatistics(
      int minAttemptsStartedExpected,
      int concurrentModificationsExpected,
      int successfulRetriesExpected) {
    assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted).isAtLeast(minAttemptsStartedExpected);
    assertThat(RETRY_STATISTICS.totalConcurrentModifications)
        .isEqualTo(concurrentModificationsExpected);
    assertThat(RETRY_STATISTICS.totalSuccessfulRetries).isAtLeast(successfulRetriesExpected);
  }
}

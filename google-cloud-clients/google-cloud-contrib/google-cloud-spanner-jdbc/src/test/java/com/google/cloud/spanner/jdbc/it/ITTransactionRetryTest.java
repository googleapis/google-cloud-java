/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc.it;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbortedDueToConcurrentModificationException;
import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest;
import com.google.cloud.spanner.jdbc.TransactionRetryListener;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This integration test tests the different scenarios for automatically retrying read/write
 * transactions, both when possible and when the transaction must abort because of a concurrent
 * update.
 */
@RunWith(JUnit4.class)
public class ITTransactionRetryTest extends ITAbstractSpannerTest {
  private static final Logger logger = Logger.getLogger(ITTransactionRetryTest.class.getName());

  @Rule public TestName testName = new TestName();

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
      connection.commit();
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

  /** Test successful retry when the commit aborts */
  @Test
  public void testCommitAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // verify that the there is no test record
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(0L)));
        assertThat(rs.next(), is(false));
      }
      // do an insert
      connection.executeUpdate(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do a commit that will first abort, and then on retry will succeed
      connection.commit();
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsFinished, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalErroredRetries, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalMaxAttemptsExceeded, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalNestedAborts, is(equalTo(0)));
      // verify that the insert succeeded
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(1L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /** Test successful retry when an insert statement aborts */
  @Test
  public void testInsertAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // verify that the there is no test record
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(0L)));
        assertThat(rs.next(), is(false));
      }
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do an insert that will abort
      connection.executeUpdate(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // do a commit
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      // verify that the insert succeeded
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(1L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /** Test successful retry when an update statement aborts */
  @Test
  public void testUpdateAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // verify that the there is no test record
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(0L)));
        assertThat(rs.next(), is(false));
      }
      // insert a test record
      connection.executeUpdate(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do an update that will abort
      connection.executeUpdate(Statement.of("UPDATE TEST SET NAME='update aborted' WHERE ID=1"));
      // do a commit
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      // verify that the update succeeded
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of(
                  "SELECT COUNT(*) AS C FROM TEST WHERE ID=1 AND NAME='update aborted'"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(1L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /** Test successful retry when a query aborts */
  @Test
  public void testQueryAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // verify that the there is no test record
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(0L)));
        assertThat(rs.next(), is(false));
      }
      // insert a test record
      connection.executeUpdate(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do a query that will abort
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(1L)));
        assertThat(rs.next(), is(false));
      }
      // do a commit
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      // verify that the update succeeded
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(1L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /** Test successful retry when a call to {@link ResultSet#next()} aborts */
  @Test
  public void testNextCallAborted() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // do a query
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        // the first record should be accessible without any problems
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(1L)));
        assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(0)));

        // indicate that the next statement should abort
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(2L)));
        assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
        // there should be only two records
        assertThat(rs.next(), is(false));
      }
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      // verify that the transaction succeeded
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(2L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /** Test successful retry after multiple aborts */
  @Test
  public void testMultipleAborts() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // verify that the there is no test record
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(0L)));
        assertThat(rs.next(), is(false));
      }
      // do three inserts which all will abort and retry
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));

      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(3)));
      assertThat(RETRY_STATISTICS.totalNestedAborts, is(equalTo(0)));
      // verify that the insert succeeded
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(3L)));
        assertThat(rs.next(), is(false));
      }
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
      // verify that the there is no test record
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(0L)));
        assertThat(rs.next(), is(false));
      }
      // insert a test record
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      // select the test record
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(1L)));
        assertThat(rs.getString("NAME"), is(equalTo("test 1")));
        assertThat(rs.next(), is(false));
      }
      // do another insert that will abort and retry
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the first test record again
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(1L)));
        assertThat(rs.getString("NAME"), is(equalTo("test 1")));
        assertThat(rs.next(), is(false));
      }
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
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
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        // iterate one step
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(1L)));
        // do another insert that will abort and retry
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        // iterate another step
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(2L)));
        // ensure we are at the end of the result set
        assertThat(rs.next(), is(false));
      }
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      // verify that all the inserts succeeded
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(3L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /** Test successful retry after a {@link ResultSet} has been fully consumed. */
  @Test
  public void testAbortWithResultSetFullyConsumed() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records and iterate over them
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing, just consume the result set
        }
      }
      // do another insert that will abort and retry
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      // verify that all the inserts succeeded
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(3L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void testAbortWithConcurrentInsert() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records and consume the entire result set
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // open a new connection and transaction and do an additional insert
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        connection2.commit();
      }
      // now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      boolean expectedException = false;
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (4, 'test 4')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
    }
  }

  @Test
  public void testAbortWithConcurrentDelete() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    // open a new connection and select the two test records
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // select the test records and consume the entire result set
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // open a new connection and transaction and remove one of the test records
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("DELETE FROM TEST WHERE ID=1"));
        connection2.commit();
      }
      // now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      boolean expectedException = false;
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
    }
  }

  @Test
  public void testAbortWithConcurrentUpdate() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    // open a new connection and select the two test records
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // select the test records and consume the entire result set
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // open a new connection and transaction and update one of the test records
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("UPDATE TEST SET NAME='test updated' WHERE ID=2"));
        connection2.commit();
      }
      // now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      boolean expectedException = false;
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
    }
  }

  /**
   * Test that shows that a transaction retry is possible even when there is a concurrent insert
   * that has an impact on a query that has been executed, as long as the user hasn't actually seen
   * the relevant part of the result of the query
   */
  @Test
  public void testAbortWithUnseenConcurrentInsert() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records and consume part of the result set
      ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"));
      assertThat(rs.next(), is(true));
      assertThat(rs.next(), is(true));
      // Open a new connection and transaction and do an additional insert. This insert will be
      // included in a retry of the above query, but this has not yet been 'seen' by the user,
      // hence is not a problem for retrying the transaction.
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        connection2.commit();
      }
      // now try to do an insert that will abort. The retry should still succeed.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(0)));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (4, 'test 4')"));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      // Consume the rest of the result set. The insert by the other transaction should now be
      // included in the result set as the transaction retried. Although this means that the result
      // is different after a retry, it is not different as seen by the user, as the user didn't
      // know that the result set did not have any more results before the transaction retry.
      assertThat(rs.next(), is(true));
      assertThat(rs.getLong("ID"), is(equalTo(3L)));
      // record with id 4 should not be visible, as it was added to the transaction after the query
      // was executed
      assertThat(rs.next(), is(false));
      rs.close();
      connection.commit();
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
    }
  }

  /**
   * This test shows what happens when an abort occurs on a call to {@link ResultSet#next()} on a
   * {@link ResultSet} that has an concurrent insert. As long as the user hasn't consumed the {@link
   * ResultSet} so far that the concurrent insert has been seen, the retry will succeed. When the
   * user has consumed the {@link ResultSet} to the point where the concurrent insert is visible,
   * the retry will fail.
   */
  @Test
  public void testAbortWithUnseenConcurrentInsertAbortOnNext() {
    // no calls to next(), this should succeed
    assertThat(testAbortWithUnseenConcurrentInsertAbortOnNext(0), is(equalTo(1)));
    // 1 call to next() should also succeed, as there were 2 records in the original result set
    assertThat(testAbortWithUnseenConcurrentInsertAbortOnNext(1), is(equalTo(1)));
    // 2 calls to next() should also succeed, as there were 2 records in the original result set and
    // the user doesn't know yet that the next call to next() will return true instead of false
    // after the concurrent insert
    assertThat(testAbortWithUnseenConcurrentInsertAbortOnNext(2), is(equalTo(1)));

    boolean expectedException = false;
    try {
      // 3 calls to next() should fail, as the user would now see the inserted record
      testAbortWithUnseenConcurrentInsertAbortOnNext(3);
    } catch (AbortedDueToConcurrentModificationException e) {
      expectedException = true;
    }
    assertThat(expectedException, is(true));
  }

  private int testAbortWithUnseenConcurrentInsertAbortOnNext(int callsToNext)
      throws AbortedDueToConcurrentModificationException {
    int retries = 0;
    clearTable();
    clearStatistics();
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      int totalRecordsSeen = 0;
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records and consume part or all of the result set
      ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"));
      for (int counter = 0; counter < callsToNext; counter++) {
        if (rs.next()) {
          totalRecordsSeen++;
        }
      }
      // Open a new connection and transaction and do an additional insert. This insert will be
      // included in a retry of the above query. Any transaction retry will fail/succeed depending
      // on whether the user has consumed enough of the result set to potentially have seen this
      // insert.
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        connection2.commit();
      }
      // Now consume the rest of the result set, but trigger a transaction retry by aborting the
      // first next() call. Without a retry, the result set should only contain 2 records. With a
      // successful retry, the result set contains 3 results. The retry will only succeed as long
      // as the user has not consumed enough of the result set to know whether there should have
      // been a record with ID 3 or not.

      // First verify that the transaction has not yet retried.
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(0)));
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);

      // Try to consume the rest of the result set.
      // This will fail with an AbortedDueToConcurrentModificationException if the retry fails.
      while (rs.next()) {
        totalRecordsSeen++;
        if (totalRecordsSeen == 3) {
          assertThat(rs.getLong("ID"), is(equalTo(3L)));
        }
      }
      // Verify that the transaction retried.
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      rs.close();
      connection.commit();
      retries = RETRY_STATISTICS.totalSuccessfulRetries;
    }
    return retries;
  }

  /**
   * Test that shows that a transaction that has aborted is considered to be rolled back, and new
   * statements will be executed in a new transaction
   */
  @Test
  public void testAbortWithConcurrentInsertAndContinue() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // Select the test records and consume the entire result set.
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // Open a new connection and transaction and do an additional insert
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        connection2.commit();
      }
      // Now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      boolean expectedException = false;
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (4, 'test 4')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));

      // the next statement should be in a new transaction as the previous transaction rolled back
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        // there should be one record from the transaction on connection2
        assertThat(rs.next(), is(true));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>The transaction aborts at commit
   *   <li>A retry starts and succeeds
   *   <li>The commit is applied again and aborts again
   *   <li>The retry is started again and then succeeds
   * </ol>
   */
  @Test
  public void testAbortTwiceOnCommit() {
    AbortInterceptor interceptor =
        new AbortInterceptor(0) {
          private int commitCount = 0;

          @Override
          protected boolean shouldAbort(String statement, ExecutionStep step) {
            if ("COMMIT".equalsIgnoreCase(statement)) {
              commitCount++;
              return commitCount <= 2;
            }
            return false;
          }
        };
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      connection.executeUpdate(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      connection.commit();
      // Assert that the transaction was retried twice.
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(2)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(2)));
      assertThat(RETRY_STATISTICS.totalNestedAborts, is(equalTo(0)));
      // Verify that the insert succeeded.
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(1L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>The transaction aborts at commit
   *   <li>A retry starts and then aborts at the insert statement
   *   <li>The retry is restarted and then succeeds
   * </ol>
   */
  @Test
  public void testNestedAbortOnInsert() {
    AbortInterceptor interceptor =
        new AbortInterceptor(0) {
          private int commitCount = 0;
          private int insertCount = 0;

          @Override
          protected boolean shouldAbort(String statement, ExecutionStep step) {
            if ("COMMIT".equalsIgnoreCase(statement)) {
              commitCount++;
              return commitCount == 1;
            } else if (statement.startsWith("INSERT INTO TEST")) {
              insertCount++;
              return insertCount == 2;
            }
            return false;
          }
        };
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      connection.executeUpdate(
          Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test aborted')"));
      connection.commit();
      // Assert that the transaction was retried (a restarted retry is counted as one successful
      // retry).
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(2)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalNestedAborts, is(equalTo(1)));
      // Verify that the insert succeeded.
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE ID=1"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(1L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>The transaction aborts at commit
   *   <li>A retry starts and then aborts at a next call in a result set
   *   <li>The retry is restarted and then succeeds
   * </ol>
   */
  @Test
  public void testNestedAbortOnNextCall() {
    AbortInterceptor interceptor =
        new AbortInterceptor(0) {
          private int nextCallsDuringRetry = 0;
          private int commitCount = 0;

          @Override
          protected boolean shouldAbort(String statement, ExecutionStep step) {
            if ("COMMIT".equalsIgnoreCase(statement)) {
              // Note that commit always has ExecutionStep == EXECUTE_STATEMENT, as a commit can
              // never
              // really be retried (it is always the last statement in a transaction, and if it
              // fails
              // because of an aborted exception, the entire transaction is retried, and the commit
              // statement is then applied again).
              commitCount++;
              return commitCount == 1;
            } else if (statement.equals("SELECT * FROM TEST ORDER BY ID")
                && step == ExecutionStep.RETRY_NEXT_ON_RESULT_SET) {
              nextCallsDuringRetry++;
              return nextCallsDuringRetry == 1;
            }
            return false;
          }
        };
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // Insert two test records.
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // Select the test records.
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        // Iterate one step. This step should abort during the retry the first time.
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(1L)));
        // Do another insert that will not be visible to the result set.
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        // iterate another step
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("ID"), is(equalTo(2L)));
        // Ensure we are at the end of the result set.
        assertThat(rs.next(), is(false));
      }
      connection.commit();
      // Verify that the transaction retried.
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(2)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalNestedAborts, is(equalTo(1)));
      // Verify that all the inserts succeeded.
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT COUNT(*) AS C FROM TEST"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(3L)));
        assertThat(rs.next(), is(false));
      }
    }
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Transaction 1 does two inserts in table TEST
   *   <li>Transaction 1 selects all records from table TEST
   *   <li>Transaction 2 inserts a record into TEST
   *   <li>Transaction 1 does another insert into TEST that aborts
   *   <li>Transaction 1 starts a retry that aborts at the SELECT statement (i.e. before the
   *       concurrent modification has been seen)
   *   <li>Transaction 1 restarts the retry that now aborts due to a concurrent modification
   *       exception
   * </ol>
   */
  @Test
  public void testNestedAbortWithConcurrentInsert() {
    AbortInterceptor interceptor =
        new AbortInterceptor(0) {
          private boolean alreadyAborted = false;

          @Override
          protected boolean shouldAbort(String statement, ExecutionStep step) {
            // Abort during retry on the select statement.
            if (!alreadyAborted
                && statement.equals("SELECT * FROM TEST ORDER BY ID")
                && step == ExecutionStep.RETRY_STATEMENT) {
              alreadyAborted = true;
              return true;
            }
            return super.shouldAbort(statement, step);
          }
        };
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // insert two test records
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      // select the test records and consume the entire result set
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // open a new connection and transaction and do an additional insert
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        connection2.commit();
      }
      // Now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      boolean expectedException = false;
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (4, 'test 4')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(2)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
      assertThat(RETRY_STATISTICS.totalNestedAborts, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
    }
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Insert two records into table TEST and commit
   *   <li>Transaction 1 updates the names of all records in the TEST table
   *   <li>Transaction 2 inserts a record in the TEST table and commits
   *   <li>Transaction 1 does another insert into TEST that aborts
   *   <li>Transaction 1 starts a retry that aborts due to a concurrent modification exception as
   *       the number of updated records will be different
   * </ol>
   */
  @Test
  public void testAbortWithDifferentUpdateCount() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    // open a new connection and update one of the records
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      connection.executeUpdate(
          Statement.of("UPDATE TEST SET NAME='test update that will fail' WHERE TRUE"));
      // open a new connection and transaction and update the same test record
      try (ITConnection connection2 = createConnection()) {
        connection2.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
        connection2.commit();
      }
      // Now try to do an insert that will abort. The retry should now fail as there has been a
      // concurrent modification.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      boolean expectedException = false;
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (4, 'test 4')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        expectedException = true;
      }
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
      assertThat(expectedException, is(true));
    }
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Insert two records into table TEST and commit
   *   <li>Try to query a non-existing table. This will lead to an exception.
   *   <li>Query all the records from the TEST table and consume the result set
   *   <li>Insert another record into TEST that aborts
   *   <li>The transaction successfully retries
   * </ol>
   */
  @Test
  public void testAbortWithExceptionOnSelect() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // do a select that will fail
      boolean expectedException = false;
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM FOO"))) {
        while (rs.next()) {
          // do nothing
        }
      } catch (SpannerException e) {
        // expected
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      // do a select that will succeed
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // now try to do an insert that will abort.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
    }
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Insert two records into table TEST and commit.
   *   <li>Try to query the non-existing table FOO. This will lead to an exception.
   *   <li>Query all the records from the TEST table and consume the result set.
   *   <li>Open another connection and create the table FOO.
   *   <li>Insert another record into TEST that aborts.
   *   <li>The transaction is internally retried. The retry fails as the SELECT statement on FOO
   *       will now succeed.
   * </ol>
   */
  @Test
  public void testAbortWithExceptionOnSelectAndConcurrentModification() {
    boolean abortedDueToConcurrentModification = false;
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // do a select that will fail
      boolean expectedException = false;
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM FOO"))) {
        while (rs.next()) {
          // do nothing
        }
      } catch (SpannerException e) {
        // expected
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      // do a select that will succeed
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // CREATE FOO
      try (ITConnection connection2 = createConnection()) {
        connection2.setAutocommit(true);
        connection2.execute(
            Statement.of("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
      }
      // Now try to do an insert that will abort. The subsequent retry will fail as the SELECT *
      // FROM FOO now returns a result.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        abortedDueToConcurrentModification = true;
      }
    }
    // DROP FOO regardless of the result to avoid any interference with other test cases
    try (ITConnection connection2 = createConnection()) {
      connection2.setAutocommit(true);
      connection2.execute(Statement.of("DROP TABLE FOO"));
    }
    assertThat(abortedDueToConcurrentModification, is(true));
    assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
    assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
    assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Insert two records into table TEST and commit.
   *   <li>Try to insert a record in the non-existing table FOO. This will lead to an exception.
   *   <li>Query all the records from the TEST table and consume the result set.
   *   <li>Open another connection and create the table FOO.
   *   <li>Insert another record into TEST that aborts.
   *   <li>The transaction is internally retried. The retry fails as the insert statement on FOO
   *       will now succeed.
   * </ol>
   */
  @Test
  public void testAbortWithExceptionOnInsertAndConcurrentModification() {
    boolean abortedDueToConcurrentModification = false;
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // do an insert that will fail
      boolean expectedException = false;
      try {
        connection.executeUpdate(Statement.of("INSERT INTO FOO (ID, NAME) VALUES (1, 'test 1')"));
      } catch (SpannerException e) {
        // expected
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      // do a select that will succeed
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // CREATE FOO
      try (ITConnection connection2 = createConnection()) {
        connection2.setAutocommit(true);
        connection2.execute(
            Statement.of("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
      }
      // Now try to do an insert that will abort. The subsequent retry will fail as the INSERT INTO
      // FOO now succeeds.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        abortedDueToConcurrentModification = true;
      }
    }
    // DROP FOO regardless of the result to avoid any interference with other test cases
    try (ITConnection connection2 = createConnection()) {
      connection2.setAutocommit(true);
      connection2.execute(Statement.of("DROP TABLE FOO"));
    }
    assertThat(abortedDueToConcurrentModification, is(true));
    assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
    assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
    assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Insert two records into table TEST and commit.
   *   <li>Create the table FOO and insert a test record.
   *   <li>Query the table FOO.
   *   <li>Query all the records from the TEST table and consume the result set.
   *   <li>Open another connection and drop the table FOO.
   *   <li>Insert another record into TEST that aborts.
   *   <li>The transaction is internally retried. The retry fails as the SELECT statement on FOO
   *       will now fail.
   * </ol>
   */
  @Test
  public void testAbortWithDroppedTableConcurrentModification() {
    boolean abortedDueToConcurrentModification = false;
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    // CREATE FOO
    try (ITConnection connection2 = createConnection()) {
      connection2.setAutocommit(true);
      connection2.execute(
          Statement.of("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
      connection2.executeUpdate(Statement.of("INSERT INTO FOO (ID, NAME) VALUES (1, 'test 1')"));
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM FOO"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // DROP FOO using a different connection
      try (ITConnection connection2 = createConnection()) {
        connection2.setAutocommit(true);
        connection2.execute(Statement.of("DROP TABLE FOO"));
      }
      // Now try to do an insert that will abort. The subsequent retry will fail as the SELECT *
      // FROM FOO now fails.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        abortedDueToConcurrentModification = true;
      }
    }
    assertThat(abortedDueToConcurrentModification, is(true));
    assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
    assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
    assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Insert two records into table TEST and commit.
   *   <li>Create the table FOO and insert a test record and commit.
   *   <li>Insert another record into the table FOO.
   *   <li>Query all the records from the TEST table and consume the result set.
   *   <li>Open another connection and drop the table FOO.
   *   <li>Insert another record into TEST that aborts.
   *   <li>The transaction is internally retried. The retry fails as the INSERT statement on FOO
   *       will now fail.
   * </ol>
   */
  @Test
  public void testAbortWithInsertOnDroppedTableConcurrentModification() {
    boolean abortedDueToConcurrentModification = false;
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    // CREATE FOO
    try (ITConnection connection2 = createConnection()) {
      connection2.setAutocommit(true);
      connection2.execute(
          Statement.of("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
      connection2.executeUpdate(Statement.of("INSERT INTO FOO (ID, NAME) VALUES (1, 'test 1')"));
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // insert a record into FOO
      connection.executeUpdate(Statement.of("INSERT INTO FOO (ID, NAME) VALUES (2, 'test 2')"));
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // DROP FOO using a different connection
      try (ITConnection connection2 = createConnection()) {
        connection2.setAutocommit(true);
        connection2.execute(Statement.of("DROP TABLE FOO"));
      }
      // Now try to do an insert that will abort. The subsequent retry will fail as the INSERT INTO
      // FOO now fails.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      try {
        connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (3, 'test 3')"));
      } catch (AbortedDueToConcurrentModificationException e) {
        abortedDueToConcurrentModification = true;
      }
    }
    assertThat(abortedDueToConcurrentModification, is(true));
    assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
    assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
    assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
  }

  /**
   * Test that shows the following:
   *
   * <ol>
   *   <li>Insert two records into table TEST and commit.
   *   <li>Create the table FOO and insert two test records and commit.
   *   <li>Query all the records from the TEST table and consume the result set.
   *   <li>Query all the records from the FOO table and consume only part of the result set.
   *   <li>Open another connection and drop the table FOO.
   *   <li>Try to consume the rest of the FOO result set. This aborts.
   *   <li>The transaction is internally retried. The retry fails as the SELECT statement on FOO
   *       will now fail.
   * </ol>
   */
  @Test
  public void testAbortWithCursorHalfwayDroppedTableConcurrentModification() {
    boolean abortedDueToConcurrentModification = false;
    AbortInterceptor interceptor = new AbortInterceptor(0);
    // first insert two test records
    try (ITConnection connection = createConnection()) {
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
      connection.executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (2, 'test 2')"));
      connection.commit();
    }
    // CREATE FOO
    try (ITConnection connection2 = createConnection()) {
      connection2.setAutocommit(true);
      connection2.execute(
          Statement.of("CREATE TABLE FOO (ID INT64, NAME STRING(100)) PRIMARY KEY (ID)"));
      connection2.executeUpdate(Statement.of("INSERT INTO FOO (ID, NAME) VALUES (1, 'test 1')"));
      connection2.executeUpdate(Statement.of("INSERT INTO FOO (ID, NAME) VALUES (2, 'test 2')"));
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST"))) {
        while (rs.next()) {
          // do nothing
        }
      }
      // SELECT FROM FOO and consume part of the result set
      ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM FOO"));
      assertThat(rs.next(), is(true));
      // DROP FOO using a different connection
      try (ITConnection connection2 = createConnection()) {
        connection2.setAutocommit(true);
        connection2.execute(Statement.of("DROP TABLE FOO"));
      }
      // try to continue to consume the result set, but this will now abort.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      try {
        // This will fail as the retry will not succeed.
        rs.next();
      } catch (AbortedDueToConcurrentModificationException e) {
        abortedDueToConcurrentModification = true;
      } finally {
        rs.close();
      }
    }
    assertThat(abortedDueToConcurrentModification, is(true));
    assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
    assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
    assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
  }

  /** Test the successful retry of a transaction with a large {@link ResultSet} */
  @Test
  public void testRetryLargeResultSet() {
    final int NUMBER_OF_TEST_RECORDS = 100000;
    final long UPDATED_RECORDS = 1000L;
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection = createConnection()) {
      // insert test records
      for (int i = 0; i < NUMBER_OF_TEST_RECORDS; i++) {
        connection.bufferedWrite(
            Mutation.newInsertBuilder("TEST").set("ID").to(i).set("NAME").to("test " + i).build());
        if (i % 1000 == 0) {
          connection.commit();
        }
      }
      connection.commit();
    }
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // select the test records and iterate over them
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing, just consume the result set
        }
      }
      // Do an update that will abort and retry.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      connection.executeUpdate(
          Statement.newBuilder("UPDATE TEST SET NAME='updated' WHERE ID<@max_id")
              .bind("max_id")
              .to(UPDATED_RECORDS)
              .build());
      connection.commit();
      // verify that the update succeeded
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE NAME='updated'"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(UPDATED_RECORDS)));
        assertThat(rs.next(), is(false));
      }
      // Verify that the transaction retried.
      assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
      assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
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
      // insert test records
      for (int i = 0; i < NUMBER_OF_TEST_RECORDS; i++) {
        connection.bufferedWrite(
            Mutation.newInsertBuilder("TEST").set("ID").to(i).set("NAME").to("test " + i).build());
        if (i % 1000 == 0) {
          connection.commit();
        }
      }
      connection.commit();
      // select the test records and iterate over them
      // reduce the abort rate to 0.01% as each next() call could abort
      interceptor.setProbability(0.0001D);
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        while (rs.next()) {
          // do nothing, just consume the result set
        }
      }
      // increase the abort rate to 50%
      interceptor.setProbability(0.50D);
      connection.executeUpdate(
          Statement.newBuilder("UPDATE TEST SET NAME='updated' WHERE ID<@max_id")
              .bind("max_id")
              .to(UPDATED_RECORDS)
              .build());
      connection.commit();
      // verify that the update succeeded
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of("SELECT COUNT(*) AS C FROM TEST WHERE NAME='updated'"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong("C"), is(equalTo(UPDATED_RECORDS)));
        assertThat(rs.next(), is(false));
      }
      connection.commit();
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

  @Test
  public void testAbortWithConcurrentInsertOnEmptyTable() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection =
        createConnection(interceptor, new CountTransactionRetryListener())) {
      // select the test records but do not consume the result set
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        // Open a new connection and transaction and do an insert. This insert will be
        // included in a retry of the above query, but this has not yet been 'seen' by the user,
        // hence is not a problem for retrying the transaction.
        try (ITConnection connection2 = createConnection()) {
          connection2.executeUpdate(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
          connection2.commit();
        }
        // Now try to consume the result set, but the call to next() will throw an AbortedException.
        // The retry should still succeed.
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(0)));
        assertThat(rs.next(), is(true));
        assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(1)));
        assertThat(rs.next(), is(false));
      }
      connection.commit();

      // Now do the same, but this time we will consume the empty result set. The retry should now
      // fail.
      clearTable();
      clearStatistics();
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST ORDER BY ID"))) {
        assertThat(rs.next(), is(false));
        // Open a new connection and transaction and do an insert. This insert will be
        // included in a retry of the above query, and this time it will cause the retry to fail.
        try (ITConnection connection2 = createConnection()) {
          connection2.executeUpdate(
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1, 'test 1')"));
          connection2.commit();
        }
        // this time the abort will occur on the call to commit()
        interceptor.setProbability(1.0);
        interceptor.setOnlyInjectOnce(true);
        assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(0)));
        boolean expectedException = false;
        try {
          connection.commit();
        } catch (AbortedDueToConcurrentModificationException e) {
          expectedException = true;
        }
        // No successful retries.
        assertThat(RETRY_STATISTICS.totalRetryAttemptsStarted, is(equalTo(1)));
        assertThat(RETRY_STATISTICS.totalConcurrentModifications, is(equalTo(1)));
        assertThat(RETRY_STATISTICS.totalSuccessfulRetries, is(equalTo(0)));
        assertThat(expectedException, is(true));
      }
    }
  }
}

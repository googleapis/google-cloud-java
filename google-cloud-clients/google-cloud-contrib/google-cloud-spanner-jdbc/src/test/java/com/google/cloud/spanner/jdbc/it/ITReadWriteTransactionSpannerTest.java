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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import com.google.cloud.spanner.jdbc.TransactionRetryListener;

@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITReadWriteTransactionSpannerTest extends ITAbstractSpannerTest {

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Override
  protected void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=false");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @Test
  public void test01_SqlScript() throws Exception {
    SqlScriptVerifier verifier = new SqlScriptVerifier(new ITConnectionProvider());
    verifier.verifyStatementsInFile("ITReadWriteTransactionSpannerTest.sql",
        SqlScriptVerifier.class, true);
  }

  @Test
  public void test02_WriteMutation() throws Exception {
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(
          Mutation.newInsertBuilder("TEST").set("ID").to(1000L).set("NAME").to("FOO").build());
      connection.commit();
      assertThat(connection.getCommitTimestamp(), is(notNullValue()));
    }
  }

  @Test
  public void test04_InsertWithTimeoutExceededRetryUntilSuccessfulAndThenCommit() {
    try (ITConnection connection = createConnection()) {
      long timeout = 1L;
      while (true) {
        connection.setStatementTimeout(timeout, TimeUnit.MILLISECONDS);
        try {
          connection
              .executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (1003, 'test')"));
        } catch (SpannerException e) {
          if (e.getErrorCode() != ErrorCode.DEADLINE_EXCEEDED) {
            throw e;
          }
          connection.clearStatementTimeout();
          connection.rollback();
        }
        // check whether the statement succeeded
        connection.clearStatementTimeout();
        try (ResultSet rs =
            connection.executeQuery(Statement.of("SELECT * FROM TEST WHERE ID=1003"))) {
          if (rs.next()) {
            break;
          }
        }
        timeout = timeout * 2;
      }
      connection.commit();
    }
    try (ITConnection connection = createConnection()) {
      try (ResultSet rs =
          connection.executeQuery(Statement.of("SELECT * FROM TEST WHERE ID=1003"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void test07_InsertWithAbortedTransactionWithRetry() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    try (ITConnection connection = createConnection(interceptor)) {
      connection.setRetryAbortsInternally(true);
      connection
          .executeUpdate(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (6, 'test aborted')"));
      // indicate that the next statement should abort
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // do a commit that will first abort, and then succeed on retry
      connection.commit();
      try (ResultSet rs = connection.executeQuery(Statement.of("SELECT * FROM TEST WHERE ID=6"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getString("NAME"), is(equalTo("test aborted")));
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void test09_BatchUpdate() {
    try (ITConnection con1 = createConnection(); ITConnection con2 = createConnection()) {
      long[] updateCounts = con1.executeBatchUpdate(
          Arrays.asList(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (10, 'Batch value 1')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (11, 'Batch value 2')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (12, 'Batch value 3')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (13, 'Batch value 4')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (14, 'Batch value 5')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (15, 'Batch value 6')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (16, 'Batch value 7')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (17, 'Batch value 8')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (18, 'Batch value 9')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (19, 'Batch value 10')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (20, 'Batch value 11')")));
      assertThat(updateCounts,
          is(equalTo(new long[] {1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L})));
      // Verify that the uncommitted values can be read on the connection that did the insert.
      try (ResultSet rs =
          con1.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=10 AND ID<=20"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(11L)));
      }
      // Verify that the uncommitted values cannot be read on another connection.
      try (ResultSet rs =
          con2.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=10 AND ID<=20"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(0L)));
      }
      // Commit con2 to avoid the transaction from aborting on the next query.
      con2.commit();
      con1.commit();
      // Verify that the committed values now can be read on another connection.
      try (ResultSet rs =
          con2.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=10 AND ID<=20"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(11L)));
      }
    }
  }

  @Test
  public void test10_BatchUpdateWithException() {
    try (ITConnection con1 = createConnection(); ITConnection con2 = createConnection()) {
      boolean expectedException = false;
      try {
        con1.executeBatchUpdate(
            Arrays.asList(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (21, 'Batch value 1')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (22, 'Batch value 2')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (23, 'Batch value 3')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (24, 'Batch value 4')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (25, 'Batch value 5')"),
                Statement.of("INSERT INTO TEST_NOT_FOUND (ID, NAME) VALUES (26, 'Batch value 6')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (27, 'Batch value 7')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (28, 'Batch value 8')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (29, 'Batch value 9')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (30, 'Batch value 10')")));
      } catch (SpannerBatchUpdateException e) {
        expectedException = true;
        assertThat(e.getUpdateCounts(), is(equalTo(new long[] {1L, 1L, 1L, 1L, 1L})));
      }
      assertThat(expectedException, is(true));
      // Verify that the uncommitted values can be read on the connection that did the insert.
      try (ResultSet rs =
          con1.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=21 AND ID<=30"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(5L)));
      }
      // Verify that the uncommitted values cannot be read on another connection.
      try (ResultSet rs =
          con2.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=21 AND ID<=30"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(0L)));
      }
      // Commit on con2 to avoid its transaction from being aborted.
      con2.commit();
      con1.commit();
      // Verify that the committed values now can be read on another connection.
      try (ResultSet rs =
          con2.executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=21 AND ID<=30"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(5L)));
      }
    }
  }

  /** Test that a transaction retry works with batch update. */
  @Test
  public void test11_BatchUpdateWithAbortedTransactionWithRetry() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    TransactionRetryListener listener = new TransactionRetryListener() {
      private boolean started = false;
      private boolean finished = false;

      @Override
      public void retryStarting(Timestamp transactionStarted, long transactionId,
          int retryAttempt) {
        started = true;
      }

      @Override
      public void retryFinished(Timestamp transactionStarted, long transactionId, int retryAttempt,
          RetryResult result) {
        // In theory there might be multiple aborts in addition to the one we are forcing, but in
        // the end the last one should be successful.
        finished = (result == RetryResult.RETRY_SUCCESSFUL);
      }

      @Override
      public String toString() {
        return (started && finished) ? "success" : "fail";
      }
    };
    try (ITConnection connection = createConnection(interceptor)) {
      connection.addTransactionRetryListener(listener);
      connection.setRetryAbortsInternally(true);
      connection.executeBatchUpdate(
          Arrays.asList(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (31, 'Batch value 1')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (32, 'Batch value 2')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (33, 'Batch value 3')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (34, 'Batch value 4')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (35, 'Batch value 5')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (36, 'Batch value 6')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (37, 'Batch value 7')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (38, 'Batch value 8')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (39, 'Batch value 9')"),
              Statement.of("INSERT INTO TEST (ID, NAME) VALUES (40, 'Batch value 10')")));
      // Indicate that the next statement should abort.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // Do a commit that will first abort, and then succeed on retry.
      connection.commit();
      assertThat(listener.toString(), is(equalTo("success")));
      try (ResultSet rs = connection
          .executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=31 AND ID<=40"))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getLong(0), is(equalTo(10L)));
      }
    }
  }

  /**
   * Test that a transaction retry works with batch update that has a statement that produces an
   * error.
   */
  @Test
  public void test12_BatchUpdateWithExceptionAndAbortedTransactionWithRetry() {
    AbortInterceptor interceptor = new AbortInterceptor(0);
    TransactionRetryListener listener = new TransactionRetryListener() {
      private boolean started = false;
      private boolean finished = false;

      @Override
      public void retryStarting(Timestamp transactionStarted, long transactionId,
          int retryAttempt) {
        started = true;
      }

      @Override
      public void retryFinished(Timestamp transactionStarted, long transactionId, int retryAttempt,
          RetryResult result) {
        // In theory there might be multiple aborts in addition to the one we are forcing, but in
        // the end the last one should be successful.
        finished = (result == RetryResult.RETRY_SUCCESSFUL);
      }

      @Override
      public String toString() {
        return (started && finished) ? "success" : "fail";
      }
    };
    try (ITConnection connection = createConnection(interceptor)) {
      connection.addTransactionRetryListener(listener);
      connection.setRetryAbortsInternally(true);
      boolean expectedException = false;
      try {
        connection.executeBatchUpdate(
            Arrays.asList(Statement.of("INSERT INTO TEST (ID, NAME) VALUES (41, 'Batch value 1')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (42, 'Batch value 2')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (43, 'Batch value 3')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (44, 'Batch value 4')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (45, 'Batch value 5')"),
                Statement.of("INSERT INTO TEST_NOT_FOUND (ID, NAME) VALUES (46, 'Batch value 6')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (47, 'Batch value 7')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (48, 'Batch value 8')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (49, 'Batch value 9')"),
                Statement.of("INSERT INTO TEST (ID, NAME) VALUES (50, 'Batch value 10')")));
      } catch (SpannerBatchUpdateException e) {
        assertThat(e.getUpdateCounts(), is(equalTo(new long[] {1L, 1L, 1L, 1L, 1L})));
        expectedException = true;
      }
      assertThat(expectedException, is(true));
      // Indicate that the next statement should abort.
      interceptor.setProbability(1.0);
      interceptor.setOnlyInjectOnce(true);
      // Do a commit that will first abort, and then succeed on retry.
      connection.commit();
      assertThat(listener.toString(), is(equalTo("success")));
      try (ResultSet rs = connection
          .executeQuery(Statement.of("SELECT COUNT(*) FROM TEST WHERE ID>=41 AND ID<=50"))) {
        assertThat(rs.next(), is(true));
        // Assert that the five first statements succeeded.
        assertThat(rs.getLong(0), is(equalTo(5L)));
      }
    }
  }
}

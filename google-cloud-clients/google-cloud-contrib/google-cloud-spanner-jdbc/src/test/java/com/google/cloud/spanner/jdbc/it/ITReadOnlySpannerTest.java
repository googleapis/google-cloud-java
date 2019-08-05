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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest;
import com.google.cloud.spanner.jdbc.SpannerExceptionMatcher;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This test class runs a SQL script for testing a connection in read-only mode, but also contains a
 * number of separate test methods that cannot be expressed in a pure SQL test.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
public class ITReadOnlySpannerTest extends ITAbstractSpannerTest {
  private static final Logger logger = Logger.getLogger(ITReadOnlySpannerTest.class.getName());
  private static final long TEST_ROWS_COUNT = 1000L;

  @Rule public ExpectedException exception = ExpectedException.none();

  @Override
  protected void appendConnectionUri(StringBuilder url) {
    url.append(";readOnly=true");
  }

  @Before
  public void createTestTables() throws Exception {
    try (ITConnection connection = createConnection()) {
      if (!(tableExists(connection, "NUMBERS") && tableExists(connection, "PRIME_NUMBERS"))) {
        // create tables
        SqlScriptVerifier verifier = new SqlScriptVerifier(new ITConnectionProvider());
        verifier.verifyStatementsInFile(
            "ITReadOnlySpannerTest_CreateTables.sql", SqlScriptVerifier.class, true);

        // fill tables with data
        connection.setAutocommit(false);
        connection.setReadOnly(false);
        for (long number = 1L; number <= TEST_ROWS_COUNT; number++) {
          connection.bufferedWrite(
              Mutation.newInsertBuilder("NUMBERS")
                  .set("number")
                  .to(number)
                  .set("name")
                  .to(Long.toBinaryString(number))
                  .build());
        }
        for (long number = 1L; number <= TEST_ROWS_COUNT; number++) {
          if (BigInteger.valueOf(number).isProbablePrime(Integer.MAX_VALUE)) {
            connection.bufferedWrite(
                Mutation.newInsertBuilder("PRIME_NUMBERS")
                    .set("prime_number")
                    .to(number)
                    .set("binary_representation")
                    .to(Long.toBinaryString(number))
                    .build());
          }
        }
        connection.commit();
      }
    }
  }

  @Test
  public void testSqlScript() throws Exception {
    SqlScriptVerifier verifier = new SqlScriptVerifier(new ITConnectionProvider());
    verifier.verifyStatementsInFile("ITReadOnlySpannerTest.sql", SqlScriptVerifier.class, true);
  }

  @Test
  public void testStatementTimeoutTransactional() throws Exception {
    try (ITConnection connection = createConnection()) {
      connection.beginTransaction();
      connection.setStatementTimeout(1L, TimeUnit.MILLISECONDS);
      exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of(
                  "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS PRIME_NUMBER_RATIO"))) {}
      // should never be reached
      connection.commit();
    }
  }

  @Test
  public void testStatementTimeoutTransactionalMultipleStatements() throws Exception {
    long startTime = System.currentTimeMillis();
    try (ITConnection connection = createConnection()) {
      connection.beginTransaction();
      for (int i = 0; i < 3; i++) {
        boolean timedOut = false;
        connection.setStatementTimeout(1L, TimeUnit.MILLISECONDS);
        try (ResultSet rs =
            connection.executeQuery(
                Statement.of(
                    "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS PRIME_NUMBER_RATIO"))) {
        } catch (SpannerException e) {
          timedOut = e.getErrorCode() == ErrorCode.DEADLINE_EXCEEDED;
        }
        assertThat(timedOut, is(true));
      }
      connection.commit();
    }
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    if (executionTime > 25L) {
      logger.warning("Total test execution time exceeded 25 milliseconds: " + executionTime);
    } else {
      logger.info("Total test execution time: " + executionTime);
    }
  }

  @Test
  public void testStatementTimeoutAutocommit() throws Exception {
    try (ITConnection connection = createConnection()) {
      assertThat(connection.isAutocommit(), is(true));
      connection.setStatementTimeout(1L, TimeUnit.MILLISECONDS);
      exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.DEADLINE_EXCEEDED));
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of(
                  "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS PRIME_NUMBER_RATIO"))) {}
    }
  }

  @Test
  public void testAnalyzeQuery() {
    try (ITConnection connection = createConnection()) {
      for (QueryAnalyzeMode mode : QueryAnalyzeMode.values()) {
        try (ResultSet rs =
            connection.analyzeQuery(
                Statement.of(
                    "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS PRIME_NUMBER_RATIO"),
                mode)) {
          // next has not yet returned false
          assertThat(rs.getStats(), is(nullValue()));
          while (rs.next()) {
            // ignore
          }
          assertThat(rs.getStats(), is(notNullValue()));
        }
      }
    }
  }

  @Test
  public void testQueryWithOptions() {
    try (ITConnection connection = createConnection()) {
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of(
                  "SELECT (SELECT CAST(COUNT(*) AS FLOAT64) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS PRIME_NUMBER_RATIO"),
              Options.prefetchChunks(100000))) {
        assertThat(rs.next(), is(true));
        assertThat(rs.getDouble(0), is(notNullValue()));
        assertThat(rs.next(), is(false));
      }
    }
  }

  @Test
  public void testMultipleOpenResultSets() throws InterruptedException {
    try (ITConnection connection = createConnection()) {
      final ResultSet rs1 = connection.executeQuery(Statement.of("SELECT * FROM PRIME_NUMBERS"));
      final ResultSet rs2 = connection.executeQuery(Statement.of("SELECT * FROM NUMBERS"));
      ExecutorService exec = Executors.newFixedThreadPool(2);
      exec.submit(
          new Runnable() {
            @Override
            public void run() {
              while (rs1.next()) {}
            }
          });
      exec.submit(
          new Runnable() {
            @Override
            public void run() {
              while (rs2.next()) {}
            }
          });
      exec.shutdown();
      exec.awaitTermination(1000L, TimeUnit.SECONDS);
      rs1.close();
      rs2.close();
    }
  }
}

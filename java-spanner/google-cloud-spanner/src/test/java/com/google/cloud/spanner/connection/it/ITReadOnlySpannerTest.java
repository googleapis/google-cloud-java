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

package com.google.cloud.spanner.connection.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import com.google.cloud.spanner.connection.SqlScriptVerifier;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This test class runs a SQL script for testing a connection in read-only mode, but also contains a
 * number of separate test methods that cannot be expressed in a pure SQL test.
 */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITReadOnlySpannerTest extends ITAbstractSpannerTest {
  private static final long TEST_ROWS_COUNT = 1000L;

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
            "ITReadOnlySpannerTest_CreateTables.sql", SqlScriptVerifier.class, false);

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
    // Wait 100ms to ensure that staleness tests in the script succeed.
    Thread.sleep(100L);
    SqlScriptVerifier verifier = new SqlScriptVerifier(new ITConnectionProvider());
    verifier.verifyStatementsInFile("ITReadOnlySpannerTest.sql", SqlScriptVerifier.class, false);
  }

  @Test
  public void testStatementTimeoutTransactional() {
    try (ITConnection connection = createConnection()) {
      connection.beginTransaction();
      connection.setStatementTimeout(1L, TimeUnit.MILLISECONDS);
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of(
                  "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS"
                      + " PRIME_NUMBER_RATIO"))) {
        fail("Expected exception");
      }
      // should never be reached
      connection.commit();
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, ex.getErrorCode());
    }
  }

  @Test
  public void testStatementTimeoutTransactionalMultipleStatements() {
    try (ITConnection connection = createConnection()) {
      connection.beginTransaction();
      for (int i = 0; i < 3; i++) {
        connection.setStatementTimeout(1L, TimeUnit.MICROSECONDS);
        try (ResultSet rs =
            connection.executeQuery(
                Statement.of(
                    "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS"
                        + " PRIME_NUMBER_RATIO"))) {
          fail("Missing expected exception");
        } catch (SpannerException e) {
          assertThat(e.getErrorCode(), is(ErrorCode.DEADLINE_EXCEEDED));
        }
      }
      connection.commit();
    }
  }

  @Test
  public void testStatementTimeoutAutocommit() {
    try (ITConnection connection = createConnection()) {
      assertThat(connection.isAutocommit(), is(true));
      connection.setStatementTimeout(1L, TimeUnit.MILLISECONDS);
      try (ResultSet rs =
          connection.executeQuery(
              Statement.of(
                  "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS"
                      + " PRIME_NUMBER_RATIO"))) {
        fail("Expected exception");
      } catch (SpannerException ex) {
        assertEquals(ErrorCode.DEADLINE_EXCEEDED, ex.getErrorCode());
      }
    }
  }

  @Test
  public void testAnalyzeQuery() {
    assumeFalse("analyze query is not supported on the emulator", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      for (QueryAnalyzeMode mode : QueryAnalyzeMode.values()) {
        try (ResultSet rs =
            connection.analyzeQuery(
                Statement.of(
                    "SELECT (SELECT COUNT(*) FROM PRIME_NUMBERS)/(SELECT COUNT(*) FROM NUMBERS) AS"
                        + " PRIME_NUMBER_RATIO"),
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
                  "SELECT (SELECT CAST(COUNT(*) AS FLOAT64) FROM PRIME_NUMBERS)/(SELECT COUNT(*)"
                      + " FROM NUMBERS) AS PRIME_NUMBER_RATIO"),
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
          () -> {
            while (rs1.next()) {}
          });
      exec.submit(
          () -> {
            while (rs2.next()) {}
          });
      exec.shutdown();
      exec.awaitTermination(1000L, TimeUnit.SECONDS);
      rs1.close();
      rs2.close();
    }
  }

  @Test
  public void testGetMetadataFromAnalyzeQuery() {
    assumeFalse("analyze query is not supported on the emulator", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      // Request a query plan without executing the query and verify that we can get the column
      // metadata of the query without calling resultSet.next() first.
      try (ResultSet resultSet =
          connection.analyzeQuery(
              Statement.of("SELECT number, name FROM NUMBERS"), QueryAnalyzeMode.PLAN)) {
        assertEquals(2, resultSet.getColumnCount());

        assertEquals(0, resultSet.getColumnIndex("number"));
        assertEquals("number", resultSet.getType().getStructFields().get(0).getName());
        assertEquals(Type.int64(), resultSet.getColumnType(0));
        assertEquals(Type.int64(), resultSet.getColumnType("number"));

        assertEquals(1, resultSet.getColumnIndex("name"));
        assertEquals("name", resultSet.getType().getStructFields().get(1).getName());
        assertEquals(Type.string(), resultSet.getColumnType(1));
        assertEquals(Type.string(), resultSet.getColumnType("name"));
      }
    }
  }
}

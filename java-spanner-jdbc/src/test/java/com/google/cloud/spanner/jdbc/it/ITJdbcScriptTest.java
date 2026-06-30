/*
 * Copyright 2022 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier.JdbcGenericConnection;
import com.google.cloud.spanner.testing.EmulatorSpannerHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Integration test that creates and fills a test database entirely using only sql scripts, and then
 * performs all possible operations on this test database using only sql scripts. This test uses the
 * JDBC driver for Spanner.
 */
@Category(ParallelIntegrationTest.class)
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITJdbcScriptTest extends ITAbstractJdbcTest {
  @ClassRule public static JdbcIntegrationTestEnv env = new JdbcIntegrationTestEnv();

  private static final String CREATE_TABLES_FILE_SQL = "ITSqlScriptTest_CreateTables.sql";
  private static final String INSERT_AND_VERIFY_TEST_DATA_SQL =
      "ITSqlScriptTest_InsertTestData.sql";
  private static final String TEST_GET_READ_TIMESTAMP_SQL =
      "ITSqlScriptTest_TestGetReadTimestamp.sql";
  private static final String TEST_GET_COMMIT_TIMESTAMP_SQL =
      "ITSqlScriptTest_TestGetCommitTimestamp.sql";
  private static final String TEST_TEMPORARY_TRANSACTIONS_SQL =
      "ITSqlScriptTest_TestTemporaryTransactions.sql";
  private static final String TEST_TRANSACTION_MODE_SQL = "ITSqlScriptTest_TestTransactionMode.sql";
  private static final String TEST_TRANSACTION_MODE_READ_ONLY_SQL =
      "ITSqlScriptTest_TestTransactionMode_ReadOnly.sql";
  private static final String TEST_READ_ONLY_STALENESS_SQL =
      "ITSqlScriptTest_TestReadOnlyStaleness.sql";
  private static final String TEST_AUTOCOMMIT_DML_MODE_SQL =
      "ITSqlScriptTest_TestAutocommitDmlMode.sql";
  private static final String TEST_AUTOCOMMIT_READ_ONLY_SQL =
      "ITSqlScriptTest_TestAutocommitReadOnly.sql";
  private static final String TEST_QUERY_OPTIONS_SQL = "ITSqlScriptTest_TestQueryOptions.sql";
  private static final String TEST_STATEMENT_TIMEOUT_SQL =
      "ITSqlScriptTest_TestStatementTimeout.sql";
  private static final String TEST_SET_STATEMENTS_SQL = "ITSqlScriptTest_TestSetStatements.sql";
  private static final String TEST_INVALID_STATEMENTS_SQL =
      "ITSqlScriptTest_TestInvalidStatements.sql";

  private static final String CREATE_TABLES_FILE_PG = "PostgreSQL/ITScriptTest_CreateTables.sql";
  private static final String INSERT_AND_VERIFY_TEST_DATA_PG =
      "PostgreSQL/ITScriptTest_InsertTestData.sql";
  private static final String TEST_GET_READ_TIMESTAMP_PG =
      "PostgreSQL/ITScriptTest_TestGetReadTimestamp.sql";
  private static final String TEST_GET_COMMIT_TIMESTAMP_PG =
      "PostgreSQL/ITSqlScriptTest_TestGetCommitTimestamp.sql";
  private static final String TEST_TEMPORARY_TRANSACTIONS_PG =
      "PostgreSQL/ITScriptTest_TestTemporaryTransactions.sql";
  private static final String TEST_TRANSACTION_MODE_PG =
      "PostgreSQL/ITScriptTest_TestTransactionMode.sql";
  private static final String TEST_TRANSACTION_MODE_READ_ONLY_PG =
      "PostgreSQL/ITScriptTest_TestTransactionMode_ReadOnly.sql";
  private static final String TEST_READ_ONLY_STALENESS_PG =
      "PostgreSQL/ITScriptTest_TestReadOnlyStaleness.sql";
  private static final String TEST_AUTOCOMMIT_DML_MODE_PG =
      "PostgreSQL/ITScriptTest_TestAutocommitDmlMode.sql";
  private static final String TEST_AUTOCOMMIT_READ_ONLY_PG =
      "PostgreSQL/ITScriptTest_TestAutocommitReadOnly.sql";
  private static final String TEST_QUERY_OPTIONS_PG =
      "PostgreSQL/ITScriptTest_TestQueryOptions.sql";
  private static final String TEST_SET_STATEMENTS_PG =
      "PostgreSQL/ITScriptTest_TestSetStatements.sql";
  private static final String TEST_INVALID_STATEMENTS_PG =
      "PostgreSQL/ITScriptTest_TestInvalidStatements.sql";

  private final JdbcSqlScriptVerifier verifier = new JdbcSqlScriptVerifier();

  @Override
  public Dialect getDialect() {
    return dialect.dialect;
  }

  @Parameters(name = "Dialect = {0}")
  public static List<DialectTestParameter> data() {
    HashMap<String, String> googleStandardSqlScripts = new HashMap<>();
    googleStandardSqlScripts.put("CREATE_TABLES_FILE", CREATE_TABLES_FILE_SQL);
    googleStandardSqlScripts.put("INSERT_AND_VERIFY_TEST_DATA", INSERT_AND_VERIFY_TEST_DATA_SQL);
    googleStandardSqlScripts.put("TEST_GET_READ_TIMESTAMP", TEST_GET_READ_TIMESTAMP_SQL);
    googleStandardSqlScripts.put("TEST_GET_COMMIT_TIMESTAMP", TEST_GET_COMMIT_TIMESTAMP_SQL);
    googleStandardSqlScripts.put("TEST_TEMPORARY_TRANSACTIONS", TEST_TEMPORARY_TRANSACTIONS_SQL);
    googleStandardSqlScripts.put("TEST_TRANSACTION_MODE", TEST_TRANSACTION_MODE_SQL);
    googleStandardSqlScripts.put(
        "TEST_TRANSACTION_MODE_READ_ONLY", TEST_TRANSACTION_MODE_READ_ONLY_SQL);
    googleStandardSqlScripts.put("TEST_READ_ONLY_STALENESS", TEST_READ_ONLY_STALENESS_SQL);
    googleStandardSqlScripts.put("TEST_AUTOCOMMIT_DML_MODE", TEST_AUTOCOMMIT_DML_MODE_SQL);
    googleStandardSqlScripts.put("TEST_AUTOCOMMIT_READ_ONLY", TEST_AUTOCOMMIT_READ_ONLY_SQL);
    googleStandardSqlScripts.put("TEST_QUERY_OPTIONS", TEST_QUERY_OPTIONS_SQL);
    googleStandardSqlScripts.put("TEST_STATEMENT_TIMEOUT", TEST_STATEMENT_TIMEOUT_SQL);
    googleStandardSqlScripts.put("TEST_SET_STATEMENTS", TEST_SET_STATEMENTS_SQL);
    googleStandardSqlScripts.put("TEST_INVALID_STATEMENTS", TEST_INVALID_STATEMENTS_SQL);
    HashMap<String, String> postgresScripts = new HashMap<>();
    postgresScripts.put("CREATE_TABLES_FILE", CREATE_TABLES_FILE_PG);
    postgresScripts.put("INSERT_AND_VERIFY_TEST_DATA", INSERT_AND_VERIFY_TEST_DATA_PG);
    postgresScripts.put("TEST_GET_READ_TIMESTAMP", TEST_GET_READ_TIMESTAMP_PG);
    postgresScripts.put("TEST_GET_COMMIT_TIMESTAMP", TEST_GET_COMMIT_TIMESTAMP_PG);
    postgresScripts.put("TEST_TEMPORARY_TRANSACTIONS", TEST_TEMPORARY_TRANSACTIONS_PG);
    postgresScripts.put("TEST_TRANSACTION_MODE", TEST_TRANSACTION_MODE_PG);
    postgresScripts.put("TEST_TRANSACTION_MODE_READ_ONLY", TEST_TRANSACTION_MODE_READ_ONLY_PG);
    postgresScripts.put("TEST_READ_ONLY_STALENESS", TEST_READ_ONLY_STALENESS_PG);
    postgresScripts.put("TEST_AUTOCOMMIT_DML_MODE", TEST_AUTOCOMMIT_DML_MODE_PG);
    postgresScripts.put("TEST_AUTOCOMMIT_READ_ONLY", TEST_AUTOCOMMIT_READ_ONLY_PG);
    postgresScripts.put("TEST_QUERY_OPTIONS", TEST_QUERY_OPTIONS_PG);
    postgresScripts.put("TEST_SET_STATEMENTS", TEST_SET_STATEMENTS_PG);
    postgresScripts.put("TEST_INVALID_STATEMENTS", TEST_INVALID_STATEMENTS_PG);
    List<DialectTestParameter> params = new ArrayList<>();
    params.add(
        new DialectTestParameter(
            Dialect.GOOGLE_STANDARD_SQL, CREATE_TABLES_FILE_SQL, googleStandardSqlScripts, null));
    params.add(
        new DialectTestParameter(Dialect.POSTGRESQL, CREATE_TABLES_FILE_PG, postgresScripts, null));
    return params;
  }

  @Parameterized.Parameter(0)
  public DialectTestParameter dialect;

  private Database database;

  @Before
  public void setup() {
    database = env.getOrCreateDatabase(getDialect(), Collections.emptyList());
  }

  /** Create test tables and verify their existence */
  @Test
  public void test01_CreateTables() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.createTableFile,
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  /** Insert some test data */
  @Test
  public void test02_InsertTestData() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("INSERT_AND_VERIFY_TEST_DATA"),
          JdbcSqlScriptVerifier.class,
          false);
    } catch (SQLException e) {
      if (env.getTestHelper().isEmulator()
          && e.getErrorCode() == ErrorCode.ALREADY_EXISTS.getGrpcStatusCode().value()) {
        // Ignore, this is expected as errors during a read/write transaction are sticky on the
        // emulator.
      }
    } catch (SpannerException e) {
      if (env.getTestHelper().isEmulator() && e.getErrorCode() == ErrorCode.ALREADY_EXISTS) {
        // Ignore, this is expected as errors during a read/write transaction are sticky on the
        // emulator.
      }
    }
  }

  @Test
  public void test03_TestGetReadTimestamp() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_GET_READ_TIMESTAMP"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test04_TestGetCommitTimestamp() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_GET_COMMIT_TIMESTAMP"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test05_TestTemporaryTransactions() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_TEMPORARY_TRANSACTIONS"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test06_TestTransactionMode() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_TRANSACTION_MODE"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test07_TestTransactionModeReadOnly() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_TRANSACTION_MODE_READ_ONLY"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test08_TestReadOnlyStaleness() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_READ_ONLY_STALENESS"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test09_TestAutocommitDmlMode() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_AUTOCOMMIT_DML_MODE"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test10_TestAutocommitReadOnly() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_AUTOCOMMIT_READ_ONLY"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test11_TestStatementTimeout() throws Exception {
    // Statements with set operations in subqueries are not supported
    assumeFalse(dialect.dialect == Dialect.POSTGRESQL);
    assumeFalse(
        "The emulator is too quick for timeouts to be reliable",
        EmulatorSpannerHelper.isUsingEmulator());
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_STATEMENT_TIMEOUT"),
          JdbcSqlScriptVerifier.class,
          false);
    }
    try (Connection connection = createConnection(env, database)) {
      // Create a statement with a query timeout, but do not set a statement timeout on the
      // connection. SHOW STATEMENT_TIMEOUT should then return a null value.
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(1);
      statement.execute("SHOW VARIABLE STATEMENT_TIMEOUT");
      try (ResultSet rs = statement.getResultSet()) {
        assertTrue(rs.next());
        assertNull(rs.getString("STATEMENT_TIMEOUT"));
      }

      // Now set a STATEMENT_TIMEOUT on the connection that is different from the query timeout of
      // the statement. SHOW STATEMENT_TIMEOUT should now return the STATEMENT_TIMEOUT of the
      // connection.
      statement.execute("SET STATEMENT_TIMEOUT='100ms'");
      statement.execute("SHOW VARIABLE STATEMENT_TIMEOUT");
      try (ResultSet rs = statement.getResultSet()) {
        assertTrue(rs.next());
        assertEquals("100ms", rs.getString("STATEMENT_TIMEOUT"));
      }

      // Remove the statement timeout again, and verify that SHOW STATEMENT_TIMEOUT once again
      // returns null.
      statement.execute("SET STATEMENT_TIMEOUT=NULL");
      statement.execute("SHOW VARIABLE STATEMENT_TIMEOUT");
      try (ResultSet rs = statement.getResultSet()) {
        assertTrue(rs.next());
        assertNull(rs.getString("STATEMENT_TIMEOUT"));
      }
    }
  }

  @Test
  public void test12_TestSetStatements() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_SET_STATEMENTS"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test13_TestInvalidStatements() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_INVALID_STATEMENTS"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }

  @Test
  public void test14_TestQueryOptions() throws Exception {
    try (CloudSpannerJdbcConnection connection = createConnection(env, database)) {
      verifier.verifyStatementsInFile(
          JdbcGenericConnection.of(connection),
          dialect.executeQueriesFiles.get("TEST_QUERY_OPTIONS"),
          JdbcSqlScriptVerifier.class,
          false);
    }
  }
}

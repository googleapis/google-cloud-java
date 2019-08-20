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

import com.google.cloud.spanner.IntegrationTest;
import com.google.cloud.spanner.jdbc.ITAbstractSpannerTest;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier;
import com.google.cloud.spanner.jdbc.SqlScriptVerifier.SpannerGenericConnection;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

/**
 * Integration test that creates and fills a test database entirely using only sql scripts, and then
 * performs all possible operations on this test database using only sql scripts. This test uses the
 * generic connection API.
 */
@Category(IntegrationTest.class)
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITSqlScriptTest extends ITAbstractSpannerTest {
  private static final String CREATE_TABLES_FILE = "ITSqlScriptTest_CreateTables.sql";
  private static final String INSERT_AND_VERIFY_TEST_DATA = "ITSqlScriptTest_InsertTestData.sql";
  private static final String TEST_GET_READ_TIMESTAMP = "ITSqlScriptTest_TestGetReadTimestamp.sql";
  private static final String TEST_GET_COMMIT_TIMESTAMP =
      "ITSqlScriptTest_TestGetCommitTimestamp.sql";
  private static final String TEST_TEMPORARY_TRANSACTIONS =
      "ITSqlScriptTest_TestTemporaryTransactions.sql";
  private static final String TEST_TRANSACTION_MODE = "ITSqlScriptTest_TestTransactionMode.sql";
  private static final String TEST_TRANSACTION_MODE_READ_ONLY =
      "ITSqlScriptTest_TestTransactionMode_ReadOnly.sql";
  private static final String TEST_READ_ONLY_STALENESS =
      "ITSqlScriptTest_TestReadOnlyStaleness.sql";
  private static final String TEST_AUTOCOMMIT_DML_MODE =
      "ITSqlScriptTest_TestAutocommitDmlMode.sql";
  private static final String TEST_AUTOCOMMIT_READ_ONLY =
      "ITSqlScriptTest_TestAutocommitReadOnly.sql";
  private static final String TEST_STATEMENT_TIMEOUT = "ITSqlScriptTest_TestStatementTimeout.sql";
  private static final String TEST_SET_STATEMENTS = "ITSqlScriptTest_TestSetStatements.sql";
  private static final String TEST_INVALID_STATEMENTS = "ITSqlScriptTest_TestInvalidStatements.sql";

  private final SqlScriptVerifier verifier = new SqlScriptVerifier();

  @Test
  public void test01_CreateTables() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection), CREATE_TABLES_FILE, SqlScriptVerifier.class);
    }
  }

  @Test
  public void test02_InsertTestData() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          INSERT_AND_VERIFY_TEST_DATA,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test03_TestGetReadTimestamp() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_GET_READ_TIMESTAMP,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test04_TestGetCommitTimestamp() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_GET_COMMIT_TIMESTAMP,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test05_TestTemporaryTransactions() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_TEMPORARY_TRANSACTIONS,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test06_TestTransactionMode() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection), TEST_TRANSACTION_MODE, SqlScriptVerifier.class);
    }
  }

  @Test
  public void test07_TestTransactionModeReadOnly() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_TRANSACTION_MODE_READ_ONLY,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test08_TestReadOnlyStaleness() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_READ_ONLY_STALENESS,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test09_TestAutocommitDmlMode() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_AUTOCOMMIT_DML_MODE,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test10_TestAutocommitReadOnly() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_AUTOCOMMIT_READ_ONLY,
          SqlScriptVerifier.class);
    }
  }

  @Test
  public void test11_TestStatementTimeout() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection), TEST_STATEMENT_TIMEOUT, SqlScriptVerifier.class);
    }
  }

  @Test
  public void test12_TestSetStatements() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection), TEST_SET_STATEMENTS, SqlScriptVerifier.class);
    }
  }

  @Test
  public void test13_TestInvalidStatements() throws Exception {
    try (ITConnection connection = createConnection()) {
      verifier.verifyStatementsInFile(
          SpannerGenericConnection.of(connection),
          TEST_INVALID_STATEMENTS,
          SqlScriptVerifier.class);
    }
  }
}

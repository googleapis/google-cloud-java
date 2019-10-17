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

package com.google.cloud.spanner.jdbc;

import static com.google.cloud.spanner.jdbc.ReadOnlyStalenessUtil.getTimeUnitAbbreviation;
import static com.google.cloud.spanner.jdbc.SpannerExceptionMatcher.matchCode;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This test class and all its subclasses are used to generate the file
 * ConnectionImplGeneratedSqlScriptTest.sql.
 */
@RunWith(JUnit4.class)
public abstract class AbstractConnectionImplTest {
  public static final String UPDATE = "UPDATE foo SET bar=1";
  public static final String SELECT = "SELECT 1 AS TEST";
  public static final String DDL =
      "CREATE TABLE foo (id INT64 NOT NULL, name STRING(100)) PRIMARY KEY (id)";

  static interface ConnectionConsumer {
    void accept(Connection connection);
  }

  @Rule public ExpectedException exception = ExpectedException.none();

  /**
   * This test class can generate a large sql file that represents all the statements and
   * verifications that are executed by this test class. This file can be fed into other test cases
   * (in other programming languages) to execute the same tests as the tests covered by all the
   * subclasses of {@link AbstractConnectionImplTest}.
   */
  private static final String LOG_FILE =
      "src/test/resources/com/google/cloud/spanner/jdbc/ConnectionImplGeneratedSqlScriptTest.sql";

  private static final String DO_LOG_PROPERTY = "do_log_statements";
  private static boolean doLog;
  private static PrintWriter writer;

  abstract Connection getConnection();

  static void expectSpannerException(
      String reason, ConnectionConsumer consumer, Connection connection) {
    expectSpannerException(reason, consumer, connection, ErrorCode.FAILED_PRECONDITION);
  }

  static void expectSpannerException(
      String reason, ConnectionConsumer consumer, Connection connection, ErrorCode errorCode) {
    SpannerException exception = null;
    try {
      consumer.accept(connection);
    } catch (SpannerException e) {
      exception = e;
    }
    assertThat(reason, exception, is(notNullValue()));
    assertThat(reason, exception.getErrorCode(), is(equalTo(errorCode)));
  }

  AbstractConnectionImplTest() {}

  /** Makes an empty test script. Can be called before a new script is to be generated. */
  static void emptyScript() {
    openLog(false);
    closeLog();
  }

  void log(String statement) {
    if (doLog) {
      writer.println(statement);
    }
  }

  @BeforeClass
  public static void openLog() {
    doLog = Boolean.valueOf(System.getProperty(DO_LOG_PROPERTY, "false"));
    if (doLog) {
      openLog(true);
    } else {
      writer = null;
    }
  }

  private static void openLog(boolean append) {
    try {
      writer =
          new PrintWriter(
              new OutputStreamWriter(new FileOutputStream(LOG_FILE, append), "UTF8"), true);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @AfterClass
  public static void closeLog() {
    if (writer != null) {
      writer.close();
    }
  }

  @Test
  public void testClose() {
    getConnection().close();
  }

  @Test
  public void testIsClosed() {
    Connection connection = getConnection();
    assertThat(connection.isClosed(), is(false));
    connection.close();
    assertThat(connection.isClosed(), is(true));
  }

  abstract boolean isSetAutocommitAllowed();

  @Test
  public void testSetAutocommit() {
    try (Connection connection = getConnection()) {
      if (isSetAutocommitAllowed()) {
        log("SET AUTOCOMMIT=FALSE;");
        connection.setAutocommit(false);

        log("@EXPECT RESULT_SET 'AUTOCOMMIT',FALSE");
        log("SHOW VARIABLE AUTOCOMMIT;");
        assertThat(connection.isAutocommit(), is(false));

        log("SET AUTOCOMMIT=TRUE;");
        connection.setAutocommit(true);

        log("@EXPECT RESULT_SET 'AUTOCOMMIT',TRUE");
        log("SHOW VARIABLE AUTOCOMMIT;");
        assertThat(connection.isAutocommit(), is(true));
      } else {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        log("SET AUTOCOMMIT=" + (connection.isAutocommit() ? "FALSE;" : "TRUE;"));
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.setAutocommit(!connection.isAutocommit());
      }
    }
  }

  abstract boolean isSetReadOnlyAllowed();

  @Test
  public void testSetReadOnly() {
    try (Connection connection = getConnection()) {
      if (isSetReadOnlyAllowed()) {
        log("SET READONLY=FALSE;");
        connection.setReadOnly(false);

        log("@EXPECT RESULT_SET 'READONLY',FALSE");
        log("SHOW VARIABLE READONLY;");
        assertThat(connection.isReadOnly(), is(false));

        log("SET READONLY=TRUE;");
        connection.setReadOnly(true);

        log("@EXPECT RESULT_SET 'READONLY',TRUE");
        log("SHOW VARIABLE READONLY;");
        assertThat(connection.isReadOnly(), is(true));
      } else {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        log("SET READONLY=" + (connection.isAutocommit() ? "FALSE;" : "TRUE;"));
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.setReadOnly(!connection.isReadOnly());
      }
    }
  }

  @Test
  public void testSetStatementTimeout() {
    try (Connection connection = getConnection()) {
      for (TimeUnit unit : ReadOnlyStalenessUtil.SUPPORTED_UNITS) {
        log(String.format("SET STATEMENT_TIMEOUT='1%s';", getTimeUnitAbbreviation(unit)));
        connection.setStatementTimeout(1L, unit);

        log(
            String.format(
                "@EXPECT RESULT_SET 'STATEMENT_TIMEOUT','1%s'", getTimeUnitAbbreviation(unit)));
        log("SHOW VARIABLE STATEMENT_TIMEOUT;");
        assertThat(connection.getStatementTimeout(unit), is(equalTo(1L)));

        log("SET STATEMENT_TIMEOUT=null;");
        connection.clearStatementTimeout();

        log("@EXPECT RESULT_SET 'STATEMENT_TIMEOUT',null");
        log("SHOW VARIABLE STATEMENT_TIMEOUT;");
        assertThat(connection.getStatementTimeout(unit), is(equalTo(0L)));
        assertThat(connection.hasStatementTimeout(), is(false));
        boolean gotException = false;
        try {
          log("@EXPECT EXCEPTION INVALID_ARGUMENT");
          log(String.format("SET STATEMENT_TIMEOUT='0%s';", getTimeUnitAbbreviation(unit)));
          connection.setStatementTimeout(0L, unit);
        } catch (IllegalArgumentException e) {
          gotException = true;
        }
        assertThat(gotException, is(true));
        log("@EXPECT RESULT_SET 'STATEMENT_TIMEOUT',null");
        log("SHOW VARIABLE STATEMENT_TIMEOUT;");
        assertThat(connection.getStatementTimeout(unit), is(equalTo(0L)));
        assertThat(connection.hasStatementTimeout(), is(false));
      }
    }
  }

  abstract boolean isStartBatchDmlAllowed();

  @Test
  public void testStartBatchDml() {
    try (Connection connection = getConnection()) {
      if (isStartBatchDmlAllowed()) {
        assertThat(connection.isReadOnly(), is(false));
        assertThat(connection.isDdlBatchActive() || connection.isDmlBatchActive(), is(false));

        log("START BATCH DML;");
        connection.startBatchDml();
        assertThat(connection.isDmlBatchActive(), is(true));

        expectSpannerException(
            "Select should not be allowed after startBatchDml()",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(SELECT + ";");
                t.execute(Statement.of(SELECT));
              }
            },
            connection);
        expectSpannerException(
            "DDL should not be allowed after startBatchDml()",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(DDL + ";");
                t.execute(Statement.of(DDL));
              }
            },
            connection);
        log(UPDATE + ";");
        connection.execute(Statement.of(UPDATE));
        assertThat(connection.isDmlBatchActive(), is(true));
      }
      // startBatchDml is not allowed as a batch has already been started.
      log("@EXPECT EXCEPTION FAILED_PRECONDITION");
      log("START BATCH DML;");
      exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      connection.startBatchDml();
    }
  }

  abstract boolean isStartBatchDdlAllowed();

  @Test
  public void testStartBatchDdl() {
    try (Connection connection = getConnection()) {
      if (isStartBatchDdlAllowed()) {
        assertThat(connection.isTransactionStarted(), is(false));
        assertThat(connection.isInTransaction(), is(equalTo(!connection.isAutocommit())));
        assertThat(connection.isDdlBatchActive() || connection.isDmlBatchActive(), is(false));

        log("START BATCH DDL;");
        connection.startBatchDdl();
        assertThat(connection.isTransactionStarted(), is(false));
        assertThat(connection.isInTransaction(), is(false));
        assertThat(connection.isDdlBatchActive(), is(true));

        expectSpannerException(
            "Select should not be allowed after startBatchDdl()",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(SELECT + ";");
                t.execute(Statement.of(SELECT));
              }
            },
            connection);
        expectSpannerException(
            "Update should not be allowed after startBatchDdl()",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(UPDATE + ";");
                t.execute(Statement.of(UPDATE));
              }
            },
            connection);
        log(DDL + ";");
        connection.execute(Statement.of(DDL));
        assertThat(connection.isTransactionStarted(), is(false));
        assertThat(connection.isDdlBatchActive(), is(true));
      }
      // startBatchDdl is no longer allowed as a batch has already been started
      log("@EXPECT EXCEPTION FAILED_PRECONDITION");
      log("START BATCH DDL;");
      exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      connection.startBatchDdl();
    }
  }

  abstract boolean isRunBatchAllowed();

  @Test
  public void testRunBatch() {
    try (Connection connection = getConnection()) {
      if (!isRunBatchAllowed()) {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      log("RUN BATCH;");
      connection.runBatch();
    }
  }

  abstract boolean isAbortBatchAllowed();

  @Test
  public void testAbortBatch() {
    try (Connection connection = getConnection()) {
      if (!isAbortBatchAllowed()) {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      log("ABORT BATCH;");
      connection.abortBatch();
    }
  }

  abstract boolean isBeginTransactionAllowed();

  abstract boolean isSelectAllowedAfterBeginTransaction();

  abstract boolean isDmlAllowedAfterBeginTransaction();

  abstract boolean isDdlAllowedAfterBeginTransaction();

  @Test
  public void testBeginTransaction() {
    try (Connection connection = getConnection()) {
      if (isBeginTransactionAllowed()) {
        assertThat(connection.isTransactionStarted(), is(false));
        assertThat(connection.isInTransaction(), is(equalTo(!connection.isAutocommit())));

        log("BEGIN TRANSACTION;");
        connection.beginTransaction();
        assertThat(connection.isTransactionStarted(), is(false));
        assertThat(connection.isInTransaction(), is(true));

        if (isSelectAllowedAfterBeginTransaction()) {
          log(SELECT + ";");
          connection.execute(Statement.of(SELECT));
        } else {
          expectSpannerException(
              "Select should not be allowed after beginTransaction",
              new ConnectionConsumer() {
                @Override
                public void accept(Connection t) {
                  log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                  log(SELECT + ";");
                  t.execute(Statement.of(SELECT));
                }
              },
              connection);
        }
        if (isDmlAllowedAfterBeginTransaction()) {
          log(UPDATE + ";");
          connection.execute(Statement.of(UPDATE));
        } else {
          expectSpannerException(
              "Update should not be allowed after beginTransaction",
              new ConnectionConsumer() {
                @Override
                public void accept(Connection t) {
                  log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                  log(UPDATE + ";");
                  t.execute(Statement.of(UPDATE));
                }
              },
              connection);
        }
        if (isDdlAllowedAfterBeginTransaction()) {
          log(DDL + ";");
          connection.execute(Statement.of(DDL));
        } else {
          expectSpannerException(
              "DDL should not be allowed after beginTransaction",
              new ConnectionConsumer() {
                @Override
                public void accept(Connection t) {
                  log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                  log(DDL + ";");
                  t.execute(Statement.of(DDL));
                }
              },
              connection);
        }
        assertThat(connection.isTransactionStarted(), is(true));
      }
      // beginTransaction is no longer allowed as the transaction has already started
      log("@EXPECT EXCEPTION FAILED_PRECONDITION");
      log("BEGIN TRANSACTION;");
      exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      connection.beginTransaction();
    }
  }

  abstract boolean isSetTransactionModeAllowed(TransactionMode mode);

  @Test
  public void testSetTransactionMode() {
    for (TransactionMode mode : TransactionMode.values()) {
      testSetTransactionMode(mode);
    }
  }

  private void testSetTransactionMode(final TransactionMode mode) {
    try (Connection connection = getConnection()) {
      if (isSetTransactionModeAllowed(mode)) {
        log("SET TRANSACTION " + mode.toString() + ";");
        connection.setTransactionMode(mode);
        assertThat(connection.getTransactionMode(), is(equalTo(mode)));
      } else {
        expectSpannerException(
            mode + " should not be allowed",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log("SET TRANSACTION " + mode.getStatementString() + ";");
                t.setTransactionMode(mode);
              }
            },
            connection);
      }
    }
  }

  abstract boolean isGetTransactionModeAllowed();

  @Test
  public void testGetTransactionMode() {
    try (Connection connection = getConnection()) {
      if (isGetTransactionModeAllowed()) {
        assertThat(connection.getTransactionMode(), is(notNullValue()));
      } else {
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.getTransactionMode();
      }
    }
  }

  abstract boolean isSetAutocommitDmlModeAllowed();

  @Test
  public void testSetAutocommitDmlMode() {
    try (Connection connection = getConnection()) {
      if (isSetAutocommitDmlModeAllowed()) {
        for (AutocommitDmlMode mode : AutocommitDmlMode.values()) {
          log("SET AUTOCOMMIT_DML_MODE='" + mode.toString() + "';");
          connection.setAutocommitDmlMode(mode);

          log("@EXPECT RESULT_SET 'AUTOCOMMIT_DML_MODE','" + mode.toString() + "'");
          log("SHOW VARIABLE AUTOCOMMIT_DML_MODE;");
          assertThat(connection.getAutocommitDmlMode(), is(equalTo(mode)));
        }
      } else {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        log(
            "SET AUTOCOMMIT_DML_MODE='"
                + AutocommitDmlMode.PARTITIONED_NON_ATOMIC.toString()
                + "';");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      }
    }
  }

  abstract boolean isGetAutocommitDmlModeAllowed();

  @Test
  public void testGetAutocommitDmlMode() {
    try (Connection connection = getConnection()) {
      if (isGetAutocommitDmlModeAllowed()) {
        log("@EXPECT RESULT_SET 'AUTOCOMMIT_DML_MODE'");
        log("SHOW VARIABLE AUTOCOMMIT_DML_MODE;");
        assertThat(connection.getAutocommitDmlMode(), is(notNullValue()));
      } else {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        log("SHOW VARIABLE AUTOCOMMIT_DML_MODE;");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.getAutocommitDmlMode();
      }
    }
  }

  abstract boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode);

  @Test
  public void testSetReadOnlyStaleness() {
    for (TimestampBound staleness : getTestTimestampBounds()) {
      testSetReadOnlyStaleness(staleness);
    }
  }

  private List<TimestampBound> getTestTimestampBounds() {
    return Arrays.asList(
        TimestampBound.strong(),
        TimestampBound.ofReadTimestamp(Timestamp.now()),
        TimestampBound.ofMinReadTimestamp(Timestamp.now()),
        TimestampBound.ofExactStaleness(1L, TimeUnit.SECONDS),
        TimestampBound.ofMaxStaleness(100L, TimeUnit.MILLISECONDS),
        TimestampBound.ofExactStaleness(100L, TimeUnit.MICROSECONDS));
  }

  private void testSetReadOnlyStaleness(final TimestampBound staleness) {
    try (Connection connection = getConnection()) {
      if (isSetReadOnlyStalenessAllowed(staleness.getMode())) {
        log(
            "SET READ_ONLY_STALENESS='"
                + ReadOnlyStalenessUtil.timestampBoundToString(staleness)
                + "';");
        connection.setReadOnlyStaleness(staleness);

        log(
            "@EXPECT RESULT_SET 'READ_ONLY_STALENESS','"
                + ReadOnlyStalenessUtil.timestampBoundToString(staleness)
                + "'");
        log("SHOW VARIABLE READ_ONLY_STALENESS;");
        assertThat(connection.getReadOnlyStaleness(), is(equalTo(staleness)));
      } else {
        expectSpannerException(
            staleness.getMode() + " should not be allowed",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(
                    "SET READ_ONLY_STALENESS='"
                        + ReadOnlyStalenessUtil.timestampBoundToString(staleness)
                        + "';");
                t.setReadOnlyStaleness(staleness);
              }
            },
            connection);
      }
    }
  }

  abstract boolean isGetReadOnlyStalenessAllowed();

  @Test
  public void testGetReadOnlyStaleness() {
    try (Connection connection = getConnection()) {
      if (isGetReadOnlyStalenessAllowed()) {
        log("@EXPECT RESULT_SET 'READ_ONLY_STALENESS'");
        log("SHOW VARIABLE READ_ONLY_STALENESS;");
        assertThat(connection.getReadOnlyStaleness(), is(notNullValue()));
      } else {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        log("SHOW VARIABLE READ_ONLY_STALENESS;");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.getReadOnlyStaleness();
      }
    }
  }

  abstract boolean isCommitAllowed();

  @Test
  public void testCommit() {
    try (Connection connection = getConnection()) {
      if (!isCommitAllowed()) {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      log("COMMIT;");
      connection.commit();
    }
  }

  abstract boolean isRollbackAllowed();

  @Test
  public void testRollback() {
    try (Connection connection = getConnection()) {
      if (!isRollbackAllowed()) {
        log("@EXPECT EXCEPTION FAILED_PRECONDITION");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      log("ROLLBACK;");
      connection.rollback();
    }
  }

  abstract boolean expectedIsInTransaction();

  @Test
  public void testIsInTransaction() {
    try (Connection connection = getConnection()) {
      assertThat(connection.isInTransaction(), is(expectedIsInTransaction()));
    }
  }

  abstract boolean expectedIsTransactionStarted();

  @Test
  public void testIsTransactionStarted() {
    try (Connection connection = getConnection()) {
      assertThat(connection.isTransactionStarted(), is(expectedIsTransactionStarted()));
    }
  }

  abstract boolean isGetReadTimestampAllowed();

  @Test
  public void testGetReadTimestamp() {
    try (Connection connection = getConnection()) {
      if (isGetReadTimestampAllowed()) {
        log("@EXPECT RESULT_SET 'READ_TIMESTAMP'");
        log("SHOW VARIABLE READ_TIMESTAMP;");
        assertThat(connection.getReadTimestamp(), is(notNullValue()));
      } else {
        log("@EXPECT RESULT_SET 'READ_TIMESTAMP',null");
        log("SHOW VARIABLE READ_TIMESTAMP;");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.getReadTimestamp();
      }
    }
  }

  abstract boolean isGetCommitTimestampAllowed();

  @Test
  public void testGetCommitTimestamp() {
    try (Connection connection = getConnection()) {
      if (isGetCommitTimestampAllowed()) {
        log("@EXPECT RESULT_SET 'COMMIT_TIMESTAMP'");
        log("SHOW VARIABLE COMMIT_TIMESTAMP;");
        assertThat(connection.getCommitTimestamp(), is(notNullValue()));
      } else {
        log("@EXPECT RESULT_SET 'COMMIT_TIMESTAMP',null");
        log("SHOW VARIABLE COMMIT_TIMESTAMP;");
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
        connection.getCommitTimestamp();
      }
    }
  }

  abstract boolean isExecuteAllowed(StatementType type);

  @Test
  public void testExecute() {
    for (StatementType type :
        new StatementType[] {StatementType.QUERY, StatementType.UPDATE, StatementType.DDL}) {
      testExecute(type);
    }
  }

  private void testExecute(final StatementType type) {
    try (Connection connection = getConnection()) {
      if (isExecuteAllowed(type)) {
        log(getTestStatement(type).getSql() + ";");
        assertThat(connection.execute(getTestStatement(type)), is(notNullValue()));
      } else {
        expectSpannerException(
            type + " should not be allowed",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(getTestStatement(type).getSql() + ";");
                t.execute(getTestStatement(type));
              }
            },
            connection);
      }
    }
  }

  private Statement getTestStatement(StatementType type) {
    switch (type) {
      case QUERY:
        return Statement.of(SELECT);
      case UPDATE:
        return Statement.of(UPDATE);
      case DDL:
        return Statement.of(DDL);
      case CLIENT_SIDE:
      case UNKNOWN:
      default:
        throw new IllegalArgumentException("Unsupported type: " + type);
    }
  }

  @Test
  public void testExecuteQuery() {
    for (StatementType type :
        new StatementType[] {StatementType.QUERY, StatementType.UPDATE, StatementType.DDL}) {
      testExecuteQuery(type);
    }
  }

  private void testExecuteQuery(final StatementType type) {
    try (Connection connection = getConnection()) {
      if (type == StatementType.QUERY && isExecuteAllowed(StatementType.QUERY)) {
        log("@EXPECT RESULT_SET 'TEST',1");
        log(getTestStatement(type).getSql() + ";");
        ResultSet rs = connection.executeQuery(getTestStatement(type));
        assertThat(rs, is(notNullValue()));
        assertThat(rs.getStats(), is(nullValue()));
      } else if (type == StatementType.QUERY) {
        // it is a query, but queries are not allowed for this connection state
        expectSpannerException(
            type + " should not be allowed",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(getTestStatement(type).getSql() + ";");
                t.executeQuery(getTestStatement(type));
              }
            },
            connection,
            ErrorCode.FAILED_PRECONDITION);
      } else {
        expectSpannerException(
            type + " should be an invalid argument",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                t.executeQuery(getTestStatement(type));
              }
            },
            connection,
            ErrorCode.INVALID_ARGUMENT);
      }
    }
  }

  @Test
  public void testAnalyzeQuery() {
    for (StatementType type :
        new StatementType[] {StatementType.QUERY, StatementType.UPDATE, StatementType.DDL}) {
      testAnalyzeQuery(type);
    }
  }

  private void testAnalyzeQuery(final StatementType type) {
    // TODO: add log statements when ANALYZE ... sql statements are supported
    try (Connection connection = getConnection()) {
      for (QueryAnalyzeMode mode : QueryAnalyzeMode.values()) {
        final QueryAnalyzeMode currentMode = mode;
        if (type == StatementType.QUERY && isExecuteAllowed(StatementType.QUERY)) {
          ResultSet rs = connection.analyzeQuery(getTestStatement(type), currentMode);
          assertThat(rs, is(notNullValue()));
          while (rs.next()) {}
          assertThat(rs.getStats(), is(notNullValue()));
        } else if (type == StatementType.QUERY) {
          // it is a query, but queries are not allowed for this connection state
          expectSpannerException(
              type + " should not be allowed",
              new ConnectionConsumer() {
                @Override
                public void accept(Connection t) {
                  t.analyzeQuery(getTestStatement(type), currentMode);
                }
              },
              connection,
              ErrorCode.FAILED_PRECONDITION);
        } else {
          expectSpannerException(
              type + " should be an invalid argument",
              new ConnectionConsumer() {
                @Override
                public void accept(Connection t) {
                  t.analyzeQuery(getTestStatement(type), currentMode);
                }
              },
              connection,
              ErrorCode.INVALID_ARGUMENT);
        }
      }
    }
  }

  @Test
  public void testExecuteUpdate() {
    for (StatementType type :
        new StatementType[] {StatementType.QUERY, StatementType.UPDATE, StatementType.DDL}) {
      testExecuteUpdate(type);
    }
  }

  private void testExecuteUpdate(final StatementType type) {
    try (Connection connection = getConnection()) {
      if (type == StatementType.UPDATE && isExecuteAllowed(StatementType.UPDATE)) {
        log("@EXPECT UPDATE_COUNT 1");
        log(getTestStatement(type).getSql() + ";");
        assertThat(connection.executeUpdate(getTestStatement(type)), is(notNullValue()));
      } else if (type == StatementType.UPDATE) {
        // it is an update statement, but updates are not allowed for this connection state
        expectSpannerException(
            type + "should not be allowed",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                log("@EXPECT EXCEPTION FAILED_PRECONDITION");
                log(getTestStatement(type).getSql() + ";");
                t.executeUpdate(getTestStatement(type));
              }
            },
            connection,
            ErrorCode.FAILED_PRECONDITION);
      } else {
        expectSpannerException(
            type + " should be an invalid argument",
            new ConnectionConsumer() {
              @Override
              public void accept(Connection t) {
                t.executeUpdate(getTestStatement(type));
              }
            },
            connection,
            ErrorCode.INVALID_ARGUMENT);
      }
    }
  }

  abstract boolean isWriteAllowed();

  @Test
  public void testWrite() {
    try (Connection connection = getConnection()) {
      if (!isWriteAllowed() || !connection.isAutocommit()) {
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      connection.write(createTestMutation());
    }
  }

  @Test
  public void testWriteIterable() {
    try (Connection connection = getConnection()) {
      if (!isWriteAllowed() || !connection.isAutocommit()) {
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      connection.write(Arrays.asList(createTestMutation()));
    }
  }

  @Test
  public void testBufferedWrite() {
    try (Connection connection = getConnection()) {
      if (!isWriteAllowed() || connection.isAutocommit()) {
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      connection.bufferedWrite(createTestMutation());
    }
  }

  @Test
  public void testBufferedWriteIterable() {
    try (Connection connection = getConnection()) {
      if (!isWriteAllowed() || connection.isAutocommit()) {
        exception.expect(matchCode(ErrorCode.FAILED_PRECONDITION));
      }
      connection.bufferedWrite(Arrays.asList(createTestMutation()));
    }
  }

  private Mutation createTestMutation() {
    return Mutation.newInsertBuilder("foo").set("id").to(1L).set("name").to("bar").build();
  }
}

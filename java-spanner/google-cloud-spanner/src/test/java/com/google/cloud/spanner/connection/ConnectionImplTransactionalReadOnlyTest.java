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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.BatchClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * The tests in this class do not need to be implemented for client libraries in other programming
 * languages, as all test cases are covered by the file ConnectionImplGeneratedSqlScriptTest.sql
 */
@RunWith(Enclosed.class)
public class ConnectionImplTransactionalReadOnlyTest {

  public static class ConnectionImplTransactionalReadOnlyNoActionsTest
      extends AbstractConnectionImplTest {
    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return mode == Mode.STRONG || mode == Mode.EXACT_STALENESS || mode == Mode.READ_TIMESTAMP;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // no query has been executed yet
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplTransactionalReadOnlyAfterSelectTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      // no call to next() on ResultSet
      log(SELECT + ";");
      connection.executeQuery(Statement.of(SELECT));
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      throw new IllegalStateException();
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      throw new IllegalStateException();
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      throw new IllegalStateException();
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return false;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return false;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return false;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      return false;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      // transaction has started
      return false;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return true;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // last statement was a query, next() has not yet been called, but as the connection api
      // returns a directly executed resultset, the read timestamp is already available
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplTransactionalReadOnlyAfterSelectAndResultSetNextTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("@EXPECT RESULT_SET 'TEST',1");
      log(SELECT + ";");
      connection.executeQuery(Statement.of(SELECT)).next();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      throw new IllegalStateException();
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      throw new IllegalStateException();
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      throw new IllegalStateException();
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return false;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return false;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return false;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // transaction is running
      return false;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      // transaction has started
      return false;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return true;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // last statement was a query
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplTransactionalReadOnlyAfterBeginTransactionTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      throw new IllegalArgumentException();
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      throw new IllegalArgumentException();
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      throw new IllegalArgumentException();
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return false;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return false;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return false;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      // connection is in read-only mode
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      // in a transaction, only exact allowed
      return mode == Mode.STRONG || mode == Mode.EXACT_STALENESS || mode == Mode.READ_TIMESTAMP;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // no query executed yet
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplTransactionalReadOnlyAfterTransactionTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
      log("@EXPECT RESULT_SET 'TEST',1");
      log(SELECT + ";");
      connection.execute(Statement.of(SELECT)).getResultSet().next();
      log("COMMIT;");
      connection.commit();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return mode == Mode.STRONG || mode == Mode.EXACT_STALENESS || mode == Mode.READ_TIMESTAMP;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // last action was a transaction that ended with a select query
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplTransactionalReadOnlyAfterRollbackTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
      log("@EXPECT RESULT_SET 'TEST',1");
      log(SELECT + ";");
      connection.execute(Statement.of(SELECT)).getResultSet().next();
      log("ROLLBACK;");
      connection.rollback();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return mode == Mode.STRONG || mode == Mode.EXACT_STALENESS || mode == Mode.READ_TIMESTAMP;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // transaction was rolled back
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplTransactionalReadOnlyAfterSetReadOnlyMaxStalenessTest
      extends AbstractConnectionImplTest {

    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      TimestampBound staleness = TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS);
      logWithNamespace(
          "SET %sREAD_ONLY_STALENESS='"
              + ReadOnlyStalenessUtil.timestampBoundToString(staleness)
              + "';");
      connection.setReadOnlyStaleness(staleness);
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return mode == Mode.STRONG || mode == Mode.EXACT_STALENESS || mode == Mode.READ_TIMESTAMP;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // no query executed yet
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  public static class ConnectionImplTransactionalReadOnlyAfterEmptyCommitTest
      extends AbstractConnectionImplTest {
    @Override
    Connection getConnection() {
      log("NEW_CONNECTION;");
      Connection connection =
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build());
      logWithNamespace("SET %sREADONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("COMMIT;");
      connection.commit();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isDdlAllowedAfterBeginTransaction() {
      return false;
    }

    @Override
    boolean isSetAutocommitAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyAllowed() {
      return true;
    }

    @Override
    boolean isBeginTransactionAllowed() {
      return true;
    }

    @Override
    boolean isSetTransactionModeAllowed(TransactionMode mode) {
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
    }

    boolean isSetTransactionTagAllowed() {
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return true;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return mode == Mode.STRONG || mode == Mode.EXACT_STALENESS || mode == Mode.READ_TIMESTAMP;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
    }

    @Override
    boolean isCommitAllowed() {
      return true;
    }

    @Override
    boolean isRollbackAllowed() {
      return true;
    }

    @Override
    boolean expectedIsInTransaction() {
      return true;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      // last commit was empty
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // read-only
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.QUERY;
    }

    @Override
    boolean isWriteAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return false;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return false;
    }

    @Override
    boolean isRunBatchAllowed() {
      return false;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return false;
    }
  }

  /**
   * Verifies that transactional read-only connections (both {@code readOnly=true} and writable
   * connections in {@link TransactionMode#READ_ONLY_TRANSACTION}) reject DML statements with
   * GoogleSQL {@code THEN RETURN} and PostgreSQL {@code RETURNING} clauses with {@link
   * ErrorCode#FAILED_PRECONDITION} without starting an idle transaction or corrupting an active
   * {@link com.google.cloud.spanner.connection.ReadOnlyTransaction}.
   */
  @RunWith(Parameterized.class)
  public static class ConnectionImplTransactionalReadOnlyDmlReturningTest {
    private static final String SELECT_SQL = "SELECT 1 AS TEST";
    private static final Timestamp FIXED_READ_TIMESTAMP =
        Timestamp.ofTimeSecondsAndNanos(12345L, 0);
    private static final ExecutorProvider ASYNC_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(1)
            .setThreadFactory(
                new ThreadFactoryBuilder()
                    .setDaemon(true)
                    .setNameFormat("transactional-readonly-dml-returning-test-%d")
                    .build())
            .build();

    @Parameter public Dialect dialect;

    @Parameters(name = "dialect = {0}")
    public static Object[] data() {
      return Dialect.values();
    }

    private List<String> dmlReturningStatements() {
      if (dialect == Dialect.POSTGRESQL) {
        return Arrays.asList(
            "INSERT INTO foo (id, name) VALUES (1, 'bar') RETURNING id",
            "UPDATE foo SET bar=1 WHERE id=1 RETURNING bar",
            "DELETE FROM foo WHERE id=1 RETURNING id");
      }
      return Arrays.asList(
          "INSERT INTO foo (id, name) VALUES (1, 'bar') THEN RETURN id",
          "UPDATE foo SET bar=1 WHERE id=1 THEN RETURN bar",
          "DELETE FROM foo WHERE id=1 THEN RETURN id");
    }

    private static ResultSet createSelectOneResultSet() {
      ResultSet rs = mock(ResultSet.class);
      when(rs.next()).thenReturn(true, false);
      when(rs.getLong(0)).thenReturn(1L);
      when(rs.getType()).thenReturn(Type.struct());
      when(rs.getColumnType(0)).thenReturn(Type.int64());
      return rs;
    }

    /**
     * Creates a transactional {@link ConnectionImpl} configured either via connection-level {@code
     * readOnly=true} or via explicit {@link TransactionMode#READ_ONLY_TRANSACTION} on a writable
     * connection.
     */
    private ConnectionImpl createTransactionalReadOnlyConnection(
        DatabaseClient dbClient, boolean connectionReadOnly, boolean autocommitExplicitBegin) {
      Spanner spanner = mock(Spanner.class);
      when(spanner.getAsyncExecutorProvider()).thenReturn(ASYNC_EXECUTOR_PROVIDER);
      SpannerPool spannerPool = mock(SpannerPool.class);
      when(spannerPool.getSpanner(any(ConnectionOptions.class), any(ConnectionImpl.class)))
          .thenReturn(spanner);
      when(dbClient.getDialect()).thenReturn(dialect);
      when(dbClient.readOnlyTransaction(any(TimestampBound.class)))
          .thenAnswer(
              invocation -> {
                ReadOnlyTransaction readOnlyTx = mock(ReadOnlyTransaction.class);
                when(readOnlyTx.executeQuery(Statement.of(SELECT_SQL)))
                    .thenAnswer(ignored -> createSelectOneResultSet());
                when(readOnlyTx.executeQuery(eq(Statement.of(SELECT_SQL)), any(QueryOption.class)))
                    .thenAnswer(ignored -> createSelectOneResultSet());
                when(readOnlyTx.getReadTimestamp()).thenReturn(FIXED_READ_TIMESTAMP);
                return readOnlyTx;
              });

      ConnectionOptions options =
          ConnectionOptions.newBuilder()
              .setCredentials(NoCredentials.getInstance())
              .setUri(ConnectionImplTest.URI)
              .build();
      ConnectionImpl connection =
          new ConnectionImpl(
              options, spannerPool, mock(DdlClient.class), dbClient, mock(BatchClient.class));
      if (autocommitExplicitBegin) {
        connection.setAutocommit(true);
        connection.setReadOnly(connectionReadOnly);
        connection.beginTransaction();
        if (!connectionReadOnly) {
          connection.setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
        }
      } else {
        connection.setAutocommit(false);
        connection.setReadOnly(connectionReadOnly);
        if (!connectionReadOnly) {
          connection.setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
        }
      }
      assertTrue(connection.isInTransaction());
      assertEquals(TransactionMode.READ_ONLY_TRANSACTION, connection.getTransactionMode());
      return connection;
    }

    private void assertAllQueryEntrypointsRejectWithFailedPrecondition(
        Connection connection, Statement stmt, String expectedMessage) {
      SpannerException execEx =
          assertThrows(SpannerException.class, () -> connection.execute(stmt));
      assertEquals(ErrorCode.FAILED_PRECONDITION, execEx.getErrorCode());
      assertTrue(execEx.getMessage().contains(expectedMessage));

      SpannerException execAllowedEx =
          assertThrows(
              SpannerException.class,
              () -> connection.execute(stmt, Collections.singleton(ResultType.RESULT_SET)));
      assertEquals(ErrorCode.FAILED_PRECONDITION, execAllowedEx.getErrorCode());
      assertTrue(execAllowedEx.getMessage().contains(expectedMessage));

      SpannerException execAsyncEx =
          assertThrows(SpannerException.class, () -> connection.executeAsync(stmt));
      assertEquals(ErrorCode.FAILED_PRECONDITION, execAsyncEx.getErrorCode());
      assertTrue(execAsyncEx.getMessage().contains(expectedMessage));

      SpannerException queryEx =
          assertThrows(SpannerException.class, () -> connection.executeQuery(stmt));
      assertEquals(ErrorCode.FAILED_PRECONDITION, queryEx.getErrorCode());
      assertTrue(queryEx.getMessage().contains(expectedMessage));

      SpannerException queryAsyncEx =
          assertThrows(SpannerException.class, () -> connection.executeQueryAsync(stmt));
      assertEquals(ErrorCode.FAILED_PRECONDITION, queryAsyncEx.getErrorCode());
      assertTrue(queryAsyncEx.getMessage().contains(expectedMessage));

      for (QueryAnalyzeMode analyzeMode : QueryAnalyzeMode.values()) {
        SpannerException analyzeEx =
            assertThrows(SpannerException.class, () -> connection.analyzeQuery(stmt, analyzeMode));
        assertEquals(ErrorCode.FAILED_PRECONDITION, analyzeEx.getErrorCode());
        assertTrue(analyzeEx.getMessage().contains(expectedMessage));
      }
    }

    @Test
    public void testTransactionalReadOnlyRejectsDmlReturning() {
      boolean[][] modes =
          new boolean[][] {
            {/* connectionReadOnly= */ true, /* autocommitExplicitBegin= */ false},
            {/* connectionReadOnly= */ false, /* autocommitExplicitBegin= */ false},
            {/* connectionReadOnly= */ false, /* autocommitExplicitBegin= */ true}
          };
      for (boolean[] mode : modes) {
        for (String sql : dmlReturningStatements()) {
          Statement stmt = Statement.of(sql);
          String expectedMessage =
              "DML statement with returning clause cannot be executed in read-only mode: " + sql;
          DatabaseClient dbClient = mock(DatabaseClient.class);
          try (ConnectionImpl connection =
              createTransactionalReadOnlyConnection(dbClient, mode[0], mode[1])) {
            assertAllQueryEntrypointsRejectWithFailedPrecondition(
                connection, stmt, expectedMessage);
            verify(dbClient, never()).readWriteTransaction();
            verify(dbClient, never()).readWriteTransaction(any());
            verify(dbClient, never()).transactionManager();
            verify(dbClient, never()).transactionManager(any());
          }
        }
      }
    }

    @Test
    public void testTransactionalReadOnlyPreservesTransactionStateOnRejectedDmlReturning() {
      Statement dmlReturning = Statement.of(dmlReturningStatements().get(0));
      String expectedMessage =
          "DML statement with returning clause cannot be executed in read-only mode: "
              + dmlReturning.getSql();

      for (boolean connectionReadOnly : new boolean[] {true, false}) {
        // 1. Idle transactional read-only connection: rejection must not start the transaction or
        // consume the statement tag.
        DatabaseClient idleDbClient = mock(DatabaseClient.class);
        try (ConnectionImpl idleConn =
            createTransactionalReadOnlyConnection(
                idleDbClient, connectionReadOnly, /* autocommitExplicitBegin= */ false)) {
          assertFalse(idleConn.isTransactionStarted());
          idleConn.setStatementTag("idle-tag");

          assertAllQueryEntrypointsRejectWithFailedPrecondition(
              idleConn, dmlReturning, expectedMessage);

          assertFalse(idleConn.isTransactionStarted());
          assertEquals("idle-tag", idleConn.getStatementTag());
          verify(idleDbClient, never()).readOnlyTransaction(any(TimestampBound.class));
          // Updating read-only staleness requires !isTransactionStarted().
          idleConn.setReadOnlyStaleness(TimestampBound.ofExactStaleness(5L, TimeUnit.SECONDS));
        }

        // 2. Active ReadOnlyTransaction: rejection must preserve the active read-only transaction
        // for subsequent queries and commit().
        DatabaseClient activeDbClient = mock(DatabaseClient.class);
        try (ConnectionImpl activeConn =
            createTransactionalReadOnlyConnection(
                activeDbClient, connectionReadOnly, /* autocommitExplicitBegin= */ false)) {
          try (ResultSet firstSelect = activeConn.executeQuery(Statement.of(SELECT_SQL))) {
            assertTrue(firstSelect.next());
            assertEquals(1L, firstSelect.getLong(0));
          }
          assertTrue(activeConn.isTransactionStarted());
          Timestamp initialReadTs = activeConn.getReadTimestamp();
          activeConn.setStatementTag("active-tag");

          assertAllQueryEntrypointsRejectWithFailedPrecondition(
              activeConn, dmlReturning, expectedMessage);

          assertTrue(activeConn.isTransactionStarted());
          assertEquals("active-tag", activeConn.getStatementTag());
          assertEquals(initialReadTs, activeConn.getReadTimestamp());

          try (ResultSet secondSelect = activeConn.executeQuery(Statement.of(SELECT_SQL))) {
            assertTrue(secondSelect.next());
            assertEquals(1L, secondSelect.getLong(0));
          }
          activeConn.commit();
          assertFalse(activeConn.isTransactionStarted());
        }
      }
    }
  }
}

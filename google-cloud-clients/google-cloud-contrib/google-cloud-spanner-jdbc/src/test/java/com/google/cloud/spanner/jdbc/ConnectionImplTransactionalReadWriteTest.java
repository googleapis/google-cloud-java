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

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.TimestampBound.Mode;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import java.util.concurrent.TimeUnit;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * The tests in this class do not need to be implemented for client libraries in other programming
 * languages, as all test cases are covered by the file ConnectionImplGeneratedSqlScriptTest.sql
 */
@RunWith(Enclosed.class)
public class ConnectionImplTransactionalReadWriteTest {

  public static class ConnectionImplTransactionalReadWriteNoActionsTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
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
      return true;
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
      return true;
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
      // no commit
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterSelectTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
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
      // read-write transactions never have a read-timestamp
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // no commit yet
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterSelectAndResultSetNextTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
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
      // read-write transactions never have a read-timestamp
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // no commit yet
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterBeginTransactionTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
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
      return true;
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
      // read-write transaction never have a read-timestamp
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // no commit yet
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterTransactionTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
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
      return true;
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
      return true;
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
      // last action was a read-write transaction
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      return true;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterRollbackTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
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
      return true;
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
      return true;
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
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // transaction was rolled back
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterSetReadOnlyMaxStalenessTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      TimestampBound staleness = TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS);
      log(
          "SET READ_ONLY_STALENESS='"
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
      return true;
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
      return true;
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
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // no commit yet
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterSetTransactionReadOnlyTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("SET TRANSACTION READ ONLY;");
      connection.setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
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
      return true;
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
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // no commit yet
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

  public static class ConnectionImplTransactionalReadWriteAfterCommittedReadOnlyTransactionTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("SET TRANSACTION READ ONLY;");
      connection.setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
      // ensure there will be a read-timestamp available by calling next()
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
      return true;
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
      return true;
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
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // last transaction was a read-only transaction
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterStartDdlBatchTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("START BATCH DDL;");
      connection.startBatchDdl();
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

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return false;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return false;
    }

    @Override
    boolean isCommitAllowed() {
      return false;
    }

    @Override
    boolean isRollbackAllowed() {
      return false;
    }

    @Override
    boolean expectedIsInTransaction() {
      return false;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // no commit yet
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.DDL;
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
      return true;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return true;
    }
  }

  public static class ConnectionImplTransactionalReadWriteInDdlBatchTransactionTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("START BATCH DDL;");
      connection.startBatchDdl();
      log(DDL + ";");
      connection.execute(Statement.of(DDL));
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

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return false;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return false;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return false;
    }

    @Override
    boolean isCommitAllowed() {
      return false;
    }

    @Override
    boolean isRollbackAllowed() {
      return false;
    }

    @Override
    boolean expectedIsInTransaction() {
      return false;
    }

    @Override
    boolean expectedIsTransactionStarted() {
      return false;
    }

    @Override
    boolean isGetReadTimestampAllowed() {
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE || type == StatementType.DDL;
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
      return true;
    }

    @Override
    boolean isAbortBatchAllowed() {
      return true;
    }
  }

  public static class ConnectionImplTransactionalReadWriteAfterRanDdlBatchTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
      log("SET AUTOCOMMIT=FALSE;");
      connection.setAutocommit(false);
      log("START BATCH DDL;");
      connection.startBatchDdl();
      log(DDL + ";");
      connection.execute(Statement.of(DDL));
      log("RUN BATCH;");
      connection.runBatch();
      return connection;
    }

    @Override
    boolean isSelectAllowedAfterBeginTransaction() {
      return true;
    }

    @Override
    boolean isDmlAllowedAfterBeginTransaction() {
      return true;
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
      return true;
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
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      // ddl-batch has no commit timestamp
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return true;
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

  public static class ConnectionImplTransactionalReadWriteAfterEmptyCommitTest
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
      log("SET READONLY=FALSE;");
      connection.setReadOnly(false);
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
      return true;
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
      return true;
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
      // empty commit
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return type == StatementType.CLIENT_SIDE
          || type == StatementType.QUERY
          || type == StatementType.UPDATE;
    }

    @Override
    boolean isWriteAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDmlAllowed() {
      return true;
    }

    @Override
    boolean isStartBatchDdlAllowed() {
      return true;
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
}

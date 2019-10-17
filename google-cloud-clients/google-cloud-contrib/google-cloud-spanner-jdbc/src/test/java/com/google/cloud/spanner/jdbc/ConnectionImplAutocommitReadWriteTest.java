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
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * The tests in this class do not need to be implemented for client libraries in other programming
 * languages, as all test cases are covered by the file ConnectionImplGeneratedSqlScriptTest.sql
 */
@RunWith(Enclosed.class)
public class ConnectionImplAutocommitReadWriteTest {

  public static class ConnectionImplAutocommitReadWriteNoActionsTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
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
      // there is no transaction
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
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
      // no query has been executed
      return false;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return true;
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

  public static class ConnectionImplAutocommitReadWriteAfterSelectTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      // no next() called
      log(SELECT + ";");
      connection.execute(Statement.of(SELECT));
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
      // there is no transaction
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
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
      // last statement was a query, next() has not yet been called, but as the connection api
      // returns a directly executed resultset, the read timestamp is already available
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return true;
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

  public static class ConnectionImplAutocommitReadWriteAfterSelectAndResultSetNextTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      // the @expect ensures next() is called
      log("@EXPECT RESULT_SET 'TEST',1");
      log(SELECT + ";");
      connection.execute(Statement.of(SELECT)).getResultSet().next();
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
      // there is no transaction
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
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
      // the last action was a query that has retrieved data
      return true;
    }

    @Override
    boolean isGetCommitTimestampAllowed() {
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return true;
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

  public static class ConnectionImplAutocommitReadWriteAfterUpdateTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log(UPDATE + ";");
      connection.execute(Statement.of(UPDATE));
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
      // there is no transaction
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
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
      return true;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return true;
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

  public static class ConnectionImplAutocommitReadWriteAfterDdlTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log(DDL + ";");
      connection.execute(Statement.of(DDL));
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
      // there is no transaction
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
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
      return true;
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

  public static class ConnectionImplAutocommitReadWriteAfterBeginTransactionTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
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
      // in temporary transaction
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
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      // default is a read-write transaction
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

  public static class ConnectionImplAutocommitReadWriteAfterTemporaryTransactionTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
      log(UPDATE + ";");
      connection.execute(Statement.of(UPDATE));
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
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isGetAutocommitDmlModeAllowed() {
      return true;
    }

    @Override
    boolean isSetReadOnlyStalenessAllowed(TimestampBound.Mode mode) {
      return true;
    }

    @Override
    boolean isGetReadOnlyStalenessAllowed() {
      return true;
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
      return true;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      return true;
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

  public static class ConnectionImplAutocommitReadWriteAfterBeginReadOnlyTransactionTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
      log("SET TRANSACTION READ ONLY;");
      connection.setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
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
      // in temporary transaction
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
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      // it's a read-only transaction
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

  public static class ConnectionImplAutocommitReadWriteAfterStartDdlBatchTest
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
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
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
      return false;
    }

    @Override
    boolean isExecuteAllowed(StatementType type) {
      // it's a DDL batch
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
}

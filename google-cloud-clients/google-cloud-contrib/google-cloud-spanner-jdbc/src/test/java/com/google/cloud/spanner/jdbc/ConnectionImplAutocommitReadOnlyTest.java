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
public class ConnectionImplAutocommitReadOnlyTest {

  public static class ConnectionImplAutocommitReadOnlyNoActionsTest
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
      log("SET READONLY=TRUE;");
      connection.setReadOnly(true);
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
      // there is no transaction
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

  public static class ConnectionImplAutocommitReadOnlyAfterSelectTest
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
      log("SET READONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      // no call to next() on ResultSet
      log(SELECT + ";");
      connection.executeQuery(Statement.of(SELECT));
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
      // there is no transaction
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

  public static class ConnectionImplAutocommitReadOnlyAfterSelectAndResultSetNextTest
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
      log("SET READONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log(SELECT + ";");
      connection.executeQuery(Statement.of(SELECT)).next();
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
      // there is no transaction
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

  public static class ConnectionImplAutocommitReadOnlyAfterBeginTransactionTest
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
      log("SET READONLY=TRUE;");
      connection.setReadOnly(true);
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
      return false;
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
      // connection is in read-only mode
      return mode == TransactionMode.READ_ONLY_TRANSACTION;
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

  public static class ConnectionImplAutocommitReadOnlyAfterTemporaryTransactionTest
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
      log("SET READONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      log("BEGIN TRANSACTION;");
      connection.beginTransaction();
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
      // no transaction
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      // readonly
      return false;
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

  public static class ConnectionImplAutocommitReadOnlyAfterSetReadOnlyMaxStalenessTest
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
      log("SET READONLY=TRUE;");
      connection.setReadOnly(true);
      log("SET AUTOCOMMIT=TRUE;");
      connection.setAutocommit(true);
      TimestampBound staleness = TimestampBound.ofMaxStaleness(10L, TimeUnit.SECONDS);
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
      // there is no transaction
      return false;
    }

    @Override
    boolean isGetTransactionModeAllowed() {
      return false;
    }

    @Override
    boolean isSetAutocommitDmlModeAllowed() {
      // readonly
      return false;
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
}

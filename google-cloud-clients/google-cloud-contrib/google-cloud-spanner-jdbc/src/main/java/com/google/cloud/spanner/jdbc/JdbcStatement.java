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

import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.rpc.Code;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Implementation of {@link java.sql.Statement} for Google Cloud Spanner. */
class JdbcStatement extends AbstractJdbcStatement {
  enum BatchType {
    NONE,
    DML,
    DDL;
  }

  private ResultSet currentResultSet;
  private long currentUpdateCount;
  private int fetchSize;
  private BatchType currentBatchType = BatchType.NONE;
  final List<Statement> batchedStatements = new ArrayList<>();

  JdbcStatement(JdbcConnection connection) {
    super(connection);
  }

  @Override
  public ResultSet executeQuery(String sql) throws SQLException {
    checkClosed();
    return executeQuery(Statement.of(sql));
  }

  /**
   * @see java.sql.Statement#executeUpdate(String)
   *     <p>This method allows both DML and DDL statements to be executed. It assumes that the user
   *     knows what kind of statement is being executed, and the method will therefore return 0 for
   *     both DML statements that changed 0 rows as well as for all DDL statements.
   */
  @Override
  public int executeUpdate(String sql) throws SQLException {
    checkClosed();
    Statement statement = Statement.of(sql);
    StatementResult result = execute(statement);
    switch (result.getResultType()) {
      case RESULT_SET:
        throw JdbcSqlExceptionFactory.of(
            "The statement is not an update or DDL statement", Code.INVALID_ARGUMENT);
      case UPDATE_COUNT:
        if (result.getUpdateCount() > Integer.MAX_VALUE) {
          throw JdbcSqlExceptionFactory.of(
              "update count too large: " + result.getUpdateCount(), Code.OUT_OF_RANGE);
        }
        return result.getUpdateCount().intValue();
      case NO_RESULT:
        return 0;
      default:
        throw JdbcSqlExceptionFactory.of(
            "unknown result: " + result.getResultType(), Code.FAILED_PRECONDITION);
    }
  }

  @Override
  public boolean execute(String sql) throws SQLException {
    checkClosed();
    return executeStatement(Statement.of(sql));
  }

  boolean executeStatement(Statement statement) throws SQLException {
    StatementResult result = execute(statement);
    switch (result.getResultType()) {
      case RESULT_SET:
        currentResultSet = JdbcResultSet.of(this, result.getResultSet());
        currentUpdateCount = JdbcConstants.STATEMENT_RESULT_SET;
        return true;
      case UPDATE_COUNT:
        currentResultSet = null;
        currentUpdateCount = result.getUpdateCount();
        return false;
      case NO_RESULT:
        currentResultSet = null;
        currentUpdateCount = JdbcConstants.STATEMENT_NO_RESULT;
        return false;
      default:
        throw JdbcSqlExceptionFactory.of(
            "unknown result: " + result.getResultType(), Code.FAILED_PRECONDITION);
    }
  }

  @Override
  public ResultSet getResultSet() throws SQLException {
    checkClosed();
    return currentResultSet;
  }

  /**
   * Returns the update count of the last update statement. Will return {@link
   * JdbcConstants#STATEMENT_RESULT_SET} if the last statement returned a {@link ResultSet} and will
   * return {@link JdbcConstants#STATEMENT_NO_RESULT} if the last statement did not have any return
   * value, such as for example DDL statements.
   */
  @Override
  public int getUpdateCount() throws SQLException {
    checkClosed();
    if (currentUpdateCount > Integer.MAX_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          "update count too large: " + currentUpdateCount, Code.OUT_OF_RANGE);
    }
    return (int) currentUpdateCount;
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    checkClosed();
    return getMoreResults(CLOSE_CURRENT_RESULT);
  }

  @Override
  public boolean getMoreResults(int current) throws SQLException {
    checkClosed();
    if (currentResultSet != null
        && !currentResultSet.isClosed()
        && (current == CLOSE_CURRENT_RESULT || current == CLOSE_ALL_RESULTS)) {
      currentResultSet.close();
    }
    currentResultSet = null;
    currentUpdateCount = -1L;
    return false;
  }

  /** This value is set as the value for {@link Options#prefetchChunks(int)} */
  @Override
  public void setFetchSize(int rows) throws SQLException {
    checkClosed();
    this.fetchSize = rows;
  }

  /** This value is set as the value for {@link Options#prefetchChunks(int)} */
  @Override
  public int getFetchSize() throws SQLException {
    checkClosed();
    return fetchSize;
  }

  /**
   * Determine the batch type (DML/DDL) based on the sql statement.
   *
   * @throws SQLException if the sql statement is not allowed for batching.
   */
  private BatchType determineStatementBatchType(String sql) throws SQLException {
    String sqlWithoutComments = StatementParser.removeCommentsAndTrim(sql);
    if (StatementParser.INSTANCE.isDdlStatement(sqlWithoutComments)) {
      return BatchType.DDL;
    } else if (StatementParser.INSTANCE.isUpdateStatement(sqlWithoutComments)) {
      return BatchType.DML;
    }
    throw JdbcSqlExceptionFactory.of(
        "The statement is not suitable for batching. Only DML and DDL statements are allowed for batching.",
        Code.INVALID_ARGUMENT);
  }

  /**
   * Check that the sql statement is of the same type as the current batch on this statement. If
   * there is no active batch on this statement, a batch will be started with the type that is
   * determined from the sql statement (DML/DDL).
   *
   * @throws SQLException if the sql statement is of a different type than the already active batch
   *     on this statement, if the statement is not allowed for batching (i.e. it is a query or a
   *     client side statement) or if the connection of this statement has an active batch.
   */
  void checkAndSetBatchType(String sql) throws SQLException {
    checkConnectionHasNoActiveBatch();
    BatchType type = determineStatementBatchType(sql);
    if (this.currentBatchType == BatchType.NONE) {
      this.currentBatchType = type;
    } else if (this.currentBatchType != type) {
      throw JdbcSqlExceptionFactory.of(
          "Mixing DML and DDL statements in a batch is not allowed.", Code.INVALID_ARGUMENT);
    }
  }

  private void checkConnectionHasNoActiveBatch() throws SQLException {
    if (getConnection().getSpannerConnection().isDdlBatchActive()
        || getConnection().getSpannerConnection().isDmlBatchActive()) {
      throw JdbcSqlExceptionFactory.of(
          "Calling addBatch() is not allowed when a DML or DDL batch has been started on the connection.",
          Code.FAILED_PRECONDITION);
    }
  }

  @Override
  public void addBatch(String sql) throws SQLException {
    checkClosed();
    checkAndSetBatchType(sql);
    batchedStatements.add(Statement.of(sql));
  }

  @Override
  public void clearBatch() throws SQLException {
    checkClosed();
    checkConnectionHasNoActiveBatch();
    batchedStatements.clear();
    this.currentBatchType = BatchType.NONE;
  }

  @Override
  public int[] executeBatch() throws SQLException {
    checkClosed();
    checkConnectionHasNoActiveBatch();
    try {
      switch (this.currentBatchType) {
        case DML:
          try {
            long[] updateCounts =
                getConnection().getSpannerConnection().executeBatchUpdate(batchedStatements);
            int[] res = convertUpdateCounts(updateCounts);
            return res;
          } catch (SpannerBatchUpdateException e) {
            int[] updateCounts = convertUpdateCounts(e.getUpdateCounts());
            throw JdbcSqlExceptionFactory.batchException(updateCounts, e);
          } catch (SpannerException e) {
            throw JdbcSqlExceptionFactory.of(e);
          }
        case DDL:
          try {
            getConnection().getSpannerConnection().startBatchDdl();
            for (Statement statement : batchedStatements) {
              execute(statement);
            }
            getConnection().getSpannerConnection().runBatch();
            int[] res = new int[batchedStatements.size()];
            Arrays.fill(res, java.sql.Statement.SUCCESS_NO_INFO);
            return res;
          } catch (SpannerBatchUpdateException e) {
            int[] res = new int[batchedStatements.size()];
            Arrays.fill(res, java.sql.Statement.EXECUTE_FAILED);
            convertUpdateCountsToSuccessNoInfo(e.getUpdateCounts(), res);
            throw JdbcSqlExceptionFactory.batchException(res, e);
          } catch (SpannerException e) {
            throw JdbcSqlExceptionFactory.of(e);
          }
        case NONE:
          // There is no batch on this statement, this is a no-op.
          return new int[0];
        default:
          throw JdbcSqlExceptionFactory.unsupported(
              String.format("Unknown batch type: %s", this.currentBatchType.name()));
      }
    } finally {
      batchedStatements.clear();
      this.currentBatchType = BatchType.NONE;
    }
  }

  @VisibleForTesting
  int[] convertUpdateCounts(long[] updateCounts) throws SQLException {
    int[] res = new int[updateCounts.length];
    for (int index = 0; index < updateCounts.length; index++) {
      if (updateCounts[index] > Integer.MAX_VALUE) {
        throw JdbcSqlExceptionFactory.of(
            String.format("Update count too large for int: %d", updateCounts[index]),
            Code.OUT_OF_RANGE);
      }
      res[index] = (int) updateCounts[index];
    }
    return res;
  }

  @VisibleForTesting
  void convertUpdateCountsToSuccessNoInfo(long[] updateCounts, int[] res) throws SQLException {
    Preconditions.checkNotNull(updateCounts);
    Preconditions.checkNotNull(res);
    Preconditions.checkArgument(res.length >= updateCounts.length);
    for (int index = 0; index < updateCounts.length; index++) {
      if (updateCounts[index] > Integer.MAX_VALUE) {
        throw JdbcSqlExceptionFactory.of(
            String.format("Update count too large for int: %d", updateCounts[index]),
            Code.OUT_OF_RANGE);
      }
      if (updateCounts[index] > 0L) {
        res[index] = java.sql.Statement.SUCCESS_NO_INFO;
      } else {
        res[index] = java.sql.Statement.EXECUTE_FAILED;
      }
    }
  }

  @Override
  public ResultSet getGeneratedKeys() throws SQLException {
    checkClosed();
    // Return an empty result set instead of throwing an exception, to facilitate any application
    // that might not check on beforehand whether the driver supports any generated keys.
    com.google.cloud.spanner.ResultSet rs =
        ResultSets.forRows(
            Type.struct(
                StructField.of("COLUMN_NAME", Type.string()),
                StructField.of("VALUE", Type.int64())),
            Collections.<Struct>emptyList());
    return JdbcResultSet.of(rs);
  }

  @Override
  public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        autoGeneratedKeys == java.sql.Statement.NO_GENERATED_KEYS,
        JdbcConnection.ONLY_NO_GENERATED_KEYS);
    return executeUpdate(sql);
  }

  @Override
  public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
    checkClosed();
    return executeUpdate(sql);
  }

  @Override
  public int executeUpdate(String sql, String[] columnNames) throws SQLException {
    checkClosed();
    return executeUpdate(sql);
  }

  @Override
  public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        autoGeneratedKeys == java.sql.Statement.NO_GENERATED_KEYS,
        JdbcConnection.ONLY_NO_GENERATED_KEYS);
    return execute(sql);
  }

  @Override
  public boolean execute(String sql, int[] columnIndexes) throws SQLException {
    checkClosed();
    return execute(sql);
  }

  @Override
  public boolean execute(String sql, String[] columnNames) throws SQLException {
    checkClosed();
    return execute(sql);
  }
}

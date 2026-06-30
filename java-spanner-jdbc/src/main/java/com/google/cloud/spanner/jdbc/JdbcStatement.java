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

import static com.google.cloud.spanner.jdbc.JdbcConnection.NO_GENERATED_KEY_COLUMNS;

import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.StatementResult;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.rpc.Code;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/** Implementation of {@link java.sql.Statement} for Google Cloud Spanner. */
class JdbcStatement extends AbstractJdbcStatement implements CloudSpannerJdbcStatement {
  static final ImmutableList<String> ALL_COLUMNS = ImmutableList.of("*");

  enum BatchType {
    NONE,
    DML,
    DDL
  }

  private ResultSet currentResultSet;
  private ResultSet currentGeneratedKeys;
  private long currentUpdateCount;
  private int fetchSize;
  private BatchType currentBatchType = BatchType.NONE;
  final List<Statement> batchedStatements = new ArrayList<>();

  JdbcStatement(JdbcConnection connection) throws SQLException {
    super(connection);
  }

  @Override
  public void close() throws SQLException {
    setCurrentResultSet(null);
    super.close();
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
    return executeUpdate(sql, NO_GENERATED_KEY_COLUMNS);
  }

  private int executeUpdate(String sql, ImmutableList<String> generatedKeysColumns)
      throws SQLException {
    return checkedCast(executeLargeUpdate(sql, generatedKeysColumns));
  }

  /**
   * @see java.sql.Statement#executeLargeUpdate(String)
   *     <p>This method allows both DML and DDL statements to be executed. It assumes that the user
   *     knows what kind of statement is being executed, and the method will therefore return 0 for
   *     both DML statements that changed 0 rows as well as for all DDL statements.
   */
  @Override
  public long executeLargeUpdate(String sql) throws SQLException {
    return executeLargeUpdate(sql, NO_GENERATED_KEY_COLUMNS);
  }

  private long executeLargeUpdate(String sql, ImmutableList<String> generatedKeysColumns)
      throws SQLException {
    return executeLargeUpdate(Statement.of(sql), generatedKeysColumns);
  }

  protected long executeLargeUpdate(Statement statement, ImmutableList<String> generatedKeysColumns)
      throws SQLException {
    Preconditions.checkNotNull(generatedKeysColumns);
    checkClosed();
    Statement statementWithReturningClause =
        addReturningToStatement(statement, generatedKeysColumns);
    StatementResult result = execute(statementWithReturningClause);
    switch (result.getResultType()) {
      case RESULT_SET:
        if (generatedKeysColumns.isEmpty()) {
          // Close the result set as we are not going to return it to the user. This prevents the
          // underlying session from potentially being leaked.
          throw closeResultSetAndCreateInvalidQueryException(result);
        }
        // Make a copy of the result set as it does not matter if the user does not close the result
        // set. This also consumes all rows of the result set, which again means that it is safe to
        // extract the update count.
        this.currentGeneratedKeys = JdbcResultSet.copyOf(result.getResultSet());
        return extractUpdateCountAndClose(result.getResultSet());
      case UPDATE_COUNT:
        return result.getUpdateCount();
      case NO_RESULT:
        return 0L;
      default:
        throw JdbcSqlExceptionFactory.of(
            "unknown result: " + result.getResultType(), Code.FAILED_PRECONDITION);
    }
  }

  /**
   * Extracts the update count from the given result set and then closes the result set. This method
   * may only be called for a {@link com.google.cloud.spanner.ResultSet} where all rows have been
   * fetched. That is; {@link com.google.cloud.spanner.ResultSet#next()} must have returned false.
   */
  private long extractUpdateCountAndClose(com.google.cloud.spanner.ResultSet resultSet)
      throws SQLException {
    try {
      if (resultSet.getStats() == null) {
        throw JdbcSqlExceptionFactory.of(
            "Result does not contain any stats", Code.FAILED_PRECONDITION);
      }
      long updateCount;
      if (resultSet.getStats().hasRowCountExact()) {
        updateCount = resultSet.getStats().getRowCountExact();
      } else if (resultSet.getStats().hasRowCountLowerBound()) {
        // This is returned by Cloud Spanner if the user had set the autocommit_dml_mode to
        // 'partitioned_non_atomic' (i.e. PDML).
        updateCount = resultSet.getStats().getRowCountLowerBound();
      } else {
        throw JdbcSqlExceptionFactory.of(
            "Result does not contain an update count", Code.FAILED_PRECONDITION);
      }
      return updateCount;
    } catch (UnsupportedOperationException unsupportedOperationException) {
      throw JdbcSqlExceptionFactory.of(
          unsupportedOperationException.getMessage(),
          Code.FAILED_PRECONDITION,
          unsupportedOperationException);
    } finally {
      resultSet.close();
    }
  }

  private SQLException closeResultSetAndCreateInvalidQueryException(StatementResult result) {
    //noinspection finally
    try {
      result.getResultSet().close();
    } finally {
      //noinspection ReturnInsideFinallyBlock
      return JdbcSqlExceptionFactory.of(
          "The statement is not a non-returning DML or DDL statement", Code.INVALID_ARGUMENT);
    }
  }

  /**
   * Adds a THEN RETURN/RETURNING clause to the given statement if the following conditions are all
   * met:
   *
   * <ol>
   *   <li>The generatedKeysColumns is not empty
   *   <li>The statement is a DML statement
   *   <li>The DML statement does not already contain a THEN RETURN/RETURNING clause
   * </ol>
   */
  Statement addReturningToStatement(Statement statement, ImmutableList<String> generatedKeysColumns)
      throws SQLException {
    if (Preconditions.checkNotNull(generatedKeysColumns).isEmpty()) {
      return statement;
    }
    // Check if the statement is a DML statement or not.
    ParsedStatement parsedStatement = getConnection().getParser().parse(statement);
    if (parsedStatement.isUpdate() && !parsedStatement.hasReturningClause()) {
      if (generatedKeysColumns.size() == 1
          && ALL_COLUMNS.get(0).equals(generatedKeysColumns.get(0))) {
        // Add a 'THEN RETURN/RETURNING *' clause to the statement.
        return statement.toBuilder()
            .replace(statement.getSql() + getReturningAllColumnsClause())
            .build();
      }
      // Add a 'THEN RETURN/RETURNING col1, col2, ...' to the statement.
      // The column names will be quoted using the dialect-specific identifier quoting character.
      return statement.toBuilder()
          .replace(
              generatedKeysColumns.stream()
                  .map(this::quoteColumn)
                  .collect(
                      Collectors.joining(
                          ", ", statement.getSql() + getReturningClause() + " ", "")))
          .build();
    }
    return statement;
  }

  /** Returns the dialect-specific clause for returning values from a DML statement. */
  String getReturningAllColumnsClause() {
    switch (getConnection().getDialect()) {
      case POSTGRESQL:
        return "\nRETURNING *";
      case GOOGLE_STANDARD_SQL:
      default:
        return "\nTHEN RETURN *";
    }
  }

  /** Returns the dialect-specific clause for returning values from a DML statement. */
  String getReturningClause() {
    switch (getConnection().getDialect()) {
      case POSTGRESQL:
        return "\nRETURNING";
      case GOOGLE_STANDARD_SQL:
      default:
        return "\nTHEN RETURN";
    }
  }

  /** Adds dialect-specific quotes to the given column name. */
  String quoteColumn(String column) {
    switch (getConnection().getDialect()) {
      case POSTGRESQL:
        return "\"" + column + "\"";
      case GOOGLE_STANDARD_SQL:
      default:
        return "`" + column + "`";
    }
  }

  @Override
  public boolean execute(String sql) throws SQLException {
    return executeStatement(Statement.of(sql), NO_GENERATED_KEY_COLUMNS);
  }

  boolean executeStatement(Statement statement, ImmutableList<String> generatedKeysColumns)
      throws SQLException {
    checkClosed();
    // This will return the same Statement instance if no THEN RETURN clause is added to the
    // statement.
    Statement statementWithReturning = addReturningToStatement(statement, generatedKeysColumns);
    StatementResult result = execute(statementWithReturning);
    switch (result.getResultType()) {
      case RESULT_SET:
        // Check whether the statement was modified to include a RETURNING clause for generated
        // keys. If so, then we return the result as an update count and the rows as the generated
        // keys. We can safely use '==', as the addReturningToStatement(..) method returns the same
        // instance if no generated keys were requested.
        if (statementWithReturning == statement) {
          setCurrentResultSet(JdbcResultSet.of(this, result.getResultSet()));
          currentUpdateCount = JdbcConstants.STATEMENT_RESULT_SET;
          return true;
        }
        this.currentGeneratedKeys = JdbcResultSet.copyOf(result.getResultSet());
        this.currentUpdateCount = extractUpdateCountAndClose(result.getResultSet());
        return false;
      case UPDATE_COUNT:
        setCurrentResultSet(null);
        currentUpdateCount = result.getUpdateCount();
        return false;
      case NO_RESULT:
        setCurrentResultSet(null);
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

  void setCurrentResultSet(ResultSet resultSet) throws SQLException {
    if (this.currentResultSet != null) {
      this.currentResultSet.close();
    }
    this.currentResultSet = resultSet;
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
    return checkedCast(currentUpdateCount);
  }

  /**
   * Returns the update count of the last update statement as a {@link Long}. Will return {@link
   * JdbcConstants#STATEMENT_RESULT_SET} if the last statement returned a {@link ResultSet} and will
   * return {@link JdbcConstants#STATEMENT_NO_RESULT} if the last statement did not have any return
   * value, such as for example DDL statements.
   */
  @Override
  public long getLargeUpdateCount() throws SQLException {
    checkClosed();
    return currentUpdateCount;
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
    String sqlWithoutComments = parser.removeCommentsAndTrim(sql);
    if (parser.isDdlStatement(sqlWithoutComments)) {
      return BatchType.DDL;
    } else if (parser.isUpdateStatement(sqlWithoutComments)) {
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
    BatchType type = determineStatementBatchType(sql);
    if (this.currentBatchType == BatchType.NONE) {
      this.currentBatchType = type;
    } else if (this.currentBatchType != type) {
      throw JdbcSqlExceptionFactory.of(
          "Mixing DML and DDL statements in a batch is not allowed.", Code.INVALID_ARGUMENT);
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
    batchedStatements.clear();
    this.currentBatchType = BatchType.NONE;
  }

  @Override
  public int[] executeBatch() throws SQLException {
    return convertUpdateCounts(executeBatch(false));
  }

  public long[] executeLargeBatch() throws SQLException {
    return executeBatch(true);
  }

  private long[] executeBatch(boolean large) throws SQLException {
    checkClosed();
    StatementTimeout originalTimeout = setTemporaryStatementTimeout();
    try {
      switch (this.currentBatchType) {
        case DML:
          try {
            return getConnection().getSpannerConnection().executeBatchUpdate(batchedStatements);
          } catch (SpannerBatchUpdateException e) {
            if (large) {
              throw JdbcSqlExceptionFactory.batchException(e.getUpdateCounts(), e);
            } else {
              throw JdbcSqlExceptionFactory.batchException(
                  convertUpdateCounts(e.getUpdateCounts()), e);
            }
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
            long[] res = new long[batchedStatements.size()];
            Arrays.fill(res, java.sql.Statement.SUCCESS_NO_INFO);
            return res;
          } catch (SpannerBatchUpdateException e) {
            long[] res = new long[batchedStatements.size()];
            Arrays.fill(res, java.sql.Statement.EXECUTE_FAILED);
            convertUpdateCountsToSuccessNoInfo(e.getUpdateCounts(), res);
            if (large) {
              throw JdbcSqlExceptionFactory.batchException(res, e);
            } else {
              throw JdbcSqlExceptionFactory.batchException(convertUpdateCounts(res), e);
            }
          } catch (SpannerException e) {
            throw JdbcSqlExceptionFactory.of(e);
          }
        case NONE:
          // There is no batch on this statement, this is a no-op.
          return new long[0];
        default:
          throw JdbcSqlExceptionFactory.unsupported(
              String.format("Unknown batch type: %s", this.currentBatchType.name()));
      }
    } finally {
      resetStatementTimeout(originalTimeout);
      batchedStatements.clear();
      this.currentBatchType = BatchType.NONE;
    }
  }

  @VisibleForTesting
  int[] convertUpdateCounts(long[] updateCounts) throws SQLException {
    int[] res = new int[updateCounts.length];
    for (int index = 0; index < updateCounts.length; index++) {
      res[index] = checkedCast(updateCounts[index]);
    }
    return res;
  }

  @VisibleForTesting
  void convertUpdateCountsToSuccessNoInfo(long[] updateCounts, long[] res) {
    Preconditions.checkNotNull(updateCounts);
    Preconditions.checkNotNull(res);
    Preconditions.checkArgument(res.length >= updateCounts.length);
    for (int index = 0; index < updateCounts.length; index++) {
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
    if (this.currentGeneratedKeys == null) {
      // Return an empty result set instead of throwing an exception, as that is what the JDBC spec
      // says we should do. Note that we need to create a new instance every time, as users could in
      // theory call close() on the returned result set.
      this.currentGeneratedKeys =
          JdbcResultSet.of(
              ResultSets.forRows(
                  Type.struct(
                      StructField.of("COLUMN_NAME", Type.string()),
                      StructField.of("VALUE", Type.int64())),
                  Collections.emptyList()));
    }
    return this.currentGeneratedKeys;
  }

  @Override
  public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    return executeUpdate(
        sql,
        autoGeneratedKeys == java.sql.Statement.RETURN_GENERATED_KEYS
            ? ALL_COLUMNS
            : NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
    // This should preferably have returned an error, but the initial version of the driver just
    // accepted and ignored this. Starting to throw an error now would be a breaking change.
    // TODO: Consider throwing an Unsupported error for the next major version bump.
    return executeUpdate(sql, NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public int executeUpdate(String sql, String[] columnNames) throws SQLException {
    return executeUpdate(
        sql,
        isNullOrEmpty(columnNames) ? NO_GENERATED_KEY_COLUMNS : ImmutableList.copyOf(columnNames));
  }

  @Override
  public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
    return executeLargeUpdate(
        sql,
        autoGeneratedKeys == java.sql.Statement.RETURN_GENERATED_KEYS
            ? ALL_COLUMNS
            : NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
    // This should preferably have returned an error, but the initial version of the driver just
    // accepted and ignored this. Starting to throw an error now would be a breaking change.
    // TODO: Consider throwing an Unsupported error for the next major version bump.
    return executeLargeUpdate(sql, NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
    return executeLargeUpdate(
        sql,
        isNullOrEmpty(columnNames) ? NO_GENERATED_KEY_COLUMNS : ImmutableList.copyOf(columnNames));
  }

  @Override
  public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
    return executeStatement(
        Statement.of(sql),
        autoGeneratedKeys == java.sql.Statement.RETURN_GENERATED_KEYS
            ? ALL_COLUMNS
            : NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public boolean execute(String sql, int[] columnIndexes) throws SQLException {
    // This should preferably have returned an error, but the initial version of the driver just
    // accepted and ignored this. Starting to throw an error now would be a breaking change.
    // TODO: Consider throwing an Unsupported error for the next major version bump.
    return executeStatement(Statement.of(sql), NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public boolean execute(String sql, String[] columnNames) throws SQLException {
    return executeStatement(
        Statement.of(sql),
        isNullOrEmpty(columnNames) ? NO_GENERATED_KEY_COLUMNS : ImmutableList.copyOf(columnNames));
  }

  static boolean isNullOrEmpty(String[] columnNames) {
    return columnNames == null || columnNames.length == 0;
  }

  @Override
  public ResultSet partitionQuery(
      String query, PartitionOptions partitionOptions, QueryOption... options) throws SQLException {
    return runWithStatementTimeout(
        connection ->
            JdbcResultSet.of(
                this, connection.partitionQuery(Statement.of(query), partitionOptions, options)));
  }

  @Override
  public ResultSet runPartition(String encodedPartitionId) throws SQLException {
    return runWithStatementTimeout(
        connection -> JdbcResultSet.of(this, connection.runPartition(encodedPartitionId)));
  }

  @Override
  public CloudSpannerJdbcPartitionedQueryResultSet runPartitionedQuery(
      String query, PartitionOptions partitionOptions, QueryOption... options) throws SQLException {
    return runWithStatementTimeout(
        connection ->
            JdbcPartitionedQueryResultSet.of(
                this,
                connection.runPartitionedQuery(Statement.of(query), partitionOptions, options)));
  }
}

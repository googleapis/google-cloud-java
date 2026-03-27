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

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.PartitionOptions;
import com.google.cloud.spanner.ReadContext.QueryAnalyzeMode;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParametersInfo;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.rpc.Code;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/** Implementation of {@link PreparedStatement} for Cloud Spanner. */
class JdbcPreparedStatement extends AbstractJdbcPreparedStatement
    implements CloudSpannerJdbcPreparedStatement {
  private static final char POS_PARAM_CHAR = '?';
  private final String sql;
  private final ParametersInfo parameters;
  private JdbcParameterMetaData cachedParameterMetadata;
  private final ImmutableList<String> generatedKeysColumns;

  JdbcPreparedStatement(
      JdbcConnection connection, String sql, ImmutableList<String> generatedKeysColumns)
      throws SQLException {
    super(connection);
    this.sql = sql;
    try {
      // The PostgreSQL parser allows comments to be present in the SQL string that is used to parse
      // the query parameters.
      String sqlForParameterExtraction =
          getConnection().getDialect() == Dialect.POSTGRESQL
              ? this.sql
              : parser.removeCommentsAndTrim(this.sql);
      this.parameters =
          parser.convertPositionalParametersToNamedParameters(
              POS_PARAM_CHAR, sqlForParameterExtraction);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
    this.generatedKeysColumns = Preconditions.checkNotNull(generatedKeysColumns);
  }

  ParametersInfo getParametersInfo() {
    return parameters;
  }

  @VisibleForTesting
  Statement createStatement() throws SQLException {
    ParametersInfo paramInfo = getParametersInfo();
    Statement.Builder builder = Statement.newBuilder(paramInfo.sqlWithNamedParameters);
    for (int index = 1; index <= getParameters().getHighestIndex(); index++) {
      getParameters().bindParameterValue(builder.bind("p" + index), index);
    }
    return builder.build();
  }

  @Override
  public ResultSet executeQuery() throws SQLException {
    checkClosed();
    return executeQuery(createStatement());
  }

  ResultSet executeQueryWithOptions(QueryOption... options) throws SQLException {
    checkClosed();
    return executeQuery(createStatement(), options);
  }

  @Override
  public int executeUpdate() throws SQLException {
    long count = executeLargeUpdate(createStatement(), generatedKeysColumns);
    if (count > Integer.MAX_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          "update count too large for executeUpdate: " + count, Code.OUT_OF_RANGE);
    }
    return (int) count;
  }

  @Override
  public long executeLargeUpdate() throws SQLException {
    return executeLargeUpdate(createStatement(), generatedKeysColumns);
  }

  @Override
  public boolean execute() throws SQLException {
    return executeStatement(createStatement(), generatedKeysColumns);
  }

  @Override
  public void addBatch() throws SQLException {
    checkClosed();
    checkAndSetBatchType(sql);
    batchedStatements.add(createStatement());
  }

  @Override
  public ParameterMetaData getParameterMetaData() throws SQLException {
    checkClosed();

    // NOTE: JdbcSimpleParameterMetaData is an experimental feature that can be removed without
    // warning in a future version. Your application should not assume that this feature will
    // continue to be supported.
    if (JdbcSimpleParameterMetaData.useSimpleParameterMetadata()) {
      return new JdbcSimpleParameterMetaData(this.parameters);
    }

    if (cachedParameterMetadata == null) {
      if (getConnection().getParser().isUpdateStatement(sql)
          && !getConnection().getParser().checkReturningClause(sql)) {
        cachedParameterMetadata = getParameterMetadataForUpdate();
      } else {
        cachedParameterMetadata = getParameterMetadataForQuery();
      }
    }
    return cachedParameterMetadata;
  }

  private JdbcParameterMetaData getParameterMetadataForUpdate() {
    try (com.google.cloud.spanner.ResultSet resultSet =
        getConnection()
            .getSpannerConnection()
            .analyzeUpdateStatement(
                Statement.of(parameters.sqlWithNamedParameters), QueryAnalyzeMode.PLAN)) {
      return new JdbcParameterMetaData(this, resultSet);
    }
  }

  private JdbcParameterMetaData getParameterMetadataForQuery() {
    try (com.google.cloud.spanner.ResultSet resultSet =
        getConnection()
            .getSpannerConnection()
            .analyzeQuery(Statement.of(parameters.sqlWithNamedParameters), QueryAnalyzeMode.PLAN)) {
      return new JdbcParameterMetaData(this, resultSet);
    }
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    checkClosed();
    if (getConnection().getParser().isUpdateStatement(sql)) {
      // Return metadata for an empty result set as DML statements do not return any results (as a
      // result set).
      com.google.cloud.spanner.ResultSet resultSet =
          ResultSets.forRows(Type.struct(), ImmutableList.of());
      resultSet.next();
      return new JdbcResultSetMetaData(JdbcResultSet.of(resultSet), this);
    }
    try (ResultSet rs = analyzeQuery(createStatement(), QueryAnalyzeMode.PLAN)) {
      return rs.getMetaData();
    }
  }

  @Override
  public ResultSet partitionQuery(PartitionOptions partitionOptions, QueryOption... options)
      throws SQLException {
    return runWithStatementTimeout(
        connection ->
            JdbcResultSet.of(
                this, connection.partitionQuery(createStatement(), partitionOptions, options)));
  }

  @Override
  public ResultSet runPartition() throws SQLException {
    return runWithStatementTimeout(
        connection -> {
          if (getParameters().getHighestIndex() < 1 || getParameters().getParameter(1) == null) {
            throw JdbcSqlExceptionFactory.of(
                "No query parameter has been set. runPartition() requires the partition ID to be set as a query parameter with index 1. Call PreparedStatement#setString(1, \"some-partition-id\") before calling runPartition().",
                Code.FAILED_PRECONDITION);
          }
          String partitionId = getParameters().getParameter(1).toString();
          return JdbcResultSet.of(this, connection.runPartition(partitionId));
        });
  }

  @Override
  public CloudSpannerJdbcPartitionedQueryResultSet runPartitionedQuery(
      PartitionOptions partitionOptions, QueryOption... options) throws SQLException {
    return runWithStatementTimeout(
        connection ->
            JdbcPartitionedQueryResultSet.of(
                this,
                connection.runPartitionedQuery(createStatement(), partitionOptions, options)));
  }
}

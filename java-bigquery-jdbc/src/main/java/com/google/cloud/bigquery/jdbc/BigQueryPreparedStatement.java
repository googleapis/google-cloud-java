/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.services.bigquery.model.QueryParameter;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BigQueryPreparedStatement extends BigQueryStatement implements PreparedStatement {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private static final char POSITIONAL_PARAMETER_CHAR = '?';
  // parameterHandler is inherited from BigQueryStatement
  protected final int parameterCount;
  protected String currentQuery;
  private Queue<ArrayList<BigQueryJdbcParameter>> batchParameters = new LinkedList<>();
  // Both hold statistics.getSchema(), which reports different things per statement type: the rows
  // a SELECT returns, versus the columns an INSERT writes.
  Schema resultSchema = null; // Feeds getMetaData().
  Schema insertSchema = null; // Feeds the Storage Write API.
  private TableName insertTableName = null;

  BigQueryPreparedStatement(BigQueryConnection connection, String query) {
    super(connection);
    this.currentQuery = query;
    QueryStatistics queryStatistics = describeQueryQuietly();
    this.parameterCount = resolveParameterCount(query, queryStatistics);
    this.parameterHandler =
        new BigQueryParameterHandler(this.parameterCount, this.isEnableTimestampPicos());
    if (queryStatistics != null) {
      applyInferredParameterTypes(queryStatistics);
      captureInsertMetadata(queryStatistics);
      captureResultSchema(queryStatistics);
    }
  }

  private int resolveParameterCount(String query, QueryStatistics queryStatistics) {
    if (queryStatistics != null && queryStatistics.getQueryParameters() != null) {
      return queryStatistics.getQueryParameters().size();
    }
    return (int) query.chars().filter(ch -> ch == POSITIONAL_PARAMETER_CHAR).count();
  }

  /**
   * Failures are logged and swallowed. Nothing a dry run supplies is required for correctness: the
   * types are defaults the caller's {@code setXxx} calls refine, and the count falls back to a scan
   * of the query text, so a statement stays usable against a service that refuses the dry run.
   */
  private QueryStatistics describeQueryQuietly() {
    if (this.currentQuery.indexOf(POSITIONAL_PARAMETER_CHAR) == -1) {
      return null;
    }
    try {
      return describePositionalParameterQuery(this.currentQuery);
    } catch (SQLException | RuntimeException ex) {
      LOG.warning(
          ex,
          "Could not describe query via dry run; parameter types will be derived from the values"
              + " supplied by the caller, and the parameter count from the query text.");
      return null;
    }
  }

  private void applyInferredParameterTypes(QueryStatistics statistics) {
    List<QueryParameter> undeclaredParameters = statistics.getQueryParameters();
    if (undeclaredParameters == null) {
      return;
    }
    int index = 1;
    for (QueryParameter parameter : undeclaredParameters) {
      if (parameter.getParameterType() != null) {
        StandardSQLTypeName sqlType = toStandardSqlType(parameter.getParameterType().getType());
        if (sqlType != null) {
          this.parameterHandler.setInferredParameterType(index, sqlType);
        }
      }
      index++;
    }
  }

  // Returning null costs one parameter its inferred type; letting the exception propagate would
  // abandon inference for every parameter after it.
  private static StandardSQLTypeName toStandardSqlType(String typeName) {
    if (typeName == null) {
      return null;
    }
    try {
      return StandardSQLTypeName.valueOf(typeName);
    } catch (IllegalArgumentException ex) {
      return null;
    }
  }

  // Remembers the table and schema of single-table INSERT targets, for the Storage Write API.
  // Failure is delegated to executeBatch instead of the constructor.
  private void captureInsertMetadata(QueryStatistics statistics) {
    if (!StatementType.INSERT.equals(statistics.getStatementType())
        || statistics.getSchema() == null
        || statistics.getReferencedTables() == null
        || statistics.getReferencedTables().stream().distinct().count() != 1) {
      return;
    }
    this.insertSchema = statistics.getSchema();
    TableId tableId = statistics.getReferencedTables().get(0);
    this.insertTableName =
        TableName.of(tableId.getProject(), tableId.getDataset(), tableId.getTable());
    LOG.finer("insertTableName: %s, insertSchema: %s", this.insertTableName, this.insertSchema);
  }

  // This populates the schema of the ResultSet that is being returned by the query.
  // The column names are as they are returned from the query dryRun and may not match the actual
  // table column names.
  private void captureResultSchema(QueryStatistics statistics) {
    if (StatementType.SELECT.equals(statistics.getStatementType())) {
      this.resultSchema = statistics.getSchema();
    }
  }

  @Override
  public ResultSet executeQuery() throws SQLException {
    validateExecution();
    return BigQueryJdbcOpenTelemetry.withTracing(
        "BigQueryPreparedStatement.executeQuery",
        this.connection,
        this.currentQuery,
        () -> super.executeQuery(this.currentQuery));
  }

  @Override
  public long executeLargeUpdate() throws SQLException {
    validateExecution();
    return BigQueryJdbcOpenTelemetry.withTracing(
        "BigQueryPreparedStatement.executeLargeUpdate",
        this.connection,
        this.currentQuery,
        () -> super.executeLargeUpdate(this.currentQuery));
  }

  @Override
  public int executeUpdate() throws SQLException {
    return super.executeUpdate(this.currentQuery);
  }

  @Override
  public boolean execute() throws SQLException {
    validateExecution();
    return BigQueryJdbcOpenTelemetry.withTracing(
        "BigQueryPreparedStatement.execute",
        this.connection,
        this.currentQuery,
        () -> super.execute(this.currentQuery));
  }

  @Override
  public void clearParameters() {
    this.parameterHandler.clearParameters();
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    checkClosed();
    this.parameterHandler.setNullParameter(parameterIndex, declaredJavaType(sqlType));
  }

  // Types.NULL is what setObject(index, null) synthesizes when the caller named no type, and
  // Types.OTHER names none either. Both defer to whatever the slot already knows.
  private static Class<?> declaredJavaType(int jdbcType)
      throws BigQueryJdbcSqlFeatureNotSupportedException {
    if (jdbcType == Types.NULL || jdbcType == Types.OTHER) {
      return null;
    }
    return BigQueryTypeRegistry.toJavaClass(jdbcType);
  }

  @Override
  public void setBoolean(int parameterIndex, boolean value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Boolean.class);
  }

  @Override
  public void setByte(int parameterIndex, byte value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Byte.class);
  }

  @Override
  public void setShort(int parameterIndex, short value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Short.class);
  }

  @Override
  public void setInt(int parameterIndex, int value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Integer.class);
  }

  @Override
  public void setLong(int parameterIndex, long value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Long.class);
  }

  @Override
  public void setFloat(int parameterIndex, float value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Float.class);
  }

  @Override
  public void setDouble(int parameterIndex, double value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Double.class);
  }

  @Override
  public void setBigDecimal(int parameterIndex, BigDecimal value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, BigDecimal.class);
  }

  @Override
  public void setString(int parameterIndex, String value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, String.class);
  }

  @Override
  public void setBytes(int parameterIndex, byte[] value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, byte[].class);
  }

  @Override
  public void setDate(int parameterIndex, Date value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Date.class);
  }

  @Override
  public void setTime(int parameterIndex, Time value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Time.class);
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Timestamp.class);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setAsciiStream is not supported.");
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public void setUnicodeStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setUnicodeStream is not supported.");
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBinaryStream is not supported.");
  }

  @Override
  public void setObject(int parameterIndex, Object value, int targetSqlType) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, targetSqlType);
      return;
    }
    if (setTemporalObject(parameterIndex, value)) {
      return;
    }
    Class<?> javaType = BigQueryTypeRegistry.toJavaClass(targetSqlType);
    this.parameterHandler.setParameter(parameterIndex, value, javaType);
  }

  @Override
  public void setObject(int parameterIndex, Object value) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.NULL);
      return;
    }
    if (setTemporalObject(parameterIndex, value)) {
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, value.getClass());
  }

  private boolean setTemporalObject(int parameterIndex, Object value) throws SQLException {
    if (value instanceof LocalDate) {
      setDate(parameterIndex, Date.valueOf((LocalDate) value));
      return true;
    }
    if (value instanceof LocalTime) {
      setTime(parameterIndex, Time.valueOf((LocalTime) value));
      return true;
    }
    if (value instanceof LocalDateTime) {
      setTimestamp(parameterIndex, Timestamp.valueOf((LocalDateTime) value));
      return true;
    }
    if (value instanceof OffsetDateTime) {
      setTimestamp(parameterIndex, Timestamp.from(((OffsetDateTime) value).toInstant()));
      return true;
    }
    if (value instanceof Instant) {
      setTimestamp(parameterIndex, Timestamp.from((Instant) value));
      return true;
    }
    if (value instanceof ZonedDateTime) {
      setTimestamp(parameterIndex, Timestamp.from(((ZonedDateTime) value).toInstant()));
      return true;
    }
    return false;
  }

  @Override
  public void addBatch() {
    ArrayList<BigQueryJdbcParameter> currentParameterList =
        deepCopyParameterList(this.parameterHandler.parametersList);
    this.batchParameters.add(currentParameterList);
  }

  private ArrayList<BigQueryJdbcParameter> deepCopyParameterList(
      ArrayList<BigQueryJdbcParameter> parametersList) {
    ArrayList<BigQueryJdbcParameter> copiedParameterList = new ArrayList<>();
    for (BigQueryJdbcParameter parameter : parametersList) {
      BigQueryJdbcParameter newParameter = new BigQueryJdbcParameter(parameter);
      copiedParameterList.add(newParameter);
    }
    return copiedParameterList;
  }

  @Override
  public int[] executeBatch() throws SQLException {
    validateExecution();
    int[] result = new int[this.batchParameters.size()];
    if (this.batchParameters.isEmpty()) {
      return result;
    }

    // The constructor's dry run may have happened before the target table existed.
    if (this.insertSchema == null
        && this.querySettings.isUseWriteAPI()
        && this.batchParameters.size() >= this.querySettings.getWriteAPIActivationRowCount()) {
      try {
        captureInsertMetadata(
            getQueryStatistics(getWriteBatchJobConfiguration(this.batchParameters.peek())));
      } catch (SQLException | RuntimeException ex) {
        LOG.warning(ex, "Could not describe INSERT target; using the standard batch path.");
      }
    }

    if (useWriteAPI()) {
      try (BigQueryWriteClient writeClient = this.connection.getBigQueryWriteClient()) {
        LOG.info("Using Write API for bulk INSERT operation.");

        long rowCount = bulkInsertWithWriteAPI(writeClient);
        int[] insertArray = new int[Math.toIntExact(rowCount)];
        Arrays.fill(insertArray, 1);
        return insertArray;

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new BigQueryJdbcRuntimeException("Interrupted during Write API batch", e);
      } catch (DescriptorValidationException | IOException e) {
        throw new BigQueryJdbcException("Failed to execute batch with Write API", e);
      }

    } else {
      try {
        LOG.info("Using individual INSERT query runs.");
        int count = this.batchParameters.size();
        StringBuilder combinedQuery = new StringBuilder();
        for (int i = 0; i < count; i++) {

          if (this.currentQuery.trim().endsWith(";")) {
            combinedQuery.append(this.currentQuery);
          } else {
            combinedQuery.append(this.currentQuery).append(";");
          }
        }
        // executeBatch in PreparedStatement is used for BulkInsert/DML.
        // If not correct Type, fails later.
        runQuery(
            combinedQuery.toString(), getStandardBatchJobConfiguration(combinedQuery.toString()));
        int i = 0;
        while (getUpdateCount() != -1 && i < count) {
          result[i] = getUpdateCount();
          getMoreResults();
          i++;
        }
        return result;
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
        throw new BigQueryJdbcRuntimeException("Interrupted during individual INSERT batch", ex);
      } catch (SQLException e) {
        throw new BigQueryJdbcException("SQL error during individual INSERT batch", e);
      }
    }
  }

  private long bulkInsertWithWriteAPI(BigQueryWriteClient bigQueryWriteClient)
      throws DescriptorValidationException,
          IOException,
          InterruptedException,
          BigQueryJdbcException {
    LOG.finer("++enter++");
    RetrySettings retrySettings = this.connection.getRetrySettings();

    BigQueryJdbcBulkInsertWriter bulkInsertWriter = new BigQueryJdbcBulkInsertWriter();
    bulkInsertWriter.initialize(this.insertTableName, bigQueryWriteClient, retrySettings);

    try {
      long offset = 0;
      JsonArray jsonArray = new JsonArray();
      Gson gson = new Gson();
      int count = this.batchParameters.size();
      for (int i = 0; i < count; i++) {

        ArrayList<BigQueryJdbcParameter> parameterList = this.batchParameters.poll();
        FieldList fieldLists = this.insertSchema.getFields();
        if (fieldLists.size() == parameterList.size()) {

          JsonObject rowObject = createJsonRow(fieldLists, parameterList, gson);
          jsonArray.add(rowObject);

          if (jsonArray.size() == this.querySettings.getWriteAPIAppendRowCount()
              || this.batchParameters.size() == 0) {
            bulkInsertWriter.append(jsonArray, offset);
            LOG.finer("Append called ");
            offset += jsonArray.size();
            jsonArray = new JsonArray();
          }
        } else {
          throw new BigQueryJdbcException("Mismatch between field count and parameter count.");
        }
      }
    } catch (BigQueryJdbcException e) {
      throw new BigQueryJdbcException("BigQueryJdbcException during bulkInsertWithWriteAPI", e);
    }

    long rowCount = bulkInsertWriter.cleanup(bigQueryWriteClient);

    BatchCommitWriteStreamsRequest commitRequest =
        BatchCommitWriteStreamsRequest.newBuilder()
            .setParent(this.insertTableName.toString())
            .addWriteStreams(bulkInsertWriter.getStreamName())
            .build();
    BatchCommitWriteStreamsResponse commitResponse =
        bigQueryWriteClient.batchCommitWriteStreams(commitRequest);
    if (commitResponse.hasCommitTime() == false) {
      throw new BigQueryJdbcException("Error committing the streams");
    }
    LOG.finer("Commit called.");
    return rowCount;
  }

  static JsonObject createJsonRow(
      FieldList fieldLists, List<BigQueryJdbcParameter> parameterList, Gson gson) {
    JsonObject rowObject = new JsonObject();
    for (int j = 0; j < parameterList.size(); j++) {
      BigQueryJdbcParameter parameter = parameterList.get(j);
      if (parameter.getValue() == null) {
        rowObject.add(fieldLists.get(j).getName(), JsonNull.INSTANCE);
      } else if (parameter.getSqlType() == StandardSQLTypeName.STRING) {
        rowObject.addProperty(fieldLists.get(j).getName(), parameter.getValue().toString());
      } else {
        rowObject.addProperty(fieldLists.get(j).getName(), gson.toJson(parameter.getValue()));
      }
    }
    return rowObject;
  }

  QueryJobConfiguration getWriteBatchJobConfiguration(
      ArrayList<BigQueryJdbcParameter> currentParameterList) throws SQLException {
    LOG.finer("++enter++");
    BigQueryParameterHandler batchHandler =
        new BigQueryParameterHandler(
            this.parameterCount, currentParameterList, this.isEnableTimestampPicos());
    QueryJobConfiguration.Builder jobConfiguration = getJobConfig(this.currentQuery);
    jobConfiguration.setParameterMode("POSITIONAL");
    jobConfiguration = batchHandler.configureParameters(jobConfiguration);
    return jobConfiguration.build();
  }

  QueryJobConfiguration getStandardBatchJobConfiguration(String query) throws SQLException {
    LOG.finer("++enter++");
    QueryJobConfiguration.Builder jobConfiguration = getJobConfig(query);
    jobConfiguration.setParameterMode("POSITIONAL");
    jobConfiguration.setPriority(QueryJobConfiguration.Priority.BATCH);
    int index = 0;
    while (!this.batchParameters.isEmpty()) {
      ArrayList<BigQueryJdbcParameter> parameterList = this.batchParameters.poll();

      for (BigQueryJdbcParameter parameter : parameterList) {
        Object parameterValue =
            BigQueryParameterHandler.formatValueForQueryParameter(
                parameter.getValue(), parameter.getSqlType(), this.isEnableTimestampPicos());
        StandardSQLTypeName sqlType = parameter.getSqlType();
        LOG.finer(
            "Parameter %s of type %s at index %s added to QueryJobConfiguration",
            parameterValue, sqlType, index++);
        jobConfiguration.addPositionalParameter(QueryParameterValue.of(parameterValue, sqlType));
      }
    }
    return jobConfiguration.build();
  }

  Boolean useWriteAPI() {
    LOG.finer("++enter++");
    return this.querySettings.isUseWriteAPI()
        // the constructor dry run already confirmed a single-table INSERT
        && this.insertSchema != null
        && this.batchParameters.size() >= this.querySettings.getWriteAPIActivationRowCount();
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setCharacterStream is not supported.");
  }

  @Override
  public void setRef(int parameterIndex, Ref x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setRef is not supported.");
  }

  @Override
  public void setBlob(int parameterIndex, Blob x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBlob is not supported.");
  }

  @Override
  public void setClob(int parameterIndex, Clob x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setClob is not supported.");
  }

  @Override
  public void setArray(int parameterIndex, Array value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Array.class);
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    checkClosed();
    // Null is the spec's answer for a statement that returns no rows.
    if (this.resultSchema == null) {
      return null;
    }
    return BigQueryResultSetMetadata.of(this.resultSchema.getFields(), this);
  }

  @Override
  public void setDate(int parameterIndex, Date value, Calendar calendar) throws SQLException {
    checkClosed();
    setDate(parameterIndex, BigQueryTemporalUtility.convertDateToCalendar(value, calendar));
  }

  @Override
  public void setTime(int parameterIndex, Time value, Calendar calendar) throws SQLException {
    checkClosed();
    setTime(parameterIndex, BigQueryTemporalUtility.convertTimeWithCalendar(value, calendar));
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value, Calendar calendar)
      throws SQLException {
    checkClosed();
    setTimestamp(
        parameterIndex, BigQueryTemporalUtility.convertTimestampWithCalendar(value, calendar));
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    setNull(parameterIndex, sqlType);
  }

  @Override
  public void setURL(int parameterIndex, URL x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setURL is not supported.");
  }

  @Override
  public ParameterMetaData getParameterMetaData() throws SQLException {
    checkClosed();
    return new BigQueryParameterMetaData(this.parameterCount, this.parameterHandler);
  }

  @Override
  public void setRowId(int parameterIndex, RowId x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setRowId is not supported.");
  }

  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNString is not supported.");
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNCharacterStream is not supported.");
  }

  @Override
  public void setNClob(int parameterIndex, NClob value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNClob is not supported.");
  }

  @Override
  public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setClob is not supported.");
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBlob is not supported.");
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNClob is not supported.");
  }

  @Override
  public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setSQLXML is not supported.");
  }

  /**
   * Note: BigQuery handles numeric scale and precision dynamically for NUMERIC (DECIMAL) and
   * BIGNUMERIC data types. The scaleOrLength parameter is ignored and delegates directly to {@link
   * #setObject(int, Object, int)}.
   */
  @Override
  public void setObject(int parameterIndex, Object value, int targetSqlType, int scaleOrLength)
      throws SQLException {
    checkClosed();
    setObject(parameterIndex, value, targetSqlType);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setAsciiStream is not supported.");
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBinaryStream is not supported.");
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setCharacterStream is not supported.");
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setAsciiStream is not supported.");
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBinaryStream is not supported.");
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setCharacterStream is not supported.");
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNCharacterStream is not supported.");
  }

  @Override
  public void setClob(int parameterIndex, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setClob is not supported.");
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBlob is not supported.");
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNClob is not supported.");
  }
}

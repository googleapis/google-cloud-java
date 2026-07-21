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
import java.util.Queue;

class BigQueryPreparedStatement extends BigQueryStatement implements PreparedStatement {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private static final char POSITIONAL_PARAMETER_CHAR = '?';
  // parameterHandler is inherited from BigQueryStatement
  protected int parameterCount = 0;
  protected String currentQuery;
  private Queue<ArrayList<BigQueryJdbcParameter>> batchParameters = new LinkedList<>();
  Schema insertSchema = null;
  private TableName insertTableName = null;

  BigQueryPreparedStatement(BigQueryConnection connection, String query) {
    super(connection);
    setCurrentQuery(query);
    this.parameterHandler = new BigQueryParameterHandler(this.parameterCount);
  }

  void setCurrentQuery(String currentQuery) {
    this.parameterCount = getParameterCount(currentQuery);
    this.currentQuery = currentQuery;
  }

  private int getParameterCount(String query) {
    LOG.finer("++enter++");
    return (int) query.chars().filter(ch -> ch == POSITIONAL_PARAMETER_CHAR).count();
  }

  @Override
  public ResultSet executeQuery() throws SQLException {
    return super.executeQuery(this.currentQuery);
  }

  @Override
  public long executeLargeUpdate() throws SQLException {
    return super.executeLargeUpdate(this.currentQuery);
  }

  @Override
  public int executeUpdate() throws SQLException {
    return super.executeUpdate(this.currentQuery);
  }

  @Override
  public boolean execute() throws SQLException {
    return super.execute(this.currentQuery);
  }

  @Override
  public void clearParameters() {
    this.parameterHandler.clearParameters();
    this.parameterCount = 0;
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    checkClosed();
    Class<?> javaType = BigQueryJdbcTypeMappings.getJavaType(sqlType);
    this.parameterHandler.setParameter(parameterIndex, null, javaType);
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
    if (value == null) {
      setNull(parameterIndex, Types.NUMERIC);
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, BigDecimal.class);
  }

  @Override
  public void setString(int parameterIndex, String value) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.VARCHAR);
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, String.class);
  }

  @Override
  public void setBytes(int parameterIndex, byte[] value) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.VARBINARY);
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, byte[].class);
  }

  @Override
  public void setDate(int parameterIndex, Date value) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.DATE);
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, Date.class);
  }

  @Override
  public void setTime(int parameterIndex, Time value) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.TIME);
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, Time.class);
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.TIMESTAMP);
      return;
    }
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
    Class<?> javaType = BigQueryJdbcTypeMappings.getJavaType(targetSqlType);
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
    int[] result = new int[this.batchParameters.size()];
    if (this.batchParameters.isEmpty()) {
      return result;
    }
    if (useWriteAPI()) {
      try (BigQueryWriteClient writeClient = this.connection.getBigQueryWriteClient()) {
        LOG.info("Using Write API for bulk INSERT operation.");
        ArrayList<BigQueryJdbcParameter> currentParameterList = this.batchParameters.peek();
        if (this.insertSchema == null && this.insertTableName == null) {
          QueryStatistics insertJobQueryStatistics =
              getQueryStatistics(getWriteBatchJobConfiguration(currentParameterList));
          setInsertMetadata(insertJobQueryStatistics);
        }

        long rowCount = bulkInsertWithWriteAPI(writeClient);
        int[] insertArray = new int[Math.toIntExact(rowCount)];
        Arrays.fill(insertArray, 1);
        return insertArray;

      } catch (DescriptorValidationException | IOException | InterruptedException e) {
        throw new BigQueryJdbcRuntimeException("Failed to execute batch with Write API", e);
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

          JsonObject rowObject = new JsonObject();
          for (int j = 0; j < parameterList.size(); j++) {
            BigQueryJdbcParameter parameter = parameterList.get(j);
            if (parameter.getSqlType() == StandardSQLTypeName.STRING) {
              rowObject.addProperty(fieldLists.get(j).getName(), parameter.getValue().toString());
            } else {
              rowObject.addProperty(fieldLists.get(j).getName(), gson.toJson(parameter.getValue()));
            }
          }
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

  private void setInsertMetadata(QueryStatistics statistics) throws SQLException {
    LOG.finer("++enter++");
    if (!statistics.getStatementType().equals(StatementType.INSERT)
        || statistics.getSchema() == null
        || statistics.getReferencedTables().stream().distinct().count() > 1) {
      throw new BigQueryJdbcException(
          "Use java.sql.Statement.executeBatch() for heterogeneous DML batches");
    }

    this.insertSchema = statistics.getSchema();
    TableId tableID = statistics.getReferencedTables().get(0);
    this.insertTableName =
        TableName.of(tableID.getProject(), tableID.getDataset(), tableID.getTable());
    LOG.finer(
        "this.insertTableName : %s, this.insertSchema : %s",
        this.insertTableName, this.insertSchema.toString());
  }

  QueryJobConfiguration getWriteBatchJobConfiguration(
      ArrayList<BigQueryJdbcParameter> currentParameterList) throws SQLException {
    LOG.finer("++enter++");
    BigQueryParameterHandler batchHandler =
        new BigQueryParameterHandler(this.parameterCount, currentParameterList);
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
        Object parameterValue = parameter.getValue();
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
    if (this.querySettings.isUseWriteAPI()) {
      if (this.batchParameters.size() >= this.querySettings.getWriteAPIActivationRowCount()) {
        return true;
      }
    }
    return false;
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
    if (value == null) {
      setNull(parameterIndex, Types.ARRAY);
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, Array.class);
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    checkClosed();
    if (this.insertSchema != null) {
      return BigQueryResultSetMetadata.of(this.insertSchema.getFields(), this);
    }
    return null;
  }

  @Override
  public void setDate(int parameterIndex, Date value, Calendar calendar) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.DATE);
      return;
    }
    setDate(parameterIndex, BigQueryTypeCoercionUtility.convertDateToCalendar(value, calendar));
  }

  @Override
  public void setTime(int parameterIndex, Time value, Calendar calendar) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.TIME);
      return;
    }
    setTime(parameterIndex, BigQueryTypeCoercionUtility.convertTimeWithCalendar(value, calendar));
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value, Calendar calendar)
      throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.TIMESTAMP);
      return;
    }
    setTimestamp(
        parameterIndex, BigQueryTypeCoercionUtility.convertTimestampWithCalendar(value, calendar));
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

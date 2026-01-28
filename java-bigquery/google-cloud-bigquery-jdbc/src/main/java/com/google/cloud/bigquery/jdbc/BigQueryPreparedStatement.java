/*
 * Copyright 2026 Google LLC
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

class BigQueryPreparedStatement extends BigQueryStatement implements PreparedStatement {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private static final char POSITIONAL_PARAMETER_CHAR = '?';
  // Making this protected so BigQueryCallableStatement subclass can access the parameters.
  protected final BigQueryParameterHandler parameterHandler;
  protected int parameterCount = 0;
  protected String currentQuery;
  private Queue<ArrayList<BigQueryJdbcParameter>> batchParameters = new LinkedList<>();
  private Schema insertSchema = null;
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
    LOG.finest("++enter++");
    return (int) query.chars().filter(ch -> ch == POSITIONAL_PARAMETER_CHAR).count();
  }

  @Override
  public ResultSet executeQuery() throws SQLException {
    LOG.finest("++enter++");
    logQueryExecutionStart(this.currentQuery);
    try {
      QueryJobConfiguration.Builder jobConfiguration = getJobConfig(this.currentQuery);
      jobConfiguration.setParameterMode("POSITIONAL");
      jobConfiguration = this.parameterHandler.configureParameters(jobConfiguration);
      runQuery(this.currentQuery, jobConfiguration.build());
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }
    return getCurrentResultSet();
  }

  @Override
  public long executeLargeUpdate() throws SQLException {
    LOG.finest("++enter++");
    logQueryExecutionStart(this.currentQuery);
    try {
      QueryJobConfiguration.Builder jobConfiguration = getJobConfig(this.currentQuery);
      jobConfiguration.setParameterMode("POSITIONAL");
      jobConfiguration = this.parameterHandler.configureParameters(jobConfiguration);
      runQuery(this.currentQuery, jobConfiguration.build());
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }
    return this.currentUpdateCount;
  }

  @Override
  public int executeUpdate() throws SQLException {
    LOG.finest("++enter++");
    return checkUpdateCount(executeLargeUpdate());
  }

  @Override
  public boolean execute() throws SQLException {
    LOG.finest("++enter++");
    logQueryExecutionStart(this.currentQuery);
    try {
      QueryJobConfiguration.Builder jobConfiguration = getJobConfig(this.currentQuery);
      jobConfiguration.setParameterMode("POSITIONAL");
      jobConfiguration = this.parameterHandler.configureParameters(jobConfiguration);
      runQuery(this.currentQuery, jobConfiguration.build());
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException(ex);
    }
    return getCurrentResultSet() != null;
  }

  @Override
  public void clearParameters() {
    LOG.finest("++enter++");
    this.parameterHandler.clearParameters();
    this.parameterCount = 0;
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) {
    // TODO(neenu): implement null case
  }

  @Override
  public void setBoolean(int parameterIndex, boolean x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, Boolean.class);
  }

  @Override
  public void setByte(int parameterIndex, byte x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, Byte.class);
  }

  @Override
  public void setShort(int parameterIndex, short x) {
    // TODO(neenu): implement Bytes conversion.
  }

  @Override
  public void setInt(int parameterIndex, int x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, Integer.class);
  }

  @Override
  public void setLong(int parameterIndex, long x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, Long.class);
  }

  @Override
  public void setFloat(int parameterIndex, float x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, Float.class);
  }

  @Override
  public void setDouble(int parameterIndex, double x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, Double.class);
  }

  @Override
  public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, BigDecimal.class);
  }

  @Override
  public void setString(int parameterIndex, String x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x, String.class);
  }

  @Override
  public void setBytes(int parameterIndex, byte[] x) {
    // TODO(neenu): implement Bytes conversion.
  }

  @Override
  public void setDate(int parameterIndex, Date x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x.toString(), String.class);
  }

  @Override
  public void setTime(int parameterIndex, Time x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x.toString(), String.class);
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, x.toString(), String.class);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream x, int length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setUnicodeStream(int parameterIndex, InputStream x, int length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream x, int length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType) {}

  @Override
  public void setObject(int parameterIndex, Object x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void addBatch() {
    LOG.finest("++enter++");
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
    LOG.finest("++enter++");
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
        throw new BigQueryJdbcRuntimeException(e);
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
        throw new BigQueryJdbcRuntimeException(ex);
      } catch (SQLException e) {
        throw new BigQueryJdbcException(e);
      }
    }
  }

  private long bulkInsertWithWriteAPI(BigQueryWriteClient bigQueryWriteClient)
      throws DescriptorValidationException,
          IOException,
          InterruptedException,
          BigQueryJdbcException {
    LOG.finest("++enter++");
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
            LOG.finest("Append called ");
            offset += jsonArray.size();
            jsonArray = new JsonArray();
          }
        } else {
          throw new BigQueryJdbcException("Mismatch between field count and parameter count.");
        }
      }
    } catch (BigQueryJdbcException e) {
      throw new RuntimeException(e);
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
    LOG.finest("Commit called.");
    return rowCount;
  }

  private void setInsertMetadata(QueryStatistics statistics) throws SQLException {
    LOG.finest("++enter++");
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
    LOG.finest(
        String.format(
            "this.insertTableName : %s, this.insertSchema : %s",
            this.insertTableName, this.insertSchema.toString()));
  }

  QueryJobConfiguration getWriteBatchJobConfiguration(
      ArrayList<BigQueryJdbcParameter> currentParameterList) throws SQLException {
    LOG.finest("++enter++");
    BigQueryParameterHandler batchHandler =
        new BigQueryParameterHandler(this.parameterCount, currentParameterList);
    QueryJobConfiguration.Builder jobConfiguration = getJobConfig(this.currentQuery);
    jobConfiguration.setParameterMode("POSITIONAL");
    jobConfiguration = batchHandler.configureParameters(jobConfiguration);
    return jobConfiguration.build();
  }

  QueryJobConfiguration getStandardBatchJobConfiguration(String query) throws SQLException {
    LOG.finest("++enter++");
    QueryJobConfiguration.Builder jobConfiguration = getJobConfig(query);
    jobConfiguration.setParameterMode("POSITIONAL");
    jobConfiguration.setPriority(QueryJobConfiguration.Priority.BATCH);
    int index = 0;
    while (!this.batchParameters.isEmpty()) {
      ArrayList<BigQueryJdbcParameter> parameterList = this.batchParameters.poll();

      for (BigQueryJdbcParameter parameter : parameterList) {
        Object parameterValue = parameter.getValue();
        StandardSQLTypeName sqlType = parameter.getSqlType();
        LOG.finest(
            String.format(
                "Parameter %s of type %s at index %s added to QueryJobConfiguration",
                parameterValue, sqlType, index++));
        jobConfiguration.addPositionalParameter(QueryParameterValue.of(parameterValue, sqlType));
      }
    }
    return jobConfiguration.build();
  }

  Boolean useWriteAPI() {
    LOG.finest("++enter++");
    if (this.querySettings.isUseWriteAPI()) {
      if (this.batchParameters.size() >= this.querySettings.getWriteAPIActivationRowCount()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, int length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setRef(int parameterIndex, Ref x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setBlob(int parameterIndex, Blob x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setClob(int parameterIndex, Clob x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setArray(int parameterIndex, Array x) {
    // TODO(neenu) :IMPLEMENT ARRAY
  }

  @Override
  public ResultSetMetaData getMetaData() {
    // TODO(neenu) :IMPLEMENT metadata
    return null;
  }

  @Override
  public void setDate(int parameterIndex, Date x, Calendar cal) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setTime(int parameterIndex, Time x, Calendar cal) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setURL(int parameterIndex, URL x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public ParameterMetaData getParameterMetaData() {
    // TODO(neenu) :IMPLEMENT
    return null;
  }

  @Override
  public void setRowId(int parameterIndex, RowId x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setNString(int parameterIndex, String value) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value, long length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setNClob(int parameterIndex, NClob value) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setClob(int parameterIndex, Reader reader, long length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream, long length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader, long length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setSQLXML(int parameterIndex, SQLXML xmlObject) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) {
    // TODO(neenu) : IMPLEMENT?
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream x, long length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream x, long length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, long length) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream x) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setClob(int parameterIndex, Reader reader) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream) {
    // TODO :NOT IMPLEMENTED
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader) {
    // TODO :NOT IMPLEMENTED
  }
}

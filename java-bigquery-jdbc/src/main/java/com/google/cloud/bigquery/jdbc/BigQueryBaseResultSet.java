/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryConversionException;
import com.google.cloud.bigquery.exception.BigQueryJdbcCoercionException;
import com.google.cloud.bigquery.exception.BigQueryJdbcCoercionNotFoundException;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public abstract class BigQueryBaseResultSet extends BigQueryNoOpsResultSet
    implements BigQueryResultSet {
  protected final BigQueryJdbcResultSetLogger LOG;
  private BigQuery bigQuery;
  private JobId jobId;
  private String queryId;
  private QueryStatistics queryStatistics;
  protected final BigQueryStatement statement;
  protected final Schema schema;
  protected final FieldList schemaFieldList;
  protected final boolean isNested;
  protected boolean isClosed = false;
  protected boolean wasNull = false;
  private int fetchSize = -1;
  private Job job;
  private SQLWarning warnings;
  private boolean warningsLoaded = false;
  protected final BigQueryTypeCoercer bigQueryTypeCoercer = BigQueryTypeCoercionUtility.INSTANCE;
  protected final SpanContext originalSpanContext;

  protected BigQueryBaseResultSet(
      BigQuery bigQuery, BigQueryStatement statement, Schema schema, boolean isNested) {
    this(bigQuery, statement, schema, isNested, null);
  }

  protected BigQueryBaseResultSet(
      BigQuery bigQuery, BigQueryStatement statement, Schema schema, boolean isNested, Job job) {
    this.bigQuery = bigQuery;
    this.statement = statement;
    this.schema = schema;
    this.schemaFieldList = schema != null ? schema.getFields() : null;
    this.isNested = isNested;
    this.originalSpanContext = Span.current().getSpanContext();
    this.job = job;
    if (job != null) {
      this.jobId = job.getJobId();
    }
    this.LOG =
        BigQueryJdbcResultSetLogger.getLogger(
            this.getClass(), statement != null ? statement.connectionId : null);
  }

  protected Scope makeOriginalContextCurrent() {
    return Context.current().with(Span.wrap(this.originalSpanContext)).makeCurrent();
  }

  public QueryStatistics getQueryStatistics() {
    if (queryStatistics != null) {
      return queryStatistics;
    }
    Job activeJob = this.job;
    if (activeJob == null && jobId != null && bigQuery != null) {
      this.job = bigQuery.getJob(jobId);
      activeJob = this.job;
    }
    queryStatistics = activeJob != null ? activeJob.getStatistics() : null;
    return queryStatistics;
  }

  public void setJobId(JobId jobId) {
    this.jobId = jobId;
  }

  public JobId getJobId() {
    return jobId;
  }

  public void setJob(Job job) {
    this.job = job;
    if (job != null) {
      this.jobId = job.getJobId();
    }
    this.queryStatistics = null;
    this.warnings = null;
    this.warningsLoaded = false;
  }

  public Job getJob() {
    return job;
  }

  public void setQueryId(String queryId) {
    this.queryId = queryId;
  }

  public String getQueryId() {
    return queryId;
  }

  @Override
  public void close() {
    try {
      if (statement != null && statement.isCloseOnCompletion() && !statement.hasMoreResults()) {
        statement.close();
      }
    } catch (SQLException ex) {
      LOG.warning("Exception during ResultState.close() operation: %s", ex.getMessage());
    }
  }

  protected SQLException logAndCreateException(SQLException ex) {
    if (this.statement == null) {
      return ex;
    }
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(this.statement.connectionId)) {
      LOG.severe(ex.getMessage(), ex);
    }
    return ex;
  }

  protected SQLException logAndCreateException(String message) {
    return logAndCreateException(new SQLException(message));
  }

  protected SQLException logAndCreateException(String message, Throwable cause) {
    return logAndCreateException(new SQLException(message, cause));
  }

  protected SQLException createCoercionException(
      int columnIndex, Class<?> targetClass, Exception cause) throws SQLException {
    checkClosed();
    StandardSQLTypeName type;
    String typeName;

    if (isNested) {
      if (columnIndex == 1) {
        return logAndCreateException(
            new BigQueryConversionException(
                String.format(
                    "Cannot convert index column to type %s.", targetClass.getSimpleName()),
                cause));
      } else if (columnIndex == 2) {
        Field arrayField = this.schema.getFields().get(0);
        type = arrayField.getType().getStandardType();
        typeName = type.name();
      } else {
        throw logAndCreateException(
            new SQLException(
                "For a nested ResultSet from an Array, columnIndex must be 1 or 2.", cause));
      }
    } else {
      Field field = this.schemaFieldList.get(columnIndex - 1);
      type = field.getType().getStandardType();
      typeName = type.name();
    }
    return logAndCreateException(
        new BigQueryConversionException(
            String.format(
                "Cannot convert value of type %s to type %s.",
                typeName, targetClass.getSimpleName()),
            cause));
  }

  private StandardSQLTypeName getStandardSQLTypeName(int columnIndex) throws SQLException {
    checkClosed();
    if (isNested) {
      if (columnIndex == 1) {
        return StandardSQLTypeName.INT64;
      } else if (columnIndex == 2) {
        if (this.schema == null || this.schema.getFields().isEmpty()) {
          throw logAndCreateException("Schema not available for nested result set.");
        }
        Field arrayField = this.schema.getFields().get(0);
        return arrayField.getType().getStandardType();
      } else {
        throw logAndCreateException(
            "For a nested ResultSet from an Array, columnIndex must be 1 or 2.");
      }
    } else {
      if (this.schemaFieldList == null
          || columnIndex > this.schemaFieldList.size()
          || columnIndex < 1) {
        throw logAndCreateException("Invalid column index: " + columnIndex);
      }
      Field field = this.schemaFieldList.get(columnIndex - 1);
      return field.getType().getStandardType();
    }
  }

  protected void setWasNull(Object val) {
    this.wasNull = val == null;
  }

  @Override
  public boolean wasNull() throws SQLException {
    checkClosed();
    return this.wasNull;
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    checkClosed();
    String connectionId = this.statement != null ? this.statement.connectionId : null;
    ResultSetMetaData metaData;
    try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(connectionId)) {
      if (this.isNested) {
        metaData = BigQueryResultSetMetadata.of(this.schemaFieldList, this.statement);
      } else {
        metaData = BigQueryResultSetMetadata.of(this.schema.getFields(), this.statement);
      }
    }
    return BigQueryJdbcContextProxy.wrap(metaData, ResultSetMetaData.class, connectionId);
  }

  @Override
  public int getType() throws SQLException {
    checkClosed();
    return ResultSet.TYPE_FORWARD_ONLY;
  }

  @Override
  public int getConcurrency() throws SQLException {
    checkClosed();
    return ResultSet.CONCUR_READ_ONLY;
  }

  @Override
  public Statement getStatement() throws SQLException {
    checkClosed();
    return this.statement;
  }

  @Override
  public int getHoldability() throws SQLException {
    checkClosed();
    return ResultSet.HOLD_CURSORS_OVER_COMMIT;
  }

  @Override
  public boolean isClosed() {
    return this.isClosed;
  }

  public abstract Object getObject(int columnIndex) throws SQLException;

  @Override
  public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
    LOG.finestTrace("getObject");
    try {
      Object value = getObject(columnIndex);
      if (value == null) {
        return null;
      }
      return this.bigQueryTypeCoercer.coerceTo(type, value, this.LOG);
    } catch (RuntimeException e) {
      throw createCoercionException(columnIndex, type, e);
    }
  }

  @Override
  public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
    return getObject(getColumnIndex(columnLabel), type);
  }

  protected int getColumnIndex(String columnLabel) throws SQLException {
    LOG.finestTrace("getColumnIndex");
    checkClosed();
    if (columnLabel == null) {
      throw logAndCreateException("Column label cannot be null");
    }
    // use schema to get the column index, add 1 for SQL index
    return this.schemaFieldList.getIndex(columnLabel) + 1;
  }

  @Override
  public String getString(int columnIndex) throws SQLException {
    LOG.finestTrace("getString");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(String.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, String.class, e);
    }
  }

  @Override
  public boolean getBoolean(int columnIndex) throws SQLException {
    LOG.finestTrace("getBoolean");

    StandardSQLTypeName type = getStandardSQLTypeName(columnIndex);
    if (type == StandardSQLTypeName.GEOGRAPHY
        || type == StandardSQLTypeName.RANGE
        || type == StandardSQLTypeName.JSON) {
      throw createCoercionException(columnIndex, Boolean.class, null);
    }

    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Boolean.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, Boolean.class, e);
    }
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    LOG.finestTrace("getByte");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Byte.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Byte.class, e);
    }
  }

  @Override
  public short getShort(int columnIndex) throws SQLException {
    LOG.finestTrace("getShort");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Short.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Short.class, e);
    }
  }

  @Override
  public int getInt(int columnIndex) throws SQLException {
    LOG.finestTrace("getInt");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Integer.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Integer.class, e);
    }
  }

  @Override
  public long getLong(int columnIndex) throws SQLException {
    LOG.finestTrace("getLong");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Long.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Long.class, e);
    }
  }

  @Override
  public float getFloat(int columnIndex) throws SQLException {
    LOG.finestTrace("getFloat");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Float.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Float.class, e);
    }
  }

  @Override
  public double getDouble(int columnIndex) throws SQLException {
    LOG.finestTrace("getDouble");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Double.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Double.class, e);
    }
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    LOG.finestTrace("getBigDecimal");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(BigDecimal.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, BigDecimal.class, e);
    }
  }

  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    LOG.finestTrace("getBytes");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(byte[].class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, byte[].class, e);
    }
  }

  @Override
  public Date getDate(int columnIndex) throws SQLException {
    LOG.finestTrace("getDate");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(java.sql.Date.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, java.sql.Date.class, e);
    }
  }

  @Override
  public Time getTime(int columnIndex) throws SQLException {
    LOG.finestTrace("getTime");
    StandardSQLTypeName type = getStandardSQLTypeName(columnIndex);
    if (type == StandardSQLTypeName.INT64) {
      throw createCoercionException(columnIndex, java.sql.Time.class, null);
    }
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(java.sql.Time.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, java.sql.Time.class, e);
    }
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    LOG.finestTrace("getTimestamp");
    StandardSQLTypeName type = getStandardSQLTypeName(columnIndex);
    if (type == StandardSQLTypeName.INT64) {
      throw createCoercionException(columnIndex, java.sql.Timestamp.class, null);
    }
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(java.sql.Timestamp.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, java.sql.Timestamp.class, e);
    }
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    LOG.finestTrace("getBigDecimal");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(BigDecimal.class, value, this.LOG);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, BigDecimal.class, e);
    }
  }

  @Override
  public Array getArray(int columnIndex) throws SQLException {
    LOG.finestTrace("getArray");
    try {
      return (Array) getObject(columnIndex);
    } catch (ClassCastException e) {
      throw createCoercionException(columnIndex, Array.class, e);
    }
  }

  @Override
  public Blob getBlob(int columnIndex) throws SQLException {
    LOG.finestTrace("getBlob");
    byte[] value = getBytes(columnIndex);
    return new javax.sql.rowset.serial.SerialBlob(value);
  }

  @Override
  public Clob getClob(int columnIndex) throws SQLException {
    LOG.finestTrace("getClob");
    String value = getString(columnIndex);
    return new javax.sql.rowset.serial.SerialClob(value.toCharArray());
  }

  @Override
  public Reader getCharacterStream(int columnIndex) throws SQLException {
    LOG.finestTrace("getCharacterStream");
    String value = getString(columnIndex);
    return value == null ? null : new StringReader(value);
  }

  private InputStream getInputStream(String value, java.nio.charset.Charset charset) {
    LOG.finestTrace("getInputStream");
    if (value == null) {
      return null;
    }
    return new java.io.ByteArrayInputStream(value.getBytes(charset));
  }

  @Override
  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    LOG.finestTrace("getAsciiStream");
    return getInputStream(getString(columnIndex), StandardCharsets.US_ASCII);
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    LOG.finestTrace("getUnicodeStream");
    return getInputStream(getString(columnIndex), StandardCharsets.UTF_16LE);
  }

  @Override
  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    LOG.finestTrace("getBinaryStream");
    byte[] bytes = getBytes(columnIndex);
    return bytes == null ? null : new java.io.ByteArrayInputStream(bytes);
  }

  @Override
  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    LOG.finestTrace("getDate");
    Date date = getDate(columnIndex);
    return BigQueryTypeCoercionUtility.convertDateWithCalendar(date, cal);
  }

  @Override
  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    LOG.finestTrace("getTime");
    Time time = getTime(columnIndex);
    return BigQueryTypeCoercionUtility.convertTimeWithCalendar(time, cal);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    LOG.finestTrace("getTimestamp");
    Timestamp timestamp = getTimestamp(columnIndex);
    return BigQueryTypeCoercionUtility.convertTimestampWithCalendar(timestamp, cal);
  }

  @Override
  public int findColumn(String columnLabel) throws SQLException {
    LOG.finestTrace("findColumn");
    return getColumnIndex(columnLabel);
  }

  @Override
  public Object getObject(String columnLabel) throws SQLException {
    return getObject(getColumnIndex(columnLabel));
  }

  @Override
  public String getString(String columnLabel) throws SQLException {
    return getString(getColumnIndex(columnLabel));
  }

  @Override
  public boolean getBoolean(String columnLabel) throws SQLException {
    return getBoolean(getColumnIndex(columnLabel));
  }

  @Override
  public byte getByte(String columnLabel) throws SQLException {
    return getByte(getColumnIndex(columnLabel));
  }

  @Override
  public short getShort(String columnLabel) throws SQLException {
    return getShort(getColumnIndex(columnLabel));
  }

  @Override
  public int getInt(String columnLabel) throws SQLException {
    return getInt(getColumnIndex(columnLabel));
  }

  @Override
  public long getLong(String columnLabel) throws SQLException {
    return getLong(getColumnIndex(columnLabel));
  }

  @Override
  public float getFloat(String columnLabel) throws SQLException {
    return getFloat(getColumnIndex(columnLabel));
  }

  @Override
  public double getDouble(String columnLabel) throws SQLException {
    return getDouble(getColumnIndex(columnLabel));
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    return getBigDecimal(getColumnIndex(columnLabel), scale);
  }

  @Override
  public byte[] getBytes(String columnLabel) throws SQLException {
    return getBytes(getColumnIndex(columnLabel));
  }

  @Override
  public Date getDate(String columnLabel) throws SQLException {
    return getDate(getColumnIndex(columnLabel));
  }

  @Override
  public Time getTime(String columnLabel) throws SQLException {
    return getTime(getColumnIndex(columnLabel));
  }

  @Override
  public Timestamp getTimestamp(String columnLabel) throws SQLException {
    return getTimestamp(getColumnIndex(columnLabel));
  }

  @Override
  public InputStream getAsciiStream(String columnLabel) throws SQLException {
    return getAsciiStream(getColumnIndex(columnLabel));
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public InputStream getUnicodeStream(String columnLabel) throws SQLException {
    return getUnicodeStream(getColumnIndex(columnLabel));
  }

  @Override
  public InputStream getBinaryStream(String columnLabel) throws SQLException {
    return getBinaryStream(getColumnIndex(columnLabel));
  }

  @Override
  public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    return getBigDecimal(getColumnIndex(columnLabel));
  }

  @Override
  public Blob getBlob(String columnLabel) throws SQLException {
    return getBlob(getColumnIndex(columnLabel));
  }

  @Override
  public Clob getClob(String columnLabel) throws SQLException {
    return getClob(getColumnIndex(columnLabel));
  }

  @Override
  public Array getArray(String columnLabel) throws SQLException {
    return getArray(getColumnIndex(columnLabel));
  }

  @Override
  public Reader getCharacterStream(String columnLabel) throws SQLException {
    return getCharacterStream(getColumnIndex(columnLabel));
  }

  @Override
  public Date getDate(String columnLabel, Calendar cal) throws SQLException {
    return getDate(getColumnIndex(columnLabel), cal);
  }

  @Override
  public Time getTime(String columnLabel, Calendar cal) throws SQLException {
    return getTime(getColumnIndex(columnLabel), cal);
  }

  @Override
  public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
    return getTimestamp(getColumnIndex(columnLabel), cal);
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    throw new BigQueryJdbcException("Cannot unwrap to " + iface.getName());
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return iface != null && iface.isInstance(this);
  }

  @Override
  public int getFetchDirection() throws SQLException {
    checkClosed();
    // Fetch direction is restricted to forward-only.
    return ResultSet.FETCH_FORWARD;
  }

  @Override
  public void setFetchDirection(int direction) throws SQLException {
    checkClosed();
    // Restricts the fetch direction to FETCH_FORWARD. Other directions are not supported.
    if (direction != ResultSet.FETCH_FORWARD) {
      throw new SQLException("Only FETCH_FORWARD is supported");
    }
  }

  @Override
  public void setFetchSize(int rows) throws SQLException {
    checkClosed();
    if (rows < 0) {
      throw new SQLException("Fetch size must be >= 0");
    }
    // This is a no-op placeholder for JDBC API compliance to prevent crashes in
    // third-party client tools that call this automatically.
    // The driver manages pagination internally under the hood.
    this.fetchSize = rows;
  }

  @Override
  public int getFetchSize() throws SQLException {
    checkClosed();
    // Returns the fetch size set on this ResultSet, or falls back to the statement's
    // fetch size, defaulting to the internal row buffer size of
    // BigQueryStatement.DEFAULT_BUFFER_SIZE.
    if (this.fetchSize > 0) {
      return this.fetchSize;
    }
    if (statement != null) {
      int statementFetchSize = statement.getFetchSize();
      if (statementFetchSize > 0) {
        return statementFetchSize;
      }
    }
    return BigQueryStatement.DEFAULT_BUFFER_SIZE;
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    checkClosed();
    // Dynamically fetches and chains non-fatal execution errors from the BigQuery Job
    // as SQLWarning objects, using lazy-loading and local caching for performance.
    if (warningsLoaded) {
      return warnings;
    }
    Job activeJob = this.job;
    if (activeJob == null && jobId != null && bigQuery != null) {
      try {
        this.job = bigQuery.getJob(jobId);
        activeJob = this.job;
      } catch (BigQueryException e) {
        throw new BigQueryJdbcException("Failed to retrieve job for warnings", e);
      }
    }
    if (activeJob != null
        && activeJob.getStatus() != null
        && activeJob.getStatus().getExecutionErrors() != null) {
      List<BigQueryError> errors = activeJob.getStatus().getExecutionErrors();
      SQLWarning head = null;
      SQLWarning tail = null;
      for (BigQueryError error : errors) {
        SQLWarning warning = new SQLWarning(error.getMessage(), error.getReason());
        if (head == null) {
          head = warning;
          tail = warning;
        } else {
          tail.setNextWarning(warning);
          tail = warning;
        }
      }
      this.warnings = head;
    }
    this.warningsLoaded = true;
    return warnings;
  }

  @Override
  public void clearWarnings() throws SQLException {
    checkClosed();
    // Clears the cached warnings chain.
    this.warnings = null;
    this.warningsLoaded = true;
  }
}

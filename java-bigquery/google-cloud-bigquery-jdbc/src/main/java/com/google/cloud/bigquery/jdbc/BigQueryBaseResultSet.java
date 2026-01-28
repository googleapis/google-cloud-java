/*
 * Copyright 2026 Google LLC
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
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public abstract class BigQueryBaseResultSet extends BigQueryNoOpsResultSet
    implements BigQueryResultSet {
  protected final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
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
  protected final BigQueryTypeCoercer bigQueryTypeCoercer = BigQueryTypeCoercionUtility.INSTANCE;

  protected BigQueryBaseResultSet(
      BigQuery bigQuery, BigQueryStatement statement, Schema schema, boolean isNested) {
    this.bigQuery = bigQuery;
    this.statement = statement;
    this.schema = schema;
    this.schemaFieldList = schema != null ? schema.getFields() : null;
    this.isNested = isNested;
  }

  public QueryStatistics getQueryStatistics() {
    if (queryStatistics != null) {
      return queryStatistics;
    }
    if (jobId == null || bigQuery == null) {
      return null;
    }
    Job job = bigQuery.getJob(jobId);
    queryStatistics = job != null ? job.getStatistics() : null;
    return queryStatistics;
  }

  public void setJobId(JobId jobId) {
    this.jobId = jobId;
  }

  public JobId getJobId() {
    return jobId;
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
      LOG.warning(
          String.format("Exception during ResultState.close() operation: %s", ex.getMessage()));
    }
  }

  protected SQLException createCoercionException(
      int columnIndex, Class<?> targetClass, Exception cause) throws SQLException {
    checkClosed();
    StandardSQLTypeName type;
    String typeName;

    if (isNested) {
      if (columnIndex == 1) {
        return new BigQueryConversionException(
            String.format("Cannot convert index column to type %s.", targetClass.getSimpleName()),
            cause);
      } else if (columnIndex == 2) {
        Field arrayField = this.schema.getFields().get(0);
        type = arrayField.getType().getStandardType();
        typeName = type.name();
      } else {
        throw new SQLException(
            "For a nested ResultSet from an Array, columnIndex must be 1 or 2.", cause);
      }
    } else {
      Field field = this.schemaFieldList.get(columnIndex - 1);
      type = field.getType().getStandardType();
      typeName = type.name();
    }
    return new BigQueryConversionException(
        String.format(
            "Cannot convert value of type %s to type %s.", typeName, targetClass.getSimpleName()),
        cause);
  }

  private StandardSQLTypeName getStandardSQLTypeName(int columnIndex) throws SQLException {
    checkClosed();
    if (isNested) {
      if (columnIndex == 1) {
        return StandardSQLTypeName.INT64;
      } else if (columnIndex == 2) {
        if (this.schema == null || this.schema.getFields().isEmpty()) {
          throw new SQLException("Schema not available for nested result set.");
        }
        Field arrayField = this.schema.getFields().get(0);
        return arrayField.getType().getStandardType();
      } else {
        throw new SQLException("For a nested ResultSet from an Array, columnIndex must be 1 or 2.");
      }
    } else {
      if (this.schemaFieldList == null
          || columnIndex > this.schemaFieldList.size()
          || columnIndex < 1) {
        throw new SQLException("Invalid column index: " + columnIndex);
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
    if (this.isNested) {
      return BigQueryResultSetMetadata.of(this.schemaFieldList, this.statement);
    } else {
      return BigQueryResultSetMetadata.of(this.schema.getFields(), this.statement);
    }
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

  protected int getColumnIndex(String columnLabel) throws SQLException {
    LOG.finest("++enter++");
    checkClosed();
    if (columnLabel == null) {
      throw new SQLException("Column label cannot be null");
    }
    // use schema to get the column index, add 1 for SQL index
    return this.schemaFieldList.getIndex(columnLabel) + 1;
  }

  @Override
  public String getString(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(String.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, String.class, e);
    }
  }

  @Override
  public boolean getBoolean(int columnIndex) throws SQLException {
    LOG.finest("++enter++");

    StandardSQLTypeName type = getStandardSQLTypeName(columnIndex);
    if (type == StandardSQLTypeName.GEOGRAPHY
        || type == StandardSQLTypeName.RANGE
        || type == StandardSQLTypeName.JSON) {
      throw createCoercionException(columnIndex, Boolean.class, null);
    }

    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Boolean.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, Boolean.class, e);
    }
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Byte.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Byte.class, e);
    }
  }

  @Override
  public short getShort(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Short.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Short.class, e);
    }
  }

  @Override
  public int getInt(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Integer.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Integer.class, e);
    }
  }

  @Override
  public long getLong(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Long.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Long.class, e);
    }
  }

  @Override
  public float getFloat(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Float.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Float.class, e);
    }
  }

  @Override
  public double getDouble(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(Double.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, Double.class, e);
    }
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(BigDecimal.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, BigDecimal.class, e);
    }
  }

  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(byte[].class, value);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, byte[].class, e);
    }
  }

  @Override
  public Date getDate(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(java.sql.Date.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, java.sql.Date.class, e);
    }
  }

  @Override
  public Time getTime(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    StandardSQLTypeName type = getStandardSQLTypeName(columnIndex);
    if (type == StandardSQLTypeName.INT64) {
      throw createCoercionException(columnIndex, java.sql.Time.class, null);
    }
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(java.sql.Time.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, java.sql.Time.class, e);
    }
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    StandardSQLTypeName type = getStandardSQLTypeName(columnIndex);
    if (type == StandardSQLTypeName.INT64) {
      throw createCoercionException(columnIndex, java.sql.Timestamp.class, null);
    }
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(java.sql.Timestamp.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException e) {
      throw createCoercionException(columnIndex, java.sql.Timestamp.class, e);
    }
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      Object value = getObject(columnIndex);
      return this.bigQueryTypeCoercer.coerceTo(BigDecimal.class, value);
    } catch (BigQueryJdbcCoercionNotFoundException | BigQueryJdbcCoercionException e) {
      throw createCoercionException(columnIndex, BigDecimal.class, e);
    }
  }

  @Override
  public Array getArray(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    try {
      return (Array) getObject(columnIndex);
    } catch (ClassCastException e) {
      throw createCoercionException(columnIndex, Array.class, e);
    }
  }

  @Override
  public Blob getBlob(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    byte[] value = getBytes(columnIndex);
    return new javax.sql.rowset.serial.SerialBlob(value);
  }

  @Override
  public Clob getClob(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    String value = getString(columnIndex);
    return new javax.sql.rowset.serial.SerialClob(value.toCharArray());
  }

  @Override
  public Reader getCharacterStream(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    String value = getString(columnIndex);
    return value == null ? null : new StringReader(value);
  }

  private InputStream getInputStream(String value, java.nio.charset.Charset charset) {
    LOG.finest("++enter++");
    if (value == null) {
      return null;
    }
    return new java.io.ByteArrayInputStream(value.getBytes(charset));
  }

  @Override
  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    return getInputStream(getString(columnIndex), StandardCharsets.US_ASCII);
  }

  @Override
  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    return getInputStream(getString(columnIndex), StandardCharsets.UTF_16LE);
  }

  @Override
  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    LOG.finest("++enter++");
    byte[] bytes = getBytes(columnIndex);
    return bytes == null ? null : new java.io.ByteArrayInputStream(bytes);
  }

  @Override
  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    LOG.finest("++enter++");
    Date date = getDate(columnIndex);
    if (date == null || cal == null) {
      return null;
    }
    cal.setTimeInMillis(date.getTime());
    return new java.sql.Date(cal.getTimeInMillis());
  }

  @Override
  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    LOG.finest("++enter++");
    Time time = getTime(columnIndex);
    if (time == null || cal == null) {
      return null;
    }
    cal.setTimeInMillis(time.getTime());
    return new java.sql.Time(cal.getTimeInMillis());
  }

  @Override
  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    LOG.finest("++enter++");
    Timestamp timeStamp = getTimestamp(columnIndex);
    if (timeStamp == null || cal == null) {
      return null;
    }
    cal.setTimeInMillis(timeStamp.getTime());
    return new java.sql.Timestamp(cal.getTimeInMillis());
  }

  @Override
  public int findColumn(String columnLabel) throws SQLException {
    LOG.finest("++enter++");
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
}

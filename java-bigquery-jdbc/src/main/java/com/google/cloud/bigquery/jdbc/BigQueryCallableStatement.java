/*
 * Copyright 2025 Google LLC
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

import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import com.google.common.annotations.VisibleForTesting;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.Map;

class BigQueryCallableStatement extends BigQueryPreparedStatement implements CallableStatement {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private boolean lastReadWasNull = false;

  BigQueryCallableStatement(BigQueryConnection connection, String callableStmtSql)
      throws SQLException {
    super(connection, callableStmtSql);
  }

  @VisibleForTesting
  protected String getCallableStatementSql() {
    return this.currentQuery;
  }

  @VisibleForTesting
  protected BigQueryParameterHandler getParameterHandler() {
    return this.parameterHandler;
  }

  @Override
  public Array getArray(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Array) {
      return (Array) param;
    }
    return getObject(parameterIndex, Array.class);
  }

  @Override
  public Array getArray(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Array) {
      return (Array) param;
    }
    return getObject(parameterName, Array.class);
  }

  @Override
  public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof BigDecimal) {
      return (BigDecimal) param;
    }
    return getObject(parameterIndex, BigDecimal.class);
  }

  @Override
  public BigDecimal getBigDecimal(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof BigDecimal) {
      return (BigDecimal) param;
    }
    return getObject(parameterName, BigDecimal.class);
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public BigDecimal getBigDecimal(int parameterIndex, int scale) throws SQLException {
    return getBigDecimal(parameterIndex);
  }

  @Override
  public Blob getBlob(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Blob) {
      return (Blob) param;
    }
    return getObject(parameterIndex, Blob.class);
  }

  @Override
  public Blob getBlob(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Blob) {
      return (Blob) param;
    }
    return getObject(parameterName, Blob.class);
  }

  @Override
  public boolean getBoolean(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Boolean) {
      return (Boolean) param;
    }
    Boolean result = getObject(parameterIndex, Boolean.class);
    return result != null && result;
  }

  @Override
  public boolean getBoolean(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Boolean) {
      return (Boolean) param;
    }
    Boolean result = getObject(parameterName, Boolean.class);
    return result != null && result;
  }

  @Override
  public byte getByte(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Byte) {
      return (Byte) param;
    }
    if (param instanceof Number) {
      return ((Number) param).byteValue();
    }
    Byte result = getObject(parameterIndex, Byte.class);
    return result != null ? result : -1;
  }

  @Override
  public byte getByte(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Byte) {
      return (Byte) param;
    }
    if (param instanceof Number) {
      return ((Number) param).byteValue();
    }
    Byte result = getObject(parameterName, Byte.class);
    return result != null ? result : -1;
  }

  @Override
  public byte[] getBytes(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof byte[]) {
      return (byte[]) param;
    }
    if (param instanceof String) {
      return param.toString().getBytes();
    }
    return getObject(parameterIndex, byte[].class);
  }

  @Override
  public byte[] getBytes(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof byte[]) {
      return (byte[]) param;
    }
    if (param instanceof String) {
      return param.toString().getBytes();
    }
    return getObject(parameterName, byte[].class);
  }

  @Override
  public Reader getCharacterStream(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Reader) {
      return (Reader) param;
    }
    if (param instanceof String) {
      return new StringReader((String) param);
    }
    return getObject(parameterIndex, Reader.class);
  }

  @Override
  public Reader getCharacterStream(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Reader) {
      return (Reader) param;
    }
    if (param instanceof String) {
      return new StringReader((String) param);
    }
    return getObject(parameterName, Reader.class);
  }

  @Override
  public Clob getClob(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Clob) {
      return (Clob) param;
    }
    return getObject(parameterIndex, Clob.class);
  }

  @Override
  public Clob getClob(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Clob) {
      return (Clob) param;
    }
    return getObject(parameterName, Clob.class);
  }

  @Override
  public Date getDate(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Date) {
      return (Date) param;
    }
    if (param instanceof java.util.Date) {
      return new Date(((java.util.Date) param).getTime());
    }
    return getObject(parameterIndex, Date.class);
  }

  @Override
  public Date getDate(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Date) {
      return (Date) param;
    }
    if (param instanceof java.util.Date) {
      return new Date(((java.util.Date) param).getTime());
    }
    return getObject(parameterName, Date.class);
  }

  @Override
  public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
    checkClosed();
    Date date = getDate(parameterIndex);
    this.lastReadWasNull = (date == null);
    return BigQueryTypeCoercionUtility.convertDateWithCalendar(date, cal);
  }

  @Override
  public Date getDate(String parameterName, Calendar cal) throws SQLException {
    checkClosed();
    Date date = getDate(parameterName);
    this.lastReadWasNull = (date == null);
    return BigQueryTypeCoercionUtility.convertDateWithCalendar(date, cal);
  }

  @Override
  public double getDouble(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Double) {
      return (Double) param;
    }
    if (param instanceof Number) {
      return ((Number) param).doubleValue();
    }
    Double result = getObject(parameterIndex, Double.class);
    return result != null ? result : 0;
  }

  @Override
  public double getDouble(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Double) {
      return (Double) param;
    }
    if (param instanceof Number) {
      return ((Number) param).doubleValue();
    }
    Double result = getObject(parameterName, Double.class);
    return result != null ? result : 0;
  }

  @Override
  public float getFloat(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Float) {
      return (Float) param;
    }
    if (param instanceof Number) {
      return ((Number) param).floatValue();
    }
    Float result = getObject(parameterIndex, Float.class);
    return result != null ? result : 0;
  }

  @Override
  public float getFloat(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Float) {
      return (Float) param;
    }
    if (param instanceof Number) {
      return ((Number) param).floatValue();
    }
    Float result = getObject(parameterName, Float.class);
    return result != null ? result : 0;
  }

  @Override
  public int getInt(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Integer) {
      return (Integer) param;
    }
    if (param instanceof Number) {
      return ((Number) param).intValue();
    }
    Integer result = getObject(parameterIndex, Integer.class);
    return result != null ? result : 0;
  }

  @Override
  public int getInt(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Integer) {
      return (Integer) param;
    }
    if (param instanceof Number) {
      return ((Number) param).intValue();
    }
    Integer result = getObject(parameterName, Integer.class);
    return result != null ? result : 0;
  }

  @Override
  public long getLong(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Long) {
      return (Long) param;
    }
    if (param instanceof Number) {
      return ((Number) param).longValue();
    }
    Long result = getObject(parameterIndex, Long.class);
    return result != null ? result : 0;
  }

  @Override
  public long getLong(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Long) {
      return (Long) param;
    }
    if (param instanceof Number) {
      return ((Number) param).longValue();
    }
    Long result = getObject(parameterName, Long.class);
    return result != null ? result : 0;
  }

  @Override
  public Reader getNCharacterStream(int parameterIndex) throws SQLException {
    return getCharacterStream(parameterIndex);
  }

  @Override
  public Reader getNCharacterStream(String parameterName) throws SQLException {
    return getCharacterStream(parameterName);
  }

  @Override
  public NClob getNClob(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof NClob) {
      return (NClob) param;
    }
    return getObject(parameterIndex, NClob.class);
  }

  @Override
  public NClob getNClob(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof NClob) {
      return (NClob) param;
    }
    return getObject(parameterName, NClob.class);
  }

  @Override
  public String getNString(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof String) {
      return param.toString();
    }
    return getObject(parameterIndex, String.class);
  }

  @Override
  public String getNString(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof String) {
      return param.toString();
    }
    return getObject(parameterName, String.class);
  }

  @Override
  public Object getObject(int parameterIndex) throws SQLException {
    checkClosed();
    Object value = this.parameterHandler.getParameter(parameterIndex);
    this.lastReadWasNull = (value == null);
    return value;
  }

  @Override
  public Object getObject(String parameterName) throws SQLException {
    checkClosed();
    Object value = this.parameterHandler.getParameter(parameterName);
    this.lastReadWasNull = (value == null);
    return value;
  }

  @Override
  public Object getObject(int parameterIndex, Map<String, Class<?>> map) throws SQLException {
    checkClosed();
    if (map != null && !map.isEmpty()) {
      StandardSQLTypeName sqlType = this.parameterHandler.getSqlType(parameterIndex);
      if (sqlType != null && map.containsKey(sqlType.name())) {
        Class<?> targetClass = map.get(sqlType.name());
        Object value = getObject(parameterIndex);
        if (value != null && targetClass != null && !targetClass.isInstance(value)) {
          throw new BigQueryJdbcException(
              String.format(
                  "Cannot map parameter %d of type %s to requested class %s in type map",
                  parameterIndex, value.getClass().getName(), targetClass.getName()));
        }
        return value;
      }
    }
    return getObject(parameterIndex);
  }

  @Override
  public Object getObject(String parameterName, Map<String, Class<?>> map) throws SQLException {
    checkClosed();
    if (map != null && !map.isEmpty()) {
      StandardSQLTypeName sqlType = this.parameterHandler.getSqlType(parameterName);
      if (sqlType != null && map.containsKey(sqlType.name())) {
        Class<?> targetClass = map.get(sqlType.name());
        Object value = getObject(parameterName);
        if (value != null && targetClass != null && !targetClass.isInstance(value)) {
          throw new BigQueryJdbcException(
              String.format(
                  "Cannot map parameter '%s' of type %s to requested class %s in type map",
                  parameterName, value.getClass().getName(), targetClass.getName()));
        }
        return value;
      }
    }
    return getObject(parameterName);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    checkClosed();
    if (type == null) {
      throw new BigQueryJdbcException("Type cannot be null.");
    }
    Object value = this.parameterHandler.getParameter(parameterIndex);
    this.lastReadWasNull = (value == null);
    if (value == null) {
      return null;
    }
    if (type.isInstance(value)) {
      return (T) value;
    }
    Class<?> javaType = this.parameterHandler.getType(parameterIndex);
    if (javaType != null && type.isAssignableFrom(javaType)) {
      return (T) value;
    }
    return null;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    checkClosed();
    if (type == null) {
      throw new BigQueryJdbcException("Type cannot be null.");
    }
    Object value = this.parameterHandler.getParameter(parameterName);
    this.lastReadWasNull = (value == null);
    if (value == null) {
      return null;
    }
    if (type.isInstance(value)) {
      return (T) value;
    }
    Class<?> javaType = this.parameterHandler.getType(parameterName);
    if (javaType != null && type.isAssignableFrom(javaType)) {
      return (T) value;
    }
    return null;
  }

  @Override
  public Ref getRef(int parameterIndex) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public Ref getRef(String parameterName) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public RowId getRowId(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof RowId) {
      return (RowId) param;
    }
    return getObject(parameterIndex, RowId.class);
  }

  @Override
  public RowId getRowId(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof RowId) {
      return (RowId) param;
    }
    return getObject(parameterName, RowId.class);
  }

  @Override
  public SQLXML getSQLXML(int parameterIndex) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public SQLXML getSQLXML(String parameterName) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public short getShort(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Short) {
      return (Short) param;
    }
    if (param instanceof Number) {
      return ((Number) param).shortValue();
    }
    Short result = getObject(parameterIndex, Short.class);
    return result != null ? result : 0;
  }

  @Override
  public short getShort(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Short) {
      return (Short) param;
    }
    if (param instanceof Number) {
      return ((Number) param).shortValue();
    }
    Short result = getObject(parameterName, Short.class);
    return result != null ? result : 0;
  }

  @Override
  public String getString(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof String) {
      return param.toString();
    }
    return getObject(parameterIndex, String.class);
  }

  @Override
  public String getString(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof String) {
      return param.toString();
    }
    return getObject(parameterName, String.class);
  }

  @Override
  public Time getTime(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Time) {
      return (Time) param;
    }
    if (param instanceof java.util.Date) {
      return new Time(((java.util.Date) param).getTime());
    }
    return getObject(parameterIndex, Time.class);
  }

  @Override
  public Time getTime(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Time) {
      return (Time) param;
    }
    if (param instanceof java.util.Date) {
      return new Time(((java.util.Date) param).getTime());
    }
    return getObject(parameterName, Time.class);
  }

  @Override
  public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
    checkClosed();
    Time time = getTime(parameterIndex);
    this.lastReadWasNull = (time == null);
    return BigQueryTypeCoercionUtility.convertTimeWithCalendar(time, cal);
  }

  @Override
  public Time getTime(String parameterName, Calendar cal) throws SQLException {
    checkClosed();
    Time time = getTime(parameterName);
    this.lastReadWasNull = (time == null);
    return BigQueryTypeCoercionUtility.convertTimeWithCalendar(time, cal);
  }

  @Override
  public Timestamp getTimestamp(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof Timestamp) {
      return (Timestamp) param;
    }
    if (param instanceof java.util.Date) {
      return new Timestamp(((java.util.Date) param).getTime());
    }
    return getObject(parameterIndex, Timestamp.class);
  }

  @Override
  public Timestamp getTimestamp(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof Timestamp) {
      return (Timestamp) param;
    }
    if (param instanceof java.util.Date) {
      return new Timestamp(((java.util.Date) param).getTime());
    }
    return getObject(parameterName, Timestamp.class);
  }

  @Override
  public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException {
    checkClosed();
    Timestamp ts = getTimestamp(parameterIndex);
    this.lastReadWasNull = (ts == null);
    return BigQueryTypeCoercionUtility.convertTimestampWithCalendar(ts, cal);
  }

  @Override
  public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {
    checkClosed();
    Timestamp ts = getTimestamp(parameterName);
    this.lastReadWasNull = (ts == null);
    return BigQueryTypeCoercionUtility.convertTimestampWithCalendar(ts, cal);
  }

  @Override
  public URL getURL(int parameterIndex) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterIndex);
    if (param instanceof URL) {
      return (URL) param;
    }
    return getObject(parameterIndex, URL.class);
  }

  @Override
  public URL getURL(String parameterName) throws SQLException {
    Object param = this.parameterHandler.getParameter(parameterName);
    if (param instanceof URL) {
      return (URL) param;
    }
    return getObject(parameterName, URL.class);
  }

  @Override
  public void registerOutParameter(int paramIndex, int sqlType) throws SQLException {
    LOG.finer("registerOutParameter: paramIndex %s, sqlType %s", paramIndex, sqlType);
    checkClosed();
    try {
      this.parameterHandler.setParameter(
          paramIndex,
          null,
          BigQueryJdbcTypeMappings.getJavaType(sqlType),
          BigQueryParameterHandler.BigQueryStatementParameterType.OUT,
          -1);
    } catch (Exception e) {
      SQLException ex = new SQLException(e);
      LOG.severe("Failed to registerOutParameter", ex);
      throw ex;
    }
  }

  @Override
  public void registerOutParameter(String paramName, int sqlType) throws SQLException {
    LOG.finer("registerOutParameter: paramName %s, sqlType %s", paramName, sqlType);
    checkClosed();
    try {
      this.parameterHandler.setParameter(
          paramName,
          null,
          BigQueryJdbcTypeMappings.getJavaType(sqlType),
          BigQueryParameterHandler.BigQueryStatementParameterType.OUT,
          -1);
    } catch (Exception e) {
      SQLException ex = new SQLException(e);
      LOG.severe("Failed to registerOutParameter", ex);
      throw ex;
    }
  }

  @Override
  public void registerOutParameter(int paramIndex, int sqlType, int scale) throws SQLException {
    LOG.finer(
        "registerOutParameter: paramIndex %s, sqlType %s, scale %s", paramIndex, sqlType, scale);
    checkClosed();
    if (sqlType != Types.NUMERIC && sqlType != Types.DECIMAL) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              String.format("registerOutParameter: Invalid sqlType passed in %s", sqlType));
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    try {
      this.parameterHandler.setParameter(
          paramIndex,
          null,
          BigQueryJdbcTypeMappings.getJavaType(sqlType),
          BigQueryParameterHandler.BigQueryStatementParameterType.OUT,
          scale);
    } catch (Exception e) {
      SQLException ex = new SQLException(e);
      LOG.severe("Failed to registerOutParameter", ex);
      throw ex;
    }
  }

  @Override
  public void registerOutParameter(int paramIndex, int sqlType, String typeName)
      throws SQLException {
    LOG.finer(
        "registerOutParameter: paramIndex %s, sqlType %s, typeName %s",
        paramIndex, sqlType, typeName);
    // fully qualified sql typeName is not supported by the driver and hence ignored.
    registerOutParameter(paramIndex, sqlType);
  }

  @Override
  public void registerOutParameter(String paramName, int sqlType, int scale) throws SQLException {
    LOG.finer(
        "registerOutParameter: paramIndex %s, sqlType %s, scale %s", paramName, sqlType, scale);
    checkClosed();
    if (sqlType != Types.NUMERIC && sqlType != Types.DECIMAL) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              String.format("registerOutParameter: Invalid sqlType passed in %s", sqlType));
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    try {
      this.parameterHandler.setParameter(
          paramName,
          null,
          BigQueryJdbcTypeMappings.getJavaType(sqlType),
          BigQueryParameterHandler.BigQueryStatementParameterType.OUT,
          scale);
    } catch (Exception e) {
      SQLException ex = new SQLException(e);
      LOG.severe("Failed to registerOutParameter", ex);
      throw ex;
    }
  }

  @Override
  public void registerOutParameter(String paramName, int sqlType, String typeName)
      throws SQLException {
    LOG.finer(
        "registerOutParameter: paramIndex %s, sqlType %s, typeName %s",
        paramName, sqlType, typeName);
    // fully qualified sql typeName is not supported by the driver and hence ignored.
    registerOutParameter(paramName, sqlType);
  }

  @Override
  public void setAsciiStream(String parameterName, InputStream x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setAsciiStream(String parameterName, InputStream x, int length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setBigDecimal(String parameterName, BigDecimal x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.NUMERIC);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, BigDecimal.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setBinaryStream(String parameterName, InputStream x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setBinaryStream(String parameterName, InputStream x, int length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setBinaryStream(String parameterName, InputStream x, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setBlob(String parameterName, Blob x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setBlob(String parameterName, InputStream x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setBlob(String parameterName, InputStream x, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setBoolean(String parameterName, boolean x) throws SQLException {
    this.parameterHandler.setParameter(
        parameterName, x, Boolean.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setByte(String parameterName, byte x) throws SQLException {
    this.parameterHandler.setParameter(
        parameterName, x, Byte.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setBytes(String parameterName, byte[] x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.VARBINARY);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, byte[].class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setCharacterStream(String parameterName, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setCharacterStream(String parameterName, Reader reader, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setCharacterStream(String parameterName, Reader reader, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setClob(String parameterName, Clob x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setClob(String parameterName, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setClob(String parameterName, Reader reader, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setDate(String parameterName, Date x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.DATE);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, Date.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setDate(String parameterName, Date x, Calendar cal) throws SQLException {
    checkClosed();
    if (x == null) {
      setNull(parameterName, Types.DATE);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName,
        BigQueryTypeCoercionUtility.convertDateToCalendar(x, cal),
        Date.class,
        BigQueryStatementParameterType.IN,
        0);
  }

  @Override
  public void setDouble(String parameterName, double x) throws SQLException {
    this.parameterHandler.setParameter(
        parameterName, x, Double.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setFloat(String parameterName, float x) throws SQLException {
    this.parameterHandler.setParameter(
        parameterName, x, Float.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setInt(String parameterName, int x) throws SQLException {
    this.parameterHandler.setParameter(
        parameterName, x, Integer.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setLong(String parameterName, long x) throws SQLException {
    this.parameterHandler.setParameter(
        parameterName, x, Long.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setNCharacterStream(String parameterName, Reader value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setNCharacterStream(String parameterName, Reader value, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setNClob(String parameterName, NClob value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setNClob(String parameterName, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setNClob(String parameterName, Reader reader, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setNString(String parameterName, String x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.NVARCHAR);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, String.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setNull(String parameterName, int sqlType) throws SQLException {
    checkClosed();
    Class<?> javaType = BigQueryJdbcTypeMappings.getJavaType(sqlType);
    if (javaType == null) {
      javaType = String.class;
    }
    this.parameterHandler.setParameter(
        parameterName, null, javaType, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setNull(String parameterName, int sqlType, String typeName) throws SQLException {
    setNull(parameterName, sqlType);
  }

  @Override
  public void setObject(String parameterName, Object x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.OTHER);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, x.getClass(), BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setObject(String parameterName, Object x, int targetSqlType) throws SQLException {
    if (x == null) {
      setNull(parameterName, targetSqlType);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, x.getClass(), BigQueryStatementParameterType.IN, 0);
    StandardSQLTypeName sqlType = this.parameterHandler.getSqlType(parameterName);
    if (BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.containsKey(sqlType)) {
      int javaSqlType = BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.get(sqlType);
      if (javaSqlType != targetSqlType) {
        throw new BigQueryJdbcSqlFeatureNotSupportedException(
            String.format("Unsupported  sql type:%s ", targetSqlType));
      }
    } else {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          String.format("parameter sql type not supported: %s", sqlType));
    }
  }

  @Override
  public void setObject(String parameterName, Object x, int targetSqlType, int scaleOrLength)
      throws SQLException {
    if (x == null) {
      setNull(parameterName, targetSqlType);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, x.getClass(), BigQueryStatementParameterType.IN, scaleOrLength);
    StandardSQLTypeName sqlType = this.parameterHandler.getSqlType(parameterName);
    if (BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.containsKey(sqlType)) {
      int javaSqlType = BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.get(sqlType);
      if (javaSqlType != targetSqlType) {
        throw new BigQueryJdbcSqlFeatureNotSupportedException(
            String.format("Unsupported  sql type:%s ", targetSqlType));
      }
    } else {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          String.format("parameter sql type not supported: %s", sqlType));
    }
  }

  @Override
  public void setRowId(String parameterName, RowId x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public void setShort(String parameterName, short x) throws SQLException {
    this.parameterHandler.setParameter(
        parameterName, x, Short.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setString(String parameterName, String x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.VARCHAR);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, String.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setTime(String parameterName, Time x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.TIME);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, Time.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setTime(String parameterName, Time x, Calendar cal) throws SQLException {
    checkClosed();
    if (x == null) {
      setNull(parameterName, Types.TIME);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName,
        BigQueryTypeCoercionUtility.convertTimeWithCalendar(x, cal),
        Time.class,
        BigQueryStatementParameterType.IN,
        0);
  }

  @Override
  public void setTimestamp(String parameterName, Timestamp x) throws SQLException {
    if (x == null) {
      setNull(parameterName, Types.TIMESTAMP);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName, x, Timestamp.class, BigQueryStatementParameterType.IN, 0);
  }

  @Override
  public void setTimestamp(String parameterName, Timestamp x, Calendar cal) throws SQLException {
    checkClosed();
    if (x == null) {
      setNull(parameterName, Types.TIMESTAMP);
      return;
    }
    this.parameterHandler.setParameter(
        parameterName,
        BigQueryTypeCoercionUtility.convertTimestampWithCalendar(x, cal),
        Timestamp.class,
        BigQueryStatementParameterType.IN,
        0);
  }

  @Override
  public void setURL(String parameterName, URL val) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("Data type not supported");
  }

  @Override
  public boolean wasNull() throws SQLException {
    checkClosed();
    return this.lastReadWasNull;
  }
}

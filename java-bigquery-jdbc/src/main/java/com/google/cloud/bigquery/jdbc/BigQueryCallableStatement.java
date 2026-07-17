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
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import com.google.common.annotations.VisibleForTesting;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FilterReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedReader;
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
  public Array getArray(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Array) {
      return (Array) param;
    }
    if (param.getClass().isAssignableFrom(Array.class)) {
      return getObject(arg0, Array.class);
    }
    return null;
  }

  @Override
  public Array getArray(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Array) {
      return (Array) param;
    }
    if (param.getClass().isAssignableFrom(Array.class)) {
      return getObject(arg0, Array.class);
    }
    return null;
  }

  @Override
  public BigDecimal getBigDecimal(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof BigDecimal) {
      return (BigDecimal) param;
    }
    if (param.getClass().isAssignableFrom(BigDecimal.class)) {
      return getObject(arg0, BigDecimal.class);
    }
    return null;
  }

  @Override
  public BigDecimal getBigDecimal(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof BigDecimal) {
      return (BigDecimal) param;
    }
    if (param.getClass().isAssignableFrom(BigDecimal.class)) {
      return getObject(arg0, BigDecimal.class);
    }
    return null;
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public BigDecimal getBigDecimal(int arg0, int arg1) throws SQLException {
    return getBigDecimal(arg0);
  }

  @Override
  public Blob getBlob(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Blob) {
      return (Blob) param;
    }
    if (param.getClass().isAssignableFrom(Blob.class)) {
      return getObject(arg0, Blob.class);
    }
    return null;
  }

  @Override
  public Blob getBlob(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Blob) {
      return (Blob) param;
    }
    if (param.getClass().isAssignableFrom(Blob.class)) {
      return getObject(arg0, Blob.class);
    }
    return null;
  }

  @Override
  public boolean getBoolean(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Boolean) {
      return (Boolean) param;
    }
    if (param.getClass().isAssignableFrom(Boolean.class)) {
      return getObject(arg0, Boolean.class);
    }
    return false;
  }

  @Override
  public boolean getBoolean(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Boolean) {
      return (Boolean) param;
    }
    if (param.getClass().isAssignableFrom(Boolean.class)) {
      return getObject(arg0, Boolean.class);
    }
    return false;
  }

  @Override
  public byte getByte(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Byte) {
      return (Byte) param;
    }
    if (param.getClass().isAssignableFrom(Byte.class)) {
      return getObject(arg0, Byte.class);
    }
    return -1;
  }

  @Override
  public byte getByte(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Byte) {
      return (Byte) param;
    }
    if (param.getClass().isAssignableFrom(Byte.class)) {
      return getObject(arg0, Byte.class);
    }
    return -1;
  }

  @Override
  public byte[] getBytes(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof byte[] || param.getClass().isAssignableFrom(byte[].class)) {
      return (byte[]) param;
    }
    if (param instanceof String) {
      return param.toString().getBytes();
    }
    return null;
  }

  @Override
  public byte[] getBytes(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof byte[] || param.getClass().isAssignableFrom(byte[].class)) {
      return (byte[]) param;
    }
    if (param instanceof String) {
      return param.toString().getBytes();
    }
    return null;
  }

  //  FilterReader, InputStreamReader, PipedReader, StringReader
  @Override
  public Reader getCharacterStream(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof String || param.getClass().isAssignableFrom(String.class)) {
      return new StringReader(param.toString());
    }

    if (param instanceof BufferedReader) {
      return (BufferedReader) param;
    }
    if (param.getClass().isAssignableFrom(BufferedReader.class)) {
      return getObject(arg0, BufferedReader.class);
    }

    if (param instanceof CharArrayReader) {
      return (CharArrayReader) param;
    }
    if (param.getClass().isAssignableFrom(CharArrayReader.class)) {
      return getObject(arg0, CharArrayReader.class);
    }

    if (param instanceof FilterReader) {
      return (FilterReader) param;
    }
    if (param.getClass().isAssignableFrom(FilterReader.class)) {
      return getObject(arg0, FilterReader.class);
    }

    if (param instanceof InputStreamReader) {
      return (InputStreamReader) param;
    }
    if (param.getClass().isAssignableFrom(InputStreamReader.class)) {
      return getObject(arg0, InputStreamReader.class);
    }

    if (param instanceof PipedReader) {
      return (PipedReader) param;
    }
    if (param.getClass().isAssignableFrom(PipedReader.class)) {
      return getObject(arg0, PipedReader.class);
    }

    if (param instanceof StringReader) {
      return (StringReader) param;
    }
    if (param.getClass().isAssignableFrom(StringReader.class)) {
      return getObject(arg0, StringReader.class);
    }
    return null;
  }

  @Override
  public Reader getCharacterStream(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof String || param.getClass().isAssignableFrom(String.class)) {
      return new StringReader(param.toString());
    }

    if (param instanceof BufferedReader) {
      return (BufferedReader) param;
    }
    if (param.getClass().isAssignableFrom(BufferedReader.class)) {
      return getObject(arg0, BufferedReader.class);
    }

    if (param instanceof CharArrayReader) {
      return (CharArrayReader) param;
    }
    if (param.getClass().isAssignableFrom(CharArrayReader.class)) {
      return getObject(arg0, CharArrayReader.class);
    }

    if (param instanceof FilterReader) {
      return (FilterReader) param;
    }
    if (param.getClass().isAssignableFrom(FilterReader.class)) {
      return getObject(arg0, FilterReader.class);
    }

    if (param instanceof InputStreamReader) {
      return (InputStreamReader) param;
    }
    if (param.getClass().isAssignableFrom(InputStreamReader.class)) {
      return getObject(arg0, InputStreamReader.class);
    }

    if (param instanceof PipedReader) {
      return (PipedReader) param;
    }
    if (param.getClass().isAssignableFrom(PipedReader.class)) {
      return getObject(arg0, PipedReader.class);
    }

    if (param instanceof StringReader) {
      return (StringReader) param;
    }
    if (param.getClass().isAssignableFrom(StringReader.class)) {
      return getObject(arg0, StringReader.class);
    }
    return null;
  }

  @Override
  public Clob getClob(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Clob) {
      return (Clob) param;
    }
    if (param.getClass().isAssignableFrom(Clob.class)) {
      return getObject(arg0, Clob.class);
    }
    return null;
  }

  @Override
  public Clob getClob(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Clob) {
      return (Clob) param;
    }
    if (param.getClass().isAssignableFrom(Clob.class)) {
      return getObject(arg0, Clob.class);
    }
    return null;
  }

  @Override
  public Date getDate(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Date) {
      return (Date) param;
    }
    if (param.getClass().isAssignableFrom(Date.class)) {
      return getObject(arg0, Date.class);
    }
    return null;
  }

  @Override
  public Date getDate(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Date) {
      return (Date) param;
    }
    if (param.getClass().isAssignableFrom(Date.class)) {
      return getObject(arg0, Date.class);
    }
    return null;
  }

  private Calendar getSafeCalendar(Calendar cal) {
    Calendar safeCal = null;
    if (cal != null) {
      Object cloned = cal.clone();
      if (cloned instanceof Calendar) {
        safeCal = (Calendar) cloned;
      }
    }
    if (safeCal == null) {
      safeCal = Calendar.getInstance();
      if (cal != null && cal.getTimeZone() != null) {
        safeCal.setTimeZone(cal.getTimeZone());
      }
    }
    return safeCal;
  }

  @Override
  public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
    checkClosed();
    Object param = this.parameterHandler.getParameter(parameterIndex);
    this.lastReadWasNull = (param == null);
    if (param instanceof Date) {
      Date dateParam = (Date) param;
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTime(dateParam);
        return new Date(safeCal.getTimeInMillis());
      }
      return dateParam;
    }
    if (param != null && param.getClass().isAssignableFrom(Date.class)) {
      Date dateObj = getObject(parameterIndex, Date.class);
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTime(dateObj);
        return new Date(safeCal.getTimeInMillis());
      }
      return dateObj;
    }
    return null;
  }

  @Override
  public Date getDate(String parameterName, Calendar cal) throws SQLException {
    checkClosed();
    Object param = this.parameterHandler.getParameter(parameterName);
    this.lastReadWasNull = (param == null);
    if (param instanceof Date) {
      Date dateParam = (Date) param;
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTime(dateParam);
        return new Date(safeCal.getTimeInMillis());
      }
      return dateParam;
    }
    if (param != null && param.getClass().isAssignableFrom(Date.class)) {
      Date dateObj = getObject(parameterName, Date.class);
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTime(dateObj);
        return new Date(safeCal.getTimeInMillis());
      }
      return dateObj;
    }
    return null;
  }

  @Override
  public double getDouble(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Double) {
      return (Double) param;
    }
    if (param.getClass().isAssignableFrom(Double.class)) {
      return getObject(arg0, Double.class);
    }
    return 0;
  }

  @Override
  public double getDouble(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Double) {
      return (Double) param;
    }
    if (param.getClass().isAssignableFrom(Double.class)) {
      return getObject(arg0, Double.class);
    }
    return 0;
  }

  @Override
  public float getFloat(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Float) {
      return (Float) param;
    }
    if (param.getClass().isAssignableFrom(Float.class)) {
      return getObject(arg0, Float.class);
    }
    return 0;
  }

  @Override
  public float getFloat(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Float) {
      return (Float) param;
    }
    if (param.getClass().isAssignableFrom(Float.class)) {
      return getObject(arg0, Float.class);
    }
    return 0;
  }

  @Override
  public int getInt(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Integer) {
      return (Integer) param;
    }
    if (param.getClass().isAssignableFrom(Integer.class)) {
      return getObject(arg0, Integer.class);
    }
    return 0;
  }

  @Override
  public int getInt(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Integer) {
      return (Integer) param;
    }
    if (param.getClass().isAssignableFrom(Integer.class)) {
      return getObject(arg0, Integer.class);
    }
    return 0;
  }

  @Override
  public long getLong(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Long) {
      return (Long) param;
    }
    if (param.getClass().isAssignableFrom(Long.class)) {
      return getObject(arg0, Long.class);
    }
    if (param instanceof Integer) {
      return (Long) param;
    }
    if (param.getClass().isAssignableFrom(Integer.class)) {
      return getObject(arg0, Integer.class);
    }
    return 0;
  }

  @Override
  public long getLong(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Long) {
      return (Long) param;
    }
    if (param.getClass().isAssignableFrom(Long.class)) {
      return getObject(arg0, Long.class);
    }
    if (param instanceof Integer) {
      return (Long) param;
    }
    if (param.getClass().isAssignableFrom(Integer.class)) {
      return getObject(arg0, Integer.class);
    }
    return 0;
  }

  @Override
  public Reader getNCharacterStream(int arg0) throws SQLException {
    return getCharacterStream(arg0);
  }

  @Override
  public Reader getNCharacterStream(String arg0) throws SQLException {
    return getCharacterStream(arg0);
  }

  @Override
  public NClob getNClob(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof NClob) {}
    if (param.getClass().isAssignableFrom(NClob.class)) {
      return getObject(arg0, NClob.class);
    }
    return null;
  }

  @Override
  public NClob getNClob(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof NClob) {
      return (NClob) param;
    }
    if (param.getClass().isAssignableFrom(NClob.class)) {
      return getObject(arg0, NClob.class);
    }
    return null;
  }

  @Override
  public String getNString(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof String) {
      return param.toString();
    }
    if (param.getClass().isAssignableFrom(String.class)) {
      return getObject(arg0, String.class);
    }
    return null;
  }

  @Override
  public String getNString(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof String) {
      return param.toString();
    }
    if (param.getClass().isAssignableFrom(String.class)) {
      return getObject(arg0, String.class);
    }
    return null;
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
  public Object getObject(int arg0, Map<String, Class<?>> arg1) throws SQLException {
    String paramKey = this.parameterHandler.getSqlType(arg0).name();
    if (arg1.containsKey(paramKey)) {
      Class<?> argJavaType = arg1.get(paramKey);
      Class<?> paramJavaType = this.parameterHandler.getType(arg0);
      if (paramJavaType.isAssignableFrom(argJavaType)) {
        return this.parameterHandler.getParameter(arg0);
      }
    }
    return null;
  }

  @Override
  public Object getObject(String arg0, Map<String, Class<?>> arg1) throws SQLException {
    String paramKey = this.parameterHandler.getSqlType(arg0).name();
    if (arg1.containsKey(paramKey)) {
      Class<?> argJavaType = arg1.get(paramKey);
      Class<?> paramJavaType = this.parameterHandler.getType(arg0);
      if (paramJavaType.isAssignableFrom(argJavaType)) {
        return this.parameterHandler.getParameter(arg0);
      }
    }
    return null;
  }

  @Override
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    Class<?> javaType = this.parameterHandler.getType(parameterIndex);
    if (javaType.isAssignableFrom(type)) {
      return (T) this.parameterHandler.getParameter(parameterIndex);
    }
    return null;
  }

  @Override
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    Class<?> javaType = this.parameterHandler.getType(parameterName);
    if (javaType.isAssignableFrom(type)) {
      return (T) this.parameterHandler.getParameter(parameterName);
    }
    return null;
  }

  @Override
  public Ref getRef(int arg0) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public Ref getRef(String arg0) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public RowId getRowId(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof RowId) {
      return (RowId) param;
    }
    if (param.getClass().isAssignableFrom(RowId.class)) {
      return getObject(arg0, RowId.class);
    }
    return null;
  }

  @Override
  public RowId getRowId(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof RowId) {
      return (RowId) param;
    }
    if (param.getClass().isAssignableFrom(RowId.class)) {
      return getObject(arg0, RowId.class);
    }
    return null;
  }

  @Override
  public SQLXML getSQLXML(int arg0) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public SQLXML getSQLXML(String arg0) throws SQLException {
    // Auto-generated method stub
    return null;
  }

  @Override
  public short getShort(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Short) {
      return (Short) param;
    }
    if (param.getClass().isAssignableFrom(Short.class)) {
      return getObject(arg0, Short.class);
    }
    return 0;
  }

  @Override
  public short getShort(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Short) {
      return (Short) param;
    }
    if (param.getClass().isAssignableFrom(Short.class)) {
      return getObject(arg0, Short.class);
    }
    return 0;
  }

  @Override
  public String getString(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof String) {
      return param.toString();
    }
    if (param.getClass().isAssignableFrom(String.class)) {
      return getObject(arg0, String.class);
    }
    return null;
  }

  @Override
  public String getString(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof String) {
      return param.toString();
    }
    if (param.getClass().isAssignableFrom(String.class)) {
      return getObject(arg0, String.class);
    }
    return null;
  }

  @Override
  public Time getTime(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Time) {
      return (Time) param;
    }
    if (param.getClass().isAssignableFrom(Time.class)) {
      return getObject(arg0, Time.class);
    }
    return null;
  }

  @Override
  public Time getTime(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Time) {
      return (Time) param;
    }
    if (param.getClass().isAssignableFrom(Time.class)) {
      return getObject(arg0, Time.class);
    }
    return null;
  }

  @Override
  public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
    checkClosed();
    Object param = this.parameterHandler.getParameter(parameterIndex);
    this.lastReadWasNull = (param == null);
    if (param instanceof Time) {
      Time timeParam = (Time) param;
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timeParam.getTime());
        return new Time(safeCal.getTimeInMillis());
      }
      return timeParam;
    }
    if (param != null && param.getClass().isAssignableFrom(Time.class)) {
      Time timeObj = getObject(parameterIndex, Time.class);
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timeObj.getTime());
        return new Time(safeCal.getTimeInMillis());
      }
      return timeObj;
    }
    return null;
  }

  @Override
  public Time getTime(String parameterName, Calendar cal) throws SQLException {
    checkClosed();
    Object param = this.parameterHandler.getParameter(parameterName);
    this.lastReadWasNull = (param == null);
    if (param instanceof Time) {
      Time timeParam = (Time) param;
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timeParam.getTime());
        return new Time(safeCal.getTimeInMillis());
      }
      return timeParam;
    }
    if (param != null && param.getClass().isAssignableFrom(Time.class)) {
      Time timeObj = getObject(parameterName, Time.class);
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timeObj.getTime());
        return new Time(safeCal.getTimeInMillis());
      }
      return timeObj;
    }
    return null;
  }

  @Override
  public Timestamp getTimestamp(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Timestamp) {
      return (Timestamp) param;
    }
    if (param.getClass().isAssignableFrom(Timestamp.class)) {
      return getObject(arg0, Timestamp.class);
    }
    return null;
  }

  @Override
  public Timestamp getTimestamp(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof Timestamp) {
      return (Timestamp) param;
    }
    if (param.getClass().isAssignableFrom(Timestamp.class)) {
      return getObject(arg0, Timestamp.class);
    }
    return null;
  }

  @Override
  public Timestamp getTimestamp(int parameterIndex, Calendar cal) throws SQLException {
    checkClosed();
    Object param = this.parameterHandler.getParameter(parameterIndex);
    this.lastReadWasNull = (param == null);
    if (param instanceof Timestamp) {
      Timestamp timestampParam = (Timestamp) param;
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timestampParam.getTime());
        return new Timestamp(safeCal.getTimeInMillis());
      }
      return timestampParam;
    }
    if (param != null && param.getClass().isAssignableFrom(Timestamp.class)) {
      Timestamp timestampObj = getObject(parameterIndex, Timestamp.class);
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timestampObj.getTime());
        return new Timestamp(safeCal.getTimeInMillis());
      }
      return timestampObj;
    }
    return null;
  }

  @Override
  public Timestamp getTimestamp(String parameterName, Calendar cal) throws SQLException {
    checkClosed();
    Object param = this.parameterHandler.getParameter(parameterName);
    this.lastReadWasNull = (param == null);
    if (param instanceof Timestamp) {
      Timestamp timestampParam = (Timestamp) param;
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timestampParam.getTime());
        return new Timestamp(safeCal.getTimeInMillis());
      }
      return timestampParam;
    }
    if (param != null && param.getClass().isAssignableFrom(Timestamp.class)) {
      Timestamp timestampObj = getObject(parameterName, Timestamp.class);
      if (cal != null) {
        Calendar safeCal = getSafeCalendar(cal);
        safeCal.setTimeInMillis(timestampObj.getTime());
        return new Timestamp(safeCal.getTimeInMillis());
      }
      return timestampObj;
    }
    return null;
  }

  @Override
  public URL getURL(int arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof URL) {
      return (URL) param;
    }
    if (param.getClass().isAssignableFrom(URL.class)) {
      return getObject(arg0, URL.class);
    }
    return null;
  }

  @Override
  public URL getURL(String arg0) throws SQLException {
    Object param = this.parameterHandler.getParameter(arg0);
    if (param instanceof URL) {
      return (URL) param;
    }
    if (param.getClass().isAssignableFrom(URL.class)) {
      return getObject(arg0, URL.class);
    }
    return null;
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
    Calendar safeCal = getSafeCalendar(cal);
    safeCal.setTimeInMillis(x.getTime());
    this.parameterHandler.setParameter(
        parameterName,
        new Date(safeCal.getTimeInMillis()),
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
    Calendar safeCal = getSafeCalendar(cal);
    safeCal.setTimeInMillis(x.getTime());
    this.parameterHandler.setParameter(
        parameterName,
        new Time(safeCal.getTimeInMillis()),
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
    Calendar safeCal = getSafeCalendar(cal);
    safeCal.setTimeInMillis(x.getTime());
    this.parameterHandler.setParameter(
        parameterName,
        new Timestamp(safeCal.getTimeInMillis()),
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

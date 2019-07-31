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

import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.Code;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/** Implementation of {@link ResultSet} for Cloud Spanner */
class JdbcResultSet extends AbstractJdbcResultSet {

  static JdbcResultSet of(com.google.cloud.spanner.ResultSet resultSet) {
    Preconditions.checkNotNull(resultSet);
    return new JdbcResultSet(null, resultSet);
  }

  static JdbcResultSet of(Statement statement, com.google.cloud.spanner.ResultSet resultSet) {
    Preconditions.checkNotNull(statement);
    Preconditions.checkNotNull(resultSet);
    return new JdbcResultSet(statement, resultSet);
  }

  private boolean closed = false;
  private final Statement statement;
  private boolean wasNull = false;
  private boolean nextReturnedFalse = false;
  private boolean nextCalledForMetaData = false;
  private boolean nextCalledForMetaDataResult = false;
  private long currentRow = 0L;

  private JdbcResultSet(Statement statement, com.google.cloud.spanner.ResultSet spanner) {
    super(spanner);
    this.statement = statement;
  }

  void checkClosedAndValidRow() throws SQLException {
    checkClosed();
    if (currentRow == 0L) {
      throw JdbcSqlExceptionFactory.of(
          "ResultSet is before first row. Call next() first.",
          com.google.rpc.Code.FAILED_PRECONDITION);
    }
    if (nextReturnedFalse) {
      throw JdbcSqlExceptionFactory.of(
          "ResultSet is after last row. There is no more data available.",
          com.google.rpc.Code.FAILED_PRECONDITION);
    }
  }

  @Override
  public boolean next() throws SQLException {
    checkClosed();
    currentRow++;
    if (nextCalledForMetaData) {
      nextReturnedFalse = !nextCalledForMetaDataResult;
      nextCalledForMetaData = false;
    } else {
      nextReturnedFalse = !spanner.next();
    }

    return !nextReturnedFalse;
  }

  @Override
  public void close() throws SQLException {
    spanner.close();
    this.closed = true;
  }

  @Override
  public boolean wasNull() throws SQLException {
    checkClosedAndValidRow();
    return wasNull;
  }

  private boolean isNull(int columnIndex) {
    wasNull = spanner.isNull(columnIndex - 1);
    return wasNull;
  }

  private boolean isNull(String columnName) {
    wasNull = spanner.isNull(columnName);
    return wasNull;
  }

  @Override
  public String getString(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex) ? null : spanner.getString(columnIndex - 1);
  }

  @Override
  public boolean getBoolean(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex) ? false : spanner.getBoolean(columnIndex - 1);
  }

  @Override
  public byte getByte(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    long val = isNull(columnIndex) ? 0L : spanner.getLong(columnIndex - 1);
    return checkedCastToByte(val);
  }

  @Override
  public short getShort(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    long val = isNull(columnIndex) ? 0L : spanner.getLong(columnIndex - 1);
    return checkedCastToShort(val);
  }

  @Override
  public int getInt(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    long val = isNull(columnIndex) ? 0L : spanner.getLong(columnIndex - 1);
    return checkedCastToInt(val);
  }

  @Override
  public long getLong(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex) ? 0L : spanner.getLong(columnIndex - 1);
  }

  @Override
  public float getFloat(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    double val = isNull(columnIndex) ? 0D : spanner.getDouble(columnIndex - 1);
    return checkedCastToFloat(val);
  }

  @Override
  public double getDouble(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex) ? 0D : spanner.getDouble(columnIndex - 1);
  }

  @Override
  public byte[] getBytes(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex) ? null : spanner.getBytes(columnIndex - 1).toByteArray();
  }

  @Override
  public Date getDate(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex)
        ? null
        : JdbcTypeConverter.toSqlDate(spanner.getDate(columnIndex - 1));
  }

  @Override
  public Time getTime(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex)
        ? null
        : JdbcTypeConverter.toSqlTime(spanner.getTimestamp(columnIndex - 1));
  }

  @Override
  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex)
        ? null
        : JdbcTypeConverter.toSqlTimestamp(spanner.getTimestamp(columnIndex - 1));
  }

  private InputStream getInputStream(String val, Charset charset) {
    if (val == null) return null;
    byte[] b = val.getBytes(charset);
    return new ByteArrayInputStream(b);
  }

  @Override
  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return getInputStream(getString(columnIndex), StandardCharsets.US_ASCII);
  }

  @Override
  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return getInputStream(getString(columnIndex), StandardCharsets.UTF_16LE);
  }

  @Override
  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    byte[] val = getBytes(columnIndex);
    return val == null ? null : new ByteArrayInputStream(val);
  }

  @Override
  public String getString(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel) ? null : spanner.getString(columnLabel);
  }

  @Override
  public boolean getBoolean(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel) ? false : spanner.getBoolean(columnLabel);
  }

  @Override
  public byte getByte(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    long val = isNull(columnLabel) ? 0L : spanner.getLong(columnLabel);
    return checkedCastToByte(val);
  }

  @Override
  public short getShort(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    long val = isNull(columnLabel) ? 0L : spanner.getLong(columnLabel);
    return checkedCastToShort(val);
  }

  @Override
  public int getInt(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    long val = isNull(columnLabel) ? 0L : spanner.getLong(columnLabel);
    return checkedCastToInt(val);
  }

  @Override
  public long getLong(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel) ? 0L : spanner.getLong(columnLabel);
  }

  @Override
  public float getFloat(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    double val = isNull(columnLabel) ? 0D : spanner.getDouble(columnLabel);
    return checkedCastToFloat(val);
  }

  @Override
  public double getDouble(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel) ? 0D : spanner.getDouble(columnLabel);
  }

  @Override
  public byte[] getBytes(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel) ? null : spanner.getBytes(columnLabel).toByteArray();
  }

  @Override
  public Date getDate(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel) ? null : JdbcTypeConverter.toSqlDate(spanner.getDate(columnLabel));
  }

  @Override
  public Time getTime(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel)
        ? null
        : JdbcTypeConverter.toSqlTime(spanner.getTimestamp(columnLabel));
  }

  @Override
  public Timestamp getTimestamp(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel)
        ? null
        : JdbcTypeConverter.toSqlTimestamp(spanner.getTimestamp(columnLabel));
  }

  @Override
  public InputStream getAsciiStream(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return getInputStream(getString(columnLabel), StandardCharsets.US_ASCII);
  }

  @Override
  public InputStream getUnicodeStream(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return getInputStream(getString(columnLabel), StandardCharsets.UTF_16LE);
  }

  @Override
  public InputStream getBinaryStream(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    byte[] val = getBytes(columnLabel);
    return val == null ? null : new ByteArrayInputStream(val);
  }

  @Override
  public JdbcResultSetMetaData getMetaData() throws SQLException {
    checkClosed();
    if (isBeforeFirst()) {
      // do a call to next() on the underlying resultset to initialize metadata
      nextCalledForMetaData = true;
      nextCalledForMetaDataResult = spanner.next();
    }
    return new JdbcResultSetMetaData(this, statement);
  }

  @Override
  public Object getObject(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    Type type = spanner.getColumnType(columnLabel);
    return isNull(columnLabel) ? null : getObject(type, columnLabel);
  }

  @Override
  public Object getObject(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    Type type = spanner.getColumnType(columnIndex - 1);
    return isNull(columnIndex) ? null : getObject(type, columnIndex);
  }

  private Object getObject(Type type, String columnLabel) throws SQLException {
    return getObject(type, spanner.getColumnIndex(columnLabel) + 1);
  }

  private Object getObject(Type type, int columnIndex) throws SQLException {
    if (type == Type.bool()) return getBoolean(columnIndex);
    if (type == Type.bytes()) return getBytes(columnIndex);
    if (type == Type.date()) return getDate(columnIndex);
    if (type == Type.float64()) return getDouble(columnIndex);
    if (type == Type.int64()) return getLong(columnIndex);
    if (type == Type.string()) return getString(columnIndex);
    if (type == Type.timestamp()) return getTimestamp(columnIndex);
    if (type.getCode() == Code.ARRAY) return getArray(columnIndex);
    throw JdbcSqlExceptionFactory.of(
        "Unknown type: " + type.toString(), com.google.rpc.Code.INVALID_ARGUMENT);
  }

  @Override
  public int findColumn(String columnLabel) throws SQLException {
    checkClosed();
    try {
      return spanner.getColumnIndex(columnLabel) + 1;
    } catch (IllegalArgumentException e) {
      throw JdbcSqlExceptionFactory.of(
          "no column with label " + columnLabel + " found", com.google.rpc.Code.INVALID_ARGUMENT);
    }
  }

  @Override
  public Reader getCharacterStream(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    String val = getString(columnIndex);
    return val == null ? null : new StringReader(val);
  }

  @Override
  public Reader getCharacterStream(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    String val = getString(columnLabel);
    return val == null ? null : new StringReader(val);
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return getBigDecimal(columnIndex, false, 0);
  }

  @Override
  public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return getBigDecimal(spanner.getColumnIndex(columnLabel) + 1, false, 0);
  }

  @Override
  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    checkClosedAndValidRow();
    return getBigDecimal(columnIndex, true, scale);
  }

  @Override
  public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    checkClosedAndValidRow();
    return getBigDecimal(spanner.getColumnIndex(columnLabel) + 1, true, scale);
  }

  private BigDecimal getBigDecimal(int columnIndex, boolean fixedScale, int scale)
      throws SQLException {
    Type type = spanner.getColumnType(columnIndex - 1);
    BigDecimal res;
    if (isNull(columnIndex)) {
      res = null;
    } else {
      if (type.getCode() == Code.STRING) {
        try {
          res = new BigDecimal(spanner.getString(columnIndex - 1));
        } catch (NumberFormatException e) {
          throw JdbcSqlExceptionFactory.of(
              "The column does not contain a valid BigDecimal",
              com.google.rpc.Code.INVALID_ARGUMENT,
              e);
        }
      } else if (type.getCode() == Code.INT64) {
        res = BigDecimal.valueOf(spanner.getLong(columnIndex - 1));
      } else if (type.getCode() == Code.FLOAT64) {
        res = BigDecimal.valueOf(spanner.getDouble(columnIndex - 1));
      } else {
        throw JdbcSqlExceptionFactory.of(
            "The column does not contain a valid BigDecimal", com.google.rpc.Code.INVALID_ARGUMENT);
      }
      if (fixedScale) {
        res = res.setScale(scale, RoundingMode.HALF_UP);
      }
    }
    return res;
  }

  @Override
  public boolean isBeforeFirst() throws SQLException {
    checkClosed();
    return currentRow == 0L;
  }

  @Override
  public boolean isAfterLast() throws SQLException {
    checkClosed();
    return nextReturnedFalse;
  }

  @Override
  public boolean isFirst() throws SQLException {
    checkClosed();
    return currentRow == 1L;
  }

  @Override
  public int getRow() throws SQLException {
    checkClosed();
    return checkedCastToInt(currentRow);
  }

  @Override
  public Statement getStatement() throws SQLException {
    checkClosed();
    return statement;
  }

  @Override
  public Array getArray(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return getArray(findColumn(columnLabel));
  }

  @Override
  public Array getArray(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    if (isNull(columnIndex)) return null;
    Type type = spanner.getColumnType(columnIndex - 1);
    if (type.getCode() != Code.ARRAY)
      throw JdbcSqlExceptionFactory.of(
          "Column with index " + columnIndex + " does not contain an array",
          com.google.rpc.Code.INVALID_ARGUMENT);
    JdbcDataType dataType = JdbcDataType.getType(type.getArrayElementType().getCode());
    List<? extends Object> elements = dataType.getArrayElements(spanner, columnIndex - 1);

    return JdbcArray.createArray(dataType, elements);
  }

  @Override
  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex)
        ? null
        : JdbcTypeConverter.toSqlDate(spanner.getDate(columnIndex - 1), cal);
  }

  @Override
  public Date getDate(String columnLabel, Calendar cal) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel)
        ? null
        : JdbcTypeConverter.toSqlDate(spanner.getDate(columnLabel), cal);
  }

  @Override
  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex)
        ? null
        : JdbcTypeConverter.toSqlTime(spanner.getTimestamp(columnIndex - 1), cal);
  }

  @Override
  public Time getTime(String columnLabel, Calendar cal) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel)
        ? null
        : JdbcTypeConverter.toSqlTime(spanner.getTimestamp(columnLabel), cal);
  }

  @Override
  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnIndex)
        ? null
        : JdbcTypeConverter.getAsSqlTimestamp(spanner.getTimestamp(columnIndex - 1), cal);
  }

  @Override
  public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
    checkClosedAndValidRow();
    return isNull(columnLabel)
        ? null
        : JdbcTypeConverter.getAsSqlTimestamp(spanner.getTimestamp(columnLabel), cal);
  }

  @Override
  public URL getURL(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    try {
      return isNull(columnIndex) ? null : new URL(spanner.getString(columnIndex - 1));
    } catch (MalformedURLException e) {
      throw JdbcSqlExceptionFactory.of(
          "Invalid URL: " + spanner.getString(columnIndex - 1),
          com.google.rpc.Code.INVALID_ARGUMENT);
    }
  }

  @Override
  public URL getURL(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return getURL(findColumn(columnLabel));
  }

  @Override
  public int getHoldability() throws SQLException {
    checkClosed();
    return CLOSE_CURSORS_AT_COMMIT;
  }

  @Override
  public boolean isClosed() throws SQLException {
    return closed;
  }

  @Override
  public String getNString(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return getString(columnIndex);
  }

  @Override
  public String getNString(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return getString(columnLabel);
  }

  @Override
  public Reader getNCharacterStream(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    return getCharacterStream(columnIndex);
  }

  @Override
  public Reader getNCharacterStream(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    return getCharacterStream(columnLabel);
  }

  @Override
  public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
    checkClosedAndValidRow();
    return convertObject(getObject(columnIndex), type, spanner.getColumnType(columnIndex - 1));
  }

  @Override
  public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
    checkClosedAndValidRow();
    return convertObject(getObject(columnLabel), type, spanner.getColumnType(columnLabel));
  }

  @Override
  public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
    checkClosedAndValidRow();
    return convertObject(getObject(columnIndex), map, spanner.getColumnType(columnIndex - 1));
  }

  @Override
  public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
    checkClosedAndValidRow();
    return convertObject(getObject(columnLabel), map, spanner.getColumnType(columnLabel));
  }

  @Override
  public Blob getBlob(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    byte[] val = getBytes(columnIndex);
    return val == null ? null : new JdbcBlob(val);
  }

  @Override
  public Blob getBlob(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    byte[] val = getBytes(columnLabel);
    return val == null ? null : new JdbcBlob(val);
  }

  @Override
  public Clob getClob(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    String val = getString(columnIndex);
    return val == null ? null : new JdbcClob(val);
  }

  @Override
  public Clob getClob(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    String val = getString(columnLabel);
    return val == null ? null : new JdbcClob(val);
  }

  @Override
  public NClob getNClob(int columnIndex) throws SQLException {
    checkClosedAndValidRow();
    String val = getString(columnIndex);
    return val == null ? null : new JdbcClob(val);
  }

  @Override
  public NClob getNClob(String columnLabel) throws SQLException {
    checkClosedAndValidRow();
    String val = getString(columnLabel);
    return val == null ? null : new JdbcClob(val);
  }

  @SuppressWarnings("unchecked")
  private <T> T convertObject(Object o, Class<T> javaType, Type type) throws SQLException {
    return (T) JdbcTypeConverter.convert(o, type, javaType);
  }

  private Object convertObject(Object o, Map<String, Class<?>> map, Type type) throws SQLException {
    if (map == null)
      throw JdbcSqlExceptionFactory.of("Map may not be null", com.google.rpc.Code.INVALID_ARGUMENT);
    if (o == null) return null;
    Class<?> javaType = map.get(type.getCode().name());
    if (javaType == null) return o;
    return JdbcTypeConverter.convert(o, type, javaType);
  }
}

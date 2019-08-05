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

import com.google.rpc.Code;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
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
import java.util.Calendar;

/** Base class for Cloud Spanner {@link PreparedStatement}s. */
abstract class AbstractJdbcPreparedStatement extends JdbcStatement implements PreparedStatement {
  private static final String METHOD_NOT_ON_PREPARED_STATEMENT =
      "This method may not be called on a PreparedStatement";
  private final JdbcParameterStore parameters = new JdbcParameterStore();

  AbstractJdbcPreparedStatement(JdbcConnection connection) {
    super(connection);
  }

  JdbcParameterStore getParameters() {
    return parameters;
  }

  private <T> T checkClosedAndThrowNotOnPreparedStatement() throws SQLException {
    checkClosed();
    throw JdbcSqlExceptionFactory.of(METHOD_NOT_ON_PREPARED_STATEMENT, Code.INVALID_ARGUMENT);
  }

  @Override
  public ResultSet executeQuery(String sql) throws SQLException {
    return checkClosedAndThrowNotOnPreparedStatement();
  }

  @Override
  public int executeUpdate(String sql) throws SQLException {
    return checkClosedAndThrowNotOnPreparedStatement();
  }

  @Override
  public boolean execute(String sql) throws SQLException {
    return checkClosedAndThrowNotOnPreparedStatement();
  }

  @Override
  public void addBatch(String sql) throws SQLException {
    checkClosedAndThrowNotOnPreparedStatement();
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, null, sqlType, null);
  }

  @Override
  public void setBoolean(int parameterIndex, boolean value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.BOOLEAN);
  }

  @Override
  public void setByte(int parameterIndex, byte value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.TINYINT);
  }

  @Override
  public void setShort(int parameterIndex, short value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.SMALLINT);
  }

  @Override
  public void setInt(int parameterIndex, int value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.INTEGER);
  }

  @Override
  public void setLong(int parameterIndex, long value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.BIGINT);
  }

  @Override
  public void setFloat(int parameterIndex, float value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.FLOAT);
  }

  @Override
  public void setDouble(int parameterIndex, double value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.DOUBLE);
  }

  @Override
  public void setBigDecimal(int parameterIndex, BigDecimal value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.DECIMAL);
  }

  @Override
  public void setString(int parameterIndex, String value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.NVARCHAR);
  }

  @Override
  public void setBytes(int parameterIndex, byte[] value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.BINARY);
  }

  @Override
  public void setDate(int parameterIndex, Date value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.DATE);
  }

  @Override
  public void setTime(int parameterIndex, Time value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.TIME);
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.TIMESTAMP);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.VARCHAR, length);
  }

  @Override
  public void setUnicodeStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.NVARCHAR, length);
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.BINARY, length);
  }

  @Override
  public void clearParameters() throws SQLException {
    checkClosed();
    parameters.clearParameters();
  }

  @Override
  public void setObject(int parameterIndex, Object value, int targetSqlType) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, targetSqlType, null);
  }

  @Override
  public void setObject(int parameterIndex, Object value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, null);
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, int length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, reader, Types.NVARCHAR, length);
  }

  @Override
  public void setRef(int parameterIndex, Ref value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.REF);
  }

  @Override
  public void setBlob(int parameterIndex, Blob value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.BLOB);
  }

  @Override
  public void setClob(int parameterIndex, Clob value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.CLOB);
  }

  @Override
  public void setArray(int parameterIndex, Array value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.ARRAY);
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    checkClosed();
    try (ResultSet rs = executeQuery()) {
      return rs.getMetaData();
    }
  }

  @Override
  public void setDate(int parameterIndex, Date value, Calendar cal) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.DATE);
  }

  @Override
  public void setTime(int parameterIndex, Time value, Calendar cal) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.TIME);
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value, Calendar cal) throws SQLException {
    checkClosed();
    parameters.setParameter(
        parameterIndex,
        cal == null ? value : JdbcTypeConverter.setTimestampInCalendar(value, cal),
        Types.TIMESTAMP);
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, null, sqlType, null);
  }

  @Override
  public void setURL(int parameterIndex, URL value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.NVARCHAR);
  }

  @Override
  public void setRowId(int parameterIndex, RowId value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.ROWID);
  }

  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.NVARCHAR);
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value, long length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.NVARCHAR);
  }

  @Override
  public void setNClob(int parameterIndex, NClob value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.NCLOB);
  }

  @Override
  public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, reader, Types.CLOB);
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream, long length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, inputStream, Types.BLOB);
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, reader, Types.NCLOB);
  }

  @Override
  public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, xmlObject, Types.SQLXML);
  }

  @Override
  public void setObject(int parameterIndex, Object value, int targetSqlType, int scaleOrLength)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, targetSqlType, scaleOrLength);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream value, long length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.VARCHAR);
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream value, long length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.BINARY);
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, long length)
      throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, reader, Types.NVARCHAR);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.VARCHAR);
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.BINARY);
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, reader, Types.NVARCHAR);
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, value, Types.NVARCHAR);
  }

  @Override
  public void setClob(int parameterIndex, Reader reader) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, reader, Types.CLOB);
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, inputStream, Types.BLOB);
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader) throws SQLException {
    checkClosed();
    parameters.setParameter(parameterIndex, reader, Types.NVARCHAR);
  }
}

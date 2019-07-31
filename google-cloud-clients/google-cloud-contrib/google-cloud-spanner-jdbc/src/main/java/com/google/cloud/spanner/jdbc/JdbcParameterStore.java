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

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Statement.Builder;
import com.google.cloud.spanner.ValueBinder;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.common.io.CharStreams;
import com.google.rpc.Code;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This class handles the parameters of a {@link PreparedStatement}. */
class JdbcParameterStore {
  /**
   * The initial size of the arrays that hold the parameter values. The array will automatically be
   * extended when needed.
   */
  private static final int INITIAL_PARAMETERS_ARRAY_SIZE = 10;

  private static final class JdbcParameter {
    private Object value;
    private Integer type;
    private Integer nullable;
    private Integer scaleOrLength;
    private String column;
  }

  private ArrayList<JdbcParameter> parametersList = new ArrayList<>(INITIAL_PARAMETERS_ARRAY_SIZE);

  /** Name of the table that the parameters will be used to query/update. Can be null. */
  private String table;

  /**
   * The highest parameter index in use. Parameter values do not need to be set in order, it could
   * be that a parameter with for example index 10 is set first, and that the preceding parameters
   * are set at a later time.
   */
  private int highestIndex = 0;

  JdbcParameterStore() {}

  void clearParameters() {
    parametersList = new ArrayList<>(INITIAL_PARAMETERS_ARRAY_SIZE);
    highestIndex = 0;
    table = null;
  }

  /** Get parameter value. Index is 1-based. */
  Object getParameter(int parameterIndex) {
    int arrayIndex = parameterIndex - 1;
    if (arrayIndex >= parametersList.size() || parametersList.get(arrayIndex) == null) return null;
    return parametersList.get(arrayIndex).value;
  }

  /** Get parameter type code according to the values in {@link Types}. Index is 1-based. */
  Integer getType(int parameterIndex) {
    int arrayIndex = parameterIndex - 1;
    if (arrayIndex >= parametersList.size() || parametersList.get(arrayIndex) == null) return null;
    return parametersList.get(arrayIndex).type;
  }

  Integer getNullable(int parameterIndex) {
    int arrayIndex = parameterIndex - 1;
    if (arrayIndex >= parametersList.size() || parametersList.get(arrayIndex) == null) return null;
    return parametersList.get(arrayIndex).nullable;
  }

  Integer getScaleOrLength(int parameterIndex) {
    int arrayIndex = parameterIndex - 1;
    if (arrayIndex >= parametersList.size() || parametersList.get(arrayIndex) == null) return null;
    return parametersList.get(arrayIndex).scaleOrLength;
  }

  String getColumn(int parameterIndex) {
    int arrayIndex = parameterIndex - 1;
    if (arrayIndex >= parametersList.size() || parametersList.get(arrayIndex) == null) return null;
    return parametersList.get(arrayIndex).column;
  }

  String getTable() {
    return table;
  }

  void setTable(String table) {
    this.table = table;
  }

  void setColumn(int parameterIndex, String column) throws SQLException {
    setParameter(
        parameterIndex,
        getParameter(parameterIndex),
        getType(parameterIndex),
        getScaleOrLength(parameterIndex),
        column);
  }

  void setType(int parameterIndex, Integer type) throws SQLException {
    setParameter(
        parameterIndex,
        getParameter(parameterIndex),
        type,
        getScaleOrLength(parameterIndex),
        getColumn(parameterIndex));
  }

  void setParameter(int parameterIndex, Object value, Integer sqlType) throws SQLException {
    setParameter(parameterIndex, value, sqlType, null);
  }

  void setParameter(int parameterIndex, Object value, Integer sqlType, Integer scaleOrLength)
      throws SQLException {
    setParameter(parameterIndex, value, sqlType, scaleOrLength, null);
  }

  void setParameter(
      int parameterIndex, Object value, Integer sqlType, Integer scaleOrLength, String column)
      throws SQLException {
    // check that only valid type/value combinations are entered
    if (sqlType != null) {
      checkTypeAndValueSupported(value, sqlType);
    }
    // set the parameter
    highestIndex = Math.max(parameterIndex, highestIndex);
    int arrayIndex = parameterIndex - 1;
    if (arrayIndex >= parametersList.size() || parametersList.get(arrayIndex) == null) {
      parametersList.ensureCapacity(parameterIndex);
      while (parametersList.size() < parameterIndex) {
        parametersList.add(null);
      }
      parametersList.set(arrayIndex, new JdbcParameter());
    }
    JdbcParameter param = parametersList.get(arrayIndex);
    param.value = value;
    param.type = sqlType;
    param.scaleOrLength = scaleOrLength;
    param.column = column;
  }

  private void checkTypeAndValueSupported(Object value, int sqlType) throws SQLException {
    if (!isTypeSupported(sqlType)) {
      throw JdbcSqlExceptionFactory.of(
          "Type " + sqlType + " is not supported", Code.INVALID_ARGUMENT);
    }
    if (!isValidTypeAndValue(value, sqlType)) {
      throw JdbcSqlExceptionFactory.of(
          value + " is not a valid value for type " + sqlType, Code.INVALID_ARGUMENT);
    }
  }

  private boolean isTypeSupported(int sqlType) {
    switch (sqlType) {
      case Types.BIT:
      case Types.BOOLEAN:
      case Types.TINYINT:
      case Types.SMALLINT:
      case Types.INTEGER:
      case Types.BIGINT:
      case Types.FLOAT:
      case Types.REAL:
      case Types.DOUBLE:
      case Types.CHAR:
      case Types.VARCHAR:
      case Types.LONGVARCHAR:
      case Types.NCHAR:
      case Types.NVARCHAR:
      case Types.LONGNVARCHAR:
      case Types.DATE:
      case Types.TIME:
      case Types.TIMESTAMP:
      case Types.BINARY:
      case Types.VARBINARY:
      case Types.LONGVARBINARY:
      case Types.ARRAY:
      case Types.BLOB:
      case Types.CLOB:
      case Types.NCLOB:
        return true;
      case Types.NUMERIC:
      case Types.DECIMAL:
        // currently not supported as Cloud Spanner does not have any decimal data type.
        return false;
    }
    return false;
  }

  private boolean isValidTypeAndValue(Object value, int sqlType) {
    if (value == null) {
      return true;
    }
    switch (sqlType) {
      case Types.BIT:
      case Types.BOOLEAN:
        return value instanceof Boolean || value instanceof Number;
      case Types.TINYINT:
      case Types.SMALLINT:
      case Types.INTEGER:
      case Types.BIGINT:
      case Types.FLOAT:
      case Types.REAL:
      case Types.DOUBLE:
        return value instanceof Number;
      case Types.NUMERIC:
      case Types.DECIMAL:
        // currently not supported as Cloud Spanner does not have any decimal data type.
        return false;
      case Types.CHAR:
      case Types.VARCHAR:
      case Types.LONGVARCHAR:
      case Types.NCHAR:
      case Types.NVARCHAR:
      case Types.LONGNVARCHAR:
        return value instanceof String
            || value instanceof InputStream
            || value instanceof Reader
            || value instanceof URL;
      case Types.DATE:
      case Types.TIME:
      case Types.TIMESTAMP:
        return value instanceof Date || value instanceof Time || value instanceof Timestamp;
      case Types.BINARY:
      case Types.VARBINARY:
      case Types.LONGVARBINARY:
        return value instanceof byte[] || value instanceof InputStream;
      case Types.ARRAY:
        return value instanceof Array;
      case Types.BLOB:
        return value instanceof Blob || value instanceof InputStream;
      case Types.CLOB:
        return value instanceof Clob || value instanceof Reader;
      case Types.NCLOB:
        return value instanceof NClob || value instanceof Reader;
    }
    return false;
  }

  /** Return the highest param index in use in this store. */
  int getHighestIndex() {
    return highestIndex;
  }

  /** Fetch parameter metadata from the database. */
  void fetchMetaData(Connection connection) throws SQLException {
    if (table != null && !"".equals(table)) {
      try (ResultSet rsCols = connection.getMetaData().getColumns(null, null, table, null)) {
        while (rsCols.next()) {
          String col = rsCols.getString("COLUMN_NAME");
          int arrayIndex = getParameterArrayIndex(col);
          if (arrayIndex > -1) {
            JdbcParameter param = parametersList.get(arrayIndex);
            if (param != null) {
              param.scaleOrLength = rsCols.getInt("COLUMN_SIZE");
              param.type = rsCols.getInt("DATA_TYPE");
              param.nullable = rsCols.getInt("NULLABLE");
            }
          }
        }
      }
    }
  }

  private int getParameterArrayIndex(String columnName) {
    if (columnName != null) {
      for (int index = 0; index < highestIndex; index++) {
        JdbcParameter param = parametersList.get(index);
        if (param != null && param.column != null) {
          if (columnName.equalsIgnoreCase(param.column)) {
            return index;
          }
        }
      }
    }
    return -1;
  }

  /** Parameter information with positional parameters translated to named parameters. */
  static class ParametersInfo {
    final int numberOfParameters;
    final String sqlWithNamedParameters;

    private ParametersInfo(int numberOfParameters, String sqlWithNamedParameters) {
      this.numberOfParameters = numberOfParameters;
      this.sqlWithNamedParameters = sqlWithNamedParameters;
    }
  }

  /**
   * Converts all positional parameters (?) in the given sql string into named parameters. The
   * parameters are named @p1, @p2, etc. This method is used when converting a JDBC statement that
   * uses positional parameters to a Cloud Spanner {@link Statement} instance that requires named
   * parameters. The input SQL string may not contain any comments.
   *
   * @param sql The sql string without comments that should be converted
   * @return A {@link ParametersInfo} object containing a string with named parameters instead of
   *     positional parameters and the number of parameters.
   * @throws JdbcSqlExceptionImpl If the input sql string contains an unclosed string/byte literal.
   */
  static ParametersInfo convertPositionalParametersToNamedParameters(String sql)
      throws SQLException {
    final char POS_PARAM = '?';
    final char SINGLE_QUOTE = '\'';
    final char DOUBLE_QUOTE = '"';
    final char BACKTICK_QUOTE = '`';
    boolean isInQuoted = false;
    char startQuote = 0;
    boolean lastCharWasEscapeChar = false;
    boolean isTripleQuoted = false;
    int paramIndex = 1;
    StringBuilder named = new StringBuilder(sql.length() + countOccurrencesOf(POS_PARAM, sql));
    for (int index = 0; index < sql.length(); index++) {
      char c = sql.charAt(index);
      if (isInQuoted) {
        if ((c == '\n' || c == '\r') && !isTripleQuoted) {
          throw JdbcSqlExceptionFactory.of(
              "SQL statement contains an unclosed literal: " + sql, Code.INVALID_ARGUMENT);
        } else if (c == startQuote) {
          if (lastCharWasEscapeChar) {
            lastCharWasEscapeChar = false;
          } else if (isTripleQuoted) {
            if (sql.length() > index + 2
                && sql.charAt(index + 1) == startQuote
                && sql.charAt(index + 2) == startQuote) {
              isInQuoted = false;
              startQuote = 0;
              isTripleQuoted = false;
            }
          } else {
            isInQuoted = false;
            startQuote = 0;
          }
        } else if (c == '\\') {
          lastCharWasEscapeChar = true;
        } else {
          lastCharWasEscapeChar = false;
        }
        named.append(c);
      } else {
        if (c == POS_PARAM) {
          named.append("@p" + paramIndex);
          paramIndex++;
        } else {
          if (c == SINGLE_QUOTE || c == DOUBLE_QUOTE || c == BACKTICK_QUOTE) {
            isInQuoted = true;
            startQuote = c;
            // check whether it is a triple-quote
            if (sql.length() > index + 2
                && sql.charAt(index + 1) == startQuote
                && sql.charAt(index + 2) == startQuote) {
              isTripleQuoted = true;
            }
          }
          named.append(c);
        }
      }
    }
    if (isInQuoted) {
      throw JdbcSqlExceptionFactory.of(
          "SQL statement contains an unclosed literal: " + sql, Code.INVALID_ARGUMENT);
    }
    return new ParametersInfo(paramIndex - 1, named.toString());
  }

  /** Convenience method that is used to estimate the number of parameters in a SQL statement. */
  private static int countOccurrencesOf(char c, String string) {
    int res = 0;
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == c) {
        res++;
      }
    }
    return res;
  }

  /** Bind a JDBC parameter to a parameter on a Spanner {@link Statement}. */
  Builder bindParameterValue(ValueBinder<Builder> binder, int index) throws SQLException {
    return setValue(binder, getParameter(index), getType(index));
  }

  /** Set a value from a JDBC parameter on a Spanner {@link Statement}. */
  Builder setValue(ValueBinder<Builder> binder, Object value, Integer sqlType) throws SQLException {
    Builder res;
    if (sqlType != null && sqlType == Types.ARRAY) {
      if (value instanceof Array) {
        Array array = (Array) value;
        value = array.getArray();
        sqlType = array.getBaseType();
      }
      res = setArrayValue(binder, sqlType, value);
    } else {
      res = setSingleValue(binder, value, sqlType);
    }
    if (res == null && value != null) {
      throw JdbcSqlExceptionFactory.of(
          "Unsupported parameter type: " + value.getClass().getName() + " - " + value.toString(),
          Code.INVALID_ARGUMENT);
    }
    return res;
  }

  private Builder setSingleValue(ValueBinder<Builder> binder, Object value, Integer sqlType)
      throws SQLException {
    if (value == null) {
      return setNullValue(binder, sqlType);
    } else if (sqlType == null || sqlType == Integer.valueOf(Types.OTHER)) {
      return setParamWithUnknownType(binder, value);
    } else {
      return setParamWithKnownType(binder, value, sqlType);
    }
  }

  /** Set a JDBC parameter value on a Spanner {@link Statement} with a known SQL type. */
  private Builder setParamWithKnownType(ValueBinder<Builder> binder, Object value, Integer sqlType)
      throws SQLException {
    switch (sqlType) {
      case Types.BIT:
      case Types.BOOLEAN:
        if (value instanceof Boolean) {
          return binder.to((Boolean) value);
        } else if (value instanceof Number) {
          return binder.to(((Number) value).longValue() != 0L);
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid boolean", Code.INVALID_ARGUMENT);
      case Types.TINYINT:
      case Types.SMALLINT:
      case Types.INTEGER:
      case Types.BIGINT:
        if (value instanceof Number) {
          return binder.to(((Number) value).longValue());
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid long", Code.INVALID_ARGUMENT);
      case Types.FLOAT:
      case Types.REAL:
      case Types.DOUBLE:
        if (value instanceof Number) {
          return binder.to(((Number) value).doubleValue());
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid double", Code.INVALID_ARGUMENT);
      case Types.NUMERIC:
      case Types.DECIMAL:
        // currently not supported as Cloud Spanner does not have any decimal data type.
        throw JdbcSqlExceptionFactory.of(
            "DECIMAL/NUMERIC values are not supported", Code.INVALID_ARGUMENT);
      case Types.CHAR:
      case Types.VARCHAR:
      case Types.LONGVARCHAR:
      case Types.NCHAR:
      case Types.NVARCHAR:
      case Types.LONGNVARCHAR:
        if (value instanceof String) {
          return binder.to((String) value);
        } else if (value instanceof InputStream) {
          InputStreamReader reader =
              new InputStreamReader((InputStream) value, StandardCharsets.US_ASCII);
          try {
            return binder.to(CharStreams.toString(reader));
          } catch (IOException e) {
            throw JdbcSqlExceptionFactory.of(
                "could not set string from input stream", Code.INVALID_ARGUMENT, e);
          }
        } else if (value instanceof Reader) {
          try {
            return binder.to(CharStreams.toString((Reader) value));
          } catch (IOException e) {
            throw JdbcSqlExceptionFactory.of(
                "could not set string from reader", Code.INVALID_ARGUMENT, e);
          }
        } else if (value instanceof URL) {
          return binder.to(((URL) value).toString());
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid string", Code.INVALID_ARGUMENT);
      case Types.DATE:
        if (value instanceof Date) {
          return binder.to(JdbcTypeConverter.toGoogleDate((Date) value));
        } else if (value instanceof Time) {
          return binder.to(JdbcTypeConverter.toGoogleDate((Time) value));
        } else if (value instanceof Timestamp) {
          return binder.to(JdbcTypeConverter.toGoogleDate((Timestamp) value));
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid date", Code.INVALID_ARGUMENT);
      case Types.TIME:
      case Types.TIMESTAMP:
        if (value instanceof Date) {
          return binder.to(JdbcTypeConverter.toGoogleTimestamp((Date) value));
        } else if (value instanceof Time) {
          return binder.to(JdbcTypeConverter.toGoogleTimestamp((Time) value));
        } else if (value instanceof Timestamp) {
          return binder.to(JdbcTypeConverter.toGoogleTimestamp((Timestamp) value));
        }
        throw JdbcSqlExceptionFactory.of(
            value + " is not a valid timestamp", Code.INVALID_ARGUMENT);
      case Types.BINARY:
      case Types.VARBINARY:
      case Types.LONGVARBINARY:
        if (value instanceof byte[]) {
          return binder.to(ByteArray.copyFrom((byte[]) value));
        } else if (value instanceof InputStream) {
          try {
            return binder.to(ByteArray.copyFrom((InputStream) value));
          } catch (IOException e) {
            throw JdbcSqlExceptionFactory.of(
                "Could not copy bytes from input stream: " + e.getMessage(),
                Code.INVALID_ARGUMENT,
                e);
          }
        }
        throw JdbcSqlExceptionFactory.of(
            value + " is not a valid byte array", Code.INVALID_ARGUMENT);
      case Types.ARRAY:
        if (value instanceof Array) {
          Array jdbcArray = (Array) value;
          return setArrayValue(binder, sqlType, jdbcArray == null ? null : jdbcArray.getArray());
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid array", Code.INVALID_ARGUMENT);
      case Types.BLOB:
        if (value instanceof Blob) {
          try {
            return binder.to(ByteArray.copyFrom(((Blob) value).getBinaryStream()));
          } catch (IOException e) {
            throw JdbcSqlExceptionFactory.of(
                "could not set bytes from blob", Code.INVALID_ARGUMENT, e);
          }
        } else if (value instanceof InputStream) {
          try {
            return binder.to(ByteArray.copyFrom((InputStream) value));
          } catch (IOException e) {
            throw JdbcSqlExceptionFactory.of(
                "could not set bytes from input stream", Code.INVALID_ARGUMENT, e);
          }
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid blob", Code.INVALID_ARGUMENT);
      case Types.CLOB:
      case Types.NCLOB:
        if (value instanceof Clob) {
          try {
            return binder.to(CharStreams.toString(((Clob) value).getCharacterStream()));
          } catch (IOException e) {
            throw JdbcSqlExceptionFactory.of(
                "could not set string from clob", Code.INVALID_ARGUMENT, e);
          }
        } else if (value instanceof Reader) {
          try {
            return binder.to(CharStreams.toString((Reader) value));
          } catch (IOException e) {
            throw JdbcSqlExceptionFactory.of(
                "could not set string from reader", Code.INVALID_ARGUMENT, e);
          }
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid clob", Code.INVALID_ARGUMENT);
    }
    return null;
  }

  /** Set the parameter value based purely on the type of the value. */
  private Builder setParamWithUnknownType(ValueBinder<Builder> binder, Object value)
      throws SQLException {
    if (Boolean.class.isAssignableFrom(value.getClass())) {
      return binder.to((Boolean) value);
    } else if (Byte.class.isAssignableFrom(value.getClass())) {
      return binder.to(((Byte) value).longValue());
    } else if (Short.class.isAssignableFrom(value.getClass())) {
      return binder.to(((Short) value).longValue());
    } else if (Integer.class.isAssignableFrom(value.getClass())) {
      return binder.to(((Integer) value).longValue());
    } else if (Long.class.isAssignableFrom(value.getClass())) {
      return binder.to(((Long) value).longValue());
    } else if (Float.class.isAssignableFrom(value.getClass())) {
      return binder.to(((Float) value).doubleValue());
    } else if (Double.class.isAssignableFrom(value.getClass())) {
      return binder.to(((Double) value).doubleValue());
    } else if (BigDecimal.class.isAssignableFrom(value.getClass())) {
      // currently not supported
      return null;
    } else if (Date.class.isAssignableFrom(value.getClass())) {
      Date dateValue = (Date) value;
      return binder.to(JdbcTypeConverter.toGoogleDate(dateValue));
    } else if (Timestamp.class.isAssignableFrom(value.getClass())) {
      return binder.to(JdbcTypeConverter.toGoogleTimestamp((Timestamp) value));
    } else if (Time.class.isAssignableFrom(value.getClass())) {
      Time timeValue = (Time) value;
      return binder.to(JdbcTypeConverter.toGoogleTimestamp(new Timestamp(timeValue.getTime())));
    } else if (String.class.isAssignableFrom(value.getClass())) {
      String stringVal = (String) value;
      return binder.to(stringVal);
    } else if (Reader.class.isAssignableFrom(value.getClass())) {
      try {
        Reader readable = (Reader) value;
        return binder.to(CharStreams.toString(readable));
      } catch (IOException e) {
        throw new IllegalArgumentException("Could not read from readable", e);
      }
    } else if (Clob.class.isAssignableFrom(value.getClass())
        || NClob.class.isAssignableFrom(value.getClass())) {
      try {
        Clob clob = (Clob) value;
        return binder.to(CharStreams.toString(clob.getCharacterStream()));
      } catch (IOException e) {
        throw new IllegalArgumentException("Could not read from readable", e);
      }
    } else if (Character.class.isAssignableFrom(value.getClass())) {
      return binder.to(((Character) value).toString());
    } else if (Character[].class.isAssignableFrom(value.getClass())) {
      List<Character> list = Arrays.asList((Character[]) value);
      StringBuilder s = new StringBuilder();
      for (Character c : list) {
        s.append(c.charValue());
      }
      return binder.to(s.toString());
    } else if (char[].class.isAssignableFrom(value.getClass())) {
      return binder.to(String.valueOf((char[]) value));
    } else if (URL.class.isAssignableFrom(value.getClass())) {
      return binder.to(((URL) value).toString());
    } else if (byte[].class.isAssignableFrom(value.getClass())) {
      return binder.to(ByteArray.copyFrom((byte[]) value));
    } else if (InputStream.class.isAssignableFrom(value.getClass())) {
      try {
        return binder.to(ByteArray.copyFrom((InputStream) value));
      } catch (IOException e) {
        throw new IllegalArgumentException(
            "Could not copy bytes from input stream: " + e.getMessage(), e);
      }
    } else if (Blob.class.isAssignableFrom(value.getClass())) {
      try {
        return binder.to(ByteArray.copyFrom(((Blob) value).getBinaryStream()));
      } catch (IOException e) {
        throw new IllegalArgumentException(
            "Could not copy bytes from input stream: " + e.getMessage(), e);
      }
    } else if (Array.class.isAssignableFrom(value.getClass())) {
      try {
        Array jdbcArray = (Array) value;
        if (value != null) {
          return setArrayValue(binder, jdbcArray.getBaseType(), jdbcArray.getArray());
        }
      } catch (SQLException e) {
        throw new IllegalArgumentException(
            "Unsupported parameter type: " + value.getClass().getName() + " - " + value.toString());
      }
    }
    return null;
  }

  private Builder setArrayValue(ValueBinder<Builder> binder, int type, Object value)
      throws SQLException {
    if (value == null) {
      switch (type) {
        case Types.BIT:
        case Types.BOOLEAN:
          return binder.toBoolArray((boolean[]) null);
        case Types.TINYINT:
        case Types.SMALLINT:
        case Types.INTEGER:
        case Types.BIGINT:
          return binder.toInt64Array((long[]) null);
        case Types.FLOAT:
        case Types.REAL:
        case Types.DOUBLE:
          return binder.toFloat64Array((double[]) null);
        case Types.NUMERIC:
        case Types.DECIMAL:
          throw JdbcSqlExceptionFactory.of(
              "DECIMAL/NUMERIC values are not supported", Code.INVALID_ARGUMENT);
        case Types.CHAR:
        case Types.VARCHAR:
        case Types.LONGVARCHAR:
        case Types.NCHAR:
        case Types.NVARCHAR:
        case Types.LONGNVARCHAR:
        case Types.CLOB:
        case Types.NCLOB:
          return binder.toStringArray((Iterable<String>) null);
        case Types.DATE:
          return binder.toDateArray((Iterable<com.google.cloud.Date>) null);
        case Types.TIME:
        case Types.TIMESTAMP:
          return binder.toTimestampArray((Iterable<com.google.cloud.Timestamp>) null);
        case Types.BINARY:
        case Types.VARBINARY:
        case Types.LONGVARBINARY:
        case Types.BLOB:
          return binder.toBytesArray((Iterable<ByteArray>) null);
      }
      throw JdbcSqlExceptionFactory.unsupported("Unknown/unsupported array base type: " + type);
    }

    if (boolean[].class.isAssignableFrom(value.getClass())) {
      return binder.toBoolArray((boolean[]) value);
    } else if (Boolean[].class.isAssignableFrom(value.getClass())) {
      return binder.toBoolArray(Arrays.asList((Boolean[]) value));
    } else if (short[].class.isAssignableFrom(value.getClass())) {
      long[] l = new long[((short[]) value).length];
      for (int i = 0; i < l.length; i++) {
        l[i] = ((short[]) value)[i];
      }
      return binder.toInt64Array(l);
    } else if (Short[].class.isAssignableFrom(value.getClass())) {
      return binder.toInt64Array(toLongList((Short[]) value));
    } else if (int[].class.isAssignableFrom(value.getClass())) {
      long[] l = new long[((int[]) value).length];
      for (int i = 0; i < l.length; i++) {
        l[i] = ((int[]) value)[i];
      }
      return binder.toInt64Array(l);
    } else if (Integer[].class.isAssignableFrom(value.getClass())) {
      return binder.toInt64Array(toLongList((Integer[]) value));
    } else if (long[].class.isAssignableFrom(value.getClass())) {
      return binder.toInt64Array((long[]) value);
    } else if (Long[].class.isAssignableFrom(value.getClass())) {
      return binder.toInt64Array(toLongList((Long[]) value));
    } else if (float[].class.isAssignableFrom(value.getClass())) {
      double[] l = new double[((float[]) value).length];
      for (int i = 0; i < l.length; i++) {
        l[i] = ((float[]) value)[i];
      }
      return binder.toFloat64Array(l);
    } else if (Float[].class.isAssignableFrom(value.getClass())) {
      return binder.toFloat64Array(toDoubleList((Float[]) value));
    } else if (double[].class.isAssignableFrom(value.getClass())) {
      return binder.toFloat64Array((double[]) value);
    } else if (Double[].class.isAssignableFrom(value.getClass())) {
      return binder.toFloat64Array(toDoubleList((Double[]) value));
    } else if (BigDecimal[].class.isAssignableFrom(value.getClass())) {
      // currently not supported
      return null;
    } else if (Date[].class.isAssignableFrom(value.getClass())) {
      return binder.toDateArray(JdbcTypeConverter.toGoogleDates((Date[]) value));
    } else if (Timestamp[].class.isAssignableFrom(value.getClass())) {
      return binder.toTimestampArray(JdbcTypeConverter.toGoogleTimestamps((Timestamp[]) value));
    } else if (String[].class.isAssignableFrom(value.getClass())) {
      return binder.toStringArray(Arrays.asList((String[]) value));
    } else if (byte[][].class.isAssignableFrom(value.getClass())) {
      return binder.toBytesArray(JdbcTypeConverter.toGoogleBytes((byte[][]) value));
    }
    return null;
  }

  private List<Long> toLongList(Number[] input) {
    List<Long> res = new ArrayList<>(input.length);
    for (int i = 0; i < input.length; i++) {
      res.add(input[i] == null ? null : input[i].longValue());
    }
    return res;
  }

  private List<Double> toDoubleList(Number[] input) {
    List<Double> res = new ArrayList<>(input.length);
    for (int i = 0; i < input.length; i++) {
      res.add(input[i] == null ? null : input[i].doubleValue());
    }
    return res;
  }

  /**
   * Sets a null value with a specific SQL type. If the sqlType is null, the value will be set as a
   * String.
   */
  private Builder setNullValue(ValueBinder<Builder> binder, Integer sqlType) throws SQLException {
    if (sqlType == null) {
      return binder.to((String) null);
    }
    switch (sqlType) {
      case Types.BIGINT:
        return binder.to((Long) null);
      case Types.BINARY:
        return binder.to((ByteArray) null);
      case Types.BLOB:
        return binder.to((ByteArray) null);
      case Types.BOOLEAN:
        return binder.to((Boolean) null);
      case Types.CHAR:
        return binder.to((String) null);
      case Types.CLOB:
        return binder.to((String) null);
      case Types.DATE:
        return binder.to((com.google.cloud.Date) null);
      case Types.NUMERIC:
      case Types.DECIMAL:
        // currently not supported
        throw JdbcSqlExceptionFactory.of(
            "DECIMAL/NUMERIC values are not supported", Code.INVALID_ARGUMENT);
      case Types.DOUBLE:
        return binder.to((Double) null);
      case Types.FLOAT:
        return binder.to((Double) null);
      case Types.INTEGER:
        return binder.to((Long) null);
      case Types.LONGNVARCHAR:
        return binder.to((String) null);
      case Types.LONGVARBINARY:
        return binder.to((ByteArray) null);
      case Types.LONGVARCHAR:
        return binder.to((String) null);
      case Types.NCHAR:
        return binder.to((String) null);
      case Types.NCLOB:
        return binder.to((String) null);
      case Types.NVARCHAR:
        return binder.to((String) null);
      case Types.REAL:
        return binder.to((Double) null);
      case Types.SMALLINT:
        return binder.to((Long) null);
      case Types.SQLXML:
        return binder.to((String) null);
      case Types.TIME:
        return binder.to((com.google.cloud.Timestamp) null);
      case Types.TIMESTAMP:
        return binder.to((com.google.cloud.Timestamp) null);
      case Types.TINYINT:
        return binder.to((Long) null);
      case Types.VARBINARY:
        return binder.to((ByteArray) null);
      case Types.VARCHAR:
        return binder.to((String) null);
      default:
        throw new IllegalArgumentException("Unsupported sql type for setting to null: " + sqlType);
    }
  }
}

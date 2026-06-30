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
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Statement.Builder;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.ValueBinder;
import com.google.common.io.CharStreams;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Message;
import com.google.protobuf.NullValue;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.rpc.Code;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
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
import java.sql.SQLType;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

  private final Dialect dialect;

  JdbcParameterStore(Dialect dialect) {
    this.dialect = dialect;
  }

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
        column,
        null);
  }

  void setType(int parameterIndex, Integer type) throws SQLException {
    setParameter(
        parameterIndex,
        getParameter(parameterIndex),
        type,
        getScaleOrLength(parameterIndex),
        getColumn(parameterIndex),
        null);
  }

  /** Sets a parameter value. The type will be determined based on the type of the value. */
  void setParameter(int parameterIndex, Object value) throws SQLException {
    setParameter(parameterIndex, value, null, null, null, null);
  }

  /** Sets a parameter value as the specified vendor-specific {@link SQLType}. */
  void setParameter(int parameterIndex, Object value, SQLType sqlType) throws SQLException {
    setParameter(parameterIndex, value, null, null, null, sqlType);
  }

  /**
   * Sets a parameter value as the specified vendor-specific {@link SQLType} with the specified
   * scale or length. This method is only here to support the {@link
   * PreparedStatement#setObject(int, Object, SQLType, int)} method.
   */
  void setParameter(int parameterIndex, Object value, SQLType sqlType, Integer scaleOrLength)
      throws SQLException {
    setParameter(parameterIndex, value, null, scaleOrLength, null, sqlType);
  }

  /**
   * Sets a parameter value as the specified sql type. The type can be one of the constants in
   * {@link Types} or a vendor specific type code supplied by a vendor specific {@link SQLType}.
   */
  void setParameter(int parameterIndex, Object value, Integer sqlType) throws SQLException {
    setParameter(parameterIndex, value, sqlType, null);
  }

  /**
   * Sets a parameter value as the specified sql type with the specified scale or length. The type
   * can be one of the constants in {@link Types} or a vendor specific type code supplied by a
   * vendor specific {@link SQLType}.
   */
  void setParameter(int parameterIndex, Object value, Integer sqlType, Integer scaleOrLength)
      throws SQLException {
    setParameter(parameterIndex, value, sqlType, scaleOrLength, null, null);
  }

  /**
   * Sets a parameter value as the specified sql type with the specified scale or length. Any {@link
   * SQLType} instance will take precedence over sqlType. The type can be one of the constants in
   * {@link Types} or a vendor specific type code supplied by a vendor specific {@link SQLType}.
   */
  void setParameter(
      int parameterIndex,
      Object value,
      Integer sqlType,
      Integer scaleOrLength,
      String column,
      SQLType sqlTypeObject)
      throws SQLException {
    // Ignore the sql type if the application has created a Spanner Value object.
    if (!(value instanceof Value)) {
      // check that only valid type/value combinations are entered
      if (sqlTypeObject != null && sqlType == null) {
        sqlType = sqlTypeObject.getVendorTypeNumber();
      }
      if (sqlType != null) {
        checkTypeAndValueSupported(value, sqlType);
      }
    } // set the parameter
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
    if (value == null) {
      // null is always supported, as we will just fall back to an untyped NULL value.
      return;
    }
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
      case Types.TIME_WITH_TIMEZONE:
      case Types.TIMESTAMP:
      case Types.TIMESTAMP_WITH_TIMEZONE:
      case Types.BINARY:
      case Types.VARBINARY:
      case Types.LONGVARBINARY:
      case Types.ARRAY:
      case Types.BLOB:
      case Types.CLOB:
      case Types.NCLOB:
      case Types.NUMERIC:
      case Types.DECIMAL:
      case JsonType.VENDOR_TYPE_NUMBER:
      case JsonType.SHORT_VENDOR_TYPE_NUMBER:
      case PgJsonbType.VENDOR_TYPE_NUMBER:
      case PgJsonbType.SHORT_VENDOR_TYPE_NUMBER:
      case ProtoMessageType.VENDOR_TYPE_NUMBER:
      case ProtoMessageType.SHORT_VENDOR_TYPE_NUMBER:
      case ProtoEnumType.VENDOR_TYPE_NUMBER:
      case ProtoEnumType.SHORT_VENDOR_TYPE_NUMBER:
        return true;
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
      case Types.NUMERIC:
      case Types.DECIMAL:
        return value instanceof Number || value instanceof ProtocolMessageEnum;
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
        return value instanceof Date
            || value instanceof Time
            || value instanceof Timestamp
            || value instanceof LocalDate;
      case Types.TIME:
      case Types.TIME_WITH_TIMEZONE:
      case Types.TIMESTAMP:
      case Types.TIMESTAMP_WITH_TIMEZONE:
        return value instanceof Date
            || value instanceof Time
            || value instanceof Timestamp
            || value instanceof OffsetDateTime;
      case Types.BINARY:
      case Types.VARBINARY:
      case Types.LONGVARBINARY:
        return value instanceof byte[]
            || value instanceof InputStream
            || value instanceof AbstractMessage;
      case Types.ARRAY:
        return value instanceof Array;
      case Types.BLOB:
        return value instanceof Blob || value instanceof InputStream;
      case Types.CLOB:
        return value instanceof Clob || value instanceof Reader;
      case Types.NCLOB:
        return value instanceof NClob || value instanceof Reader;
      case JsonType.VENDOR_TYPE_NUMBER:
      case JsonType.SHORT_VENDOR_TYPE_NUMBER:
        return value instanceof String
            || value instanceof InputStream
            || value instanceof Reader
            || (value instanceof Value && ((Value) value).getType().getCode() == Type.Code.JSON);
      case PgJsonbType.VENDOR_TYPE_NUMBER:
      case PgJsonbType.SHORT_VENDOR_TYPE_NUMBER:
        return value instanceof String
            || value instanceof InputStream
            || value instanceof Reader
            || (value instanceof Value
                && ((Value) value).getType().getCode() == Type.Code.PG_JSONB);
      case ProtoMessageType.VENDOR_TYPE_NUMBER:
      case ProtoMessageType.SHORT_VENDOR_TYPE_NUMBER:
        return value instanceof AbstractMessage || value instanceof byte[];
      case ProtoEnumType.VENDOR_TYPE_NUMBER:
      case ProtoEnumType.SHORT_VENDOR_TYPE_NUMBER:
        return value instanceof ProtocolMessageEnum || value instanceof Number;
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

  /** Bind a JDBC parameter to a parameter on a Spanner {@link Statement}. */
  Builder bindParameterValue(ValueBinder<Builder> binder, int index) throws SQLException {
    return setValue(binder, getParameter(index), getType(index));
  }

  /** Set a value from a JDBC parameter on a Spanner {@link Statement}. */
  Builder setValue(ValueBinder<Builder> binder, Object value, Integer sqlType) throws SQLException {
    Builder res;
    if (value instanceof Value) {
      // If a Value has been constructed, then that should override any sqlType that might have been
      // supplied.
      res = binder.to((Value) value);
    } else if (sqlType != null && sqlType == Types.ARRAY) {
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
          "Unsupported parameter type: " + value.getClass().getName() + " - " + value,
          Code.INVALID_ARGUMENT);
    }
    return res;
  }

  private Builder setSingleValue(ValueBinder<Builder> binder, Object value, Integer sqlType)
      throws SQLException {
    if (value == null) {
      return setNullValue(binder, sqlType);
    } else if (sqlType == null || sqlType.equals(Types.OTHER)) {
      return setParamWithUnknownType(binder, value);
    } else {
      return setParamWithKnownType(binder, value, sqlType);
    }
  }

  /** Set a JDBC parameter value on a Spanner {@link Statement} with a known SQL type. */
  private Builder setParamWithKnownType(ValueBinder<Builder> binder, Object value, Integer sqlType)
      throws SQLException {
    if (sqlType == null) {
      return null;
    }
    int type = sqlType;

    switch (type) {
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
        } else if (value instanceof ProtocolMessageEnum) {
          return binder.to((ProtocolMessageEnum) value);
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid long", Code.INVALID_ARGUMENT);
      case Types.REAL:
        if (value instanceof Number) {
          return binder.to(((Number) value).floatValue());
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid float", Code.INVALID_ARGUMENT);
      case Types.FLOAT:
      case Types.DOUBLE:
        if (value instanceof Number) {
          return binder.to(((Number) value).doubleValue());
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid double", Code.INVALID_ARGUMENT);
      case Types.NUMERIC:
      case Types.DECIMAL:
        if (dialect == Dialect.POSTGRESQL) {
          if (value instanceof Number) {
            return binder.to(Value.pgNumeric(value.toString()));
          }
          throw JdbcSqlExceptionFactory.of(value + " is not a valid Number", Code.INVALID_ARGUMENT);
        } else {
          if (value instanceof Number) {
            if (value instanceof BigDecimal) {
              return binder.to((BigDecimal) value);
            }
            try {
              return binder.to(new BigDecimal(value.toString()));
            } catch (NumberFormatException e) {
              // ignore and fall through to the exception.
            }
          }
          throw JdbcSqlExceptionFactory.of(
              value + " is not a valid BigDecimal", Code.INVALID_ARGUMENT);
        }
      case Types.CHAR:
      case Types.VARCHAR:
      case Types.LONGVARCHAR:
      case Types.NCHAR:
      case Types.NVARCHAR:
      case Types.LONGNVARCHAR:
        String stringValue;
        if (value instanceof String) {
          stringValue = (String) value;
        } else if (value instanceof InputStream) {
          stringValue = getStringFromInputStream((InputStream) value);
        } else if (value instanceof Reader) {
          stringValue = getStringFromReader((Reader) value);
        } else if (value instanceof URL) {
          stringValue = value.toString();
        } else if (value instanceof UUID) {
          stringValue = ((UUID) value).toString();
        } else {
          throw JdbcSqlExceptionFactory.of(value + " is not a valid string", Code.INVALID_ARGUMENT);
        }
        return binder.to(stringValue);
      case JsonType.VENDOR_TYPE_NUMBER:
      case JsonType.SHORT_VENDOR_TYPE_NUMBER:
      case PgJsonbType.VENDOR_TYPE_NUMBER:
      case PgJsonbType.SHORT_VENDOR_TYPE_NUMBER:
        String jsonValue;
        if (value instanceof String) {
          jsonValue = (String) value;
        } else if (value instanceof InputStream) {
          jsonValue = getStringFromInputStream((InputStream) value);
        } else if (value instanceof Reader) {
          jsonValue = getStringFromReader((Reader) value);
        } else {
          throw JdbcSqlExceptionFactory.of(
              value + " is not a valid JSON value", Code.INVALID_ARGUMENT);
        }
        if (type == PgJsonbType.VENDOR_TYPE_NUMBER
            || type == PgJsonbType.SHORT_VENDOR_TYPE_NUMBER) {
          return binder.to(Value.pgJsonb(jsonValue));
        }
        return binder.to(Value.json(jsonValue));
      case Types.DATE:
        if (value instanceof Date) {
          return binder.to(JdbcTypeConverter.toGoogleDate((Date) value));
        } else if (value instanceof Time) {
          return binder.to(JdbcTypeConverter.toGoogleDate((Time) value));
        } else if (value instanceof Timestamp) {
          return binder.to(JdbcTypeConverter.toGoogleDate((Timestamp) value));
        } else if (value instanceof LocalDate) {
          LocalDate localDate = (LocalDate) value;
          return binder.to(
              com.google.cloud.Date.fromYearMonthDay(
                  localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()));
        }
        throw JdbcSqlExceptionFactory.of(value + " is not a valid date", Code.INVALID_ARGUMENT);
      case Types.TIME:
      case Types.TIME_WITH_TIMEZONE:
      case Types.TIMESTAMP:
      case Types.TIMESTAMP_WITH_TIMEZONE:
        if (value instanceof Date) {
          return binder.to(JdbcTypeConverter.toGoogleTimestamp((Date) value));
        } else if (value instanceof Time) {
          return binder.to(JdbcTypeConverter.toGoogleTimestamp((Time) value));
        } else if (value instanceof Timestamp) {
          return binder.to(JdbcTypeConverter.toGoogleTimestamp((Timestamp) value));
        } else if (value instanceof OffsetDateTime) {
          OffsetDateTime offsetDateTime = (OffsetDateTime) value;
          return binder.to(
              com.google.cloud.Timestamp.ofTimeSecondsAndNanos(
                  offsetDateTime.toEpochSecond(), offsetDateTime.getNano()));
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
        } else if (value instanceof AbstractMessage) {
          return binder.to((AbstractMessage) value);
        }
        throw JdbcSqlExceptionFactory.of(
            value + " is not a valid byte array", Code.INVALID_ARGUMENT);
      case Types.ARRAY:
        if (value instanceof Array) {
          Array jdbcArray = (Array) value;
          return setArrayValue(binder, sqlType, jdbcArray.getArray());
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
      case ProtoMessageType.VENDOR_TYPE_NUMBER:
      case ProtoMessageType.SHORT_VENDOR_TYPE_NUMBER:
        if (value instanceof AbstractMessage) {
          return binder.to((AbstractMessage) value);
        } else if (value instanceof byte[]) {
          return binder.to(ByteArray.copyFrom((byte[]) value));
        } else {
          throw JdbcSqlExceptionFactory.of(
              value + " is not a valid PROTO value", Code.INVALID_ARGUMENT);
        }
      case ProtoEnumType.VENDOR_TYPE_NUMBER:
      case ProtoEnumType.SHORT_VENDOR_TYPE_NUMBER:
        if (value instanceof ProtocolMessageEnum) {
          return binder.to((ProtocolMessageEnum) value);
        } else if (value instanceof Number) {
          return binder.to(((Number) value).longValue());
        }
        throw JdbcSqlExceptionFactory.of(
            value + " is not a valid ENUM value", Code.INVALID_ARGUMENT);
    }
    return null;
  }

  private String getStringFromInputStream(InputStream inputStream) throws SQLException {
    InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
    try {
      return CharStreams.toString(reader);
    } catch (IOException e) {
      throw JdbcSqlExceptionFactory.of(
          "could not set string from input stream", Code.INVALID_ARGUMENT, e);
    }
  }

  private String getStringFromReader(Reader reader) throws SQLException {
    try {
      return CharStreams.toString(reader);
    } catch (IOException e) {
      throw JdbcSqlExceptionFactory.of(
          "could not set string from reader", Code.INVALID_ARGUMENT, e);
    }
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
      if (dialect == Dialect.POSTGRESQL) {
        return binder.to(Value.pgNumeric(value.toString()));
      } else {
        return binder.to((BigDecimal) value);
      }
    } else if (Date.class.isAssignableFrom(value.getClass())) {
      Date dateValue = (Date) value;
      return binder.to(JdbcTypeConverter.toGoogleDate(dateValue));
    } else if (LocalDate.class.isAssignableFrom(value.getClass())) {
      LocalDate localDate = (LocalDate) value;
      return binder.to(
          com.google.cloud.Date.fromYearMonthDay(
              localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()));
    } else if (Timestamp.class.isAssignableFrom(value.getClass())) {
      return binder.to(JdbcTypeConverter.toGoogleTimestamp((Timestamp) value));
    } else if (OffsetDateTime.class.isAssignableFrom(value.getClass())) {
      OffsetDateTime offsetDateTime = (OffsetDateTime) value;
      return binder.to(
          com.google.cloud.Timestamp.ofTimeSecondsAndNanos(
              offsetDateTime.toEpochSecond(), offsetDateTime.getNano()));
    } else if (Time.class.isAssignableFrom(value.getClass())) {
      Time timeValue = (Time) value;
      return binder.to(JdbcTypeConverter.toGoogleTimestamp(new Timestamp(timeValue.getTime())));
    } else if (UUID.class.isAssignableFrom(value.getClass())) {
      // Bind UUID values as untyped strings to allow them to be used with all types that support
      // string values (e.g. STRING, UUID).
      return binder.to(
          Value.untyped(
              com.google.protobuf.Value.newBuilder().setStringValue(value.toString()).build()));
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
    } else if (Clob.class.isAssignableFrom(value.getClass())) {
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
      return binder.to(value.toString());
    } else if (UUID.class.isAssignableFrom(value.getClass())) {
      return binder.to(((UUID) value).toString());
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
        return setArrayValue(binder, jdbcArray.getBaseType(), jdbcArray.getArray());
      } catch (SQLException e) {
        throw new IllegalArgumentException(
            "Unsupported parameter type: " + value.getClass().getName() + " - " + value);
      }
    } else if (AbstractMessage.class.isAssignableFrom(value.getClass())) {
      return binder.to((AbstractMessage) value);
    } else if (ProtocolMessageEnum.class.isAssignableFrom(value.getClass())) {
      return binder.to((ProtocolMessageEnum) value);
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
        case Types.REAL:
          return binder.toFloat32Array((float[]) null);
        case Types.FLOAT:
        case Types.DOUBLE:
          return binder.toFloat64Array((double[]) null);
        case Types.NUMERIC:
        case Types.DECIMAL:
          if (dialect == Dialect.POSTGRESQL) {
            return binder.toPgNumericArray(null);
          } else {
            return binder.toNumericArray(null);
          }
        case Types.CHAR:
        case Types.VARCHAR:
        case Types.LONGVARCHAR:
        case Types.NCHAR:
        case Types.NVARCHAR:
        case Types.LONGNVARCHAR:
        case Types.CLOB:
        case Types.NCLOB:
          return binder.toStringArray(null);
        case JsonType.VENDOR_TYPE_NUMBER:
        case JsonType.SHORT_VENDOR_TYPE_NUMBER:
          return binder.toJsonArray(null);
        case PgJsonbType.VENDOR_TYPE_NUMBER:
        case PgJsonbType.SHORT_VENDOR_TYPE_NUMBER:
          return binder.toPgJsonbArray(null);
        case Types.DATE:
          return binder.toDateArray(null);
        case Types.TIME:
        case Types.TIME_WITH_TIMEZONE:
        case Types.TIMESTAMP:
        case Types.TIMESTAMP_WITH_TIMEZONE:
          return binder.toTimestampArray(null);
        case Types.BINARY:
        case Types.VARBINARY:
        case Types.LONGVARBINARY:
        case Types.BLOB:
          return binder.toBytesArray(null);
        case ProtoMessageType.VENDOR_TYPE_NUMBER:
        case ProtoMessageType.SHORT_VENDOR_TYPE_NUMBER:
        case ProtoEnumType.VENDOR_TYPE_NUMBER:
        case ProtoEnumType.SHORT_VENDOR_TYPE_NUMBER:
          return binder.to(
              Value.untyped(
                  com.google.protobuf.Value.newBuilder()
                      .setNullValue(NullValue.NULL_VALUE)
                      .build()));
        case UuidType.VENDOR_TYPE_NUMBER:
        case UuidType.SHORT_VENDOR_TYPE_NUMBER:
          return binder.toUuidArray(null);
        default:
          return binder.to(
              Value.untyped(
                  com.google.protobuf.Value.newBuilder()
                      .setNullValue(NullValue.NULL_VALUE)
                      .build()));
      }
    }

    if (boolean[].class.isAssignableFrom(value.getClass())) {
      return binder.toBoolArray((boolean[]) value);
    } else if (Boolean[].class.isAssignableFrom(value.getClass())) {
      return binder.toBoolArray(Arrays.asList((Boolean[]) value));
    } else if (Byte[].class.isAssignableFrom(value.getClass())) {
      return binder.toInt64Array(toLongList((Byte[]) value));
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
      return binder.toFloat32Array((float[]) value);
    } else if (Float[].class.isAssignableFrom(value.getClass())) {
      return binder.toFloat32Array(toFloatList((Float[]) value));
    } else if (double[].class.isAssignableFrom(value.getClass())) {
      return binder.toFloat64Array((double[]) value);
    } else if (Double[].class.isAssignableFrom(value.getClass())) {
      return binder.toFloat64Array(toDoubleList((Double[]) value));
    } else if (BigDecimal[].class.isAssignableFrom(value.getClass())) {
      if (dialect == Dialect.POSTGRESQL) {
        return binder.toPgNumericArray(
            Arrays.stream((BigDecimal[]) value)
                .map(bigDecimal -> bigDecimal == null ? null : bigDecimal.toString())
                .collect(Collectors.toList()));
      } else {
        return binder.toNumericArray(Arrays.asList((BigDecimal[]) value));
      }
    } else if (Date[].class.isAssignableFrom(value.getClass())) {
      return binder.toDateArray(JdbcTypeConverter.toGoogleDates((Date[]) value));
    } else if (Timestamp[].class.isAssignableFrom(value.getClass())) {
      return binder.toTimestampArray(JdbcTypeConverter.toGoogleTimestamps((Timestamp[]) value));
    } else if (UUID[].class.isAssignableFrom(value.getClass())) {
      return binder.toUuidArray(Arrays.asList((UUID[]) value));
    } else if (String[].class.isAssignableFrom(value.getClass())) {
      if (type == JsonType.VENDOR_TYPE_NUMBER || type == JsonType.SHORT_VENDOR_TYPE_NUMBER) {
        return binder.toJsonArray(Arrays.asList((String[]) value));
      } else if (type == PgJsonbType.VENDOR_TYPE_NUMBER
          || type == PgJsonbType.SHORT_VENDOR_TYPE_NUMBER) {
        return binder.toPgJsonbArray(Arrays.asList((String[]) value));
      } else {
        return binder.toStringArray(Arrays.asList((String[]) value));
      }
    } else if (byte[][].class.isAssignableFrom(value.getClass())) {
      return binder.toBytesArray(JdbcTypeConverter.toGoogleBytes((byte[][]) value));
    } else if (AbstractMessage[].class.isAssignableFrom(value.getClass())) {
      return bindProtoMessageArray(binder, value);
    } else if (ProtocolMessageEnum[].class.isAssignableFrom(value.getClass())) {
      return bindProtoEnumArray(binder, value);
    }
    return null;
  }

  private Builder bindProtoMessageArray(ValueBinder<Builder> binder, Object value)
      throws SQLException {
    Class<?> componentType = value.getClass().getComponentType();
    int length = java.lang.reflect.Array.getLength(value);
    List<ByteArray> convertedArray = new ArrayList<>();
    try {
      Method method = componentType.getMethod("toByteArray");
      for (int i = 0; i < length; i++) {
        Object element = java.lang.reflect.Array.get(value, i);
        if (element != null) {
          byte[] l = (byte[]) method.invoke(element);
          convertedArray.add(ByteArray.copyFrom(l));
        } else {
          convertedArray.add(null);
        }
      }

      Message.Builder builder =
          (Message.Builder) componentType.getMethod("newBuilder").invoke(null);
      Descriptor msgDescriptor = builder.getDescriptorForType();

      return binder.toProtoMessageArray(convertedArray, msgDescriptor.getFullName());
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of(
          "Error occurred when binding Array of Proto Message input", Code.UNKNOWN, e);
    }
  }

  private Builder bindProtoEnumArray(ValueBinder<Builder> binder, Object value)
      throws SQLException {
    Class<?> componentType = value.getClass().getComponentType();
    int length = java.lang.reflect.Array.getLength(value);
    List<Long> convertedArray = new ArrayList<>();
    try {
      Method method = componentType.getMethod("getNumber");
      for (int i = 0; i < length; i++) {
        Object element = java.lang.reflect.Array.get(value, i);
        if (element != null) {
          int op = (int) method.invoke(element);
          convertedArray.add((long) op);
        } else {
          convertedArray.add(null);
        }
      }

      Descriptors.EnumDescriptor enumDescriptor =
          (Descriptors.EnumDescriptor) componentType.getMethod("getDescriptor").invoke(null);

      return binder.toProtoEnumArray(convertedArray, enumDescriptor.getFullName());
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of(
          "Error occurred when binding Array of Proto Enum input", Code.UNKNOWN, e);
    }
  }

  private List<Long> toLongList(Number[] input) {
    List<Long> res = new ArrayList<>(input.length);
    for (Number number : input) {
      res.add(number == null ? null : number.longValue());
    }
    return res;
  }

  private List<Float> toFloatList(Number[] input) {
    List<Float> res = new ArrayList<>(input.length);
    for (Number number : input) {
      res.add(number == null ? null : number.floatValue());
    }
    return res;
  }

  private List<Double> toDoubleList(Number[] input) {
    List<Double> res = new ArrayList<>(input.length);
    for (Number number : input) {
      res.add(number == null ? null : number.doubleValue());
    }
    return res;
  }

  /**
   * Sets a null value with a specific SQL type. If the sqlType is null, the value will be set as a
   * String.
   */
  private Builder setNullValue(ValueBinder<Builder> binder, Integer sqlType) {
    if (sqlType == null) {
      return binder.to(
          Value.untyped(
              com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build()));
    }
    int type = sqlType;
    switch (type) {
      case Types.BIGINT:
        return binder.to((Long) null);
      case Types.BINARY:
      case ProtoMessageType.VENDOR_TYPE_NUMBER:
      case ProtoEnumType.SHORT_VENDOR_TYPE_NUMBER:
        return binder.to((ByteArray) null);
      case Types.BLOB:
        return binder.to((ByteArray) null);
      case Types.BIT:
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
        if (dialect == Dialect.POSTGRESQL) {
          return binder.to(Value.pgNumeric(null));
        } else {
          return binder.to((BigDecimal) null);
        }
      case Types.FLOAT:
      case Types.DOUBLE:
        return binder.to((Double) null);
      case Types.INTEGER:
      case ProtoEnumType.VENDOR_TYPE_NUMBER:
      case ProtoMessageType.SHORT_VENDOR_TYPE_NUMBER:
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
        return binder.to((Float) null);
      case Types.SMALLINT:
        return binder.to((Long) null);
      case Types.SQLXML:
        return binder.to((String) null);
      case Types.TIME:
      case Types.TIME_WITH_TIMEZONE:
      case Types.TIMESTAMP:
      case Types.TIMESTAMP_WITH_TIMEZONE:
        return binder.to((com.google.cloud.Timestamp) null);
      case Types.TINYINT:
        return binder.to((Long) null);
      case Types.VARBINARY:
        return binder.to((ByteArray) null);
      case Types.VARCHAR:
        return binder.to((String) null);
      case JsonType.VENDOR_TYPE_NUMBER:
      case JsonType.SHORT_VENDOR_TYPE_NUMBER:
        return binder.to(Value.json(null));
      case PgJsonbType.VENDOR_TYPE_NUMBER:
      case PgJsonbType.SHORT_VENDOR_TYPE_NUMBER:
        return binder.to(Value.pgJsonb(null));
      default:
        return binder.to(
            Value.untyped(
                com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build()));
    }
  }
}

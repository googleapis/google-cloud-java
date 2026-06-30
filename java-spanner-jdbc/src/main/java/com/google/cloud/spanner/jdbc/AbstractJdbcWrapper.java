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

import static com.google.cloud.spanner.jdbc.JdbcTypeConverter.getMainTypeCode;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.Code;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.sql.Wrapper;
import java.util.Calendar;

/** Base class for all Cloud Spanner JDBC classes that implement the {@link Wrapper} interface. */
abstract class AbstractJdbcWrapper implements Wrapper {
  static final String OTHER_NAME = "OTHER";

  /**
   * Extract {@link java.sql.Types} code from Spanner {@link Type}.
   *
   * @param type The Cloud Spanner type to convert. May not be <code>null</code>.
   */
  static int extractColumnType(Type type) {
    Preconditions.checkNotNull(type);
    switch (getMainTypeCode(type)) {
      case BOOL:
        return Types.BOOLEAN;
      case BYTES:
      case PROTO:
        return Types.BINARY;
      case DATE:
        return Types.DATE;
      case FLOAT32:
        return Types.REAL;
      case FLOAT64:
        return Types.DOUBLE;
      case INT64:
      case ENUM:
        return Types.BIGINT;
      case NUMERIC:
      case PG_NUMERIC:
        return Types.NUMERIC;
      case STRING:
      case JSON:
      case PG_JSONB:
        return Types.NVARCHAR;
      case TIMESTAMP:
        return Types.TIMESTAMP;
      case ARRAY:
        return Types.ARRAY;
      case STRUCT:
      default:
        return Types.OTHER;
    }
  }

  static String getSpannerTypeName(Type type, Dialect dialect) {
    return Preconditions.checkNotNull(type).getSpannerTypeName(dialect);
  }

  static String getSpannerColumnTypeName(Type type, Dialect dialect) {
    if (dialect == Dialect.POSTGRESQL && type.getCode() == Code.ARRAY) {
      return "_" + getSpannerTypeName(type.getArrayElementType(), dialect);
    }
    return getSpannerTypeName(type, dialect);
  }

  /**
   * Extract Spanner type name from {@link java.sql.Types} code.
   *
   * @deprecated Use {@link #getSpannerTypeName(Type, Dialect)} instead.
   */
  @Deprecated
  static String getSpannerTypeName(int sqlType) {
    // TODO: Re-write to be dialect-aware (or remove all-together).
    if (sqlType == Types.BOOLEAN) return Type.bool().getCode().name();
    if (sqlType == Types.BINARY) return Type.bytes().getCode().name();
    if (sqlType == Types.DATE) return Type.date().getCode().name();
    if (sqlType == Types.REAL) {
      return Type.float32().getCode().name();
    }
    if (sqlType == Types.DOUBLE || sqlType == Types.FLOAT) return Type.float64().getCode().name();
    if (sqlType == Types.BIGINT
        || sqlType == Types.INTEGER
        || sqlType == Types.SMALLINT
        || sqlType == Types.TINYINT) return Type.int64().getCode().name();
    if (sqlType == Types.NUMERIC || sqlType == Types.DECIMAL)
      return Type.numeric().getCode().name();
    if (sqlType == Types.NVARCHAR) return Type.string().getCode().name();
    if (sqlType == Types.TIMESTAMP || sqlType == Types.TIMESTAMP_WITH_TIMEZONE)
      return Type.timestamp().getCode().name();
    if (sqlType == Types.ARRAY) return Code.ARRAY.name();

    return OTHER_NAME;
  }

  /**
   * Get corresponding Java class name from {@link java.sql.Types} code.
   *
   * @deprecated Use {@link #getClassName(Type)} instead.
   */
  @Deprecated
  static String getClassName(int sqlType) {
    if (sqlType == Types.BOOLEAN) return Boolean.class.getName();
    if (sqlType == Types.BINARY) return Byte[].class.getName();
    if (sqlType == Types.DATE) return Date.class.getName();
    if (sqlType == Types.REAL) {
      return Float.class.getName();
    }
    if (sqlType == Types.DOUBLE || sqlType == Types.FLOAT) return Double.class.getName();
    if (sqlType == Types.BIGINT
        || sqlType == Types.INTEGER
        || sqlType == Types.SMALLINT
        || sqlType == Types.TINYINT) return Long.class.getName();
    if (sqlType == Types.NUMERIC || sqlType == Types.DECIMAL) return BigDecimal.class.getName();
    if (sqlType == Types.NVARCHAR) return String.class.getName();
    if (sqlType == Types.TIMESTAMP || sqlType == Types.TIMESTAMP_WITH_TIMEZONE)
      return Timestamp.class.getName();
    if (sqlType == Types.ARRAY) return Object.class.getName();

    return null;
  }

  /**
   * Get corresponding Java class name from Spanner {@link Type}.
   *
   * @param type The Cloud Spanner type to convert. May not be <code>null</code>.
   */
  static String getClassName(Type type) {
    Preconditions.checkNotNull(type);
    switch (getMainTypeCode(type)) {
      case BOOL:
        return Boolean.class.getName();
      case BYTES:
      case PROTO:
        return byte[].class.getName();
      case DATE:
        return Date.class.getName();
      case FLOAT32:
        return Float.class.getName();
      case FLOAT64:
        return Double.class.getName();
      case INT64:
      case ENUM:
        return Long.class.getName();
      case NUMERIC:
      case PG_NUMERIC:
        return BigDecimal.class.getName();
      case STRING:
      case JSON:
      case PG_JSONB:
        return String.class.getName();
      case TIMESTAMP:
        return Timestamp.class.getName();
      case ARRAY:
        switch (getMainTypeCode(type.getArrayElementType())) {
          case BOOL:
            return Boolean[].class.getName();
          case BYTES:
          case PROTO:
            return byte[][].class.getName();
          case DATE:
            return Date[].class.getName();
          case FLOAT32:
            return Float[].class.getName();
          case FLOAT64:
            return Double[].class.getName();
          case INT64:
          case ENUM:
            return Long[].class.getName();
          case NUMERIC:
          case PG_NUMERIC:
            return BigDecimal[].class.getName();
          case STRING:
          case JSON:
          case PG_JSONB:
            return String[].class.getName();
          case TIMESTAMP:
            return Timestamp[].class.getName();
        }
      case STRUCT:
      default:
        return null;
    }
  }

  /** Standard error message for out-of-range values. */
  private static final String OUT_OF_RANGE_MSG = "Value out of range for %s: %s";

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static byte checkedCastToByte(long val) throws SQLException {
    if (val > Byte.MAX_VALUE || val < Byte.MIN_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "byte", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
    return (byte) val;
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static byte checkedCastToByte(BigDecimal val) throws SQLException {
    try {
      return val.byteValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "byte", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static byte checkedCastToByte(BigInteger val) throws SQLException {
    try {
      return val.byteValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "byte", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static short checkedCastToShort(long val) throws SQLException {
    if (val > Short.MAX_VALUE || val < Short.MIN_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "short", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
    return (short) val;
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static short checkedCastToShort(BigDecimal val) throws SQLException {
    try {
      return val.shortValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "short", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static short checkedCastToShort(BigInteger val) throws SQLException {
    try {
      return val.shortValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "short", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static int checkedCastToInt(long val) throws SQLException {
    if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "int", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
    return (int) val;
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static int checkedCastToInt(BigDecimal val) throws SQLException {
    try {
      return val.intValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "int", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static int checkedCastToInt(BigInteger val) throws SQLException {
    try {
      return val.intValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "int", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static float checkedCastToFloat(double val) throws SQLException {
    if (Double.isFinite(val) && (val > Float.MAX_VALUE || val < -Float.MAX_VALUE)) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "float", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
    return (float) val;
  }

  /**
   * Parses the given string value as a long. Throws {@link SQLException} if the string is not a
   * valid long value.
   */
  static long parseLong(String val) throws SQLException {
    Preconditions.checkNotNull(val);
    try {
      return Long.parseLong(val);
    } catch (NumberFormatException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid number", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static BigInteger checkedCastToBigInteger(BigDecimal val) throws SQLException {
    try {
      return val.toBigIntegerExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "BigInteger", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static long checkedCastToLong(BigDecimal val) throws SQLException {
    try {
      return val.longValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "long", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /** Cast value and throw {@link SQLException} if out-of-range. */
  static long checkedCastToLong(BigInteger val) throws SQLException {
    try {
      return val.longValueExact();
    } catch (ArithmeticException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "long", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
  }

  /**
   * Parses the given string value as a double. Throws {@link SQLException} if the string is not a
   * valid double value.
   */
  static double parseDouble(String val) throws SQLException {
    Preconditions.checkNotNull(val);
    try {
      return Double.parseDouble(val);
    } catch (NumberFormatException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid number", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /**
   * Parses the given string value as a float. Throws {@link SQLException} if the string is not a
   * valid float value.
   */
  static float parseFloat(String val) throws SQLException {
    Preconditions.checkNotNull(val);
    try {
      return Float.parseFloat(val);
    } catch (NumberFormatException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid number", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /**
   * Parses the given string value as a {@link Date} value. Throws {@link SQLException} if the
   * string is not a valid {@link Date} value.
   */
  static Date parseDate(String val) throws SQLException {
    Preconditions.checkNotNull(val);
    try {
      return JdbcTypeConverter.toSqlDate(com.google.cloud.Date.parseDate(val));
    } catch (IllegalArgumentException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid date", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /**
   * Parses the given string value as a {@link Date} value in the timezone of the given {@link
   * Calendar}. Throws {@link SQLException} if the string is not a valid {@link Date} value.
   */
  static Date parseDate(String val, Calendar cal) throws SQLException {
    Preconditions.checkNotNull(val);
    Preconditions.checkNotNull(cal);
    try {
      return JdbcTypeConverter.toSqlDate(com.google.cloud.Date.parseDate(val), cal);
    } catch (IllegalArgumentException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid date", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /**
   * Parses the given string value as a {@link Time} value. Throws {@link SQLException} if the
   * string is not a valid {@link Time} value.
   */
  static Time parseTime(String val) throws SQLException {
    Preconditions.checkNotNull(val);
    try {
      return Time.valueOf(val);
    } catch (IllegalArgumentException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid time", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /**
   * Parses the given string value as a {@link Time} value in the timezone of the given {@link
   * Calendar}. Throws {@link SQLException} if the string is not a valid {@link Time} value.
   */
  static Time parseTime(String val, Calendar cal) throws SQLException {
    Preconditions.checkNotNull(val);
    Preconditions.checkNotNull(cal);
    try {
      return JdbcTypeConverter.parseSqlTime(val, cal);
    } catch (IllegalArgumentException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid time", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /**
   * Parses the given string value as a {@link Timestamp} value. Throws {@link SQLException} if the
   * string is not a valid {@link Timestamp} value.
   */
  static Timestamp parseTimestamp(String val) throws SQLException {
    Preconditions.checkNotNull(val);
    try {
      return JdbcTypeConverter.toSqlTimestamp(com.google.cloud.Timestamp.parseTimestamp(val));
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid timestamp", val),
          com.google.rpc.Code.INVALID_ARGUMENT,
          e);
    }
  }

  /**
   * Parses the given string value as a {@link Timestamp} value in the timezone of the given {@link
   * Calendar}. Throws {@link SQLException} if the string is not a valid {@link Timestamp} value.
   */
  static Timestamp parseTimestamp(String val, Calendar cal) throws SQLException {
    Preconditions.checkNotNull(val);
    Preconditions.checkNotNull(cal);
    try {
      return JdbcTypeConverter.setTimestampInCalendar(
          com.google.cloud.Timestamp.parseTimestamp(val).toSqlTimestamp(), cal);
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid timestamp", val),
          com.google.rpc.Code.INVALID_ARGUMENT,
          e);
    }
  }

  /**
   * Parses the given string value as a {@link BigDecimal} value. Throws {@link SQLException} if the
   * string is not a valid {@link BigDecimal} value.
   */
  static BigDecimal parseBigDecimal(String val) throws SQLException {
    Preconditions.checkNotNull(val);
    try {
      return new BigDecimal(val);
    } catch (NumberFormatException e) {
      throw JdbcSqlExceptionFactory.of(
          String.format("%s is not a valid number", val), com.google.rpc.Code.INVALID_ARGUMENT, e);
    }
  }

  /** Should return true if this object has been closed */
  public abstract boolean isClosed();

  /** Throws a {@link SQLException} if this object is closed */
  void checkClosed() throws SQLException {
    if (isClosed()) {
      throw JdbcSqlExceptionFactory.of(
          "This " + getClass().getName() + " has been closed",
          com.google.rpc.Code.FAILED_PRECONDITION);
    }
  }

  /**
   * Throws a {@link SQLException} if this object is closed and otherwise a {@link
   * SQLFeatureNotSupportedException} with the given message
   */
  <T> T checkClosedAndThrowUnsupported(String message) throws SQLException {
    checkClosed();
    throw JdbcSqlExceptionFactory.unsupported(message);
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) {
    return iface != null && iface.isAssignableFrom(getClass());
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    if (isWrapperFor(iface)) {
      return iface.cast(this);
    }
    throw JdbcSqlExceptionFactory.of(
        "Cannot unwrap to " + iface.getName(), com.google.rpc.Code.INVALID_ARGUMENT);
  }
}

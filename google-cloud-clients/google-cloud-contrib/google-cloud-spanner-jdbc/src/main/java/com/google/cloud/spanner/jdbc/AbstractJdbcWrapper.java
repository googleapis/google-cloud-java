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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Timestamp;
import java.sql.Types;
import java.sql.Wrapper;

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
    if (type.equals(Type.bool())) return Types.BOOLEAN;
    if (type.equals(Type.bytes())) return Types.BINARY;
    if (type.equals(Type.date())) return Types.DATE;
    if (type.equals(Type.float64())) return Types.DOUBLE;
    if (type.equals(Type.int64())) return Types.BIGINT;
    if (type.equals(Type.string())) return Types.NVARCHAR;
    if (type.equals(Type.timestamp())) return Types.TIMESTAMP;
    if (type.getCode() == Code.ARRAY) return Types.ARRAY;
    return Types.OTHER;
  }

  /** Extract Spanner type name from {@link java.sql.Types} code. */
  static String getSpannerTypeName(int sqlType) {
    if (sqlType == Types.BOOLEAN) return Type.bool().getCode().name();
    if (sqlType == Types.BINARY) return Type.bytes().getCode().name();
    if (sqlType == Types.DATE) return Type.date().getCode().name();
    if (sqlType == Types.DOUBLE || sqlType == Types.FLOAT) return Type.float64().getCode().name();
    if (sqlType == Types.BIGINT
        || sqlType == Types.INTEGER
        || sqlType == Types.SMALLINT
        || sqlType == Types.TINYINT) return Type.int64().getCode().name();
    if (sqlType == Types.NVARCHAR) return Type.string().getCode().name();
    if (sqlType == Types.TIMESTAMP) return Type.timestamp().getCode().name();
    if (sqlType == Types.ARRAY) return Code.ARRAY.name();

    return OTHER_NAME;
  }

  /** Get corresponding Java class name from {@link java.sql.Types} code. */
  static String getClassName(int sqlType) {
    if (sqlType == Types.BOOLEAN) return Boolean.class.getName();
    if (sqlType == Types.BINARY) return Byte[].class.getName();
    if (sqlType == Types.DATE) return Date.class.getName();
    if (sqlType == Types.DOUBLE || sqlType == Types.FLOAT) return Double.class.getName();
    if (sqlType == Types.BIGINT
        || sqlType == Types.INTEGER
        || sqlType == Types.SMALLINT
        || sqlType == Types.TINYINT) return Long.class.getName();
    if (sqlType == Types.NVARCHAR) return String.class.getName();
    if (sqlType == Types.TIMESTAMP) return Timestamp.class.getName();
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
    if (type == Type.bool()) return Boolean.class.getName();
    if (type == Type.bytes()) return byte[].class.getName();
    if (type == Type.date()) return Date.class.getName();
    if (type == Type.float64()) return Double.class.getName();
    if (type == Type.int64()) return Long.class.getName();
    if (type == Type.string()) return String.class.getName();
    if (type == Type.timestamp()) return Timestamp.class.getName();
    if (type.getCode() == Code.ARRAY) {
      if (type.getArrayElementType() == Type.bool()) return Boolean[].class.getName();
      if (type.getArrayElementType() == Type.bytes()) return byte[][].class.getName();
      if (type.getArrayElementType() == Type.date()) return Date[].class.getName();
      if (type.getArrayElementType() == Type.float64()) return Double[].class.getName();
      if (type.getArrayElementType() == Type.int64()) return Long[].class.getName();
      if (type.getArrayElementType() == Type.string()) return String[].class.getName();
      if (type.getArrayElementType() == Type.timestamp()) return Timestamp[].class.getName();
    }
    return null;
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
  static short checkedCastToShort(long val) throws SQLException {
    if (val > Short.MAX_VALUE || val < Short.MIN_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "short", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
    return (short) val;
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
  static float checkedCastToFloat(double val) throws SQLException {
    if (val > Float.MAX_VALUE || val < -Float.MAX_VALUE) {
      throw JdbcSqlExceptionFactory.of(
          String.format(OUT_OF_RANGE_MSG, "float", val), com.google.rpc.Code.OUT_OF_RANGE);
    }
    return (float) val;
  }

  /** Should return true if this object has been closed */
  public abstract boolean isClosed() throws SQLException;

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
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
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

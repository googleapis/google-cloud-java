/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
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
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Types;

/** ParameterMetaData implementation for BigQuery JDBC PreparedStatement parameters. */
class BigQueryParameterMetaData implements ParameterMetaData {
  private final int parameterCount;
  private final BigQueryParameterHandler parameterHandler;

  BigQueryParameterMetaData(int parameterCount, BigQueryParameterHandler parameterHandler) {
    this.parameterCount = parameterCount;
    this.parameterHandler = parameterHandler;
  }

  private void checkValidIndex(int param) throws SQLException {
    if (param < 1 || param > this.parameterCount) {
      throw new BigQueryJdbcException("Invalid parameter index: " + param);
    }
  }

  @Override
  public int getParameterCount() {
    return this.parameterCount;
  }

  @Override
  public int isNullable(int param) throws SQLException {
    checkValidIndex(param);
    return parameterNullable;
  }

  @Override
  public boolean isSigned(int param) throws SQLException {
    int type = getParameterType(param);
    return type == Types.SMALLINT
        || type == Types.TINYINT
        || type == Types.INTEGER
        || type == Types.BIGINT
        || type == Types.FLOAT
        || type == Types.DOUBLE
        || type == Types.DECIMAL
        || type == Types.NUMERIC;
  }

  @Override
  public int getPrecision(int param) throws SQLException {
    checkValidIndex(param);
    StandardSQLTypeName sqlType = getStandardSQLTypeName(param);
    if (sqlType != null) {
      BigQueryJdbcTypeMappings.ColumnTypeInfo typeInfo =
          BigQueryJdbcTypeMappings.STANDARD_TYPE_INFO.get(sqlType);
      if (typeInfo != null && typeInfo.columnSize != null) {
        return typeInfo.columnSize;
      }
    }
    return 0;
  }

  @Override
  public int getScale(int param) throws SQLException {
    checkValidIndex(param);
    StandardSQLTypeName sqlType = getStandardSQLTypeName(param);
    if (sqlType != null) {
      BigQueryJdbcTypeMappings.ColumnTypeInfo typeInfo =
          BigQueryJdbcTypeMappings.STANDARD_TYPE_INFO.get(sqlType);
      if (typeInfo != null && typeInfo.decimalDigits != null) {
        return typeInfo.decimalDigits;
      }
    }
    return 0;
  }

  @Override
  public int getParameterType(int param) throws SQLException {
    checkValidIndex(param);
    StandardSQLTypeName sqlType = getStandardSQLTypeName(param);
    if (sqlType != null) {
      Integer jdbcType = BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.get(sqlType);
      if (jdbcType != null) {
        return jdbcType;
      }
    }
    return Types.OTHER;
  }

  @Override
  public String getParameterTypeName(int param) throws SQLException {
    checkValidIndex(param);
    StandardSQLTypeName sqlType = getStandardSQLTypeName(param);
    return sqlType != null ? sqlType.name() : "UNKNOWN";
  }

  @Override
  public String getParameterClassName(int param) throws SQLException {
    checkValidIndex(param);
    StandardSQLTypeName sqlType = getStandardSQLTypeName(param);
    if (sqlType != null) {
      Class<?> clazz = BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping.get(sqlType);
      if (clazz != null) {
        return clazz.getName();
      }
    }
    if (this.parameterHandler != null) {
      Class<?> boundType = this.parameterHandler.getType(param);
      if (boundType != null) {
        return boundType.getName();
      }
    }
    return Object.class.getName();
  }

  @Override
  public int getParameterMode(int param) throws SQLException {
    checkValidIndex(param);
    if (this.parameterHandler != null) {
      BigQueryParameterHandler.BigQueryStatementParameterType paramType =
          this.parameterHandler.getParameterType(param);
      if (paramType == BigQueryParameterHandler.BigQueryStatementParameterType.OUT) {
        return parameterModeOut;
      } else if (paramType == BigQueryParameterHandler.BigQueryStatementParameterType.INOUT) {
        return parameterModeInOut;
      }
    }
    return parameterModeIn;
  }

  private StandardSQLTypeName getStandardSQLTypeName(int param) {
    if (this.parameterHandler != null) {
      StandardSQLTypeName sqlType = this.parameterHandler.getSqlType(param);
      if (sqlType != null) {
        return sqlType;
      }
      Class<?> javaType = this.parameterHandler.getType(param);
      if (javaType != null) {
        try {
          return BigQueryJdbcTypeMappings.classToType(javaType);
        } catch (SQLException ignored) {
          // fall back to default
        }
      }
    }
    return null;
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
}

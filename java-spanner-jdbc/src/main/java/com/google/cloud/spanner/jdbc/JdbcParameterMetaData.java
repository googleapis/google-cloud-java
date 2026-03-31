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

import com.google.cloud.spanner.JdbcDataTypeConverter;
import com.google.cloud.spanner.ResultSet;
import com.google.rpc.Code;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

/** {@link ParameterMetaData} implementation for Cloud Spanner */
class JdbcParameterMetaData extends AbstractJdbcWrapper implements ParameterMetaData {
  private final JdbcPreparedStatement statement;

  private final StructType parameters;

  JdbcParameterMetaData(JdbcPreparedStatement statement, ResultSet resultSet) {
    this.statement = statement;
    this.parameters = resultSet.getMetadata().getUndeclaredParameters();
  }

  private Field getField(int param) throws SQLException {
    JdbcPreconditions.checkArgument(param > 0 && param <= parameters.getFieldsCount(), param);
    String paramName = "p" + param;
    return parameters.getFieldsList().stream()
        .filter(field -> field.getName().equals(paramName))
        .findAny()
        .orElseThrow(
            () ->
                JdbcSqlExceptionFactory.of(
                    "Unknown parameter: " + paramName, Code.INVALID_ARGUMENT));
  }

  @Override
  public boolean isClosed() {
    return false;
  }

  @Override
  public int getParameterCount() {
    return parameters.getFieldsCount();
  }

  @Override
  public int isNullable(int param) {
    Integer nullable = statement.getParameters().getNullable(param);
    //noinspection MagicConstant
    return nullable == null ? parameterNullableUnknown : nullable;
  }

  @Override
  public boolean isSigned(int param) throws SQLException {
    int type = getParameterType(param);
    return type == Types.DOUBLE
        || type == Types.FLOAT
        || type == Types.REAL
        || type == Types.BIGINT
        || type == Types.INTEGER
        || type == Types.SMALLINT
        || type == Types.TINYINT
        || type == Types.DECIMAL
        || type == Types.NUMERIC;
  }

  @Override
  public int getPrecision(int param) {
    Integer length = statement.getParameters().getScaleOrLength(param);
    return length == null ? 0 : length;
  }

  @Override
  public int getScale(int param) {
    return 0;
  }

  @Override
  public int getParameterType(int param) throws SQLException {
    JdbcPreconditions.checkArgument(param > 0 && param <= parameters.getFieldsCount(), param);
    int typeFromValue = getParameterTypeFromValue(param);
    if (typeFromValue != Types.OTHER) {
      return typeFromValue;
    }

    Type type = getField(param).getType();
    // JDBC only has a generic ARRAY type.
    if (type.getCode() == TypeCode.ARRAY) {
      return Types.ARRAY;
    }
    JdbcDataType jdbcDataType =
        JdbcDataType.getType(JdbcDataTypeConverter.toSpannerType(type).getCode());
    return jdbcDataType == null ? Types.OTHER : jdbcDataType.getSqlType();
  }

  /**
   * This method returns the parameter type based on the parameter value that has been set. This was
   * previously the only way to get the parameter types of a statement. Cloud Spanner can now return
   * the types and names of parameters in a SQL string, which is what this method should return.
   */
  // TODO: Remove this method for the next major version bump.
  private int getParameterTypeFromValue(int param) {
    Integer type = statement.getParameters().getType(param);
    if (type != null) {
      return type;
    }

    Object value = statement.getParameters().getParameter(param);
    if (value == null) {
      return Types.OTHER;
    } else if (Boolean.class.isAssignableFrom(value.getClass())) {
      return Types.BOOLEAN;
    } else if (Byte.class.isAssignableFrom(value.getClass())) {
      return Types.TINYINT;
    } else if (Short.class.isAssignableFrom(value.getClass())) {
      return Types.SMALLINT;
    } else if (Integer.class.isAssignableFrom(value.getClass())) {
      return Types.INTEGER;
    } else if (Long.class.isAssignableFrom(value.getClass())) {
      return Types.BIGINT;
    } else if (Float.class.isAssignableFrom(value.getClass())) {
      return Types.REAL;
    } else if (Double.class.isAssignableFrom(value.getClass())) {
      return Types.DOUBLE;
    } else if (BigDecimal.class.isAssignableFrom(value.getClass())) {
      return Types.NUMERIC;
    } else if (Date.class.isAssignableFrom(value.getClass())) {
      return Types.DATE;
    } else if (Timestamp.class.isAssignableFrom(value.getClass())) {
      return Types.TIMESTAMP;
    } else if (Time.class.isAssignableFrom(value.getClass())) {
      return Types.TIME;
    } else if (String.class.isAssignableFrom(value.getClass())) {
      return Types.NVARCHAR;
    } else if (byte[].class.isAssignableFrom(value.getClass())) {
      return Types.BINARY;
    } else {
      return Types.OTHER;
    }
  }

  @Override
  public String getParameterTypeName(int param) throws SQLException {
    JdbcPreconditions.checkArgument(param > 0 && param <= parameters.getFieldsCount(), param);
    String typeNameFromValue = getParameterTypeNameFromValue(param);
    if (typeNameFromValue != null) {
      return typeNameFromValue;
    }

    com.google.cloud.spanner.Type type =
        JdbcDataTypeConverter.toSpannerType(getField(param).getType());
    return getSpannerTypeName(type, statement.getConnection().getDialect());
  }

  private String getParameterTypeNameFromValue(int param) {
    int type = getParameterTypeFromValue(param);
    if (type != Types.OTHER) {
      return getSpannerTypeName(type);
    }
    return null;
  }

  @Override
  public String getParameterClassName(int param) throws SQLException {
    JdbcPreconditions.checkArgument(param > 0 && param <= parameters.getFieldsCount(), param);
    String classNameFromValue = getParameterClassNameFromValue(param);
    if (classNameFromValue != null) {
      return classNameFromValue;
    }

    com.google.cloud.spanner.Type type =
        JdbcDataTypeConverter.toSpannerType(getField(param).getType());
    return getClassName(type);
  }

  // TODO: Remove this method for the next major version bump.
  private String getParameterClassNameFromValue(int param) {
    Object value = statement.getParameters().getParameter(param);
    if (value != null) {
      return value.getClass().getName();
    }
    Integer type = statement.getParameters().getType(param);
    if (type != null) {
      return getClassName(type);
    }
    return null;
  }

  @Override
  public int getParameterMode(int param) {
    return parameterModeIn;
  }

  @Override
  public String toString() {
    try {
      StringBuilder res = new StringBuilder();
      res.append("CloudSpannerPreparedStatementParameterMetaData, parameter count: ")
          .append(getParameterCount());
      for (int param = 1; param <= getParameterCount(); param++) {
        res.append("\nParameter ")
            .append(param)
            .append(":\n\t Class name: ")
            .append(getParameterClassName(param));
        res.append(",\n\t Parameter type name: ").append(getParameterTypeName(param));
        res.append(",\n\t Parameter type: ").append(getParameterType(param));
        res.append(",\n\t Parameter precision: ").append(getPrecision(param));
        res.append(",\n\t Parameter scale: ").append(getScale(param));
        res.append(",\n\t Parameter signed: ").append(isSigned(param));
        res.append(",\n\t Parameter nullable: ").append(isNullable(param));
        res.append(",\n\t Parameter mode: ").append(getParameterMode(param));
      }
      return res.toString();
    } catch (SQLException exception) {
      return "Failed to get parameter metadata: " + exception;
    }
  }
}

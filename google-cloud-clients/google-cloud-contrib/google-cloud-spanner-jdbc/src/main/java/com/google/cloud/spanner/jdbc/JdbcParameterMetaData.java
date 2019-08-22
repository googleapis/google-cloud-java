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

import com.google.cloud.spanner.jdbc.JdbcParameterStore.ParametersInfo;
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

  JdbcParameterMetaData(JdbcPreparedStatement statement) throws SQLException {
    this.statement = statement;
    statement.getParameters().fetchMetaData(statement.getConnection());
  }

  @Override
  public boolean isClosed() {
    return false;
  }

  @Override
  public int getParameterCount() throws SQLException {
    ParametersInfo info = statement.getParametersInfo();
    return info.numberOfParameters;
  }

  @Override
  public int isNullable(int param) throws SQLException {
    Integer nullable = statement.getParameters().getNullable(param);
    return nullable == null ? parameterNullableUnknown : nullable.intValue();
  }

  @Override
  public boolean isSigned(int param) throws SQLException {
    int type = getParameterType(param);
    return type == Types.DOUBLE
        || type == Types.FLOAT
        || type == Types.BIGINT
        || type == Types.INTEGER
        || type == Types.SMALLINT
        || type == Types.TINYINT
        || type == Types.DECIMAL
        || type == Types.NUMERIC;
  }

  @Override
  public int getPrecision(int param) throws SQLException {
    Integer length = statement.getParameters().getScaleOrLength(param);
    return length == null ? 0 : length.intValue();
  }

  @Override
  public int getScale(int param) throws SQLException {
    return 0;
  }

  @Override
  public int getParameterType(int param) throws SQLException {
    Integer type = statement.getParameters().getType(param);
    if (type != null) return type.intValue();

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
      return Types.FLOAT;
    } else if (Double.class.isAssignableFrom(value.getClass())) {
      return Types.DOUBLE;
    } else if (BigDecimal.class.isAssignableFrom(value.getClass())) {
      return Types.DECIMAL;
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
    return getSpannerTypeName(getParameterType(param));
  }

  @Override
  public String getParameterClassName(int param) throws SQLException {
    Object value = statement.getParameters().getParameter(param);
    if (value != null) return value.getClass().getName();
    Integer type = statement.getParameters().getType(param);
    if (type != null) return getClassName(type.intValue());
    return null;
  }

  @Override
  public int getParameterMode(int param) throws SQLException {
    return parameterModeIn;
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    try {
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
    } catch (SQLException e) {
      res.append("Error while fetching parameter metadata: ").append(e.getMessage());
    }
    return res.toString();
  }
}

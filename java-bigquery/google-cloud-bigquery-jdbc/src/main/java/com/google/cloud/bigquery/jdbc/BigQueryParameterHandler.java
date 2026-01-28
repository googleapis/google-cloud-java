/*
 * Copyright 2024 Google LLC
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

import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import java.sql.SQLException;
import java.util.ArrayList;

class BigQueryParameterHandler {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());

  public BigQueryParameterHandler(int parameterCount) {
    this.parametersArraySize = parameterCount;
  }

  BigQueryParameterHandler(int parameterCount, ArrayList<BigQueryJdbcParameter> parametersList) {
    this.parametersArraySize = parameterCount;
    this.parametersList = parametersList;
  }

  // Indicates whether the parameter is input, output or both
  // Default is UNSPECIFIED
  // Used by CallableStatement
  enum BigQueryStatementParameterType {
    UNSPECIFIED,
    IN,
    OUT,
    INOUT
  };

  private int parametersArraySize;
  ArrayList<BigQueryJdbcParameter> parametersList = new ArrayList<>(parametersArraySize);

  private long highestIndex = 0;

  QueryJobConfiguration.Builder configureParameters(
      QueryJobConfiguration.Builder jobConfigurationBuilder) throws SQLException {
    LOG.finest("++enter++");
    try {
      for (int i = 1; i <= this.parametersArraySize; i++) {

        Object parameterValue = getParameter(i);
        StandardSQLTypeName sqlType = getSqlType(i);
        LOG.info(
            String.format(
                "Parameter %s of type %s at index %s added to QueryJobConfiguration",
                parameterValue, sqlType, i));
        jobConfigurationBuilder.addPositionalParameter(
            QueryParameterValue.of(parameterValue, sqlType));
      }
    } catch (NullPointerException e) {
      if (e.getMessage().contains("Null type")) {
        throw new BigQueryJdbcException("One or more parameters missing in Prepared statement.", e);
      }
    }
    return jobConfigurationBuilder;
  }

  void setParameter(int parameterIndex, Object value, Class type)
      throws BigQueryJdbcSqlFeatureNotSupportedException {
    LOG.finest("++enter++");
    LOG.finest(String.format("setParameter called by : %s", type.getName()));
    checkValidIndex(parameterIndex);

    int arrayIndex = parameterIndex - 1;
    if (parameterIndex >= this.highestIndex || this.parametersList.get(arrayIndex) == null) {
      parametersList.ensureCapacity(parameterIndex);
      while (parametersList.size() < parameterIndex) {
        parametersList.add(null);
      }
      parametersList.set(arrayIndex, new BigQueryJdbcParameter());
    }
    this.highestIndex = Math.max(parameterIndex, highestIndex);
    BigQueryJdbcParameter parameter = parametersList.get(arrayIndex);

    parameter.setIndex(parameterIndex);
    parameter.setValue(value);
    parameter.setType(type);
    parameter.setSqlType(BigQueryJdbcTypeMappings.classToType(type));
    parameter.setParamName("");
    parameter.setParamType(BigQueryStatementParameterType.UNSPECIFIED);
    parameter.setScale(-1);

    LOG.finest(String.format("Parameter set { %s }", parameter.toString()));
  }

  private void checkValidIndex(int parameterIndex) {
    if (parameterIndex > this.parametersArraySize) {
      throw new IndexOutOfBoundsException("All parameters already provided.");
    }
  }

  Object getParameter(int index) {
    // Index is 1-based. Converting to 0 based for java.
    int arrayIndex = index - 1;
    if (parametersList.size() <= arrayIndex || parametersList.get(arrayIndex) == null) {
      return null;
    }
    return parametersList.get(arrayIndex).getValue();
  }

  Class<?> getType(int index) {
    // Index is 1-based. Converting to 0 based for java.
    int arrayIndex = index - 1;
    if (parametersList.size() <= arrayIndex || parametersList.get(arrayIndex) == null) {
      return null;
    }
    return parametersList.get(arrayIndex).getType();
  }

  StandardSQLTypeName getSqlType(int index) {
    // Index is 1-based. Converting to 0 based for java.
    int arrayIndex = index - 1;
    if (parametersList.size() <= arrayIndex || parametersList.get(arrayIndex) == null) {
      return null;
    }
    return parametersList.get(arrayIndex).getSqlType();
  }

  void clearParameters() {
    LOG.finest("++enter++");
    parametersList.clear();
    highestIndex = 0;
  }

  // set parameter by name and type
  void setParameter(
      String paramName,
      Object value,
      Class<?> type,
      BigQueryStatementParameterType paramType,
      int scale)
      throws BigQueryJdbcSqlFeatureNotSupportedException {
    LOG.finest("++enter++");
    LOG.finest(String.format("setParameter called by : %s", type.getName()));
    if (paramName == null || paramName.isEmpty()) {
      throw new IllegalArgumentException("paramName cannot be null or empty");
    }
    BigQueryJdbcParameter parameter = null;
    for (BigQueryJdbcParameter p : parametersList) {
      if (paramName.equals(p.getParamName())) {
        parameter = p;
        break;
      }
    }
    if (parameter == null) {
      // Add new parameter.
      parameter = new BigQueryJdbcParameter();
      parameter.setIndex(-1);
    }
    parameter.setValue(value);
    parameter.setType(type);
    parameter.setSqlType(BigQueryJdbcTypeMappings.classToType(type));
    parameter.setParamName(paramName);
    parameter.setParamType(paramType);
    parameter.setScale(scale);
    if (parameter.getIndex() == -1) {
      parametersList.add(parameter);
    }
    LOG.finest(String.format("Parameter set { %s }", parameter.toString()));
  }

  // set parameter by index and type
  void setParameter(
      int parameterIndex,
      Object value,
      Class<?> type,
      BigQueryStatementParameterType paramType,
      int scale)
      throws BigQueryJdbcSqlFeatureNotSupportedException {
    LOG.finest("++enter++");
    LOG.finest(String.format("setParameter called by : %s", type.getName()));
    checkValidIndex(parameterIndex);
    int arrayIndex = parameterIndex - 1;
    if (parameterIndex >= this.highestIndex || this.parametersList.get(arrayIndex) == null) {
      parametersList.ensureCapacity(parameterIndex);
      while (parametersList.size() < parameterIndex) {
        parametersList.add(null);
      }
      parametersList.set(arrayIndex, new BigQueryJdbcParameter());
    }
    this.highestIndex = Math.max(parameterIndex, highestIndex);
    BigQueryJdbcParameter parameter = parametersList.get(arrayIndex);

    parameter.setIndex(parameterIndex);
    parameter.setValue(value);
    parameter.setType(type);
    parameter.setSqlType(BigQueryJdbcTypeMappings.classToType(type));
    parameter.setParamName("");
    parameter.setParamType(paramType);
    parameter.setScale(scale);

    LOG.finest(String.format("Parameter set { %s }", parameter.toString()));
  }

  // Get Parameter by name
  Object getParameter(String name) {
    for (BigQueryJdbcParameter p : parametersList) {
      if (name.equals(p.getParamName())) {
        return p.getValue();
      }
    }
    return null;
  }

  // Get parameter type by index
  BigQueryStatementParameterType getParameterType(int index) {
    // Index is 1-based. Converting to 0 based for java.
    int arrayIndex = index - 1;
    if (parametersList.size() <= arrayIndex || parametersList.get(arrayIndex) == null) {
      return null;
    }
    return parametersList.get(arrayIndex).getParamType();
  }

  // Get parameter type by name
  BigQueryStatementParameterType getParameterType(String name) {
    for (BigQueryJdbcParameter p : parametersList) {
      if (name.equals(p.getParamName())) {
        return p.getParamType();
      }
    }
    return null;
  }

  // Get scale type by index
  int getParameterScale(int index) {
    // Index is 1-based. Converting to 0 based for java.
    int arrayIndex = index - 1;
    if (parametersList.size() <= arrayIndex || parametersList.get(arrayIndex) == null) {
      return -1;
    }
    return parametersList.get(arrayIndex).getScale();
  }

  // Get parameter scale by name
  int getParameterScale(String name) {
    for (BigQueryJdbcParameter p : parametersList) {
      if (name.equals(p.getParamName())) {
        return p.getScale();
      }
    }
    return -1;
  }

  Class<?> getType(String name) {
    for (BigQueryJdbcParameter p : parametersList) {
      if (name.equals(p.getParamName())) {
        return p.getType();
      }
    }
    return null;
  }

  StandardSQLTypeName getSqlType(String name) {
    for (BigQueryJdbcParameter p : parametersList) {
      if (name.equals(p.getParamName())) {
        return p.getSqlType();
      }
    }
    return null;
  }
}

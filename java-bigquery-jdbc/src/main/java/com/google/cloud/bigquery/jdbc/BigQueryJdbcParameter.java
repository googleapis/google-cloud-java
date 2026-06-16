/*
 * Copyright 2025 Google LLC
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
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;

class BigQueryJdbcParameter {
  private int index;
  private Object value;
  private Class type;
  private StandardSQLTypeName sqlType;
  // Additional parameters needed for CallableStatement.
  private String paramName;
  private BigQueryStatementParameterType paramType;
  private int scale;

  BigQueryJdbcParameter() {}

  BigQueryJdbcParameter(BigQueryJdbcParameter parameter) {
    this.index = parameter.index;
    this.value = parameter.value;
    this.type = parameter.type;
    this.sqlType = parameter.sqlType;
  }

  int getIndex() {
    return index;
  }

  void setIndex(int index) {
    this.index = index;
  }

  Object getValue() {
    return value;
  }

  void setValue(Object value) {
    this.value = value;
  }

  Class getType() {
    return type;
  }

  public void setType(Class type) {
    this.type = type;
  }

  StandardSQLTypeName getSqlType() {
    return sqlType;
  }

  void setSqlType(StandardSQLTypeName sqlType) {
    this.sqlType = sqlType;
  }

  String getParamName() {
    return paramName;
  }

  void setParamName(String paramName) {
    this.paramName = paramName;
  }

  BigQueryStatementParameterType getParamType() {
    return paramType;
  }

  void setParamType(BigQueryStatementParameterType paramType) {
    this.paramType = paramType;
  }

  int getScale() {
    return scale;
  }

  void setScale(int scale) {
    this.scale = scale;
  }

  @Override
  public String toString() {
    return "BigQueryJdbcParameter{"
        + "index="
        + index
        + ", value="
        + value
        + ", type="
        + type
        + ", sqlType="
        + sqlType
        + ", paramName='"
        + paramName
        + '\''
        + ", paramType="
        + paramType.name()
        + ", scale="
        + scale
        + '}';
  }
}

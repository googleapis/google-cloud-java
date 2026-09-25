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

  // The parameter can be inferred from the user via setter methods along with values and
  // just the parameter types from dryRuns. Keeping track of this metadata avoids repeated dryRuns.
  enum Binding {
    // Type and value unknown
    UNBOUND,
    // Parameter Type is known; inferred from dryRun or left behind by a cleared value. No value
    // known.
    TYPED,
    // Parameter type and value set by user; its type outranks anything a dry run reports.
    BOUND
  }

  private int index;
  private Object value;
  private Class type;
  private StandardSQLTypeName sqlType;
  // Additional parameters needed for CallableStatement.
  private String paramName;
  private BigQueryStatementParameterType paramType = BigQueryStatementParameterType.UNSPECIFIED;
  private int scale;
  private Binding binding = Binding.UNBOUND;

  BigQueryJdbcParameter() {}

  BigQueryJdbcParameter(BigQueryJdbcParameter parameter) {
    this.index = parameter.index;
    this.value = parameter.value;
    this.type = parameter.type;
    this.sqlType = parameter.sqlType;
    this.paramName = parameter.paramName;
    this.paramType = parameter.paramType;
    this.scale = parameter.scale;
    this.binding = parameter.binding;
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

  void setType(Class type) {
    this.type = type;
  }

  StandardSQLTypeName getSqlType() {
    return sqlType;
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

  boolean isBound() {
    return binding == Binding.BOUND;
  }

  Binding getBinding() {
    return binding;
  }

  boolean suggestType(Class<?> javaType, StandardSQLTypeName bqType) {
    if (binding == Binding.BOUND) {
      return false;
    }
    this.type = javaType;
    this.sqlType = bqType;
    this.binding = Binding.TYPED;
    return true;
  }

  void bindType(Class<?> javaType, StandardSQLTypeName bqType) {
    this.type = javaType;
    this.sqlType = bqType;
    this.binding = Binding.BOUND;
  }

  void clearValue() {
    this.value = null;
    if (binding == Binding.BOUND) {
      this.binding = Binding.TYPED;
    }
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
        + ", binding="
        + binding
        + '}';
  }
}

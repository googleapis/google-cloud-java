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
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class BigQueryParameterHandler {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private final int parametersArraySize;
  private final boolean enableTimestampPicos;
  final ArrayList<BigQueryJdbcParameter> parametersList;
  // Precompiled and immutable (DateTimeFormatter is thread-safe). Building a formatter from a
  // pattern is the expensive step; formatting with one is ~1 µs.
  //
  // TIMESTAMP parameters are ALWAYS rendered in UTC with a trailing 'Z'. 'XXX' prints 'Z' for a
  // zero offset and a numeric offset otherwise, so the label can never lie about the digits. UTC
  // is used because QueryParameterValue's lenient TIMESTAMP validator rejects non-zero offsets
  // written with a colon (e.g. "-05:00"), while both it and BigQuery accept 'Z'. Rendering in UTC
  // also makes the output independent of the JVM default zone. The absolute instant is preserved,
  // which is all a BigQuery TIMESTAMP stores.
  private static final DateTimeFormatter TIMESTAMP_MICROS_UTC =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSXXX");
  private static final DateTimeFormatter TIMESTAMP_NANOS_UTC =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSSXXX");
  // BigQuery DATETIME is a zone-less wall clock with microsecond precision only; its validator
  // requires exactly six fraction digits and rejects any offset.
  private static final DateTimeFormatter DATETIME_MICROS =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

  BigQueryParameterHandler(int parameterCount) {
    this(parameterCount, false);
  }

  BigQueryParameterHandler(int parameterCount, boolean enableTimestampPicos) {
    this(parameterCount, new ArrayList<>(parameterCount), enableTimestampPicos);
  }

  BigQueryParameterHandler(
      int parameterCount,
      ArrayList<BigQueryJdbcParameter> parametersList,
      boolean enableTimestampPicos) {
    this.parametersArraySize = parameterCount;
    this.parametersList = parametersList;
    this.enableTimestampPicos = enableTimestampPicos;
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

  QueryJobConfiguration.Builder configureParameters(
      QueryJobConfiguration.Builder jobConfigurationBuilder) throws SQLException {
    LOG.finest("++enter++");
    for (int i = 1; i <= this.parametersArraySize; i++) {

      int arrayIndex = i - 1;
      if (this.parametersList.size() <= arrayIndex
          || this.parametersList.get(arrayIndex) == null
          || !this.parametersList.get(arrayIndex).isBound()) {
        throw new BigQueryJdbcException(
            String.format(
                "One or more parameters missing in Prepared statement. No value was set for"
                    + " parameter %d of %d.",
                i, this.parametersArraySize));
      }

      Object parameterValue = getParameter(i);
      StandardSQLTypeName sqlType = getSqlType(i);
      parameterValue =
          formatValueForQueryParameter(parameterValue, sqlType, this.enableTimestampPicos);
      LOG.finest(
          "Parameter %s of type %s at index %s added to QueryJobConfiguration",
          parameterValue, sqlType, i);
      jobConfigurationBuilder.addPositionalParameter(
          QueryParameterValue.of(parameterValue, sqlType));
    }
    return jobConfigurationBuilder;
  }

  static Object formatValueForQueryParameter(
      Object parameterValue, StandardSQLTypeName sqlType, boolean enableTimestampPicos) {
    if (parameterValue == null) {
      return null;
    }
    if (sqlType == StandardSQLTypeName.INT64
        && (parameterValue instanceof Short
            || parameterValue instanceof Byte
            || parameterValue instanceof BigInteger)) {
      return ((Number) parameterValue).longValue();
    }
    if (sqlType == StandardSQLTypeName.FLOAT64 && parameterValue instanceof Float) {
      return ((Number) parameterValue).doubleValue();
    }
    if (sqlType == StandardSQLTypeName.TIMESTAMP) {
      // Every instant-carrying type is reduced to its Instant and rendered in UTC, so BigQuery
      // reconstructs the exact moment regardless of the JVM default zone. The digits and the 'Z'
      // label are derived together from the same Instant and cannot disagree.
      if (parameterValue instanceof Timestamp) {
        return formatInstantUtc(((Timestamp) parameterValue).toInstant(), enableTimestampPicos);
      }
      if (parameterValue instanceof OffsetDateTime) {
        return formatInstantUtc(
            ((OffsetDateTime) parameterValue).toInstant(), enableTimestampPicos);
      }
      if (parameterValue instanceof ZonedDateTime) {
        return formatInstantUtc(((ZonedDateTime) parameterValue).toInstant(), enableTimestampPicos);
      }
      if (parameterValue instanceof Instant) {
        return formatInstantUtc((Instant) parameterValue, enableTimestampPicos);
      }
      if (parameterValue instanceof String) {
        String str = ((String) parameterValue).trim();
        if (str.length() > 10 && str.charAt(10) == 'T') {
          str = str.substring(0, 10) + ' ' + str.substring(11);
        }
        return BigQueryTemporalUtility.truncateFractionalSeconds(
            str, enableTimestampPicos ? 12 : 6);
      }
    }

    if (parameterValue instanceof Timestamp) {
      // Non-TIMESTAMP slot; in practice only DATETIME, a zone-less wall clock. Emit the JVM-local
      // digits with the exact 6-digit fraction the DATETIME validator requires. No offset is
      // appended because DATETIME has no zone to carry one. Sub-microsecond digits are truncated,
      // matching prior behaviour.
      return DATETIME_MICROS.format(((Timestamp) parameterValue).toLocalDateTime());
    }

    if (parameterValue instanceof Time) {
      String timeStr = parameterValue.toString();
      if (timeStr.length() == 8) {
        return timeStr + ".000000";
      }
      return timeStr;
    }
    if (parameterValue instanceof Date || parameterValue instanceof java.util.Date) {
      return parameterValue.toString();
    }
    return parameterValue;
  }

  /** Renders an absolute instant as UTC wall-clock digits with a trailing 'Z'. */
  private static String formatInstantUtc(Instant instant, boolean enableTimestampPicos) {
    // Fixed-width 'S' truncates (does not round), matching the legacy nanos/1000*1000 behaviour.
    return (enableTimestampPicos ? TIMESTAMP_NANOS_UTC : TIMESTAMP_MICROS_UTC)
        .format(instant.atOffset(ZoneOffset.UTC));
  }

  private BigQueryJdbcParameter getOrCreateParameter(int parameterIndex) {
    int arrayIndex = parameterIndex - 1;
    parametersList.ensureCapacity(parameterIndex);
    while (parametersList.size() < parameterIndex) {
      parametersList.add(null);
    }
    BigQueryJdbcParameter parameter = parametersList.get(arrayIndex);
    if (parameter == null) {
      parameter = new BigQueryJdbcParameter();
      parameter.setIndex(parameterIndex);
      parametersList.set(arrayIndex, parameter);
    }
    return parameter;
  }

  // A null still needs a type, since BigQuery rejects an untyped one. Preference order is the type
  // the caller named, then the type a dry run inferred for this slot, then STRING.
  void setNullParameter(int parameterIndex, Class<?> declaredJavaType) {
    LOG.finest("++enter++");
    checkValidIndex(parameterIndex);

    BigQueryJdbcParameter parameter = getOrCreateParameter(parameterIndex);
    Class<?> javaType = declaredJavaType;
    StandardSQLTypeName sqlType;
    if (javaType != null) {
      // Keep the caller's class instead of round-tripping it through BigQuery, which would report
      // an Integer back as a Long.
      sqlType = BigQueryTypeRegistry.toBigQueryType(javaType);
    } else {
      sqlType = parameter.getSqlType();
      if (sqlType == null) {
        sqlType = StandardSQLTypeName.STRING;
      }
      javaType = BigQueryTypeRegistry.toJavaClass(sqlType);
    }

    parameter.setIndex(parameterIndex);
    parameter.setValue(null);
    parameter.bindType(javaType, sqlType);
    parameter.setParamName("");
    parameter.setParamType(BigQueryStatementParameterType.UNSPECIFIED);
    parameter.setScale(-1);

    LOG.finest("Parameter set { %s }", parameter.toString());
  }

  void setParameter(int parameterIndex, Object value, Class type) {
    LOG.finest("++enter++");
    LOG.finest("setParameter called by : %s", type.getName());
    checkValidIndex(parameterIndex);

    BigQueryJdbcParameter parameter = getOrCreateParameter(parameterIndex);
    parameter.setIndex(parameterIndex);
    parameter.setValue(value);
    parameter.bindType(type, BigQueryTypeRegistry.toBigQueryType(type));
    parameter.setParamName("");
    parameter.setParamType(BigQueryStatementParameterType.UNSPECIFIED);
    parameter.setScale(-1);

    LOG.finest("Parameter set { %s }", parameter.toString());
  }

  // Records the type BigQuery inferred for a placeholder. Subordinate to the caller: a bound value
  // keeps its own type.
  boolean setInferredParameterType(int parameterIndex, StandardSQLTypeName sqlTypeName) {
    checkValidIndex(parameterIndex);
    BigQueryJdbcParameter parameter = getOrCreateParameter(parameterIndex);
    parameter.setIndex(parameterIndex);
    return parameter.suggestType(BigQueryTypeRegistry.toJavaClass(sqlTypeName), sqlTypeName);
  }

  private void checkValidIndex(int parameterIndex) {
    if (parameterIndex > this.parametersArraySize) {
      IndexOutOfBoundsException ex =
          new IndexOutOfBoundsException("All parameters already provided.");
      LOG.severe("All parameters already provided.", ex);
      throw ex;
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
    for (BigQueryJdbcParameter param : this.parametersList) {
      if (param != null) {
        param.clearValue();
      }
    }
  }

  // set parameter by name and type
  void setParameter(
      String paramName,
      Object value,
      Class<?> type,
      BigQueryStatementParameterType paramType,
      int scale) {
    LOG.finest("++enter++");
    LOG.finest("setParameter called by : %s", type.getName());
    if (paramName == null || paramName.isEmpty()) {
      IllegalArgumentException ex =
          new IllegalArgumentException("paramName cannot be null or empty");
      LOG.severe("paramName cannot be null or empty", ex);
      throw ex;
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
    parameter.bindType(type, BigQueryTypeRegistry.toBigQueryType(type));
    parameter.setParamName(paramName);
    parameter.setParamType(paramType);
    parameter.setScale(scale);

    if (parameter.getIndex() == -1) {
      parametersList.add(parameter);
    }
    LOG.finest("Parameter set { %s }", parameter.toString());
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
    LOG.finest("setParameter called by : %s", type.getName());
    checkValidIndex(parameterIndex);

    BigQueryJdbcParameter parameter = getOrCreateParameter(parameterIndex);

    parameter.setIndex(parameterIndex);
    parameter.setValue(value);
    parameter.bindType(type, BigQueryTypeRegistry.toBigQueryType(type));
    parameter.setParamName("");
    parameter.setParamType(paramType);
    parameter.setScale(scale);

    LOG.finest("Parameter set { %s }", parameter.toString());
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

  int getParametersArraySize() {
    return this.parametersArraySize;
  }
}

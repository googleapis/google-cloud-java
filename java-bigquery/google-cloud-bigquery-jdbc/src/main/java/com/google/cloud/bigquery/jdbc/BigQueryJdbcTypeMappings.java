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

import com.google.api.core.InternalApi;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

@InternalApi
class BigQueryJdbcTypeMappings {

  static final Map<StandardSQLTypeName, Class<?>> standardSQLToJavaTypeMapping =
      ImmutableMap.ofEntries(
          entry(StandardSQLTypeName.INT64, Long.class),
          entry(StandardSQLTypeName.BOOL, Boolean.class),
          entry(StandardSQLTypeName.FLOAT64, Double.class),
          entry(StandardSQLTypeName.NUMERIC, BigDecimal.class),
          entry(StandardSQLTypeName.BIGNUMERIC, BigDecimal.class),
          entry(StandardSQLTypeName.STRING, String.class),
          entry(StandardSQLTypeName.TIMESTAMP, Timestamp.class),
          entry(StandardSQLTypeName.DATE, Date.class),
          entry(StandardSQLTypeName.TIME, Time.class),
          entry(StandardSQLTypeName.DATETIME, Timestamp.class),
          entry(StandardSQLTypeName.GEOGRAPHY, String.class),
          entry(StandardSQLTypeName.JSON, String.class),
          entry(StandardSQLTypeName.INTERVAL, String.class),
          entry(StandardSQLTypeName.RANGE, String.class),
          entry(StandardSQLTypeName.BYTES, byte[].class),
          entry(StandardSQLTypeName.STRUCT, Struct.class),
          entry(StandardSQLTypeName.ARRAY, Array.class));

  static final Map<StandardSQLTypeName, Integer> standardSQLToJavaSqlTypesMapping =
      ImmutableMap.ofEntries(
          entry(StandardSQLTypeName.INT64, Types.BIGINT),
          entry(StandardSQLTypeName.BOOL, Types.BOOLEAN),
          entry(StandardSQLTypeName.FLOAT64, Types.DOUBLE),
          entry(StandardSQLTypeName.NUMERIC, Types.NUMERIC),
          entry(StandardSQLTypeName.BIGNUMERIC, Types.NUMERIC),
          entry(StandardSQLTypeName.STRING, Types.NVARCHAR),
          entry(StandardSQLTypeName.TIMESTAMP, Types.TIMESTAMP),
          entry(StandardSQLTypeName.DATE, Types.DATE),
          entry(StandardSQLTypeName.TIME, Types.TIME),
          entry(StandardSQLTypeName.DATETIME, Types.TIMESTAMP),
          entry(StandardSQLTypeName.GEOGRAPHY, Types.OTHER),
          entry(StandardSQLTypeName.JSON, Types.OTHER),
          entry(StandardSQLTypeName.INTERVAL, Types.OTHER),
          entry(StandardSQLTypeName.RANGE, Types.OTHER),
          entry(StandardSQLTypeName.BYTES, Types.VARBINARY),
          entry(StandardSQLTypeName.STRUCT, Types.STRUCT),
          entry(StandardSQLTypeName.ARRAY, Types.ARRAY));

  static final Map<Integer, Class<?>> javaSQLToJavaTypeMapping =
      ImmutableMap.ofEntries(
          entry(Types.BIGINT, Long.class),
          entry(Types.INTEGER, Integer.class),
          entry(Types.BOOLEAN, Boolean.class),
          entry(Types.DOUBLE, Double.class),
          entry(Types.FLOAT, Float.class),
          entry(Types.NUMERIC, BigDecimal.class),
          entry(Types.VARCHAR, String.class),
          entry(Types.NVARCHAR, String.class),
          entry(Types.TIMESTAMP, Timestamp.class),
          entry(Types.DATE, Date.class),
          entry(Types.TIME, Time.class),
          entry(Types.OTHER, String.class),
          entry(Types.BINARY, byte[].class),
          entry(Types.VARBINARY, byte[].class),
          entry(Types.STRUCT, Struct.class),
          entry(Types.BIT, Boolean.class),
          entry(Types.ARRAY, Array.class));

  static StandardSQLTypeName classToType(Class type)
      throws BigQueryJdbcSqlFeatureNotSupportedException {
    if (Boolean.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.BOOL;
    } else if (String.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.STRING;
    } else if (String.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.GEOGRAPHY;
    } else if (String.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.DATETIME;
    } else if (Integer.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.INT64;
    } else if (Long.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.INT64;
    } else if (Double.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.FLOAT64;
    } else if (Float.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.FLOAT64;
    } else if (BigDecimal.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.NUMERIC;
    } else if (BigDecimal.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.BIGNUMERIC;
    } else if (Date.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.DATE;
    } else if (Timestamp.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.TIMESTAMP;
    } else if (Time.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.TIME;
    } else if (String.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.JSON;
    } else if (JsonObject.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.JSON;
    } else if (Byte.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.BYTES;
    } else if (Array.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.ARRAY;
    } else if (Struct.class.isAssignableFrom(type)) {
      return StandardSQLTypeName.STRUCT;
    } else if (byte[].class.isAssignableFrom(type)) {
      return StandardSQLTypeName.BYTES;
    }
    throw new BigQueryJdbcSqlFeatureNotSupportedException(
        "Unsupported object type for QueryParameter: " + type);
  }

  static Class<?> getJavaType(int javaSQLType) throws BigQueryJdbcSqlFeatureNotSupportedException {
    if (!javaSQLToJavaTypeMapping.containsKey(javaSQLType)) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "Unsupported Java type for SQL type: " + javaSQLType);
    }
    Class<?> javaType = javaSQLToJavaTypeMapping.get(javaSQLType);
    if (javaType == null) {
      // This should never happen unless the map was initialized with null values.
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "Unsupported Java type for SQL type: " + javaSQLType);
    }
    return javaType;
  }

  private static <K, V> SimpleEntry<K, V> entry(K key, V value) {
    return new SimpleEntry<>(key, value);
  }
}

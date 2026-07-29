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
import java.time.ZoneId;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Defines the bidirectional mapping between a JDBC SQL type, a default Java class, and a BigQuery
 * StandardSQLTypeName. It also contains the coercion logic to convert raw values into the expected
 * Java type.
 */
final class TypeDescriptor<T> {
  private final int jdbcType;
  private final Class<T> defaultJavaClass;
  private final StandardSQLTypeName bqType;
  private final List<Class<?>> supportedJavaTypes;
  private final BiFunction<Object, ZoneId, T> coercer;

  TypeDescriptor(
      int jdbcType,
      Class<T> defaultJavaClass,
      StandardSQLTypeName bqType,
      List<Class<?>> supportedJavaTypes,
      BiFunction<Object, ZoneId, T> coercer) {
    this.jdbcType = jdbcType;
    this.defaultJavaClass = defaultJavaClass;
    this.bqType = bqType;
    this.supportedJavaTypes = supportedJavaTypes;
    this.coercer = coercer;
  }

  public int getJdbcType() {
    return jdbcType;
  }

  public Class<T> getDefaultJavaClass() {
    return defaultJavaClass;
  }

  public StandardSQLTypeName getBqType() {
    return bqType;
  }

  public List<Class<?>> getSupportedJavaTypes() {
    return supportedJavaTypes;
  }

  public T convert(Object value, ZoneId zoneId) {
    if (value == null) {
      return null;
    }
    return coercer.apply(value, zoneId);
  }
}

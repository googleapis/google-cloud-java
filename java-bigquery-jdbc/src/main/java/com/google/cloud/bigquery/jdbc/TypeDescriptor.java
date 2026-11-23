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

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Bidirectional mapping between a JDBC SQL type, default Java class, and BigQuery type, including
 * ResultSet coercion and Storage Write API ProtoSchema encoding.
 */
final class TypeDescriptor<T> {

  @FunctionalInterface
  interface TypeCoercer {
    Object coerce(Object value, Class<?> targetClass, ZoneId zoneId) throws BigQueryJdbcException;
  }

  @FunctionalInterface
  interface WriteApiValidator {
    boolean isValid(Object value, StandardSQLTypeName paramSqlType, Field columnField);
  }

  @FunctionalInterface
  interface ProtoFieldEncoder {
    Object encode(Object value, FieldDescriptor fieldDescriptor);
  }

  private final int jdbcType;
  private final Class<T> defaultJavaClass;
  private final StandardSQLTypeName bqType;
  private final List<Class<?>> supportedJavaTypes;
  private final TypeCoercer coercer;
  private final Set<StandardSQLTypeName> writeApiParamTypes;
  private final WriteApiValidator writeApiValidator;
  private final ProtoFieldEncoder protoEncoder;

  TypeDescriptor(
      int jdbcType,
      Class<T> defaultJavaClass,
      StandardSQLTypeName bqType,
      List<Class<?>> supportedJavaTypes,
      TypeCoercer coercer) {
    this(jdbcType, defaultJavaClass, bqType, supportedJavaTypes, coercer, null);
  }

  TypeDescriptor(
      int jdbcType,
      Class<T> defaultJavaClass,
      StandardSQLTypeName bqType,
      List<Class<?>> supportedJavaTypes,
      TypeCoercer coercer,
      ProtoFieldEncoder protoEncoder) {
    this(
        jdbcType,
        defaultJavaClass,
        bqType,
        supportedJavaTypes,
        coercer,
        Collections.emptySet(),
        null,
        protoEncoder);
  }

  TypeDescriptor(
      int jdbcType,
      Class<T> defaultJavaClass,
      StandardSQLTypeName bqType,
      List<Class<?>> supportedJavaTypes,
      TypeCoercer coercer,
      Set<StandardSQLTypeName> writeApiParamTypes,
      WriteApiValidator writeApiValidator,
      ProtoFieldEncoder protoEncoder) {
    this.jdbcType = jdbcType;
    this.defaultJavaClass = defaultJavaClass;
    this.bqType = bqType;
    this.supportedJavaTypes = supportedJavaTypes;
    this.coercer = coercer;
    this.writeApiParamTypes = writeApiParamTypes;
    this.writeApiValidator = writeApiValidator;
    this.protoEncoder = protoEncoder;
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

  boolean supportsWriteApi() {
    return protoEncoder != null;
  }

  boolean isSupportedJavaInstance(Object value) {
    for (Class<?> supportedClass : supportedJavaTypes) {
      if (supportedClass.isInstance(value)) {
        return true;
      }
    }
    return false;
  }

  boolean isSqlTypeAssignable(StandardSQLTypeName paramSqlType) {
    return paramSqlType != null
        && (paramSqlType == bqType || writeApiParamTypes.contains(paramSqlType));
  }

  boolean isValidWriteApiValue(Object value, StandardSQLTypeName paramSqlType, Field columnField) {
    if (!supportsWriteApi() || value == null || !isSqlTypeAssignable(paramSqlType)) {
      return false;
    }
    return writeApiValidator != null
        ? writeApiValidator.isValid(value, paramSqlType, columnField)
        : isSupportedJavaInstance(value);
  }

  Object toProtoValue(Object value, FieldDescriptor fieldDescriptor) throws BigQueryJdbcException {
    if (protoEncoder == null) {
      throw new BigQueryJdbcException("Unsupported Storage Write API column type: " + bqType);
    }
    try {
      return protoEncoder.encode(value, fieldDescriptor);
    } catch (RuntimeException ex) {
      throw new BigQueryJdbcException(
          "Failed to encode parameter for column " + fieldDescriptor.getName(), ex);
    }
  }

  public Object convert(Object value, Class<?> targetClass, ZoneId zoneId)
      throws BigQueryJdbcException {
    if (value == null) {
      return null;
    }
    return coercer.coerce(value, targetClass, zoneId);
  }
}

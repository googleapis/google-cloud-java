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
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * A central, bidirectional engine for resolving and coercing types between JDBC, Java, and
 * BigQuery.
 */
public final class BigQueryTypeRegistry {

  private static final TypeDescriptor<?>[] DESCRIPTORS_BY_ORDINAL;
  private static final Map<Class<?>, TypeDescriptor<?>> DESCRIPTORS_BY_CLASS;
  private static final Map<Integer, TypeDescriptor<?>> DESCRIPTORS_BY_JDBC_TYPE;

  static {
    int maxOrdinal = 0;
    for (StandardSQLTypeName type : StandardSQLTypeName.values()) {
      if (type.ordinal() > maxOrdinal) {
        maxOrdinal = type.ordinal();
      }
    }
    DESCRIPTORS_BY_ORDINAL = new TypeDescriptor<?>[maxOrdinal + 1];
    DESCRIPTORS_BY_CLASS = new IdentityHashMap<>();
    DESCRIPTORS_BY_JDBC_TYPE = new HashMap<>();

    // BOOL
    register(
        new TypeDescriptor<>(
            Types.BOOLEAN,
            Boolean.class,
            StandardSQLTypeName.BOOL,
            Arrays.asList(Boolean.class),
            (val, zone) -> {
              if (val instanceof Boolean) return (Boolean) val;
              if (val instanceof String) return Boolean.parseBoolean((String) val);
              throw new IllegalArgumentException("Cannot convert to BOOL: " + val);
            }));

    // STRING
    register(
        new TypeDescriptor<>(
            Types.NVARCHAR,
            String.class,
            StandardSQLTypeName.STRING,
            Arrays.asList(String.class),
            (val, zone) -> String.valueOf(val)));

    // INT64
    register(
        new TypeDescriptor<>(
            Types.BIGINT,
            Long.class,
            StandardSQLTypeName.INT64,
            Arrays.asList(Long.class, Integer.class, Short.class, Byte.class),
            (val, zone) -> {
              if (val instanceof Number) return ((Number) val).longValue();
              if (val instanceof String) return Long.parseLong((String) val);
              throw new IllegalArgumentException("Cannot convert to INT64: " + val);
            }));

    // FLOAT64
    register(
        new TypeDescriptor<>(
            Types.DOUBLE,
            Double.class,
            StandardSQLTypeName.FLOAT64,
            Arrays.asList(Double.class, Float.class),
            (val, zone) -> {
              if (val instanceof Number) return ((Number) val).doubleValue();
              if (val instanceof String) return Double.parseDouble((String) val);
              throw new IllegalArgumentException("Cannot convert to FLOAT64: " + val);
            }));

    // NUMERIC
    register(
        new TypeDescriptor<>(
            Types.NUMERIC,
            BigDecimal.class,
            StandardSQLTypeName.NUMERIC,
            Arrays.asList(BigDecimal.class),
            (val, zone) -> {
              if (val instanceof BigDecimal) return (BigDecimal) val;
              if (val instanceof Number) return BigDecimal.valueOf(((Number) val).doubleValue());
              if (val instanceof String) return new BigDecimal((String) val);
              throw new IllegalArgumentException("Cannot convert to NUMERIC: " + val);
            }));

    // DATE
    register(
        new TypeDescriptor<>(
            Types.DATE,
            Date.class,
            StandardSQLTypeName.DATE,
            Arrays.asList(Date.class, LocalDate.class),
            (val, zone) -> {
              if (val instanceof Date) return (Date) val;
              if (val instanceof LocalDate) return Date.valueOf((LocalDate) val);
              throw new IllegalArgumentException("Cannot convert to DATE: " + val);
            }));

    // DATETIME
    register(
        new TypeDescriptor<>(
            Types.TIMESTAMP,
            Timestamp.class,
            StandardSQLTypeName.DATETIME,
            Arrays.asList(LocalDateTime.class),
            (val, zone) -> {
              if (val instanceof LocalDateTime) return Timestamp.valueOf((LocalDateTime) val);
              if (val instanceof Timestamp) return (Timestamp) val;
              throw new IllegalArgumentException("Cannot convert to DATETIME: " + val);
            }));

    // TIMESTAMP
    register(
        new TypeDescriptor<>(
            Types.TIMESTAMP,
            Timestamp.class,
            StandardSQLTypeName.TIMESTAMP,
            Arrays.asList(
                Timestamp.class, OffsetDateTime.class, Instant.class, ZonedDateTime.class),
            (val, zone) -> {
              if (val instanceof Timestamp) return (Timestamp) val;
              throw new IllegalArgumentException("Cannot convert to TIMESTAMP: " + val);
            }));

    // TIME
    register(
        new TypeDescriptor<>(
            Types.TIME,
            Time.class,
            StandardSQLTypeName.TIME,
            Arrays.asList(Time.class, LocalTime.class),
            (val, zone) -> {
              if (val instanceof Time) return (Time) val;
              if (val instanceof LocalTime) return Time.valueOf((LocalTime) val);
              throw new IllegalArgumentException("Cannot convert to TIME: " + val);
            }));

    // BYTES
    register(
        new TypeDescriptor<>(
            Types.VARBINARY,
            byte[].class,
            StandardSQLTypeName.BYTES,
            Arrays.asList(byte[].class),
            (val, zone) -> {
              if (val instanceof byte[]) return (byte[]) val;
              throw new IllegalArgumentException("Cannot convert to BYTES: " + val);
            }));

    // ARRAY
    register(
        new TypeDescriptor<>(
            Types.ARRAY,
            Array.class,
            StandardSQLTypeName.ARRAY,
            Arrays.asList(Array.class),
            (val, zone) -> {
              if (val instanceof Array) return (Array) val;
              throw new IllegalArgumentException("Cannot convert to ARRAY: " + val);
            }));

    // STRUCT
    register(
        new TypeDescriptor<>(
            Types.STRUCT,
            Struct.class,
            StandardSQLTypeName.STRUCT,
            Arrays.asList(Struct.class),
            (val, zone) -> {
              if (val instanceof Struct) return (Struct) val;
              throw new IllegalArgumentException("Cannot convert to STRUCT: " + val);
            }));

    // JSON
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.JSON,
            Arrays.asList(com.google.gson.JsonObject.class),
            (val, zone) -> String.valueOf(val)));

    // BIGNUMERIC
    register(
        new TypeDescriptor<>(
            Types.NUMERIC,
            BigDecimal.class,
            StandardSQLTypeName.BIGNUMERIC,
            Arrays.asList(BigDecimal.class),
            (val, zone) -> {
              if (val instanceof BigDecimal) return (BigDecimal) val;
              if (val instanceof Number) return BigDecimal.valueOf(((Number) val).doubleValue());
              if (val instanceof String) return new BigDecimal((String) val);
              throw new IllegalArgumentException("Cannot convert to BIGNUMERIC: " + val);
            }));

    // GEOGRAPHY
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.GEOGRAPHY,
            Arrays.asList(String.class),
            (val, zone) -> String.valueOf(val)));

    // INTERVAL
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.INTERVAL,
            Arrays.asList(String.class),
            (val, zone) -> String.valueOf(val)));

    // RANGE
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.RANGE,
            Arrays.asList(String.class),
            (val, zone) -> String.valueOf(val)));
  }

  private static void register(TypeDescriptor<?> descriptor) {
    if (DESCRIPTORS_BY_ORDINAL[descriptor.getBqType().ordinal()] == null) {
      DESCRIPTORS_BY_ORDINAL[descriptor.getBqType().ordinal()] = descriptor;
    }
    DESCRIPTORS_BY_JDBC_TYPE.putIfAbsent(descriptor.getJdbcType(), descriptor);
    for (Class<?> clazz : descriptor.getSupportedJavaTypes()) {
      DESCRIPTORS_BY_CLASS.putIfAbsent(clazz, descriptor);
    }
  }

  private BigQueryTypeRegistry() {}

  /**
   * Returns the exact BigQuery StandardSQLTypeName for a given Java class. If no mapping is found,
   * returns StandardSQLTypeName.STRING as a fallback.
   */
  public static StandardSQLTypeName toBigQueryType(Class<?> clazz) {
    TypeDescriptor<?> descriptor = getDescriptorForClass(clazz);
    if (descriptor != null) {
      return descriptor.getBqType();
    }
    return StandardSQLTypeName.STRING;
  }

  /** Returns the default Java target class for a given JDBC type constant. */
  public static Class<?> toJavaClass(int jdbcType) {
    TypeDescriptor<?> descriptor = DESCRIPTORS_BY_JDBC_TYPE.get(jdbcType);
    if (descriptor != null) {
      return descriptor.getDefaultJavaClass();
    }
    return String.class; // fallback
  }

  /** Converts the input value to the target class type. */
  @SuppressWarnings("unchecked")
  public static <T> T convert(Object input, Class<T> targetClass) {
    if (input == null) {
      return null;
    }
    TypeDescriptor<?> descriptor = getDescriptorForClass(targetClass);
    if (descriptor == null) {
      throw new IllegalArgumentException("Unsupported target class: " + targetClass.getName());
    }
    return (T) descriptor.convert(input, null);
  }

  private static TypeDescriptor<?> getDescriptorForClass(Class<?> clazz) {
    TypeDescriptor<?> descriptor = DESCRIPTORS_BY_CLASS.get(clazz);
    if (descriptor != null) {
      return descriptor;
    }
    // Fallback logic for subclasses/interfaces
    for (Map.Entry<Class<?>, TypeDescriptor<?>> entry : DESCRIPTORS_BY_CLASS.entrySet()) {
      if (entry.getKey().isAssignableFrom(clazz)) {
        return entry.getValue();
      }
    }
    return null;
  }
}

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
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A central, bidirectional engine for resolving and coercing types between JDBC, Java, and
 * BigQuery.
 */
final class BigQueryTypeRegistry {

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
    DESCRIPTORS_BY_CLASS = new ConcurrentHashMap<>();
    DESCRIPTORS_BY_JDBC_TYPE = new ConcurrentHashMap<>();

    // BOOL
    register(
        new TypeDescriptor<>(
            Types.BOOLEAN,
            Boolean.class,
            StandardSQLTypeName.BOOL,
            Arrays.asList(Boolean.class),
            (val, targetClass, zone) -> {
              if (val instanceof Boolean) return val;
              if (val instanceof String) return Boolean.parseBoolean((String) val);
              throw new BigQueryJdbcException("Cannot convert to BOOL: " + val);
            }));

    // STRING
    register(
        new TypeDescriptor<>(
            Types.NVARCHAR,
            String.class,
            StandardSQLTypeName.STRING,
            Arrays.asList(String.class),
            (val, targetClass, zone) -> String.valueOf(val)));

    // INT64
    register(
        new TypeDescriptor<>(
            Types.BIGINT,
            Long.class,
            StandardSQLTypeName.INT64,
            Arrays.asList(Long.class, Integer.class, Short.class, Byte.class),
            (val, targetClass, zone) -> {
              long longVal;
              if (val instanceof Number) longVal = ((Number) val).longValue();
              else if (val instanceof String) longVal = Long.parseLong((String) val);
              else throw new BigQueryJdbcException("Cannot convert to INT64: " + val);

              if (targetClass == Integer.class) return (int) longVal;
              if (targetClass == Short.class) return (short) longVal;
              if (targetClass == Byte.class) return (byte) longVal;
              return longVal;
            }));

    // FLOAT64
    register(
        new TypeDescriptor<>(
            Types.DOUBLE,
            Double.class,
            StandardSQLTypeName.FLOAT64,
            Arrays.asList(Double.class, Float.class),
            (val, targetClass, zone) -> {
              double doubleVal;
              if (val instanceof Number) doubleVal = ((Number) val).doubleValue();
              else if (val instanceof String) doubleVal = Double.parseDouble((String) val);
              else throw new BigQueryJdbcException("Cannot convert to FLOAT64: " + val);

              if (targetClass == Float.class) return (float) doubleVal;
              return doubleVal;
            }));

    // NUMERIC
    register(
        new TypeDescriptor<>(
            Types.NUMERIC,
            BigDecimal.class,
            StandardSQLTypeName.NUMERIC,
            Arrays.asList(BigDecimal.class),
            (val, targetClass, zone) -> {
              if (val instanceof BigDecimal) return val;
              if (val instanceof Number) return new BigDecimal(val.toString());
              if (val instanceof String) return new BigDecimal((String) val);
              throw new BigQueryJdbcException("Cannot convert to NUMERIC: " + val);
            }));

    // --- TEMPORAL TYPES MOVED TO PHASE 2 PR ---
    // DATE, DATETIME, TIMESTAMP, and TIME descriptors require BigQueryTemporalUtility
    // which will be introduced in the stacked Phase 2 PR.
    
    // BYTES
    register(
        new TypeDescriptor<>(
            Types.VARBINARY,
            byte[].class,
            StandardSQLTypeName.BYTES,
            Arrays.asList(byte[].class),
            (val, targetClass, zone) -> {
              if (val instanceof byte[]) return val;
              throw new BigQueryJdbcException("Cannot convert to BYTES: " + val);
            }));

    // ARRAY
    register(
        new TypeDescriptor<>(
            Types.ARRAY,
            Array.class,
            StandardSQLTypeName.ARRAY,
            Arrays.asList(Array.class),
            (val, targetClass, zone) -> {
              if (val instanceof Array) return val;
              throw new BigQueryJdbcException("Cannot convert to ARRAY: " + val);
            }));

    // STRUCT
    register(
        new TypeDescriptor<>(
            Types.STRUCT,
            Struct.class,
            StandardSQLTypeName.STRUCT,
            Arrays.asList(Struct.class),
            (val, targetClass, zone) -> {
              if (val instanceof Struct) return val;
              throw new BigQueryJdbcException("Cannot convert to STRUCT: " + val);
            }));

    // JSON
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.JSON,
            Arrays.asList(com.google.gson.JsonObject.class),
            (val, targetClass, zone) -> String.valueOf(val)));

    // BIGNUMERIC
    register(
        new TypeDescriptor<>(
            Types.NUMERIC,
            BigDecimal.class,
            StandardSQLTypeName.BIGNUMERIC,
            Arrays.asList(BigDecimal.class),
            (val, targetClass, zone) -> {
              if (val instanceof BigDecimal) return val;
              if (val instanceof Number) return new BigDecimal(val.toString());
              if (val instanceof String) return new BigDecimal((String) val);
              throw new BigQueryJdbcException("Cannot convert to BIGNUMERIC: " + val);
            }));

    // GEOGRAPHY
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.GEOGRAPHY,
            Arrays.asList(String.class),
            (val, targetClass, zone) -> String.valueOf(val)));

    // INTERVAL
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.INTERVAL,
            Arrays.asList(String.class),
            (val, targetClass, zone) -> String.valueOf(val)));

    // RANGE
    register(
        new TypeDescriptor<>(
            Types.OTHER,
            String.class,
            StandardSQLTypeName.RANGE,
            Arrays.asList(String.class),
            (val, targetClass, zone) -> String.valueOf(val)));
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

  /**
   * Converts the input value to the target class type by looking up the target class descriptor.
   */
  @SuppressWarnings("unchecked")
  public static <T> T convert(Object input, Class<T> targetClass) throws BigQueryJdbcException {
    if (input == null) {
      return null;
    }
    TypeDescriptor<?> descriptor = getDescriptorForClass(targetClass);
    if (descriptor == null) {
      throw new BigQueryJdbcException("Unsupported target class: " + targetClass.getName());
    }
    return (T) descriptor.convert(input, targetClass, null);
  }

  /**
   * High-performance hotpath convert for ResultSets. Converts the input value using the default
   * mapping for the given BigQuery type via O(1) array indexing.
   */
  public static Object convert(Object input, StandardSQLTypeName bqType, ZoneId zoneId)
      throws BigQueryJdbcException {
    if (input == null) return null;
    int ordinal = bqType.ordinal();
    if (ordinal >= DESCRIPTORS_BY_ORDINAL.length || DESCRIPTORS_BY_ORDINAL[ordinal] == null) {
      throw new BigQueryJdbcException("No type descriptor registered for BigQuery type: " + bqType);
    }
    TypeDescriptor<?> descriptor = DESCRIPTORS_BY_ORDINAL[ordinal];
    return descriptor.convert(input, descriptor.getDefaultJavaClass(), zoneId);
  }

  /**
   * High-performance hotpath convert for ResultSets. Converts the input value to the target class
   * using the descriptor for the given BigQuery type via O(1) array indexing.
   */
  @SuppressWarnings("unchecked")
  public static <T> T convert(
      Object input, StandardSQLTypeName bqType, Class<T> targetClass, ZoneId zoneId)
      throws BigQueryJdbcException {
    if (input == null) return null;
    int ordinal = bqType.ordinal();
    if (ordinal >= DESCRIPTORS_BY_ORDINAL.length || DESCRIPTORS_BY_ORDINAL[ordinal] == null) {
      throw new BigQueryJdbcException("No type descriptor registered for BigQuery type: " + bqType);
    }
    return (T) DESCRIPTORS_BY_ORDINAL[ordinal].convert(input, targetClass, zoneId);
  }

  private static TypeDescriptor<?> getDescriptorForClass(Class<?> clazz) {
    TypeDescriptor<?> descriptor = DESCRIPTORS_BY_CLASS.get(clazz);
    if (descriptor != null) {
      return descriptor;
    }
    // Fallback logic for subclasses/interfaces (O(N) initial lookup)
    for (Map.Entry<Class<?>, TypeDescriptor<?>> entry : DESCRIPTORS_BY_CLASS.entrySet()) {
      if (entry.getKey().isAssignableFrom(clazz)) {
        TypeDescriptor<?> matchedDescriptor = entry.getValue();
        // Cache the result in the ConcurrentHashMap to turn subsequent subclass lookups into O(1)
        DESCRIPTORS_BY_CLASS.putIfAbsent(clazz, matchedDescriptor);
        return matchedDescriptor;
      }
    }
    return null;
  }
}

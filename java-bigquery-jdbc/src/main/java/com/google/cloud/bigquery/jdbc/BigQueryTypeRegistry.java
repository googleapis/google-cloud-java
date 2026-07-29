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
              if (val instanceof Number) return BigDecimal.valueOf(((Number) val).doubleValue());
              if (val instanceof String) return new BigDecimal((String) val);
              throw new BigQueryJdbcException("Cannot convert to NUMERIC: " + val);
            }));

    // DATE
    register(
        new TypeDescriptor<>(
            Types.DATE,
            Date.class,
            StandardSQLTypeName.DATE,
            Arrays.asList(Date.class, LocalDate.class),
            (val, targetClass, zone) -> {
              Date sqlDate;
              if (val instanceof Date) sqlDate = (Date) val;
              else if (val instanceof LocalDate) sqlDate = Date.valueOf((LocalDate) val);
              else if (val instanceof String) sqlDate = Date.valueOf((String) val);
              else throw new BigQueryJdbcException("Cannot convert to DATE: " + val);

              if (targetClass == LocalDate.class) return sqlDate.toLocalDate();
              return sqlDate;
            }));

    // DATETIME
    register(
        new TypeDescriptor<>(
            Types.TIMESTAMP,
            Timestamp.class,
            StandardSQLTypeName.DATETIME,
            Arrays.asList(Timestamp.class, LocalDateTime.class),
            (val, targetClass, zone) -> {
              Timestamp ts;
              if (val instanceof Timestamp) ts = (Timestamp) val;
              else if (val instanceof LocalDateTime) ts = Timestamp.valueOf((LocalDateTime) val);
              else if (val instanceof String) {
                String str = (String) val;
                if (str.contains("T")) {
                  ts = Timestamp.valueOf(LocalDateTime.parse(str));
                } else {
                  ts = Timestamp.valueOf(str);
                }
              } else throw new BigQueryJdbcException("Cannot convert to DATETIME: " + val);

              if (targetClass == LocalDateTime.class) return ts.toLocalDateTime();
              return ts;
            }));

    // TIMESTAMP
    register(
        new TypeDescriptor<>(
            Types.TIMESTAMP,
            Timestamp.class,
            StandardSQLTypeName.TIMESTAMP,
            Arrays.asList(
                Timestamp.class, OffsetDateTime.class, Instant.class, ZonedDateTime.class),
            (val, targetClass, zone) -> {
              Timestamp ts;
              if (val instanceof Timestamp) ts = (Timestamp) val;
              else if (val instanceof String) {
                String str = (String) val;
                if (str.contains("T") || str.contains("Z")) {
                  ts = Timestamp.from(Instant.parse(str));
                } else {
                  ts = Timestamp.valueOf(str);
                }
              } else throw new BigQueryJdbcException("Cannot convert to TIMESTAMP: " + val);

              if (targetClass == Instant.class) return ts.toInstant();
              if (targetClass == OffsetDateTime.class)
                return ts.toInstant().atOffset(java.time.ZoneOffset.UTC);
              if (targetClass == ZonedDateTime.class)
                return ts.toInstant().atZone(java.time.ZoneOffset.UTC);
              return ts;
            }));

    // TIME
    register(
        new TypeDescriptor<>(
            Types.TIME,
            Time.class,
            StandardSQLTypeName.TIME,
            Arrays.asList(Time.class, LocalTime.class),
            (val, targetClass, zone) -> {
              Time sqlTime;
              if (val instanceof Time) sqlTime = (Time) val;
              else if (val instanceof LocalTime) sqlTime = Time.valueOf((LocalTime) val);
              else if (val instanceof String) sqlTime = Time.valueOf((String) val);
              else throw new BigQueryJdbcException("Cannot convert to TIME: " + val);

              if (targetClass == LocalTime.class) return sqlTime.toLocalTime();
              return sqlTime;
            }));

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
              if (val instanceof Number) return BigDecimal.valueOf(((Number) val).doubleValue());
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

  /** Converts the input value to the target class type. */
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

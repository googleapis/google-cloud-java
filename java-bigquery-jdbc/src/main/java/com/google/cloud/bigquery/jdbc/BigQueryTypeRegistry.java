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

import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.Range;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.common.collect.ImmutableMap;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.sql.Struct;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.arrow.vector.PeriodDuration;

/**
 * A central, bidirectional engine for resolving and coercing types between JDBC, Java, and
 * BigQuery.
 */
final class BigQueryTypeRegistry {

  private static final TypeDescriptor<?>[] DESCRIPTORS_BY_ORDINAL;
  private static final Map<Class<?>, TypeDescriptor<?>> DESCRIPTORS_BY_CLASS;
  private static final Map<Integer, TypeDescriptor<?>> DESCRIPTORS_BY_JDBC_TYPE;

  private static final DateTimeFormatter TIMESTAMP_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
  private static final DateTimeFormatter TIME_FORMATTER =
      DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

  static {
    DESCRIPTORS_BY_ORDINAL = new TypeDescriptor<?>[StandardSQLTypeName.values().length];
    DESCRIPTORS_BY_CLASS = new ConcurrentHashMap<>();
    DESCRIPTORS_BY_JDBC_TYPE = new ConcurrentHashMap<>();

    register(createBoolDescriptor());
    register(createStringDescriptor());
    register(createInt64Descriptor());
    register(createFloat64Descriptor());
    register(createNumericDescriptor());
    register(createDateDescriptor());
    register(createTimestampDescriptor());
    register(createDatetimeDescriptor());
    register(createTimeDescriptor());
    register(createBytesDescriptor());
    register(createArrayDescriptor());
    register(createStructDescriptor());
    register(createJsonDescriptor());
    register(createBignumericDescriptor());
    register(createGeographyDescriptor());
    register(createIntervalDescriptor());
    register(createRangeDescriptor());
  }

  static TypeDescriptor<?> createBoolDescriptor() {
    return new TypeDescriptor<>(
        Types.BOOLEAN,
        Boolean.class,
        StandardSQLTypeName.BOOL,
        Arrays.asList(Boolean.class),
        (val, targetClass, zone) -> {
          if (val instanceof Boolean) {
            return val;
          }
          if (val instanceof Number) {
            return ((Number) val).longValue() != 0;
          }
          if (val instanceof String) {
            return Boolean.parseBoolean((String) val);
          }
          throw new BigQueryJdbcException("Cannot convert to BOOL: " + val);
        });
  }

  static TypeDescriptor<?> createStringDescriptor() {
    return new TypeDescriptor<>(
        Types.NVARCHAR,
        String.class,
        StandardSQLTypeName.STRING,
        Arrays.asList(String.class),
        (val, targetClass, zone) -> {
          if (val == null) {
            return null;
          }
          if (val instanceof byte[]) {
            return Base64.getEncoder().encodeToString((byte[]) val);
          }
          if (val instanceof Timestamp) {
            return TIMESTAMP_FORMATTER.format(((Timestamp) val).toLocalDateTime());
          }
          if (val instanceof Time) {
            return TIME_FORMATTER.format(((Time) val).toLocalTime());
          }
          return String.valueOf(val);
        });
  }

  static TypeDescriptor<?> createInt64Descriptor() {
    return new TypeDescriptor<>(
        Types.BIGINT,
        Long.class,
        StandardSQLTypeName.INT64,
        Arrays.asList(Long.class, Integer.class, Short.class, Byte.class),
        (val, targetClass, zone) -> {
          long longVal;
          if (val instanceof Number) {
            if (val instanceof BigDecimal) {
              BigDecimal bd = (BigDecimal) val;
              if (bd.compareTo(new BigDecimal(Long.MAX_VALUE)) > 0
                  || bd.compareTo(new BigDecimal(Long.MIN_VALUE)) < 0) {
                throw new BigQueryJdbcException("Value out of range for Long: " + bd);
              }
            }
            longVal = ((Number) val).longValue();
          } else if (val instanceof String) {
            longVal = Long.parseLong((String) val);
          } else if (val instanceof Boolean) {
            longVal = (Boolean) val ? 1L : 0L;
          } else {
            throw new BigQueryJdbcException("Cannot convert to INT64: " + val);
          }

          if (targetClass == Integer.class) {
            if (longVal > Integer.MAX_VALUE || longVal < Integer.MIN_VALUE) {
              throw new BigQueryJdbcException("Value out of range for Integer: " + longVal);
            }
            return (int) longVal;
          }
          if (targetClass == Short.class) {
            if (longVal > Short.MAX_VALUE || longVal < Short.MIN_VALUE) {
              throw new BigQueryJdbcException("Value out of range for Short: " + longVal);
            }
            return (short) longVal;
          }
          if (targetClass == Byte.class) {
            if (longVal > Byte.MAX_VALUE || longVal < Byte.MIN_VALUE) {
              throw new BigQueryJdbcException("Value out of range for Byte: " + longVal);
            }
            return (byte) longVal;
          }
          return longVal;
        });
  }

  static TypeDescriptor<?> createFloat64Descriptor() {
    return new TypeDescriptor<>(
        Types.DOUBLE,
        Double.class,
        StandardSQLTypeName.FLOAT64,
        Arrays.asList(Double.class, Float.class),
        (val, targetClass, zone) -> {
          double doubleVal;
          if (val instanceof Number) doubleVal = ((Number) val).doubleValue();
          else if (val instanceof String) doubleVal = Double.parseDouble((String) val);
          else if (val instanceof Boolean) doubleVal = (Boolean) val ? 1.0 : 0.0;
          else throw new BigQueryJdbcException("Cannot convert to FLOAT64: " + val);

          if (targetClass == Float.class) {
            return (float) doubleVal;
          }
          return doubleVal;
        });
  }

  static TypeDescriptor<?> createNumericDescriptor() {
    return new TypeDescriptor<>(
        Types.NUMERIC,
        BigDecimal.class,
        StandardSQLTypeName.NUMERIC,
        Arrays.asList(BigDecimal.class),
        (val, targetClass, zone) -> {
          if (val instanceof BigDecimal) {
            return val;
          }
          if (val instanceof Number) {
            return new BigDecimal(val.toString());
          }
          if (val instanceof String) {
            return new BigDecimal((String) val);
          }
          if (val instanceof Boolean) {
            return (Boolean) val ? BigDecimal.ONE : BigDecimal.ZERO;
          }
          throw new BigQueryJdbcException("Cannot convert to NUMERIC: " + val);
        });
  }

  static TypeDescriptor<?> createDateDescriptor() {
    return new TypeDescriptor<>(
        Types.DATE,
        Date.class,
        StandardSQLTypeName.DATE,
        Arrays.asList(Date.class, LocalDate.class),
        (val, targetClass, zone) -> {
          // Modern fast-path: Bypass intermediate object creation for JSR-310 targets
          if (targetClass == LocalDate.class) {
            if (val instanceof LocalDate) {
              return val;
            } else if (val instanceof Date) {
              return ((Date) val).toLocalDate();
            } else if (val instanceof Timestamp) {
              return ((Timestamp) val).toInstant().atOffset(ZoneOffset.UTC).toLocalDate();
            } else if (val instanceof java.sql.Time) {
              throw new BigQueryJdbcException("Cannot convert to DATE: " + val);
            } else if (val instanceof java.util.Date) {
              return new Date(((java.util.Date) val).getTime()).toLocalDate();
            } else if (val instanceof LocalDateTime) {
              return ((LocalDateTime) val).toLocalDate();
            } else if (val instanceof String) {
              return LocalDate.parse((String) val);
            } else {
              throw new BigQueryJdbcException("Cannot convert to DATE: " + val);
            }
          }

          // Legacy path: Box values into java.sql.Date
          Date sqlDate;
          if (val instanceof Date) {
            sqlDate = (Date) val;
          } else if (val instanceof Timestamp) {
            sqlDate =
                Date.valueOf(((Timestamp) val).toInstant().atOffset(ZoneOffset.UTC).toLocalDate());
          } else if (val instanceof java.sql.Time) {
            throw new BigQueryJdbcException("Cannot convert to DATE: " + val);
          } else if (val instanceof java.util.Date) {
            sqlDate = new Date(((java.util.Date) val).getTime());
          } else if (val instanceof LocalDate) {
            sqlDate = Date.valueOf((LocalDate) val);
          } else if (val instanceof LocalDateTime) {
            sqlDate = Date.valueOf(((LocalDateTime) val).toLocalDate());
          } else if (val instanceof String) {
            sqlDate = BigQueryTemporalUtility.boxDate((String) val, zone);
          } else {
            throw new BigQueryJdbcException("Cannot convert to DATE: " + val);
          }

          return sqlDate;
        });
  }

  static TypeDescriptor<?> createDatetimeDescriptor() {
    return new TypeDescriptor<>(
        Types.TIMESTAMP,
        Timestamp.class,
        StandardSQLTypeName.DATETIME,
        Arrays.asList(Timestamp.class, LocalDateTime.class),
        (val, targetClass, zone) -> {
          // Modern fast-path: Bypass intermediate object creation for JSR-310 targets
          if (targetClass == LocalDateTime.class) {
            if (val instanceof LocalDateTime) {
              return val;
            } else if (val instanceof Timestamp) {
              return ((Timestamp) val).toLocalDateTime();
            } else if (val instanceof java.util.Date) {
              return new Timestamp(((java.util.Date) val).getTime()).toLocalDateTime();
            } else if (val instanceof String) {
              return LocalDateTime.parse(((String) val).replace(' ', 'T'));
            } else {
              throw new BigQueryJdbcException("Cannot convert to DATETIME: " + val);
            }
          }

          // Legacy path: Box values into java.sql.Timestamp
          Timestamp ts;
          if (val instanceof Timestamp) {
            ts = (Timestamp) val;
          } else if (val instanceof java.util.Date) {
            ts = new Timestamp(((java.util.Date) val).getTime());
          } else if (val instanceof LocalDateTime) {
            ts = Timestamp.valueOf((LocalDateTime) val);
          } else if (val instanceof String) {
            ts = BigQueryTemporalUtility.boxDateTime((String) val, zone);
          } else {
            throw new BigQueryJdbcException("Cannot convert to DATETIME: " + val);
          }

          return ts;
        });
  }

  static TypeDescriptor<?> createTimestampDescriptor() {
    return new TypeDescriptor<>(
        Types.TIMESTAMP,
        Timestamp.class,
        StandardSQLTypeName.TIMESTAMP,
        Arrays.asList(Timestamp.class, OffsetDateTime.class, Instant.class, ZonedDateTime.class),
        (val, targetClass, zone) -> {
          // Modern fast-path: Bypass intermediate object creation for JSR-310 targets
          if (targetClass == Instant.class || targetClass == OffsetDateTime.class || targetClass == ZonedDateTime.class) {
            Instant instant;
            if (val instanceof Instant) {
              instant = (Instant) val;
            } else if (val instanceof OffsetDateTime) {
              instant = ((OffsetDateTime) val).toInstant();
            } else if (val instanceof ZonedDateTime) {
              instant = ((ZonedDateTime) val).toInstant();
            } else if (val instanceof Timestamp) {
              instant = ((Timestamp) val).toInstant();
            } else if (val instanceof java.util.Date) {
              instant = Instant.ofEpochMilli(((java.util.Date) val).getTime());
            } else if (val instanceof LocalDateTime) {
              instant = ((LocalDateTime) val).toInstant(ZoneOffset.UTC);
            } else if (val instanceof Long) {
              instant = Instant.EPOCH.plus((Long) val, java.time.temporal.ChronoUnit.MICROS);
            } else if (val instanceof String) {
              instant = BigQueryTemporalUtility.boxTimestamp((String) val).toInstant();
            } else {
              throw new BigQueryJdbcException("Cannot convert to TIMESTAMP: " + val);
            }

            if (targetClass == Instant.class) return instant;
            if (targetClass == OffsetDateTime.class) return instant.atOffset(ZoneOffset.UTC);
            if (targetClass == ZonedDateTime.class) return instant.atZone(ZoneOffset.UTC);
          }

          // Legacy path: Box values into java.sql.Timestamp
          Timestamp ts;
          if (val instanceof Timestamp) {
            ts = (Timestamp) val;
          } else if (val instanceof java.util.Date) {
            ts = new Timestamp(((java.util.Date) val).getTime());
          } else if (val instanceof Instant) {
            ts = Timestamp.from((Instant) val);
          } else if (val instanceof OffsetDateTime) {
            ts = Timestamp.from(((OffsetDateTime) val).toInstant());
          } else if (val instanceof ZonedDateTime) {
            ts = Timestamp.from(((ZonedDateTime) val).toInstant());
          } else if (val instanceof LocalDateTime) {
            ts = Timestamp.from(((LocalDateTime) val).toInstant(ZoneOffset.UTC));
          } else if (val instanceof Long) {
            ts = Timestamp.from(Instant.EPOCH.plus((Long) val, java.time.temporal.ChronoUnit.MICROS));
          } else if (val instanceof String) {
            ts = BigQueryTemporalUtility.boxTimestamp((String) val);
          } else {
            throw new BigQueryJdbcException("Cannot convert to TIMESTAMP: " + val);
          }

          return ts;
        });
  }

  static TypeDescriptor<?> createTimeDescriptor() {
    return new TypeDescriptor<>(
        Types.TIME,
        Time.class,
        StandardSQLTypeName.TIME,
        Arrays.asList(Time.class, LocalTime.class),
        (val, targetClass, zone) -> {
          if (targetClass == LocalTime.class && val instanceof String) {
            // Phase 3 Fast Path: Parse directly to LocalTime to preserve microsecond precision
            return LocalTime.parse((String) val);
          }

          Time sqlTime;
          if (val instanceof Time) sqlTime = (Time) val;
          else if (val instanceof Timestamp) {
            sqlTime =
                Time.valueOf(((Timestamp) val).toInstant().atOffset(ZoneOffset.UTC).toLocalTime());
          } else if (val instanceof java.sql.Date) {
            throw new BigQueryJdbcException("Cannot convert to TIME: " + val);
          } else if (val instanceof java.util.Date)
            sqlTime = new Time(((java.util.Date) val).getTime());
          else if (val instanceof LocalTime) sqlTime = Time.valueOf((LocalTime) val);
          else if (val instanceof LocalDateTime) {
            long millisOfDay = ((LocalDateTime) val).toLocalTime().toNanoOfDay() / 1_000_000;
            sqlTime = new Time(BigQueryTemporalUtility.getLocalMillis(millisOfDay, zone));
          } else if (val instanceof Long) {
            long millisOfDay = (Long) val / 1000;
            // Align with civil time anchoring
            sqlTime = new Time(BigQueryTemporalUtility.getLocalMillis(millisOfDay, zone));
          } else if (val instanceof String)
            sqlTime = BigQueryTemporalUtility.boxTime((String) val, zone);
          else throw new BigQueryJdbcException("Cannot convert to TIME: " + val);

          if (targetClass == LocalTime.class) {
            // java.sql.Time.toLocalTime() drops milliseconds (JDK bug).
            // We manually convert it using the JVM offset to preserve millisecond precision.
            long epochMillis = sqlTime.getTime();
            return Instant.ofEpochMilli(epochMillis).atZone(ZoneId.systemDefault()).toLocalTime();
          }
          return sqlTime;
        });
  }

  static TypeDescriptor<?> createBytesDescriptor() {
    return new TypeDescriptor<>(
        Types.VARBINARY,
        byte[].class,
        StandardSQLTypeName.BYTES,
        Arrays.asList(byte[].class),
        (val, targetClass, zone) -> {
          if (val instanceof byte[]) {
            return val;
          } else if (val instanceof String) {
            return Base64.getDecoder().decode((String) val);
          }
          throw new BigQueryJdbcException("Cannot convert to BYTES: " + val);
        });
  }

  static TypeDescriptor<?> createArrayDescriptor() {
    return new TypeDescriptor<>(
        Types.ARRAY,
        Array.class,
        StandardSQLTypeName.ARRAY,
        Arrays.asList(Array.class),
        (val, targetClass, zone) -> {
          if (val instanceof Array) {
            return val;
          }
          throw new BigQueryJdbcException("Cannot convert to ARRAY: " + val);
        });
  }

  static TypeDescriptor<?> createStructDescriptor() {
    return new TypeDescriptor<>(
        Types.STRUCT,
        Struct.class,
        StandardSQLTypeName.STRUCT,
        Arrays.asList(Struct.class),
        (val, targetClass, zone) -> {
          if (val instanceof Struct) {
            return val;
          }
          throw new BigQueryJdbcException("Cannot convert to STRUCT: " + val);
        });
  }

  static TypeDescriptor<?> createJsonDescriptor() {
    return new TypeDescriptor<>(
        Types.OTHER,
        String.class,
        StandardSQLTypeName.JSON,
        Arrays.asList(com.google.gson.JsonObject.class),
        (val, targetClass, zone) -> String.valueOf(val));
  }

  static TypeDescriptor<?> createBignumericDescriptor() {
    return new TypeDescriptor<>(
        Types.NUMERIC,
        BigDecimal.class,
        StandardSQLTypeName.BIGNUMERIC,
        Arrays.asList(BigDecimal.class),
        (val, targetClass, zone) -> {
          if (val instanceof BigDecimal) {
            return val;
          }
          if (val instanceof Number) {
            return new BigDecimal(val.toString());
          }
          if (val instanceof String) {
            return new BigDecimal((String) val);
          }
          throw new BigQueryJdbcException("Cannot convert to BIGNUMERIC: " + val);
        });
  }

  static TypeDescriptor<?> createGeographyDescriptor() {
    return new TypeDescriptor<>(
        Types.OTHER,
        String.class,
        StandardSQLTypeName.GEOGRAPHY,
        Arrays.asList(String.class),
        (val, targetClass, zone) -> String.valueOf(val));
  }

  static TypeDescriptor<?> createIntervalDescriptor() {
    return new TypeDescriptor<>(
        Types.OTHER,
        String.class,
        StandardSQLTypeName.INTERVAL,
        Arrays.asList(String.class),
        (val, targetClass, zone) -> {
          if (val == null) return null;
          if (val instanceof PeriodDuration) {
            PeriodDuration pd = (PeriodDuration) val;
            Period period = pd.getPeriod().normalized();
            StringBuilder builder = new StringBuilder();
            builder
                .append(period.getYears())
                .append("-")
                .append(period.getMonths())
                .append(" ")
                .append(period.getDays())
                .append(" ");
            Duration duration = pd.getDuration();
            if (duration.isNegative()) {
              builder.append("-");
              duration = duration.negated();
            }
            long hours = duration.toHours();
            duration = duration.minusHours(hours);
            long minutes = duration.toMinutes();
            duration = duration.minusMinutes(minutes);
            long seconds = duration.getSeconds();
            duration = duration.minusSeconds(seconds);
            long microseconds = duration.toNanos() / 1000;
            builder
                .append(hours)
                .append(":")
                .append(minutes)
                .append(":")
                .append(seconds)
                .append(".")
                .append(microseconds);
            return builder.toString().replaceFirst("--", "-");
          }
          return String.valueOf(val);
        });
  }

  static TypeDescriptor<?> createRangeDescriptor() {
    return new TypeDescriptor<>(
        Types.OTHER,
        String.class,
        StandardSQLTypeName.RANGE,
        Arrays.asList(String.class),
        (val, targetClass, zone) -> {
          if (val == null) return null;
          if (val instanceof Range) {
            Range range = (Range) val;
            String start =
                range.getStart().isNull() ? "UNBOUNDED" : range.getStart().getStringValue();
            String end = range.getEnd().isNull() ? "UNBOUNDED" : range.getEnd().getStringValue();
            return String.format("[%s, %s)", start, end);
          }
          return String.valueOf(val);
        });
  }

  private static void register(TypeDescriptor<?> descriptor) {
    if (DESCRIPTORS_BY_ORDINAL[descriptor.getBqType().ordinal()] != null) {
      throw new IllegalStateException(
          "Error: Duplicate TypeDescriptor registration attempted for BigQuery type '"
              + descriptor.getBqType()
              + "'. A StandardSQLTypeName can only be registered once.");
    }
    DESCRIPTORS_BY_ORDINAL[descriptor.getBqType().ordinal()] = descriptor;
    DESCRIPTORS_BY_JDBC_TYPE.putIfAbsent(descriptor.getJdbcType(), descriptor);
    for (Class<?> clazz : descriptor.getSupportedJavaTypes()) {
      DESCRIPTORS_BY_CLASS.putIfAbsent(clazz, descriptor);
    }
  }

  private BigQueryTypeRegistry() {}

  /**
   * Returns the exact BigQuery StandardSQLTypeName for a given Java class. If no mapping is found,
   * returns StandardSQLTypeName.STRING as a fallback to preserve backward compatibility.
   */
  public static StandardSQLTypeName toBigQueryType(Class<?> clazz) {
    TypeDescriptor<?> descriptor = getDescriptorForClass(clazz);
    if (descriptor != null) {
      return descriptor.getBqType();
    }
    return StandardSQLTypeName.STRING; // Legacy fallback
  }

  /** Returns the JDBC Type constant for a given BigQuery type. */
  public static int toJdbcType(StandardSQLTypeName bqType) {
    if (bqType == null) {
      return java.sql.Types.OTHER;
    }
    int ordinal = bqType.ordinal();
    if (ordinal >= DESCRIPTORS_BY_ORDINAL.length || DESCRIPTORS_BY_ORDINAL[ordinal] == null) {
      return java.sql.Types.OTHER;
    }
    return DESCRIPTORS_BY_ORDINAL[ordinal].getJdbcType();
  }

  /**
   * Explicit mapping to resolve lossy reverse-lookups. Since multiple JDBC types (e.g., TINYINT,
   * INTEGER) map to a single BigQuery type (INT64), this map ensures strict JDBC compliance by
   * returning the exact Java class (e.g., Integer.class) expected for PreparedStatement binding.
   */
  private static final Map<Integer, Class<?>> JDBC_TO_JAVA_CLASS_MAP =
      ImmutableMap.<Integer, Class<?>>builder()
          .put(Types.BIGINT, Long.class)
          .put(Types.INTEGER, Integer.class)
          .put(Types.SMALLINT, Short.class)
          .put(Types.TINYINT, Byte.class)
          .put(Types.BOOLEAN, Boolean.class)
          .put(Types.DOUBLE, Double.class)
          .put(Types.FLOAT, Float.class)
          .put(Types.NUMERIC, BigDecimal.class)
          .put(Types.DECIMAL, BigDecimal.class)
          .put(Types.VARCHAR, String.class)
          .put(Types.CHAR, String.class)
          .put(Types.LONGVARCHAR, String.class)
          .put(Types.NVARCHAR, String.class)
          .put(Types.NCHAR, String.class)
          .put(Types.LONGNVARCHAR, String.class)
          .put(Types.TIMESTAMP, Timestamp.class)
          .put(Types.DATE, Date.class)
          .put(Types.TIME, Time.class)
          .put(Types.OTHER, String.class)
          .put(Types.BINARY, byte[].class)
          .put(Types.VARBINARY, byte[].class)
          .put(Types.LONGVARBINARY, byte[].class)
          .put(Types.STRUCT, Struct.class)
          .put(Types.BIT, Boolean.class)
          .put(Types.ARRAY, Array.class)
          .put(Types.NULL, String.class)
          .put(Types.REAL, Float.class)
          .put(Types.CLOB, String.class)
          .put(Types.NCLOB, String.class)
          .put(Types.BLOB, byte[].class)
          .build();

  /** Returns the exact default Java Class for a given BigQuery type, avoiding lossy mappings. */
  public static Class<?> toJavaClass(StandardSQLTypeName bqType) {
    if (bqType == null) {
      return String.class;
    }
    int ordinal = bqType.ordinal();
    if (ordinal >= DESCRIPTORS_BY_ORDINAL.length || DESCRIPTORS_BY_ORDINAL[ordinal] == null) {
      return String.class;
    }
    return DESCRIPTORS_BY_ORDINAL[ordinal].getDefaultJavaClass();
  }

  /**
   * Returns the standard Java Class equivalent for a given JDBC SQL type.
   *
   * @param jdbcType the generic JDBC SQL type (e.g., {@link Types#INTEGER})
   * @return the corresponding Java Class (e.g., {@link Integer})
   * @throws BigQueryJdbcSqlFeatureNotSupportedException if the given SQL type is not supported
   */
  public static Class<?> toJavaClass(int jdbcType)
      throws BigQueryJdbcSqlFeatureNotSupportedException {
    Class<?> clazz = JDBC_TO_JAVA_CLASS_MAP.get(jdbcType);
    if (clazz == null) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "Unsupported Java type for SQL type: " + jdbcType);
    }
    return clazz;
  }

  /**
   * Converts the input value to the target class type by looking up the target class descriptor.
   */
  @SuppressWarnings("unchecked")
  public static <T> T convert(Object input, Class<T> targetClass) throws BigQueryJdbcException {
    if (input == null) {
      return null;
    }
    if (input instanceof FieldValue) {
      FieldValue fv = (FieldValue) input;
      if (fv.isNull()) return null;
      input = fv.getValue();
    }
    if (targetClass.isInstance(input)) {
      return (T) input;
    }
    TypeDescriptor<?> descriptor = getDescriptorForClass(targetClass);
    if (descriptor == null) {
      throw new BigQueryJdbcException("Unsupported target class: " + targetClass.getName());
    }
    try {
      return (T) descriptor.convert(input, targetClass, null);
    } catch (Exception e) {
      throw new BigQueryJdbcException(
          String.format("Failed to coerce value '%s' to %s", input, targetClass.getName()), e);
    }
  }

  /**
   * High-performance hotpath convert for ResultSets. Converts the input value using the default
   * mapping for the given BigQuery type via O(1) array indexing.
   */
  public static Object convert(Object input, StandardSQLTypeName bqType, ZoneId zoneId)
      throws BigQueryJdbcException {
    if (input == null) {
      return null;
    }
    if (input instanceof FieldValue) {
      FieldValue fv = (FieldValue) input;
      if (fv.isNull()) {
        return null;
      }
      input = fv.getValue();
    }
    int ordinal = bqType.ordinal();
    if (ordinal >= DESCRIPTORS_BY_ORDINAL.length || DESCRIPTORS_BY_ORDINAL[ordinal] == null) {
      throw new BigQueryJdbcException("No type descriptor registered for BigQuery type: " + bqType);
    }
    TypeDescriptor<?> descriptor = DESCRIPTORS_BY_ORDINAL[ordinal];
    try {
      return descriptor.convert(input, descriptor.getDefaultJavaClass(), zoneId);
    } catch (Exception e) {
      throw new BigQueryJdbcException(
          String.format("Failed to coerce value '%s' from BigQuery %s", input, bqType), e);
    }
  }

  /**
   * High-performance hotpath convert for ResultSets. Converts the input value to the target class
   * using the descriptor for the given BigQuery type via O(1) array indexing.
   */
  @SuppressWarnings("unchecked")
  public static <T> T convert(
      Object input, StandardSQLTypeName bqType, Class<T> targetClass, ZoneId zoneId)
      throws BigQueryJdbcException {
    if (input == null) {
      return null;
    }
    int ordinal = bqType.ordinal();
    if (ordinal >= DESCRIPTORS_BY_ORDINAL.length || DESCRIPTORS_BY_ORDINAL[ordinal] == null) {
      throw new BigQueryJdbcException("No type descriptor registered for BigQuery type: " + bqType);
    }
    try {
      return (T) DESCRIPTORS_BY_ORDINAL[ordinal].convert(input, targetClass, zoneId);
    } catch (Exception e) {
      throw new BigQueryJdbcException(
          String.format(
              "Failed to coerce value '%s' from BigQuery %s to %s",
              input, bqType, targetClass.getName()),
          e);
    }
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

  static class ColumnTypeInfo {
    final int jdbcType;
    final String typeName;
    final Integer columnSize;
    final Integer decimalDigits;
    final Integer numPrecRadix;

    ColumnTypeInfo(
        int jdbcType,
        String typeName,
        Integer columnSize,
        Integer decimalDigits,
        Integer numPrecRadix) {
      this.jdbcType = jdbcType;
      this.typeName = typeName;
      this.columnSize = columnSize;
      this.decimalDigits = decimalDigits;
      this.numPrecRadix = numPrecRadix;
    }
  }

  private static final Map<StandardSQLTypeName, ColumnTypeInfo> STANDARD_TYPE_INFO =
      ImmutableMap.<StandardSQLTypeName, ColumnTypeInfo>builder()
          .put(StandardSQLTypeName.INT64, new ColumnTypeInfo(Types.BIGINT, "INT64", 19, 0, 10))
          .put(StandardSQLTypeName.BOOL, new ColumnTypeInfo(Types.BOOLEAN, "BOOL", 1, null, null))
          .put(
              StandardSQLTypeName.FLOAT64,
              new ColumnTypeInfo(Types.DOUBLE, "FLOAT64", 15, null, 10))
          .put(StandardSQLTypeName.NUMERIC, new ColumnTypeInfo(Types.NUMERIC, "NUMERIC", 38, 9, 10))
          .put(
              StandardSQLTypeName.BIGNUMERIC,
              new ColumnTypeInfo(Types.NUMERIC, "BIGNUMERIC", 77, 38, 10))
          .put(
              StandardSQLTypeName.STRING,
              new ColumnTypeInfo(Types.NVARCHAR, "STRING", null, null, null))
          .put(
              StandardSQLTypeName.TIMESTAMP,
              new ColumnTypeInfo(Types.TIMESTAMP, "TIMESTAMP", 26, 6, null))
          .put(
              StandardSQLTypeName.DATETIME,
              new ColumnTypeInfo(Types.TIMESTAMP, "DATETIME", 26, 6, null))
          .put(StandardSQLTypeName.DATE, new ColumnTypeInfo(Types.DATE, "DATE", 10, 0, null))
          .put(StandardSQLTypeName.TIME, new ColumnTypeInfo(Types.TIME, "TIME", 15, 6, null))
          .put(
              StandardSQLTypeName.GEOGRAPHY,
              new ColumnTypeInfo(Types.OTHER, "GEOGRAPHY", null, null, null))
          .put(StandardSQLTypeName.JSON, new ColumnTypeInfo(Types.OTHER, "JSON", null, null, null))
          .put(
              StandardSQLTypeName.INTERVAL,
              new ColumnTypeInfo(Types.OTHER, "INTERVAL", null, null, null))
          .put(
              StandardSQLTypeName.RANGE, new ColumnTypeInfo(Types.OTHER, "RANGE", null, null, null))
          .put(
              StandardSQLTypeName.BYTES,
              new ColumnTypeInfo(Types.VARBINARY, "BYTES", null, null, null))
          .put(
              StandardSQLTypeName.STRUCT,
              new ColumnTypeInfo(Types.STRUCT, "STRUCT", null, null, null))
          .put(
              StandardSQLTypeName.ARRAY, new ColumnTypeInfo(Types.ARRAY, "ARRAY", null, null, null))
          .build();

  public static ColumnTypeInfo getColumnTypeInfo(StandardSQLTypeName bqType) {
    return STANDARD_TYPE_INFO.get(bqType);
  }
}

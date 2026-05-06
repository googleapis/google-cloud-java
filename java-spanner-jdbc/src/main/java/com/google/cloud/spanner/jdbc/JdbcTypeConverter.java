/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.jdbc;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.Value;
import com.google.common.base.Preconditions;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ProtocolMessageEnum;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/** Convenience class for converting values between Java, JDBC and Cloud Spanner. */
class JdbcTypeConverter {
  private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
  private static final Charset UTF8 = StandardCharsets.UTF_8;

  // TODO: Remove when this is supported in the Java client library.
  static Code getMainTypeCode(Type type) {
    Preconditions.checkNotNull(type);
    switch (type.getCode()) {
      case PG_OID:
        return Code.INT64;
      default:
        return type.getCode();
    }
  }

  /**
   * Converts the given value from the Google {@link Type} to the Java {@link Class} type. The input
   * value and the {@link Type} must be consistent with each other.
   *
   * @param value The value to convert. This value must be in the default type used for a Cloud
   *     Spanner database type. I.e. if the type argument is {@link Type#string()}, then the input
   *     value must be an instance of {@link java.lang.String}.
   * @param type The type in the database.
   * @param targetType The java class target type to convert to.
   * @return The converted value.
   * @throws SQLException if the given value cannot be converted to the specified type, or if the
   *     input value and input type are not consistent with each other.
   */
  static Object convert(Object value, Type type, Class<?> targetType) throws SQLException {
    JdbcPreconditions.checkArgument(type != null, "type may not be null");
    JdbcPreconditions.checkArgument(targetType != null, "targetType may not be null");
    checkValidTypeAndValueForConvert(type, value);

    if (value == null) {
      return null;
    }
    if (value.getClass().equals(targetType)) {
      return value;
    }
    try {
      if (targetType.equals(Value.class)) {
        return convertToSpannerValue(value, type);
      }
      if (targetType.equals(String.class)) {
        if (type.getCode() == Code.BYTES || type.getCode() == Code.PROTO)
          return new String((byte[]) value, UTF8);
        if (type.getCode() == Code.TIMESTAMP) {
          Timestamp timestamp = Timestamp.of((java.sql.Timestamp) value);
          return TIMESTAMP_FORMAT.format(
              ZonedDateTime.ofInstant(
                  Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()),
                  ZoneId.systemDefault()));
        }
        return value.toString();
      }
      if (targetType.equals(byte[].class)) {
        if (type.getCode() == Code.BYTES || type.getCode() == Code.PROTO) return value;
        if (type.getCode() == Code.STRING
            || type.getCode() == Code.JSON
            || type.getCode() == Code.PG_JSONB) return ((String) value).getBytes(UTF8);
      }
      if (targetType.equals(Boolean.class)) {
        if (type.getCode() == Code.BOOL) return value;
        if (type.getCode() == Code.INT64 || type.getCode() == Code.ENUM) return (Long) value != 0;
        if (type.getCode() == Code.FLOAT32) {
          return (Float) value != 0f;
        }
        if (type.getCode() == Code.FLOAT64) return (Double) value != 0d;
        if (type.getCode() == Code.NUMERIC) return !value.equals(BigDecimal.ZERO);
        if (type.getCode() == Code.PG_NUMERIC)
          return !AbstractJdbcWrapper.parseBigDecimal((String) value).equals(BigDecimal.ZERO);
      }
      if (targetType.equals(BigDecimal.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? BigDecimal.ONE : BigDecimal.ZERO;
        if (type.getCode() == Code.INT64 || type.getCode() == Code.ENUM)
          return BigDecimal.valueOf((Long) value);
        if (type.getCode() == Code.NUMERIC) return value;
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.parseBigDecimal((String) value);
      }
      if (targetType.equals(Long.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1L : 0L;
        if (type.getCode() == Code.INT64 || type.getCode() == Code.ENUM) return value;
        if (type.getCode() == Code.NUMERIC)
          return AbstractJdbcWrapper.checkedCastToLong(((BigDecimal) value).toBigInteger());
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.checkedCastToLong(
              AbstractJdbcWrapper.parseBigDecimal((String) value).toBigInteger());
      }
      if (targetType.equals(Integer.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1 : 0;
        if (type.getCode() == Code.INT64 || type.getCode() == Code.ENUM)
          return AbstractJdbcWrapper.checkedCastToInt((Long) value);
        if (type.getCode() == Code.NUMERIC)
          return AbstractJdbcWrapper.checkedCastToInt(((BigDecimal) value).toBigInteger());
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.checkedCastToInt(
              AbstractJdbcWrapper.parseBigDecimal((String) value).toBigInteger());
      }
      if (targetType.equals(Short.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1 : 0;
        if (type.getCode() == Code.INT64 || type.getCode() == Code.ENUM)
          return AbstractJdbcWrapper.checkedCastToShort((Long) value);
        if (type.getCode() == Code.NUMERIC)
          return AbstractJdbcWrapper.checkedCastToShort(((BigDecimal) value).toBigInteger());
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.checkedCastToShort(
              AbstractJdbcWrapper.parseBigDecimal((String) value).toBigInteger());
      }
      if (targetType.equals(Byte.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1 : 0;
        if (type.getCode() == Code.INT64 || type.getCode() == Code.ENUM)
          return AbstractJdbcWrapper.checkedCastToByte((Long) value);
        if (type.getCode() == Code.NUMERIC)
          return AbstractJdbcWrapper.checkedCastToByte(((BigDecimal) value).toBigInteger());
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.checkedCastToByte(
              AbstractJdbcWrapper.parseBigDecimal((String) value).toBigInteger());
      }
      if (targetType.equals(BigInteger.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? BigInteger.ONE : BigInteger.ZERO;
        if (type.getCode() == Code.INT64 || type.getCode() == Code.ENUM)
          return BigInteger.valueOf((Long) value);
        if (type.getCode() == Code.NUMERIC)
          return AbstractJdbcWrapper.checkedCastToBigInteger((BigDecimal) value);
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.checkedCastToBigInteger(
              AbstractJdbcWrapper.parseBigDecimal((String) value));
      }
      if (targetType.equals(Float.class)) {
        if (type.getCode() == Code.BOOL)
          return (Boolean) value ? Float.valueOf(1f) : Float.valueOf(0f);
        if (type.getCode() == Code.FLOAT32) {
          return value;
        }
        if (type.getCode() == Code.FLOAT64)
          return AbstractJdbcWrapper.checkedCastToFloat((Double) value);
        if (type.getCode() == Code.NUMERIC) return ((BigDecimal) value).floatValue();
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.parseFloat((String) value);
      }
      if (targetType.equals(Double.class)) {
        if (type.getCode() == Code.BOOL)
          return (Boolean) value ? Double.valueOf(1d) : Double.valueOf(0d);
        if (type.getCode() == Code.FLOAT64 || type.getCode() == Code.FLOAT32) {
          return value;
        }
        if (type.getCode() == Code.NUMERIC) return ((BigDecimal) value).doubleValue();
        if (type.getCode() == Code.PG_NUMERIC)
          return AbstractJdbcWrapper.parseDouble((String) value);
      }
      if (targetType.equals(java.sql.Date.class)) {
        if (type.getCode() == Code.DATE) return value;
      }
      if (targetType.equals(LocalDate.class)) {
        if (type.getCode() == Code.DATE) {
          return ((java.sql.Date) value).toLocalDate();
        }
      }
      if (targetType.equals(java.sql.Timestamp.class)) {
        if (type.getCode() == Code.TIMESTAMP) return value;
      }
      if (targetType.equals(OffsetDateTime.class)) {
        if (type.getCode() == Code.TIMESTAMP) {
          Timestamp timestamp = Timestamp.of((java.sql.Timestamp) value);
          return OffsetDateTime.ofInstant(
              Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()),
              ZoneId.systemDefault());
        }
      }
      if (AbstractMessage.class.isAssignableFrom(targetType)) {
        if (type.getCode() == Code.PROTO || type.getCode() == Code.BYTES) {
          Method parseMethodParseFrom = targetType.getMethod("parseFrom", byte[].class);
          return targetType.cast(parseMethodParseFrom.invoke(null, value));
        }
      }
      if (ProtocolMessageEnum.class.isAssignableFrom(targetType)) {
        if (type.getCode() == Code.ENUM || type.getCode() == Code.INT64) {
          Method parseMethodForNumber = targetType.getMethod("forNumber", int.class);
          return targetType.cast(
              parseMethodForNumber.invoke(
                  null, AbstractJdbcWrapper.checkedCastToInt((Long) value)));
        }
      }
      if (targetType.equals(java.sql.Array.class)) {
        if (type.getCode() == Code.ARRAY) return value;
      }
      if (targetType.isArray() && type.getCode() == Code.ARRAY) {
        if (type.getArrayElementType().getCode() == Code.PROTO
            || type.getArrayElementType().getCode() == Code.BYTES) {
          Object res = convertArrayOfProtoMessage(value, targetType);
          if (res != null) {
            return res;
          }
        }
        if (type.getArrayElementType().getCode() == Code.ENUM
            || type.getArrayElementType().getCode() == Code.INT64) {
          Object res = convertArrayOfProtoEnum(value, targetType);
          if (res != null) {
            return res;
          }
        }
      }
    } catch (SQLException e) {
      throw e;
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of(
          "Cannot convert " + value + " to " + targetType.getName(),
          com.google.rpc.Code.INVALID_ARGUMENT,
          e);
    }
    throw JdbcSqlExceptionFactory.of(
        "Cannot convert " + type.getCode().name() + " to " + targetType.getName(),
        com.google.rpc.Code.INVALID_ARGUMENT);
  }

  /**
   * Converts the given value to the Java {@link Class} type. The targetType {@link Class} must be
   * an array of {@link AbstractMessage}.
   */
  static Object convertArrayOfProtoMessage(Object value, Class<?> targetType) throws Exception {
    Class<?> componentType = targetType.getComponentType();
    if (AbstractMessage.class.isAssignableFrom(componentType)) {
      byte[][] result = (byte[][]) ((JdbcArray) value).getArray();
      Object obj = java.lang.reflect.Array.newInstance(componentType, result.length);
      Method parseMethodParseFrom = componentType.getMethod("parseFrom", byte[].class);
      for (int i = 0; i < result.length; i++) {
        if (result[i] != null) {
          java.lang.reflect.Array.set(
              obj, i, componentType.cast(parseMethodParseFrom.invoke(null, result[i])));
        }
      }
      return obj;
    }
    return null;
  }

  /**
   * Converts the given value to the Java {@link Class} type. The targetType {@link Class} must be
   * an array of {@link ProtocolMessageEnum}.
   */
  static Object convertArrayOfProtoEnum(Object value, Class<?> targetType) throws Exception {
    Class<?> componentType = targetType.getComponentType();
    if (ProtocolMessageEnum.class.isAssignableFrom(componentType)) {
      Long[] result = (Long[]) ((JdbcArray) value).getArray();
      Object obj = java.lang.reflect.Array.newInstance(componentType, result.length);
      Method parseMethodForNumber = componentType.getMethod("forNumber", int.class);
      for (int i = 0; i < result.length; i++) {
        if (result[i] != null) {
          java.lang.reflect.Array.set(
              obj,
              i,
              componentType.cast(
                  parseMethodForNumber.invoke(
                      null, AbstractJdbcWrapper.checkedCastToInt(result[i]))));
        }
      }
      return obj;
    }
    return null;
  }

  private static Value convertToSpannerValue(Object value, Type type) throws SQLException {
    switch (type.getCode()) {
      case ARRAY:
        switch (type.getArrayElementType().getCode()) {
          case BOOL:
            return Value.boolArray(Arrays.asList((Boolean[]) ((java.sql.Array) value).getArray()));
          case BYTES:
            return Value.bytesArray(toGoogleBytes((byte[][]) ((java.sql.Array) value).getArray()));
          case PROTO:
            return Value.protoMessageArray(
                toGoogleBytes((byte[][]) ((java.sql.Array) value).getArray()),
                type.getArrayElementType().getProtoTypeFqn());
          case DATE:
            return Value.dateArray(
                toGoogleDates((java.sql.Date[]) ((java.sql.Array) value).getArray()));
          case FLOAT32:
            return Value.float32Array(Arrays.asList((Float[]) ((java.sql.Array) value).getArray()));
          case FLOAT64:
            return Value.float64Array(
                Arrays.asList((Double[]) ((java.sql.Array) value).getArray()));
          case INT64:
            return Value.int64Array(Arrays.asList((Long[]) ((java.sql.Array) value).getArray()));
          case ENUM:
            return Value.protoEnumArray(
                Arrays.asList((Long[]) ((java.sql.Array) value).getArray()),
                type.getArrayElementType().getProtoTypeFqn());
          case PG_OID:
            return Value.pgOidArray(Arrays.asList((Long[]) ((java.sql.Array) value).getArray()));
          case NUMERIC:
            return Value.numericArray(
                Arrays.asList((BigDecimal[]) ((java.sql.Array) value).getArray()));
          case PG_NUMERIC:
            return Value.pgNumericArray(
                Arrays.asList((String[]) ((java.sql.Array) value).getArray()));
          case STRING:
            return Value.stringArray(Arrays.asList((String[]) ((java.sql.Array) value).getArray()));
          case TIMESTAMP:
            return Value.timestampArray(
                toGoogleTimestamps((java.sql.Timestamp[]) ((java.sql.Array) value).getArray()));
          case JSON:
            return Value.jsonArray(Arrays.asList((String[]) ((java.sql.Array) value).getArray()));
          case PG_JSONB:
            return Value.pgJsonbArray(
                Arrays.asList((String[]) ((java.sql.Array) value).getArray()));
          case STRUCT:
          default:
            throw JdbcSqlExceptionFactory.of(
                "invalid argument: " + value, com.google.rpc.Code.INVALID_ARGUMENT);
        }
      case BOOL:
        return Value.bool((Boolean) value);
      case BYTES:
        return Value.bytes(ByteArray.copyFrom((byte[]) value));
      case DATE:
        return Value.date(toGoogleDate((java.sql.Date) value));
      case FLOAT32:
        return Value.float32((Float) value);
      case FLOAT64:
        return Value.float64((Double) value);
      case INT64:
        return Value.int64((Long) value);
      case PG_OID:
        return Value.pgOid((Long) value);
      case NUMERIC:
        return Value.numeric((BigDecimal) value);
      case PG_NUMERIC:
        return Value.pgNumeric(value == null ? null : value.toString());
      case STRING:
        return Value.string((String) value);
      case TIMESTAMP:
        return Value.timestamp(toGoogleTimestamp((java.sql.Timestamp) value));
      case JSON:
        return Value.json((String) value);
      case PG_JSONB:
        return Value.pgJsonb((String) value);
      case PROTO:
        return Value.protoMessage(ByteArray.copyFrom((byte[]) value), type.getProtoTypeFqn());
      case ENUM:
        return Value.protoEnum((Long) value, type.getProtoTypeFqn());
      case STRUCT:
      default:
        throw JdbcSqlExceptionFactory.of(
            "invalid argument: " + value, com.google.rpc.Code.INVALID_ARGUMENT);
    }
  }

  private static void checkValidTypeAndValueForConvert(Type type, Object value)
      throws SQLException {
    if (value == null) {
      return;
    }
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.ARRAY || Array.class.isAssignableFrom(value.getClass()),
        "input type is array, but input value is not an instance of java.sql.Array");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.BOOL || value.getClass().equals(Boolean.class),
        "input type is bool, but input value is not an instance of Boolean");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.BYTES || value.getClass().equals(byte[].class),
        "input type is bytes, but input value is not an instance of byte[]");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.DATE || value.getClass().equals(java.sql.Date.class),
        "input type is date, but input value is not an instance of java.sql.Date");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.FLOAT32 || value.getClass().equals(Float.class),
        "input type is float32, but input value is not an instance of Float");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.FLOAT64 || value.getClass().equals(Double.class),
        "input type is float64, but input value is not an instance of Double");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.INT64 || value.getClass().equals(Long.class),
        "input type is int64, but input value is not an instance of Long");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.STRING || value.getClass().equals(String.class),
        "input type is string, but input value is not an instance of String");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.TIMESTAMP || value.getClass().equals(java.sql.Timestamp.class),
        "input type is timestamp, but input value is not an instance of java.sql.Timestamp");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.NUMERIC || value.getClass().equals(BigDecimal.class),
        "input type is numeric, but input value is not an instance of BigDecimal");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.PROTO || value.getClass().equals(byte[].class),
        "input type is proto, but input value is not an instance of byte[]");
    JdbcPreconditions.checkArgument(
        type.getCode() != Code.ENUM || value.getClass().equals(Long.class),
        "input type is enum, but input value is not an instance of Long");
  }

  @SuppressWarnings("deprecation")
  static Date toGoogleDate(java.sql.Date date) {
    return date == null
        ? null
        : Date.fromYearMonthDay(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
  }

  static Date toGoogleDate(java.sql.Time date) {
    return Date.fromYearMonthDay(1970, 1, 1);
  }

  @SuppressWarnings("deprecation")
  static Date toGoogleDate(java.sql.Timestamp date) {
    return date == null
        ? null
        : Date.fromYearMonthDay(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
  }

  static List<Date> toGoogleDates(java.sql.Date[] dates) {
    List<com.google.cloud.Date> res = new ArrayList<>(dates.length);
    for (java.sql.Date date : dates) {
      res.add(toGoogleDate(date));
    }
    return res;
  }

  static java.sql.Date toSqlDate(Date date) {
    return toSqlDate(date, Calendar.getInstance());
  }

  static java.sql.Date toSqlDate(Date date, Calendar cal) {
    if (date != null) {
      //noinspection MagicConstant
      cal.set(date.getYear(), date.getMonth() - 1, date.getDayOfMonth(), 0, 0, 0);
      cal.clear(Calendar.MILLISECOND);
      return new java.sql.Date(cal.getTimeInMillis());
    }
    return null;
  }

  static List<java.sql.Date> toSqlDates(List<Date> dates) {
    List<java.sql.Date> res = new ArrayList<>(dates.size());
    for (Date date : dates) res.add(toSqlDate(date));
    return res;
  }

  static java.sql.Timestamp toSqlTimestamp(Timestamp ts) {
    return ts == null ? null : ts.toSqlTimestamp();
  }

  static java.sql.Timestamp toSqlTimestamp(Date date) {
    return date == null ? null : new java.sql.Timestamp(toSqlDate(date).getTime());
  }

  static java.sql.Timestamp toSqlTimestamp(Date date, Calendar cal) {
    return date == null ? null : new java.sql.Timestamp(toSqlDate(date, cal).getTime());
  }

  static java.sql.Timestamp getAsSqlTimestamp(Timestamp ts, Calendar cal) {
    return ts == null ? null : getTimestampInCalendar(ts.toSqlTimestamp(), cal);
  }

  static java.sql.Timestamp getTimestampInCalendar(java.sql.Timestamp sqlTs, Calendar cal) {
    return getOrSetTimestampInCalendar(sqlTs, cal, GetOrSetTimestampInCalendar.GET);
  }

  static java.sql.Timestamp setTimestampInCalendar(java.sql.Timestamp sqlTs, Calendar cal) {
    return getOrSetTimestampInCalendar(sqlTs, cal, GetOrSetTimestampInCalendar.SET);
  }

  private enum GetOrSetTimestampInCalendar {
    GET,
    SET
  }

  private static java.sql.Timestamp getOrSetTimestampInCalendar(
      java.sql.Timestamp sqlTs, Calendar cal, GetOrSetTimestampInCalendar getOrSet) {
    if (sqlTs != null) {
      // Get a calendar in the requested timezone
      Calendar newCal = Calendar.getInstance(cal.getTimeZone());
      // set the millisecond time on this calendar from the timestamp
      newCal.setTimeInMillis(sqlTs.getTime());

      TimeZone timeZone = newCal.getTimeZone();
      long totalMillis = newCal.getTimeInMillis();
      // to calculate the offset for DST correctly, we need to add DST savings and check if
      // given epoch milli is in daylight savings time.
      if (getOrSet == GetOrSetTimestampInCalendar.GET) {
        totalMillis += timeZone.getRawOffset() + timeZone.getDSTSavings();
      }

      // then shift the time of the calendar by the difference between UTC and the timezone of the
      // given calendar
      int offset = newCal.getTimeZone().getOffset(totalMillis);
      newCal.add(
          Calendar.MILLISECOND, getOrSet == GetOrSetTimestampInCalendar.GET ? offset : -offset);
      // then use that to create a sql timestamp
      java.sql.Timestamp res = new java.sql.Timestamp(newCal.getTimeInMillis());
      // set the nanosecond value that will also set the millisecond value of the timestamp
      // as the nanosecond value contains all fraction of a second information
      res.setNanos(sqlTs.getNanos());
      return res;
    }
    return null;
  }

  static List<java.sql.Timestamp> toSqlTimestamps(List<Timestamp> timestamps) {
    List<java.sql.Timestamp> res = new ArrayList<>(timestamps.size());
    for (Timestamp timestamp : timestamps) {
      res.add(toSqlTimestamp(timestamp));
    }
    return res;
  }

  static Timestamp toGoogleTimestamp(java.util.Date ts) {
    if (ts != null) {
      long milliseconds = ts.getTime();
      long seconds = milliseconds / 1000L;
      long nanos = (milliseconds - (seconds * 1000)) * 1000000;
      return com.google.cloud.Timestamp.ofTimeSecondsAndNanos(seconds, (int) nanos);
    }
    return null;
  }

  static Timestamp toGoogleTimestamp(java.sql.Timestamp ts) {
    if (ts != null) {
      long milliseconds = ts.getTime();
      long seconds = milliseconds / 1000L;
      int nanos = ts.getNanos();
      return com.google.cloud.Timestamp.ofTimeSecondsAndNanos(seconds, nanos);
    }
    return null;
  }

  static List<Timestamp> toGoogleTimestamps(java.sql.Timestamp[] timestamps) {
    List<com.google.cloud.Timestamp> res = new ArrayList<>(timestamps.length);
    for (java.sql.Timestamp timestamp : timestamps) {
      res.add(toGoogleTimestamp(timestamp));
    }
    return res;
  }

  @SuppressWarnings("deprecation")
  static Time toSqlTime(Timestamp ts) {
    if (ts != null) {
      java.sql.Timestamp sqlTs = toSqlTimestamp(ts);
      Time time = new Time(sqlTs.getHours(), sqlTs.getMinutes(), sqlTs.getSeconds());
      time.setTime(
          time.getTime() + TimeUnit.MILLISECONDS.convert(sqlTs.getNanos(), TimeUnit.NANOSECONDS));
      return time;
    }
    return null;
  }

  @SuppressWarnings("deprecation")
  static Time toSqlTime(Timestamp ts, Calendar cal) {
    if (ts != null) {
      java.sql.Timestamp sqlTs = getAsSqlTimestamp(ts, cal);
      Time time = new Time(sqlTs.getHours(), sqlTs.getMinutes(), sqlTs.getSeconds());
      time.setTime(
          time.getTime() + TimeUnit.MILLISECONDS.convert(sqlTs.getNanos(), TimeUnit.NANOSECONDS));
      return time;
    }
    return null;
  }

  @SuppressWarnings("deprecation")
  static java.sql.Time parseSqlTime(String val, Calendar cal) {
    if (val != null) {
      Time time = Time.valueOf(val);
      cal.set(1970, Calendar.JANUARY, 1, time.getHours(), time.getMinutes(), time.getSeconds());
      cal.clear(Calendar.MILLISECOND);
      return new java.sql.Time(cal.getTimeInMillis());
    }
    return null;
  }

  static List<ByteArray> toGoogleBytes(byte[][] bytes) {
    List<ByteArray> res = new ArrayList<>(bytes.length);
    for (byte[] aByte : bytes) {
      res.add(aByte == null ? null : ByteArray.copyFrom(aByte));
    }
    return res;
  }

  static List<byte[]> toJavaByteArrays(List<ByteArray> bytes) {
    List<byte[]> res = new ArrayList<>(bytes.size());
    for (ByteArray ba : bytes) {
      res.add(ba == null ? null : ba.toByteArray());
    }
    return res;
  }
}

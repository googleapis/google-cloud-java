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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.Array;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

/** Convenience class for converting values between Java, JDBC and Cloud Spanner. */
class JdbcTypeConverter {
  private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
  private static final Charset UTF8 = Charset.forName("UTF8");

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

    if (value == null) return null;
    try {
      if (targetType.equals(String.class)) {
        if (type.getCode() == Code.BYTES) return new String((byte[]) value, UTF8);
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
        if (type.getCode() == Code.BYTES) return value;
        if (type.getCode() == Code.STRING) return ((String) value).getBytes(UTF8);
      }
      if (targetType.equals(Boolean.class)) {
        if (type.getCode() == Code.BOOL) return value;
        if (type.getCode() == Code.INT64) return Boolean.valueOf((Long) value != 0);
        if (type.getCode() == Code.FLOAT64) return Boolean.valueOf((Double) value != 0d);
      }
      if (targetType.equals(BigDecimal.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? BigDecimal.ONE : BigDecimal.ZERO;
        if (type.getCode() == Code.INT64) return BigDecimal.valueOf((Long) value);
      }
      if (targetType.equals(Long.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1L : 0L;
        if (type.getCode() == Code.INT64) return value;
      }
      if (targetType.equals(Integer.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1 : 0;
        if (type.getCode() == Code.INT64) return AbstractJdbcWrapper.checkedCastToInt((Long) value);
      }
      if (targetType.equals(Short.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1 : 0;
        if (type.getCode() == Code.INT64)
          return AbstractJdbcWrapper.checkedCastToShort((Long) value);
      }
      if (targetType.equals(Byte.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1 : 0;
        if (type.getCode() == Code.INT64)
          return AbstractJdbcWrapper.checkedCastToByte((Long) value);
      }
      if (targetType.equals(BigInteger.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? BigInteger.ONE : BigInteger.ZERO;
        if (type.getCode() == Code.INT64) return BigInteger.valueOf((Long) value);
      }
      if (targetType.equals(Float.class)) {
        if (type.getCode() == Code.BOOL)
          return (Boolean) value ? Float.valueOf(1f) : Float.valueOf(0f);
        if (type.getCode() == Code.FLOAT64)
          return AbstractJdbcWrapper.checkedCastToFloat((Double) value);
      }
      if (targetType.equals(Double.class)) {
        if (type.getCode() == Code.BOOL)
          return (Boolean) value ? Double.valueOf(1d) : Double.valueOf(0d);
        if (type.getCode() == Code.FLOAT64) return value;
      }
      if (targetType.equals(java.sql.Date.class)) {
        if (type.getCode() == Code.DATE) return value;
      }
      if (targetType.equals(java.sql.Timestamp.class)) {
        if (type.getCode() == Code.TIMESTAMP) return value;
      }
      if (targetType.equals(java.sql.Array.class)) {
        if (type.getCode() == Code.ARRAY) return value;
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

  private static void checkValidTypeAndValueForConvert(Type type, Object value)
      throws SQLException {
    if (value == null) return;
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.ARRAY && Array.class.isAssignableFrom(value.getClass()))
            || type.getCode() != Code.ARRAY,
        "input type is array, but input value is not an instance of java.sql.Array");
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.BOOL && value.getClass().equals(Boolean.class))
            || type.getCode() != Code.BOOL,
        "input type is bool, but input value is not an instance of Boolean");
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.BYTES && value.getClass().equals(byte[].class))
            || type.getCode() != Code.BYTES,
        "input type is bytes, but input value is not an instance of byte[]");
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.DATE && value.getClass().equals(java.sql.Date.class))
            || type.getCode() != Code.DATE,
        "input type is date, but input value is not an instance of java.sql.Date");
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.FLOAT64 && value.getClass().equals(Double.class))
            || type.getCode() != Code.FLOAT64,
        "input type is float64, but input value is not an instance of Double");
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.INT64 && value.getClass().equals(Long.class))
            || type.getCode() != Code.INT64,
        "input type is int64, but input value is not an instance of Long");
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.STRING && value.getClass().equals(String.class))
            || type.getCode() != Code.STRING,
        "input type is string, but input value is not an instance of String");
    JdbcPreconditions.checkArgument(
        (type.getCode() == Code.TIMESTAMP && value.getClass().equals(java.sql.Timestamp.class))
            || type.getCode() != Code.TIMESTAMP,
        "input type is timestamp, but input value is not an instance of java.sql.Timestamp");
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
    for (int index = 0; index < dates.length; index++) res.add(toGoogleDate(dates[index]));
    return res;
  }

  static java.sql.Date toSqlDate(Date date) {
    return toSqlDate(date, Calendar.getInstance());
  }

  static java.sql.Date toSqlDate(Date date, Calendar cal) {
    if (date != null) {
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
    SET;
  }

  private static java.sql.Timestamp getOrSetTimestampInCalendar(
      java.sql.Timestamp sqlTs, Calendar cal, GetOrSetTimestampInCalendar getOrSet) {
    if (sqlTs != null) {
      // Get a calendar in the requested timezone
      Calendar newCal = Calendar.getInstance(cal.getTimeZone());
      // set the millisecond time on this calendar from the timestamp
      newCal.setTimeInMillis(sqlTs.getTime());
      newCal.set(Calendar.MILLISECOND, 0);
      // then shift the time of the calendar by the difference between UTC and the timezone of the
      // given calendar
      int offset = newCal.getTimeZone().getOffset(newCal.getTimeInMillis());
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

  static Timestamp toGoogleTimestamp(java.sql.Date ts) {
    if (ts != null) {
      long milliseconds = ts.getTime();
      long seconds = milliseconds / 1000l;
      long nanos = (milliseconds - (seconds * 1000)) * 1000000;
      return com.google.cloud.Timestamp.ofTimeSecondsAndNanos(seconds, (int) nanos);
    }
    return null;
  }

  static Timestamp toGoogleTimestamp(java.sql.Time ts) {
    if (ts != null) {
      long milliseconds = ts.getTime();
      long seconds = milliseconds / 1000l;
      long nanos = (milliseconds - (seconds * 1000)) * 1000000;
      return com.google.cloud.Timestamp.ofTimeSecondsAndNanos(seconds, (int) nanos);
    }
    return null;
  }

  static Timestamp toGoogleTimestamp(java.sql.Timestamp ts) {
    if (ts != null) {
      long milliseconds = ts.getTime();
      long seconds = milliseconds / 1000l;
      int nanos = ts.getNanos();
      return com.google.cloud.Timestamp.ofTimeSecondsAndNanos(seconds, nanos);
    }
    return null;
  }

  static List<Timestamp> toGoogleTimestamps(java.sql.Timestamp[] timestamps) {
    List<com.google.cloud.Timestamp> res = new ArrayList<>(timestamps.length);
    for (int index = 0; index < timestamps.length; index++) {
      res.add(toGoogleTimestamp(timestamps[index]));
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

  static List<ByteArray> toGoogleBytes(byte[][] bytes) {
    List<ByteArray> res = new ArrayList<>(bytes.length);
    for (int index = 0; index < bytes.length; index++) {
      res.add(bytes[index] == null ? null : ByteArray.copyFrom(bytes[index]));
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

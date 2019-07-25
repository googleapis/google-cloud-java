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
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** Convenience class for converting values between Java, JDBC and Cloud Spanner. */
class JdbcTypeConverter {

  /**
   * Converts the given value from the Google {@link Type} to the Java {@link Class} type.
   *
   * @param value The value to convert
   * @param type The type in the database
   * @param targetType The java class target type to convert to
   * @return The converted value
   * @throws CloudSpannerSQLException Thrown if the given value cannot be converted to the specified
   *     type
   */
  static Object convert(Object value, Type type, Class<?> targetType) throws SQLException {
    Preconditions.checkNotNull(type, "type may not be null");
    Preconditions.checkNotNull(targetType, "targetType may not be null");
    if (value == null) return null;
    if (targetType.equals(String.class)) return value.toString();

    try {
      if (targetType.equals(Boolean.class)) {
        if (type.getCode() == Code.BOOL) return value;
        if (type.getCode() == Code.INT64) return Boolean.valueOf((Long) value != 0);
        if (type.getCode() == Code.FLOAT64) return Boolean.valueOf((Double) value != 0d);
        if (type.getCode() == Code.STRING) return Boolean.valueOf((String) value);
      }
      if (targetType.equals(BigDecimal.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? BigDecimal.ONE : BigDecimal.ZERO;
        if (type.getCode() == Code.INT64) return BigDecimal.valueOf((Long) value);
        if (type.getCode() == Code.FLOAT64) return BigDecimal.valueOf((Double) value);
        if (type.getCode() == Code.STRING) return new BigDecimal((String) value);
      }
      if (targetType.equals(Long.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1L : 0L;
        if (type.getCode() == Code.INT64) return value;
        if (type.getCode() == Code.FLOAT64) return ((Double) value).longValue();
        if (type.getCode() == Code.STRING) return Long.valueOf((String) value);
      }
      if (targetType.equals(Integer.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? 1 : 0;
        if (type.getCode() == Code.INT64) return ((Long) value).intValue();
        if (type.getCode() == Code.FLOAT64) return ((Double) value).intValue();
        if (type.getCode() == Code.STRING) return Integer.valueOf((String) value);
      }
      if (targetType.equals(BigInteger.class)) {
        if (type.getCode() == Code.BOOL) return (Boolean) value ? BigInteger.ONE : BigInteger.ZERO;
        if (type.getCode() == Code.INT64) return BigInteger.valueOf((Long) value);
        if (type.getCode() == Code.FLOAT64) return BigInteger.valueOf(((Double) value).longValue());
        if (type.getCode() == Code.STRING) return new BigInteger((String) value);
      }
      if (targetType.equals(Float.class)) {
        if (type.getCode() == Code.BOOL)
          return (Boolean) value ? Float.valueOf(1f) : Float.valueOf(0f);
        if (type.getCode() == Code.INT64) return ((Long) value).floatValue();
        if (type.getCode() == Code.FLOAT64) return ((Double) value).floatValue();
        if (type.getCode() == Code.STRING) return Float.valueOf((String) value);
      }
      if (targetType.equals(Double.class)) {
        if (type.getCode() == Code.BOOL)
          return (Boolean) value ? Double.valueOf(1d) : Double.valueOf(0d);
        if (type.getCode() == Code.INT64) return ((Long) value).doubleValue();
        if (type.getCode() == Code.FLOAT64) return value;
        if (type.getCode() == Code.STRING) return Double.valueOf((String) value);
      }
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

  static Time toSqlTime(Timestamp ts) {
    return toSqlTime(ts, Calendar.getInstance());
  }

  static Time toSqlTime(Timestamp ts, Calendar cal) {
    if (ts != null) {
      cal.set(1970, 0, 1, 0, 0, 0);
      cal.clear(Calendar.MILLISECOND);
      cal.setTimeInMillis(
          ts.getSeconds() * 1000
              + TimeUnit.MILLISECONDS.convert(ts.getNanos(), TimeUnit.NANOSECONDS));
      return new Time(cal.getTimeInMillis());
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

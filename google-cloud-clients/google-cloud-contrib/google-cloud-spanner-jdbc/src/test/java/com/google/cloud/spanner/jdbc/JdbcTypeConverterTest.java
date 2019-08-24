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

import static com.google.cloud.spanner.jdbc.JdbcTypeConverter.*;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.rpc.Code;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcTypeConverterTest {
  private static final Charset UTF8 = Charset.forName("UTF8");

  @Test
  public void testConvertArray() throws SQLException {
    Array testValue = JdbcArray.createArray("INT64", new Long[] {1L, 2L, 3L});
    for (Type t :
        new Type[] {
          Type.bool(),
          Type.bytes(),
          Type.date(),
          Type.float64(),
          Type.int64(),
          Type.string(),
          Type.timestamp()
        }) {
      assertConvertThrows(testValue, Type.array(t), Boolean.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), Byte.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), Short.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), Integer.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), Long.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), Float.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), Double.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), BigInteger.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(testValue, Type.array(t), BigDecimal.class, Code.INVALID_ARGUMENT);

      assertThat(convert(testValue, Type.array(t), Array.class)).isEqualTo(testValue);
      assertThat(convert(testValue, Type.array(t), String.class)).isEqualTo("{1,2,3}");
    }
  }

  @Test
  public void testConvertBool() throws SQLException {
    Boolean[] testValues = new Boolean[] {Boolean.TRUE, Boolean.FALSE};
    for (Boolean b : testValues) {
      assertThat(convert(b, Type.bool(), Boolean.class)).isEqualTo(b);
      assertThat(convert(b, Type.bool(), Byte.class))
          .isEqualTo(Byte.valueOf(b ? (byte) 1 : (byte) 0));
      assertThat(convert(b, Type.bool(), Short.class))
          .isEqualTo(Short.valueOf(b ? (short) 1 : (short) 0));
      assertThat(convert(b, Type.bool(), Integer.class)).isEqualTo(Integer.valueOf(b ? 1 : 0));
      assertThat(convert(b, Type.bool(), Long.class)).isEqualTo(Long.valueOf(b ? 1L : 0L));
      assertThat(convert(b, Type.bool(), Float.class)).isEqualTo(Float.valueOf(b ? 1F : 0F));
      assertThat(convert(b, Type.bool(), Double.class)).isEqualTo(Double.valueOf(b ? 1D : 0D));
      assertThat(convert(b, Type.bool(), BigInteger.class))
          .isEqualTo(b ? BigInteger.ONE : BigInteger.ZERO);
      assertThat(convert(b, Type.bool(), BigDecimal.class))
          .isEqualTo(b ? BigDecimal.ONE : BigDecimal.ZERO);
      assertThat(convert(b, Type.bool(), String.class)).isEqualTo(String.valueOf(b));
    }
  }

  @Test
  public void testConvertBytes() throws SQLException {
    byte[] testValues = "test".getBytes(UTF8);
    assertConvertThrows(testValues, Type.bytes(), Boolean.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), Byte.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), Short.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), Integer.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), Long.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), Float.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), Double.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), BigInteger.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValues, Type.bytes(), BigDecimal.class, Code.INVALID_ARGUMENT);

    assertThat(convert(testValues, Type.bytes(), byte[].class)).isEqualTo(testValues);
    assertThat(convert(testValues, Type.bytes(), String.class)).isEqualTo("test");
  }

  private TimeZone[] getTestTimeZones() {
    return new TimeZone[] {
      TimeZone.getTimeZone("GMT-12:00"),
      TimeZone.getTimeZone("GMT-9:00"),
      TimeZone.getTimeZone("GMT-1:00"),
      TimeZone.getTimeZone("GMT"),
      TimeZone.getTimeZone("GMT+1:00"),
      TimeZone.getTimeZone("GMT+12:00")
    };
  }

  @Test
  public void testConvertDate() throws SQLException {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        TimeZone.setDefault(zone);
        @SuppressWarnings("deprecation")
        Date testValue = new Date(2019 - 1900, 7, 24);
        assertConvertThrows(testValue, Type.date(), Boolean.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), Byte.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), Short.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), Integer.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), Long.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), Float.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), Double.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), BigInteger.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.date(), BigDecimal.class, Code.INVALID_ARGUMENT);

        assertThat(convert(testValue, Type.date(), Date.class)).isEqualTo(testValue);
        assertThat(convert(testValue, Type.date(), String.class)).isEqualTo("2019-08-24");
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @Test
  public void testConvertTimestamp() throws SQLException {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        TimeZone.setDefault(zone);
        @SuppressWarnings("deprecation")
        Timestamp testValue = new Timestamp(2019 - 1900, 7, 24, 7, 20, 19, 123456789);
        assertConvertThrows(testValue, Type.timestamp(), Boolean.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), Byte.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), Short.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), Integer.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), Long.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), Float.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), Double.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), BigInteger.class, Code.INVALID_ARGUMENT);
        assertConvertThrows(testValue, Type.timestamp(), BigDecimal.class, Code.INVALID_ARGUMENT);

        assertThat(convert(testValue, Type.timestamp(), Timestamp.class)).isEqualTo(testValue);
        int offset = zone.getOffset(testValue.getTime());
        int offsetHours = offset / (60_000 * 60);
        DecimalFormat fmt = new DecimalFormat("+##00;-#");
        String offsetString = offset == 0 ? "Z" : fmt.format(offsetHours) + ":00";
        assertThat(convert(testValue, Type.timestamp(), String.class))
            .isEqualTo("2019-08-24T07:20:19.123456789" + offsetString);
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @Test
  public void testConvertString() throws SQLException {
    String testValue = "test";
    assertConvertThrows(testValue, Type.string(), Boolean.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), Byte.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), Short.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), Integer.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), Long.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), Float.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), Double.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), BigInteger.class, Code.INVALID_ARGUMENT);
    assertConvertThrows(testValue, Type.string(), BigDecimal.class, Code.INVALID_ARGUMENT);

    assertThat(convert(testValue, Type.string(), String.class)).isEqualTo(testValue);
    assertThat(convert(testValue, Type.string(), byte[].class)).isEqualTo(testValue.getBytes(UTF8));
  }

  @Test
  public void testConvertInt64() throws SQLException {
    Long[] testValues =
        new Long[] {
          0L,
          -1L,
          1L,
          Long.MIN_VALUE,
          Long.MAX_VALUE,
          Long.valueOf(Integer.MIN_VALUE),
          Long.valueOf(Integer.MAX_VALUE),
          Long.valueOf(Integer.MIN_VALUE - 1),
          Long.valueOf(Integer.MAX_VALUE + 1),
          Long.valueOf(Short.MIN_VALUE),
          Long.valueOf(Short.MAX_VALUE),
          Long.valueOf(Short.MIN_VALUE - 1),
          Long.valueOf(Short.MAX_VALUE + 1),
          Long.valueOf(Byte.MIN_VALUE),
          Long.valueOf(Byte.MAX_VALUE),
          Long.valueOf(Byte.MIN_VALUE - 1),
          Long.valueOf(Byte.MAX_VALUE + 1)
        };
    testConvertInt64ToNumber(testValues, Long.class, Long.MIN_VALUE, Long.MAX_VALUE);
    testConvertInt64ToNumber(testValues, Integer.class, Integer.MIN_VALUE, Integer.MAX_VALUE);
    testConvertInt64ToNumber(testValues, Short.class, Short.MIN_VALUE, Short.MAX_VALUE);
    testConvertInt64ToNumber(testValues, Byte.class, Byte.MIN_VALUE, Byte.MAX_VALUE);
    testConvertInt64ToNumber(testValues, BigInteger.class, Long.MIN_VALUE, Long.MAX_VALUE);
    testConvertInt64ToNumber(testValues, BigDecimal.class, Long.MIN_VALUE, Long.MAX_VALUE);

    for (Long l : testValues) {
      assertThat(convert(l, Type.int64(), String.class)).isEqualTo(String.valueOf(l));
      assertThat(convert(l, Type.int64(), Boolean.class)).isEqualTo(Boolean.valueOf(l != 0L));
      assertConvertThrows(l, Type.int64(), Double.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(l, Type.int64(), Float.class, Code.INVALID_ARGUMENT);
    }
  }

  private void testConvertInt64ToNumber(
      Long[] testValues, Class<? extends Number> targetType, Number minValue, Number maxValue)
      throws SQLException {
    for (Long t : testValues) {
      if (t < minValue.longValue() || t > maxValue.longValue()) {
        assertConvertThrows(t, Type.int64(), targetType, Code.OUT_OF_RANGE);
      } else {
        assertThat(((Number) convert(t, Type.int64(), targetType)).longValue()).isEqualTo(t);
        assertThat(convert(t, Type.int64(), targetType)).isInstanceOf(targetType);
      }
    }
  }

  @Test
  public void testConvertFloat64() throws SQLException {
    Double[] testValues =
        new Double[] {
          0D,
          -1D,
          1D,
          Double.MIN_VALUE,
          Double.MAX_VALUE,
          Double.valueOf(Float.MIN_VALUE),
          Double.valueOf(Float.MAX_VALUE),
          Double.valueOf(Float.MAX_VALUE + 1D)
        };
    for (Double d : testValues) {
      assertThat(convert(d, Type.float64(), Double.class)).isEqualTo(d);
      if (d > Float.MAX_VALUE || d < -Float.MAX_VALUE) {
        assertConvertThrows(d, Type.float64(), Float.class, Code.OUT_OF_RANGE);
      } else {
        assertThat(convert(d, Type.float64(), Float.class)).isEqualTo(d.floatValue());
      }
      assertThat(convert(d, Type.float64(), String.class)).isEqualTo(String.valueOf(d));
      assertThat(convert(d, Type.float64(), Boolean.class)).isEqualTo(Boolean.valueOf(d != 0D));
      assertConvertThrows(d, Type.float64(), Long.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(d, Type.float64(), Integer.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(d, Type.float64(), Short.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(d, Type.float64(), Byte.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(d, Type.float64(), BigInteger.class, Code.INVALID_ARGUMENT);
      assertConvertThrows(d, Type.float64(), BigDecimal.class, Code.INVALID_ARGUMENT);
    }
  }

  private void assertConvertThrows(Object t, Type type, Class<?> destinationType, Code code)
      throws SQLException {
    try {
      convert(t, type, destinationType);
      fail("missing conversion exception for " + t);
    } catch (JdbcSqlExceptionImpl e) {
      assertThat(e.getCode()).isEqualTo(code);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testToGoogleDate() {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        TimeZone.setDefault(zone);
        assertThat(toGoogleDate(new Date(2019 - 1900, 7, 24)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2019, 8, 24));
        assertThat(toGoogleDate(new Date(2019 - 1900, 0, 1)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2019, 1, 1));
        assertThat(toGoogleDate(new Date(2019 - 1900, 11, 31)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2019, 12, 31));
        assertThat(toGoogleDate(new Date(2016 - 1900, 1, 29)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2016, 2, 29));
        assertThat(toGoogleDate(new Date(2000 - 1900, 1, 29)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2000, 2, 29));

        assertThat(toGoogleDate(new Time(12, 0, 0)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1));
        assertThat(toGoogleDate(new Time(0, 0, 0)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1));
        assertThat(toGoogleDate(new Time(23, 59, 59)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(1970, 1, 1));

        assertThat(toGoogleDate(new Timestamp(2019 - 1900, 7, 24, 8, 51, 21, 987)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2019, 8, 24));
        assertThat(toGoogleDate(new Timestamp(2019 - 1900, 0, 1, 0, 0, 0, 0)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2019, 1, 1));
        assertThat(toGoogleDate(new Timestamp(2019 - 1900, 11, 31, 23, 59, 59, 100)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2019, 12, 31));
        assertThat(toGoogleDate(new Timestamp(2016 - 1900, 1, 29, 23, 59, 59, 0)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2016, 2, 29));
        assertThat(toGoogleDate(new Timestamp(2000 - 1900, 1, 29, 0, 0, 0, 0)))
            .isEqualTo(com.google.cloud.Date.fromYearMonthDay(2000, 2, 29));
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @Test
  public void testToGoogleDates() {
    @SuppressWarnings("deprecation")
    Date[] dates =
        new Date[] {
          new Date(2019 - 1900, 7, 24),
          new Date(2019 - 1900, 0, 1),
          new Date(2019 - 1900, 11, 31),
          new Date(2016 - 1900, 1, 29),
          new Date(2000 - 1900, 1, 29)
        };
    List<com.google.cloud.Date> expected =
        Arrays.asList(
            com.google.cloud.Date.fromYearMonthDay(2019, 8, 24),
            com.google.cloud.Date.fromYearMonthDay(2019, 1, 1),
            com.google.cloud.Date.fromYearMonthDay(2019, 12, 31),
            com.google.cloud.Date.fromYearMonthDay(2016, 2, 29),
            com.google.cloud.Date.fromYearMonthDay(2000, 2, 29));
    assertThat(toGoogleDates(dates)).isEqualTo(expected);
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testToSqlDate() {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        TimeZone.setDefault(zone);
        assertThat(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2019, 8, 24)))
            .isEqualTo(new Date(2019 - 1900, 7, 24));
        assertThat(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2019, 1, 1)))
            .isEqualTo(new Date(2019 - 1900, 0, 1));
        assertThat(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2019, 12, 31)))
            .isEqualTo(new Date(2019 - 1900, 11, 31));
        assertThat(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2016, 2, 29)))
            .isEqualTo(new Date(2016 - 1900, 1, 29));
        assertThat(toSqlDate(com.google.cloud.Date.fromYearMonthDay(2000, 2, 29)))
            .isEqualTo(new Date(2000 - 1900, 1, 29));
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @Test
  public void testToSqlDateWithCalendar() {
    for (TimeZone zone : getTestTimeZones()) {
      Calendar cal = Calendar.getInstance(zone);
      cal.set(2019, 7, 24, 0, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      assertThat(
              toSqlDate(
                  com.google.cloud.Date.fromYearMonthDay(2019, 8, 24), Calendar.getInstance(zone)))
          .isEqualTo(new Date(cal.getTimeInMillis()));

      cal.set(2019, 0, 1, 0, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      assertThat(
              toSqlDate(
                  com.google.cloud.Date.fromYearMonthDay(2019, 1, 1), Calendar.getInstance(zone)))
          .isEqualTo(new Date(cal.getTimeInMillis()));

      cal.set(2019, 11, 31, 0, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      assertThat(
              toSqlDate(
                  com.google.cloud.Date.fromYearMonthDay(2019, 12, 31), Calendar.getInstance(zone)))
          .isEqualTo(new Date(cal.getTimeInMillis()));

      cal.set(2016, 1, 29, 0, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      assertThat(
              toSqlDate(
                  com.google.cloud.Date.fromYearMonthDay(2016, 2, 29), Calendar.getInstance(zone)))
          .isEqualTo(new Date(cal.getTimeInMillis()));

      cal.set(2000, 1, 29, 0, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      assertThat(
              toSqlDate(
                  com.google.cloud.Date.fromYearMonthDay(2000, 2, 29), Calendar.getInstance(zone)))
          .isEqualTo(new Date(cal.getTimeInMillis()));
    }
  }

  @Test
  public void testToSqlDates() {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        TimeZone.setDefault(zone);
        List<com.google.cloud.Date> input =
            Arrays.asList(
                com.google.cloud.Date.fromYearMonthDay(2019, 8, 24),
                com.google.cloud.Date.fromYearMonthDay(2019, 1, 1),
                com.google.cloud.Date.fromYearMonthDay(2019, 12, 31),
                com.google.cloud.Date.fromYearMonthDay(2016, 2, 29),
                com.google.cloud.Date.fromYearMonthDay(2000, 2, 29));
        @SuppressWarnings("deprecation")
        List<Date> expected =
            Arrays.asList(
                new Date(2019 - 1900, 7, 24),
                new Date(2019 - 1900, 0, 1),
                new Date(2019 - 1900, 11, 31),
                new Date(2016 - 1900, 1, 29),
                new Date(2000 - 1900, 1, 29));
        assertThat(toSqlDates(input)).isEqualTo(expected);
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testToSqlTimestamp() throws SQLException {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        List<Timestamp> sqlTimestamps = new ArrayList<>();
        List<com.google.cloud.Timestamp> gTimestamps = new ArrayList<>();
        TimeZone.setDefault(zone);

        // Create a timestamp in the current default timezone, but do not set the nanosecond value
        // yet, as it would be lost by the ts.getTime() call on the next line.
        Timestamp ts = new Timestamp(2019 - 1900, 7, 24, 11 - 2, 23, 1, 0);
        ts.setTime(ts.getTime() + zone.getRawOffset());
        ts.setNanos(199800000);
        com.google.cloud.Timestamp gts =
            ReadOnlyStalenessUtil.parseRfc3339("2019-08-24T11:23:01.1998+02:00");
        assertThat(toSqlTimestamp(gts)).isEqualTo(ts);
        sqlTimestamps.add(ts);
        gTimestamps.add(gts);

        ts = new Timestamp(2019 - 1900, 11, 31, 23, 59, 59, 0);
        ts.setTime(ts.getTime() + zone.getRawOffset());
        ts.setNanos(999999999);
        gts = ReadOnlyStalenessUtil.parseRfc3339("2019-12-31T23:59:59.999999999Z");
        assertThat(toSqlTimestamp(gts)).isEqualTo(ts);
        sqlTimestamps.add(ts);
        gTimestamps.add(gts);

        ts = new Timestamp(2016 - 1900, 1, 29, 12 + 2, 0, 1, 0);
        ts.setTime(ts.getTime() + zone.getRawOffset());
        ts.setNanos(1000);
        gts = ReadOnlyStalenessUtil.parseRfc3339("2016-02-29T12:00:01.000001000-02:00");
        assertThat(toSqlTimestamp(gts)).isEqualTo(ts);
        sqlTimestamps.add(ts);
        gTimestamps.add(gts);

        ts = new Timestamp(2000 - 1900, 1, 29, 0, 0, 0, 0);
        ts.setTime(ts.getTime() + zone.getRawOffset());
        ts.setNanos(100000000);
        gts = ReadOnlyStalenessUtil.parseRfc3339("2000-02-29T00:00:00.100000000Z");
        assertThat(toSqlTimestamp(gts)).isEqualTo(ts);
        sqlTimestamps.add(ts);
        gTimestamps.add(gts);

        assertThat(toSqlTimestamps(gTimestamps)).isEqualTo(sqlTimestamps);
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @Test
  public void testGetAsSqlTimestamp() throws SQLException {
    for (TimeZone zone : getTestTimeZones()) {
      com.google.cloud.Timestamp gts =
          ReadOnlyStalenessUtil.parseRfc3339("2019-08-24T11:23:01.1998+03:00");
      Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+03:00"));
      cal.set(2019, 7, 24, 11, 23, 1);
      cal.set(Calendar.MILLISECOND, 0);
      Timestamp ts = new Timestamp(cal.getTimeInMillis() + zone.getRawOffset());
      ts.setNanos(199800000);
      assertThat(getAsSqlTimestamp(gts, Calendar.getInstance(zone))).isEqualTo(ts);

      gts = ReadOnlyStalenessUtil.parseRfc3339("2019-12-31T23:59:59.999999999-03:00");
      cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00"));
      cal.set(2019, 11, 31, 23, 59, 59);
      cal.set(Calendar.MILLISECOND, 0);
      ts = new Timestamp(cal.getTimeInMillis() + zone.getRawOffset());
      ts.setNanos(999999999);
      assertThat(getAsSqlTimestamp(gts, Calendar.getInstance(zone))).isEqualTo(ts);

      gts = ReadOnlyStalenessUtil.parseRfc3339("2016-02-29T12:00:00Z");
      cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      cal.set(2016, 1, 29, 12, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      ts = new Timestamp(cal.getTimeInMillis() + zone.getRawOffset());
      assertThat(getAsSqlTimestamp(gts, Calendar.getInstance(zone))).isEqualTo(ts);

      gts = ReadOnlyStalenessUtil.parseRfc3339("2000-02-29T00:00:00.000000000-10:00");
      cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-10:00"));
      cal.set(2000, 1, 29, 0, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      ts = new Timestamp(cal.getTimeInMillis() + zone.getRawOffset());
      assertThat(getAsSqlTimestamp(gts, Calendar.getInstance(zone))).isEqualTo(ts);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testSetTimestampInCalendar() throws SQLException {
    for (TimeZone zone : getTestTimeZones()) {
      Calendar cal = Calendar.getInstance(zone);
      cal.set(2019, 7, 24, 11, 23, 1);
      cal.set(Calendar.MILLISECOND, 0);
      Timestamp ts = new Timestamp(2019 - 1900, 7, 24, 11, 23, 1, 0);
      Timestamp tsInCal = setTimestampInCalendar(ts, Calendar.getInstance(zone));
      assertThat(tsInCal.getTime())
          .isEqualTo(cal.getTimeInMillis() - TimeZone.getDefault().getOffset(ts.getTime()));

      cal = Calendar.getInstance(zone);
      cal.set(2019, 11, 31, 23, 59, 59);
      cal.set(Calendar.MILLISECOND, 999);
      ts = new Timestamp(2019 - 1900, 11, 31, 23, 59, 59, 999000000);
      tsInCal = setTimestampInCalendar(ts, Calendar.getInstance(zone));
      assertThat(tsInCal.getTime())
          .isEqualTo(cal.getTimeInMillis() - TimeZone.getDefault().getOffset(ts.getTime()));

      cal = Calendar.getInstance(zone);
      cal.set(2016, 1, 29, 12, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      ts = new Timestamp(2016 - 1900, 1, 29, 12, 0, 0, 0);
      tsInCal = setTimestampInCalendar(ts, Calendar.getInstance(zone));
      assertThat(tsInCal.getTime())
          .isEqualTo(cal.getTimeInMillis() - TimeZone.getDefault().getOffset(ts.getTime()));

      cal = Calendar.getInstance(zone);
      cal.set(2000, 1, 29, 0, 0, 0);
      cal.set(Calendar.MILLISECOND, 0);
      ts = new Timestamp(2000 - 1900, 1, 29, 0, 0, 0, 0);
      tsInCal = setTimestampInCalendar(ts, Calendar.getInstance(zone));
      assertThat(tsInCal.getTime())
          .isEqualTo(cal.getTimeInMillis() - TimeZone.getDefault().getOffset(ts.getTime()));
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testToGoogleTimestamp() {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        TimeZone.setDefault(zone);
        assertThat(toGoogleTimestamp(new Date(2019 - 1900, 7, 24)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2019 - 1900, 7, 24, 0, 0, 0, 0)));
        assertThat(toGoogleTimestamp(new Date(2019 - 1900, 0, 1)))
            .isEqualTo(com.google.cloud.Timestamp.of(new Timestamp(2019 - 1900, 0, 1, 0, 0, 0, 0)));
        assertThat(toGoogleTimestamp(new Date(2019 - 1900, 11, 31)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2019 - 1900, 11, 31, 0, 0, 0, 0)));
        assertThat(toGoogleTimestamp(new Date(2016 - 1900, 1, 29)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2016 - 1900, 1, 29, 0, 0, 0, 0)));
        assertThat(toGoogleTimestamp(new Date(2000 - 1900, 1, 29)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2000 - 1900, 1, 29, 0, 0, 0, 0)));

        assertThat(toGoogleTimestamp(new Time(12, 0, 0)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(1970 - 1900, 0, 1, 12, 0, 0, 0)));
        assertThat(toGoogleTimestamp(new Time(0, 0, 0)))
            .isEqualTo(com.google.cloud.Timestamp.of(new Timestamp(1970 - 1900, 0, 1, 0, 0, 0, 0)));
        assertThat(toGoogleTimestamp(new Time(23, 59, 59)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(1970 - 1900, 0, 1, 23, 59, 59, 0)));

        assertThat(toGoogleTimestamp(new Timestamp(2019 - 1900, 7, 24, 8, 51, 21, 987)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2019 - 1900, 7, 24, 8, 51, 21, 987)));
        assertThat(toGoogleTimestamp(new Timestamp(2019 - 1900, 0, 1, 0, 0, 0, 0)))
            .isEqualTo(com.google.cloud.Timestamp.of(new Timestamp(2019 - 1900, 0, 1, 0, 0, 0, 0)));
        assertThat(toGoogleTimestamp(new Timestamp(2019 - 1900, 11, 31, 23, 59, 59, 100)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2019 - 1900, 11, 31, 23, 59, 59, 100)));
        assertThat(toGoogleTimestamp(new Timestamp(2016 - 1900, 1, 29, 23, 59, 59, 0)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2016 - 1900, 1, 29, 23, 59, 59, 0)));
        assertThat(toGoogleTimestamp(new Timestamp(2000 - 1900, 1, 29, 0, 0, 0, 0)))
            .isEqualTo(
                com.google.cloud.Timestamp.of(new Timestamp(2000 - 1900, 1, 29, 0, 0, 0, 0)));
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testToSqlTime() {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      for (TimeZone zone : getTestTimeZones()) {
        TimeZone.setDefault(zone);

        com.google.cloud.Timestamp gts =
            ReadOnlyStalenessUtil.parseRfc3339("2019-08-24T11:23:01.1998+03:00");
        // Subtract 3 hours to compensate for +03 timezone.
        Time time = new Time(11 - 3, 23, 1);
        time.setTime(time.getTime() + zone.getRawOffset());
        Time convertedTime = toSqlTime(gts);
        assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
        assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
        assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());

        gts = ReadOnlyStalenessUtil.parseRfc3339("2019-12-31T23:59:59.999999999Z");
        time = new Time(23, 59, 59);
        time.setTime(time.getTime() + zone.getRawOffset());
        convertedTime = toSqlTime(gts);
        assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
        assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
        assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());

        gts = ReadOnlyStalenessUtil.parseRfc3339("2016-02-29T12:00:01.000001000-02:00");
        time = new Time(12 + 2, 0, 1);
        time.setTime(time.getTime() + zone.getRawOffset());
        convertedTime = toSqlTime(gts);
        assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
        assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
        assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());

        gts = ReadOnlyStalenessUtil.parseRfc3339("2000-02-29T00:00:00.100000000Z");
        time = new Time(0, 0, 0);
        time.setTime(time.getTime() + zone.getRawOffset());
        convertedTime = toSqlTime(gts);
        assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
        assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
        assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());
      }
    } finally {
      TimeZone.setDefault(initialDefault);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testToSqlTimeWithCalendar() {
    for (TimeZone zone : getTestTimeZones()) {
      com.google.cloud.Timestamp gts =
          ReadOnlyStalenessUtil.parseRfc3339("2019-08-24T11:23:01.1998+03:00");
      // Compensate for +03
      Time time = new Time(11 - 3, 23, 1);
      // Compensate for the test timezone.
      time.setHours(time.getHours() + ((int) (zone.getRawOffset() / 60_000L / 60)));
      // Compensate for the timezone of the environment on the parsed date.
      time.setHours(
          time.getHours()
              + ((int)
                  (TimeZone.getDefault().getOffset(gts.toSqlTimestamp().getTime())
                      / 60_000L
                      / 60)));
      Time convertedTime = toSqlTime(gts, Calendar.getInstance(zone));
      assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
      assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
      assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());

      gts = ReadOnlyStalenessUtil.parseRfc3339("2019-12-31T23:59:59.999999999Z");
      time = new Time(23, 59, 59);
      time.setHours(time.getHours() + ((int) (zone.getRawOffset() / 60_000L / 60)));
      time.setHours(
          time.getHours()
              + ((int)
                  (TimeZone.getDefault().getOffset(gts.toSqlTimestamp().getTime())
                      / 60_000L
                      / 60)));
      convertedTime = toSqlTime(gts, Calendar.getInstance(zone));
      assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
      assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
      assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());

      gts = ReadOnlyStalenessUtil.parseRfc3339("2016-02-29T12:00:01.000001000-02:00");
      time = new Time(12 + 2, 0, 1);
      time.setHours(time.getHours() + ((int) (zone.getRawOffset() / 60_000L / 60)));
      time.setHours(
          time.getHours()
              + ((int)
                  (TimeZone.getDefault().getOffset(gts.toSqlTimestamp().getTime())
                      / 60_000L
                      / 60)));
      convertedTime = toSqlTime(gts, Calendar.getInstance(zone));
      assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
      assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
      assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());

      gts = ReadOnlyStalenessUtil.parseRfc3339("2000-02-29T00:00:00.100000000Z");
      time = new Time(0, 0, 0);
      time.setHours(time.getHours() + ((int) (zone.getRawOffset() / 60_000L / 60)));
      time.setHours(
          time.getHours()
              + ((int)
                  (TimeZone.getDefault().getOffset(gts.toSqlTimestamp().getTime())
                      / 60_000L
                      / 60)));
      convertedTime = toSqlTime(gts, Calendar.getInstance(zone));
      assertThat(convertedTime.getHours()).isEqualTo(time.getHours());
      assertThat(convertedTime.getMinutes()).isEqualTo(time.getMinutes());
      assertThat(convertedTime.getSeconds()).isEqualTo(time.getSeconds());
    }
  }

  @Test
  public void testToGoogleBytes() {
    assertThat(toGoogleBytes(new byte[][] {"test1".getBytes(UTF8), "test2".getBytes(UTF8)}))
        .isEqualTo(Arrays.asList(ByteArray.copyFrom("test1"), ByteArray.copyFrom("test2")));
  }

  @Test
  public void testToJavaByteArrays() {
    List<ByteArray> input = Arrays.asList(ByteArray.copyFrom("test3"), ByteArray.copyFrom("test4"));
    List<byte[]> expected = Arrays.asList("test3".getBytes(UTF8), "test4".getBytes(UTF8));
    List<byte[]> output = toJavaByteArrays(input);
    assertThat(Arrays.deepEquals(expected.toArray(), output.toArray())).isTrue();
  }
}

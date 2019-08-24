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

import static com.google.cloud.spanner.jdbc.JdbcTypeConverter.convert;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.rpc.Code;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
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

  @Test
  public void testConvertDate() throws SQLException {
    TimeZone initialDefault = TimeZone.getDefault();
    try {
      TimeZone[] zones =
          new TimeZone[] {
            TimeZone.getTimeZone("GMT-12:00"),
            TimeZone.getTimeZone("GMT-9:00"),
            TimeZone.getTimeZone("GMT-1:00"),
            TimeZone.getTimeZone("GMT"),
            TimeZone.getTimeZone("GMT+1:00"),
            TimeZone.getTimeZone("GMT+12:00")
          };
      for (TimeZone zone : zones) {
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
      TimeZone[] zones =
          new TimeZone[] {
            TimeZone.getTimeZone("GMT-12:00"),
            TimeZone.getTimeZone("GMT-9:00"),
            TimeZone.getTimeZone("GMT-1:00"),
            TimeZone.getTimeZone("GMT"),
            TimeZone.getTimeZone("GMT+1:00"),
            TimeZone.getTimeZone("GMT+12:00")
          };
      for (TimeZone zone : zones) {
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
}

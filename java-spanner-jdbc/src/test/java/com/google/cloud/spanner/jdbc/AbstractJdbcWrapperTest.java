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

import static com.google.cloud.spanner.jdbc.AbstractJdbcWrapper.getSpannerColumnTypeName;
import static com.google.cloud.spanner.jdbc.AbstractJdbcWrapper.getSpannerTypeName;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Type;
import com.google.rpc.Code;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractJdbcWrapperTest {
  /** Create a concrete sub class to use for testing. */
  private static class TestWrapper extends AbstractJdbcWrapper {
    @Override
    public boolean isClosed() {
      return false;
    }
  }

  /** Add a sub class for the test class for testing wrapping. */
  private static class SubTestWrapper extends TestWrapper {}

  @Test
  public void testIsWrapperFor() {
    TestWrapper subject = new TestWrapper();
    assertThat(subject.isWrapperFor(TestWrapper.class)).isTrue();
    assertThat(subject.isWrapperFor(SubTestWrapper.class)).isFalse();
    assertThat(subject.isWrapperFor(Object.class)).isTrue();
    assertThat(subject.isWrapperFor(getClass())).isFalse();

    subject = new SubTestWrapper();
    assertThat(subject.isWrapperFor(TestWrapper.class)).isTrue();
    assertThat(subject.isWrapperFor(SubTestWrapper.class)).isTrue();
    assertThat(subject.isWrapperFor(Object.class)).isTrue();
    assertThat(subject.isWrapperFor(getClass())).isFalse();
  }

  @Test
  public void testUnwrap() {
    TestWrapper subject = new TestWrapper();
    assertThat(unwrapSucceeds(subject, TestWrapper.class)).isTrue();
    assertThat(unwrapSucceeds(subject, SubTestWrapper.class)).isFalse();
    assertThat(unwrapSucceeds(subject, Object.class)).isTrue();
    assertThat(unwrapSucceeds(subject, getClass())).isFalse();
  }

  @FunctionalInterface
  private interface SqlFunction<T, R> {
    R apply(T value) throws SQLException;
  }

  private static final class CheckedCastChecker<T> {

    private final SqlFunction<T, ?> checker;

    public CheckedCastChecker(SqlFunction<T, ?> checker) {
      this.checker = checker;
    }

    public boolean cast(T value) {
      try {
        checker.apply(value);
        return true;
      } catch (SQLException e) {
        return false;
      }
    }
  }

  @Test
  public void testCheckedCastToByte() {
    final CheckedCastChecker<Long> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToByte);
    assertThat(checker.cast(0L)).isTrue();
    assertThat(checker.cast(1L)).isTrue();
    assertThat(checker.cast((long) Byte.MAX_VALUE)).isTrue();
    assertThat(checker.cast((long) Byte.MAX_VALUE + 1L)).isFalse();
    assertThat(checker.cast(Long.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1L)).isTrue();
    assertThat(checker.cast((long) Byte.MIN_VALUE)).isTrue();
    assertThat(checker.cast((long) Byte.MIN_VALUE - 1L)).isFalse();
    assertThat(checker.cast(Long.MIN_VALUE)).isFalse();
  }

  @Test
  public void testCheckedCastFromBigDecimalToByte() {
    final CheckedCastChecker<BigDecimal> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToByte);
    assertTrue(checker.cast(BigDecimal.ZERO));
    assertTrue(checker.cast(BigDecimal.ONE));
    assertTrue(checker.cast(BigDecimal.valueOf(-1)));
    assertTrue(checker.cast(BigDecimal.valueOf(Byte.MIN_VALUE)));
    assertTrue(checker.cast(BigDecimal.valueOf(Byte.MAX_VALUE)));

    assertFalse(checker.cast(BigDecimal.valueOf(Byte.MAX_VALUE).add(BigDecimal.ONE)));
    assertFalse(checker.cast(BigDecimal.valueOf(Byte.MIN_VALUE).subtract(BigDecimal.ONE)));
  }

  @Test
  public void testCheckedCastFromBigIntegerToByte() {
    final CheckedCastChecker<BigInteger> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToByte);
    assertTrue(checker.cast(BigInteger.ZERO));
    assertTrue(checker.cast(BigInteger.ONE));
    assertTrue(checker.cast(BigInteger.valueOf(-1)));
    assertTrue(checker.cast(BigInteger.valueOf(Byte.MIN_VALUE)));
    assertTrue(checker.cast(BigInteger.valueOf(Byte.MAX_VALUE)));

    assertFalse(checker.cast(BigInteger.valueOf(Byte.MAX_VALUE).add(BigInteger.ONE)));
    assertFalse(checker.cast(BigInteger.valueOf(Byte.MIN_VALUE).subtract(BigInteger.ONE)));
  }

  @Test
  public void testCheckedCastToShort() {
    final CheckedCastChecker<Long> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToShort);
    assertThat(checker.cast(0L)).isTrue();
    assertThat(checker.cast(1L)).isTrue();
    assertThat(checker.cast((long) Short.MAX_VALUE)).isTrue();
    assertThat(checker.cast((long) Short.MAX_VALUE + 1L)).isFalse();
    assertThat(checker.cast(Long.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1L)).isTrue();
    assertThat(checker.cast((long) Short.MIN_VALUE)).isTrue();
    assertThat(checker.cast((long) Short.MIN_VALUE - 1L)).isFalse();
    assertThat(checker.cast(Long.MIN_VALUE)).isFalse();
  }

  @Test
  public void testCheckedCastFromBigDecimalToShort() {
    final CheckedCastChecker<BigDecimal> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToShort);
    assertTrue(checker.cast(BigDecimal.ZERO));
    assertTrue(checker.cast(BigDecimal.ONE));
    assertTrue(checker.cast(BigDecimal.valueOf(-1)));
    assertTrue(checker.cast(BigDecimal.valueOf(Short.MIN_VALUE)));
    assertTrue(checker.cast(BigDecimal.valueOf(Short.MAX_VALUE)));

    assertFalse(checker.cast(BigDecimal.valueOf(Short.MAX_VALUE).add(BigDecimal.ONE)));
    assertFalse(checker.cast(BigDecimal.valueOf(Short.MIN_VALUE).subtract(BigDecimal.ONE)));
  }

  @Test
  public void testCheckedCastFromBigIntegerToShort() {
    final CheckedCastChecker<BigInteger> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToShort);
    assertTrue(checker.cast(BigInteger.ZERO));
    assertTrue(checker.cast(BigInteger.ONE));
    assertTrue(checker.cast(BigInteger.valueOf(-1)));
    assertTrue(checker.cast(BigInteger.valueOf(Short.MIN_VALUE)));
    assertTrue(checker.cast(BigInteger.valueOf(Short.MAX_VALUE)));

    assertFalse(checker.cast(BigInteger.valueOf(Short.MAX_VALUE).add(BigInteger.ONE)));
    assertFalse(checker.cast(BigInteger.valueOf(Short.MIN_VALUE).subtract(BigInteger.ONE)));
  }

  @Test
  public void testCheckedCastToInt() {
    final CheckedCastChecker<Long> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToInt);
    assertThat(checker.cast(0L)).isTrue();
    assertThat(checker.cast(1L)).isTrue();
    assertThat(checker.cast((long) Integer.MAX_VALUE)).isTrue();
    assertThat(checker.cast((long) Integer.MAX_VALUE + 1L)).isFalse();
    assertThat(checker.cast(Long.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1L)).isTrue();
    assertThat(checker.cast((long) Integer.MIN_VALUE)).isTrue();
    assertThat(checker.cast((long) Integer.MIN_VALUE - 1L)).isFalse();
    assertThat(checker.cast(Long.MIN_VALUE)).isFalse();
  }

  @Test
  public void testCheckedCastFromBigDecimalToInt() {
    final CheckedCastChecker<BigDecimal> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToInt);
    assertTrue(checker.cast(BigDecimal.ZERO));
    assertTrue(checker.cast(BigDecimal.ONE));
    assertTrue(checker.cast(BigDecimal.valueOf(-1)));
    assertTrue(checker.cast(BigDecimal.valueOf(Integer.MIN_VALUE)));
    assertTrue(checker.cast(BigDecimal.valueOf(Integer.MAX_VALUE)));

    assertFalse(checker.cast(BigDecimal.valueOf(Integer.MAX_VALUE).add(BigDecimal.ONE)));
    assertFalse(checker.cast(BigDecimal.valueOf(Integer.MIN_VALUE).subtract(BigDecimal.ONE)));
  }

  @Test
  public void testCheckedCastFromBigIntegerToInt() {
    final CheckedCastChecker<BigInteger> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToInt);
    assertTrue(checker.cast(BigInteger.ZERO));
    assertTrue(checker.cast(BigInteger.ONE));
    assertTrue(checker.cast(BigInteger.valueOf(-1)));
    assertTrue(checker.cast(BigInteger.valueOf(Integer.MIN_VALUE)));
    assertTrue(checker.cast(BigInteger.valueOf(Integer.MAX_VALUE)));

    assertFalse(checker.cast(BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.ONE)));
    assertFalse(checker.cast(BigInteger.valueOf(Integer.MIN_VALUE).subtract(BigInteger.ONE)));
  }

  @Test
  public void testCheckedCastFromBigDecimalToLong() {
    final CheckedCastChecker<BigDecimal> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToLong);
    assertTrue(checker.cast(BigDecimal.ZERO));
    assertTrue(checker.cast(BigDecimal.ONE));
    assertTrue(checker.cast(BigDecimal.valueOf(-1)));
    assertTrue(checker.cast(BigDecimal.valueOf(Long.MIN_VALUE)));
    assertTrue(checker.cast(BigDecimal.valueOf(Long.MAX_VALUE)));

    assertFalse(checker.cast(BigDecimal.valueOf(Long.MAX_VALUE).add(BigDecimal.ONE)));
    assertFalse(checker.cast(BigDecimal.valueOf(Long.MIN_VALUE).subtract(BigDecimal.ONE)));
  }

  @Test
  public void testCheckedCastFromBigIntegerToLong() {
    final CheckedCastChecker<BigInteger> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToLong);
    assertTrue(checker.cast(BigInteger.ZERO));
    assertTrue(checker.cast(BigInteger.ONE));
    assertTrue(checker.cast(BigInteger.valueOf(-1)));
    assertTrue(checker.cast(BigInteger.valueOf(Long.MIN_VALUE)));
    assertTrue(checker.cast(BigInteger.valueOf(Long.MAX_VALUE)));

    assertFalse(checker.cast(BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE)));
    assertFalse(checker.cast(BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.ONE)));
  }

  @Test
  public void testCheckedCastToFloat() throws SQLException {
    final CheckedCastChecker<Double> checker =
        new CheckedCastChecker<>(AbstractJdbcWrapper::checkedCastToFloat);
    assertThat(checker.cast(0D)).isTrue();
    assertThat(checker.cast(1D)).isTrue();
    assertThat(checker.cast((double) Float.MAX_VALUE)).isTrue();
    assertThat(checker.cast((double) Float.MAX_VALUE * 2.0D)).isFalse();
    assertThat(checker.cast(Double.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1D)).isTrue();
    assertThat(checker.cast((double) Float.MIN_VALUE)).isTrue();
    assertThat(checker.cast(-Float.MAX_VALUE * 2d)).isFalse();
    assertThat(checker.cast(-Double.MAX_VALUE)).isFalse();

    assertEquals(
        Float.POSITIVE_INFINITY,
        AbstractJdbcWrapper.checkedCastToFloat(Double.POSITIVE_INFINITY),
        0.0d);
    assertEquals(
        Float.NEGATIVE_INFINITY,
        AbstractJdbcWrapper.checkedCastToFloat(Double.NEGATIVE_INFINITY),
        0.0d);
    assertEquals(Float.NaN, AbstractJdbcWrapper.checkedCastToFloat(Double.NaN), 0.0d);
  }

  @Test
  public void testParseBigDecimal() throws SQLException {
    assertEquals(BigDecimal.valueOf(123, 2), AbstractJdbcWrapper.parseBigDecimal("1.23"));
    try {
      AbstractJdbcWrapper.parseBigDecimal("NaN");
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertTrue(e instanceof JdbcSqlException);
      assertEquals(Code.INVALID_ARGUMENT.getNumber(), e.getErrorCode());
    }
  }

  @Test
  public void testParseFloat() throws SQLException {
    assertEquals(3.14F, AbstractJdbcWrapper.parseFloat("3.14"), 0.001F);
    try {
      AbstractJdbcWrapper.parseFloat("invalid number");
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertTrue(e instanceof JdbcSqlException);
      assertEquals(Code.INVALID_ARGUMENT.getNumber(), e.getErrorCode());
    }
  }

  private boolean unwrapSucceeds(AbstractJdbcWrapper subject, Class<?> iface) {
    try {
      subject.unwrap(iface);
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  @Test
  public void testParseDouble() throws SQLException {
    assertThat(AbstractJdbcWrapper.parseDouble("3.14")).isEqualTo(3.14D);
    try {
      AbstractJdbcWrapper.parseDouble("not a number");
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      assertThat(((JdbcSqlException) e).getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testParseDate() throws SQLException {
    assertThat(AbstractJdbcWrapper.parseDate("2020-06-01")).isEqualTo(new Date(2020 - 1900, 5, 1));
    try {
      AbstractJdbcWrapper.parseDate("01-06-2020");
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      assertThat(((JdbcSqlException) e).getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testParseDateWithCalendar() throws SQLException {
    assertThat(
            AbstractJdbcWrapper.parseDate(
                "2020-06-01", Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"))))
        .isEqualTo(
            new Date(
                Timestamp.parseTimestamp("2020-06-01T00:00:00-07:00").toSqlTimestamp().getTime()));
    assertThat(
            AbstractJdbcWrapper.parseDate(
                "2020-06-01", Calendar.getInstance(TimeZone.getTimeZone("Europe/Amsterdam"))))
        .isEqualTo(
            new Date(
                Timestamp.parseTimestamp("2020-06-01T00:00:00+02:00").toSqlTimestamp().getTime()));
    try {
      AbstractJdbcWrapper.parseDate("01-06-2020", Calendar.getInstance());
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      assertThat(((JdbcSqlException) e).getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testParseTime() throws SQLException {
    assertThat(AbstractJdbcWrapper.parseTime("10:31:05")).isEqualTo(new Time(10, 31, 5));
    try {
      AbstractJdbcWrapper.parseTime("10.31.05");
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      assertThat(((JdbcSqlException) e).getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testParseTimeWithCalendar() throws SQLException {
    assertThat(
            AbstractJdbcWrapper.parseTime(
                "10:31:05", Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"))))
        .isEqualTo(
            new Time(
                Timestamp.parseTimestamp("1970-01-01T10:31:05-08:00").toSqlTimestamp().getTime()));
    assertThat(
            AbstractJdbcWrapper.parseTime(
                "10:31:05", Calendar.getInstance(TimeZone.getTimeZone("Pacific/Auckland"))))
        .isEqualTo(
            new Time(
                Timestamp.parseTimestamp("1970-01-01T10:31:05+12:00").toSqlTimestamp().getTime()));
    try {
      AbstractJdbcWrapper.parseTime("10.31.05", Calendar.getInstance());
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      assertThat(((JdbcSqlException) e).getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testParseTimestamp() throws SQLException {
    assertThat(AbstractJdbcWrapper.parseTimestamp("2020-06-01T10:31:05Z"))
        .isEqualTo(Timestamp.parseTimestamp("2020-06-01T10:31:05Z").toSqlTimestamp());
    assertThat(AbstractJdbcWrapper.parseTimestamp("2020-06-01T10:31:05.123Z"))
        .isEqualTo(Timestamp.parseTimestamp("2020-06-01T10:31:05.123Z").toSqlTimestamp());
    assertThat(AbstractJdbcWrapper.parseTimestamp("2020-06-01T10:31Z"))
        .isEqualTo(Timestamp.parseTimestamp("2020-06-01T10:31:00Z").toSqlTimestamp());
    assertThat(AbstractJdbcWrapper.parseTimestamp("2020-06-01T10:31"))
        .isEqualTo(Timestamp.parseTimestamp("2020-06-01T10:31:00Z").toSqlTimestamp());
    assertThat(AbstractJdbcWrapper.parseTimestamp("1970-01-01T00:00:00Z"))
        .isEqualTo(Timestamp.ofTimeMicroseconds(0L).toSqlTimestamp());
    try {
      AbstractJdbcWrapper.parseTimestamp("2020-06-01T10");
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      assertThat(((JdbcSqlException) e).getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testParseTimestampWithCalendar() throws SQLException {
    assertThat(
            AbstractJdbcWrapper.parseTimestamp(
                "2020-02-01T10:31:05Z",
                Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"))))
        .isEqualTo(Timestamp.parseTimestamp("2020-02-01T10:31:05-08:00").toSqlTimestamp());
    assertThat(
            AbstractJdbcWrapper.parseTimestamp(
                "2020-06-01T10:31:05Z",
                Calendar.getInstance(TimeZone.getTimeZone("Europe/Amsterdam"))))
        .isEqualTo(Timestamp.parseTimestamp("2020-06-01T10:31:05+02:00").toSqlTimestamp());
    try {
      AbstractJdbcWrapper.parseTimestamp(
          "2020-06-01T10", Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")));
      fail("missing expected SQLException");
    } catch (SQLException e) {
      assertThat((Exception) e).isInstanceOf(JdbcSqlException.class);
      assertThat(((JdbcSqlException) e).getCode()).isEqualTo(Code.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testGoogleSQLTypeNames() {
    assertEquals("INT64", getSpannerTypeName(Type.int64(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("BOOL", getSpannerTypeName(Type.bool(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("FLOAT64", getSpannerTypeName(Type.float64(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("STRING", getSpannerTypeName(Type.string(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("BYTES", getSpannerTypeName(Type.bytes(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("DATE", getSpannerTypeName(Type.date(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("TIMESTAMP", getSpannerTypeName(Type.timestamp(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("JSON", getSpannerTypeName(Type.json(), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals("NUMERIC", getSpannerTypeName(Type.numeric(), Dialect.GOOGLE_STANDARD_SQL));

    assertEquals(
        "ARRAY<INT64>", getSpannerTypeName(Type.array(Type.int64()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<BOOL>", getSpannerTypeName(Type.array(Type.bool()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<FLOAT64>",
        getSpannerTypeName(Type.array(Type.float64()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<STRING>",
        getSpannerTypeName(Type.array(Type.string()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<BYTES>", getSpannerTypeName(Type.array(Type.bytes()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<DATE>", getSpannerTypeName(Type.array(Type.date()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<TIMESTAMP>",
        getSpannerTypeName(Type.array(Type.timestamp()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<JSON>", getSpannerTypeName(Type.array(Type.json()), Dialect.GOOGLE_STANDARD_SQL));
    assertEquals(
        "ARRAY<NUMERIC>",
        getSpannerTypeName(Type.array(Type.numeric()), Dialect.GOOGLE_STANDARD_SQL));
  }

  @Test
  public void testPostgreSQLTypeNames() {
    assertEquals("bigint", getSpannerTypeName(Type.int64(), Dialect.POSTGRESQL));
    assertEquals("boolean", getSpannerTypeName(Type.bool(), Dialect.POSTGRESQL));
    assertEquals("double precision", getSpannerTypeName(Type.float64(), Dialect.POSTGRESQL));
    assertEquals("character varying", getSpannerTypeName(Type.string(), Dialect.POSTGRESQL));
    assertEquals("bytea", getSpannerTypeName(Type.bytes(), Dialect.POSTGRESQL));
    assertEquals("date", getSpannerTypeName(Type.date(), Dialect.POSTGRESQL));
    assertEquals(
        "timestamp with time zone", getSpannerTypeName(Type.timestamp(), Dialect.POSTGRESQL));
    assertEquals("jsonb", getSpannerTypeName(Type.pgJsonb(), Dialect.POSTGRESQL));
    assertEquals("numeric", getSpannerTypeName(Type.pgNumeric(), Dialect.POSTGRESQL));

    assertEquals("bigint[]", getSpannerTypeName(Type.array(Type.int64()), Dialect.POSTGRESQL));
    assertEquals("boolean[]", getSpannerTypeName(Type.array(Type.bool()), Dialect.POSTGRESQL));
    assertEquals(
        "double precision[]", getSpannerTypeName(Type.array(Type.float64()), Dialect.POSTGRESQL));
    assertEquals(
        "character varying[]", getSpannerTypeName(Type.array(Type.string()), Dialect.POSTGRESQL));
    assertEquals("bytea[]", getSpannerTypeName(Type.array(Type.bytes()), Dialect.POSTGRESQL));
    assertEquals("date[]", getSpannerTypeName(Type.array(Type.date()), Dialect.POSTGRESQL));
    assertEquals(
        "timestamp with time zone[]",
        getSpannerTypeName(Type.array(Type.timestamp()), Dialect.POSTGRESQL));
    assertEquals("jsonb[]", getSpannerTypeName(Type.array(Type.pgJsonb()), Dialect.POSTGRESQL));
    assertEquals("numeric[]", getSpannerTypeName(Type.array(Type.pgNumeric()), Dialect.POSTGRESQL));

    assertEquals("_bigint", getSpannerColumnTypeName(Type.array(Type.int64()), Dialect.POSTGRESQL));
    assertEquals("_boolean", getSpannerColumnTypeName(Type.array(Type.bool()), Dialect.POSTGRESQL));
    assertEquals(
        "_double precision",
        getSpannerColumnTypeName(Type.array(Type.float64()), Dialect.POSTGRESQL));
    assertEquals(
        "_character varying",
        getSpannerColumnTypeName(Type.array(Type.string()), Dialect.POSTGRESQL));
    assertEquals("_bytea", getSpannerColumnTypeName(Type.array(Type.bytes()), Dialect.POSTGRESQL));
    assertEquals("_date", getSpannerColumnTypeName(Type.array(Type.date()), Dialect.POSTGRESQL));
    assertEquals(
        "_timestamp with time zone",
        getSpannerColumnTypeName(Type.array(Type.timestamp()), Dialect.POSTGRESQL));
    assertEquals(
        "_jsonb", getSpannerColumnTypeName(Type.array(Type.pgJsonb()), Dialect.POSTGRESQL));
    assertEquals(
        "_numeric", getSpannerColumnTypeName(Type.array(Type.pgNumeric()), Dialect.POSTGRESQL));
  }
}

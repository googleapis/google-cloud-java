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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcResultSetTest {
  private static final String UNKNOWN_COLUMN = "UNKNOWN_COLUMN";
  private static final String STRING_COL_NULL = "STRING_COL_NULL";
  private static final String STRING_COL_NOT_NULL = "STRING_COL_NOT_NULL";
  private static final String STRING_VALUE = "FOO";
  private static final int STRING_COLINDEX_NULL = 1;
  private static final int STRING_COLINDEX_NOTNULL = 2;
  private static final String BOOLEAN_COL_NULL = "BOOLEAN_COL_NULL";
  private static final String BOOLEAN_COL_NOT_NULL = "BOOLEAN_COL_NOT_NULL";
  private static final boolean BOOLEAN_VALUE = true;
  private static final int BOOLEAN_COLINDEX_NULL = 3;
  private static final int BOOLEAN_COLINDEX_NOTNULL = 4;
  private static final String DOUBLE_COL_NULL = "DOUBLE_COL_NULL";
  private static final String DOUBLE_COL_NOT_NULL = "DOUBLE_COL_NOT_NULL";
  private static final double DOUBLE_VALUE = 3.14159265359D;
  private static final int DOUBLE_COLINDEX_NULL = 5;
  private static final int DOUBLE_COLINDEX_NOTNULL = 6;
  private static final String BYTES_COL_NULL = "BYTES_COL_NULL";
  private static final String BYTES_COL_NOT_NULL = "BYTES_COL_NOT_NULL";
  private static final ByteArray BYTES_VALUE = ByteArray.copyFrom("FOO");
  private static final int BYTES_COLINDEX_NULL = 7;
  private static final int BYTES_COLINDEX_NOTNULL = 8;
  private static final String LONG_COL_NULL = "LONG_COL_NULL";
  private static final String LONG_COL_NOT_NULL = "LONG_COL_NOT_NULL";
  private static final long LONG_VALUE = 1L;
  private static final int LONG_COLINDEX_NULL = 9;
  private static final int LONG_COLINDEX_NOTNULL = 10;
  private static final String DATE_COL_NULL = "DATE_COL_NULL";
  private static final String DATE_COL_NOT_NULL = "DATE_COL_NOT_NULL";
  private static final Date DATE_VALUE = Date.fromYearMonthDay(2019, 1, 18);
  private static final int DATE_COLINDEX_NULL = 11;
  private static final int DATE_COLINDEX_NOTNULL = 12;
  private static final String TIMESTAMP_COL_NULL = "TIMESTAMP_COL_NULL";
  private static final String TIMESTAMP_COL_NOT_NULL = "TIMESTAMP_COL_NOT_NULL";
  private static final Timestamp TIMESTAMP_VALUE =
      Timestamp.parseTimestamp("2019-01-18T10:00:01.1213Z");
  private static final int TIMESTAMP_COLINDEX_NULL = 13;
  private static final int TIMESTAMP_COLINDEX_NOTNULL = 14;
  private static final String TIME_COL_NULL = "TIME_COL_NULL";
  private static final String TIME_COL_NOT_NULL = "TIME_COL_NOT_NULL";
  private static final Timestamp TIME_VALUE = Timestamp.parseTimestamp("1970-01-01T10:01:02.995Z");
  private static final int TIME_COLINDEX_NULL = 15;
  private static final int TIME_COLINDEX_NOTNULL = 16;
  private static final String ARRAY_COL_NULL = "ARRAY_COL_NULL";
  private static final String ARRAY_COL_NOT_NULL = "ARRAY_COL_NOT_NULL";
  private static final long[] ARRAY_VALUE = new long[] {1L, 2L, 3L};
  private static final int ARRAY_COLINDEX_NULL = 17;
  private static final int ARRAY_COLINDEX_NOTNULL = 18;
  private static final String URL_COL_NULL = "URL_COL_NULL";
  private static final String URL_COL_NOT_NULL = "URL_COL_NOT_NULL";
  private static final String URL_VALUE = "https://cloud.google.com/spanner/docs/apis";
  private static final int URL_COLINDEX_NULL = 19;
  private static final int URL_COLINDEX_NOTNULL = 20;

  @Rule public ExpectedException thrown = ExpectedException.none();

  private JdbcResultSet subject;

  static ResultSet getMockResultSet() {
    return ResultSets.forRows(
        Type.struct(
            StructField.of(STRING_COL_NULL, Type.string()),
            StructField.of(STRING_COL_NOT_NULL, Type.string()),
            StructField.of(BOOLEAN_COL_NULL, Type.bool()),
            StructField.of(BOOLEAN_COL_NOT_NULL, Type.bool()),
            StructField.of(DOUBLE_COL_NULL, Type.float64()),
            StructField.of(DOUBLE_COL_NOT_NULL, Type.float64()),
            StructField.of(BYTES_COL_NULL, Type.bytes()),
            StructField.of(BYTES_COL_NOT_NULL, Type.bytes()),
            StructField.of(LONG_COL_NULL, Type.int64()),
            StructField.of(LONG_COL_NOT_NULL, Type.int64()),
            StructField.of(DATE_COL_NULL, Type.date()),
            StructField.of(DATE_COL_NOT_NULL, Type.date()),
            StructField.of(TIMESTAMP_COL_NULL, Type.timestamp()),
            StructField.of(TIMESTAMP_COL_NOT_NULL, Type.timestamp()),
            StructField.of(TIME_COL_NULL, Type.timestamp()),
            StructField.of(TIME_COL_NOT_NULL, Type.timestamp()),
            StructField.of(ARRAY_COL_NULL, Type.array(Type.int64())),
            StructField.of(ARRAY_COL_NOT_NULL, Type.array(Type.int64())),
            StructField.of(URL_COL_NULL, Type.string()),
            StructField.of(URL_COL_NOT_NULL, Type.string())),
        Arrays.asList(
            Struct.newBuilder()
                .set(STRING_COL_NULL)
                .to((String) null)
                .set(STRING_COL_NOT_NULL)
                .to(STRING_VALUE)
                .set(BOOLEAN_COL_NULL)
                .to((Boolean) null)
                .set(BOOLEAN_COL_NOT_NULL)
                .to(BOOLEAN_VALUE)
                .set(DOUBLE_COL_NULL)
                .to((Double) null)
                .set(DOUBLE_COL_NOT_NULL)
                .to(DOUBLE_VALUE)
                .set(BYTES_COL_NULL)
                .to((ByteArray) null)
                .set(BYTES_COL_NOT_NULL)
                .to(BYTES_VALUE)
                .set(LONG_COL_NULL)
                .to((Long) null)
                .set(LONG_COL_NOT_NULL)
                .to(LONG_VALUE)
                .set(DATE_COL_NULL)
                .to((Date) null)
                .set(DATE_COL_NOT_NULL)
                .to(DATE_VALUE)
                .set(TIMESTAMP_COL_NULL)
                .to((Timestamp) null)
                .set(TIMESTAMP_COL_NOT_NULL)
                .to(TIMESTAMP_VALUE)
                .set(TIME_COL_NULL)
                .to((Timestamp) null)
                .set(TIME_COL_NOT_NULL)
                .to(TIME_VALUE)
                .set(ARRAY_COL_NULL)
                .toInt64Array((long[]) null)
                .set(ARRAY_COL_NOT_NULL)
                .toInt64Array(ARRAY_VALUE)
                .set(URL_COL_NULL)
                .to((String) null)
                .set(URL_COL_NOT_NULL)
                .to(URL_VALUE)
                .build()));
  }

  public JdbcResultSetTest() throws SQLException {
    subject = JdbcResultSet.of(mock(Statement.class), getMockResultSet());
    subject.next();
  }

  @Test
  public void testWasNull() throws SQLException {
    String value = subject.getString(STRING_COL_NULL);
    boolean wasNull = subject.wasNull();
    assertTrue(wasNull);
    assertNull(value);
    String valueNotNull = subject.getString(STRING_COL_NOT_NULL);
    boolean wasNotNull = subject.wasNull();
    assertFalse(wasNotNull);
    assertNotNull(valueNotNull);
  }

  @Test
  public void testNext() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      assertTrue(rs.isBeforeFirst());
      assertFalse(rs.isAfterLast());
      int num = 0;
      while (rs.next()) {
        num++;
      }
      assertTrue(num > 0);
      assertFalse(rs.isBeforeFirst());
      assertTrue(rs.isAfterLast());
    }
  }

  @Test
  public void testClose() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      assertFalse(rs.isClosed());
      rs.next();
      assertNotNull(rs.getString(STRING_COL_NOT_NULL));
      rs.close();
      assertTrue(rs.isClosed());
      boolean failed = false;
      try {
        // Should fail
        rs.getString(STRING_COL_NOT_NULL);
      } catch (SQLException e) {
        failed = true;
      }
      assertTrue(failed);
    }
  }

  @Test
  public void testGetStringIndex() throws SQLException {
    assertNotNull(subject.getString(STRING_COLINDEX_NOTNULL));
    assertEquals(STRING_VALUE, subject.getString(STRING_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetNStringIndex() throws SQLException {
    assertNotNull(subject.getNString(STRING_COLINDEX_NOTNULL));
    assertEquals(STRING_VALUE, subject.getNString(STRING_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getNString(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetURLIndex() throws SQLException, MalformedURLException {
    assertNotNull(subject.getURL(URL_COLINDEX_NOTNULL));
    assertEquals(new URL(URL_VALUE), subject.getURL(URL_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getURL(URL_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetURLIndexInvalid() throws SQLException, MalformedURLException {
    thrown.expect(JdbcSqlExceptionImpl.class);
    thrown.expectMessage("Invalid URL");
    assertNotNull(subject.getURL(STRING_COLINDEX_NOTNULL));
  }

  @Test
  public void testGetBooleanIndex() throws SQLException {
    assertNotNull(subject.getBoolean(BOOLEAN_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertFalse(subject.getBoolean(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetLongIndex() throws SQLException {
    assertNotNull(subject.getLong(LONG_COLINDEX_NOTNULL));
    assertEquals(LONG_VALUE, subject.getLong(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0l, subject.getLong(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDoubleIndex() throws SQLException {
    assertNotNull(subject.getDouble(DOUBLE_COLINDEX_NOTNULL));
    assertEquals(DOUBLE_VALUE, subject.getDouble(DOUBLE_COLINDEX_NOTNULL), 0d);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getDouble(DOUBLE_COLINDEX_NULL), 0d);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBigDecimalIndexAndScale() throws SQLException {
    assertNotNull(subject.getBigDecimal(DOUBLE_COLINDEX_NOTNULL, 2));
    assertEquals(
        BigDecimal.valueOf(DOUBLE_VALUE).setScale(2, RoundingMode.HALF_UP),
        subject.getBigDecimal(DOUBLE_COLINDEX_NOTNULL, 2));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(DOUBLE_COLINDEX_NULL, 2));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBytesIndex() throws SQLException {
    assertNotNull(subject.getBytes(BYTES_COLINDEX_NOTNULL));
    assertArrayEquals(BYTES_VALUE.toByteArray(), subject.getBytes(BYTES_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBytes(BYTES_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetDateIndex() throws SQLException {
    assertNotNull(subject.getDate(DATE_COLINDEX_NOTNULL));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getDate(DATE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getDate(DATE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimeIndex() throws SQLException {
    assertNotNull(subject.getTime(TIME_COLINDEX_NOTNULL));
    assertEquals(
        new Time(TIME_VALUE.toSqlTimestamp().getTime()), subject.getTime(TIME_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getTime(TIME_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimestampIndex() throws SQLException {
    assertNotNull(subject.getTimestamp(TIMESTAMP_COLINDEX_NOTNULL));
    assertEquals(
        TIMESTAMP_VALUE.toSqlTimestamp(), subject.getTimestamp(TIMESTAMP_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(TIMESTAMP_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringLabel() throws SQLException {
    assertNotNull(subject.getString(STRING_COL_NOT_NULL));
    assertEquals("FOO", subject.getString(STRING_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(STRING_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetNStringLabel() throws SQLException {
    assertNotNull(subject.getNString(STRING_COL_NOT_NULL));
    assertEquals("FOO", subject.getNString(STRING_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getNString(STRING_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetURLLabel() throws SQLException {
    assertNotNull(subject.getString(URL_COL_NOT_NULL));
    assertEquals(URL_VALUE, subject.getString(URL_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(URL_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetURLLabelInvalid() throws SQLException {
    thrown.expect(JdbcSqlExceptionImpl.class);
    thrown.expectMessage("Invalid URL");
    assertNotNull(subject.getURL(STRING_COL_NOT_NULL));
  }

  @Test
  public void testGetBooleanLabel() throws SQLException {
    assertNotNull(subject.getBoolean(BOOLEAN_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertFalse(subject.getBoolean(BOOLEAN_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetLongLabel() throws SQLException {
    assertNotNull(subject.getLong(LONG_COL_NOT_NULL));
    assertEquals(1l, subject.getLong(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0l, subject.getLong(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDoubleLabel() throws SQLException {
    assertNotNull(subject.getDouble(DOUBLE_COL_NOT_NULL));
    assertEquals(DOUBLE_VALUE, subject.getDouble(DOUBLE_COL_NOT_NULL), 0d);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getDouble(DOUBLE_COL_NULL), 0d);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBigDecimalLabelAndScale() throws SQLException {
    assertNotNull(subject.getBigDecimal(DOUBLE_COL_NOT_NULL, 2));
    assertEquals(BigDecimal.valueOf(3.14d), subject.getBigDecimal(DOUBLE_COL_NOT_NULL, 2));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(DOUBLE_COL_NULL, 2));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBytesLabel() throws SQLException {
    assertNotNull(subject.getBytes(BYTES_COL_NOT_NULL));
    assertArrayEquals(
        ByteArray.copyFrom("FOO").toByteArray(), subject.getBytes(BYTES_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBytes(BYTES_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetDateLabel() throws SQLException {
    assertNotNull(subject.getDate(DATE_COL_NOT_NULL));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getDate(DATE_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getDate(DATE_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimeLabel() throws SQLException {
    assertNotNull(subject.getTime(TIME_COL_NOT_NULL));
    assertEquals(
        new Time(TIME_VALUE.toSqlTimestamp().getTime()), subject.getTime(TIME_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getTime(TIME_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimestampLabel() throws SQLException {
    assertNotNull(subject.getTime(TIMESTAMP_COL_NOT_NULL));
    assertEquals(TIMESTAMP_VALUE.toSqlTimestamp(), subject.getTimestamp(TIMESTAMP_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(TIMESTAMP_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetMetaData() throws SQLException {
    JdbcResultSetMetaData metadata = subject.getMetaData();
    assertNotNull(metadata);
  }

  @Test
  public void testFindColumn() throws SQLException {
    assertEquals(2, subject.findColumn(STRING_COL_NOT_NULL));
  }

  @Test
  public void testGetBigDecimalIndex() throws SQLException {
    assertNotNull(subject.getBigDecimal(DOUBLE_COLINDEX_NOTNULL));
    assertEquals(BigDecimal.valueOf(DOUBLE_VALUE), subject.getBigDecimal(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBigDecimalLabel() throws SQLException {
    assertNotNull(subject.getBigDecimal(DOUBLE_COL_NOT_NULL));
    assertEquals(BigDecimal.valueOf(DOUBLE_VALUE), subject.getBigDecimal(DOUBLE_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(DOUBLE_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStatement() throws SQLException {
    assertNotNull(subject.getStatement());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetDateIndexCalendar() throws SQLException {
    Calendar cal = Calendar.getInstance();
    assertNotNull(subject.getDate(DATE_COLINDEX_NOTNULL, cal));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getDate(DATE_COLINDEX_NOTNULL, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getDate(DATE_COLINDEX_NULL, cal));
    assertTrue(subject.wasNull());

    Calendar calGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    Calendar expectedCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    expectedCal.clear();
    expectedCal.set(DATE_VALUE.getYear(), DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth());
    java.sql.Date expected = new java.sql.Date(expectedCal.getTimeInMillis());
    assertEquals(expected, subject.getDate(DATE_COLINDEX_NOTNULL, calGMT));
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetDateLabelCalendar() throws SQLException {
    Calendar cal = Calendar.getInstance();
    assertNotNull(subject.getDate(DATE_COL_NOT_NULL, cal));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getDate(DATE_COL_NOT_NULL, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getDate(DATE_COL_NULL, cal));
    assertTrue(subject.wasNull());

    Calendar calGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    Calendar expected = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    expected.set(
        DATE_VALUE.getYear(), DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth(), 0, 0, 0);
    expected.clear(Calendar.MILLISECOND);
    assertEquals(
        new java.sql.Date(expected.getTimeInMillis()), subject.getDate(DATE_COL_NOT_NULL, calGMT));
  }

  @Test
  public void testGetTimeIndexCalendar() throws SQLException {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    assertNotNull(subject.getTime(TIME_COLINDEX_NOTNULL, cal));
    assertEquals(
        new Time(TIME_VALUE.toSqlTimestamp().getTime()),
        subject.getTime(TIME_COLINDEX_NOTNULL, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getTime(TIME_COLINDEX_NULL, cal));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimeLabelCalendar() throws SQLException {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    assertNotNull(subject.getTime(TIME_COL_NOT_NULL, cal));
    assertEquals(
        new Time(TIME_VALUE.toSqlTimestamp().getTime()), subject.getTime(TIME_COL_NOT_NULL, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getTime(TIME_COL_NULL, cal));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimestampIndexCalendar() throws SQLException {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    assertNotNull(subject.getTimestamp(TIMESTAMP_COLINDEX_NOTNULL, cal));
    assertEquals(
        TIMESTAMP_VALUE.toSqlTimestamp(), subject.getTimestamp(TIMESTAMP_COLINDEX_NOTNULL, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(TIMESTAMP_COLINDEX_NULL, cal));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimestampLabelCalendar() throws SQLException {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    assertNotNull(subject.getTimestamp(TIMESTAMP_COL_NOT_NULL, cal));
    assertEquals(
        TIMESTAMP_VALUE.toSqlTimestamp(), subject.getTimestamp(TIMESTAMP_COL_NOT_NULL, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(TIMESTAMP_COL_NULL, cal));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testIsClosed() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      assertFalse(rs.isClosed());
      rs.close();
      assertTrue(rs.isClosed());
    }
  }

  @Test
  public void testGetByteIndex() throws SQLException {
    assertNotNull(subject.getByte(LONG_COLINDEX_NOTNULL));
    assertEquals(LONG_VALUE, subject.getByte(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getByte(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetShortIndex() throws SQLException {
    assertNotNull(subject.getShort(LONG_COLINDEX_NOTNULL));
    assertEquals(LONG_VALUE, subject.getShort(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getShort(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetIntIndex() throws SQLException {
    assertNotNull(subject.getInt(LONG_COLINDEX_NOTNULL));
    int expected = (int) LONG_VALUE;
    assertEquals(expected, subject.getInt(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getInt(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetFloatIndex() throws SQLException {
    assertNotNull(subject.getFloat(DOUBLE_COLINDEX_NOTNULL));
    float expected = (float) DOUBLE_VALUE;
    assertEquals(expected, subject.getFloat(DOUBLE_COLINDEX_NOTNULL), 0f);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getFloat(DOUBLE_COLINDEX_NULL), 0f);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetByteLabel() throws SQLException {
    assertNotNull(subject.getByte(LONG_COL_NOT_NULL));
    assertEquals(1, subject.getByte(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getByte(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetShortLabel() throws SQLException {
    assertNotNull(subject.getShort(LONG_COL_NOT_NULL));
    assertEquals(1, subject.getShort(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getShort(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetIntLabel() throws SQLException {
    assertNotNull(subject.getInt(LONG_COL_NOT_NULL));
    assertEquals(1, subject.getInt(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getInt(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetFloatLabel() throws SQLException {
    assertNotNull(subject.getFloat(DOUBLE_COL_NOT_NULL));
    float expected = (float) DOUBLE_VALUE;
    assertEquals(expected, subject.getFloat(DOUBLE_COL_NOT_NULL), 0f);
    assertFalse(subject.wasNull());
    assertEquals(0f, subject.getFloat(DOUBLE_COL_NULL), 0f);
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetObjectLabel() throws SQLException {
    assertNotNull(subject.getObject(DATE_COL_NOT_NULL));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getObject(DATE_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(DATE_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetObjectIndex() throws SQLException {
    assertNotNull(subject.getObject(DATE_COLINDEX_NOTNULL));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getObject(DATE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(DATE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetObjectLabelMap() throws SQLException {
    Map<String, Class<?>> map = new HashMap<>();
    assertNotNull(subject.getObject(DATE_COL_NOT_NULL, map));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getObject(DATE_COL_NOT_NULL, map));
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(DATE_COL_NULL, map));
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetObjectIndexMap() throws SQLException {
    Map<String, Class<?>> map = Collections.emptyMap();
    assertNotNull(subject.getObject(DATE_COLINDEX_NOTNULL, map));
    assertEquals(
        new java.sql.Date(
            DATE_VALUE.getYear() - 1900, DATE_VALUE.getMonth() - 1, DATE_VALUE.getDayOfMonth()),
        subject.getObject(DATE_COLINDEX_NOTNULL, map));
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(DATE_COLINDEX_NULL, map));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetArrayLabel() throws SQLException {
    assertNotNull(subject.getArray(ARRAY_COL_NOT_NULL));
    assertEquals(
        JdbcArray.createArray(JdbcDataType.INT64, Arrays.asList(1L, 2L, 3L)),
        subject.getArray(ARRAY_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getArray(ARRAY_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetArrayIndex() throws SQLException {
    assertNotNull(subject.getArray(ARRAY_COLINDEX_NOTNULL));
    assertEquals(
        JdbcArray.createArray(JdbcDataType.INT64, Arrays.asList(1L, 2L, 3L)),
        subject.getArray(ARRAY_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getArray(ARRAY_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetWarnings() throws SQLException {
    assertNull(subject.getWarnings());
  }

  @Test
  public void testClearWarnings() throws SQLException {
    subject.clearWarnings();
  }

  @Test
  public void testIsBeforeFirst() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      assertTrue(rs.isBeforeFirst());
      rs.next();
      assertFalse(rs.isBeforeFirst());
    }
  }

  @Test
  public void testIsAfterLast() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      assertFalse(rs.isAfterLast());
      while (rs.next()) {
        // do nothing
      }
      assertTrue(rs.isAfterLast());
    }
  }

  @Test
  public void testGetCharacterStreamIndex() throws SQLException, IOException {
    assertNotNull(subject.getCharacterStream(STRING_COLINDEX_NOTNULL));
    Reader actual = subject.getCharacterStream(STRING_COLINDEX_NOTNULL);
    char[] cbuf = new char[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(STRING_VALUE, new String(cbuf, 0, len));
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getCharacterStream(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetCharacterStreamLabel() throws SQLException, IOException {
    assertNotNull(subject.getCharacterStream(STRING_COL_NOT_NULL));
    Reader actual = subject.getCharacterStream(STRING_COL_NOT_NULL);
    char[] cbuf = new char[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals("FOO", new String(cbuf, 0, len));
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getCharacterStream(STRING_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetNCharacterStreamIndex() throws SQLException, IOException {
    assertNotNull(subject.getNCharacterStream(STRING_COLINDEX_NOTNULL));
    Reader actual = subject.getNCharacterStream(STRING_COLINDEX_NOTNULL);
    char[] cbuf = new char[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(STRING_VALUE, new String(cbuf, 0, len));
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getNCharacterStream(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetNCharacterStreamLabel() throws SQLException, IOException {
    assertNotNull(subject.getNCharacterStream(STRING_COL_NOT_NULL));
    Reader actual = subject.getNCharacterStream(STRING_COL_NOT_NULL);
    char[] cbuf = new char[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals("FOO", new String(cbuf, 0, len));
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getNCharacterStream(STRING_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetAsciiStreamIndex() throws SQLException, IOException {
    assertNotNull(subject.getAsciiStream(STRING_COLINDEX_NOTNULL));
    InputStream actual = subject.getAsciiStream(STRING_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(STRING_VALUE, new String(cbuf, 0, len, StandardCharsets.US_ASCII));
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getAsciiStream(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetUnicodeStreamIndex() throws SQLException, IOException {
    assertNotNull(subject.getUnicodeStream(STRING_COLINDEX_NOTNULL));
    InputStream actual = subject.getUnicodeStream(STRING_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(STRING_VALUE, new String(cbuf, 0, len, StandardCharsets.UTF_16LE));
    assertEquals(6, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getUnicodeStream(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBinaryStreamIndex() throws SQLException, IOException {
    assertNotNull(subject.getBinaryStream(BYTES_COLINDEX_NOTNULL));
    InputStream actual = subject.getBinaryStream(BYTES_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[3];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertArrayEquals(BYTES_VALUE.toByteArray(), cbuf);
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getUnicodeStream(BYTES_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetAsciiStreamLabel() throws SQLException, IOException {
    assertNotNull(subject.getAsciiStream(STRING_COL_NOT_NULL));
    InputStream actual = subject.getAsciiStream(STRING_COL_NOT_NULL);
    byte[] cbuf = new byte[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals("FOO", new String(cbuf, 0, len, StandardCharsets.US_ASCII));
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getAsciiStream(STRING_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetUnicodeStreamLabel() throws SQLException, IOException {
    assertNotNull(subject.getUnicodeStream(STRING_COL_NOT_NULL));
    InputStream actual = subject.getUnicodeStream(STRING_COL_NOT_NULL);
    byte[] cbuf = new byte[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals("FOO", new String(cbuf, 0, len, StandardCharsets.UTF_16LE));
    assertEquals(6, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getUnicodeStream(STRING_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBinaryStreamLabel() throws SQLException, IOException {
    assertNotNull(subject.getBinaryStream(BYTES_COL_NOT_NULL));
    InputStream actual = subject.getBinaryStream(BYTES_COL_NOT_NULL);
    byte[] cbuf = new byte[3];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertArrayEquals(ByteArray.copyFrom("FOO").toByteArray(), cbuf);
    assertEquals(3, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getUnicodeStream(BYTES_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBeforeNext() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      thrown.expect(SQLException.class);
      thrown.expectMessage(
          "FAILED_PRECONDITION: ResultSet is before first row. Call next() first.");
      rs.getBigDecimal(LONG_COLINDEX_NOTNULL);
    }
  }

  @Test
  public void testGetAfterLast() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      while (rs.next()) {
        // do nothing
      }
      thrown.expect(SQLException.class);
      thrown.expectMessage(
          "FAILED_PRECONDITION: ResultSet is after last row. There is no more data available.");
      rs.getBigDecimal(LONG_COLINDEX_NOTNULL);
    }
  }

  @Test
  public void testFindIllegalColumnName() throws SQLException {
    thrown.expect(SQLException.class);
    thrown.expectMessage("INVALID_ARGUMENT: no column with label " + UNKNOWN_COLUMN + " found");
    int index = subject.findColumn(UNKNOWN_COLUMN);
    assertEquals(0, index);
  }

  @Test
  public void testGetRowAndIsFirst() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      int row = 0;
      while (rs.next()) {
        row++;
        assertEquals(row, rs.getRow());
        assertEquals(row == 1, rs.isFirst());
      }
    }
  }

  @Test
  public void testGetHoldability() throws SQLException {
    assertEquals(java.sql.ResultSet.CLOSE_CURSORS_AT_COMMIT, subject.getHoldability());
  }
}

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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.cloud.spanner.jdbc.it.SingerProto.Genre;
import com.google.cloud.spanner.jdbc.it.SingerProto.SingerInfo;
import com.google.common.collect.ImmutableList;
import com.google.rpc.Code;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.junit.Test;
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

  private static final String STRING_COL_NUMBER = "STRING_COL_NUMBER";
  private static final int STRING_COLINDEX_NUMBER = 21;
  private static final String STRING_NUMBER_VALUE = "123";
  private static final String STRING_COL_DATE = "STRING_COL_DATE";
  private static final int STRING_COLINDEX_DATE = 22;
  private static final String STRING_DATE_VALUE = "2020-06-01";
  private static final String STRING_COL_TIMESTAMP = "STRING_COL_TIMESTAMP";
  private static final int STRING_COLINDEX_TIMESTAMP = 23;
  private static final String STRING_TIMESTAMP_VALUE = "2020-06-01T10:31:15.123Z";
  private static final String STRING_COL_TIME = "STRING_COL_TIME";
  private static final int STRING_COLINDEX_TIME = 24;
  private static final String STRING_TIME_VALUE = "10:31:15";
  private static final String NUMERIC_COL_NULL = "NUMERIC_COL_NULL";
  private static final String NUMERIC_COL_NOT_NULL = "NUMERIC_COL_NOT_NULL";
  private static final BigDecimal NUMERIC_VALUE = new BigDecimal("3.14");
  private static final int NUMERIC_COLINDEX_NULL = 25;
  private static final int NUMERIC_COLINDEX_NOTNULL = 26;
  private static final String PG_NUMERIC_COL_NULL = "PG_NUMERIC_COL_NULL";
  private static final String PG_NUMERIC_COL_NOT_NULL = "PG_NUMERIC_COL_NOT_NULL";
  private static final String PG_NUMERIC_COL_NAN = "PG_NUMERIC_COL_NAN";
  private static final int PG_NUMERIC_COLINDEX_NULL = 44;
  private static final int PG_NUMERIC_COLINDEX_NOTNULL = 45;
  private static final int PG_NUMERIC_COLINDEX_NAN = 46;
  private static final String JSON_COL_NULL = "JSON_COL_NULL";
  private static final String JSON_COL_NOT_NULL = "JSON_COL_NOT_NULL";
  private static final int JSON_COLINDEX_NULL = 27;
  private static final int JSON_COLINDEX_NOT_NULL = 28;
  private static final String JSON_VALUE = "{\"name\":\"John\", \"age\":30, \"car\":null}";

  private static final String PROTO_MSG_COL_NULL = "PROTO_MSG_COL_NULL";
  private static final String PROTO_MSG_COL_NOT_NULL = "PROTO_MSG_COL_NOT_NULL";
  private static final int PROTO_MSG_COLINDEX_NULL = 29;
  private static final int PROTO_MSG_COLINDEX_NOT_NULL = 30;
  private static final ByteArray PROTO_MSG_VALUE =
      ByteArray.copyFrom(SingerInfo.newBuilder().setSingerId(1).build().toByteArray());
  private static final String PROTO_ENUM_COL_NULL = "PROTO_ENUM_COL_NULL";
  private static final String PROTO_ENUM_COL_NOT_NULL = "PROTO_ENUM_COL_NOT_NULL";
  private static final int PROTO_ENUM_COLINDEX_NULL = 31;
  private static final int PROTO_ENUM_COLINDEX_NOT_NULL = 32;
  private static final long PROTO_ENUM_VALUE = Genre.ROCK.getNumber();

  private static final String BOOL_ARRAY_COL = "BOOL_ARRAY";
  private static final List<Boolean> BOOL_ARRAY_VALUE = Arrays.asList(true, null, false);
  private static final String BYTES_ARRAY_COL = "BYTES_ARRAY";
  private static final List<ByteArray> BYTES_ARRAY_VALUE = Arrays.asList(BYTES_VALUE, null);
  private static final String DATE_ARRAY_COL = "DATE_ARRAY";
  private static final List<Date> DATE_ARRAY_VALUE = Arrays.asList(DATE_VALUE, null);
  private static final String FLOAT64_ARRAY_COL = "FLOAT64_ARRAY";
  private static final List<Double> FLOAT64_ARRAY_VALUE = Arrays.asList(DOUBLE_VALUE, null);
  private static final String INT64_ARRAY_COL = "INT64_ARRAY";
  private static final List<Long> INT64_ARRAY_VALUE = Arrays.asList(LONG_VALUE, null);
  private static final String NUMERIC_ARRAY_COL = "NUMERIC_ARRAY";
  private static final List<BigDecimal> NUMERIC_ARRAY_VALUE = Arrays.asList(NUMERIC_VALUE, null);
  private static final String STRING_ARRAY_COL = "STRING_ARRAY";
  private static final List<String> STRING_ARRAY_VALUE = Arrays.asList(STRING_VALUE, null);
  private static final String TIMESTAMP_ARRAY_COL = "TIMESTAMP_ARRAY";
  private static final List<Timestamp> TIMESTAMP_ARRAY_VALUE = Arrays.asList(TIMESTAMP_VALUE, null);
  private static final String JSON_ARRAY_COL = "JSON_ARRAY";
  private static final List<String> JSON_ARRAY_VALUE = Arrays.asList(JSON_VALUE, null);
  private static final String PROTO_MSG_ARRAY_COL = "PROTO_MSG_ARRAY";
  private static final List<ByteArray> PROTO_MSG_ARRAY_VALUE = Arrays.asList(PROTO_MSG_VALUE, null);
  private static final String PROTO_ENUM_ARRAY_COL = "PROTO_ENUM_ARRAY";
  private static final List<Long> PROTO_ENUM_ARRAY_VALUE = Arrays.asList(PROTO_ENUM_VALUE, null);

  private final JdbcResultSet subject;

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
            StructField.of(URL_COL_NOT_NULL, Type.string()),
            StructField.of(STRING_COL_NUMBER, Type.string()),
            StructField.of(STRING_COL_DATE, Type.string()),
            StructField.of(STRING_COL_TIMESTAMP, Type.string()),
            StructField.of(STRING_COL_TIME, Type.string()),
            StructField.of(NUMERIC_COL_NULL, Type.numeric()),
            StructField.of(NUMERIC_COL_NOT_NULL, Type.numeric()),
            StructField.of(JSON_COL_NULL, Type.json()),
            StructField.of(JSON_COL_NOT_NULL, Type.json()),
            StructField.of(
                PROTO_MSG_COL_NULL, Type.proto(SingerInfo.getDescriptor().getFullName())),
            StructField.of(
                PROTO_MSG_COL_NOT_NULL, Type.proto(SingerInfo.getDescriptor().getFullName())),
            StructField.of(
                PROTO_ENUM_COL_NULL, Type.protoEnum(Genre.getDescriptor().getFullName())),
            StructField.of(
                PROTO_ENUM_COL_NOT_NULL, Type.protoEnum(Genre.getDescriptor().getFullName())),
            StructField.of(BOOL_ARRAY_COL, Type.array(Type.bool())),
            StructField.of(BYTES_ARRAY_COL, Type.array(Type.bytes())),
            StructField.of(DATE_ARRAY_COL, Type.array(Type.date())),
            StructField.of(FLOAT64_ARRAY_COL, Type.array(Type.float64())),
            StructField.of(INT64_ARRAY_COL, Type.array(Type.int64())),
            StructField.of(NUMERIC_ARRAY_COL, Type.array(Type.numeric())),
            StructField.of(JSON_ARRAY_COL, Type.array(Type.json())),
            StructField.of(STRING_ARRAY_COL, Type.array(Type.string())),
            StructField.of(TIMESTAMP_ARRAY_COL, Type.array(Type.timestamp())),
            StructField.of(
                PROTO_MSG_ARRAY_COL,
                Type.array(Type.proto(SingerInfo.getDescriptor().getFullName()))),
            StructField.of(
                PROTO_ENUM_ARRAY_COL,
                Type.array(Type.protoEnum(Genre.getDescriptor().getFullName()))),
            StructField.of(PG_NUMERIC_COL_NULL, Type.pgNumeric()),
            StructField.of(PG_NUMERIC_COL_NOT_NULL, Type.pgNumeric()),
            StructField.of(PG_NUMERIC_COL_NAN, Type.pgNumeric())),
        Collections.singletonList(
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
                .set(STRING_COL_NUMBER)
                .to(STRING_NUMBER_VALUE)
                .set(STRING_COL_DATE)
                .to(STRING_DATE_VALUE)
                .set(STRING_COL_TIMESTAMP)
                .to(STRING_TIMESTAMP_VALUE)
                .set(STRING_COL_TIME)
                .to(STRING_TIME_VALUE)
                .set(NUMERIC_COL_NULL)
                .to((BigDecimal) null)
                .set(NUMERIC_COL_NOT_NULL)
                .to(NUMERIC_VALUE)
                .set(JSON_COL_NULL)
                .to(Value.json(null))
                .set(JSON_COL_NOT_NULL)
                .to(Value.json(JSON_VALUE))
                .set(PROTO_MSG_COL_NULL)
                .to((ByteArray) null, SingerInfo.getDescriptor().getFullName())
                .set(PROTO_MSG_COL_NOT_NULL)
                .to(PROTO_MSG_VALUE, SingerInfo.getDescriptor().getFullName())
                .set(PROTO_ENUM_COL_NULL)
                .to((Long) null, Genre.getDescriptor().getFullName())
                .set(PROTO_ENUM_COL_NOT_NULL)
                .to(PROTO_ENUM_VALUE, Genre.getDescriptor().getFullName())
                .set(BOOL_ARRAY_COL)
                .toBoolArray(BOOL_ARRAY_VALUE)
                .set(BYTES_ARRAY_COL)
                .toBytesArray(BYTES_ARRAY_VALUE)
                .set(DATE_ARRAY_COL)
                .toDateArray(DATE_ARRAY_VALUE)
                .set(FLOAT64_ARRAY_COL)
                .toFloat64Array(FLOAT64_ARRAY_VALUE)
                .set(INT64_ARRAY_COL)
                .toInt64Array(INT64_ARRAY_VALUE)
                .set(NUMERIC_ARRAY_COL)
                .toNumericArray(NUMERIC_ARRAY_VALUE)
                .set(JSON_ARRAY_COL)
                .toJsonArray(JSON_ARRAY_VALUE)
                .set(STRING_ARRAY_COL)
                .toStringArray(STRING_ARRAY_VALUE)
                .set(TIMESTAMP_ARRAY_COL)
                .toTimestampArray(TIMESTAMP_ARRAY_VALUE)
                .set(PROTO_MSG_ARRAY_COL)
                .toProtoMessageArray(
                    PROTO_MSG_ARRAY_VALUE, SingerInfo.getDescriptor().getFullName())
                .set(PROTO_ENUM_ARRAY_COL)
                .toProtoEnumArray(PROTO_ENUM_ARRAY_VALUE, Genre.getDescriptor().getFullName())
                .set(PG_NUMERIC_COL_NULL)
                .to(Value.pgNumeric((String) null))
                .set(PG_NUMERIC_COL_NOT_NULL)
                .to(Value.pgNumeric("3.14"))
                .set(PG_NUMERIC_COL_NAN)
                .to(Value.pgNumeric("NaN"))
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
  public void testGetJsonIndex() throws SQLException {
    assertNotNull(subject.getString(JSON_COLINDEX_NOT_NULL));
    assertEquals(JSON_VALUE, subject.getString(JSON_COLINDEX_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(JSON_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringIndexForBool() throws SQLException {
    assertNotNull(subject.getString(BOOLEAN_COLINDEX_NOTNULL));
    assertEquals(String.valueOf(BOOLEAN_VALUE), subject.getString(BOOLEAN_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringIndexForInt64() throws SQLException {
    assertNotNull(subject.getString(LONG_COLINDEX_NOTNULL));
    assertEquals(String.valueOf(LONG_VALUE), subject.getString(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringIndexForFloat64() throws SQLException {
    assertNotNull(subject.getString(DOUBLE_COLINDEX_NOTNULL));
    assertEquals(String.valueOf(DOUBLE_VALUE), subject.getString(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringIndexForBytes() throws SQLException {
    assertNotNull(subject.getString(BYTES_COLINDEX_NOTNULL));
    assertEquals(BYTES_VALUE.toBase64(), subject.getString(BYTES_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(BYTES_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringIndexForDate() throws SQLException {
    assertNotNull(subject.getString(DATE_COLINDEX_NOTNULL));
    assertEquals(String.valueOf(DATE_VALUE), subject.getString(DATE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(DATE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringIndexForTimestamp() throws SQLException {
    assertNotNull(subject.getString(TIMESTAMP_COLINDEX_NOTNULL));
    assertEquals(String.valueOf(TIMESTAMP_VALUE), subject.getString(TIMESTAMP_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getString(TIMESTAMP_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetStringIndexForArray() {
    try {
      subject.getString(ARRAY_COLINDEX_NOTNULL);
      fail("missing SQLException");
    } catch (SQLException e) {
      assertTrue(e instanceof JdbcSqlException);
      JdbcSqlException jse = (JdbcSqlException) e;
      assertEquals(jse.getCode(), Code.INVALID_ARGUMENT);
    }
  }

  @Test
  public void testGetStringIndexForNullArray() {
    try {
      subject.getString(ARRAY_COLINDEX_NULL);
      fail("missing SQLException");
    } catch (SQLException e) {
      assertTrue(e instanceof JdbcSqlException);
      JdbcSqlException jse = (JdbcSqlException) e;
      assertEquals(jse.getCode(), Code.INVALID_ARGUMENT);
    }
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
  public void testGetURLIndexInvalid() throws SQLException {
    JdbcSqlExceptionImpl sqlException =
        assertThrows(JdbcSqlExceptionImpl.class, () -> subject.getURL(STRING_COLINDEX_NOTNULL));
    assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
    assertTrue(
        sqlException.getMessage(),
        sqlException
            .getMessage()
            .contains("Invalid URL: " + subject.getString(STRING_COLINDEX_NOTNULL)));
  }

  @Test
  public void testGetBooleanIndex() throws SQLException {
    assertTrue(subject.getBoolean(BOOLEAN_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertFalse(subject.getBoolean(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBooleanIndexForLong() throws SQLException {
    assertTrue(subject.getBoolean(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertFalse(subject.getBoolean(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBooleanIndexForDouble() throws SQLException {
    assertTrue(subject.getBoolean(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertFalse(subject.getBoolean(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBooleanIndexForString() throws SQLException {
    assertFalse(subject.getBoolean(STRING_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertFalse(subject.getBoolean(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBooleanIndexForDate() {
    SQLException e =
        assertThrows(SQLException.class, () -> subject.getBoolean(DATE_COLINDEX_NOTNULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());

    e = assertThrows(SQLException.class, () -> subject.getBoolean(DATE_COLINDEX_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetNullBooleanIndex() throws SQLException {
    assertFalse(subject.getBoolean(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertFalse(subject.getBoolean(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertFalse(subject.getBoolean(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetLongIndex() throws SQLException {
    assertEquals(1L, subject.getLong(LONG_COLINDEX_NOTNULL));
    assertEquals(LONG_VALUE, subject.getLong(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0L, subject.getLong(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetLongIndexForBool() throws SQLException {
    assertEquals(1L, subject.getLong(BOOLEAN_COLINDEX_NOTNULL));
    assertEquals(BOOLEAN_VALUE ? 1L : 0L, subject.getLong(BOOLEAN_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0L, subject.getLong(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetLongIndexForFloat64() throws SQLException {
    assertEquals(3L, subject.getLong(DOUBLE_COLINDEX_NOTNULL));
    assertEquals((long) DOUBLE_VALUE, subject.getLong(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0L, subject.getLong(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetIntegerTypesOnNumeric() throws SQLException {
    assertEquals((byte) 0, subject.getByte(NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals((byte) 3, subject.getByte(NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());

    assertEquals((short) 0, subject.getShort(NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals((short) 3, subject.getShort(NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());

    assertEquals(0, subject.getInt(NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(3, subject.getInt(NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());

    assertEquals(0L, subject.getLong(NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(3L, subject.getLong(NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetIntegerTypesOnPgNumeric() throws SQLException {
    assertEquals((byte) 0, subject.getByte(PG_NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals((byte) 3, subject.getByte(PG_NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());

    assertEquals((short) 0, subject.getShort(PG_NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals((short) 3, subject.getShort(PG_NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());

    assertEquals(0, subject.getInt(PG_NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(3, subject.getInt(PG_NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());

    assertEquals(0L, subject.getLong(PG_NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(3L, subject.getLong(PG_NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetIntegerTypesOnPgNumericNaN() throws SQLException {
    assertTrue(Double.isNaN(subject.getDouble(PG_NUMERIC_COLINDEX_NAN)));
    assertTrue(Float.isNaN(subject.getFloat(PG_NUMERIC_COLINDEX_NAN)));
    assertEquals("NaN", subject.getString(PG_NUMERIC_COLINDEX_NAN));
    SQLException e =
        assertThrows(SQLException.class, () -> subject.getByte(PG_NUMERIC_COLINDEX_NAN));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());

    e = assertThrows(SQLException.class, () -> subject.getShort(PG_NUMERIC_COLINDEX_NAN));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());

    e = assertThrows(SQLException.class, () -> subject.getInt(PG_NUMERIC_COLINDEX_NAN));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());

    e = assertThrows(SQLException.class, () -> subject.getLong(PG_NUMERIC_COLINDEX_NAN));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());

    e = assertThrows(SQLException.class, () -> subject.getBigDecimal(PG_NUMERIC_COLINDEX_NAN));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetLongIndexForString() {
    SQLException e =
        assertThrows(SQLException.class, () -> subject.getLong(STRING_COLINDEX_NOTNULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetLongIndexForNumberString() throws SQLException {
    assertEquals(
        Long.valueOf(STRING_NUMBER_VALUE).longValue(), subject.getLong(STRING_COLINDEX_NUMBER));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetLongIndexForNullString() throws SQLException {
    assertEquals(0L, subject.getLong(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetLongIndexForTimestamp() {
    SQLException e =
        assertThrows(SQLException.class, () -> subject.getLong(TIMESTAMP_COLINDEX_NOTNULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetDoubleIndex() throws SQLException {
    assertEquals(DOUBLE_VALUE, subject.getDouble(DOUBLE_COLINDEX_NOTNULL), 0d);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getDouble(DOUBLE_COLINDEX_NULL), 0d);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDoubleIndexFromString() throws SQLException {
    assertEquals(
        Double.parseDouble(STRING_NUMBER_VALUE), subject.getDouble(STRING_COLINDEX_NUMBER), 0d);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getDouble(STRING_COLINDEX_NULL), 0d);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDoubleIndexFromBool() throws SQLException {
    assertEquals(BOOLEAN_VALUE ? 1d : 0d, subject.getDouble(BOOLEAN_COLINDEX_NOTNULL), 0d);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getDouble(BOOLEAN_COLINDEX_NULL), 0d);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDoubleIndexFromInt64() throws SQLException {
    assertEquals(LONG_VALUE, subject.getDouble(LONG_COLINDEX_NOTNULL), 0d);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getDouble(LONG_COLINDEX_NULL), 0d);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDoubleIndexFromTimestamp() {
    SQLException e =
        assertThrows(SQLException.class, () -> subject.getDouble(TIMESTAMP_COLINDEX_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @SuppressWarnings("deprecation")
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

  @Test
  public void testGetBytesIndexFromProtoMessage() throws SQLException {
    assertNotNull(subject.getBytes(PROTO_MSG_COLINDEX_NOT_NULL));
    assertArrayEquals(PROTO_MSG_VALUE.toByteArray(), subject.getBytes(PROTO_MSG_COLINDEX_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBytes(PROTO_MSG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetProtoMessage() throws SQLException {
    SingerInfo singerInfo = subject.getObject(PROTO_MSG_COLINDEX_NOT_NULL, SingerInfo.class);
    assertEquals(SingerInfo.newBuilder().setSingerId(1).build(), singerInfo);
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(PROTO_MSG_COLINDEX_NULL, SingerInfo.class));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBytesAsObjectIndexFromProtoMessage() throws SQLException {
    assertNotNull(subject.getObject(PROTO_MSG_COLINDEX_NOT_NULL));
    assertArrayEquals(
        PROTO_MSG_VALUE.toByteArray(), (byte[]) subject.getObject(PROTO_MSG_COLINDEX_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(PROTO_MSG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetProtoMessageArrayAsObject() throws SQLException {
    assertNotNull(subject.getObject(PROTO_MSG_ARRAY_COL, SingerInfo[].class));
    assertArrayEquals(
        new SingerInfo[] {SingerInfo.newBuilder().setSingerId(1).build(), null},
        subject.getObject(PROTO_MSG_ARRAY_COL, SingerInfo[].class));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetIntIndexFromProtoEnum() throws SQLException {
    assertEquals(PROTO_ENUM_VALUE, subject.getInt(PROTO_ENUM_COLINDEX_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getInt(PROTO_ENUM_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetEnum() throws SQLException {
    Genre singerGenre = subject.getObject(PROTO_ENUM_COLINDEX_NOT_NULL, Genre.class);
    assertEquals(Genre.ROCK, singerGenre);
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(PROTO_ENUM_COLINDEX_NULL, Genre.class));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetIntAsObjectIndexFromProtoEnum() throws SQLException {
    assertNotNull(subject.getObject(PROTO_ENUM_COLINDEX_NOT_NULL));
    assertEquals(PROTO_ENUM_VALUE, subject.getObject(PROTO_ENUM_COLINDEX_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(PROTO_ENUM_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetProtoEnumArrayAsObject() throws SQLException {
    assertNotNull(subject.getObject(PROTO_ENUM_ARRAY_COL, Genre[].class));
    assertArrayEquals(
        new Genre[] {Genre.ROCK, null}, subject.getObject(PROTO_ENUM_ARRAY_COL, Genre[].class));
    assertFalse(subject.wasNull());
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
  public void testGetDateIndexFromString() throws SQLException {
    assertNotNull(subject.getDate(STRING_COLINDEX_DATE));
    assertEquals(java.sql.Date.valueOf(STRING_DATE_VALUE), subject.getDate(STRING_COLINDEX_DATE));
    assertFalse(subject.wasNull());
    assertNull(subject.getDate(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDateIndexFromTimestamp() throws SQLException {
    assertNotNull(subject.getDate(TIMESTAMP_COLINDEX_NOTNULL));
    assertEquals(
        new java.sql.Date(TIMESTAMP_VALUE.toSqlTimestamp().getTime()),
        subject.getDate(TIMESTAMP_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getDate(TIMESTAMP_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDateIndexFromInt64() {
    SQLException e = assertThrows(SQLException.class, () -> subject.getDate(LONG_COLINDEX_NOTNULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
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
  public void testGetTimeIndexFromString() throws SQLException {
    assertNotNull(subject.getTime(STRING_COLINDEX_TIME));
    assertEquals(Time.valueOf(STRING_TIME_VALUE), subject.getTime(STRING_COLINDEX_TIME));
    assertFalse(subject.wasNull());
    assertNull(subject.getTime(STRING_COLINDEX_NULL));
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
  public void testGetTimestampIndexFromString() throws SQLException {
    assertNotNull(subject.getTimestamp(STRING_COLINDEX_TIMESTAMP));
    assertEquals(
        Timestamp.parseTimestamp(STRING_TIMESTAMP_VALUE).toSqlTimestamp(),
        subject.getTimestamp(STRING_COLINDEX_TIMESTAMP));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testGetTimestampIndexFromDate() throws SQLException {
    assertNotNull(subject.getTimestamp(DATE_COLINDEX_NOTNULL));
    assertEquals(
        new java.sql.Timestamp(
            DATE_VALUE.getYear() - 1900,
            DATE_VALUE.getMonth() - 1,
            DATE_VALUE.getDayOfMonth(),
            0,
            0,
            0,
            0),
        subject.getTimestamp(DATE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(DATE_COLINDEX_NULL));
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
    JdbcSqlExceptionImpl sqlException =
        assertThrows(JdbcSqlExceptionImpl.class, () -> subject.getURL(STRING_COL_NOT_NULL));
    assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
    assertTrue(
        sqlException.getMessage(),
        sqlException
            .getMessage()
            .contains("Invalid URL: " + subject.getString(STRING_COL_NOT_NULL)));
  }

  @Test
  public void testGetBooleanLabel() throws SQLException {
    assertTrue(subject.getBoolean(BOOLEAN_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertFalse(subject.getBoolean(BOOLEAN_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetLongLabel() throws SQLException {
    assertEquals(1L, subject.getLong(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0L, subject.getLong(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetDoubleLabel() throws SQLException {
    assertEquals(DOUBLE_VALUE, subject.getDouble(DOUBLE_COL_NOT_NULL), 0d);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getDouble(DOUBLE_COL_NULL), 0d);
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
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
  public void testGetMetaDataBeforeNext() throws SQLException {
    ResultSet spannerResultSet = mock(ResultSet.class);
    when(spannerResultSet.next()).thenReturn(true, false);

    JdbcResultSet resultSet = JdbcResultSet.of(spannerResultSet);
    assertNotNull(resultSet.getMetaData());
    assertTrue(resultSet.next());
    assertFalse(resultSet.next());
  }

  @Test
  public void testGetMetaDataTwiceBeforeNext() throws SQLException {
    ResultSet spannerResultSet = mock(ResultSet.class);
    when(spannerResultSet.next()).thenReturn(true, false);

    JdbcResultSet resultSet = JdbcResultSet.of(spannerResultSet);
    assertNotNull(resultSet.getMetaData());
    assertNotNull(resultSet.getMetaData());

    // This would have returned false before the fix in
    // https://github.com/googleapis/java-spanner-jdbc/pull/323
    assertTrue(resultSet.next());
    assertFalse(resultSet.next());
  }

  @Test
  public void testFindColumn() throws SQLException {
    assertEquals(2, subject.findColumn(STRING_COL_NOT_NULL));
  }

  @Test
  public void testGetBigDecimalFromDouble_usingIndex() throws SQLException {
    assertNotNull(subject.getBigDecimal(DOUBLE_COLINDEX_NOTNULL));
    assertEquals(BigDecimal.valueOf(DOUBLE_VALUE), subject.getBigDecimal(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBigDecimalFromDouble_usingLabel() throws SQLException {
    assertNotNull(subject.getBigDecimal(DOUBLE_COL_NOT_NULL));
    assertEquals(BigDecimal.valueOf(DOUBLE_VALUE), subject.getBigDecimal(DOUBLE_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(DOUBLE_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBigDecimalIndex() throws SQLException {
    assertNotNull(subject.getBigDecimal(NUMERIC_COLINDEX_NOTNULL));
    assertEquals(NUMERIC_VALUE, subject.getBigDecimal(NUMERIC_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(NUMERIC_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBigDecimalLabel() throws SQLException {
    assertNotNull(subject.getBigDecimal(NUMERIC_COL_NOT_NULL));
    assertEquals(NUMERIC_VALUE, subject.getBigDecimal(NUMERIC_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getBigDecimal(NUMERIC_COL_NULL));
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
    //noinspection MagicConstant
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
    //noinspection MagicConstant
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
  public void testGetTimestampIndexCalendarFromString() throws SQLException {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));

    assertNotNull(subject.getTimestamp(STRING_COLINDEX_TIMESTAMP, cal));
    assertEquals(
        Timestamp.parseTimestamp(STRING_TIMESTAMP_VALUE.replace("Z", "-07:00")).toSqlTimestamp(),
        subject.getTimestamp(STRING_COLINDEX_TIMESTAMP, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(STRING_COLINDEX_NULL, cal));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetTimestampIndexCalendarFromDate() throws SQLException {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles"));

    assertNotNull(subject.getTimestamp(DATE_COLINDEX_NOTNULL, cal));
    assertEquals(
        Timestamp.parseTimestamp(String.format("%sT00:00:00-08:00", DATE_VALUE)).toSqlTimestamp(),
        subject.getTimestamp(DATE_COLINDEX_NOTNULL, cal));
    assertFalse(subject.wasNull());
    assertNull(subject.getTimestamp(DATE_COLINDEX_NULL, cal));
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
  public void testIsClosed() {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      assertFalse(rs.isClosed());
      rs.close();
      assertTrue(rs.isClosed());
    }
  }

  @Test
  public void testGetByteIndex() throws SQLException {
    assertEquals(LONG_VALUE, subject.getByte(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getByte(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetByteIndexFromString() throws SQLException {
    assertEquals(
        Byte.valueOf(STRING_NUMBER_VALUE).byteValue(), subject.getByte(STRING_COLINDEX_NUMBER));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetByteIndexFromDouble() throws SQLException {
    assertEquals((byte) DOUBLE_VALUE, subject.getByte(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetByteIndexFromBoolean() throws SQLException {
    assertEquals(BOOLEAN_VALUE ? 1 : 0, subject.getByte(BOOLEAN_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetNullByteIndex() throws SQLException {
    assertEquals(0, subject.getByte(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getByte(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getByte(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getByte(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    SQLException e = assertThrows(SQLException.class, () -> subject.getByte(TIMESTAMP_COL_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetShortIndex() throws SQLException {
    assertEquals(LONG_VALUE, subject.getShort(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getShort(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetShortIndexFromString() throws SQLException {
    assertEquals(
        Short.valueOf(STRING_NUMBER_VALUE).shortValue(), subject.getShort(STRING_COLINDEX_NUMBER));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetShortIndexFromDouble() throws SQLException {
    assertEquals((short) DOUBLE_VALUE, subject.getShort(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetShortIndexFromBoolean() throws SQLException {
    assertEquals(BOOLEAN_VALUE ? 1 : 0, subject.getShort(BOOLEAN_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetShortIndexFromBytes() {
    SQLException e = assertThrows(SQLException.class, () -> subject.getShort(BYTES_COL_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetNullShortIndex() throws SQLException {
    assertEquals(0, subject.getShort(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getShort(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getShort(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getShort(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    SQLException e = assertThrows(SQLException.class, () -> subject.getShort(TIMESTAMP_COL_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetIntIndex() throws SQLException {
    int expected = (int) LONG_VALUE;
    assertEquals(expected, subject.getInt(LONG_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getInt(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetIntIndexFromString() throws SQLException {
    assertEquals(
        Integer.valueOf(STRING_NUMBER_VALUE).intValue(), subject.getInt(STRING_COLINDEX_NUMBER));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetIntIndexFromDouble() throws SQLException {
    assertEquals((int) DOUBLE_VALUE, subject.getInt(DOUBLE_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetIntIndexFromBoolean() throws SQLException {
    assertEquals(BOOLEAN_VALUE ? 1 : 0, subject.getInt(BOOLEAN_COLINDEX_NOTNULL));
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetIntIndexFromTimestamp() {
    SQLException e = assertThrows(SQLException.class, () -> subject.getInt(TIMESTAMP_COL_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetNullIntIndex() throws SQLException {
    assertEquals(0, subject.getInt(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getInt(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getInt(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    assertEquals(0, subject.getInt(STRING_COLINDEX_NULL));
    assertTrue(subject.wasNull());
    SQLException e = assertThrows(SQLException.class, () -> subject.getInt(TIMESTAMP_COL_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetFloatIndex() throws SQLException {
    float expected = (float) DOUBLE_VALUE;
    assertEquals(expected, subject.getFloat(DOUBLE_COLINDEX_NOTNULL), 0f);
    assertFalse(subject.wasNull());
    assertEquals(0d, subject.getFloat(DOUBLE_COLINDEX_NULL), 0f);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetFloatIndexFromString() throws SQLException {
    assertEquals(
        Float.parseFloat(STRING_NUMBER_VALUE), subject.getFloat(STRING_COLINDEX_NUMBER), 0f);
    assertFalse(subject.wasNull());
    assertEquals(0f, subject.getFloat(STRING_COLINDEX_NULL), 0f);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetFloatIndexFromBool() throws SQLException {
    assertEquals(BOOLEAN_VALUE ? 1f : 0f, subject.getFloat(BOOLEAN_COLINDEX_NOTNULL), 0f);
    assertFalse(subject.wasNull());
    assertEquals(0f, subject.getFloat(BOOLEAN_COLINDEX_NULL), 0f);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetFloatIndexFromInt64() throws SQLException {
    assertEquals(LONG_VALUE, subject.getFloat(LONG_COLINDEX_NOTNULL), 0f);
    assertFalse(subject.wasNull());
    assertEquals(0f, subject.getFloat(LONG_COLINDEX_NULL), 0f);
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetFloatIndexFromTimestamp() {
    SQLException e =
        assertThrows(SQLException.class, () -> subject.getFloat(TIMESTAMP_COLINDEX_NULL));
    assertTrue(e instanceof JdbcSqlException);
    assertEquals(Code.INVALID_ARGUMENT, ((JdbcSqlException) e).getCode());
  }

  @Test
  public void testGetByteLabel() throws SQLException {
    assertEquals(1, subject.getByte(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getByte(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetShortLabel() throws SQLException {
    assertEquals(1, subject.getShort(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getShort(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetIntLabel() throws SQLException {
    assertEquals(1, subject.getInt(LONG_COL_NOT_NULL));
    assertFalse(subject.wasNull());
    assertEquals(0, subject.getInt(LONG_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetFloatLabel() throws SQLException {
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

  @Test
  public void testGetJsonAsObjectIndex() throws SQLException {
    assertNotNull(subject.getObject(JSON_COLINDEX_NOT_NULL));
    assertEquals(JSON_VALUE, subject.getObject(JSON_COLINDEX_NOT_NULL));
    assertFalse(subject.wasNull());
    assertNull(subject.getObject(JSON_COLINDEX_NULL));
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
  public void testGetWarnings() {
    assertNull(subject.getWarnings());
  }

  @Test
  public void testClearWarnings() {
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
        assertFalse(rs.isAfterLast());
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
  public void testGetAsciiStreamIndexForBool() throws SQLException, IOException {
    assertNotNull(subject.getAsciiStream(BOOLEAN_COLINDEX_NOTNULL));
    InputStream actual = subject.getAsciiStream(BOOLEAN_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(
        String.valueOf(BOOLEAN_VALUE), new String(cbuf, 0, len, StandardCharsets.US_ASCII));
    assertEquals(4, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getAsciiStream(BOOLEAN_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetAsciiStreamIndexForInt64() throws SQLException, IOException {
    assertNotNull(subject.getAsciiStream(LONG_COLINDEX_NOTNULL));
    InputStream actual = subject.getAsciiStream(LONG_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(String.valueOf(LONG_VALUE), new String(cbuf, 0, len, StandardCharsets.US_ASCII));
    assertEquals(1, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getAsciiStream(LONG_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetAsciiStreamIndexForFloat64() throws SQLException, IOException {
    assertNotNull(subject.getAsciiStream(DOUBLE_COLINDEX_NOTNULL));
    InputStream actual = subject.getAsciiStream(DOUBLE_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[20];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(String.valueOf(DOUBLE_VALUE), new String(cbuf, 0, len, StandardCharsets.US_ASCII));
    assertEquals(13, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getAsciiStream(DOUBLE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetAsciiStreamIndexForDate() throws SQLException, IOException {
    assertNotNull(subject.getAsciiStream(DATE_COLINDEX_NOTNULL));
    InputStream actual = subject.getAsciiStream(DATE_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[10];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(String.valueOf(DATE_VALUE), new String(cbuf, 0, len, StandardCharsets.US_ASCII));
    assertEquals(10, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getAsciiStream(DATE_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetAsciiStreamIndexForTimestamp() throws SQLException, IOException {
    assertNotNull(subject.getAsciiStream(TIMESTAMP_COLINDEX_NOTNULL));
    InputStream actual = subject.getAsciiStream(TIMESTAMP_COLINDEX_NOTNULL);
    byte[] cbuf = new byte[100];
    int len = actual.read(cbuf, 0, cbuf.length);
    assertEquals(
        String.valueOf(TIMESTAMP_VALUE), new String(cbuf, 0, len, StandardCharsets.US_ASCII));
    assertEquals(30, len);
    assertFalse(subject.wasNull());
    assertNull(subject.getAsciiStream(TIMESTAMP_COLINDEX_NULL));
    assertTrue(subject.wasNull());
  }

  @SuppressWarnings("deprecation")
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
    assertNull(subject.getBinaryStream(BYTES_COLINDEX_NULL));
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

  @SuppressWarnings("deprecation")
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
    assertNull(subject.getBinaryStream(BYTES_COL_NULL));
    assertTrue(subject.wasNull());
  }

  @Test
  public void testGetBeforeNext() {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      JdbcSqlExceptionImpl sqlException =
          assertThrows(JdbcSqlExceptionImpl.class, () -> rs.getBigDecimal(LONG_COLINDEX_NOTNULL));
      assertEquals(Code.FAILED_PRECONDITION, sqlException.getCode());
      assertTrue(
          sqlException.getMessage(),
          sqlException.getMessage().contains("ResultSet is before first row. Call next() first."));
    }
  }

  @Test
  public void testGetAfterLast() throws SQLException {
    try (JdbcResultSet rs = JdbcResultSet.of(mock(Statement.class), getMockResultSet())) {
      while (rs.next()) {
        assertNotNull(rs.getBigDecimal(LONG_COLINDEX_NOTNULL));
      }
      JdbcSqlExceptionImpl sqlException =
          assertThrows(JdbcSqlExceptionImpl.class, () -> rs.getBigDecimal(LONG_COLINDEX_NOTNULL));
      assertEquals(Code.FAILED_PRECONDITION, sqlException.getCode());
      assertTrue(
          sqlException.getMessage(),
          sqlException
              .getMessage()
              .contains("ResultSet is after last row. There is no more data available."));
    }
  }

  @Test
  public void testFindIllegalColumnName() {
    JdbcSqlExceptionImpl sqlException =
        assertThrows(JdbcSqlExceptionImpl.class, () -> subject.findColumn(UNKNOWN_COLUMN));
    assertEquals(Code.INVALID_ARGUMENT, sqlException.getCode());
    assertTrue(
        sqlException.getMessage(),
        sqlException.getMessage().contains("no column with label " + UNKNOWN_COLUMN + " found"));
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

  @Test
  public void testGetObjectAsValue() throws SQLException {
    assertEquals(
        Value.bool(BOOLEAN_VALUE), subject.getObject(BOOLEAN_COLINDEX_NOTNULL, Value.class));
    assertEquals(Value.bytes(BYTES_VALUE), subject.getObject(BYTES_COLINDEX_NOTNULL, Value.class));
    assertEquals(Value.date(DATE_VALUE), subject.getObject(DATE_COLINDEX_NOTNULL, Value.class));
    assertEquals(
        Value.float64(DOUBLE_VALUE), subject.getObject(DOUBLE_COLINDEX_NOTNULL, Value.class));
    assertEquals(Value.int64(LONG_VALUE), subject.getObject(LONG_COLINDEX_NOTNULL, Value.class));
    assertEquals(
        Value.numeric(NUMERIC_VALUE), subject.getObject(NUMERIC_COLINDEX_NOTNULL, Value.class));
    assertEquals(
        Value.string(STRING_VALUE), subject.getObject(STRING_COLINDEX_NOTNULL, Value.class));
    assertEquals(
        Value.timestamp(TIMESTAMP_VALUE),
        subject.getObject(TIMESTAMP_COLINDEX_NOTNULL, Value.class));
    assertEquals(
        Value.protoMessage(PROTO_MSG_VALUE, SingerInfo.getDescriptor()),
        subject.getObject(PROTO_MSG_COLINDEX_NOT_NULL, Value.class));
    assertEquals(
        Value.protoEnum(PROTO_ENUM_VALUE, Genre.getDescriptor()),
        subject.getObject(PROTO_ENUM_COLINDEX_NOT_NULL, Value.class));

    assertEquals(Value.boolArray(BOOL_ARRAY_VALUE), subject.getObject(BOOL_ARRAY_COL, Value.class));
    assertEquals(
        Value.bytesArray(BYTES_ARRAY_VALUE), subject.getObject(BYTES_ARRAY_COL, Value.class));
    assertEquals(Value.dateArray(DATE_ARRAY_VALUE), subject.getObject(DATE_ARRAY_COL, Value.class));
    assertEquals(
        Value.float64Array(FLOAT64_ARRAY_VALUE), subject.getObject(FLOAT64_ARRAY_COL, Value.class));
    assertEquals(
        Value.int64Array(INT64_ARRAY_VALUE), subject.getObject(INT64_ARRAY_COL, Value.class));
    assertEquals(
        Value.numericArray(NUMERIC_ARRAY_VALUE), subject.getObject(NUMERIC_ARRAY_COL, Value.class));
    assertEquals(
        Value.stringArray(STRING_ARRAY_VALUE), subject.getObject(STRING_ARRAY_COL, Value.class));
    assertEquals(
        Value.timestampArray(TIMESTAMP_ARRAY_VALUE),
        subject.getObject(TIMESTAMP_ARRAY_COL, Value.class));
    assertEquals(
        Value.protoMessageArray(PROTO_MSG_ARRAY_VALUE, SingerInfo.getDescriptor().getFullName()),
        subject.getObject(PROTO_MSG_ARRAY_COL, Value.class));
    assertEquals(
        Value.protoEnumArray(PROTO_ENUM_ARRAY_VALUE, Genre.getDescriptor().getFullName()),
        subject.getObject(PROTO_ENUM_ARRAY_COL, Value.class));
  }

  @Test
  public void testGetLocalDate() throws SQLException {
    LocalDate localDate = subject.getObject(DATE_COL_NOT_NULL, LocalDate.class);
    assertEquals(
        LocalDate.of(DATE_VALUE.getYear(), DATE_VALUE.getMonth(), DATE_VALUE.getDayOfMonth()),
        localDate);
    assertFalse(subject.wasNull());
  }

  @Test
  public void testGetOffsetDateTime() throws SQLException {
    OffsetDateTime offsetDateTime = subject.getObject(TIMESTAMP_COL_NOT_NULL, OffsetDateTime.class);
    assertEquals(
        OffsetDateTime.ofInstant(
            Instant.ofEpochSecond(TIMESTAMP_VALUE.getSeconds(), TIMESTAMP_VALUE.getNanos()),
            ZoneOffset.systemDefault()),
        offsetDateTime);
    assertFalse(subject.wasNull());
  }

  @Test
  public void testCopyOf() throws SQLException {
    ResultSet original =
        ResultSets.forRows(
            Type.struct(StructField.of("id", Type.int64()), StructField.of("value", Type.string())),
            ImmutableList.of(
                Struct.newBuilder().set("id").to(1L).set("value").to("One").build(),
                Struct.newBuilder().set("id").to(2L).set("value").to("Two").build()));
    java.sql.ResultSet copy = JdbcResultSet.copyOf(original);
    // The original result set has been fully consumed.
    assertFalse(original.next());
    // We can safely close the original result set and still use the copy.
    original.close();

    ResultSetMetaData metadata = copy.getMetaData();
    assertEquals(2, metadata.getColumnCount());
    assertEquals("id", metadata.getColumnName(1));
    assertEquals("value", metadata.getColumnName(2));
    assertEquals(Types.BIGINT, metadata.getColumnType(1));
    assertEquals(Types.NVARCHAR, metadata.getColumnType(2));

    assertTrue(copy.next());
    assertEquals(1L, copy.getLong(1));
    assertEquals("One", copy.getString(2));
    assertTrue(copy.next());
    assertEquals(2L, copy.getLong("id"));
    assertEquals("Two", copy.getString("value"));
    assertFalse(copy.next());
  }

  @Test
  public void testCopyOfEmpty() throws SQLException {
    ResultSet original =
        ResultSets.forRows(
            Type.struct(StructField.of("id", Type.int64()), StructField.of("value", Type.string())),
            ImmutableList.of());
    java.sql.ResultSet copy = JdbcResultSet.copyOf(original);
    // The original result set has been fully consumed.
    assertFalse(original.next());
    // We can safely close the original result set and still use the copy.
    original.close();

    ResultSetMetaData metadata = copy.getMetaData();
    assertEquals(2, metadata.getColumnCount());
    assertEquals("id", metadata.getColumnName(1));
    assertEquals("value", metadata.getColumnName(2));
    assertEquals(Types.BIGINT, metadata.getColumnType(1));
    assertEquals(Types.NVARCHAR, metadata.getColumnType(2));

    // The copy should not contain any rows.
    assertFalse(copy.next());
  }
}

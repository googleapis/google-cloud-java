/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.sql.Array;
import java.sql.Date;
import java.sql.ParameterMetaData;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.TimeZone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigQueryPreparedStatementSettersTest {

  private BigQueryConnection connection;
  private BigQueryPreparedStatement preparedStatement;

  @BeforeEach
  public void setUp() throws Exception {
    connection = mock(BigQueryConnection.class);
    preparedStatement = new BigQueryPreparedStatement(connection, "SELECT ?, ?, ?, ?, ?");
  }

  @Test
  public void testSetNullWithSqlType() throws Exception {
    preparedStatement.setNull(1, Types.VARCHAR);
    assertNull(preparedStatement.parameterHandler.getParameter(1));
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.STRING, preparedStatement.parameterHandler.getSqlType(1));

    preparedStatement.setNull(2, Types.INTEGER);
    assertNull(preparedStatement.parameterHandler.getParameter(2));
    assertEquals(Integer.class, preparedStatement.parameterHandler.getType(2));
    assertEquals(StandardSQLTypeName.INT64, preparedStatement.parameterHandler.getSqlType(2));

    preparedStatement.setNull(3, Types.SMALLINT);
    assertNull(preparedStatement.parameterHandler.getParameter(3));
    assertEquals(Short.class, preparedStatement.parameterHandler.getType(3));
    assertEquals(StandardSQLTypeName.INT64, preparedStatement.parameterHandler.getSqlType(3));

    preparedStatement.setNull(4, Types.TINYINT);
    assertNull(preparedStatement.parameterHandler.getParameter(4));
    assertEquals(Byte.class, preparedStatement.parameterHandler.getType(4));
    assertEquals(StandardSQLTypeName.INT64, preparedStatement.parameterHandler.getSqlType(4));

    preparedStatement.setNull(5, Types.NULL);
    assertNull(preparedStatement.parameterHandler.getParameter(5));
    assertEquals(String.class, preparedStatement.parameterHandler.getType(5));
    assertEquals(StandardSQLTypeName.STRING, preparedStatement.parameterHandler.getSqlType(5));
  }

  @Test
  public void testSetNullWithTypeName() throws Exception {
    preparedStatement.setNull(1, Types.VARCHAR, "VARCHAR");
    assertNull(preparedStatement.parameterHandler.getParameter(1));
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.STRING, preparedStatement.parameterHandler.getSqlType(1));
  }

  @Test
  public void testSetNullWithUnsupportedSqlTypeThrowsException() {
    assertThrows(java.sql.SQLException.class, () -> preparedStatement.setNull(1, 99999));
  }

  @Test
  public void testSetShort() throws Exception {
    preparedStatement.setShort(1, (short) 42);
    assertEquals((short) 42, preparedStatement.parameterHandler.getParameter(1));
    assertEquals(Short.class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.INT64, preparedStatement.parameterHandler.getSqlType(1));
  }

  @Test
  public void testSetBytes() throws Exception {
    byte[] bytes = new byte[] {1, 2, 3, 4};
    preparedStatement.setBytes(1, bytes);
    assertArrayEquals(bytes, (byte[]) preparedStatement.parameterHandler.getParameter(1));
    assertEquals(byte[].class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.BYTES, preparedStatement.parameterHandler.getSqlType(1));
  }

  @Test
  public void testSetObjectSingleArg() throws Exception {
    preparedStatement.setObject(1, "hello");
    assertEquals("hello", preparedStatement.parameterHandler.getParameter(1));
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.STRING, preparedStatement.parameterHandler.getSqlType(1));

    preparedStatement.setObject(2, 100L);
    assertEquals(100L, preparedStatement.parameterHandler.getParameter(2));
    assertEquals(Long.class, preparedStatement.parameterHandler.getType(2));
    assertEquals(StandardSQLTypeName.INT64, preparedStatement.parameterHandler.getSqlType(2));

    preparedStatement.setObject(3, null);
    assertNull(preparedStatement.parameterHandler.getParameter(3));
    assertEquals(String.class, preparedStatement.parameterHandler.getType(3));
  }

  @Test
  public void testSetObjectWithTargetSqlType() throws Exception {
    preparedStatement.setObject(1, 123, Types.INTEGER);
    assertEquals(123, preparedStatement.parameterHandler.getParameter(1));
    assertEquals(Integer.class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.INT64, preparedStatement.parameterHandler.getSqlType(1));

    preparedStatement.setObject(2, null, Types.INTEGER);
    assertNull(preparedStatement.parameterHandler.getParameter(2));
    assertEquals(Integer.class, preparedStatement.parameterHandler.getType(2));

    preparedStatement.setObject(3, 456, Types.INTEGER, 0);
    assertEquals(456, preparedStatement.parameterHandler.getParameter(3));
    assertEquals(Integer.class, preparedStatement.parameterHandler.getType(3));
  }

  @Test
  public void testSetArray() throws Exception {
    Array mockArray = mock(Array.class);
    preparedStatement.setArray(1, mockArray);
    assertEquals(mockArray, preparedStatement.parameterHandler.getParameter(1));
    assertEquals(Array.class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.ARRAY, preparedStatement.parameterHandler.getSqlType(1));
  }

  @Test
  public void testGetParameterMetaData() throws Exception {
    preparedStatement.setString(1, "test");
    preparedStatement.setInt(2, 42);

    ParameterMetaData metaData = preparedStatement.getParameterMetaData();
    assertEquals(5, metaData.getParameterCount());
    assertEquals(Types.NVARCHAR, metaData.getParameterType(1));
    assertEquals("STRING", metaData.getParameterTypeName(1));
    assertEquals(String.class.getName(), metaData.getParameterClassName(1));

    assertEquals(Types.BIGINT, metaData.getParameterType(2));
    assertEquals("INT64", metaData.getParameterTypeName(2));
    assertEquals(Long.class.getName(), metaData.getParameterClassName(2));

    assertEquals(ParameterMetaData.parameterNullable, metaData.isNullable(1));
    assertEquals(ParameterMetaData.parameterModeIn, metaData.getParameterMode(1));

    assertThrows(SQLException.class, () -> metaData.getParameterType(0));
    assertThrows(SQLException.class, () -> metaData.getParameterType(6));
  }

  @Test
  public void testSetDateWithCalendar() throws Exception {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    Date date = new Date(1700000000000L); // 2023-11-14

    preparedStatement.setDate(1, date, cal);
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));
  }

  @Test
  public void testSetTimeWithCalendar() throws Exception {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    Time time = new Time(43200000L); // 12:00:00

    preparedStatement.setTime(1, time, cal);
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));
  }

  @Test
  public void testSetTimestampWithCalendar() throws Exception {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    Timestamp ts = new Timestamp(1700000000000L);

    preparedStatement.setTimestamp(1, ts, cal);
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));
  }

  @Test
  public void testGetMetaData() throws Exception {
    // Before execution/insertSchema initialization, getMetaData() returns null
    assertNull(preparedStatement.getMetaData());

    // When insertSchema is present, getMetaData() returns ResultSetMetaData
    preparedStatement.insertSchema =
        Schema.of(
            Field.of("col1", StandardSQLTypeName.STRING),
            Field.of("col2", StandardSQLTypeName.INT64));

    ResultSetMetaData metaData = preparedStatement.getMetaData();
    assertNotNull(metaData);
    assertEquals(2, metaData.getColumnCount());
    assertEquals("col1", metaData.getColumnName(1));
    assertEquals(Types.NVARCHAR, metaData.getColumnType(1));
    assertEquals("col2", metaData.getColumnName(2));
    assertEquals(Types.BIGINT, metaData.getColumnType(2));
  }

  @Test
  public void testSetObjectWithJavaTime() throws Exception {
    LocalDate localDate = LocalDate.of(2025, 12, 3);
    preparedStatement.setObject(1, localDate);
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));

    LocalTime localTime = LocalTime.of(12, 30, 0);
    preparedStatement.setObject(2, localTime);
    assertEquals(String.class, preparedStatement.parameterHandler.getType(2));

    LocalDateTime localDateTime = LocalDateTime.of(2025, 12, 3, 12, 30, 0);
    preparedStatement.setObject(3, localDateTime);
    assertEquals(String.class, preparedStatement.parameterHandler.getType(3));

    Instant instant = Instant.now();
    preparedStatement.setObject(4, instant);
    assertEquals(String.class, preparedStatement.parameterHandler.getType(4));
  }
}

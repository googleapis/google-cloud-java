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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.jdbc.BigQueryParameterHandler.BigQueryStatementParameterType;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class BigQueryCallableStatementTest {

  private BigQueryConnection bigQueryConnection;
  private static final String GET_PARAM_KEY = "ParamKey";
  private static final String PARAM_KEY = GET_PARAM_KEY;

  @Before
  public void setUp() throws IOException, SQLException {
    bigQueryConnection = mock(BigQueryConnection.class);
  }

  @Test
  public void testCreateCallableStatement() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc");
    assertNotNull(statement);

    assertEquals("call testProc", statement.getCallableStatementSql());
  }

  @Test
  public void testRegisterOutParamIndexVarchar() throws SQLException {
    registerOutParamIndexHelper(1, Types.VARCHAR, String.class, StandardSQLTypeName.STRING, -1);
  }

  @Test
  public void testRegisterOutParamIndexNVarchar() throws SQLException {
    registerOutParamIndexHelper(1, Types.NVARCHAR, String.class, StandardSQLTypeName.STRING, -1);
  }

  @Test
  public void testRegisterOutParamIndexBigInt() throws SQLException {
    registerOutParamIndexHelper(1, Types.BIGINT, Long.class, StandardSQLTypeName.INT64, -1);
  }

  @Test
  public void testRegisterOutParamIndexInteger() throws SQLException {
    registerOutParamIndexHelper(1, Types.INTEGER, Integer.class, StandardSQLTypeName.INT64, -1);
  }

  @Test
  public void testRegisterOutParamIndexBoolean() throws SQLException {
    registerOutParamIndexHelper(1, Types.BOOLEAN, Boolean.class, StandardSQLTypeName.BOOL, -1);
  }

  @Test
  public void testRegisterOutParamIndexDouble() throws SQLException {
    registerOutParamIndexHelper(1, Types.DOUBLE, Double.class, StandardSQLTypeName.FLOAT64, -1);
  }

  @Test
  public void testRegisterOutParamIndexFloat() throws SQLException {
    registerOutParamIndexHelper(1, Types.FLOAT, Float.class, StandardSQLTypeName.FLOAT64, -1);
  }

  @Test
  public void testRegisterOutParamIndexNumeric() throws SQLException {
    registerOutParamIndexHelper(1, Types.NUMERIC, BigDecimal.class, StandardSQLTypeName.NUMERIC, 2);
  }

  @Test
  public void testRegisterOutParamIndexTimestamp() throws SQLException {
    registerOutParamIndexHelper(
        1, Types.TIMESTAMP, Timestamp.class, StandardSQLTypeName.TIMESTAMP, -1);
  }

  @Test
  public void testRegisterOutParamIndexDate() throws SQLException {
    registerOutParamIndexHelper(1, Types.DATE, Date.class, StandardSQLTypeName.DATE, -1);
  }

  @Test
  public void testRegisterOutParamIndexTime() throws SQLException {
    registerOutParamIndexHelper(1, Types.TIME, Time.class, StandardSQLTypeName.TIME, -1);
  }

  @Test
  public void testRegisterOutParamIndexOther() throws SQLException {
    registerOutParamIndexHelper(1, Types.OTHER, String.class, StandardSQLTypeName.STRING, -1);
  }

  @Test
  public void testRegisterOutParamIndexBinary() throws SQLException {
    registerOutParamIndexHelper(1, Types.BINARY, byte[].class, StandardSQLTypeName.BYTES, -1);
  }

  @Test
  public void testRegisterOutParamIndexVarBinary() throws SQLException {
    registerOutParamIndexHelper(1, Types.VARBINARY, byte[].class, StandardSQLTypeName.BYTES, -1);
  }

  @Test
  public void testRegisterOutParamIndexStruct() throws SQLException {
    registerOutParamIndexHelper(1, Types.STRUCT, Struct.class, StandardSQLTypeName.STRUCT, -1);
  }

  @Test
  public void testRegisterOutParamIndexArray() throws SQLException {
    registerOutParamIndexHelper(1, Types.ARRAY, Array.class, StandardSQLTypeName.ARRAY, -1);
  }

  @Test
  public void testRegisterOutParamIndexBit() throws SQLException {
    registerOutParamIndexHelper(1, Types.BIT, Boolean.class, StandardSQLTypeName.BOOL, -1);
  }

  @Test
  public void testRegisterOutParamNameVarchar() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.VARCHAR, String.class, StandardSQLTypeName.STRING, -1);
  }

  @Test
  public void testRegisterOutParamNameNVarchar() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.NVARCHAR, String.class, StandardSQLTypeName.STRING, -1);
  }

  @Test
  public void testRegisterOutParamNameBigInt() throws SQLException {
    registerOutParamNameHelper("ParamKey", Types.BIGINT, Long.class, StandardSQLTypeName.INT64, -1);
  }

  @Test
  public void testRegisterOutParamNameInteger() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.INTEGER, Integer.class, StandardSQLTypeName.INT64, -1);
  }

  @Test
  public void testRegisterOutParamNameBoolean() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.BOOLEAN, Boolean.class, StandardSQLTypeName.BOOL, -1);
  }

  @Test
  public void testRegisterOutParamNameDouble() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.DOUBLE, Double.class, StandardSQLTypeName.FLOAT64, -1);
  }

  @Test
  public void testRegisterOutParamNameFloat() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.FLOAT, Float.class, StandardSQLTypeName.FLOAT64, -1);
  }

  @Test
  public void testRegisterOutParamNameNumeric() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.NUMERIC, BigDecimal.class, StandardSQLTypeName.NUMERIC, 2);
  }

  @Test
  public void testRegisterOutParamNameTimestamp() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.TIMESTAMP, Timestamp.class, StandardSQLTypeName.TIMESTAMP, -1);
  }

  @Test
  public void testRegisterOutParamNameDate() throws SQLException {
    registerOutParamNameHelper("ParamKey", Types.DATE, Date.class, StandardSQLTypeName.DATE, -1);
  }

  @Test
  public void testRegisterOutParamNameTime() throws SQLException {
    registerOutParamNameHelper("ParamKey", Types.TIME, Time.class, StandardSQLTypeName.TIME, -1);
  }

  @Test
  public void testRegisterOutParamNameOther() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.OTHER, String.class, StandardSQLTypeName.STRING, -1);
  }

  @Test
  public void testRegisterOutParamNameBinary() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.BINARY, byte[].class, StandardSQLTypeName.BYTES, -1);
  }

  @Test
  public void testRegisterOutParamNameVarBinary() throws SQLException {
    registerOutParamNameHelper(
        "ParamKey", Types.VARBINARY, byte[].class, StandardSQLTypeName.BYTES, -1);
  }

  @Test
  public void testRegisterOutParamNameStruct() throws SQLException {
    registerOutParamIndexHelper(1, Types.STRUCT, Struct.class, StandardSQLTypeName.STRUCT, -1);
  }

  @Test
  public void testRegisterOutParamNameArray() throws SQLException {
    registerOutParamNameHelper("ParamKey", Types.ARRAY, Array.class, StandardSQLTypeName.ARRAY, -1);
  }

  @Test
  public void testRegisterOutParamNameBit() throws SQLException {
    registerOutParamNameHelper("ParamKey", Types.BIT, Boolean.class, StandardSQLTypeName.BOOL, -1);
  }

  @Test
  public void testRegisterOutParamIndexScaleFail() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    assertThrows(
        IllegalArgumentException.class, () -> statement.registerOutParameter(1, Types.VARCHAR, 3));
  }

  @Test
  public void testRegisterOutNameIndexScaleFail() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    assertThrows(
        IllegalArgumentException.class,
        () -> statement.registerOutParameter("ParamKey", Types.VARCHAR, 3));
  }

  @Test
  public void testGetArrayParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Array expected = mock(Array.class);

    statement.getParameterHandler().setParameter(1, expected, Array.class);
    Array actual = statement.getArray(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetArrayParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Array expected = mock(Array.class);

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Array.class, BigQueryStatementParameterType.IN, 0);
    Array actual = statement.getArray(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBigDecimalParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    BigDecimal expected = mock(BigDecimal.class);

    statement.getParameterHandler().setParameter(1, expected, BigDecimal.class);
    BigDecimal actual = statement.getBigDecimal(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBigDecimalParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    BigDecimal expected = mock(BigDecimal.class);

    statement
        .getParameterHandler()
        .setParameter(
            GET_PARAM_KEY, expected, BigDecimal.class, BigQueryStatementParameterType.IN, 0);
    BigDecimal actual = statement.getBigDecimal(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBooleanParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Boolean expected = true;

    statement.getParameterHandler().setParameter(1, expected, Boolean.class);
    Boolean actual = statement.getBoolean(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBooleanParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Boolean expected = true;

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Boolean.class, BigQueryStatementParameterType.IN, 0);
    Boolean actual = statement.getBoolean(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetByteParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Byte expected = "hello".getBytes()[0];

    statement.getParameterHandler().setParameter(1, expected, Byte.class);
    Byte actual = statement.getByte(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetByteParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Byte expected = "hello".getBytes()[0];

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Byte.class, BigQueryStatementParameterType.IN, 0);
    Byte actual = statement.getByte(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBytesParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    byte[] expected = "hello".getBytes();

    statement.getParameterHandler().setParameter(1, expected, byte[].class);
    byte[] actual = statement.getBytes(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetBytesParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    byte[] expected = "hello".getBytes();

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, byte[].class, BigQueryStatementParameterType.IN, 0);
    byte[] actual = statement.getBytes(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetCharacterStreamParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement.getParameterHandler().setParameter(1, expected, String.class);
    Reader actual = statement.getCharacterStream(1);
    assertNotNull(actual);
    assertTrue(actual instanceof StringReader);
  }

  @Test
  public void testGetCharacterStreamParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, String.class, BigQueryStatementParameterType.IN, 0);
    Reader actual = statement.getCharacterStream(GET_PARAM_KEY);
    assertNotNull(actual);
    assertTrue(actual instanceof StringReader);
  }

  @Test
  public void testGetDateParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Date expected = mock(Date.class);

    statement.getParameterHandler().setParameter(1, expected, Date.class);
    Date actual = statement.getDate(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetDateParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Date expected = mock(Date.class);

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Date.class, BigQueryStatementParameterType.IN, 0);
    Date actual = statement.getDate(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetDateParamWithCalByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Calendar cal = Calendar.getInstance();
    Date expected = new Date(cal.getTimeInMillis());

    statement.getParameterHandler().setParameter(1, expected, Date.class);
    Date actual = statement.getDate(1, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetDateParamWithCalByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Calendar cal = Calendar.getInstance();
    Date expected = new Date(cal.getTimeInMillis());

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Date.class, BigQueryStatementParameterType.IN, 0);
    Date actual = statement.getDate(GET_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetDoubleParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Double expected = 10.123;

    statement.getParameterHandler().setParameter(1, expected, Double.class);
    Double actual = statement.getDouble(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetDoubleParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Double expected = 10.123;

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Double.class, BigQueryStatementParameterType.IN, 0);
    Double actual = statement.getDouble(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetFloatParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Float expected = 10.123F;

    statement.getParameterHandler().setParameter(1, expected, Float.class);
    Float actual = statement.getFloat(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetFloatParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Float expected = 10.123F;

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Float.class, BigQueryStatementParameterType.IN, 0);
    Float actual = statement.getFloat(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetIntegerParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Integer expected = 10;

    statement.getParameterHandler().setParameter(1, expected, Integer.class);
    Integer actual = statement.getInt(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetIntegerParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Integer expected = 10;

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Integer.class, BigQueryStatementParameterType.IN, 0);
    Integer actual = statement.getInt(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetLongParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Long expected = 10L;

    statement.getParameterHandler().setParameter(1, expected, Long.class);
    Long actual = statement.getLong(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetLongParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Long expected = 10L;

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Long.class, BigQueryStatementParameterType.IN, 0);
    Long actual = statement.getLong(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetNCharacterStreamParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement.getParameterHandler().setParameter(1, expected, String.class);
    Reader actual = statement.getNCharacterStream(1);
    assertNotNull(actual);
    assertTrue(actual instanceof StringReader);
  }

  @Test
  public void testGetNCharacterStreamParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, String.class, BigQueryStatementParameterType.IN, 0);
    Reader actual = statement.getNCharacterStream(GET_PARAM_KEY);
    assertNotNull(actual);
    assertTrue(actual instanceof StringReader);
  }

  @Test
  public void testGetNStringParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement.getParameterHandler().setParameter(1, expected, String.class);
    String actual = statement.getNString(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetNStringByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, String.class, BigQueryStatementParameterType.IN, 0);
    String actual = statement.getNString(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetObjectParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement.getParameterHandler().setParameter(1, expected, String.class);
    Object actual = statement.getObject(1);
    assertEquals(expected, actual.toString());
  }

  @Test
  public void testGetObjectParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, String.class, BigQueryStatementParameterType.IN, 0);
    Object actual = statement.getObject(GET_PARAM_KEY);
    assertEquals(expected, actual.toString());
  }

  @Test
  public void testGetObjectParamWithMapByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Map<String, Class<?>> map = new HashMap<>();
    map.putIfAbsent(StandardSQLTypeName.STRING.name(), String.class);
    String expected = "hello";

    statement.getParameterHandler().setParameter(1, expected, String.class);
    Object actual = statement.getObject(1, map);
    assertEquals(expected, actual.toString());
  }

  @Test
  public void testGetObjectParamWithMapByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Map<String, Class<?>> map = new HashMap<>();
    map.putIfAbsent(StandardSQLTypeName.STRING.name(), String.class);
    String expected = "hello";

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, String.class, BigQueryStatementParameterType.IN, 0);
    Object actual = statement.getObject(GET_PARAM_KEY, map);
    assertEquals(expected, actual.toString());
  }

  @Test
  public void testGetObjectParamWithClassByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement.getParameterHandler().setParameter(1, expected, String.class);
    Object actual = statement.getObject(1, String.class);
    assertEquals(expected, actual.toString());
  }

  @Test
  public void testGetObjectParamWithClassByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, String.class, BigQueryStatementParameterType.IN, 0);
    Object actual = statement.getObject(GET_PARAM_KEY, String.class);
    assertEquals(expected, actual.toString());
  }

  @Test
  public void testGetStringParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "test";

    statement.getParameterHandler().setParameter(1, expected, String.class);
    String actual = statement.getString(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetStringParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "test";

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, String.class, BigQueryStatementParameterType.IN, 0);
    String actual = statement.getString(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimeParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Time expected = mock(Time.class);

    statement.getParameterHandler().setParameter(1, expected, Time.class);
    Time actual = statement.getTime(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimeParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Time expected = mock(Time.class);

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Time.class, BigQueryStatementParameterType.IN, 0);
    Time actual = statement.getTime(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimeParamWithCalByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Calendar cal = Calendar.getInstance();
    Time expected = new Time(cal.getTimeInMillis());

    statement.getParameterHandler().setParameter(1, expected, Time.class);
    Time actual = statement.getTime(1, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimeParamWithCalByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Calendar cal = Calendar.getInstance();
    Time expected = new Time(cal.getTimeInMillis());

    statement
        .getParameterHandler()
        .setParameter(GET_PARAM_KEY, expected, Time.class, BigQueryStatementParameterType.IN, 0);
    Time actual = statement.getTime(GET_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimestampParamByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Timestamp expected = mock(Timestamp.class);

    statement.getParameterHandler().setParameter(1, expected, Timestamp.class);
    Timestamp actual = statement.getTimestamp(1);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimestampParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Timestamp expected = mock(Timestamp.class);

    statement
        .getParameterHandler()
        .setParameter(
            GET_PARAM_KEY, expected, Timestamp.class, BigQueryStatementParameterType.IN, 0);
    Timestamp actual = statement.getTimestamp(GET_PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimestampParamWithCalByIndex() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Calendar cal = Calendar.getInstance();
    Timestamp expected = new Timestamp(cal.getTimeInMillis());

    statement.getParameterHandler().setParameter(1, expected, Timestamp.class);
    Timestamp actual = statement.getTimestamp(1, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testGetTimestampParamWithCalByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Calendar cal = Calendar.getInstance();
    Timestamp expected = new Timestamp(cal.getTimeInMillis());

    statement
        .getParameterHandler()
        .setParameter(
            GET_PARAM_KEY, expected, Timestamp.class, BigQueryStatementParameterType.IN, 0);
    Timestamp actual = statement.getTimestamp(GET_PARAM_KEY, cal);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetBigDecimalParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    BigDecimal expected = mock(BigDecimal.class);

    statement.setBigDecimal(PARAM_KEY, expected);
    BigDecimal actual = statement.getBigDecimal(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetBooleanParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Boolean expected = true;

    statement.setBoolean(PARAM_KEY, expected);
    Boolean actual = statement.getBoolean(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetByteParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Byte expected = "hello".getBytes()[0];

    statement.setByte(PARAM_KEY, expected);
    Byte actual = statement.getByte(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetByteArrayParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    byte[] expected = "heelo".getBytes();

    statement.setBytes(PARAM_KEY, expected);
    byte[] actual = statement.getBytes(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetDateParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Date expected = mock(Date.class);
    statement.setDate(PARAM_KEY, expected);
    Date actual = statement.getDate(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetDateCalParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Date expectedDate = mock(Date.class);
    Calendar expectedCal = mock(Calendar.class);

    doReturn(1L).when(expectedDate).getTime();
    doReturn(1L).when(expectedCal).getTime();
    doReturn(1L).when(expectedCal).getTimeInMillis();
    statement.setDate(PARAM_KEY, expectedDate, expectedCal);
    Date actual = statement.getDate(PARAM_KEY);
    assertEquals(new Date(1L), actual);
    actual = statement.getDate(PARAM_KEY, expectedCal);
    assertEquals(new Date(1L), actual);
  }

  @Test
  public void testSetDoubleParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Double expected = 123.123;
    statement.setDouble(PARAM_KEY, expected);
    Double actual = statement.getDouble(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetFloatParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Float expected = 123.123F;
    statement.setFloat(PARAM_KEY, expected);
    Float actual = statement.getFloat(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetIntParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Integer expected = 1;
    statement.setInt(PARAM_KEY, expected);
    Integer actual = statement.getInt(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetLongParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Long expected = 1L;
    statement.setLong(PARAM_KEY, expected);
    Long actual = statement.getLong(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetObjectParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Long expected = 1L;
    statement.setObject(PARAM_KEY, expected);
    Long actual = statement.getObject(PARAM_KEY, Long.class);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetObjectSqlTypeParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Long expected = 1L;
    statement.setObject(PARAM_KEY, expected, java.sql.Types.BIGINT);
    Long actual = statement.getObject(PARAM_KEY, Long.class);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetObjectSqlTypeScaleParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Long expected = 1L;
    statement.setObject(PARAM_KEY, expected, java.sql.Types.BIGINT, 5);
    Long actual = statement.getObject(PARAM_KEY, Long.class);
    assertEquals(expected, actual);
    int scale = statement.getParameterHandler().getParameterScale(PARAM_KEY);
    assertEquals(5, scale);
  }

  @Test
  public void testSetStringParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    String expected = "hello";
    statement.setString(PARAM_KEY, expected);
    String actual = statement.getString(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetTimeParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Time expected = mock(Time.class);
    statement.setTime(PARAM_KEY, expected);
    Time actual = statement.getTime(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetTimeCalParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Time expectedTime = mock(Time.class);
    Calendar expectedCal = mock(Calendar.class);

    doReturn(1L).when(expectedTime).getTime();
    doReturn(1L).when(expectedCal).getTime();
    doReturn(1L).when(expectedCal).getTimeInMillis();
    statement.setTime(PARAM_KEY, expectedTime, expectedCal);
    Time actual = statement.getTime(PARAM_KEY);
    assertEquals(new Time(1L), actual);
    actual = statement.getTime(PARAM_KEY, expectedCal);
    assertEquals(new Time(1L), actual);
  }

  @Test
  public void testSetTimestampParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Timestamp expected = mock(Timestamp.class);
    statement.setTimestamp(PARAM_KEY, expected);
    Timestamp actual = statement.getTimestamp(PARAM_KEY);
    assertEquals(expected, actual);
  }

  @Test
  public void testSetTimestampCalParamByName() throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);
    Timestamp expectedTimestamp = mock(Timestamp.class);
    Calendar expectedCal = mock(Calendar.class);

    doReturn(1L).when(expectedTimestamp).getTime();
    doReturn(1L).when(expectedCal).getTime();
    doReturn(1L).when(expectedCal).getTimeInMillis();
    statement.setTimestamp(PARAM_KEY, expectedTimestamp, expectedCal);
    Timestamp actual = statement.getTimestamp(PARAM_KEY);
    assertEquals(new Timestamp(1L), actual);
    actual = statement.getTimestamp(PARAM_KEY, expectedCal);
    assertEquals(new Timestamp(1L), actual);
  }

  ////////// Private helper methods ////////////////////////
  private void registerOutParamIndexHelper(
      int paramIndex, int javaSqlType, Class<?> javaType, StandardSQLTypeName sqlType, int scale)
      throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);

    if (scale >= 0) {
      statement.registerOutParameter(paramIndex, javaSqlType, scale);
    } else {
      statement.registerOutParameter(paramIndex, javaSqlType);
    }
    BigQueryParameterHandler paramHandler = statement.getParameterHandler();
    assertNotNull(paramHandler);

    assertNull(paramHandler.getParameter(paramIndex));
    assertEquals(BigQueryStatementParameterType.OUT, paramHandler.getParameterType(paramIndex));
    assertEquals(scale, paramHandler.getParameterScale(paramIndex));
    assertEquals(javaType, paramHandler.getType(paramIndex));
    assertEquals(sqlType, paramHandler.getSqlType(paramIndex));
  }

  private void registerOutParamNameHelper(
      String paramName, int javaSqlType, Class<?> javaType, StandardSQLTypeName sqlType, int scale)
      throws SQLException {
    BigQueryCallableStatement statement =
        new BigQueryCallableStatement(bigQueryConnection, "call testProc('?')");
    assertNotNull(statement);

    if (scale >= 0) {
      statement.registerOutParameter(paramName, javaSqlType, scale);
    } else {
      statement.registerOutParameter(paramName, javaSqlType);
    }
    BigQueryParameterHandler paramHandler = statement.getParameterHandler();
    assertNotNull(paramHandler);

    assertNull(paramHandler.getParameter(paramName));
    assertEquals(BigQueryStatementParameterType.OUT, paramHandler.getParameterType(paramName));
    assertEquals(scale, paramHandler.getParameterScale(paramName));
    assertEquals(javaType, paramHandler.getType(paramName));
    assertEquals(sqlType, paramHandler.getSqlType(paramName));
  }
}

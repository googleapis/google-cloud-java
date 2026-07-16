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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.StandardSQLTypeName;
import java.sql.Array;
import java.sql.Types;
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

    preparedStatement.setNull(3, Types.NULL);
    assertNull(preparedStatement.parameterHandler.getParameter(3));
    assertEquals(String.class, preparedStatement.parameterHandler.getType(3));
    assertEquals(StandardSQLTypeName.STRING, preparedStatement.parameterHandler.getSqlType(3));
  }

  @Test
  public void testSetNullWithTypeName() throws Exception {
    preparedStatement.setNull(1, Types.VARCHAR, "VARCHAR");
    assertNull(preparedStatement.parameterHandler.getParameter(1));
    assertEquals(String.class, preparedStatement.parameterHandler.getType(1));
    assertEquals(StandardSQLTypeName.STRING, preparedStatement.parameterHandler.getSqlType(1));
  }

  @Test
  public void testSetShort() throws Exception {
    preparedStatement.setShort(1, (short) 42);
    assertEquals(42L, preparedStatement.parameterHandler.getParameter(1));
    assertEquals(Long.class, preparedStatement.parameterHandler.getType(1));
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
}

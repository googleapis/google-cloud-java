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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.ByteArray;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.Code;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.common.base.Preconditions;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.internal.stubbing.answers.Returns;

@RunWith(JUnit4.class)
public class JdbcResultSetMetaDataTest {
  private JdbcResultSetMetaData subject;
  private java.sql.Connection connection;

  private static class TestColumn {
    private final Type type;
    private final String name;
    private final int defaultSize;
    private final boolean calculated;

    private TestColumn(Type type, String name, Integer nulls, int size, boolean calculated) {
      Preconditions.checkNotNull(type);
      Preconditions.checkNotNull(name);
      Preconditions.checkNotNull(nulls);
      this.type = type;
      this.name = name;
      this.defaultSize = getDefaultSize(type);
      this.calculated = calculated;
    }

    private static int getDefaultSize(Type type) {
      if (type == Type.bool()) return 1;
      if (type == Type.date()) return 10;
      if (type == Type.float64()) return 14;
      if (type == Type.int64()) return 10;
      if (type == Type.timestamp()) return 24;
      if (type == Type.string()) return 50;
      if (type == Type.bytes()) return 50;
      return 50;
    }

    private boolean isTableColumn() {
      return !calculated;
    }

    private static class Builder {
      private Type type;
      private String name;
      private Integer nulls;
      private int size = 0;
      private boolean calculated = false;

      public static Builder getBuilder() {
        return new Builder();
      }

      private TestColumn build() {
        return new TestColumn(type, name, nulls, size, calculated);
      }

      private Builder withType(Type type) {
        this.type = type;
        return this;
      }

      private Builder withName(String name) {
        this.name = name;
        return this;
      }

      private Builder withNotNull() {
        this.nulls = ResultSetMetaData.columnNoNulls;
        return this;
      }

      private Builder withNullable() {
        this.nulls = ResultSetMetaData.columnNullable;
        return this;
      }

      private Builder withNullableUnknown() {
        this.nulls = ResultSetMetaData.columnNullableUnknown;
        return this;
      }

      private Builder withSize(int size) {
        this.size = size;
        return this;
      }

      private Builder withCalculated(boolean calculated) {
        this.calculated = calculated;
        return this;
      }
    }
  }

  private static final List<TestColumn> TEST_COLUMNS = createTestColumns();

  @Before
  public void setup() throws SQLException {
    connection = mock(java.sql.Connection.class);
    Statement statement = mock(Statement.class);
    JdbcResultSet resultSet = getFooTestResultSet(statement);
    when(connection.getSchema()).thenReturn("");
    when(connection.getCatalog()).thenReturn("test-database");
    when(statement.getConnection()).then(new Returns(connection));

    subject = resultSet.getMetaData();
  }

  private static List<TestColumn> createTestColumns() {
    List<TestColumn> res = new ArrayList<>();
    int index = 1;
    for (Type type : getAllTypes()) {
      TestColumn.Builder builder = TestColumn.Builder.getBuilder();
      builder.withName("COL" + index).withType(type).withSize(getDefaultSize(type));
      if (index % 2 == 1) builder.withNotNull();
      else builder.withNullable();
      res.add(builder.build());
      index++;
    }
    TestColumn.Builder builder = TestColumn.Builder.getBuilder();
    builder
        .withName("CALCULATED")
        .withType(Type.int64())
        .withNullableUnknown()
        .withCalculated(true);
    res.add(builder.build());
    return res;
  }

  private static int getDefaultSize(Type type) {
    if (type == Type.string()) return 100;
    return 0;
  }

  private static List<Type> getAllTypes() {
    List<Type> types = new ArrayList<>();
    types.add(Type.bool());
    types.add(Type.bytes());
    types.add(Type.date());
    types.add(Type.float64());
    types.add(Type.int64());
    types.add(Type.string());
    types.add(Type.timestamp());
    List<Type> arrayTypes = new ArrayList<>();
    for (Type type : types) {
      arrayTypes.add(Type.array(type));
    }
    types.addAll(arrayTypes);

    return types;
  }

  private JdbcResultSet getFooTestResultSet(Statement statement) throws SQLException {
    List<Struct> rows = new ArrayList<>(4);
    for (int row = 1; row <= 4; row++) {
      Struct.Builder builder = Struct.newBuilder();
      for (TestColumn col : TEST_COLUMNS) {
        builder.set(col.name).to(getDefaultValue(col.type, row));
      }
      rows.add(builder.build());
    }
    StructField[] fields = new StructField[TEST_COLUMNS.size()];
    int index = 0;
    for (TestColumn col : TEST_COLUMNS) {
      fields[index] = StructField.of(col.name, col.type);
      index++;
    }

    ResultSet rs = ResultSets.forRows(Type.struct(fields), rows);
    return JdbcResultSet.of(statement, rs);
  }

  private Value getDefaultValue(Type type, int row) {
    if (type == Type.bool()) return Value.bool(Boolean.TRUE);
    if (type == Type.bytes()) return Value.bytes(ByteArray.copyFrom("test byte array " + row));
    if (type == Type.date()) return Value.date(com.google.cloud.Date.fromYearMonthDay(2018, 4, 1));
    if (type == Type.float64()) return Value.float64(123.45D);
    if (type == Type.int64()) return Value.int64(12345L);
    if (type == Type.string()) return Value.string("test value " + row);
    if (type == Type.timestamp()) return Value.timestamp(com.google.cloud.Timestamp.now());

    if (type.getCode() == Code.ARRAY) {
      if (type.getArrayElementType() == Type.bool())
        return Value.boolArray(Arrays.asList(Boolean.TRUE, Boolean.FALSE));
      if (type.getArrayElementType() == Type.bytes())
        return Value.bytesArray(
            Arrays.asList(
                ByteArray.copyFrom("test byte array " + row),
                ByteArray.copyFrom("test byte array " + row)));
      if (type.getArrayElementType() == Type.date())
        return Value.dateArray(
            Arrays.asList(
                com.google.cloud.Date.fromYearMonthDay(2018, 4, 1),
                com.google.cloud.Date.fromYearMonthDay(2018, 4, 2)));
      if (type.getArrayElementType() == Type.float64())
        return Value.float64Array(Arrays.asList(123.45D, 543.21D));
      if (type.getArrayElementType() == Type.int64())
        return Value.int64Array(Arrays.asList(12345L, 54321L));
      if (type.getArrayElementType() == Type.string())
        return Value.stringArray(Arrays.asList("test value " + row, "test value " + row));
      if (type.getArrayElementType() == Type.timestamp())
        return Value.timestampArray(
            Arrays.asList(com.google.cloud.Timestamp.now(), com.google.cloud.Timestamp.now()));
    }
    return null;
  }

  @Test
  public void testGetColumnCount() throws SQLException {
    assertEquals(TEST_COLUMNS.size(), subject.getColumnCount());
  }

  @Test
  public void testIsAutoIncrement() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(false, subject.isAutoIncrement(i));
    }
  }

  @Test
  public void testIsCaseSensitive() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      Type type = TEST_COLUMNS.get(i - 1).type;
      assertEquals(type == Type.string() || type == Type.bytes(), subject.isCaseSensitive(i));
    }
  }

  @Test
  public void testIsSearchable() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(true, subject.isSearchable(i));
    }
  }

  @Test
  public void testIsCurrency() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(false, subject.isCurrency(i));
    }
  }

  @Test
  public void testIsNullable() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(ResultSetMetaData.columnNullableUnknown, subject.isNullable(i));
    }
  }

  @Test
  public void testIsSigned() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      Type type = TEST_COLUMNS.get(i - 1).type;
      if (type == Type.int64() || type == Type.float64()) {
        assertTrue(subject.isSigned(i));
      } else {
        assertFalse(subject.isSigned(i));
      }
    }
  }

  @Test
  public void testGetColumnDisplaySize() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(
          getDefaultDisplaySize(TEST_COLUMNS.get(i - 1).type, i), subject.getColumnDisplaySize(i));
    }
  }

  private int getDefaultDisplaySize(Type type, int column) throws SQLException {
    if (type.getCode() == Code.ARRAY) return 50;
    if (type == Type.bool()) return 5;
    if (type == Type.bytes()) return 50;
    if (type == Type.date()) return 10;
    if (type == Type.float64()) return 14;
    if (type == Type.int64()) return 10;
    if (type == Type.string()) {
      int length = subject.getPrecision(column);
      return length == 0 ? 50 : length;
    }
    if (type == Type.timestamp()) return 16;
    return 10;
  }

  @Test
  public void testGetColumnLabel() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(TEST_COLUMNS.get(i - 1).name, subject.getColumnLabel(i));
    }
  }

  @Test
  public void testGetColumnName() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(TEST_COLUMNS.get(i - 1).name, subject.getColumnName(i));
    }
  }

  @Test
  public void testGetSchemaName() throws SQLException {
    assertEquals("", subject.getSchemaName(1));
  }

  @Test
  public void testGetPrecision() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(getPrecision(TEST_COLUMNS.get(i - 1)), subject.getPrecision(i));
    }
  }

  private int getPrecision(TestColumn col) {
    if (col.type == Type.bool()) return 1;
    if (col.type == Type.date()) return 10;
    if (col.type == Type.float64()) return 14;
    if (col.type == Type.int64()) return 10;
    if (col.type == Type.timestamp()) return 24;
    if (col.isTableColumn()) return col.defaultSize;
    return 50;
  }

  @Test
  public void testGetScale() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(getScale(TEST_COLUMNS.get(i - 1)), subject.getScale(i));
    }
  }

  private int getScale(TestColumn col) {
    if (col.type == Type.float64()) return 15;
    return 0;
  }

  @Test
  public void testGetTableName() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals("", subject.getTableName(i));
    }
  }

  @Test
  public void testGetCatalogName() throws SQLException {
    assertEquals("test-database", subject.getCatalogName(1));
  }

  @Test
  public void testGetColumnType() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(getSqlType(TEST_COLUMNS.get(i - 1).type), subject.getColumnType(i));
    }
  }

  private int getSqlType(Type type) {
    if (type == Type.bool()) return Types.BOOLEAN;
    if (type == Type.bytes()) return Types.BINARY;
    if (type == Type.date()) return Types.DATE;
    if (type == Type.float64()) return Types.DOUBLE;
    if (type == Type.int64()) return Types.BIGINT;
    if (type == Type.string()) return Types.NVARCHAR;
    if (type == Type.timestamp()) return Types.TIMESTAMP;
    if (type.getCode() == Code.ARRAY) return Types.ARRAY;
    return Types.OTHER;
  }

  @Test
  public void getColumnTypeName() throws SQLException {
    int index = 1;
    for (TestColumn col : TEST_COLUMNS) {
      assertEquals(col.type.getCode().name(), subject.getColumnTypeName(index));
      index++;
    }
  }

  @Test
  public void testIsReadOnly() throws SQLException {
    for (int i = 0; i < TEST_COLUMNS.size(); i++) {
      assertFalse(subject.isReadOnly(i));
    }
  }

  @Test
  public void testIsWritable() throws SQLException {
    for (int i = 0; i < TEST_COLUMNS.size(); i++) {
      assertTrue(subject.isWritable(i));
    }
  }

  @Test
  public void testIsDefinitelyWritable() throws SQLException {
    for (int i = 0; i < TEST_COLUMNS.size(); i++) {
      assertFalse(subject.isDefinitelyWritable(i));
    }
  }

  @Test
  public void testGetColumnClassName() throws SQLException {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(getTypeClassName(TEST_COLUMNS.get(i - 1).type), subject.getColumnClassName(i));
    }
  }

  private String getTypeClassName(Type type) {
    if (type == Type.bool()) return Boolean.class.getName();
    if (type == Type.bytes()) return byte[].class.getName();
    if (type == Type.date()) return Date.class.getName();
    if (type == Type.float64()) return Double.class.getName();
    if (type == Type.int64()) return Long.class.getName();
    if (type == Type.string()) return String.class.getName();
    if (type == Type.timestamp()) return Timestamp.class.getName();
    if (type.getCode() == Code.ARRAY) {
      if (type.getArrayElementType() == Type.bool()) return Boolean[].class.getName();
      if (type.getArrayElementType() == Type.bytes()) return byte[][].class.getName();
      if (type.getArrayElementType() == Type.date()) return Date[].class.getName();
      if (type.getArrayElementType() == Type.float64()) return Double[].class.getName();
      if (type.getArrayElementType() == Type.int64()) return Long[].class.getName();
      if (type.getArrayElementType() == Type.string()) return String[].class.getName();
      if (type.getArrayElementType() == Type.timestamp()) return Timestamp[].class.getName();
    }
    return null;
  }

  private static final String EXPECTED_TO_STRING =
      "Col 1: COL1 BOOL\n"
          + "Col 2: COL2 BYTES\n"
          + "Col 3: COL3 DATE\n"
          + "Col 4: COL4 FLOAT64\n"
          + "Col 5: COL5 INT64\n"
          + "Col 6: COL6 STRING\n"
          + "Col 7: COL7 TIMESTAMP\n"
          + "Col 8: COL8 ARRAY\n"
          + "Col 9: COL9 ARRAY\n"
          + "Col 10: COL10 ARRAY\n"
          + "Col 11: COL11 ARRAY\n"
          + "Col 12: COL12 ARRAY\n"
          + "Col 13: COL13 ARRAY\n"
          + "Col 14: COL14 ARRAY\n"
          + "Col 15: CALCULATED INT64\n";

  @Test
  public void testToString() {
    assertEquals(subject.toString(), EXPECTED_TO_STRING);
  }
}

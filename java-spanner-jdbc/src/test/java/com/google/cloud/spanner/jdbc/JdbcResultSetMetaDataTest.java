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
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.ResultSets;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
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

  private static class TestColumn {
    private final Type type;
    private final String name;
    private final int defaultSize;
    private final boolean calculated;

    private TestColumn(Type type, String name, Integer nulls, boolean calculated) {
      Preconditions.checkNotNull(type);
      Preconditions.checkNotNull(name);
      Preconditions.checkNotNull(nulls);
      this.type = type;
      this.name = name;
      this.defaultSize = getDefaultSize(type);
      this.calculated = calculated;
    }

    private static int getDefaultSize(Type type) {
      Preconditions.checkNotNull(type);
      switch (type.getCode()) {
        case BOOL:
          return 1;
        case DATE:
          return 10;
        case FLOAT32:
          return 7;
        case FLOAT64:
          return 14;
        case INT64:
          return 10;
        case TIMESTAMP:
          return 24;
        case STRING:
        case BYTES:
        case JSON:
        case PG_JSONB:
          return 50;
        case NUMERIC:
        case PG_NUMERIC:
          return 50;
        case ARRAY:
        case STRUCT:
        default:
          return 50;
      }
    }

    private boolean isTableColumn() {
      return !calculated;
    }

    private static class Builder {
      private Type type;
      private String name;
      private Integer nulls;
      private boolean calculated = false;

      public static Builder getBuilder() {
        return new Builder();
      }

      private TestColumn build() {
        return new TestColumn(type, name, nulls, calculated);
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

      private Builder withCalculated() {
        this.calculated = true;
        return this;
      }
    }
  }

  private static final List<TestColumn> TEST_COLUMNS = createTestColumns();

  @Before
  public void setup() throws SQLException {
    java.sql.Connection connection = mock(java.sql.Connection.class);
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
      builder.withName("COL" + index).withType(type);
      if (index % 2 == 1) {
        builder.withNotNull();
      } else {
        builder.withNullable();
      }
      res.add(builder.build());
      index++;
    }
    TestColumn.Builder builder = TestColumn.Builder.getBuilder();
    TestColumn column =
        builder
            .withName("CALCULATED")
            .withType(Type.int64())
            .withNullableUnknown()
            .withCalculated()
            .build();
    res.add(column);
    return res;
  }

  private static List<Type> getAllTypes() {
    List<Type> types = new ArrayList<>();
    types.add(Type.bool());
    types.add(Type.bytes());
    types.add(Type.date());
    types.add(Type.float32());
    types.add(Type.float64());
    types.add(Type.int64());
    types.add(Type.string());
    types.add(Type.json());
    types.add(Type.pgJsonb());
    types.add(Type.timestamp());
    types.add(Type.numeric());
    types.add(Type.pgNumeric());
    List<Type> arrayTypes = new ArrayList<>();
    for (Type type : types) {
      arrayTypes.add(Type.array(type));
    }
    types.addAll(arrayTypes);

    return types;
  }

  private JdbcResultSet getFooTestResultSet(Statement statement) {
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
    Preconditions.checkNotNull(type);
    switch (type.getCode()) {
      case BOOL:
        return Value.bool(Boolean.TRUE);
      case INT64:
        return Value.int64(12345L);
      case NUMERIC:
        return Value.numeric(new BigDecimal("3.14"));
      case PG_NUMERIC:
        return Value.pgNumeric("3.14");
      case FLOAT32:
        return Value.float32(6.626f);
      case FLOAT64:
        return Value.float64(123.45D);
      case STRING:
        return Value.string("test value " + row);
      case JSON:
        return Value.json("{\"test_value\": " + row + "}");
      case PG_JSONB:
        return Value.pgJsonb("{\"test_value\": " + row + "}");
      case BYTES:
        return Value.bytes(ByteArray.copyFrom("test byte array " + row));
      case TIMESTAMP:
        return Value.timestamp(com.google.cloud.Timestamp.now());
      case DATE:
        return Value.date(com.google.cloud.Date.fromYearMonthDay(2018, 4, 1));
      case ARRAY:
        switch (type.getArrayElementType().getCode()) {
          case BOOL:
            return Value.boolArray(Arrays.asList(Boolean.TRUE, Boolean.FALSE));
          case INT64:
            return Value.int64Array(Arrays.asList(12345L, 54321L));
          case NUMERIC:
            return Value.numericArray(Arrays.asList(BigDecimal.ONE, BigDecimal.TEN));
          case PG_NUMERIC:
            return Value.pgNumericArray(Arrays.asList("3.14", null, "NaN", "6.626"));
          case FLOAT32:
            return Value.float32Array(Arrays.asList(-3498.31490f, 82.353f));
          case FLOAT64:
            return Value.float64Array(Arrays.asList(123.45D, 543.21D));
          case STRING:
            return Value.stringArray(Arrays.asList("test value " + row, "test value " + row));
          case JSON:
            return Value.jsonArray(
                Arrays.asList("{\"test_value\": " + row + "}", "{\"test_value\": " + row + "}"));
          case PG_JSONB:
            return Value.pgJsonbArray(
                Arrays.asList("{\"test_value\": " + row + "}", "{\"test_value\": " + row + "}"));
          case BYTES:
            return Value.bytesArray(
                Arrays.asList(
                    ByteArray.copyFrom("test byte array " + row),
                    ByteArray.copyFrom("test byte array " + row)));
          case TIMESTAMP:
            return Value.timestampArray(
                Arrays.asList(com.google.cloud.Timestamp.now(), com.google.cloud.Timestamp.now()));
          case DATE:
            return Value.dateArray(
                Arrays.asList(
                    com.google.cloud.Date.fromYearMonthDay(2018, 4, 1),
                    com.google.cloud.Date.fromYearMonthDay(2018, 4, 2)));
          case ARRAY:
          case STRUCT:
        }
      case STRUCT:
      default:
        return null;
    }
  }

  @Test
  public void testGetColumnCount() {
    assertEquals(TEST_COLUMNS.size(), subject.getColumnCount());
  }

  @Test
  public void testIsAutoIncrement() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertFalse(subject.isAutoIncrement(i));
    }
  }

  @Test
  public void testIsCaseSensitive() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      Type type = TEST_COLUMNS.get(i - 1).type;
      assertEquals(
          type == Type.string()
              || type == Type.bytes()
              || type == Type.json()
              || type == Type.pgJsonb(),
          subject.isCaseSensitive(i));
    }
  }

  @Test
  public void testIsSearchable() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertTrue(subject.isSearchable(i));
    }
  }

  @Test
  public void testIsCurrency() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertFalse(subject.isCurrency(i));
    }
  }

  @Test
  public void testIsNullable() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(ResultSetMetaData.columnNullableUnknown, subject.isNullable(i));
    }
  }

  @Test
  public void testIsSigned() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      Type type = TEST_COLUMNS.get(i - 1).type;
      if (type == Type.int64()
          || type == Type.float64()
          || type == Type.numeric()
          || type == Type.pgNumeric()) {
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
          "Wrong column display size for " + TEST_COLUMNS.get(i - 1).type,
          getDefaultDisplaySize(TEST_COLUMNS.get(i - 1).type, i),
          subject.getColumnDisplaySize(i));
    }
  }

  private int getDefaultDisplaySize(Type type, int column) throws SQLException {
    Preconditions.checkNotNull(type);
    switch (type.getCode()) {
      case BOOL:
        return 5;
      case INT64:
        return 10;
      case FLOAT32:
        return 7;
      case NUMERIC:
      case PG_NUMERIC:
        return 14;
      case FLOAT64:
        return 14;
      case STRING:
        int length = subject.getPrecision(column);
        return length == 0 ? 50 : length;
      case JSON:
      case PG_JSONB:
        return 50;
      case BYTES:
        return 50;
      case TIMESTAMP:
        return 16;
      case DATE:
        return 10;
      case ARRAY:
        return 50;
      case STRUCT:
      default:
        return 10;
    }
  }

  @Test
  public void testGetColumnLabel() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(TEST_COLUMNS.get(i - 1).name, subject.getColumnLabel(i));
    }
  }

  @Test
  public void testGetColumnName() {
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
      assertEquals(
          "Wrong precision for type " + TEST_COLUMNS.get(i - 1).type,
          getPrecision(TEST_COLUMNS.get(i - 1)),
          subject.getPrecision(i));
    }
  }

  private int getPrecision(TestColumn col) {
    Preconditions.checkNotNull(col);
    switch (col.type.getCode()) {
      case BOOL:
        return 1;
      case DATE:
        return 10;
      case FLOAT32:
        return 7;
      case FLOAT64:
        return 14;
      case INT64:
        return 10;
      case TIMESTAMP:
        return 24;
      case NUMERIC:
      case PG_NUMERIC:
        return 14;
      case STRING:
      case JSON:
      case PG_JSONB:
      case BYTES:
      case ARRAY:
      case STRUCT:
      default:
        return col.isTableColumn() ? col.defaultSize : 50;
    }
  }

  @Test
  public void testGetScale() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(getScale(TEST_COLUMNS.get(i - 1)), subject.getScale(i));
    }
  }

  private int getScale(TestColumn col) {
    if (col.type == Type.float32()) {
      return 7;
    }
    if (col.type == Type.float64() || col.type == Type.numeric() || col.type == Type.pgNumeric()) {
      return 15;
    }
    return 0;
  }

  @Test
  public void testGetTableName() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals("", subject.getTableName(i));
    }
  }

  @Test
  public void testGetCatalogName() throws SQLException {
    assertEquals("test-database", subject.getCatalogName(1));
  }

  @Test
  public void testGetColumnType() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(getSqlType(TEST_COLUMNS.get(i - 1).type), subject.getColumnType(i));
    }
  }

  private int getSqlType(Type type) {
    Preconditions.checkNotNull(type);
    switch (type.getCode()) {
      case BOOL:
        return Types.BOOLEAN;
      case INT64:
        return Types.BIGINT;
      case NUMERIC:
      case PG_NUMERIC:
        return Types.NUMERIC;
      case FLOAT32:
        return Types.REAL;
      case FLOAT64:
        return Types.DOUBLE;
      case STRING:
      case JSON:
      case PG_JSONB:
        return Types.NVARCHAR;
      case BYTES:
        return Types.BINARY;
      case TIMESTAMP:
        return Types.TIMESTAMP;
      case DATE:
        return Types.DATE;
      case ARRAY:
        return Types.ARRAY;
      case STRUCT:
      default:
        return Types.OTHER;
    }
  }

  @Test
  public void getColumnTypeName() {
    int index = 1;
    for (TestColumn col : TEST_COLUMNS) {
      assertEquals(col.type.getCode().name(), subject.getColumnTypeName(index));
      index++;
    }
  }

  @Test
  public void getColumnTypeNameForPostgreSQL() throws SQLException {
    JdbcConnection connection = mock(JdbcConnection.class);
    JdbcStatement statement = mock(JdbcStatement.class);
    JdbcResultSet resultSet = getFooTestResultSet(statement);
    when(connection.getSchema()).thenReturn("");
    when(connection.getCatalog()).thenReturn("test-database");
    when(statement.getConnection()).then(new Returns(connection));
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);

    JdbcResultSetMetaData sub = resultSet.getMetaData();

    int index = 1;
    for (TestColumn col : TEST_COLUMNS) {
      if (col.type.getCode() == Type.Code.ARRAY
          && col.type.getSpannerTypeName(Dialect.POSTGRESQL).contains("bool")) {
        assertEquals("_boolean", sub.getColumnTypeName(index));
      } else if (col.type.getCode() == Type.Code.BOOL) {
        assertEquals("boolean", sub.getColumnTypeName(index));
      }
      index++;
    }
  }

  @Test
  public void testIsReadOnly() {
    for (int i = 0; i < TEST_COLUMNS.size(); i++) {
      assertFalse(subject.isReadOnly(i));
    }
  }

  @Test
  public void testIsWritable() {
    for (int i = 0; i < TEST_COLUMNS.size(); i++) {
      assertTrue(subject.isWritable(i));
    }
  }

  @Test
  public void testIsDefinitelyWritable() {
    for (int i = 0; i < TEST_COLUMNS.size(); i++) {
      assertFalse(subject.isDefinitelyWritable(i));
    }
  }

  @Test
  public void testGetColumnClassName() {
    for (int i = 1; i <= TEST_COLUMNS.size(); i++) {
      assertEquals(getTypeClassName(TEST_COLUMNS.get(i - 1).type), subject.getColumnClassName(i));
    }
  }

  private String getTypeClassName(Type type) {
    Preconditions.checkNotNull(type);
    switch (type.getCode()) {
      case BOOL:
        return Boolean.class.getName();
      case INT64:
        return Long.class.getName();
      case NUMERIC:
      case PG_NUMERIC:
        return BigDecimal.class.getName();
      case FLOAT32:
        return Float.class.getName();
      case FLOAT64:
        return Double.class.getName();
      case STRING:
      case JSON:
      case PG_JSONB:
        return String.class.getName();
      case BYTES:
        return byte[].class.getName();
      case TIMESTAMP:
        return Timestamp.class.getName();
      case DATE:
        return Date.class.getName();
      case ARRAY:
        switch (type.getArrayElementType().getCode()) {
          case BOOL:
            return Boolean[].class.getName();
          case INT64:
            return Long[].class.getName();
          case NUMERIC:
          case PG_NUMERIC:
            return BigDecimal[].class.getName();
          case FLOAT32:
            return Float[].class.getName();
          case FLOAT64:
            return Double[].class.getName();
          case STRING:
          case JSON:
          case PG_JSONB:
            return String[].class.getName();
          case BYTES:
            return byte[][].class.getName();
          case TIMESTAMP:
            return Timestamp[].class.getName();
          case DATE:
            return Date[].class.getName();
          case ARRAY:
          case STRUCT:
          default:
            // fallthrough
        }
      case STRUCT:
      default:
        return null;
    }
  }

  private static final String EXPECTED_TO_STRING =
      "Col 1: COL1 BOOL\n"
          + "Col 2: COL2 BYTES\n"
          + "Col 3: COL3 DATE\n"
          + "Col 4: COL4 FLOAT32\n"
          + "Col 5: COL5 FLOAT64\n"
          + "Col 6: COL6 INT64\n"
          + "Col 7: COL7 STRING\n"
          + "Col 8: COL8 JSON\n"
          + "Col 9: COL9 PG_JSONB\n"
          + "Col 10: COL10 TIMESTAMP\n"
          + "Col 11: COL11 NUMERIC\n"
          + "Col 12: COL12 PG_NUMERIC\n"
          + "Col 13: COL13 ARRAY\n"
          + "Col 14: COL14 ARRAY\n"
          + "Col 15: COL15 ARRAY\n"
          + "Col 16: COL16 ARRAY\n"
          + "Col 17: COL17 ARRAY\n"
          + "Col 18: COL18 ARRAY\n"
          + "Col 19: COL19 ARRAY\n"
          + "Col 20: COL20 ARRAY\n"
          + "Col 21: COL21 ARRAY\n"
          + "Col 22: COL22 ARRAY\n"
          + "Col 23: COL23 ARRAY\n"
          + "Col 24: COL24 ARRAY\n"
          + "Col 25: CALCULATED INT64\n";

  @Test
  public void testToString() {
    assertEquals(subject.toString(), EXPECTED_TO_STRING);
  }
}

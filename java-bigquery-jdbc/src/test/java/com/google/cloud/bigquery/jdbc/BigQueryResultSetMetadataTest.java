/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.sql.Array;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.concurrent.Future;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BigQueryResultSetMetadataTest {

  private BigQueryStatement statement;

  private static Field tenthField =
      Field.newBuilder("tenth", LegacySQLTypeName.NUMERIC)
          .setName("tenth")
          .setType(StandardSQLTypeName.NUMERIC)
          .setPrecision(12L)
          .setScale(9L)
          .build();
  private static final FieldList fieldList =
      FieldList.of(
          Field.of("first", StandardSQLTypeName.BOOL),
          Field.of("second", StandardSQLTypeName.INT64),
          Field.of("third", StandardSQLTypeName.FLOAT64),
          Field.of("fourth", StandardSQLTypeName.STRING),
          Field.of("fifth", StandardSQLTypeName.TIMESTAMP),
          Field.of("sixth", StandardSQLTypeName.BYTES),
          Field.of("seventh", StandardSQLTypeName.STRING),
          Field.newBuilder("eight", StandardSQLTypeName.STRING)
              .setMode(Field.Mode.REPEATED)
              .build(),
          Field.of(
              "ninth",
              StandardSQLTypeName.STRUCT,
              Field.of("first", StandardSQLTypeName.FLOAT64),
              Field.of("second", StandardSQLTypeName.TIMESTAMP)),
          tenthField,
          Field.of("eleventh", StandardSQLTypeName.BIGNUMERIC),
          Field.of("twelfth", LegacySQLTypeName.TIME),
          Field.of("thirteenth", LegacySQLTypeName.DATE));

  private static final Schema QUERY_SCHEMA = Schema.of(fieldList);

  private ResultSetMetaData resultSetMetaData;

  private ResultSetMetaData resultSetMetaDataNested;

  @BeforeEach
  public void setUp() throws SQLException {
    statement = mock(BigQueryStatement.class);
    Future<?>[] workerTasks = {mock(Future.class)};
    BigQueryJsonResultSet bigQueryJsonResultSet =
        BigQueryJsonResultSet.of(QUERY_SCHEMA, 1L, null, statement, workerTasks);
    // values for nested types
    resultSetMetaData = bigQueryJsonResultSet.getMetaData();

    // values for nested types
    Field fieldEight = fieldList.get("eight");
    // The schema for the nested result set should describe the elements of the array.
    Field elementField = fieldEight.toBuilder().setMode(Field.Mode.NULLABLE).build();
    FieldList nestedFieldList = FieldList.of(elementField);
    BigQueryFieldValueListWrapper bigQueryFieldValueListWrapperNested =
        BigQueryFieldValueListWrapper.getNestedFieldValueListWrapper(nestedFieldList, null);
    BigQueryJsonResultSet bigQueryJsonResultSetNested =
        BigQueryJsonResultSet.getNestedResultSet(
            Schema.of(nestedFieldList), bigQueryFieldValueListWrapperNested, -1, -1);
    resultSetMetaDataNested = bigQueryJsonResultSetNested.getMetaData();
  }

  @ParameterizedTest
  @MethodSource("columnMetadataProvider")
  public void testColumnMetadata(
      int columnIndex,
      int expectedSqlType,
      String expectedColumnTypeName,
      String expectedClassName,
      int expectedPrecision,
      int expectedScale)
      throws SQLException {
    assertThat(resultSetMetaData.getColumnType(columnIndex)).isEqualTo(expectedSqlType);
    assertThat(resultSetMetaData.getColumnTypeName(columnIndex)).isEqualTo(expectedColumnTypeName);
    assertThat(resultSetMetaData.getColumnClassName(columnIndex)).isEqualTo(expectedClassName);
    assertThat(resultSetMetaData.getPrecision(columnIndex)).isEqualTo(expectedPrecision);
    assertThat(resultSetMetaData.getScale(columnIndex)).isEqualTo(expectedScale);
  }

  private static Stream<Arguments> columnMetadataProvider() {
    return Stream.of(
        arguments(1, Types.BOOLEAN, "BOOL", "java.lang.Boolean", 1, 0),
        arguments(2, Types.BIGINT, "INT64", "java.lang.Long", 19, 0),
        arguments(3, Types.DOUBLE, "FLOAT64", "java.lang.Double", 15, 0),
        arguments(4, Types.NVARCHAR, "STRING", "java.lang.String", 0, 0),
        arguments(5, Types.TIMESTAMP, "TIMESTAMP", "java.sql.Timestamp", 26, 6),
        arguments(6, Types.VARBINARY, "BYTES", byte[].class.getName(), 0, 0),
        arguments(7, Types.NVARCHAR, "STRING", "java.lang.String", 0, 0),
        arguments(8, Types.ARRAY, "ARRAY", Array.class.getName(), 0, 0),
        arguments(9, Types.STRUCT, "STRUCT", "java.sql.Struct", 0, 0),
        arguments(10, Types.NUMERIC, "NUMERIC", "java.math.BigDecimal", 12, 9),
        arguments(11, Types.NUMERIC, "BIGNUMERIC", "java.math.BigDecimal", 77, 38),
        arguments(12, Types.TIME, "TIME", "java.sql.Time", 15, 6),
        arguments(13, Types.DATE, "DATE", "java.sql.Date", 10, 0));
  }

  @Test
  public void testResultSetMetadataProperties() throws SQLException {
    assertThat(resultSetMetaData).isNotNull();
    assertThat(resultSetMetaData.getColumnCount()).isEqualTo(13);
    assertThat(resultSetMetaData.isAutoIncrement(1)).isFalse();
    assertThat(resultSetMetaData.isSearchable(4)).isTrue();
    assertThat(resultSetMetaData.isCurrency(4)).isFalse();
    assertThat(resultSetMetaData.isReadOnly(4)).isFalse();
    assertThat(resultSetMetaData.isDefinitelyWritable(4)).isFalse();
    assertThat(resultSetMetaData.isWritable(4)).isTrue();
    assertThat(resultSetMetaData.isNullable(4)).isEqualTo(ResultSetMetaData.columnNullableUnknown);
  }

  @Test
  public void testSigned() throws SQLException {
    assertThat(resultSetMetaData.isSigned(4)).isFalse();
    assertThat(resultSetMetaData.isSigned(2)).isTrue();
  }

  @Test
  public void testCheckNameLabelCatalog() throws SQLException {
    assertThat(resultSetMetaData.getColumnLabel(1)).isEqualTo("first");
    assertThat(resultSetMetaData.getColumnName(10)).isEqualTo("tenth");
    assertThat(resultSetMetaData.getColumnName(10)).isEqualTo("tenth");
    assertThat(resultSetMetaData.getSchemaName(10)).isEqualTo("");
    assertThat(resultSetMetaData.getCatalogName(10)).isEqualTo("");
  }

  @Test
  public void testCheckCaseSensitive() throws SQLException {
    assertThat(resultSetMetaData.isCaseSensitive(2)).isFalse();
    assertThat(resultSetMetaData.isCaseSensitive(4)).isTrue();
  }

  @Test
  public void testScale() throws SQLException {
    assertThat(resultSetMetaData.getScale(1)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(2)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(3)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(4)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(5)).isEqualTo(6);
    assertThat(resultSetMetaData.getScale(6)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(7)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(8)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(9)).isEqualTo(0);
    assertThat(resultSetMetaData.getScale(10)).isEqualTo(9);
    assertThat(resultSetMetaData.getScale(11)).isEqualTo(38);
    assertThat(resultSetMetaData.getScale(12)).isEqualTo(6);
    assertThat(resultSetMetaData.getScale(13)).isEqualTo(0);
  }

  @Test
  public void testColumnDisplaySize() throws SQLException {
    assertThat(resultSetMetaData.getColumnDisplaySize(1)).isEqualTo(5);
    assertThat(resultSetMetaData.getColumnDisplaySize(13)).isEqualTo(10);
    assertThat(resultSetMetaData.getColumnDisplaySize(2)).isEqualTo(10);
    assertThat(resultSetMetaData.getColumnDisplaySize(3)).isEqualTo(14);
    assertThat(resultSetMetaData.getColumnDisplaySize(12)).isEqualTo(50);
    assertThat(resultSetMetaData.getColumnDisplaySize(5)).isEqualTo(16);
  }

  // Nested Types

  @Test
  public void testResultSetMetaDataNestedColType() throws SQLException {
    assertThat(resultSetMetaDataNested).isNotNull();
    assertThat(resultSetMetaDataNested.getColumnType(1)).isEqualTo(Types.NVARCHAR);
    assertThat(resultSetMetaDataNested.getColumnClassName(1)).isEqualTo("java.lang.String");
  }

  @Test
  public void testNestedresultSetMetaDataNestedProperties() throws SQLException {
    assertThat(resultSetMetaDataNested.getColumnCount()).isEqualTo(1);
    assertThat(resultSetMetaDataNested.isAutoIncrement(1)).isFalse();
    assertThat(resultSetMetaDataNested.isSearchable(1)).isTrue();
    assertThat(resultSetMetaDataNested.isCurrency(1)).isFalse();
    assertThat(resultSetMetaDataNested.isReadOnly(1)).isFalse();
    assertThat(resultSetMetaDataNested.isDefinitelyWritable(1)).isFalse();
    assertThat(resultSetMetaDataNested.isWritable(1)).isTrue();
    assertThat(resultSetMetaDataNested.isNullable(1)).isEqualTo(ResultSetMetaData.columnNullable);
  }

  @Test
  public void testNestedPrecision() throws SQLException {
    assertThat(resultSetMetaDataNested.getPrecision(1))
        .isEqualTo(0); // schema doesn't have this info, should be defaulted to 0
  }

  @Test
  public void testNestedSigned() throws SQLException {
    assertThat(resultSetMetaDataNested.isSigned(1)).isFalse();
  }

  @Test
  public void testNestedCheckNameLabelCatalog() throws SQLException {
    assertThat(resultSetMetaDataNested.getColumnLabel(1)).isEqualTo("eight");
    assertThat(resultSetMetaDataNested.getColumnName(1)).isEqualTo("eight");
    assertThat(resultSetMetaDataNested.getSchemaName(1)).isEqualTo("");
    assertThat(resultSetMetaDataNested.getCatalogName(1)).isEqualTo("");
  }

  @Test
  public void testNestedCheckCaseSensitive() throws SQLException {
    assertThat(resultSetMetaDataNested.isCaseSensitive(1)).isTrue();
  }

  @Test
  public void testNestedScale() throws SQLException {
    assertThat(resultSetMetaDataNested.getScale(1)).isEqualTo(0L);
  }

  @Test
  public void testNestedColumnDisplaySize() throws SQLException {
    assertThat(resultSetMetaDataNested.getColumnDisplaySize(1)).isEqualTo(50);
  }

  @Test
  public void testWrapperMethods() throws SQLException {
    assertThat(resultSetMetaData.isWrapperFor(ResultSetMetaData.class)).isTrue();
    assertThat(resultSetMetaData.isWrapperFor(BigQueryResultSetMetadata.class)).isTrue();
    assertThat(resultSetMetaData.isWrapperFor(java.sql.Connection.class)).isFalse();
    assertThat(resultSetMetaData.isWrapperFor(null)).isFalse();

    Object unwrappedMeta = resultSetMetaData.unwrap(ResultSetMetaData.class);
    assertThat(unwrappedMeta).isNotSameInstanceAs(resultSetMetaData);
    assertThat(unwrappedMeta).isInstanceOf(BigQueryResultSetMetadata.class);

    Object unwrappedImpl = resultSetMetaData.unwrap(BigQueryResultSetMetadata.class);
    assertThat(unwrappedImpl).isNotSameInstanceAs(resultSetMetaData);
    assertThat(unwrappedImpl).isInstanceOf(BigQueryResultSetMetadata.class);

    BigQueryJdbcException e =
        assertThrows(
            BigQueryJdbcException.class, () -> resultSetMetaData.unwrap(java.sql.Connection.class));
    assertThat((Throwable) e).hasMessageThat().contains("Cannot unwrap to java.sql.Connection");
  }

  @ParameterizedTest
  @EnumSource(StandardSQLTypeName.class)
  public void testIsSearchableForAllTypes(StandardSQLTypeName type) throws SQLException {
    Field field;
    if (type == StandardSQLTypeName.STRUCT) {
      field =
          Field.of("col", StandardSQLTypeName.STRUCT, Field.of("sub", StandardSQLTypeName.STRING));
    } else if (type == StandardSQLTypeName.ARRAY) {
      field =
          Field.newBuilder("col", StandardSQLTypeName.STRING).setMode(Field.Mode.REPEATED).build();
    } else {
      field = Field.of("col", type);
    }
    FieldList schemaFields = FieldList.of(field);
    BigQueryJsonResultSet resultSet =
        BigQueryJsonResultSet.of(
            Schema.of(schemaFields), 1L, null, statement, new Future<?>[] {mock(Future.class)});
    ResultSetMetaData metaData = resultSet.getMetaData();
    assertThat(metaData.isSearchable(1)).isTrue();
  }
}

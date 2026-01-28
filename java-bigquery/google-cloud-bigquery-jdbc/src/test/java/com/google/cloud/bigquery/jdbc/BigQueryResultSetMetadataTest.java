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
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.common.collect.ImmutableList;
import java.sql.Array;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
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

  private static final List fieldListSqlTypes =
      ImmutableList.of(
          Types.BOOLEAN,
          Types.BIGINT,
          Types.DOUBLE,
          Types.NVARCHAR,
          Types.TIMESTAMP,
          Types.VARBINARY,
          Types.NVARCHAR,
          Types.ARRAY,
          Types.STRUCT,
          Types.NUMERIC,
          Types.NUMERIC,
          Types.TIME,
          Types.DATE);

  private static final List fieldListClassNames =
      ImmutableList.of(
          "java.lang.Boolean",
          "java.lang.Long",
          "java.lang.Double",
          "java.lang.String",
          "java.sql.Timestamp",
          byte[].class.getName(),
          "java.lang.String",
          Array.class.getName(),
          "java.sql.Struct",
          "java.math.BigDecimal",
          "java.math.BigDecimal",
          "java.sql.Time",
          "java.sql.Date");
  private static final Schema QUERY_SCHEMA = Schema.of(fieldList);

  private ResultSetMetaData resultSetMetaData;

  private ResultSetMetaData resultSetMetaDataNested;

  @Before
  public void setUp() throws SQLException {
    statement = mock(BigQueryStatement.class);
    Thread[] workerThreads = {new Thread()};
    BigQueryJsonResultSet bigQueryJsonResultSet =
        BigQueryJsonResultSet.of(QUERY_SCHEMA, 1L, null, statement, workerThreads);
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

  @Test
  public void testGetColumnType() throws SQLException {
    // match the mapping for all the types in the test dataset
    for (int colIndex = 1; colIndex <= 13; colIndex++) {
      assertThat(resultSetMetaData.getColumnType(colIndex))
          .isEqualTo(fieldListSqlTypes.get(colIndex - 1));
    }
  }

  @Test
  public void testGetColumnTypeName() throws SQLException {
    assertThat(resultSetMetaData.getColumnTypeName(1)).isEqualTo("BOOL");
    assertThat(resultSetMetaData.getColumnTypeName(2)).isEqualTo("INT64");
    assertThat(resultSetMetaData.getColumnTypeName(3)).isEqualTo("FLOAT64");
    assertThat(resultSetMetaData.getColumnTypeName(4)).isEqualTo("STRING");
    assertThat(resultSetMetaData.getColumnTypeName(5)).isEqualTo("TIMESTAMP");
    assertThat(resultSetMetaData.getColumnTypeName(6)).isEqualTo("BYTES");
    assertThat(resultSetMetaData.getColumnTypeName(7)).isEqualTo("STRING");
    assertThat(resultSetMetaData.getColumnTypeName(8)).isEqualTo("ARRAY");
    assertThat(resultSetMetaData.getColumnTypeName(9)).isEqualTo("STRUCT");
    assertThat(resultSetMetaData.getColumnTypeName(10)).isEqualTo("NUMERIC");
    assertThat(resultSetMetaData.getColumnTypeName(11)).isEqualTo("BIGNUMERIC");
    assertThat(resultSetMetaData.getColumnTypeName(12)).isEqualTo("TIME");
    assertThat(resultSetMetaData.getColumnTypeName(13)).isEqualTo("DATE");
  }

  @Test
  public void testColumnClassName()
      throws SQLException { // match the mapping for all the types in the test dataset
    for (int colIndex = 1; colIndex <= 13; colIndex++) {
      assertThat(resultSetMetaData.getColumnClassName(colIndex))
          .isEqualTo(fieldListClassNames.get(colIndex - 1));
    }
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
  public void testPrecision() throws SQLException {
    assertThat(resultSetMetaData.getPrecision(10)).isEqualTo(12L);
    assertThat(resultSetMetaData.getPrecision(1))
        .isEqualTo(0); // schema doesn't have this info, should be defaulted to 0
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
    assertThat(resultSetMetaData.getScale(10)).isEqualTo(9L);
    assertThat(resultSetMetaData.getScale(4)).isEqualTo(0L);
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
}

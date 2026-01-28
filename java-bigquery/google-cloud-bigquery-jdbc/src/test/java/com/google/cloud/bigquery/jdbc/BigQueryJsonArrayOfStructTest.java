/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.FieldValue.Attribute.PRIMITIVE;
import static com.google.cloud.bigquery.LegacySQLTypeName.RECORD;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.INVALID_ARRAY;
import static com.google.cloud.bigquery.jdbc.utils.TestUtilities.nestedResultSetToColumnLists;
import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertThrows;

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class BigQueryJsonArrayOfStructTest {

  private Array array;

  @Before
  public void setUp() {
    FieldList profileSchema =
        FieldList.of(
            Field.newBuilder("name", LegacySQLTypeName.STRING).build(),
            Field.newBuilder("age", LegacySQLTypeName.INTEGER).build(),
            Field.newBuilder("adult", LegacySQLTypeName.BOOLEAN).build());

    FieldValue record1 =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                asList(
                    FieldValue.of(PRIMITIVE, "Arya"),
                    FieldValue.of(PRIMITIVE, "15"),
                    FieldValue.of(PRIMITIVE, "false"))));
    FieldValue record2 =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                asList(
                    FieldValue.of(PRIMITIVE, "Khal Drogo"),
                    FieldValue.of(PRIMITIVE, "35"),
                    FieldValue.of(PRIMITIVE, "true"))));
    FieldValue record3 =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                asList(
                    FieldValue.of(PRIMITIVE, "Ned Stark"),
                    FieldValue.of(PRIMITIVE, "45"),
                    FieldValue.of(PRIMITIVE, "true"))));
    FieldValue record4 =
        FieldValue.of(
            Attribute.RECORD,
            FieldValueList.of(
                asList(
                    FieldValue.of(PRIMITIVE, "Jon Snow"),
                    FieldValue.of(PRIMITIVE, "25"),
                    FieldValue.of(PRIMITIVE, "true"))));

    Field arrayOfStructSchema =
        Field.newBuilder("profiles", RECORD, profileSchema).setMode(Mode.REPEATED).build();

    FieldValue arrayOfStructValue =
        FieldValue.of(
            Attribute.REPEATED, FieldValueList.of(asList(record1, record2, record3, record4)));
    array = new BigQueryJsonArray(arrayOfStructSchema, arrayOfStructValue);
  }

  @Test
  public void getArray() throws SQLException {
    Struct[] structArray = (Struct[]) array.getArray();

    assertThat(structArray.length).isEqualTo(4);
    assertThat(structArray[0].getAttributes()).isEqualTo(asList("Arya", 15L, false).toArray());
    assertThat(structArray[1].getAttributes()).isEqualTo(asList("Khal Drogo", 35L, true).toArray());
    assertThat(structArray[2].getAttributes()).isEqualTo(asList("Ned Stark", 45L, true).toArray());
    assertThat(structArray[3].getAttributes()).isEqualTo(asList("Jon Snow", 25L, true).toArray());
  }

  @Test
  public void getSlicedArray() throws SQLException {
    Struct[] structArray = (Struct[]) array.getArray(2, 2);

    assertThat(structArray.length).isEqualTo(2);
    assertThat(structArray[0].getAttributes()).isEqualTo(asList("Khal Drogo", 35L, true).toArray());
    assertThat(structArray[1].getAttributes()).isEqualTo(asList("Ned Stark", 45L, true).toArray());
  }

  @Test
  public void getSlicedArrayWhenCountIsGreaterThanOriginalArrayLength() {
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> array.getArray(2, 10));
    assertThat(illegalArgumentException.getMessage())
        .isEqualTo("The array index is out of range: 12, number of elements: 4.");
  }

  @Test
  public void getResultSet() throws SQLException {
    ResultSet resultSet = array.getResultSet();
    Tuple<ArrayList<Object>, ArrayList<Struct>> indexAndValues =
        nestedResultSetToColumnLists(resultSet);

    ArrayList<Object> indexList = indexAndValues.x();
    ArrayList<Struct> structs = indexAndValues.y();

    assertThat(indexList.toArray()).isEqualTo(new Object[] {1, 2, 3, 4});
    assertThat(structs.get(0).getAttributes()).isEqualTo(asList("Arya", 15L, false).toArray());
    assertThat(structs.get(1).getAttributes()).isEqualTo(asList("Khal Drogo", 35L, true).toArray());
    assertThat(structs.get(2).getAttributes()).isEqualTo(asList("Ned Stark", 45L, true).toArray());
    assertThat(structs.get(3).getAttributes()).isEqualTo(asList("Jon Snow", 25L, true).toArray());
  }

  @Test
  public void getSlicedResultSet() throws SQLException {
    ResultSet resultSet = array.getResultSet(2, 2);
    Tuple<ArrayList<Object>, ArrayList<Struct>> indexAndValues =
        nestedResultSetToColumnLists(resultSet);

    ArrayList<Object> indexList = indexAndValues.x();
    ArrayList<Struct> structs = indexAndValues.y();

    assertThat(indexList.toArray()).isEqualTo(new Object[] {2, 3});
    assertThat(structs.get(0).getAttributes()).isEqualTo(asList("Khal Drogo", 35L, true).toArray());
    assertThat(structs.get(1).getAttributes()).isEqualTo(asList("Ned Stark", 45L, true).toArray());
  }

  @Test
  public void getResultSetWhenCountIsGreaterThanOriginalArrayLength() {
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> array.getResultSet(2, 10));
    assertThat(illegalArgumentException.getMessage())
        .isEqualTo("The array index is out of range: 12, number of elements: 4.");
  }

  @Test
  public void getBaseTypeName() throws SQLException {
    assertThat(array.getBaseTypeName()).isEqualTo(StandardSQLTypeName.STRUCT.name());
  }

  @Test
  public void getBaseType() throws SQLException {
    assertThat(array.getBaseType()).isEqualTo(Types.STRUCT);
  }

  @Test
  public void free() throws SQLException {
    this.array.free();

    ensureArrayIsInvalid(() -> array.getArray());
    ensureArrayIsInvalid(() -> array.getArray(1, 2));
    ensureArrayIsInvalid(() -> array.getBaseTypeName());
    ensureArrayIsInvalid(() -> array.getBaseType());
  }

  @Test
  public void getArrayWithCustomTypeMappingsIsNotSupported() {
    Exception exception1 =
        assertThrows(SQLFeatureNotSupportedException.class, () -> array.getArray(emptyMap()));
    Exception exception2 =
        assertThrows(SQLFeatureNotSupportedException.class, () -> array.getArray(1, 2, emptyMap()));
    assertThat(exception1.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
    assertThat(exception2.getMessage()).isEqualTo(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  private void ensureArrayIsInvalid(ThrowingRunnable block) {
    Exception exception = Assert.assertThrows(IllegalStateException.class, block);
    assertThat(exception.getMessage()).isEqualTo(INVALID_ARRAY);
  }
}

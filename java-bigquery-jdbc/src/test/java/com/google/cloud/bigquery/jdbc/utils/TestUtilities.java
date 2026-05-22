/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.jdbc.utils;

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.sql.ConnectionEvent;
import javax.sql.ConnectionEventListener;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.JsonStringHashMap;

public class TestUtilities {

  public static Tuple<Field, FieldValue> primitiveSchemaAndValue(
      StandardSQLTypeName typeName, String value) {
    Field schema =
        Field.newBuilder(typeName.name() + "_column", typeName).setMode(Mode.NULLABLE).build();
    FieldValue primitiveValue = FieldValue.of(Attribute.PRIMITIVE, value);

    return Tuple.of(schema, primitiveValue);
  }

  public static Tuple<Field, FieldValue> arraySchemaAndValue(
      StandardSQLTypeName typeName, String... values) {
    Field schema =
        Field.newBuilder(typeName.name() + "_arr_column", typeName).setMode(Mode.REPEATED).build();

    FieldValue arrayValues =
        FieldValue.of(
            Attribute.REPEATED,
            FieldValueList.of(
                Arrays.stream(values)
                    .map(value -> FieldValue.of(Attribute.PRIMITIVE, value))
                    .collect(Collectors.toList())));

    return Tuple.of(schema, arrayValues);
  }

  public static <T> Tuple<ArrayList<Object>, ArrayList<T>> nestedResultSetToColumnLists(
      ResultSet resultSet) throws SQLException {
    ArrayList<Object> indexes = new ArrayList<>();
    ArrayList<T> columnValues = new ArrayList<>();
    while (resultSet.next()) {
      indexes.add(resultSet.getObject(1));
      columnValues.add((T) resultSet.getObject(2));
    }
    return Tuple.of(indexes, columnValues);
  }

  @SafeVarargs
  public static Tuple<FieldList, JsonStringHashMap<String, Object>> arrowStructOf(
      Tuple<StandardSQLTypeName, Object>... tuples) {
    ArrayList<Field> fields = new ArrayList<>();
    JsonStringHashMap<String, Object> values = new JsonStringHashMap<>();

    for (Tuple<StandardSQLTypeName, Object> tuple : tuples) {
      StandardSQLTypeName typeName = tuple.x();
      Object value = tuple.y();
      String name = typeName.name() + "_column";
      Field schema = Field.newBuilder(name, typeName).setMode(Mode.NULLABLE).build();
      fields.add(schema);
      values.put(name, value);
    }
    return Tuple.of(FieldList.of(fields), values);
  }

  public static <T> Tuple<Field, JsonStringArrayList<T>> arrowArraySchemaAndValue(
      StandardSQLTypeName typeName, T... values) {
    Field schema =
        Field.newBuilder(typeName.name() + "_arr_column", typeName).setMode(Mode.REPEATED).build();

    JsonStringArrayList<T> arrayValues = new JsonStringArrayList<>();
    arrayValues.addAll(Arrays.asList(values));
    return Tuple.of(schema, arrayValues);
  }

  @SafeVarargs
  public static <T> JsonStringArrayList<T> arrowArrayOf(T... values) {
    JsonStringArrayList<T> arrayValues = new JsonStringArrayList<>();
    arrayValues.addAll(Arrays.asList(values));
    return arrayValues;
  }

  // struct of arrays
  public static JsonStringHashMap<String, Object> toArrowStruct(
      Iterable<Tuple<Field, JsonStringArrayList<Object>>> schemaAndValues) {
    JsonStringHashMap<String, Object> struct = new JsonStringHashMap<>();
    for (Tuple<Field, JsonStringArrayList<Object>> schemaAndValue : schemaAndValues) {
      Field schema = schemaAndValue.x();
      JsonStringArrayList<Object> value = schemaAndValue.y();
      struct.put(schema.getName(), value);
    }
    return struct;
  }

  public static class TestConnectionListener implements ConnectionEventListener {
    private int connectionClosedCount = 0;
    private int connectionErrorCount = 0;

    @Override
    public void connectionClosed(ConnectionEvent arg0) {
      connectionClosedCount++;
    }

    @Override
    public void connectionErrorOccurred(ConnectionEvent arg0) {
      connectionErrorCount++;
    }

    public int getConnectionClosedCount() {
      return connectionClosedCount;
    }

    public int getConnectionErrorCount() {
      return connectionErrorCount;
    }
  }
}

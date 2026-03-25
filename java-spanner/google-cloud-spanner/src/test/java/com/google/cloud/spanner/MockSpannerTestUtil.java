/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import com.google.cloud.spanner.Type.StructField;
import com.google.common.collect.ContiguousSet;
import com.google.protobuf.ListValue;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import java.util.Arrays;

public class MockSpannerTestUtil {
  public static final Statement SELECT1 = Statement.of("SELECT 1 AS COL1");
  private static final ResultSetMetadata SELECT1_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  public static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .setMetadata(SELECT1_METADATA)
          .build();
  public static final Statement SELECT1_FROM_TABLE = Statement.of("SELECT 1 FROM FOO WHERE 1=1");
  static final Statement INVALID_SELECT_STATEMENT =
      Statement.of("SELECT * FROM NON_EXISTENT_TABLE");
  static final String TEST_PROJECT = "my-project";
  static final String TEST_INSTANCE = "my-instance";
  static final String TEST_DATABASE = "my-database";

  static final Statement UPDATE_STATEMENT = Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");
  static final Statement INVALID_UPDATE_STATEMENT =
      Statement.of("UPDATE NON_EXISTENT_TABLE SET BAR=1 WHERE BAZ=2");
  static final Statement UPDATE_ABORTED_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2 AND THIS_WILL_ABORT=TRUE");
  static final long UPDATE_COUNT = 1L;

  static final String READ_TABLE_NAME = "TestTable";
  static final String EMPTY_READ_TABLE_NAME = "EmptyTestTable";
  static final Iterable<String> READ_COLUMN_NAMES = Arrays.asList("Key", "Value");
  static final Statement READ_ONE_KEY_VALUE_STATEMENT =
      Statement.of("SELECT Key, Value FROM TestTable WHERE ID=1");
  static final Statement READ_MULTIPLE_KEY_VALUE_STATEMENT =
      Statement.of("SELECT Key, Value FROM TestTable WHERE 1=1");
  static final Statement READ_ONE_EMPTY_KEY_VALUE_STATEMENT =
      Statement.of("SELECT Key, Value FROM EmptyTestTable WHERE ID=1");
  static final Statement READ_ALL_EMPTY_KEY_VALUE_STATEMENT =
      Statement.of("SELECT Key, Value FROM EmptyTestTable WHERE 1=1");
  static final ResultSetMetadata READ_KEY_VALUE_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("Key")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.STRING)
                                  .build())
                          .build())
                  .addFields(
                      Field.newBuilder()
                          .setName("Value")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.STRING)
                                  .build())
                          .build())
                  .build())
          .build();
  static final Type READ_TABLE_TYPE =
      Type.struct(StructField.of("Key", Type.string()), StructField.of("Value", Type.string()));
  static final com.google.spanner.v1.ResultSet EMPTY_KEY_VALUE_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(ListValue.newBuilder().build())
          .setMetadata(READ_KEY_VALUE_METADATA)
          .build();
  static final com.google.spanner.v1.ResultSet READ_ONE_KEY_VALUE_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("k1").build())
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("v1").build())
                  .build())
          .setMetadata(READ_KEY_VALUE_METADATA)
          .build();
  static final com.google.spanner.v1.ResultSet READ_MULTIPLE_KEY_VALUE_RESULTSET =
      generateKeyValueResultSet(ContiguousSet.closed(1, 3));

  static com.google.spanner.v1.ResultSet generateKeyValueResultSet(Iterable<Integer> rows) {
    com.google.spanner.v1.ResultSet.Builder builder = com.google.spanner.v1.ResultSet.newBuilder();
    for (Integer row : rows) {
      builder.addRows(
          ListValue.newBuilder()
              .addValues(com.google.protobuf.Value.newBuilder().setStringValue("k" + row).build())
              .addValues(com.google.protobuf.Value.newBuilder().setStringValue("v" + row).build())
              .build());
    }
    return builder.setMetadata(READ_KEY_VALUE_METADATA).build();
  }

  static final ResultSetMetadata READ_FIRST_NAME_SINGERS_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("FirstName")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.STRING)
                                  .build())
                          .build())
                  .build())
          .build();
  static final com.google.spanner.v1.ResultSet READ_FIRST_NAME_SINGERS_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(
                      com.google.protobuf.Value.newBuilder().setStringValue("FirstName").build())
                  .build())
          .setMetadata(READ_FIRST_NAME_SINGERS_METADATA)
          .build();
}

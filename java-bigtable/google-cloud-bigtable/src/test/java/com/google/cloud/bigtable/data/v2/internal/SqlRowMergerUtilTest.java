/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapElement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSets;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.bigtable.v2.ColumnMetadata;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SqlRowMergerUtilTest {

  @Test
  public void close_succeedsWhenEmpty() {
    com.google.bigtable.v2.ResultSetMetadata md = metadata(columnMetadata("a", stringType()));
    try (SqlRowMergerUtil util = new SqlRowMergerUtil(md)) {}

    try (SqlRowMergerUtil util = new SqlRowMergerUtil(md)) {
      // Metadata with no rows
      List<SqlRow> unused = util.parseExecuteQueryResponses(ImmutableList.of());
    }
  }

  @Test
  public void parseExecuteQueryResponses_handlesSingleValue_serializedProtoRows() {
    com.google.bigtable.v2.ResultSetMetadata metadata =
        metadata(columnMetadata("str", stringType()));
    ImmutableList<ExecuteQueryResponse> responses =
        ImmutableList.of(partialResultSetWithToken(stringValue("val")));
    try (SqlRowMergerUtil util = new SqlRowMergerUtil(metadata)) {
      List<SqlRow> rows = util.parseExecuteQueryResponses(responses);
      assertThat(rows)
          .containsExactly(
              ProtoSqlRow.create(
                  ProtoResultSetMetadata.fromProto(metadata(columnMetadata("str", stringType()))),
                  ImmutableList.of(stringValue("val"))));
      ;
    }
  }

  @Test
  public void
      parseExecuteQueryResponses_handlesMultipleValuesAcrossMultipleRows_serializedProtoRows() {
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()),
      columnMetadata("bytes", bytesType()),
      columnMetadata("strArr", arrayType(stringType())),
      columnMetadata("map", mapType(stringType(), bytesType()))
    };
    com.google.bigtable.v2.ResultSetMetadata metadataProto = metadata(columns);
    ResultSetMetadata metadata = ProtoResultSetMetadata.fromProto(metadataProto);
    ImmutableList<ExecuteQueryResponse> responses =
        partialResultSets(
            3,
            stringValue("str1"),
            bytesValue("bytes1"),
            arrayValue(stringValue("arr1")),
            mapValue(mapElement(stringValue("key1"), bytesValue("val1"))),
            stringValue("str2"),
            bytesValue("bytes2"),
            arrayValue(stringValue("arr2")),
            mapValue(mapElement(stringValue("key2"), bytesValue("val2"))),
            stringValue("str3"),
            bytesValue("bytes3"),
            arrayValue(stringValue("arr3")),
            mapValue(mapElement(stringValue("key3"), bytesValue("val3"))));
    try (SqlRowMergerUtil util = new SqlRowMergerUtil(metadataProto)) {
      List<SqlRow> rows = util.parseExecuteQueryResponses(responses);
      assertThat(rows)
          .containsExactly(
              ProtoSqlRow.create(
                  metadata,
                  ImmutableList.of(
                      stringValue("str1"),
                      bytesValue("bytes1"),
                      arrayValue(stringValue("arr1")),
                      mapValue(mapElement(stringValue("key1"), bytesValue("val1"))))),
              ProtoSqlRow.create(
                  metadata,
                  ImmutableList.of(
                      stringValue("str2"),
                      bytesValue("bytes2"),
                      arrayValue(stringValue("arr2")),
                      mapValue(mapElement(stringValue("key2"), bytesValue("val2"))))),
              ProtoSqlRow.create(
                  metadata,
                  ImmutableList.of(
                      stringValue("str3"),
                      bytesValue("bytes3"),
                      arrayValue(stringValue("arr3")),
                      mapValue(mapElement(stringValue("key3"), bytesValue("val3"))))));
    }
  }

  @Test
  public void parseExecuteQueryResponses_throwsOnCloseWithPartialBatch_serializedProtoRows() {
    com.google.bigtable.v2.ResultSetMetadata metadata =
        metadata(columnMetadata("str", stringType()));
    ImmutableList<ExecuteQueryResponse> responses =
        ImmutableList.of(partialResultSetWithoutToken(stringValue("str1")));

    SqlRowMergerUtil util = new SqlRowMergerUtil(metadata);
    List<SqlRow> unused = util.parseExecuteQueryResponses(responses);
    assertThrows(IllegalStateException.class, util::close);
  }

  @Test
  public void
      parseExecuteQueryResponses_throwsOnParseWithPartialRowsInCompleteBatch_serializedProtoRows() {
    com.google.bigtable.v2.ResultSetMetadata metadata =
        metadata(columnMetadata("str", stringType()), columnMetadata("bytes", bytesType()));
    ImmutableList<ExecuteQueryResponse> responses =
        ImmutableList.of(
            partialResultSetWithToken(
                stringValue("str1"), bytesValue("bytes1"), stringValue("str2")));

    SqlRowMergerUtil util = new SqlRowMergerUtil(metadata);
    assertThrows(IllegalStateException.class, () -> util.parseExecuteQueryResponses(responses));
  }

  @Test
  public void parseExecuteQueryResponses_worksWithIncrementalSetsOfResponses_serializedProtoRows() {
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()),
      columnMetadata("bytes", bytesType()),
      columnMetadata("strArr", arrayType(stringType())),
      columnMetadata("map", mapType(stringType(), bytesType()))
    };
    com.google.bigtable.v2.ResultSetMetadata metadataProto = metadata(columns);
    ResultSetMetadata metadata = ProtoResultSetMetadata.fromProto(metadataProto);
    ImmutableList<ExecuteQueryResponse> responses =
        partialResultSets(
            3,
            stringValue("str1"),
            bytesValue("bytes1"),
            arrayValue(stringValue("arr1")),
            mapValue(mapElement(stringValue("key1"), bytesValue("val1"))),
            stringValue("str2"),
            bytesValue("bytes2"),
            arrayValue(stringValue("arr2")),
            mapValue(mapElement(stringValue("key2"), bytesValue("val2"))),
            stringValue("str3"),
            bytesValue("bytes3"),
            arrayValue(stringValue("arr3")),
            mapValue(mapElement(stringValue("key3"), bytesValue("val3"))));
    try (SqlRowMergerUtil util = new SqlRowMergerUtil(metadataProto)) {
      List<SqlRow> rows = new ArrayList<>();
      rows.addAll(util.parseExecuteQueryResponses(responses.subList(0, 1)));
      rows.addAll(util.parseExecuteQueryResponses(responses.subList(1, 2)));
      rows.addAll(util.parseExecuteQueryResponses(responses.subList(2, 3)));

      assertThat(rows)
          .containsExactly(
              ProtoSqlRow.create(
                  metadata,
                  ImmutableList.of(
                      stringValue("str1"),
                      bytesValue("bytes1"),
                      arrayValue(stringValue("arr1")),
                      mapValue(mapElement(stringValue("key1"), bytesValue("val1"))))),
              ProtoSqlRow.create(
                  metadata,
                  ImmutableList.of(
                      stringValue("str2"),
                      bytesValue("bytes2"),
                      arrayValue(stringValue("arr2")),
                      mapValue(mapElement(stringValue("key2"), bytesValue("val2"))))),
              ProtoSqlRow.create(
                  metadata,
                  ImmutableList.of(
                      stringValue("str3"),
                      bytesValue("bytes3"),
                      arrayValue(stringValue("arr3")),
                      mapValue(mapElement(stringValue("key3"), bytesValue("val3"))))));
    }
  }
}

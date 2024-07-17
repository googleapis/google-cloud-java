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
package com.google.cloud.bigtable.data.v2.stub.sql;

import static com.google.cloud.bigtable.data.v2.internal.SqlRowSubject.assertThat;
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
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.tokenOnlyResultSet;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlRowMergerSubject.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.bigtable.v2.ColumnMetadata;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SqlRowMergerTest {

  @Test
  public void sqlRowMerger_handlesEmptyState() {
    SqlRowMerger merger = new SqlRowMerger();
    assertThat(merger).hasPartialFrame(false);
    assertThat(merger).hasFullFrame(false);
  }

  @Test
  public void sqlRowMerger_handlesMetadata() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()),
      columnMetadata("bytes", bytesType()),
      columnMetadata("strArr", arrayType(stringType())),
      columnMetadata("strByteMap", mapType(stringType(), bytesType()))
    };
    merger.push(metadata(columns));
    assertThat(merger).hasPartialFrame(false);
    assertThat(merger).hasFullFrame(false);
  }

  @Test
  public void sqlRowMerger_rejectsMetadataOfUnrecognizedType() {
    SqlRowMerger merger = new SqlRowMerger();
    ExecuteQueryResponse unrecognizedMetadata =
        ExecuteQueryResponse.newBuilder()
            .setMetadata(com.google.bigtable.v2.ResultSetMetadata.newBuilder().build())
            .build();

    assertThrows(IllegalStateException.class, () -> merger.push(unrecognizedMetadata));
  }

  @Test
  public void hasPartialFrame_trueWithIncompleteBatch() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType())
    };
    merger.push(metadata(columns));
    merger.push(partialResultSetWithoutToken(stringValue("test")));
    assertThat(merger).hasPartialFrame(true);
  }

  @Test
  public void hasPartialFrame_trueWithFullRow() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType())
    };
    merger.push(metadata(columns));
    merger.push(partialResultSetWithToken(stringValue("test"), bytesValue("test")));
    assertThat(merger).hasPartialFrame(true);
  }

  @Test
  public void push_failsOnCompleteBatchWithIncompleteRow() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType())
    };
    merger.push(metadata(columns));
    assertThrows(
        IllegalStateException.class,
        () -> merger.push(partialResultSetWithToken(stringValue("test"))));
  }

  @Test
  public void hasFullFrame_trueWithFullRow() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType())
    };
    merger.push(metadata(columns));
    merger.push(partialResultSetWithoutToken(stringValue("test")));
    merger.push(partialResultSetWithToken(bytesValue("test")));
    assertThat(merger).hasFullFrame(true);
  }

  @Test
  public void hasFullFrame_falseWithIncompleteBatch() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType())
    };
    merger.push(metadata(columns));
    merger.push(partialResultSetWithoutToken(stringValue("test")));
    assertThat(merger).hasFullFrame(false);
  }

  @Test
  public void sqlRowMerger_handlesResponseStream() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()),
      columnMetadata("bytes", bytesType()),
      columnMetadata("strArr", arrayType(stringType())),
      columnMetadata("strByteMap", mapType(stringType(), bytesType()))
    };
    ResultSetMetadata metadata = ProtoResultSetMetadata.fromProto(metadata(columns).getMetadata());
    merger.push(metadata(columns));

    // Three logical rows worth of values split across two responses
    Value[] values = {
      // first response
      stringValue("test"),
      bytesValue("bytes"),
      arrayValue(stringValue("foo"), stringValue("bar")),
      mapValue(mapElement(stringValue("key"), bytesValue("bytes"))),
      stringValue("test2"),
      // second response
      bytesValue("bytes2"),
      arrayValue(stringValue("foo2"), stringValue("bar2")),
      mapValue(mapElement(stringValue("key2"), bytesValue("bytes2"))),
      stringValue("test3"),
      bytesValue("bytes3"),
      arrayValue(stringValue("foo3"), stringValue("bar3")),
      mapValue(mapElement(stringValue("key3"), bytesValue("bytes3")))
    };
    merger.push(partialResultSetWithoutToken(Arrays.copyOf(values, 5)));
    merger.push(partialResultSetWithToken(Arrays.copyOfRange(values, 5, 12)));
    assertThat(merger.pop())
        .isEqualTo(ProtoSqlRow.create(metadata, ImmutableList.copyOf(Arrays.copyOf(values, 4))));
    assertThat(merger.pop())
        .isEqualTo(
            ProtoSqlRow.create(metadata, ImmutableList.copyOf(Arrays.copyOfRange(values, 4, 8))));
    assertThat(merger.pop())
        .isEqualTo(
            ProtoSqlRow.create(metadata, ImmutableList.copyOf(Arrays.copyOfRange(values, 8, 12))));
  }

  @Test
  public void addValue_failsWithoutMetadataFirst() {
    SqlRowMerger merger = new SqlRowMerger();
    assertThrows(
        IllegalStateException.class,
        () -> merger.push(partialResultSetWithToken(stringValue("test"))));
  }

  @Test
  public void sqlRowMerger_handlesTokenWithOpenPartialBatch() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType()),
    };
    ResultSetMetadata metadata = ProtoResultSetMetadata.fromProto(metadata(columns).getMetadata());
    merger.push(metadata(columns));
    merger.push(partialResultSetWithoutToken(stringValue("test")));
    merger.push(partialResultSetWithoutToken(bytesValue("test")));
    merger.push(tokenOnlyResultSet(ByteString.copyFromUtf8("token")));

    assertThat(merger).hasPartialFrame(true);
    assertThat(merger).hasFullFrame(true);
    assertThat(merger.pop())
        .isEqualTo(
            ProtoSqlRow.create(
                metadata, ImmutableList.of(stringValue("test"), bytesValue("test"))));
  }

  @Test
  public void sqlRowMerger_handlesTokensWithNoData() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType()),
    };
    merger.push(metadata(columns));
    merger.push(tokenOnlyResultSet(ByteString.copyFromUtf8("token1")));
    merger.push(tokenOnlyResultSet(ByteString.copyFromUtf8("token2")));
    merger.push(tokenOnlyResultSet(ByteString.copyFromUtf8("token3")));

    assertThat(merger).hasPartialFrame(false);
    assertThat(merger).hasFullFrame(false);
  }

  @Test
  public void sqlRowMerger_handlesLeadingTokens() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {
      columnMetadata("str", stringType()), columnMetadata("bytes", bytesType()),
    };
    ResultSetMetadata metadata = ProtoResultSetMetadata.fromProto(metadata(columns).getMetadata());
    merger.push(metadata(columns));
    merger.push(tokenOnlyResultSet(ByteString.copyFromUtf8("token1")));
    merger.push(partialResultSetWithoutToken(stringValue("test")));
    merger.push(partialResultSetWithToken(bytesValue("test")));

    assertThat(merger).hasPartialFrame(true);
    assertThat(merger).hasFullFrame(true);
    assertThat(merger.pop())
        .isEqualTo(
            ProtoSqlRow.create(
                metadata, ImmutableList.of(stringValue("test"), bytesValue("test"))));
  }

  @Test
  public void addValue_failsOnDuplicateMetadata() {
    SqlRowMerger merger = new SqlRowMerger();
    ColumnMetadata[] columns = {columnMetadata("str", stringType())};
    merger.push(metadata(columns));
    merger.push(partialResultSetWithToken(stringValue("test")));

    assertThrows(IllegalStateException.class, () -> merger.push(metadata(columns)));
  }

  @Test
  public void pop_failsWhenQueueIsEmpty() {
    SqlRowMerger merger = new SqlRowMerger();
    assertThrows(NullPointerException.class, merger::pop);
  }
}

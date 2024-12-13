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
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float32Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.floatValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapElement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structField;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.cloud.Date;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSet;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.stub.sql.ExecuteQueryCallContext;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlServerStream;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlServerStreamImpl;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.protobuf.ByteString;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ResultSetImplTest {

  private static ResultSet resultSetWithFakeStream(ResultSetMetadata metadata, SqlRow... rows) {
    ServerStreamingStashCallable<ExecuteQueryCallContext, SqlRow> stream =
        new ServerStreamingStashCallable<>(Arrays.asList(rows));
    SettableApiFuture<ResultSetMetadata> future = SettableApiFuture.create();
    future.set(metadata);
    ExecuteQueryCallContext fakeCallContext =
        ExecuteQueryCallContext.create(ExecuteQueryRequest.newBuilder().build(), future);
    return ResultSetImpl.create(SqlServerStreamImpl.create(future, stream.call(fakeCallContext)));
  }

  @Test
  public void testSingleRow() throws ExecutionException, InterruptedException {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(
                    columnMetadata("string", stringType()),
                    columnMetadata("bytes", bytesType()),
                    columnMetadata("long", int64Type()),
                    columnMetadata("double", float64Type()),
                    columnMetadata("float", float32Type()),
                    columnMetadata("boolean", boolType()),
                    columnMetadata("timestamp", timestampType()),
                    columnMetadata("date", dateType()),
                    columnMetadata("struct", structType(structField("string", stringType()))),
                    columnMetadata("list", arrayType(stringType())),
                    columnMetadata("map", mapType(stringType(), stringType())))
                .getMetadata());
    ResultSet resultSet =
        resultSetWithFakeStream(
            metadata,
            ProtoSqlRow.create(
                metadata,
                Arrays.asList(
                    stringValue("test"),
                    bytesValue("bytes"),
                    int64Value(100),
                    floatValue(1.23),
                    floatValue(1.23),
                    boolValue(true),
                    timestampValue(10000000, 100),
                    dateValue(2024, 6, 5),
                    structValue(stringValue("foo")),
                    arrayValue(stringValue("foo"), stringValue("bar")),
                    mapValue(mapElement(stringValue("key"), stringValue("val"))))));
    int rows = 0;
    while (resultSet.next()) {
      rows++;
      assertThat(resultSet.getString(0)).isEqualTo("test");
      assertThat(resultSet.getString("string")).isEqualTo("test");
      assertThat(resultSet.getBytes(1)).isEqualTo(ByteString.copyFromUtf8("bytes"));
      assertThat(resultSet.getBytes("bytes")).isEqualTo(ByteString.copyFromUtf8("bytes"));
      assertThat(resultSet.getLong(2)).isEqualTo(100);
      assertThat(resultSet.getLong("long")).isEqualTo(100);
      assertThat(resultSet.getDouble(3)).isEqualTo(1.23d);
      assertThat(resultSet.getDouble("double")).isEqualTo(1.23d);
      assertThat(resultSet.getFloat(4)).isEqualTo(1.23f);
      assertThat(resultSet.getFloat("float")).isEqualTo(1.23f);
      assertThat(resultSet.getBoolean(5)).isTrue();
      assertThat(resultSet.getBoolean("boolean")).isTrue();
      assertThat(resultSet.getTimestamp(6)).isEqualTo(Instant.ofEpochSecond(10000000, 100));
      assertThat(resultSet.getTimestamp("timestamp"))
          .isEqualTo(Instant.ofEpochSecond(10000000, 100));
      assertThat(resultSet.getDate(7)).isEqualTo(Date.fromYearMonthDay(2024, 6, 5));
      assertThat(resultSet.getDate("date")).isEqualTo(Date.fromYearMonthDay(2024, 6, 5));
      assertThat(resultSet.getStruct(8))
          .isEqualTo(
              ProtoStruct.create(
                  (SqlType.Struct)
                      SqlType.fromProto(structType(structField("string", stringType()))),
                  structValue(stringValue("foo")).getArrayValue()));
      assertThat(resultSet.getStruct("struct"))
          .isEqualTo(
              ProtoStruct.create(
                  (SqlType.Struct)
                      SqlType.fromProto(structType(structField("string", stringType()))),
                  structValue(stringValue("foo")).getArrayValue()));
      assertThat(resultSet.getList(9, SqlType.arrayOf(SqlType.string())))
          .isEqualTo(Arrays.asList("foo", "bar"));
      assertThat(resultSet.getList("list", SqlType.arrayOf(SqlType.string())))
          .isEqualTo(Arrays.asList("foo", "bar"));
      assertThat(resultSet.getMap(10, SqlType.mapOf(SqlType.string(), SqlType.string())))
          .isEqualTo(
              new HashMap<String, String>() {
                {
                  put("key", "val");
                }
              });
      assertThat(resultSet.getMap("map", SqlType.mapOf(SqlType.string(), SqlType.string())))
          .isEqualTo(
              new HashMap<String, String>() {
                {
                  put("key", "val");
                }
              });
    }
    assertThat(rows).isEqualTo(1);
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getMetadata()).isEqualTo(metadata);
    resultSet.close();
  }

  @Test
  public void testIteration() {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("string", stringType())).getMetadata());
    try (ResultSet resultSet =
        resultSetWithFakeStream(
            metadata,
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("foo"))),
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("bar"))),
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("baz"))),
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("a"))),
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("b"))))) {

      assertThat(resultSet.next()).isTrue();
      assertThat(resultSet.getString(0)).isEqualTo("foo");
      assertThat(resultSet.next()).isTrue();
      // skip a row
      assertThat(resultSet.next()).isTrue();
      assertThat(resultSet.getString(0)).isEqualTo("baz");
      assertThat(resultSet.next()).isTrue();
      assertThat(resultSet.getString(0)).isEqualTo("a");
      assertThat(resultSet.next()).isTrue();
      assertThat(resultSet.getString(0)).isEqualTo("b");
      assertThat(resultSet.next()).isFalse();
    }
  }

  @Test
  public void testEmptyResultSet() throws ExecutionException, InterruptedException {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("string", stringType())).getMetadata());
    try (ResultSet resultSet = resultSetWithFakeStream(metadata)) {
      assertThat(resultSet.next()).isFalse();
      assertThat(resultSet.getMetadata()).isEqualTo(metadata);
    }
  }

  @Test
  public void getCallsPrevented_afterNextReturnsFalse() {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("string", stringType())).getMetadata());

    ResultSet resultSet =
        resultSetWithFakeStream(
            metadata,
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("foo"))),
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("bar"))));

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getString(0)).isEqualTo("foo");
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getString(0)).isEqualTo("bar");
    assertThat(resultSet.next()).isFalse();
    // Users can still call next
    assertThat(resultSet.next()).isFalse();
    // Attempts to access data will throw an exception
    assertThrows(IllegalStateException.class, () -> resultSet.getString(0));
    resultSet.close();
  }

  @Test
  public void close_preventsGetCalls() {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("string", stringType())).getMetadata());
    ResultSet resultSet =
        resultSetWithFakeStream(
            metadata, ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("foo"))));

    assertThat(resultSet.next()).isTrue();
    resultSet.close();
    assertThrows(IllegalStateException.class, () -> resultSet.getString(0));
  }

  @Test
  public void close_cancelsStreamWhenResultsNotConsumed() {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("string", stringType())).getMetadata());
    ServerStreamingStashCallable<ExecuteQueryRequest, SqlRow> stream =
        new ServerStreamingStashCallable<>(
            Collections.singletonList(
                ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("foo")))));
    SqlServerStream sqlServerStream =
        SqlServerStreamImpl.create(
            SettableApiFuture.create(), stream.call(ExecuteQueryRequest.newBuilder().build()));
    ResultSet resultSet = ResultSetImpl.create(sqlServerStream);
    resultSet.close();

    Throwable lastCallError = stream.popLastCall().getError();
    assertThat(lastCallError).isInstanceOf(CancellationException.class);
  }

  @Test
  public void close_doesNotCancelStreamWhenResultsConsumed() {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("string", stringType())).getMetadata());
    ServerStreamingStashCallable<ExecuteQueryRequest, SqlRow> stream =
        new ServerStreamingStashCallable<>(
            Collections.singletonList(
                ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("foo")))));
    SqlServerStream sqlServerStream =
        SqlServerStreamImpl.create(
            SettableApiFuture.create(), stream.call(ExecuteQueryRequest.newBuilder().build()));
    ResultSet resultSet = ResultSetImpl.create(sqlServerStream);

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.next()).isFalse();
    resultSet.close();
    Throwable lastCallError = stream.popLastCall().getError();
    assertThat(lastCallError).isNull();
  }

  @Test
  public void getBeforeNext_throwsException() {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("string", stringType())).getMetadata());
    try (ResultSet resultSet =
        resultSetWithFakeStream(
            metadata,
            ProtoSqlRow.create(metadata, Collections.singletonList(stringValue("foo"))))) {
      assertThrows(IllegalStateException.class, () -> resultSet.getString(0));
    }
  }

  @Test
  public void getOnColumnWithDuplicateName_throwsException() {
    ResultSetMetadata metadata =
        ProtoResultSetMetadata.fromProto(
            metadata(columnMetadata("name", stringType()), columnMetadata("name", stringType()))
                .getMetadata());
    try (ResultSet resultSet =
        resultSetWithFakeStream(
            metadata,
            ProtoSqlRow.create(metadata, Arrays.asList(stringValue("foo"), stringValue("bar"))))) {

      assertThat(resultSet.next()).isTrue();
      assertThrows(IllegalArgumentException.class, () -> resultSet.getString("name"));
    }
  }

  @Test
  public void getMetadata_unwrapsExecutionExceptions() {
    SettableApiFuture<ResultSetMetadata> metadataFuture = SettableApiFuture.create();
    ServerStreamingStashCallable<ExecuteQueryCallContext, SqlRow> stream =
        new ServerStreamingStashCallable<>(Collections.emptyList());
    ExecuteQueryCallContext fakeCallContext =
        ExecuteQueryCallContext.create(ExecuteQueryRequest.newBuilder().build(), metadataFuture);
    ResultSet rs =
        ResultSetImpl.create(
            SqlServerStreamImpl.create(metadataFuture, stream.call(fakeCallContext)));

    metadataFuture.setException(new IllegalStateException("test"));
    assertThrows(IllegalStateException.class, rs::getMetadata);
  }

  @Test
  public void getMetadata_returnsNonRuntimeExecutionExceptionsWrapped() {
    SettableApiFuture<ResultSetMetadata> metadataFuture = SettableApiFuture.create();
    ServerStreamingStashCallable<ExecuteQueryCallContext, SqlRow> stream =
        new ServerStreamingStashCallable<>(Collections.emptyList());
    ExecuteQueryCallContext fakeCallContext =
        ExecuteQueryCallContext.create(ExecuteQueryRequest.newBuilder().build(), metadataFuture);
    ResultSet rs =
        ResultSetImpl.create(
            SqlServerStreamImpl.create(metadataFuture, stream.call(fakeCallContext)));

    metadataFuture.setException(new Throwable("test"));
    assertThrows(RuntimeException.class, rs::getMetadata);
  }
}

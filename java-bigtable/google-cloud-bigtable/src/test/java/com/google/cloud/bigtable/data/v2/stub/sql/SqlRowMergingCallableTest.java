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

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.callContext;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.preparedStatement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ServerStream;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.internal.PreparedStatementImpl;
import com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.models.sql.PreparedStatement;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * We have much more extensive testing of the row merging in {@link
 * com.google.cloud.bigtable.data.v2.stub.sql.SqlRowMergerTest}. The Callable is a simple wrapper
 * around this, so we don't need to duplicate all of the tests.
 */
@RunWith(JUnit4.class)
public class SqlRowMergingCallableTest {

  @Test
  public void testMerging() throws ExecutionException, InterruptedException {
    ServerStreamingStashCallable<ExecuteQueryCallContext, ExecuteQueryResponse> inner =
        new ServerStreamingStashCallable<>(
            Lists.newArrayList(
                partialResultSetWithoutToken(
                    stringValue("foo"),
                    int64Value(1),
                    arrayValue(stringValue("foo"), stringValue("bar"))),
                partialResultSetWithToken(stringValue("test"), int64Value(10), arrayValue())));

    PreparedStatementImpl preparedStatement =
        preparedStatement(
            metadata(
                columnMetadata("stringCol", stringType()),
                columnMetadata("intCol", int64Type()),
                columnMetadata("arrayCol", arrayType(stringType()))));
    BoundStatement boundStatement = preparedStatement.bind().build();
    ResultSetMetadata metadata =
        preparedStatement.getLatestPrepareResponse().prepareFuture().get().resultSetMetadata();
    SettableApiFuture<ResultSetMetadata> mdFuture = SettableApiFuture.create();
    mdFuture.set(metadata);
    SqlRowMergingCallable rowMergingCallable = new SqlRowMergingCallable(inner);
    ServerStream<SqlRow> results = rowMergingCallable.call(callContext(boundStatement, mdFuture));
    List<SqlRow> resultsList = results.stream().collect(Collectors.toList());
    assertThat(resultsList)
        .containsExactly(
            ProtoSqlRow.create(
                metadata,
                Arrays.asList(
                    stringValue("foo"),
                    int64Value(1),
                    arrayValue(stringValue("foo"), stringValue("bar")))),
            ProtoSqlRow.create(
                metadata, Arrays.asList(stringValue("test"), int64Value(10), arrayValue())));
  }

  @Test
  public void testError() throws ExecutionException, InterruptedException {
    PreparedStatementImpl preparedStatement =
        preparedStatement(
            metadata(
                columnMetadata("stringCol", stringType()),
                columnMetadata("intCol", int64Type()),
                columnMetadata("arrayCol", arrayType(stringType()))));
    BoundStatement boundStatement = preparedStatement.bind().build();

    // empty response is invalid
    ServerStreamingStashCallable<ExecuteQueryCallContext, ExecuteQueryResponse> inner =
        new ServerStreamingStashCallable<>(
            Lists.newArrayList(ExecuteQueryResponse.getDefaultInstance()));

    SqlRowMergingCallable rowMergingCallable = new SqlRowMergingCallable(inner);
    SettableApiFuture<ResultSetMetadata> mdFuture = SettableApiFuture.create();
    mdFuture.set(
        preparedStatement.getLatestPrepareResponse().prepareFuture().get().resultSetMetadata());
    ServerStream<SqlRow> results = rowMergingCallable.call(callContext(boundStatement));

    assertThrows(IllegalStateException.class, () -> results.iterator().next());
  }

  @Test
  public void testMetdataFutureError() {
    PreparedStatement preparedStatement =
        preparedStatement(
            metadata(
                columnMetadata("stringCol", stringType()),
                columnMetadata("intCol", int64Type()),
                columnMetadata("arrayCol", arrayType(stringType()))));
    BoundStatement boundStatement = preparedStatement.bind().build();

    // empty response is invalid
    ServerStreamingStashCallable<ExecuteQueryCallContext, ExecuteQueryResponse> inner =
        new ServerStreamingStashCallable<>(
            Lists.newArrayList(ExecuteQueryResponse.getDefaultInstance()));

    SqlRowMergingCallable rowMergingCallable = new SqlRowMergingCallable(inner);
    SettableApiFuture<ResultSetMetadata> mdFuture = SettableApiFuture.create();
    mdFuture.setException(new RuntimeException("test"));
    ServerStream<SqlRow> results = rowMergingCallable.call(callContext(boundStatement, mdFuture));

    assertThrows(RuntimeException.class, () -> results.iterator().next());
  }
}

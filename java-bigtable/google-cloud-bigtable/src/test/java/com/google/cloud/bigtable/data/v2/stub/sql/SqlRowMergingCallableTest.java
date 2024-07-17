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
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.partialResultSetWithoutToken;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ServerStream;
import com.google.bigtable.v2.ExecuteQueryRequest;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.cloud.bigtable.data.v2.internal.ProtoResultSetMetadata;
import com.google.cloud.bigtable.data.v2.internal.ProtoSqlRow;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
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
  public void testMerging() {
    ExecuteQueryResponse metadataResponse =
        metadata(
            columnMetadata("stringCol", stringType()),
            columnMetadata("intCol", int64Type()),
            columnMetadata("arrayCol", arrayType(stringType())));
    ServerStreamingStashCallable<ExecuteQueryCallContext, ExecuteQueryResponse> inner =
        new ServerStreamingStashCallable<>(
            Lists.newArrayList(
                metadataResponse,
                partialResultSetWithoutToken(
                    stringValue("foo"),
                    int64Value(1),
                    arrayValue(stringValue("foo"), stringValue("bar"))),
                partialResultSetWithToken(stringValue("test"), int64Value(10), arrayValue())));

    SqlRowMergingCallable rowMergingCallable = new SqlRowMergingCallable(inner);
    ServerStream<SqlRow> results =
        rowMergingCallable.call(
            ExecuteQueryCallContext.create(
                ExecuteQueryRequest.getDefaultInstance(), SettableApiFuture.create()));
    List<SqlRow> resultsList = results.stream().collect(Collectors.toList());
    ResultSetMetadata metadata = ProtoResultSetMetadata.fromProto(metadataResponse.getMetadata());
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
  public void testError() {
    // empty metadata is invalid
    ServerStreamingStashCallable<ExecuteQueryCallContext, ExecuteQueryResponse> inner =
        new ServerStreamingStashCallable<>(Lists.newArrayList(metadata()));

    SqlRowMergingCallable rowMergingCallable = new SqlRowMergingCallable(inner);
    ServerStream<SqlRow> results =
        rowMergingCallable.call(
            ExecuteQueryCallContext.create(
                ExecuteQueryRequest.getDefaultInstance(), SettableApiFuture.create()));

    assertThrows(IllegalStateException.class, () -> results.iterator().next());
  }
}

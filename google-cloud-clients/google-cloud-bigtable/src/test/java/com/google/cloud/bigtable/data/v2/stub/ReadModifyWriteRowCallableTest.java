/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.Cell;
import com.google.bigtable.v2.Column;
import com.google.bigtable.v2.Family;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import io.grpc.Status.Code;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadModifyWriteRowCallableTest {
  private final RequestContext requestContext =
      RequestContext.create("fake-project", "fake-instance", "fake-profile");
  private FakeCallable inner;
  private ReadModifyWriteRowCallable callable;

  @Before
  public void setUp() {
    inner = new FakeCallable();
    callable = new ReadModifyWriteRowCallable(inner, requestContext);
  }

  @Test
  public void requestIsCorrect() {
    callable.futureCall(
        ReadModifyWriteRow.create("my-table", "my-key").append("my-family", "", "suffix"));

    assertThat(inner.request)
        .isEqualTo(
            ReadModifyWriteRowRequest.newBuilder()
                .setTableName(
                    NameUtil.formatTableName(
                        requestContext.getProjectId(), requestContext.getInstanceId(), "my-table"))
                .setAppProfileId(requestContext.getAppProfileId())
                .setRowKey(ByteString.copyFromUtf8("my-key"))
                .addRules(
                    ReadModifyWriteRule.newBuilder()
                        .setFamilyName("my-family")
                        .setColumnQualifier(ByteString.EMPTY)
                        .setAppendValue(ByteString.copyFromUtf8("suffix")))
                .build());
  }

  @Test
  public void responseCorrectlyTransformed() throws Exception {
    ApiFuture<Row> result =
        callable.futureCall(
            ReadModifyWriteRow.create("my-table", "my-key").append("my-family", "col", "suffix"));

    inner.response.set(
        ReadModifyWriteRowResponse.newBuilder()
            .setRow(
                com.google.bigtable.v2.Row.newBuilder()
                    .setKey(ByteString.copyFromUtf8("my-key"))
                    .addFamilies(
                        Family.newBuilder()
                            .setName("my-family")
                            .addColumns(
                                Column.newBuilder()
                                    .setQualifier(ByteString.copyFromUtf8("col"))
                                    .addCells(
                                        Cell.newBuilder()
                                            .setTimestampMicros(1_000)
                                            .setValue(ByteString.copyFromUtf8("suffix"))))))
            .build());

    assertThat(result.get(1, TimeUnit.SECONDS))
        .isEqualTo(
            Row.create(
                ByteString.copyFromUtf8("my-key"),
                ImmutableList.of(
                    RowCell.create(
                        "my-family",
                        ByteString.copyFromUtf8("col"),
                        1_000,
                        ImmutableList.<String>of(),
                        ByteString.copyFromUtf8("suffix")))));
  }

  @Test
  public void responseSortsFamilies() throws Exception {
    ByteString col = ByteString.copyFromUtf8("col1");
    ByteString value1 = ByteString.copyFromUtf8("value1");
    ByteString value2 = ByteString.copyFromUtf8("value2");

    ApiFuture<Row> result =
        callable.futureCall(
            ReadModifyWriteRow.create("my-table", "my-key").append("my-family", "col", "suffix"));

    inner.response.set(
        ReadModifyWriteRowResponse.newBuilder()
            .setRow(
                com.google.bigtable.v2.Row.newBuilder()
                    .setKey(ByteString.copyFromUtf8("my-key"))
                    // family2 is out of order
                    .addFamilies(
                        Family.newBuilder()
                            .setName("family2")
                            .addColumns(
                                Column.newBuilder()
                                    .setQualifier(col)
                                    .addCells(
                                        Cell.newBuilder()
                                            .setTimestampMicros(1_000)
                                            .setValue(value2))))
                    .addFamilies(
                        Family.newBuilder()
                            .setName("family1")
                            .addColumns(
                                Column.newBuilder()
                                    .setQualifier(col)
                                    .addCells(
                                        Cell.newBuilder()
                                            .setTimestampMicros(1_000)
                                            .setValue(value1)))
                            .build()))
            .build());

    assertThat(result.get(1, TimeUnit.SECONDS))
        .isEqualTo(
            Row.create(
                ByteString.copyFromUtf8("my-key"),
                ImmutableList.of(
                    RowCell.create("family1", col, 1_000, ImmutableList.<String>of(), value1),
                    RowCell.create("family2", col, 1_000, ImmutableList.<String>of(), value2))));
  }

  @Test
  public void errorIsPropagated() throws Exception {
    ApiFuture<Row> result =
        callable.futureCall(
            ReadModifyWriteRow.create("my-table", "my-key").append("my-family", "", "suffix"));

    Throwable expectedError =
        new NotFoundException("fake error", null, GrpcStatusCode.of(Code.NOT_FOUND), false);
    inner.response.setException(expectedError);

    Throwable actualError = null;
    try {
      result.get(1, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      actualError = e.getCause();
    }

    assertThat(actualError).isEqualTo(expectedError);
  }

  static class FakeCallable
      extends UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse> {
    ReadModifyWriteRowRequest request;
    ApiCallContext callContext;
    SettableApiFuture<ReadModifyWriteRowResponse> response = SettableApiFuture.create();

    @Override
    public ApiFuture<ReadModifyWriteRowResponse> futureCall(
        ReadModifyWriteRowRequest request, ApiCallContext context) {
      this.request = request;
      this.callContext = context;

      return response;
    }
  }
}

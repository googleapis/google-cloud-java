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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.BatchedFuture;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsRequest.Entry;
import com.google.bigtable.v2.MutateRowsRequest.Entry.Builder;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.Mutation.SetCell;
import com.google.bigtable.v2.TableName;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MutateRowsBatchingDescriptorTest {
  private static final TableName TABLE_NAME =
      TableName.of("fake-project", "fake-instance", "fake-table");
  private static final Set<Code> RETRYABLE_CODES =
      ImmutableSet.of(Code.UNAVAILABLE, Code.DEADLINE_EXCEEDED, Code.RESOURCE_EXHAUSTED);

  private MutateRowsBatchingDescriptor descriptor;

  @Before
  public void setUp() throws Exception {
    descriptor = new MutateRowsBatchingDescriptor(RETRYABLE_CODES);
  }

  @Test
  public void countBytesTest() {
    MutateRowsRequest request = createRequest(2);
    long actual = descriptor.countBytes(request);
    assertThat(actual).isEqualTo(request.getSerializedSize());
  }

  @Test
  public void countElementsTest() {
    MutateRowsRequest request = createRequest(2);
    long actual = descriptor.countElements(request);
    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void partitionKeyTest() {
    TableName myTableName = TableName.of("my-project", "my-instance", "my-table");

    MutateRowsRequest request =
        createRequest(2).toBuilder().setTableName(myTableName.toString()).build();

    PartitionKey actual = descriptor.getBatchPartitionKey(request);
    assertThat(actual).isEqualTo(new PartitionKey(myTableName.toString()));
  }

  @Test
  public void requestBuilderTest() {
    RequestBuilder<MutateRowsRequest> builder = descriptor.getRequestBuilder();

    MutateRowsRequest expected = createRequest(5);

    for (Entry entry : expected.getEntriesList()) {
      MutateRowsRequest singleReq =
          MutateRowsRequest.newBuilder()
              .setTableName(TABLE_NAME.toString())
              .addEntries(entry)
              .build();

      builder.appendRequest(singleReq);
    }

    MutateRowsRequest actual = builder.build();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void splitExceptionTest() throws TimeoutException, InterruptedException {
    BatchedFuture<MutateRowsResponse> result1 = BatchedFuture.create();
    BatchedRequestIssuer<MutateRowsResponse> issuer1 = new BatchedRequestIssuer<>(result1, 1);
    BatchedFuture<MutateRowsResponse> result2 = BatchedFuture.create();
    BatchedRequestIssuer<MutateRowsResponse> issuer2 = new BatchedRequestIssuer<>(result2, 1);

    ImmutableList<BatchedRequestIssuer<MutateRowsResponse>> issuers =
        new ImmutableList.Builder<BatchedRequestIssuer<MutateRowsResponse>>()
            .add(issuer1)
            .add(issuer2)
            .build();

    ApiException serverError =
        new ApiException(null, GrpcStatusCode.of(Status.Code.UNAVAILABLE), true);
    descriptor.splitException(serverError, issuers);
    issuer1.sendResult();
    issuer2.sendResult();

    Throwable error1 = null;
    try {
      result1.get(1, TimeUnit.SECONDS);
    } catch (ExecutionException t) {
      error1 = t.getCause();
    }
    assertThat(error1).isSameAs(serverError);

    Throwable error2 = null;
    try {
      result2.get(1, TimeUnit.SECONDS);
    } catch (ExecutionException t) {
      error2 = t.getCause();
    }
    assertThat(error2).isSameAs(serverError);
  }

  @Test
  public void splitResponseOkTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    BatchedFuture<MutateRowsResponse> result1 = BatchedFuture.create();
    BatchedRequestIssuer<MutateRowsResponse> issuer1 = new BatchedRequestIssuer<>(result1, 1);
    BatchedFuture<MutateRowsResponse> result2 = BatchedFuture.create();
    BatchedRequestIssuer<MutateRowsResponse> issuer2 = new BatchedRequestIssuer<>(result2, 1);

    List<BatchedRequestIssuer<MutateRowsResponse>> issuers =
        new ImmutableList.Builder<BatchedRequestIssuer<MutateRowsResponse>>()
            .add(issuer1)
            .add(issuer2)
            .build();

    MutateRowsResponse.Entry.Builder okEntryBuilder =
        MutateRowsResponse.Entry.newBuilder()
            .setStatus(com.google.rpc.Status.newBuilder().setCode(com.google.rpc.Code.OK_VALUE));

    MutateRowsResponse response =
        MutateRowsResponse.newBuilder()
            .addEntries(okEntryBuilder.setIndex(0).build())
            .addEntries(okEntryBuilder.setIndex(1).build())
            .build();

    descriptor.splitResponse(response, issuers);
    issuer1.sendResult();
    issuer2.sendResult();

    assertThat(result1.get(1, TimeUnit.SECONDS))
        .isEqualTo(
            MutateRowsResponse.newBuilder().addEntries(okEntryBuilder.setIndex(0).build()).build());

    assertThat(result2.get(1, TimeUnit.SECONDS))
        .isEqualTo(
            MutateRowsResponse.newBuilder().addEntries(okEntryBuilder.setIndex(0).build()).build());
  }

  @Test
  public void splitResponseErrorWrapTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    MutateRowsResponse batchResponse =
        MutateRowsResponse.newBuilder()
            .addEntries(
                MutateRowsResponse.Entry.newBuilder()
                    .setIndex(0)
                    .setStatus(
                        com.google.rpc.Status.newBuilder()
                            .setCode(com.google.rpc.Code.DEADLINE_EXCEEDED_VALUE)))
            .addEntries(
                MutateRowsResponse.Entry.newBuilder()
                    .setIndex(1)
                    .setStatus(
                        com.google.rpc.Status.newBuilder()
                            .setCode(com.google.rpc.Code.INTERNAL_VALUE)))
            .build();

    BatchedFuture<MutateRowsResponse> result1 = BatchedFuture.create();
    BatchedRequestIssuer<MutateRowsResponse> issuer1 = new BatchedRequestIssuer<>(result1, 1);

    BatchedFuture<MutateRowsResponse> result2 = BatchedFuture.create();
    BatchedRequestIssuer<MutateRowsResponse> issuer2 = new BatchedRequestIssuer<>(result2, 1);

    List<BatchedRequestIssuer<MutateRowsResponse>> issuers =
        new ImmutableList.Builder<BatchedRequestIssuer<MutateRowsResponse>>()
            .add(issuer1)
            .add(issuer2)
            .build();

    descriptor.splitResponse(batchResponse, issuers);
    issuer1.sendResult();
    issuer2.sendResult();

    Throwable actualError1 = null;

    try {
      result1.get(1, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      actualError1 = e.getCause();
    }

    assertThat(actualError1).isInstanceOf(ApiException.class);
    assertThat(((ApiException) actualError1).isRetryable()).isTrue();

    assertThat(actualError1.getCause()).isInstanceOf(StatusRuntimeException.class);
    assertThat(((StatusRuntimeException) actualError1.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.DEADLINE_EXCEEDED);

    Throwable actualError2 = null;

    try {
      result2.get(1, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      actualError2 = e.getCause();
    }

    assertThat(actualError2).isInstanceOf(ApiException.class);
    assertThat(((ApiException) actualError2).isRetryable()).isFalse();

    assertThat(actualError2.getCause()).isInstanceOf(StatusRuntimeException.class);
    assertThat(((StatusRuntimeException) actualError2.getCause()).getStatus().getCode())
        .isEqualTo(Status.Code.INTERNAL);
  }

  private static MutateRowsRequest createRequest(int count) {
    MutateRowsRequest.Builder request =
        MutateRowsRequest.newBuilder().setTableName(TABLE_NAME.toString());

    for (int i = 0; i < count; i++) {
      Builder entry =
          Entry.newBuilder()
              .addMutations(
                  Mutation.newBuilder()
                      .setSetCell(
                          SetCell.newBuilder()
                              .setFamilyName("family")
                              .setColumnQualifier(ByteString.copyFromUtf8("col" + i))
                              .setTimestampMicros(1000)
                              .setValue(ByteString.copyFromUtf8("value" + i))));
      request.addEntries(entry);
    }

    return request.build();
  }
}

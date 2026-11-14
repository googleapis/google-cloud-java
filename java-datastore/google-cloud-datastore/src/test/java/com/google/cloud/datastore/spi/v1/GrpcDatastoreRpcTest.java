/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.datastore.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datastore.v1.stub.GrpcDatastoreStub;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.datastore.v1.TransactionOptions;
import com.google.protobuf.ByteString;
import org.junit.Test;

public class GrpcDatastoreRpcTest {

  @Test
  public void testRoutingHeaders() throws Exception {
    GrpcDatastoreStub mockStub = mock(GrpcDatastoreStub.class);

    RecordingUnaryCallable<BeginTransactionRequest, BeginTransactionResponse> beginTxCallable =
        new RecordingUnaryCallable<>();
    when(mockStub.beginTransactionCallable()).thenReturn(beginTxCallable);

    RecordingUnaryCallable<RollbackRequest, RollbackResponse> rollbackCallable =
        new RecordingUnaryCallable<>();
    when(mockStub.rollbackCallable()).thenReturn(rollbackCallable);

    RecordingUnaryCallable<CommitRequest, CommitResponse> commitCallable =
        new RecordingUnaryCallable<>();
    when(mockStub.commitCallable()).thenReturn(commitCallable);

    RecordingUnaryCallable<LookupRequest, LookupResponse> lookupCallable =
        new RecordingUnaryCallable<>();
    when(mockStub.lookupCallable()).thenReturn(lookupCallable);

    RecordingUnaryCallable<RunQueryRequest, RunQueryResponse> runQueryCallable =
        new RecordingUnaryCallable<>();
    when(mockStub.runQueryCallable()).thenReturn(runQueryCallable);

    RecordingUnaryCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
        runAggQueryCallable = new RecordingUnaryCallable<>();
    when(mockStub.runAggregationQueryCallable()).thenReturn(runAggQueryCallable);

    RecordingUnaryCallable<AllocateIdsRequest, AllocateIdsResponse> allocateIdsCallable =
        new RecordingUnaryCallable<>();
    when(mockStub.allocateIdsCallable()).thenReturn(allocateIdsCallable);

    RecordingUnaryCallable<ReserveIdsRequest, ReserveIdsResponse> reserveIdsCallable =
        new RecordingUnaryCallable<>();
    when(mockStub.reserveIdsCallable()).thenReturn(reserveIdsCallable);

    GrpcDatastoreRpc rpc = new GrpcDatastoreRpc(mockStub);

    // beginTransaction -> always true
    rpc.beginTransaction(BeginTransactionRequest.getDefaultInstance());
    assertThat(beginTxCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // rollback -> always true
    rpc.rollback(RollbackRequest.getDefaultInstance());
    assertThat(rollbackCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // commit (transactional mode) -> true
    rpc.commit(CommitRequest.newBuilder().setMode(CommitRequest.Mode.TRANSACTIONAL).build());
    assertThat(commitCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // commit (non-transactional) -> false
    rpc.commit(CommitRequest.newBuilder().setMode(CommitRequest.Mode.NON_TRANSACTIONAL).build());
    assertThat(commitCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    // commit (has transaction id) -> true
    rpc.commit(CommitRequest.newBuilder().setTransaction(ByteString.copyFromUtf8("tx")).build());
    assertThat(commitCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // commit (single-use transaction) -> true
    rpc.commit(
        CommitRequest.newBuilder()
            .setSingleUseTransaction(TransactionOptions.getDefaultInstance())
            .build());
    assertThat(commitCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // lookup (transactional) -> true
    rpc.lookup(
        LookupRequest.newBuilder()
            .setReadOptions(ReadOptions.newBuilder().setTransaction(ByteString.copyFromUtf8("tx")))
            .build());
    assertThat(lookupCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // lookup (non-transactional) -> false
    rpc.lookup(LookupRequest.getDefaultInstance());
    assertThat(lookupCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    // lookup (newTransaction) -> true
    rpc.lookup(
        LookupRequest.newBuilder()
            .setReadOptions(
                ReadOptions.newBuilder().setNewTransaction(TransactionOptions.getDefaultInstance()))
            .build());
    assertThat(lookupCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // runQuery (transactional) -> true
    rpc.runQuery(
        RunQueryRequest.newBuilder()
            .setReadOptions(ReadOptions.newBuilder().setTransaction(ByteString.copyFromUtf8("tx")))
            .build());
    assertThat(runQueryCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // runQuery (non-transactional) -> false
    rpc.runQuery(RunQueryRequest.getDefaultInstance());
    assertThat(runQueryCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    // runQuery (newTransaction) -> true
    rpc.runQuery(
        RunQueryRequest.newBuilder()
            .setReadOptions(
                ReadOptions.newBuilder().setNewTransaction(TransactionOptions.getDefaultInstance()))
            .build());
    assertThat(runQueryCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // runAggregationQuery (transactional) -> true
    rpc.runAggregationQuery(
        RunAggregationQueryRequest.newBuilder()
            .setReadOptions(ReadOptions.newBuilder().setTransaction(ByteString.copyFromUtf8("tx")))
            .build());
    assertThat(runAggQueryCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // runAggregationQuery (non-transactional) -> false
    rpc.runAggregationQuery(RunAggregationQueryRequest.getDefaultInstance());
    assertThat(runAggQueryCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    // runAggregationQuery (newTransaction) -> true
    rpc.runAggregationQuery(
        RunAggregationQueryRequest.newBuilder()
            .setReadOptions(
                ReadOptions.newBuilder().setNewTransaction(TransactionOptions.getDefaultInstance()))
            .build());
    assertThat(runAggQueryCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    // allocateIds -> false
    rpc.allocateIds(AllocateIdsRequest.getDefaultInstance());
    assertThat(allocateIdsCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    // reserveIds -> false
    rpc.reserveIds(ReserveIdsRequest.getDefaultInstance());
    assertThat(reserveIdsCallable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");
  }

  private static class RecordingUnaryCallable<RequestT, ResponseT>
      extends UnaryCallable<RequestT, ResponseT> {
    ApiCallContext lastContext;

    @Override
    public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context) {
      this.lastContext = context;
      return ApiFutures.immediateFuture(null);
    }
  }
}

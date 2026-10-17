/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.spi.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.ScheduledRetryingExecutor;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamReadyObserver;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.v1.FirestoreClient.ListCollectionIdsPagedResponse;
import com.google.cloud.firestore.v1.FirestoreClient.ListDocumentsPagedResponse;
import com.google.cloud.firestore.v1.FirestoreClient.PartitionQueryPagedResponse;
import com.google.cloud.firestore.v1.stub.FirestoreStub;
import com.google.cloud.firestore.v1.stub.FirestoreStubSettings;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.TransactionOptions;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrpcFirestoreRpcTest {

  private static FirestoreStubSettings defaultStubSettings;

  private final FirestoreOptions firestoreOptionsWithoutOverride =
      FirestoreOptions.newBuilder().setProjectId("test-project").build();

  @BeforeClass
  public static void beforeClass() throws IOException {
    defaultStubSettings = FirestoreStubSettings.newBuilder().build();
  }

  static <T> T getViaReflection(Object o, String fieldName)
      throws NoSuchFieldException, IllegalAccessException {
    return getViaReflection(o.getClass(), fieldName, o);
  }

  static <T> T getViaReflection(Class clazz, String fieldName, Object o)
      throws NoSuchFieldException, IllegalAccessException {
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    return (T) field.get(o);
  }

  @Test
  public void retrySettingsOverride() throws Exception {
    RetrySettings retrySettings = RetrySettings.newBuilder().setMaxAttempts(2).build();
    FirestoreOptions firestoreOptions =
        FirestoreOptions.newBuilder()
            .setProjectId("test-project")
            .setRetrySettings(retrySettings)
            .build();
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptions);

    CallableRetryData commit = getRetryData(grpcFirestoreRpc.commitCallable());
    assertThat(commit.retrySettings).isEqualTo(retrySettings);
    assertThat(commit.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.commitSettings().getRetryableCodes());

    CallableRetryData batchWrite = getRetryData(grpcFirestoreRpc.batchWriteCallable());
    assertThat(batchWrite.retrySettings).isEqualTo(retrySettings);
    assertThat(batchWrite.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.batchWriteSettings().getRetryableCodes());

    CallableRetryData batchGetDocuments =
        getRetryData(grpcFirestoreRpc.batchGetDocumentsCallable());
    assertThat(batchGetDocuments.retrySettings).isEqualTo(retrySettings);
    assertThat(batchGetDocuments.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.batchGetDocumentsSettings().getRetryableCodes());

    CallableRetryData runQuery = getRetryData(grpcFirestoreRpc.runQueryCallable());
    assertThat(runQuery.retrySettings).isEqualTo(retrySettings);
    assertThat(runQuery.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.runQuerySettings().getRetryableCodes());

    CallableRetryData runAggregationQuery =
        getRetryData(grpcFirestoreRpc.runAggregationQueryCallable());
    assertThat(runAggregationQuery.retrySettings).isEqualTo(retrySettings);
    assertThat(runAggregationQuery.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.runAggregationQuerySettings().getRetryableCodes());

    CallableRetryData beginTransaction = getRetryData(grpcFirestoreRpc.beginTransactionCallable());
    assertThat(beginTransaction.retrySettings).isEqualTo(retrySettings);
    assertThat(beginTransaction.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.beginTransactionSettings().getRetryableCodes());

    CallableRetryData rollback = getRetryData(grpcFirestoreRpc.rollbackCallable());
    assertThat(rollback.retrySettings).isEqualTo(retrySettings);
    assertThat(rollback.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.rollbackSettings().getRetryableCodes());

    CallableRetryData listCollectionIdsPaged =
        getRetryData(grpcFirestoreRpc.listCollectionIdsPagedCallable());
    assertThat(listCollectionIdsPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(listCollectionIdsPaged.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.listCollectionIdsSettings().getRetryableCodes());

    CallableRetryData partitionQueryPaged =
        getRetryData(grpcFirestoreRpc.partitionQueryPagedCallable());
    assertThat(partitionQueryPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(partitionQueryPaged.retryableCodes)
        .containsExactlyElementsIn(
            defaultStubSettings.partitionQuerySettings().getRetryableCodes());

    CallableRetryData listDocumentsPaged =
        getRetryData(grpcFirestoreRpc.listDocumentsPagedCallable());
    assertThat(listDocumentsPaged.retrySettings).isEqualTo(retrySettings);
    assertThat(listDocumentsPaged.retryableCodes)
        .containsExactlyElementsIn(defaultStubSettings.listDocumentsSettings().getRetryableCodes());
  }

  private static RetrySettings withMaxAttempt5(RetrySettings retrySettings) {
    return retrySettings.toBuilder().setMaxAttempts(5).build();
  }

  @Test
  public void commitCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.commitCallable());
    UnaryCallSettings<CommitRequest, CommitResponse> expectedSettings =
        defaultStubSettings.commitSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void batchWriteCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.batchWriteCallable());
    UnaryCallSettings<BatchWriteRequest, BatchWriteResponse> expectedSettings =
        defaultStubSettings.batchWriteSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void batchGetDocumentsCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.batchGetDocumentsCallable());
    ServerStreamingCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        expectedSettings = defaultStubSettings.batchGetDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void runQueryCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.runQueryCallable());
    ServerStreamingCallSettings<RunQueryRequest, RunQueryResponse> expectedSettings =
        defaultStubSettings.runQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void runAggregationQueryCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.runAggregationQueryCallable());
    ServerStreamingCallSettings<RunAggregationQueryRequest, RunAggregationQueryResponse>
        expectedSettings = defaultStubSettings.runAggregationQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void executePipelineCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.executePipelineCallable());
    ServerStreamingCallSettings<ExecutePipelineRequest, ExecutePipelineResponse> expectedSettings =
        defaultStubSettings.executePipelineSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void beginTransactionCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.beginTransactionCallable());
    UnaryCallSettings<BeginTransactionRequest, BeginTransactionResponse> expectedSettings =
        defaultStubSettings.beginTransactionSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void rollbackCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.rollbackCallable());
    UnaryCallSettings<RollbackRequest, Empty> expectedSettings =
        defaultStubSettings.rollbackSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void listCollectionIdsPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.listCollectionIdsPagedCallable());
    PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        expectedSettings = defaultStubSettings.listDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void partitionQueryPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.partitionQueryPagedCallable());
    PagedCallSettings<PartitionQueryRequest, PartitionQueryResponse, PartitionQueryPagedResponse>
        expectedSettings = defaultStubSettings.partitionQuerySettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void listDocumentsPagedCallableFollowsServiceConfig() throws Exception {
    GrpcFirestoreRpc grpcFirestoreRpc = new GrpcFirestoreRpc(firestoreOptionsWithoutOverride);
    CallableRetryData actual = getRetryData(grpcFirestoreRpc.listDocumentsPagedCallable());
    PagedCallSettings<ListDocumentsRequest, ListDocumentsResponse, ListDocumentsPagedResponse>
        expectedSettings = defaultStubSettings.listDocumentsSettings();
    assertThat(actual.retrySettings)
        .isEqualTo(withMaxAttempt5(expectedSettings.getRetrySettings()));
    assertThat(actual.retryableCodes)
        .containsExactlyElementsIn(expectedSettings.getRetryableCodes());
  }

  @Test
  public void commitCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingUnaryCallable<CommitRequest, CommitResponse> callable = new RecordingUnaryCallable<>();
    when(mockStub.commitCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.commitCallable()
        .futureCall(CommitRequest.getDefaultInstance(), GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    rpc.commitCallable()
        .futureCall(
            CommitRequest.newBuilder().setTransaction(ByteString.copyFromUtf8("tx1")).build(),
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void batchWriteCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingUnaryCallable<BatchWriteRequest, BatchWriteResponse> callable =
        new RecordingUnaryCallable<>();
    when(mockStub.batchWriteCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.batchWriteCallable()
        .futureCall(BatchWriteRequest.getDefaultInstance(), GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");
  }

  @Test
  public void batchGetDocumentsCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse> callable =
        new RecordingServerStreamingCallable<>();
    when(mockStub.batchGetDocumentsCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.batchGetDocumentsCallable()
        .call(BatchGetDocumentsRequest.getDefaultInstance(), null, GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    rpc.batchGetDocumentsCallable()
        .call(
            BatchGetDocumentsRequest.newBuilder()
                .setTransaction(ByteString.copyFromUtf8("tx1"))
                .build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    rpc.batchGetDocumentsCallable()
        .call(
            BatchGetDocumentsRequest.newBuilder()
                .setNewTransaction(TransactionOptions.getDefaultInstance())
                .build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void runQueryCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingServerStreamingCallable<RunQueryRequest, RunQueryResponse> callable =
        new RecordingServerStreamingCallable<>();
    when(mockStub.runQueryCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.runQueryCallable()
        .call(RunQueryRequest.getDefaultInstance(), null, GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    rpc.runQueryCallable()
        .call(
            RunQueryRequest.newBuilder().setTransaction(ByteString.copyFromUtf8("tx1")).build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    rpc.runQueryCallable()
        .call(
            RunQueryRequest.newBuilder()
                .setNewTransaction(TransactionOptions.getDefaultInstance())
                .build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void executePipelineCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingServerStreamingCallable<ExecutePipelineRequest, ExecutePipelineResponse> callable =
        new RecordingServerStreamingCallable<>();
    when(mockStub.executePipelineCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.executePipelineCallable()
        .call(ExecutePipelineRequest.getDefaultInstance(), null, GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    rpc.executePipelineCallable()
        .call(
            ExecutePipelineRequest.newBuilder()
                .setTransaction(ByteString.copyFromUtf8("tx1"))
                .build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    rpc.executePipelineCallable()
        .call(
            ExecutePipelineRequest.newBuilder()
                .setNewTransaction(TransactionOptions.getDefaultInstance())
                .build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void runAggregationQueryCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingServerStreamingCallable<RunAggregationQueryRequest, RunAggregationQueryResponse>
        callable = new RecordingServerStreamingCallable<>();
    when(mockStub.runAggregationQueryCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.runAggregationQueryCallable()
        .call(
            RunAggregationQueryRequest.getDefaultInstance(), null, GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    rpc.runAggregationQueryCallable()
        .call(
            RunAggregationQueryRequest.newBuilder()
                .setTransaction(ByteString.copyFromUtf8("tx1"))
                .build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");

    rpc.runAggregationQueryCallable()
        .call(
            RunAggregationQueryRequest.newBuilder()
                .setNewTransaction(TransactionOptions.getDefaultInstance())
                .build(),
            null,
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void beginTransactionCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingUnaryCallable<BeginTransactionRequest, BeginTransactionResponse> callable =
        new RecordingUnaryCallable<>();
    when(mockStub.beginTransactionCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.beginTransactionCallable()
        .futureCall(BeginTransactionRequest.getDefaultInstance(), GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void rollbackCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingUnaryCallable<RollbackRequest, Empty> callable = new RecordingUnaryCallable<>();
    when(mockStub.rollbackCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.rollbackCallable()
        .futureCall(RollbackRequest.getDefaultInstance(), GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void listCollectionIdsPagedCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingUnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse> callable =
        new RecordingUnaryCallable<>();
    when(mockStub.listCollectionIdsPagedCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.listCollectionIdsPagedCallable()
        .futureCall(ListCollectionIdsRequest.getDefaultInstance(), GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");
  }

  @Test
  public void partitionQueryPagedCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingUnaryCallable<PartitionQueryRequest, PartitionQueryPagedResponse> callable =
        new RecordingUnaryCallable<>();
    when(mockStub.partitionQueryPagedCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.partitionQueryPagedCallable()
        .futureCall(PartitionQueryRequest.getDefaultInstance(), GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");
  }

  @Test
  public void listDocumentsPagedCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingUnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse> callable =
        new RecordingUnaryCallable<>();
    when(mockStub.listDocumentsPagedCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.listDocumentsPagedCallable()
        .futureCall(ListDocumentsRequest.getDefaultInstance(), GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("false");

    rpc.listDocumentsPagedCallable()
        .futureCall(
            ListDocumentsRequest.newBuilder()
                .setTransaction(ByteString.copyFromUtf8("tx1"))
                .build(),
            GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
        .containsExactly("true");
  }

  @Test
  public void listenCallableRoutingHeader() {
    FirestoreStub mockStub = mock(FirestoreStub.class);
    RecordingBidiStreamingCallable<ListenRequest, ListenResponse> callable =
        new RecordingBidiStreamingCallable<>();
    when(mockStub.listenCallable()).thenReturn(callable);
    GrpcFirestoreRpc rpc = new GrpcFirestoreRpc(mockStub);

    rpc.listenCallable().internalCall(null, null, GrpcCallContext.createDefault());
    assertThat(callable.lastContext.getExtraHeaders().get("x-goog-is-transaction"))
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

  private static class RecordingServerStreamingCallable<RequestT, ResponseT>
      extends ServerStreamingCallable<RequestT, ResponseT> {
    ApiCallContext lastContext;

    @Override
    public void call(
        RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
      this.lastContext = context;
    }
  }

  private static class RecordingBidiStreamingCallable<RequestT, ResponseT>
      extends BidiStreamingCallable<RequestT, ResponseT> {
    ApiCallContext lastContext;

    @Override
    public ClientStream<RequestT> internalCall(
        ResponseObserver<ResponseT> responseObserver,
        ClientStreamReadyObserver<RequestT> onReady,
        ApiCallContext context) {
      this.lastContext = context;
      return null;
    }
  }

  private static CallableRetryData getRetryData(Object callable) throws Exception {
    String aClassName = callable.getClass().getName();
    switch (aClassName) {
      case "com.google.api.gax.tracing.TracedUnaryCallable":
      case "com.google.api.gax.tracing.TracedServerStreamingCallable":
        return getRetryData(getViaReflection(callable, "innerCallable"));
      case "com.google.api.gax.rpc.UnaryCallable$1":
      case "com.google.api.gax.rpc.ServerStreamingCallable$1":
        return getRetryData(getViaReflection(callable, "this$0"));
      case "com.google.cloud.firestore.spi.v1.GrpcFirestoreRpc$1":
      case "com.google.cloud.firestore.spi.v1.GrpcFirestoreRpc$2":
        return getRetryData(getViaReflection(callable, "val$callable"));
      case "com.google.api.gax.rpc.RetryingCallable":
        return new CallableRetryData(
            getRetrySettings(getViaReflection(callable, "executor")),
            getRetryableCodes(getViaReflection(callable, "callable")));
      case "com.google.api.gax.rpc.RetryingServerStreamingCallable":
        return new CallableRetryData(
            getRetrySettings(getViaReflection(callable, "executor")),
            getRetryableCodes(getViaReflection(callable, "innerCallable")));
      case "com.google.api.gax.rpc.PagedCallable":
        return getRetryData(getViaReflection(callable, "callable"));
      default:
        throw new Exception("Unexpected class " + aClassName);
    }
  }

  private static Set<Code> getRetryableCodes(Object o)
      throws NoSuchFieldException, IllegalAccessException {
    switch (o.getClass().getName()) {
      case "com.google.api.gax.rpc.ServerStreamingCallable$1":
        return getRetryableCodes(getViaReflection(o, "this$0"));
      case "com.google.api.gax.rpc.WatchdogServerStreamingCallable":
        return getRetryableCodes(getViaReflection(o, "inner"));
    }
    Object exceptionFactory = getViaReflection(o, "exceptionFactory");
    return getViaReflection(exceptionFactory, "retryableCodes");
  }

  private static RetrySettings getRetrySettings(Object o) throws Exception {
    String aClassName = o.getClass().getName();
    switch (aClassName) {
      case "com.google.api.gax.retrying.ScheduledRetryingExecutor":
        {
          Object retryAlgorithm =
              getViaReflection(ScheduledRetryingExecutor.class, "retryAlgorithm", o);
          Object exponentialRetryAlgorithm =
              getViaReflection(RetryAlgorithm.class, "timedAlgorithmWithContext", retryAlgorithm);
          return getViaReflection(
              ExponentialRetryAlgorithm.class, "globalSettings", exponentialRetryAlgorithm);
        }
      default:
        throw new Exception("Unexpected class " + aClassName);
    }
  }

  static class CallableRetryData {
    final RetrySettings retrySettings;
    final Set<Code> retryableCodes;

    CallableRetryData(RetrySettings retrySettings, Set<Code> retryableCodes) {
      this.retrySettings = retrySettings;
      this.retryableCodes = retryableCodes;
    }
  }
}

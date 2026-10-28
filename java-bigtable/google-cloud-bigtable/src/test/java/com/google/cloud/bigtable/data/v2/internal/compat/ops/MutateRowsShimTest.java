/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.BatchEntry;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration;
import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.bigtable.v2.SessionScopeDiversionConfiguration;
import com.google.cloud.bigtable.data.v2.internal.api.AuthorizedViewAsync;
import com.google.cloud.bigtable.data.v2.internal.api.Client;
import com.google.cloud.bigtable.data.v2.internal.api.TableAsync;
import com.google.cloud.bigtable.data.v2.internal.api.VRpcException;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.internal.util.SessionScope;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException.FailedMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.models.TableId;
import com.google.cloud.bigtable.data.v2.models.TargetId;
import com.google.cloud.bigtable.data.v2.stub.MutateRowsErrorConverterUnaryCallable;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsAttemptResult;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsBatchingDescriptor;
import com.google.common.collect.ImmutableList;
import com.google.rpc.Code;
import io.grpc.Deadline;
import io.grpc.Status;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MutateRowsShimTest {

  private Client client;
  private TableAsync tableAsync;
  private AuthorizedViewAsync authViewAsync;
  private SessionPool<?> tablePool;
  private SessionPool<?> authViewPool;
  private MutateRowsShim shim;

  @BeforeEach
  @SuppressWarnings("unchecked")
  void setUp() {
    client = mock(Client.class);
    tableAsync = mock(TableAsync.class);
    authViewAsync = mock(AuthorizedViewAsync.class);
    tablePool = mock(SessionPool.class);
    authViewPool = mock(SessionPool.class);

    when(client.openTableAsync(any(), any())).thenReturn(tableAsync);
    when(client.openAuthorizedViewAsync(any(), any(), any())).thenReturn(authViewAsync);
    doReturn(tablePool).when(tableAsync).getSessionPool();
    doReturn(authViewPool).when(authViewAsync).getSessionPool();

    shim = new MutateRowsShim(new SessionPoolMap(client));
  }

  @Test
  void supports_tableId_belowThreshold_returnsTrue() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES - 1);

    BulkMutation request = BulkMutation.create(TableId.of("table1"));
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_tableId_atThresholdNoSession_returnsFalse() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(tablePool.hasSession()).thenReturn(false);

    BulkMutation request = BulkMutation.create(TableId.of("table1"));
    assertThat(shim.supports(request)).isFalse();
  }

  @Test
  void supports_tableId_atThresholdWithSession_returnsTrue() {
    when(tablePool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES);
    when(tablePool.hasSession()).thenReturn(true);

    BulkMutation request = BulkMutation.create(TableId.of("table1"));
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_authorizedViewId_belowThreshold_returnsTrue() {
    when(authViewPool.getConsecutiveUnimplementedFailures())
        .thenReturn(UnaryShim.MAX_CONSECUTIVE_UNIMPLEMENTED_FAILURES - 1);

    BulkMutation request = BulkMutation.create(AuthorizedViewId.of("table1", "view1"));
    assertThat(shim.supports(request)).isTrue();
  }

  @Test
  void supports_unsupportedTargetId_returnsFalse() {
    TargetId unsupported = mock(TargetId.class);
    BulkMutation request = BulkMutation.create(unsupported);
    assertThat(shim.supports(request)).isFalse();
  }

  @Test
  void call_tableId_allOk_returnsSuccess() throws Exception {
    SessionMutateRowsResponse response =
        SessionMutateRowsResponse.newBuilder()
            .addEntries(entry(0, Code.OK_VALUE, ""))
            .addEntries(entry(1, Code.OK_VALUE, ""))
            .build();
    when(tableAsync.mutateRows(any(), any()))
        .thenReturn(CompletableFuture.completedFuture(response));

    BulkMutation request =
        BulkMutation.create(TableId.of("table1"))
            .add("k0", Mutation.create().setCell("cf", "q", 1000L, "v0"))
            .add("k1", Mutation.create().setCell("cf", "q", 1000L, "v1"));
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    MutateRowsAttemptResult result = shim.call(request, deadline).get();
    assertThat(result.getFailedMutations()).isEmpty();
    assertThat(result.getIsRetryable()).isFalse();
  }

  @Test
  void call_authorizedViewId_allOk_returnsSuccess() throws Exception {
    SessionMutateRowsResponse response =
        SessionMutateRowsResponse.newBuilder().addEntries(entry(0, Code.OK_VALUE, "")).build();
    when(authViewAsync.mutateRows(any(), any()))
        .thenReturn(CompletableFuture.completedFuture(response));

    BulkMutation request =
        BulkMutation.create(AuthorizedViewId.of("table1", "view1"))
            .add("k0", Mutation.create().deleteRow());
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    MutateRowsAttemptResult result = shim.call(request, deadline).get();
    assertThat(result.getFailedMutations()).isEmpty();
    assertThat(result.getIsRetryable()).isFalse();
  }

  @Test
  void call_partialEntryFailures_mapsErrorsAndRetryabilityPerEntry() throws Exception {
    SessionMutateRowsResponse response =
        SessionMutateRowsResponse.newBuilder()
            .addEntries(entry(0, Code.OK_VALUE, ""))
            .addEntries(entry(1, Code.UNAVAILABLE_VALUE, "tablet unavailable"))
            .addEntries(entry(2, Code.INVALID_ARGUMENT_VALUE, "bad family"))
            .addEntries(entry(3, Code.UNAVAILABLE_VALUE, "non-idempotent unavailable"))
            .build();
    when(tableAsync.mutateRows(any(), any()))
        .thenReturn(CompletableFuture.completedFuture(response));

    BulkMutation request =
        BulkMutation.create(TableId.of("table1"))
            .add("k0", Mutation.create().setCell("cf", "q", 1000L, "v0"))
            .add("k1", Mutation.create().setCell("cf", "q", 1000L, "v1"))
            .add("k2", Mutation.create().setCell("cf", "q", 1000L, "v2"))
            // setCell without explicit timestamp uses server timestamp (-1), which is
            // non-idempotent
            .add("k3", Mutation.createUnsafe().setCell("cf", "q", -1L, "v3"));
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    MutateRowsAttemptResult result = shim.call(request, deadline).get();
    assertThat(result.getIsRetryable()).isTrue();
    assertThat(result.getFailedMutations()).hasSize(3);

    FailedMutation f1 = result.getFailedMutations().get(0);
    assertThat(f1.getIndex()).isEqualTo(1);
    assertThat(f1.getError().getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
    assertThat(f1.getError().isRetryable()).isTrue();

    FailedMutation f2 = result.getFailedMutations().get(1);
    assertThat(f2.getIndex()).isEqualTo(2);
    assertThat(f2.getError().getStatusCode().getCode()).isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
    assertThat(f2.getError().isRetryable()).isFalse();

    FailedMutation f3 = result.getFailedMutations().get(2);
    assertThat(f3.getIndex()).isEqualTo(3);
    assertThat(f3.getError().getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
    assertThat(f3.getError().isRetryable()).isFalse();
  }

  @Test
  void call_missingEntryInResponse_recordsPermanentInternalFailure() throws Exception {
    SessionMutateRowsResponse response =
        SessionMutateRowsResponse.newBuilder()
            .addEntries(entry(0, Code.OK_VALUE, ""))
            .addEntries(entry(2, Code.OK_VALUE, ""))
            .build();
    when(tableAsync.mutateRows(any(), any()))
        .thenReturn(CompletableFuture.completedFuture(response));

    BulkMutation request =
        BulkMutation.create(TableId.of("table1"))
            .add("k0", Mutation.create().deleteRow())
            .add("k1", Mutation.create().deleteRow())
            .add("k2", Mutation.create().deleteRow());
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    MutateRowsAttemptResult result = shim.call(request, deadline).get();
    assertThat(result.getIsRetryable()).isFalse();
    assertThat(result.getFailedMutations()).hasSize(1);
    FailedMutation missing = result.getFailedMutations().get(0);
    assertThat(missing.getIndex()).isEqualTo(1);
    assertThat(missing.getError().getStatusCode().getCode()).isEqualTo(StatusCode.Code.INTERNAL);
    assertThat(missing.getError().isRetryable()).isFalse();
    assertThat(missing.getError().getMessage()).contains("Missing entry response for entry 1");
  }

  @Test
  void call_wholeVRpcFailure_failsWithMutateRowsExceptionForAllEntries() {
    CompletableFuture<SessionMutateRowsResponse> failedFuture = new CompletableFuture<>();
    failedFuture.completeExceptionally(
        VRpcException.create(
            VRpcResult.createLocalTransportError(
                Status.UNAVAILABLE.withDescription("session disconnected"))));
    when(tableAsync.mutateRows(any(), any())).thenReturn(failedFuture);

    BulkMutation request =
        BulkMutation.create(TableId.of("table1"))
            .add("k0", Mutation.create().setCell("cf", "q", 1000L, "v0"))
            .add("k1", Mutation.createUnsafe().setCell("cf", "q", -1L, "v1"));
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    ExecutionException ex =
        assertThrows(ExecutionException.class, () -> shim.call(request, deadline).get());
    assertThat(ex.getCause()).isInstanceOf(MutateRowsException.class);
    MutateRowsException mrEx = (MutateRowsException) ex.getCause();
    assertThat(mrEx.getStatusCode().getCode()).isEqualTo(StatusCode.Code.UNAVAILABLE);
    assertThat(mrEx.isRetryable()).isTrue();
    assertThat(mrEx.getFailedMutations()).hasSize(2);
    assertThat(mrEx.getFailedMutations().get(0).getIndex()).isEqualTo(0);
    assertThat(mrEx.getFailedMutations().get(0).getError().isRetryable()).isTrue();
    assertThat(mrEx.getFailedMutations().get(1).getIndex()).isEqualTo(1);
    assertThat(mrEx.getFailedMutations().get(1).getError().isRetryable()).isFalse();
  }

  @Test
  void call_wholeVRpcFailureEmptyRequest_failsWithApiException() {
    CompletableFuture<SessionMutateRowsResponse> failedFuture = new CompletableFuture<>();
    failedFuture.completeExceptionally(
        VRpcException.create(
            VRpcResult.createRejectedError(
                Status.PERMISSION_DENIED.withDescription("access denied"))));
    when(tableAsync.mutateRows(any(), any())).thenReturn(failedFuture);

    BulkMutation emptyRequest = BulkMutation.create(TableId.of("table1"));
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    ExecutionException ex =
        assertThrows(ExecutionException.class, () -> shim.call(emptyRequest, deadline).get());
    assertThat(ex.getCause()).isInstanceOf(ApiException.class);
    assertThat(ex.getCause()).isNotInstanceOf(MutateRowsException.class);
    ApiException apiEx = (ApiException) ex.getCause();
    assertThat(apiEx.getStatusCode().getCode()).isEqualTo(StatusCode.Code.PERMISSION_DENIED);
  }

  @Test
  void divertingCallable_integratesWithErrorConverterAndBatchingDescriptor() throws Exception {
    ClientConfigurationManager configManager = mock(ClientConfigurationManager.class);
    when(configManager.getClientConfiguration())
        .thenReturn(
            ClientConfiguration.newBuilder()
                .setSessionConfiguration(
                    SessionClientConfiguration.newBuilder()
                        .setSessionDiversionConfiguration(
                            SessionDiversionConfiguration.newBuilder()
                                .setGlobalDiversion(
                                    SessionScopeDiversionConfiguration.newBuilder()
                                        .setSessionLoad(1.0f))))
                .build());

    @SuppressWarnings("unchecked")
    UnaryCallable<BulkMutation, MutateRowsAttemptResult> unusedClassic = mock(UnaryCallable.class);
    DivertingUnaryCallable<BulkMutation, MutateRowsAttemptResult> diverted =
        new DivertingUnaryCallable<>(
            configManager,
            unusedClassic,
            shim,
            Duration.ofSeconds(10),
            new NoopMetrics().getDebugTagTracer(),
            SessionScope.MUTATE_ROWS);
    MutateRowsErrorConverterUnaryCallable bulkVoidCallable =
        new MutateRowsErrorConverterUnaryCallable(diverted);

    SessionMutateRowsResponse partialFailureResponse =
        SessionMutateRowsResponse.newBuilder()
            .addEntries(entry(0, Code.OK_VALUE, ""))
            .addEntries(entry(1, Code.INVALID_ARGUMENT_VALUE, "bad col"))
            .build();
    when(tableAsync.mutateRows(any(), any()))
        .thenReturn(CompletableFuture.completedFuture(partialFailureResponse));

    RowMutationEntry row0 = RowMutationEntry.create("k0").deleteRow();
    RowMutationEntry row1 = RowMutationEntry.create("k1").deleteRow();
    BulkMutation request = BulkMutation.create(TableId.of("table1")).add(row0).add(row1);

    // 1. bulkMutateRows path surfaces MutateRowsException with OK RPC status and entry 1 failure.
    MutateRowsException thrown =
        assertThrows(
            MutateRowsException.class,
            () -> bulkVoidCallable.call(request, GrpcCallContext.createDefault()));
    assertThat(thrown.getStatusCode().getCode()).isEqualTo(StatusCode.Code.OK);
    assertThat(thrown.getFailedMutations()).hasSize(1);
    assertThat(thrown.getFailedMutations().get(0).getIndex()).isEqualTo(1);
    assertThat(thrown.getFailedMutations().get(0).getError().getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);

    // 2. Batcher path splits MutateRowsAttemptResult so row 0 succeeds and only row 1 fails.
    MutateRowsAttemptResult attemptResult = diverted.call(request, GrpcCallContext.createDefault());
    SettableApiFuture<Void> f0 = SettableApiFuture.create();
    SettableApiFuture<Void> f1 = SettableApiFuture.create();
    List<BatchEntry<RowMutationEntry, Void>> batchEntries =
        ImmutableList.of(BatchEntry.create(row0, f0), BatchEntry.create(row1, f1));
    new MutateRowsBatchingDescriptor().splitResponse(attemptResult, batchEntries);

    assertThat(f0.get()).isNull();
    ExecutionException f1Ex = assertThrows(ExecutionException.class, f1::get);
    assertThat(f1Ex.getCause()).isInstanceOf(ApiException.class);
    assertThat(((ApiException) f1Ex.getCause()).getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
  }

  @Test
  void call_unsupportedTargetId_futureFailsWithUnsupportedOperationException() {
    TargetId unsupported = mock(TargetId.class);
    BulkMutation request = BulkMutation.create(unsupported);
    Deadline deadline = Deadline.after(1, TimeUnit.SECONDS);

    CompletableFuture<MutateRowsAttemptResult> future = shim.call(request, deadline);

    assertThat(future.isCompletedExceptionally()).isTrue();
    ExecutionException ex = assertThrows(ExecutionException.class, future::get);
    assertThat(ex.getCause()).isInstanceOf(UnsupportedOperationException.class);
  }

  private static SessionMutateRowsResponse.Entry entry(int index, int code, String message) {
    SessionMutateRowsResponse.Entry.Builder builder =
        SessionMutateRowsResponse.Entry.newBuilder().setIndex(index);
    builder.getStatusBuilder().setCode(code).setMessage(message);
    return builder.build();
  }
}

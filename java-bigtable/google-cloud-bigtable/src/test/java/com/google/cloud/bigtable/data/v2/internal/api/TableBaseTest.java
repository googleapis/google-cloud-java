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

package com.google.cloud.bigtable.data.v2.internal.api;

import static com.google.cloud.bigtable.data.v2.internal.test_helpers.VRpcCallContextSubject.assertThat;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.OpenTableRequest;
import com.google.bigtable.v2.SessionCheckAndMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowResponse;
import com.google.bigtable.v2.SessionReadRowsRequest;
import com.google.bigtable.v2.SessionReadRowsResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Message;
import io.grpc.Deadline;
import io.grpc.Metadata;
import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Timeout(30)
@ExtendWith(MockitoExtension.class)
public class TableBaseTest {

  private TableBase table;
  private final FakeSessionPool fakeSessionPool = new FakeSessionPool();
  private final Metrics noopMetrics = new NoopMetrics();
  private final ScheduledExecutorService mockExecutor =
      Mockito.mock(ScheduledExecutorService.class);
  private final BigtableTimer mockTimer = Mockito.mock(BigtableTimer.class);
  private static final ClientInfo clientInfo =
      ClientInfo.builder()
          .setInstanceName(
              InstanceName.builder()
                  .setProjectId("fake-project")
                  .setInstanceId("fake-instance")
                  .build())
          .setAppProfileId("default")
          .build();
  private Deadline deadline;
  private UnaryResponseFuture<SessionMutateRowResponse> f;

  @BeforeEach
  public void setup() {
    table =
        new TableBase(
            fakeSessionPool,
            VRpcDescriptor.READ_ROW,
            VRpcDescriptor.READ_ROWS,
            VRpcDescriptor.MUTATE_ROW,
            VRpcDescriptor.CHECK_AND_MUTATE_ROW,
            noopMetrics,
            mockTimer,
            MoreExecutors.directExecutor());
    deadline = Deadline.after(1, TimeUnit.MINUTES);
    f = new UnaryResponseFuture<>();
  }

  @Test
  public void testAddToCellNotIdempotent() {
    table.mutateRow(
        SessionMutateRowRequest.newBuilder()
            .addMutations(
                Mutation.newBuilder().setAddToCell(Mutation.AddToCell.getDefaultInstance()).build())
            .build(),
        f,
        deadline);

    assertThat(fakeSessionPool.lastVRpc.ctx).isNotIdempotent();
  }

  @Test
  public void testMergeToCellNotIdempotent() {
    table.mutateRow(
        SessionMutateRowRequest.newBuilder()
            .addMutations(
                Mutation.newBuilder().setMergeToCell(Mutation.MergeToCell.getDefaultInstance()))
            .build(),
        f,
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isNotIdempotent();
  }

  @Test
  public void testSetCellSystemTimestampNotIdempotent() {
    table.mutateRow(
        SessionMutateRowRequest.newBuilder()
            .addMutations(
                Mutation.newBuilder()
                    .setSetCell(Mutation.SetCell.newBuilder().setTimestampMicros(-1).build()))
            .build(),
        f,
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isNotIdempotent();
  }

  @Test
  public void testDeleteFromRowIdempotent() {
    table.mutateRow(
        SessionMutateRowRequest.newBuilder()
            .addMutations(
                Mutation.newBuilder().setDeleteFromRow(Mutation.DeleteFromRow.getDefaultInstance()))
            .build(),
        f,
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isIdempotent();
  }

  @Test
  public void testDeleteFromColumnIdempotent() {
    table.mutateRow(
        SessionMutateRowRequest.newBuilder()
            .addMutations(
                Mutation.newBuilder()
                    .setDeleteFromColumn(Mutation.DeleteFromColumn.getDefaultInstance()))
            .build(),
        f,
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isIdempotent();
  }

  @Test
  public void testDeleteFromCfIdempotent() {
    table.mutateRow(
        SessionMutateRowRequest.newBuilder()
            .addMutations(
                Mutation.newBuilder()
                    .setDeleteFromFamily(Mutation.DeleteFromFamily.getDefaultInstance()))
            .build(),
        f,
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isIdempotent();
  }

  @Test
  public void testSetCellIdempotent() {
    table.mutateRow(
        SessionMutateRowRequest.newBuilder()
            .addMutations(Mutation.newBuilder().setSetCell(Mutation.SetCell.getDefaultInstance()))
            .build(),
        f,
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isIdempotent();
  }

  @Test
  public void testCheckAndMutateRowNotIdempotent() {
    // CheckAndMutateRow is never idempotent and must never be retried, regardless of the
    // idempotency of its underlying mutations.
    table.checkAndMutateRow(
        SessionCheckAndMutateRowRequest.newBuilder()
            .addTrueMutations(
                Mutation.newBuilder().setDeleteFromRow(Mutation.DeleteFromRow.getDefaultInstance()))
            .build(),
        new UnaryResponseFuture<>(),
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isNotIdempotent();
  }

  @Test
  public void testReadRowsIsIdempotent() {
    // Reads are idempotent, so a mid-stream failure can be resumed.
    table.readRows(
        SessionReadRowsRequest.getDefaultInstance(), new NoopReadRowsListener(), deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isIdempotent();
  }

  @Test
  public void testReadRowsAutoPumpsDemandOnDelivery() {
    // Flow control for streaming reads is fully internal: the caller never pulls. readRows starts
    // the stream with autoFlowControl=true, so once a response is delivered, VOperationImpl pumps
    // the next unit of demand down the chain automatically. Delivering one response must therefore
    // drive exactly one requestNext into the attempt without any caller involvement.
    table.readRows(
        SessionReadRowsRequest.getDefaultInstance(), new NoopReadRowsListener(), deadline);

    FakeVRpc<?, ?> attempt = fakeSessionPool.lastVRpc;
    attempt.deliver(SessionReadRowsResponse.getDefaultInstance());

    // Truth's assertThat is fully qualified here because the file statically imports the
    // VRpcCallContextSubject.assertThat overload for the idempotency checks above.
    com.google.common.truth.Truth.assertThat(attempt.requestNextCount).isEqualTo(1);
  }

  private static class NoopReadRowsListener implements VRpcListener<SessionReadRowsResponse> {
    @Override
    public void onMessage(SessionReadRowsResponse msg) {}

    @Override
    public void onClose(VRpcResult result) {}
  }

  static class FakeSessionPool implements SessionPool<OpenTableRequest> {

    private FakeVRpc<?, ?> lastVRpc = null;

    @Override
    public void start(OpenTableRequest openReq, Metadata md) {}

    @Override
    public void close(CloseSessionRequest req) {}

    @Override
    public boolean awaitTerminated(Duration timeout) {
      return true;
    }

    @Override
    public SessionPoolInfo getInfo() {
      return SessionPoolInfo.create(clientInfo, VRpcDescriptor.TABLE_SESSION, "fake-pool");
    }

    @Override
    public <ReqT extends Message, RespT extends Message> VRpc<ReqT, RespT> newCall(
        VRpcDescriptor<?, ReqT, RespT> desc) {
      FakeVRpc<ReqT, RespT> localVRpc = new FakeVRpc<>();
      this.lastVRpc = localVRpc;
      return localVRpc;
    }

    @Override
    public int getConsecutiveUnimplementedFailures() {
      return 0;
    }

    @Override
    public boolean hasSession() {
      return true;
    }
  }

  static class FakeVRpc<ReqT, RespT> implements VRpc<ReqT, RespT> {
    private VRpcCallContext ctx;
    private VRpcListener listener;
    int requestNextCount = 0;

    @Override
    public void start(Object req, VRpcCallContext ctx, VRpcListener listener) {
      this.ctx = ctx;
      this.listener = listener;
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {}

    @Override
    public boolean isDone() {
      return false;
    }

    @Override
    public void requestNext() {
      requestNextCount++;
    }

    /** Push a response up through the retry layer's listener, on the operation executor. */
    @SuppressWarnings("unchecked")
    void deliver(Object response) {
      ctx.getExecutor().execute(() -> listener.onMessage(response));
    }
  }
}

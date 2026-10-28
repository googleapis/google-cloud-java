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
import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.FeatureFlags;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.OpenTableRequest;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.bigtable.v2.SessionCheckAndMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowResponse;
import com.google.bigtable.v2.SessionMutateRowsRequest;
import com.google.bigtable.v2.SessionMutateRowsResponse;
import com.google.bigtable.v2.SessionReadModifyWriteRowRequest;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.SessionMutateRowsRateLimiter;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Message;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
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
            VRpcDescriptor.MUTATE_ROW,
            VRpcDescriptor.CHECK_AND_MUTATE_ROW,
            VRpcDescriptor.READ_MODIFY_WRITE_ROW,
            VRpcDescriptor.MUTATE_ROWS,
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
  public void testReadModifyWriteRowNotIdempotent() {
    // ReadModifyWriteRow is never idempotent and must never be retried.
    table.readModifyWriteRow(
        SessionReadModifyWriteRowRequest.newBuilder()
            .addRules(ReadModifyWriteRule.newBuilder().setFamilyName("f").build())
            .build(),
        new UnaryResponseFuture<>(),
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isNotIdempotent();
  }

  @Test
  public void testMutateRowsIdempotent() {
    table.mutateRows(
        SessionMutateRowsRequest.newBuilder()
            .addEntries(
                SessionMutateRowsRequest.Entry.newBuilder()
                    .addMutations(
                        Mutation.newBuilder()
                            .setSetCell(Mutation.SetCell.getDefaultInstance())
                            .build()))
            .build(),
        new UnaryResponseFuture<>(),
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isIdempotent();
  }

  @Test
  public void testMutateRowsNotIdempotent() {
    table.mutateRows(
        SessionMutateRowsRequest.newBuilder()
            .addEntries(
                SessionMutateRowsRequest.Entry.newBuilder()
                    .addMutations(
                        Mutation.newBuilder()
                            .setAddToCell(Mutation.AddToCell.getDefaultInstance())
                            .build()))
            .build(),
        new UnaryResponseFuture<>(),
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isNotIdempotent();
  }

  @Test
  public void testMutateRowsMixedEntriesNotIdempotent() {
    table.mutateRows(
        SessionMutateRowsRequest.newBuilder()
            .addEntries(
                SessionMutateRowsRequest.Entry.newBuilder()
                    .addMutations(
                        Mutation.newBuilder()
                            .setSetCell(Mutation.SetCell.newBuilder().setTimestampMicros(1000L))))
            .addEntries(
                SessionMutateRowsRequest.Entry.newBuilder()
                    .addMutations(
                        Mutation.newBuilder()
                            .setAddToCell(Mutation.AddToCell.getDefaultInstance())))
            .build(),
        new UnaryResponseFuture<>(),
        deadline);
    assertThat(fakeSessionPool.lastVRpc.ctx).isNotIdempotent();
  }

  @Test
  public void testMutateRowsWithRateLimiterUpdatesLimiterFromResponse() throws Exception {
    SessionMutateRowsRateLimiter limiter = new SessionMutateRowsRateLimiter();
    TableBase rateLimitedTable =
        new TableBase(
            fakeSessionPool,
            VRpcDescriptor.READ_ROW,
            VRpcDescriptor.MUTATE_ROW,
            VRpcDescriptor.CHECK_AND_MUTATE_ROW,
            VRpcDescriptor.READ_MODIFY_WRITE_ROW,
            VRpcDescriptor.MUTATE_ROWS,
            noopMetrics,
            mockTimer,
            MoreExecutors.directExecutor(),
            limiter);

    assertThat(limiter.isEnabled()).isFalse();
    assertThat(limiter.getRate()).isEqualTo(10.0);

    UnaryResponseFuture<SessionMutateRowsResponse> future = new UnaryResponseFuture<>();
    rateLimitedTable.mutateRows(
        SessionMutateRowsRequest.newBuilder()
            .addEntries(
                SessionMutateRowsRequest.Entry.newBuilder()
                    .addMutations(
                        Mutation.newBuilder()
                            .setDeleteFromRow(Mutation.DeleteFromRow.getDefaultInstance())))
            .build(),
        future,
        deadline);

    SessionMutateRowsResponse.Entry.Builder entry =
        SessionMutateRowsResponse.Entry.newBuilder().setIndex(0);
    entry.getStatusBuilder().setCode(Code.OK_VALUE);
    SessionMutateRowsResponse response =
        SessionMutateRowsResponse.newBuilder()
            .addEntries(entry)
            .setRateLimitInfo(
                SessionMutateRowsResponse.RateLimitInfo.newBuilder()
                    .setFactor(0.8)
                    .setPeriod(Durations.fromSeconds(10)))
            .build();

    @SuppressWarnings("unchecked")
    VRpc.VRpcListener<SessionMutateRowsResponse> listener =
        (VRpc.VRpcListener<SessionMutateRowsResponse>) fakeSessionPool.lastVRpc.listener;
    fakeSessionPool
        .lastVRpc
        .ctx
        .getExecutor()
        .execute(
            () -> {
              listener.onMessage(response);
              listener.onClose(VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance()));
            });

    assertThat(future.get()).isEqualTo(response);
    assertThat(limiter.isEnabled()).isTrue();
    assertThat(limiter.getRate()).isWithin(0.001).of(8.0);
  }

  @Test
  public void testClientComputeBaseFeatureFlagsReflectsFlowControlSetting() {
    ChannelProviders.ChannelProvider channelProvider =
        Mockito.mock(ChannelProviders.ChannelProvider.class);
    ClientSettings defaultSettings =
        ClientSettings.builder()
            .setChannelProvider(channelProvider)
            .setInstanceName(clientInfo.getInstanceName())
            .setAppProfileId("default")
            .build();
    FeatureFlags defaultFlags = Client.computeBaseFeatureFlags(defaultSettings);
    assertThat(defaultFlags.getMutateRowsRateLimit()).isFalse();
    assertThat(defaultFlags.getMutateRowsRateLimit2()).isFalse();

    ClientSettings enabledSettings =
        ClientSettings.builder()
            .setChannelProvider(channelProvider)
            .setInstanceName(clientInfo.getInstanceName())
            .setAppProfileId("default")
            .setServerInitiatedFlowControlEnabled(true)
            .build();
    FeatureFlags enabledFlags = Client.computeBaseFeatureFlags(enabledSettings);
    assertThat(enabledFlags.getMutateRowsRateLimit()).isTrue();
    assertThat(enabledFlags.getMutateRowsRateLimit2()).isTrue();
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
    private VRpcListener<RespT> listener;

    @Override
    public void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener) {
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
    public void requestNext() {}
  }
}

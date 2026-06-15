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
import com.google.bigtable.v2.SessionMutateRowRequest;
import com.google.bigtable.v2.SessionMutateRowResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.Metrics;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.protobuf.Message;
import io.grpc.Deadline;
import io.grpc.Metadata;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TableBaseTest {

  private TableBase table;
  private final FakeSessionPool fakeSessionPool = new FakeSessionPool();
  private final Metrics noopMetrics = new NoopMetrics();
  private final ScheduledExecutorService mockExecutor =
      Mockito.mock(ScheduledExecutorService.class);
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
            noopMetrics,
            mockExecutor);
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

  static class FakeSessionPool implements SessionPool<OpenTableRequest> {

    private FakeVRpc<?, ?> lastVRpc = null;

    @Override
    public void start(OpenTableRequest openReq, Metadata md) {}

    @Override
    public void close(CloseSessionRequest req) {}

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

    @Override
    public void start(Object req, VRpcCallContext ctx, VRpcListener ignored) {
      this.ctx = ctx;
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {}

    @Override
    public void requestNext() {}
  }
}

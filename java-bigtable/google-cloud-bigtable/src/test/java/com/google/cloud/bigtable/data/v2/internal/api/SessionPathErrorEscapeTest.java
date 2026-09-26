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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.bigtable.v2.CloseSessionRequest;
import com.google.bigtable.v2.SessionReadRowRequest;
import com.google.bigtable.v2.SessionReadRowResponse;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.BigtableTimer;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPool;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Message;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;

/**
 * Fault injection at the seam between {@code SessionPoolMap.apply} and the session machinery.
 *
 * <p>An application-visible UNKNOWN requires a throwable with no grpc Status to reach {@code
 * DivertingUnaryCallable.translateException}. That can only happen if the throw escapes {@link
 * TableBase#readRow} synchronously, because everything inside the op chain is converted to a Status
 * first. These tests establish which throw sites actually escape.
 */
@Timeout(30)
public class SessionPathErrorEscapeTest {

  private static final ClientInfo CLIENT_INFO =
      ClientInfo.builder()
          .setInstanceName(
              InstanceName.builder()
                  .setProjectId("fake-project")
                  .setInstanceId("fake-instance")
                  .build())
          .setAppProfileId("default")
          .build();

  private final BigtableTimer mockTimer = Mockito.mock(BigtableTimer.class);
  private final Deadline deadline = Deadline.after(1, TimeUnit.MINUTES);

  @Test
  public void sessionPoolNewCallThrow_isConvertedToCancelled() {
    // Verifies that a throw out of SessionPool.newCall does not escape as a bare throwable: it is
    // caught by RetryingVRpc.start and turned into CANCELLED, both for the caller and in CSM.
    //
    // The throw is injected directly rather than raced for -- FakeSessionPool.newCall throws the
    // IllegalStateException that SessionList would raise on a real close/drain race ("NEW session
    // was closed", "double close"). The test is about what RetryingVRpc does with such a throw, not
    // about reproducing the interleaving that produces it, so injecting it keeps the test
    // deterministic. It also means the SessionList race cannot be a source of an application
    // UNKNOWN: whatever wins the race, the throw surfaces as CANCELLED in both places.
    CountingMetrics metrics = new CountingMetrics();
    FakeSessionPool pool = new FakeSessionPool();
    pool.throwOnNewCall = new IllegalStateException("double close");
    TableBase table = newTable(pool, metrics);
    UnaryResponseFuture<SessionReadRowResponse> listener = new UnaryResponseFuture<>();

    table.readRow(SessionReadRowRequest.getDefaultInstance(), listener, deadline);

    assertThat(listener.isCompletedExceptionally()).isTrue();
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> listener.get(5, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(VRpcException.class);
    VRpcException vrpc = (VRpcException) ee.getCause();
    assertThat(vrpc.getStatus().getCode()).isEqualTo(Status.Code.CANCELLED);
    // The original throw survives as the cause, and CSM records the same CANCELLED the caller saw.
    assertThat(Status.fromThrowable(vrpc).getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(metrics.operationsFinished.get()).isEqualTo(1);
    assertThat(metrics.lastOperationStatus.get()).isEqualTo(Status.Code.CANCELLED);
  }

  @Test
  public void okResultWithoutMessage_failsCallerButRecordsOkInCsm() {
    // Verifies the quietest failure mode: an application error that CSM records as a success.
    //
    // UnaryResponseFuture.onClose completes the caller exceptionally with a bare
    // IllegalStateException when the vRPC closes OK but no message arrived. The VRpcResult status
    // is OK, so the tracer records OK and the server saw a success -- yet the application gets an
    // exception, and translateException has no Status to read from it.
    //
    // A row that does not exist does NOT take this path: the server still sends one
    // SessionReadRowResponse, with `row` unset, and ReadRowShim#buildRow turns that into a null
    // row. So reaching here means the server closed OK without sending the message at all, which
    // is a protocol violation rather than a normal not-found -- throwing is right, and the code
    // below pins what the caller sees when it happens.
    UnaryResponseFuture<SessionReadRowResponse> listener = new UnaryResponseFuture<>();
    VRpcResult okResult = VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance());
    assertThat(okResult.getStatus().isOk()).isTrue();

    listener.onClose(okResult);

    assertThat(listener.isCompletedExceptionally()).isTrue();
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> listener.get(5, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(IllegalStateException.class);
    assertThat(ee).hasCauseThat().hasMessageThat().contains("missing result");
    // No grpc Status anywhere on it -- this is exactly the input translateException has to classify
    // without help. See DivertingUnaryCallableTest#translateException_illegalStateBecomesInternal.
    assertThat(ee.getCause()).isNotInstanceOf(io.grpc.StatusRuntimeException.class);
  }

  @Test
  public void okResultWithMessage_completesNormally() {
    // Verifies the control for the test above: the same OK result with a message delivered first
    // completes the caller normally.
    UnaryResponseFuture<SessionReadRowResponse> listener = new UnaryResponseFuture<>();
    SessionReadRowResponse response = SessionReadRowResponse.getDefaultInstance();

    listener.onMessage(response);
    listener.onClose(VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance()));

    assertThat(listener.isCompletedExceptionally()).isFalse();
  }

  private TableBase newTable(FakeSessionPool pool, CountingMetrics metrics) {
    return new TableBase(
        pool,
        VRpcDescriptor.READ_ROW,
        VRpcDescriptor.MUTATE_ROW,
        metrics,
        mockTimer,
        MoreExecutors.directExecutor());
  }

  /** NoopMetrics that records what the operation-level tracer was told at completion. */
  private static final class CountingMetrics extends NoopMetrics {
    final AtomicInteger operationsFinished = new AtomicInteger();
    final AtomicReference<Status.Code> lastOperationStatus = new AtomicReference<>();

    @Override
    public VRpcTracer newTableTracer(
        SessionPoolInfo poolInfo, VRpcDescriptor descriptor, Deadline deadline) {
      return new NoopVrpcTracer() {
        @Override
        public void onOperationFinish(VRpcResult result) {
          operationsFinished.incrementAndGet();
          lastOperationStatus.set(result.getStatus().getCode());
        }
      };
    }
  }

  /** SessionPool whose newCall can be told to throw, simulating a close/drain race. */
  private static final class FakeSessionPool
      implements SessionPool<com.google.bigtable.v2.OpenTableRequest> {
    @Nullable RuntimeException throwOnNewCall;

    @Override
    public void start(com.google.bigtable.v2.OpenTableRequest openReq, Metadata md) {}

    @Override
    public void close(CloseSessionRequest req) {}

    @Override
    public boolean awaitTerminated(Duration timeout) {
      return true;
    }

    @Override
    public SessionPoolInfo getInfo() {
      return SessionPoolInfo.create(CLIENT_INFO, VRpcDescriptor.TABLE_SESSION, "fake-pool");
    }

    @Override
    public <ReqT extends Message, RespT extends Message> VRpc<ReqT, RespT> newCall(
        VRpcDescriptor<?, ReqT, RespT> desc) {
      if (throwOnNewCall != null) {
        throw throwOnNewCall;
      }
      return new NeverCompletingVRpc<>();
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

  private static final class NeverCompletingVRpc<ReqT, RespT> implements VRpc<ReqT, RespT> {
    @Override
    public void start(Object req, VRpcCallContext ctx, VRpcListener listener) {}

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

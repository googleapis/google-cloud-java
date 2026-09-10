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
import javax.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;

/**
 * Fault injection at the seam between {@code SessionPoolMap.apply} and the session machinery.
 *
 * <p>Context: a production incident produced application-visible UNKNOWN errors with no matching
 * UNKNOWN in CSM or on the server. An UNKNOWN requires a throwable with no grpc Status to reach
 * {@code DivertingUnaryCallable.translateException}. That can only happen if the throw escapes
 * {@link TableBase#readRow} synchronously, because everything inside the op chain is converted to a
 * Status first. These tests establish which throw sites actually escape.
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

  // -----------------------------------------------------------------------------------------
  // Escapes: reaches SessionPoolMap.apply's `catch (Throwable)` with no Status attached, and so
  // becomes an application UNKNOWN.
  // -----------------------------------------------------------------------------------------

  @Test
  public void tracerConstructionThrow_escapesReadRowSynchronously() {
    // metrics.newTableTracer is called on the caller's thread in TableBase.readRow, outside any
    // try/catch, before the op chain exists. MetricsImpl's implementation splits the method name
    // and calls into a user-supplied ApiTracerFactory, so a throw here is reachable in production.
    // Nothing downstream can convert it, so it propagates out of readRow.
    CountingMetrics metrics = new CountingMetrics();
    metrics.throwOnNewTracer = new IllegalStateException("tracer factory blew up");
    TableBase table = newTable(new FakeSessionPool(), metrics);
    UnaryResponseFuture<SessionReadRowResponse> listener = new UnaryResponseFuture<>();

    IllegalStateException thrown =
        assertThrows(
            IllegalStateException.class,
            () -> table.readRow(SessionReadRowRequest.getDefaultInstance(), listener, deadline));

    assertThat(thrown).hasMessageThat().isEqualTo("tracer factory blew up");
    // The listener never hears about it -- the caller's future would hang if SessionPoolMap.apply
    // did not convert the escaping throw into a failed future.
    assertThat(listener.isDone()).isFalse();
    // And CSM has no record of the operation at all: it never started, so it never finished.
    assertThat(metrics.operationsFinished.get()).isEqualTo(0);
  }

  // -----------------------------------------------------------------------------------------
  // Does NOT escape: converted to a Status inside the op chain, so it lands in CSM with a real
  // code and can never be the source of an application UNKNOWN.
  // -----------------------------------------------------------------------------------------

  @Test
  public void sessionPoolNewCallThrow_isConvertedToCancelled() {
    // A throw from SessionPool.newCall / PendingCall.start -- the shape SessionList raises on a
    // close/drain race ("NEW session was closed", "double close") -- is caught by
    // RetryingVRpc.start's try/catch and turned into Status.CANCELLED. It reaches the listener as
    // a VRpcException, which IS a StatusRuntimeException, so translateException maps it cleanly.
    //
    // This rules the SessionList race out as a source of application UNKNOWN: it would show up as
    // CANCELLED in both CSM and the application.
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
    // The original throw survives as the cause, and the operation IS recorded in CSM.
    assertThat(Status.fromThrowable(vrpc).getCause()).isInstanceOf(IllegalStateException.class);
    assertThat(metrics.operationsFinished.get()).isEqualTo(1);
  }

  // -----------------------------------------------------------------------------------------
  // The quietest failure mode: an application error that CSM records as a success.
  // -----------------------------------------------------------------------------------------

  @Test
  public void okResultWithoutMessage_failsCallerButRecordsOkInCsm() {
    // UnaryResponseFuture.onClose completes the caller exceptionally with a bare
    // IllegalStateException when the vRPC closes OK but no message arrived. The VRpcResult status
    // is OK, so the tracer records OK and the server saw a success -- yet the application gets an
    // exception, and translateException has no Status to read, so it presents it as UNKNOWN.
    //
    // This is the only path found that yields application UNKNOWN with *no* error anywhere in CSM
    // or on the server, which is the signature reported in production.
    UnaryResponseFuture<SessionReadRowResponse> listener = new UnaryResponseFuture<>();
    VRpcResult okResult = VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance());
    assertThat(okResult.getStatus().isOk()).isTrue();

    listener.onClose(okResult);

    assertThat(listener.isCompletedExceptionally()).isTrue();
    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> listener.get(5, TimeUnit.SECONDS));
    assertThat(ee).hasCauseThat().isInstanceOf(IllegalStateException.class);
    assertThat(ee).hasCauseThat().hasMessageThat().contains("missing result");
    // No grpc Status anywhere on it -- this is exactly the input that translateException defaults
    // to UNKNOWN. See
    // DivertingUnaryCallableTest#translateException_nonStatusThrowableBecomesUnknown.
    assertThat(ee.getCause()).isNotInstanceOf(io.grpc.StatusRuntimeException.class);
  }

  @Test
  public void okResultWithMessage_completesNormally() {
    // Control for the test above: the same OK result with a message delivered first succeeds.
    UnaryResponseFuture<SessionReadRowResponse> listener = new UnaryResponseFuture<>();
    SessionReadRowResponse response = SessionReadRowResponse.getDefaultInstance();

    listener.onMessage(response);
    listener.onClose(VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance()));

    assertThat(listener.isCompletedExceptionally()).isFalse();
  }

  // -----------------------------------------------------------------------------------------

  private TableBase newTable(FakeSessionPool pool, CountingMetrics metrics) {
    return new TableBase(
        pool,
        VRpcDescriptor.READ_ROW,
        VRpcDescriptor.MUTATE_ROW,
        metrics,
        mockTimer,
        MoreExecutors.directExecutor());
  }

  /** NoopMetrics that counts operation completions and can be told to throw on tracer creation. */
  private static final class CountingMetrics extends NoopMetrics {
    final AtomicInteger operationsFinished = new AtomicInteger();
    @Nullable RuntimeException throwOnNewTracer;

    @Override
    public VRpcTracer newTableTracer(
        SessionPoolInfo poolInfo, VRpcDescriptor descriptor, Deadline deadline) {
      if (throwOnNewTracer != null) {
        throw throwOnNewTracer;
      }
      return new NoopVrpcTracer() {
        @Override
        public void onOperationFinish(VRpcResult result) {
          operationsFinished.incrementAndGet();
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

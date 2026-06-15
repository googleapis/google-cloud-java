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
package com.google.cloud.bigtable.data.v2.internal.middleware;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigtable.data.v2.internal.csm.NoopMetrics;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcCallContext;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcListener;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Status;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.junit.jupiter.api.Test;

class VOperationImplTest {

  @Test
  void grpcContextCancelPropagatesToChain() throws InterruptedException {
    // Normal-path sanity: addListener fires (chain.start doesn't queue an onClose), then a
    // later grpcContext.cancel routes through cancellationListener -> opExecutor -> chain.cancel.
    // This exercises the new runInline-based addListener path introduced to close the TOCTOU
    // between wrapped.closed and addListener.
    Context.CancellableContext grpcContext = Context.current().withCancellation();
    AtomicInteger chainCancelCount = new AtomicInteger();
    CountDownLatch cancelLatch = new CountDownLatch(1);

    VRpc<String, String> chain =
        new VRpc<String, String>() {
          @Override
          public void start(String req, VRpcCallContext ctx, VRpcListener<String> listener) {
            // Hold open — do not call listener.onClose. Cancellation must drive termination.
          }

          @Override
          public void cancel(@Nullable String msg, @Nullable Throwable cause) {
            chainCancelCount.incrementAndGet();
            cancelLatch.countDown();
          }

          @Override
          public void requestNext() {}
        };

    VOperationImpl<String, String> op =
        new VOperationImpl<>(
            chain,
            grpcContext,
            MoreExecutors.directExecutor(),
            NoopMetrics.NoopVrpcTracer.INSTANCE,
            Deadline.after(10, TimeUnit.SECONDS),
            true);

    op.start(
        "req",
        new VRpcListener<String>() {
          @Override
          public void onMessage(String msg) {}

          @Override
          public void onClose(VRpcResult result) {}
        });

    grpcContext.cancel(Status.CANCELLED.withDescription("test").asException());

    assertThat(cancelLatch.await(2, TimeUnit.SECONDS)).isTrue();
    assertThat(chainCancelCount.get()).isEqualTo(1);
  }

  @Test
  void asyncOnCloseFromChainDoesNotPropagateLaterContextCancel() throws InterruptedException {
    // Regression for the wrapped.closed TOCTOU. When chain.start asynchronously queues an
    // onClose via the op executor, the addListener task (also queued through the op executor
    // by VOperationImpl.start) drains FIFO after the onClose and observes wrapped.closed=true,
    // so the cancellationListener is NOT registered. A later grpcContext.cancel therefore has
    // no path to reach chain.cancel — which is correct because the chain has already terminated.
    Context.CancellableContext grpcContext = Context.current().withCancellation();
    AtomicInteger chainCancelCount = new AtomicInteger();
    AtomicReference<VRpcResult> userClose = new AtomicReference<>();
    CountDownLatch onCloseLatch = new CountDownLatch(1);

    VRpc<String, String> chain =
        new VRpc<String, String>() {
          @Override
          public void start(String req, VRpcCallContext ctx, VRpcListener<String> listener) {
            // Simulate PendingVRpc pool-closed branch / VRpcImpl deadline short-circuit.
            ctx.getExecutor()
                .execute(
                    () ->
                        listener.onClose(
                            VRpcResult.createUncommitedError(
                                Status.UNAVAILABLE.withDescription("fast-fail"))));
          }

          @Override
          public void cancel(@Nullable String msg, @Nullable Throwable cause) {
            chainCancelCount.incrementAndGet();
          }

          @Override
          public void requestNext() {}
        };

    VOperationImpl<String, String> op =
        new VOperationImpl<>(
            chain,
            grpcContext,
            MoreExecutors.directExecutor(),
            NoopMetrics.NoopVrpcTracer.INSTANCE,
            Deadline.after(10, TimeUnit.SECONDS),
            true);

    op.start(
        "req",
        new VRpcListener<String>() {
          @Override
          public void onMessage(String msg) {}

          @Override
          public void onClose(VRpcResult result) {
            userClose.set(result);
            onCloseLatch.countDown();
          }
        });

    assertThat(onCloseLatch.await(2, TimeUnit.SECONDS)).isTrue();
    assertThat(userClose.get().getStatus().getCode()).isEqualTo(Status.UNAVAILABLE.getCode());

    grpcContext.cancel(Status.CANCELLED.withDescription("test").asException());
    Thread.sleep(50); // give any leaked listener a chance to fire

    // No chain.cancel — the cancellationListener was correctly skipped because the chain had
    // already reached its terminal state via the queued onClose.
    assertThat(chainCancelCount.get()).isEqualTo(0);
  }
}

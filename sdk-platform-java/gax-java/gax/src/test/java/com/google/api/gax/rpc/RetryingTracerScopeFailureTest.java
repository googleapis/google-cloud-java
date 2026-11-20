/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.api.gax.tracing.BaseApiTracerFactory;
import com.google.api.gax.tracing.CompositeTracerFactory;
import com.google.api.gax.tracing.SpanName;
import com.google.api.gax.tracing.TracedUnaryCallable;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * End-to-end regression test verifying that a retrying traced RPC future completes with the
 * original RPC error instead of hanging when a child tracer's {@link ApiTracer#inScope()} throws.
 */
class RetryingTracerScopeFailureTest {
  private ScheduledExecutorService executor;
  private ClientContext clientContext;

  /** Initializes a scheduled executor and {@link ClientContext} for retrying callable tests. */
  @BeforeEach
  void setUp() {
    executor = Executors.newSingleThreadScheduledExecutor();
    clientContext =
        ClientContext.newBuilder()
            .setExecutor(executor)
            .setClock(NanoClock.getDefaultClock())
            .setDefaultCallContext(FakeCallContext.createDefault())
            .build();
  }

  /** Shuts down the test executor. */
  @AfterEach
  void tearDown() {
    executor.shutdownNow();
  }

  /**
   * Verifies that the retrying future completes immediately with the original RPC error even when a
   * child tracer's {@link ApiTracer#inScope()} throws during completion callbacks.
   */
  @Test
  void retryingFutureCompletes_whenTracerScopeThrows() {
    ApiException rpcError =
        new InvalidArgumentException(
            null, FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);

    UnaryCallable<Integer, Integer> transport =
        new UnaryCallable<Integer, Integer>() {
          @Override
          public ApiFuture<Integer> futureCall(Integer request, ApiCallContext context) {
            return ApiFutures.immediateFailedFuture(rpcError);
          }
        };

    ApiTracer brokenScopeTracer =
        new BaseApiTracer() {
          @Override
          public Scope inScope() {
            throw new IllegalStateException("broken inScope()");
          }
        };

    ApiTracerFactory tracerFactory =
        new CompositeTracerFactory(
            ImmutableList.of(
                BaseApiTracerFactory.getInstance(),
                (parent, spanName, operationType) -> brokenScopeTracer));

    UnaryCallSettings<Integer, Integer> callSettings =
        UnaryCallSettings.<Integer, Integer>newUnaryCallSettingsBuilder()
            .setRetryableCodes(StatusCode.Code.UNAVAILABLE)
            .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(3).build())
            .build();

    UnaryCallable<Integer, Integer> callable =
        new TracedUnaryCallable<>(
            Callables.retrying(transport, callSettings, clientContext),
            tracerFactory,
            SpanName.of("FakeClient", "FakeMethod"));

    ApiFuture<Integer> future = callable.futureCall(1, FakeCallContext.createDefault());

    // If the exception from inScope() escapes BasicRetryingFuture.handleAttempt, Guava's listener
    // loop swallows it and the retrying future is never completed.
    assertThat(future.isDone()).isTrue();
    ExecutionException e = assertThrows(ExecutionException.class, future::get);
    assertThat(e).hasCauseThat().isSameInstanceAs(rpcError);
  }
}

/*
 * Copyright 2016 Google LLC
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

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.FakeApiClock;
import com.google.api.gax.core.RecordingScheduler;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeCallableFactory;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CancellationTest {

  @SuppressWarnings("unchecked")
  private UnaryCallable<Integer, Integer> callInt = Mockito.mock(UnaryCallable.class);

  private static final RetrySettings FAST_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(2L))
          .setRetryDelayMultiplier(1)
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(2L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(2L))
          .setRpcTimeoutMultiplier(1)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(2L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(20L))
          .build();

  private static final RetrySettings SLOW_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelayDuration(java.time.Duration.ofMillis(3000L))
          .setRetryDelayMultiplier(1)
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(3000L))
          .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(3000L))
          .setRpcTimeoutMultiplier(1)
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(3000L))
          .setTotalTimeoutDuration(java.time.Duration.ofMillis(3000L))
          .build();

  private FakeApiClock fakeClock;
  private RecordingScheduler executor;
  private ClientContext clientContext;

  @BeforeEach
  void resetClock() {
    fakeClock = new FakeApiClock(System.nanoTime());
    executor = RecordingScheduler.create(fakeClock);
    clientContext =
        ClientContext.newBuilder()
            .setExecutor(executor)
            .setClock(fakeClock)
            .setDefaultCallContext(FakeCallContext.createDefault())
            .setTransportChannel(FakeTransportChannel.create(new FakeChannel()))
            .build();
  }

  @AfterEach
  void teardown() {
    executor.shutdownNow();
  }

  @Test
  void cancellationBeforeGetOnRetryingCallable() throws Exception {
    try {
      Mockito.when(callInt.futureCall((Integer) Mockito.any(), (ApiCallContext) Mockito.any()))
          .thenReturn(SettableApiFuture.<Integer>create());

      UnaryCallSettings<Integer, Integer> callSettings =
          RetryingTest.createSettings(FAST_RETRY_SETTINGS);
      UnaryCallable<Integer, Integer> callable =
          FakeCallableFactory.createUnaryCallable(callInt, callSettings, clientContext);

      ApiFuture<Integer> resultFuture = callable.futureCall(0);
      resultFuture.cancel(true);
      resultFuture.get();
      Assertions.fail("Callable should have thrown an exception");
    } catch (CancellationException expected) {
      Truth.assertThat(expected).hasMessageThat().contains("Task was cancelled");
    }
  }

  private static class CancellationTrackingFuture<RespT> extends AbstractApiFuture<RespT> {
    private volatile boolean cancelled = false;

    public static <RespT> CancellationTrackingFuture<RespT> create() {
      return new CancellationTrackingFuture<>();
    }

    private CancellationTrackingFuture() {}

    @Override
    protected void interruptTask() {
      cancelled = true;
    }

    public boolean isCancelled() {
      return cancelled;
    }
  }

  private static class LatchCountDownFutureCallable<RequestT, ResponseT>
      extends UnaryCallable<RequestT, ResponseT> {
    private CountDownLatch callLatch;
    private List<ApiFuture<ResponseT>> injectedFutures;

    @SuppressWarnings("unchecked")
    public LatchCountDownFutureCallable(
        CountDownLatch callLatch, ApiFuture<ResponseT> injectedFuture) {
      this(callLatch, Lists.newArrayList(injectedFuture));
    }

    public LatchCountDownFutureCallable(
        CountDownLatch callLatch, List<ApiFuture<ResponseT>> injectedFutures) {
      this.callLatch = callLatch;
      this.injectedFutures = Lists.newArrayList(injectedFutures);
    }

    @Override
    public ApiFuture<ResponseT> futureCall(RequestT request, ApiCallContext context) {
      callLatch.countDown();
      return injectedFutures.remove(0);
    }
  }

  @Test
  void cancellationDuringFirstCall() throws Exception {
    CancellationTrackingFuture<Integer> innerFuture = CancellationTrackingFuture.<Integer>create();
    CountDownLatch callIssuedLatch = new CountDownLatch(1);
    UnaryCallable<Integer, Integer> innerCallable =
        new LatchCountDownFutureCallable<>(callIssuedLatch, innerFuture);

    UnaryCallSettings<Integer, Integer> callSettings =
        RetryingTest.createSettings(FAST_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        FakeCallableFactory.createUnaryCallable(
            innerCallable,
            callSettings,
            clientContext.toBuilder().setExecutor(new ScheduledThreadPoolExecutor(1)).build());

    ApiFuture<Integer> resultFuture = callable.futureCall(0);
    CancellationHelpers.cancelInThreadAfterLatchCountDown(resultFuture, callIssuedLatch);
    CancellationException gotException = null;
    try {
      resultFuture.get();
    } catch (CancellationException e) {
      gotException = e;
    }
    Truth.assertThat(gotException).isNotNull();
    Truth.assertThat(innerFuture.isCancelled()).isTrue();
  }

  @Test
  void cancellationDuringRetryDelay() throws Exception {
    Throwable throwable =
        new UnavailableException(null, FakeStatusCode.of(StatusCode.Code.UNAVAILABLE), true);
    CancellationTrackingFuture<Integer> innerFuture = CancellationTrackingFuture.create();
    Mockito.when(callInt.futureCall((Integer) Mockito.any(), (ApiCallContext) Mockito.any()))
        .thenReturn(RetryingTest.<Integer>immediateFailedFuture(throwable))
        .thenReturn(innerFuture);

    CountDownLatch retryScheduledLatch = new CountDownLatch(1);
    LatchCountDownScheduler scheduler = LatchCountDownScheduler.get(retryScheduledLatch, 0L, 0L);
    UnaryCallSettings<Integer, Integer> callSettings =
        RetryingTest.createSettings(SLOW_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        FakeCallableFactory.createUnaryCallable(
            callInt, callSettings, clientContext.toBuilder().setExecutor(scheduler).build());

    ApiFuture<Integer> resultFuture = callable.futureCall(0);
    CancellationHelpers.cancelInThreadAfterLatchCountDown(resultFuture, retryScheduledLatch);
    CancellationException gotException = null;
    try {
      resultFuture.get();
    } catch (CancellationException e) {
      gotException = e;
    }
    Truth.assertThat(gotException).isNotNull();
    Truth.assertThat(resultFuture.isDone()).isTrue();
    Truth.assertThat(resultFuture.isCancelled()).isTrue();
    Truth.assertThat(innerFuture.isCancelled()).isFalse();

    scheduler.shutdownNow();
  }

  @Test
  void cancellationDuringSecondCall() throws Exception {
    Throwable throwable =
        new UnavailableException(null, FakeStatusCode.of(StatusCode.Code.UNAVAILABLE), true);
    ApiFuture<Integer> failingFuture = RetryingTest.immediateFailedFuture(throwable);
    CancellationTrackingFuture<Integer> innerFuture = CancellationTrackingFuture.create();
    CountDownLatch callIssuedLatch = new CountDownLatch(2);
    @SuppressWarnings("unchecked")
    UnaryCallable<Integer, Integer> innerCallable =
        new LatchCountDownFutureCallable<>(
            callIssuedLatch, Lists.newArrayList(failingFuture, innerFuture));

    UnaryCallSettings<Integer, Integer> callSettings =
        RetryingTest.createSettings(FAST_RETRY_SETTINGS);
    UnaryCallable<Integer, Integer> callable =
        FakeCallableFactory.createUnaryCallable(
            innerCallable,
            callSettings,
            clientContext.toBuilder().setExecutor(new ScheduledThreadPoolExecutor(1)).build());

    ApiFuture<Integer> resultFuture = callable.futureCall(0);
    CancellationHelpers.cancelInThreadAfterLatchCountDown(resultFuture, callIssuedLatch);
    CancellationException gotException = null;
    try {
      resultFuture.get();
    } catch (CancellationException e) {
      gotException = e;
    }
    Truth.assertThat(gotException).isNotNull();
    Truth.assertThat(resultFuture.isDone()).isTrue();
    Truth.assertThat(resultFuture.isCancelled()).isTrue();
    Truth.assertThat(innerFuture.isDone()).isTrue();
  }
}

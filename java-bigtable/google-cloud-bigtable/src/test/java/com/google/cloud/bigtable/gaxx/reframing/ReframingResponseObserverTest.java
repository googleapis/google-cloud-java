/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.gaxx.reframing;

import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable.StreamControllerStash;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockResponseObserver;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCall;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockServerStreamingCallable;
import com.google.cloud.bigtable.gaxx.testing.MockStreamingApi.MockStreamController;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Queues;
import com.google.common.truth.Truth;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReframingResponseObserverTest {
  private ExecutorService executor;

  @Before
  public void setUp() throws Exception {
    executor = Executors.newCachedThreadPool();
  }

  @After
  public void tearDown() throws Exception {
    executor.shutdownNow();
  }

  @Test
  public void testUnsolicitedResponseError() throws Exception {
    // Have the outer observer request manual flow control
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(false);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(1));
    MockServerStreamingCallable<String, String> innerCallable = new MockServerStreamingCallable<>();

    innerCallable.call("request", middleware);
    MockServerStreamingCall<String, String> lastCall = innerCallable.popLastCall();
    MockStreamController<String> innerController = lastCall.getController();

    // Nothing was requested by the outer observer (thats also in manual flow control)
    Preconditions.checkState(innerController.popLastPull() == 0);

    Throwable error = null;
    try {
      // send an unsolicited response
      innerController.getObserver().onResponse("a");
    } catch (Throwable t) {
      error = t;
    }

    Truth.assertThat(error).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void testConcurrentRequestAfterClose() throws Exception {
    // Have the outer observer request manual flow control
    GatedMockResponseObserver outerObserver = new GatedMockResponseObserver(false);
    outerObserver.completeBreakpoint.enable();

    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(1));
    MockServerStreamingCallable<String, String> innerCallable = new MockServerStreamingCallable<>();

    innerCallable.call("request", middleware);

    MockServerStreamingCall<String, String> lastCall = innerCallable.popLastCall();
    final MockStreamController<String> innerController = lastCall.getController();

    // Asynchronously start the delivery loop for a completion by notifying the innermost
    // observer, which will bubble up to the outer GatedMockResponseObserver and hit the
    // completeBreakpoint.
    Future<?> completeFuture =
        executor.submit(
            new Runnable() {
              @Override
              public void run() {
                innerController.getObserver().onComplete();
              }
            });

    // Wait until the delivery loop started in the other thread.
    outerObserver.completeBreakpoint.awaitArrival();
    // Concurrently request the next message.
    outerObserver.getController().request(1);
    // Resume the other thread
    outerObserver.completeBreakpoint.release();

    // Should have no errors delivered.
    Truth.assertThat(outerObserver.getFinalError()).isNull();

    // Should have no errors thrown.
    Throwable error = null;
    try {
      completeFuture.get();
    } catch (ExecutionException e) {
      error = e.getCause();
    }
    Truth.assertThat(error).isNull();
  }

  @Test
  public void testOneToOne() throws InterruptedException {
    // Have the outer observer request manual flow control
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(false);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(1));
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a"));

    innerCallable.call("request", middleware);

    // simple path: downstream requests 1 response, the request is proxied to upstream & upstream
    // delivers.
    outerObserver.getController().request(1);

    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a");
    Truth.assertThat(outerObserver.isDone()).isTrue();
  }

  @Test
  public void testOneToOneAuto() throws InterruptedException {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(1));
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a", "b"));
    innerCallable.call("request", middleware);

    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a");
    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("b");
    Truth.assertThat(outerObserver.isDone()).isTrue();
  }

  @Test
  public void testManyToOne() throws InterruptedException {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(false);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(1));
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a-b"));
    innerCallable.call("request", middleware);

    Preconditions.checkState(outerObserver.popNextResponse() == null);

    // First downstream request makes the upstream over produce
    outerObserver.getController().request(1);
    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a");
    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo(null);
    Truth.assertThat(outerObserver.isDone()).isFalse();

    // Next downstream request should fetch from buffer
    outerObserver.getController().request(1);
    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("b");

    // Make sure completion is delivered
    Truth.assertThat(outerObserver.isDone()).isTrue();
  }

  @Test
  public void testManyToOneAuto() throws InterruptedException {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(1));
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a-b"));
    innerCallable.call("request", middleware);

    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a");
    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("b");
    Truth.assertThat(outerObserver.isDone()).isTrue();
  }

  @Test
  public void testManyToOneCancelEarly() throws InterruptedException {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(false);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(1));
    MockServerStreamingCallable<String, String> innerCallable = new MockServerStreamingCallable<>();
    innerCallable.call("request", middleware);

    MockServerStreamingCall<String, String> lastCall = innerCallable.popLastCall();
    MockStreamController<String> innerController = lastCall.getController();

    outerObserver.getController().request(1);
    innerController.getObserver().onResponse("a-b");

    outerObserver.popNextResponse();
    outerObserver.getController().cancel();

    Truth.assertThat(innerController.isCancelled()).isTrue();
    innerController.getObserver().onError(new RuntimeException("Some other upstream error"));

    Truth.assertThat(outerObserver.getFinalError()).isInstanceOf(CancellationException.class);
  }

  @Test
  public void testOneToMany() throws InterruptedException {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(false);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(2));
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a", "b"));
    innerCallable.call("request", middleware);

    Preconditions.checkState(outerObserver.popNextResponse() == null);
    outerObserver.getController().request(1);

    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a-b");
    Truth.assertThat(outerObserver.isDone()).isTrue();
    Truth.assertThat(outerObserver.getFinalError()).isNull();
  }

  @Test
  public void testOneToManyAuto() throws InterruptedException {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(2));
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a", "b"));
    innerCallable.call("request", middleware);

    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a-b");
    Truth.assertThat(outerObserver.isDone()).isTrue();
    Truth.assertThat(outerObserver.getFinalError()).isNull();
  }

  @Test
  public void testOneToManyIncomplete() {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(2));
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a"));
    innerCallable.call("request", middleware);

    // Make sure completion is delivered
    Truth.assertThat(outerObserver.getFinalError()).isInstanceOf(IncompleteStreamException.class);
  }

  @Test
  public void testConcurrentCancel() throws InterruptedException {
    final MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, new DasherizingReframer(2));
    MockServerStreamingCallable<String, String> innerCallable = new MockServerStreamingCallable<>();

    innerCallable.call("request", middleware);
    MockServerStreamingCall<String, String> lastCall = innerCallable.popLastCall();
    final MockStreamController<String> innerController = lastCall.getController();

    final CountDownLatch latch = new CountDownLatch(2);

    executor.submit(
        new Runnable() {
          @Override
          public void run() {
            while (!outerObserver.isDone()) {
              outerObserver.popNextResponse();
            }
            latch.countDown();
          }
        });

    executor.submit(
        new Runnable() {
          @Override
          public void run() {
            while (!innerController.isCancelled()) {
              if (innerController.popLastPull() > 0) {
                innerController.getObserver().onResponse("a");
              }
            }
            innerController
                .getObserver()
                .onError(new RuntimeException("Some other upstream error"));
            latch.countDown();
          }
        });

    outerObserver.getController().cancel();

    Truth.assertThat(latch.await(1, TimeUnit.MINUTES)).isTrue();
  }

  @Test
  public void testReframerPushError() throws Exception {
    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    Reframer<String, String> reframer =
        new DasherizingReframer(1) {
          @Override
          public void push(String response) {
            if ("boom".equals(response)) {
              throw new IllegalStateException("fake error");
            }
            super.push(response);
          }
        };

    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, reframer);
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a", "boom", "c"));

    innerCallable.call("request", middleware);

    Truth.assertThat(outerObserver.getFinalError()).isInstanceOf(IllegalStateException.class);
    Truth.assertThat(outerObserver.getFinalError()).hasMessageThat().isEqualTo("fake error");
    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a");
    Truth.assertThat(outerObserver.popNextResponse()).isNull();
  }

  @Test
  public void testReframerPopError() {
    final AtomicInteger popCount = new AtomicInteger();

    MockResponseObserver<String> outerObserver = new MockResponseObserver<>(true);
    Reframer<String, String> reframer =
        new DasherizingReframer(1) {
          @Override
          public String pop() {
            if (popCount.incrementAndGet() == 2) {
              throw new IllegalStateException("fake error");
            }
            return super.pop();
          }
        };

    ReframingResponseObserver<String, String> middleware =
        new ReframingResponseObserver<>(outerObserver, reframer);
    ServerStreamingStashCallable<String, String> innerCallable =
        new ServerStreamingStashCallable<>(ImmutableList.of("a", "boom", "c"));

    innerCallable.call("request", middleware);
    StreamControllerStash<String> lastCall = innerCallable.popLastCall();

    Truth.assertThat(outerObserver.getFinalError()).isInstanceOf(IllegalStateException.class);
    Truth.assertThat(outerObserver.getFinalError()).hasMessageThat().isEqualTo("fake error");
    Truth.assertThat(outerObserver.popNextResponse()).isEqualTo("a");
    Truth.assertThat(outerObserver.popNextResponse()).isNull();
    Truth.assertThat(popCount.get()).isEqualTo(2);

    Truth.assertThat(lastCall.getError()).isInstanceOf(CancellationException.class);
    Truth.assertThat(lastCall.getNumDelivered()).isEqualTo(2);
  }

  /**
   * A simple implementation of a {@link Reframer}. The input string is split by dash, and the
   * output is concatenated by dashes. The test can verify M:N behavior by adjusting the
   * partsPerResponse parameter and the number of dashes in the input.
   */
  static class DasherizingReframer implements Reframer<String, String> {
    final Queue<String> buffer = Queues.newArrayDeque();
    final int partsPerResponse;

    DasherizingReframer(int partsPerResponse) {
      this.partsPerResponse = partsPerResponse;
    }

    @Override
    public void push(String response) {
      buffer.addAll(Arrays.asList(response.split("-")));
    }

    @Override
    public boolean hasFullFrame() {
      return buffer.size() >= partsPerResponse;
    }

    @Override
    public boolean hasPartialFrame() {
      return !buffer.isEmpty();
    }

    @Override
    public String pop() {
      String[] parts = new String[partsPerResponse];

      for (int i = 0; i < partsPerResponse; i++) {
        parts[i] = buffer.poll();
      }
      return Joiner.on("-").join(parts);
    }
  }

  static class GatedMockResponseObserver extends MockResponseObserver<String> {
    final Breakpoint completeBreakpoint = new Breakpoint();
    final Breakpoint errorBreakpoint = new Breakpoint();

    public GatedMockResponseObserver(boolean autoFlowControl) {
      super(autoFlowControl);
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      super.onErrorImpl(t);
      errorBreakpoint.arrive();
    }

    @Override
    protected void onCompleteImpl() {
      super.onCompleteImpl();
      completeBreakpoint.arrive();
    }
  }

  static class Breakpoint {
    private volatile CountDownLatch arriveLatch = new CountDownLatch(0);
    private volatile CountDownLatch leaveLatch = new CountDownLatch(0);

    public void enable() {
      arriveLatch = new CountDownLatch(1);
      leaveLatch = new CountDownLatch(1);
    }

    public void arrive() {
      arriveLatch.countDown();
      try {
        leaveLatch.await(1, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    void awaitArrival() {
      try {
        arriveLatch.await(1, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    public void release() {
      leaveLatch.countDown();
    }
  }
}

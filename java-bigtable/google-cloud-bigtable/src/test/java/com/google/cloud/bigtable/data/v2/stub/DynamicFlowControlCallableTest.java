/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.DynamicFlowControlSettings;
import com.google.api.gax.batching.FlowControlEventStats;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.common.collect.Lists;
import io.grpc.Status.Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DynamicFlowControlCallableTest {
  @Rule public Timeout timeout = new Timeout(1, TimeUnit.MINUTES);

  private static final int TARGET_LATENCY_MS = 100;
  private static final long ADJUSTING_INTERVAL_MS = TimeUnit.SECONDS.toMillis(20);
  private static final String LATENCY_HEADER = "latency";
  private static final long INITIAL_ELEMENT = 20L;
  private static final long MAX_ELEMENT = 30L;
  private static final long MIN_ELEMENT = 5L;
  private static final int DEADLINE_EXCEEDED_LATENCY = 501;

  private FlowController flowController;
  private FlowControlEventStats flowControlEvents;
  private DynamicFlowControlStats stats;
  private UnaryCallable innerCallable;
  private ApiCallContext context;
  private MutateRowsRequest request;

  private DynamicFlowControlCallable callableToTest;

  @Before
  public void setup() {
    flowController =
        new FlowController(
            DynamicFlowControlSettings.newBuilder()
                .setInitialOutstandingElementCount(INITIAL_ELEMENT)
                .setMaxOutstandingElementCount(MAX_ELEMENT)
                .setMinOutstandingElementCount(MIN_ELEMENT)
                .setInitialOutstandingRequestBytes(15L)
                .setMaxOutstandingRequestBytes(15L)
                .setMinOutstandingRequestBytes(15L)
                .setLimitExceededBehavior(LimitExceededBehavior.Block)
                .build());
    flowControlEvents = flowController.getFlowControlEventStats();
    stats = new DynamicFlowControlStats();
    context = GrpcCallContext.createDefault();
    innerCallable = new MockInnerCallable();
    request =
        MutateRowsRequest.newBuilder()
            .addEntries(MutateRowsRequest.Entry.getDefaultInstance())
            .build();
    callableToTest =
        new DynamicFlowControlCallable(
            innerCallable, flowController, stats, TARGET_LATENCY_MS, ADJUSTING_INTERVAL_MS);
  }

  @Test
  public void testLatenciesAreRecorded() throws Exception {
    Map<String, List<String>> extraHeaders = new HashMap<>();
    extraHeaders.put(LATENCY_HEADER, Arrays.asList("5"));
    ApiCallContext newContext = context.withExtraHeaders(extraHeaders);
    ApiFuture future = callableToTest.futureCall(request, newContext);
    future.get();
    assertThat(stats.getMeanLatency()).isNonZero();
    assertThat(stats.getLastAdjustedTimestampMs()).isEqualTo(0);
  }

  @Test
  public void testTriggeringAdjustingThreshold() throws Exception {
    Map<String, List<String>> extraHeaders = new HashMap<>();
    extraHeaders.put(LATENCY_HEADER, Arrays.asList(String.valueOf(TARGET_LATENCY_MS * 4)));
    long currentTimeMs = System.currentTimeMillis();
    ApiCallContext newContext = context.withExtraHeaders(extraHeaders);
    ApiFuture future = callableToTest.futureCall(request, newContext);
    future.get();
    assertThat(stats.getMeanLatency())
        .isAtLeast(TARGET_LATENCY_MS * DynamicFlowControlCallable.VERY_HIGH_LATENCY_MULTIPLIER);
    assertThat(stats.getLastAdjustedTimestampMs()).isGreaterThan(currentTimeMs);
    long expectedStep =
        Math.round(
            MAX_ELEMENT * DynamicFlowControlCallable.VERY_HIGH_LATENCY_DECREASE_CONCURRENCY_RATE);
    assertThat(flowController.getCurrentElementCountLimit())
        .isEqualTo(INITIAL_ELEMENT - expectedStep);
  }

  @Test
  public void testNoConsecutiveUpdatesToThreshold() throws Exception {
    Map<String, List<String>> extraHeaders = new HashMap<>();
    extraHeaders.put(LATENCY_HEADER, Arrays.asList(String.valueOf(TARGET_LATENCY_MS * 4)));
    long firstRequest = System.currentTimeMillis();
    ApiCallContext newContext = context.withExtraHeaders(extraHeaders);
    ApiFuture future = callableToTest.futureCall(request, newContext);
    future.get();
    long secondRequest = System.currentTimeMillis();
    future = callableToTest.futureCall(request, newContext);
    future.get();
    assertThat(stats.getMeanLatency())
        .isAtLeast(TARGET_LATENCY_MS * DynamicFlowControlCallable.VERY_HIGH_LATENCY_MULTIPLIER);
    assertThat(stats.getLastAdjustedTimestampMs()).isGreaterThan(firstRequest);
    assertThat(stats.getLastAdjustedTimestampMs()).isAtMost(secondRequest);
    long expectedStep =
        Math.round(
            MAX_ELEMENT * DynamicFlowControlCallable.VERY_HIGH_LATENCY_DECREASE_CONCURRENCY_RATE);
    assertThat(flowController.getCurrentElementCountLimit())
        .isEqualTo(INITIAL_ELEMENT - expectedStep);
  }

  @Test
  public void testDecreasingThresholdsCantGoOverLimit() throws Exception {
    // set adjusting intervals to 0 so the thresholds can keep getting updated
    callableToTest =
        new DynamicFlowControlCallable(innerCallable, flowController, stats, TARGET_LATENCY_MS, 0);
    Map<String, List<String>> extraHeaders = new HashMap<>();
    extraHeaders.put(LATENCY_HEADER, Arrays.asList(String.valueOf(TARGET_LATENCY_MS * 4)));
    ApiCallContext newContext = context.withExtraHeaders(extraHeaders);
    List<Future> futures = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      ApiFuture future = callableToTest.futureCall(request, newContext);
      futures.add(future);
    }
    for (Future f : futures) {
      f.get();
    }
    long expectedStep =
        Math.round(
                MAX_ELEMENT
                    * DynamicFlowControlCallable.VERY_HIGH_LATENCY_DECREASE_CONCURRENCY_RATE)
            * 3;
    assertThat(INITIAL_ELEMENT - expectedStep).isLessThan(MIN_ELEMENT);
    assertThat(flowController.getCurrentElementCountLimit()).isEqualTo(MIN_ELEMENT);
  }

  @Test
  public void testIncreasingThreshold() throws Exception {
    // Test when there was flow control events and mean latency is low, increase the thresholds
    callableToTest =
        new DynamicFlowControlCallable(
            innerCallable, flowController, stats, 1000, ADJUSTING_INTERVAL_MS);
    createFlowControlEvent(flowController);
    ApiFuture future = callableToTest.futureCall(request, context);
    future.get();
    long expectedIncrease =
        Math.round(MAX_ELEMENT * DynamicFlowControlCallable.LOW_LATENCY_INCREASE_CONCURRENCY_RATE);
    assertThat(expectedIncrease).isNotEqualTo(0);
    assertThat(INITIAL_ELEMENT + expectedIncrease).isLessThan(MAX_ELEMENT);
    assertThat(flowController.getCurrentElementCountLimit())
        .isEqualTo(INITIAL_ELEMENT + expectedIncrease);
  }

  @Test
  public void testIncreasingThresholdCantGoOverLimit() throws Exception {
    // set adjusting interval to 0 so it can be updated multiple times
    callableToTest = new DynamicFlowControlCallable(innerCallable, flowController, stats, 1000, 0);
    createFlowControlEvent(flowController);
    List<Future> futures = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      ApiFuture future = callableToTest.futureCall(request, context);
      futures.add(future);
    }
    for (Future f : futures) {
      f.get();
    }
    long expectedIncrease =
        Math.round(MAX_ELEMENT * DynamicFlowControlCallable.LOW_LATENCY_INCREASE_CONCURRENCY_RATE)
            * 20;
    assertThat(INITIAL_ELEMENT + expectedIncrease).isGreaterThan(MAX_ELEMENT);
    assertThat(flowController.getCurrentElementCountLimit()).isEqualTo(MAX_ELEMENT);
  }

  @Test
  public void testConcurrentUpdates() throws Exception {
    callableToTest =
        new DynamicFlowControlCallable(
            innerCallable, flowController, stats, 1000, ADJUSTING_INTERVAL_MS);
    createFlowControlEvent(flowController);
    List<Future> futures = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      ApiFuture future = callableToTest.futureCall(request, context);
      futures.add(future);
    }
    for (Future f : futures) {
      f.get();
    }
    // should only be updated once
    long expectedIncrease =
        Math.round(MAX_ELEMENT * DynamicFlowControlCallable.LOW_LATENCY_INCREASE_CONCURRENCY_RATE);
    assertThat(expectedIncrease).isNotEqualTo(0);
    assertThat(INITIAL_ELEMENT + expectedIncrease).isLessThan(MAX_ELEMENT);
    assertThat(flowController.getCurrentElementCountLimit())
        .isEqualTo(INITIAL_ELEMENT + expectedIncrease);
  }

  @Test
  public void testDeadlineExceeded() throws Exception {
    // very high latency with deadline exceeded exception, limits should be decreased
    Map<String, List<String>> extraHeaders = new HashMap<>();
    extraHeaders.put(LATENCY_HEADER, Arrays.asList(String.valueOf(DEADLINE_EXCEEDED_LATENCY)));
    callableToTest.futureCall(request, context.withExtraHeaders(extraHeaders));
    assertThat(flowController.getCurrentElementCountLimit())
        .isEqualTo(
            INITIAL_ELEMENT
                - Math.round(
                    MAX_ELEMENT
                        * DynamicFlowControlCallable.VERY_HIGH_LATENCY_DECREASE_CONCURRENCY_RATE));
  }

  static class MockInnerCallable
      extends UnaryCallable<MutateRowsRequest, List<MutateRowsResponse>> {
    List<MutateRowsResponse> response = Lists.newArrayList();

    @Override
    public ApiFuture<List<MutateRowsResponse>> futureCall(
        MutateRowsRequest request, ApiCallContext context) {
      List<String> latencyHeader = context.getExtraHeaders().get(LATENCY_HEADER);
      if (latencyHeader != null) {
        try {
          Thread.sleep(Integer.valueOf(latencyHeader.get(0)));
        } catch (InterruptedException e) {
        }
        if (Integer.valueOf(latencyHeader.get(0)) == DEADLINE_EXCEEDED_LATENCY) {
          return ApiFutures.immediateFailedFuture(
              new DeadlineExceededException(
                  "deadline exceeded", null, GrpcStatusCode.of(Code.DEADLINE_EXCEEDED), false));
        }
      }
      return ApiFutures.immediateFuture(response);
    }
  }

  private void createFlowControlEvent(final FlowController flowController) throws Exception {
    flowController.reserve(INITIAL_ELEMENT, 0);
    final AtomicBoolean threadStarted = new AtomicBoolean(false);
    Thread t =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  threadStarted.set(true);
                  flowController.reserve(1, 0);
                } catch (Exception e) {
                }
              }
            });
    t.start();
    // Wait 5 seconds for the thread to start, and 50 milliseconds after it's started to make sure
    // flowController.reserve(1, 0) is blocked and creates a throttling event. It should never take
    // so long.
    for (int i = 0; i < 1000; i++) {
      if (threadStarted.get()) {
        break;
      }
      Thread.sleep(5);
    }
    Thread.sleep(50);
    flowController.release(INITIAL_ELEMENT, 0);
    t.join();
    flowController.release(1, 0);

    assertThat(flowController.getFlowControlEventStats().getLastFlowControlEvent()).isNotNull();
  }
}

/*
 * Copyright 2017 Google LLC
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

import static com.google.api.gax.rpc.testing.FakeBatchableApi.SQUARER_BATCHING_DESC;
import static com.google.api.gax.rpc.testing.FakeBatchableApi.callLabeledIntSquarer;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.batching.TrackedFlowController;
import com.google.api.gax.rpc.testing.FakeBatchableApi.LabeledIntList;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeCallableFactory;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.common.truth.Truth;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BatchingTest {

  private ScheduledExecutorService batchingExecutor;
  private ClientContext clientContext;

  @BeforeEach
  void setUp() {
    batchingExecutor = new ScheduledThreadPoolExecutor(1);
    clientContext =
        ClientContext.newBuilder()
            .setExecutor(batchingExecutor)
            .setDefaultCallContext(FakeCallContext.createDefault())
            .setTransportChannel(FakeTransportChannel.create(new FakeChannel()))
            .build();
  }

  @AfterEach
  void teardown() {
    batchingExecutor.shutdownNow();
  }

  @Test
  void batching() throws Exception {
    BatchingSettings batchingSettings =
        BatchingSettings.newBuilder()
            .setDelayThresholdDuration(java.time.Duration.ofSeconds(1))
            .setElementCountThreshold(2L)
            .build();
    BatchingCallSettings<LabeledIntList, List<Integer>> batchingCallSettings =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC)
            .setBatchingSettings(batchingSettings)
            .build();
    UnaryCallable<LabeledIntList, List<Integer>> callable =
        FakeCallableFactory.createBatchingCallable(
            callLabeledIntSquarer, batchingCallSettings, clientContext);
    ApiFuture<List<Integer>> f1 = callable.futureCall(new LabeledIntList("one", 1, 2));
    ApiFuture<List<Integer>> f2 = callable.futureCall(new LabeledIntList("one", 3, 4));
    Truth.assertThat(f1.get()).isEqualTo(Arrays.asList(1, 4));
    Truth.assertThat(f2.get()).isEqualTo(Arrays.asList(9, 16));
  }

  @Test
  void batchingWithFlowControl() throws Exception {
    BatchingSettings batchingSettings =
        BatchingSettings.newBuilder()
            .setDelayThresholdDuration(java.time.Duration.ofSeconds(1))
            .setElementCountThreshold(4L)
            .setRequestByteThreshold(null)
            .setFlowControlSettings(
                FlowControlSettings.newBuilder()
                    .setLimitExceededBehavior(LimitExceededBehavior.Block)
                    .setMaxOutstandingElementCount(10L)
                    .setMaxOutstandingRequestBytes(10L)
                    .build())
            .build();
    TrackedFlowController trackedFlowController =
        new TrackedFlowController(batchingSettings.getFlowControlSettings());

    Truth.assertThat(trackedFlowController.getElementsReserved()).isEqualTo(0);
    Truth.assertThat(trackedFlowController.getElementsReleased()).isEqualTo(0);
    Truth.assertThat(trackedFlowController.getBytesReserved()).isEqualTo(0);
    Truth.assertThat(trackedFlowController.getBytesReleased()).isEqualTo(0);
    Truth.assertThat(trackedFlowController.getCallsToReserve()).isEqualTo(0);
    Truth.assertThat(trackedFlowController.getCallsToRelease()).isEqualTo(0);

    LabeledIntList requestA = new LabeledIntList("one", 1, 2);
    LabeledIntList requestB = new LabeledIntList("one", 3, 4);

    BatchingCallSettings<LabeledIntList, List<Integer>> batchingCallSettings =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC)
            .setBatchingSettings(batchingSettings)
            .setFlowController(trackedFlowController)
            .build();
    Callables.BatchingCreateResult<LabeledIntList, List<Integer>> batchingCreateResult =
        Callables.batchingImpl(callLabeledIntSquarer, batchingCallSettings, clientContext);
    ApiFuture<List<Integer>> f1 =
        batchingCreateResult
            .getUnaryCallable()
            .futureCall(requestA, FakeCallContext.createDefault());
    ApiFuture<List<Integer>> f2 =
        batchingCreateResult
            .getUnaryCallable()
            .futureCall(requestB, FakeCallContext.createDefault());
    Truth.assertThat(f1.get()).isEqualTo(Arrays.asList(1, 4));
    Truth.assertThat(f2.get()).isEqualTo(Arrays.asList(9, 16));

    batchingCreateResult
        .getBatcherFactory()
        .getPushingBatcher(SQUARER_BATCHING_DESC.getBatchPartitionKey(requestA))
        .pushCurrentBatch()
        .get();

    // Check that the number of bytes is correct even when requests are merged, and the merged
    // request consumes fewer bytes.
    Truth.assertThat(trackedFlowController.getElementsReserved()).isEqualTo(4);
    Truth.assertThat(trackedFlowController.getElementsReleased()).isEqualTo(4);
    Truth.assertThat(trackedFlowController.getBytesReserved()).isEqualTo(8);
    Truth.assertThat(trackedFlowController.getBytesReleased()).isEqualTo(8);
    Truth.assertThat(trackedFlowController.getCallsToReserve()).isEqualTo(2);
    Truth.assertThat(trackedFlowController.getCallsToRelease()).isEqualTo(1);
  }

  @Test
  void batchingDisabled() throws Exception {
    BatchingSettings batchingSettings = BatchingSettings.newBuilder().setIsEnabled(false).build();

    BatchingCallSettings<LabeledIntList, List<Integer>> batchingCallSettings =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC)
            .setBatchingSettings(batchingSettings)
            .build();
    UnaryCallable<LabeledIntList, List<Integer>> callable =
        FakeCallableFactory.createBatchingCallable(
            callLabeledIntSquarer, batchingCallSettings, clientContext);
    ApiFuture<List<Integer>> f1 = callable.futureCall(new LabeledIntList("one", 1, 2));
    ApiFuture<List<Integer>> f2 = callable.futureCall(new LabeledIntList("one", 3, 4));
    Truth.assertThat(f1.get()).isEqualTo(Arrays.asList(1, 4));
    Truth.assertThat(f2.get()).isEqualTo(Arrays.asList(9, 16));
  }

  @Test
  void batchingWithBlockingCallThreshold() throws Exception {
    BatchingSettings batchingSettings =
        BatchingSettings.newBuilder()
            .setDelayThresholdDuration(java.time.Duration.ofSeconds(1))
            .setElementCountThreshold(2L)
            .build();
    BatchingCallSettings<LabeledIntList, List<Integer>> batchingCallSettings =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC)
            .setBatchingSettings(batchingSettings)
            .build();
    UnaryCallable<LabeledIntList, List<Integer>> callable =
        FakeCallableFactory.createBatchingCallable(
            callLabeledIntSquarer, batchingCallSettings, clientContext);
    ApiFuture<List<Integer>> f1 = callable.futureCall(new LabeledIntList("one", 1));
    ApiFuture<List<Integer>> f2 = callable.futureCall(new LabeledIntList("one", 3));
    Truth.assertThat(f1.get()).isEqualTo(Arrays.asList(1));
    Truth.assertThat(f2.get()).isEqualTo(Arrays.asList(9));
  }

  private static UnaryCallable<LabeledIntList, List<Integer>> callLabeledIntExceptionThrower =
      new UnaryCallable<LabeledIntList, List<Integer>>() {
        @Override
        public ApiFuture<List<Integer>> futureCall(LabeledIntList request, ApiCallContext context) {
          return RetryingTest.<List<Integer>>immediateFailedFuture(
              new IllegalArgumentException("I FAIL!!"));
        }
      };

  @Test
  void batchingException() throws Exception {
    BatchingSettings batchingSettings =
        BatchingSettings.newBuilder()
            .setDelayThresholdDuration(java.time.Duration.ofSeconds(1))
            .setElementCountThreshold(2L)
            .build();
    BatchingCallSettings<LabeledIntList, List<Integer>> batchingCallSettings =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC)
            .setBatchingSettings(batchingSettings)
            .build();
    UnaryCallable<LabeledIntList, List<Integer>> callable =
        FakeCallableFactory.createBatchingCallable(
            callLabeledIntExceptionThrower, batchingCallSettings, clientContext);
    ApiFuture<List<Integer>> f1 = callable.futureCall(new LabeledIntList("one", 1, 2));
    ApiFuture<List<Integer>> f2 = callable.futureCall(new LabeledIntList("one", 3, 4));
    assertThrows(ExecutionException.class, f1::get);
    assertThrows(ExecutionException.class, f2::get);
  }
}

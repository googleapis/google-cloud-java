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

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.rpc.testing.FakeBatchableApi;
import com.google.api.gax.rpc.testing.FakeBatchableApi.LabeledIntList;
import com.google.api.gax.rpc.testing.FakeBatchableApi.SquarerBatchingDescriptor;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.common.truth.Truth;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BatchingCallableTest {
  private ScheduledExecutorService batchingExecutor;

  @BeforeEach
  void setUp() {
    batchingExecutor = new ScheduledThreadPoolExecutor(2);
  }

  @AfterEach
  void tearDown() {
    batchingExecutor.shutdownNow();
  }

  @Test
  void testBatchedCall() throws Exception {

    BatchingSettings batchingSettings =
        BatchingSettings.newBuilder()
            .setDelayThresholdDuration(java.time.Duration.ofSeconds(10))
            .setElementCountThreshold(2L)
            .setRequestByteThreshold(1000L)
            .build();
    FlowControlSettings flowControlSettings =
        FlowControlSettings.newBuilder()
            .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
            .build();
    FlowController flowController = new FlowController(flowControlSettings);
    BatcherFactory<LabeledIntList, List<Integer>> batcherFactory =
        new BatcherFactory<>(
            new SquarerBatchingDescriptor(), batchingSettings, batchingExecutor, flowController);

    BatchingCallable<LabeledIntList, List<Integer>> batchingCallable =
        new BatchingCallable<>(
            FakeBatchableApi.callLabeledIntSquarer,
            FakeBatchableApi.SQUARER_BATCHING_DESC,
            batcherFactory);

    LabeledIntList request1 = new LabeledIntList("label", 2);
    ApiFuture<List<Integer>> future1 =
        batchingCallable.futureCall(request1, FakeCallContext.createDefault());
    // Assume it won't take 10 seconds (the batching delay threshold) to check the first future
    Truth.assertThat(future1.isDone()).isFalse();

    LabeledIntList request2 = new LabeledIntList("label", 3);
    ApiFuture<List<Integer>> future2 =
        batchingCallable.futureCall(request2, FakeCallContext.createDefault());

    List<Integer> response1 = future1.get();
    List<Integer> response2 = future2.get();

    Truth.assertThat(response1.size()).isEqualTo(1);
    Truth.assertThat(response1.get(0)).isEqualTo(2 * 2);

    Truth.assertThat(response2.size()).isEqualTo(1);
    Truth.assertThat(response2.get(0)).isEqualTo(3 * 3);
  }

  @Test
  void testUnbatchedCall() throws Exception {

    BatchingSettings batchingSettings = BatchingSettings.newBuilder().setIsEnabled(false).build();
    FlowControlSettings flowControlSettings =
        FlowControlSettings.newBuilder()
            .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
            .build();
    FlowController flowController = new FlowController(flowControlSettings);
    BatcherFactory<LabeledIntList, List<Integer>> batcherFactory =
        new BatcherFactory<>(
            new SquarerBatchingDescriptor(), batchingSettings, batchingExecutor, flowController);

    BatchingCallable<LabeledIntList, List<Integer>> batchingCallable =
        new BatchingCallable<>(
            FakeBatchableApi.callLabeledIntSquarer,
            FakeBatchableApi.SQUARER_BATCHING_DESC,
            batcherFactory);

    LabeledIntList request1 = new LabeledIntList("label", 2);
    ApiFuture<List<Integer>> future1 =
        batchingCallable.futureCall(request1, FakeCallContext.createDefault());
    List<Integer> response1 = future1.get();

    Truth.assertThat(response1.size()).isEqualTo(1);
    Truth.assertThat(response1.get(0)).isEqualTo(2 * 2);
  }
}

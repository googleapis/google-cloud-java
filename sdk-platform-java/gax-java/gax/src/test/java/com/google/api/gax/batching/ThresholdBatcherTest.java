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
package com.google.api.gax.batching;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.common.collect.ImmutableList;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.Test;

class ThresholdBatcherTest {

  private static final ScheduledExecutorService EXECUTOR = new ScheduledThreadPoolExecutor(1);

  private static FlowController getDisabledFlowController() {
    return new FlowController(
        FlowControlSettings.newBuilder()
            .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
            .build());
  }

  private static <T> BatchingFlowController<T> getDisabledBatchingFlowController() {
    return new BatchingFlowController<>(
        getDisabledFlowController(),
        new ElementCounter<T>() {
          @Override
          public long count(T t) {
            return 1;
          }
        },
        new ElementCounter<T>() {
          @Override
          public long count(T t) {
            return 1;
          }
        });
  }

  private static TrackedFlowController trackedFlowController;

  private static BatchingFlowController<SimpleBatch> getTrackedIntegerBatchingFlowController(
      Long elementCount, Long byteCount, LimitExceededBehavior limitExceededBehaviour) {
    trackedFlowController =
        new TrackedFlowController(
            FlowControlSettings.newBuilder()
                .setMaxOutstandingElementCount(elementCount)
                .setMaxOutstandingRequestBytes(byteCount)
                .setLimitExceededBehavior(limitExceededBehaviour)
                .build());
    return new BatchingFlowController<>(
        trackedFlowController,
        new ElementCounter<SimpleBatch>() {
          @Override
          public long count(SimpleBatch t) {
            return t.getIntegers().size();
          }
        },
        new ElementCounter<SimpleBatch>() {
          @Override
          public long count(SimpleBatch t) {
            long counter = 0;
            for (Integer i : t.integers) {
              counter += i;
            }
            return counter;
          }
        });
  }

  private static class SimpleBatch {

    private final List<Integer> integers = new ArrayList<>();

    private static SimpleBatch fromInteger(Integer integer) {
      SimpleBatch batch = new SimpleBatch();
      batch.integers.add(integer);
      return batch;
    }

    void merge(SimpleBatch t) {
      integers.addAll(t.integers);
    }

    private List<Integer> getIntegers() {
      return integers;
    }
  }

  private static class SimpleBatchMerger implements BatchMerger<SimpleBatch> {

    @Override
    public void merge(SimpleBatch batch, SimpleBatch newBatch) {
      batch.merge(newBatch);
    }
  }

  private static ThresholdBatcher.Builder<SimpleBatch> createSimpleBatcherBuidler(
      AccumulatingBatchReceiver<SimpleBatch> receiver) {
    return ThresholdBatcher.<SimpleBatch>newBuilder()
        .setThresholds(BatchingThresholds.<SimpleBatch>create(100))
        .setExecutor(EXECUTOR)
        .setMaxDelayDuration(java.time.Duration.ofMillis(10000))
        .setReceiver(receiver)
        .setFlowController(ThresholdBatcherTest.<SimpleBatch>getDisabledBatchingFlowController())
        .setBatchMerger(new SimpleBatchMerger());
  }

  private static SimpleEntry<ThresholdBatcher.Builder, ScheduledExecutorService>
      createSimpleBatcherBuilderWithMockExecutor(long customThreshold) {
    AccumulatingBatchReceiver<SimpleBatch> receiver =
        new AccumulatingBatchReceiver<>(ApiFutures.<Void>immediateFuture(null));
    ScheduledExecutorService executor = mock(ScheduledThreadPoolExecutor.class);
    when(executor.schedule((Runnable) any(), anyLong(), any()))
        .thenReturn(mock(ScheduledFuture.class));
    BatchingThreshold<SimpleBatch> threshold = new NumericThreshold<>(customThreshold, e -> 1);

    ThresholdBatcher.Builder builder =
        createSimpleBatcherBuidler(receiver)
            .setExecutor(executor)
            .setThresholds(ImmutableList.of(threshold));
    return new SimpleEntry<>(builder, executor);
  }

  @Test
  void testAdd() throws Exception {
    AccumulatingBatchReceiver<SimpleBatch> receiver =
        new AccumulatingBatchReceiver<>(ApiFutures.<Void>immediateFuture(null));
    ThresholdBatcher<SimpleBatch> batcher = createSimpleBatcherBuidler(receiver).build();
    batcher.add(SimpleBatch.fromInteger(14));
    assertThat(batcher.isEmpty()).isFalse();
    assertThat(receiver.getBatches()).hasSize(0);

    batcher.pushCurrentBatch().get();
    assertThat(batcher.isEmpty()).isTrue();
    assertThat(receiver.getBatches()).hasSize(1);
    assertThat(receiver.getBatches().get(0).getIntegers()).isEqualTo(Arrays.asList(14));
  }

  @Test
  void testBatching() throws Exception {
    AccumulatingBatchReceiver<SimpleBatch> receiver =
        new AccumulatingBatchReceiver<>(ApiFutures.<Void>immediateFuture(null));
    ThresholdBatcher<SimpleBatch> batcher =
        createSimpleBatcherBuidler(receiver)
            .setThresholds(BatchingThresholds.<SimpleBatch>create(2))
            .build();

    batcher.add(SimpleBatch.fromInteger(3));
    batcher.add(SimpleBatch.fromInteger(5));
    // Give time for the executor to push the batch
    Thread.sleep(100);
    assertThat(receiver.getBatches()).hasSize(1);

    batcher.add(SimpleBatch.fromInteger(7));
    batcher.add(SimpleBatch.fromInteger(9));
    // Give time for the executor to push the batch
    Thread.sleep(100);
    assertThat(receiver.getBatches()).hasSize(2);

    batcher.add(SimpleBatch.fromInteger(11));

    batcher.pushCurrentBatch().get();

    List<List<Integer>> expected =
        Arrays.asList(Arrays.asList(3, 5), Arrays.asList(7, 9), Arrays.asList(11));
    List<List<Integer>> actual = new ArrayList<>();
    for (SimpleBatch batch : receiver.getBatches()) {
      actual.add(batch.getIntegers());
    }
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testBatchingWithDelay() throws Exception {
    AccumulatingBatchReceiver<SimpleBatch> receiver =
        new AccumulatingBatchReceiver<>(ApiFutures.<Void>immediateFuture(null));
    ThresholdBatcher<SimpleBatch> batcher =
        createSimpleBatcherBuidler(receiver)
            .setMaxDelayDuration(java.time.Duration.ofMillis(100))
            .build();

    batcher.add(SimpleBatch.fromInteger(3));
    batcher.add(SimpleBatch.fromInteger(5));
    // Give time for the delay to trigger and push the batch
    Thread.sleep(500);
    assertThat(receiver.getBatches()).hasSize(1);

    batcher.add(SimpleBatch.fromInteger(11));

    batcher.pushCurrentBatch().get();

    List<List<Integer>> expected = Arrays.asList(Arrays.asList(3, 5), Arrays.asList(11));
    List<List<Integer>> actual = new ArrayList<>();
    for (SimpleBatch batch : receiver.getBatches()) {
      actual.add(batch.getIntegers());
    }
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testExceptionWithNullFlowController() {
    assertThrows(
        NullPointerException.class,
        () ->
            ThresholdBatcher.<SimpleBatch>newBuilder()
                .setThresholds(BatchingThresholds.<SimpleBatch>create(100))
                .setExecutor(EXECUTOR)
                .setMaxDelayDuration(java.time.Duration.ofMillis(10000))
                .setReceiver(
                    new AccumulatingBatchReceiver<SimpleBatch>(
                        ApiFutures.<Void>immediateFuture(null)))
                .setBatchMerger(new SimpleBatchMerger())
                .build());
  }

  @Test
  void testBatchingWithFlowControl() throws Exception {
    AccumulatingBatchReceiver<SimpleBatch> receiver =
        new AccumulatingBatchReceiver<>(ApiFutures.<Void>immediateFuture(null));
    ThresholdBatcher<SimpleBatch> batcher =
        createSimpleBatcherBuidler(receiver)
            .setThresholds(BatchingThresholds.<SimpleBatch>create(2))
            .setFlowController(
                getTrackedIntegerBatchingFlowController(2L, null, LimitExceededBehavior.Block))
            .build();

    assertThat(trackedFlowController.getElementsReserved()).isEqualTo(0);
    assertThat(trackedFlowController.getElementsReleased()).isEqualTo(0);
    assertThat(trackedFlowController.getBytesReserved()).isEqualTo(0);
    assertThat(trackedFlowController.getBytesReleased()).isEqualTo(0);

    batcher.add(SimpleBatch.fromInteger(3));
    batcher.add(SimpleBatch.fromInteger(5));
    batcher.add(
        SimpleBatch.fromInteger(7)); // We expect to block here until the first batch is handled
    assertThat(receiver.getBatches()).hasSize(1);
    batcher.add(SimpleBatch.fromInteger(9));
    batcher.add(
        SimpleBatch.fromInteger(11)); // We expect to block here until the second batch is handled
    assertThat(receiver.getBatches()).hasSize(2);

    batcher.pushCurrentBatch().get();

    List<List<Integer>> expected =
        Arrays.asList(Arrays.asList(3, 5), Arrays.asList(7, 9), Arrays.asList(11));
    List<List<Integer>> actual = new ArrayList<>();
    for (SimpleBatch batch : receiver.getBatches()) {
      actual.add(batch.getIntegers());
    }
    assertThat(actual).isEqualTo(expected);

    assertThat(trackedFlowController.getElementsReserved())
        .isEqualTo(trackedFlowController.getElementsReleased());
    assertThat(trackedFlowController.getBytesReserved())
        .isEqualTo(trackedFlowController.getBytesReleased());
  }

  @Test
  void testBatchingFlowControlExceptionRecovery() throws Exception {
    AccumulatingBatchReceiver<SimpleBatch> receiver =
        new AccumulatingBatchReceiver<>(ApiFutures.<Void>immediateFuture(null));
    ThresholdBatcher<SimpleBatch> batcher =
        createSimpleBatcherBuidler(receiver)
            .setThresholds(BatchingThresholds.<SimpleBatch>create(4))
            .setFlowController(
                getTrackedIntegerBatchingFlowController(
                    3L, null, LimitExceededBehavior.ThrowException))
            .build();

    assertThat(trackedFlowController.getElementsReserved()).isEqualTo(0);
    assertThat(trackedFlowController.getElementsReleased()).isEqualTo(0);
    assertThat(trackedFlowController.getBytesReserved()).isEqualTo(0);
    assertThat(trackedFlowController.getBytesReleased()).isEqualTo(0);

    batcher.add(SimpleBatch.fromInteger(3));
    batcher.add(SimpleBatch.fromInteger(5));
    batcher.add(SimpleBatch.fromInteger(7));

    assertThrows(FlowControlException.class, () -> batcher.add(SimpleBatch.fromInteger(9)));

    batcher.pushCurrentBatch().get();
    assertThat(receiver.getBatches()).hasSize(1);
    batcher.add(SimpleBatch.fromInteger(11));
    batcher.add(SimpleBatch.fromInteger(13));
    batcher.pushCurrentBatch().get();

    List<List<Integer>> expected = Arrays.asList(Arrays.asList(3, 5, 7), Arrays.asList(11, 13));
    List<List<Integer>> actual = new ArrayList<>();
    for (SimpleBatch batch : receiver.getBatches()) {
      actual.add(batch.getIntegers());
    }
    assertThat(actual).isEqualTo(expected);

    assertThat(trackedFlowController.getElementsReserved())
        .isEqualTo(trackedFlowController.getElementsReleased());
    assertThat(trackedFlowController.getBytesReserved())
        .isEqualTo(trackedFlowController.getBytesReleased());
  }

  @Test
  void testBatchingFailedRPC() throws Exception {
    Exception ex = new IllegalStateException("does nothing, unsuccessfully");
    AccumulatingBatchReceiver<SimpleBatch> receiver =
        new AccumulatingBatchReceiver<>(ApiFutures.<Void>immediateFailedFuture(ex));
    ThresholdBatcher<SimpleBatch> batcher =
        createSimpleBatcherBuidler(receiver)
            .setThresholds(BatchingThresholds.<SimpleBatch>create(4))
            .setFlowController(
                getTrackedIntegerBatchingFlowController(
                    3L, null, LimitExceededBehavior.ThrowException))
            .build();

    assertThat(trackedFlowController.getElementsReserved()).isEqualTo(0);
    assertThat(trackedFlowController.getElementsReleased()).isEqualTo(0);
    assertThat(trackedFlowController.getBytesReserved()).isEqualTo(0);
    assertThat(trackedFlowController.getBytesReleased()).isEqualTo(0);

    batcher.add(SimpleBatch.fromInteger(3));

    ExecutionException actualException =
        assertThrows(ExecutionException.class, () -> batcher.pushCurrentBatch().get());
    assertEquals(actualException.getCause(), ex);

    assertThat(receiver.getBatches()).hasSize(1);

    List<List<Integer>> expected = Arrays.asList(Arrays.asList(3));
    List<List<Integer>> actual = new ArrayList<>();
    for (SimpleBatch batch : receiver.getBatches()) {
      actual.add(batch.getIntegers());
    }
    assertThat(actual).isEqualTo(expected);

    assertThat(trackedFlowController.getElementsReserved())
        .isEqualTo(trackedFlowController.getElementsReleased());
    assertThat(trackedFlowController.getBytesReserved())
        .isEqualTo(trackedFlowController.getBytesReleased());
  }

  @Test
  public void testMaxDelay() throws FlowControlException {

    final long MILLIS = 123l;
    final SimpleBatch TEST_BATCH = SimpleBatch.fromInteger(1);
    java.time.Duration javaTimeDuration = java.time.Duration.ofMillis(MILLIS);
    org.threeten.bp.Duration threetenDuration = org.threeten.bp.Duration.ofMillis(MILLIS);

    SimpleEntry<ThresholdBatcher.Builder, ScheduledExecutorService> container =
        createSimpleBatcherBuilderWithMockExecutor(1000l);
    ThresholdBatcher.Builder builder = container.getKey();
    ScheduledExecutorService executor = container.getValue();

    builder.setMaxDelayDuration(javaTimeDuration).build().add(TEST_BATCH);
    verify(executor, times(1)).schedule((Runnable) any(), eq(MILLIS), any());

    container = createSimpleBatcherBuilderWithMockExecutor(1000l);
    builder = container.getKey();
    executor = container.getValue();

    builder.setMaxDelay(threetenDuration).build().add(TEST_BATCH);
    verify(executor, times(1)).schedule((Runnable) any(), eq(MILLIS), any());
  }
}

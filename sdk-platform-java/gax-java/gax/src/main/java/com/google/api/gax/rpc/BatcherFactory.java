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

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchingFlowController;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.BatchingThreshold;
import com.google.api.gax.batching.ElementCounter;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.NumericThreshold;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.ThresholdBatcher;
import com.google.api.gax.rpc.Batch.BatchByteCounter;
import com.google.api.gax.rpc.Batch.BatchElementCounter;
import com.google.api.gax.rpc.Batch.BatchMergerImpl;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

/**
 * A Factory class which, for each unique partitionKey, creates a trio including a ThresholdBatcher,
 * BatchExecutor, and ThresholdBatchingForwarder. The ThresholdBatchingForwarder pulls items from
 * the ThresholdBatcher and forwards them to the BatchExecutor for processing.
 *
 * <p>This is public only for technical reasons, for advanced usage.
 */
@InternalApi
public final class BatcherFactory<RequestT, ResponseT> {
  private final Map<PartitionKey, ThresholdBatcher<Batch<RequestT, ResponseT>>> batchers =
      new ConcurrentHashMap<>();
  private final ScheduledExecutorService executor;
  private final BatchingDescriptor<RequestT, ResponseT> batchingDescriptor;
  private final FlowController flowController;
  private final BatchingSettings batchingSettings;
  private final Object lock = new Object();

  public BatcherFactory(
      BatchingDescriptor<RequestT, ResponseT> batchingDescriptor,
      BatchingSettings batchingSettings,
      ScheduledExecutorService executor,
      FlowController flowController) {
    this.batchingDescriptor = batchingDescriptor;
    this.batchingSettings = batchingSettings;
    this.executor = executor;
    this.flowController = flowController;
  }

  /**
   * Provides the ThresholdBatcher corresponding to the given partitionKey, or constructs one if it
   * doesn't exist yet. The implementation is thread-safe.
   */
  public ThresholdBatcher<Batch<RequestT, ResponseT>> getPushingBatcher(PartitionKey partitionKey) {
    ThresholdBatcher<Batch<RequestT, ResponseT>> batcher = batchers.get(partitionKey);
    if (batcher == null) {
      synchronized (lock) {
        batcher = batchers.get(partitionKey);
        if (batcher == null) {
          batcher = createBatcher(partitionKey);
          batchers.put(partitionKey, batcher);
        }
      }
    }
    return batcher;
  }

  /**
   * Returns the BatchingSettings object that is associated with this factory.
   *
   * <p>This is public only for technical reasons, for advanced usage.
   */
  @InternalApi
  public BatchingSettings getBatchingSettings() {
    return batchingSettings;
  }

  private ThresholdBatcher<Batch<RequestT, ResponseT>> createBatcher(PartitionKey partitionKey) {
    BatchExecutor<RequestT, ResponseT> processor =
        new BatchExecutor<>(batchingDescriptor, partitionKey);
    BatchingFlowController<Batch<RequestT, ResponseT>> batchingFlowController =
        new BatchingFlowController<>(
            flowController,
            new BatchElementCounter<>(batchingDescriptor),
            new BatchByteCounter<RequestT, ResponseT>());
    return ThresholdBatcher.<Batch<RequestT, ResponseT>>newBuilder()
        .setThresholds(getThresholds(batchingSettings))
        .setExecutor(executor)
        .setMaxDelayDuration(batchingSettings.getDelayThresholdDuration())
        .setReceiver(processor)
        .setFlowController(batchingFlowController)
        .setBatchMerger(new BatchMergerImpl<RequestT, ResponseT>())
        .build();
  }

  private ImmutableList<BatchingThreshold<Batch<RequestT, ResponseT>>> getThresholds(
      BatchingSettings batchingSettings) {
    ImmutableList.Builder<BatchingThreshold<Batch<RequestT, ResponseT>>> listBuilder =
        ImmutableList.builder();

    if (batchingSettings.getElementCountThreshold() != null) {
      ElementCounter<Batch<RequestT, ResponseT>> elementCounter =
          new BatchElementCounter<>(batchingDescriptor);

      BatchingThreshold<Batch<RequestT, ResponseT>> countThreshold =
          new NumericThreshold<>(batchingSettings.getElementCountThreshold(), elementCounter);
      listBuilder.add(countThreshold);
    }

    if (batchingSettings.getRequestByteThreshold() != null) {
      ElementCounter<Batch<RequestT, ResponseT>> requestByteCounter =
          new BatchByteCounter<RequestT, ResponseT>();

      BatchingThreshold<Batch<RequestT, ResponseT>> byteThreshold =
          new NumericThreshold<>(batchingSettings.getRequestByteThreshold(), requestByteCounter);
      listBuilder.add(byteThreshold);
    }

    return listBuilder.build();
  }
}

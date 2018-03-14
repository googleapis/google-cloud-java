/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.logging;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.FlowController;
import com.google.cloud.batchingexperimental.RequestAccumulator;
import com.google.common.base.Preconditions;
import com.google.logging.v2.WriteLogEntriesRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class BatchingWriter {

  interface Rpc {
    ApiFuture<Void> call(WriteLogEntriesRequest request);
  }

  private final Rpc rpc;
  private final FlowController flowController;
  private final RequestAccumulator<com.google.logging.v2.LogEntry, Void> accumulator;
  private final WriteLogEntriesRequest requestPrototype;
  private final ScheduledThreadPoolExecutor executor;

  // Use Boolean, since concurrent maps don't support nulls.
  private final ConcurrentHashMap<ApiFuture<Void>, Boolean> pendingWrites =
      new ConcurrentHashMap<>();

  private Future<?> flushJob = null;

  BatchingWriter(
      Rpc rpc,
      int batchCount,
      long batchSize,
      FlowController flowController,
      WriteLogEntriesRequest requestPrototype,
      ScheduledThreadPoolExecutor executor) {
    this.flowController = Preconditions.checkNotNull(flowController);
    this.rpc = Preconditions.checkNotNull(rpc);
    this.requestPrototype = Preconditions.checkNotNull(requestPrototype);
    this.executor = Preconditions.checkNotNull(executor);
    this.accumulator = new RequestAccumulator<>(batchCount, batchSize);
  }

  synchronized void startJob() {
    Preconditions.checkArgument(flushJob == null, "job already started");
    flushJob =
        executor.scheduleWithFixedDelay(
            new Runnable() {
              @Override
              public void run() {
                initFlush();
              }
            },
            100,
            100,
            TimeUnit.MILLISECONDS);
  }

  synchronized void stopJob() {
    Preconditions.checkArgument(flushJob != null, "job not started");
    flushJob.cancel(false);
  }

  void add(com.google.logging.v2.LogEntry entry) throws FlowController.FlowControlException {
    long entrySize = entry.getSerializedSize();

    flowController.reserve(1, entrySize);
    synchronized (accumulator) {
      accumulator.add(entry, entrySize, null);
      while (accumulator.hasBatch()) {
        final WriteLogEntriesRequest request =
            requestPrototype.toBuilder().addAllEntries(accumulator.batch()).build();
        final long size = accumulator.bytes();
        send(request, size);
        // TODO: Whoever calls send serializes the proto; consider doing it off-thread.
        // This gives better CPU utilization if there are few producer threads
        // on a many-core machine.
        //
        // When doing this, make sure to put a future into the map before this method
        // returns so flush works properly.
        accumulator.next();
      }
    }
  }

  void initFlush() {
    WriteLogEntriesRequest request;
    long size;
    synchronized (accumulator) {
      if (accumulator.batch().isEmpty()) {
        return;
      }
      request = requestPrototype.toBuilder().addAllEntries(accumulator.batch()).build();
      size = accumulator.bytes();
      accumulator.next();
    }
    send(request, size);
  }

  private void send(WriteLogEntriesRequest request, final long size) {
    final int count = request.getEntriesCount();

    final ApiFuture<Void> writeFuture = rpc.call(request);
    pendingWrites.put(writeFuture, Boolean.TRUE);
    ApiFutures.addCallback(
        writeFuture,
        new ApiFutureCallback<Void>() {
          private void onBoth() {
            pendingWrites.remove(writeFuture);
            flowController.release(count, size);
          }

          @Override
          public void onSuccess(Void v) {
            onBoth();
          }

          @Override
          public void onFailure(Throwable t) {
            // Report failure.
            onBoth();
          }
        });
  }

  List<ApiFuture<Void>> pendingRpcs() {
    return new ArrayList<>(pendingWrites.keySet());
  }
}

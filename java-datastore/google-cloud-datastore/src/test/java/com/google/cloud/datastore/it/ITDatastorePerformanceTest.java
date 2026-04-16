/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.datastore.it;

import com.google.api.gax.grpc.ChannelPool;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.TransportChannel;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.base.Strings;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class ITDatastorePerformanceTest {

  @Test
  public void testMultiPhasePerformanceAndResizing() throws Exception {
    int[] loadSteps = {100, 500, 1000, 2500};
    long phaseDurationMillis = TimeUnit.MINUTES.toMillis(15);
    
    for (int load : loadSteps) {
      runPhase(load, phaseDurationMillis);
      System.out.println("\n\n" + Strings.repeat("=", 50));
      System.out.println("COMPLETED PHASE WITH " + load + " THREADS");
      System.out.println(Strings.repeat("=", 50) + "\n\n");
    }
  }

  private void runPhase(int threadCount, long durationMillis) throws Exception {
    System.out.println("\n--- STARTING PHASE: " + threadCount + " threads ---");

    DatastoreOptions options = DatastoreOptions.newBuilder()
        .setTransportOptions(GrpcTransportOptions.newBuilder().build())
        .build();

    Datastore datastore = options.getService();
    
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("PerfTestKind");
    Key key = keyFactory.newKey("perf-test-entity");
    datastore.put(com.google.cloud.datastore.Entity.newBuilder(key)
        .set("payload", Strings.repeat("a", 1024))
        .build());

    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    AtomicInteger intervalRequests = new AtomicInteger(0);
    AtomicInteger errorCount = new AtomicInteger(0);
    AtomicInteger activePeak = new AtomicInteger(0);

    Thread peakTracker = new Thread(() -> {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int current = getActualOutstanding(datastore);
                int currentPeak;
                do {
                    currentPeak = activePeak.get();
                    if (current <= currentPeak) break;
                } while (!activePeak.compareAndSet(currentPeak, current));
                Thread.sleep(5);
            }
        } catch (InterruptedException ignored) {}
    });
    peakTracker.setDaemon(true);
    peakTracker.start();

    for (int i = 0; i < threadCount; i++) {
      executor.submit(() -> {
        while (!Thread.currentThread().isInterrupted()) {
          try {
            datastore.get(key);
            intervalRequests.incrementAndGet();
          } catch (Exception e) {
            errorCount.incrementAndGet();
          }
        }
      });
    }

    long startTime = System.currentTimeMillis();
    try {
      int minute = 1;
      while (System.currentTimeMillis() - startTime < durationMillis) {
        Thread.sleep(60000);
        reportChannels(datastore, threadCount, minute++, intervalRequests.getAndSet(0), 
            errorCount.getAndSet(0), activePeak.getAndSet(0));
      }
    } finally {
      peakTracker.interrupt();
      executor.shutdownNow();
      executor.awaitTermination(10, TimeUnit.SECONDS);
      datastore.close();
    }
  }

  private ChannelPool getChannelPool(Datastore datastore) {
    try {
      Field rpcField = datastore.getClass().getDeclaredField("datastoreRpc");
      rpcField.setAccessible(true);
      Object rpc = rpcField.get(datastore);

      Field stubField = rpc.getClass().getDeclaredField("datastoreStub");
      stubField.setAccessible(true);
      Object stub = stubField.get(rpc);

      Field resourcesField = stub.getClass().getSuperclass().getDeclaredField("backgroundResources");
      resourcesField.setAccessible(true);
      List<?> resources = (List<?>) resourcesField.get(stub);
      
      for (Object res : resources) {
          if (res instanceof GrpcTransportChannel) {
              Object channel = ((GrpcTransportChannel) res).getManagedChannel();
              return findChannelPool(channel);
          }
      }
    } catch (Exception ignored) {}
    return null;
  }

  private ChannelPool findChannelPool(Object channel) {
      if (channel == null) return null;
      if (channel instanceof ChannelPool) {
          return (ChannelPool) channel;
      }
      try {
          Field delegateField = channel.getClass().getDeclaredField("delegate");
          delegateField.setAccessible(true);
          return findChannelPool(delegateField.get(channel));
      } catch (Exception e) {
          try {
              Field subChannelField = channel.getClass().getDeclaredField("channel");
              subChannelField.setAccessible(true);
              return findChannelPool(subChannelField.get(channel));
          } catch (Exception ignored) {}
      }
      return null;
  }

  private int getActualOutstanding(Datastore datastore) {
    ChannelPool pool = getChannelPool(datastore);
    if (pool != null) {
      List<ChannelPool.Entry> entries = pool.entries.get();
      int total = 0;
      for (ChannelPool.Entry entry : entries) {
        total += entry.outstandingRpcs.get();
      }
      return total;
    }
    return 0;
  }

  private void reportChannels(Datastore datastore, int targetLoad, int minute, int requestsInInterval, 
      int errorsInInterval, int observedPeak) {
    try {
      System.out.println("\n" + Strings.repeat("-", 30));
      System.out.println(String.format("[PHASE: %d threads] Minute %d/15", targetLoad, minute));
      System.out.println(String.format("Throughput: %d req/min (~%.2f req/s) | Observed Peak Concurrency: %d", 
          requestsInInterval, requestsInInterval/60.0, observedPeak));
      if (errorsInInterval > 0) System.out.println("Errors in last minute: " + errorsInInterval);

      ChannelPool pool = getChannelPool(datastore);
      if (pool != null) {
        List<ChannelPool.Entry> entries = pool.entries.get();

        int poolSize = entries.size();
        int overwhelmedCount = 0;
        StringBuilder channelDetails = new StringBuilder("Channel Saturation:\n");
        for (int i = 0; i < poolSize; i++) {
          ChannelPool.Entry entry = entries.get(i);
          int count = entry.outstandingRpcs.get();
          int poolInternalMax = entry.maxOutstanding.get();
          
          if (count > 100 || poolInternalMax > 100) overwhelmedCount++;
          if (poolSize <= 10 || i < 5 || i >= poolSize - 2) {
            String status = (count > 100 || poolInternalMax > 100) ? "!! OVERWHELMED !!" : "OK";
            channelDetails.append(String.format("  Ch %02d: Current %3d, InternalPeak %3d [%s]\n", i, count, poolInternalMax, status));
          } else if (i == 5) {
            channelDetails.append("  ... (hiding middle channels)\n");
          }
        }
        System.out.println("Current Pool Size: " + poolSize);
        System.out.print(channelDetails.toString());
        if (overwhelmedCount > 0) System.out.println(String.format("WARNING: %d/%d channels saturated (>=100 streams)!", overwhelmedCount, poolSize));
      } else {
        System.out.println("Underlying channel is NOT a ChannelPool. Check if gRPC is enabled.");
      }
    } catch (Exception e) {
      System.err.println("Failed to report: " + e.getMessage());
    }
  }
}

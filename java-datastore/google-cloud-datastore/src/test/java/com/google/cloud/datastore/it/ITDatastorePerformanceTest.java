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

import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.base.Strings;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;

public class ITDatastorePerformanceTest {

  @Test
  public void testMultiPhasePerformanceAndResizing() throws Exception {
    int[] loadSteps = {100, 500, 1000, 2500};
    long phaseDurationMillis = TimeUnit.MINUTES.toMillis(15);
    
    for (int load : loadSteps) {
      runPhase(load, phaseDurationMillis);
      System.out.println("\n\n" + Strings.repeat("=", 50));
      System.out.println("COMPLETED PHASE WITH " + load + " CONCURRENT RPCs");
      System.out.println(Strings.repeat("=", 50) + "\n\n");
    }
  }

  private void runPhase(int threadCount, long durationMillis) throws Exception {
    System.out.println("\n--- STARTING PHASE: " + threadCount + " concurrent RPCs ---");

    // Configure Dynamic Resizing: max 50 RPCs per channel, max 100 channels
    TransportChannelProvider channelProvider = DatastoreSettings.defaultGrpcTransportProviderBuilder()
        .setChannelPoolSettings(ChannelPoolSettings.builder()
            .setInitialChannelCount(1)
            .setMinChannelCount(1)
            .setMaxChannelCount(100)
            .setMaxRpcsPerChannel(50)
            .setMinRpcsPerChannel(10)
            .build())
        .build();

    // Use default credentials and real endpoint (hit Google Cloud)
    DatastoreOptions options = DatastoreOptions.newBuilder()
        .setTransportOptions(GrpcTransportOptions.newBuilder().build())
        .setChannelProvider(channelProvider)
        .build();

    System.out.println("Project ID: " + options.getProjectId());
    System.out.println("Host: " + options.getHost());

    Datastore datastore = options.getService();
    
    // Ensure a real entity exists to fetch (increases latency vs "Not Found")
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("PerfTestKind");
    Key key = keyFactory.newKey("perf-test-entity");
    datastore.put(com.google.cloud.datastore.Entity.newBuilder(key)
        .set("payload", Strings.repeat("a", 1024)) // 1KB payload
        .build());

    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    AtomicInteger intervalRequests = new AtomicInteger(0);
    AtomicInteger errorCount = new AtomicInteger(0);
    AtomicInteger activePeak = new AtomicInteger(0);

    // Background thread to track the true peak concurrency
    Thread peakTracker = new Thread(() -> {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int current = getActualOutstanding(datastore);
                int currentPeak;
                do {
                    currentPeak = activePeak.get();
                    if (current <= currentPeak) break;
                } while (!activePeak.compareAndSet(currentPeak, current));
                Thread.sleep(10); // Sample every 10ms
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
        Thread.sleep(60000); // Wait 1 minute
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

  private int getActualOutstanding(Datastore datastore) {
    try {
      Field rpcField = datastore.getClass().getDeclaredField("datastoreRpc");
      rpcField.setAccessible(true);
      Object rpc = rpcField.get(datastore);

      Field contextField = rpc.getClass().getDeclaredField("clientContext");
      contextField.setAccessible(true);
      ClientContext clientContext = (ClientContext) contextField.get(rpc);

      TransportChannel transportChannel = clientContext.getTransportChannel();
      Method getChannelMethod = transportChannel.getClass().getMethod("getChannel");
      Object managedChannel = getChannelMethod.invoke(transportChannel);

      if (managedChannel.getClass().getName().contains("ChannelPool")) {
        Field entriesField = managedChannel.getClass().getDeclaredField("entries");
        entriesField.setAccessible(true);
        AtomicReference<?> entriesRef = (AtomicReference<?>) entriesField.get(managedChannel);
        List<?> entries = (List<?>) entriesRef.get();

        int total = 0;
        for (Object entry : entries) {
          Field outstandingField = entry.getClass().getDeclaredField("outstandingRpcs");
          outstandingField.setAccessible(true);
          total += ((AtomicInteger) outstandingField.get(entry)).get();
        }
        return total;
      }
    } catch (Exception ignored) {}
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

      Field rpcField = datastore.getClass().getDeclaredField("datastoreRpc");
      rpcField.setAccessible(true);
      Object rpc = rpcField.get(datastore);

      Field contextField = rpc.getClass().getDeclaredField("clientContext");
      contextField.setAccessible(true);
      ClientContext clientContext = (ClientContext) contextField.get(rpc);

      TransportChannel transportChannel = clientContext.getTransportChannel();
      Method getChannelMethod = transportChannel.getClass().getMethod("getChannel");
      Object managedChannel = getChannelMethod.invoke(transportChannel);

      if (managedChannel.getClass().getName().contains("ChannelPool")) {
        Field entriesField = managedChannel.getClass().getDeclaredField("entries");
        entriesField.setAccessible(true);
        AtomicReference<?> entriesRef = (AtomicReference<?>) entriesField.get(managedChannel);
        List<?> entries = (List<?>) entriesRef.get();

        int poolSize = entries.size();
        int overwhelmedCount = 0;
        
        StringBuilder channelDetails = new StringBuilder("Channel Saturation:\n");
        for (int i = 0; i < poolSize; i++) {
          Object entry = entries.get(i);
          Field outstandingField = entry.getClass().getDeclaredField("outstandingRpcs");
          outstandingField.setAccessible(true);
          int count = ((AtomicInteger) outstandingField.get(entry)).get();
          
          Field maxField = entry.getClass().getDeclaredField("maxOutstanding");
          maxField.setAccessible(true);
          int poolInternalMax = ((AtomicInteger) maxField.get(entry)).get();
          
          if (count > 100 || poolInternalMax > 100) overwhelmedCount++;

          if (poolSize <= 10 || i < 5 || i >= poolSize - 2) {
            String status = (count > 100 || poolInternalMax > 100) ? "!! OVERWHELMED !!" : (poolInternalMax > 50 ? "Scaling" : "OK");
            channelDetails.append(String.format("  Ch %02d: Current %3d, InternalPeak %3d [%s]\n", i, count, poolInternalMax, status));
          } else if (i == 5) {
            channelDetails.append("  ... (hiding middle channels)\n");
          }
        }

        System.out.println("Current Pool Size: " + poolSize);
        System.out.print(channelDetails.toString());
        
        if (overwhelmedCount > 0) {
          System.out.println(String.format("WARNING: %d/%d channels saturated (>=100 streams)!", overwhelmedCount, poolSize));
        }
      } else {
        System.out.println("Underlying channel is not a ChannelPool: " + managedChannel.getClass().getName());
      }
    } catch (Exception e) {
      System.err.println("Failed to report: " + e.getMessage());
    }
  }
}

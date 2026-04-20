/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.protobuf.ByteString;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.Tablet;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChannelFinderTest {

  @Test
  public void updateAsyncDrainsQueuedUpdatesInOrderWithoutDroppingAny() throws Exception {
    ExecutorService executor = cacheUpdatePool();
    int threadCount = maxCacheUpdateThreads();
    CountDownLatch workersStarted = new CountDownLatch(threadCount);
    CountDownLatch releaseWorkers = new CountDownLatch(1);

    try {
      for (int i = 0; i < threadCount; i++) {
        executor.execute(
            () -> {
              workersStarted.countDown();
              try {
                releaseWorkers.await(5, TimeUnit.SECONDS);
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
              }
            });
      }
      assertThat(workersStarted.await(5, TimeUnit.SECONDS)).isTrue();

      ChannelFinder finder = new ChannelFinder(new FakeEndpointCache());
      int updateCount = 64;
      for (int i = 0; i < updateCount; i++) {
        finder.updateAsync(singleRangeUpdate(i));
      }

      releaseWorkers.countDown();
      finder.awaitPendingUpdates();

      assertThat(rangeCache(finder).size()).isEqualTo(updateCount);
    } finally {
      releaseWorkers.countDown();
    }
  }

  @Test
  public void updateIgnoresZeroDatabaseIdAndKeepsExistingCache() throws Exception {
    ChannelFinder finder = new ChannelFinder(new FakeEndpointCache());
    finder.update(singleRangeUpdate(0));

    finder.update(CacheUpdate.newBuilder().setDatabaseId(0L).build());

    assertThat(databaseId(finder)).isEqualTo(7L);
    assertThat(rangeCache(finder).size()).isEqualTo(1);
  }

  @Test
  public void updateAsyncSkipsTrulyEmptyUpdateForCurrentDatabase() throws Exception {
    ChannelFinder finder = new ChannelFinder(new FakeEndpointCache());
    finder.update(singleRangeUpdate(0));

    finder.updateAsync(CacheUpdate.newBuilder().setDatabaseId(7L).build());
    finder.awaitPendingUpdates();

    assertThat(databaseId(finder)).isEqualTo(7L);
    assertThat(rangeCache(finder).size()).isEqualTo(1);
  }

  @Test
  public void updateAsyncProcessesDatabaseTransitionWithoutRangesOrGroups() throws Exception {
    ChannelFinder finder = new ChannelFinder(new FakeEndpointCache());
    finder.update(singleRangeUpdate(0));

    finder.updateAsync(CacheUpdate.newBuilder().setDatabaseId(9L).build());
    finder.awaitPendingUpdates();

    assertThat(databaseId(finder)).isEqualTo(9L);
    assertThat(rangeCache(finder).size()).isEqualTo(0);
  }

  @Test
  public void updateDoesNotBlockOnLifecycleManagerAddressReconciliation() throws Exception {
    BlockingLifecycleManager lifecycleManager =
        new BlockingLifecycleManager(new FakeEndpointCache());
    ChannelFinder finder = new ChannelFinder(new FakeEndpointCache(), lifecycleManager, "db-1");
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      Future<?> future = executor.submit(() -> finder.update(singleRangeUpdate(0)));

      future.get(1, TimeUnit.SECONDS);
      assertThat(lifecycleManager.updateStarted.await(5, TimeUnit.SECONDS)).isTrue();
      assertThat(rangeCache(finder).size()).isEqualTo(1);

      lifecycleManager.releaseUpdate.countDown();
      assertThat(lifecycleManager.updateFinished.await(5, TimeUnit.SECONDS)).isTrue();
    } finally {
      lifecycleManager.releaseUpdate.countDown();
      lifecycleManager.shutdown();
      executor.shutdownNow();
    }
  }

  private static CacheUpdate singleRangeUpdate(int index) {
    String startKey = String.format("k%05d", index);
    String limitKey = String.format("k%05d", index + 1);
    long groupUid = index + 1L;
    return CacheUpdate.newBuilder()
        .setDatabaseId(7L)
        .addRange(
            Range.newBuilder()
                .setStartKey(bytes(startKey))
                .setLimitKey(bytes(limitKey))
                .setGroupUid(groupUid)
                .setSplitId(groupUid)
                .setGeneration(bytes("g")))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(groupUid)
                .setGeneration(bytes("g"))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(groupUid)
                        .setServerAddress("server-" + index + ":1234")
                        .setIncarnation(bytes("i"))
                        .setDistance(0)))
        .build();
  }

  private static ByteString bytes(String value) {
    return ByteString.copyFromUtf8(value);
  }

  private static ExecutorService cacheUpdatePool() throws Exception {
    Field field = ChannelFinder.class.getDeclaredField("CACHE_UPDATE_POOL");
    field.setAccessible(true);
    return (ExecutorService) field.get(null);
  }

  private static int maxCacheUpdateThreads() throws Exception {
    Field field = ChannelFinder.class.getDeclaredField("MAX_CACHE_UPDATE_THREADS");
    field.setAccessible(true);
    return field.getInt(null);
  }

  private static long databaseId(ChannelFinder finder) throws Exception {
    Field field = ChannelFinder.class.getDeclaredField("databaseId");
    field.setAccessible(true);
    return ((AtomicLong) field.get(finder)).get();
  }

  private static KeyRangeCache rangeCache(ChannelFinder finder) throws Exception {
    Field field = ChannelFinder.class.getDeclaredField("rangeCache");
    field.setAccessible(true);
    return (KeyRangeCache) field.get(finder);
  }

  private static final class FakeEndpointCache implements ChannelEndpointCache {
    private final Map<String, FakeEndpoint> endpoints = new ConcurrentHashMap<>();
    private final FakeEndpoint defaultEndpoint = new FakeEndpoint("default");

    @Override
    public ChannelEndpoint defaultChannel() {
      return defaultEndpoint;
    }

    @Override
    public ChannelEndpoint get(String address) {
      return endpoints.computeIfAbsent(address, FakeEndpoint::new);
    }

    @Override
    public ChannelEndpoint getIfPresent(String address) {
      return endpoints.computeIfAbsent(address, FakeEndpoint::new);
    }

    @Override
    public void evict(String address) {
      endpoints.remove(address);
    }

    @Override
    public void shutdown() {
      endpoints.clear();
    }
  }

  private static final class FakeEndpoint implements ChannelEndpoint {
    private final String address;
    private final ManagedChannel channel = new FakeManagedChannel();
    private final AtomicInteger activeRequests = new AtomicInteger();

    private FakeEndpoint(String address) {
      this.address = address;
    }

    @Override
    public String getAddress() {
      return address;
    }

    @Override
    public boolean isHealthy() {
      return true;
    }

    @Override
    public boolean isTransientFailure() {
      return false;
    }

    @Override
    public ManagedChannel getChannel() {
      return channel;
    }

    @Override
    public void incrementActiveRequests() {
      activeRequests.incrementAndGet();
    }

    @Override
    public void decrementActiveRequests() {
      activeRequests.updateAndGet(current -> current > 0 ? current - 1 : 0);
    }

    @Override
    public int getActiveRequestCount() {
      return Math.max(0, activeRequests.get());
    }
  }

  private static final class FakeManagedChannel extends ManagedChannel {
    @Override
    public ManagedChannel shutdown() {
      return this;
    }

    @Override
    public ManagedChannel shutdownNow() {
      return this;
    }

    @Override
    public boolean isShutdown() {
      return false;
    }

    @Override
    public boolean isTerminated() {
      return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
      return true;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      throw new UnsupportedOperationException();
    }

    @Override
    public String authority() {
      return "fake";
    }
  }

  private static final class BlockingLifecycleManager extends EndpointLifecycleManager {
    private final CountDownLatch updateStarted = new CountDownLatch(1);
    private final CountDownLatch releaseUpdate = new CountDownLatch(1);
    private final CountDownLatch updateFinished = new CountDownLatch(1);

    private BlockingLifecycleManager(ChannelEndpointCache endpointCache) {
      super(endpointCache);
    }

    @Override
    void updateActiveAddresses(String finderKey, java.util.Set<String> activeAddresses) {
      updateStarted.countDown();
      try {
        releaseUpdate.await(5, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } finally {
        updateFinished.countDown();
      }
    }
  }
}

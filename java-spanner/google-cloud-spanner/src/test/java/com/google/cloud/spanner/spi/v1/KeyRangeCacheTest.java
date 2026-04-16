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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.Tablet;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KeyRangeCacheTest {

  @Test
  public void skipsTransientFailureTabletWithSkippedTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    cache.addRanges(twoReplicaUpdate());

    // Pre-create endpoints.
    endpointCache.get("server1");
    endpointCache.get("server2");

    // Initial routing works.
    RoutingHint.Builder initialHint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint initialServer =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            initialHint);
    assertNotNull(initialServer);

    // Mark server1 as TRANSIENT_FAILURE.
    endpointCache.setState("server1", EndpointHealthState.TRANSIENT_FAILURE);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
    assertEquals(1, hint.getSkippedTabletUidCount());
    assertEquals(1L, hint.getSkippedTabletUid(0).getTabletUid());
  }

  @Test
  public void skipsExplicitlyExcludedTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    cache.addRanges(
        CacheUpdate.newBuilder()
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("a"))
                    .setLimitKey(bytes("z"))
                    .setGroupUid(5)
                    .setSplitId(1)
                    .setGeneration(bytes("1")))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(5)
                    .setGeneration(bytes("1"))
                    .setLeaderIndex(0)
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(1)
                            .setServerAddress("server1")
                            .setIncarnation(bytes("1"))
                            .setDistance(0))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(2)
                            .setServerAddress("server2")
                            .setIncarnation(bytes("1"))
                            .setDistance(0)))
            .build());

    // Pre-create endpoints so getIfPresent() returns them.
    endpointCache.get("server1");
    endpointCache.get("server2");

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            /* preferLeader= */ true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint,
            "server1"::equals);

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
    assertEquals(1, hint.getSkippedTabletUidCount());
    assertEquals(1L, hint.getSkippedTabletUid(0).getTabletUid());
  }

  @Test
  public void shrinkToEvictsRanges() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    final int numRanges = 100;
    for (int i = 0; i < numRanges; i++) {
      CacheUpdate update =
          CacheUpdate.newBuilder()
              .addRange(
                  Range.newBuilder()
                      .setStartKey(bytes(String.format("%04d", i)))
                      .setLimitKey(bytes(String.format("%04d", i + 1)))
                      .setGroupUid(i)
                      .setSplitId(i)
                      .setGeneration(bytes("1")))
              .addGroup(
                  Group.newBuilder()
                      .setGroupUid(i)
                      .setGeneration(bytes("1"))
                      .addTablets(
                          Tablet.newBuilder()
                              .setTabletUid(i)
                              .setServerAddress("server" + i)
                              .setIncarnation(bytes("1"))))
              .build();
      cache.addRanges(update);
      // Pre-create endpoint so READY state check passes in shouldSkip.
      endpointCache.get("server" + i);
    }

    checkContents(cache, numRanges, numRanges);

    int shrinkTo = numRanges - numRanges / 4;
    cache.shrinkTo(shrinkTo);
    checkContents(cache, shrinkTo, 3 * numRanges / 4);

    cache.shrinkTo(numRanges / 8);
    checkContents(cache, numRanges / 8, 7 * numRanges / 8);

    cache.shrinkTo(0);
    checkContents(cache, 0, numRanges);
  }

  @Test
  public void readyEndpointIsUsableForLocationAware() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    // Pre-create endpoint so getIfPresent finds it. Default state is READY.
    endpointCache.get("server1");

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server1", server.getAddress());
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void idleEndpointIsNotUsableForLocationAware() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    // Ensure endpoint exists in cache first.
    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.IDLE);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    // IDLE causes silent skip — falls back to null (default host), no skipped_tablets.
    assertNull(server);
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void connectingEndpointIsNotUsableForLocationAware() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.CONNECTING);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNull(server);
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void transientFailureEndpointIsNotUsable() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.TRANSIENT_FAILURE);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    // TRANSIENT_FAILURE: skip with skipped_tablets.
    assertNull(server);
    assertEquals(1, hint.getSkippedTabletUidCount());
    assertEquals(1L, hint.getSkippedTabletUid(0).getTabletUid());
  }

  @Test
  public void unsupportedGetStateTreatedAsNotReady() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.UNSUPPORTED);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    // Unsupported state: skip silently, no skipped_tablets.
    assertNull(server);
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void missingEndpointCausesDefaultHostFallbackWithoutSkippedTablet() {
    // Endpoint not in cache at all — getIfPresent returns null.
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    endpointCache.setCreateOnGet(false);
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNull(server);
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void idleEndpointCausesDefaultHostFallbackWithoutSkippedTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.IDLE);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNull(server);
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void connectingEndpointCausesDefaultHostFallbackWithoutSkippedTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.CONNECTING);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNull(server);
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void transientFailureEndpointCausesSkippedTabletPlusDefaultHostFallback() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.TRANSIENT_FAILURE);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNull(server);
    assertEquals(1, hint.getSkippedTabletUidCount());
    assertEquals(1L, hint.getSkippedTabletUid(0).getTabletUid());
  }

  @Test
  public void recentlyEvictedTransientFailureEndpointStillAddsSkippedTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    RecentTransientFailureLifecycleManager lifecycleManager =
        new RecentTransientFailureLifecycleManager(endpointCache);
    try {
      KeyRangeCache cache = new KeyRangeCache(endpointCache, lifecycleManager);
      cache.addRanges(singleReplicaUpdate("server1"));
      lifecycleManager.markRecentlyEvictedTransientFailure("server1");

      RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
      ChannelEndpoint server =
          cache.fillRoutingHint(
              false,
              KeyRangeCache.RangeMode.COVERING_SPLIT,
              DirectedReadOptions.getDefaultInstance(),
              hint);

      assertNull(server);
      assertEquals(1, hint.getSkippedTabletUidCount());
      assertEquals(1L, hint.getSkippedTabletUid(0).getTabletUid());
      assertTrue(lifecycleManager.recreationRequested.contains("server1"));
    } finally {
      lifecycleManager.shutdown();
    }
  }

  @Test
  public void oneUnusableReplicaAndOneReadyReplicaUsesReady() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(twoReplicaUpdate());

    // Make both endpoints present.
    endpointCache.get("server1");
    endpointCache.get("server2");

    // server1 is IDLE (not ready), server2 is READY.
    endpointCache.setState("server1", EndpointHealthState.IDLE);
    endpointCache.setState("server2", EndpointHealthState.READY);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
    // server1 was IDLE, so no skipped_tablets for it.
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void readyEndpointIsUsedForLocationAware() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.READY);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server1", server.getAddress());
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void transientFailureReplicaSkippedAndReadyReplicaSelected() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(twoReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");

    endpointCache.setState("server1", EndpointHealthState.TRANSIENT_FAILURE);
    endpointCache.setState("server2", EndpointHealthState.READY);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
    // server1 was TRANSIENT_FAILURE, so it should be in skipped_tablets.
    assertEquals(1, hint.getSkippedTabletUidCount());
    assertEquals(1L, hint.getSkippedTabletUid(0).getTabletUid());
  }

  @Test
  public void laterTransientFailureReplicaReportedWhenEarlierReplicaSelected() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    endpointCache.setState("server1", EndpointHealthState.READY);
    endpointCache.setState("server2", EndpointHealthState.READY);
    endpointCache.setState("server3", EndpointHealthState.TRANSIENT_FAILURE);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server1", server.getAddress());
    assertEquals(1, hint.getSkippedTabletUidCount());
    assertEquals(3L, hint.getSkippedTabletUid(0).getTabletUid());
  }

  @Test
  public void laterRecentlyEvictedTransientFailureReplicaReportedWhenEarlierReplicaSelected() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    RecentTransientFailureLifecycleManager lifecycleManager =
        new RecentTransientFailureLifecycleManager(endpointCache);
    try {
      KeyRangeCache cache = new KeyRangeCache(endpointCache, lifecycleManager);
      cache.addRanges(threeReplicaUpdate());

      endpointCache.get("server1");
      endpointCache.get("server2");
      lifecycleManager.markRecentlyEvictedTransientFailure("server3");

      RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
      ChannelEndpoint server =
          cache.fillRoutingHint(
              false,
              KeyRangeCache.RangeMode.COVERING_SPLIT,
              DirectedReadOptions.getDefaultInstance(),
              hint);

      assertNotNull(server);
      assertEquals("server1", server.getAddress());
      assertEquals(1, hint.getSkippedTabletUidCount());
      assertEquals(3L, hint.getSkippedTabletUid(0).getTabletUid());
    } finally {
      lifecycleManager.shutdown();
    }
  }

  // --- Eviction and recreation tests ---

  @Test
  public void staleShutdownEndpointIsClearedAndRelookedUp() {
    // Bug 1 regression: after idle eviction shuts down a channel, the tablet's cached
    // endpoint reference becomes stale. shouldSkip must detect the shutdown channel,
    // discard it, and re-lookup from the cache.
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));

    // Route once so the tablet caches the endpoint reference.
    endpointCache.get("server1");
    RoutingHint.Builder hint1 = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint first =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint1);
    assertNotNull(first);
    assertEquals("server1", first.getAddress());

    // Simulate idle eviction: shut down the channel and evict from cache.
    first.getChannel().shutdownNow();
    endpointCache.evict("server1");

    // Without the fix, the tablet would keep using the stale shutdown endpoint forever.
    // With the fix, shouldSkip detects the shutdown, clears it, and re-lookups from cache.

    // Re-create the endpoint (simulating lifecycle manager recreation).
    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.READY);

    RoutingHint.Builder hint2 = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint second =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint2);

    // Should find the new READY endpoint.
    assertNotNull(second);
    assertEquals("server1", second.getAddress());
    assertEquals(0, hint2.getSkippedTabletUidCount());
  }

  @Test
  public void missingEndpointTriggersRecreationViaLifecycleManager() {
    // Bug 2 regression: when a routing lookup finds no endpoint, it should call
    // requestEndpointRecreation so the endpoint becomes available for future requests.
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    TrackingLifecycleManager tracking = new TrackingLifecycleManager(endpointCache);
    try {
      KeyRangeCache cache = new KeyRangeCache(endpointCache, tracking);
      cache.addRanges(singleReplicaUpdate("server1"));

      // No endpoint exists in cache.
      RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
      ChannelEndpoint server =
          cache.fillRoutingHint(
              false,
              KeyRangeCache.RangeMode.COVERING_SPLIT,
              DirectedReadOptions.getDefaultInstance(),
              hint);

      // Should fall back to default.
      assertNull(server);

      // Lifecycle manager should have been asked to recreate the endpoint.
      assertTrue(
          "requestEndpointRecreation should have been called for server1",
          tracking.recreationRequested.contains("server1"));
    } finally {
      tracking.shutdown();
    }
  }

  /** Minimal lifecycle manager stub that records recreation requests. */
  private static class TrackingLifecycleManager extends EndpointLifecycleManager {
    final java.util.Set<String> recreationRequested = new java.util.HashSet<>();

    TrackingLifecycleManager(ChannelEndpointCache cache) {
      super(cache);
    }

    @Override
    void requestEndpointRecreation(String address) {
      recreationRequested.add(address);
    }
  }

  private static final class RecentTransientFailureLifecycleManager
      extends TrackingLifecycleManager {
    final java.util.Set<String> recentlyEvictedTransientFailures = new java.util.HashSet<>();

    RecentTransientFailureLifecycleManager(ChannelEndpointCache cache) {
      super(cache);
    }

    void markRecentlyEvictedTransientFailure(String address) {
      recentlyEvictedTransientFailures.add(address);
    }

    @Override
    boolean wasRecentlyEvictedTransientFailure(String address) {
      return recentlyEvictedTransientFailures.contains(address);
    }
  }

  // --- Helper methods ---

  private static CacheUpdate singleReplicaUpdate(String serverAddress) {
    return CacheUpdate.newBuilder()
        .addRange(
            Range.newBuilder()
                .setStartKey(bytes("a"))
                .setLimitKey(bytes("z"))
                .setGroupUid(5)
                .setSplitId(1)
                .setGeneration(bytes("1")))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(5)
                .setGeneration(bytes("1"))
                .setLeaderIndex(0)
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(1)
                        .setServerAddress(serverAddress)
                        .setIncarnation(bytes("1"))
                        .setDistance(0)))
        .build();
  }

  private static CacheUpdate twoReplicaUpdate() {
    return CacheUpdate.newBuilder()
        .addRange(
            Range.newBuilder()
                .setStartKey(bytes("a"))
                .setLimitKey(bytes("z"))
                .setGroupUid(5)
                .setSplitId(1)
                .setGeneration(bytes("1")))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(5)
                .setGeneration(bytes("1"))
                .setLeaderIndex(0)
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(1)
                        .setServerAddress("server1")
                        .setIncarnation(bytes("1"))
                        .setDistance(0))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(2)
                        .setServerAddress("server2")
                        .setIncarnation(bytes("1"))
                        .setDistance(0)))
        .build();
  }

  private static CacheUpdate threeReplicaUpdate() {
    return CacheUpdate.newBuilder()
        .addRange(
            Range.newBuilder()
                .setStartKey(bytes("a"))
                .setLimitKey(bytes("z"))
                .setGroupUid(5)
                .setSplitId(1)
                .setGeneration(bytes("1")))
        .addGroup(
            Group.newBuilder()
                .setGroupUid(5)
                .setGeneration(bytes("1"))
                .setLeaderIndex(0)
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(1)
                        .setServerAddress("server1")
                        .setIncarnation(bytes("1"))
                        .setDistance(0))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(2)
                        .setServerAddress("server2")
                        .setIncarnation(bytes("1"))
                        .setDistance(0))
                .addTablets(
                    Tablet.newBuilder()
                        .setTabletUid(3)
                        .setServerAddress("server3")
                        .setIncarnation(bytes("1"))
                        .setDistance(0)))
        .build();
  }

  private static void checkContents(KeyRangeCache cache, int expectedSize, int mustBeInCache) {
    assertEquals(expectedSize, cache.size());
    int hitCount = 0;
    for (int i = 0; i < 100; i++) {
      RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes(String.format("%04d", i)));
      ChannelEndpoint server =
          cache.fillRoutingHint(
              false,
              KeyRangeCache.RangeMode.COVERING_SPLIT,
              DirectedReadOptions.getDefaultInstance(),
              hint);
      if (i > mustBeInCache) {
        assertNotNull(server);
      }
      if (server != null) {
        hitCount++;
        assertEquals("server" + i, server.getAddress());
      }
    }
    assertEquals(expectedSize, hitCount);
  }

  private static ByteString bytes(String value) {
    return ByteString.copyFromUtf8(value);
  }

  // --- Health state for testing ---

  enum EndpointHealthState {
    READY,
    IDLE,
    CONNECTING,
    TRANSIENT_FAILURE,
    SHUTDOWN,
    UNSUPPORTED
  }

  // --- Test doubles ---

  static final class FakeEndpointCache implements ChannelEndpointCache {
    private final Map<String, FakeEndpoint> endpoints = new HashMap<>();
    private final FakeEndpoint defaultEndpoint = new FakeEndpoint("default");
    private boolean createOnGet = true;

    @Override
    public ChannelEndpoint defaultChannel() {
      return defaultEndpoint;
    }

    @Override
    public ChannelEndpoint get(String address) {
      return endpoints.computeIfAbsent(address, FakeEndpoint::new);
    }

    @Override
    @Nullable
    public ChannelEndpoint getIfPresent(String address) {
      return endpoints.get(address);
    }

    @Override
    public void evict(String address) {
      endpoints.remove(address);
    }

    @Override
    public void shutdown() {
      endpoints.clear();
    }

    void setCreateOnGet(boolean createOnGet) {
      this.createOnGet = createOnGet;
    }

    void setState(String address, EndpointHealthState state) {
      FakeEndpoint endpoint = endpoints.get(address);
      if (endpoint != null) {
        endpoint.setState(state);
      }
    }

    @Deprecated
    void setHealthy(String address, boolean healthy) {
      setState(
          address, healthy ? EndpointHealthState.READY : EndpointHealthState.TRANSIENT_FAILURE);
    }
  }

  static final class FakeEndpoint implements ChannelEndpoint {
    private final String address;
    private final FakeManagedChannel channel = new FakeManagedChannel();
    private EndpointHealthState state = EndpointHealthState.READY;

    FakeEndpoint(String address) {
      this.address = address;
    }

    @Override
    public String getAddress() {
      return address;
    }

    @Override
    public boolean isHealthy() {
      return state == EndpointHealthState.READY;
    }

    @Override
    public boolean isTransientFailure() {
      return state == EndpointHealthState.TRANSIENT_FAILURE;
    }

    @Override
    public ManagedChannel getChannel() {
      return channel;
    }

    void setState(EndpointHealthState state) {
      this.state = state;
      channel.setConnectivityState(toConnectivityState(state));
    }

    private static ConnectivityState toConnectivityState(EndpointHealthState healthState) {
      switch (healthState) {
        case READY:
          return ConnectivityState.READY;
        case TRANSIENT_FAILURE:
          return ConnectivityState.TRANSIENT_FAILURE;
        case IDLE:
          return ConnectivityState.IDLE;
        case CONNECTING:
          return ConnectivityState.CONNECTING;
        case UNSUPPORTED:
          return ConnectivityState.IDLE;
        default:
          return ConnectivityState.IDLE;
      }
    }
  }

  private static final class FakeManagedChannel extends ManagedChannel {
    private boolean shutdown = false;
    private volatile ConnectivityState connectivityState = ConnectivityState.READY;

    void setConnectivityState(ConnectivityState state) {
      this.connectivityState = state;
    }

    @Override
    public ConnectivityState getState(boolean requestConnection) {
      return shutdown ? ConnectivityState.SHUTDOWN : connectivityState;
    }

    @Override
    public ManagedChannel shutdown() {
      shutdown = true;
      return this;
    }

    @Override
    public boolean isShutdown() {
      return shutdown;
    }

    @Override
    public boolean isTerminated() {
      return shutdown;
    }

    @Override
    public ManagedChannel shutdownNow() {
      shutdown = true;
      return this;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
      return shutdown;
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
}

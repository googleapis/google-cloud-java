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
import static org.junit.Assert.assertFalse;
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
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KeyRangeCacheTest {
  private static final long TEST_OPERATION_UID = 101L;

  @After
  public void tearDown() {
    EndpointLatencyRegistry.clear();
  }

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
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void lookupRoutingHintReportsCacheMiss() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    KeyRangeCache.RouteLookupResult result =
        cache.lookupRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint,
            address -> false);

    assertNull(result.endpoint);
    assertEquals(KeyRangeCache.RouteFailureReason.CACHE_MISS, result.failureReason);
  }

  @Test
  public void lookupRoutingHintReusesReplicaWhenAllCandidatesAreExcludedOrCoolingDown() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));
    endpointCache.get("server1");

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    KeyRangeCache.RouteLookupResult result =
        cache.lookupRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint,
            "server1"::equals);

    assertNotNull(result.endpoint);
    assertEquals("server1", result.endpoint.getAddress());
    assertEquals(KeyRangeCache.RouteFailureReason.NONE, result.failureReason);
  }

  @Test
  public void lookupRoutingHintUsesLowestScoreWhenAllCandidatesAreExcludedOrCoolingDown() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, false, "server1", Duration.ofNanos(300_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, false, "server2", Duration.ofNanos(100_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, false, "server3", Duration.ofNanos(200_000L));

    RoutingHint.Builder hint =
        RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID);
    KeyRangeCache.RouteLookupResult result =
        cache.lookupRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint,
            address -> true);

    assertNotNull(result.endpoint);
    assertEquals("server2", result.endpoint.getAddress());
    assertEquals(KeyRangeCache.RouteFailureReason.NONE, result.failureReason);
  }

  @Test
  public void lookupRoutingHintRescuesOldestCoolingReplicaWhenAnotherTabletIsSkipped() {
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
                    .setLeaderIndex(1)
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(1)
                            .setIncarnation(bytes("1"))
                            .setSkip(true))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(2)
                            .setServerAddress("server1")
                            .setIncarnation(bytes("1")))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(3)
                            .setServerAddress("server2")
                            .setIncarnation(bytes("1"))))
            .build());
    endpointCache.get("server1");
    endpointCache.get("server2");
    MutableClock clock = new MutableClock();
    EndpointOverloadCooldownTracker cooldowns =
        new EndpointOverloadCooldownTracker(
            Duration.ofSeconds(10),
            Duration.ofMinutes(1),
            Duration.ofMinutes(10),
            clock,
            ignored -> 0L);
    for (int i = 0; i < 2; i++) {
      cooldowns.recordFailure(
          "server1", io.grpc.Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    }
    clock.advance(Duration.ofMillis(10));
    for (int i = 0; i < 2; i++) {
      cooldowns.recordFailure(
          "server2", io.grpc.Status.Code.RESOURCE_EXHAUSTED, Duration.ofMillis(100));
    }
    clock.advance(Duration.ofMillis(100));

    KeyRangeCache.RouteLookupResult first =
        cache.lookupRoutingHint(
            true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")),
            cooldowns);
    KeyRangeCache.RouteLookupResult second =
        cache.lookupRoutingHint(
            true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")),
            cooldowns);
    KeyRangeCache.RouteLookupResult third =
        cache.lookupRoutingHint(
            true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")),
            cooldowns);

    assertNotNull(first.endpoint);
    assertEquals("server1", first.endpoint.getAddress());
    assertNotNull(second.endpoint);
    assertEquals("server2", second.endpoint.getAddress());
    assertNull(third.endpoint);
    assertEquals(KeyRangeCache.RouteFailureReason.NO_ROUTABLE_REPLICA, third.failureReason);
  }

  @Test
  public void lookupRoutingHintReportsNoReadyReplica() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.addRanges(singleReplicaUpdate("server1"));
    endpointCache.get("server1");
    endpointCache.setState("server1", EndpointHealthState.IDLE);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    KeyRangeCache.RouteLookupResult result =
        cache.lookupRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint,
            address -> false);

    assertNull(result.endpoint);
    assertEquals(KeyRangeCache.RouteFailureReason.NO_READY_REPLICA, result.failureReason);
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
  public void excludedEndpointDoesNotAddSkippedTablet() {
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
            hint,
            "server1"::equals);

    assertNotNull(server);
    assertEquals("server1", server.getAddress());
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
    cache.useDeterministicRandom();
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
      cache.useDeterministicRandom();
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

  @Test
  public void preferLeaderFalseUsesLowestLatencyReplicaWhenScoresAvailable() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, false, "server1", Duration.ofNanos(300_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, false, "server2", Duration.ofNanos(100_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, false, "server3", Duration.ofNanos(200_000L));

    RoutingHint.Builder hint =
        RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID);
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
  }

  @Test
  public void preferLeaderTrueWithOperationUidStillPrefersReadyLeaderOnInitialRequest() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server1", Duration.ofNanos(300_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server2", Duration.ofNanos(100_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server3", Duration.ofNanos(200_000L));

    RoutingHint.Builder hint =
        RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID);
    ChannelEndpoint server =
        cache.fillRoutingHint(
            true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server1", server.getAddress());
  }

  @Test
  public void preferLeaderTrueFallsBackToScoreAwareSelectionWhenLeaderIsExcluded() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server1", Duration.ofNanos(300_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server2", Duration.ofNanos(200_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server3", Duration.ofNanos(100_000L));

    RoutingHint.Builder hint =
        RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID);
    ChannelEndpoint server =
        cache.fillRoutingHint(
            true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint,
            "server1"::equals);

    assertNotNull(server);
    assertEquals("server3", server.getAddress());
  }

  @Test
  public void preferLeaderTrueUsesScoreAwareSelectionOnRetryPath() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server1", Duration.ofNanos(300_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server2", Duration.ofNanos(100_000L));
    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server3", Duration.ofNanos(200_000L));

    RoutingHint.Builder hint =
        RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID);
    hint.addSkippedTabletUidBuilder().setTabletUid(1).setIncarnation(bytes("1"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
  }

  @Test
  public void preferLeaderTrueWithoutOperationUidKeepsLeaderSelection() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    cache.recordReplicaLatency(TEST_OPERATION_UID, "server1", Duration.ofNanos(300_000L));
    cache.recordReplicaLatency(TEST_OPERATION_UID, "server2", Duration.ofNanos(100_000L));
    cache.recordReplicaLatency(TEST_OPERATION_UID, "server3", Duration.ofNanos(200_000L));

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server1", server.getAddress());
  }

  @Test
  public void preferLeaderFalseSkipsBestScoredReplicaWhenItIsNotReady() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");
    endpointCache.setState("server2", EndpointHealthState.IDLE);

    cache.recordReplicaLatency(TEST_OPERATION_UID, "server1", Duration.ofNanos(300_000L));
    cache.recordReplicaLatency(TEST_OPERATION_UID, "server2", Duration.ofNanos(100_000L));
    cache.recordReplicaLatency(TEST_OPERATION_UID, "server3", Duration.ofNanos(200_000L));

    RoutingHint.Builder hint =
        RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID);
    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server3", server.getAddress());
  }

  @Test
  public void preferLeaderFalseUsesOperationUidScopedScores() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    cache.recordReplicaLatency(201L, "server1", Duration.ofNanos(100_000L));
    cache.recordReplicaLatency(201L, "server2", Duration.ofNanos(300_000L));
    cache.recordReplicaLatency(201L, "server3", Duration.ofNanos(200_000L));
    cache.recordReplicaLatency(202L, "server1", Duration.ofNanos(300_000L));
    cache.recordReplicaLatency(202L, "server2", Duration.ofNanos(100_000L));
    cache.recordReplicaLatency(202L, "server3", Duration.ofNanos(200_000L));

    ChannelEndpoint firstOperationServer =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(201L));
    ChannelEndpoint secondOperationServer =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(202L));

    assertNotNull(firstOperationServer);
    assertNotNull(secondOperationServer);
    assertEquals("server1", firstOperationServer.getAddress());
    assertEquals("server2", secondOperationServer.getAddress());
  }

  @Test
  public void preferLeaderFalseUsesInflightCostForColdReplicaSelection() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    endpointCache.get("server1").incrementActiveRequests();

    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID));

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
  }

  @Test
  public void coldReplicaSelectionEmitsFiniteDefaultCost() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    KeyRangeCache.RouteLookupResult result =
        cache.lookupRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID),
            address -> false);

    assertNotNull(result.endpoint);
  }

  @Test
  public void preferLeaderFalseInflightCostCanOutweighLowerLatency() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(threeReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");
    endpointCache.get("server3");

    cache.recordReplicaLatency(TEST_OPERATION_UID, "server1", Duration.ofNanos(100_000L));
    cache.recordReplicaLatency(TEST_OPERATION_UID, "server2", Duration.ofNanos(300_000L));
    endpointCache.get("server1").incrementActiveRequests();
    endpointCache.get("server1").incrementActiveRequests();
    endpointCache.get("server1").incrementActiveRequests();

    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID));

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
  }

  @Test
  public void preferLeaderFalseErrorPenaltySteersSelectionAwayFromPenalizedReplica() {
    FakeEndpointCache baselineEndpointCache = new FakeEndpointCache();
    KeyRangeCache baselineCache = new KeyRangeCache(baselineEndpointCache);
    baselineCache.useDeterministicRandom();
    baselineCache.addRanges(threeReplicaUpdate());

    baselineEndpointCache.get("server1");
    baselineEndpointCache.get("server2");
    baselineEndpointCache.get("server3");

    ChannelEndpoint baselineServer =
        baselineCache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID));

    assertNotNull(baselineServer);

    EndpointLatencyRegistry.clear();

    FakeEndpointCache penalizedEndpointCache = new FakeEndpointCache();
    KeyRangeCache penalizedCache = new KeyRangeCache(penalizedEndpointCache);
    penalizedCache.useDeterministicRandom();
    penalizedCache.addRanges(threeReplicaUpdate());

    penalizedEndpointCache.get("server1");
    penalizedEndpointCache.get("server2");
    penalizedEndpointCache.get("server3");
    penalizedCache.recordReplicaError(TEST_OPERATION_UID, baselineServer.getAddress());

    ChannelEndpoint penalizedSelection =
        penalizedCache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID));

    assertNotNull(penalizedSelection);
    assertTrue(!baselineServer.getAddress().equals(penalizedSelection.getAddress()));
  }

  @Test
  public void preferLeaderFalseIgnoresPreferLeaderTrueScoreBucket() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    cache.useDeterministicRandom();
    cache.addRanges(twoReplicaUpdate());

    endpointCache.get("server1");
    endpointCache.get("server2");

    EndpointLatencyRegistry.recordLatency(
        null, TEST_OPERATION_UID, true, "server2", Duration.ofMillis(1));

    ChannelEndpoint server =
        cache.fillRoutingHint(
            false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")).setOperationUid(TEST_OPERATION_UID));

    assertNotNull(server);
    assertEquals("server1", server.getAddress());
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

  private static final class MutableClock extends Clock {
    private Instant now = Instant.ofEpochSecond(100);

    @Override
    public ZoneId getZone() {
      return ZoneOffset.UTC;
    }

    @Override
    public Clock withZone(ZoneId zone) {
      return this;
    }

    @Override
    public Instant instant() {
      return now;
    }

    private void advance(Duration duration) {
      now = now.plus(duration);
    }
  }

  @Test
  public void staleGenerationGroupUpdateDoesNotOverwriteTablets() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    // Newer generation: dead tablet skip+empty, leader on survivor.
    cache.addRanges(
        CacheUpdate.newBuilder()
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("a"))
                    .setLimitKey(bytes("z"))
                    .setGroupUid(5)
                    .setSplitId(1)
                    .setGeneration(bytes("2")))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(5)
                    .setGeneration(bytes("2"))
                    .setLeaderIndex(1)
                    .addTablets(Tablet.newBuilder().setTabletUid(1).setSkip(true).setDistance(0))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(2)
                            .setServerAddress("survivor")
                            .setIncarnation(bytes("2"))
                            .setDistance(0)))
            .build());

    // Older generation still names the isolated host — must not re-inject it.
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
                            .setServerAddress("isolated-dead")
                            .setIncarnation(bytes("1"))
                            .setDistance(0)
                            .setSkip(false))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(2)
                            .setServerAddress("survivor")
                            .setIncarnation(bytes("1"))
                            .setDistance(0)))
            .build());

    Set<String> active = cache.getActiveAddresses();
    assertTrue("survivor should remain active", active.contains("survivor"));
    assertFalse(
        "stale generation must not re-inject isolated-dead into active addresses: " + active,
        active.contains("isolated-dead"));
  }

  @Test
  public void equalGenerationWithNewerIncarnationRestoresSkippedEmptyTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    addSingleTabletGroup(cache, "1", true, "", "");
    addSingleTabletGroup(cache, "1", false, "recovered", "1");
    endpointCache.get("recovered");

    assertTrue(cache.getActiveAddresses().contains("recovered"));
    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint selected =
        cache.fillRoutingHint(
            /* preferLeader= */ true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);
    assertNotNull(selected);
    assertEquals("recovered", selected.getAddress());
    assertEquals(0, hint.getSkippedTabletUidCount());
  }

  @Test
  public void equalGenerationWithSameIncarnationDoesNotRestoreSkippedEmptyTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    addSingleTabletGroup(cache, "1", true, "", "1");
    addSingleTabletGroup(cache, "1", false, "isolated-dead", "1");

    assertFalse(
        "equal-gen unskip with the same incarnation must remain latched",
        cache.getActiveAddresses().contains("isolated-dead"));
  }

  @Test
  public void equalGenerationWithEmptyIncarnationDoesNotRestoreSkippedEmptyTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    addSingleTabletGroup(cache, "1", true, "", "");
    addSingleTabletGroup(cache, "1", false, "isolated-dead", "");

    assertFalse(
        "equal-gen unskip with an empty incarnation must remain latched",
        cache.getActiveAddresses().contains("isolated-dead"));
  }

  @Test
  public void equalGenerationWithOlderIncarnationDoesNotRestoreSkippedEmptyTablet() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    addSingleTabletGroup(cache, "1", true, "", "2");
    addSingleTabletGroup(cache, "1", false, "isolated-dead", "1");

    assertFalse(
        "equal-gen unskip with an older incarnation must remain latched",
        cache.getActiveAddresses().contains("isolated-dead"));
  }

  @Test
  public void equalGenerationTreatsNonEmptyIncarnationAsNewerThanEmpty() {
    assertTrue(
        restoresSkippedTablet(ByteString.EMPTY, ByteString.copyFrom(new byte[] {(byte) 0x00})));
  }

  @Test
  public void equalGenerationTreatsProperPrefixExtensionAsNewerIncarnation() {
    assertTrue(
        restoresSkippedTablet(
            ByteString.copyFrom(new byte[] {(byte) 0x01}),
            ByteString.copyFrom(new byte[] {(byte) 0x01, (byte) 0x00})));
  }

  @Test
  public void equalGenerationComparesLastIncarnationByteUnsigned() {
    assertTrue(
        restoresSkippedTablet(
            ByteString.copyFrom(new byte[] {(byte) 0x01, (byte) 0x7f}),
            ByteString.copyFrom(new byte[] {(byte) 0x01, (byte) 0x80})));
  }

  @Test
  public void equalGenerationRejectsLongerLexicographicallySmallerIncarnation() {
    assertFalse(
        restoresSkippedTablet(
            ByteString.copyFrom(new byte[] {(byte) 0x02}),
            ByteString.copyFrom(new byte[] {(byte) 0x01, (byte) 0xff})));
  }

  @Test
  public void equalGenerationSkipPreservesIncarnationAndRefusesReplay() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", true, "", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertTrue(cache.getActiveAddresses().isEmpty());
  }

  @Test
  public void equalGenerationSkipPreservesIncarnationAndAcceptsNewerRecovery() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", true, "", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);
    assertTrue(cache.getActiveAddresses().isEmpty());

    addSingleTabletGroup(
        cache, "1", false, "recovered", ByteString.copyFrom(new byte[] {(byte) 0x02}));
    assertTrue(cache.getActiveAddresses().contains("recovered"));
  }

  @Test
  public void equalGenerationRepeatedSkipRoundsDoNotLaunderIncarnation() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    for (int i = 0; i < 3; i++) {
      addSingleTabletGroup(cache, "1", true, "", ByteString.EMPTY);
      addSingleTabletGroup(cache, "1", false, "replayed-" + i, incarnation);
      assertTrue("skip round " + i + " must remain latched", cache.getActiveAddresses().isEmpty());
    }
  }

  @Test
  public void equalGenerationOmissionDoesNotEraseIncarnationHistory() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", true, "", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);
    assertFalse(cache.getActiveAddresses().contains("replayed"));

    addSingleTabletGroup(
        cache, "1", false, "recovered", ByteString.copyFrom(new byte[] {(byte) 0x02}));
    assertTrue(cache.getActiveAddresses().contains("recovered"));
  }

  @Test
  public void equalGenerationOmittedHealthyTabletReappearsAtSameAddress() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);

    assertTrue(cache.getActiveAddresses().contains("healthy"));
  }

  @Test
  public void equalGenerationOmittedHealthyTabletRequiresNewerIncarnationForNewAddress() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);
    assertFalse(cache.getActiveAddresses().contains("replayed"));

    addSingleTabletGroup(
        cache, "1", false, "recovered", ByteString.copyFrom(new byte[] {(byte) 0x02}));
    assertTrue(cache.getActiveAddresses().contains("recovered"));
  }

  @Test
  public void equalGenerationEmptyGroupRefillsAtSameAddress() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addEmptyTabletGroup(cache, "1");
    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);

    assertTrue(cache.getActiveAddresses().contains("healthy"));
  }

  @Test
  public void equalGenerationUnfreshAddressedSkipDoesNotAuthorizeNewAddress() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", true, "replayed", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertNull(selectSingleTablet(cache));

    addSingleTabletGroup(
        cache, "1", false, "replayed", ByteString.copyFrom(new byte[] {(byte) 0x02}));
    ChannelEndpoint selected = selectSingleTablet(cache);
    assertNotNull(selected);
    assertEquals("replayed", selected.getAddress());
  }

  @Test
  public void equalGenerationOmittedTabletUnfreshSkipDoesNotAuthorizeNewAddress() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", true, "replayed", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertNull(selectSingleTablet(cache));
  }

  @Test
  public void equalGenerationEmptyAddressStateDoesNotBypassAddressBaseline() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", true, "replayed", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "", incarnation);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertNull(selectSingleTablet(cache));
  }

  @Test
  public void equalGenerationOmittedTabletEmptyAddressStateDoesNotBypassBaseline() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", true, "replayed", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "", incarnation);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertNull(selectSingleTablet(cache));
  }

  @Test
  public void equalGenerationFreshAddressMoveAdvancesBaseline() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString firstIncarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    ByteString secondIncarnation = ByteString.copyFrom(new byte[] {(byte) 0x02});
    endpointCache.get("healthy");
    endpointCache.get("moved");

    addSingleTabletGroup(cache, "1", false, "healthy", firstIncarnation);
    addSingleTabletGroup(cache, "1", false, "moved", secondIncarnation);
    ChannelEndpoint selected = selectSingleTablet(cache);
    assertNotNull(selected);
    assertEquals("moved", selected.getAddress());

    addSingleTabletGroup(cache, "1", false, "", secondIncarnation);
    addSingleTabletGroup(cache, "1", false, "healthy", firstIncarnation);
    assertNull(selectSingleTablet(cache));

    addSingleTabletGroup(cache, "1", false, "moved", secondIncarnation);
    selected = selectSingleTablet(cache);
    assertNotNull(selected);
    assertEquals("moved", selected.getAddress());
  }

  @Test
  public void equalGenerationFirstAddressDiscoveryDoesNotRequireNewerIncarnation() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("healthy");

    addSingleTabletGroup(cache, "1", false, "old", incarnation);
    addSingleTabletGroup(cache, "2", false, "", incarnation);
    addSingleTabletGroup(cache, "2", false, "healthy", incarnation);

    ChannelEndpoint selected = selectSingleTablet(cache);
    assertNotNull(selected);
    assertEquals("healthy", selected.getAddress());
  }

  @Test
  public void equalGenerationFirstAddressDiscoveryEstablishesAddressBaseline() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("healthy");
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", false, "old", incarnation);
    addSingleTabletGroup(cache, "2", false, "", incarnation);
    addSingleTabletGroup(cache, "2", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "2", false, "replayed", incarnation);

    ChannelEndpoint selected = selectSingleTablet(cache);
    assertNotNull(selected);
    assertEquals("healthy", selected.getAddress());
  }

  @Test
  public void equalGenerationSkippedEmptyStateLatchesFirstAddressFreshness() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", false, "", incarnation);
    addSingleTabletGroup(cache, "1", true, "", incarnation);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertNull(selectSingleTablet(cache));
  }

  @Test
  public void equalGenerationOlderIncarnationCannotSupplyFirstAddress() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", false, "", ByteString.copyFrom(new byte[] {(byte) 0x02}));
    addSingleTabletGroup(
        cache, "1", false, "replayed", ByteString.copyFrom(new byte[] {(byte) 0x01}));

    assertNull(selectSingleTablet(cache));
  }

  @Test
  public void equalGenerationFirstSeenSkippedEmptyTabletRequiresNewerIncarnation() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", true, "", incarnation);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertNull(selectSingleTablet(cache));
  }

  @Test
  public void equalGenerationFirstSeenAddressedSkipCannotChangeAddressWithoutNewerIncarnation() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", true, "skipped", incarnation);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertNull(selectSingleTablet(cache));
  }

  @Test
  public void equalGenerationFirstSeenRoutableTabletEstablishesAddressBaseline() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});
    endpointCache.get("healthy");
    endpointCache.get("replayed");

    addSingleTabletGroup(cache, "1", 2L, false, "other", incarnation);
    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    ChannelEndpoint selected = selectSingleTablet(cache);
    assertNotNull(selected);
    assertEquals("healthy", selected.getAddress());
  }

  @Test
  public void equalGenerationAddressedSkipRefusesSameIncarnationAddressReplacement() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", true, "healthy", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "replayed", incarnation);

    assertFalse(cache.getActiveAddresses().contains("replayed"));
    assertTrue(cache.getActiveAddresses().contains("healthy"));
  }

  @Test
  public void equalGenerationAddressedSkipAllowsSameAddressUnskip() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);
    ByteString incarnation = ByteString.copyFrom(new byte[] {(byte) 0x01});

    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    addSingleTabletGroup(cache, "1", true, "healthy", ByteString.EMPTY);
    addSingleTabletGroup(cache, "1", false, "healthy", incarnation);
    endpointCache.get("healthy");

    ChannelEndpoint selected =
        cache.fillRoutingHint(
            /* preferLeader= */ true,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            RoutingHint.newBuilder().setKey(bytes("a")));
    assertNotNull(selected);
    assertEquals("healthy", selected.getAddress());
  }

  @Test
  public void equalGenerationNewerSkippedIncarnationRatchetsHistory() {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());

    addSingleTabletGroup(
        cache, "1", false, "healthy", ByteString.copyFrom(new byte[] {(byte) 0x01}));
    addSingleTabletGroup(cache, "1", true, "", ByteString.copyFrom(new byte[] {(byte) 0x02}));
    addSingleTabletGroup(
        cache, "1", false, "replayed", ByteString.copyFrom(new byte[] {(byte) 0x02}));
    assertTrue(cache.getActiveAddresses().isEmpty());

    addSingleTabletGroup(
        cache, "1", false, "recovered", ByteString.copyFrom(new byte[] {(byte) 0x03}));
    assertTrue(cache.getActiveAddresses().contains("recovered"));
  }

  // --- Helper methods ---

  private static boolean restoresSkippedTablet(
      ByteString previousIncarnation, ByteString incomingIncarnation) {
    KeyRangeCache cache = new KeyRangeCache(new FakeEndpointCache());
    addSingleTabletGroup(cache, "1", true, "", previousIncarnation);
    addSingleTabletGroup(cache, "1", false, "recovered", incomingIncarnation);
    return cache.getActiveAddresses().contains("recovered");
  }

  private static ChannelEndpoint selectSingleTablet(KeyRangeCache cache) {
    return cache.fillRoutingHint(
        /* preferLeader= */ true,
        KeyRangeCache.RangeMode.COVERING_SPLIT,
        DirectedReadOptions.getDefaultInstance(),
        RoutingHint.newBuilder().setKey(bytes("a")));
  }

  private static void addSingleTabletGroup(
      KeyRangeCache cache,
      String generation,
      boolean skip,
      String serverAddress,
      String incarnation) {
    addSingleTabletGroup(cache, generation, skip, serverAddress, bytes(incarnation));
  }

  private static void addSingleTabletGroup(
      KeyRangeCache cache,
      String generation,
      boolean skip,
      String serverAddress,
      ByteString incarnation) {
    addSingleTabletGroup(cache, generation, 1L, skip, serverAddress, incarnation);
  }

  private static void addSingleTabletGroup(
      KeyRangeCache cache,
      String generation,
      long tabletUid,
      boolean skip,
      String serverAddress,
      ByteString incarnation) {
    cache.addRanges(
        CacheUpdate.newBuilder()
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("a"))
                    .setLimitKey(bytes("z"))
                    .setGroupUid(5)
                    .setSplitId(1)
                    .setGeneration(bytes(generation)))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(5)
                    .setGeneration(bytes(generation))
                    .setLeaderIndex(0)
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(tabletUid)
                            .setServerAddress(serverAddress)
                            .setIncarnation(incarnation)
                            .setDistance(0)
                            .setSkip(skip)))
            .build());
  }

  private static void addEmptyTabletGroup(KeyRangeCache cache, String generation) {
    cache.addRanges(
        CacheUpdate.newBuilder()
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("a"))
                    .setLimitKey(bytes("z"))
                    .setGroupUid(5)
                    .setSplitId(1)
                    .setGeneration(bytes(generation)))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(5)
                    .setGeneration(bytes(generation))
                    .setLeaderIndex(0))
            .build());
  }

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
    private final AtomicInteger activeRequests = new AtomicInteger();
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

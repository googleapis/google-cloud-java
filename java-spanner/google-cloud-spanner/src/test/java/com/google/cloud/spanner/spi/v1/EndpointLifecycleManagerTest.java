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

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;
import java.util.function.BooleanSupplier;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EndpointLifecycleManagerTest {

  private EndpointLifecycleManager manager;

  /** Counter for generating unique finder keys in tests. */
  private static final AtomicLong TEST_FINDER_ID = new AtomicLong(1000);

  @After
  public void tearDown() {
    if (manager != null) {
      manager.shutdown();
    }
  }

  /**
   * Registers addresses with the lifecycle manager via updateActiveAddresses, which atomically
   * creates endpoints and registers them as active. This mirrors how ChannelFinder.update() works.
   */
  private static String registerAddresses(EndpointLifecycleManager mgr, String... addresses) {
    String finderId = "finder-" + TEST_FINDER_ID.incrementAndGet();
    Set<String> addressSet = new HashSet<>();
    Collections.addAll(addressSet, addresses);
    mgr.updateActiveAddresses(finderId, addressSet);
    return finderId;
  }

  private static void awaitCondition(String message, BooleanSupplier condition) {
    long deadlineNanos = System.nanoTime() + TimeUnit.SECONDS.toNanos(5);
    while (System.nanoTime() < deadlineNanos) {
      if (condition.getAsBoolean()) {
        return;
      }
      LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10));
    }
    assertTrue(message, condition.getAsBoolean());
  }

  @Test
  public void endpointCreationStartsProbing() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 1, Duration.ofMinutes(30), Clock.systemUTC());

    registerAddresses(manager, "server1");
    awaitCondition(
        "endpoint should be created in background", () -> cache.getIfPresent("server1") != null);

    // Endpoint should be created in the cache.
    assertNotNull(cache.getIfPresent("server1"));

    // Should be managed.
    assertTrue(manager.isManaged("server1"));
    assertNotNull(manager.getEndpointState("server1"));
    assertEquals(1, manager.managedEndpointCount());
  }

  @Test
  public void duplicateRegistrationIsNoop() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    String finderId = registerAddresses(manager, "server1");
    // Re-register with the same finder ID — should not create duplicate state.
    manager.updateActiveAddresses(finderId, Collections.singleton("server1"));
    manager.updateActiveAddresses(finderId, Collections.singleton("server1"));

    assertEquals(1, manager.managedEndpointCount());
  }

  @Test
  public void defaultEndpointIsNotManaged() {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    registerAddresses(manager, "default");

    assertFalse(manager.isManaged("default"));
    assertEquals(0, manager.managedEndpointCount());
  }

  @Test
  public void probeTrafficDoesNotUpdateLastRealTrafficAt() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    TestClock clock = new TestClock(Instant.now());
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 1, Duration.ofMinutes(30), clock);

    Instant creationTime = clock.instant();
    registerAddresses(manager, "server1");
    awaitCondition(
        "probe should run after background endpoint creation",
        () -> {
          EndpointLifecycleManager.EndpointState state = manager.getEndpointState("server1");
          return state != null && state.lastProbeAt != null;
        });

    // Probe traffic should not change lastRealTrafficAt.
    EndpointLifecycleManager.EndpointState state = manager.getEndpointState("server1");
    assertNotNull(state);
    assertEquals(creationTime, state.lastRealTrafficAt);
  }

  @Test
  public void realRoutedTrafficUpdatesLastRealTrafficAt() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    TestClock clock = new TestClock(Instant.now());
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), clock);

    registerAddresses(manager, "server1");

    Instant before = clock.instant();
    clock.advance(Duration.ofMinutes(5));
    manager.recordRealTraffic("server1");

    EndpointLifecycleManager.EndpointState state = manager.getEndpointState("server1");
    assertNotNull(state);
    assertTrue(state.lastRealTrafficAt.isAfter(before));
  }

  @Test
  public void endpointWithOnlyProbeTrafficIsEvictedAfterIdleDuration() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    TestClock clock = new TestClock(Instant.now());
    Duration idleDuration = Duration.ofMinutes(30);
    manager =
        new EndpointLifecycleManager(cache, /* probeIntervalSeconds= */ 60, idleDuration, clock);

    registerAddresses(manager, "server1");
    awaitCondition(
        "endpoint should be created in background", () -> cache.getIfPresent("server1") != null);

    assertTrue(manager.isManaged("server1"));

    // Advance past idle threshold.
    clock.advance(Duration.ofMinutes(31));

    // Trigger eviction check manually.
    manager.checkIdleEviction();

    // Endpoint should be evicted.
    assertFalse(manager.isManaged("server1"));
    assertNull(cache.getIfPresent("server1"));
    assertEquals(0, manager.managedEndpointCount());
  }

  @Test
  public void endpointWithRecentRealTrafficIsNotEvicted() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    TestClock clock = new TestClock(Instant.now());
    Duration idleDuration = Duration.ofMinutes(30);
    manager =
        new EndpointLifecycleManager(cache, /* probeIntervalSeconds= */ 60, idleDuration, clock);

    registerAddresses(manager, "server1");

    // Record real traffic at 20 minutes.
    clock.advance(Duration.ofMinutes(20));
    manager.recordRealTraffic("server1");

    // Advance to 31 minutes (only 11 minutes since last real traffic).
    clock.advance(Duration.ofMinutes(11));
    manager.checkIdleEviction();

    // Should NOT be evicted because last real traffic was 11 minutes ago.
    assertTrue(manager.isManaged("server1"));
  }

  @Test
  public void evictedEndpointIsRecreatedOnDemand() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    TestClock clock = new TestClock(Instant.now());
    Duration idleDuration = Duration.ofMinutes(30);
    manager =
        new EndpointLifecycleManager(cache, /* probeIntervalSeconds= */ 60, idleDuration, clock);

    registerAddresses(manager, "server1");
    awaitCondition(
        "endpoint should be created in background", () -> cache.getIfPresent("server1") != null);

    // Evict.
    clock.advance(Duration.ofMinutes(31));
    manager.checkIdleEviction();
    assertFalse(manager.isManaged("server1"));

    // Recreate.
    manager.requestEndpointRecreation("server1");
    awaitCondition(
        "endpoint should be recreated in background", () -> cache.getIfPresent("server1") != null);

    assertTrue(manager.isManaged("server1"));
    assertNotNull(cache.getIfPresent("server1"));
  }

  @Test
  public void transientFailureEvictionTrackedUntilEndpointReadyAgain() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 1, Duration.ofMinutes(30), Clock.systemUTC());

    registerAddresses(manager, "server1");
    awaitCondition(
        "endpoint should be created in background", () -> cache.getIfPresent("server1") != null);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    awaitCondition(
        "endpoint should be evicted after repeated transient failures",
        () ->
            !manager.isManaged("server1")
                && manager.wasRecentlyEvictedTransientFailure("server1")
                && cache.getIfPresent("server1") == null);

    manager.requestEndpointRecreation("server1");
    awaitCondition(
        "endpoint should be recreated in background", () -> cache.getIfPresent("server1") != null);
    awaitCondition(
        "recent transient failure marker should clear once endpoint is READY again",
        () -> !manager.wasRecentlyEvictedTransientFailure("server1"));
  }

  @Test
  public void transientFailureOscillationWithConnectingStillEvictsEndpoint() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    registerAddresses(manager, "server1");
    awaitCondition(
        "endpoint should be created in background", () -> cache.getIfPresent("server1") != null);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    manager.probe("server1");
    assertEquals(1, manager.getEndpointState("server1").consecutiveTransientFailures);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.CONNECTING);
    manager.probe("server1");
    assertEquals(1, manager.getEndpointState("server1").consecutiveTransientFailures);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    manager.probe("server1");
    assertEquals(2, manager.getEndpointState("server1").consecutiveTransientFailures);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.CONNECTING);
    manager.probe("server1");
    assertEquals(2, manager.getEndpointState("server1").consecutiveTransientFailures);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    manager.probe("server1");

    assertFalse(manager.isManaged("server1"));
    assertTrue(manager.wasRecentlyEvictedTransientFailure("server1"));
    assertNull(cache.getIfPresent("server1"));
  }

  @Test
  public void readyResetsTransientFailureCounterAfterRecovery() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    registerAddresses(manager, "server1");
    awaitCondition(
        "endpoint should be created in background", () -> cache.getIfPresent("server1") != null);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    manager.probe("server1");
    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.CONNECTING);
    manager.probe("server1");
    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    manager.probe("server1");
    assertEquals(2, manager.getEndpointState("server1").consecutiveTransientFailures);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.READY);
    manager.probe("server1");
    EndpointLifecycleManager.EndpointState state = manager.getEndpointState("server1");
    assertNotNull(state);
    assertEquals(0, state.consecutiveTransientFailures);
    assertNotNull(state.lastReadyAt);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    manager.probe("server1");
    assertEquals(1, manager.getEndpointState("server1").consecutiveTransientFailures);
    assertTrue(manager.isManaged("server1"));
  }

  @Test
  public void transientFailureEvictionMarkerRemovedWhenAddressNoLongerActive() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 1, Duration.ofMinutes(30), Clock.systemUTC());

    String finder = registerAddresses(manager, "server1");
    awaitCondition(
        "endpoint should be created in background", () -> cache.getIfPresent("server1") != null);

    cache.setState("server1", KeyRangeCacheTest.EndpointHealthState.TRANSIENT_FAILURE);
    awaitCondition(
        "endpoint should be evicted after repeated transient failures",
        () ->
            !manager.isManaged("server1") && manager.wasRecentlyEvictedTransientFailure("server1"));

    manager.updateActiveAddresses(finder, Collections.emptySet());

    assertFalse(manager.wasRecentlyEvictedTransientFailure("server1"));
  }

  @Test
  public void shutdownStopsAllProbing() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 1, Duration.ofMinutes(30), Clock.systemUTC());

    registerAddresses(manager, "server1", "server2");

    assertEquals(2, manager.managedEndpointCount());

    manager.shutdown();

    assertEquals(0, manager.managedEndpointCount());
  }

  @Test
  public void emptyOrNullAddressIsIgnored() {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    manager.updateActiveAddresses("finder-1", Collections.singleton(""));
    manager.updateActiveAddresses("finder-2", Collections.emptySet());

    assertEquals(0, manager.managedEndpointCount());
  }

  @Test
  public void recordRealTrafficForDefaultEndpointIsIgnored() {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    // Should not throw or create state.
    manager.recordRealTraffic("default");
    manager.recordRealTraffic(null);
    assertEquals(0, manager.managedEndpointCount());
  }

  @Test
  public void staleEndpointEvictedWhenNoLongerActive() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    // Finder 1 reports server1 and server2.
    String finder1 = registerAddresses(manager, "server1", "server2");
    assertEquals(2, manager.managedEndpointCount());

    // Finder 1 updates: server1 is gone, only server2 remains.
    manager.updateActiveAddresses(finder1, Collections.singleton("server2"));

    // server1 should be evicted since no finder references it.
    assertFalse(manager.isManaged("server1"));
    assertTrue(manager.isManaged("server2"));
    assertEquals(1, manager.managedEndpointCount());
  }

  @Test
  public void endpointKeptIfReferencedByAnotherFinder() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    // Finder 1 reports server1.
    String finder1 = registerAddresses(manager, "server1");
    // Finder 2 also reports server1.
    registerAddresses(manager, "server1");

    // Finder 1 drops server1, but finder 2 still references it.
    manager.updateActiveAddresses(finder1, Collections.emptySet());

    assertTrue(manager.isManaged("server1"));
    assertEquals(1, manager.managedEndpointCount());
  }

  @Test
  public void unregisterFinderEvictsEndpointsNoLongerReferenced() throws Exception {
    KeyRangeCacheTest.FakeEndpointCache cache = new KeyRangeCacheTest.FakeEndpointCache();
    manager =
        new EndpointLifecycleManager(
            cache, /* probeIntervalSeconds= */ 60, Duration.ofMinutes(30), Clock.systemUTC());

    String finder1 = registerAddresses(manager, "server1");
    String finder2 = registerAddresses(manager, "server2");

    manager.unregisterFinder(finder1);

    assertFalse(manager.isManaged("server1"));
    assertTrue(manager.isManaged("server2"));
    assertEquals(1, manager.managedEndpointCount());

    manager.unregisterFinder(finder2);

    assertEquals(0, manager.managedEndpointCount());
  }

  /** Test clock that can be advanced manually. */
  private static final class TestClock extends Clock {
    private Instant now;

    TestClock(Instant now) {
      this.now = now;
    }

    void advance(Duration duration) {
      now = now.plus(duration);
    }

    @Override
    public Instant instant() {
      return now;
    }

    @Override
    public ZoneId getZone() {
      return ZoneId.of("UTC");
    }

    @Override
    public Clock withZone(ZoneId zone) {
      return this;
    }
  }
}

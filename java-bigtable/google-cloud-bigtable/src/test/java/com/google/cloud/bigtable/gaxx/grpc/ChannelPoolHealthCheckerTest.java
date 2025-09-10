/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.gaxx.grpc;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.cloud.bigtable.data.v2.stub.BigtableChannelPrimer;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelPool.Entry;
import com.google.cloud.bigtable.gaxx.grpc.ChannelPoolHealthChecker.ProbeResult;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.testing.TestingExecutors;
import io.grpc.ManagedChannel;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class ChannelPoolHealthCheckerTest {
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
  @Mock private BigtableChannelPrimer mockPrimer;
  private ListeningScheduledExecutorService executor;
  @Mock private Clock mockClock;
  private ChannelPoolHealthChecker healthChecker;
  private List<Entry> channelList;

  @Before
  public void setUp() {
    executor = TestingExecutors.sameThreadScheduledExecutor();
    channelList = new ArrayList<>();
    Supplier<ImmutableList<Entry>> entrySupplier = () -> ImmutableList.copyOf(channelList);

    healthChecker = new ChannelPoolHealthChecker(entrySupplier, mockPrimer, executor, mockClock);

    // Default the clock to a fixed time
    Mockito.when(mockClock.instant()).thenReturn(Instant.parse("2025-08-01T10:00:00Z"));
  }

  // Helper method to create test entries
  private Entry createTestEntry() {
    ManagedChannel mockChannel = Mockito.mock(ManagedChannel.class);
    return new Entry(mockChannel);
  }

  @After
  public void tearDown() {
    executor.shutdownNow();
  }

  @Test
  public void testOnComplete_successUpdatesCounters() {
    Entry entry = createTestEntry();
    channelList.add(entry);

    SettableApiFuture<PingAndWarmResponse> successFuture = SettableApiFuture.create();
    Mockito.when(mockPrimer.sendPrimeRequestsAsync(entry.getManagedChannel()))
        .thenReturn(successFuture);

    healthChecker.runProbes();

    successFuture.set(PingAndWarmResponse.getDefaultInstance());

    assertThat(entry.successfulProbesInWindow.get()).isEqualTo(1);
    assertThat(entry.failedProbesInWindow.get()).isEqualTo(0);
  }

  @Test
  public void testOnComplete_cancellationIsFailure() {
    Entry entry = createTestEntry();
    channelList.add(entry);

    SettableApiFuture<PingAndWarmResponse> hangingFuture = SettableApiFuture.create();
    Mockito.when(mockPrimer.sendPrimeRequestsAsync(entry.getManagedChannel()))
        .thenReturn(hangingFuture);

    healthChecker.runProbes();

    hangingFuture.cancel(true);

    assertThat(entry.failedProbesInWindow.get()).isEqualTo(1);
    assertThat(entry.successfulProbesInWindow.get()).isEqualTo(0);
  }

  @Test
  public void testPruning_removesOldProbesAndCounters() {
    Entry entry = createTestEntry();
    healthChecker.addProbeResult(entry, ProbeResult.create(mockClock.instant(), false));
    assertThat(entry.failedProbesInWindow.get()).isEqualTo(1);

    Instant newTime = mockClock.instant().plus(Duration.ofMinutes(6));
    Mockito.when(mockClock.instant()).thenReturn(newTime);
    healthChecker.pruneHistory(entry); // Manually call for direct testing

    assertThat(entry.probeHistory).isEmpty();
    assertThat(entry.failedProbesInWindow.get()).isEqualTo(0);
  }

  @Test
  public void testEviction_selectsUnhealthyChannel() {
    Entry healthyEntry = createTestEntry();
    Entry badEntry = createTestEntry();
    Entry worseEntry = createTestEntry();

    // A channel needs at least 4 probes to be considered for eviction
    healthyEntry.successfulProbesInWindow.set(10); // 0% failure -> healthy
    badEntry.failedProbesInWindow.set(3); // 3/13 = 23% failure -> healthy
    badEntry.successfulProbesInWindow.set(10);
    worseEntry.failedProbesInWindow.set(10); // 10/10 = 100% failure -> unhealthy

    channelList.addAll(Arrays.asList(healthyEntry, badEntry, worseEntry));

    healthChecker.detectAndRemoveOutlierEntries();

    // Assert that only the unhealthy channel was evicted
    Mockito.verify(worseEntry.getManagedChannel()).enterIdle();
    Mockito.verify(badEntry.getManagedChannel(), Mockito.never()).enterIdle();
    Mockito.verify(healthyEntry.getManagedChannel(), Mockito.never()).enterIdle();
  }

  @Test
  public void testEviction_selectsMostUnhealthyChannel() {
    Entry healthyEntry = createTestEntry();
    Entry badEntry = createTestEntry();
    Entry worseEntry = createTestEntry();

    // A channel needs at least 4 probes to be considered for eviction
    healthyEntry.successfulProbesInWindow.set(10); // 0% failure -> healthy
    badEntry.failedProbesInWindow.set(8); // 8/13 = 61% failure -> unhealthy
    badEntry.successfulProbesInWindow.set(10);
    worseEntry.failedProbesInWindow.set(10); // 10/10 = 100% failure -> most unhealthy

    channelList.addAll(Arrays.asList(healthyEntry, badEntry, worseEntry));

    healthChecker.detectAndRemoveOutlierEntries();

    // Assert that only the unhealthy channel was evicted
    Mockito.verify(worseEntry.getManagedChannel()).enterIdle();
    Mockito.verify(badEntry.getManagedChannel(), Mockito.never()).enterIdle();
    Mockito.verify(healthyEntry.getManagedChannel(), Mockito.never()).enterIdle();
  }

  @Test
  public void testCircuitBreaker_preventsEviction() {
    Entry entry1 = createTestEntry();
    Entry entry2 = createTestEntry();
    Entry entry3 = createTestEntry();
    channelList.addAll(Arrays.asList(entry1, entry2, entry3));

    // Set failure counts to exceed 60% SINGLE_CHANNEL_FAILURE_PERCENT_THRESHOLD with at least
    // MIN_PROBES_FOR_EVALUATION (4) failures
    for (Entry entry : channelList) {
      entry.failedProbesInWindow.set(4); // 4 failures, 0 successes = 100% failure rate
    }

    healthChecker.detectAndRemoveOutlierEntries();

    // The circuit breaker should engage because 3/3 channels (100%) are unhealthy,
    // which is greater than the 70% POOLWIDE_BAD_CHANNEL_CIRCUITBREAKER_PERCENT threshold.
    Mockito.verify(entry1.getManagedChannel(), Mockito.never()).enterIdle();
    Mockito.verify(entry2.getManagedChannel(), Mockito.never()).enterIdle();
    Mockito.verify(entry3.getManagedChannel(), Mockito.never()).enterIdle();
  }
}

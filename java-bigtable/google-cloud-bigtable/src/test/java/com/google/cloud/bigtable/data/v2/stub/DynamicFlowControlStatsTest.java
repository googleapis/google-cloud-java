/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiClock;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class DynamicFlowControlStatsTest {

  @Rule public final MockitoRule rule = MockitoJUnit.rule();

  @Mock private ApiClock clock;

  @Test
  public void testUpdate() {

    Mockito.when(clock.millisTime()).thenReturn(0L);
    DynamicFlowControlStats stats = new DynamicFlowControlStats(0.015, clock);
    stats.updateLatency(10);
    assertThat(stats.getMeanLatency()).isEqualTo(10);
    stats.updateLatency(10);
    stats.updateLatency(10);
    assertThat(stats.getMeanLatency()).isEqualTo(10);

    // In five minutes the previous latency should be decayed to under 1. And the new average should
    // be very close to 20
    Mockito.when(clock.millisTime()).thenReturn(TimeUnit.MINUTES.toMillis(5));
    stats.updateLatency(20);
    assertThat(stats.getMeanLatency()).isGreaterThan(19);
    assertThat(stats.getMeanLatency()).isLessThan(20);

    // After a day
    long aDay = TimeUnit.DAYS.toMillis(1);
    for (int i = 0; i < 10; i++) {
      Mockito.when(clock.millisTime()).thenReturn(aDay + TimeUnit.SECONDS.toMillis(i));
      stats.updateLatency(i);
    }
    assertThat(stats.getMeanLatency()).isGreaterThan(4.5);
    assertThat(stats.getMeanLatency()).isLessThan(6);
  }

  @Test(timeout = 1000)
  public void testConcurrentUpdates() throws InterruptedException, ExecutionException {
    final DynamicFlowControlStats stats = new DynamicFlowControlStats();
    ExecutorService executor = Executors.newCachedThreadPool();
    List<Future<?>> futures = new LinkedList<>();
    for (int i = 1; i <= 50; i++) {
      final long latency = i;
      Runnable r =
          new Runnable() {
            @Override
            public void run() {
              stats.updateLatency(latency);
            }
          };
      futures.add(executor.submit(r));
    }
    for (Future f : futures) {
      f.get();
    }
    // Mean should be around 50 / 2 = 25
    assertThat(stats.getMeanLatency()).isGreaterThan(20);
    assertThat(stats.getMeanLatency()).isLessThan(30);
  }
}

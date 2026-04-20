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

import com.google.common.base.Ticker;
import com.google.common.testing.FakeTicker;
import io.grpc.ManagedChannel;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EndpointLatencyRegistryTest {
  private static final String DATABASE_SCOPE = "projects/p/instances/i/databases/d";

  private static final class TestEndpoint implements ChannelEndpoint {
    private final AtomicInteger activeRequests = new AtomicInteger();

    @Override
    public String getAddress() {
      return "test";
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
      return null;
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

  @After
  public void tearDown() {
    EndpointLatencyRegistry.useTrackerTicker(Ticker.systemTicker());
    EndpointLatencyRegistry.clear();
  }

  @Test
  public void trackersExpireAfterAccessWindow() {
    FakeTicker ticker = new FakeTicker();
    EndpointLatencyRegistry.useTrackerTicker(ticker);

    EndpointLatencyRegistry.recordLatency(
        DATABASE_SCOPE, 101L, false, "server-a:1234", Duration.ofMillis(5));

    assertThat(EndpointLatencyRegistry.hasScore(DATABASE_SCOPE, 101L, false, "server-a:1234"))
        .isTrue();

    ticker.advance(
        EndpointLatencyRegistry.TRACKER_EXPIRE_AFTER_ACCESS.toNanos() + 1L, TimeUnit.NANOSECONDS);

    assertThat(EndpointLatencyRegistry.hasScore(DATABASE_SCOPE, 101L, false, "server-a:1234"))
        .isFalse();
  }

  @Test
  public void accessKeepsTrackerAliveWithinExpiryWindow() {
    FakeTicker ticker = new FakeTicker();
    EndpointLatencyRegistry.useTrackerTicker(ticker);

    EndpointLatencyRegistry.recordLatency(
        DATABASE_SCOPE, 202L, false, "server-b:1234", Duration.ofMillis(7));

    ticker.advance(
        EndpointLatencyRegistry.TRACKER_EXPIRE_AFTER_ACCESS.toNanos() / 2L, TimeUnit.NANOSECONDS);
    assertThat(
            EndpointLatencyRegistry.getSelectionCost(DATABASE_SCOPE, 202L, false, "server-b:1234"))
        .isGreaterThan(0.0);

    ticker.advance(
        EndpointLatencyRegistry.TRACKER_EXPIRE_AFTER_ACCESS.toNanos() / 2L, TimeUnit.NANOSECONDS);

    assertThat(EndpointLatencyRegistry.hasScore(DATABASE_SCOPE, 202L, false, "server-b:1234"))
        .isTrue();
  }

  @Test
  public void trackersAreIsolatedByDatabaseScope() {
    EndpointLatencyRegistry.recordLatency(
        "projects/p1/instances/i1/databases/d1",
        303L,
        false,
        "server-a:1234",
        Duration.ofMillis(9));

    assertThat(
            EndpointLatencyRegistry.hasScore(
                "projects/p1/instances/i1/databases/d1", 303L, false, "server-a:1234"))
        .isTrue();
    assertThat(
            EndpointLatencyRegistry.hasScore(
                "projects/p2/instances/i2/databases/d2", 303L, false, "server-a:1234"))
        .isFalse();
  }

  @Test
  public void trackersAreIsolatedByPreferLeader() {
    EndpointLatencyRegistry.recordLatency(
        DATABASE_SCOPE, 404L, true, "server-a:1234", Duration.ofMillis(9));

    assertThat(EndpointLatencyRegistry.hasScore(DATABASE_SCOPE, 404L, true, "server-a:1234"))
        .isTrue();
    assertThat(EndpointLatencyRegistry.hasScore(DATABASE_SCOPE, 404L, false, "server-a:1234"))
        .isFalse();
  }

  @Test
  public void inflightCountDoesNotGoNegativeAndCanBeReusedAfterZero() {
    TestEndpoint endpoint = new TestEndpoint();
    endpoint.incrementActiveRequests();
    assertThat(endpoint.getActiveRequestCount()).isEqualTo(1);

    endpoint.decrementActiveRequests();
    assertThat(endpoint.getActiveRequestCount()).isEqualTo(0);

    endpoint.decrementActiveRequests();
    assertThat(endpoint.getActiveRequestCount()).isEqualTo(0);

    endpoint.incrementActiveRequests();
    assertThat(endpoint.getActiveRequestCount()).isEqualTo(1);
  }
}

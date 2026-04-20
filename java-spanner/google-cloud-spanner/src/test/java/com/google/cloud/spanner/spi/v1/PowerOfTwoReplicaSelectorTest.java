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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PowerOfTwoReplicaSelectorTest {

  private static class TestEndpoint implements ChannelEndpoint {
    private final String address;
    private double score = Double.MAX_VALUE;

    TestEndpoint(String address) {
      this.address = address;
    }

    void setScore(double score) {
      this.score = score;
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
    public io.grpc.ManagedChannel getChannel() {
      return null;
    }

    @Override
    public LatencyTracker getLatencyTracker() {
      return new LatencyTracker() {
        @Override
        public double getScore() {
          return score;
        }

        @Override
        public void update(java.time.Duration latency) {}

        @Override
        public void recordError(java.time.Duration penalty) {}
      };
    }
  }

  @Test
  public void testEmptyList() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    assertNull(selector.select(null));
    assertNull(selector.select(Arrays.asList()));
  }

  @Test
  public void testSingleElement() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    ChannelEndpoint endpoint = new TestEndpoint("a");
    assertEquals(endpoint, selector.select(Arrays.asList(endpoint)));
  }

  @Test
  public void testTwoElementsPicksBetter() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    TestEndpoint better = new TestEndpoint("better");
    better.setScore(10.0);
    TestEndpoint worse = new TestEndpoint("worse");
    worse.setScore(20.0);

    List<ChannelEndpoint> candidates = Arrays.asList(better, worse);

    for (int i = 0; i < 100; i++) {
      assertEquals(better, selector.select(candidates));
    }
  }

  @Test
  public void testThreeElementsNeverPicksWorst() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    TestEndpoint best = new TestEndpoint("best");
    best.setScore(10.0);
    TestEndpoint middle = new TestEndpoint("middle");
    middle.setScore(20.0);
    TestEndpoint worst = new TestEndpoint("worst");
    worst.setScore(30.0);

    List<ChannelEndpoint> candidates = Arrays.asList(best, middle, worst);

    for (int i = 0; i < 100; i++) {
      ChannelEndpoint selected = selector.select(candidates);
      assertTrue("Should not pick worst", selected != worst);
    }
  }

  @Test
  public void testMissingScoresTreatedAsMax() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    TestEndpoint withScore = new TestEndpoint("withScore");
    withScore.setScore(100.0);
    TestEndpoint withoutScore = new TestEndpoint("withoutScore");
    // withoutScore has default Double.MAX_VALUE score

    List<ChannelEndpoint> candidates = Arrays.asList(withScore, withoutScore);

    for (int i = 0; i < 100; i++) {
      assertEquals(withScore, selector.select(candidates));
    }
  }

  @Test
  public void testNullTrackerTreatedAsMax() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    TestEndpoint withScore = new TestEndpoint("withScore");
    withScore.setScore(100.0);
    ChannelEndpoint withoutTracker =
        new ChannelEndpoint() {
          @Override
          public String getAddress() {
            return "withoutTracker";
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
          public io.grpc.ManagedChannel getChannel() {
            return null;
          }
        };

    List<ChannelEndpoint> candidates = Arrays.asList(withScore, withoutTracker);

    for (int i = 0; i < 100; i++) {
      assertEquals(withScore, selector.select(candidates));
    }
  }
}

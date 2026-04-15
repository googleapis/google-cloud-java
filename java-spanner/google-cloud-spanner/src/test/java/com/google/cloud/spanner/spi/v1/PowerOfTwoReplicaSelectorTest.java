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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PowerOfTwoReplicaSelectorTest {

  private static class TestEndpoint implements ChannelEndpoint {
    private final String address;

    TestEndpoint(String address) {
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
    public io.grpc.ManagedChannel getChannel() {
      return null;
    }
  }

  @Test
  public void testEmptyList() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    assertNull(selector.select(null, endpoint -> 1.0));
    assertNull(selector.select(Arrays.asList(), endpoint -> 1.0));
  }

  @Test
  public void testSingleElement() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    ChannelEndpoint endpoint = new TestEndpoint("a");
    assertEquals(endpoint, selector.select(Arrays.asList(endpoint), e -> 1.0));
  }

  @Test
  public void testTwoElementsPicksBetter() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    ChannelEndpoint better = new TestEndpoint("better");
    ChannelEndpoint worse = new TestEndpoint("worse");

    Map<ChannelEndpoint, Double> scores = new HashMap<>();
    scores.put(better, 10.0);
    scores.put(worse, 20.0);

    List<ChannelEndpoint> candidates = Arrays.asList(better, worse);

    for (int i = 0; i < 100; i++) {
      assertEquals(better, selector.select(candidates, scores::get));
    }
  }

  @Test
  public void testThreeElementsNeverPicksWorst() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    ChannelEndpoint best = new TestEndpoint("best");
    ChannelEndpoint middle = new TestEndpoint("middle");
    ChannelEndpoint worst = new TestEndpoint("worst");

    Map<ChannelEndpoint, Double> scores = new HashMap<>();
    scores.put(best, 10.0);
    scores.put(middle, 20.0);
    scores.put(worst, 30.0);

    List<ChannelEndpoint> candidates = Arrays.asList(best, middle, worst);

    for (int i = 0; i < 100; i++) {
      ChannelEndpoint selected = selector.select(candidates, scores::get);
      assertTrue("Should not pick worst", selected != worst);
    }
  }

  @Test
  public void testNullScoresTreatedAsMax() {
    PowerOfTwoReplicaSelector selector = new PowerOfTwoReplicaSelector();
    ChannelEndpoint withScore = new TestEndpoint("withScore");
    ChannelEndpoint withoutScore = new TestEndpoint("withoutScore");

    Map<ChannelEndpoint, Double> scores = new HashMap<>();
    scores.put(withScore, 100.0);

    List<ChannelEndpoint> candidates = Arrays.asList(withScore, withoutScore);

    for (int i = 0; i < 100; i++) {
      assertEquals(withScore, selector.select(candidates, scores::get));
    }
  }
}

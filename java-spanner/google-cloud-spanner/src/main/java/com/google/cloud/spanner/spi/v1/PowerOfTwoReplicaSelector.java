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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/** Implementation of {@link ReplicaSelector} using the "Power of 2 Random Choices" strategy. */
@InternalApi
@BetaApi
public class PowerOfTwoReplicaSelector implements ReplicaSelector {

  @Override
  public ChannelEndpoint select(List<ChannelEndpoint> candidates) {
    if (candidates == null || candidates.isEmpty()) {
      return null;
    }
    if (candidates.size() == 1) {
      return candidates.get(0);
    }

    Random random = ThreadLocalRandom.current();
    int index1 = random.nextInt(candidates.size());
    int index2 = random.nextInt(candidates.size() - 1);
    if (index2 >= index1) {
      index2++;
    }

    ChannelEndpoint c1 = candidates.get(index1);
    ChannelEndpoint c2 = candidates.get(index2);

    LatencyTracker t1 = c1.getLatencyTracker();
    LatencyTracker t2 = c2.getLatencyTracker();

    double s1 = t1 != null ? t1.getScore() : Double.MAX_VALUE;
    double s2 = t2 != null ? t2.getScore() : Double.MAX_VALUE;

    return s1 <= s2 ? c1 : c2;
  }
}

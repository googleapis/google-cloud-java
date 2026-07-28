/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.bigtable.v2.LoadBalancingOptions;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.AfeHandle;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.SessionHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/** Pick the AFE with the fewest in-flight requests. */
class LeastInFlightPicker extends Picker {
  private final SessionList sessionList;
  private final LoadBalancingOptions.LeastInFlight options;

  public LeastInFlightPicker(SessionList sessionList, LoadBalancingOptions.LeastInFlight options) {
    this.sessionList = sessionList;
    this.options = options;
  }

  @Override
  Optional<SessionHandle> pickSession() {
    List<AfeHandle> readyAfes = sessionList.getAfesWithReadySessions();
    if (readyAfes.isEmpty()) {
      return Optional.empty();
    }

    ThreadLocalRandom rng = ThreadLocalRandom.current();
    List<AfeHandle> candidates = new ArrayList<>(readyAfes);
    int bestCost = Integer.MAX_VALUE;
    AfeHandle bestAfe = null;
    long iterations = readyAfes.size();
    if (options.getRandomSubsetSize() > 0) {
      iterations = Math.min(options.getRandomSubsetSize(), iterations);
    }

    // Partial Fisher-Yates shuffle.
    for (int i = 0; i < iterations; i++) {
      int randomIndex = i + rng.nextInt(candidates.size() - i);
      AfeHandle picked = candidates.get(randomIndex);
      if (picked.getNumOutstanding() < bestCost) {
        bestCost = picked.getNumOutstanding();
        bestAfe = picked;
      }
      // Move candidate to the `i`th entry so that it's not picked again.
      Collections.swap(candidates, i, randomIndex);
    }
    return sessionList.checkoutSession(bestAfe);
  }
}

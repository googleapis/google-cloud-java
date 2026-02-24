/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.csm;

import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import java.time.Duration;
import java.time.Instant;

class Pacemaker implements Runnable {

  static final Duration PACEMAKER_INTERVAL = Duration.ofMillis(100);

  private final RecorderRegistry registry;
  private final ClientInfo clientInfo;
  private final String executorName;

  private Instant prev;

  Pacemaker(RecorderRegistry registry, ClientInfo clientInfo, String name) {
    this.prev = Instant.now();
    this.registry = registry;
    this.clientInfo = clientInfo;
    this.executorName = name;
  }

  @Override
  public void run() {
    Instant current = Instant.now();
    Duration delta = Duration.between(prev, current).minus(PACEMAKER_INTERVAL);
    prev = current;
    registry.pacemakerDelay.record(
        clientInfo, executorName, delta.isNegative() ? Duration.ZERO : delta);
  }
}

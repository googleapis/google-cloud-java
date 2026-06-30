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
package com.google.cloud.bigtable.data.v2.internal.csm.tracers;

import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import java.util.Optional;

public class DebugTagTracerImpl extends DebugTagTracer {

  private final MetricRegistry.RecorderRegistry registry;
  private final ClientInfo clientInfo;

  private Optional<ClientConfigurationManager> manager = Optional.empty();

  public DebugTagTracerImpl(ClientInfo clientInfo, MetricRegistry.RecorderRegistry registry) {
    this.clientInfo = clientInfo;
    this.registry = registry;
  }

  public void setClientConfigurationManager(ClientConfigurationManager manager) {
    this.manager = Optional.of(manager);
  }

  @Override
  public void record(TelemetryConfiguration.Level level, String tag) {
    if (shouldRecord(level)) {
      registry.debugTagCount.record(clientInfo, tag, 1);
    }
  }

  private boolean shouldRecord(TelemetryConfiguration.Level level) {
    TelemetryConfiguration.Level currentLevel =
        manager
            .map(m -> m.getClientConfiguration().getTelemetryConfiguration().getDebugTagLevel())
            .orElse(TelemetryConfiguration.Level.WARN);
    return level.getNumber() >= currentLevel.getNumber();
  }
}

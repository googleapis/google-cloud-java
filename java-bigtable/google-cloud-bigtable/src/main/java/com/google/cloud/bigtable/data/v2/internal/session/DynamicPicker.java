/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.session;

import com.google.bigtable.v2.LoadBalancingOptions;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.cloud.bigtable.data.v2.internal.session.SessionList.SessionHandle;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A Picker that delegates to a concrete Picker implementation based on the current configuration.
 */
class DynamicPicker extends Picker {
  private static final Logger LOGGER = Logger.getLogger(DynamicPicker.class.getName());
  private final SessionList sessions;

  private volatile Picker delegate;
  private LoadBalancingOptions.LoadBalancingStrategyCase currentStrategy;

  public DynamicPicker(
      SessionList sessions, LoadBalancingOptions.LoadBalancingStrategyCase initialStrategy) {
    this.sessions = sessions;
    this.currentStrategy = initialStrategy;
    this.delegate = createPicker(initialStrategy);
  }

  @Override
  public Optional<SessionHandle> pickSession() {
    return delegate.pickSession();
  }

  public void updateConfig(SessionClientConfiguration.SessionPoolConfiguration config) {
    LoadBalancingOptions.LoadBalancingStrategyCase newStrategy =
        config.getLoadBalancingOptions().getLoadBalancingStrategyCase();
    if (newStrategy != currentStrategy) {
      delegate = createPicker(newStrategy);
      currentStrategy = newStrategy;
    }
  }

  private Picker createPicker(LoadBalancingOptions.LoadBalancingStrategyCase strategy) {
    switch (strategy) {
      case RANDOM:
        return new SimplePicker(sessions);
      case LEAST_IN_FLIGHT:
        return new LeastInFlightPicker(sessions);
      default:
        LOGGER.log(
            Level.FINE, "got load balancing strategy {0} which was not implemented", strategy);
        // TODO: implement PeakEwma
        return new LeastInFlightPicker(sessions);
    }
  }
}

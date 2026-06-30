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
import java.time.Duration;

/**
 * Interface for tracking latency scores of Spanner servers.
 *
 * <p>Implementations must be thread-safe as instances may be shared across multiple concurrent
 * operations.
 */
@InternalApi
@BetaApi
public interface LatencyTracker {

  /**
   * Returns the current latency score.
   *
   * @return the latency score, where lower is better.
   */
  double getScore();

  /**
   * Updates the latency score with a new observation.
   *
   * @param latency the observed latency.
   */
  void update(Duration latency);

  /**
   * Records an error and applies a latency penalty.
   *
   * @param penalty the penalty to apply.
   */
  void recordError(Duration penalty);
}

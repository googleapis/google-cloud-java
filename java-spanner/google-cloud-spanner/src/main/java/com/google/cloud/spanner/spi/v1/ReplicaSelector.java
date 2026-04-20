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
import java.util.function.Function;

/** Interface for selecting a replica from a list of candidates. */
@InternalApi
@BetaApi
public interface ReplicaSelector {

  /**
   * Selects a replica from the given list of candidates.
   *
   * @param candidates the list of eligible candidates.
   * @param scoreLookup a function to look up the latency score for a candidate.
   * @return the selected candidate, or null if the list is empty.
   */
  ChannelEndpoint select(
      List<ChannelEndpoint> candidates, Function<ChannelEndpoint, Double> scoreLookup);
}

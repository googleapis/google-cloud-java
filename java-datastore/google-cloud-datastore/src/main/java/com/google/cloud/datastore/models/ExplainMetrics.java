/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.datastore.models;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.common.base.Objects;
import java.util.Optional;

/** Model class for {@link com.google.datastore.v1.ExplainMetrics}. */
@BetaApi
public class ExplainMetrics {
  private final PlanSummary planSummary;
  private ExecutionStats executionStats;

  @InternalApi
  public ExplainMetrics(com.google.datastore.v1.ExplainMetrics proto) {
    if (proto.hasExecutionStats()) {
      this.executionStats = new ExecutionStats(proto.getExecutionStats());
    }
    this.planSummary = new PlanSummary(proto.getPlanSummary());
  }

  /** Returns the planning phase information for the query. */
  public PlanSummary getPlanSummary() {
    return planSummary;
  }

  /**
   * Returns the aggregated stats from the execution of the query, if present. Only present when
   * 'analyze' is set to true for {@link ExplainOptions}.
   */
  public Optional<ExecutionStats> getExecutionStats() {
    return Optional.ofNullable(executionStats);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ExplainMetrics)) return false;
    ExplainMetrics that = (ExplainMetrics) o;
    return Objects.equal(planSummary, that.planSummary)
        && Objects.equal(executionStats, that.executionStats);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(planSummary, executionStats);
  }
}

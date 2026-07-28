/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.firestore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** ExplainMetrics contains information about planning and execution of a query. */
public final class ExplainMetrics {
  private final @Nonnull PlanSummary planSummary;
  private final @Nullable ExecutionStats executionStats;

  ExplainMetrics(@Nonnull com.google.firestore.v1.ExplainMetrics metrics) {
    // ExplainMetrics is guaranteed to have a plan summary.
    this.planSummary = new PlanSummary(metrics.getPlanSummary());

    // Depending on explain options, metrics may or may not contain execution stats.
    this.executionStats =
        metrics.hasExecutionStats() ? new ExecutionStats(metrics.getExecutionStats()) : null;
  }

  /** Returns the information about the query plan. */
  @Nonnull
  public PlanSummary getPlanSummary() {
    return planSummary;
  }

  /**
   * Returns the information about the execution of the query, or null if the query was not
   * executed.
   */
  @Nullable
  public ExecutionStats getExecutionStats() {
    return executionStats;
  }
}

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

import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.cloud.Structs;
import com.google.common.base.Objects;
import java.util.Map;

/** Model class for {@link com.google.datastore.v1.ExecutionStats} */
@BetaApi
public class ExecutionStats {
  private final long resultsReturned;
  private final java.time.Duration executionDuration;
  private final long readOperations;
  private final Map<String, Object> debugStats;

  @InternalApi
  public ExecutionStats(com.google.datastore.v1.ExecutionStats proto) {
    this.resultsReturned = proto.getResultsReturned();
    this.executionDuration = java.time.Duration.ofNanos(proto.getExecutionDuration().getNanos());
    this.readOperations = proto.getReadOperations();
    this.debugStats = Structs.asMap(proto.getDebugStats());
  }

  /**
   * Returns the total number of results returned, including documents, projections, aggregation
   * results, keys.
   */
  public long getResultsReturned() {
    return resultsReturned;
  }

  /** Returns the debugging statistics from the execution of the query. */
  public Map<String, Object> getDebugStats() {
    return debugStats;
  }

  /** This method is obsolete. Use {@link #getExecutionDurationJavaTime()} instead. */
  @ObsoleteApi("Use getExecutionDurationJavaTime() instead")
  public org.threeten.bp.Duration getExecutionDuration() {
    return toThreetenDuration(getExecutionDurationJavaTime());
  }

  /** Returns the total time to execute the query in the backend. */
  public java.time.Duration getExecutionDurationJavaTime() {
    return executionDuration;
  }

  /** Returns the total billable read operations. */
  public long getReadOperations() {
    return readOperations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExecutionStats)) {
      return false;
    }
    ExecutionStats that = (ExecutionStats) o;

    return Objects.equal(resultsReturned, that.resultsReturned)
        && Objects.equal(executionDuration, that.executionDuration)
        && Objects.equal(readOperations, that.readOperations)
        && Objects.equal(debugStats, that.debugStats);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(resultsReturned, executionDuration, readOperations, debugStats);
  }
}

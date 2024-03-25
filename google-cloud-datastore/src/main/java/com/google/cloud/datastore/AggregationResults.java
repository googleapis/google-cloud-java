/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.datastore;

import static com.google.api.client.util.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.models.ExplainMetrics;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The result of an {@link AggregationQuery} query submission. Contains a List&lt;{@link
 * AggregationResult}&gt; and readTime {@link Timestamp} in it.
 *
 * <p>This can be used to iterate over an underlying List&lt;{@link AggregationResult}&gt; directly.
 */
public class AggregationResults implements Iterable<AggregationResult> {

  private final List<AggregationResult> aggregationResults;
  private final Timestamp readTime;

  private final ExplainMetrics explainMetrics;

  @BetaApi
  public AggregationResults(
      List<AggregationResult> aggregationResults,
      Timestamp readTime,
      ExplainMetrics explainMetrics) {
    checkNotNull(aggregationResults, "Aggregation results cannot be null");
    checkNotNull(readTime, "readTime cannot be null");
    this.aggregationResults = aggregationResults;
    this.readTime = readTime;
    this.explainMetrics = explainMetrics;
  }

  public AggregationResults(List<AggregationResult> aggregationResults, Timestamp readTime) {
    this(aggregationResults, readTime, null);
  }

  /** Returns {@link Iterator} for underlying List&lt;{@link AggregationResult}&gt;. */
  @Override
  public Iterator<AggregationResult> iterator() {
    return this.aggregationResults.iterator();
  }

  public int size() {
    return this.aggregationResults.size();
  }

  /**
   * Returns {@code ExplainMetrics} if {@code ExplainOptions} were enabled. Otherwise, returns null.
   */
  @BetaApi
  public Optional<ExplainMetrics> getExplainMetrics() {
    return Optional.ofNullable(this.explainMetrics);
  }

  @InternalApi
  public AggregationResult get(int index) {
    return this.aggregationResults.get(index);
  }

  /** Returns read timestamp this result batch was returned from. */
  public Timestamp getReadTime() {
    return this.readTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AggregationResults that = (AggregationResults) o;
    return Objects.equals(aggregationResults, that.aggregationResults)
        && Objects.equals(readTime, that.readTime)
        && Objects.equals(explainMetrics, that.explainMetrics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregationResults, readTime, explainMetrics);
  }
}

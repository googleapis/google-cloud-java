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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * The result of an {@link AggregationQuery} query submission. Contains a {@link
 * List<AggregationResult>} and readTime {@link Timestamp} in it.
 *
 * <p>This can be used to iterate over an underlying {@link List<AggregationResult>} directly.
 */
@BetaApi
public class AggregationResults implements Iterable<AggregationResult> {

  private final List<AggregationResult> aggregationResults;
  private final Timestamp readTime;

  public AggregationResults(List<AggregationResult> aggregationResults, Timestamp readTime) {
    checkNotNull(aggregationResults, "Aggregation results cannot be null");
    checkNotNull(readTime, "readTime cannot be null");
    this.aggregationResults = aggregationResults;
    this.readTime = readTime;
  }

  /** Returns {@link Iterator} for underlying {@link List<AggregationResult>}. */
  @Override
  public Iterator<AggregationResult> iterator() {
    return this.aggregationResults.iterator();
  }

  public int size() {
    return this.aggregationResults.size();
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
    return Objects.equals(aggregationResults, that.aggregationResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aggregationResults);
  }
}

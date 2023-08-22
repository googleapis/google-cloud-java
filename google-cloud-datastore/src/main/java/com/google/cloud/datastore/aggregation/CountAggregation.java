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

package com.google.cloud.datastore.aggregation;

import com.google.datastore.v1.AggregationQuery;
import com.google.datastore.v1.AggregationQuery.Aggregation.Count;
import java.util.Objects;

/** Represents an {@link Aggregation} which returns count. */
public class CountAggregation extends Aggregation {

  /** @param alias Alias to used when running this aggregation. */
  public CountAggregation(String alias) {
    super(alias);
  }

  @Override
  public AggregationQuery.Aggregation toPb() {
    return aggregationBuilder().setCount(Count.newBuilder()).build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountAggregation that = (CountAggregation) o;
    return Objects.equals(getAlias(), that.getAlias());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAlias());
  }

  /** A builder class to create and customize a {@link CountAggregation}. */
  public static class Builder implements AggregationBuilder<CountAggregation> {

    private String alias;

    public Builder as(String alias) {
      this.alias = alias;
      return this;
    }

    @Override
    public CountAggregation build() {
      return new CountAggregation(alias);
    }
  }
}

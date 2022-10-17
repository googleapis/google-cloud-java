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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.datastore.v1.AggregationQuery;

/**
 * Represents a Google Cloud Datastore Aggregation which is used with an {@link AggregationQuery}.
 */
@BetaApi
public abstract class Aggregation {

  private final String alias;

  public Aggregation(String alias) {
    this.alias = alias;
  }

  /** Returns the alias for this aggregation. */
  public String getAlias() {
    return alias;
  }

  @InternalApi
  public abstract AggregationQuery.Aggregation toPb();

  /** Returns a {@link CountAggregation} builder. */
  public static CountAggregation.Builder count() {
    return new CountAggregation.Builder();
  }
}

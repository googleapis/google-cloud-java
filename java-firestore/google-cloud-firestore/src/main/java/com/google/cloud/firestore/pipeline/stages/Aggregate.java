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

package com.google.cloud.firestore.pipeline.stages;

import static com.google.cloud.firestore.PipelineUtils.encodeValue;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.firestore.PipelineUtils;
import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.cloud.firestore.pipeline.expressions.AliasedAggregate;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.cloud.firestore.pipeline.expressions.Selectable;
import com.google.firestore.v1.Value;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

@BetaApi
public final class Aggregate extends Stage {

  private final Map<String, Expression> groups;
  private final Map<String, AggregateFunction> accumulators;

  @BetaApi
  public Aggregate withGroups(String... fields) {
    return new Aggregate(
        PipelineUtils.fieldNamesToMap(fields), this.accumulators, new AggregateOptions());
  }

  @BetaApi
  public Aggregate withGroups(Selectable... selectables) {
    return new Aggregate(
        PipelineUtils.selectablesToMap(selectables), this.accumulators, new AggregateOptions());
  }

  @BetaApi
  public static Aggregate withAccumulators(AliasedAggregate... accumulators) {
    Map<String, AggregateFunction> accumulatorMap = new HashMap<>();
    for (AliasedAggregate accumulator : accumulators) {
      if (accumulatorMap.containsKey(accumulator.getAlias())) {
        throw new IllegalArgumentException(
            "Duplicate alias or field name: " + accumulator.getAlias());
      }
      accumulatorMap.put(accumulator.getAlias(), accumulator.getExpr());
    }
    return new Aggregate(Collections.emptyMap(), accumulatorMap, new AggregateOptions());
  }

  @InternalApi
  public Aggregate withOptions(@Nonnull AggregateOptions options) {
    return new Aggregate(groups, accumulators, options);
  }

  private Aggregate(
      Map<String, Expression> groups,
      Map<String, AggregateFunction> accumulators,
      AggregateOptions options) {
    super("aggregate", options.options);
    if (accumulators.isEmpty()) {
      throw new IllegalArgumentException(
          "Must specify at least one accumulator for aggregate() stage. There is a distinct() stage"
              + " if only distinct group values are needed.");
    }

    this.groups = groups;
    this.accumulators = accumulators;
  }

  @Override
  Iterable<Value> toStageArgs() {
    return Arrays.asList(encodeValue(accumulators), encodeValue(groups));
  }
}

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
package com.google.cloud.datastore.execution.response;

import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.LongValue;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.Value;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

@InternalApi
public class AggregationQueryResponseTransformer
    implements ResponseTransformer<RunAggregationQueryResponse, AggregationResults> {

  @Override
  public AggregationResults transform(RunAggregationQueryResponse response) {
    Timestamp readTime = Timestamp.fromProto(response.getBatch().getReadTime());
    List<AggregationResult> aggregationResults =
        response.getBatch().getAggregationResultsList().stream()
            .map(
                aggregationResult -> new AggregationResult(resultWithLongValues(aggregationResult)))
            .collect(Collectors.toCollection(LinkedList::new));
    return new AggregationResults(aggregationResults, readTime);
  }

  private Map<String, LongValue> resultWithLongValues(
      com.google.datastore.v1.AggregationResult aggregationResult) {
    return aggregationResult.getAggregatePropertiesMap().entrySet().stream()
        .map(
            (Function<Entry<String, Value>, Entry<String, LongValue>>)
                entry ->
                    new SimpleEntry<>(
                        entry.getKey(), (LongValue) LongValue.fromPb(entry.getValue())))
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }
}

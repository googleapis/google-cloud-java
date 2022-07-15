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
package com.google.cloud.bigtable.stats;

import static com.google.api.gax.tracing.ApiTracerFactory.OperationType;

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.SpanName;
import io.opencensus.stats.Stats;
import io.opencensus.stats.View;
import io.opencensus.tags.TagKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Wrapper class for accessing opencensus. We use a shaded version of opencensus to avoid polluting
 * the global opencensus namespace. And this provides a facade that will not be relocated.
 */
@InternalApi("For internal use only")
public class StatsWrapper {
  public static StatsRecorderWrapper createRecorder(
      OperationType operationType, SpanName spanName, Map<String, String> statsAttributes) {
    return new StatsRecorderWrapper(
        operationType, spanName, statsAttributes, Stats.getStatsRecorder());
  }

  // This is used in integration tests to get the tag value strings from view manager because Stats
  // is relocated to com.google.bigtable.veneer.repackaged.io.opencensus.
  @InternalApi("Visible for testing")
  public static List<String> getOperationLatencyViewTagValueStrings() {
    return Stats.getViewManager().getView(BuiltinViewConstants.OPERATION_LATENCIES_VIEW.getName())
        .getAggregationMap().entrySet().stream()
        .map(Map.Entry::getKey)
        .flatMap(x -> x.stream())
        .map(x -> x.asString())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  // A workaround to run ITBuiltinViewConstantsTest as integration test. Integration test runs after
  // the packaging step. Opencensus classes will be relocated when they are packaged but the
  // integration test files will not be. So the integration tests can't reference any transitive
  // dependencies that have been relocated.
  static Map<String, List<String>> getViewToTagMap() {
    Map<String, List<String>> map = new HashMap<>();
    for (View view : BuiltinViews.BIGTABLE_BUILTIN_VIEWS) {
      List<TagKey> tagKeys = view.getColumns();
      map.put(
          view.getName().asString(),
          tagKeys.stream().map(tagKey -> tagKey.getName()).collect(Collectors.toList()));
    }
    return map;
  }
}

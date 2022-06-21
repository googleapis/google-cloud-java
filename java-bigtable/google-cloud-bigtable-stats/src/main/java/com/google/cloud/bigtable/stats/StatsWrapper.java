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
import java.util.Map;

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
}

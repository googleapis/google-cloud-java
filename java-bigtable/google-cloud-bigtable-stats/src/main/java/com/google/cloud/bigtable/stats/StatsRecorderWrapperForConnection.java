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
package com.google.cloud.bigtable.stats;

import com.google.api.core.InternalApi;
import io.opencensus.stats.MeasureMap;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagContext;
import io.opencensus.tags.TagContextBuilder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import io.opencensus.tags.Tags;
import java.util.Map;

/** A wrapper to record built-in metrics for connection metrics not tied to operations/RPCs. */
@InternalApi("For internal use only")
public class StatsRecorderWrapperForConnection {
  private final StatsRecorder statsRecorder;
  private final TagContext tagContext;
  private MeasureMap perConnectionErrorCountMeasureMap;

  public StatsRecorderWrapperForConnection(
      Map<String, String> statsAttributes, StatsRecorder statsRecorder) {
    this.statsRecorder = statsRecorder;

    this.perConnectionErrorCountMeasureMap = statsRecorder.newMeasureMap();

    Tagger tagger = Tags.getTagger();
    TagContextBuilder tagContextBuilder = tagger.toBuilder(tagger.getCurrentTagContext());
    for (Map.Entry<String, String> entry : statsAttributes.entrySet()) {
      tagContextBuilder.putLocal(TagKey.create(entry.getKey()), TagValue.create(entry.getValue()));
    }
    this.tagContext = tagContextBuilder.build();
  }

  public void putAndRecordPerConnectionErrorCount(long errorCount) {
    perConnectionErrorCountMeasureMap.put(
        BuiltinMeasureConstants.PER_CONNECTION_ERROR_COUNT, errorCount);

    perConnectionErrorCountMeasureMap.record(tagContext);
    perConnectionErrorCountMeasureMap = statsRecorder.newMeasureMap();
  }
}

/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import io.opencensus.impl.stats.StatsComponentImpl;
import io.opencensus.stats.StatsComponent;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.TagKey;
import io.opencensus.tags.TagValue;
import io.opencensus.tags.Tagger;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class HeaderTracerTest {

  private final StatsComponent localStats = new StatsComponentImpl();

  @Test
  public void testDefaultBuilder() {
    HeaderTracer.Builder builder = HeaderTracer.newBuilder();
    HeaderTracer tracer = builder.build();
    assertThat(tracer.getStats()).isNotNull();
    assertThat(tracer.getTagger()).isNotNull();
    assertThat(tracer.getStatsAttributes()).isNotNull();
    assertThat(tracer.getStatsAttributes()).isEmpty();
  }

  @Test
  public void testBuilder() {
    HeaderTracer.Builder builder = HeaderTracer.newBuilder();
    Map<TagKey, TagValue> attrs =
        ImmutableMap.<TagKey, TagValue>of(TagKey.create("fake-key"), TagValue.create("fake-value"));
    Tagger tagger = Mockito.mock(Tagger.class);
    StatsRecorder stats = localStats.getStatsRecorder();
    builder.setStats(stats).setStatsAttributes(attrs).setTagger(tagger);
    HeaderTracer headerTracer = builder.build();
    assertThat(headerTracer.getStats()).isEqualTo(stats);
    assertThat(headerTracer.getTagger()).isEqualTo(tagger);
    assertThat(headerTracer.getStatsAttributes()).isEqualTo(attrs);
  }

  @Test
  public void testToBuilder() {
    HeaderTracer.Builder builder = HeaderTracer.newBuilder();
    Map<TagKey, TagValue> attrs =
        ImmutableMap.<TagKey, TagValue>of(TagKey.create("fake-key"), TagValue.create("fake-value"));
    Tagger tagger = Mockito.mock(Tagger.class);
    StatsRecorder stats = localStats.getStatsRecorder();
    builder.setStats(stats).setStatsAttributes(attrs).setTagger(tagger);
    HeaderTracer headerTracer = builder.build();

    HeaderTracer.Builder newBuilder = headerTracer.toBuilder();
    assertThat(newBuilder.build().getStats()).isEqualTo(stats);
    assertThat(newBuilder.build().getTagger()).isEqualTo(tagger);
    assertThat(newBuilder.build().getStatsAttributes()).isEqualTo(attrs);
  }
}

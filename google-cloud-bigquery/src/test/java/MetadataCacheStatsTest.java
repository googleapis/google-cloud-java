/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import com.google.api.services.bigquery.model.MetadataCacheStatistics;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class MetadataCacheStatsTest {
  private static List<com.google.api.services.bigquery.model.TableMetadataCacheUsage>
      TABLE_METADATA_CACHE_USAGE_PB_LIST =
          ImmutableList.of(
              new com.google.api.services.bigquery.model.TableMetadataCacheUsage()
                  .setExplanation("test explanation"));

  private static final MetadataCacheStats METADATA_CACHE_STATS =
      MetadataCacheStats.newBuilder()
          .setTableMetadataCacheUsage(
              TABLE_METADATA_CACHE_USAGE_PB_LIST.stream()
                  .map(TableMetadataCacheUsage::fromPb)
                  .collect(Collectors.toList()))
          .build();

  private static final MetadataCacheStatistics METADATA_CACHE_STATISTICS_PB =
      new MetadataCacheStatistics().setTableMetadataCacheUsage(TABLE_METADATA_CACHE_USAGE_PB_LIST);

  @Test
  public void testToPbAndFromPb() {
    assertEquals(METADATA_CACHE_STATISTICS_PB, METADATA_CACHE_STATS.toPb());
    compareMetadataCacheStats(
        METADATA_CACHE_STATS, MetadataCacheStats.fromPb(METADATA_CACHE_STATISTICS_PB));
  }

  private void compareMetadataCacheStats(MetadataCacheStats expected, MetadataCacheStats value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    Truth.assertThat(
        expected.getTableMetadataCacheUsage().containsAll(value.getTableMetadataCacheUsage()));
  }
}

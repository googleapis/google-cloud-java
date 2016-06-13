/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.cloud.bigquery.JobStatistics.CopyStatistics;
import com.google.cloud.bigquery.JobStatistics.ExtractStatistics;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.QueryStage.QueryStep;

import org.junit.Test;

import java.util.List;

public class JobStatisticsTest {

  private static final Integer BILLING_TIER = 42;
  private static final Boolean CACHE_HIT = true;
  private static final Long TOTAL_BYTES_BILLED = 24L;
  private static final Long TOTAL_BYTES_PROCESSED = 42L;
  private static final Long INPUT_BYTES = 1L;
  private static final Long INPUT_FILES = 2L;
  private static final Long OUTPUT_BYTES = 3L;
  private static final Long OUTPUT_ROWS = 4L;
  private static final List<Long> FILE_COUNT = ImmutableList.of(1L, 2L, 3L);
  private static final Long CREATION_TIME = 10L;
  private static final Long END_TIME = 20L;
  private static final Long START_TIME = 15L;
  private static final CopyStatistics COPY_STATISTICS = CopyStatistics.builder()
      .creationTime(CREATION_TIME)
      .endTime(END_TIME)
      .startTime(START_TIME)
      .build();
  private static final ExtractStatistics EXTRACT_STATISTICS = ExtractStatistics.builder()
      .creationTime(CREATION_TIME)
      .endTime(END_TIME)
      .startTime(START_TIME)
      .destinationUriFileCounts(FILE_COUNT)
      .build();
  private static final LoadStatistics LOAD_STATISTICS = LoadStatistics.builder()
      .creationTime(CREATION_TIME)
      .endTime(END_TIME)
      .startTime(START_TIME)
      .inputBytes(INPUT_BYTES)
      .inputFiles(INPUT_FILES)
      .outputBytes(OUTPUT_BYTES)
      .outputRows(OUTPUT_ROWS)
      .build();
  private static final LoadStatistics LOAD_STATISTICS_INCOMPLETE = LoadStatistics.builder()
      .creationTime(CREATION_TIME)
      .endTime(END_TIME)
      .startTime(START_TIME)
      .inputBytes(INPUT_BYTES)
      .inputFiles(INPUT_FILES)
      .build();
  private static final List<String> SUBSTEPS1 = ImmutableList.of("substep1", "substep2");
  private static final List<String> SUBSTEPS2 = ImmutableList.of("substep3", "substep4");
  private static final QueryStep QUERY_STEP1 = new QueryStep("KIND", SUBSTEPS1);
  private static final QueryStep QUERY_STEP2 = new QueryStep("KIND", SUBSTEPS2);
  private static final QueryStage QUERY_STAGE = QueryStage.builder()
      .computeRatioAvg(1.1)
      .computeRatioMax(2.2)
      .generatedId(42L)
      .name("stage")
      .readRatioAvg(3.3)
      .readRatioMax(4.4)
      .recordsRead(5L)
      .recordsWritten(6L)
      .steps(ImmutableList.of(QUERY_STEP1, QUERY_STEP2))
      .waitRatioAvg(7.7)
      .waitRatioMax(8.8)
      .writeRatioAvg(9.9)
      .writeRatioMax(10.10)
      .build();
  private static final List<QueryStage> QUERY_PLAN = ImmutableList.of(QUERY_STAGE);
  private static final QueryStatistics QUERY_STATISTICS = QueryStatistics.builder()
      .creationTime(CREATION_TIME)
      .endTime(END_TIME)
      .startTime(START_TIME)
      .billingTier(BILLING_TIER)
      .cacheHit(CACHE_HIT)
      .totalBytesBilled(TOTAL_BYTES_BILLED)
      .totalBytesProcessed(TOTAL_BYTES_PROCESSED)
      .queryPlan(QUERY_PLAN)
      .build();
  private static final QueryStatistics QUERY_STATISTICS_INCOMPLETE = QueryStatistics.builder()
      .creationTime(CREATION_TIME)
      .endTime(END_TIME)
      .startTime(START_TIME)
      .billingTier(BILLING_TIER)
      .cacheHit(CACHE_HIT)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(CREATION_TIME, COPY_STATISTICS.creationTime());
    assertEquals(START_TIME, COPY_STATISTICS.startTime());
    assertEquals(END_TIME, COPY_STATISTICS.endTime());

    assertEquals(CREATION_TIME, EXTRACT_STATISTICS.creationTime());
    assertEquals(START_TIME, EXTRACT_STATISTICS.startTime());
    assertEquals(END_TIME, EXTRACT_STATISTICS.endTime());
    assertEquals(FILE_COUNT, EXTRACT_STATISTICS.destinationUriFileCounts());

    assertEquals(CREATION_TIME, LOAD_STATISTICS.creationTime());
    assertEquals(START_TIME, LOAD_STATISTICS.startTime());
    assertEquals(END_TIME, LOAD_STATISTICS.endTime());
    assertEquals(INPUT_BYTES, LOAD_STATISTICS.inputBytes());
    assertEquals(INPUT_FILES, LOAD_STATISTICS.inputFiles());
    assertEquals(OUTPUT_BYTES, LOAD_STATISTICS.outputBytes());
    assertEquals(OUTPUT_ROWS, LOAD_STATISTICS.outputRows());

    assertEquals(CREATION_TIME, QUERY_STATISTICS.creationTime());
    assertEquals(START_TIME, QUERY_STATISTICS.startTime());
    assertEquals(END_TIME, QUERY_STATISTICS.endTime());
    assertEquals(BILLING_TIER, QUERY_STATISTICS.billingTier());
    assertEquals(CACHE_HIT, QUERY_STATISTICS.cacheHit());
    assertEquals(TOTAL_BYTES_BILLED, QUERY_STATISTICS.totalBytesBilled());
    assertEquals(TOTAL_BYTES_PROCESSED, QUERY_STATISTICS.totalBytesProcessed());
    assertEquals(TOTAL_BYTES_PROCESSED, QUERY_STATISTICS.totalBytesProcessed());
    assertEquals(QUERY_PLAN, QUERY_STATISTICS.queryPlan());

    assertEquals(CREATION_TIME, LOAD_STATISTICS_INCOMPLETE.creationTime());
    assertEquals(START_TIME, LOAD_STATISTICS_INCOMPLETE.startTime());
    assertEquals(END_TIME, LOAD_STATISTICS_INCOMPLETE.endTime());
    assertEquals(INPUT_BYTES, LOAD_STATISTICS_INCOMPLETE.inputBytes());
    assertEquals(INPUT_FILES, LOAD_STATISTICS_INCOMPLETE.inputFiles());
    assertEquals(null, LOAD_STATISTICS_INCOMPLETE.outputBytes());
    assertEquals(null, LOAD_STATISTICS_INCOMPLETE.outputRows());

    assertEquals(CREATION_TIME, QUERY_STATISTICS_INCOMPLETE.creationTime());
    assertEquals(START_TIME, QUERY_STATISTICS_INCOMPLETE.startTime());
    assertEquals(END_TIME, QUERY_STATISTICS_INCOMPLETE.endTime());
    assertEquals(BILLING_TIER, QUERY_STATISTICS_INCOMPLETE.billingTier());
    assertEquals(CACHE_HIT, QUERY_STATISTICS_INCOMPLETE.cacheHit());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.totalBytesBilled());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.totalBytesProcessed());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.queryPlan());
  }

  @Test
  public void testToPbAndFromPb() {
    compareExtractStatistics(EXTRACT_STATISTICS,
        ExtractStatistics.fromPb(EXTRACT_STATISTICS.toPb()));
    compareLoadStatistics(LOAD_STATISTICS, LoadStatistics.fromPb(LOAD_STATISTICS.toPb()));
    compareQueryStatistics(QUERY_STATISTICS, QueryStatistics.fromPb(QUERY_STATISTICS.toPb()));
    compareStatistics(COPY_STATISTICS, JobStatistics.fromPb(COPY_STATISTICS.toPb()));

    compareLoadStatistics(LOAD_STATISTICS_INCOMPLETE,
        LoadStatistics.fromPb(LOAD_STATISTICS_INCOMPLETE.toPb()));
    compareQueryStatistics(QUERY_STATISTICS_INCOMPLETE,
        QueryStatistics.fromPb(QUERY_STATISTICS_INCOMPLETE.toPb()));
  }

  private void compareExtractStatistics(ExtractStatistics expected, ExtractStatistics value) {
    assertEquals(expected, value);
    compareStatistics(expected, value);
    assertEquals(expected.destinationUriFileCounts(), value.destinationUriFileCounts());
  }

  private void compareLoadStatistics(LoadStatistics expected, LoadStatistics value) {
    assertEquals(expected, value);
    compareStatistics(expected, value);
    assertEquals(expected.inputBytes(), value.inputBytes());
    assertEquals(expected.inputFiles(), value.inputFiles());
    assertEquals(expected.outputBytes(), value.outputBytes());
    assertEquals(expected.outputRows(), value.outputRows());
  }

  private void compareQueryStatistics(QueryStatistics expected, QueryStatistics value) {
    assertEquals(expected, value);
    compareStatistics(expected, value);
    assertEquals(expected.billingTier(), value.billingTier());
    assertEquals(expected.cacheHit(), value.cacheHit());
    assertEquals(expected.totalBytesBilled(), value.totalBytesBilled());
    assertEquals(expected.totalBytesProcessed(), value.totalBytesProcessed());
    assertEquals(expected.queryPlan(), value.queryPlan());
  }

  private void compareStatistics(JobStatistics expected, JobStatistics value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.creationTime(), value.creationTime());
    assertEquals(expected.endTime(), value.endTime());
    assertEquals(expected.startTime(), value.startTime());
  }
}

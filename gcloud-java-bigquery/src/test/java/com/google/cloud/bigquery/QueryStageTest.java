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

import com.google.api.services.bigquery.model.ExplainQueryStep;
import com.google.common.collect.ImmutableList;
import com.google.cloud.bigquery.QueryStage.QueryStep;

import org.junit.Test;

import java.util.List;

public class QueryStageTest {

  private static final List<String> SUBSTEPS1 = ImmutableList.of("substep1", "substep2");
  private static final List<String> SUBSTEPS2 = ImmutableList.of("substep3", "substep4");
  private static final QueryStep QUERY_STEP1 = new QueryStep("KIND", SUBSTEPS1);
  private static final QueryStep QUERY_STEP2 = new QueryStep("KIND", SUBSTEPS2);
  private static final double COMPUTE_RATIO_AVG = 1.1;
  private static final double COMPUTE_RATIO_MAX = 2.2;
  private static final long ID = 42L;
  private static final String NAME = "StageName";
  private static final double READ_RATIO_AVG = 3.3;
  private static final double READ_RATIO_MAX = 4.4;
  private static final long RECORDS_READ = 5L;
  private static final long RECORDS_WRITTEN = 6L;
  private static final List<QueryStep> STEPS = ImmutableList.of(QUERY_STEP1, QUERY_STEP2);
  private static final double WAIT_RATIO_AVG = 7.7;
  private static final double WAIT_RATIO_MAX = 8.8;
  private static final double WRITE_RATIO_AVG = 9.9;
  private static final double WRITE_RATIO_MAX = 10.10;
  private static final QueryStage QUERY_STAGE = QueryStage.builder()
      .computeRatioAvg(COMPUTE_RATIO_AVG)
      .computeRatioMax(COMPUTE_RATIO_MAX)
      .generatedId(ID)
      .name(NAME)
      .readRatioAvg(READ_RATIO_AVG)
      .readRatioMax(READ_RATIO_MAX)
      .recordsRead(RECORDS_READ)
      .recordsWritten(RECORDS_WRITTEN)
      .steps(STEPS)
      .waitRatioAvg(WAIT_RATIO_AVG)
      .waitRatioMax(WAIT_RATIO_MAX)
      .writeRatioAvg(WRITE_RATIO_AVG)
      .writeRatioMax(WRITE_RATIO_MAX)
      .build();

  @Test
  public void testQueryStepConstructor() {
    assertEquals("KIND", QUERY_STEP1.name());
    assertEquals("KIND", QUERY_STEP2.name());
    assertEquals(SUBSTEPS1, QUERY_STEP1.substeps());
    assertEquals(SUBSTEPS2, QUERY_STEP2.substeps());
  }

  @Test
  public void testBuilder() {
    assertEquals(COMPUTE_RATIO_AVG, QUERY_STAGE.computeRatioAvg(), 0);
    assertEquals(COMPUTE_RATIO_MAX, QUERY_STAGE.computeRatioMax(), 0);
    assertEquals(ID, QUERY_STAGE.generatedId());
    assertEquals(NAME, QUERY_STAGE.name());
    assertEquals(READ_RATIO_AVG, QUERY_STAGE.readRatioAvg(), 0);
    assertEquals(READ_RATIO_MAX, QUERY_STAGE.readRatioMax(), 0);
    assertEquals(RECORDS_READ, QUERY_STAGE.recordsRead());
    assertEquals(RECORDS_WRITTEN, QUERY_STAGE.recordsWritten());
    assertEquals(STEPS, QUERY_STAGE.steps());
    assertEquals(WAIT_RATIO_AVG, QUERY_STAGE.waitRatioAvg(), 0);
    assertEquals(WAIT_RATIO_MAX, QUERY_STAGE.waitRatioMax(), 0);
    assertEquals(WRITE_RATIO_AVG, QUERY_STAGE.writeRatioAvg(), 0);
    assertEquals(WRITE_RATIO_MAX, QUERY_STAGE.writeRatioMax(), 0);
  }

  @Test
  public void testToAndFromPb() {
    compareQueryStep(QUERY_STEP1, QueryStep.fromPb(QUERY_STEP1.toPb()));
    compareQueryStep(QUERY_STEP2, QueryStep.fromPb(QUERY_STEP2.toPb()));
    compareQueryStage(QUERY_STAGE, QueryStage.fromPb(QUERY_STAGE.toPb()));
    ExplainQueryStep stepPb = new ExplainQueryStep();
    stepPb.setKind("KIND");
    stepPb.setSubsteps(null);
    compareQueryStep(new QueryStep("KIND", ImmutableList.<String>of()), QueryStep.fromPb(stepPb));
  }

  @Test
  public void testEquals() {
    compareQueryStep(QUERY_STEP1, QUERY_STEP1);
    compareQueryStep(QUERY_STEP2, QUERY_STEP2);
    compareQueryStage(QUERY_STAGE, QUERY_STAGE);
  }

  private void compareQueryStage(QueryStage expected, QueryStage value) {
    assertEquals(expected, value);
    assertEquals(expected.computeRatioAvg(), value.computeRatioAvg(), 0);
    assertEquals(expected.computeRatioMax(), value.computeRatioMax(), 0);
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.name(), value.name());
    assertEquals(expected.readRatioAvg(), value.readRatioAvg(), 0);
    assertEquals(expected.readRatioMax(), value.readRatioMax(), 0);
    assertEquals(expected.recordsRead(), value.recordsRead());
    assertEquals(expected.recordsWritten(), value.recordsWritten());
    assertEquals(expected.steps(), value.steps());
    assertEquals(expected.waitRatioAvg(), value.waitRatioAvg(), 0);
    assertEquals(expected.waitRatioMax(), value.waitRatioMax(), 0);
    assertEquals(expected.writeRatioAvg(), value.writeRatioAvg(), 0);
    assertEquals(expected.writeRatioMax(), value.writeRatioMax(), 0);
    assertEquals(expected.hashCode(), value.hashCode());
  }

  private void compareQueryStep(QueryStep expected, QueryStep value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.substeps(), value.substeps());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

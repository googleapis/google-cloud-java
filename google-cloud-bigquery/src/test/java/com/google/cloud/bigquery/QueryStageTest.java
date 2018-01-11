/*
 * Copyright 2015 Google LLC
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
import com.google.cloud.bigquery.QueryStage.QueryStep;
import com.google.common.collect.ImmutableList;

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
  private static final QueryStage QUERY_STAGE = QueryStage.newBuilder()
      .setComputeRationAvg(COMPUTE_RATIO_AVG)
      .setComputeRatioMax(COMPUTE_RATIO_MAX)
      .setGeneratedId(ID)
      .setName(NAME)
      .setReadRatioAvg(READ_RATIO_AVG)
      .setReadRatioMax(READ_RATIO_MAX)
      .setRecordsRead(RECORDS_READ)
      .setRecordsWritten(RECORDS_WRITTEN)
      .setSteps(STEPS)
      .setWaitRatioAvg(WAIT_RATIO_AVG)
      .setWaitRatioMax(WAIT_RATIO_MAX)
      .setWriteRatioAvg(WRITE_RATIO_AVG)
      .setWriteRatioMax(WRITE_RATIO_MAX)
      .build();

  @Test
  public void testQueryStepConstructor() {
    assertEquals("KIND", QUERY_STEP1.getName());
    assertEquals("KIND", QUERY_STEP2.getName());
    assertEquals(SUBSTEPS1, QUERY_STEP1.getSubsteps());
    assertEquals(SUBSTEPS2, QUERY_STEP2.getSubsteps());
  }


  @Test
  public void testBuilder() {
    assertEquals(COMPUTE_RATIO_AVG, QUERY_STAGE.getComputeRatioAvg(), 0);
    assertEquals(COMPUTE_RATIO_MAX, QUERY_STAGE.getComputeRatioMax(), 0);
    assertEquals(ID, QUERY_STAGE.getGeneratedId());
    assertEquals(NAME, QUERY_STAGE.getName());
    assertEquals(READ_RATIO_AVG, QUERY_STAGE.getReadRatioAvg(), 0);
    assertEquals(READ_RATIO_MAX, QUERY_STAGE.getReadRatioMax(), 0);
    assertEquals(RECORDS_READ, QUERY_STAGE.getRecordsRead());
    assertEquals(RECORDS_WRITTEN, QUERY_STAGE.getRecordsWritten());
    assertEquals(STEPS, QUERY_STAGE.getSteps());
    assertEquals(WAIT_RATIO_AVG, QUERY_STAGE.getWaitRatioAvg(), 0);
    assertEquals(WAIT_RATIO_MAX, QUERY_STAGE.getWaitRatioMax(), 0);
    assertEquals(WRITE_RATIO_AVG, QUERY_STAGE.getWriteRatioAvg(), 0);
    assertEquals(WRITE_RATIO_MAX, QUERY_STAGE.getWriteRatioMax(), 0);
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
    assertEquals(expected.getComputeRatioAvg(), value.getComputeRatioAvg(), 0);
    assertEquals(expected.getComputeRatioMax(), value.getComputeRatioMax(), 0);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getReadRatioAvg(), value.getReadRatioAvg(), 0);
    assertEquals(expected.getReadRatioMax(), value.getReadRatioMax(), 0);
    assertEquals(expected.getRecordsRead(), value.getRecordsRead());
    assertEquals(expected.getRecordsWritten(), value.getRecordsWritten());
    assertEquals(expected.getSteps(), value.getSteps());
    assertEquals(expected.getWaitRatioAvg(), value.getWaitRatioAvg(), 0);
    assertEquals(expected.getWaitRatioMax(), value.getWaitRatioMax(), 0);
    assertEquals(expected.getWriteRatioAvg(), value.getWriteRatioAvg(), 0);
    assertEquals(expected.getWriteRatioMax(), value.getWriteRatioMax(), 0);
    assertEquals(expected.hashCode(), value.hashCode());
  }

  private void compareQueryStep(QueryStep expected, QueryStep value) {
    assertEquals(expected, value);
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getSubsteps(), value.getSubsteps());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

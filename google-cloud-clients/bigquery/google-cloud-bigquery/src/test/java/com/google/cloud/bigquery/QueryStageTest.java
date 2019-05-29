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
import java.util.List;
import org.junit.Test;

public class QueryStageTest {

  private static final List<String> SUBSTEPS1 = ImmutableList.of("substep1", "substep2");
  private static final List<String> SUBSTEPS2 = ImmutableList.of("substep3", "substep4");
  private static final QueryStep QUERY_STEP1 = new QueryStep("KIND", SUBSTEPS1);
  private static final QueryStep QUERY_STEP2 = new QueryStep("KIND", SUBSTEPS2);
  private static final long COMPLETED_PARALLEL_INPUTS = 3;
  private static final long COMPUTE_MS_AVG = 1234;
  private static final long COMPUTE_MS_MAX = 2345;
  private static final double COMPUTE_RATIO_AVG = 1.1;
  private static final double COMPUTE_RATIO_MAX = 2.2;
  private static final long END_MS = 1522540860000L;
  private static final long ID = 42L;
  private static final List<Long> INPUT_STAGES = ImmutableList.of(Long.valueOf(7), Long.valueOf(9));
  private static final String NAME = "StageName";
  private static final long PARALLEL_INPUTS = 4;
  private static final long READ_MS_AVG = 3456;
  private static final long READ_MS_MAX = 4567;
  private static final double READ_RATIO_AVG = 3.3;
  private static final double READ_RATIO_MAX = 4.4;
  private static final long RECORDS_READ = 5L;
  private static final long RECORDS_WRITTEN = 6L;
  private static final long SHUFFLE_OUTPUT_BYTES = 4096;
  private static final long SHUFFLE_OUTPUT_BYTES_SPILLED = 0;
  private static final long START_MS = 1522540800000L;
  private static final String STATUS = "COMPLETE";
  private static final List<QueryStep> STEPS = ImmutableList.of(QUERY_STEP1, QUERY_STEP2);
  private static final long WAIT_MS_AVG = 3333;
  private static final long WAIT_MS_MAX = 3344;
  private static final double WAIT_RATIO_AVG = 7.7;
  private static final double WAIT_RATIO_MAX = 8.8;
  private static final long WRITE_MS_AVG = 44;
  private static final long WRITE_MS_MAX = 50;
  private static final double WRITE_RATIO_AVG = 9.9;
  private static final double WRITE_RATIO_MAX = 10.10;
  private static final QueryStage QUERY_STAGE =
      QueryStage.newBuilder()
          .setCompletedParallelInputs(COMPLETED_PARALLEL_INPUTS)
          .setComputeMsAvg(COMPUTE_MS_AVG)
          .setComputeMsMax(COMPUTE_MS_MAX)
          .setComputeRatioAvg(COMPUTE_RATIO_AVG)
          .setComputeRatioMax(COMPUTE_RATIO_MAX)
          .setEndMs(END_MS)
          .setGeneratedId(ID)
          .setInputStages(INPUT_STAGES)
          .setName(NAME)
          .setParallelInputs(PARALLEL_INPUTS)
          .setReadMsAvg(READ_MS_AVG)
          .setReadMsMax(READ_MS_MAX)
          .setReadRatioAvg(READ_RATIO_AVG)
          .setReadRatioMax(READ_RATIO_MAX)
          .setRecordsRead(RECORDS_READ)
          .setRecordsWritten(RECORDS_WRITTEN)
          .setShuffleOutputBytes(SHUFFLE_OUTPUT_BYTES)
          .setShuffleOutputBytesSpilled(SHUFFLE_OUTPUT_BYTES_SPILLED)
          .setStartMs(START_MS)
          .setStatus(STATUS)
          .setSteps(STEPS)
          .setWaitMsAvg(WAIT_MS_AVG)
          .setWaitMsMax(WAIT_MS_MAX)
          .setWaitRatioAvg(WAIT_RATIO_AVG)
          .setWaitRatioMax(WAIT_RATIO_MAX)
          .setWriteMsAvg(WRITE_MS_AVG)
          .setWriteMsMax(WRITE_MS_MAX)
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
    assertEquals(COMPLETED_PARALLEL_INPUTS, QUERY_STAGE.getCompletedParallelInputs());
    assertEquals(COMPUTE_MS_AVG, QUERY_STAGE.getComputeMsAvg());
    assertEquals(COMPUTE_MS_MAX, QUERY_STAGE.getComputeMsMax());
    assertEquals(COMPUTE_RATIO_AVG, QUERY_STAGE.getComputeRatioAvg(), 0);
    assertEquals(COMPUTE_RATIO_MAX, QUERY_STAGE.getComputeRatioMax(), 0);
    assertEquals(END_MS, QUERY_STAGE.getEndMs());
    assertEquals(ID, QUERY_STAGE.getGeneratedId());
    assertEquals(INPUT_STAGES, QUERY_STAGE.getInputStages());
    assertEquals(PARALLEL_INPUTS, QUERY_STAGE.getParallelInputs());
    assertEquals(NAME, QUERY_STAGE.getName());
    assertEquals(READ_RATIO_AVG, QUERY_STAGE.getReadRatioAvg(), 0);
    assertEquals(READ_RATIO_MAX, QUERY_STAGE.getReadRatioMax(), 0);
    assertEquals(RECORDS_READ, QUERY_STAGE.getRecordsRead());
    assertEquals(RECORDS_WRITTEN, QUERY_STAGE.getRecordsWritten());
    assertEquals(SHUFFLE_OUTPUT_BYTES, QUERY_STAGE.getShuffleOutputBytes());
    assertEquals(SHUFFLE_OUTPUT_BYTES_SPILLED, QUERY_STAGE.getShuffleOutputBytesSpilled());
    assertEquals(START_MS, QUERY_STAGE.getStartMs());
    assertEquals(STATUS, QUERY_STAGE.getStatus());
    assertEquals(STEPS, QUERY_STAGE.getSteps());
    assertEquals(WAIT_MS_AVG, QUERY_STAGE.getWaitMsAvg());
    assertEquals(WAIT_MS_MAX, QUERY_STAGE.getWaitMsMax());
    assertEquals(WAIT_RATIO_AVG, QUERY_STAGE.getWaitRatioAvg(), 0);
    assertEquals(WAIT_RATIO_MAX, QUERY_STAGE.getWaitRatioMax(), 0);
    assertEquals(WRITE_MS_AVG, QUERY_STAGE.getWriteMsAvg());
    assertEquals(WRITE_MS_MAX, QUERY_STAGE.getWriteMsMax());
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
    assertEquals(expected.getCompletedParallelInputs(), value.getCompletedParallelInputs());
    assertEquals(expected.getComputeMsAvg(), value.getComputeMsAvg());
    assertEquals(expected.getComputeMsMax(), value.getComputeMsMax());
    assertEquals(expected.getComputeRatioAvg(), value.getComputeRatioAvg(), 0);
    assertEquals(expected.getComputeRatioMax(), value.getComputeRatioMax(), 0);
    assertEquals(expected.getEndMs(), value.getEndMs());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getInputStages(), value.getInputStages());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getParallelInputs(), value.getParallelInputs());
    assertEquals(expected.getReadRatioAvg(), value.getReadRatioAvg(), 0);
    assertEquals(expected.getReadRatioMax(), value.getReadRatioMax(), 0);
    assertEquals(expected.getRecordsRead(), value.getRecordsRead());
    assertEquals(expected.getRecordsWritten(), value.getRecordsWritten());
    assertEquals(expected.getShuffleOutputBytes(), value.getShuffleOutputBytes());
    assertEquals(expected.getShuffleOutputBytesSpilled(), value.getShuffleOutputBytesSpilled());
    assertEquals(expected.getStartMs(), value.getStartMs());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getSteps(), value.getSteps());
    assertEquals(expected.getWaitMsAvg(), value.getWaitMsAvg());
    assertEquals(expected.getWaitMsMax(), value.getWaitMsMax());
    assertEquals(expected.getWaitRatioAvg(), value.getWaitRatioAvg(), 0);
    assertEquals(expected.getWaitRatioMax(), value.getWaitRatioMax(), 0);
    assertEquals(expected.getWriteMsAvg(), expected.getWriteMsAvg());
    assertEquals(expected.getWriteMsMax(), expected.getWriteMsMax());
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

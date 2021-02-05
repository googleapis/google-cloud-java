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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.cloud.bigquery.JobStatistics.CopyStatistics;
import com.google.cloud.bigquery.JobStatistics.ExtractStatistics;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.ReservationUsage;
import com.google.cloud.bigquery.JobStatistics.ScriptStatistics;
import com.google.cloud.bigquery.JobStatistics.ScriptStatistics.ScriptStackFrame;
import com.google.cloud.bigquery.QueryStage.QueryStep;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class JobStatisticsTest {

  private static final Integer BILLING_TIER = 42;
  private static final Boolean CACHE_HIT = true;
  private static final String DDL_OPERATION_PERFORMED = "SKIP";
  private static final String EVALUATIONKIND_TYPE_STATEMENT = "STATEMENT";
  private static final String EVALUATIONKIND_TYPE_EXPRESSION = "EXPRESSION";
  private static final TableId DDL_TARGET_TABLE = TableId.of("foo", "bar", "baz");
  private static final RoutineId DDL_TARGET_ROUTINE = RoutineId.of("alpha", "beta", "gamma");
  private static final Long ESTIMATE_BYTES_PROCESSED = 101L;
  private static final Long NUM_DML_AFFECTED_ROWS = 88L;
  private static final QueryStatistics.StatementType STATEMENT_TYPE =
      QueryStatistics.StatementType.SELECT;
  private static final Long TOTAL_BYTES_BILLED = 24L;
  private static final Long TOTAL_BYTES_PROCESSED = 42L;
  private static final Long TOTAL_PARTITION_PROCESSED = 63L;
  private static final Long TOTAL_SLOT_MS = 10202L;
  private static final Long INPUT_BYTES = 1L;
  private static final Long INPUT_FILES = 2L;
  private static final Long OUTPUT_BYTES = 3L;
  private static final Long OUTPUT_ROWS = 4L;
  private static final Long BAD_RECORDS = 1L;
  private static final List<TableId> REFERENCED_TABLES =
      ImmutableList.of(TableId.of("foo", "bar", "table1"), TableId.of("foo", "bar", "table2"));
  private static final List<Long> FILE_COUNT = ImmutableList.of(1L, 2L, 3L);
  private static final Long CREATION_TIME = 10L;
  private static final Long END_TIME = 20L;
  private static final Long START_TIME = 15L;
  private static final String NAME = "reservation-name";
  private static final Long SLOTMS = 12545L;
  private static final CopyStatistics COPY_STATISTICS =
      CopyStatistics.newBuilder()
          .setCreationTimestamp(CREATION_TIME)
          .setEndTime(END_TIME)
          .setStartTime(START_TIME)
          .build();
  private static final ExtractStatistics EXTRACT_STATISTICS =
      ExtractStatistics.newBuilder()
          .setCreationTimestamp(CREATION_TIME)
          .setEndTime(END_TIME)
          .setStartTime(START_TIME)
          .setDestinationUriFileCounts(FILE_COUNT)
          .build();
  private static final LoadStatistics LOAD_STATISTICS =
      LoadStatistics.newBuilder()
          .setCreationTimestamp(CREATION_TIME)
          .setEndTime(END_TIME)
          .setStartTime(START_TIME)
          .setInputBytes(INPUT_BYTES)
          .setInputFiles(INPUT_FILES)
          .setOutputBytes(OUTPUT_BYTES)
          .setOutputRows(OUTPUT_ROWS)
          .setBadRecords(BAD_RECORDS)
          .build();
  private static final LoadStatistics LOAD_STATISTICS_INCOMPLETE =
      LoadStatistics.newBuilder()
          .setCreationTimestamp(CREATION_TIME)
          .setEndTime(END_TIME)
          .setStartTime(START_TIME)
          .setInputBytes(INPUT_BYTES)
          .setInputFiles(INPUT_FILES)
          .setBadRecords(BAD_RECORDS)
          .build();
  private static final List<String> SUBSTEPS1 = ImmutableList.of("substep1", "substep2");
  private static final List<String> SUBSTEPS2 = ImmutableList.of("substep3", "substep4");
  private static final QueryStep QUERY_STEP1 = new QueryStep("KIND", SUBSTEPS1);
  private static final QueryStep QUERY_STEP2 = new QueryStep("KIND", SUBSTEPS2);
  private static final QueryStage QUERY_STAGE =
      QueryStage.newBuilder()
          .setComputeRatioAvg(1.1)
          .setComputeRatioMax(2.2)
          .setGeneratedId(42L)
          .setName("stage")
          .setReadRatioAvg(3.3)
          .setReadRatioMax(4.4)
          .setRecordsRead(5L)
          .setRecordsWritten(6L)
          .setSteps(ImmutableList.of(QUERY_STEP1, QUERY_STEP2))
          .setWaitRatioAvg(7.7)
          .setWaitRatioMax(8.8)
          .setWriteRatioAvg(9.9)
          .setWriteRatioMax(10.10)
          .build();

  private static final TimelineSample TIMELINE_SAMPLE1 =
      TimelineSample.newBuilder()
          .setElapsedMs(1001L)
          .setActiveUnits(100L)
          .setCompletedUnits(200L)
          .setPendingUnits(50L)
          .setSlotMillis(12345L)
          .build();
  private static final TimelineSample TIMELINE_SAMPLE2 =
      TimelineSample.newBuilder()
          .setElapsedMs(2002L)
          .setActiveUnits(48L)
          .setCompletedUnits(302L)
          .setPendingUnits(0L)
          .setSlotMillis(23456L)
          .build();
  private static final List<TimelineSample> TIMELINE =
      ImmutableList.of(TIMELINE_SAMPLE1, TIMELINE_SAMPLE2);
  private static final List<QueryStage> QUERY_PLAN = ImmutableList.of(QUERY_STAGE);
  private static final Schema SCHEMA = Schema.of(Field.of("column", LegacySQLTypeName.DATETIME));
  private static final QueryStatistics QUERY_STATISTICS =
      QueryStatistics.newBuilder()
          .setCreationTimestamp(CREATION_TIME)
          .setEndTime(END_TIME)
          .setStartTime(START_TIME)
          .setBillingTier(BILLING_TIER)
          .setCacheHit(CACHE_HIT)
          .setDDLOperationPerformed(DDL_OPERATION_PERFORMED)
          .setDDLTargetTable(DDL_TARGET_TABLE)
          .setDDLTargetRoutine(DDL_TARGET_ROUTINE)
          .setEstimatedBytesProcessed(ESTIMATE_BYTES_PROCESSED)
          .setNumDmlAffectedRows(NUM_DML_AFFECTED_ROWS)
          .setReferenceTables(REFERENCED_TABLES)
          .setStatementType(STATEMENT_TYPE)
          .setTotalBytesBilled(TOTAL_BYTES_BILLED)
          .setTotalBytesProcessed(TOTAL_BYTES_PROCESSED)
          .setTotalPartitionsProcessed(TOTAL_PARTITION_PROCESSED)
          .setTotalSlotMs(TOTAL_SLOT_MS)
          .setQueryPlan(QUERY_PLAN)
          .setTimeline(TIMELINE)
          .setSchema(SCHEMA)
          .build();
  private static final QueryStatistics QUERY_STATISTICS_INCOMPLETE =
      QueryStatistics.newBuilder()
          .setCreationTimestamp(CREATION_TIME)
          .setEndTime(END_TIME)
          .setStartTime(START_TIME)
          .setBillingTier(BILLING_TIER)
          .setCacheHit(CACHE_HIT)
          .build();
  private static final ScriptStackFrame STATEMENT_STACK_FRAME =
      ScriptStackFrame.newBuilder()
          .setEndColumn(2)
          .setEndLine(16)
          .setProcedureId("test-procedureId")
          .setStartColumn(1)
          .setStartLine(16)
          .setText(
              "SELECT\n"
                  + "  name AS shakespeare_name\n"
                  + "FROM UNNEST(top_names) AS name\n"
                  + "WHERE name IN (\n"
                  + "  SELECT word\n"
                  + "  FROM `bigquery-public-data`.samples.shakespeare\n"
                  + ")")
          .build();
  private static final ScriptStackFrame EXPRESSION_STACK_FRAME =
      ScriptStackFrame.newBuilder()
          .setEndColumn(2)
          .setEndLine(8)
          .setProcedureId("test-procedureId")
          .setStartColumn(17)
          .setStartLine(4)
          .setText(
              "SELECT ARRAY_AGG(name ORDER BY number DESC LIMIT 100)\n"
                  + "  FROM `bigquery-public-data`.usa_names.usa_1910_current\n"
                  + "  WHERE year = 2017")
          .build();
  private static final ScriptStatistics STATEMENT_SCRIPT_STATISTICS =
      ScriptStatistics.newBuilder()
          .setEvaluationKind(EVALUATIONKIND_TYPE_STATEMENT)
          .setStackFrames(ImmutableList.of(STATEMENT_STACK_FRAME))
          .build();
  private static final ScriptStatistics EXPRESSION_SCRIPT_STATISTICS =
      ScriptStatistics.newBuilder()
          .setEvaluationKind(EVALUATIONKIND_TYPE_EXPRESSION)
          .setStackFrames(ImmutableList.of(EXPRESSION_STACK_FRAME))
          .build();
  private static final ReservationUsage RESERVATION_USAGE =
      ReservationUsage.newBuilder().setName(NAME).setSlotMs(SLOTMS).build();

  @Test
  public void testBuilder() {
    assertEquals(CREATION_TIME, EXTRACT_STATISTICS.getCreationTime());
    assertEquals(START_TIME, EXTRACT_STATISTICS.getStartTime());
    assertEquals(END_TIME, EXTRACT_STATISTICS.getEndTime());
    assertEquals(FILE_COUNT, EXTRACT_STATISTICS.getDestinationUriFileCounts());

    assertEquals(CREATION_TIME, LOAD_STATISTICS.getCreationTime());
    assertEquals(START_TIME, LOAD_STATISTICS.getStartTime());
    assertEquals(END_TIME, LOAD_STATISTICS.getEndTime());
    assertEquals(INPUT_BYTES, LOAD_STATISTICS.getInputBytes());
    assertEquals(INPUT_FILES, LOAD_STATISTICS.getInputFiles());
    assertEquals(OUTPUT_BYTES, LOAD_STATISTICS.getOutputBytes());
    assertEquals(OUTPUT_ROWS, LOAD_STATISTICS.getOutputRows());
    assertEquals(BAD_RECORDS, LOAD_STATISTICS.getBadRecords());

    assertEquals(CREATION_TIME, QUERY_STATISTICS.getCreationTime());
    assertEquals(START_TIME, QUERY_STATISTICS.getStartTime());
    assertEquals(END_TIME, QUERY_STATISTICS.getEndTime());
    assertEquals(BILLING_TIER, QUERY_STATISTICS.getBillingTier());
    assertEquals(CACHE_HIT, QUERY_STATISTICS.getCacheHit());
    assertEquals(DDL_OPERATION_PERFORMED, QUERY_STATISTICS.getDdlOperationPerformed());
    assertEquals(DDL_TARGET_TABLE, QUERY_STATISTICS.getDdlTargetTable());
    assertEquals(DDL_TARGET_ROUTINE, QUERY_STATISTICS.getDdlTargetRoutine());
    assertEquals(ESTIMATE_BYTES_PROCESSED, QUERY_STATISTICS.getEstimatedBytesProcessed());
    assertEquals(NUM_DML_AFFECTED_ROWS, QUERY_STATISTICS.getNumDmlAffectedRows());
    assertEquals(REFERENCED_TABLES, QUERY_STATISTICS.getReferencedTables());
    assertEquals(STATEMENT_TYPE, QUERY_STATISTICS.getStatementType());
    assertEquals(TOTAL_BYTES_BILLED, QUERY_STATISTICS.getTotalBytesBilled());
    assertEquals(TOTAL_BYTES_PROCESSED, QUERY_STATISTICS.getTotalBytesProcessed());
    assertEquals(TOTAL_PARTITION_PROCESSED, QUERY_STATISTICS.getTotalPartitionsProcessed());
    assertEquals(TOTAL_SLOT_MS, QUERY_STATISTICS.getTotalSlotMs());
    assertEquals(QUERY_PLAN, QUERY_STATISTICS.getQueryPlan());
    assertEquals(TIMELINE, QUERY_STATISTICS.getTimeline());

    assertEquals(CREATION_TIME, LOAD_STATISTICS_INCOMPLETE.getCreationTime());
    assertEquals(START_TIME, LOAD_STATISTICS_INCOMPLETE.getStartTime());
    assertEquals(END_TIME, LOAD_STATISTICS_INCOMPLETE.getEndTime());
    assertEquals(INPUT_BYTES, LOAD_STATISTICS_INCOMPLETE.getInputBytes());
    assertEquals(INPUT_FILES, LOAD_STATISTICS_INCOMPLETE.getInputFiles());
    assertEquals(BAD_RECORDS, LOAD_STATISTICS_INCOMPLETE.getBadRecords());
    assertEquals(null, LOAD_STATISTICS_INCOMPLETE.getOutputBytes());
    assertEquals(null, LOAD_STATISTICS_INCOMPLETE.getOutputRows());

    assertEquals(CREATION_TIME, QUERY_STATISTICS_INCOMPLETE.getCreationTime());
    assertEquals(START_TIME, QUERY_STATISTICS_INCOMPLETE.getStartTime());
    assertEquals(END_TIME, QUERY_STATISTICS_INCOMPLETE.getEndTime());
    assertEquals(BILLING_TIER, QUERY_STATISTICS_INCOMPLETE.getBillingTier());
    assertEquals(CACHE_HIT, QUERY_STATISTICS_INCOMPLETE.getCacheHit());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getDdlOperationPerformed());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getDdlTargetTable());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getDdlTargetRoutine());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getEstimatedBytesProcessed());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getNumDmlAffectedRows());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getTotalBytesBilled());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getTotalBytesProcessed());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getTotalPartitionsProcessed());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getTotalSlotMs());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getReferencedTables());
    assertEquals(null, QUERY_STATISTICS_INCOMPLETE.getQueryPlan());

    assertEquals(EVALUATIONKIND_TYPE_STATEMENT, STATEMENT_SCRIPT_STATISTICS.getEvaluationKind());
    assertEquals(
        ImmutableList.of(STATEMENT_STACK_FRAME), STATEMENT_SCRIPT_STATISTICS.getStackFrames());
    assertEquals(EVALUATIONKIND_TYPE_EXPRESSION, EXPRESSION_SCRIPT_STATISTICS.getEvaluationKind());
    assertEquals(
        ImmutableList.of(EXPRESSION_STACK_FRAME), EXPRESSION_SCRIPT_STATISTICS.getStackFrames());
    assertEquals(NAME, RESERVATION_USAGE.getName());
    assertEquals(SLOTMS, RESERVATION_USAGE.getSlotMs());
  }

  @Test
  public void testToPbAndFromPb() {
    compareExtractStatistics(
        EXTRACT_STATISTICS, ExtractStatistics.fromPb(EXTRACT_STATISTICS.toPb()));
    compareLoadStatistics(LOAD_STATISTICS, LoadStatistics.fromPb(LOAD_STATISTICS.toPb()));
    compareQueryStatistics(QUERY_STATISTICS, QueryStatistics.fromPb(QUERY_STATISTICS.toPb()));
    compareStatistics(COPY_STATISTICS, CopyStatistics.fromPb(COPY_STATISTICS.toPb()));

    compareLoadStatistics(
        LOAD_STATISTICS_INCOMPLETE, LoadStatistics.fromPb(LOAD_STATISTICS_INCOMPLETE.toPb()));
    compareQueryStatistics(
        QUERY_STATISTICS_INCOMPLETE, QueryStatistics.fromPb(QUERY_STATISTICS_INCOMPLETE.toPb()));
    compareScriptStatistics(
        STATEMENT_SCRIPT_STATISTICS, ScriptStatistics.fromPb(STATEMENT_SCRIPT_STATISTICS.toPb()));
    compareScriptStatistics(
        EXPRESSION_SCRIPT_STATISTICS, ScriptStatistics.fromPb(EXPRESSION_SCRIPT_STATISTICS.toPb()));
    for (ScriptStackFrame stackFrame : STATEMENT_SCRIPT_STATISTICS.getStackFrames()) {
      compareStackFrames(stackFrame, ScriptStackFrame.fromPb(stackFrame.toPb()));
    }
    for (ScriptStackFrame stackFrame : EXPRESSION_SCRIPT_STATISTICS.getStackFrames()) {
      compareStackFrames(stackFrame, ScriptStackFrame.fromPb(stackFrame.toPb()));
    }
    compareReservation(RESERVATION_USAGE, ReservationUsage.fromPb(RESERVATION_USAGE.toPb()));
  }

  @Test
  public void testIncomplete() {
    // https://github.com/googleapis/google-cloud-java/issues/2357
    com.google.api.services.bigquery.model.Job job =
        new com.google.api.services.bigquery.model.Job()
            .setStatistics(
                new com.google.api.services.bigquery.model.JobStatistics()
                    .setCreationTime(1234L)
                    .setStartTime(5678L));

    job.setConfiguration(
        new com.google.api.services.bigquery.model.JobConfiguration()
            .setCopy(new com.google.api.services.bigquery.model.JobConfigurationTableCopy()));
    assertThat(JobStatistics.fromPb(job)).isInstanceOf(CopyStatistics.class);

    job.setConfiguration(
        new com.google.api.services.bigquery.model.JobConfiguration()
            .setLoad(new com.google.api.services.bigquery.model.JobConfigurationLoad()));
    assertThat(JobStatistics.fromPb(job)).isInstanceOf(LoadStatistics.class);

    job.setConfiguration(
        new com.google.api.services.bigquery.model.JobConfiguration()
            .setExtract(new com.google.api.services.bigquery.model.JobConfigurationExtract()));
    assertThat(JobStatistics.fromPb(job)).isInstanceOf(ExtractStatistics.class);

    job.setConfiguration(
        new com.google.api.services.bigquery.model.JobConfiguration()
            .setQuery(new com.google.api.services.bigquery.model.JobConfigurationQuery()));
    assertThat(JobStatistics.fromPb(job)).isInstanceOf(QueryStatistics.class);
  }

  private void compareExtractStatistics(ExtractStatistics expected, ExtractStatistics value) {
    assertEquals(expected, value);
    compareStatistics(expected, value);
    assertEquals(expected.getDestinationUriFileCounts(), value.getDestinationUriFileCounts());
  }

  private void compareLoadStatistics(LoadStatistics expected, LoadStatistics value) {
    assertEquals(expected, value);
    compareStatistics(expected, value);
    assertEquals(expected.getInputBytes(), value.getInputBytes());
    assertEquals(expected.getInputFiles(), value.getInputFiles());
    assertEquals(expected.getOutputBytes(), value.getOutputBytes());
    assertEquals(expected.getOutputRows(), value.getOutputRows());
  }

  private void compareQueryStatistics(QueryStatistics expected, QueryStatistics value) {
    assertEquals(expected, value);
    compareStatistics(expected, value);
    assertEquals(expected.getBillingTier(), value.getBillingTier());
    assertEquals(expected.getCacheHit(), value.getCacheHit());
    assertEquals(expected.getDdlOperationPerformed(), value.getDdlOperationPerformed());
    assertEquals(expected.getDdlTargetTable(), value.getDdlTargetTable());
    assertEquals(expected.getDdlTargetRoutine(), value.getDdlTargetRoutine());
    assertEquals(expected.getEstimatedBytesProcessed(), value.getEstimatedBytesProcessed());
    assertEquals(expected.getTotalBytesBilled(), value.getTotalBytesBilled());
    assertEquals(expected.getTotalBytesProcessed(), value.getTotalBytesProcessed());
    assertEquals(expected.getTotalPartitionsProcessed(), value.getTotalPartitionsProcessed());
    assertEquals(expected.getTotalSlotMs(), value.getTotalSlotMs());
    assertEquals(expected.getQueryPlan(), value.getQueryPlan());
    assertEquals(expected.getReferencedTables(), value.getReferencedTables());
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getStatementType(), value.getStatementType());
    assertEquals(expected.getTimeline(), value.getTimeline());
  }

  private void compareStatistics(JobStatistics expected, JobStatistics value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getEndTime(), value.getEndTime());
    assertEquals(expected.getStartTime(), value.getStartTime());
    assertEquals(expected.getNumChildJobs(), value.getNumChildJobs());
    assertEquals(expected.getParentJobId(), value.getParentJobId());
    assertEquals(expected.getScriptStatistics(), value.getScriptStatistics());
  }

  private void compareScriptStatistics(ScriptStatistics expected, ScriptStatistics value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), expected.toString());
    assertEquals(expected.getEvaluationKind(), value.getEvaluationKind());
    assertEquals(expected.getStackFrames(), value.getStackFrames());
  }

  private void compareStackFrames(
      ScriptStatistics.ScriptStackFrame expected, ScriptStatistics.ScriptStackFrame value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getEndColumn(), value.getEndColumn());
    assertEquals(expected.getEndLine(), value.getEndLine());
    assertEquals(expected.getProcedureId(), value.getProcedureId());
    assertEquals(expected.getStartColumn(), value.getStartColumn());
    assertEquals(expected.getStartLine(), value.getStartLine());
    assertEquals(expected.getText(), value.getText());
  }

  private void compareReservation(ReservationUsage expected, ReservationUsage value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.toPb(), value.toPb());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getSlotMs(), value.getSlotMs());
  }
}

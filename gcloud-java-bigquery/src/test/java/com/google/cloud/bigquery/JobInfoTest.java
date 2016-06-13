/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.JobStatistics.ExtractStatistics;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class JobInfoTest {

  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final JobId JOB_ID = JobId.of("job");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final JobStatistics COPY_JOB_STATISTICS = JobStatistics.builder()
      .creationTime(1L)
      .endTime(3L)
      .startTime(2L)
      .build();
  private static final ExtractStatistics EXTRACT_JOB_STATISTICS =
      ExtractStatistics.builder()
          .creationTime(1L)
          .endTime(3L)
          .startTime(2L)
          .destinationUriFileCounts(ImmutableList.of(42L))
          .build();
  private static final LoadStatistics LOAD_JOB_STATISTICS =
      LoadStatistics.builder()
          .creationTime(1L)
          .endTime(3L)
          .startTime(2L)
          .inputFiles(42L)
          .outputBytes(1024L)
          .inputBytes(2048L)
          .outputRows(24L)
          .build();
  private static final QueryStatistics QUERY_JOB_STATISTICS =
      QueryStatistics.builder()
          .creationTime(1L)
          .endTime(3L)
          .startTime(2L)
          .totalBytesProcessed(2048L)
          .totalBytesBilled(1024L)
          .cacheHit(false)
          .billingTier(42)
          .build();
  private static final TableId SOURCE_TABLE = TableId.of("dataset", "sourceTable");
  private static final TableId DESTINATION_TABLE = TableId.of("dataset", "destinationTable");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final CopyJobConfiguration COPY_CONFIGURATION =
      CopyJobConfiguration.builder(DESTINATION_TABLE, SOURCE_TABLE)
          .createDisposition(CREATE_DISPOSITION)
          .writeDisposition(WRITE_DISPOSITION)
          .build();
  private static final List<String> DESTINATION_URIS = ImmutableList.of("uri1", "uri2");
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.builder("IntegerField", Field.Type.integer())
          .mode(Field.Mode.REPEATED)
          .description("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.builder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .mode(Field.Mode.REQUIRED)
          .description("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final String FIELD_DELIMITER = ",";
  private static final String FORMAT = "CSV";
  private static final Boolean PRINT_HEADER = true;
  private static final String COMPRESSION = "GZIP";
  private static final ExtractJobConfiguration EXTRACT_CONFIGURATION =
      ExtractJobConfiguration.builder(TABLE_ID, DESTINATION_URIS)
          .printHeader(PRINT_HEADER)
          .fieldDelimiter(FIELD_DELIMITER)
          .compression(COMPRESSION)
          .format(FORMAT)
          .build();
  private static final List<String> PROJECTION_FIELDS = ImmutableList.of("field1", "field2");
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder().build();
  private static final ExternalTableDefinition TABLE_CONFIGURATION =
      ExternalTableDefinition.builder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .compression(COMPRESSION)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .maxBadRecords(MAX_BAD_RECORDS)
          .build();
  private static final LoadJobConfiguration LOAD_CONFIGURATION =
      LoadJobConfiguration.builder(TABLE_ID, SOURCE_URIS)
          .createDisposition(CREATE_DISPOSITION)
          .writeDisposition(WRITE_DISPOSITION)
          .formatOptions(CSV_OPTIONS)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .maxBadRecords(MAX_BAD_RECORDS)
          .projectionFields(PROJECTION_FIELDS)
          .schema(TABLE_SCHEMA)
          .build();
  private static final String QUERY = "BigQuery SQL";
  private static final Map<String, ExternalTableDefinition> TABLE_DEFINITIONS =
      ImmutableMap.of("tableName", TABLE_CONFIGURATION);
  private static final QueryJobConfiguration.Priority PRIORITY =
      QueryJobConfiguration.Priority.BATCH;
  private static final boolean ALLOW_LARGE_RESULTS = true;
  private static final boolean USE_QUERY_CACHE = false;
  private static final boolean FLATTEN_RESULTS = true;
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS = ImmutableList.of(
      UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final QueryJobConfiguration QUERY_CONFIGURATION =
      QueryJobConfiguration.builder(QUERY)
          .useQueryCache(USE_QUERY_CACHE)
          .tableDefinitions(TABLE_DEFINITIONS)
          .allowLargeResults(ALLOW_LARGE_RESULTS)
          .createDisposition(CREATE_DISPOSITION)
          .defaultDataset(DATASET_ID)
          .destinationTable(TABLE_ID)
          .writeDisposition(WRITE_DISPOSITION)
          .priority(PRIORITY)
          .flattenResults(FLATTEN_RESULTS)
          .userDefinedFunctions(USER_DEFINED_FUNCTIONS)
          .dryRun(true)
          .build();
  private static final JobInfo COPY_JOB = JobInfo.builder(COPY_CONFIGURATION)
      .jobId(JOB_ID)
      .statistics(COPY_JOB_STATISTICS)
      .jobId(JOB_ID)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .selfLink(SELF_LINK)
      .userEmail(EMAIL)
      .status(JOB_STATUS)
      .build();
  private static final JobInfo EXTRACT_JOB = JobInfo.builder(EXTRACT_CONFIGURATION)
      .jobId(JOB_ID)
      .statistics(EXTRACT_JOB_STATISTICS)
      .jobId(JOB_ID)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .selfLink(SELF_LINK)
      .userEmail(EMAIL)
      .status(JOB_STATUS)
      .build();
  private static final JobInfo LOAD_JOB = JobInfo.builder(LOAD_CONFIGURATION)
      .jobId(JOB_ID)
      .statistics(LOAD_JOB_STATISTICS)
      .jobId(JOB_ID)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .selfLink(SELF_LINK)
      .userEmail(EMAIL)
      .status(JOB_STATUS)
      .build();
  private static final JobInfo QUERY_JOB = JobInfo.builder(QUERY_CONFIGURATION)
      .jobId(JOB_ID)
      .statistics(QUERY_JOB_STATISTICS)
      .jobId(JOB_ID)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .selfLink(SELF_LINK)
      .userEmail(EMAIL)
      .status(JOB_STATUS)
      .build();


  @Test
  public void testToBuilder() {
    compareJobInfo(COPY_JOB, COPY_JOB.toBuilder().build());
    compareJobInfo(EXTRACT_JOB, EXTRACT_JOB.toBuilder().build());
    compareJobInfo(LOAD_JOB, LOAD_JOB.toBuilder().build());
    compareJobInfo(QUERY_JOB, QUERY_JOB.toBuilder().build());
    JobInfo job = COPY_JOB.toBuilder()
        .userEmail("newEmail")
        .build();
    assertEquals("newEmail", job.userEmail());
    job = job.toBuilder().userEmail(EMAIL).build();
    compareJobInfo(COPY_JOB, job);
    job = EXTRACT_JOB.toBuilder()
        .userEmail("newEmail")
        .build();
    assertEquals("newEmail", job.userEmail());
    job = job.toBuilder().userEmail(EMAIL).build();
    compareJobInfo(EXTRACT_JOB, job);
    job = LOAD_JOB.toBuilder()
        .userEmail("newEmail")
        .build();
    assertEquals("newEmail", job.userEmail());
    job = job.toBuilder().userEmail(EMAIL).build();
    compareJobInfo(LOAD_JOB, job);
    job = QUERY_JOB.toBuilder()
        .userEmail("newEmail")
        .build();
    assertEquals("newEmail", job.userEmail());
    job = job.toBuilder().userEmail(EMAIL).build();
    compareJobInfo(QUERY_JOB, job);
  }

  @Test
  public void testOf() {
    JobInfo job = JobInfo.of(COPY_CONFIGURATION);
    assertEquals(COPY_CONFIGURATION, job.configuration());
    job = JobInfo.of(EXTRACT_CONFIGURATION);
    assertEquals(EXTRACT_CONFIGURATION, job.configuration());
    job = JobInfo.of(LOAD_CONFIGURATION);
    assertEquals(LOAD_CONFIGURATION, job.configuration());
    job = JobInfo.of(QUERY_CONFIGURATION);
    assertEquals(QUERY_CONFIGURATION, job.configuration());
    job = JobInfo.of(JOB_ID, COPY_CONFIGURATION);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(COPY_CONFIGURATION, job.configuration());
    job = JobInfo.of(JOB_ID, EXTRACT_CONFIGURATION);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(EXTRACT_CONFIGURATION, job.configuration());
    job = JobInfo.of(JOB_ID, LOAD_CONFIGURATION);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(LOAD_CONFIGURATION, job.configuration());
    job = JobInfo.of(JOB_ID, QUERY_CONFIGURATION);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(QUERY_CONFIGURATION, job.configuration());

  }

  @Test
  public void testToBuilderIncomplete() {
    JobInfo job = JobInfo.of(COPY_CONFIGURATION);
    compareJobInfo(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, COPY_JOB.etag());
    assertEquals(GENERATED_ID, COPY_JOB.generatedId());
    assertEquals(SELF_LINK, COPY_JOB.selfLink());
    assertEquals(EMAIL, COPY_JOB.userEmail());
    assertEquals(JOB_ID, COPY_JOB.jobId());
    assertEquals(JOB_STATUS, COPY_JOB.status());
    assertEquals(COPY_CONFIGURATION, COPY_JOB.configuration());
    assertEquals(COPY_JOB_STATISTICS, COPY_JOB.statistics());

    assertEquals(ETAG, EXTRACT_JOB.etag());
    assertEquals(GENERATED_ID, EXTRACT_JOB.generatedId());
    assertEquals(SELF_LINK, EXTRACT_JOB.selfLink());
    assertEquals(EMAIL, EXTRACT_JOB.userEmail());
    assertEquals(JOB_ID, EXTRACT_JOB.jobId());
    assertEquals(JOB_STATUS, EXTRACT_JOB.status());
    assertEquals(EXTRACT_CONFIGURATION, EXTRACT_JOB.configuration());
    assertEquals(EXTRACT_JOB_STATISTICS, EXTRACT_JOB.statistics());

    assertEquals(ETAG, LOAD_JOB.etag());
    assertEquals(GENERATED_ID, LOAD_JOB.generatedId());
    assertEquals(SELF_LINK, LOAD_JOB.selfLink());
    assertEquals(EMAIL, LOAD_JOB.userEmail());
    assertEquals(JOB_ID, LOAD_JOB.jobId());
    assertEquals(JOB_STATUS, LOAD_JOB.status());
    assertEquals(LOAD_CONFIGURATION, LOAD_JOB.configuration());
    assertEquals(LOAD_JOB_STATISTICS, LOAD_JOB.statistics());

    assertEquals(ETAG, QUERY_JOB.etag());
    assertEquals(GENERATED_ID, QUERY_JOB.generatedId());
    assertEquals(SELF_LINK, QUERY_JOB.selfLink());
    assertEquals(EMAIL, QUERY_JOB.userEmail());
    assertEquals(JOB_ID, QUERY_JOB.jobId());
    assertEquals(JOB_STATUS, QUERY_JOB.status());
    assertEquals(QUERY_CONFIGURATION, QUERY_JOB.configuration());
    assertEquals(QUERY_JOB_STATISTICS, QUERY_JOB.statistics());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(COPY_JOB.toPb().getConfiguration().getCopy());
    assertNull(COPY_JOB.toPb().getConfiguration().getExtract());
    assertNull(COPY_JOB.toPb().getConfiguration().getLoad());
    assertNull(COPY_JOB.toPb().getConfiguration().getQuery());
    assertEquals(COPY_JOB_STATISTICS, JobStatistics.fromPb(COPY_JOB.statistics().toPb()));
    compareJobInfo(COPY_JOB, JobInfo.fromPb(COPY_JOB.toPb()));
    assertTrue(JobInfo.fromPb(COPY_JOB.toPb()).configuration() instanceof CopyJobConfiguration);
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getCopy());
    assertNotNull(EXTRACT_JOB.toPb().getConfiguration().getExtract());
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getLoad());
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getQuery());
    assertEquals(EXTRACT_JOB_STATISTICS, JobStatistics.fromPb(EXTRACT_JOB.statistics().toPb()));
    compareJobInfo(EXTRACT_JOB, JobInfo.fromPb(EXTRACT_JOB.toPb()));
    assertTrue(
        JobInfo.fromPb(EXTRACT_JOB.toPb()).configuration() instanceof ExtractJobConfiguration);
    assertTrue(JobInfo.fromPb(EXTRACT_JOB.toPb()).statistics() instanceof ExtractStatistics);
    assertNull(LOAD_JOB.toPb().getConfiguration().getCopy());
    assertNull(LOAD_JOB.toPb().getConfiguration().getExtract());
    assertNotNull(LOAD_JOB.toPb().getConfiguration().getLoad());
    assertNull(LOAD_JOB.toPb().getConfiguration().getQuery());
    assertEquals(LOAD_JOB_STATISTICS, JobStatistics.fromPb(LOAD_JOB.statistics().toPb()));
    compareJobInfo(LOAD_JOB, JobInfo.fromPb(LOAD_JOB.toPb()));
    assertTrue(JobInfo.fromPb(LOAD_JOB.toPb()).configuration() instanceof LoadJobConfiguration);
    assertTrue(JobInfo.fromPb(LOAD_JOB.toPb()).statistics() instanceof LoadStatistics);
    assertNull(QUERY_JOB.toPb().getConfiguration().getCopy());
    assertNull(QUERY_JOB.toPb().getConfiguration().getExtract());
    assertNull(QUERY_JOB.toPb().getConfiguration().getLoad());
    assertNotNull(QUERY_JOB.toPb().getConfiguration().getQuery());
    assertEquals(QUERY_JOB_STATISTICS, JobStatistics.fromPb(QUERY_JOB.statistics().toPb()));
    compareJobInfo(QUERY_JOB, JobInfo.fromPb(QUERY_JOB.toPb()));
    assertTrue(JobInfo.fromPb(QUERY_JOB.toPb()).configuration() instanceof QueryJobConfiguration);
    assertTrue(JobInfo.fromPb(QUERY_JOB.toPb()).statistics() instanceof QueryStatistics);
  }

  @Test
  public void testSetProjectId() {
    CopyJobConfiguration copyConfiguration = COPY_JOB.setProjectId("p").configuration();
    assertEquals("p", copyConfiguration.destinationTable().project());
    for (TableId sourceTable : copyConfiguration.sourceTables()) {
      assertEquals("p", sourceTable.project());
    }
    ExtractJobConfiguration extractConfiguration = EXTRACT_JOB.setProjectId("p").configuration();
    assertEquals("p", extractConfiguration.sourceTable().project());
    LoadJobConfiguration loadConfiguration = LOAD_JOB.setProjectId("p").configuration();
    assertEquals("p", loadConfiguration.destinationTable().project());
    QueryJobConfiguration queryConfiguration = QUERY_JOB.setProjectId("p").configuration();
    assertEquals("p", queryConfiguration.defaultDataset().project());
    assertEquals("p", queryConfiguration.destinationTable().project());
  }

  private void compareJobInfo(JobInfo expected, JobInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.jobId(), value.jobId());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.statistics(), value.statistics());
    assertEquals(expected.userEmail(), value.userEmail());
    assertEquals(expected.configuration(), value.configuration());
  }
}

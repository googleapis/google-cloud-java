/*
 * Copyright 2016 Google LLC
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

import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.JobStatistics.CopyStatistics;
import com.google.cloud.bigquery.JobStatistics.ExtractStatistics;
import com.google.cloud.bigquery.JobStatistics.LoadStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class JobInfoTest {

  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final JobId JOB_ID = JobId.of("job");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final CopyStatistics COPY_JOB_STATISTICS =
      CopyStatistics.newBuilder().setCreationTimestamp(1L).setEndTime(3L).setStartTime(2L).build();
  private static final ExtractStatistics EXTRACT_JOB_STATISTICS =
      ExtractStatistics.newBuilder()
          .setCreationTimestamp(1L)
          .setEndTime(3L)
          .setStartTime(2L)
          .setDestinationUriFileCounts(ImmutableList.of(42L))
          .build();
  private static final LoadStatistics LOAD_JOB_STATISTICS =
      LoadStatistics.newBuilder()
          .setCreationTimestamp(1L)
          .setEndTime(3L)
          .setStartTime(2L)
          .setInputFiles(42L)
          .setOutputBytes(1024L)
          .setInputBytes(2048L)
          .setOutputRows(24L)
          .build();
  private static final QueryStatistics QUERY_JOB_STATISTICS =
      QueryStatistics.newBuilder()
          .setCreationTimestamp(1L)
          .setEndTime(3L)
          .setStartTime(2L)
          .setTotalBytesProcessed(2048L)
          .setTotalBytesBilled(1024L)
          .setCacheHit(false)
          .setBillingTier(42)
          .build();
  private static final TableId SOURCE_TABLE = TableId.of("dataset", "sourceTable");
  private static final TableId DESTINATION_TABLE = TableId.of("dataset", "destinationTable");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final CopyJobConfiguration COPY_CONFIGURATION =
      CopyJobConfiguration.newBuilder(DESTINATION_TABLE, SOURCE_TABLE)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .build();
  private static final List<String> DESTINATION_URIS = ImmutableList.of("uri1", "uri2");
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", LegacySQLTypeName.RECORD, FIELD_SCHEMA1, FIELD_SCHEMA2)
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final String FIELD_DELIMITER = ",";
  private static final String FORMAT = "CSV";
  private static final Boolean PRINT_HEADER = true;
  private static final String COMPRESSION = "GZIP";
  private static final ExtractJobConfiguration EXTRACT_CONFIGURATION =
      ExtractJobConfiguration.newBuilder(TABLE_ID, DESTINATION_URIS)
          .setPrintHeader(PRINT_HEADER)
          .setFieldDelimiter(FIELD_DELIMITER)
          .setCompression(COMPRESSION)
          .setFormat(FORMAT)
          .build();
  private static final List<String> PROJECTION_FIELDS = ImmutableList.of("field1", "field2");
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final CsvOptions CSV_OPTIONS = CsvOptions.newBuilder().build();
  private static final List<SchemaUpdateOption> SCHEMA_UPDATE_OPTIONS =
      ImmutableList.of(SchemaUpdateOption.ALLOW_FIELD_ADDITION);
  private static final ExternalTableDefinition TABLE_CONFIGURATION =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .setCompression(COMPRESSION)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .build();
  private static final LoadJobConfiguration LOAD_CONFIGURATION =
      LoadJobConfiguration.newBuilder(TABLE_ID, SOURCE_URIS)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setFormatOptions(CSV_OPTIONS)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setSchema(TABLE_SCHEMA)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .build();
  private static final String QUERY = "BigQuery SQL";
  private static final Map<String, ExternalTableDefinition> TABLE_DEFINITIONS =
      ImmutableMap.of("tableName", TABLE_CONFIGURATION);
  private static final QueryJobConfiguration.Priority PRIORITY =
      QueryJobConfiguration.Priority.BATCH;
  private static final boolean ALLOW_LARGE_RESULTS = true;
  private static final boolean USE_QUERY_CACHE = false;
  private static final boolean FLATTEN_RESULTS = true;
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS =
      ImmutableList.of(UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final QueryJobConfiguration QUERY_CONFIGURATION =
      QueryJobConfiguration.newBuilder(QUERY)
          .setUseQueryCache(USE_QUERY_CACHE)
          .setTableDefinitions(TABLE_DEFINITIONS)
          .setAllowLargeResults(ALLOW_LARGE_RESULTS)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setDefaultDataset(DATASET_ID)
          .setDestinationTable(TABLE_ID)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setPriority(PRIORITY)
          .setFlattenResults(FLATTEN_RESULTS)
          .setUserDefinedFunctions(USER_DEFINED_FUNCTIONS)
          .setDryRun(true)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .build();
  private static final JobInfo COPY_JOB =
      JobInfo.newBuilder(COPY_CONFIGURATION)
          .setJobId(JOB_ID)
          .setStatistics(COPY_JOB_STATISTICS)
          .setJobId(JOB_ID)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setSelfLink(SELF_LINK)
          .setUserEmail(EMAIL)
          .setStatus(JOB_STATUS)
          .build();
  private static final JobInfo EXTRACT_JOB =
      JobInfo.newBuilder(EXTRACT_CONFIGURATION)
          .setJobId(JOB_ID)
          .setStatistics(EXTRACT_JOB_STATISTICS)
          .setJobId(JOB_ID)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setSelfLink(SELF_LINK)
          .setUserEmail(EMAIL)
          .setStatus(JOB_STATUS)
          .build();
  private static final JobInfo LOAD_JOB =
      JobInfo.newBuilder(LOAD_CONFIGURATION)
          .setJobId(JOB_ID)
          .setStatistics(LOAD_JOB_STATISTICS)
          .setJobId(JOB_ID)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setSelfLink(SELF_LINK)
          .setUserEmail(EMAIL)
          .setStatus(JOB_STATUS)
          .build();
  private static final JobInfo QUERY_JOB =
      JobInfo.newBuilder(QUERY_CONFIGURATION)
          .setJobId(JOB_ID)
          .setStatistics(QUERY_JOB_STATISTICS)
          .setJobId(JOB_ID)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setSelfLink(SELF_LINK)
          .setUserEmail(EMAIL)
          .setStatus(JOB_STATUS)
          .build();

  @Test
  public void testToBuilder() {
    compareJobInfo(COPY_JOB, COPY_JOB.toBuilder().build());
    compareJobInfo(EXTRACT_JOB, EXTRACT_JOB.toBuilder().build());
    compareJobInfo(LOAD_JOB, LOAD_JOB.toBuilder().build());
    compareJobInfo(QUERY_JOB, QUERY_JOB.toBuilder().build());
    JobInfo job = COPY_JOB.toBuilder().setUserEmail("newEmail").build();
    assertEquals("newEmail", job.getUserEmail());
    job = job.toBuilder().setUserEmail(EMAIL).build();
    compareJobInfo(COPY_JOB, job);
    job = EXTRACT_JOB.toBuilder().setUserEmail("newEmail").build();
    assertEquals("newEmail", job.getUserEmail());
    job = job.toBuilder().setUserEmail(EMAIL).build();
    compareJobInfo(EXTRACT_JOB, job);
    job = LOAD_JOB.toBuilder().setUserEmail("newEmail").build();
    assertEquals("newEmail", job.getUserEmail());
    job = job.toBuilder().setUserEmail(EMAIL).build();
    compareJobInfo(LOAD_JOB, job);
    job = QUERY_JOB.toBuilder().setUserEmail("newEmail").build();
    assertEquals("newEmail", job.getUserEmail());
    job = job.toBuilder().setUserEmail(EMAIL).build();
    compareJobInfo(QUERY_JOB, job);
  }

  @Test
  public void testOf() {
    JobInfo job = JobInfo.of(COPY_CONFIGURATION);
    assertEquals(COPY_CONFIGURATION, job.getConfiguration());
    job = JobInfo.of(EXTRACT_CONFIGURATION);
    assertEquals(EXTRACT_CONFIGURATION, job.getConfiguration());
    job = JobInfo.of(LOAD_CONFIGURATION);
    assertEquals(LOAD_CONFIGURATION, job.getConfiguration());
    job = JobInfo.of(QUERY_CONFIGURATION);
    assertEquals(QUERY_CONFIGURATION, job.getConfiguration());
    job = JobInfo.of(JOB_ID, COPY_CONFIGURATION);
    assertEquals(JOB_ID, job.getJobId());
    assertEquals(COPY_CONFIGURATION, job.getConfiguration());
    job = JobInfo.of(JOB_ID, EXTRACT_CONFIGURATION);
    assertEquals(JOB_ID, job.getJobId());
    assertEquals(EXTRACT_CONFIGURATION, job.getConfiguration());
    job = JobInfo.of(JOB_ID, LOAD_CONFIGURATION);
    assertEquals(JOB_ID, job.getJobId());
    assertEquals(LOAD_CONFIGURATION, job.getConfiguration());
    job = JobInfo.of(JOB_ID, QUERY_CONFIGURATION);
    assertEquals(JOB_ID, job.getJobId());
    assertEquals(QUERY_CONFIGURATION, job.getConfiguration());
  }

  @Test
  public void testToBuilderIncomplete() {
    JobInfo job = JobInfo.of(COPY_CONFIGURATION);
    compareJobInfo(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, COPY_JOB.getEtag());
    assertEquals(GENERATED_ID, COPY_JOB.getGeneratedId());
    assertEquals(SELF_LINK, COPY_JOB.getSelfLink());
    assertEquals(EMAIL, COPY_JOB.getUserEmail());
    assertEquals(JOB_ID, COPY_JOB.getJobId());
    assertEquals(JOB_STATUS, COPY_JOB.getStatus());
    assertEquals(COPY_CONFIGURATION, COPY_JOB.getConfiguration());
    assertEquals(COPY_JOB_STATISTICS, COPY_JOB.getStatistics());

    assertEquals(ETAG, EXTRACT_JOB.getEtag());
    assertEquals(GENERATED_ID, EXTRACT_JOB.getGeneratedId());
    assertEquals(SELF_LINK, EXTRACT_JOB.getSelfLink());
    assertEquals(EMAIL, EXTRACT_JOB.getUserEmail());
    assertEquals(JOB_ID, EXTRACT_JOB.getJobId());
    assertEquals(JOB_STATUS, EXTRACT_JOB.getStatus());
    assertEquals(EXTRACT_CONFIGURATION, EXTRACT_JOB.getConfiguration());
    assertEquals(EXTRACT_JOB_STATISTICS, EXTRACT_JOB.getStatistics());

    assertEquals(ETAG, LOAD_JOB.getEtag());
    assertEquals(GENERATED_ID, LOAD_JOB.getGeneratedId());
    assertEquals(SELF_LINK, LOAD_JOB.getSelfLink());
    assertEquals(EMAIL, LOAD_JOB.getUserEmail());
    assertEquals(JOB_ID, LOAD_JOB.getJobId());
    assertEquals(JOB_STATUS, LOAD_JOB.getStatus());
    assertEquals(LOAD_CONFIGURATION, LOAD_JOB.getConfiguration());
    assertEquals(LOAD_JOB_STATISTICS, LOAD_JOB.getStatistics());

    assertEquals(ETAG, QUERY_JOB.getEtag());
    assertEquals(GENERATED_ID, QUERY_JOB.getGeneratedId());
    assertEquals(SELF_LINK, QUERY_JOB.getSelfLink());
    assertEquals(EMAIL, QUERY_JOB.getUserEmail());
    assertEquals(JOB_ID, QUERY_JOB.getJobId());
    assertEquals(JOB_STATUS, QUERY_JOB.getStatus());
    assertEquals(QUERY_CONFIGURATION, QUERY_JOB.getConfiguration());
    assertEquals(QUERY_JOB_STATISTICS, QUERY_JOB.getStatistics());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(COPY_JOB.toPb().getConfiguration().getCopy());
    assertNull(COPY_JOB.toPb().getConfiguration().getExtract());
    assertNull(COPY_JOB.toPb().getConfiguration().getLoad());
    assertNull(COPY_JOB.toPb().getConfiguration().getQuery());
    assertEquals(COPY_JOB_STATISTICS, JobStatistics.fromPb(COPY_JOB.toPb()));
    compareJobInfo(COPY_JOB, JobInfo.fromPb(COPY_JOB.toPb()));
    assertTrue(JobInfo.fromPb(COPY_JOB.toPb()).getConfiguration() instanceof CopyJobConfiguration);
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getCopy());
    assertNotNull(EXTRACT_JOB.toPb().getConfiguration().getExtract());
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getLoad());
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getQuery());
    assertEquals(EXTRACT_JOB_STATISTICS, JobStatistics.fromPb(EXTRACT_JOB.toPb()));
    compareJobInfo(EXTRACT_JOB, JobInfo.fromPb(EXTRACT_JOB.toPb()));
    assertTrue(
        JobInfo.fromPb(EXTRACT_JOB.toPb()).getConfiguration() instanceof ExtractJobConfiguration);
    assertTrue(JobInfo.fromPb(EXTRACT_JOB.toPb()).getStatistics() instanceof ExtractStatistics);
    assertNull(LOAD_JOB.toPb().getConfiguration().getCopy());
    assertNull(LOAD_JOB.toPb().getConfiguration().getExtract());
    assertNotNull(LOAD_JOB.toPb().getConfiguration().getLoad());
    assertNull(LOAD_JOB.toPb().getConfiguration().getQuery());
    assertEquals(LOAD_JOB_STATISTICS, JobStatistics.fromPb(LOAD_JOB.toPb()));
    compareJobInfo(LOAD_JOB, JobInfo.fromPb(LOAD_JOB.toPb()));
    assertTrue(JobInfo.fromPb(LOAD_JOB.toPb()).getConfiguration() instanceof LoadJobConfiguration);
    assertTrue(JobInfo.fromPb(LOAD_JOB.toPb()).getStatistics() instanceof LoadStatistics);
    assertNull(QUERY_JOB.toPb().getConfiguration().getCopy());
    assertNull(QUERY_JOB.toPb().getConfiguration().getExtract());
    assertNull(QUERY_JOB.toPb().getConfiguration().getLoad());
    assertNotNull(QUERY_JOB.toPb().getConfiguration().getQuery());
    assertEquals(QUERY_JOB_STATISTICS, JobStatistics.fromPb(QUERY_JOB.toPb()));
    compareJobInfo(QUERY_JOB, JobInfo.fromPb(QUERY_JOB.toPb()));
    assertTrue(
        JobInfo.fromPb(QUERY_JOB.toPb()).getConfiguration() instanceof QueryJobConfiguration);
    assertTrue(JobInfo.fromPb(QUERY_JOB.toPb()).getStatistics() instanceof QueryStatistics);
  }

  @Test
  public void testSetProjectId() {
    JobInfo jobInfo = COPY_JOB.setProjectId("p");
    assertEquals("p", jobInfo.getJobId().getProject());
    CopyJobConfiguration copyConfiguration = jobInfo.getConfiguration();
    assertEquals("p", copyConfiguration.getDestinationTable().getProject());
    for (TableId sourceTable : copyConfiguration.getSourceTables()) {
      assertEquals("p", sourceTable.getProject());
    }
    jobInfo = EXTRACT_JOB.setProjectId("p");
    assertEquals("p", jobInfo.getJobId().getProject());
    ExtractJobConfiguration extractConfiguration = jobInfo.getConfiguration();
    assertEquals("p", extractConfiguration.getSourceTable().getProject());
    jobInfo = LOAD_JOB.setProjectId("p");
    assertEquals("p", jobInfo.getJobId().getProject());
    LoadJobConfiguration loadConfiguration = jobInfo.getConfiguration();
    assertEquals("p", loadConfiguration.getDestinationTable().getProject());
    jobInfo = QUERY_JOB.setProjectId("p");
    assertEquals("p", jobInfo.getJobId().getProject());
    QueryJobConfiguration queryConfiguration = jobInfo.getConfiguration();
    assertEquals("p", queryConfiguration.getDefaultDataset().getProject());
    assertEquals("p", queryConfiguration.getDestinationTable().getProject());
  }

  private void compareJobInfo(JobInfo expected, JobInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getJobId(), value.getJobId());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getStatus(), value.getStatus());
    assertEquals(expected.getStatistics(), value.getStatistics());
    assertEquals(expected.getUserEmail(), value.getUserEmail());
    assertEquals(expected.getConfiguration(), value.getConfiguration());
  }
}

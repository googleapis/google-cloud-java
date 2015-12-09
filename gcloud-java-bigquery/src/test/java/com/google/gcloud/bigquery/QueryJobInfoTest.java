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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.bigquery.JobInfo.CreateDisposition;
import com.google.gcloud.bigquery.JobInfo.WriteDisposition;
import com.google.gcloud.bigquery.JobStatistics.QueryStatistics;
import com.google.gcloud.bigquery.QueryJobInfo.Priority;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class QueryJobInfoTest {

  private static final String ETAG = "etag";
  private static final String ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final String QUERY = "BigQuery SQL";
  private static final DatasetId DATASET_ID = DatasetId.of("project", "dataset");
  private static final TableId TABLE_ID = TableId.of("project", "dataset", "table");
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
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder().build();
  private static final ExternalDataConfiguration TABLE_CONFIGURATION = ExternalDataConfiguration
      .builder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
      .compression(COMPRESSION)
      .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .maxBadRecords(MAX_BAD_RECORDS)
      .build();
  private static final Map<String, ExternalDataConfiguration> TABLE_DEFINITIONS =
      ImmutableMap.of("tableName", TABLE_CONFIGURATION);
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final Priority PRIORITY = Priority.BATCH;
  private static final boolean ALLOW_LARGE_RESULTS = true;
  private static final boolean USE_QUERY_CACHE = false;
  private static final boolean FLATTEN_RESULTS = true;
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS = ImmutableList.of(
      UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final JobId JOB_ID = JobId.of("job");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final QueryStatistics JOB_STATISTICS = QueryStatistics.builder()
      .creationTime(1L)
      .endTime(3L)
      .startTime(2L)
      .totalBytesProcessed(2048L)
      .totalBytesBilled(1024L)
      .cacheHit(false)
      .billingTier(42)
      .build();
  private static final QueryJobInfo QUERY_JOB = QueryJobInfo.builder(QUERY)
      .etag(ETAG)
      .id(ID)
      .selfLink(SELF_LINK)
      .userEmail(EMAIL)
      .jobId(JOB_ID)
      .status(JOB_STATUS)
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
      .statistics(JOB_STATISTICS)
      .build();

  @Test
  public void testToBuilder() {
    compareQueryJobInfo(QUERY_JOB, QUERY_JOB.toBuilder().build());
    QueryJobInfo job = QUERY_JOB.toBuilder()
        .query("New BigQuery SQL")
        .build();
    assertEquals("New BigQuery SQL", job.query());
    job = job.toBuilder().query(QUERY).build();
    compareQueryJobInfo(QUERY_JOB, job);
  }

  @Test
  public void testOf() {
    QueryJobInfo job = QueryJobInfo.of(QUERY);
    assertEquals(QUERY, job.query());
    job = QueryJobInfo.of(JOB_ID, QUERY);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(QUERY, job.query());
  }

  @Test
  public void testToBuilderIncomplete() {
    QueryJobInfo job = QueryJobInfo.of(QUERY);
    compareQueryJobInfo(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, QUERY_JOB.etag());
    assertEquals(ID, QUERY_JOB.id());
    assertEquals(SELF_LINK, QUERY_JOB.selfLink());
    assertEquals(EMAIL, QUERY_JOB.userEmail());
    assertEquals(JOB_ID, QUERY_JOB.jobId());
    assertEquals(JOB_STATUS, QUERY_JOB.status());
    assertEquals(ALLOW_LARGE_RESULTS, QUERY_JOB.allowLargeResults());
    assertEquals(CREATE_DISPOSITION, QUERY_JOB.createDisposition());
    assertEquals(DATASET_ID, QUERY_JOB.defaultDataset());
    assertEquals(TABLE_ID, QUERY_JOB.destinationTable());
    assertEquals(FLATTEN_RESULTS, QUERY_JOB.flattenResults());
    assertEquals(PRIORITY, QUERY_JOB.priority());
    assertEquals(QUERY, QUERY_JOB.query());
    assertEquals(TABLE_DEFINITIONS, QUERY_JOB.tableDefinitions());
    assertEquals(USE_QUERY_CACHE, QUERY_JOB.useQueryCache());
    assertEquals(USER_DEFINED_FUNCTIONS, QUERY_JOB.userDefinedFunctions());
    assertEquals(WRITE_DISPOSITION, QUERY_JOB.writeDisposition());
    assertTrue(QUERY_JOB.dryRun());
    assertEquals(JOB_STATISTICS, QUERY_JOB.statistics());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(QUERY_JOB.toPb().getConfiguration().getQuery());
    assertNull(QUERY_JOB.toPb().getConfiguration().getExtract());
    assertNull(QUERY_JOB.toPb().getConfiguration().getCopy());
    assertNull(QUERY_JOB.toPb().getConfiguration().getLoad());
    assertEquals(JOB_STATISTICS, JobStatistics.fromPb(QUERY_JOB.statistics().toPb()));
    compareQueryJobInfo(QUERY_JOB, QueryJobInfo.fromPb(QUERY_JOB.toPb()));
    compareQueryJobInfo(QUERY_JOB,
        (QueryJobInfo) JobInfo.fromPb(QUERY_JOB.toPb()));
    QueryJobInfo job = QueryJobInfo.of(QUERY);
    compareQueryJobInfo(job, QueryJobInfo.fromPb(job.toPb()));
    compareQueryJobInfo(job, (QueryJobInfo) JobInfo.fromPb(job.toPb()));
  }

  private void compareQueryJobInfo(QueryJobInfo expected, QueryJobInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.jobId(), value.jobId());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.statistics(), value.statistics());
    assertEquals(expected.dryRun(), value.dryRun());
    assertEquals(expected.userEmail(), value.userEmail());
    assertEquals(expected.allowLargeResults(), value.allowLargeResults());
    assertEquals(expected.createDisposition(), value.createDisposition());
    assertEquals(expected.defaultDataset(), value.defaultDataset());
    assertEquals(expected.destinationTable(), value.destinationTable());
    assertEquals(expected.flattenResults(), value.flattenResults());
    assertEquals(expected.priority(), value.priority());
    assertEquals(expected.query(), value.query());
    assertEquals(expected.tableDefinitions(), value.tableDefinitions());
    assertEquals(expected.useQueryCache(), value.useQueryCache());
    assertEquals(expected.userDefinedFunctions(), value.userDefinedFunctions());
    assertEquals(expected.writeDisposition(), value.writeDisposition());
  }
}

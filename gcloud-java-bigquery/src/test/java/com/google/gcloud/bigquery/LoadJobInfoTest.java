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

import com.google.common.collect.ImmutableList;
import com.google.gcloud.bigquery.JobInfo.CreateDisposition;
import com.google.gcloud.bigquery.JobInfo.WriteDisposition;
import com.google.gcloud.bigquery.JobStatistics.LoadStatistics;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class LoadJobInfoTest {

  private static final String ETAG = "etag";
  private static final String ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder()
      .allowJaggedRows(true)
      .allowQuotedNewLines(false)
      .encoding(StandardCharsets.UTF_8)
      .build();
  private static final String SOURCE_URI = "uri";
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final String FORMAT = "CSV";
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final List<String> PROJECTION_FIELDS = ImmutableList.of("field1", "field2");
  private static final JobId JOB_ID = JobId.of("job");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final Field FIELD_SCHEMA = Field.builder("IntegerField", Field.Type.integer())
      .mode(Field.Mode.REQUIRED)
      .description("FieldDescription")
      .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA);
  private static final LoadStatistics JOB_STATISTICS = LoadStatistics.builder()
      .creationTime(1L)
      .endTime(3L)
      .startTime(2L)
      .inputFiles(42L)
      .outputBytes(1024L)
      .inputBytes(2048L)
      .outputRows(24L)
      .build();
  private static final LoadJobInfo LOAD_JOB = LoadJobInfo.builder(TABLE_ID, SOURCE_URIS)
      .etag(ETAG)
      .id(ID)
      .selfLink(SELF_LINK)
      .userEmail(EMAIL)
      .jobId(JOB_ID)
      .status(JOB_STATUS)
      .createDisposition(CREATE_DISPOSITION)
      .writeDisposition(WRITE_DISPOSITION)
      .formatOptions(CSV_OPTIONS)
      .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .maxBadRecords(MAX_BAD_RECORDS)
      .projectionFields(PROJECTION_FIELDS)
      .schema(TABLE_SCHEMA)
      .statistics(JOB_STATISTICS)
      .build();

  @Test
  public void testToBuilder() {
    compareLoadJobInfo(LOAD_JOB, LOAD_JOB.toBuilder().build());
    LoadJobInfo job = LOAD_JOB.toBuilder()
        .destinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", job.destinationTable().table());
    job = job.toBuilder().destinationTable(TABLE_ID).build();
    compareLoadJobInfo(LOAD_JOB, job);
  }

  @Test
  public void testOf() {
    LoadJobInfo job = LoadJobInfo.of(TABLE_ID, SOURCE_URIS);
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(SOURCE_URIS, job.sourceUris());
    job = LoadJobInfo.of(TABLE_ID, SOURCE_URI);
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_URI), job.sourceUris());
    job = LoadJobInfo.of(TABLE_ID, CSV_OPTIONS, SOURCE_URIS);
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(SOURCE_URIS, job.sourceUris());
    assertEquals(FORMAT, job.format());
    assertEquals(CSV_OPTIONS, job.csvOptions());
    job = LoadJobInfo.of(TABLE_ID, CSV_OPTIONS, SOURCE_URI);
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_URI), job.sourceUris());
    assertEquals(FORMAT, job.format());
    assertEquals(CSV_OPTIONS, job.csvOptions());
    job = LoadJobInfo.of(JOB_ID, TABLE_ID, SOURCE_URIS);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(SOURCE_URIS, job.sourceUris());
    job = LoadJobInfo.of(JOB_ID, TABLE_ID, SOURCE_URI);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_URI), job.sourceUris());
    job = LoadJobInfo.of(JOB_ID, TABLE_ID, CSV_OPTIONS, SOURCE_URIS);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(SOURCE_URIS, job.sourceUris());
    assertEquals(FORMAT, job.format());
    assertEquals(CSV_OPTIONS, job.csvOptions());
    job = LoadJobInfo.of(JOB_ID, TABLE_ID, CSV_OPTIONS, SOURCE_URI);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(TABLE_ID, job.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_URI), job.sourceUris());
    assertEquals(FORMAT, job.format());
    assertEquals(CSV_OPTIONS, job.csvOptions());
  }

  @Test
  public void testToBuilderIncomplete() {
    LoadJobInfo job = LoadJobInfo.of(TABLE_ID, SOURCE_URIS);
    compareLoadJobInfo(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, LOAD_JOB.etag());
    assertEquals(ID, LOAD_JOB.id());
    assertEquals(SELF_LINK, LOAD_JOB.selfLink());
    assertEquals(EMAIL, LOAD_JOB.userEmail());
    assertEquals(JOB_ID, LOAD_JOB.jobId());
    assertEquals(JOB_STATUS, LOAD_JOB.status());
    assertEquals(TABLE_ID, LOAD_JOB.destinationTable());
    assertEquals(SOURCE_URIS, LOAD_JOB.sourceUris());
    assertEquals(CREATE_DISPOSITION, LOAD_JOB.createDisposition());
    assertEquals(WRITE_DISPOSITION, LOAD_JOB.writeDisposition());
    assertEquals(CSV_OPTIONS, LOAD_JOB.csvOptions());
    assertEquals(FORMAT, LOAD_JOB.format());
    assertEquals(IGNORE_UNKNOWN_VALUES, LOAD_JOB.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, LOAD_JOB.maxBadRecords());
    assertEquals(PROJECTION_FIELDS, LOAD_JOB.projectionFields());
    assertEquals(TABLE_SCHEMA, LOAD_JOB.schema());
    assertEquals(JOB_STATISTICS, LOAD_JOB.statistics());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(LOAD_JOB.toPb().getConfiguration().getLoad());
    assertNull(LOAD_JOB.toPb().getConfiguration().getExtract());
    assertNull(LOAD_JOB.toPb().getConfiguration().getCopy());
    assertNull(LOAD_JOB.toPb().getConfiguration().getQuery());
    assertEquals(JOB_STATISTICS, JobStatistics.fromPb(LOAD_JOB.toPb().getStatistics()));
    compareLoadJobInfo(LOAD_JOB, LoadJobInfo.fromPb(LOAD_JOB.toPb()));
    compareLoadJobInfo(LOAD_JOB, (LoadJobInfo) JobInfo.fromPb(LOAD_JOB.toPb()));
    LoadJobInfo job = LoadJobInfo.of(TABLE_ID, SOURCE_URIS);
    compareLoadJobInfo(job, LoadJobInfo.fromPb(job.toPb()));
    compareLoadJobInfo(job, (LoadJobInfo) JobInfo.fromPb(job.toPb()));
  }

  private void compareLoadJobInfo(LoadJobInfo expected, LoadJobInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.jobId(), value.jobId());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.status(), value.status());
    assertEquals(expected.statistics(), value.statistics());
    assertEquals(expected.userEmail(), value.userEmail());
    assertEquals(expected.destinationTable(), value.destinationTable());
    assertEquals(expected.sourceUris(), value.sourceUris());
    assertEquals(expected.createDisposition(), value.createDisposition());
    assertEquals(expected.writeDisposition(), value.writeDisposition());
    assertEquals(expected.csvOptions(), value.csvOptions());
    assertEquals(expected.format(), value.format());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.maxBadRecords(), value.maxBadRecords());
    assertEquals(expected.projectionFields(), value.projectionFields());
    assertEquals(expected.schema(), value.schema());
  }
}

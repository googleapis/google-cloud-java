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
import com.google.gcloud.bigquery.JobStatistics.ExtractStatistics;

import org.junit.Test;

import java.util.List;

public class ExtractJobInfoTest {

  private static final String ETAG = "etag";
  private static final String ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final List<String> DESTINATION_URIS = ImmutableList.of("uri1", "uri2");
  private static final String DESTINATION_URI = "uri1";
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final String FIELD_DELIMITER = ",";
  private static final String FORMAT = "CSV";
  private static final Boolean PRINT_HEADER = true;
  private static final String COMPRESSION = "GZIP";
  private static final JobId JOB_ID = JobId.of("job");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final ExtractStatistics JOB_STATISTICS = ExtractStatistics.builder()
      .creationTime(1L)
      .endTime(3L)
      .startTime(2L)
      .destinationUriFileCounts(ImmutableList.of(42L))
      .build();
  private static final ExtractJobInfo EXTRACT_JOB =
      ExtractJobInfo.builder(TABLE_ID, DESTINATION_URIS)
          .etag(ETAG)
          .id(ID)
          .selfLink(SELF_LINK)
          .userEmail(EMAIL)
          .jobId(JOB_ID)
          .status(JOB_STATUS)
          .printHeader(PRINT_HEADER)
          .fieldDelimiter(FIELD_DELIMITER)
          .compression(COMPRESSION)
          .format(FORMAT)
          .statistics(JOB_STATISTICS)
          .build();
  private static final ExtractJobInfo EXTRACT_JOB_ONE_URI =
      ExtractJobInfo.builder(TABLE_ID, DESTINATION_URI)
          .etag(ETAG)
          .id(ID)
          .selfLink(SELF_LINK)
          .userEmail(EMAIL)
          .jobId(JOB_ID)
          .status(JOB_STATUS)
          .printHeader(PRINT_HEADER)
          .fieldDelimiter(FIELD_DELIMITER)
          .compression(COMPRESSION)
          .format(FORMAT)
          .build();

  @Test
  public void testToBuilder() {
    compareExtractJobInfo(EXTRACT_JOB, EXTRACT_JOB.toBuilder().build());
    ExtractJobInfo job = EXTRACT_JOB.toBuilder()
        .sourceTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", job.sourceTable().table());
    job = job.toBuilder().sourceTable(TABLE_ID).build();
    compareExtractJobInfo(EXTRACT_JOB, job);
  }

  @Test
  public void testOf() {
    ExtractJobInfo job = ExtractJobInfo.of(TABLE_ID, DESTINATION_URIS);
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(DESTINATION_URIS, job.destinationUris());
    job = ExtractJobInfo.of(TABLE_ID, DESTINATION_URI);
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI), job.destinationUris());
    job = ExtractJobInfo.of(JOB_ID, TABLE_ID, DESTINATION_URIS);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(DESTINATION_URIS, job.destinationUris());
    job = ExtractJobInfo.of(JOB_ID, TABLE_ID, DESTINATION_URI);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI), job.destinationUris());
  }

  @Test
  public void testToBuilderIncomplete() {
    ExtractJobInfo job = ExtractJobInfo.of(TABLE_ID, DESTINATION_URIS);
    compareExtractJobInfo(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, EXTRACT_JOB.etag());
    assertEquals(ID, EXTRACT_JOB.id());
    assertEquals(SELF_LINK, EXTRACT_JOB.selfLink());
    assertEquals(EMAIL, EXTRACT_JOB.userEmail());
    assertEquals(JOB_ID, EXTRACT_JOB.jobId());
    assertEquals(JOB_STATUS, EXTRACT_JOB.status());
    assertEquals(TABLE_ID, EXTRACT_JOB.sourceTable());
    assertEquals(DESTINATION_URIS, EXTRACT_JOB.destinationUris());
    assertEquals(FIELD_DELIMITER, EXTRACT_JOB.fieldDelimiter());
    assertEquals(COMPRESSION, EXTRACT_JOB.compression());
    assertEquals(PRINT_HEADER, EXTRACT_JOB.printHeader());
    assertEquals(FORMAT, EXTRACT_JOB.format());
    assertEquals(JOB_STATISTICS, EXTRACT_JOB.statistics());
    assertEquals(ETAG, EXTRACT_JOB_ONE_URI.etag());
    assertEquals(ID, EXTRACT_JOB_ONE_URI.id());
    assertEquals(SELF_LINK, EXTRACT_JOB_ONE_URI.selfLink());
    assertEquals(EMAIL, EXTRACT_JOB_ONE_URI.userEmail());
    assertEquals(JOB_ID, EXTRACT_JOB_ONE_URI.jobId());
    assertEquals(JOB_STATUS, EXTRACT_JOB_ONE_URI.status());
    assertEquals(TABLE_ID, EXTRACT_JOB_ONE_URI.sourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI),
        EXTRACT_JOB_ONE_URI.destinationUris());
    assertEquals(FIELD_DELIMITER, EXTRACT_JOB_ONE_URI.fieldDelimiter());
    assertEquals(COMPRESSION, EXTRACT_JOB_ONE_URI.compression());
    assertEquals(PRINT_HEADER, EXTRACT_JOB_ONE_URI.printHeader());
    assertEquals(FORMAT, EXTRACT_JOB_ONE_URI.format());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(EXTRACT_JOB.toPb().getConfiguration().getExtract());
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getCopy());
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getLoad());
    assertNull(EXTRACT_JOB.toPb().getConfiguration().getQuery());
    assertEquals(JOB_STATISTICS, JobStatistics.fromPb(EXTRACT_JOB.toPb().getStatistics()));
    compareExtractJobInfo(EXTRACT_JOB,
        ExtractJobInfo.fromPb(EXTRACT_JOB.toPb()));
    compareExtractJobInfo(EXTRACT_JOB,
        (ExtractJobInfo) JobInfo.fromPb(EXTRACT_JOB.toPb()));
    compareExtractJobInfo(EXTRACT_JOB_ONE_URI,
        ExtractJobInfo.fromPb(EXTRACT_JOB_ONE_URI.toPb()));
    compareExtractJobInfo(EXTRACT_JOB_ONE_URI,
        (ExtractJobInfo) JobInfo.fromPb(EXTRACT_JOB_ONE_URI.toPb()));
    ExtractJobInfo job = ExtractJobInfo.of(TABLE_ID, DESTINATION_URIS);
    compareExtractJobInfo(job, ExtractJobInfo.fromPb(job.toPb()));
    compareExtractJobInfo(job, (ExtractJobInfo) JobInfo.fromPb(job.toPb()));
  }

  private void compareExtractJobInfo(ExtractJobInfo expected, ExtractJobInfo value) {
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
    assertEquals(expected.sourceTable(), value.sourceTable());
    assertEquals(expected.destinationUris(), value.destinationUris());
    assertEquals(expected.compression(), value.compression());
    assertEquals(expected.printHeader(), value.printHeader());
    assertEquals(expected.fieldDelimiter(), value.fieldDelimiter());
    assertEquals(expected.format(), value.format());
  }
}
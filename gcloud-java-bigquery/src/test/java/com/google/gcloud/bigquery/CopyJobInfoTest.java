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

import org.junit.Test;

import java.util.List;

public class CopyJobInfoTest {

  private static final String ETAG = "etag";
  private static final String ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final TableId SOURCE_TABLE = TableId.of("dataset", "sourceTable");
  private static final List<TableId> SOURCE_TABLES = ImmutableList.of(
      TableId.of("dataset", "sourceTable1"),
      TableId.of("dataset", "sourceTable2")
  );
  private static final TableId DESTINATION_TABLE = TableId.of("dataset", "destinationTable");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final JobId JOB_ID = JobId.of("job");
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final JobStatistics JOB_STATISTICS = JobStatistics.builder()
      .creationTime(1L)
      .endTime(3L)
      .startTime(2L)
      .build();
  private static final CopyJobInfo COPY_JOB =
      CopyJobInfo.builder(DESTINATION_TABLE, SOURCE_TABLE)
          .etag(ETAG)
          .id(ID)
          .selfLink(SELF_LINK)
          .userEmail(EMAIL)
          .jobId(JOB_ID)
          .status(JOB_STATUS)
          .createDisposition(CREATE_DISPOSITION)
          .writeDisposition(WRITE_DISPOSITION)
          .statistics(JOB_STATISTICS)
          .build();
  private static final CopyJobInfo COPY_JOB_INFO_MULTIPLE_TABLES =
      CopyJobInfo.builder(DESTINATION_TABLE, SOURCE_TABLES)
          .etag(ETAG)
          .id(ID)
          .selfLink(SELF_LINK)
          .userEmail(EMAIL)
          .jobId(JOB_ID)
          .status(JOB_STATUS)
          .createDisposition(CREATE_DISPOSITION)
          .writeDisposition(WRITE_DISPOSITION)
          .build();

  @Test
  public void testToBuilder() {
    compareCopyJobInfo(COPY_JOB, COPY_JOB.toBuilder().build());
    compareCopyJobInfo(COPY_JOB_INFO_MULTIPLE_TABLES,
        COPY_JOB_INFO_MULTIPLE_TABLES.toBuilder().build());
    CopyJobInfo job = COPY_JOB.toBuilder()
        .destinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", job.destinationTable().table());
    job = job.toBuilder().destinationTable(DESTINATION_TABLE).build();
    compareCopyJobInfo(COPY_JOB, job);
  }

  @Test
  public void testOf() {
    CopyJobInfo job = CopyJobInfo.of(DESTINATION_TABLE, SOURCE_TABLES);
    assertEquals(DESTINATION_TABLE, job.destinationTable());
    assertEquals(SOURCE_TABLES, job.sourceTables());
    job = CopyJobInfo.of(DESTINATION_TABLE, SOURCE_TABLE);
    assertEquals(DESTINATION_TABLE, job.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_TABLE), job.sourceTables());
    job = CopyJobInfo.of(JOB_ID, DESTINATION_TABLE, SOURCE_TABLES);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(DESTINATION_TABLE, job.destinationTable());
    assertEquals(SOURCE_TABLES, job.sourceTables());
    job = CopyJobInfo.of(JOB_ID, DESTINATION_TABLE, SOURCE_TABLE);
    assertEquals(JOB_ID, job.jobId());
    assertEquals(DESTINATION_TABLE, job.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_TABLE), job.sourceTables());
  }

  @Test
  public void testToBuilderIncomplete() {
    CopyJobInfo job = CopyJobInfo.of(DESTINATION_TABLE, SOURCE_TABLES);
    compareCopyJobInfo(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, COPY_JOB_INFO_MULTIPLE_TABLES.etag());
    assertEquals(ID, COPY_JOB_INFO_MULTIPLE_TABLES.id());
    assertEquals(SELF_LINK, COPY_JOB_INFO_MULTIPLE_TABLES.selfLink());
    assertEquals(EMAIL, COPY_JOB_INFO_MULTIPLE_TABLES.userEmail());
    assertEquals(JOB_ID, COPY_JOB_INFO_MULTIPLE_TABLES.jobId());
    assertEquals(JOB_STATUS, COPY_JOB_INFO_MULTIPLE_TABLES.status());
    assertEquals(DESTINATION_TABLE, COPY_JOB_INFO_MULTIPLE_TABLES.destinationTable());
    assertEquals(SOURCE_TABLES, COPY_JOB_INFO_MULTIPLE_TABLES.sourceTables());
    assertEquals(CREATE_DISPOSITION, COPY_JOB_INFO_MULTIPLE_TABLES.createDisposition());
    assertEquals(WRITE_DISPOSITION, COPY_JOB_INFO_MULTIPLE_TABLES.writeDisposition());
    assertEquals(ETAG, COPY_JOB.etag());
    assertEquals(ID, COPY_JOB.id());
    assertEquals(SELF_LINK, COPY_JOB.selfLink());
    assertEquals(EMAIL, COPY_JOB.userEmail());
    assertEquals(JOB_ID, COPY_JOB.jobId());
    assertEquals(JOB_STATUS, COPY_JOB.status());
    assertEquals(DESTINATION_TABLE, COPY_JOB.destinationTable());
    assertEquals(ImmutableList.of(SOURCE_TABLE), COPY_JOB.sourceTables());
    assertEquals(CREATE_DISPOSITION, COPY_JOB.createDisposition());
    assertEquals(WRITE_DISPOSITION, COPY_JOB.writeDisposition());
    assertEquals(JOB_STATISTICS, COPY_JOB.statistics());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(COPY_JOB.toPb().getConfiguration().getCopy());
    assertNull(COPY_JOB.toPb().getConfiguration().getExtract());
    assertNull(COPY_JOB.toPb().getConfiguration().getLoad());
    assertNull(COPY_JOB.toPb().getConfiguration().getQuery());
    assertNull(COPY_JOB.toPb().getConfiguration().getCopy().getSourceTables());
    assertEquals(JOB_STATISTICS, JobStatistics.fromPb(COPY_JOB.statistics().toPb()));
    assertNull(COPY_JOB_INFO_MULTIPLE_TABLES.toPb().getConfiguration().getCopy().getSourceTable());
    compareCopyJobInfo(COPY_JOB, CopyJobInfo.fromPb(COPY_JOB.toPb()));
    compareCopyJobInfo(COPY_JOB, (CopyJobInfo) JobInfo.fromPb(COPY_JOB.toPb()));
    compareCopyJobInfo(COPY_JOB_INFO_MULTIPLE_TABLES,
        CopyJobInfo.fromPb(COPY_JOB_INFO_MULTIPLE_TABLES.toPb()));
    compareCopyJobInfo(COPY_JOB_INFO_MULTIPLE_TABLES,
        (CopyJobInfo) JobInfo.fromPb(COPY_JOB_INFO_MULTIPLE_TABLES.toPb()));
    CopyJobInfo job = CopyJobInfo.of(DESTINATION_TABLE, SOURCE_TABLES);
    compareCopyJobInfo(job, CopyJobInfo.fromPb(job.toPb()));
    compareCopyJobInfo(job, (CopyJobInfo) JobInfo.fromPb(job.toPb()));
  }

  private void compareCopyJobInfo(CopyJobInfo expected, CopyJobInfo value) {
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
    assertEquals(expected.sourceTables(), value.sourceTables());
    assertEquals(expected.createDisposition(), value.createDisposition());
    assertEquals(expected.writeDisposition(), value.writeDisposition());
  }
}

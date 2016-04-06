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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

public class JobTest {

  private static final JobId JOB_ID = JobId.of("project", "job");
  private static final TableId TABLE_ID1 = TableId.of("dataset", "table1");
  private static final TableId TABLE_ID2 = TableId.of("dataset", "table2");
  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final JobStatistics COPY_JOB_STATISTICS = JobStatistics.builder()
      .creationTime(1L)
      .endTime(3L)
      .startTime(2L)
      .build();
  private static final CopyJobConfiguration COPY_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID1, TABLE_ID2);
  private static final JobInfo JOB_INFO = JobInfo.builder(COPY_CONFIGURATION)
      .jobId(JOB_ID)
      .statistics(COPY_JOB_STATISTICS)
      .jobId(JOB_ID)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .selfLink(SELF_LINK)
      .userEmail(EMAIL)
      .status(JOB_STATUS)
      .build();

  private BigQuery serviceMockReturnsOptions = createStrictMock(BigQuery.class);
  private BigQueryOptions mockOptions = createMock(BigQueryOptions.class);
  private BigQuery bigquery;
  private Job expectedJob;
  private Job job;

  private void initializeExpectedJob(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    bigquery = createStrictMock(BigQuery.class);
    expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(JOB_INFO));
  }

  private void initializeJob() {
    job = new Job(bigquery, new JobInfo.BuilderImpl(JOB_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(bigquery, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedJob(2);
    replay(bigquery);
    Job builtJob = new Job.Builder(serviceMockReturnsOptions, COPY_CONFIGURATION)
        .jobId(JOB_ID)
        .statistics(COPY_JOB_STATISTICS)
        .jobId(JOB_ID)
        .etag(ETAG)
        .generatedId(GENERATED_ID)
        .selfLink(SELF_LINK)
        .userEmail(EMAIL)
        .status(JOB_STATUS)
        .build();
    assertEquals(ETAG, builtJob.etag());
    assertEquals(GENERATED_ID, builtJob.generatedId());
    assertEquals(SELF_LINK, builtJob.selfLink());
    assertEquals(EMAIL, builtJob.userEmail());
    assertEquals(JOB_ID, builtJob.jobId());
    assertEquals(JOB_STATUS, builtJob.status());
    assertEquals(COPY_CONFIGURATION, builtJob.configuration());
    assertEquals(COPY_JOB_STATISTICS, builtJob.statistics());
    assertSame(serviceMockReturnsOptions, builtJob.bigquery());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedJob(4);
    replay(bigquery);
    compareJob(expectedJob, expectedJob.toBuilder().build());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedJob(1);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields()};
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions)).andReturn(expectedJob);
    replay(bigquery);
    initializeJob();
    assertTrue(job.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedJob(1);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields()};
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeJob();
    assertFalse(job.exists());
  }

  @Test
  public void testIsDone_True() throws Exception {
    initializeExpectedJob(2);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.state()).andReturn(JobStatus.State.DONE);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions))
        .andReturn(expectedJob.toBuilder().status(status).build());
    replay(status, bigquery);
    initializeJob();
    assertTrue(job.isDone());
    verify(status);
  }

  @Test
  public void testIsDone_False() throws Exception {
    initializeExpectedJob(2);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.state()).andReturn(JobStatus.State.RUNNING);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions))
        .andReturn(expectedJob.toBuilder().status(status).build());
    replay(status, bigquery);
    initializeJob();
    assertFalse(job.isDone());
    verify(status);
  }

  @Test
  public void testIsDone_NotExists() throws Exception {
    initializeExpectedJob(1);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeJob();
    assertTrue(job.isDone());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedJob(4);
    JobInfo updatedInfo = JOB_INFO.toBuilder().etag("etag").build();
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(updatedInfo));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId().job())).andReturn(expectedJob);
    replay(bigquery);
    initializeJob();
    Job updatedJob = job.reload();
    compareJob(expectedJob, updatedJob);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedJob(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId().job())).andReturn(null);
    replay(bigquery);
    initializeJob();
    assertNull(job.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedJob(4);
    JobInfo updatedInfo = JOB_INFO.toBuilder().etag("etag").build();
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(updatedInfo));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.jobId().job(), BigQuery.JobOption.fields()))
        .andReturn(expectedJob);
    replay(bigquery);
    initializeJob();
    Job updatedJob = job.reload(BigQuery.JobOption.fields());
    compareJob(expectedJob, updatedJob);
  }

  @Test
  public void testCancel() throws Exception {
    initializeExpectedJob(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.cancel(JOB_INFO.jobId())).andReturn(true);
    replay(bigquery);
    initializeJob();
    assertTrue(job.cancel());
  }

  @Test
  public void testBigquery() {
    initializeExpectedJob(1);
    replay(bigquery);
    assertSame(serviceMockReturnsOptions, expectedJob.bigquery());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedJob(4);
    replay(bigquery);
    compareJob(expectedJob, Job.fromPb(serviceMockReturnsOptions, expectedJob.toPb()));
  }

  private void compareJob(Job expected, Job value) {
    assertEquals(expected, value);
    compareJobInfo(expected, value);
    assertEquals(expected.bigquery().options(), value.bigquery().options());
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

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

package com.google.cloud.bigquery;

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

import com.google.api.core.ApiClock;
import com.google.api.core.CurrentMillisClock;
import com.google.cloud.WaitForOption;
import com.google.cloud.bigquery.JobStatistics.CopyStatistics;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JobTest {

  private static final JobId JOB_ID = JobId.of("project", "job");
  private static final TableId TABLE_ID1 = TableId.of("dataset", "table1");
  private static final TableId TABLE_ID2 = TableId.of("dataset", "table2");
  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final JobStatistics COPY_JOB_STATISTICS = CopyStatistics.newBuilder()
      .setCreationTimestamp(1L)
      .setEndTime(3L)
      .setStartTime(2L)
      .build();
  private static final CopyJobConfiguration COPY_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID1, TABLE_ID2);
  private static final JobInfo JOB_INFO = JobInfo.newBuilder(COPY_CONFIGURATION)
      .setJobId(JOB_ID)
      .setStatistics(COPY_JOB_STATISTICS)
      .setJobId(JOB_ID)
      .setEtag(ETAG)
      .setGeneratedId(GENERATED_ID)
      .setSelfLink(SELF_LINK)
      .setUserEmail(EMAIL)
      .setStatus(JOB_STATUS)
      .build();

  private BigQuery serviceMockReturnsOptions = createStrictMock(BigQuery.class);
  private BigQueryOptions mockOptions = createMock(BigQueryOptions.class);
  private BigQuery bigquery;
  private Job expectedJob;
  private Job job;

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  private void initializeExpectedJob(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
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
        .setJobId(JOB_ID)
        .setStatistics(COPY_JOB_STATISTICS)
        .setJobId(JOB_ID)
        .setEtag(ETAG)
        .setGeneratedId(GENERATED_ID)
        .setSelfLink(SELF_LINK)
        .setUserEmail(EMAIL)
        .setStatus(JOB_STATUS)
        .build();
    assertEquals(ETAG, builtJob.getEtag());
    assertEquals(GENERATED_ID, builtJob.getGeneratedId());
    assertEquals(SELF_LINK, builtJob.getSelfLink());
    assertEquals(EMAIL, builtJob.getUserEmail());
    assertEquals(JOB_ID, builtJob.getJobId());
    assertEquals(JOB_STATUS, builtJob.getStatus());
    assertEquals(COPY_CONFIGURATION, builtJob.getConfiguration());
    assertEquals(COPY_JOB_STATISTICS, builtJob.getStatistics());
    assertSame(serviceMockReturnsOptions, builtJob.getBigquery());
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
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(expectedJob);
    replay(bigquery);
    initializeJob();
    assertTrue(job.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedJob(1);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields()};
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeJob();
    assertFalse(job.exists());
  }

  @Test
  public void testIsDone_True() throws Exception {
    initializeExpectedJob(2);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.getState()).andReturn(JobStatus.State.DONE);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions))
        .andReturn(expectedJob.toBuilder().setStatus(status).build());
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
    expect(status.getState()).andReturn(JobStatus.State.RUNNING);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions))
        .andReturn(expectedJob.toBuilder().setStatus(status).build());
    replay(status, bigquery);
    initializeJob();
    assertFalse(job.isDone());
    verify(status);
  }

  @Test
  public void testIsDone_NotExists() throws Exception {
    initializeExpectedJob(1);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeJob();
    assertTrue(job.isDone());
  }

  @Test
  public void testWaitFor() throws InterruptedException, TimeoutException {
    initializeExpectedJob(2);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.getState()).andReturn(JobStatus.State.DONE);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(CurrentMillisClock.getDefaultClock());
    Job completedJob = expectedJob.toBuilder().setStatus(status).build();
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(completedJob);
    expect(bigquery.getJob(JOB_INFO.getJobId())).andReturn(completedJob);
    replay(status, bigquery, mockOptions);
    initializeJob();
    assertSame(completedJob, job.waitFor());
    verify(status, mockOptions);
  }

  @Test
  public void testWaitFor_Null() throws InterruptedException, TimeoutException {
    initializeExpectedJob(1);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(CurrentMillisClock.getDefaultClock());
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(null);
    expect(bigquery.getJob(JOB_INFO.getJobId())).andReturn(null);
    replay(bigquery, mockOptions);
    initializeJob();
    assertNull(job.waitFor());
    verify(mockOptions);
  }

  @Test
  public void testWaitForWithCheckingPeriod() throws InterruptedException, TimeoutException {
    initializeExpectedJob(3);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    TimeUnit timeUnit = createStrictMock(TimeUnit.class);
    timeUnit.sleep(42);
    EasyMock.expectLastCall();
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.getState()).andReturn(JobStatus.State.RUNNING);
    expect(status.getState()).andReturn(JobStatus.State.DONE);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(CurrentMillisClock.getDefaultClock());
    Job runningJob = expectedJob.toBuilder().setStatus(status).build();
    Job completedJob = expectedJob.toBuilder().setStatus(status).build();
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(runningJob);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(completedJob);
    expect(bigquery.getJob(JOB_INFO.getJobId())).andReturn(completedJob);
    replay(status, bigquery, timeUnit, mockOptions);
    initializeJob();
    assertSame(completedJob, job.waitFor(WaitForOption.checkEvery(42, timeUnit)));
    verify(status, timeUnit, mockOptions);
  }

  @Test
  public void testWaitForWithCheckingPeriod_Null() throws InterruptedException, TimeoutException {
    initializeExpectedJob(2);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    TimeUnit timeUnit = createStrictMock(TimeUnit.class);
    timeUnit.sleep(42);
    EasyMock.expectLastCall();
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(CurrentMillisClock.getDefaultClock());
    Job runningJob =
        expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.RUNNING)).build();
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(runningJob);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(null);
    expect(bigquery.getJob(JOB_INFO.getJobId())).andReturn(null);
    replay(bigquery, timeUnit, mockOptions);
    initializeJob();
    assertNull(job.waitFor(WaitForOption.checkEvery(42, timeUnit)));
    verify(bigquery, timeUnit, mockOptions);
  }

  @Test
  public void testWaitForWithTimeout() throws InterruptedException, TimeoutException {
    initializeExpectedJob(2);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    TimeUnit timeUnit = createStrictMock(TimeUnit.class);
    timeUnit.sleep(1);
    EasyMock.expectLastCall();
    ApiClock clock = createStrictMock(ApiClock.class);
    expect(clock.millisTime()).andReturn(0L);
    expect(clock.millisTime()).andReturn(1L);
    expect(clock.millisTime()).andReturn(3L);
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.getState()).andReturn(JobStatus.State.RUNNING);
    expect(status.getState()).andReturn(JobStatus.State.RUNNING);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(mockOptions.getClock()).andReturn(clock);
    Job runningJob = expectedJob.toBuilder().setStatus(status).build();
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(runningJob);
    expect(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).andReturn(runningJob);
    replay(status, bigquery, timeUnit, clock, mockOptions);
    initializeJob();
    thrown.expect(TimeoutException.class);
    job.waitFor(WaitForOption.checkEvery(1, timeUnit),
        WaitForOption.timeout(3, TimeUnit.MILLISECONDS));
    verify(status, timeUnit, clock, mockOptions);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedJob(4);
    JobInfo updatedInfo = JOB_INFO.toBuilder().setEtag("etag").build();
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(updatedInfo));
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId())).andReturn(expectedJob);
    replay(bigquery);
    initializeJob();
    Job updatedJob = job.reload();
    compareJob(expectedJob, updatedJob);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedJob(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId())).andReturn(null);
    replay(bigquery);
    initializeJob();
    assertNull(job.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedJob(4);
    JobInfo updatedInfo = JOB_INFO.toBuilder().setEtag("etag").build();
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(updatedInfo));
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getJob(JOB_INFO.getJobId(), BigQuery.JobOption.fields()))
        .andReturn(expectedJob);
    replay(bigquery);
    initializeJob();
    Job updatedJob = job.reload(BigQuery.JobOption.fields());
    compareJob(expectedJob, updatedJob);
  }

  @Test
  public void testCancel() throws Exception {
    initializeExpectedJob(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.cancel(JOB_INFO.getJobId())).andReturn(true);
    replay(bigquery);
    initializeJob();
    assertTrue(job.cancel());
  }

  @Test
  public void testBigquery() {
    initializeExpectedJob(1);
    replay(bigquery);
    assertSame(serviceMockReturnsOptions, expectedJob.getBigquery());
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
    assertEquals(expected.getBigquery().getOptions(), value.getBigquery().getOptions());
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

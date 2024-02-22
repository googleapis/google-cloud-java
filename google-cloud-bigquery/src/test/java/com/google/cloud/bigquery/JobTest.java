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

import static com.google.common.collect.ObjectArrays.concat;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.CurrentMillisClock;
import com.google.api.gax.paging.Page;
import com.google.api.gax.paging.Pages;
import com.google.cloud.RetryOption;
import com.google.cloud.bigquery.JobStatistics.CopyStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatus.State;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.threeten.bp.Duration;

@RunWith(MockitoJUnitRunner.class)
public class JobTest {

  private static final JobId JOB_ID = JobId.of("project", "job");
  private static final TableId TABLE_ID1 = TableId.of("dataset", "table1");
  private static final TableId TABLE_ID2 = TableId.of("dataset", "table2");
  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "id";
  private static final String SELF_LINK = "selfLink";
  private static final String EMAIL = "email";
  private static final JobStatus JOB_STATUS = new JobStatus(JobStatus.State.DONE);
  private static final JobStatistics COPY_JOB_STATISTICS =
      CopyStatistics.newBuilder().setCreationTimestamp(1L).setEndTime(3L).setStartTime(2L).build();
  private static final CopyJobConfiguration COPY_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID1, TABLE_ID2);
  private static final JobInfo JOB_INFO =
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

  private static final RetryOption[] TEST_RETRY_OPTIONS =
      new RetryOption[] {
        RetryOption.totalTimeout(Duration.ofSeconds(3)),
        RetryOption.initialRetryDelay(Duration.ofMillis(1L)),
        RetryOption.jittered(false),
        RetryOption.retryDelayMultiplier(1.0)
      };

  @Rule public MockitoRule rule;

  private BigQuery bigquery;
  private BigQueryOptions mockOptions;
  private Job expectedJob;
  private Job job;

  @Before
  public void setUp() {
    bigquery = mock(BigQuery.class);
    mockOptions = mock(BigQueryOptions.class);
    when(bigquery.getOptions()).thenReturn(mockOptions);
    expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(JOB_INFO));
    job = new Job(bigquery, new JobInfo.BuilderImpl(JOB_INFO));
  }

  @Test
  public void testBuilder() {
    Job builtJob =
        new Job.Builder(bigquery, COPY_CONFIGURATION)
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
    assertSame(bigquery, builtJob.getBigQuery());
  }

  @Test
  public void testToBuilder() {
    compareJob(expectedJob, expectedJob.toBuilder().build());
  }

  @Test
  public void testExists_True() {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields()};
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(expectedJob);
    assertTrue(job.exists());
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
  }

  @Test
  public void testExists_False() {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields()};
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(null);
    assertFalse(job.exists());
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
  }

  @Test
  public void testIsDone_True() {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    Job job = expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.DONE)).build();
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(job);
    assertTrue(job.isDone());
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
  }

  @Test
  public void testIsDone_False() {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    Job job = expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.RUNNING)).build();
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(job);
    assertFalse(job.isDone());
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
  }

  @Test
  public void testIsDone_NotExists() {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(null);
    assertTrue(job.isDone());
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
  }

  @Test
  public void testWaitFor() throws InterruptedException {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    JobStatus status = mock(JobStatus.class);
    when(status.getState()).thenReturn(JobStatus.State.DONE);
    // caused by optimizing extra call to ResultRetryAlgorithm#shouldRetry()
    when(status.getState()).thenReturn(JobStatus.State.DONE);
    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    Job completedJob = expectedJob.toBuilder().setStatus(status).build();
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(completedJob);
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(completedJob);
    assertSame(completedJob, job.waitFor(TEST_RETRY_OPTIONS));
    verify(mockOptions).getClock();
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
    verify(bigquery).getJob(JOB_INFO.getJobId());
  }

  @Test
  public void testWaitForAndGetQueryResultsEmpty() throws InterruptedException {
    QueryJobConfiguration jobConfig =
        QueryJobConfiguration.newBuilder("CREATE VIEW").setDestinationTable(TABLE_ID1).build();
    QueryStatistics jobStatistics =
        QueryStatistics.newBuilder()
            .setCreationTimestamp(1L)
            .setEndTime(3L)
            .setStartTime(2L)
            .build();
    JobInfo jobInfo =
        JobInfo.newBuilder(jobConfig)
            .setJobId(JOB_ID)
            .setStatistics(jobStatistics)
            .setJobId(JOB_ID)
            .setEtag(ETAG)
            .setGeneratedId(GENERATED_ID)
            .setSelfLink(SELF_LINK)
            .setUserEmail(EMAIL)
            .setStatus(JOB_STATUS)
            .build();

    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    Job completedJob =
        expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.RUNNING)).build();
    QueryResponse completedQuery =
        QueryResponse.newBuilder()
            .setCompleted(true)
            .setTotalRows(0)
            .setSchema(Schema.of())
            .setErrors(ImmutableList.<BigQueryError>of())
            .build();

    when(bigquery.getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS))
        .thenReturn(completedQuery);
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(completedJob);
    when(bigquery.getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS))
        .thenReturn(completedQuery);
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(completedJob);
    job = this.job.toBuilder().setConfiguration(jobConfig).build();
    assertThat(job.waitFor(TEST_RETRY_OPTIONS)).isSameInstanceAs(completedJob);
    assertThat(job.getQueryResults().iterateAll()).isEmpty();
    verify(bigquery, times(2)).getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS);
    verify(bigquery).getJob(JOB_INFO.getJobId());
  }

  @Test
  public void testWaitForAndGetQueryResultsEmptyWithSchema() throws InterruptedException {
    QueryJobConfiguration jobConfig =
        QueryJobConfiguration.newBuilder("CREATE VIEW").setDestinationTable(TABLE_ID1).build();
    QueryStatistics jobStatistics =
        QueryStatistics.newBuilder()
            .setCreationTimestamp(1L)
            .setEndTime(3L)
            .setStartTime(2L)
            .build();
    JobInfo jobInfo =
        JobInfo.newBuilder(jobConfig)
            .setJobId(JOB_ID)
            .setStatistics(jobStatistics)
            .setJobId(JOB_ID)
            .setEtag(ETAG)
            .setGeneratedId(GENERATED_ID)
            .setSelfLink(SELF_LINK)
            .setUserEmail(EMAIL)
            .setStatus(JOB_STATUS)
            .build();

    JobStatus status = mock(JobStatus.class);
    when(bigquery.getOptions()).thenReturn(mockOptions);
    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    Job completedJob =
        expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.RUNNING)).build();
    QueryResponse completedQuery =
        QueryResponse.newBuilder()
            .setCompleted(true)
            .setTotalRows(0)
            .setSchema(Schema.of(Field.of("field1", LegacySQLTypeName.BOOLEAN)))
            .setErrors(ImmutableList.<BigQueryError>of())
            .build();
    when(bigquery.getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS))
        .thenReturn(completedQuery);
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(completedJob);
    when(bigquery.getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS))
        .thenReturn(completedQuery);
    job = this.job.toBuilder().setConfiguration(jobConfig).build();
    assertThat(job.waitFor(TEST_RETRY_OPTIONS)).isSameInstanceAs(completedJob);
    assertThat(job.getQueryResults().getSchema())
        .isEqualTo(Schema.of(Field.of("field1", LegacySQLTypeName.BOOLEAN)));
    verify(bigquery, times(2)).getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS);
    verify(bigquery).getJob(JOB_INFO.getJobId());
  }

  @Test
  public void testWaitForAndGetQueryResults() throws InterruptedException {
    QueryJobConfiguration jobConfig =
        QueryJobConfiguration.newBuilder("SELECT 1").setDestinationTable(TABLE_ID1).build();
    QueryStatistics jobStatistics =
        QueryStatistics.newBuilder()
            .setCreationTimestamp(1L)
            .setEndTime(3L)
            .setStartTime(2L)
            .build();
    JobInfo jobInfo =
        JobInfo.newBuilder(jobConfig)
            .setJobId(JOB_ID)
            .setStatistics(jobStatistics)
            .setJobId(JOB_ID)
            .setEtag(ETAG)
            .setGeneratedId(GENERATED_ID)
            .setSelfLink(SELF_LINK)
            .setUserEmail(EMAIL)
            .setStatus(JOB_STATUS)
            .build();

    when(bigquery.getOptions()).thenReturn(mockOptions);
    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    Job completedJob =
        expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.RUNNING)).build();
    Page<FieldValueList> singlePage = Pages.empty();
    TableResult result =
        TableResult.newBuilder()
            .setSchema(Schema.of())
            .setTotalRows(1L)
            .setPageNoSchema(singlePage)
            .build();
    QueryResponse completedQuery =
        QueryResponse.newBuilder()
            .setCompleted(true)
            .setTotalRows(1) // Lies to force call of listTableData().
            .setSchema(Schema.of(Field.of("_f0", LegacySQLTypeName.INTEGER)))
            .setErrors(ImmutableList.<BigQueryError>of())
            .build();

    when(bigquery.getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS))
        .thenReturn(completedQuery);
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(completedJob);
    when(bigquery.getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS))
        .thenReturn(completedQuery);
    when(bigquery.listTableData(eq(TABLE_ID1), any(Schema.class))).thenReturn(result);
    job = this.job.toBuilder().setConfiguration(jobConfig).build();
    assertThat(job.waitFor(TEST_RETRY_OPTIONS)).isSameInstanceAs(completedJob);
    assertThat(job.getQueryResults().iterateAll()).hasSize(0);
    verify(bigquery, times(2)).getQueryResults(jobInfo.getJobId(), Job.DEFAULT_QUERY_WAIT_OPTIONS);
    verify(bigquery).getJob(JOB_INFO.getJobId());
  }

  @Test
  public void testWaitForAndGetQueryResults_Unsupported() throws InterruptedException {
    try {
      job.getQueryResults();
      Assert.fail();
    } catch (UnsupportedOperationException expected) {
      Assert.assertNotNull(expected.getMessage());
    }
  }

  @Test
  public void testWaitFor_Null() throws InterruptedException {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(null);
    assertNull(job.waitFor(TEST_RETRY_OPTIONS));
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
  }

  @Test
  public void testWaitForWithCheckingPeriod() throws InterruptedException {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    JobStatus status = mock(JobStatus.class);
    when(status.getState()).thenReturn(JobStatus.State.RUNNING);
    // caused by optimizing extra call to ResultRetryAlgorithm#shouldRetry()
    when(status.getState()).thenReturn(JobStatus.State.RUNNING);
    when(status.getState()).thenReturn(JobStatus.State.DONE);
    // caused by optimizing extra call to ResultRetryAlgorithm#shouldRetry()
    when(status.getState()).thenReturn(JobStatus.State.DONE);
    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    Job runningJob = expectedJob.toBuilder().setStatus(status).build();
    Job completedJob = expectedJob.toBuilder().setStatus(status).build();
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(runningJob);
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(completedJob);
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(completedJob);
    assertSame(completedJob, job.waitFor(TEST_RETRY_OPTIONS));
    verify(mockOptions).getClock();
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
    verify(bigquery).getJob(JOB_INFO.getJobId());
  }

  @Test
  public void testWaitForWithCheckingPeriod_Null() throws InterruptedException {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    Job runningJob =
        expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.RUNNING)).build();
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(runningJob);
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(null);
    assertNull(job.waitFor(TEST_RETRY_OPTIONS));
    verify(mockOptions).getClock();
    verify(bigquery).getJob(JOB_INFO.getJobId(), expectedOptions);
  }

  @Test
  public void testWaitForWithTimeout() throws InterruptedException {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    when(mockOptions.getClock()).thenReturn(CurrentMillisClock.getDefaultClock());
    Job runningJob =
        expectedJob.toBuilder().setStatus(new JobStatus(JobStatus.State.RUNNING)).build();
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(runningJob);
    when(bigquery.getJob(JOB_INFO.getJobId(), expectedOptions)).thenReturn(runningJob);
    try {
      job.waitFor(concat(TEST_RETRY_OPTIONS, RetryOption.totalTimeout(Duration.ofMillis(3))));
      Assert.fail();
    } catch (BigQueryException expected) {
      Assert.assertNotNull(expected.getMessage());
    }
  }

  @Test
  public void testReload() {
    JobInfo updatedInfo = JOB_INFO.toBuilder().setEtag("etag").build();
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(updatedInfo));
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(expectedJob);
    Job updatedJob = job.reload();
    compareJob(expectedJob, updatedJob);
    verify(bigquery).getJob(JOB_INFO.getJobId());
  }

  @Test
  public void testReloadJobException() {
    JobInfo updatedInfo = JOB_INFO.toBuilder().setEtag("etag").build();
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(updatedInfo));
    BigQueryError bigQueryError = new BigQueryError("invalidQuery", "US", "invalidQuery");
    expectedJob =
        expectedJob.toBuilder().setStatus(new JobStatus(State.DONE, bigQueryError, null)).build();
    ImmutableList<BigQueryError> bigQueryErrorList = ImmutableList.of(bigQueryError);
    BigQueryException bigQueryException = new BigQueryException(bigQueryErrorList);
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(expectedJob).thenThrow(bigQueryException);
    try {
      job.reload();
      fail("JobException expected");
    } catch (BigQueryException e) {
      assertNotNull(e.getErrors());
    }
  }

  @Test
  public void testReloadNull() {
    when(bigquery.getJob(JOB_INFO.getJobId())).thenReturn(null);
    assertNull(job.reload());
    verify(bigquery).getJob(JOB_INFO.getJobId());
  }

  @Test
  public void testReloadWithOptions() {
    JobInfo updatedInfo = JOB_INFO.toBuilder().setEtag("etag").build();
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(updatedInfo));
    when(bigquery.getJob(JOB_INFO.getJobId(), BigQuery.JobOption.fields())).thenReturn(expectedJob);
    Job updatedJob = job.reload(BigQuery.JobOption.fields());
    compareJob(expectedJob, updatedJob);
    verify(bigquery).getJob(JOB_INFO.getJobId(), BigQuery.JobOption.fields());
  }

  @Test
  public void testCancel() {
    when(bigquery.cancel(JOB_INFO.getJobId())).thenReturn(true);
    assertTrue(job.cancel());
    verify(bigquery).cancel(JOB_INFO.getJobId());
  }

  @Test
  public void testBigQuery() {
    assertSame(bigquery, expectedJob.getBigQuery());
  }

  @Test
  public void testToAndFromPb() {
    compareJob(expectedJob, Job.fromPb(bigquery, expectedJob.toPb()));
  }

  @Test
  public void testToAndFromPbWithoutConfiguration() {
    assertNotEquals(expectedJob, bigquery);
    compareJob(expectedJob, Job.fromPb(bigquery, expectedJob.toPb()));
  }

  private void compareJob(Job expected, Job value) {
    assertEquals(expected, value);
    compareJobInfo(expected, value);
    assertEquals(expected.getBigQuery().getOptions(), value.getBigQuery().getOptions());
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

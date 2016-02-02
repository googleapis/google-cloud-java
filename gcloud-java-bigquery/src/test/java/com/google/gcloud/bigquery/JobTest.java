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

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JobTest {

  private static final JobId JOB_ID = JobId.of("dataset", "job");
  private static final TableId TABLE_ID1 = TableId.of("dataset", "table1");
  private static final TableId TABLE_ID2 = TableId.of("dataset", "table2");
  private static final JobInfo JOB_INFO =
      JobInfo.of(JOB_ID, CopyJobConfiguration.of(TABLE_ID1, TABLE_ID2));

  private BigQuery bigquery;
  private Job job;

  @Before
  public void setUp() throws Exception {
    bigquery = createStrictMock(BigQuery.class);
    job = new Job(bigquery, JOB_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(bigquery);
  }

  @Test
  public void testInfo() throws Exception {
    assertEquals(JOB_INFO, job.info());
    replay(bigquery);
  }

  @Test
  public void testBigQuery() throws Exception {
    assertSame(bigquery, job.bigquery());
    replay(bigquery);
  }

  @Test
  public void testExists_True() throws Exception {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields()};
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions)).andReturn(JOB_INFO);
    replay(bigquery);
    assertTrue(job.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields()};
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    assertFalse(job.exists());
  }

  @Test
  public void testIsDone_True() throws Exception {
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.state()).andReturn(JobStatus.State.DONE);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions))
        .andReturn(JOB_INFO.toBuilder().status(status).build());
    replay(status, bigquery);
    assertTrue(job.isDone());
    verify(status);
  }

  @Test
  public void testIsDone_False() throws Exception {
    JobStatus status = createStrictMock(JobStatus.class);
    expect(status.state()).andReturn(JobStatus.State.RUNNING);
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions))
        .andReturn(JOB_INFO.toBuilder().status(status).build());
    replay(status, bigquery);
    assertFalse(job.isDone());
    verify(status);
  }

  @Test
  public void testIsDone_NotExists() throws Exception {
    BigQuery.JobOption[] expectedOptions = {BigQuery.JobOption.fields(BigQuery.JobField.STATUS)};
    expect(bigquery.getJob(JOB_INFO.jobId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    assertFalse(job.isDone());
  }

  @Test
  public void testReload() throws Exception {
    JobInfo updatedInfo = JOB_INFO.toBuilder().etag("etag").build();
    expect(bigquery.getJob(JOB_INFO.jobId().job())).andReturn(updatedInfo);
    replay(bigquery);
    Job updatedJob = job.reload();
    assertSame(bigquery, updatedJob.bigquery());
    assertEquals(updatedInfo, updatedJob.info());
  }

  @Test
  public void testReloadNull() throws Exception {
    expect(bigquery.getJob(JOB_INFO.jobId().job())).andReturn(null);
    replay(bigquery);
    assertNull(job.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    JobInfo updatedInfo = JOB_INFO.toBuilder().etag("etag").build();
    expect(bigquery.getJob(JOB_INFO.jobId().job(), BigQuery.JobOption.fields()))
        .andReturn(updatedInfo);
    replay(bigquery);
    Job updatedJob = job.reload(BigQuery.JobOption.fields());
    assertSame(bigquery, updatedJob.bigquery());
    assertEquals(updatedInfo, updatedJob.info());
  }

  @Test
  public void testCancel() throws Exception {
    expect(bigquery.cancel(JOB_INFO.jobId())).andReturn(true);
    replay(bigquery);
    assertTrue(job.cancel());
  }

  @Test
  public void testGet() throws Exception {
    expect(bigquery.getJob(JOB_INFO.jobId().job())).andReturn(JOB_INFO);
    replay(bigquery);
    Job loadedJob = Job.get(bigquery, JOB_INFO.jobId().job());
    assertNotNull(loadedJob);
    assertEquals(JOB_INFO, loadedJob.info());
  }

  @Test
  public void testGetNull() throws Exception {
    expect(bigquery.getJob(JOB_INFO.jobId().job())).andReturn(null);
    replay(bigquery);
    assertNull(Job.get(bigquery, JOB_INFO.jobId().job()));
  }

  @Test
  public void testGetWithOptions() throws Exception {
    expect(bigquery.getJob(JOB_INFO.jobId().job(), BigQuery.JobOption.fields()))
        .andReturn(JOB_INFO);
    replay(bigquery);
    Job loadedJob = Job.get(bigquery, JOB_INFO.jobId().job(), BigQuery.JobOption.fields());
    assertNotNull(loadedJob);
    assertEquals(JOB_INFO, loadedJob.info());
  }
}

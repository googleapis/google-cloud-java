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

package com.google.cloud.examples.bigquery.snippets;

import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobConfiguration;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;

import org.junit.BeforeClass;
import org.junit.Test;

public class ITJobSnippets {

  private static final String QUERY =
      "SELECT corpus FROM `publicdata.samples.shakespeare` GROUP BY corpus;";

  private static BigQuery bigquery;

  @BeforeClass
  public static void beforeClass() {
    bigquery = RemoteBigQueryHelper.create().options().service();
  }

  @Test
  public void testIsDone() throws Exception {
    JobConfiguration jobConfig = QueryJobConfiguration.builder(QUERY).useLegacySql(false).build();
    JobInfo jobInfo = JobInfo.builder(jobConfig).build();
    Job job = bigquery.create(jobInfo);
    JobSnippets jobSnippets = new JobSnippets(job);
    jobSnippets.isDone();
    assertTrue(job.isDone());
  }

  @Test
  public void testWaitFor() throws Exception {
    JobConfiguration jobConfig = QueryJobConfiguration.builder(QUERY).useLegacySql(false).build();
    JobInfo jobInfo = JobInfo.builder(jobConfig).build();
    Job job = bigquery.create(jobInfo);
    JobSnippets jobSnippets = new JobSnippets(job);
    boolean result = jobSnippets.waitFor();
    assertTrue(result);
  }

  @Test
  public void testWaitForWithOptions() throws Exception {
    JobConfiguration jobConfig = QueryJobConfiguration.builder(QUERY).useLegacySql(false).build();
    JobInfo jobInfo = JobInfo.builder(jobConfig).build();
    Job job = bigquery.create(jobInfo);
    JobSnippets jobSnippets = new JobSnippets(job);
    boolean result = jobSnippets.waitForWithOptions();
    assertTrue(result);
  }
}

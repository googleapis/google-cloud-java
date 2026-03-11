/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;

public class BigQueryBaseResultSetTest {
  private BigQuery bigQuery;
  private BigQueryBaseResultSet resultSet;
  private Job job;
  private QueryStatistics statistics;

  @Before
  public void setUp() {
    // Using mock() for QueryStatistics because Builder() seems to not be available
    // from outside.
    bigQuery = mock(BigQuery.class);
    job = mock(Job.class);
    doReturn(job).when(bigQuery).getJob(any(JobId.class));

    statistics = mock(QueryStatistics.class);
    doReturn(statistics).when(job).getStatistics();

    resultSet = mock(BigQueryBaseResultSet.class, CALLS_REAL_METHODS);
    try {
      Field field = BigQueryBaseResultSet.class.getDeclaredField("bigQuery");
      field.setAccessible(true);
      field.set(resultSet, bigQuery);
    } catch (Exception e) {
      assertFalse(true);
    }
  }

  @Test
  public void testGetQueryId() {
    resultSet.setQueryId("queryId");
    assertThat(resultSet.getQueryId()).isEqualTo("queryId");
  }

  @Test
  public void testGetJobId() {
    resultSet.setJobId(JobId.of("jobId"));
    assertThat(resultSet.getJobId()).isEqualTo(JobId.of("jobId"));
  }

  @Test
  public void testGetQueryStatistics() {
    resultSet.setJobId(JobId.of("jobId"));
    assertThat(resultSet.getQueryStatistics()).isInstanceOf(QueryStatistics.class);
  }

  @Test
  public void testGetQueryStatisticsCaching() {
    resultSet.setJobId(JobId.of("jobId"));
    assertThat(resultSet.getQueryStatistics()).isInstanceOf(QueryStatistics.class);
    // Change return value to null to ensure lazy init saved the state
    doReturn(null).when(job).getStatistics();
    assertThat(resultSet.getQueryStatistics()).isInstanceOf(QueryStatistics.class);
  }

  @Test
  public void testGetQueryStatistics_no_client() {
    resultSet = mock(BigQueryBaseResultSet.class, CALLS_REAL_METHODS);
    assertThat(resultSet.getQueryStatistics()).isNull();
  }

  @Test
  public void testGetQueryStatistics_no_job_id() {
    assertThat(resultSet.getQueryStatistics()).isNull();
  }

  @Test
  public void testGetQueryStatistics_no_job() {
    doReturn(job).when(bigQuery).getJob(any(JobId.class));
    assertThat(resultSet.getQueryStatistics()).isNull();
  }
}

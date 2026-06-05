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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatus;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigQueryBaseResultSetTest {
  private BigQuery bigQuery;
  private BigQueryBaseResultSet resultSet;
  private Job job;
  private QueryStatistics statistics;

  @BeforeEach
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
      Field bigQueryField = BigQueryBaseResultSet.class.getDeclaredField("bigQuery");
      bigQueryField.setAccessible(true);
      bigQueryField.set(resultSet, bigQuery);

      Field fetchSizeField = BigQueryBaseResultSet.class.getDeclaredField("fetchSize");
      fetchSizeField.setAccessible(true);
      fetchSizeField.set(resultSet, -1);
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
  public void testGetQueryStatisticsCaching() {
    resultSet.setJobId(JobId.of("jobId"));
    assertThat(resultSet.getQueryStatistics()).isInstanceOf(QueryStatistics.class);
    // Change return value to null to ensure lazy init saved the state
    doReturn(null).when(job).getStatistics();
    assertThat(resultSet.getQueryStatistics()).isInstanceOf(QueryStatistics.class);
  }

  @Test
  public void testGetQueryStatisticsReturnsNullWhenJobIdIsNull() {
    assertThat(resultSet.getQueryStatistics()).isNull();
  }

  @Test
  public void testGetQueryStatisticsReturnsNullWhenJobCannotBeFound() {
    resultSet.setJobId(JobId.of("jobId"));
    doReturn(null).when(bigQuery).getJob(any(JobId.class));
    assertThat(resultSet.getQueryStatistics()).isNull();
  }

  @Test
  public void testWrapperMethods() throws SQLException {
    assertTrue(resultSet.isWrapperFor(java.sql.ResultSet.class));
    assertTrue(resultSet.isWrapperFor(BigQueryBaseResultSet.class));
    assertFalse(resultSet.isWrapperFor(java.sql.Statement.class));
    assertFalse(resultSet.isWrapperFor(null));

    Object unwrappedRs = resultSet.unwrap(java.sql.ResultSet.class);
    assertSame(unwrappedRs, resultSet);

    Object unwrappedImpl = resultSet.unwrap(BigQueryBaseResultSet.class);
    assertSame(unwrappedImpl, resultSet);

    BigQueryJdbcException e =
        assertThrows(BigQueryJdbcException.class, () -> resultSet.unwrap(java.sql.Statement.class));
    assertTrue(e.getMessage().contains("Cannot unwrap to java.sql.Statement"));
  }

  @Test
  public void testGetFetchSizeDefaultWithoutStatement() throws SQLException {
    assertThat(resultSet.getFetchSize()).isEqualTo(20000);
  }

  @Test
  public void testGetFetchSizeWithStatement() throws SQLException, Exception {
    BigQueryStatement statement = mock(BigQueryStatement.class);
    doReturn(1000).when(statement).getFetchSize();

    Field field = BigQueryBaseResultSet.class.getDeclaredField("statement");
    field.setAccessible(true);
    field.set(resultSet, statement);

    assertThat(resultSet.getFetchSize()).isEqualTo(1000);
  }

  @Test
  public void testSetAndGetFetchSize() throws SQLException {
    resultSet.setFetchSize(5000);
    assertThat(resultSet.getFetchSize()).isEqualTo(5000);
  }

  @Test
  public void testSetFetchSizeNegativeThrows() {
    assertThrows(SQLException.class, () -> resultSet.setFetchSize(-5));
  }

  @Test
  public void testFetchDirection() throws SQLException {
    assertThat(resultSet.getFetchDirection()).isEqualTo(ResultSet.FETCH_FORWARD);
    resultSet.setFetchDirection(ResultSet.FETCH_FORWARD); // no-op

    assertThrows(SQLException.class, () -> resultSet.setFetchDirection(ResultSet.FETCH_REVERSE));
  }

  @Test
  public void testWarnings() throws SQLException, Exception {
    // Set jobId on the resultSet
    JobId jobId = JobId.of("my-job-id");
    resultSet.setJobId(jobId);

    // Mock JobStatus and BigQueryError warnings list
    JobStatus jobStatus = mock(JobStatus.class);
    BigQueryError error1 = new BigQueryError("reason1", "location1", "message1");
    BigQueryError error2 = new BigQueryError("reason2", "location2", "message2");
    doReturn(jobStatus).when(job).getStatus();
    doReturn(Arrays.asList(error1, error2)).when(jobStatus).getExecutionErrors();

    // First call should load warnings from mock Job
    SQLWarning warning1 = resultSet.getWarnings();
    assertThat((Object) warning1).isNotNull();
    assertThat(warning1.getMessage()).isEqualTo("message1");
    assertThat(warning1.getSQLState()).isEqualTo("reason1");

    SQLWarning warning2 = warning1.getNextWarning();
    assertThat((Object) warning2).isNotNull();
    assertThat(warning2.getMessage()).isEqualTo("message2");
    assertThat(warning2.getSQLState()).isEqualTo("reason2");

    // Verify lazy caching (repeated calls do not query getJob again)
    SQLWarning warning1Cached = resultSet.getWarnings();
    assertSame(warning1, warning1Cached);

    // Test clearWarnings
    resultSet.clearWarnings();
    assertThat((Object) resultSet.getWarnings()).isNull();
  }

  @Test
  public void testClosedResultSetThrowsOnFetchAndWarnings() throws SQLException, Exception {
    Field field = BigQueryBaseResultSet.class.getDeclaredField("isClosed");
    field.setAccessible(true);
    field.set(resultSet, true);

    assertThrows(SQLException.class, () -> resultSet.getFetchDirection());
    assertThrows(SQLException.class, () -> resultSet.setFetchDirection(ResultSet.FETCH_FORWARD));
    assertThrows(SQLException.class, () -> resultSet.setFetchSize(100));
    assertThrows(SQLException.class, () -> resultSet.getFetchSize());
    assertThrows(SQLException.class, () -> resultSet.getWarnings());
    assertThrows(SQLException.class, () -> resultSet.clearWarnings());
  }

  @Test
  public void testWarningsWithPreCachedJob() throws SQLException {
    resultSet.setJob(job);

    JobStatus jobStatus = mock(JobStatus.class);
    BigQueryError error = new BigQueryError("reason1", "location1", "message1");
    doReturn(jobStatus).when(job).getStatus();
    doReturn(Arrays.asList(error)).when(jobStatus).getExecutionErrors();

    // Invoking getWarnings
    SQLWarning warning = resultSet.getWarnings();
    assertThat((Object) warning).isNotNull();
    assertThat(warning.getMessage()).isEqualTo("message1");

    // Verify that bigQuery.getJob() was never called since the Job was pre-cached!
    verify(bigQuery, never()).getJob(any(JobId.class));
  }

  @Test
  public void testQueryStatisticsWithPreCachedJob() {
    resultSet.setJob(job);

    // Invoking getQueryStatistics
    QueryStatistics stats = resultSet.getQueryStatistics();
    assertThat(stats).isSameInstanceAs(statistics);

    // Verify that bigQuery.getJob() was never called since the Job was pre-cached!
    verify(bigQuery, never()).getJob(any(JobId.class));
  }

  @Test
  public void testSetJobResetsCachedState() throws SQLException {
    resultSet.setJob(job);

    // Fetch warnings and statistics once
    JobStatus jobStatus = mock(JobStatus.class);
    BigQueryError error = new BigQueryError("reason1", "location1", "message1");
    doReturn(jobStatus).when(job).getStatus();
    doReturn(Arrays.asList(error)).when(jobStatus).getExecutionErrors();

    SQLWarning warning1 = resultSet.getWarnings();
    assertThat((Object) warning1).isNotNull();
    assertThat(warning1.getMessage()).isEqualTo("message1");

    QueryStatistics stats1 = resultSet.getQueryStatistics();
    assertThat(stats1).isSameInstanceAs(statistics);

    // Now, set a new mock Job
    Job newJob = mock(Job.class);
    JobStatus newJobStatus = mock(JobStatus.class);
    BigQueryError newError = new BigQueryError("reason2", "location2", "message2");
    doReturn(newJobStatus).when(newJob).getStatus();
    doReturn(Arrays.asList(newError)).when(newJobStatus).getExecutionErrors();

    QueryStatistics newStatistics = mock(QueryStatistics.class);
    doReturn(newStatistics).when(newJob).getStatistics();

    resultSet.setJob(newJob);

    // Verify that the cached values are updated and not using the old ones!
    SQLWarning warning2 = resultSet.getWarnings();
    assertThat((Object) warning2).isNotNull();
    assertThat(warning2.getMessage()).isEqualTo("message2");

    QueryStatistics stats2 = resultSet.getQueryStatistics();
    assertThat(stats2).isSameInstanceAs(newStatistics);
  }

  @Test
  public void testGetWarningsWrapsBigQueryException() {
    // Make sure we have a JobId set but no pre-cached Job, so getWarnings() tries to load it
    resultSet.setJobId(JobId.of("project", "job"));
    resultSet.setJob(null);

    // Mock bigQuery.getJob(jobId) to throw a BigQueryException
    doThrow(new BigQueryException(500, "Internal Server Error"))
        .when(bigQuery)
        .getJob(any(JobId.class));

    // verify that getWarnings() wraps the BigQueryException into a SQLException
    assertThrows(SQLException.class, () -> resultSet.getWarnings());
  }

  @Test
  public void testSetJobUpdatesJobId() {
    Job newJob = mock(Job.class);
    JobId newJobId = JobId.of("new_project", "new_job_id");
    doReturn(newJobId).when(newJob).getJobId();

    resultSet.setJob(newJob);

    assertThat(resultSet.getJobId()).isEqualTo(newJobId);
  }
}

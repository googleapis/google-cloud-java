/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.bigquery.jdbc.utils.ArrowUtilities.serializeSchema;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.QueryResultsOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.JobStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration.Priority;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.jdbc.BigQueryStatement.JobIdWrapper;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.storage.v1.ArrowSchema;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.BitVector;
import org.apache.arrow.vector.FieldVector;
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.VectorSchemaRoot;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class BigQueryStatementTest {

  private BigQueryConnection bigQueryConnection;
  private static final String PROJECT = "project";

  private BigQueryRpcFactory rpcFactoryMock;

  private BigQueryReadClient storageReadClient;

  private BigQuery bigquery;

  private BigQueryStatement bigQueryStatement;

  private final String query = "select * from test";

  private final String jobIdVal = UUID.randomUUID().toString();

  private JobId jobId;

  private static final FieldList fieldList =
      FieldList.of(
          Field.of("first", StandardSQLTypeName.BOOL),
          Field.of("second", StandardSQLTypeName.INT64));

  private static final String DEFAULT_TEST_DATASET = "bigquery_test_dataset";

  private static final TableId TABLE_ID = TableId.of(DEFAULT_TEST_DATASET, PROJECT);

  private static ArrowSchema arrowSchema;

  private final Map<String, String> LABELS =
      new HashMap<String, String>() {
        {
          put("key1", "val1");
          put("key2", "val2");
          put("key3", "val3");
        }
      };

  private Job getJobMock(
      TableResult result, QueryJobConfiguration configuration, StatementType type)
      throws InterruptedException {
    Job job = mock(Job.class);
    JobStatistics.QueryStatistics statistics = mock(QueryStatistics.class);
    JobId jobId = mock(JobId.class);
    doReturn(result).when(job).getQueryResults(any(QueryResultsOption.class));
    doReturn(jobId).when(job).getJobId();
    doReturn(configuration).when(job).getConfiguration();
    doReturn(statistics).when(job).getStatistics();
    doReturn(type).when(statistics).getStatementType();
    return job;
  }

  @Before
  public void setUp() throws IOException, SQLException {
    bigQueryConnection = mock(BigQueryConnection.class);
    rpcFactoryMock = mock(BigQueryRpcFactory.class);
    bigquery = mock(BigQuery.class);
    bigQueryConnection.bigQuery = bigquery;
    storageReadClient = mock(BigQueryReadClient.class);
    jobId = JobId.newBuilder().setJob(jobIdVal).build();

    doReturn(bigquery).when(bigQueryConnection).getBigQuery();
    doReturn(10L).when(bigQueryConnection).getJobTimeoutInSeconds();
    doReturn(10L).when(bigQueryConnection).getMaxBytesBilled();
    doReturn(LABELS).when(bigQueryConnection).getLabels();
    doReturn(BigQueryJdbcUrlUtility.DEFAULT_QUERY_DIALECT_VALUE)
        .when(bigQueryConnection)
        .getQueryDialect();
    doReturn(1000L).when(bigQueryConnection).getMaxResults();
    bigQueryStatement = new BigQueryStatement(bigQueryConnection);
    VectorSchemaRoot vectorSchemaRoot = getTestVectorSchemaRoot();
    arrowSchema =
        ArrowSchema.newBuilder()
            .setSerializedSchema(serializeSchema(vectorSchemaRoot.getSchema()))
            .build();
    // bigQueryConnection.addOpenStatements(bigQueryStatement);

  }

  private VectorSchemaRoot getTestVectorSchemaRoot() {
    RootAllocator allocator = new RootAllocator();
    BitVector boolField =
        new BitVector("boolField", allocator); // Mapped with StandardSQLTypeName.BOOL
    boolField.allocateNew(2);
    boolField.set(0, 0);
    boolField.setValueCount(1);
    IntVector int64Filed =
        new IntVector("int64Filed", allocator); // Mapped with StandardSQLTypeName.INT64
    int64Filed.allocateNew(2);
    int64Filed.set(0, 1);
    int64Filed.setValueCount(1);
    List<FieldVector> fieldVectors = ImmutableList.of(boolField, int64Filed);
    return new VectorSchemaRoot(fieldVectors);
  }

  private BigQueryOptions createBigQueryOptionsForProject(
      String project, BigQueryRpcFactory rpcFactory) {
    return BigQueryOptions.newBuilder()
        .setProjectId(project)
        .setServiceRpcFactory(rpcFactory)
        .setRetrySettings(ServiceOptions.getNoRetrySettings())
        .build();
  }

  @Test
  public void testStatementNonNull() {
    assertThat(bigQueryStatement).isNotNull();
  }

  @Ignore
  public void testExecFastQueryPath() throws SQLException, InterruptedException {
    JobIdWrapper jobIdWrapper = new JobIdWrapper(jobId, null, null);
    BigQueryStatement bigQueryStatementSpy = Mockito.spy(bigQueryStatement);

    TableResult result = Mockito.mock(TableResult.class);
    BigQueryJsonResultSet jsonResultSet = mock(BigQueryJsonResultSet.class);
    QueryJobConfiguration jobConfiguration = QueryJobConfiguration.newBuilder(query).build();

    doReturn(result).when(bigquery).query(jobConfiguration);
    doReturn(jsonResultSet).when(bigQueryStatementSpy).processJsonResultSet(result);

    bigQueryStatementSpy.runQuery(query, jobConfiguration);
    // verify the statement's state
    assertThat(bigQueryStatementSpy.jobIds.size()).isEqualTo(1); // job id should be created
    assertThat(bigQueryStatementSpy.jobIds.get(0)).isNotNull();
    // assertThat(bigQueryStatementSpy.currentResultSet).isNotNull();

  }

  @Test
  public void testExecSlowQueryPath() throws SQLException, InterruptedException {
    JobIdWrapper jobIdWrapper = new JobIdWrapper(jobId, null, null);
    BigQueryStatement bigQueryStatementSpy = Mockito.spy(bigQueryStatement);
    TableResult tableResult = mock(TableResult.class);
    QueryJobConfiguration queryJobConfiguration =
        QueryJobConfiguration.newBuilder(query)
            .setPriority(Priority.BATCH) // query settings for slow query path
            .build();
    Job job = getJobMock(tableResult, queryJobConfiguration, StatementType.SELECT);

    doReturn(job).when(bigquery).create(any(JobInfo.class));

    doReturn(jobIdWrapper)
        .when(bigQueryStatementSpy)
        .insertJob(any(com.google.cloud.bigquery.JobConfiguration.class));
    doReturn(false).when(bigQueryStatementSpy).useReadAPI(eq(tableResult));
    doReturn(mock(JobId.class)).when(tableResult).getJobId();

    ResultSet bigQueryJsonResultSet = mock(BigQueryJsonResultSet.class);

    doReturn(bigQueryJsonResultSet)
        .when(bigQueryStatementSpy)
        .processJsonResultSet(any(TableResult.class));

    bigQueryStatementSpy.runQuery(query, queryJobConfiguration);
    // verify the statement's state
    // job id is created during runQuery, but cleaned up after function completes.
    assertThat(bigQueryStatementSpy.jobIds.size()).isEqualTo(0);
    assertThat(bigQueryStatementSpy.getResultSet()).isEqualTo(bigQueryJsonResultSet);
  }

  @Test
  public void getArrowResultSetTest() throws SQLException {
    BigQueryStatement bigQueryStatementSpy = Mockito.spy(bigQueryStatement);
    BigQueryReadClient bigQueryReadClient = Mockito.spy(mock(BigQueryReadClient.class));
    Schema schema = Schema.of(fieldList);
    ReadSession readSession = ReadSession.getDefaultInstance();
    doReturn(bigQueryReadClient).when(bigQueryStatementSpy).getBigQueryReadClient();
    doReturn(readSession)
        .when(bigQueryStatementSpy)
        .getReadSession(any(CreateReadSessionRequest.class));
    Thread mockWorker = new Thread();
    doReturn(mockWorker)
        .when(bigQueryStatementSpy)
        .populateArrowBufferedQueue(
            any(ReadSession.class), any(BlockingQueue.class), any(BigQueryReadClient.class));

    doReturn(arrowSchema).when(bigQueryStatementSpy).getArrowSchema(any(ReadSession.class));

    JobId jobId = JobId.of("123");
    TableResult result = Mockito.mock(TableResult.class);
    doReturn(schema).when(result).getSchema();
    doReturn(10L).when(result).getTotalRows();
    doReturn(TABLE_ID).when(bigQueryStatementSpy).getDestinationTable(any());
    doReturn(jobId).when(result).getJobId();
    Job job = mock(Job.class);
    doReturn(mock(QueryStatistics.class)).when(job).getStatistics();
    doReturn(job).when(bigquery).getJob(jobId);

    ResultSet resultSet = bigQueryStatementSpy.processArrowResultSet(result);
    assertThat(resultSet).isNotNull();
    assertThat(resultSet).isInstanceOf(BigQueryArrowResultSet.class);
    assertThat(resultSet.isLast()).isFalse(); // as we have 10 rows
  }

  @Test
  public void getJobTimeoutTest() throws Exception {
    QueryJobConfiguration jobConfig = bigQueryStatement.getJobConfig("select 1").build();
    assertEquals(10000L, jobConfig.getJobTimeoutMs().longValue());
  }

  @Test
  public void getMaxBytesBilledTest() throws Exception {
    QueryJobConfiguration jobConfig = bigQueryStatement.getJobConfig("select 1").build();
    assertEquals(10L, jobConfig.getMaximumBytesBilled().longValue());
  }

  @Test
  public void testSetMaxRowsJson() throws SQLException {
    assertEquals(0, bigQueryStatement.getMaxRows());
    bigQueryStatement.setMaxRows(10);
    assertEquals(10, bigQueryStatement.getMaxRows());
  }

  @Test
  public void setQueryTimeoutTest() throws Exception {
    bigQueryStatement.setQueryTimeout(3);
    BigQueryStatement bigQueryStatementSpy = Mockito.spy(bigQueryStatement);

    TableResult result = Mockito.mock(TableResult.class);
    BigQueryJsonResultSet jsonResultSet = mock(BigQueryJsonResultSet.class);
    QueryJobConfiguration jobConfiguration =
        QueryJobConfiguration.newBuilder(query).setJobTimeoutMs(10000L).build();

    Job job = getJobMock(result, jobConfiguration, StatementType.SELECT);
    doReturn(job).when(bigquery).create(any(JobInfo.class));

    doReturn(jsonResultSet).when(bigQueryStatementSpy).processJsonResultSet(result);
    ArgumentCaptor<JobInfo> captor = ArgumentCaptor.forClass(JobInfo.class);

    bigQueryStatementSpy.runQuery(query, jobConfiguration);
    verify(bigquery).create(captor.capture());
    QueryJobConfiguration jobConfig = captor.getValue().getConfiguration();
    assertEquals(3000L, jobConfig.getJobTimeoutMs().longValue());
  }

  @Test
  public void getLabelsTest() throws Exception {
    QueryJobConfiguration jobConfig = bigQueryStatement.getJobConfig("select 1").build();
    Map<String, String> expected =
        new HashMap<String, String>() {
          {
            put("key1", "val1");
            put("key2", "val2");
            put("key3", "val3");
          }
        };

    assertTrue(Maps.difference(expected, jobConfig.getLabels()).areEqual());
  }

  @Test
  public void getUpdateCountTest() {
    bigQueryStatement.setUpdateCount(100L);
    assertEquals(100, bigQueryStatement.getUpdateCount());
    assertEquals(100L, bigQueryStatement.getLargeUpdateCount());
  }

  @Test
  public void testSetExtraLabels() {
    Map<String, String> extraLabels = new HashMap<>();
    extraLabels.put("extraKey1", "extraVal1");
    bigQueryStatement.setExtraLabels(extraLabels);
    assertEquals(extraLabels, bigQueryStatement.getExtraLabels());
  }

  @Test
  public void testGetJobConfigWithExtraLabels() {
    Map<String, String> extraLabels = new HashMap<>();
    extraLabels.put("extraKey1", "extraVal1");
    extraLabels.put("key1", "overrideVal1"); // Override connection label
    bigQueryStatement.setExtraLabels(extraLabels);

    QueryJobConfiguration jobConfig = bigQueryStatement.getJobConfig("select 1").build();
    Map<String, String> expectedLabels = new HashMap<>();
    expectedLabels.put("key1", "overrideVal1");
    expectedLabels.put("key2", "val2");
    expectedLabels.put("key3", "val3");
    expectedLabels.put("extraKey1", "extraVal1");

    assertTrue(Maps.difference(expectedLabels, jobConfig.getLabels()).areEqual());
  }

  @Test
  public void testJoblessQuery() throws SQLException, InterruptedException {
    // 1. Test JobCreationMode=2 (jobless)
    doReturn(true).when(bigQueryConnection).getUseStatelessQueryMode();
    BigQueryStatement joblessStatement = new BigQueryStatement(bigQueryConnection);
    BigQueryStatement joblessStatementSpy = Mockito.spy(joblessStatement);

    TableResult tableResultMock = mock(TableResult.class);
    doReturn("queryId").when(tableResultMock).getQueryId();
    doReturn(null).when(tableResultMock).getJobId();
    doReturn(tableResultMock)
        .when(bigquery)
        .queryWithTimeout(any(QueryJobConfiguration.class), any(), any());
    doReturn(mock(BigQueryJsonResultSet.class))
        .when(joblessStatementSpy)
        .processJsonResultSet(tableResultMock);

    Job dryRunJobMock = getJobMock(null, null, StatementType.SELECT);
    ArgumentCaptor<JobInfo> dryRunCaptor = ArgumentCaptor.forClass(JobInfo.class);
    doReturn(dryRunJobMock).when(bigquery).create(dryRunCaptor.capture());

    joblessStatementSpy.executeQuery("SELECT 1");

    verify(bigquery).queryWithTimeout(any(QueryJobConfiguration.class), any(), any());
    verify(bigquery).create(any(JobInfo.class));
    assertTrue(
        Boolean.TRUE.equals(
            ((QueryJobConfiguration) dryRunCaptor.getValue().getConfiguration()).dryRun()));

    // 2. Test JobCreationMode=1 (jobful)
    Mockito.reset(bigquery);
    doReturn(false).when(bigQueryConnection).getUseStatelessQueryMode();
    BigQueryStatement jobfulStatement = new BigQueryStatement(bigQueryConnection);
    BigQueryStatement jobfulStatementSpy = Mockito.spy(jobfulStatement);

    TableResult tableResultJobfulMock = mock(TableResult.class);
    QueryJobConfiguration jobConf = QueryJobConfiguration.newBuilder("SELECT 1").build();
    Job jobMock = getJobMock(tableResultJobfulMock, jobConf, StatementType.SELECT);
    ArgumentCaptor<JobInfo> jobfulCaptor = ArgumentCaptor.forClass(JobInfo.class);
    doReturn(jobMock).when(bigquery).create(jobfulCaptor.capture());
    doReturn(mock(BigQueryJsonResultSet.class))
        .when(jobfulStatementSpy)
        .processJsonResultSet(tableResultJobfulMock);

    jobfulStatementSpy.executeQuery("SELECT 1");

    verify(bigquery).create(any(JobInfo.class));
    assertTrue(
        jobfulCaptor.getAllValues().stream()
            .noneMatch(
                jobInfo ->
                    Boolean.TRUE.equals(
                        ((QueryJobConfiguration) jobInfo.getConfiguration()).dryRun())));
    verify(bigquery, Mockito.never())
        .queryWithTimeout(any(QueryJobConfiguration.class), any(), any());
  }

  @Test
  public void testCloseCancelsJob() throws SQLException, InterruptedException {
    BigQueryStatement bigQueryStatementSpy = Mockito.spy(bigQueryStatement);
    TableResult tableResult = mock(TableResult.class);
    Schema mockSchema = Schema.of(FieldList.of());
    doReturn(mockSchema).when(tableResult).getSchema();
    QueryJobConfiguration queryJobConfiguration =
        QueryJobConfiguration.newBuilder(query).setPriority(Priority.BATCH).build();
    Job job = getJobMock(tableResult, queryJobConfiguration, StatementType.SELECT);

    doReturn(job).when(bigquery).create(any(JobInfo.class));
    doReturn(false).when(bigQueryStatementSpy).useReadAPI(eq(tableResult));
    doReturn(mock(JobId.class)).when(tableResult).getJobId();
    Mockito.when(job.getQueryResults(any(QueryResultsOption.class)))
        .thenAnswer(
            invocation -> {
              Thread.sleep(2000);
              return null;
            });
    Thread t =
        new Thread(
            () -> {
              try {
                bigQueryStatementSpy.runQuery(query, queryJobConfiguration);
              } catch (Exception e) {
              }
            });

    t.start();
    // Sleep to allow background thread to call "create".
    Thread.sleep(500);
    bigQueryStatementSpy.close();
    t.join();
    verify(bigquery, Mockito.times(1)).cancel(any(JobId.class));
  }

  @Test
  public void testCancelWithJoblessQuery() throws SQLException, InterruptedException {
    doReturn(true).when(bigQueryConnection).getUseStatelessQueryMode();
    BigQueryStatement joblessStatement = new BigQueryStatement(bigQueryConnection);
    BigQueryStatement joblessStatementSpy = Mockito.spy(joblessStatement);

    TableResult tableResultMock = mock(TableResult.class);
    doReturn(null).when(tableResultMock).getJobId();

    doReturn(tableResultMock)
        .when(bigquery)
        .queryWithTimeout(any(QueryJobConfiguration.class), any(), any());

    Job dryRunJobMock = getJobMock(null, null, StatementType.SELECT);
    doReturn(dryRunJobMock).when(bigquery).create(any(JobInfo.class));

    BigQueryJsonResultSet resultSetMock = mock(BigQueryJsonResultSet.class);
    doReturn(resultSetMock).when(joblessStatementSpy).processJsonResultSet(tableResultMock);

    joblessStatementSpy.executeQuery("SELECT 1");

    // Pre-check: statement has a result set
    assertTrue(joblessStatementSpy.currentResultSet != null);

    joblessStatementSpy.cancel();

    // Post-check: The result set's close() method was called
    verify(resultSetMock).close();

    // And no backend cancellation was attempted
    verify(bigquery, Mockito.never()).cancel(any(JobId.class));
  }
}

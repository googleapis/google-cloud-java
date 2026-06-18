/*
 * Copyright 2023 Google LLC
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.QueryResultsOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValueList;
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
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
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
import java.util.ArrayList;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

  @BeforeEach
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

  @Disabled
  public void testExecFastQueryPath() throws SQLException, InterruptedException {
    JobIdWrapper jobIdWrapper = new JobIdWrapper(jobId, null, null);
    BigQueryStatement bigQueryStatementSpy = Mockito.spy(bigQueryStatement);

    TableResult result = Mockito.mock(TableResult.class);
    BigQueryJsonResultSet jsonResultSet = mock(BigQueryJsonResultSet.class);
    QueryJobConfiguration jobConfiguration = QueryJobConfiguration.newBuilder(query).build();

    doReturn(result).when(bigquery).query(jobConfiguration);
    doReturn(jsonResultSet).when(bigQueryStatementSpy).processJsonResultSet(eq(result), any());

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

    doReturn(job).when(bigquery).queryWithTimeout(any(), any(), any());

    doReturn(jobIdWrapper)
        .when(bigQueryStatementSpy)
        .insertJob(any(com.google.cloud.bigquery.JobConfiguration.class));
    doReturn(false).when(bigQueryStatementSpy).useReadAPI(eq(tableResult));
    doReturn(mock(JobId.class)).when(tableResult).getJobId();

    ResultSet bigQueryJsonResultSet = mock(BigQueryJsonResultSet.class);

    doReturn(bigQueryJsonResultSet)
        .when(bigQueryStatementSpy)
        .processJsonResultSet(any(TableResult.class), any());

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

    ResultSet resultSet = bigQueryStatementSpy.processArrowResultSet(result, null);
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
    doReturn(job).when(bigquery).queryWithTimeout(any(), any(), any());

    doReturn(jsonResultSet).when(bigQueryStatementSpy).processJsonResultSet(eq(result), any());
    ArgumentCaptor<QueryJobConfiguration> captor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);

    bigQueryStatementSpy.runQuery(query, jobConfiguration);
    verify(bigquery).queryWithTimeout(captor.capture(), any(), any());
    QueryJobConfiguration jobConfig = captor.getValue();
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
        .processJsonResultSet(eq(tableResultMock), any());

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
    doReturn(jobMock)
        .when(bigquery)
        .queryWithTimeout(any(QueryJobConfiguration.class), any(), any());
    doReturn(mock(BigQueryJsonResultSet.class))
        .when(jobfulStatementSpy)
        .processJsonResultSet(eq(tableResultJobfulMock), any());

    jobfulStatementSpy.executeQuery("SELECT 1");

    verify(bigquery).queryWithTimeout(any(QueryJobConfiguration.class), any(), any());
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

    doReturn(job).when(bigquery).queryWithTimeout(any(), any(), any());
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
    doReturn(resultSetMock)
        .when(joblessStatementSpy)
        .processJsonResultSet(eq(tableResultMock), any());

    joblessStatementSpy.executeQuery("SELECT 1");

    // Pre-check: statement has a result set
    assertTrue(joblessStatementSpy.currentResultSet != null);

    joblessStatementSpy.cancel();

    // Post-check: The result set's close() method was called
    verify(resultSetMock).close();

    // And no backend cancellation was attempted
    verify(bigquery, Mockito.never()).cancel(any(JobId.class));
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  public void testGetStatementType(boolean isReadOnlyTokenUsed) throws Exception {
    doReturn(isReadOnlyTokenUsed).when(bigQueryConnection).isReadOnlyTokenUsed();

    Job dryRunJobMock = getJobMock(null, null, StatementType.SELECT);
    doReturn(dryRunJobMock).when(bigquery).create(any(JobInfo.class));

    BigQueryStatement statementSpy = Mockito.spy(bigQueryStatement);
    QueryJobConfiguration queryJobConfiguration = QueryJobConfiguration.newBuilder(query).build();

    StatementType type = statementSpy.getStatementType(queryJobConfiguration);

    assertThat(type).isEqualTo(StatementType.SELECT);
    verify(bigquery, isReadOnlyTokenUsed ? Mockito.never() : Mockito.times(1))
        .create(any(JobInfo.class));
  }

  @Test
  public void testProcessQueryResponseFallbackToJsonOnReadApiFailure() throws SQLException {
    BigQueryStatement statementSpy = Mockito.spy(bigQueryStatement);
    TableResult tableResultMock = mockTableResultWithJob("job-id");

    // Force useReadAPI to return true to enter the HTAPI block
    doReturn(true).when(statementSpy).useReadAPI(tableResultMock);

    // Mock a permission denied ApiException
    ApiException apiExceptionMock = mockApiException(StatusCode.Code.PERMISSION_DENIED);

    BigQueryJdbcException exceptionToThrow =
        new BigQueryJdbcException("Simulated permission denied", apiExceptionMock);

    // Force processArrowResultSet to throw the permission exception
    Mockito.doThrow(exceptionToThrow)
        .when(statementSpy)
        .processArrowResultSet(eq(tableResultMock), any());

    BigQueryJsonResultSet jsonResultSetMock = mock(BigQueryJsonResultSet.class);
    // Mock processJsonResultSet to return our mock JSON result set
    doReturn(jsonResultSetMock).when(statementSpy).processJsonResultSet(eq(tableResultMock), any());

    statementSpy.processQueryResponse("SELECT 1", tableResultMock);

    // Verify that processJsonResultSet was indeed called as a fallback
    verify(statementSpy).processJsonResultSet(eq(tableResultMock), any());
    // Verify that currentResultSet is set to the mocked JSON result set
    assertThat(statementSpy.currentResultSet).isEqualTo(jsonResultSetMock);
  }

  @Test
  public void testProcessQueryResponseNoFallbackOnNonPermissionFailure() throws SQLException {
    BigQueryStatement statementSpy = Mockito.spy(bigQueryStatement);
    TableResult tableResultMock = mockTableResultWithJob("job-id");

    // Force useReadAPI to return true to enter the HTAPI block
    doReturn(true).when(statementSpy).useReadAPI(tableResultMock);

    // Mock a non-permission ApiException (e.g., INTERNAL)
    ApiException apiExceptionMock = mockApiException(StatusCode.Code.INTERNAL);

    BigQueryJdbcException exceptionToThrow =
        new BigQueryJdbcException("Simulated internal error", apiExceptionMock);

    // Force processArrowResultSet to throw the non-permission exception
    Mockito.doThrow(exceptionToThrow)
        .when(statementSpy)
        .processArrowResultSet(eq(tableResultMock), any());

    BigQueryJsonResultSet jsonResultSetMock = mock(BigQueryJsonResultSet.class);
    doReturn(jsonResultSetMock).when(statementSpy).processJsonResultSet(eq(tableResultMock), any());

    // Assert that the exception is propagated
    try {
      statementSpy.processQueryResponse("SELECT 1", tableResultMock);
      fail("Expected SQLException to be thrown");
    } catch (SQLException e) {
      assertEquals(exceptionToThrow, e);
    }

    // Verify that processJsonResultSet was NOT called
    verify(statementSpy, Mockito.never()).processJsonResultSet(eq(tableResultMock), any());
  }

  private TableResult mockTableResultWithJob(String jobId) {
    TableResult tableResult = mock(TableResult.class);
    doReturn(JobId.of(jobId)).when(tableResult).getJobId();
    return tableResult;
  }

  private ApiException mockApiException(StatusCode.Code code) {
    ApiException apiExceptionMock = mock(ApiException.class);
    StatusCode statusCodeMock = mock(StatusCode.class);
    doReturn(statusCodeMock).when(apiExceptionMock).getStatusCode();
    doReturn(code).when(statusCodeMock).getCode();
    return apiExceptionMock;
  }

  @Test
  public void testUseReadAPI_SafeguardSmallDataset() throws SQLException {
    // Setup: totalRows < MinTableSize, so it should not activate the Read API
    doReturn(true).when(bigQueryConnection).isEnableHighThroughputAPI();
    doReturn(100).when(bigQueryConnection).getHighThroughputMinTableSize();
    doReturn(2).when(bigQueryConnection).getHighThroughputActivationRatio();
    doReturn(1000L).when(bigQueryConnection).getMaxResults();

    BigQueryStatement statement = new BigQueryStatement(bigQueryConnection);
    TableResult tableResult = mock(TableResult.class);
    doReturn(50L).when(tableResult).getTotalRows();

    // Standard java collection in values
    List<FieldValueList> valuesList = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      valuesList.add(mock(FieldValueList.class));
    }
    doReturn(valuesList).when(tableResult).getValues();

    boolean useReadApi = statement.useReadAPI(tableResult);
    assertThat(useReadApi).isFalse();
  }

  @Test
  public void testUseReadAPI_SafeguardNoNextPage() throws SQLException {
    // Setup: totalRows = 500 > MinTableSize (100), but hasNextPage() is false.
    // Safeguard should prevent double-fetching and not activate the Read API.
    doReturn(true).when(bigQueryConnection).isEnableHighThroughputAPI();
    doReturn(100).when(bigQueryConnection).getHighThroughputMinTableSize();
    doReturn(2).when(bigQueryConnection).getHighThroughputActivationRatio();
    doReturn(1000L).when(bigQueryConnection).getMaxResults();

    BigQueryStatement statement = new BigQueryStatement(bigQueryConnection);
    TableResult tableResult = mock(TableResult.class);
    doReturn(500L).when(tableResult).getTotalRows();
    doReturn(false).when(tableResult).hasNextPage();

    boolean useReadApi = statement.useReadAPI(tableResult);
    assertThat(useReadApi).isFalse();
  }

  @Test
  public void testUseReadAPI_MeetsRatio() throws SQLException {
    // Setup: totalRows = 500, maxResultPerPage = 100, MinTableSize = 100, ActivationRatio = 2
    // ratio = 5 > 2, should activate Read API
    doReturn(true).when(bigQueryConnection).isEnableHighThroughputAPI();
    doReturn(100).when(bigQueryConnection).getHighThroughputMinTableSize();
    doReturn(2).when(bigQueryConnection).getHighThroughputActivationRatio();
    doReturn(100L).when(bigQueryConnection).getMaxResults();

    BigQueryStatement statement = new BigQueryStatement(bigQueryConnection);
    TableResult tableResult = mock(TableResult.class);
    doReturn(500L).when(tableResult).getTotalRows();
    doReturn(true).when(tableResult).hasNextPage();

    boolean useReadApi = statement.useReadAPI(tableResult);
    assertThat(useReadApi).isTrue();
  }

  @Test
  public void testUseReadAPI_FailsMinTableSize() throws SQLException {
    // Setup: totalRows = 80 < MinTableSize (100)
    doReturn(true).when(bigQueryConnection).isEnableHighThroughputAPI();
    doReturn(100).when(bigQueryConnection).getHighThroughputMinTableSize();
    doReturn(2).when(bigQueryConnection).getHighThroughputActivationRatio();
    doReturn(1000L).when(bigQueryConnection).getMaxResults();

    BigQueryStatement statement = new BigQueryStatement(bigQueryConnection);
    TableResult tableResult = mock(TableResult.class);
    doReturn(80L).when(tableResult).getTotalRows();

    boolean useReadApi = statement.useReadAPI(tableResult);
    assertThat(useReadApi).isFalse();
  }

  @Test
  public void testUseReadAPI_ZeroPageSizeDivisionByZeroSafeguard() throws SQLException {
    // Setup: totalRows = 500, MinTableSize = 100, ActivationRatio = 2, maxResultPerPage = 0
    // Verify that the division by zero check safely guards and falls back to pageSize = 1
    doReturn(true).when(bigQueryConnection).isEnableHighThroughputAPI();
    doReturn(100).when(bigQueryConnection).getHighThroughputMinTableSize();
    doReturn(2).when(bigQueryConnection).getHighThroughputActivationRatio();
    doReturn(0L).when(bigQueryConnection).getMaxResults(); // maxResultPerPage = 0

    BigQueryStatement statement = new BigQueryStatement(bigQueryConnection);
    TableResult tableResult = mock(TableResult.class);
    doReturn(500L).when(tableResult).getTotalRows();
    doReturn(true).when(tableResult).hasNextPage();

    // This should not throw ArithmeticException (/ by zero) and should evaluate safely
    boolean useReadApi = statement.useReadAPI(tableResult);
    assertThat(useReadApi).isTrue(); // ratio = 500 / 1 = 500 > 2 -> true
  }

  @Test
  public void testWrapperMethods() throws SQLException {
    assertTrue(bigQueryStatement.isWrapperFor(java.sql.Statement.class));
    assertTrue(bigQueryStatement.isWrapperFor(BigQueryStatement.class));
    assertFalse(bigQueryStatement.isWrapperFor(java.sql.Connection.class));
    assertFalse(bigQueryStatement.isWrapperFor(null));

    Object unwrappedStmt = bigQueryStatement.unwrap(java.sql.Statement.class);
    org.junit.jupiter.api.Assertions.assertSame(unwrappedStmt, bigQueryStatement);

    Object unwrappedImpl = bigQueryStatement.unwrap(BigQueryStatement.class);
    org.junit.jupiter.api.Assertions.assertSame(unwrappedImpl, bigQueryStatement);

    BigQueryJdbcException e =
        org.junit.jupiter.api.Assertions.assertThrows(
            BigQueryJdbcException.class, () -> bigQueryStatement.unwrap(java.sql.Connection.class));
    assertTrue(e.getMessage().contains("Cannot unwrap to java.sql.Connection"));
  }

  @Test
  public void testPreparedStatementExecuteQueryWithLargeResults() throws Exception {
    // Setup connection mocks to return large results settings
    doReturn(true).when(bigQueryConnection).isAllowLargeResults();
    doReturn("test_dataset").when(bigQueryConnection).getDestinationDataset();
    doReturn("test_table").when(bigQueryConnection).getDestinationTable();

    com.google.cloud.bigquery.Dataset dataset = mock(com.google.cloud.bigquery.Dataset.class);
    doReturn(dataset).when(bigquery).getDataset(any(com.google.cloud.bigquery.DatasetId.class));

    // Create PreparedStatement
    BigQueryPreparedStatement preparedStatement =
        new BigQueryPreparedStatement(bigQueryConnection, query);
    BigQueryPreparedStatement preparedStatementSpy = Mockito.spy(preparedStatement);

    TableResult result = Mockito.mock(TableResult.class);
    BigQueryJsonResultSet jsonResultSet = mock(BigQueryJsonResultSet.class);
    QueryJobConfiguration jobConfiguration = QueryJobConfiguration.newBuilder(query).build();
    Job job = getJobMock(result, jobConfiguration, StatementType.SELECT);

    doReturn(job).when(bigquery).queryWithTimeout(any(), any(), any());
    doReturn(jsonResultSet).when(preparedStatementSpy).processJsonResultSet(eq(result), any());

    Job dryRunJob = getJobMock(null, jobConfiguration, StatementType.SELECT);
    doReturn(dryRunJob).when(bigquery).create(any(JobInfo.class));

    // Act
    preparedStatementSpy.executeQuery();

    // Assert
    ArgumentCaptor<QueryJobConfiguration> captor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);
    verify(bigquery).queryWithTimeout(captor.capture(), any(), any());
    QueryJobConfiguration capturedConfig = captor.getValue();

    assertThat(capturedConfig.getDestinationTable())
        .isEqualTo(TableId.of("test_dataset", "test_table"));
    assertThat(capturedConfig.allowLargeResults()).isTrue();
  }

  @Test
  public void testPreparedStatementExecuteWithLargeResults() throws Exception {
    // Setup connection mocks to return large results settings
    doReturn(true).when(bigQueryConnection).isAllowLargeResults();
    doReturn("test_dataset").when(bigQueryConnection).getDestinationDataset();
    doReturn("test_table").when(bigQueryConnection).getDestinationTable();

    com.google.cloud.bigquery.Dataset dataset = mock(com.google.cloud.bigquery.Dataset.class);
    doReturn(dataset).when(bigquery).getDataset(any(com.google.cloud.bigquery.DatasetId.class));

    // Create PreparedStatement
    BigQueryPreparedStatement preparedStatement =
        new BigQueryPreparedStatement(bigQueryConnection, query);
    BigQueryPreparedStatement preparedStatementSpy = Mockito.spy(preparedStatement);

    TableResult result = Mockito.mock(TableResult.class);
    BigQueryJsonResultSet jsonResultSet = mock(BigQueryJsonResultSet.class);
    QueryJobConfiguration jobConfiguration = QueryJobConfiguration.newBuilder(query).build();
    Job job = getJobMock(result, jobConfiguration, StatementType.SELECT);

    doReturn(job).when(bigquery).queryWithTimeout(any(), any(), any());
    doReturn(jsonResultSet).when(preparedStatementSpy).processJsonResultSet(eq(result), any());

    Job dryRunJob = getJobMock(null, jobConfiguration, StatementType.SELECT);
    doReturn(dryRunJob).when(bigquery).create(any(JobInfo.class));

    // Act
    preparedStatementSpy.execute();

    // Assert
    ArgumentCaptor<QueryJobConfiguration> captor =
        ArgumentCaptor.forClass(QueryJobConfiguration.class);
    verify(bigquery).queryWithTimeout(captor.capture(), any(), any());
    QueryJobConfiguration capturedConfig = captor.getValue();

    assertThat(capturedConfig.getDestinationTable())
        .isEqualTo(TableId.of("test_dataset", "test_table"));
    assertThat(capturedConfig.allowLargeResults()).isTrue();
  }

  @Test
  public void testSetFetchSizeNegativeThrows() {
    org.junit.jupiter.api.Assertions.assertThrows(
        SQLException.class, () -> bigQueryStatement.setFetchSize(-1));
  }

  @Test
  public void testSetAndGetFetchSize() throws SQLException {
    bigQueryStatement.setFetchSize(100);
    assertEquals(100, bigQueryStatement.getFetchSize());
  }
}

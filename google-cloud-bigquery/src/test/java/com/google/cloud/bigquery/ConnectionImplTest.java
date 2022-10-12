/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import com.google.api.services.bigquery.model.*;
import com.google.api.services.bigquery.model.QueryResponse;
import com.google.cloud.ServiceOptions;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionImplTest {
  private BigQueryOptions options;
  private BigQueryRpcFactory rpcFactoryMock;
  private BigQueryRpc bigqueryRpcMock;
  private Connection connectionMock;
  private BigQuery bigquery;
  private ConnectionImpl connection;
  private static final String PROJECT = "project";
  private static final String JOB = "job";
  private static final String LOCATION = "US";
  private static final String DEFAULT_TEST_DATASET = "bigquery_test_dataset";
  private static final String PAGE_TOKEN = "ABCD123";
  private static final TableId TABLE_NAME = TableId.of(DEFAULT_TEST_DATASET, PROJECT);
  private static final TableCell STRING_CELL = new TableCell().setV("Value");
  private static final TableRow TABLE_ROW = new TableRow().setF(ImmutableList.of(STRING_CELL));
  private static final String SQL_QUERY =
      "SELECT  county, state_name FROM bigquery_test_dataset.large_data_testing_table limit 2";
  private static final String DRY_RUN_SQL =
      "SELECT  county, state_name FROM bigquery_test_dataset.large_data_testing_table where country = ?";
  private static final int DEFAULT_PAGE_SIZE = 10000;
  private ConnectionSettings connectionSettings;
  private static final Schema QUERY_SCHEMA =
      Schema.of(
          Field.newBuilder("country", StandardSQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("state_name", StandardSQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build());
  private static final TableSchema FAST_QUERY_TABLESCHEMA = QUERY_SCHEMA.toPb();
  private static final BigQueryResult BQ_RS_MOCK_RES =
      new BigQueryResultImpl(QUERY_SCHEMA, 2, null, null);

  private static final BigQueryResult BQ_RS_MOCK_RES_MULTI_PAGE =
      new BigQueryResultImpl(QUERY_SCHEMA, 4, null, null);

  private static final JobId QUERY_JOB = JobId.of(PROJECT, JOB).setLocation(LOCATION);
  private static final GetQueryResultsResponse GET_QUERY_RESULTS_RESPONSE =
      new GetQueryResultsResponse()
          .setJobReference(QUERY_JOB.toPb())
          .setRows(ImmutableList.of(TABLE_ROW))
          .setJobComplete(true)
          .setCacheHit(false)
          .setPageToken(PAGE_TOKEN)
          .setTotalBytesProcessed(42L)
          .setTotalRows(BigInteger.valueOf(1L))
          .setSchema(FAST_QUERY_TABLESCHEMA);

  private static final GetQueryResultsResponse GET_QUERY_RESULTS_RESPONSE_NULL_SCHEMA =
      new GetQueryResultsResponse()
          .setJobReference(QUERY_JOB.toPb())
          .setRows(ImmutableList.of(TABLE_ROW))
          .setJobComplete(false)
          .setPageToken(PAGE_TOKEN)
          .setTotalBytesProcessed(42L)
          .setTotalRows(BigInteger.valueOf(1L))
          .setSchema(null);

  private static List<TableRow> TABLE_ROWS =
      ImmutableList.of(
          new TableRow()
              .setF(
                  ImmutableList.of(new TableCell().setV("Value1"), new TableCell().setV("Value2"))),
          new TableRow()
              .setF(
                  ImmutableList.of(
                      new TableCell().setV("Value3"), new TableCell().setV("Value4"))));

  private BigQueryOptions createBigQueryOptionsForProject(
      String project, BigQueryRpcFactory rpcFactory) {
    return BigQueryOptions.newBuilder()
        .setProjectId(project)
        .setServiceRpcFactory(rpcFactory)
        .setRetrySettings(ServiceOptions.getNoRetrySettings())
        .build();
  }

  @Before
  public void setUp() {
    rpcFactoryMock = mock(BigQueryRpcFactory.class);
    bigqueryRpcMock = mock(BigQueryRpc.class);
    connectionMock = mock(Connection.class);
    when(rpcFactoryMock.create(any(BigQueryOptions.class))).thenReturn(bigqueryRpcMock);
    options = createBigQueryOptionsForProject(PROJECT, rpcFactoryMock);
    bigquery = options.getService();

    connectionSettings =
        ConnectionSettings.newBuilder()
            .setDefaultDataset(DatasetId.of(DEFAULT_TEST_DATASET))
            .setNumBufferedRows(DEFAULT_PAGE_SIZE)
            .build();
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    connection = (ConnectionImpl) bigquery.createConnection(connectionSettings);
    assertNotNull(connection);
  }

  @Test
  public void testFastQuerySinglePage() throws BigQuerySQLException {
    com.google.api.services.bigquery.model.QueryResponse mockQueryRes =
        new QueryResponse().setSchema(FAST_QUERY_TABLESCHEMA).setJobComplete(true);
    when(bigqueryRpcMock.queryRpc(any(String.class), any(QueryRequest.class)))
        .thenReturn(mockQueryRes);
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .processQueryResponseResults(any(QueryResponse.class));

    BigQueryResult res = connectionSpy.executeSelect(SQL_QUERY);
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(connectionSpy, times(1))
        .processQueryResponseResults(
            any(com.google.api.services.bigquery.model.QueryResponse.class));
  }

  @Test
  // NOTE: This doesn't truly paginates. Returns a response while mocking
  // processQueryResponseResults
  public void testFastQueryMultiplePages() throws BigQuerySQLException {
    com.google.api.services.bigquery.model.QueryResponse mockQueryRes =
        new QueryResponse()
            .setSchema(FAST_QUERY_TABLESCHEMA)
            .setJobComplete(true)
            .setPageToken(PAGE_TOKEN);
    when(bigqueryRpcMock.queryRpc(any(String.class), any(QueryRequest.class)))
        .thenReturn(mockQueryRes);
    ConnectionImpl connectionSpy = Mockito.spy(connection);

    doReturn(BQ_RS_MOCK_RES_MULTI_PAGE)
        .when(connectionSpy)
        .processQueryResponseResults(
            any(com.google.api.services.bigquery.model.QueryResponse.class));

    BigQueryResult res = connectionSpy.executeSelect(SQL_QUERY);
    assertEquals(res.getTotalRows(), 4);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(connectionSpy, times(1))
        .processQueryResponseResults(
            any(com.google.api.services.bigquery.model.QueryResponse.class));
  }

  @Test
  public void testClose() throws BigQuerySQLException {
    boolean cancelled = connection.close();
    assertTrue(cancelled);
  }

  @Test
  public void testQueryDryRun() throws BigQuerySQLException {
    List<QueryParameter> queryParametersMock =
        ImmutableList.of(
            new QueryParameter().setParameterType(new QueryParameterType().setType("STRING")));
    com.google.api.services.bigquery.model.JobStatistics2 queryMock =
        new com.google.api.services.bigquery.model.JobStatistics2()
            .setSchema(FAST_QUERY_TABLESCHEMA)
            .setUndeclaredQueryParameters(queryParametersMock);
    com.google.api.services.bigquery.model.JobStatistics jobStatsMock =
        new com.google.api.services.bigquery.model.JobStatistics()
            .setCreationTime(1234L)
            .setStartTime(5678L)
            .setQuery(queryMock);
    com.google.api.services.bigquery.model.JobConfigurationQuery jobConfigurationQuery =
        new com.google.api.services.bigquery.model.JobConfigurationQuery();
    com.google.api.services.bigquery.model.JobConfiguration jobConfig =
        new com.google.api.services.bigquery.model.JobConfiguration()
            .setQuery(jobConfigurationQuery);
    com.google.api.services.bigquery.model.Job mockDryRunJob =
        new com.google.api.services.bigquery.model.Job()
            .setStatistics(jobStatsMock)
            .setConfiguration(jobConfig);
    when(bigqueryRpcMock.createJobForQuery(any(com.google.api.services.bigquery.model.Job.class)))
        .thenReturn(mockDryRunJob);
    BigQueryDryRunResult dryRunResult = connection.dryRun(DRY_RUN_SQL);
    assertEquals(1, dryRunResult.getQueryParameters().size());
    assertEquals(QUERY_SCHEMA, dryRunResult.getSchema());
    verify(bigqueryRpcMock, times(1))
        .createJobForQuery(any(com.google.api.services.bigquery.model.Job.class));
  }

  @Test
  public void testParseDataTask() throws InterruptedException {
    BlockingQueue<Tuple<Iterable<FieldValueList>, Boolean>> pageCache =
        new LinkedBlockingDeque<>(2);
    BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue = new LinkedBlockingDeque<>(2);
    rpcResponseQueue.offer(Tuple.of(null, false));
    // This call should populate page cache
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    connectionSpy.parseRpcDataAsync(TABLE_ROWS, QUERY_SCHEMA, pageCache, rpcResponseQueue);
    Tuple<Iterable<FieldValueList>, Boolean> fvlTupple =
        pageCache.take(); // wait for the parser thread to parse the data
    assertNotNull(fvlTupple);
    Iterable<FieldValueList> iterableFvl = fvlTupple.x();
    int rowCnt = 0;
    for (FieldValueList fvl : iterableFvl) {
      assertEquals(2, fvl.size()); // both the rows should have 2 fields each
      rowCnt++;
    }
    assertEquals(2, rowCnt); // row rows read

    verify(connectionSpy, times(1))
        .parseRpcDataAsync(
            any(List.class), any(Schema.class), any(BlockingQueue.class), any(BlockingQueue.class));
  }

  @Test
  public void testPopulateBuffer() throws InterruptedException {

    BlockingQueue<Tuple<Iterable<FieldValueList>, Boolean>> pageCache =
        new LinkedBlockingDeque<>(2);
    BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue = new LinkedBlockingDeque<>(2);
    BlockingQueue<AbstractList<FieldValue>> buffer = new LinkedBlockingDeque<>(5);
    rpcResponseQueue.offer(Tuple.of(null, false));
    // This call should populate page cache
    ConnectionImpl connectionSpy = Mockito.spy(connection);

    connectionSpy.parseRpcDataAsync(TABLE_ROWS, QUERY_SCHEMA, pageCache, rpcResponseQueue);

    verify(connectionSpy, times(1))
        .parseRpcDataAsync(
            any(List.class), any(Schema.class), any(BlockingQueue.class), any(BlockingQueue.class));

    // now pass the pageCache to populateBuffer method
    connectionSpy.populateBufferAsync(rpcResponseQueue, pageCache, buffer);
    // check if buffer was populated with two rows async by using the blocking take method
    AbstractList<FieldValue> fvl1 = buffer.take();
    assertNotNull(fvl1);
    assertEquals(2, fvl1.size());
    assertEquals("Value1", fvl1.get(0).getValue().toString());
    assertEquals("Value2", fvl1.get(1).getValue().toString());
    AbstractList<FieldValue> fvl2 = buffer.take();
    assertNotNull(fvl2);
    assertEquals(2, fvl2.size());
    assertEquals("Value3", fvl2.get(0).getValue().toString());
    assertEquals("Value4", fvl2.get(1).getValue().toString());
    verify(connectionSpy, times(1))
        .populateBufferAsync(
            any(BlockingQueue.class), any(BlockingQueue.class), any(BlockingQueue.class));
  }

  @Test
  public void testNextPageTask() throws InterruptedException {
    BlockingQueue<Tuple<TableDataList, Boolean>> rpcResponseQueue = new LinkedBlockingDeque<>(2);
    TableDataList mockTabledataList =
        new TableDataList()
            .setPageToken(PAGE_TOKEN)
            .setRows(ImmutableList.of(TABLE_ROW))
            .setTotalRows(1L);
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    doReturn(mockTabledataList)
        .when(connectionSpy)
        .tableDataListRpc(any(TableId.class), any(String.class));
    connectionSpy.runNextPageTaskAsync(PAGE_TOKEN, TABLE_NAME, rpcResponseQueue);
    Tuple<TableDataList, Boolean> tableDataListTuple = rpcResponseQueue.take();
    assertNotNull(tableDataListTuple);
    TableDataList tableDataList = tableDataListTuple.x();
    assertNotNull(tableDataList);
    assertEquals("ABCD123", tableDataList.getPageToken());
    assertEquals(Long.valueOf(1), tableDataList.getTotalRows());
    verify(connectionSpy, times(1))
        .runNextPageTaskAsync(any(String.class), any(TableId.class), any(BlockingQueue.class));
  }

  @Test
  public void testGetQueryResultsFirstPage() {
    when(bigqueryRpcMock.getQueryResultsWithRowLimit(
            any(String.class),
            any(String.class),
            any(String.class),
            any(Integer.class),
            any(Long.class)))
        .thenReturn(GET_QUERY_RESULTS_RESPONSE);
    GetQueryResultsResponse response = connection.getQueryResultsFirstPage(QUERY_JOB);
    assertNotNull(response);
    assertEquals(GET_QUERY_RESULTS_RESPONSE, response);
    verify(bigqueryRpcMock, times(1))
        .getQueryResultsWithRowLimit(
            any(String.class),
            any(String.class),
            any(String.class),
            any(Integer.class),
            any(Long.class));
  }

  // calls executeSelect with a nonFast query and exercises createQueryJob
  @Test
  public void testLegacyQuerySinglePage() throws BigQuerySQLException {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    com.google.api.services.bigquery.model.Job jobResponseMock =
        new com.google.api.services.bigquery.model.Job()
            // .setConfiguration(QUERY_JOB.g)
            .setJobReference(QUERY_JOB.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"));
    // emulating a legacy query
    doReturn(false).when(connectionSpy).isFastQuerySupported();
    doReturn(GET_QUERY_RESULTS_RESPONSE)
        .when(connectionSpy)
        .getQueryResultsFirstPage(any(JobId.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .getSubsequentQueryResultsWithJob(
            any(Long.class),
            any(Long.class),
            any(JobId.class),
            any(GetQueryResultsResponse.class),
            any(Boolean.class));
    when(bigqueryRpcMock.createJobForQuery(any(com.google.api.services.bigquery.model.Job.class)))
        .thenReturn(jobResponseMock); // RPC call in createQueryJob
    BigQueryResult res = connectionSpy.executeSelect(SQL_QUERY);
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(bigqueryRpcMock, times(1))
        .createJobForQuery(any(com.google.api.services.bigquery.model.Job.class));
  }

  // exercises getSubsequentQueryResultsWithJob for fast running queries
  @Test
  public void testFastQueryLongRunning() throws SQLException {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    // emulating a fast query
    doReturn(true).when(connectionSpy).isFastQuerySupported();
    doReturn(GET_QUERY_RESULTS_RESPONSE)
        .when(connectionSpy)
        .getQueryResultsFirstPage(any(JobId.class));

    doReturn(TABLE_NAME).when(connectionSpy).getDestinationTable(any(JobId.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .tableDataList(any(GetQueryResultsResponse.class), any(JobId.class));

    com.google.api.services.bigquery.model.QueryResponse mockQueryRes =
        new QueryResponse()
            .setSchema(FAST_QUERY_TABLESCHEMA)
            .setJobComplete(false)
            .setTotalRows(new BigInteger(String.valueOf(4L)))
            .setJobReference(QUERY_JOB.toPb())
            .setRows(TABLE_ROWS);
    when(bigqueryRpcMock.queryRpc(any(String.class), any(QueryRequest.class)))
        .thenReturn(mockQueryRes);
    BigQueryResult res = connectionSpy.executeSelect(SQL_QUERY);
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(bigqueryRpcMock, times(1)).queryRpc(any(String.class), any(QueryRequest.class));
  }

  @Test
  public void testFastQueryLongRunningAsync()
      throws SQLException, ExecutionException, InterruptedException {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    // emulating a fast query
    doReturn(true).when(connectionSpy).isFastQuerySupported();
    doReturn(GET_QUERY_RESULTS_RESPONSE)
        .when(connectionSpy)
        .getQueryResultsFirstPage(any(JobId.class));

    doReturn(TABLE_NAME).when(connectionSpy).getDestinationTable(any(JobId.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .tableDataList(any(GetQueryResultsResponse.class), any(JobId.class));

    com.google.api.services.bigquery.model.QueryResponse mockQueryRes =
        new QueryResponse()
            .setSchema(FAST_QUERY_TABLESCHEMA)
            .setJobComplete(false)
            .setTotalRows(new BigInteger(String.valueOf(4L)))
            .setJobReference(QUERY_JOB.toPb())
            .setRows(TABLE_ROWS);
    when(bigqueryRpcMock.queryRpc(any(String.class), any(QueryRequest.class)))
        .thenReturn(mockQueryRes);
    ListenableFuture<ExecuteSelectResponse> executeSelectFut =
        connectionSpy.executeSelectAsync(SQL_QUERY);
    ExecuteSelectResponse exSelRes = executeSelectFut.get();
    BigQueryResult res = exSelRes.getResultSet();
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    assertTrue(exSelRes.getIsSuccessful());
    verify(bigqueryRpcMock, times(1)).queryRpc(any(String.class), any(QueryRequest.class));
  }

  @Test
  public void testFastQuerySinglePageAsync()
      throws BigQuerySQLException, ExecutionException, InterruptedException {
    com.google.api.services.bigquery.model.QueryResponse mockQueryRes =
        new QueryResponse().setSchema(FAST_QUERY_TABLESCHEMA).setJobComplete(true);
    when(bigqueryRpcMock.queryRpc(any(String.class), any(QueryRequest.class)))
        .thenReturn(mockQueryRes);
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .processQueryResponseResults(any(QueryResponse.class));

    ListenableFuture<ExecuteSelectResponse> executeSelectFut =
        connectionSpy.executeSelectAsync(SQL_QUERY);
    ExecuteSelectResponse exSelRes = executeSelectFut.get();
    BigQueryResult res = exSelRes.getResultSet();
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    assertTrue(exSelRes.getIsSuccessful());
    verify(connectionSpy, times(1))
        .processQueryResponseResults(
            any(com.google.api.services.bigquery.model.QueryResponse.class));
  }

  @Test
  public void testExecuteSelectSlowWithParamsAsync()
      throws BigQuerySQLException, ExecutionException, InterruptedException {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    List<Parameter> parameters = new ArrayList<>();
    Map<String, String> labels = new HashMap<>();
    doReturn(false).when(connectionSpy).isFastQuerySupported();
    com.google.api.services.bigquery.model.JobStatistics jobStatistics =
        new com.google.api.services.bigquery.model.JobStatistics();
    com.google.api.services.bigquery.model.Job jobResponseMock =
        new com.google.api.services.bigquery.model.Job()
            .setJobReference(QUERY_JOB.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"))
            .setStatistics(jobStatistics);

    doReturn(jobResponseMock)
        .when(connectionSpy)
        .createQueryJob(SQL_QUERY, connectionSettings, parameters, labels);
    doReturn(GET_QUERY_RESULTS_RESPONSE)
        .when(connectionSpy)
        .getQueryResultsFirstPage(any(JobId.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .getResultSet(
            any(GetQueryResultsResponse.class),
            any(JobId.class),
            any(String.class),
            any(Boolean.class));
    ListenableFuture<ExecuteSelectResponse> executeSelectFut =
        connectionSpy.executeSelectAsync(SQL_QUERY, parameters, labels);
    ExecuteSelectResponse exSelRes = executeSelectFut.get();
    BigQueryResult res = exSelRes.getResultSet();
    assertTrue(exSelRes.getIsSuccessful());
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(connectionSpy, times(1))
        .getResultSet(
            any(GetQueryResultsResponse.class),
            any(JobId.class),
            any(String.class),
            any(Boolean.class));
  }

  @Test
  public void testFastQueryMultiplePagesAsync()
      throws BigQuerySQLException, ExecutionException, InterruptedException {
    com.google.api.services.bigquery.model.QueryResponse mockQueryRes =
        new QueryResponse()
            .setSchema(FAST_QUERY_TABLESCHEMA)
            .setJobComplete(true)
            .setPageToken(PAGE_TOKEN);
    when(bigqueryRpcMock.queryRpc(any(String.class), any(QueryRequest.class)))
        .thenReturn(mockQueryRes);
    ConnectionImpl connectionSpy = Mockito.spy(connection);

    doReturn(BQ_RS_MOCK_RES_MULTI_PAGE)
        .when(connectionSpy)
        .processQueryResponseResults(
            any(com.google.api.services.bigquery.model.QueryResponse.class));

    ListenableFuture<ExecuteSelectResponse> executeSelectFut =
        connectionSpy.executeSelectAsync(SQL_QUERY);
    ExecuteSelectResponse exSelRes = executeSelectFut.get();
    BigQueryResult res = exSelRes.getResultSet();
    assertTrue(exSelRes.getIsSuccessful());
    assertEquals(res.getTotalRows(), 4);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(connectionSpy, times(1))
        .processQueryResponseResults(
            any(com.google.api.services.bigquery.model.QueryResponse.class));
  }

  @Test
  // Emulates first page response using getQueryResultsFirstPage(jobId) and then subsequent pages
  // using getQueryResultsFirstPage(jobId) getSubsequentQueryResultsWithJob(
  public void testLegacyQueryMultiplePages() throws SQLException {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    com.google.api.services.bigquery.model.JobStatistics jobStatistics =
        new com.google.api.services.bigquery.model.JobStatistics();
    // emulating a Legacy query
    doReturn(false).when(connectionSpy).isFastQuerySupported();
    doReturn(GET_QUERY_RESULTS_RESPONSE)
        .when(connectionSpy)
        .getQueryResultsFirstPage(any(JobId.class));
    doReturn(TABLE_NAME).when(connectionSpy).getDestinationTable(any(JobId.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .tableDataList(any(GetQueryResultsResponse.class), any(JobId.class));
    com.google.api.services.bigquery.model.Job jobResponseMock =
        new com.google.api.services.bigquery.model.Job()
            .setJobReference(QUERY_JOB.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"))
            .setStatistics(jobStatistics);
    when(bigqueryRpcMock.createJobForQuery(any(com.google.api.services.bigquery.model.Job.class)))
        .thenReturn(jobResponseMock); // RPC call in createQueryJob
    BigQueryResult res = connectionSpy.executeSelect(SQL_QUERY);
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(bigqueryRpcMock, times(1))
        .createJobForQuery(any(com.google.api.services.bigquery.model.Job.class));
    verify(connectionSpy, times(1))
        .tableDataList(any(GetQueryResultsResponse.class), any(JobId.class));
  }

  @Test
  public void testExecuteSelectSlow() throws BigQuerySQLException {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    doReturn(false).when(connectionSpy).isFastQuerySupported();
    com.google.api.services.bigquery.model.JobStatistics jobStatistics =
        new com.google.api.services.bigquery.model.JobStatistics();
    com.google.api.services.bigquery.model.Job jobResponseMock =
        new com.google.api.services.bigquery.model.Job()
            .setJobReference(QUERY_JOB.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"))
            .setStatistics(jobStatistics);

    doReturn(jobResponseMock)
        .when(connectionSpy)
        .createQueryJob(SQL_QUERY, connectionSettings, null, null);
    doReturn(GET_QUERY_RESULTS_RESPONSE)
        .when(connectionSpy)
        .getQueryResultsFirstPage(any(JobId.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .getResultSet(
            any(GetQueryResultsResponse.class),
            any(JobId.class),
            any(String.class),
            any(Boolean.class));
    BigQueryResult res = connectionSpy.executeSelect(SQL_QUERY);
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(connectionSpy, times(1))
        .getResultSet(
            any(GetQueryResultsResponse.class),
            any(JobId.class),
            any(String.class),
            any(Boolean.class));
  }

  @Test
  public void testExecuteSelectSlowWithParams() throws BigQuerySQLException {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    List<Parameter> parameters = new ArrayList<>();
    Map<String, String> labels = new HashMap<>();
    doReturn(false).when(connectionSpy).isFastQuerySupported();
    com.google.api.services.bigquery.model.JobStatistics jobStatistics =
        new com.google.api.services.bigquery.model.JobStatistics();
    com.google.api.services.bigquery.model.Job jobResponseMock =
        new com.google.api.services.bigquery.model.Job()
            .setJobReference(QUERY_JOB.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"))
            .setStatistics(jobStatistics);

    doReturn(jobResponseMock)
        .when(connectionSpy)
        .createQueryJob(SQL_QUERY, connectionSettings, parameters, labels);
    doReturn(GET_QUERY_RESULTS_RESPONSE)
        .when(connectionSpy)
        .getQueryResultsFirstPage(any(JobId.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .getResultSet(
            any(GetQueryResultsResponse.class),
            any(JobId.class),
            any(String.class),
            any(Boolean.class));
    BigQueryResult res = connectionSpy.executeSelect(SQL_QUERY, parameters, labels);
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(connectionSpy, times(1))
        .getResultSet(
            any(GetQueryResultsResponse.class),
            any(JobId.class),
            any(String.class),
            any(Boolean.class));
  }

  @Test
  public void testGetSubsequentQueryResultsWithJob() {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    JobId jobId = mock(JobId.class);
    BigQueryResultStats bqRsStats = mock(BigQueryResultStats.class);
    doReturn(true)
        .when(connectionSpy)
        .useReadAPI(any(Long.class), any(Long.class), any(Schema.class), any(Boolean.class));
    doReturn(BQ_RS_MOCK_RES)
        .when(connectionSpy)
        .highThroughPutRead(
            any(TableId.class), any(Long.class), any(Schema.class), any(BigQueryResultStats.class));

    doReturn(TABLE_NAME).when(connectionSpy).getDestinationTable(any(JobId.class));
    doReturn(bqRsStats).when(connectionSpy).getBigQueryResultSetStats(any(JobId.class));
    BigQueryResult res =
        connectionSpy.getSubsequentQueryResultsWithJob(
            10000L, 100L, jobId, GET_QUERY_RESULTS_RESPONSE, false);
    assertEquals(res.getTotalRows(), 2);
    assertEquals(QUERY_SCHEMA, res.getSchema());
    verify(connectionSpy, times(1))
        .getSubsequentQueryResultsWithJob(10000L, 100L, jobId, GET_QUERY_RESULTS_RESPONSE, false);
  }

  @Test
  public void testGetPageCacheSize() {
    ConnectionImpl connectionSpy = Mockito.spy(connection);
    // number of cached pages should be within a range
    assertTrue(connectionSpy.getPageCacheSize(10000, QUERY_SCHEMA) >= 3);
    assertTrue(connectionSpy.getPageCacheSize(100000000, QUERY_SCHEMA) <= 20);
    verify(connectionSpy, times(2)).getPageCacheSize(any(Integer.class), any(Schema.class));
  }
}

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

import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.eq;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.api.services.bigquery.model.ErrorProto;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableRow;
import com.google.cloud.ServiceOptions;
import com.google.cloud.Tuple;
import com.google.cloud.WriteChannel;
import com.google.cloud.bigquery.BigQuery.QueryResultsOption;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BigQueryImplTest {

  private static final String PROJECT = "project";
  private static final String OTHER_PROJECT = "otherProject";
  private static final String DATASET = "dataset";
  private static final String TABLE = "table";
  private static final String JOB = "job";
  private static final String OTHER_TABLE = "otherTable";
  private static final String OTHER_DATASET = "otherDataset";
  private static final List<Acl> ACCESS_RULES =
      ImmutableList.of(
          Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
          Acl.of(new Acl.View(TableId.of("dataset", "table")), Acl.Role.WRITER));
  private static final List<Acl> ACCESS_RULES_WITH_PROJECT =
      ImmutableList.of(
          Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
          Acl.of(new Acl.View(TableId.of(PROJECT, "dataset", "table"))));
  private static final DatasetInfo DATASET_INFO =
      DatasetInfo.newBuilder(DATASET).setAcl(ACCESS_RULES).setDescription("description").build();
  private static final DatasetInfo DATASET_INFO_WITH_PROJECT =
      DatasetInfo.newBuilder(PROJECT, DATASET)
          .setAcl(ACCESS_RULES_WITH_PROJECT)
          .setDescription("description")
          .build();
  private static final DatasetInfo OTHER_DATASET_INFO =
      DatasetInfo.newBuilder(PROJECT, OTHER_DATASET)
          .setAcl(ACCESS_RULES)
          .setDescription("other description")
          .build();
  private static final TableId TABLE_ID = TableId.of(DATASET, TABLE);
  private static final TableId OTHER_TABLE_ID = TableId.of(PROJECT, DATASET, OTHER_TABLE);
  private static final TableId TABLE_ID_WITH_PROJECT = TableId.of(PROJECT, DATASET, TABLE);
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", Field.Type.string())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", Field.Type.integer())
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final StandardTableDefinition TABLE_DEFINITION =
      StandardTableDefinition.of(TABLE_SCHEMA);
  private static final TableInfo TABLE_INFO = TableInfo.of(TABLE_ID, TABLE_DEFINITION);
  private static final TableInfo OTHER_TABLE_INFO = TableInfo.of(OTHER_TABLE_ID, TABLE_DEFINITION);
  private static final TableInfo TABLE_INFO_WITH_PROJECT =
      TableInfo.of(TABLE_ID_WITH_PROJECT, TABLE_DEFINITION);
  private static final LoadJobConfiguration LOAD_JOB_CONFIGURATION =
      LoadJobConfiguration.of(TABLE_ID, "URI");
  private static final LoadJobConfiguration LOAD_JOB_CONFIGURATION_WITH_PROJECT =
      LoadJobConfiguration.of(TABLE_ID_WITH_PROJECT, "URI");
  private static final JobInfo LOAD_JOB = JobInfo.of(LOAD_JOB_CONFIGURATION);
  private static final JobInfo COMPLETE_LOAD_JOB =
      JobInfo.of(JobId.of(PROJECT, JOB), LOAD_JOB_CONFIGURATION_WITH_PROJECT);
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID, ImmutableList.of(TABLE_ID, TABLE_ID));
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION_WITH_PROJECT =
      CopyJobConfiguration.of(
          TABLE_ID_WITH_PROJECT, ImmutableList.of(TABLE_ID_WITH_PROJECT, TABLE_ID_WITH_PROJECT));
  private static final JobInfo COPY_JOB = JobInfo.of(COPY_JOB_CONFIGURATION);
  private static final JobInfo COMPLETE_COPY_JOB =
      JobInfo.of(JobId.of(PROJECT, JOB), COPY_JOB_CONFIGURATION_WITH_PROJECT);
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION =
      QueryJobConfiguration.newBuilder("SQL")
          .setDefaultDataset(DatasetId.of(DATASET))
          .setDestinationTable(TABLE_ID)
          .build();
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_WITH_PROJECT =
      QueryJobConfiguration.newBuilder("SQL")
          .setDefaultDataset(DatasetId.of(PROJECT, DATASET))
          .setDestinationTable(TABLE_ID_WITH_PROJECT)
          .build();
  private static final JobInfo QUERY_JOB = JobInfo.of(QUERY_JOB_CONFIGURATION);
  private static final JobInfo COMPLETE_QUERY_JOB =
      JobInfo.of(JobId.of(PROJECT, JOB), QUERY_JOB_CONFIGURATION_WITH_PROJECT);
  private static final ExtractJobConfiguration EXTRACT_JOB_CONFIGURATION =
      ExtractJobConfiguration.of(TABLE_ID, "URI");
  private static final ExtractJobConfiguration EXTRACT_JOB_CONFIGURATION_WITH_PROJECT =
      ExtractJobConfiguration.of(TABLE_ID_WITH_PROJECT, "URI");
  private static final JobInfo EXTRACT_JOB = JobInfo.of(EXTRACT_JOB_CONFIGURATION);
  private static final JobInfo COMPLETE_EXTRACT_JOB =
      JobInfo.of(JobId.of(PROJECT, JOB), EXTRACT_JOB_CONFIGURATION_WITH_PROJECT);
  private static final TableCell BOOLEAN_FIELD = new TableCell().setV("false");
  private static final TableCell INTEGER_FIELD = new TableCell().setV("1");
  private static final TableRow TABLE_ROW =
      new TableRow().setF(ImmutableList.of(BOOLEAN_FIELD, INTEGER_FIELD));
  private static final QueryRequest QUERY_REQUEST =
      QueryRequest.newBuilder("SQL")
          .setPageSize(42L)
          .setUseQueryCache(false)
          .setDefaultDataset(DatasetId.of(DATASET))
          .build();
  private static final QueryRequest QUERY_REQUEST_WITH_PROJECT =
      QueryRequest.newBuilder("SQL")
          .setPageSize(42L)
          .setUseQueryCache(false)
          .setDefaultDataset(DatasetId.of(PROJECT, DATASET))
          .build();
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_FOR_QUERY =
      QueryJobConfiguration.newBuilder("SQL")
          .setDefaultDataset(DatasetId.of(DATASET))
          .setUseQueryCache(false)
          .build();
  private static final JobInfo JOB_INFO =
      JobInfo.newBuilder(QUERY_JOB_CONFIGURATION_FOR_QUERY)
          .setJobId(JobId.of(PROJECT, JOB))
          .build();
  private static final String CURSOR = "cursor";
  private static final TableCell CELL_PB1 = new TableCell().setV("Value1");
  private static final TableCell CELL_PB2 = new TableCell().setV("Value2");
  private static final ImmutableList<List<FieldValue>> TABLE_DATA =
      ImmutableList.of(
          (List<FieldValue>) ImmutableList.of(FieldValue.fromPb(CELL_PB1)),
          ImmutableList.of(FieldValue.fromPb(CELL_PB2)));
  private static final Tuple<String, Iterable<TableRow>> TABLE_DATA_PB =
      Tuple.<String, Iterable<TableRow>>of(
          CURSOR,
          ImmutableList.of(
              new TableRow().setF(ImmutableList.of(new TableCell().setV("Value1"))),
              new TableRow().setF(ImmutableList.of(new TableCell().setV("Value2")))));

  // Empty BigQueryRpc options
  private static final Map<BigQueryRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // Dataset options
  private static final BigQuery.DatasetOption DATASET_OPTION_FIELDS =
      BigQuery.DatasetOption.fields(BigQuery.DatasetField.ACCESS, BigQuery.DatasetField.ETAG);

  // Dataset list options
  private static final BigQuery.DatasetListOption DATASET_LIST_ALL =
      BigQuery.DatasetListOption.all();
  private static final BigQuery.DatasetListOption DATASET_LIST_PAGE_TOKEN =
      BigQuery.DatasetListOption.pageToken(CURSOR);
  private static final BigQuery.DatasetListOption DATASET_LIST_PAGE_SIZE =
      BigQuery.DatasetListOption.pageSize(42L);
  private static final Map<BigQueryRpc.Option, ?> DATASET_LIST_OPTIONS =
      ImmutableMap.of(
          BigQueryRpc.Option.ALL_DATASETS,
          true,
          BigQueryRpc.Option.PAGE_TOKEN,
          CURSOR,
          BigQueryRpc.Option.MAX_RESULTS,
          42L);

  // Dataset delete options
  private static final BigQuery.DatasetDeleteOption DATASET_DELETE_CONTENTS =
      BigQuery.DatasetDeleteOption.deleteContents();
  private static final Map<BigQueryRpc.Option, ?> DATASET_DELETE_OPTIONS =
      ImmutableMap.of(BigQueryRpc.Option.DELETE_CONTENTS, true);

  // Table options
  private static final BigQuery.TableOption TABLE_OPTION_FIELDS =
      BigQuery.TableOption.fields(BigQuery.TableField.SCHEMA, BigQuery.TableField.ETAG);

  // Table list options
  private static final BigQuery.TableListOption TABLE_LIST_PAGE_SIZE =
      BigQuery.TableListOption.pageSize(42L);
  private static final BigQuery.TableListOption TABLE_LIST_PAGE_TOKEN =
      BigQuery.TableListOption.pageToken(CURSOR);
  private static final Map<BigQueryRpc.Option, ?> TABLE_LIST_OPTIONS =
      ImmutableMap.of(BigQueryRpc.Option.MAX_RESULTS, 42L, BigQueryRpc.Option.PAGE_TOKEN, CURSOR);

  // TableData list options
  private static final BigQuery.TableDataListOption TABLE_DATA_LIST_PAGE_SIZE =
      BigQuery.TableDataListOption.pageSize(42L);
  private static final BigQuery.TableDataListOption TABLE_DATA_LIST_PAGE_TOKEN =
      BigQuery.TableDataListOption.pageToken(CURSOR);
  private static final BigQuery.TableDataListOption TABLE_DATA_LIST_START_INDEX =
      BigQuery.TableDataListOption.startIndex(0L);
  private static final Map<BigQueryRpc.Option, ?> TABLE_DATA_LIST_OPTIONS =
      ImmutableMap.of(
          BigQueryRpc.Option.MAX_RESULTS, 42L,
          BigQueryRpc.Option.PAGE_TOKEN, CURSOR,
          BigQueryRpc.Option.START_INDEX, 0L);

  // Job options
  private static final BigQuery.JobOption JOB_OPTION_FIELDS =
      BigQuery.JobOption.fields(BigQuery.JobField.USER_EMAIL);

  // Job list options
  private static final BigQuery.JobListOption JOB_LIST_OPTION_FIELD =
      BigQuery.JobListOption.fields(BigQuery.JobField.STATISTICS);
  private static final BigQuery.JobListOption JOB_LIST_ALL_USERS =
      BigQuery.JobListOption.allUsers();
  private static final BigQuery.JobListOption JOB_LIST_STATE_FILTER =
      BigQuery.JobListOption.stateFilter(JobStatus.State.DONE, JobStatus.State.PENDING);
  private static final BigQuery.JobListOption JOB_LIST_PAGE_TOKEN =
      BigQuery.JobListOption.pageToken(CURSOR);
  private static final BigQuery.JobListOption JOB_LIST_PAGE_SIZE =
      BigQuery.JobListOption.pageSize(42L);
  private static final Map<BigQueryRpc.Option, ?> JOB_LIST_OPTIONS =
      ImmutableMap.of(
          BigQueryRpc.Option.ALL_USERS,
          true,
          BigQueryRpc.Option.STATE_FILTER,
          ImmutableList.of("done", "pending"),
          BigQueryRpc.Option.PAGE_TOKEN,
          CURSOR,
          BigQueryRpc.Option.MAX_RESULTS,
          42L);

  // Query Results options
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_TIME =
      BigQuery.QueryResultsOption.maxWaitTime(42L);
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_INDEX =
      BigQuery.QueryResultsOption.startIndex(1024L);
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_PAGE_TOKEN =
      BigQuery.QueryResultsOption.pageToken(CURSOR);
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_PAGE_SIZE =
      BigQuery.QueryResultsOption.pageSize(0L);
  private static final Map<BigQueryRpc.Option, ?> QUERY_RESULTS_OPTIONS =
      ImmutableMap.of(
          BigQueryRpc.Option.TIMEOUT, 42L,
          BigQueryRpc.Option.START_INDEX, 1024L,
          BigQueryRpc.Option.PAGE_TOKEN, CURSOR,
          BigQueryRpc.Option.MAX_RESULTS, 0L);

  private BigQueryOptions options;
  private BigQueryRpcFactory rpcFactoryMock;
  private BigQueryRpc bigqueryRpcMock;
  private BigQuery bigquery;

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createMock(BigQueryRpcFactory.class);
    bigqueryRpcMock = EasyMock.createMock(BigQueryRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(BigQueryOptions.class)))
        .andReturn(bigqueryRpcMock);
    EasyMock.replay(rpcFactoryMock);
    options =
        BigQueryOptions.newBuilder()
            .setProjectId(PROJECT)
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, bigqueryRpcMock);
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertSame(options, bigquery.getOptions());
  }

  @Test
  public void testCreateDataset() {
    DatasetInfo datasetInfo = DATASET_INFO.setProjectId(OTHER_PROJECT);
    EasyMock.expect(bigqueryRpcMock.create(datasetInfo.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(datasetInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.create(datasetInfo);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(datasetInfo)), dataset);
  }

  @Test
  public void testCreateDatasetWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            bigqueryRpcMock.create(eq(DATASET_INFO_WITH_PROJECT.toPb()), capture(capturedOptions)))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.create(DATASET_INFO, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
  }

  @Test
  public void testGetDataset() {
    EasyMock.expect(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
  }

  @Test
  public void testGetDatasetFromDatasetId() {
    EasyMock.expect(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(DatasetId.of(DATASET));
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
  }

  @Test
  public void testGetDatasetFromDatasetIdWithProject() {
    DatasetInfo datasetInfo = DATASET_INFO.setProjectId(OTHER_PROJECT);
    DatasetId datasetId = DatasetId.of(OTHER_PROJECT, DATASET);
    EasyMock.expect(bigqueryRpcMock.getDataset(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(datasetInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(datasetId);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(datasetInfo)), dataset);
  }

  @Test
  public void testGetDatasetWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(bigqueryRpcMock.getDataset(eq(PROJECT), eq(DATASET), capture(capturedOptions)))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(DATASET, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
  }

  @Test
  public void testListDatasets() {
    bigquery = options.getService();
    ImmutableList<Dataset> datasetList =
        ImmutableList.of(
            new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
            new Dataset(bigquery, new DatasetInfo.BuilderImpl(OTHER_DATASET_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.of(CURSOR, Iterables.transform(datasetList, DatasetInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listDatasets(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Dataset> page = bigquery.listDatasets();
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(
        datasetList.toArray(), Iterables.toArray(page.getValues(), DatasetInfo.class));
  }

  @Test
  public void testListDatasetsWithProjects() {
    bigquery = options.getService();
    ImmutableList<Dataset> datasetList =
        ImmutableList.of(
            new Dataset(
                bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO.setProjectId(OTHER_PROJECT))));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.of(CURSOR, Iterables.transform(datasetList, DatasetInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listDatasets(OTHER_PROJECT, EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Dataset> page = bigquery.listDatasets(OTHER_PROJECT);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(
        datasetList.toArray(), Iterables.toArray(page.getValues(), DatasetInfo.class));
  }

  @Test
  public void testListEmptyDatasets() {
    ImmutableList<com.google.api.services.bigquery.model.Dataset> datasets = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.<String, Iterable<com.google.api.services.bigquery.model.Dataset>>of(null, datasets);
    EasyMock.expect(bigqueryRpcMock.listDatasets(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Page<Dataset> page = bigquery.listDatasets();
    assertNull(page.getNextPageToken());
    assertArrayEquals(
        ImmutableList.of().toArray(), Iterables.toArray(page.getValues(), Dataset.class));
  }

  @Test
  public void testListDatasetsWithOptions() {
    bigquery = options.getService();
    ImmutableList<Dataset> datasetList =
        ImmutableList.of(
            new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
            new Dataset(bigquery, new DatasetInfo.BuilderImpl(OTHER_DATASET_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.of(CURSOR, Iterables.transform(datasetList, DatasetInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listDatasets(PROJECT, DATASET_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Dataset> page =
        bigquery.listDatasets(DATASET_LIST_ALL, DATASET_LIST_PAGE_TOKEN, DATASET_LIST_PAGE_SIZE);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(
        datasetList.toArray(), Iterables.toArray(page.getValues(), DatasetInfo.class));
  }

  @Test
  public void testDeleteDataset() {
    EasyMock.expect(bigqueryRpcMock.deleteDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.delete(DATASET));
  }

  @Test
  public void testDeleteDatasetFromDatasetId() {
    EasyMock.expect(bigqueryRpcMock.deleteDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.delete(DatasetId.of(DATASET)));
  }

  @Test
  public void testDeleteDatasetFromDatasetIdWithProject() {
    DatasetId datasetId = DatasetId.of(OTHER_PROJECT, DATASET);
    EasyMock.expect(bigqueryRpcMock.deleteDataset(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.delete(datasetId));
  }

  @Test
  public void testDeleteDatasetWithOptions() {
    EasyMock.expect(bigqueryRpcMock.deleteDataset(PROJECT, DATASET, DATASET_DELETE_OPTIONS))
        .andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.delete(DATASET, DATASET_DELETE_CONTENTS));
  }

  @Test
  public void testUpdateDataset() {
    DatasetInfo updatedDatasetInfo =
        DATASET_INFO
            .setProjectId(OTHER_PROJECT)
            .toBuilder()
            .setDescription("newDescription")
            .build();
    EasyMock.expect(bigqueryRpcMock.patch(updatedDatasetInfo.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(updatedDatasetInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.update(updatedDatasetInfo);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedDatasetInfo)), dataset);
  }

  @Test
  public void testUpdateDatasetWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    DatasetInfo updatedDatasetInfo =
        DATASET_INFO.toBuilder().setDescription("newDescription").build();
    DatasetInfo updatedDatasetInfoWithProject =
        DATASET_INFO_WITH_PROJECT.toBuilder().setDescription("newDescription").build();
    EasyMock.expect(
            bigqueryRpcMock.patch(
                eq(updatedDatasetInfoWithProject.toPb()), capture(capturedOptions)))
        .andReturn(updatedDatasetInfoWithProject.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Dataset dataset = bigquery.update(updatedDatasetInfo, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedDatasetInfoWithProject)), dataset);
  }

  @Test
  public void testCreateTable() {
    TableInfo tableInfo = TABLE_INFO.setProjectId(OTHER_PROJECT);
    EasyMock.expect(bigqueryRpcMock.create(tableInfo.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(tableInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.create(tableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(tableInfo)), table);
  }

  @Test
  public void testCreateTableWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            bigqueryRpcMock.create(eq(TABLE_INFO_WITH_PROJECT.toPb()), capture(capturedOptions)))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.create(TABLE_INFO, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testGetTable() {
    EasyMock.expect(bigqueryRpcMock.getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.getTable(DATASET, TABLE);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testGetTableFromTableId() {
    EasyMock.expect(bigqueryRpcMock.getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.getTable(TABLE_ID);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testGetTableFromTableIdWithProject() {
    TableInfo tableInfo = TABLE_INFO.setProjectId(OTHER_PROJECT);
    TableId tableId = TABLE_ID.setProjectId(OTHER_PROJECT);
    EasyMock.expect(bigqueryRpcMock.getTable(OTHER_PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(tableInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.getTable(tableId);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(tableInfo)), table);
  }

  @Test
  public void testGetTableWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            bigqueryRpcMock.getTable(eq(PROJECT), eq(DATASET), eq(TABLE), capture(capturedOptions)))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.getTable(TABLE_ID, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testListTables() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)),
            new Table(bigquery, new TableInfo.BuilderImpl(OTHER_TABLE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listTables(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Table> page = bigquery.listTables(DATASET);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
  }

  @Test
  public void testListTablesFromDatasetId() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)),
            new Table(bigquery, new TableInfo.BuilderImpl(OTHER_TABLE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listTables(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Table> page = bigquery.listTables(DatasetId.of(DATASET));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
  }

  @Test
  public void testListTablesFromDatasetIdWithProject() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO.setProjectId(OTHER_PROJECT))));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listTables(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Table> page = bigquery.listTables(DatasetId.of(OTHER_PROJECT, DATASET));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
  }

  @Test
  public void testListTablesWithOptions() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)),
            new Table(bigquery, new TableInfo.BuilderImpl(OTHER_TABLE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Table> page = bigquery.listTables(DATASET, TABLE_LIST_PAGE_SIZE, TABLE_LIST_PAGE_TOKEN);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
  }

  @Test
  public void testDeleteTable() {
    EasyMock.expect(bigqueryRpcMock.deleteTable(PROJECT, DATASET, TABLE)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.delete(DATASET, TABLE));
  }

  @Test
  public void testDeleteTableFromTableId() {
    EasyMock.expect(bigqueryRpcMock.deleteTable(PROJECT, DATASET, TABLE)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.delete(TABLE_ID));
  }

  @Test
  public void testDeleteTableFromTableIdWithProject() {
    TableId tableId = TABLE_ID.setProjectId(OTHER_PROJECT);
    EasyMock.expect(bigqueryRpcMock.deleteTable(OTHER_PROJECT, DATASET, TABLE)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.delete(tableId));
  }

  @Test
  public void testUpdateTable() {
    TableInfo updatedTableInfo =
        TABLE_INFO.setProjectId(OTHER_PROJECT).toBuilder().setDescription("newDescription").build();
    EasyMock.expect(bigqueryRpcMock.patch(updatedTableInfo.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(updatedTableInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.update(updatedTableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(updatedTableInfo)), table);
  }

  @Test
  public void testUpdateTableWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    TableInfo updatedTableInfo = TABLE_INFO.toBuilder().setDescription("newDescription").build();
    TableInfo updatedTableInfoWithProject =
        TABLE_INFO_WITH_PROJECT.toBuilder().setDescription("newDescription").build();
    EasyMock.expect(
            bigqueryRpcMock.patch(eq(updatedTableInfoWithProject.toPb()), capture(capturedOptions)))
        .andReturn(updatedTableInfoWithProject.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Table table = bigquery.update(updatedTableInfo, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(
        new Table(bigquery, new TableInfo.BuilderImpl(updatedTableInfoWithProject)), table);
  }

  @Test
  public void testInsertAll() {
    Map<String, Object> row1 = ImmutableMap.<String, Object>of("field", "value1");
    Map<String, Object> row2 = ImmutableMap.<String, Object>of("field", "value2");
    List<RowToInsert> rows =
        ImmutableList.of(new RowToInsert("row1", row1), new RowToInsert("row2", row2));
    InsertAllRequest request =
        InsertAllRequest.newBuilder(TABLE_ID)
            .setRows(rows)
            .setSkipInvalidRows(false)
            .setIgnoreUnknownValues(true)
            .setTemplateSuffix("suffix")
            .build();
    TableDataInsertAllRequest requestPb =
        new TableDataInsertAllRequest()
            .setRows(
                Lists.transform(
                    rows,
                    new Function<RowToInsert, TableDataInsertAllRequest.Rows>() {
                      @Override
                      public TableDataInsertAllRequest.Rows apply(RowToInsert rowToInsert) {
                        return new TableDataInsertAllRequest.Rows()
                            .setInsertId(rowToInsert.getId())
                            .setJson(rowToInsert.getContent());
                      }
                    }))
            .setSkipInvalidRows(false)
            .setIgnoreUnknownValues(true)
            .setTemplateSuffix("suffix");
    TableDataInsertAllResponse responsePb =
        new TableDataInsertAllResponse()
            .setInsertErrors(
                ImmutableList.of(
                    new TableDataInsertAllResponse.InsertErrors()
                        .setIndex(0L)
                        .setErrors(ImmutableList.of(new ErrorProto().setMessage("ErrorMessage")))));
    EasyMock.expect(bigqueryRpcMock.insertAll(PROJECT, DATASET, TABLE, requestPb))
        .andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    InsertAllResponse response = bigquery.insertAll(request);
    assertNotNull(response.getErrorsFor(0L));
    assertNull(response.getErrorsFor(1L));
    assertEquals(1, response.getErrorsFor(0L).size());
    assertEquals("ErrorMessage", response.getErrorsFor(0L).get(0).getMessage());
  }

  @Test
  public void testInsertAllWithProject() {
    Map<String, Object> row1 = ImmutableMap.<String, Object>of("field", "value1");
    Map<String, Object> row2 = ImmutableMap.<String, Object>of("field", "value2");
    List<RowToInsert> rows =
        ImmutableList.of(new RowToInsert("row1", row1), new RowToInsert("row2", row2));
    TableId tableId = TableId.of(OTHER_PROJECT, DATASET, TABLE);
    InsertAllRequest request =
        InsertAllRequest.newBuilder(tableId)
            .setRows(rows)
            .setSkipInvalidRows(false)
            .setIgnoreUnknownValues(true)
            .setTemplateSuffix("suffix")
            .build();
    TableDataInsertAllRequest requestPb =
        new TableDataInsertAllRequest()
            .setRows(
                Lists.transform(
                    rows,
                    new Function<RowToInsert, TableDataInsertAllRequest.Rows>() {
                      @Override
                      public TableDataInsertAllRequest.Rows apply(RowToInsert rowToInsert) {
                        return new TableDataInsertAllRequest.Rows()
                            .setInsertId(rowToInsert.getId())
                            .setJson(rowToInsert.getContent());
                      }
                    }))
            .setSkipInvalidRows(false)
            .setIgnoreUnknownValues(true)
            .setTemplateSuffix("suffix");
    TableDataInsertAllResponse responsePb =
        new TableDataInsertAllResponse()
            .setInsertErrors(
                ImmutableList.of(
                    new TableDataInsertAllResponse.InsertErrors()
                        .setIndex(0L)
                        .setErrors(ImmutableList.of(new ErrorProto().setMessage("ErrorMessage")))));
    EasyMock.expect(bigqueryRpcMock.insertAll(OTHER_PROJECT, DATASET, TABLE, requestPb))
        .andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    InsertAllResponse response = bigquery.insertAll(request);
    assertNotNull(response.getErrorsFor(0L));
    assertNull(response.getErrorsFor(1L));
    assertEquals(1, response.getErrorsFor(0L).size());
    assertEquals("ErrorMessage", response.getErrorsFor(0L).get(0).getMessage());
  }

  @Test
  public void testListTableData() {
    EasyMock.expect(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_DATA_PB);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Page<List<FieldValue>> page = bigquery.listTableData(DATASET, TABLE);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
  }

  @Test
  public void testListTableDataFromTableId() {
    EasyMock.expect(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_DATA_PB);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Page<List<FieldValue>> page = bigquery.listTableData(TableId.of(DATASET, TABLE));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
  }

  @Test
  public void testListTableDataFromTableIdWithProject() {
    TableId tableId = TABLE_ID.setProjectId(OTHER_PROJECT);
    EasyMock.expect(bigqueryRpcMock.listTableData(OTHER_PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_DATA_PB);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Page<List<FieldValue>> page = bigquery.listTableData(tableId);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
  }

  @Test
  public void testListTableDataWithOptions() {
    EasyMock.expect(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, TABLE_DATA_LIST_OPTIONS))
        .andReturn(TABLE_DATA_PB);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Page<List<FieldValue>> page =
        bigquery.listTableData(
            DATASET,
            TABLE,
            TABLE_DATA_LIST_PAGE_SIZE,
            TABLE_DATA_LIST_PAGE_TOKEN,
            TABLE_DATA_LIST_START_INDEX);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
  }

  @Test
  public void testCreateQueryJob() {
    EasyMock.expect(
            bigqueryRpcMock.create(
                JobInfo.of(QUERY_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_QUERY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.create(QUERY_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)), job);
  }

  @Test
  public void testCreateLoadJob() {
    EasyMock.expect(
            bigqueryRpcMock.create(
                JobInfo.of(LOAD_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_LOAD_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.create(LOAD_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)), job);
  }

  @Test
  public void testCreateCopyJob() {
    EasyMock.expect(
            bigqueryRpcMock.create(
                JobInfo.of(COPY_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_COPY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.create(COPY_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
  }

  @Test
  public void testCreateExtractJob() {
    EasyMock.expect(
            bigqueryRpcMock.create(
                JobInfo.of(EXTRACT_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_EXTRACT_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.create(EXTRACT_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_EXTRACT_JOB)), job);
  }

  @Test
  public void testCreateJobWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
            bigqueryRpcMock.create(
                eq(JobInfo.of(QUERY_JOB_CONFIGURATION_WITH_PROJECT).toPb()),
                capture(capturedOptions)))
        .andReturn(COMPLETE_QUERY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.create(QUERY_JOB, JOB_OPTION_FIELDS);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)), job);
    String selector = (String) capturedOptions.getValue().get(JOB_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("jobReference"));
    assertTrue(selector.contains("configuration"));
    assertTrue(selector.contains("user_email"));
    assertEquals(37, selector.length());
  }

  @Test
  public void testCreateJobWithProjectId() {
    JobInfo jobInfo =
        JobInfo.newBuilder(QUERY_JOB_CONFIGURATION.setProjectId(OTHER_PROJECT))
            .setJobId(JobId.of(OTHER_PROJECT, JOB))
            .build();
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(bigqueryRpcMock.create(eq(jobInfo.toPb()), capture(capturedOptions)))
        .andReturn(jobInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.create(jobInfo, JOB_OPTION_FIELDS);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(jobInfo)), job);
    String selector = (String) capturedOptions.getValue().get(JOB_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("jobReference"));
    assertTrue(selector.contains("configuration"));
    assertTrue(selector.contains("user_email"));
    assertEquals(37, selector.length());
  }

  @Test
  public void testGetJob() {
    EasyMock.expect(bigqueryRpcMock.getJob(PROJECT, JOB, EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_COPY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.getJob(JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
  }

  @Test
  public void testGetJobFromJobId() {
    EasyMock.expect(bigqueryRpcMock.getJob(PROJECT, JOB, EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_COPY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.getJob(JobId.of(JOB));
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
  }

  @Test
  public void testGetJobFromJobIdWithProject() {
    JobId jobId = JobId.of(OTHER_PROJECT, JOB);
    JobInfo jobInfo = COPY_JOB.setProjectId(OTHER_PROJECT);
    EasyMock.expect(bigqueryRpcMock.getJob(OTHER_PROJECT, JOB, EMPTY_RPC_OPTIONS))
        .andReturn(jobInfo.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    Job job = bigquery.getJob(jobId);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(jobInfo)), job);
  }

  @Test
  public void testListJobs() {
    bigquery = options.getService();
    ImmutableList<Job> jobList =
        ImmutableList.of(
            new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)),
            new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
        Tuple.of(
            CURSOR,
            Iterables.transform(
                jobList,
                new Function<Job, com.google.api.services.bigquery.model.Job>() {
                  @Override
                  public com.google.api.services.bigquery.model.Job apply(Job job) {
                    return job.toPb();
                  }
                }));
    EasyMock.expect(bigqueryRpcMock.listJobs(PROJECT, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Job> page = bigquery.listJobs();
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.getValues(), Job.class));
  }

  @Test
  public void testListJobsWithOptions() {
    bigquery = options.getService();
    ImmutableList<Job> jobList =
        ImmutableList.of(
            new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)),
            new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
        Tuple.of(
            CURSOR,
            Iterables.transform(
                jobList,
                new Function<Job, com.google.api.services.bigquery.model.Job>() {
                  @Override
                  public com.google.api.services.bigquery.model.Job apply(Job job) {
                    return job.toPb();
                  }
                }));
    EasyMock.expect(bigqueryRpcMock.listJobs(PROJECT, JOB_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Job> page =
        bigquery.listJobs(
            JOB_LIST_ALL_USERS, JOB_LIST_STATE_FILTER, JOB_LIST_PAGE_TOKEN, JOB_LIST_PAGE_SIZE);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.getValues(), Job.class));
  }

  @Test
  public void testListJobsWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    bigquery = options.getService();
    ImmutableList<Job> jobList =
        ImmutableList.of(
            new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)),
            new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
        Tuple.of(
            CURSOR,
            Iterables.transform(
                jobList,
                new Function<Job, com.google.api.services.bigquery.model.Job>() {
                  @Override
                  public com.google.api.services.bigquery.model.Job apply(Job job) {
                    return job.toPb();
                  }
                }));
    EasyMock.expect(bigqueryRpcMock.listJobs(eq(PROJECT), capture(capturedOptions)))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Job> page = bigquery.listJobs(JOB_LIST_OPTION_FIELD);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.getValues(), Job.class));
    String selector = (String) capturedOptions.getValue().get(JOB_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("nextPageToken,jobs("));
    assertTrue(selector.contains("configuration"));
    assertTrue(selector.contains("jobReference"));
    assertTrue(selector.contains("statistics"));
    assertTrue(selector.contains("state"));
    assertTrue(selector.contains("errorResult"));
    assertTrue(selector.contains(")"));
    assertEquals(75, selector.length());
  }

  @Test
  public void testCancelJob() {
    EasyMock.expect(bigqueryRpcMock.cancel(PROJECT, JOB)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.cancel(JOB));
  }

  @Test
  public void testCancelJobFromJobId() {
    EasyMock.expect(bigqueryRpcMock.cancel(PROJECT, JOB)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.cancel(JobId.of(PROJECT, JOB)));
  }

  @Test
  public void testCancelJobFromJobIdWithProject() {
    JobId jobId = JobId.of(OTHER_PROJECT, JOB);
    EasyMock.expect(bigqueryRpcMock.cancel(OTHER_PROJECT, JOB)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    assertTrue(bigquery.cancel(jobId));
  }

  @Test
  public void testQueryRequest() {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.Job jobResponsePb =
        new com.google.api.services.bigquery.model.Job()
            .setConfiguration(QUERY_JOB_CONFIGURATION_FOR_QUERY.toPb())
            .setJobReference(queryJob.toPb())
            .setId(JOB);
    GetQueryResultsResponse responsePb =
        new GetQueryResultsResponse()
            .setJobReference(queryJob.toPb())
            .setJobComplete(false);

    EasyMock.expect(
        bigqueryRpcMock.create(JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap()))
            .andReturn(jobResponsePb);

    Map<BigQueryRpc.Option, Object> optionMap = Maps.newEnumMap(BigQueryRpc.Option.class);
    QueryResultsOption pageSizeOption = QueryResultsOption.pageSize(42L);
    optionMap.put(pageSizeOption.getRpcOption(), pageSizeOption.getValue());
    EasyMock.expect(
        bigqueryRpcMock.getQueryResults(PROJECT, JOB, optionMap)).andReturn(responsePb);

    EasyMock.replay(bigqueryRpcMock);

    bigquery = options.getService();
    QueryResponse response = bigquery.query(QUERY_REQUEST, queryJob);
    assertNull(response.getEtag());
    assertNull(response.getResult());
    assertEquals(queryJob, response.getJobId());
    assertEquals(false, response.jobCompleted());
    assertEquals(ImmutableList.<BigQueryError>of(), response.getExecutionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.getResult());
  }

  @Test
  public void testQueryRequestCompleted() {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.Job jobResponsePb =
        new com.google.api.services.bigquery.model.Job()
            .setConfiguration(QUERY_JOB_CONFIGURATION_FOR_QUERY.toPb())
            .setJobReference(queryJob.toPb())
            .setId(JOB);
    GetQueryResultsResponse responsePb =
        new GetQueryResultsResponse()
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken(CURSOR)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));

    EasyMock.expect(
        bigqueryRpcMock.create(JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap()))
        .andReturn(jobResponsePb);

    Map<BigQueryRpc.Option, Object> optionMap = Maps.newEnumMap(BigQueryRpc.Option.class);
    QueryResultsOption pageSizeOption = QueryResultsOption.pageSize(42L);
    optionMap.put(pageSizeOption.getRpcOption(), pageSizeOption.getValue());
    EasyMock.expect(
        bigqueryRpcMock.getQueryResults(PROJECT, JOB, optionMap)).andReturn(responsePb);

    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    QueryResponse response = bigquery.query(QUERY_REQUEST, queryJob);
    assertNull(response.getEtag());
    assertEquals(queryJob, response.getJobId());
    assertEquals(true, response.jobCompleted());
    assertEquals(false, response.getResult().cacheHit());
    assertEquals(ImmutableList.<BigQueryError>of(), response.getExecutionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.getResult().getSchema());
    assertEquals(42L, response.getResult().getTotalBytesProcessed());
    assertEquals(1L, response.getResult().getTotalRows());
    for (List<FieldValue> row : response.getResult().getValues()) {
      assertEquals(false, row.get(0).getBooleanValue());
      assertEquals(1L, row.get(1).getLongValue());
    }
    assertEquals(CURSOR, response.getResult().getNextPageToken());
  }

  @Test
  public void testGetQueryResults() {
    JobId queryJob = JobId.of(JOB);
    GetQueryResultsResponse responsePb =
        new GetQueryResultsResponse()
            .setEtag("etag")
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken(CURSOR)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));
    EasyMock.expect(bigqueryRpcMock.getQueryResults(PROJECT, JOB, EMPTY_RPC_OPTIONS))
        .andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    QueryResponse response = bigquery.getQueryResults(queryJob);
    assertEquals("etag", response.getEtag());
    assertEquals(queryJob, response.getJobId());
    assertEquals(true, response.jobCompleted());
    assertEquals(false, response.getResult().cacheHit());
    assertEquals(ImmutableList.<BigQueryError>of(), response.getExecutionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.getResult().getSchema());
    assertEquals(42L, response.getResult().getTotalBytesProcessed());
    assertEquals(1L, response.getResult().getTotalRows());
    for (List<FieldValue> row : response.getResult().getValues()) {
      assertEquals(false, row.get(0).getBooleanValue());
      assertEquals(1L, row.get(1).getLongValue());
    }
    assertEquals(CURSOR, response.getResult().getNextPageToken());
  }

  @Test
  public void testGetQueryResultsWithProject() {
    JobId queryJob = JobId.of(OTHER_PROJECT, JOB);
    GetQueryResultsResponse responsePb =
        new GetQueryResultsResponse()
            .setEtag("etag")
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken(CURSOR)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));
    EasyMock.expect(bigqueryRpcMock.getQueryResults(OTHER_PROJECT, JOB, EMPTY_RPC_OPTIONS))
        .andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    QueryResponse response = bigquery.getQueryResults(queryJob);
    assertEquals("etag", response.getEtag());
    assertEquals(queryJob, response.getJobId());
    assertEquals(true, response.jobCompleted());
    assertEquals(false, response.getResult().cacheHit());
    assertEquals(ImmutableList.<BigQueryError>of(), response.getExecutionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.getResult().getSchema());
    assertEquals(42L, response.getResult().getTotalBytesProcessed());
    assertEquals(1L, response.getResult().getTotalRows());
    for (List<FieldValue> row : response.getResult().getValues()) {
      assertEquals(false, row.get(0).getBooleanValue());
      assertEquals(1L, row.get(1).getLongValue());
    }
    assertEquals(CURSOR, response.getResult().getNextPageToken());
  }

  @Test
  public void testGetQueryResultsWithOptions() {
    JobId queryJob = JobId.of(PROJECT, JOB);
    GetQueryResultsResponse responsePb =
        new GetQueryResultsResponse()
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken(CURSOR)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));
    EasyMock.expect(bigqueryRpcMock.getQueryResults(PROJECT, JOB, QUERY_RESULTS_OPTIONS))
        .andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    QueryResponse response =
        bigquery.getQueryResults(
            queryJob,
            QUERY_RESULTS_OPTION_TIME,
            QUERY_RESULTS_OPTION_INDEX,
            QUERY_RESULTS_OPTION_PAGE_SIZE,
            QUERY_RESULTS_OPTION_PAGE_TOKEN);
    assertEquals(queryJob, response.getJobId());
    assertEquals(true, response.jobCompleted());
    assertEquals(false, response.getResult().cacheHit());
    assertEquals(ImmutableList.<BigQueryError>of(), response.getExecutionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.getResult().getSchema());
    assertEquals(42L, response.getResult().getTotalBytesProcessed());
    assertEquals(1L, response.getResult().getTotalRows());
    for (List<FieldValue> row : response.getResult().getValues()) {
      assertEquals(false, row.get(0).getBooleanValue());
      assertEquals(1L, row.get(1).getLongValue());
    }
    assertEquals(CURSOR, response.getResult().getNextPageToken());
  }

  @Test
  public void testWriter() {
    WriteChannelConfiguration writeChannelConfiguration = WriteChannelConfiguration.of(TABLE_ID);
    EasyMock.expect(
            bigqueryRpcMock.open(WriteChannelConfiguration.of(TABLE_ID_WITH_PROJECT).toPb()))
        .andReturn("upload-id");
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.getService();
    WriteChannel channel = bigquery.writer(writeChannelConfiguration);
    assertNotNull(channel);
    assertTrue(channel.isOpen());
  }

  @Test
  public void testRetryableException() {
    EasyMock.expect(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andThrow(new BigQueryException(500, "InternalError"))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
  }

  @Test
  public void testNonRetryableException() {
    String exceptionMessage = "Not Implemented";
    EasyMock.expect(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andThrow(new BigQueryException(501, exceptionMessage));
    EasyMock.replay(bigqueryRpcMock);
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    thrown.expect(BigQueryException.class);
    thrown.expectMessage(exceptionMessage);
    bigquery.getDataset(DatasetId.of(DATASET));
  }

  @Test
  public void testRuntimeException() {
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(bigqueryRpcMock);
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    thrown.expect(BigQueryException.class);
    thrown.expectMessage(exceptionMessage);
    bigquery.getDataset(DATASET);
  }
}

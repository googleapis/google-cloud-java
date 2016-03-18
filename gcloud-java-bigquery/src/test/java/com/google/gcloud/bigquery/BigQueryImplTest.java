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

import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.eq;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.services.bigquery.model.ErrorProto;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableRow;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gcloud.Page;
import com.google.gcloud.RetryParams;
import com.google.gcloud.WriteChannel;
import com.google.gcloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.gcloud.bigquery.spi.BigQueryRpc;
import com.google.gcloud.bigquery.spi.BigQueryRpc.Tuple;
import com.google.gcloud.bigquery.spi.BigQueryRpcFactory;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class BigQueryImplTest {

  private static final String PROJECT = "project";
  private static final String DATASET = "dataset";
  private static final String TABLE = "table";
  private static final String JOB = "job";
  private static final String OTHER_TABLE = "otherTable";
  private static final String OTHER_DATASET = "otherDataset";
  private static final List<Acl> ACCESS_RULES = ImmutableList.of(
      Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
      Acl.of(new Acl.View(TableId.of("dataset", "table")), Acl.Role.WRITER));
  private static final List<Acl> ACCESS_RULES_WITH_PROJECT = ImmutableList.of(
      Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
      Acl.of(new Acl.View(TableId.of(PROJECT, "dataset", "table"))));
  private static final DatasetInfo DATASET_INFO = DatasetInfo.builder(DATASET)
      .acl(ACCESS_RULES)
      .description("description")
      .build();
  private static final DatasetInfo DATASET_INFO_WITH_PROJECT = DatasetInfo.builder(PROJECT, DATASET)
      .acl(ACCESS_RULES_WITH_PROJECT)
      .description("description")
      .build();
  private static final DatasetInfo OTHER_DATASET_INFO = DatasetInfo.builder(PROJECT, OTHER_DATASET)
      .acl(ACCESS_RULES)
      .description("other description")
      .build();
  private static final TableId TABLE_ID = TableId.of(DATASET, TABLE);
  private static final TableId OTHER_TABLE_ID = TableId.of(PROJECT, DATASET, OTHER_TABLE);
  private static final TableId TABLE_ID_WITH_PROJECT = TableId.of(PROJECT, DATASET, TABLE);
  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.builder("IntegerField", Field.Type.integer())
          .mode(Field.Mode.REPEATED)
          .description("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.builder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .mode(Field.Mode.REQUIRED)
          .description("FieldDescription3")
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
  private static final JobInfo LOAD_JOB =
      JobInfo.of(LOAD_JOB_CONFIGURATION);
  private static final JobInfo COMPLETE_LOAD_JOB =
      JobInfo.of(JobId.of(PROJECT, JOB), LOAD_JOB_CONFIGURATION_WITH_PROJECT);
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID, ImmutableList.of(TABLE_ID, TABLE_ID));
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION_WITH_PROJECT =
      CopyJobConfiguration.of(TABLE_ID_WITH_PROJECT, ImmutableList.of(TABLE_ID_WITH_PROJECT,
          TABLE_ID_WITH_PROJECT));
  private static final JobInfo COPY_JOB = JobInfo.of(COPY_JOB_CONFIGURATION);
  private static final JobInfo COMPLETE_COPY_JOB =
      JobInfo.of(JobId.of(PROJECT, JOB), COPY_JOB_CONFIGURATION_WITH_PROJECT);
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION =
      QueryJobConfiguration.builder("SQL")
          .defaultDataset(DatasetId.of(DATASET))
          .destinationTable(TABLE_ID)
          .build();
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_WITH_PROJECT =
      QueryJobConfiguration.builder("SQL")
          .defaultDataset(DatasetId.of(PROJECT, DATASET))
          .destinationTable(TABLE_ID_WITH_PROJECT)
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
  private static final QueryRequest QUERY_REQUEST = QueryRequest.builder("SQL")
      .maxResults(42L)
      .useQueryCache(false)
      .defaultDataset(DatasetId.of(DATASET))
      .build();
  private static final QueryRequest QUERY_REQUEST_WITH_PROJECT = QueryRequest.builder("SQL")
      .maxResults(42L)
      .useQueryCache(false)
      .defaultDataset(DatasetId.of(PROJECT, DATASET))
      .build();

  // Empty BigQueryRpc options
  private static final Map<BigQueryRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // Dataset options
  private static final BigQuery.DatasetOption DATASET_OPTION_FIELDS =
      BigQuery.DatasetOption.fields(BigQuery.DatasetField.ACCESS, BigQuery.DatasetField.ETAG);

  // Dataset list options
  private static final BigQuery.DatasetListOption DATASET_LIST_ALL =
      BigQuery.DatasetListOption.all();
  private static final BigQuery.DatasetListOption DATASET_LIST_PAGE_TOKEN =
      BigQuery.DatasetListOption.startPageToken("cursor");
  private static final BigQuery.DatasetListOption DATASET_LIST_MAX_RESULTS =
      BigQuery.DatasetListOption.maxResults(42L);
  private static final Map<BigQueryRpc.Option, ?> DATASET_LIST_OPTIONS = ImmutableMap.of(
      BigQueryRpc.Option.ALL_DATASETS, true,
      BigQueryRpc.Option.PAGE_TOKEN, "cursor",
      BigQueryRpc.Option.MAX_RESULTS, 42L);

  // Dataset delete options
  private static final BigQuery.DatasetDeleteOption DATASET_DELETE_CONTENTS =
      BigQuery.DatasetDeleteOption.deleteContents();
  private static final Map<BigQueryRpc.Option, ?> DATASET_DELETE_OPTIONS = ImmutableMap.of(
      BigQueryRpc.Option.DELETE_CONTENTS, true);

  // Table options
  private static final BigQuery.TableOption TABLE_OPTION_FIELDS =
      BigQuery.TableOption.fields(BigQuery.TableField.SCHEMA, BigQuery.TableField.ETAG);

  // Table list options
  private static final BigQuery.TableListOption TABLE_LIST_MAX_RESULTS =
      BigQuery.TableListOption.maxResults(42L);
  private static final BigQuery.TableListOption TABLE_LIST_PAGE_TOKEN =
      BigQuery.TableListOption.startPageToken("cursor");
  private static final Map<BigQueryRpc.Option, ?> TABLE_LIST_OPTIONS = ImmutableMap.of(
      BigQueryRpc.Option.MAX_RESULTS, 42L,
      BigQueryRpc.Option.PAGE_TOKEN, "cursor");

  // TableData list options
  private static final BigQuery.TableDataListOption TABLE_DATA_LIST_MAX_RESULTS =
      BigQuery.TableDataListOption.maxResults(42L);
  private static final BigQuery.TableDataListOption TABLE_DATA_LIST_PAGE_TOKEN =
      BigQuery.TableDataListOption.startPageToken("cursor");
  private static final BigQuery.TableDataListOption TABLE_DATA_LIST_START_INDEX =
      BigQuery.TableDataListOption.startIndex(0L);
  private static final Map<BigQueryRpc.Option, ?> TABLE_DATA_LIST_OPTIONS = ImmutableMap.of(
      BigQueryRpc.Option.MAX_RESULTS, 42L,
      BigQueryRpc.Option.PAGE_TOKEN, "cursor",
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
      BigQuery.JobListOption.startPageToken("cursor");
  private static final BigQuery.JobListOption JOB_LIST_MAX_RESULTS =
      BigQuery.JobListOption.maxResults(42L);
  private static final Map<BigQueryRpc.Option, ?> JOB_LIST_OPTIONS = ImmutableMap.of(
      BigQueryRpc.Option.ALL_USERS, true,
      BigQueryRpc.Option.STATE_FILTER, ImmutableList.of("done", "pending"),
      BigQueryRpc.Option.PAGE_TOKEN, "cursor",
      BigQueryRpc.Option.MAX_RESULTS, 42L);

  // Query Results options
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_TIME =
      BigQuery.QueryResultsOption.maxWaitTime(42L);
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_INDEX =
      BigQuery.QueryResultsOption.startIndex(1024L);
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_PAGE_TOKEN =
      BigQuery.QueryResultsOption.startPageToken("cursor");
  private static final BigQuery.QueryResultsOption QUERY_RESULTS_OPTION_MAX_RESULTS =
      BigQuery.QueryResultsOption.maxResults(0L);
  private static final Map<BigQueryRpc.Option, ?> QUERY_RESULTS_OPTIONS = ImmutableMap.of(
      BigQueryRpc.Option.TIMEOUT, 42L,
      BigQueryRpc.Option.START_INDEX, 1024L,
      BigQueryRpc.Option.PAGE_TOKEN, "cursor",
      BigQueryRpc.Option.MAX_RESULTS, 0L);

  private BigQueryOptions options;
  private BigQueryRpcFactory rpcFactoryMock;
  private BigQueryRpc bigqueryRpcMock;
  private BigQuery bigquery;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createMock(BigQueryRpcFactory.class);
    bigqueryRpcMock = EasyMock.createMock(BigQueryRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(BigQueryOptions.class)))
        .andReturn(bigqueryRpcMock);
    EasyMock.replay(rpcFactoryMock);
    options = BigQueryOptions.builder()
        .projectId(PROJECT)
        .serviceRpcFactory(rpcFactoryMock)
        .retryParams(RetryParams.noRetries())
        .build();
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, bigqueryRpcMock);
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertSame(options, bigquery.options());
  }

  @Test
  public void testCreateDataset() {
    EasyMock.expect(bigqueryRpcMock.create(DATASET_INFO_WITH_PROJECT.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Dataset dataset = bigquery.create(DATASET_INFO);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        dataset);
  }

  @Test
  public void testCreateDatasetWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        bigqueryRpcMock.create(eq(DATASET_INFO_WITH_PROJECT.toPb()), capture(capturedOptions)))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Dataset dataset = bigquery.create(DATASET_INFO, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        dataset);
  }

  @Test
  public void testGetDataset() {
    EasyMock.expect(bigqueryRpcMock.getDataset(DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        dataset);
  }

  @Test
  public void testGetDatasetFromDatasetId() {
    EasyMock.expect(bigqueryRpcMock.getDataset(DATASET, EMPTY_RPC_OPTIONS))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Dataset dataset = bigquery.getDataset(DatasetId.of(PROJECT, DATASET));
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        dataset);
  }

  @Test
  public void testGetDatasetWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(bigqueryRpcMock.getDataset(eq(DATASET), capture(capturedOptions)))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Dataset dataset = bigquery.getDataset(DATASET, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        dataset);
  }

  @Test
  public void testListDatasets() {
    String cursor = "cursor";
    bigquery = options.service();
    ImmutableList<Dataset> datasetList = ImmutableList.of(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(OTHER_DATASET_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.of(cursor, Iterables.transform(datasetList, DatasetInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listDatasets(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Dataset> page = bigquery.listDatasets();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(datasetList.toArray(), Iterables.toArray(page.values(), DatasetInfo.class));
  }

  @Test
  public void testListEmptyDatasets() {
    ImmutableList<com.google.api.services.bigquery.model.Dataset> datasets = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.<String, Iterable<com.google.api.services.bigquery.model.Dataset>>of(null, datasets);
    EasyMock.expect(bigqueryRpcMock.listDatasets(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Page<Dataset> page = bigquery.listDatasets();
    assertNull(page.nextPageCursor());
    assertArrayEquals(ImmutableList.of().toArray(),
        Iterables.toArray(page.values(), Dataset.class));
  }

  @Test
  public void testListDatasetsWithOptions() {
    String cursor = "cursor";
    bigquery = options.service();
    ImmutableList<Dataset> datasetList = ImmutableList.of(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(OTHER_DATASET_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.of(cursor, Iterables.transform(datasetList, DatasetInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listDatasets(DATASET_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Dataset> page = bigquery.listDatasets(DATASET_LIST_ALL, DATASET_LIST_PAGE_TOKEN,
        DATASET_LIST_MAX_RESULTS);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(datasetList.toArray(), Iterables.toArray(page.values(), DatasetInfo.class));
  }

  @Test
  public void testDeleteDataset() {
    EasyMock.expect(bigqueryRpcMock.deleteDataset(DATASET, EMPTY_RPC_OPTIONS)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertTrue(bigquery.delete(DATASET));
  }

  @Test
  public void testDeleteDatasetFromDatasetId() {
    EasyMock.expect(bigqueryRpcMock.deleteDataset(DATASET, EMPTY_RPC_OPTIONS)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertTrue(bigquery.delete(DatasetId.of(PROJECT, DATASET)));
  }

  @Test
  public void testDeleteDatasetWithOptions() {
    EasyMock.expect(bigqueryRpcMock.deleteDataset(DATASET, DATASET_DELETE_OPTIONS)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertTrue(bigquery.delete(DATASET, DATASET_DELETE_CONTENTS));
  }

  @Test
  public void testUpdateDataset() {
    DatasetInfo updatedDatasetInfo = DATASET_INFO.toBuilder().description("newDescription").build();
    DatasetInfo updatedDatasetInfoWithProject = DATASET_INFO_WITH_PROJECT.toBuilder()
        .description("newDescription")
        .build();
    EasyMock.expect(bigqueryRpcMock.patch(updatedDatasetInfoWithProject.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(updatedDatasetInfoWithProject.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Dataset dataset = bigquery.update(updatedDatasetInfo);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedDatasetInfoWithProject)),
        dataset);
  }

  @Test
  public void testUpdateDatasetWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    DatasetInfo updatedDatasetInfo = DATASET_INFO.toBuilder().description("newDescription").build();
    DatasetInfo updatedDatasetInfoWithProject = DATASET_INFO_WITH_PROJECT.toBuilder()
        .description("newDescription")
        .build();
    EasyMock.expect(
        bigqueryRpcMock.patch(eq(updatedDatasetInfoWithProject.toPb()), capture(capturedOptions)))
        .andReturn(updatedDatasetInfoWithProject.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Dataset dataset = bigquery.update(updatedDatasetInfo, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedDatasetInfoWithProject)),
        dataset);
  }

  @Test
  public void testCreateTable() {
    EasyMock.expect(bigqueryRpcMock.create(TABLE_INFO_WITH_PROJECT.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Table table = bigquery.create(TABLE_INFO);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testCreateTableWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(
        bigqueryRpcMock.create(eq(TABLE_INFO_WITH_PROJECT.toPb()), capture(capturedOptions)))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Table table = bigquery.create(TABLE_INFO, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testGetTable() {
    EasyMock.expect(bigqueryRpcMock.getTable(DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Table table = bigquery.getTable(DATASET, TABLE);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testGetTableFromTableId() {
    EasyMock.expect(bigqueryRpcMock.getTable(DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Table table = bigquery.getTable(TABLE_ID);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testGetTableWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(bigqueryRpcMock.getTable(eq(DATASET), eq(TABLE), capture(capturedOptions)))
        .andReturn(TABLE_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Table table = bigquery.getTable(TABLE_ID, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
  }

  @Test
  public void testListTables() {
    String cursor = "cursor";
    bigquery = options.service();
    ImmutableList<Table> tableList = ImmutableList.of(
        new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)),
        new Table(bigquery, new TableInfo.BuilderImpl(OTHER_TABLE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(cursor, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listTables(DATASET, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Table> page = bigquery.listTables(DATASET);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.values(), Table.class));
  }

  @Test
  public void testListTablesFromDatasetId() {
    String cursor = "cursor";
    bigquery = options.service();
    ImmutableList<Table> tableList = ImmutableList.of(
        new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)),
        new Table(bigquery, new TableInfo.BuilderImpl(OTHER_TABLE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(cursor, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listTables(DATASET, EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Table> page = bigquery.listTables(DatasetId.of(PROJECT, DATASET));
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.values(), Table.class));
  }

  @Test
  public void testListTablesWithOptions() {
    String cursor = "cursor";
    bigquery = options.service();
    ImmutableList<Table> tableList = ImmutableList.of(
        new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)),
        new Table(bigquery, new TableInfo.BuilderImpl(OTHER_TABLE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(cursor, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    EasyMock.expect(bigqueryRpcMock.listTables(DATASET, TABLE_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Table> page = bigquery.listTables(DATASET, TABLE_LIST_MAX_RESULTS, TABLE_LIST_PAGE_TOKEN);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.values(), Table.class));
  }

  @Test
  public void testDeleteTable() {
    EasyMock.expect(bigqueryRpcMock.deleteTable(DATASET, TABLE)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertTrue(bigquery.delete(DATASET, TABLE));
  }

  @Test
  public void testDeleteTableFromTableId() {
    EasyMock.expect(bigqueryRpcMock.deleteTable(DATASET, TABLE)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertTrue(bigquery.delete(TABLE_ID));
  }

  @Test
  public void testUpdateTable() {
    TableInfo updatedTableInfo = TABLE_INFO.toBuilder().description("newDescription").build();
    TableInfo updatedTableInfoWithProject = TABLE_INFO_WITH_PROJECT.toBuilder()
        .description("newDescription")
        .build();
    EasyMock.expect(bigqueryRpcMock.patch(updatedTableInfoWithProject.toPb(), EMPTY_RPC_OPTIONS))
        .andReturn(updatedTableInfoWithProject.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Table table = bigquery.update(updatedTableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(updatedTableInfoWithProject)),
        table);
  }

  @Test
  public void testUpdateTableWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    TableInfo updatedTableInfo = TABLE_INFO.toBuilder().description("newDescription").build();
    TableInfo updatedTableInfoWithProject = TABLE_INFO_WITH_PROJECT.toBuilder()
        .description("newDescription")
        .build();
    EasyMock.expect(bigqueryRpcMock.patch(eq(updatedTableInfoWithProject.toPb()),
        capture(capturedOptions))).andReturn(updatedTableInfoWithProject.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Table table = bigquery.update(updatedTableInfo, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(updatedTableInfoWithProject)),
        table);
  }

  @Test
  public void testInsertAll() {
    Map<String, Object> row1 = ImmutableMap.<String, Object>of("field", "value1");
    Map<String, Object> row2 = ImmutableMap.<String, Object>of("field", "value2");
    List<RowToInsert> rows = ImmutableList.of(
        new RowToInsert("row1", row1),
        new RowToInsert("row2", row2)
    );
    InsertAllRequest request = InsertAllRequest.builder(TABLE_ID)
        .rows(rows)
        .skipInvalidRows(false)
        .ignoreUnknownValues(true)
        .templateSuffix("suffix")
        .build();
    TableDataInsertAllRequest requestPb = new TableDataInsertAllRequest().setRows(
        Lists.transform(rows, new Function<RowToInsert, TableDataInsertAllRequest.Rows>() {
          @Override
          public TableDataInsertAllRequest.Rows apply(RowToInsert rowToInsert) {
            return new TableDataInsertAllRequest.Rows().setInsertId(rowToInsert.id())
                .setJson(rowToInsert.content());
          }
        })).setSkipInvalidRows(false).setIgnoreUnknownValues(true).setTemplateSuffix("suffix");
    TableDataInsertAllResponse responsePb = new TableDataInsertAllResponse().setInsertErrors(
        ImmutableList.of(new TableDataInsertAllResponse.InsertErrors().setIndex(0L).setErrors(
            ImmutableList.of(new ErrorProto().setMessage("ErrorMessage")))));
    EasyMock.expect(bigqueryRpcMock.insertAll(DATASET, TABLE, requestPb))
        .andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    InsertAllResponse response = bigquery.insertAll(request);
    assertNotNull(response.errorsFor(0L));
    assertNull(response.errorsFor(1L));
    assertEquals(1, response.errorsFor(0L).size());
    assertEquals("ErrorMessage", response.errorsFor(0L).get(0).message());
  }

  @Test
  public void testListTableData() {
    String cursor = "cursor";
    com.google.api.services.bigquery.model.TableCell cell1 =
        new com.google.api.services.bigquery.model.TableCell().setV("Value1");
    com.google.api.services.bigquery.model.TableCell cell2 =
        new com.google.api.services.bigquery.model.TableCell().setV("Value2");
    ImmutableList<List<FieldValue>> tableData = ImmutableList.of(
        (List<FieldValue>) ImmutableList.of(FieldValue.fromPb(cell1)),
        ImmutableList.of(FieldValue.fromPb(cell2)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.TableRow>> result =
        Tuple.<String, Iterable<com.google.api.services.bigquery.model.TableRow>>of(cursor,
            ImmutableList.of(
                new com.google.api.services.bigquery.model.TableRow().setF(
                    ImmutableList.of(new com.google.api.services.bigquery.model.TableCell()
                        .setV("Value1"))),
                new com.google.api.services.bigquery.model.TableRow().setF(
                    ImmutableList.of(new com.google.api.services.bigquery.model.TableCell()
                        .setV("Value2")))));
    EasyMock.expect(bigqueryRpcMock.listTableData(DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Page<List<FieldValue>> page = bigquery.listTableData(DATASET, TABLE);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(tableData.toArray(), Iterables.toArray(page.values(), List.class));
  }

  @Test
  public void testListTableDataFromTableId() {
    String cursor = "cursor";
    com.google.api.services.bigquery.model.TableCell cell1 =
        new com.google.api.services.bigquery.model.TableCell().setV("Value1");
    com.google.api.services.bigquery.model.TableCell cell2 =
        new com.google.api.services.bigquery.model.TableCell().setV("Value2");
    ImmutableList<List<FieldValue>> tableData = ImmutableList.of(
        (List<FieldValue>) ImmutableList.of(FieldValue.fromPb(cell1)),
        ImmutableList.of(FieldValue.fromPb(cell2)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.TableRow>> result =
        Tuple.<String, Iterable<com.google.api.services.bigquery.model.TableRow>>of(cursor,
            ImmutableList.of(
                new com.google.api.services.bigquery.model.TableRow().setF(
                    ImmutableList.of(new com.google.api.services.bigquery.model.TableCell()
                        .setV("Value1"))),
                new com.google.api.services.bigquery.model.TableRow().setF(
                    ImmutableList.of(new com.google.api.services.bigquery.model.TableCell()
                        .setV("Value2")))));
    EasyMock.expect(bigqueryRpcMock.listTableData(DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Page<List<FieldValue>> page = bigquery.listTableData(TableId.of(DATASET, TABLE));
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(tableData.toArray(), Iterables.toArray(page.values(), List.class));
  }

  @Test
  public void testListTableDataWithOptions() {
    String cursor = "cursor";
    com.google.api.services.bigquery.model.TableCell cell1 =
        new com.google.api.services.bigquery.model.TableCell().setV("Value1");
    com.google.api.services.bigquery.model.TableCell cell2 =
        new com.google.api.services.bigquery.model.TableCell().setV("Value2");
    ImmutableList<List<FieldValue>> tableData = ImmutableList.of(
        (List<FieldValue>) ImmutableList.of(FieldValue.fromPb(cell1)),
        ImmutableList.of(FieldValue.fromPb(cell2)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.TableRow>> result =
        Tuple.<String, Iterable<com.google.api.services.bigquery.model.TableRow>>of(cursor,
            ImmutableList.of(
                new com.google.api.services.bigquery.model.TableRow().setF(
                    ImmutableList.of(new com.google.api.services.bigquery.model.TableCell()
                        .setV("Value1"))),
                new com.google.api.services.bigquery.model.TableRow().setF(
                    ImmutableList.of(new com.google.api.services.bigquery.model.TableCell()
                        .setV("Value2")))));
    EasyMock.expect(bigqueryRpcMock.listTableData(DATASET, TABLE, TABLE_DATA_LIST_OPTIONS))
        .andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Page<List<FieldValue>> page = bigquery.listTableData(DATASET, TABLE,
        TABLE_DATA_LIST_MAX_RESULTS, TABLE_DATA_LIST_PAGE_TOKEN, TABLE_DATA_LIST_START_INDEX);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(tableData.toArray(), Iterables.toArray(page.values(), List.class));
  }

  @Test
  public void testCreateQueryJob() {
    EasyMock.expect(bigqueryRpcMock.create(
        JobInfo.of(QUERY_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
            .andReturn(COMPLETE_QUERY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Job job = bigquery.create(QUERY_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)), job);
  }

  @Test
  public void testCreateLoadJob() {
    EasyMock.expect(bigqueryRpcMock.create(
        JobInfo.of(LOAD_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
            .andReturn(COMPLETE_LOAD_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Job job = bigquery.create(LOAD_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)), job);
  }

  @Test
  public void testCreateCopyJob() {
    EasyMock.expect(bigqueryRpcMock.create(
        JobInfo.of(COPY_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
            .andReturn(COMPLETE_COPY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Job job = bigquery.create(COPY_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
  }

  @Test
  public void testCreateExtractJob() {
    EasyMock.expect(bigqueryRpcMock.create(
        JobInfo.of(EXTRACT_JOB_CONFIGURATION_WITH_PROJECT).toPb(), EMPTY_RPC_OPTIONS))
            .andReturn(COMPLETE_EXTRACT_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Job job = bigquery.create(EXTRACT_JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_EXTRACT_JOB)), job);
  }

  @Test
  public void testCreateJobWithSelectedFields() {
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    EasyMock.expect(bigqueryRpcMock.create(
        eq(JobInfo.of(QUERY_JOB_CONFIGURATION_WITH_PROJECT).toPb()), capture(capturedOptions)))
            .andReturn(COMPLETE_QUERY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Job job = bigquery.create(QUERY_JOB, JOB_OPTION_FIELDS);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)), job);
    String selector = (String) capturedOptions.getValue().get(JOB_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("jobReference"));
    assertTrue(selector.contains("configuration"));
    assertTrue(selector.contains("user_email"));
    assertEquals(37, selector.length());
  }

  @Test
  public void testGetJob() {
    EasyMock.expect(bigqueryRpcMock.getJob(JOB, EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_COPY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Job job = bigquery.getJob(JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
  }

  @Test
  public void testGetJobFromJobId() {
    EasyMock.expect(bigqueryRpcMock.getJob(JOB, EMPTY_RPC_OPTIONS))
        .andReturn(COMPLETE_COPY_JOB.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    Job job = bigquery.getJob(JobId.of(PROJECT, JOB));
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
  }

  @Test
  public void testListJobs() {
    String cursor = "cursor";
    bigquery = options.service();
    ImmutableList<Job> jobList = ImmutableList.of(
        new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)),
        new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
        Tuple.of(cursor, Iterables.transform(jobList,
            new Function<Job, com.google.api.services.bigquery.model.Job>() {
              @Override
              public com.google.api.services.bigquery.model.Job apply(Job job) {
                return job.toPb();
              }
            }));
    EasyMock.expect(bigqueryRpcMock.listJobs(EMPTY_RPC_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Job> page = bigquery.listJobs();
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.values(), Job.class));
  }

  @Test
  public void testListJobsWithOptions() {
    String cursor = "cursor";
    bigquery = options.service();
    ImmutableList<Job> jobList = ImmutableList.of(
        new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)),
        new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
        Tuple.of(cursor, Iterables.transform(jobList,
            new Function<Job, com.google.api.services.bigquery.model.Job>() {
              @Override
              public com.google.api.services.bigquery.model.Job apply(Job job) {
                return job.toPb();
              }
            }));
    EasyMock.expect(bigqueryRpcMock.listJobs(JOB_LIST_OPTIONS)).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Job> page = bigquery.listJobs(JOB_LIST_ALL_USERS, JOB_LIST_STATE_FILTER,
        JOB_LIST_PAGE_TOKEN, JOB_LIST_MAX_RESULTS);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.values(), Job.class));
  }

  @Test
  public void testListJobsWithSelectedFields() {
    String cursor = "cursor";
    Capture<Map<BigQueryRpc.Option, Object>> capturedOptions = Capture.newInstance();
    bigquery = options.service();
    ImmutableList<Job> jobList = ImmutableList.of(
        new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_QUERY_JOB)),
        new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_LOAD_JOB)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Job>> result =
        Tuple.of(cursor, Iterables.transform(jobList,
            new Function<Job, com.google.api.services.bigquery.model.Job>() {
              @Override
              public com.google.api.services.bigquery.model.Job apply(Job job) {
                return job.toPb();
              }
            }));
    EasyMock.expect(bigqueryRpcMock.listJobs(capture(capturedOptions))).andReturn(result);
    EasyMock.replay(bigqueryRpcMock);
    Page<Job> page = bigquery.listJobs(JOB_LIST_OPTION_FIELD);
    assertEquals(cursor, page.nextPageCursor());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.values(), Job.class));
    String selector = (String) capturedOptions.getValue().get(JOB_OPTION_FIELDS.rpcOption());
    assertTrue(selector.contains("etag,jobs("));
    assertTrue(selector.contains("configuration"));
    assertTrue(selector.contains("jobReference"));
    assertTrue(selector.contains("statistics"));
    assertTrue(selector.contains("state,errorResult),nextPageToken"));
    assertEquals(80, selector.length());
  }

  @Test
  public void testCancelJob() {
    EasyMock.expect(bigqueryRpcMock.cancel(JOB)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertTrue(bigquery.cancel(JOB));
  }

  @Test
  public void testCancelJobFromJobId() {
    EasyMock.expect(bigqueryRpcMock.cancel(JOB)).andReturn(true);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    assertTrue(bigquery.cancel(JobId.of(PROJECT, JOB)));
  }

  @Test
  public void testQueryRequest() {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.QueryResponse responsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setJobReference(queryJob.toPb())
            .setJobComplete(false);
    EasyMock.expect(bigqueryRpcMock.query(QUERY_REQUEST_WITH_PROJECT.toPb())).andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    QueryResponse response = bigquery.query(QUERY_REQUEST);
    assertNull(response.etag());
    assertNull(response.result());
    assertEquals(queryJob, response.jobId());
    assertEquals(false, response.jobCompleted());
    assertEquals(ImmutableList.<BigQueryError>of(), response.executionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.result());
  }

  @Test
  public void testQueryRequestCompleted() {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.QueryResponse responsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken("cursor")
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));
    EasyMock.expect(bigqueryRpcMock.query(QUERY_REQUEST_WITH_PROJECT.toPb())).andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    QueryResponse response = bigquery.query(QUERY_REQUEST);
    assertNull(response.etag());
    assertEquals(queryJob, response.jobId());
    assertEquals(true, response.jobCompleted());
    assertEquals(false, response.result().cacheHit());
    assertEquals(ImmutableList.<BigQueryError>of(), response.executionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.result().schema());
    assertEquals(42L, response.result().totalBytesProcessed());
    assertEquals(1L, response.result().totalRows());
    for (List<FieldValue> row : response.result().values()) {
      assertEquals(false, row.get(0).booleanValue());
      assertEquals(1L, row.get(1).longValue());
    }
    assertEquals("cursor", response.result().nextPageCursor());
  }

  @Test
  public void testGetQueryResults() {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.GetQueryResultsResponse responsePb =
        new com.google.api.services.bigquery.model.GetQueryResultsResponse()
            .setEtag("etag")
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken("cursor")
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));
    EasyMock.expect(bigqueryRpcMock.getQueryResults(JOB, EMPTY_RPC_OPTIONS)).andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    QueryResponse response = bigquery.getQueryResults(queryJob);
    assertEquals("etag", response.etag());
    assertEquals(queryJob, response.jobId());
    assertEquals(true, response.jobCompleted());
    assertEquals(false, response.result().cacheHit());
    assertEquals(ImmutableList.<BigQueryError>of(), response.executionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.result().schema());
    assertEquals(42L, response.result().totalBytesProcessed());
    assertEquals(1L, response.result().totalRows());
    for (List<FieldValue> row : response.result().values()) {
      assertEquals(false, row.get(0).booleanValue());
      assertEquals(1L, row.get(1).longValue());
    }
    assertEquals("cursor", response.result().nextPageCursor());
  }

  @Test
  public void testGetQueryResultsWithOptions() {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.GetQueryResultsResponse responsePb =
        new com.google.api.services.bigquery.model.GetQueryResultsResponse()
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken("cursor")
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));
    EasyMock.expect(bigqueryRpcMock.getQueryResults(JOB, QUERY_RESULTS_OPTIONS))
        .andReturn(responsePb);
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    QueryResponse response = bigquery.getQueryResults(queryJob, QUERY_RESULTS_OPTION_TIME,
        QUERY_RESULTS_OPTION_INDEX, QUERY_RESULTS_OPTION_MAX_RESULTS,
        QUERY_RESULTS_OPTION_PAGE_TOKEN);
    assertEquals(queryJob, response.jobId());
    assertEquals(true, response.jobCompleted());
    assertEquals(false, response.result().cacheHit());
    assertEquals(ImmutableList.<BigQueryError>of(), response.executionErrors());
    assertFalse(response.hasErrors());
    assertEquals(null, response.result().schema());
    assertEquals(42L, response.result().totalBytesProcessed());
    assertEquals(1L, response.result().totalRows());
    for (List<FieldValue> row : response.result().values()) {
      assertEquals(false, row.get(0).booleanValue());
      assertEquals(1L, row.get(1).longValue());
    }
    assertEquals("cursor", response.result().nextPageCursor());
  }

  @Test
  public void testWriter() {
    WriteChannelConfiguration writeChannelConfiguration = WriteChannelConfiguration.of(TABLE_ID);
    EasyMock.expect(
        bigqueryRpcMock.open(WriteChannelConfiguration.of(TABLE_ID_WITH_PROJECT).toPb()))
            .andReturn("upload-id");
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.service();
    WriteChannel channel = bigquery.writer(writeChannelConfiguration);
    assertNotNull(channel);
    assertTrue(channel.isOpen());
  }

  @Test
  public void testRetryableException() {
    EasyMock.expect(bigqueryRpcMock.getDataset(DATASET, EMPTY_RPC_OPTIONS))
        .andThrow(new BigQueryException(500, "InternalError"))
        .andReturn(DATASET_INFO_WITH_PROJECT.toPb());
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.toBuilder().retryParams(RetryParams.defaultInstance()).build().service();
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)),
        dataset);
  }

  @Test
  public void testNonRetryableException() {
    String exceptionMessage = "Not Implemented";
    EasyMock.expect(bigqueryRpcMock.getDataset(DATASET, EMPTY_RPC_OPTIONS))
        .andThrow(new BigQueryException(501, exceptionMessage));
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.toBuilder().retryParams(RetryParams.defaultInstance()).build().service();
    thrown.expect(BigQueryException.class);
    thrown.expectMessage(exceptionMessage);
    bigquery.getDataset(DatasetId.of(DATASET));
  }

  @Test
  public void testRuntimeException() {
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(bigqueryRpcMock.getDataset(DATASET, EMPTY_RPC_OPTIONS))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(bigqueryRpcMock);
    bigquery = options.toBuilder().retryParams(RetryParams.defaultInstance()).build().service();
    thrown.expect(BigQueryException.class);
    thrown.expectMessage(exceptionMessage);
    bigquery.getDataset(DATASET);
  }
}

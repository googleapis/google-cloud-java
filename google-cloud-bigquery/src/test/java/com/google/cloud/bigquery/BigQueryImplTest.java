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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.paging.Page;
import com.google.api.services.bigquery.model.ErrorProto;
import com.google.api.services.bigquery.model.GetQueryResultsResponse;
import com.google.api.services.bigquery.model.JobConfigurationQuery;
import com.google.api.services.bigquery.model.QueryRequest;
import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableDataInsertAllRequest;
import com.google.api.services.bigquery.model.TableDataInsertAllResponse;
import com.google.api.services.bigquery.model.TableDataList;
import com.google.api.services.bigquery.model.TableRow;
import com.google.cloud.Policy;
import com.google.cloud.ServiceOptions;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.BigQuery.QueryResultsOption;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.cloud.bigquery.spi.BigQueryRpcFactory;
import com.google.cloud.bigquery.spi.v2.BigQueryRpc;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BigQueryImplTest {

  private static final String PROJECT = "project";
  private static final String LOCATION = "US";
  private static final String OTHER_PROJECT = "otherProject";
  private static final String DATASET = "dataset";
  private static final String TABLE = "table";
  private static final String MODEL = "model";
  private static final String OTHER_MODEL = "otherModel";
  private static final String JOB = "job";
  private static final String OTHER_TABLE = "otherTable";
  private static final String OTHER_DATASET = "otherDataset";
  private static final String ROUTINE = "routine";
  private static final RoutineId ROUTINE_ID = RoutineId.of(DATASET, ROUTINE);
  private static final String ETAG = "etag";
  private static final String ROUTINE_TYPE = "SCALAR_FUNCTION";
  private static final Long CREATION_TIME = 10L;
  private static final Long LAST_MODIFIED_TIME = 20L;
  private static final String LANGUAGE = "SQL";
  private static final String UPLOAD_ID = "uploadid";
  private static final int MIN_CHUNK_SIZE = 256 * 1024;
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
      Field.newBuilder("BooleanField", LegacySQLTypeName.BOOLEAN)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription2")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2);
  private static final StandardTableDefinition TABLE_DEFINITION =
      StandardTableDefinition.of(TABLE_SCHEMA);
  private static final ModelTableDefinition MODEL_TABLE_DEFINITION =
      ModelTableDefinition.newBuilder().build();
  private static final Long EXPIRATION_MS = 86400000L;
  private static final Long TABLE_CREATION_TIME = 1546275600000L;
  private static final TimePartitioning TIME_PARTITIONING =
      TimePartitioning.of(TimePartitioning.Type.DAY, EXPIRATION_MS);
  private static final com.google.api.services.bigquery.model.TimePartitioning PB_TIMEPARTITIONING =
      new com.google.api.services.bigquery.model.TimePartitioning()
          .setType(null)
          .setField("timestampField");
  private static final TimePartitioning TIME_PARTITIONING_NULL_TYPE =
      TimePartitioning.fromPb(PB_TIMEPARTITIONING);
  private static final StandardTableDefinition TABLE_DEFINITION_WITH_PARTITIONING =
      StandardTableDefinition.newBuilder()
          .setSchema(TABLE_SCHEMA)
          .setTimePartitioning(TIME_PARTITIONING)
          .build();
  private static final StandardTableDefinition TABLE_DEFINITION_WITH_PARTITIONING_NULL_TYPE =
      StandardTableDefinition.newBuilder()
          .setSchema(TABLE_SCHEMA)
          .setTimePartitioning(TIME_PARTITIONING_NULL_TYPE)
          .build();
  private static final RangePartitioning.Range RANGE =
      RangePartitioning.Range.newBuilder().setStart(1L).setInterval(2L).setEnd(10L).build();
  private static final RangePartitioning RANGE_PARTITIONING =
      RangePartitioning.newBuilder().setField("IntegerField").setRange(RANGE).build();
  private static final StandardTableDefinition TABLE_DEFINITION_WITH_RANGE_PARTITIONING =
      StandardTableDefinition.newBuilder()
          .setSchema(TABLE_SCHEMA)
          .setRangePartitioning(RANGE_PARTITIONING)
          .build();
  private static final TableInfo TABLE_INFO_RANGE_PARTITIONING =
      TableInfo.of(TABLE_ID, TABLE_DEFINITION_WITH_RANGE_PARTITIONING);
  private static final TableInfo TABLE_INFO = TableInfo.of(TABLE_ID, TABLE_DEFINITION);
  private static final TableInfo OTHER_TABLE_INFO = TableInfo.of(OTHER_TABLE_ID, TABLE_DEFINITION);
  private static final TableInfo TABLE_INFO_WITH_PROJECT =
      TableInfo.of(TABLE_ID_WITH_PROJECT, TABLE_DEFINITION);
  private static final TableInfo MODEL_TABLE_INFO_WITH_PROJECT =
      TableInfo.of(TABLE_ID_WITH_PROJECT, MODEL_TABLE_DEFINITION);
  private static final TableInfo TABLE_INFO_WITH_PARTITIONS =
      TableInfo.newBuilder(TABLE_ID, TABLE_DEFINITION_WITH_PARTITIONING)
          .setCreationTime(TABLE_CREATION_TIME)
          .build();
  private static final TableInfo TABLE_INFO_WITH_PARTITIONS_NULL_TYPE =
      TableInfo.newBuilder(TABLE_ID, TABLE_DEFINITION_WITH_PARTITIONING_NULL_TYPE)
          .setCreationTime(TABLE_CREATION_TIME)
          .build();
  private static final ModelId OTHER_MODEL_ID = ModelId.of(DATASET, OTHER_MODEL);
  private static final ModelId MODEL_ID_WITH_PROJECT = ModelId.of(PROJECT, DATASET, MODEL);

  private static final ModelInfo OTHER_MODEL_INFO = ModelInfo.of(OTHER_MODEL_ID);
  private static final ModelInfo MODEL_INFO_WITH_PROJECT = ModelInfo.of(MODEL_ID_WITH_PROJECT);

  private static final LoadJobConfiguration LOAD_JOB_CONFIGURATION_WITH_PROJECT =
      LoadJobConfiguration.of(TABLE_ID_WITH_PROJECT, "URI");
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
  private static final JobInfo COMPLETE_QUERY_JOB =
      JobInfo.of(JobId.of(PROJECT, JOB), QUERY_JOB_CONFIGURATION_WITH_PROJECT);
  private static final TableCell BOOLEAN_FIELD = new TableCell().setV("false");
  private static final TableCell INTEGER_FIELD = new TableCell().setV("1");
  private static final TableRow TABLE_ROW =
      new TableRow().setF(ImmutableList.of(BOOLEAN_FIELD, INTEGER_FIELD));

  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_FOR_QUERY =
      QueryJobConfiguration.newBuilder("SQL")
          .setDefaultDataset(DatasetId.of(PROJECT, DATASET))
          .setUseQueryCache(false)
          .build();
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_FOR_DMLQUERY =
      QueryJobConfiguration.newBuilder("DML")
          .setDefaultDataset(DatasetId.of(PROJECT, DATASET))
          .setUseQueryCache(false)
          .build();
  private static final QueryJobConfiguration QUERY_JOB_CONFIGURATION_FOR_DDLQUERY =
      QueryJobConfiguration.newBuilder("DDL")
          .setDefaultDataset(DatasetId.of(PROJECT, DATASET))
          .setUseQueryCache(false)
          .build();
  private static final JobInfo JOB_INFO =
      JobInfo.newBuilder(QUERY_JOB_CONFIGURATION_FOR_QUERY)
          .setJobId(JobId.of(PROJECT, JOB))
          .build();
  private static final String CURSOR = "cursor";
  private static final TableCell CELL_PB1 = new TableCell().setV("Value1");
  private static final TableCell CELL_PB2 = new TableCell().setV("Value2");
  private static final ImmutableList<FieldValueList> TABLE_DATA =
      ImmutableList.of(
          FieldValueList.of(ImmutableList.of(FieldValue.fromPb(CELL_PB1))),
          FieldValueList.of(ImmutableList.of(FieldValue.fromPb(CELL_PB2))));
  private static final TableDataList TABLE_DATA_PB =
      new TableDataList()
          .setPageToken(CURSOR)
          .setTotalRows(3L)
          .setRows(
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

  // Table list partitions
  private static final Field PROJECT_ID_FIELD =
      Field.newBuilder("project_id", LegacySQLTypeName.STRING).setMode(Field.Mode.NULLABLE).build();
  private static final Field DATASET_ID_FIELD =
      Field.newBuilder("dataset_id", LegacySQLTypeName.STRING).setMode(Field.Mode.NULLABLE).build();
  private static final Field TABLE_ID_FIELD =
      Field.newBuilder("table_id", LegacySQLTypeName.STRING).setMode(Field.Mode.NULLABLE).build();
  private static final Field PARTITION_ID_FIELD =
      Field.newBuilder("partition_id", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .build();
  private static final Field CREATION_TIME_FIELD =
      Field.newBuilder("creation_time", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.NULLABLE)
          .build();
  private static final Field CREATION_TIMESTAMP_FIELD =
      Field.newBuilder("creation_timestamp", LegacySQLTypeName.TIMESTAMP)
          .setMode(Field.Mode.NULLABLE)
          .build();
  private static final Field LAST_MODIFIED_FIELD =
      Field.newBuilder("last_modified_time", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.NULLABLE)
          .build();
  private static final Field LAST_MODIFIED_TIMESTAMP_FIELD =
      Field.newBuilder("last_modified_timestamp", LegacySQLTypeName.TIMESTAMP)
          .setMode(Field.Mode.NULLABLE)
          .build();
  private static final Schema SCHEMA_PARTITIONS =
      Schema.of(
          PROJECT_ID_FIELD,
          DATASET_ID_FIELD,
          TABLE_ID_FIELD,
          PARTITION_ID_FIELD,
          CREATION_TIME_FIELD,
          CREATION_TIMESTAMP_FIELD,
          LAST_MODIFIED_FIELD,
          LAST_MODIFIED_TIMESTAMP_FIELD);
  private static final TableDefinition TABLE_DEFINITION_PARTITIONS =
      StandardTableDefinition.newBuilder()
          .setSchema(SCHEMA_PARTITIONS)
          .setNumBytes(0L)
          .setNumLongTermBytes(0L)
          .setNumRows(3L)
          .setLocation("unknown")
          .build();
  private static final TableInfo TABLE_INFO_PARTITIONS =
      TableInfo.newBuilder(TABLE_ID, TABLE_DEFINITION_PARTITIONS)
          .setEtag("ETAG")
          .setCreationTime(1553689573240L)
          .setLastModifiedTime(1553841163438L)
          .setNumBytes(0L)
          .setNumLongTermBytes(0L)
          .setNumRows(BigInteger.valueOf(3L))
          .build();
  private static final TableCell TABLE_CELL1_PROJECT_ID = new TableCell().setV(PROJECT);
  private static final TableCell TABLE_CELL1_DATASET_ID = new TableCell().setV(DATASET);
  private static final TableCell TABLE_CELL1_TABLE_ID = new TableCell().setV(TABLE);
  private static final TableCell TABLE_CELL1_PARTITION_ID = new TableCell().setV("20190327");
  private static final TableCell TABLE_CELL1_CREATION_TIME = new TableCell().setV("1553694932498");
  private static final TableCell TABLE_CELL1_CREATION_TIMESTAMP =
      new TableCell().setV("1553694932.498");
  private static final TableCell TABLE_CELL1_LAST_MODIFIED_TIME =
      new TableCell().setV("1553694932989");
  private static final TableCell TABLE_CELL1_LAST_MODIFIED_TIMESTAMP =
      new TableCell().setV("1553694932.989");

  private static final TableCell TABLE_CELL2_PARTITION_ID = new TableCell().setV("20190328");
  private static final TableCell TABLE_CELL2_CREATION_TIME = new TableCell().setV("1553754224760");
  private static final TableCell TABLE_CELL2_CREATION_TIMESTAMP =
      new TableCell().setV("1553754224.76");
  private static final TableCell TABLE_CELL2_LAST_MODIFIED_TIME =
      new TableCell().setV("1553754225587");
  private static final TableCell TABLE_CELL2_LAST_MODIFIED_TIMESTAMP =
      new TableCell().setV("1553754225.587");

  private static final TableCell TABLE_CELL3_PARTITION_ID = new TableCell().setV("20190329");
  private static final TableCell TABLE_CELL3_CREATION_TIME = new TableCell().setV("1553841162879");
  private static final TableCell TABLE_CELL3_CREATION_TIMESTAMP =
      new TableCell().setV("1553841162.879");
  private static final TableCell TABLE_CELL3_LAST_MODIFIED_TIME =
      new TableCell().setV("1553841163438");
  private static final TableCell TABLE_CELL3_LAST_MODIFIED_TIMESTAMP =
      new TableCell().setV("1553841163.438");

  private static final TableDataList TABLE_DATA_WITH_PARTITIONS =
      new TableDataList()
          .setTotalRows(3L)
          .setRows(
              ImmutableList.of(
                  new TableRow()
                      .setF(
                          ImmutableList.of(
                              TABLE_CELL1_PROJECT_ID,
                              TABLE_CELL1_DATASET_ID,
                              TABLE_CELL1_TABLE_ID,
                              TABLE_CELL1_PARTITION_ID,
                              TABLE_CELL1_CREATION_TIME,
                              TABLE_CELL1_CREATION_TIMESTAMP,
                              TABLE_CELL1_LAST_MODIFIED_TIME,
                              TABLE_CELL1_LAST_MODIFIED_TIMESTAMP)),
                  new TableRow()
                      .setF(
                          ImmutableList.of(
                              TABLE_CELL1_PROJECT_ID,
                              TABLE_CELL1_DATASET_ID,
                              TABLE_CELL1_TABLE_ID,
                              TABLE_CELL2_PARTITION_ID,
                              TABLE_CELL2_CREATION_TIME,
                              TABLE_CELL2_CREATION_TIMESTAMP,
                              TABLE_CELL2_LAST_MODIFIED_TIME,
                              TABLE_CELL2_LAST_MODIFIED_TIMESTAMP)),
                  new TableRow()
                      .setF(
                          ImmutableList.of(
                              TABLE_CELL1_PROJECT_ID,
                              TABLE_CELL1_DATASET_ID,
                              TABLE_CELL1_TABLE_ID,
                              TABLE_CELL3_PARTITION_ID,
                              TABLE_CELL3_CREATION_TIME,
                              TABLE_CELL3_CREATION_TIMESTAMP,
                              TABLE_CELL3_LAST_MODIFIED_TIME,
                              TABLE_CELL3_LAST_MODIFIED_TIMESTAMP))));
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

  private static final RoutineArgument ARG_1 =
      RoutineArgument.newBuilder()
          .setDataType(StandardSQLDataType.newBuilder("STRING").build())
          .setName("arg1")
          .build();

  private static final List<RoutineArgument> ARGUMENT_LIST = ImmutableList.of(ARG_1);

  private static final StandardSQLDataType RETURN_TYPE =
      StandardSQLDataType.newBuilder("FLOAT64").build();

  private static final List<String> IMPORTED_LIBRARIES =
      ImmutableList.of("gs://foo", "gs://bar", "gs://baz");

  private static final String BODY = "body";

  private static final RoutineInfo ROUTINE_INFO =
      RoutineInfo.newBuilder(ROUTINE_ID)
          .setEtag(ETAG)
          .setRoutineType(ROUTINE_TYPE)
          .setCreationTime(CREATION_TIME)
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setLanguage(LANGUAGE)
          .setArguments(ARGUMENT_LIST)
          .setReturnType(RETURN_TYPE)
          .setImportedLibraries(IMPORTED_LIBRARIES)
          .setBody(BODY)
          .build();
  private static final WriteChannelConfiguration LOAD_CONFIGURATION =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
          .setCreateDisposition(JobInfo.CreateDisposition.CREATE_IF_NEEDED)
          .setWriteDisposition(JobInfo.WriteDisposition.WRITE_APPEND)
          .setFormatOptions(FormatOptions.json())
          .setIgnoreUnknownValues(true)
          .setMaxBadRecords(10)
          .build();

  private static final Policy SAMPLE_IAM_POLICY =
      Policy.newBuilder()
          .addIdentity(
              com.google.cloud.Role.of("roles/bigquery.dataViewer"),
              com.google.cloud.Identity.allUsers())
          .setEtag(ETAG)
          .setVersion(1)
          .build();
  private BigQueryOptions options;
  private BigQueryRpcFactory rpcFactoryMock;
  private BigQueryRpc bigqueryRpcMock;
  private BigQuery bigquery;
  private static final String RATE_LIMIT_ERROR_MSG =
      "Job exceeded rate limits: Your table exceeded quota for table update operations. For more information, see https://cloud.google.com/bigquery/docs/troubleshoot-quotas";

  @Captor private ArgumentCaptor<Map<BigQueryRpc.Option, Object>> capturedOptions;
  @Captor private ArgumentCaptor<com.google.api.services.bigquery.model.Job> jobCapture;
  @Captor private ArgumentCaptor<byte[]> capturedBuffer;

  @Captor
  private ArgumentCaptor<com.google.api.services.bigquery.model.QueryRequest> requestPbCapture;

  private TableDataWriteChannel writer;

  private BigQueryOptions createBigQueryOptionsForProject(
      String project, BigQueryRpcFactory rpcFactory) {
    return BigQueryOptions.newBuilder()
        .setProjectId(project)
        .setServiceRpcFactory(rpcFactory)
        .setRetrySettings(ServiceOptions.getNoRetrySettings())
        .build();
  }

  private BigQueryOptions createBigQueryOptionsForProjectWithLocation(
      String project, BigQueryRpcFactory rpcFactory) {
    return BigQueryOptions.newBuilder()
        .setProjectId(project)
        .setLocation(LOCATION)
        .setServiceRpcFactory(rpcFactory)
        .setRetrySettings(ServiceOptions.getNoRetrySettings())
        .build();
  }

  @Before
  public void setUp() {
    rpcFactoryMock = mock(BigQueryRpcFactory.class);
    bigqueryRpcMock = mock(BigQueryRpc.class);
    when(rpcFactoryMock.create(any(BigQueryOptions.class))).thenReturn(bigqueryRpcMock);
    options = createBigQueryOptionsForProject(PROJECT, rpcFactoryMock);
  }

  @Test
  public void testGetOptions() {
    bigquery = options.getService();
    assertSame(options, bigquery.getOptions());
  }

  @Test
  public void testCreateDataset() {
    DatasetInfo datasetInfo = DATASET_INFO.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.create(datasetInfo.toPb(), EMPTY_RPC_OPTIONS))
        .thenReturn(datasetInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Dataset dataset = bigquery.create(datasetInfo);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(datasetInfo)), dataset);
    verify(bigqueryRpcMock).create(datasetInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testCreateDatasetWithSelectedFields() {
    when(bigqueryRpcMock.create(eq(DATASET_INFO_WITH_PROJECT.toPb()), capturedOptions.capture()))
        .thenReturn(DATASET_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Dataset dataset = bigquery.create(DATASET_INFO, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
    verify(bigqueryRpcMock).create(eq(DATASET_INFO_WITH_PROJECT.toPb()), capturedOptions.capture());
  }

  @Test
  public void testGetDataset() {
    when(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .thenReturn(DATASET_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
    verify(bigqueryRpcMock).getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetDatasetNotFoundWhenThrowIsDisabled() {
    when(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .thenReturn(DATASET_INFO_WITH_PROJECT.toPb());
    options.setThrowNotFound(false);
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
    verify(bigqueryRpcMock).getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetDatasetNotFoundWhenThrowIsEnabled() {
    when(bigqueryRpcMock.getDataset(PROJECT, "dataset-not-found", EMPTY_RPC_OPTIONS))
        .thenReturn(null)
        .thenThrow(new BigQueryException(404, "Dataset not found"));
    options.setThrowNotFound(true);
    bigquery = options.getService();
    try {
      bigquery.getDataset("dataset-not-found");
      Assert.fail();
    } catch (BigQueryException ex) {
      Assert.assertNotNull(ex.getMessage());
    }
    verify(bigqueryRpcMock).getDataset(PROJECT, "dataset-not-found", EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetDatasetFromDatasetId() {
    when(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .thenReturn(DATASET_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(DatasetId.of(DATASET));
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
    verify(bigqueryRpcMock).getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetDatasetFromDatasetIdWithProject() {
    DatasetInfo datasetInfo = DATASET_INFO.setProjectId(OTHER_PROJECT);
    DatasetId datasetId = DatasetId.of(OTHER_PROJECT, DATASET);
    when(bigqueryRpcMock.getDataset(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .thenReturn(datasetInfo.toPb());
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(datasetId);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(datasetInfo)), dataset);
    verify(bigqueryRpcMock).getDataset(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetDatasetWithSelectedFields() {
    when(bigqueryRpcMock.getDataset(eq(PROJECT), eq(DATASET), capturedOptions.capture()))
        .thenReturn(DATASET_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Dataset dataset = bigquery.getDataset(DATASET, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
    verify(bigqueryRpcMock).getDataset(eq(PROJECT), eq(DATASET), capturedOptions.capture());
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
    when(bigqueryRpcMock.listDatasets(PROJECT, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Dataset> page = bigquery.listDatasets();
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(
        datasetList.toArray(), Iterables.toArray(page.getValues(), DatasetInfo.class));
    verify(bigqueryRpcMock).listDatasets(PROJECT, EMPTY_RPC_OPTIONS);
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
    when(bigqueryRpcMock.listDatasets(OTHER_PROJECT, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Dataset> page = bigquery.listDatasets(OTHER_PROJECT);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(
        datasetList.toArray(), Iterables.toArray(page.getValues(), DatasetInfo.class));
    verify(bigqueryRpcMock).listDatasets(OTHER_PROJECT, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListEmptyDatasets() {
    ImmutableList<com.google.api.services.bigquery.model.Dataset> datasets = ImmutableList.of();
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Dataset>> result =
        Tuple.<String, Iterable<com.google.api.services.bigquery.model.Dataset>>of(null, datasets);
    when(bigqueryRpcMock.listDatasets(PROJECT, EMPTY_RPC_OPTIONS)).thenReturn(result);
    bigquery = options.getService();
    Page<Dataset> page = bigquery.listDatasets();
    assertNull(page.getNextPageToken());
    assertArrayEquals(
        ImmutableList.of().toArray(), Iterables.toArray(page.getValues(), Dataset.class));
    verify(bigqueryRpcMock).listDatasets(PROJECT, EMPTY_RPC_OPTIONS);
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
    when(bigqueryRpcMock.listDatasets(PROJECT, DATASET_LIST_OPTIONS)).thenReturn(result);
    Page<Dataset> page =
        bigquery.listDatasets(DATASET_LIST_ALL, DATASET_LIST_PAGE_TOKEN, DATASET_LIST_PAGE_SIZE);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(
        datasetList.toArray(), Iterables.toArray(page.getValues(), DatasetInfo.class));
    verify(bigqueryRpcMock).listDatasets(PROJECT, DATASET_LIST_OPTIONS);
  }

  @Test
  public void testDeleteDataset() {
    when(bigqueryRpcMock.deleteDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(DATASET));
    verify(bigqueryRpcMock).deleteDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testDeleteDatasetFromDatasetId() {
    when(bigqueryRpcMock.deleteDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(DatasetId.of(DATASET)));
    verify(bigqueryRpcMock).deleteDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testDeleteDatasetFromDatasetIdWithProject() {
    DatasetId datasetId = DatasetId.of(OTHER_PROJECT, DATASET);
    when(bigqueryRpcMock.deleteDataset(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(datasetId));
    verify(bigqueryRpcMock).deleteDataset(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testDeleteDatasetWithOptions() {
    when(bigqueryRpcMock.deleteDataset(PROJECT, DATASET, DATASET_DELETE_OPTIONS)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(DATASET, DATASET_DELETE_CONTENTS));
    verify(bigqueryRpcMock).deleteDataset(PROJECT, DATASET, DATASET_DELETE_OPTIONS);
  }

  @Test
  public void testUpdateDataset() {
    DatasetInfo updatedDatasetInfo =
        DATASET_INFO
            .setProjectId(OTHER_PROJECT)
            .toBuilder()
            .setDescription("newDescription")
            .build();
    when(bigqueryRpcMock.patch(updatedDatasetInfo.toPb(), EMPTY_RPC_OPTIONS))
        .thenReturn(updatedDatasetInfo.toPb());
    bigquery = options.getService();
    Dataset dataset = bigquery.update(updatedDatasetInfo);
    assertEquals(new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedDatasetInfo)), dataset);
    verify(bigqueryRpcMock).patch(updatedDatasetInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testUpdateDatasetWithSelectedFields() {
    DatasetInfo updatedDatasetInfo =
        DATASET_INFO.toBuilder().setDescription("newDescription").build();
    DatasetInfo updatedDatasetInfoWithProject =
        DATASET_INFO_WITH_PROJECT.toBuilder().setDescription("newDescription").build();
    when(bigqueryRpcMock.patch(eq(updatedDatasetInfoWithProject.toPb()), capturedOptions.capture()))
        .thenReturn(updatedDatasetInfoWithProject.toPb());
    bigquery = options.getService();
    Dataset dataset = bigquery.update(updatedDatasetInfo, DATASET_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(DATASET_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("datasetReference"));
    assertTrue(selector.contains("access"));
    assertTrue(selector.contains("etag"));
    assertEquals(28, selector.length());
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedDatasetInfoWithProject)), dataset);
    verify(bigqueryRpcMock)
        .patch(eq(updatedDatasetInfoWithProject.toPb()), capturedOptions.capture());
  }

  @Test
  public void testCreateTable() {
    TableInfo tableInfo = TABLE_INFO.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.create(tableInfo.toPb(), EMPTY_RPC_OPTIONS)).thenReturn(tableInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.create(tableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(tableInfo)), table);
    verify(bigqueryRpcMock).create(tableInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void tesCreateExternalTable() {
    TableInfo createTableInfo =
        TableInfo.of(TABLE_ID, ExternalTableDefinition.newBuilder().setSchema(TABLE_SCHEMA).build())
            .setProjectId(OTHER_PROJECT);

    com.google.api.services.bigquery.model.Table expectedCreateInput =
        createTableInfo.toPb().setSchema(TABLE_SCHEMA.toPb());
    expectedCreateInput.getExternalDataConfiguration().setSchema(null);
    when(bigqueryRpcMock.create(expectedCreateInput, EMPTY_RPC_OPTIONS))
        .thenReturn(createTableInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.create(createTableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(createTableInfo)), table);
    verify(bigqueryRpcMock).create(expectedCreateInput, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testCreateTableWithoutProject() {
    TableInfo tableInfo = TABLE_INFO.setProjectId(PROJECT);
    TableId tableId = TableId.of("", TABLE_ID.getDataset(), TABLE_ID.getTable());
    tableInfo.toBuilder().setTableId(tableId);
    when(bigqueryRpcMock.create(tableInfo.toPb(), EMPTY_RPC_OPTIONS)).thenReturn(tableInfo.toPb());
    BigQueryOptions bigQueryOptions = createBigQueryOptionsForProject(PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.create(tableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(tableInfo)), table);
    verify(bigqueryRpcMock).create(tableInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testCreateTableWithSelectedFields() {
    when(bigqueryRpcMock.create(eq(TABLE_INFO_WITH_PROJECT.toPb()), capturedOptions.capture()))
        .thenReturn(TABLE_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Table table = bigquery.create(TABLE_INFO, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
    verify(bigqueryRpcMock).create(eq(TABLE_INFO_WITH_PROJECT.toPb()), capturedOptions.capture());
  }

  @Test
  public void testGetTable() {
    when(bigqueryRpcMock.getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Table table = bigquery.getTable(DATASET, TABLE);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
    verify(bigqueryRpcMock).getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetModel() {
    when(bigqueryRpcMock.getModel(PROJECT, DATASET, MODEL, EMPTY_RPC_OPTIONS))
        .thenReturn(MODEL_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Model model = bigquery.getModel(DATASET, MODEL);
    assertEquals(new Model(bigquery, new ModelInfo.BuilderImpl(MODEL_INFO_WITH_PROJECT)), model);
    verify(bigqueryRpcMock).getModel(PROJECT, DATASET, MODEL, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetModelNotFoundWhenThrowIsEnabled() {
    String expected = "Model not found";
    when(bigqueryRpcMock.getModel(PROJECT, DATASET, MODEL, EMPTY_RPC_OPTIONS))
        .thenReturn(null)
        .thenThrow(new BigQueryException(404, expected));
    options.setThrowNotFound(true);
    bigquery = options.getService();
    try {
      bigquery.getModel(DATASET, MODEL);
    } catch (BigQueryException ex) {
      assertEquals(expected, ex.getMessage());
    }
    verify(bigqueryRpcMock).getModel(PROJECT, DATASET, MODEL, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListPartition() {
    when(bigqueryRpcMock.getTable(
            PROJECT, DATASET, "table$__PARTITIONS_SUMMARY__", EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_INFO_PARTITIONS.toPb());
    when(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_DATA_WITH_PARTITIONS);
    bigquery = options.getService();
    List<String> partition = bigquery.listPartitions(TABLE_ID_WITH_PROJECT);
    assertEquals(3, partition.size());
    verify(bigqueryRpcMock)
        .getTable(PROJECT, DATASET, "table$__PARTITIONS_SUMMARY__", EMPTY_RPC_OPTIONS);
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetTableNotFoundWhenThrowIsDisabled() {
    when(bigqueryRpcMock.getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_INFO_WITH_PROJECT.toPb());
    options.setThrowNotFound(false);
    bigquery = options.getService();
    Table table = bigquery.getTable(DATASET, TABLE);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
    verify(bigqueryRpcMock).getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetTableNotFoundWhenThrowIsEnabled() {
    when(bigqueryRpcMock.getTable(PROJECT, DATASET, "table-not-found", EMPTY_RPC_OPTIONS))
        .thenReturn(null)
        .thenThrow(new BigQueryException(404, "Table not found"));
    options.setThrowNotFound(true);
    bigquery = options.getService();
    try {
      bigquery.getTable(DATASET, "table-not-found");
      Assert.fail();
    } catch (BigQueryException ex) {
      Assert.assertNotNull(ex.getMessage());
    }
    verify(bigqueryRpcMock).getTable(PROJECT, DATASET, "table-not-found", EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetTableFromTableId() {
    when(bigqueryRpcMock.getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Table table = bigquery.getTable(TABLE_ID);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
    verify(bigqueryRpcMock).getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetTableFromTableIdWithProject() {
    TableInfo tableInfo = TABLE_INFO.setProjectId(OTHER_PROJECT);
    TableId tableId = TABLE_ID.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.getTable(OTHER_PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(tableInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.getTable(tableId);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(tableInfo)), table);
    verify(bigqueryRpcMock).getTable(OTHER_PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetTableFromTableIdWithoutProject() {
    TableInfo tableInfo = TABLE_INFO.setProjectId(PROJECT);
    TableId tableId = TableId.of("", TABLE_ID.getDataset(), TABLE_ID.getTable());
    when(bigqueryRpcMock.getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(tableInfo.toPb());
    BigQueryOptions bigQueryOptions = createBigQueryOptionsForProject(PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.getTable(tableId);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(tableInfo)), table);
    verify(bigqueryRpcMock).getTable(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetTableWithSelectedFields() {
    when(bigqueryRpcMock.getTable(eq(PROJECT), eq(DATASET), eq(TABLE), capturedOptions.capture()))
        .thenReturn(TABLE_INFO_WITH_PROJECT.toPb());
    bigquery = options.getService();
    Table table = bigquery.getTable(TABLE_ID, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)), table);
    verify(bigqueryRpcMock)
        .getTable(eq(PROJECT), eq(DATASET), eq(TABLE), capturedOptions.capture());
  }

  @Test
  public void testListTables() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PROJECT)),
            new Table(bigquery, new TableInfo.BuilderImpl(OTHER_TABLE_INFO)),
            new Table(bigquery, new TableInfo.BuilderImpl(MODEL_TABLE_INFO_WITH_PROJECT)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listTables(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Table> page = bigquery.listTables(DATASET);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
    verify(bigqueryRpcMock).listTables(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListTablesReturnedParameters() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PARTITIONS)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS)).thenReturn(result);
    Page<Table> page = bigquery.listTables(DATASET, TABLE_LIST_PAGE_SIZE, TABLE_LIST_PAGE_TOKEN);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
    verify(bigqueryRpcMock).listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS);
  }

  @Test
  public void testListTablesReturnedParametersNullType() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_WITH_PARTITIONS_NULL_TYPE)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS)).thenReturn(result);
    Page<Table> page = bigquery.listTables(DATASET, TABLE_LIST_PAGE_SIZE, TABLE_LIST_PAGE_TOKEN);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
    verify(bigqueryRpcMock).listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS);
  }

  @Test
  public void testListTablesWithRangePartitioning() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO_RANGE_PARTITIONING)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS)).thenReturn(result);
    Page<Table> page = bigquery.listTables(DATASET, TABLE_LIST_PAGE_SIZE, TABLE_LIST_PAGE_TOKEN);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
    verify(bigqueryRpcMock).listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS);
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
    when(bigqueryRpcMock.listTables(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Table> page = bigquery.listTables(DatasetId.of(DATASET));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
    verify(bigqueryRpcMock).listTables(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListTablesFromDatasetIdWithProject() {
    bigquery = options.getService();
    ImmutableList<Table> tableList =
        ImmutableList.of(
            new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO.setProjectId(OTHER_PROJECT))));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Table>> result =
        Tuple.of(CURSOR, Iterables.transform(tableList, TableInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listTables(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Table> page = bigquery.listTables(DatasetId.of(OTHER_PROJECT, DATASET));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
    verify(bigqueryRpcMock).listTables(OTHER_PROJECT, DATASET, EMPTY_RPC_OPTIONS);
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
    when(bigqueryRpcMock.listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS)).thenReturn(result);
    Page<Table> page = bigquery.listTables(DATASET, TABLE_LIST_PAGE_SIZE, TABLE_LIST_PAGE_TOKEN);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(tableList.toArray(), Iterables.toArray(page.getValues(), Table.class));
    verify(bigqueryRpcMock).listTables(PROJECT, DATASET, TABLE_LIST_OPTIONS);
  }

  @Test
  public void testListModels() {
    bigquery = options.getService();
    ImmutableList<Model> modelList =
        ImmutableList.of(
            new Model(bigquery, new ModelInfo.BuilderImpl(MODEL_INFO_WITH_PROJECT)),
            new Model(bigquery, new ModelInfo.BuilderImpl(OTHER_MODEL_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>> result =
        Tuple.of(CURSOR, Iterables.transform(modelList, ModelInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listModels(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Model> page = bigquery.listModels(DATASET);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(modelList.toArray(), Iterables.toArray(page.getValues(), Model.class));
    verify(bigqueryRpcMock).listModels(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListModelsWithModelId() {
    bigquery = options.getService();
    ImmutableList<Model> modelList =
        ImmutableList.of(
            new Model(bigquery, new ModelInfo.BuilderImpl(MODEL_INFO_WITH_PROJECT)),
            new Model(bigquery, new ModelInfo.BuilderImpl(OTHER_MODEL_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Model>> result =
        Tuple.of(CURSOR, Iterables.transform(modelList, ModelInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listModels(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Model> page = bigquery.listModels(DatasetId.of(DATASET));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(modelList.toArray(), Iterables.toArray(page.getValues(), Model.class));
    verify(bigqueryRpcMock).listModels(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testDeleteTable() {
    when(bigqueryRpcMock.deleteTable(PROJECT, DATASET, TABLE)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(TABLE_ID));
    verify(bigqueryRpcMock).deleteTable(PROJECT, DATASET, TABLE);
  }

  @Test
  public void testDeleteTableFromTableId() {
    when(bigqueryRpcMock.deleteTable(PROJECT, DATASET, TABLE)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(TABLE_ID));
    verify(bigqueryRpcMock).deleteTable(PROJECT, DATASET, TABLE);
  }

  @Test
  public void testDeleteTableFromTableIdWithProject() {
    TableId tableId = TABLE_ID.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.deleteTable(OTHER_PROJECT, DATASET, TABLE)).thenReturn(true);
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    assertTrue(bigquery.delete(tableId));
    verify(bigqueryRpcMock).deleteTable(OTHER_PROJECT, DATASET, TABLE);
  }

  @Test
  public void testDeleteTableFromTableIdWithoutProject() {
    TableId tableId = TableId.of("", TABLE_ID.getDataset(), TABLE_ID.getTable());
    when(bigqueryRpcMock.deleteTable(PROJECT, DATASET, TABLE)).thenReturn(true);
    BigQueryOptions bigQueryOptions = createBigQueryOptionsForProject(PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    assertTrue(bigquery.delete(tableId));
    verify(bigqueryRpcMock).deleteTable(PROJECT, DATASET, TABLE);
  }

  @Test
  public void testDeleteModel() {
    when(bigqueryRpcMock.deleteModel(PROJECT, DATASET, MODEL)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(ModelId.of(DATASET, MODEL)));
    verify(bigqueryRpcMock).deleteModel(PROJECT, DATASET, MODEL);
  }

  @Test
  public void testUpdateModel() {
    ModelInfo updateModelInfo =
        MODEL_INFO_WITH_PROJECT
            .setProjectId(OTHER_PROJECT)
            .toBuilder()
            .setDescription("newDescription")
            .build();
    when(bigqueryRpcMock.patch(updateModelInfo.toPb(), EMPTY_RPC_OPTIONS))
        .thenReturn(updateModelInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Model actualModel = bigquery.update(updateModelInfo);
    assertEquals(new Model(bigquery, new ModelInfo.BuilderImpl(updateModelInfo)), actualModel);
    verify(bigqueryRpcMock).patch(updateModelInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testUpdateTable() {
    TableInfo updatedTableInfo =
        TABLE_INFO.setProjectId(OTHER_PROJECT).toBuilder().setDescription("newDescription").build();
    when(bigqueryRpcMock.patch(updatedTableInfo.toPb(), EMPTY_RPC_OPTIONS))
        .thenReturn(updatedTableInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.update(updatedTableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(updatedTableInfo)), table);
    verify(bigqueryRpcMock).patch(updatedTableInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testUpdateExternalTableWithNewSchema() {
    TableInfo updatedTableInfo =
        TableInfo.of(TABLE_ID, ExternalTableDefinition.newBuilder().setSchema(TABLE_SCHEMA).build())
            .setProjectId(OTHER_PROJECT);

    com.google.api.services.bigquery.model.Table expectedPatchInput =
        updatedTableInfo.toPb().setSchema(TABLE_SCHEMA.toPb());
    expectedPatchInput.getExternalDataConfiguration().setSchema(null);
    when(bigqueryRpcMock.patch(expectedPatchInput, EMPTY_RPC_OPTIONS))
        .thenReturn(updatedTableInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.update(updatedTableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(updatedTableInfo)), table);
    verify(bigqueryRpcMock).patch(expectedPatchInput, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testUpdateTableWithoutProject() {
    TableInfo tableInfo = TABLE_INFO.setProjectId(PROJECT);
    TableId tableId = TableId.of("", TABLE_ID.getDataset(), TABLE_ID.getTable());
    tableInfo.toBuilder().setTableId(tableId);
    when(bigqueryRpcMock.patch(tableInfo.toPb(), EMPTY_RPC_OPTIONS)).thenReturn(tableInfo.toPb());
    BigQueryOptions bigQueryOptions = createBigQueryOptionsForProject(PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Table table = bigquery.update(tableInfo);
    assertEquals(new Table(bigquery, new TableInfo.BuilderImpl(tableInfo)), table);
    verify(bigqueryRpcMock).patch(tableInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testUpdateTableWithSelectedFields() {
    TableInfo updatedTableInfo = TABLE_INFO.toBuilder().setDescription("newDescription").build();
    TableInfo updatedTableInfoWithProject =
        TABLE_INFO_WITH_PROJECT.toBuilder().setDescription("newDescription").build();
    when(bigqueryRpcMock.patch(eq(updatedTableInfoWithProject.toPb()), capturedOptions.capture()))
        .thenReturn(updatedTableInfoWithProject.toPb());
    bigquery = options.getService();
    Table table = bigquery.update(updatedTableInfo, TABLE_OPTION_FIELDS);
    String selector = (String) capturedOptions.getValue().get(TABLE_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("tableReference"));
    assertTrue(selector.contains("schema"));
    assertTrue(selector.contains("etag"));
    assertEquals(31, selector.length());
    assertEquals(
        new Table(bigquery, new TableInfo.BuilderImpl(updatedTableInfoWithProject)), table);
    verify(bigqueryRpcMock)
        .patch(eq(updatedTableInfoWithProject.toPb()), capturedOptions.capture());
  }

  @Test
  public void testInsertAllWithRowIdShouldRetry() {
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
    when(bigqueryRpcMock.insertAll(PROJECT, DATASET, TABLE, requestPb))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenReturn(responsePb);
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    InsertAllResponse response = bigquery.insertAll(request);
    assertNotNull(response.getErrorsFor(0L));
    assertNull(response.getErrorsFor(1L));
    assertEquals(1, response.getErrorsFor(0L).size());
    assertEquals("ErrorMessage", response.getErrorsFor(0L).get(0).getMessage());
    verify(bigqueryRpcMock, times(2)).insertAll(PROJECT, DATASET, TABLE, requestPb);
  }

  @Test
  public void testInsertAllWithoutRowIdShouldNotRetry() {
    Map<String, Object> row1 = ImmutableMap.<String, Object>of("field", "value1");
    Map<String, Object> row2 = ImmutableMap.<String, Object>of("field", "value2");
    List<RowToInsert> rows = ImmutableList.of(RowToInsert.of(row1), RowToInsert.of(row2));
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
    when(bigqueryRpcMock.insertAll(PROJECT, DATASET, TABLE, requestPb))
        .thenThrow(new BigQueryException(500, "InternalError"));
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    try {
      bigquery.insertAll(request);
      Assert.fail();
    } catch (BigQueryException ex) {
      Assert.assertNotNull(ex.getMessage());
    }
    verify(bigqueryRpcMock).insertAll(PROJECT, DATASET, TABLE, requestPb);
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
    when(bigqueryRpcMock.insertAll(OTHER_PROJECT, DATASET, TABLE, requestPb))
        .thenReturn(responsePb);
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    InsertAllResponse response = bigquery.insertAll(request);
    assertNotNull(response.getErrorsFor(0L));
    assertNull(response.getErrorsFor(1L));
    assertEquals(1, response.getErrorsFor(0L).size());
    assertEquals("ErrorMessage", response.getErrorsFor(0L).get(0).getMessage());
    verify(bigqueryRpcMock).insertAll(OTHER_PROJECT, DATASET, TABLE, requestPb);
  }

  @Test
  public void testInsertAllWithProjectInTable() {
    Map<String, Object> row1 = ImmutableMap.<String, Object>of("field", "value1");
    Map<String, Object> row2 = ImmutableMap.<String, Object>of("field", "value2");
    List<RowToInsert> rows =
        ImmutableList.of(new RowToInsert("row1", row1), new RowToInsert("row2", row2));
    TableId tableId = TableId.of("project-different-from-option", DATASET, TABLE);
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
    when(bigqueryRpcMock.insertAll("project-different-from-option", DATASET, TABLE, requestPb))
        .thenReturn(responsePb);
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    InsertAllResponse response = bigquery.insertAll(request);
    assertNotNull(response.getErrorsFor(0L));
    assertNull(response.getErrorsFor(1L));
    assertEquals(1, response.getErrorsFor(0L).size());
    assertEquals("ErrorMessage", response.getErrorsFor(0L).get(0).getMessage());
    verify(bigqueryRpcMock).insertAll("project-different-from-option", DATASET, TABLE, requestPb);
  }

  @Test
  public void testListTableData() {
    when(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_DATA_PB);
    bigquery = options.getService();
    Page<FieldValueList> page = bigquery.listTableData(DATASET, TABLE);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListTableDataFromTableId() {
    when(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_DATA_PB);
    bigquery = options.getService();
    Page<FieldValueList> page = bigquery.listTableData(TableId.of(DATASET, TABLE));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListTableDataFromTableIdWithProject() {
    TableId tableId = TABLE_ID.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.listTableData(OTHER_PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(TABLE_DATA_PB);
    BigQueryOptions bigQueryOptions = createBigQueryOptionsForProject(PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Page<FieldValueList> page = bigquery.listTableData(tableId);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
    verify(bigqueryRpcMock).listTableData(OTHER_PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListTableDataWithOptions() {
    when(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, TABLE_DATA_LIST_OPTIONS))
        .thenReturn(TABLE_DATA_PB);
    bigquery = options.getService();
    Page<FieldValueList> page =
        bigquery.listTableData(
            DATASET,
            TABLE,
            TABLE_DATA_LIST_PAGE_SIZE,
            TABLE_DATA_LIST_PAGE_TOKEN,
            TABLE_DATA_LIST_START_INDEX);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, TABLE_DATA_LIST_OPTIONS);
  }

  @Test
  public void testListTableDataWithNextPage() {
    doReturn(TABLE_DATA_PB)
        .when(bigqueryRpcMock)
        .listTableData(PROJECT, DATASET, TABLE, TABLE_DATA_LIST_OPTIONS);
    bigquery = options.getService();
    TableResult page =
        bigquery.listTableData(
            DATASET,
            TABLE,
            TABLE_DATA_LIST_PAGE_SIZE,
            TABLE_DATA_LIST_PAGE_TOKEN,
            TABLE_DATA_LIST_START_INDEX);
    assertEquals(CURSOR, page.getNextPageToken());
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, TABLE_DATA_LIST_OPTIONS);
    assertArrayEquals(TABLE_DATA.toArray(), Iterables.toArray(page.getValues(), List.class));
    Map<BigQueryRpc.Option, ?> SECOND_TABLE_DATA_LIST_OPTIONS =
        ImmutableMap.of(BigQueryRpc.Option.PAGE_TOKEN, CURSOR, BigQueryRpc.Option.START_INDEX, 0L);
    doReturn(
            new TableDataList()
                .setPageToken(null)
                .setTotalRows(1L)
                .setRows(
                    ImmutableList.of(
                        new TableRow().setF(ImmutableList.of(new TableCell().setV("Value3"))),
                        new TableRow().setF(ImmutableList.of(new TableCell().setV("Value4"))))))
        .when(bigqueryRpcMock)
        .listTableData(PROJECT, DATASET, TABLE, SECOND_TABLE_DATA_LIST_OPTIONS);
    assertTrue(page.hasNextPage());
    page = page.getNextPage();
    assertNull(page.getNextPageToken());
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, SECOND_TABLE_DATA_LIST_OPTIONS);
  }

  // The "minimally initialized" Job that lets Job.fromPb run without throwing.
  private static com.google.api.services.bigquery.model.Job newJobPb() {
    return new com.google.api.services.bigquery.model.Job()
        .setConfiguration(
            new com.google.api.services.bigquery.model.JobConfiguration()
                .setQuery(new JobConfigurationQuery().setQuery("FOO")));
  }

  @Test
  public void testCreateJobSuccess() {
    String id = "testCreateJobSuccess-id";
    JobId jobId = JobId.of(id);
    String query = "SELECT * in FOO";

    when(bigqueryRpcMock.create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS)))
        .thenReturn(newJobPb());

    bigquery = options.getService();
    assertThat(bigquery.create(JobInfo.of(jobId, QueryJobConfiguration.of(query)))).isNotNull();
    assertThat(jobCapture.getValue().getJobReference().getJobId()).isEqualTo(id);
    verify(bigqueryRpcMock).create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS));
  }

  @Test
  public void testCreateJobFailureShouldRetry() {
    when(bigqueryRpcMock.create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS)))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenThrow(new BigQueryException(502, "Bad Gateway"))
        .thenThrow(new BigQueryException(503, "Service Unavailable"))
        .thenThrow(
            new BigQueryException(
                400, RATE_LIMIT_ERROR_MSG)) // retrial on based on RATE_LIMIT_EXCEEDED_MSG
        .thenThrow(new BigQueryException(200, RATE_LIMIT_ERROR_MSG))
        .thenReturn(newJobPb());

    bigquery = options.getService();
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();

    ((BigQueryImpl) bigquery).create(JobInfo.of(QUERY_JOB_CONFIGURATION_FOR_DMLQUERY));
    verify(bigqueryRpcMock, times(6)).create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS));
  }

  @Test
  public void testCreateJobWithSelectedFields() {
    when(bigqueryRpcMock.create(
            any(com.google.api.services.bigquery.model.Job.class), capturedOptions.capture()))
        .thenReturn(newJobPb());

    BigQuery.JobOption jobOptions = BigQuery.JobOption.fields(BigQuery.JobField.USER_EMAIL);

    bigquery = options.getService();
    bigquery.create(JobInfo.of(QueryJobConfiguration.of("SOME QUERY")), jobOptions);
    String selector = (String) capturedOptions.getValue().get(jobOptions.getRpcOption());

    // jobReference and configuration are always sent; the RPC call won't succeed otherwise.
    assertThat(selector.split(","))
        .asList()
        .containsExactly("jobReference", "configuration", "user_email");
    verify(bigqueryRpcMock)
        .create(any(com.google.api.services.bigquery.model.Job.class), capturedOptions.capture());
  }

  @Test
  public void testCreateJobNoGet() {
    String id = "testCreateJobNoGet-id";
    JobId jobId = JobId.of(id);
    String query = "SELECT * in FOO";

    when(bigqueryRpcMock.create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS)))
        .thenThrow(new BigQueryException(409, "already exists, for some reason"));

    bigquery = options.getService();
    try {
      bigquery.create(JobInfo.of(jobId, QueryJobConfiguration.of(query)));
      fail("should throw");
    } catch (BigQueryException e) {
      assertThat(jobCapture.getValue().getJobReference().getJobId()).isEqualTo(id);
    }
    verify(bigqueryRpcMock).create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS));
  }

  @Test
  public void testCreateJobTryGet() {
    final String id = "testCreateJobTryGet-id";
    String query = "SELECT * in FOO";
    Supplier<JobId> idProvider =
        new Supplier<JobId>() {
          @Override
          public JobId get() {
            return JobId.of(id);
          }
        };

    when(bigqueryRpcMock.create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS)))
        .thenThrow(new BigQueryException(409, "already exists, for some reason"));
    when(bigqueryRpcMock.getJob(
            any(String.class), eq(id), eq((String) null), eq(EMPTY_RPC_OPTIONS)))
        .thenReturn(newJobPb());

    bigquery = options.getService();
    ((BigQueryImpl) bigquery).create(JobInfo.of(QueryJobConfiguration.of(query)), idProvider);
    assertThat(jobCapture.getValue().getJobReference().getJobId()).isEqualTo(id);
    verify(bigqueryRpcMock).create(jobCapture.capture(), eq(EMPTY_RPC_OPTIONS));
    verify(bigqueryRpcMock)
        .getJob(any(String.class), eq(id), eq((String) null), eq(EMPTY_RPC_OPTIONS));
  }

  @Test
  public void testCreateJobWithProjectId() {
    JobInfo jobInfo =
        JobInfo.newBuilder(QUERY_JOB_CONFIGURATION.setProjectId(OTHER_PROJECT))
            .setJobId(JobId.of(OTHER_PROJECT, JOB))
            .build();
    when(bigqueryRpcMock.create(eq(jobInfo.toPb()), capturedOptions.capture()))
        .thenReturn(jobInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Job job = bigquery.create(jobInfo, JOB_OPTION_FIELDS);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(jobInfo)), job);
    String selector = (String) capturedOptions.getValue().get(JOB_OPTION_FIELDS.getRpcOption());
    assertTrue(selector.contains("jobReference"));
    assertTrue(selector.contains("configuration"));
    assertTrue(selector.contains("user_email"));
    assertEquals(37, selector.length());
    verify(bigqueryRpcMock).create(eq(jobInfo.toPb()), capturedOptions.capture());
  }

  @Test
  public void testGetJob() {
    when(bigqueryRpcMock.getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS))
        .thenReturn(COMPLETE_COPY_JOB.toPb());
    bigquery = options.getService();
    Job job = bigquery.getJob(JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
    verify(bigqueryRpcMock).getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetJobWithLocation() {
    when(bigqueryRpcMock.getJob(PROJECT, JOB, LOCATION, EMPTY_RPC_OPTIONS))
        .thenReturn(COMPLETE_COPY_JOB.toPb());
    BigQueryOptions options = createBigQueryOptionsForProjectWithLocation(PROJECT, rpcFactoryMock);
    bigquery = options.getService();
    Job job = bigquery.getJob(JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
    verify(bigqueryRpcMock).getJob(PROJECT, JOB, LOCATION, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetJobNotFoundWhenThrowIsDisabled() {
    when(bigqueryRpcMock.getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS))
        .thenReturn(COMPLETE_COPY_JOB.toPb());
    options.setThrowNotFound(false);
    bigquery = options.getService();
    Job job = bigquery.getJob(JOB);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
    verify(bigqueryRpcMock).getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetJobNotFoundWhenThrowIsEnabled() {
    when(bigqueryRpcMock.getJob(PROJECT, "job-not-found", null, EMPTY_RPC_OPTIONS))
        .thenReturn(null)
        .thenThrow(new BigQueryException(404, "Job not found"));
    options.setThrowNotFound(true);
    bigquery = options.getService();
    try {
      bigquery.getJob("job-not-found");
      Assert.fail();
    } catch (BigQueryException ex) {
      Assert.assertNotNull(ex.getMessage());
    }
    verify(bigqueryRpcMock).getJob(PROJECT, "job-not-found", null, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetJobFromJobId() {
    when(bigqueryRpcMock.getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS))
        .thenReturn(COMPLETE_COPY_JOB.toPb());
    bigquery = options.getService();
    Job job = bigquery.getJob(JobId.of(JOB));
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
    verify(bigqueryRpcMock).getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetJobFromJobIdWithLocation() {
    when(bigqueryRpcMock.getJob(PROJECT, JOB, LOCATION, EMPTY_RPC_OPTIONS))
        .thenReturn(COMPLETE_COPY_JOB.toPb());
    BigQueryOptions options = createBigQueryOptionsForProjectWithLocation(PROJECT, rpcFactoryMock);
    bigquery = options.getService();
    Job job = bigquery.getJob(JobId.of(JOB));
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(COMPLETE_COPY_JOB)), job);
    verify(bigqueryRpcMock).getJob(PROJECT, JOB, LOCATION, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetJobFromJobIdWithProject() {
    JobId jobId = JobId.of(OTHER_PROJECT, JOB);
    JobInfo jobInfo = COPY_JOB.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.getJob(OTHER_PROJECT, JOB, null, EMPTY_RPC_OPTIONS))
        .thenReturn(jobInfo.toPb());
    bigquery = options.getService();
    Job job = bigquery.getJob(jobId);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(jobInfo)), job);
    verify(bigqueryRpcMock).getJob(OTHER_PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetJobFromJobIdWithProjectWithLocation() {
    JobId jobId = JobId.of(OTHER_PROJECT, JOB);
    JobInfo jobInfo = COPY_JOB.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.getJob(OTHER_PROJECT, JOB, LOCATION, EMPTY_RPC_OPTIONS))
        .thenReturn(jobInfo.toPb());
    BigQueryOptions options = createBigQueryOptionsForProjectWithLocation(PROJECT, rpcFactoryMock);
    bigquery = options.getService();
    Job job = bigquery.getJob(jobId);
    assertEquals(new Job(bigquery, new JobInfo.BuilderImpl(jobInfo)), job);
    verify(bigqueryRpcMock).getJob(OTHER_PROJECT, JOB, LOCATION, EMPTY_RPC_OPTIONS);
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
    when(bigqueryRpcMock.listJobs(PROJECT, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Job> page = bigquery.listJobs();
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.getValues(), Job.class));
    verify(bigqueryRpcMock).listJobs(PROJECT, EMPTY_RPC_OPTIONS);
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
    when(bigqueryRpcMock.listJobs(PROJECT, JOB_LIST_OPTIONS)).thenReturn(result);
    Page<Job> page =
        bigquery.listJobs(
            JOB_LIST_ALL_USERS, JOB_LIST_STATE_FILTER, JOB_LIST_PAGE_TOKEN, JOB_LIST_PAGE_SIZE);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(jobList.toArray(), Iterables.toArray(page.getValues(), Job.class));
    verify(bigqueryRpcMock).listJobs(PROJECT, JOB_LIST_OPTIONS);
  }

  @Test
  public void testListJobsWithSelectedFields() {
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
    when(bigqueryRpcMock.listJobs(eq(PROJECT), capturedOptions.capture())).thenReturn(result);
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
    verify(bigqueryRpcMock).listJobs(eq(PROJECT), capturedOptions.capture());
  }

  @Test
  public void testCancelJob() {
    when(bigqueryRpcMock.cancel(PROJECT, JOB, null)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.cancel(JOB));
    verify(bigqueryRpcMock).cancel(PROJECT, JOB, null);
  }

  @Test
  public void testCancelJobFromJobId() {
    when(bigqueryRpcMock.cancel(PROJECT, JOB, null)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.cancel(JobId.of(PROJECT, JOB)));
    verify(bigqueryRpcMock).cancel(PROJECT, JOB, null);
  }

  @Test
  public void testCancelJobFromJobIdWithProject() {
    JobId jobId = JobId.of(OTHER_PROJECT, JOB);
    when(bigqueryRpcMock.cancel(OTHER_PROJECT, JOB, null)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.cancel(jobId));
    verify(bigqueryRpcMock).cancel(OTHER_PROJECT, JOB, null);
  }

  @Test
  public void testQueryRequestCompleted() throws InterruptedException {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.Job jobResponsePb =
        new com.google.api.services.bigquery.model.Job()
            .setConfiguration(QUERY_JOB_CONFIGURATION_FOR_QUERY.toPb())
            .setJobReference(queryJob.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"));
    jobResponsePb.getConfiguration().getQuery().setDestinationTable(TABLE_ID.toPb());
    GetQueryResultsResponse responsePb =
        new GetQueryResultsResponse()
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken(CURSOR)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L))
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.create(
            JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap()))
        .thenReturn(jobResponsePb);
    when(bigqueryRpcMock.getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS)))
        .thenReturn(responsePb);
    when(bigqueryRpcMock.listTableData(
            PROJECT, DATASET, TABLE, Collections.<BigQueryRpc.Option, Object>emptyMap()))
        .thenReturn(
            new TableDataList()
                .setPageToken("")
                .setRows(ImmutableList.of(TABLE_ROW))
                .setTotalRows(1L));

    bigquery = options.getService();
    TableResult result = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_QUERY, queryJob);
    assertThat(result.getSchema()).isEqualTo(TABLE_SCHEMA);
    assertThat(result.getTotalRows()).isEqualTo(1);
    for (FieldValueList row : result.getValues()) {
      assertThat(row.get(0).getBooleanValue()).isFalse();
      assertThat(row.get(1).getLongValue()).isEqualTo(1);
    }
    verify(bigqueryRpcMock)
        .create(JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap());
    verify(bigqueryRpcMock)
        .getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS));

    verify(bigqueryRpcMock)
        .listTableData(PROJECT, DATASET, TABLE, Collections.<BigQueryRpc.Option, Object>emptyMap());
  }

  @Test
  public void testFastQueryRequestCompleted() throws InterruptedException {
    com.google.api.services.bigquery.model.QueryResponse queryResponsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setCacheHit(false)
            .setJobComplete(true)
            .setKind("bigquery#queryResponse")
            .setPageToken(null)
            .setRows(ImmutableList.of(TABLE_ROW))
            .setSchema(TABLE_SCHEMA.toPb())
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture()))
        .thenReturn(queryResponsePb);

    bigquery = options.getService();
    TableResult result = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_QUERY);
    assertNull(result.getNextPage());
    assertNull(result.getNextPageToken());
    assertFalse(result.hasNextPage());
    assertThat(result.getSchema()).isEqualTo(TABLE_SCHEMA);
    assertThat(result.getTotalRows()).isEqualTo(1);
    for (FieldValueList row : result.getValues()) {
      assertThat(row.get(0).getBooleanValue()).isFalse();
      assertThat(row.get(1).getLongValue()).isEqualTo(1);
    }

    QueryRequest requestPb = requestPbCapture.getValue();
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.getQuery(), requestPb.getQuery());
    assertEquals(
        QUERY_JOB_CONFIGURATION_FOR_QUERY.getDefaultDataset().getDataset(),
        requestPb.getDefaultDataset().getDatasetId());
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.useQueryCache(), requestPb.getUseQueryCache());

    verify(bigqueryRpcMock).queryRpc(eq(PROJECT), requestPbCapture.capture());
  }

  @Test
  public void testFastQueryMultiplePages() throws InterruptedException {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.Job responseJob =
        new com.google.api.services.bigquery.model.Job()
            .setConfiguration(QUERY_JOB_CONFIGURATION_FOR_QUERY.toPb())
            .setJobReference(queryJob.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"));
    responseJob.getConfiguration().getQuery().setDestinationTable(TABLE_ID.toPb());
    when(bigqueryRpcMock.getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS)).thenReturn(responseJob);
    when(bigqueryRpcMock.listTableData(
            PROJECT,
            DATASET,
            TABLE,
            BigQueryImpl.optionMap(BigQuery.TableDataListOption.pageToken(CURSOR))))
        .thenReturn(
            new TableDataList()
                .setPageToken(CURSOR)
                .setRows(ImmutableList.of(TABLE_ROW))
                .setTotalRows(1L));

    com.google.api.services.bigquery.model.QueryResponse queryResponsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setCacheHit(false)
            .setJobReference(queryJob.toPb())
            .setJobComplete(true)
            .setKind("bigquery#queryResponse")
            .setPageToken(CURSOR)
            .setRows(ImmutableList.of(TABLE_ROW))
            .setSchema(TABLE_SCHEMA.toPb())
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L));

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture()))
        .thenReturn(queryResponsePb);

    bigquery = options.getService();
    TableResult result = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_QUERY);
    assertTrue(result.hasNextPage());
    assertNotNull(result.getNextPageToken());
    assertNotNull(result.getNextPage());

    QueryRequest requestPb = requestPbCapture.getValue();
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.getQuery(), requestPb.getQuery());
    assertEquals(
        QUERY_JOB_CONFIGURATION_FOR_QUERY.getDefaultDataset().getDataset(),
        requestPb.getDefaultDataset().getDatasetId());
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.useQueryCache(), requestPb.getUseQueryCache());

    verify(bigqueryRpcMock).getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
    verify(bigqueryRpcMock)
        .listTableData(
            PROJECT,
            DATASET,
            TABLE,
            BigQueryImpl.optionMap(BigQuery.TableDataListOption.pageToken(CURSOR)));
    verify(bigqueryRpcMock).queryRpc(eq(PROJECT), requestPbCapture.capture());
  }

  @Test
  public void testFastQuerySlowDdl() throws InterruptedException {
    // mock new fast query path response when running a query that takes more than 10s
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.QueryResponse queryResponsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setJobComplete(false) // false when query does not complete in 10s
            .setJobReference(queryJob.toPb()) // backend sends back a jobReference
            .setRows(ImmutableList.of(TABLE_ROW))
            .setSchema(TABLE_SCHEMA.toPb());

    // mock job response from backend
    com.google.api.services.bigquery.model.Job responseJob =
        new com.google.api.services.bigquery.model.Job()
            .setConfiguration(QUERY_JOB_CONFIGURATION_FOR_QUERY.toPb())
            .setJobReference(queryJob.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"));

    // mock old query path response when falling back
    GetQueryResultsResponse queryResultsResponsePb =
        new GetQueryResultsResponse()
            .setJobReference(responseJob.getJobReference())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setTotalRows(BigInteger.valueOf(1L))
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture()))
        .thenReturn(queryResponsePb);
    responseJob.getConfiguration().getQuery().setDestinationTable(TABLE_ID.toPb());
    when(bigqueryRpcMock.getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS)).thenReturn(responseJob);
    when(bigqueryRpcMock.getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS)))
        .thenReturn(queryResultsResponsePb);
    when(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS))
        .thenReturn(new TableDataList().setRows(ImmutableList.of(TABLE_ROW)).setTotalRows(1L));

    bigquery = options.getService();
    TableResult result = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_QUERY);
    assertThat(result.getSchema()).isEqualTo(TABLE_SCHEMA);
    assertThat(result.getTotalRows()).isEqualTo(1);
    for (FieldValueList row : result.getValues()) {
      assertThat(row.get(0).getBooleanValue()).isFalse();
      assertThat(row.get(1).getLongValue()).isEqualTo(1);
    }

    QueryRequest requestPb = requestPbCapture.getValue();
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.getQuery(), requestPb.getQuery());
    assertEquals(
        QUERY_JOB_CONFIGURATION_FOR_QUERY.getDefaultDataset().getDataset(),
        requestPb.getDefaultDataset().getDatasetId());
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.useQueryCache(), requestPb.getUseQueryCache());

    verify(bigqueryRpcMock).queryRpc(eq(PROJECT), requestPbCapture.capture());
    verify(bigqueryRpcMock).getJob(PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
    verify(bigqueryRpcMock)
        .getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS));
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testQueryRequestCompletedOptions() throws InterruptedException {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.Job jobResponsePb =
        new com.google.api.services.bigquery.model.Job()
            .setConfiguration(QUERY_JOB_CONFIGURATION_FOR_QUERY.toPb())
            .setJobReference(queryJob.toPb())
            .setId(JOB)
            .setStatus(new com.google.api.services.bigquery.model.JobStatus().setState("DONE"));
    jobResponsePb.getConfiguration().getQuery().setDestinationTable(TABLE_ID.toPb());
    GetQueryResultsResponse responsePb =
        new GetQueryResultsResponse()
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken(CURSOR)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L))
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.create(
            JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap()))
        .thenReturn(jobResponsePb);

    Map<BigQueryRpc.Option, Object> optionMap = Maps.newEnumMap(BigQueryRpc.Option.class);
    QueryResultsOption pageSizeOption = QueryResultsOption.pageSize(42L);
    optionMap.put(pageSizeOption.getRpcOption(), pageSizeOption.getValue());

    when(bigqueryRpcMock.getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS)))
        .thenReturn(responsePb);
    when(bigqueryRpcMock.listTableData(PROJECT, DATASET, TABLE, optionMap))
        .thenReturn(
            new TableDataList()
                .setPageToken("")
                .setRows(ImmutableList.of(TABLE_ROW))
                .setTotalRows(1L));

    bigquery = options.getService();
    Job job = bigquery.create(JobInfo.of(queryJob, QUERY_JOB_CONFIGURATION_FOR_QUERY));
    TableResult result = job.getQueryResults(pageSizeOption);
    assertThat(result.getSchema()).isEqualTo(TABLE_SCHEMA);
    assertThat(result.getTotalRows()).isEqualTo(1);
    for (FieldValueList row : result.getValues()) {
      assertThat(row.get(0).getBooleanValue()).isFalse();
      assertThat(row.get(1).getLongValue()).isEqualTo(1);
    }
    verify(bigqueryRpcMock)
        .create(JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap());
    verify(bigqueryRpcMock)
        .getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS));
    verify(bigqueryRpcMock).listTableData(PROJECT, DATASET, TABLE, optionMap);
  }

  @Test
  public void testQueryRequestCompletedOnSecondAttempt() throws InterruptedException {
    JobId queryJob = JobId.of(PROJECT, JOB);
    com.google.api.services.bigquery.model.Job jobResponsePb1 =
        new com.google.api.services.bigquery.model.Job()
            .setConfiguration(QUERY_JOB_CONFIGURATION_FOR_QUERY.toPb())
            .setJobReference(queryJob.toPb())
            .setId(JOB);
    jobResponsePb1.setStatus(
        new com.google.api.services.bigquery.model.JobStatus().setState("DONE"));
    jobResponsePb1.getConfiguration().getQuery().setDestinationTable(TABLE_ID.toPb());

    GetQueryResultsResponse responsePb1 =
        new GetQueryResultsResponse().setJobReference(queryJob.toPb()).setJobComplete(false);

    GetQueryResultsResponse responsePb2 =
        new GetQueryResultsResponse()
            .setJobReference(queryJob.toPb())
            .setRows(ImmutableList.of(TABLE_ROW))
            .setJobComplete(true)
            .setCacheHit(false)
            .setPageToken(CURSOR)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L))
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.create(
            JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap()))
        .thenReturn(jobResponsePb1);
    when(bigqueryRpcMock.getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS)))
        .thenReturn(responsePb1);
    when(bigqueryRpcMock.getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS)))
        .thenReturn(responsePb2);
    when(bigqueryRpcMock.listTableData(
            PROJECT, DATASET, TABLE, Collections.<BigQueryRpc.Option, Object>emptyMap()))
        .thenReturn(
            new TableDataList()
                .setPageToken("")
                .setRows(ImmutableList.of(TABLE_ROW))
                .setTotalRows(1L));

    bigquery = options.getService();
    TableResult result = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_QUERY, queryJob);
    assertThat(result.getSchema()).isEqualTo(TABLE_SCHEMA);
    assertThat(result.getTotalRows()).isEqualTo(1);
    for (FieldValueList row : result.getValues()) {
      assertThat(row.get(0).getBooleanValue()).isFalse();
      assertThat(row.get(1).getLongValue()).isEqualTo(1);
    }
    verify(bigqueryRpcMock)
        .create(JOB_INFO.toPb(), Collections.<BigQueryRpc.Option, Object>emptyMap());
    verify(bigqueryRpcMock)
        .getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS));
    verify(bigqueryRpcMock)
        .getQueryResults(
            PROJECT, JOB, null, BigQueryImpl.optionMap(Job.DEFAULT_QUERY_WAIT_OPTIONS));
    verify(bigqueryRpcMock)
        .listTableData(PROJECT, DATASET, TABLE, Collections.<BigQueryRpc.Option, Object>emptyMap());
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
    when(bigqueryRpcMock.getQueryResults(PROJECT, JOB, null, EMPTY_RPC_OPTIONS))
        .thenReturn(responsePb);
    bigquery = options.getService();
    QueryResponse response = bigquery.getQueryResults(queryJob);
    assertEquals(true, response.getCompleted());
    assertEquals(null, response.getSchema());
    verify(bigqueryRpcMock).getQueryResults(PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetQueryResultsRetry() {
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

    when(bigqueryRpcMock.getQueryResults(PROJECT, JOB, null, EMPTY_RPC_OPTIONS))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenThrow(new BigQueryException(502, "Bad Gateway"))
        .thenThrow(new BigQueryException(503, "Service Unavailable"))
        .thenThrow(new BigQueryException(504, "Gateway Timeout"))
        .thenThrow(
            new BigQueryException(
                400,
                BigQueryErrorMessages
                    .RATE_LIMIT_EXCEEDED_MSG)) // retrial on based on RATE_LIMIT_EXCEEDED_MSG
        .thenReturn(responsePb);

    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();

    QueryResponse response = bigquery.getQueryResults(queryJob);
    assertEquals(true, response.getCompleted());
    assertEquals(null, response.getSchema());
    // IMP: Unable to test for idempotency of the requests using getQueryResults(PROJECT, JOB, null,
    // EMPTY_RPC_OPTIONS) as there is no
    // identifier in this method which will can potentially differ and which can be used to
    // establish idempotency
    verify(bigqueryRpcMock, times(6)).getQueryResults(PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
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
    when(bigqueryRpcMock.getQueryResults(OTHER_PROJECT, JOB, null, EMPTY_RPC_OPTIONS))
        .thenReturn(responsePb);
    bigquery = options.getService();
    QueryResponse response = bigquery.getQueryResults(queryJob);
    assertTrue(response.getCompleted());
    assertEquals(null, response.getSchema());
    verify(bigqueryRpcMock).getQueryResults(OTHER_PROJECT, JOB, null, EMPTY_RPC_OPTIONS);
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
    when(bigqueryRpcMock.getQueryResults(PROJECT, JOB, null, QUERY_RESULTS_OPTIONS))
        .thenReturn(responsePb);
    bigquery = options.getService();
    QueryResponse response =
        bigquery.getQueryResults(
            queryJob,
            QUERY_RESULTS_OPTION_TIME,
            QUERY_RESULTS_OPTION_INDEX,
            QUERY_RESULTS_OPTION_PAGE_SIZE,
            QUERY_RESULTS_OPTION_PAGE_TOKEN);
    assertEquals(true, response.getCompleted());
    assertEquals(null, response.getSchema());
    verify(bigqueryRpcMock).getQueryResults(PROJECT, JOB, null, QUERY_RESULTS_OPTIONS);
  }

  @Test
  public void testGetDatasetRetryableException() {
    when(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenReturn(DATASET_INFO_WITH_PROJECT.toPb());
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    Dataset dataset = bigquery.getDataset(DATASET);
    assertEquals(
        new Dataset(bigquery, new DatasetInfo.BuilderImpl(DATASET_INFO_WITH_PROJECT)), dataset);
    verify(bigqueryRpcMock, times(2)).getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testNonRetryableException() {
    String exceptionMessage = "Not Implemented";
    when(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .thenThrow(new BigQueryException(501, exceptionMessage));
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    try {
      bigquery.getDataset(DatasetId.of(DATASET));
      Assert.fail();
    } catch (BigQueryException ex) {
      Assert.assertEquals(exceptionMessage, ex.getMessage());
    }
    verify(bigqueryRpcMock).getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testRuntimeException() {
    String exceptionMessage = "Artificial runtime exception";
    when(bigqueryRpcMock.getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS))
        .thenThrow(new RuntimeException(exceptionMessage));
    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    try {
      bigquery.getDataset(DATASET);
      Assert.fail();
    } catch (BigQueryException ex) {
      Assert.assertTrue(ex.getMessage().endsWith(exceptionMessage));
    }
    verify(bigqueryRpcMock).getDataset(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testQueryDryRun() throws Exception {
    // https://github.com/googleapis/google-cloud-java/issues/2479
    try {
      options
          .toBuilder()
          .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
          .build()
          .getService()
          .query(QueryJobConfiguration.newBuilder("foo").setDryRun(true).build());
      Assert.fail();
    } catch (UnsupportedOperationException ex) {
      Assert.assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void testFastQuerySQLShouldRetry() throws Exception {
    com.google.api.services.bigquery.model.QueryResponse responsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setCacheHit(false)
            .setJobComplete(true)
            .setRows(ImmutableList.of(TABLE_ROW))
            .setPageToken(null)
            .setTotalBytesProcessed(42L)
            .setTotalRows(BigInteger.valueOf(1L))
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture()))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenThrow(new BigQueryException(502, "Bad Gateway"))
        .thenThrow(new BigQueryException(503, "Service Unavailable"))
        .thenThrow(new BigQueryException(504, "Gateway Timeout"))
        .thenReturn(responsePb);

    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();

    TableResult response = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_QUERY);
    assertEquals(TABLE_SCHEMA, response.getSchema());
    assertEquals(1, response.getTotalRows());

    List<QueryRequest> allRequests = requestPbCapture.getAllValues();
    boolean idempotent = true;
    String firstRequestId = allRequests.get(0).getRequestId();
    for (QueryRequest request : allRequests) {
      idempotent = request.getRequestId().equals(firstRequestId);
    }
    assertTrue(idempotent);

    verify(bigqueryRpcMock, times(5)).queryRpc(eq(PROJECT), requestPbCapture.capture());
  }

  @Test
  public void testFastQueryDMLShouldRetry() throws Exception {
    com.google.api.services.bigquery.model.QueryResponse responsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setCacheHit(false)
            .setJobComplete(true)
            .setRows(ImmutableList.of(TABLE_ROW))
            .setPageToken(null)
            .setTotalBytesProcessed(42L)
            .setNumDmlAffectedRows(1L)
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture()))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenThrow(new BigQueryException(502, "Bad Gateway"))
        .thenThrow(new BigQueryException(503, "Service Unavailable"))
        .thenThrow(new BigQueryException(504, "Gateway Timeout"))
        .thenReturn(responsePb);

    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();

    TableResult response = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_DMLQUERY);
    assertEquals(TABLE_SCHEMA, response.getSchema());
    assertEquals(1, response.getTotalRows());

    List<QueryRequest> allRequests = requestPbCapture.getAllValues();
    boolean idempotent = true;
    String firstRequestId = allRequests.get(0).getRequestId();
    for (QueryRequest request : allRequests) {
      idempotent = request.getRequestId().equals(firstRequestId);
    }
    assertTrue(idempotent);

    verify(bigqueryRpcMock, times(5)).queryRpc(eq(PROJECT), requestPbCapture.capture());
  }

  @Test
  public void testFastQueryRateLimitIdempotency() throws Exception {
    com.google.api.services.bigquery.model.QueryResponse responsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setCacheHit(false)
            .setJobComplete(true)
            .setRows(ImmutableList.of(TABLE_ROW))
            .setPageToken(null)
            .setTotalBytesProcessed(42L)
            .setNumDmlAffectedRows(1L)
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture()))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenThrow(new BigQueryException(502, "Bad Gateway"))
        .thenThrow(new BigQueryException(503, "Service Unavailable"))
        .thenThrow(new BigQueryException(504, "Gateway Timeout"))
        .thenThrow(
            new BigQueryException(
                400, RATE_LIMIT_ERROR_MSG)) // retrial on based on RATE_LIMIT_EXCEEDED_MSG
        .thenReturn(responsePb);

    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();

    TableResult response = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_DMLQUERY);
    assertEquals(TABLE_SCHEMA, response.getSchema());
    assertEquals(1, response.getTotalRows());

    List<QueryRequest> allRequests = requestPbCapture.getAllValues();
    boolean idempotent = true;
    String firstRequestId = allRequests.get(0).getRequestId();
    for (QueryRequest request : allRequests) {
      idempotent =
          idempotent
              && request
                  .getRequestId()
                  .equals(firstRequestId); // all the requestIds should be the same
    }

    assertTrue(idempotent);
    verify(bigqueryRpcMock, times(6)).queryRpc(eq(PROJECT), requestPbCapture.capture());
  }

  @Test
  public void testRateLimitRegEx() throws Exception {
    String msg2 =
        "Job eceeded rate limits: Your table exceeded quota for table update operations. For more information, see https://cloud.google.com/bigquery/docs/troubleshoot-quotas";
    String msg3 = "exceeded rate exceeded quota for table update";
    String msg4 = "exceeded rate limits";
    assertTrue(
        BigQueryRetryAlgorithm.matchRegEx(
            BigQueryErrorMessages.RetryRegExPatterns.RATE_LIMIT_EXCEEDED_REGEX,
            RATE_LIMIT_ERROR_MSG));
    assertFalse(
        BigQueryRetryAlgorithm.matchRegEx(
            BigQueryErrorMessages.RetryRegExPatterns.RATE_LIMIT_EXCEEDED_REGEX,
            msg2.toLowerCase()));
    assertFalse(
        BigQueryRetryAlgorithm.matchRegEx(
            BigQueryErrorMessages.RetryRegExPatterns.RATE_LIMIT_EXCEEDED_REGEX,
            msg3.toLowerCase()));
    assertTrue(
        BigQueryRetryAlgorithm.matchRegEx(
            BigQueryErrorMessages.RetryRegExPatterns.RATE_LIMIT_EXCEEDED_REGEX,
            msg4.toLowerCase()));
  }

  @Test
  public void testFastQueryDDLShouldRetry() throws Exception {
    com.google.api.services.bigquery.model.QueryResponse responsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setCacheHit(false)
            .setJobComplete(true)
            .setRows(ImmutableList.of(TABLE_ROW))
            .setPageToken(null)
            .setTotalBytesProcessed(42L)
            .setSchema(TABLE_SCHEMA.toPb());

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture()))
        .thenThrow(new BigQueryException(500, "InternalError"))
        .thenThrow(new BigQueryException(502, "Bad Gateway"))
        .thenThrow(new BigQueryException(503, "Service Unavailable"))
        .thenThrow(new BigQueryException(504, "Gateway Timeout"))
        .thenReturn(responsePb);

    bigquery =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();

    TableResult response = bigquery.query(QUERY_JOB_CONFIGURATION_FOR_DDLQUERY);
    assertEquals(TABLE_SCHEMA, response.getSchema());
    assertEquals(0, response.getTotalRows());

    List<QueryRequest> allRequests = requestPbCapture.getAllValues();
    boolean idempotent = true;
    String firstRequestId = allRequests.get(0).getRequestId();
    for (QueryRequest request : allRequests) {
      idempotent = request.getRequestId().equals(firstRequestId);
    }
    assertTrue(idempotent);

    verify(bigqueryRpcMock, times(5)).queryRpc(eq(PROJECT), requestPbCapture.capture());
  }

  @Test
  public void testFastQueryBigQueryException() throws InterruptedException {
    List<ErrorProto> errorProtoList =
        ImmutableList.of(
            new ErrorProto()
                .setMessage("Backend error1")
                .setLocation("testLocation1")
                .setReason("Backend issue1"),
            new ErrorProto()
                .setMessage("Backend error2")
                .setLocation("testLocation2")
                .setReason("Backend issue2"));
    com.google.api.services.bigquery.model.QueryResponse responsePb =
        new com.google.api.services.bigquery.model.QueryResponse()
            .setJobComplete(true)
            .setPageToken(null)
            .setErrors(errorProtoList);

    when(bigqueryRpcMock.queryRpc(eq(PROJECT), requestPbCapture.capture())).thenReturn(responsePb);

    bigquery = options.getService();
    try {
      bigquery.query(QUERY_JOB_CONFIGURATION_FOR_QUERY);
      fail("BigQueryException expected");
    } catch (BigQueryException ex) {
      assertEquals(Lists.transform(errorProtoList, BigQueryError.FROM_PB_FUNCTION), ex.getErrors());
    }

    QueryRequest requestPb = requestPbCapture.getValue();
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.getQuery(), requestPb.getQuery());
    assertEquals(
        QUERY_JOB_CONFIGURATION_FOR_QUERY.getDefaultDataset().getDataset(),
        requestPb.getDefaultDataset().getDatasetId());
    assertEquals(QUERY_JOB_CONFIGURATION_FOR_QUERY.useQueryCache(), requestPb.getUseQueryCache());
    verify(bigqueryRpcMock).queryRpc(eq(PROJECT), requestPbCapture.capture());
  }

  @Test
  public void testCreateRoutine() {
    RoutineInfo routineInfo = ROUTINE_INFO.setProjectId(OTHER_PROJECT);
    when(bigqueryRpcMock.create(routineInfo.toPb(), EMPTY_RPC_OPTIONS))
        .thenReturn(routineInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Routine actualRoutine = bigquery.create(routineInfo);
    assertEquals(new Routine(bigquery, new RoutineInfo.BuilderImpl(routineInfo)), actualRoutine);
    verify(bigqueryRpcMock).create(routineInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetRoutine() {
    when(bigqueryRpcMock.getRoutine(PROJECT, DATASET, ROUTINE, EMPTY_RPC_OPTIONS))
        .thenReturn(ROUTINE_INFO.toPb());
    bigquery = options.getService();
    Routine routine = bigquery.getRoutine(DATASET, ROUTINE);
    assertEquals(new Routine(bigquery, new RoutineInfo.BuilderImpl(ROUTINE_INFO)), routine);
    verify(bigqueryRpcMock).getRoutine(PROJECT, DATASET, ROUTINE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetRoutineWithRountineId() {
    when(bigqueryRpcMock.getRoutine(PROJECT, DATASET, ROUTINE, EMPTY_RPC_OPTIONS))
        .thenReturn(ROUTINE_INFO.toPb());
    bigquery = options.getService();
    Routine routine = bigquery.getRoutine(ROUTINE_ID);
    assertEquals(new Routine(bigquery, new RoutineInfo.BuilderImpl(ROUTINE_INFO)), routine);
    verify(bigqueryRpcMock).getRoutine(PROJECT, DATASET, ROUTINE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testGetRoutineWithEnabledThrowNotFoundException() {
    when(bigqueryRpcMock.getRoutine(PROJECT, DATASET, ROUTINE, EMPTY_RPC_OPTIONS))
        .thenReturn(null)
        .thenThrow(new BigQueryException(404, "Routine not found"));
    options.setThrowNotFound(true);
    bigquery = options.getService();
    try {
      Routine routine = bigquery.getRoutine(ROUTINE_ID);
      fail();
    } catch (BigQueryException ex) {
      assertEquals("Routine not found", ex.getMessage());
    }
    verify(bigqueryRpcMock).getRoutine(PROJECT, DATASET, ROUTINE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testUpdateRoutine() {
    RoutineInfo updatedRoutineInfo =
        ROUTINE_INFO
            .setProjectId(OTHER_PROJECT)
            .toBuilder()
            .setDescription("newDescription")
            .build();
    when(bigqueryRpcMock.update(updatedRoutineInfo.toPb(), EMPTY_RPC_OPTIONS))
        .thenReturn(updatedRoutineInfo.toPb());
    BigQueryOptions bigQueryOptions =
        createBigQueryOptionsForProject(OTHER_PROJECT, rpcFactoryMock);
    bigquery = bigQueryOptions.getService();
    Routine routine = bigquery.update(updatedRoutineInfo);
    assertEquals(new Routine(bigquery, new RoutineInfo.BuilderImpl(updatedRoutineInfo)), routine);
    verify(bigqueryRpcMock).update(updatedRoutineInfo.toPb(), EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListRoutines() {
    bigquery = options.getService();
    ImmutableList<Routine> routineList =
        ImmutableList.of(new Routine(bigquery, new RoutineInfo.BuilderImpl(ROUTINE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>> result =
        Tuple.of(CURSOR, Iterables.transform(routineList, RoutineInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listRoutines(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Routine> page = bigquery.listRoutines(DATASET);
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(routineList.toArray(), Iterables.toArray(page.getValues(), Routine.class));
    verify(bigqueryRpcMock).listRoutines(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListRoutinesWithDatasetId() {
    bigquery = options.getService();
    ImmutableList<Routine> routineList =
        ImmutableList.of(new Routine(bigquery, new RoutineInfo.BuilderImpl(ROUTINE_INFO)));
    Tuple<String, Iterable<com.google.api.services.bigquery.model.Routine>> result =
        Tuple.of(CURSOR, Iterables.transform(routineList, RoutineInfo.TO_PB_FUNCTION));
    when(bigqueryRpcMock.listRoutines(PROJECT, DATASET, EMPTY_RPC_OPTIONS)).thenReturn(result);
    Page<Routine> page = bigquery.listRoutines(DatasetId.of(PROJECT, DATASET));
    assertEquals(CURSOR, page.getNextPageToken());
    assertArrayEquals(routineList.toArray(), Iterables.toArray(page.getValues(), Routine.class));
    verify(bigqueryRpcMock).listRoutines(PROJECT, DATASET, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testDeleteRoutine() {
    when(bigqueryRpcMock.deleteRoutine(PROJECT, DATASET, ROUTINE)).thenReturn(true);
    bigquery = options.getService();
    assertTrue(bigquery.delete(ROUTINE_ID));
    verify(bigqueryRpcMock).deleteRoutine(PROJECT, DATASET, ROUTINE);
  }

  @Test
  public void testWriteWithJob() throws IOException {
    bigquery = options.getService();
    Job job = new Job(bigquery, new JobInfo.BuilderImpl(JOB_INFO));
    when(bigqueryRpcMock.open(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.write(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true)))
        .thenReturn(job.toPb());
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    writer.close();
    assertEquals(job, writer.getJob());
    bigquery.writer(JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    verify(bigqueryRpcMock)
        .open(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock)
        .write(eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true));
  }

  @Test
  public void testWriteChannel() throws IOException {
    bigquery = options.getService();
    Job job = new Job(bigquery, new JobInfo.BuilderImpl(JOB_INFO));
    when(bigqueryRpcMock.open(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb())))
        .thenReturn(UPLOAD_ID);
    when(bigqueryRpcMock.write(
            eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true)))
        .thenReturn(job.toPb());
    writer = new TableDataWriteChannel(options, JOB_INFO.getJobId(), LOAD_CONFIGURATION);
    writer.close();
    assertEquals(job, writer.getJob());
    bigquery.writer(LOAD_CONFIGURATION);
    verify(bigqueryRpcMock)
        .open(
            new com.google.api.services.bigquery.model.Job()
                .setJobReference(JOB_INFO.getJobId().toPb())
                .setConfiguration(LOAD_CONFIGURATION.toPb()));
    verify(bigqueryRpcMock)
        .write(eq(UPLOAD_ID), capturedBuffer.capture(), eq(0), eq(0L), eq(0), eq(true));
  }

  @Test
  public void testGetIamPolicy() {
    final String resourceId =
        String.format("projects/%s/datasets/%s/tables/%s", PROJECT, DATASET, TABLE);
    final com.google.api.services.bigquery.model.Policy apiPolicy =
        PolicyHelper.convertToApiPolicy(SAMPLE_IAM_POLICY);
    when(bigqueryRpcMock.getIamPolicy(resourceId, EMPTY_RPC_OPTIONS)).thenReturn(apiPolicy);
    bigquery = options.getService();
    Policy policy = bigquery.getIamPolicy(TABLE_ID);
    assertEquals(policy, SAMPLE_IAM_POLICY);
    verify(bigqueryRpcMock).getIamPolicy(resourceId, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testSetIamPolicy() {
    final String resourceId =
        String.format("projects/%s/datasets/%s/tables/%s", PROJECT, DATASET, TABLE);
    final com.google.api.services.bigquery.model.Policy apiPolicy =
        PolicyHelper.convertToApiPolicy(SAMPLE_IAM_POLICY);
    when(bigqueryRpcMock.setIamPolicy(resourceId, apiPolicy, EMPTY_RPC_OPTIONS))
        .thenReturn(apiPolicy);
    bigquery = options.getService();
    Policy returnedPolicy = bigquery.setIamPolicy(TABLE_ID, SAMPLE_IAM_POLICY);
    assertEquals(returnedPolicy, SAMPLE_IAM_POLICY);
    verify(bigqueryRpcMock).setIamPolicy(resourceId, apiPolicy, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testTestIamPermissions() {
    final String resourceId =
        String.format("projects/%s/datasets/%s/tables/%s", PROJECT, DATASET, TABLE);
    final List<String> checkedPermissions = ImmutableList.<String>of("foo", "bar", "baz");
    final List<String> grantedPermissions = ImmutableList.<String>of("foo", "bar");
    final com.google.api.services.bigquery.model.TestIamPermissionsResponse response =
        new com.google.api.services.bigquery.model.TestIamPermissionsResponse()
            .setPermissions(grantedPermissions);
    when(bigqueryRpcMock.testIamPermissions(resourceId, checkedPermissions, EMPTY_RPC_OPTIONS))
        .thenReturn(response);
    bigquery = options.getService();
    List<String> perms = bigquery.testIamPermissions(TABLE_ID, checkedPermissions);
    assertEquals(perms, grantedPermissions);
    verify(bigqueryRpcMock).testIamPermissions(resourceId, checkedPermissions, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testTestIamPermissionsWhenNoPermissionsGranted() {
    final String resourceId =
        String.format("projects/%s/datasets/%s/tables/%s", PROJECT, DATASET, TABLE);
    final List<String> checkedPermissions = ImmutableList.<String>of("foo", "bar", "baz");
    // If caller has no permissions, TestIamPermissionsResponse.permissions will be null
    final com.google.api.services.bigquery.model.TestIamPermissionsResponse response =
        new com.google.api.services.bigquery.model.TestIamPermissionsResponse()
            .setPermissions(null);
    when(bigqueryRpcMock.testIamPermissions(resourceId, checkedPermissions, EMPTY_RPC_OPTIONS))
        .thenReturn(response);
    bigquery = options.getService();
    List<String> perms = bigquery.testIamPermissions(TABLE_ID, checkedPermissions);
    assertEquals(perms, ImmutableList.of());
    verify(bigqueryRpcMock).testIamPermissions(resourceId, checkedPermissions, EMPTY_RPC_OPTIONS);
  }
}

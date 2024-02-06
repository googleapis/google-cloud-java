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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.math.BigInteger;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class TableTest {

  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "project:dataset:table1";
  private static final String SELF_LINK = "selfLink";
  private static final String FRIENDLY_NAME = "friendlyName";
  private static final String DESCRIPTION = "description";
  private static final Long CREATION_TIME = 10L;
  private static final Long EXPIRATION_TIME = 100L;
  private static final Long LAST_MODIFIED_TIME = 20L;
  private static final Long NUM_BYTES = 42L;
  private static final Long NUM_LONG_TERM_BYTES = 21L;
  private static final Long NUM_ROWS = 43L;
  private static final TableId TABLE_ID1 = TableId.of("dataset", "table1");
  private static final TableId TABLE_ID2 = TableId.of("dataset", "table2");
  private static final Boolean REQUIRE_PARTITION_FILTER = true;
  private static final EncryptionConfiguration ENCRYPTION_CONFIGURATION =
      EncryptionConfiguration.newBuilder().setKmsKeyName("KMS_KEY_1").build();
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID2, TABLE_ID1);
  private static final JobInfo COPY_JOB_INFO = JobInfo.of(COPY_JOB_CONFIGURATION);
  private static final JobInfo LOAD_JOB_INFO =
      JobInfo.of(LoadJobConfiguration.of(TABLE_ID1, ImmutableList.of("URI"), FormatOptions.json()));
  private static final JobInfo EXTRACT_JOB_INFO =
      JobInfo.of(ExtractJobConfiguration.of(TABLE_ID1, ImmutableList.of("URI"), "CSV"));
  private static final Field FIELD = Field.of("FieldName", LegacySQLTypeName.STRING);
  private static final Schema SCHEMA = Schema.of(FIELD);
  private static final TableDefinition TABLE_DEFINITION = StandardTableDefinition.of(SCHEMA);
  private static final TableInfo TABLE_INFO = TableInfo.of(TABLE_ID1, TABLE_DEFINITION);
  private static final List<RowToInsert> ROWS_TO_INSERT =
      ImmutableList.of(
          RowToInsert.of("id1", ImmutableMap.<String, Object>of("key", "val1")),
          RowToInsert.of("id2", ImmutableMap.<String, Object>of("key", "val2")));
  private static final InsertAllRequest INSERT_ALL_REQUEST =
      InsertAllRequest.of(TABLE_ID1, ROWS_TO_INSERT);
  private static final InsertAllRequest INSERT_ALL_REQUEST_COMPLETE =
      InsertAllRequest.newBuilder(TABLE_ID1, ROWS_TO_INSERT)
          .setSkipInvalidRows(true)
          .setIgnoreUnknownValues(true)
          .build();
  private static final InsertAllResponse EMPTY_INSERT_ALL_RESPONSE =
      new InsertAllResponse(ImmutableMap.<Long, List<BigQueryError>>of());
  private static final FieldValue FIELD_VALUE1 =
      FieldValue.of(FieldValue.Attribute.PRIMITIVE, "val1");
  private static final FieldValue FIELD_VALUE2 =
      FieldValue.of(FieldValue.Attribute.PRIMITIVE, "val1");
  private static final List<FieldValueList> ROWS =
      ImmutableList.of(
          FieldValueList.of(ImmutableList.of(FIELD_VALUE1)),
          FieldValueList.of(ImmutableList.of(FIELD_VALUE2)));
  private static final List<FieldValueList> ROWS_WITH_SCHEMA =
      ImmutableList.of(
          FieldValueList.of(ImmutableList.of(FIELD_VALUE1)).withSchema(SCHEMA.getFields()),
          FieldValueList.of(ImmutableList.of(FIELD_VALUE2)).withSchema(SCHEMA.getFields()));

  @Rule public MockitoRule rule;

  private BigQuery bigquery;
  private BigQueryOptions mockOptions;
  private Table expectedTable;
  private Table table;

  @Before
  public void setUp() {
    bigquery = mock(BigQuery.class);
    mockOptions = mock(BigQueryOptions.class);
    when(bigquery.getOptions()).thenReturn(mockOptions);
    expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO));
    table = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO));
  }

  @Test
  public void testBuilder() {
    Table builtTable =
        new Table.Builder(bigquery, TABLE_ID1, TABLE_DEFINITION)
            .setCreationTime(CREATION_TIME)
            .setDescription(DESCRIPTION)
            .setEtag(ETAG)
            .setExpirationTime(EXPIRATION_TIME)
            .setFriendlyName(FRIENDLY_NAME)
            .setGeneratedId(GENERATED_ID)
            .setLastModifiedTime(LAST_MODIFIED_TIME)
            .setSelfLink(SELF_LINK)
            .setNumBytes(NUM_BYTES)
            .setNumLongTermBytes(NUM_LONG_TERM_BYTES)
            .setNumRows(BigInteger.valueOf(NUM_ROWS))
            .setRequirePartitionFilter(REQUIRE_PARTITION_FILTER)
            .build();
    assertEquals(TABLE_ID1, builtTable.getTableId());
    assertEquals(CREATION_TIME, builtTable.getCreationTime());
    assertEquals(DESCRIPTION, builtTable.getDescription());
    assertEquals(ETAG, builtTable.getEtag());
    assertEquals(EXPIRATION_TIME, builtTable.getExpirationTime());
    assertEquals(FRIENDLY_NAME, builtTable.getFriendlyName());
    assertEquals(GENERATED_ID, builtTable.getGeneratedId());
    assertEquals(LAST_MODIFIED_TIME, builtTable.getLastModifiedTime());
    assertEquals(TABLE_DEFINITION, builtTable.getDefinition());
    assertEquals(SELF_LINK, builtTable.getSelfLink());
    assertEquals(NUM_BYTES, builtTable.getNumBytes());
    assertEquals(NUM_LONG_TERM_BYTES, builtTable.getNumLongTermBytes());
    assertEquals(BigInteger.valueOf(NUM_ROWS), builtTable.getNumRows());
    assertEquals(REQUIRE_PARTITION_FILTER, builtTable.getRequirePartitionFilter());
    assertSame(bigquery, builtTable.getBigQuery());
  }

  @Test
  public void testToBuilder() {
    compareTable(expectedTable, expectedTable.toBuilder().build());
  }

  @Test
  public void testExists_True() {
    BigQuery.TableOption[] expectedOptions = {BigQuery.TableOption.fields()};
    when(bigquery.getTable(TABLE_INFO.getTableId(), expectedOptions)).thenReturn(expectedTable);
    assertTrue(table.exists());
    verify(bigquery).getTable(TABLE_INFO.getTableId(), expectedOptions);
  }

  @Test
  public void testExists_False() {
    BigQuery.TableOption[] expectedOptions = {BigQuery.TableOption.fields()};
    when(bigquery.getTable(TABLE_INFO.getTableId(), expectedOptions)).thenReturn(null);
    assertFalse(table.exists());
    verify(bigquery).getTable(TABLE_INFO.getTableId(), expectedOptions);
  }

  @Test
  public void testReload() {
    TableInfo updatedInfo = TABLE_INFO.toBuilder().setDescription("Description").build();
    Table expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(updatedInfo));
    when(bigquery.getTable(TABLE_INFO.getTableId())).thenReturn(expectedTable);
    Table updatedTable = table.reload();
    compareTable(expectedTable, updatedTable);
    verify(bigquery).getTable(TABLE_INFO.getTableId());
  }

  @Test
  public void testReloadNull() {
    when(bigquery.getTable(TABLE_INFO.getTableId())).thenReturn(null);
    assertNull(table.reload());
    verify(bigquery).getTable(TABLE_INFO.getTableId());
  }

  @Test
  public void testReloadWithOptions() {
    TableInfo updatedInfo = TABLE_INFO.toBuilder().setDescription("Description").build();
    Table expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(updatedInfo));
    when(bigquery.getTable(TABLE_INFO.getTableId(), BigQuery.TableOption.fields()))
        .thenReturn(expectedTable);
    Table updatedTable = table.reload(BigQuery.TableOption.fields());
    compareTable(expectedTable, updatedTable);
    verify(bigquery).getTable(TABLE_INFO.getTableId(), BigQuery.TableOption.fields());
  }

  @Test
  public void testUpdate() {
    Table expectedUpdatedTable = expectedTable.toBuilder().setDescription("Description").build();
    when(bigquery.update(eq(expectedTable))).thenReturn(expectedUpdatedTable);
    Table actualUpdatedTable = table.update();
    compareTable(expectedUpdatedTable, actualUpdatedTable);
    verify(bigquery).update(eq(expectedTable));
  }

  @Test
  public void testUpdateWithOptions() {
    Table expectedUpdatedTable = expectedTable.toBuilder().setDescription("Description").build();
    when(bigquery.update(eq(expectedTable), eq(BigQuery.TableOption.fields())))
        .thenReturn(expectedUpdatedTable);
    Table actualUpdatedTable = table.update(BigQuery.TableOption.fields());
    compareTable(expectedUpdatedTable, actualUpdatedTable);
    verify(bigquery).update(eq(expectedTable), eq(BigQuery.TableOption.fields()));
  }

  @Test
  public void testDeleteTrue() {
    when(bigquery.delete(TABLE_INFO.getTableId())).thenReturn(true);
    assertTrue(table.delete());
    verify(bigquery).delete(TABLE_INFO.getTableId());
  }

  @Test
  public void testDeleteFalse() {
    when(bigquery.delete(TABLE_INFO.getTableId())).thenReturn(false);
    assertFalse(table.delete());
    verify(bigquery).delete(TABLE_INFO.getTableId());
  }

  @Test
  public void testInsert() {
    when(bigquery.insertAll(INSERT_ALL_REQUEST)).thenReturn(EMPTY_INSERT_ALL_RESPONSE);
    InsertAllResponse response = table.insert(ROWS_TO_INSERT);
    assertSame(EMPTY_INSERT_ALL_RESPONSE, response);
    verify(bigquery).insertAll(INSERT_ALL_REQUEST);
  }

  @Test
  public void testInsertComplete() {
    when(bigquery.insertAll(INSERT_ALL_REQUEST_COMPLETE)).thenReturn(EMPTY_INSERT_ALL_RESPONSE);
    InsertAllResponse response = table.insert(ROWS_TO_INSERT, true, true);
    assertSame(EMPTY_INSERT_ALL_RESPONSE, response);
    verify(bigquery).insertAll(INSERT_ALL_REQUEST_COMPLETE);
  }

  @Test
  public void testList() {
    Page<FieldValueList> page = new PageImpl<>(null, "c", ROWS);
    when(bigquery.listTableData(TABLE_ID1))
        .thenReturn(new TableResult(null, ROWS.size(), page, null));
    when(bigquery.listTableData(TABLE_ID1, SCHEMA))
        .thenReturn(new TableResult(SCHEMA, ROWS.size(), page, null));
    Page<FieldValueList> dataPage = table.list();
    assertThat(dataPage.getValues()).containsExactlyElementsIn(ROWS).inOrder();
    dataPage = table.list(SCHEMA);
    assertThat(dataPage.getValues()).containsExactlyElementsIn(ROWS_WITH_SCHEMA).inOrder();
    verify(bigquery).listTableData(TABLE_ID1);
    verify(bigquery).listTableData(TABLE_ID1, SCHEMA);
  }

  @Test
  public void testListWithOptions() {
    Page<FieldValueList> page = new PageImpl<>(null, "c", ROWS);
    when(bigquery.listTableData(TABLE_ID1, BigQuery.TableDataListOption.pageSize(10L)))
        .thenReturn(new TableResult(null, ROWS.size(), page, null));
    when(bigquery.listTableData(TABLE_ID1, SCHEMA, BigQuery.TableDataListOption.pageSize(10L)))
        .thenReturn(new TableResult(SCHEMA, ROWS.size(), page, null));
    Page<FieldValueList> dataPage = table.list(BigQuery.TableDataListOption.pageSize(10L));
    assertThat(dataPage.getValues()).containsExactlyElementsIn(ROWS).inOrder();

    dataPage = table.list(SCHEMA, BigQuery.TableDataListOption.pageSize(10L));
    assertThat(dataPage.getValues()).containsExactlyElementsIn(ROWS_WITH_SCHEMA).inOrder();
    verify(bigquery).listTableData(TABLE_ID1, BigQuery.TableDataListOption.pageSize(10L));
    verify(bigquery).listTableData(TABLE_ID1, SCHEMA, BigQuery.TableDataListOption.pageSize(10L));
  }

  @Test
  public void testCopyFromString() {
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(COPY_JOB_INFO));
    when(bigquery.create(COPY_JOB_INFO)).thenReturn(expectedJob);
    Job job = table.copy(TABLE_ID2.getDataset(), TABLE_ID2.getTable());
    assertSame(expectedJob, job);
    verify(bigquery).create(COPY_JOB_INFO);
  }

  @Test
  public void testCopyFromId() {
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(COPY_JOB_INFO));
    when(bigquery.create(COPY_JOB_INFO)).thenReturn(expectedJob);
    Job job = table.copy(TABLE_ID2.getDataset(), TABLE_ID2.getTable());
    assertSame(expectedJob, job);
    verify(bigquery).create(COPY_JOB_INFO);
  }

  @Test
  public void testLoadDataUri() {
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(LOAD_JOB_INFO));
    when(bigquery.create(LOAD_JOB_INFO)).thenReturn(expectedJob);
    Job job = table.load(FormatOptions.json(), "URI");
    assertSame(expectedJob, job);
    verify(bigquery).create(LOAD_JOB_INFO);
  }

  @Test
  public void testLoadDataUris() {
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(LOAD_JOB_INFO));
    when(bigquery.create(LOAD_JOB_INFO)).thenReturn(expectedJob);
    Job job = table.load(FormatOptions.json(), ImmutableList.of("URI"));
    assertSame(expectedJob, job);
    verify(bigquery).create(LOAD_JOB_INFO);
  }

  @Test
  public void testExtractDataUri() {
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(EXTRACT_JOB_INFO));
    when(bigquery.create(EXTRACT_JOB_INFO)).thenReturn(expectedJob);
    Job job = table.extract("CSV", "URI");
    assertSame(expectedJob, job);
    verify(bigquery).create(EXTRACT_JOB_INFO);
  }

  @Test
  public void testExtractDataUris() {
    Job expectedJob = new Job(bigquery, new JobInfo.BuilderImpl(EXTRACT_JOB_INFO));
    when(bigquery.create(EXTRACT_JOB_INFO)).thenReturn(expectedJob);
    Job job = table.extract("CSV", ImmutableList.of("URI"));
    assertSame(expectedJob, job);
    verify(bigquery).create(EXTRACT_JOB_INFO);
  }

  @Test
  public void testBigQuery() {
    assertSame(bigquery, expectedTable.getBigQuery());
  }

  @Test
  public void testToAndFromPb() {
    compareTable(expectedTable, Table.fromPb(bigquery, expectedTable.toPb()));
  }

  private void compareTable(Table expected, Table value) {
    assertEquals(expected, value);
    compareTableInfo(expected, value);
    assertEquals(expected.getBigQuery().getOptions(), value.getBigQuery().getOptions());
  }

  private void compareTableInfo(TableInfo expected, TableInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getTableId(), value.getTableId());
    assertEquals(expected.getDefinition(), value.getDefinition());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getExpirationTime(), value.getExpirationTime());
    assertEquals(expected.getFriendlyName(), value.getFriendlyName());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getLastModifiedTime(), value.getLastModifiedTime());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getDefinition(), value.getDefinition());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

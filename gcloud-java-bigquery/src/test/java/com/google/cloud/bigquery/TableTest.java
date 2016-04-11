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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.bigquery.InsertAllRequest.RowToInsert;

import org.junit.After;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class TableTest {

  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "project:dataset:table1";
  private static final String SELF_LINK = "selfLink";
  private static final String FRIENDLY_NAME = "friendlyName";
  private static final String DESCRIPTION = "description";
  private static final Long CREATION_TIME = 10L;
  private static final Long EXPIRATION_TIME = 100L;
  private static final Long LAST_MODIFIED_TIME = 20L;
  private static final TableId TABLE_ID1 = TableId.of("dataset", "table1");
  private static final TableId TABLE_ID2 = TableId.of("dataset", "table2");
  private static final CopyJobConfiguration COPY_JOB_CONFIGURATION =
      CopyJobConfiguration.of(TABLE_ID2, TABLE_ID1);
  private static final JobInfo COPY_JOB_INFO = JobInfo.of(COPY_JOB_CONFIGURATION);
  private static final JobInfo LOAD_JOB_INFO =
      JobInfo.of(LoadJobConfiguration.of(TABLE_ID1, ImmutableList.of("URI"), FormatOptions.json()));
  private static final JobInfo EXTRACT_JOB_INFO =
      JobInfo.of(ExtractJobConfiguration.of(TABLE_ID1, ImmutableList.of("URI"), "CSV"));
  private static final Field FIELD = Field.of("FieldName", Field.Type.integer());
  private static final TableDefinition TABLE_DEFINITION =
      StandardTableDefinition.of(Schema.of(FIELD));
  private static final TableInfo TABLE_INFO = TableInfo.of(TABLE_ID1, TABLE_DEFINITION);
  private static final List<RowToInsert> ROWS_TO_INSERT = ImmutableList.of(
      RowToInsert.of("id1", ImmutableMap.<String, Object>of("key", "val1")),
      RowToInsert.of("id2", ImmutableMap.<String, Object>of("key", "val2")));
  private static final InsertAllRequest INSERT_ALL_REQUEST =
      InsertAllRequest.of(TABLE_ID1, ROWS_TO_INSERT);
  private static final InsertAllRequest INSERT_ALL_REQUEST_COMPLETE =
      InsertAllRequest.builder(TABLE_ID1, ROWS_TO_INSERT)
          .skipInvalidRows(true)
          .ignoreUnknownValues(true)
          .build();
  private static final InsertAllResponse EMPTY_INSERT_ALL_RESPONSE =
      new InsertAllResponse(ImmutableMap.<Long, List<BigQueryError>>of());
  private static final FieldValue FIELD_VALUE1 =
      new FieldValue(FieldValue.Attribute.PRIMITIVE, "val1");
  private static final FieldValue FIELD_VALUE2 =
      new FieldValue(FieldValue.Attribute.PRIMITIVE, "val1");
  private static final Iterable<List<FieldValue>> ROWS = ImmutableList.of(
      (List<FieldValue>) ImmutableList.of(FIELD_VALUE1), ImmutableList.of(FIELD_VALUE2));

  private BigQuery serviceMockReturnsOptions = createStrictMock(BigQuery.class);
  private BigQueryOptions mockOptions = createMock(BigQueryOptions.class);
  private BigQuery bigquery;
  private Table expectedTable;
  private Table table;

  private void initializeExpectedTable(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    bigquery = createStrictMock(BigQuery.class);
    expectedTable = new Table(serviceMockReturnsOptions, new TableInfo.BuilderImpl(TABLE_INFO));
  }

  private void initializeTable() {
    table = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(bigquery, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedTable(2);
    replay(bigquery);
    Table builtTable = new Table.Builder(serviceMockReturnsOptions, TABLE_ID1, TABLE_DEFINITION)
        .creationTime(CREATION_TIME)
        .description(DESCRIPTION)
        .etag(ETAG)
        .expirationTime(EXPIRATION_TIME)
        .friendlyName(FRIENDLY_NAME)
        .generatedId(GENERATED_ID)
        .lastModifiedTime(LAST_MODIFIED_TIME)
        .selfLink(SELF_LINK)
        .build();
    assertEquals(TABLE_ID1, builtTable.tableId());
    assertEquals(CREATION_TIME, builtTable.creationTime());
    assertEquals(DESCRIPTION, builtTable.description());
    assertEquals(ETAG, builtTable.etag());
    assertEquals(EXPIRATION_TIME, builtTable.expirationTime());
    assertEquals(FRIENDLY_NAME, builtTable.friendlyName());
    assertEquals(GENERATED_ID, builtTable.generatedId());
    assertEquals(LAST_MODIFIED_TIME, builtTable.lastModifiedTime());
    assertEquals(TABLE_DEFINITION, builtTable.definition());
    assertEquals(SELF_LINK, builtTable.selfLink());
    assertSame(serviceMockReturnsOptions, builtTable.bigquery());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedTable(4);
    replay(bigquery);
    compareTable(expectedTable, expectedTable.toBuilder().build());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedTable(1);
    BigQuery.TableOption[] expectedOptions = {BigQuery.TableOption.fields()};
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO.tableId(), expectedOptions)).andReturn(expectedTable);
    replay(bigquery);
    initializeTable();
    assertTrue(table.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedTable(1);
    BigQuery.TableOption[] expectedOptions = {BigQuery.TableOption.fields()};
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO.tableId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeTable();
    assertFalse(table.exists());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedTable(4);
    TableInfo updatedInfo = TABLE_INFO.toBuilder().description("Description").build();
    Table expectedTable =
        new Table(serviceMockReturnsOptions, new TableInfo.BuilderImpl(updatedInfo));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(expectedTable);
    replay(bigquery);
    initializeTable();
    Table updatedTable = table.reload();
    compareTable(expectedTable, updatedTable);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedTable(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(null);
    replay(bigquery);
    initializeTable();
    assertNull(table.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedTable(4);
    TableInfo updatedInfo = TABLE_INFO.toBuilder().description("Description").build();
    Table expectedTable =
        new Table(serviceMockReturnsOptions, new TableInfo.BuilderImpl(updatedInfo));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO.tableId(), BigQuery.TableOption.fields()))
        .andReturn(expectedTable);
    replay(bigquery);
    initializeTable();
    Table updatedTable = table.reload(BigQuery.TableOption.fields());
    compareTable(expectedTable, updatedTable);
  }

  @Test
  public void testUpdate() {
    initializeExpectedTable(4);
    Table expectedUpdatedTable = expectedTable.toBuilder().description("Description").build();
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedTable))).andReturn(expectedUpdatedTable);
    replay(bigquery);
    initializeTable();
    Table actualUpdatedTable = table.update();
    compareTable(expectedUpdatedTable, actualUpdatedTable);
  }

  @Test
  public void testUpdateWithOptions() {
    initializeExpectedTable(4);
    Table expectedUpdatedTable = expectedTable.toBuilder().description("Description").build();
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedTable), eq(BigQuery.TableOption.fields())))
        .andReturn(expectedUpdatedTable);
    replay(bigquery);
    initializeTable();
    Table actualUpdatedTable = table.update(BigQuery.TableOption.fields());
    compareTable(expectedUpdatedTable, actualUpdatedTable);
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedTable(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.delete(TABLE_INFO.tableId())).andReturn(true);
    replay(bigquery);
    initializeTable();
    assertTrue(table.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedTable(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.delete(TABLE_INFO.tableId())).andReturn(false);
    replay(bigquery);
    initializeTable();
    assertFalse(table.delete());
  }

  @Test
  public void testInsert() throws Exception {
    initializeExpectedTable(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.insertAll(INSERT_ALL_REQUEST)).andReturn(EMPTY_INSERT_ALL_RESPONSE);
    replay(bigquery);
    initializeTable();
    InsertAllResponse response = table.insert(ROWS_TO_INSERT);
    assertSame(EMPTY_INSERT_ALL_RESPONSE, response);
  }

  @Test
  public void testInsertComplete() throws Exception {
    initializeExpectedTable(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.insertAll(INSERT_ALL_REQUEST_COMPLETE)).andReturn(EMPTY_INSERT_ALL_RESPONSE);
    replay(bigquery);
    initializeTable();
    InsertAllResponse response = table.insert(ROWS_TO_INSERT, true, true);
    assertSame(EMPTY_INSERT_ALL_RESPONSE, response);
  }

  @Test
  public void testList() throws Exception {
    initializeExpectedTable(1);
    expect(bigquery.options()).andReturn(mockOptions);
    PageImpl<List<FieldValue>> tableDataPage = new PageImpl<>(null, "c", ROWS);
    expect(bigquery.listTableData(TABLE_ID1)).andReturn(tableDataPage);
    replay(bigquery);
    initializeTable();
    Page<List<FieldValue>> dataPage = table.list();
    Iterator<List<FieldValue>> tableDataIterator = tableDataPage.values().iterator();
    Iterator<List<FieldValue>> dataIterator = dataPage.values().iterator();
    assertTrue(Iterators.elementsEqual(tableDataIterator, dataIterator));
  }

  @Test
  public void testListWithOptions() throws Exception {
    initializeExpectedTable(1);
    expect(bigquery.options()).andReturn(mockOptions);
    PageImpl<List<FieldValue>> tableDataPage = new PageImpl<>(null, "c", ROWS);
    expect(bigquery.listTableData(TABLE_ID1, BigQuery.TableDataListOption.pageSize(10L)))
        .andReturn(tableDataPage);
    replay(bigquery);
    initializeTable();
    Page<List<FieldValue>> dataPage = table.list(BigQuery.TableDataListOption.pageSize(10L));
    Iterator<List<FieldValue>> tableDataIterator = tableDataPage.values().iterator();
    Iterator<List<FieldValue>> dataIterator = dataPage.values().iterator();
    assertTrue(Iterators.elementsEqual(tableDataIterator, dataIterator));
  }

  @Test
  public void testCopyFromString() throws Exception {
    initializeExpectedTable(2);
    expect(bigquery.options()).andReturn(mockOptions);
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(COPY_JOB_INFO));
    expect(bigquery.create(COPY_JOB_INFO))
        .andReturn(expectedJob);
    replay(bigquery);
    initializeTable();
    Job job = table.copy(TABLE_ID2.dataset(), TABLE_ID2.table());
    assertSame(expectedJob, job);
  }

  @Test
  public void testCopyFromId() throws Exception {
    initializeExpectedTable(2);
    expect(bigquery.options()).andReturn(mockOptions);
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(COPY_JOB_INFO));
    expect(bigquery.create(COPY_JOB_INFO)).andReturn(expectedJob);
    replay(bigquery);
    initializeTable();
    Job job = table.copy(TABLE_ID2.dataset(), TABLE_ID2.table());
    assertSame(expectedJob, job);
  }

  @Test
  public void testLoadDataUri() throws Exception {
    initializeExpectedTable(2);
    expect(bigquery.options()).andReturn(mockOptions);
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(LOAD_JOB_INFO));
    expect(bigquery.create(LOAD_JOB_INFO)).andReturn(expectedJob);
    replay(bigquery);
    initializeTable();
    Job job = table.load(FormatOptions.json(), "URI");
    assertSame(expectedJob, job);
  }

  @Test
  public void testLoadDataUris() throws Exception {
    initializeExpectedTable(2);
    expect(bigquery.options()).andReturn(mockOptions);
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(LOAD_JOB_INFO));
    expect(bigquery.create(LOAD_JOB_INFO)).andReturn(expectedJob);
    replay(bigquery);
    initializeTable();
    Job job = table.load(FormatOptions.json(), ImmutableList.of("URI"));
    assertSame(expectedJob, job);
  }

  @Test
  public void testExtractDataUri() throws Exception {
    initializeExpectedTable(2);
    expect(bigquery.options()).andReturn(mockOptions);
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(EXTRACT_JOB_INFO));
    expect(bigquery.create(EXTRACT_JOB_INFO)).andReturn(expectedJob);
    replay(bigquery);
    initializeTable();
    Job job = table.extract("CSV", "URI");
    assertSame(expectedJob, job);
  }

  @Test
  public void testExtractDataUris() throws Exception {
    initializeExpectedTable(2);
    expect(bigquery.options()).andReturn(mockOptions);
    Job expectedJob = new Job(serviceMockReturnsOptions, new JobInfo.BuilderImpl(EXTRACT_JOB_INFO));
    expect(bigquery.create(EXTRACT_JOB_INFO)).andReturn(expectedJob);
    replay(bigquery);
    initializeTable();
    Job job = table.extract("CSV", ImmutableList.of("URI"));
    assertSame(expectedJob, job);
  }

  @Test
  public void testBigquery() {
    initializeExpectedTable(1);
    replay(bigquery);
    assertSame(serviceMockReturnsOptions, expectedTable.bigquery());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedTable(4);
    replay(bigquery);
    compareTable(expectedTable, Table.fromPb(serviceMockReturnsOptions, expectedTable.toPb()));
  }

  private void compareTable(Table expected, Table value) {
    assertEquals(expected, value);
    compareTableInfo(expected, value);
    assertEquals(expected.bigquery().options(), value.bigquery().options());
  }

  private void compareTableInfo(TableInfo expected, TableInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.tableId(), value.tableId());
    assertEquals(expected.definition(), value.definition());
    assertEquals(expected.creationTime(), value.creationTime());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.expirationTime(), value.expirationTime());
    assertEquals(expected.friendlyName(), value.friendlyName());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.lastModifiedTime(), value.lastModifiedTime());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.definition(), value.definition());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}

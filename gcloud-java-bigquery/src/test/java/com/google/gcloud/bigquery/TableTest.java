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

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.bigquery.InsertAllRequest.RowToInsert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.List;

public class TableTest {

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

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  private BigQuery bigquery;
  private Table table;

  @Before
  public void setUp() throws Exception {
    bigquery = createStrictMock(BigQuery.class);
    table = new Table(bigquery, TABLE_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(bigquery);
  }

  @Test
  public void testInfo() throws Exception {
    assertEquals(TABLE_INFO, table.info());
    replay(bigquery);
  }

  @Test
  public void testBigQuery() throws Exception {
    assertSame(bigquery, table.bigquery());
    replay(bigquery);
  }

  @Test
  public void testExists_True() throws Exception {
    BigQuery.TableOption[] expectedOptions = {BigQuery.TableOption.fields()};
    expect(bigquery.getTable(TABLE_INFO.tableId(), expectedOptions)).andReturn(TABLE_INFO);
    replay(bigquery);
    assertTrue(table.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    BigQuery.TableOption[] expectedOptions = {BigQuery.TableOption.fields()};
    expect(bigquery.getTable(TABLE_INFO.tableId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    assertFalse(table.exists());
  }

  @Test
  public void testReload() throws Exception {
    TableInfo updatedInfo = TABLE_INFO.toBuilder().description("Description").build();
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(updatedInfo);
    replay(bigquery);
    Table updatedTable = table.reload();
    assertSame(bigquery, updatedTable.bigquery());
    assertEquals(updatedInfo, updatedTable.info());
  }

  @Test
  public void testReloadNull() throws Exception {
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(null);
    replay(bigquery);
    assertNull(table.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    TableInfo updatedInfo = TABLE_INFO.toBuilder().description("Description").build();
    expect(bigquery.getTable(TABLE_INFO.tableId(), BigQuery.TableOption.fields()))
        .andReturn(updatedInfo);
    replay(bigquery);
    Table updatedTable = table.reload(BigQuery.TableOption.fields());
    assertSame(bigquery, updatedTable.bigquery());
    assertEquals(updatedInfo, updatedTable.info());
  }

  @Test
  public void testUpdate() throws Exception {
    TableInfo updatedInfo = TABLE_INFO.toBuilder().description("Description").build();
    expect(bigquery.update(updatedInfo)).andReturn(updatedInfo);
    replay(bigquery);
    Table updatedTable = table.update(updatedInfo);
    assertSame(bigquery, updatedTable.bigquery());
    assertEquals(updatedInfo, updatedTable.info());
  }

  @Test
  public void testUpdateWithDifferentId() throws Exception {
    TableInfo updatedInfo = TABLE_INFO.toBuilder()
        .tableId(TableId.of("dataset", "table3"))
        .description("Description")
        .build();
    replay(bigquery);
    thrown.expect(IllegalArgumentException.class);
    table.update(updatedInfo);
  }

  @Test
  public void testUpdateWithDifferentDatasetId() throws Exception {
    TableInfo updatedInfo = TABLE_INFO.toBuilder()
        .tableId(TableId.of("dataset1", "table1"))
        .description("Description")
        .build();
    replay(bigquery);
    thrown.expect(IllegalArgumentException.class);
    table.update(updatedInfo);
  }

  @Test
  public void testUpdateWithOptions() throws Exception {
    TableInfo updatedInfo = TABLE_INFO.toBuilder().description("Description").build();
    expect(bigquery.update(updatedInfo, BigQuery.TableOption.fields())).andReturn(updatedInfo);
    replay(bigquery);
    Table updatedTable = table.update(updatedInfo, BigQuery.TableOption.fields());
    assertSame(bigquery, updatedTable.bigquery());
    assertEquals(updatedInfo, updatedTable.info());
  }

  @Test
  public void testDelete() throws Exception {
    expect(bigquery.delete(TABLE_INFO.tableId())).andReturn(true);
    replay(bigquery);
    assertTrue(table.delete());
  }

  @Test
  public void testInsert() throws Exception {
    expect(bigquery.insertAll(INSERT_ALL_REQUEST)).andReturn(EMPTY_INSERT_ALL_RESPONSE);
    replay(bigquery);
    InsertAllResponse response = table.insert(ROWS_TO_INSERT);
    assertSame(EMPTY_INSERT_ALL_RESPONSE, response);
  }

  @Test
  public void testInsertComplete() throws Exception {
    expect(bigquery.insertAll(INSERT_ALL_REQUEST_COMPLETE)).andReturn(EMPTY_INSERT_ALL_RESPONSE);
    replay(bigquery);
    InsertAllResponse response = table.insert(ROWS_TO_INSERT, true, true);
    assertSame(EMPTY_INSERT_ALL_RESPONSE, response);
  }

  @Test
  public void testList() throws Exception {
    PageImpl<List<FieldValue>> tableDataPage = new PageImpl<>(null, "c", ROWS);
    expect(bigquery.listTableData(TABLE_ID1)).andReturn(tableDataPage);
    replay(bigquery);
    Page<List<FieldValue>> dataPage = table.list();
    Iterator<List<FieldValue>> tableDataIterator = tableDataPage.values().iterator();
    Iterator<List<FieldValue>> dataIterator = dataPage.values().iterator();
    assertTrue(Iterators.elementsEqual(tableDataIterator, dataIterator));
  }

  @Test
  public void testListWithOptions() throws Exception {
    PageImpl<List<FieldValue>> tableDataPage = new PageImpl<>(null, "c", ROWS);
    expect(bigquery.listTableData(TABLE_ID1, BigQuery.TableDataListOption.maxResults(10L)))
        .andReturn(tableDataPage);
    replay(bigquery);
    Page<List<FieldValue>> dataPage = table.list(BigQuery.TableDataListOption.maxResults(10L));
    Iterator<List<FieldValue>> tableDataIterator = tableDataPage.values().iterator();
    Iterator<List<FieldValue>> dataIterator = dataPage.values().iterator();
    assertTrue(Iterators.elementsEqual(tableDataIterator, dataIterator));
  }

  @Test
  public void testCopyFromString() throws Exception {
    expect(bigquery.create(COPY_JOB_INFO)).andReturn(COPY_JOB_INFO);
    replay(bigquery);
    Job job = table.copy(TABLE_ID2.dataset(), TABLE_ID2.table());
    assertSame(bigquery, job.bigquery());
    assertEquals(COPY_JOB_INFO, job.info());
  }

  @Test
  public void testCopyFromId() throws Exception {
    expect(bigquery.create(COPY_JOB_INFO)).andReturn(COPY_JOB_INFO);
    replay(bigquery);
    Job job = table.copy(TABLE_ID2);
    assertSame(bigquery, job.bigquery());
    assertEquals(COPY_JOB_INFO, job.info());
  }

  @Test
  public void testLoadDataUri() throws Exception {
    expect(bigquery.create(LOAD_JOB_INFO)).andReturn(LOAD_JOB_INFO);
    replay(bigquery);
    Job job = table.load(FormatOptions.json(), "URI");
    assertSame(bigquery, job.bigquery());
    assertEquals(LOAD_JOB_INFO, job.info());
  }

  @Test
  public void testLoadDataUris() throws Exception {
    expect(bigquery.create(LOAD_JOB_INFO)).andReturn(LOAD_JOB_INFO);
    replay(bigquery);
    Job job = table.load(FormatOptions.json(), ImmutableList.of("URI"));
    assertSame(bigquery, job.bigquery());
    assertEquals(LOAD_JOB_INFO, job.info());
  }

  @Test
  public void testExtractDataUri() throws Exception {
    expect(bigquery.create(EXTRACT_JOB_INFO)).andReturn(EXTRACT_JOB_INFO);
    replay(bigquery);
    Job job = table.extract("CSV", "URI");
    assertSame(bigquery, job.bigquery());
    assertEquals(EXTRACT_JOB_INFO, job.info());
  }

  @Test
  public void testExtractDataUris() throws Exception {
    expect(bigquery.create(EXTRACT_JOB_INFO)).andReturn(EXTRACT_JOB_INFO);
    replay(bigquery);
    Job job = table.extract("CSV", ImmutableList.of("URI"));
    assertSame(bigquery, job.bigquery());
    assertEquals(EXTRACT_JOB_INFO, job.info());
  }

  @Test
  public void testGetFromId() throws Exception {
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(TABLE_INFO);
    replay(bigquery);
    Table loadedTable = Table.get(bigquery, TABLE_INFO.tableId());
    assertNotNull(loadedTable);
    assertEquals(TABLE_INFO, loadedTable.info());
  }

  @Test
  public void testGetFromStrings() throws Exception {
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(TABLE_INFO);
    replay(bigquery);
    Table loadedTable = Table.get(bigquery, TABLE_ID1.dataset(), TABLE_ID1.table());
    assertNotNull(loadedTable);
    assertEquals(TABLE_INFO, loadedTable.info());
  }

  @Test
  public void testGetFromIdNull() throws Exception {
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(null);
    replay(bigquery);
    assertNull(Table.get(bigquery, TABLE_INFO.tableId()));
  }

  @Test
  public void testGetFromStringsNull() throws Exception {
    expect(bigquery.getTable(TABLE_INFO.tableId())).andReturn(null);
    replay(bigquery);
    assertNull(Table.get(bigquery, TABLE_ID1.dataset(), TABLE_ID1.table()));
  }

  @Test
  public void testGetFromIdWithOptions() throws Exception {
    expect(bigquery.getTable(TABLE_INFO.tableId(), BigQuery.TableOption.fields()))
        .andReturn(TABLE_INFO);
    replay(bigquery);
    Table loadedTable = Table.get(bigquery, TABLE_INFO.tableId(), BigQuery.TableOption.fields());
    assertNotNull(loadedTable);
    assertEquals(TABLE_INFO, loadedTable.info());
  }

  @Test
  public void testGetFromStringsWithOptions() throws Exception {
    expect(bigquery.getTable(TABLE_INFO.tableId(), BigQuery.TableOption.fields()))
        .andReturn(TABLE_INFO);
    replay(bigquery);
    Table loadedTable =
        Table.get(bigquery, TABLE_ID1.dataset(), TABLE_ID1.table(), BigQuery.TableOption.fields());
    assertNotNull(loadedTable);
    assertEquals(TABLE_INFO, loadedTable.info());
  }
}

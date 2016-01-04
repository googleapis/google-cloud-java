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
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class DatasetTest {

  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final DatasetInfo DATASET_INFO = DatasetInfo.builder(DATASET_ID).build();
  private static final Field FIELD = Field.of("FieldName", Field.Type.integer());
  private static final Iterable<BaseTableInfo> TABLE_INFO_RESULTS = ImmutableList.of(
      TableInfo.builder(TableId.of("dataset", "table1"), Schema.of(FIELD)).build(),
      ViewInfo.builder(TableId.of("dataset", "table2"), "QUERY").build(),
      ExternalTableInfo.builder(TableId.of("dataset", "table2"),
          ExternalDataConfiguration.of(ImmutableList.of("URI"), Schema.of(), FormatOptions.csv()))
          .build());

  private BigQuery bigquery;
  private Dataset dataset;

  @Before
  public void setUp() throws Exception {
    bigquery = createStrictMock(BigQuery.class);
    dataset = new Dataset(bigquery, DATASET_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(bigquery);
  }

  @Test
  public void testInfo() throws Exception {
    assertEquals(DATASET_INFO, dataset.info());
    replay(bigquery);
  }

  @Test
  public void testExists_True() throws Exception {
    BigQuery.DatasetOption[] expectedOptions = {BigQuery.DatasetOption.fields()};
    expect(bigquery.getDataset(DATASET_ID, expectedOptions)).andReturn(DATASET_INFO);
    replay(bigquery);
    assertTrue(dataset.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    BigQuery.DatasetOption[] expectedOptions = {BigQuery.DatasetOption.fields()};
    expect(bigquery.getDataset(DATASET_ID, expectedOptions)).andReturn(null);
    replay(bigquery);
    assertFalse(dataset.exists());
  }

  @Test
  public void testReload() throws Exception {
    DatasetInfo updatedInfo = DATASET_INFO.toBuilder().description("Description").build();
    expect(bigquery.getDataset(DATASET_ID.dataset())).andReturn(updatedInfo);
    replay(bigquery);
    Dataset updatedDataset = dataset.reload();
    assertSame(bigquery, updatedDataset.bigquery());
    assertEquals(updatedInfo, updatedDataset.info());
  }

  @Test
  public void testReloadNull() throws Exception {
    expect(bigquery.getDataset(DATASET_ID.dataset())).andReturn(null);
    replay(bigquery);
    assertNull(dataset.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    DatasetInfo updatedInfo = DATASET_INFO.toBuilder().description("Description").build();
    expect(bigquery.getDataset(DATASET_ID.dataset(), BigQuery.DatasetOption.fields()))
        .andReturn(updatedInfo);
    replay(bigquery);
    Dataset updatedDataset = dataset.reload(BigQuery.DatasetOption.fields());
    assertSame(bigquery, updatedDataset.bigquery());
    assertEquals(updatedInfo, updatedDataset.info());
  }

  @Test
  public void testUpdate() throws Exception {
    DatasetInfo updatedInfo = DATASET_INFO.toBuilder().description("Description").build();
    expect(bigquery.update(updatedInfo)).andReturn(updatedInfo);
    replay(bigquery);
    Dataset updatedDataset = dataset.update(updatedInfo);
    assertSame(bigquery, dataset.bigquery());
    assertEquals(updatedInfo, updatedDataset.info());
  }

  @Test
  public void testDelete() throws Exception {
    expect(bigquery.delete(DATASET_INFO.datasetId())).andReturn(true);
    replay(bigquery);
    assertTrue(dataset.delete());
  }

  @Test
  public void testList() throws Exception {
    BigQueryOptions bigqueryOptions = createStrictMock(BigQueryOptions.class);
    PageImpl<BaseTableInfo> tableInfoPage = new PageImpl<>(null, "c", TABLE_INFO_RESULTS);
    expect(bigquery.listTables(DATASET_INFO.datasetId())).andReturn(tableInfoPage);
    expect(bigquery.options()).andReturn(bigqueryOptions);
    expect(bigqueryOptions.service()).andReturn(bigquery);
    replay(bigquery, bigqueryOptions);
    Page<Table> tablePage = dataset.list();
    Iterator<BaseTableInfo> tableInfoIterator = tableInfoPage.values().iterator();
    Iterator<Table> tableIterator = tablePage.values().iterator();
    while (tableInfoIterator.hasNext() && tableIterator.hasNext()) {
      assertEquals(tableInfoIterator.next(), tableIterator.next().info());
    }
    assertFalse(tableInfoIterator.hasNext());
    assertFalse(tableIterator.hasNext());
    assertEquals(tableInfoPage.nextPageCursor(), tablePage.nextPageCursor());
    verify(bigqueryOptions);
  }

  @Test
  public void testGet() throws Exception {
    BaseTableInfo info = TableInfo.builder(TableId.of("dataset", "table1"), Schema.of()).build();
    expect(bigquery.getTable(TableId.of("dataset", "table1"))).andReturn(info);
    replay(bigquery);
    Table table = dataset.get("table1");
    assertNotNull(table);
    assertEquals(info, table.info());
  }

  @Test
  public void testGetNull() throws Exception {
    expect(bigquery.getTable(TableId.of("dataset", "table1"))).andReturn(null);
    replay(bigquery);
    assertNull(dataset.get("table1"));
  }

  @Test
  public void testCreateTable() throws Exception {
    TableInfo info = TableInfo.builder(TableId.of("dataset", "table1"), Schema.of(FIELD)).build();
    expect(bigquery.create(info)).andReturn(info);
    replay(bigquery);
    Table table = dataset.create("table1", Schema.of(FIELD));
    assertEquals(info, table.info());
  }

  @Test
  public void testCreateView() throws Exception {
    ViewInfo info = ViewInfo.builder(TableId.of("dataset", "table2"), "QUERY").build();
    expect(bigquery.create(info)).andReturn(info);
    replay(bigquery);
    Table table = dataset.create("table2", "QUERY");
    assertEquals(info, table.info());
  }

  @Test
  public void testCreateExternalTable() throws Exception {
    ExternalTableInfo info = ExternalTableInfo.builder(TableId.of("dataset", "table3"),
        ExternalDataConfiguration.of(ImmutableList.of("URI"), Schema.of(), FormatOptions.csv()))
        .build();
    expect(bigquery.create(info)).andReturn(info);
    replay(bigquery);
    Table table = dataset.create("table3", ExternalDataConfiguration.of(
        ImmutableList.of("URI"), Schema.of(), FormatOptions.csv()));
    assertEquals(info, table.info());
  }

  @Test
  public void testLoad() throws Exception {
    expect(bigquery.getDataset(DATASET_INFO.datasetId().dataset())).andReturn(DATASET_INFO);
    replay(bigquery);
    Dataset loadedDataset = Dataset.load(bigquery, DATASET_INFO.datasetId().dataset());
    assertNotNull(loadedDataset);
    assertEquals(DATASET_INFO, loadedDataset.info());
  }

  @Test
  public void testLoadNull() throws Exception {
    expect(bigquery.getDataset(DATASET_INFO.datasetId().dataset())).andReturn(null);
    replay(bigquery);
    assertNull(Dataset.load(bigquery, DATASET_INFO.datasetId().dataset()));
  }

  @Test
  public void testLoadWithOptions() throws Exception {
    expect(bigquery.getDataset(DATASET_INFO.datasetId().dataset(), BigQuery.DatasetOption.fields()))
        .andReturn(DATASET_INFO);
    replay(bigquery);
    Dataset loadedDataset = Dataset.load(bigquery, DATASET_INFO.datasetId().dataset(),
        BigQuery.DatasetOption.fields());
    assertNotNull(loadedDataset);
    assertEquals(DATASET_INFO, loadedDataset.info());
  }
}

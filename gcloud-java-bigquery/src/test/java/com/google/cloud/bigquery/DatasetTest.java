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
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.cloud.Page;
import com.google.cloud.PageImpl;

import org.junit.After;
import org.junit.Test;

import java.util.List;

public class DatasetTest {

  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final List<Acl> ACCESS_RULES = ImmutableList.of(
      Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
      Acl.of(new Acl.View(TableId.of("dataset", "table"))));
  private static final Long CREATION_TIME = System.currentTimeMillis();
  private static final Long DEFAULT_TABLE_EXPIRATION = CREATION_TIME + 100;
  private static final String DESCRIPTION = "description";
  private static final String ETAG = "0xFF00";
  private static final String FRIENDLY_NAME = "friendlyDataset";
  private static final String GENERATED_ID = "P/D:1";
  private static final Long LAST_MODIFIED = CREATION_TIME + 50;
  private static final String LOCATION = "";
  private static final String SELF_LINK = "http://bigquery/p/d";
  private static final DatasetInfo DATASET_INFO = DatasetInfo.builder(DATASET_ID).build();
  private static final Field FIELD = Field.of("FieldName", Field.Type.integer());
  private static final StandardTableDefinition TABLE_DEFINITION =
      StandardTableDefinition.of(Schema.of(FIELD));
  private static final ViewDefinition VIEW_DEFINITION = ViewDefinition.of("QUERY");
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.of(ImmutableList.of("URI"), Schema.of(), FormatOptions.csv());
  private static final TableInfo TABLE_INFO1 =
      TableInfo.builder(TableId.of("dataset", "table1"), TABLE_DEFINITION).build();
  private static final TableInfo TABLE_INFO2 =
      TableInfo.builder(TableId.of("dataset", "table2"), VIEW_DEFINITION).build();
  private static final TableInfo TABLE_INFO3 =
      TableInfo.builder(TableId.of("dataset", "table3"), EXTERNAL_TABLE_DEFINITION).build();

  private BigQuery serviceMockReturnsOptions = createStrictMock(BigQuery.class);
  private BigQueryOptions mockOptions = createMock(BigQueryOptions.class);
  private BigQuery bigquery;
  private Dataset expectedDataset;
  private Dataset dataset;

  private void initializeExpectedDataset(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    bigquery = createStrictMock(BigQuery.class);
    expectedDataset = new Dataset(serviceMockReturnsOptions, new Dataset.BuilderImpl(DATASET_INFO));
  }

  private void initializeDataset() {
    dataset = new Dataset(bigquery, new Dataset.BuilderImpl(DATASET_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(bigquery, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedDataset(2);
    replay(bigquery);
    Dataset builtDataset = new Dataset.Builder(serviceMockReturnsOptions, DATASET_ID)
        .acl(ACCESS_RULES)
        .creationTime(CREATION_TIME)
        .defaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
        .description(DESCRIPTION)
        .etag(ETAG)
        .friendlyName(FRIENDLY_NAME)
        .generatedId(GENERATED_ID)
        .lastModified(LAST_MODIFIED)
        .location(LOCATION)
        .selfLink(SELF_LINK)
        .build();
    assertEquals(DATASET_ID, builtDataset.datasetId());
    assertEquals(ACCESS_RULES, builtDataset.acl());
    assertEquals(CREATION_TIME, builtDataset.creationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, builtDataset.defaultTableLifetime());
    assertEquals(DESCRIPTION, builtDataset.description());
    assertEquals(ETAG, builtDataset.etag());
    assertEquals(FRIENDLY_NAME, builtDataset.friendlyName());
    assertEquals(GENERATED_ID, builtDataset.generatedId());
    assertEquals(LAST_MODIFIED, builtDataset.lastModified());
    assertEquals(LOCATION, builtDataset.location());
    assertEquals(SELF_LINK, builtDataset.selfLink());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedDataset(4);
    replay(bigquery);
    compareDataset(expectedDataset, expectedDataset.toBuilder().build());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedDataset(1);
    BigQuery.DatasetOption[] expectedOptions = {BigQuery.DatasetOption.fields()};
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getDataset(DATASET_INFO.datasetId(), expectedOptions))
        .andReturn(expectedDataset);
    replay(bigquery);
    initializeDataset();
    assertTrue(dataset.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedDataset(1);
    BigQuery.DatasetOption[] expectedOptions = {BigQuery.DatasetOption.fields()};
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getDataset(DATASET_INFO.datasetId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeDataset();
    assertFalse(dataset.exists());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedDataset(4);
    DatasetInfo updatedInfo = DATASET_INFO.toBuilder().description("Description").build();
    Dataset expectedDataset =
        new Dataset(serviceMockReturnsOptions, new DatasetInfo.BuilderImpl(updatedInfo));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getDataset(DATASET_INFO.datasetId().dataset())).andReturn(expectedDataset);
    replay(bigquery);
    initializeDataset();
    Dataset updatedDataset = dataset.reload();
    compareDataset(expectedDataset, updatedDataset);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedDataset(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getDataset(DATASET_INFO.datasetId().dataset())).andReturn(null);
    replay(bigquery);
    initializeDataset();
    assertNull(dataset.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedDataset(4);
    DatasetInfo updatedInfo = DATASET_INFO.toBuilder().description("Description").build();
    Dataset expectedDataset =
        new Dataset(serviceMockReturnsOptions, new DatasetInfo.BuilderImpl(updatedInfo));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getDataset(DATASET_INFO.datasetId().dataset(), BigQuery.DatasetOption.fields()))
        .andReturn(expectedDataset);
    replay(bigquery);
    initializeDataset();
    Dataset updatedDataset = dataset.reload(BigQuery.DatasetOption.fields());
    compareDataset(expectedDataset, updatedDataset);
  }

  @Test
  public void testUpdate() {
    initializeExpectedDataset(4);
    Dataset expectedUpdatedDataset = expectedDataset.toBuilder().description("Description").build();
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedDataset))).andReturn(expectedUpdatedDataset);
    replay(bigquery);
    initializeDataset();
    Dataset actualUpdatedDataset = dataset.update();
    compareDataset(expectedUpdatedDataset, actualUpdatedDataset);
  }

  @Test
  public void testUpdateWithOptions() {
    initializeExpectedDataset(4);
    Dataset expectedUpdatedDataset = expectedDataset.toBuilder().description("Description").build();
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedDataset), eq(BigQuery.DatasetOption.fields())))
        .andReturn(expectedUpdatedDataset);
    replay(bigquery);
    initializeDataset();
    Dataset actualUpdatedDataset = dataset.update(BigQuery.DatasetOption.fields());
    compareDataset(expectedUpdatedDataset, actualUpdatedDataset);
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedDataset(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.delete(DATASET_INFO.datasetId())).andReturn(true);
    replay(bigquery);
    initializeDataset();
    assertTrue(dataset.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedDataset(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.delete(DATASET_INFO.datasetId())).andReturn(false);
    replay(bigquery);
    initializeDataset();
    assertFalse(dataset.delete());
  }

  @Test
  public void testList() throws Exception {
    initializeExpectedDataset(4);
    List<Table> tableResults = ImmutableList.of(
        new Table(serviceMockReturnsOptions, new Table.BuilderImpl(TABLE_INFO1)),
        new Table(serviceMockReturnsOptions, new Table.BuilderImpl(TABLE_INFO2)),
        new Table(serviceMockReturnsOptions, new Table.BuilderImpl(TABLE_INFO3)));
    PageImpl<Table> expectedPage = new PageImpl<>(null, "c", tableResults);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.listTables(DATASET_INFO.datasetId())).andReturn(expectedPage);
    replay(bigquery);
    initializeDataset();
    Page<Table> tablePage = dataset.list();
    assertArrayEquals(tableResults.toArray(), Iterables.toArray(tablePage.values(), Table.class));
    assertEquals(expectedPage.nextPageCursor(), tablePage.nextPageCursor());
  }

  @Test
  public void testListWithOptions() throws Exception {
    initializeExpectedDataset(4);
    List<Table> tableResults = ImmutableList.of(
        new Table(serviceMockReturnsOptions, new Table.BuilderImpl(TABLE_INFO1)),
        new Table(serviceMockReturnsOptions, new Table.BuilderImpl(TABLE_INFO2)),
        new Table(serviceMockReturnsOptions, new Table.BuilderImpl(TABLE_INFO3)));
    PageImpl<Table> expectedPage = new PageImpl<>(null, "c", tableResults);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.listTables(DATASET_INFO.datasetId(), BigQuery.TableListOption.pageSize(10L)))
        .andReturn(expectedPage);
    replay(bigquery);
    initializeDataset();
    Page<Table> tablePage = dataset.list(BigQuery.TableListOption.pageSize(10L));
    assertArrayEquals(tableResults.toArray(), Iterables.toArray(tablePage.values(), Table.class));
    assertEquals(expectedPage.nextPageCursor(), tablePage.nextPageCursor());
  }

  @Test
  public void testGet() throws Exception {
    initializeExpectedDataset(2);
    Table expectedTable =
        new Table(serviceMockReturnsOptions, new TableInfo.BuilderImpl(TABLE_INFO1));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO1.tableId())).andReturn(expectedTable);
    replay(bigquery);
    initializeDataset();
    Table table = dataset.get(TABLE_INFO1.tableId().table());
    assertNotNull(table);
    assertEquals(expectedTable, table);
  }

  @Test
  public void testGetNull() throws Exception {
    initializeExpectedDataset(1);
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO1.tableId())).andReturn(null);
    replay(bigquery);
    initializeDataset();
    assertNull(dataset.get(TABLE_INFO1.tableId().table()));
  }

  @Test
  public void testGetWithOptions() throws Exception {
    initializeExpectedDataset(2);
    Table expectedTable =
        new Table(serviceMockReturnsOptions, new TableInfo.BuilderImpl(TABLE_INFO1));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.getTable(TABLE_INFO1.tableId(), BigQuery.TableOption.fields()))
        .andReturn(expectedTable);
    replay(bigquery);
    initializeDataset();
    Table table = dataset.get(TABLE_INFO1.tableId().table(), BigQuery.TableOption.fields());
    assertNotNull(table);
    assertEquals(expectedTable, table);
  }

  @Test
  public void testCreateTable() throws Exception {
    initializeExpectedDataset(2);
    Table expectedTable =
        new Table(serviceMockReturnsOptions, new TableInfo.BuilderImpl(TABLE_INFO1));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.create(TABLE_INFO1)).andReturn(expectedTable);
    replay(bigquery);
    initializeDataset();
    Table table = dataset.create(TABLE_INFO1.tableId().table(), TABLE_DEFINITION);
    assertEquals(expectedTable, table);
  }

  @Test
  public void testCreateTableWithOptions() throws Exception {
    initializeExpectedDataset(2);
    Table expectedTable =
        new Table(serviceMockReturnsOptions, new TableInfo.BuilderImpl(TABLE_INFO1));
    expect(bigquery.options()).andReturn(mockOptions);
    expect(bigquery.create(TABLE_INFO1, BigQuery.TableOption.fields())).andReturn(expectedTable);
    replay(bigquery);
    initializeDataset();
    Table table = dataset.create(TABLE_INFO1.tableId().table(), TABLE_DEFINITION,
        BigQuery.TableOption.fields());
    assertEquals(expectedTable, table);
  }

  @Test
  public void testBigquery() {
    initializeExpectedDataset(1);
    replay(bigquery);
    assertSame(serviceMockReturnsOptions, expectedDataset.bigquery());
  }

  @Test
  public void testToAndFromPb() {
    initializeExpectedDataset(4);
    replay(bigquery);
    compareDataset(expectedDataset,
        Dataset.fromPb(serviceMockReturnsOptions, expectedDataset.toPb()));
  }

  private void compareDataset(Dataset expected, Dataset value) {
    assertEquals(expected, value);
    compareDatasetInfo(expected, value);
    assertEquals(expected.bigquery().options(), value.bigquery().options());
  }

  private void compareDatasetInfo(DatasetInfo expected, DatasetInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.datasetId(), value.datasetId());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.friendlyName(), value.friendlyName());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.location(), value.location());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.acl(), value.acl());
    assertEquals(expected.creationTime(), value.creationTime());
    assertEquals(expected.defaultTableLifetime(), value.defaultTableLifetime());
    assertEquals(expected.lastModified(), value.lastModified());
  }
}

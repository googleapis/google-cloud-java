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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class DatasetTest {

  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final List<Acl> ACCESS_RULES =
      ImmutableList.of(
          Acl.of(Acl.Group.ofAllAuthenticatedUsers(), Acl.Role.READER),
          Acl.of(new Acl.View(TableId.of("dataset", "table"))),
          Acl.of(new Acl.Routine(RoutineId.of("dataset", "routine"))));
  private static final Map<String, String> LABELS =
      ImmutableMap.of(
          "example-label1", "example-value1",
          "example-label2", "example-value2");
  private static final Long CREATION_TIME = System.currentTimeMillis();
  private static final Long DEFAULT_TABLE_EXPIRATION = CREATION_TIME + 100;
  private static final String DESCRIPTION = "description";
  private static final String ETAG = "0xFF00";
  private static final String FRIENDLY_NAME = "friendlyDataset";
  private static final String GENERATED_ID = "P/D:1";
  private static final Long LAST_MODIFIED = CREATION_TIME + 50;
  private static final String LOCATION = "";
  private static final String SELF_LINK = "http://bigquery/p/d";
  private static final DatasetInfo DATASET_INFO = DatasetInfo.newBuilder(DATASET_ID).build();
  private static final Field FIELD = Field.of("FieldName", LegacySQLTypeName.INTEGER);
  private static final String STORAGE_BILLING_MODEL = "LOGICAL";
  private static final Long MAX_TIME_TRAVEL_HOURS = 168L;
  private static final Map<String, String> RESOURCE_TAGS =
      ImmutableMap.of(
          "example-key1", "example-value1",
          "example-key2", "example-value2");
  private static final StandardTableDefinition TABLE_DEFINITION =
      StandardTableDefinition.of(Schema.of(FIELD));
  private static final ViewDefinition VIEW_DEFINITION = ViewDefinition.of("QUERY");
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.of(ImmutableList.of("URI"), Schema.of(), FormatOptions.csv());
  private static final TableInfo TABLE_INFO1 =
      TableInfo.newBuilder(TableId.of("dataset", "table1"), TABLE_DEFINITION).build();
  private static final TableInfo TABLE_INFO2 =
      TableInfo.newBuilder(TableId.of("dataset", "table2"), VIEW_DEFINITION).build();
  private static final TableInfo TABLE_INFO3 =
      TableInfo.newBuilder(TableId.of("dataset", "table3"), EXTERNAL_TABLE_DEFINITION).build();
  private static final String NEW_PROJECT_ID = "projectId2";
  private static final TableId TABLE_ID1 = TableId.of(NEW_PROJECT_ID, "dataset", "table3");
  private static final TableInfo TABLE_INFO4 =
      TableInfo.newBuilder(
              TableId.of(NEW_PROJECT_ID, "dataset", "table3"), EXTERNAL_TABLE_DEFINITION)
          .build();
  private static final ExternalDatasetReference EXTERNAL_DATASET_REFERENCE =
      ExternalDatasetReference.newBuilder()
          .setExternalSource("source")
          .setConnection("connection")
          .build();

  @Rule public MockitoRule rule;

  private BigQuery bigquery;
  private BigQueryOptions mockOptions;
  private Dataset expectedDataset;
  private Dataset dataset;

  @Before
  public void setUp() {
    bigquery = mock(BigQuery.class);
    mockOptions = mock(BigQueryOptions.class);
    when(bigquery.getOptions()).thenReturn(mockOptions);
    expectedDataset = new Dataset(bigquery, new Dataset.BuilderImpl(DATASET_INFO));
    dataset = new Dataset(bigquery, new Dataset.BuilderImpl(DATASET_INFO));
  }

  @Test
  public void testBuilder() {
    Dataset builtDataset =
        new Dataset.Builder(bigquery, DATASET_ID)
            .setAcl(ACCESS_RULES)
            .setCreationTime(CREATION_TIME)
            .setDefaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
            .setDescription(DESCRIPTION)
            .setEtag(ETAG)
            .setFriendlyName(FRIENDLY_NAME)
            .setGeneratedId(GENERATED_ID)
            .setLastModified(LAST_MODIFIED)
            .setLocation(LOCATION)
            .setSelfLink(SELF_LINK)
            .setLabels(LABELS)
            .setStorageBillingModel(STORAGE_BILLING_MODEL)
            .setMaxTimeTravelHours(MAX_TIME_TRAVEL_HOURS)
            .setResourceTags(RESOURCE_TAGS)
            .build();
    assertEquals(DATASET_ID, builtDataset.getDatasetId());
    assertEquals(ACCESS_RULES, builtDataset.getAcl());
    assertEquals(CREATION_TIME, builtDataset.getCreationTime());
    assertEquals(DEFAULT_TABLE_EXPIRATION, builtDataset.getDefaultTableLifetime());
    assertEquals(DESCRIPTION, builtDataset.getDescription());
    assertEquals(ETAG, builtDataset.getEtag());
    assertEquals(FRIENDLY_NAME, builtDataset.getFriendlyName());
    assertEquals(GENERATED_ID, builtDataset.getGeneratedId());
    assertEquals(LAST_MODIFIED, builtDataset.getLastModified());
    assertEquals(LOCATION, builtDataset.getLocation());
    assertEquals(SELF_LINK, builtDataset.getSelfLink());
    assertEquals(LABELS, builtDataset.getLabels());
    assertEquals(STORAGE_BILLING_MODEL, builtDataset.getStorageBillingModel());
    assertEquals(MAX_TIME_TRAVEL_HOURS, builtDataset.getMaxTimeTravelHours());
    assertEquals(RESOURCE_TAGS, builtDataset.getResourceTags());
  }

  @Test
  public void testToBuilder() {
    compareDataset(expectedDataset, expectedDataset.toBuilder().build());
  }

  @Test
  public void testExists_True() {
    BigQuery.DatasetOption[] expectedOptions = {BigQuery.DatasetOption.fields()};
    when(bigquery.getDataset(DATASET_INFO.getDatasetId(), expectedOptions))
        .thenReturn(expectedDataset);
    assertTrue(dataset.exists());
    verify(bigquery).getDataset(DATASET_INFO.getDatasetId(), expectedOptions);
  }

  @Test
  public void testExists_False() {
    BigQuery.DatasetOption[] expectedOptions = {BigQuery.DatasetOption.fields()};
    when(bigquery.getDataset(DATASET_INFO.getDatasetId(), expectedOptions)).thenReturn(null);
    assertFalse(dataset.exists());
    verify(bigquery).getDataset(DATASET_INFO.getDatasetId(), expectedOptions);
  }

  @Test
  public void testReload() {
    DatasetInfo updatedInfo = DATASET_INFO.toBuilder().setDescription("Description").build();
    Dataset expectedDataset = new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedInfo));
    when(bigquery.getDataset(DATASET_INFO.getDatasetId().getDataset())).thenReturn(expectedDataset);
    Dataset updatedDataset = dataset.reload();
    compareDataset(expectedDataset, updatedDataset);
    verify(bigquery).getDataset(DATASET_INFO.getDatasetId().getDataset());
  }

  @Test
  public void testReloadNull() {
    when(bigquery.getDataset(DATASET_INFO.getDatasetId().getDataset())).thenReturn(null);
    assertNull(dataset.reload());
    verify(bigquery).getDataset(DATASET_INFO.getDatasetId().getDataset());
  }

  @Test
  public void testReloadWithOptions() {
    DatasetInfo updatedInfo = DATASET_INFO.toBuilder().setDescription("Description").build();
    Dataset expectedDataset = new Dataset(bigquery, new DatasetInfo.BuilderImpl(updatedInfo));
    when(bigquery.getDataset(
            DATASET_INFO.getDatasetId().getDataset(), BigQuery.DatasetOption.fields()))
        .thenReturn(expectedDataset);
    Dataset updatedDataset = dataset.reload(BigQuery.DatasetOption.fields());
    compareDataset(expectedDataset, updatedDataset);
    verify(bigquery)
        .getDataset(DATASET_INFO.getDatasetId().getDataset(), BigQuery.DatasetOption.fields());
  }

  @Test
  public void testUpdate() {
    Dataset expectedUpdatedDataset =
        expectedDataset.toBuilder().setDescription("Description").build();
    when(bigquery.update(eq(expectedDataset))).thenReturn(expectedUpdatedDataset);
    Dataset actualUpdatedDataset = dataset.update();
    compareDataset(expectedUpdatedDataset, actualUpdatedDataset);
    verify(bigquery).update(eq(expectedDataset));
  }

  @Test
  public void testUpdateWithOptions() {
    Dataset expectedUpdatedDataset =
        expectedDataset.toBuilder().setDescription("Description").build();
    when(bigquery.update(eq(expectedDataset), eq(BigQuery.DatasetOption.fields())))
        .thenReturn(expectedUpdatedDataset);
    Dataset actualUpdatedDataset = dataset.update(BigQuery.DatasetOption.fields());
    compareDataset(expectedUpdatedDataset, actualUpdatedDataset);
    verify(bigquery).update(eq(expectedDataset), eq(BigQuery.DatasetOption.fields()));
  }

  @Test
  public void testDeleteTrue() {
    when(bigquery.delete(DATASET_INFO.getDatasetId())).thenReturn(true);
    assertTrue(dataset.delete());
    verify(bigquery).delete(DATASET_INFO.getDatasetId());
  }

  @Test
  public void testDeleteFalse() {
    when(bigquery.delete(DATASET_INFO.getDatasetId())).thenReturn(false);
    assertFalse(dataset.delete());
    verify(bigquery).delete(DATASET_INFO.getDatasetId());
  }

  @Test
  public void testList() {
    List<Table> tableResults =
        ImmutableList.of(
            new Table(bigquery, new Table.BuilderImpl(TABLE_INFO1)),
            new Table(bigquery, new Table.BuilderImpl(TABLE_INFO2)),
            new Table(bigquery, new Table.BuilderImpl(TABLE_INFO3)));
    PageImpl<Table> expectedPage = new PageImpl<>(null, "c", tableResults);
    when(bigquery.listTables(DATASET_INFO.getDatasetId())).thenReturn(expectedPage);
    Page<Table> tablePage = dataset.list();
    assertArrayEquals(
        tableResults.toArray(), Iterables.toArray(tablePage.getValues(), Table.class));
    assertEquals(expectedPage.getNextPageToken(), tablePage.getNextPageToken());
    verify(bigquery).listTables(DATASET_INFO.getDatasetId());
  }

  @Test
  public void testListWithOptions() {
    List<Table> tableResults =
        ImmutableList.of(
            new Table(bigquery, new Table.BuilderImpl(TABLE_INFO1)),
            new Table(bigquery, new Table.BuilderImpl(TABLE_INFO2)),
            new Table(bigquery, new Table.BuilderImpl(TABLE_INFO3)));
    PageImpl<Table> expectedPage = new PageImpl<>(null, "c", tableResults);
    when(bigquery.listTables(DATASET_INFO.getDatasetId(), BigQuery.TableListOption.pageSize(10L)))
        .thenReturn(expectedPage);
    Page<Table> tablePage = dataset.list(BigQuery.TableListOption.pageSize(10L));
    assertArrayEquals(
        tableResults.toArray(), Iterables.toArray(tablePage.getValues(), Table.class));
    assertEquals(expectedPage.getNextPageToken(), tablePage.getNextPageToken());
    verify(bigquery)
        .listTables(DATASET_INFO.getDatasetId(), BigQuery.TableListOption.pageSize(10L));
  }

  @Test
  public void testGet() {
    Table expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO1));
    when(bigquery.getTable(TABLE_INFO1.getTableId())).thenReturn(expectedTable);
    Table table = dataset.get(TABLE_INFO1.getTableId().getTable());
    assertNotNull(table);
    assertEquals(expectedTable, table);
    verify(bigquery).getTable(TABLE_INFO1.getTableId());
  }

  @Test
  public void testGetTableWithNewProjectId() {
    Table expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO4));
    when(bigquery.getTable(TABLE_ID1, null)).thenReturn(expectedTable);
    Table table = bigquery.getTable(TABLE_ID1, null);
    assertNotNull(table);
    assertEquals(table.getTableId().getProject(), NEW_PROJECT_ID);
    verify(bigquery).getTable(TABLE_ID1, null);
  }

  @Test
  public void testGetNull() {
    when(bigquery.getTable(TABLE_INFO1.getTableId())).thenReturn(null);
    assertNull(dataset.get(TABLE_INFO1.getTableId().getTable()));
    verify(bigquery).getTable(TABLE_INFO1.getTableId());
  }

  @Test
  public void testGetWithOptions() {
    Table expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO1));
    when(bigquery.getTable(TABLE_INFO1.getTableId(), BigQuery.TableOption.fields()))
        .thenReturn(expectedTable);
    Table table = dataset.get(TABLE_INFO1.getTableId().getTable(), BigQuery.TableOption.fields());
    assertNotNull(table);
    assertEquals(expectedTable, table);
    verify(bigquery).getTable(TABLE_INFO1.getTableId(), BigQuery.TableOption.fields());
  }

  @Test
  public void testCreateTable() {
    Table expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO1));
    when(bigquery.create(TABLE_INFO1)).thenReturn(expectedTable);
    Table table = dataset.create(TABLE_INFO1.getTableId().getTable(), TABLE_DEFINITION);
    assertEquals(expectedTable, table);
    verify(bigquery).create(TABLE_INFO1);
  }

  @Test
  public void testCreateTableWithOptions() {
    Table expectedTable = new Table(bigquery, new TableInfo.BuilderImpl(TABLE_INFO1));
    when(bigquery.create(TABLE_INFO1, BigQuery.TableOption.fields())).thenReturn(expectedTable);
    Table table =
        dataset.create(
            TABLE_INFO1.getTableId().getTable(), TABLE_DEFINITION, BigQuery.TableOption.fields());
    assertEquals(expectedTable, table);
    verify(bigquery).create(TABLE_INFO1, BigQuery.TableOption.fields());
  }

  @Test
  public void testBigQuery() {
    assertSame(bigquery, expectedDataset.getBigQuery());
  }

  @Test
  public void testToAndFromPb() {
    compareDataset(expectedDataset, Dataset.fromPb(bigquery, expectedDataset.toPb()));
  }

  @Test
  public void testExternalDatasetReference() {
    Dataset datasetWithExternalDatasetReference =
        new Dataset.Builder(bigquery, DATASET_ID)
            .setAcl(ACCESS_RULES)
            .setCreationTime(CREATION_TIME)
            .setDefaultTableLifetime(DEFAULT_TABLE_EXPIRATION)
            .setDescription(DESCRIPTION)
            .setEtag(ETAG)
            .setFriendlyName(FRIENDLY_NAME)
            .setGeneratedId(GENERATED_ID)
            .setLastModified(LAST_MODIFIED)
            .setLocation(LOCATION)
            .setSelfLink(SELF_LINK)
            .setLabels(LABELS)
            .setExternalDatasetReference(EXTERNAL_DATASET_REFERENCE)
            .setStorageBillingModel(STORAGE_BILLING_MODEL)
            .setMaxTimeTravelHours(MAX_TIME_TRAVEL_HOURS)
            .setResourceTags(RESOURCE_TAGS)
            .build();
    assertEquals(
        EXTERNAL_DATASET_REFERENCE,
        datasetWithExternalDatasetReference.getExternalDatasetReference());
    compareDataset(
        datasetWithExternalDatasetReference,
        datasetWithExternalDatasetReference.toBuilder().build());
  }

  private void compareDataset(Dataset expected, Dataset value) {
    assertEquals(expected, value);
    compareDatasetInfo(expected, value);
    assertEquals(expected.getBigQuery().getOptions(), value.getBigQuery().getOptions());
  }

  private void compareDatasetInfo(DatasetInfo expected, DatasetInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getDatasetId(), value.getDatasetId());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getFriendlyName(), value.getFriendlyName());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getLocation(), value.getLocation());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getAcl(), value.getAcl());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getDefaultTableLifetime(), value.getDefaultTableLifetime());
    assertEquals(expected.getLastModified(), value.getLastModified());
    assertEquals(expected.getExternalDatasetReference(), value.getExternalDatasetReference());
    assertEquals(expected.getStorageBillingModel(), value.getStorageBillingModel());
    assertEquals(expected.getMaxTimeTravelHours(), value.getMaxTimeTravelHours());
    assertEquals(expected.getResourceTags(), value.getResourceTags());
  }
}

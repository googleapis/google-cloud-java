/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.examples.bigquery.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.Dataset.Builder;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

public class ITDatasetSnippets {

  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String NON_EXISTING_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static final String FRIENDLY_NAME = "some_friendly_name";

  private static BigQuery bigquery;
  private static Dataset nonExistingDataset;
  private static Dataset dataset;
  private static DatasetSnippets datasetSnippets;
  private static DatasetSnippets nonExistingDatasetSnippets;

  @BeforeClass
  public static void beforeClass() {
    bigquery = RemoteBigQueryHelper.create().getOptions().getService();
    dataset = bigquery.create(DatasetInfo.newBuilder(DATASET).build());
    nonExistingDataset = bigquery.create(DatasetInfo.newBuilder(NON_EXISTING_DATASET).build());
    nonExistingDataset.delete(DatasetDeleteOption.deleteContents());
  }

  @Before
  public void before() {
    datasetSnippets = new DatasetSnippets(dataset);
    nonExistingDatasetSnippets = new DatasetSnippets(nonExistingDataset);
  }

  @AfterClass
  public static void afterClass() {
    bigquery.delete(DATASET, DatasetDeleteOption.deleteContents());
  }

  @Test
  public void testExistsNonExistingDataset() {
    assertFalse(nonExistingDatasetSnippets.doesDatasetExist());
  }

  @Test
  public void testExists() {
    assertTrue(datasetSnippets.doesDatasetExist());
  }

  @Test
  public void testReloadNonExistingDataset() {
    assertNull(nonExistingDatasetSnippets.reloadDataset());
  }

  @Test
  public void testReload() {
    assertNull(dataset.getFriendlyName());

    Builder builder = dataset.toBuilder();
    builder.setFriendlyName(FRIENDLY_NAME);
    builder.build().update();

    Dataset reloadedDataset = datasetSnippets.reloadDataset();
    assertEquals(FRIENDLY_NAME, reloadedDataset.getFriendlyName());
  }

  @Test
  public void testUpdate() {
    assertNull(dataset.getFriendlyName());

    Dataset updatedDataset = datasetSnippets.updateDataset(FRIENDLY_NAME);
    assertEquals(FRIENDLY_NAME, updatedDataset.getFriendlyName());
  }

  @Test
  public void testDeleteNonExistingDataset() {
    assertFalse(nonExistingDatasetSnippets.deleteDataset());
  }

  @Test
  public void testDelete() {
    String datasetName = RemoteBigQueryHelper.generateDatasetName();
    DatasetInfo dataset = DatasetInfo.newBuilder(datasetName).build();
    DatasetSnippets datasetSnippets = new DatasetSnippets(bigquery.create(dataset));
    assertTrue(datasetSnippets.deleteDataset());
  }

  @Test
  public void testListTablesEmpty() {
    Page<Table> tables = datasetSnippets.list();
    assertFalse(tables.iterateAll().iterator().hasNext());
  }

  @Test
  public void testListTablesNotEmpty() {
    String expectedTableName = "test_table";

    dataset.create(expectedTableName, StandardTableDefinition.newBuilder().build());
    Page<Table> tables = datasetSnippets.list();
    Iterator<Table> iterator = tables.iterateAll().iterator();
    assertTrue(iterator.hasNext());

    Table actualTable = iterator.next();
    assertEquals(expectedTableName, actualTable.getTableId().getTable());
    assertFalse(iterator.hasNext());

    bigquery.delete(DATASET, expectedTableName);
  }

  @Test
  public void testGetTable() {
    String expectedTableName = "test_table";

    dataset.create(expectedTableName, StandardTableDefinition.newBuilder().build());
    Table actualTable = datasetSnippets.getTable(expectedTableName);

    assertNotNull(actualTable);
    assertEquals(expectedTableName, actualTable.getTableId().getTable());

    bigquery.delete(DATASET, expectedTableName);
  }

  @Test
  public void testCreateTable() {
    String expectedTableName = "test_table";
    String expectedFieldName = "test_field";

    Table actualTable = datasetSnippets.createTable(expectedTableName, expectedFieldName);
    assertNotNull(actualTable);
    assertEquals(expectedTableName, actualTable.getTableId().getTable());
    assertEquals(1, actualTable.getDefinition().getSchema().getFields().size());

    Field actualField = actualTable.getDefinition().getSchema().getFields().get(0);
    assertEquals(expectedFieldName, actualField.getName());

    bigquery.delete(DATASET, expectedTableName);
  }
}

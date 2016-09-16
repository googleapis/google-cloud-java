/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;   
import com.google.cloud.bigquery.Dataset.Builder;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

public class ITDatasetSnippets {
  private static final String datasetId = "dataset_snippets_integration_test";
  private static final String nonExistandDatasetId = "non_existant_dataset";
  private static final String friendlyName = "some_friendly_name";

  private static BigQuery bigquery;
  private static Dataset dataset;
  private static DatasetSnippets datasetSnippets;

  @BeforeClass
  public static void beforeClass() {
    bigquery = BigQueryOptions.defaultInstance().service();
  }

  @Before
  public void before() {
    dataset = bigquery.create(DatasetInfo.builder(datasetId).build());
    datasetSnippets = new DatasetSnippets(dataset);
  }

  @After
  public void after() {
    bigquery.delete(datasetId, BigQuery.DatasetDeleteOption.deleteContents());
  }

  @Test
  public void testDoesDataExistReturnsFalseWhenDatasetDoesntExist() {
    Dataset nonExistantDataset = bigquery.create(DatasetInfo.builder(nonExistandDatasetId).build());
    DatasetSnippets datasetSnippetsWithNonExistantDataset = new DatasetSnippets(nonExistantDataset);
    bigquery.delete(nonExistandDatasetId, BigQuery.DatasetDeleteOption.deleteContents());
    assertFalse(datasetSnippetsWithNonExistantDataset.doesDatasetExist());
  }

  @Test
  public void testDoesDataExistReturnsTrueWhenDatasetExists() {
    assertTrue(datasetSnippets.doesDatasetExist());
  }
  
  @Test
  public void testReloadDatasetReturnsNullWhenDatasetDoesntExist() {
    Dataset nonExistantDataset = bigquery.create(DatasetInfo.builder(nonExistandDatasetId).build());
    DatasetSnippets datasetSnippetsWithNonExistantDataset = new DatasetSnippets(nonExistantDataset);
    bigquery.delete(nonExistandDatasetId, BigQuery.DatasetDeleteOption.deleteContents());
    assertNull(datasetSnippetsWithNonExistantDataset.reloadDataset());
  }
  
  @Test
  public void testReloadDatasetReturnsTheReloadedDatasetWhenDatasetExists() {
    assertNull(dataset.friendlyName());
    
    Builder builder = dataset.toBuilder();
    builder.friendlyName(friendlyName);
    builder.build().update();
    
    Dataset reloadedDataset = datasetSnippets.reloadDataset();
    assertEquals(friendlyName, reloadedDataset.friendlyName());
  }
  
  @Test
  public void testUpdateDatasetReturnsTheUpdatedDatasetWhenDatasetExists() {
    assertNull(dataset.friendlyName());
    
    Dataset updatedDataset = datasetSnippets.updateDataset(friendlyName);
    assertEquals(friendlyName, updatedDataset.friendlyName());
  }
  
  @Test
  public void testDeleteDatasetReturnsFalseWhenDatasetDoesntExist() {
    Dataset nonExistantDataset = bigquery.create(DatasetInfo.builder(nonExistandDatasetId).build());
    DatasetSnippets datasetSnippetsWithNonExistantDataset = new DatasetSnippets(nonExistantDataset);
    bigquery.delete(nonExistandDatasetId, BigQuery.DatasetDeleteOption.deleteContents());
    assertFalse(datasetSnippetsWithNonExistantDataset.deleteDataset());
  }
  
  @Test
  public void testDeleteDatasetReturnsTrueWhenDatasetExists() {
    assertTrue(datasetSnippets.deleteDataset());
  }

  @Test
  public void testListTablesWhenEmpty() {
    Page<Table> tables = datasetSnippets.listDataset();
    assertFalse(tables.iterateAll().hasNext());
  }

  @Test
  public void testListTablesWhenNotEmpty() {
    String expectedTableName = "test_table";

    dataset.create(expectedTableName, StandardTableDefinition.builder().build());
    Page<Table> tables = datasetSnippets.listDataset();
    Iterator<Table> iterator = tables.iterateAll();
    assertTrue(iterator.hasNext());

    Table actualTable = iterator.next();
    assertTrue(actualTable.tableId().table().equals(expectedTableName));
    assertFalse(iterator.hasNext());
  }

  @Test
  public void testGetTable() {
    String expectedTableName = "test_table";

    dataset.create(expectedTableName, StandardTableDefinition.builder().build());
    Table actualTable = datasetSnippets.getTable(expectedTableName);

    Assert.assertNotNull(actualTable);
    Assert.assertEquals(expectedTableName, actualTable.tableId().table());
  }

  @Test
  public void testCreateTable() {
    String expectedTableName = "test_table";

    Table actualTable = datasetSnippets.createTable(expectedTableName);
    Assert.assertNotNull(actualTable);
    Assert.assertEquals(expectedTableName, actualTable.tableId().table());
  }

  @Test
  public void testCreateTableWithSchema() {
    String expectedTableName = "test_table";
    String expectedFieldName = "test_field";

    Table actualTable = datasetSnippets.createTable(expectedTableName, expectedFieldName);
    Assert.assertNotNull(actualTable);
    Assert.assertEquals(expectedTableName, actualTable.tableId().table());
    Assert.assertEquals(1, actualTable.definition().schema().fields().size());

    Field actualField = actualTable.definition().schema().fields().get(0);
    Assert.assertEquals(expectedFieldName, actualField.name());
  }
}

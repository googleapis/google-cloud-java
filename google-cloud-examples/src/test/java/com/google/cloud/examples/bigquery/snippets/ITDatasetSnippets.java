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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITDatasetSnippets {
  private static final String datasetId = "dataset_snippets_integration_test";
  private static final String nonExistandDatasetId = "non_existant_dataset";

  private static BigQuery bigquery;
  private static Dataset dataset;
  private static Dataset nonExistantDataset;
  private static DatasetSnippets datasetSnippets;
  private static DatasetSnippets datasetSnippetsWithNonExistantDataset;

  @BeforeClass
  public static void beforeClass() {
      bigquery = BigQueryOptions.defaultInstance().service();
  }

  @Before
  public void before() {
    dataset = bigquery.create(DatasetInfo.builder(datasetId).build());
    datasetSnippets = new DatasetSnippets(dataset);
    
    nonExistantDataset = bigquery.create(DatasetInfo.builder(nonExistandDatasetId).build());
    bigquery.delete(nonExistandDatasetId, BigQuery.DatasetDeleteOption.deleteContents());
    datasetSnippetsWithNonExistantDataset = new DatasetSnippets(nonExistantDataset);
  }

  @After
  public void after() {
    bigquery.delete(datasetId, BigQuery.DatasetDeleteOption.deleteContents());
  }

  @Test
  public void testExistsReturnsFalseWhenDatasetDoesntExist() {
    assertFalse(datasetSnippetsWithNonExistantDataset.doesDatasetExist());
  }

  @Test
  public void testExistsReturnsTrueWhenDatasetExists() {
    assertTrue(datasetSnippets.doesDatasetExist());
  }

}

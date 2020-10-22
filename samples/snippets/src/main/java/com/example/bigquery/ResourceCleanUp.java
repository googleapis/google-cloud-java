/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigquery;

import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetListOption;
import com.google.cloud.bigquery.BigQuery.ModelListOption;
import com.google.cloud.bigquery.BigQuery.TableListOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Model;
import com.google.cloud.bigquery.ModelId;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;

public class ResourceCleanUp {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String BIGQUERY_DATASET_NAME = System.getenv("BIGQUERY_DATASET_NAME");

  public static void main(String[] args) {
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

    // clean up stale test datasets
    Page<Dataset> datasets = bigquery.listDatasets(PROJECT_ID, DatasetListOption.pageSize(1000));
    for (Dataset dataset : datasets.getValues()) {
      String datasetName = dataset.getDatasetId().getDataset();
      if (datasetName.contains("CREATE_DATASET_AWS_TEST_")
          || datasetName.contains("MY_DATASET_NAME_TEST_")
          || datasetName.contains("gcloud_test_")
          || datasetName.contains("SHARED_DATASET_TEST_")) {
        System.out.format("\tDeleting Dataset: %s\n", datasetName);
        bigquery.delete(DatasetId.of(PROJECT_ID, datasetName));
      }
    }

    // clean up stale test tables in the test dataset
    Page<Table> tables =
        bigquery.listTables(BIGQUERY_DATASET_NAME, TableListOption.pageSize(10000));
    for (Table table : tables.getValues()) {
      String tableName = table.getTableId().getTable();
      if (tableName.contains("TestTable_")
          || tableName.contains("_TEST")
          || tableName.contains("MY_")
          || tableName.contains("gcloud_test_")) {
        System.out.format("\tDeleting Table: %s\n", tableName);
        bigquery.delete(TableId.of(PROJECT_ID, BIGQUERY_DATASET_NAME, tableName));
      }
    }

    // clean up stale test models in the test dataset
    Page<Model> models = bigquery.listModels(BIGQUERY_DATASET_NAME, ModelListOption.pageSize(1000));
    for (Model model : models.getValues()) {
      String modelName = model.getModelId().getModel();
      if (modelName.contains("MY_MODEL_NAME_")) {
        System.out.format("\tDeleting Model: %s\n", modelName);
        bigquery.delete(ModelId.of(PROJECT_ID, BIGQUERY_DATASET_NAME, modelName));
      }
    }

    System.out.println("*************** All done! Squeaky clean now :) ***************");
  }
}

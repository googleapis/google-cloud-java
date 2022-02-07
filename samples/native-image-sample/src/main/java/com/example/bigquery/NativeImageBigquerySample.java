/*
 * Copyright 2022 Google LLC
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
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Sample application demonstrating BigQuery operations.
 *
 * <p>Note: This application will create a BigQuery dataset in your GCP project. You can delete this
 * by viewing BigQuery in Cloud Console https://console.cloud.google.com/bigquery or by uncommenting
 * the call to `deleteDataset(..)` made in main().
 */
public class NativeImageBigquerySample {

  private static final String DATASET_ID = "nativeimage_test_dataset";

  private static final String TABLE_ID = "nativeimage_test_table";

  private static final Schema TABLE_SCHEMA =
      Schema.of(
          Field.of("id", StandardSQLTypeName.STRING), Field.of("age", StandardSQLTypeName.INT64));

  /** Entrypoint to the application. */
  public static void main(String[] args) throws InterruptedException {
    BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();

    if (!hasDataset(bigQuery, DATASET_ID)) {
      createDataset(bigQuery, DATASET_ID);
    }

    String tableName = TABLE_ID + "_" + UUID.randomUUID().toString().replace("-", "");
    createTable(bigQuery, DATASET_ID, tableName, TABLE_SCHEMA);
    String testId = "TestUser-" + UUID.randomUUID().toString();
    int testAge = 40;
    insertTestRecord(bigQuery, DATASET_ID, tableName, testId, testAge);
    queryTable(bigQuery, DATASET_ID, tableName);

    // Clean up resources.
    deleteTable(bigQuery, DATASET_ID, tableName);

    // Uncomment this to delete the created dataset.
    // deleteDataset(bigQuery, DATASET_ID);
  }

  static String queryTable(BigQuery bigQuery, String datasetName, String tableName)
      throws InterruptedException {
    String fullyQualifiedTable = datasetName + "." + tableName;
    String query = "SELECT * FROM " + fullyQualifiedTable;

    QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
    TableResult results = bigQuery.query(queryConfig);

    String result = "";
    System.out.println("Queried the following records: ");
    for (FieldValueList row : results.iterateAll()) {
      String rowStatement =
          String.format(
              "User id: %s | age: %d\n",
              row.get("id").getStringValue(), row.get("age").getLongValue());
      result += rowStatement;
      System.out.println(row);
    }
    return result;
  }

  static void insertTestRecord(
      BigQuery bigQuery, String datasetName, String tableName, String id, int age) {

    Map<String, Object> rowContent = new HashMap<>();
    rowContent.put("id", id);
    rowContent.put("age", age);

    InsertAllRequest request =
        InsertAllRequest.newBuilder(datasetName, tableName).addRow(rowContent).build();

    InsertAllResponse response = bigQuery.insertAll(request);

    if (response.hasErrors()) {
      System.out.println("Insert resulted in errors:");
      for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
        System.out.println("Response error: \n" + entry.getValue());
      }
    } else {
      System.out.println("Successfully inserted test row.");
    }
  }

  static void createTable(BigQuery bigQuery, String datasetName, String tableName, Schema schema) {

    TableId tableId = TableId.of(datasetName, tableName);
    TableDefinition tableDefinition = StandardTableDefinition.of(schema);
    TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();
    bigQuery.create(tableInfo);
    System.out.println("Created new table: " + tableName);
  }

  static boolean hasTable(BigQuery bigQuery, String datasetName, String tableName) {

    Page<Table> tables = bigQuery.listTables(datasetName);
    for (Table table : tables.iterateAll()) {
      if (tableName.equals(table.getTableId().getTable())) {
        return true;
      }
    }
    return false;
  }

  static void createDataset(BigQuery bigQuery, String datasetName) {
    DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();
    Dataset newDataset = bigQuery.create(datasetInfo);
    System.out.println("Created new dataset: " + newDataset.getDatasetId().getDataset());
  }

  static boolean hasDataset(BigQuery bigQuery, String datasetName) {
    Page<Dataset> datasets = bigQuery.listDatasets();
    for (Dataset dataset : datasets.iterateAll()) {
      if (datasetName.equals(dataset.getDatasetId().getDataset())) {
        return true;
      }
    }
    return false;
  }

  static void deleteTable(BigQuery bigQuery, String datasetName, String tableName) {
    bigQuery.getTable(datasetName, tableName).delete();
    System.out.println("Deleted table: " + tableName);
  }

  static void deleteDataset(BigQuery bigQuery, String datasetName) {
    bigQuery.getDataset(datasetName).delete();
    System.out.println("Deleting dataset " + datasetName);
  }
}

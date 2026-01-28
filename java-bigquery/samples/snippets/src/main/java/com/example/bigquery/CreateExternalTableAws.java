/*
 * Copyright 2026 Google LLC
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

// [START bigquery_omni_create_external_table]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.CsvOptions;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;

// Sample to create an external aws table
public class CreateExternalTableAws {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String connectionId = "MY_CONNECTION_ID";
    String sourceUri = "s3://your-bucket-name/";
    CsvOptions options = CsvOptions.newBuilder().setSkipLeadingRows(1).build();
    Schema schema =
        Schema.of(
            Field.of("name", StandardSQLTypeName.STRING),
            Field.of("post_abbr", StandardSQLTypeName.STRING));
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.newBuilder(sourceUri, options)
            .setConnectionId(connectionId)
            .setSchema(schema)
            .build();
    createExternalTableAws(projectId, datasetName, tableName, externalTableDefinition);
  }

  public static void createExternalTableAws(
      String projectId,
      String datasetName,
      String tableName,
      ExternalTableDefinition externalTableDefinition) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableId tableId = TableId.of(projectId, datasetName, tableName);
      TableInfo tableInfo = TableInfo.newBuilder(tableId, externalTableDefinition).build();

      bigquery.create(tableInfo);
      System.out.println("Aws external table created successfully");

      // Clean up
      bigquery.delete(TableId.of(projectId, datasetName, tableName));
    } catch (BigQueryException e) {
      System.out.println("Aws external was not created." + e.toString());
    }
  }
}
// [END bigquery_omni_create_external_table]

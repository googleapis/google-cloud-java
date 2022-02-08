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

package com.example.bigquerystorage;

import com.google.api.core.ApiFuture;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.storage.v1.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1.JsonStreamWriter;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.cloud.bigquery.storage.v1.TableSchema;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonWriterDefaultStream {

  public static void main(String[] args) throws Exception {
    if (args.length < 4) {
      System.out.println("Arguments: project, dataset, table, source_file");
      return;
    }

    String projectId = args[0];
    String datasetName = args[1];
    String tableName = args[2];
    String dataFile = args[3];
    createDestinationTable(projectId, datasetName, tableName);
    writeToDefaultStream(projectId, datasetName, tableName, dataFile);
  }

  // createDestinationTable: Creates the destination table for streaming with the desired schema.
  public static void createDestinationTable(
      String projectId, String datasetName, String tableName) {
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    // Create a schema that matches the source data.
    Schema schema =
        Schema.of(
            Field.of("commit", StandardSQLTypeName.STRING),
            Field.newBuilder("parent", StandardSQLTypeName.STRING)
                .setMode(Field.Mode.REPEATED)
                .build(),
            Field.of("author", StandardSQLTypeName.STRING),
            Field.of("committer", StandardSQLTypeName.STRING),
            Field.of("commit_date", StandardSQLTypeName.DATETIME),
            Field.of("subject", StandardSQLTypeName.STRING),
            Field.of("message", StandardSQLTypeName.STRING),
            Field.of("repo_name", StandardSQLTypeName.STRING));

    // Create a table that uses this schema.
    TableId tableId = TableId.of(projectId, datasetName, tableName);
    Table table = bigquery.getTable(tableId);
    if (table == null) {
      TableInfo tableInfo =
          TableInfo.newBuilder(tableId, StandardTableDefinition.of(schema)).build();
      bigquery.create(tableInfo);
    }
  }

  // writeToDefaultStream: Writes records from the source file to the destination table.
  public static void writeToDefaultStream(
      String projectId, String datasetName, String tableName, String dataFile)
      throws DescriptorValidationException, InterruptedException, IOException {

    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

    // Get the schema of the destination table and convert to the equivalent BigQueryStorage type.
    Table table = bigquery.getTable(datasetName, tableName);
    Schema schema = table.getDefinition().getSchema();
    TableSchema tableSchema = BqToBqStorageSchemaConverter.convertTableSchema(schema);

    // Use the JSON stream writer to send records in JSON format.
    TableName parentTable = TableName.of(projectId, datasetName, tableName);
    try (JsonStreamWriter writer =
        JsonStreamWriter.newBuilder(parentTable.toString(), tableSchema).build()) {
      // Read JSON data from the source file and send it to the Write API.
      BufferedReader reader = new BufferedReader(new FileReader(dataFile));
      String line = reader.readLine();
      while (line != null) {
        // As a best practice, send batches of records, instead of single records at a time.
        JSONArray jsonArr = new JSONArray();
        for (int i = 0; i < 100; i++) {
          JSONObject record = new JSONObject(line);
          jsonArr.put(record);
          line = reader.readLine();
          if (line == null) {
            break;
          }
        } // batch
        ApiFuture<AppendRowsResponse> future = writer.append(jsonArr);
        AppendRowsResponse response = future.get();
        if (response.hasUpdatedSchema()) {
          // The destination table schema has changed. The client library automatically
          // reestablishes a connection to the backend using the new schema, so we can continue
          // to send data without interruption.
          System.out.println("Table schema changed.");
        }
      }
      System.out.println("Appended records successfully.");
    } catch (ExecutionException e) {
      // If the wrapped exception is a StatusRuntimeException, check the state of the operation.
      // If the state is INTERNAL, CANCELLED, or ABORTED, you can retry. For more information, see:
      // https://grpc.github.io/grpc-java/javadoc/io/grpc/StatusRuntimeException.html
      System.out.println("Failed to append records. \n" + e.toString());
    }
  }
}

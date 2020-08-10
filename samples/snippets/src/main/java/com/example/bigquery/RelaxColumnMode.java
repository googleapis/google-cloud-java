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

// [START bigquery_relax_column]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;

public class RelaxColumnMode {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableId = "MY_TABLE_NAME";
    relaxColumnMode(datasetName, tableId);
  }

  public static void relaxColumnMode(String datasetName, String tableId) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Table table = bigquery.getTable(datasetName, tableId);

      // Create new relaxed schema based on the existing table schema
      Schema relaxedSchema =
          Schema.of(
              // The only supported modification you can make to a column's mode is changing it from
              // REQUIRED to NULLABLE
              // Changing a column's mode from REQUIRED to NULLABLE is also called column relaxation
              // INFO: LegacySQLTypeName will be updated to StandardSQLTypeName in release 1.103.0
              Field.newBuilder("word", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("word_count", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("corpus", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("corpus_date", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build());

      // Update the table with the new schema
      Table updatedTable =
          table.toBuilder().setDefinition(StandardTableDefinition.of(relaxedSchema)).build();
      updatedTable.update();
      System.out.println("Table schema successfully relaxed.");
    } catch (BigQueryException e) {
      System.out.println("Table schema not relaxed \n" + e.toString());
    }
  }
}
// [END bigquery_relax_column]

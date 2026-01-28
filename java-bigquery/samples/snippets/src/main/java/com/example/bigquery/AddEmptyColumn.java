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

// [START bigquery_add_empty_column]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import java.util.ArrayList;
import java.util.List;

public class AddEmptyColumn {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableId = "MY_TABLE_NAME";
    String newColumnName = "NEW_COLUMN_NAME";
    addEmptyColumn(newColumnName, datasetName, tableId);
  }

  public static void addEmptyColumn(String newColumnName, String datasetName, String tableId) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Table table = bigquery.getTable(datasetName, tableId);
      Schema schema = table.getDefinition().getSchema();
      FieldList fields = schema.getFields();

      // Create the new field/column
      Field newField = Field.of(newColumnName, LegacySQLTypeName.STRING);

      // Create a new schema adding the current fields, plus the new one
      List<Field> fieldList = new ArrayList<Field>();
      fields.forEach(fieldList::add);
      fieldList.add(newField);
      Schema newSchema = Schema.of(fieldList);

      // Update the table with the new schema
      Table updatedTable =
          table.toBuilder().setDefinition(StandardTableDefinition.of(newSchema)).build();
      updatedTable.update();
      System.out.println("Empty column successfully added to table");
    } catch (BigQueryException e) {
      System.out.println("Empty column was not added. \n" + e.toString());
    }
  }
}
// [END bigquery_add_empty_column]

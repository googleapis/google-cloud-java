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

// [START bigquery_inserting_data_types]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.InsertAllResponse;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Sample to insert data types in a table
public class InsertingDataTypes {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    insertingDataTypes(datasetName, tableName);
  }

  public static void insertingDataTypes(String datasetName, String tableName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      // Inserting data types
      Field name = Field.of("name", StandardSQLTypeName.STRING);
      Field age = Field.of("age", StandardSQLTypeName.INT64);
      Field school = Field.of("school", StandardSQLTypeName.BYTES);
      Field location = Field.of("location", StandardSQLTypeName.GEOGRAPHY);
      Field measurements =
          Field.newBuilder("measurements", StandardSQLTypeName.FLOAT64)
              .setMode(Field.Mode.REPEATED)
              .build();
      Field day = Field.of("day", StandardSQLTypeName.DATE);
      Field firstTime = Field.of("firstTime", StandardSQLTypeName.DATETIME);
      Field secondTime = Field.of("secondTime", StandardSQLTypeName.TIME);
      Field thirdTime = Field.of("thirdTime", StandardSQLTypeName.TIMESTAMP);
      Field datesTime =
          Field.of("datesTime", StandardSQLTypeName.STRUCT, day, firstTime, secondTime, thirdTime);
      Schema schema = Schema.of(name, age, school, location, measurements, datesTime);

      TableId tableId = TableId.of(datasetName, tableName);
      TableDefinition tableDefinition = StandardTableDefinition.of(schema);
      TableInfo tableInfo = TableInfo.newBuilder(tableId, tableDefinition).build();

      bigquery.create(tableInfo);

      // Inserting Sample data
      Map<String, Object> datesTimeContent = new HashMap<>();
      datesTimeContent.put("day", "2019-1-12");
      datesTimeContent.put("firstTime", "2019-02-17 11:24:00.000");
      datesTimeContent.put("secondTime", "14:00:00");
      datesTimeContent.put("thirdTime", "2020-04-27T18:07:25.356Z");

      Map<String, Object> rowContent = new HashMap<>();
      rowContent.put("name", "Tom");
      rowContent.put("age", 30);
      rowContent.put("school", Base64.getEncoder().encodeToString("Test University".getBytes()));
      rowContent.put("location", "POINT(1 2)");
      rowContent.put("measurements", new Float[] {50.05f, 100.5f});
      rowContent.put("datesTime", datesTimeContent);

      InsertAllResponse response =
          bigquery.insertAll(InsertAllRequest.newBuilder(tableId).addRow(rowContent).build());

      if (response.hasErrors()) {
        // If any of the insertions failed, this lets you inspect the errors
        for (Map.Entry<Long, List<BigQueryError>> entry : response.getInsertErrors().entrySet()) {
          System.out.println("Response error: \n" + entry.getValue());
        }
      }
      System.out.println("Rows successfully inserted into table");
    } catch (BigQueryException e) {
      System.out.println("Insert operation not performed \n" + e.toString());
    }
  }
}
// [END bigquery_inserting_data_types]

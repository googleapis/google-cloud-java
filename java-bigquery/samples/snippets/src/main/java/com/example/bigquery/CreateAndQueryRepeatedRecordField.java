/*
 * Copyright 2023 Google LLC
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

// [START bigquery_create_and_query_repeated_record]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Create a table with a repeated record field and query it using an array of struct named parameter
public class CreateAndQueryRepeatedRecordField {

  private static final Field REPEATED_RECORD_FIELD_SCHEMA =
      Field.newBuilder(
              "Addresses",
              LegacySQLTypeName.RECORD,
              Field.newBuilder("Status", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("Address", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("City", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("State", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("Zip", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build(),
              Field.newBuilder("NumberOfYears", LegacySQLTypeName.STRING)
                  .setMode(Field.Mode.NULLABLE)
                  .build())
          .setMode(Field.Mode.REPEATED)
          .build();
  private static final Schema REPEATED_RECORD_TABLE_SCHEMA =
      Schema.of(
          Field.newBuilder("ID", LegacySQLTypeName.STRING).setMode(Field.Mode.NULLABLE).build(),
          Field.newBuilder("FirstName", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("LastName", LegacySQLTypeName.STRING)
              .setMode(Field.Mode.NULLABLE)
              .build(),
          Field.newBuilder("DOB", LegacySQLTypeName.DATE).setMode(Field.Mode.NULLABLE).build(),
          REPEATED_RECORD_FIELD_SCHEMA);

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    createAndQueryRepeatedRecordField(datasetName, tableName);
  }

  public static void createAndQueryRepeatedRecordField(String datasetName, String tableName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
      TableId tableId = TableId.of(datasetName, tableName);

      // Create a table with a repeated record field
      StandardTableDefinition tableDefinition =
          StandardTableDefinition.of(REPEATED_RECORD_TABLE_SCHEMA);
      TableInfo tableInfo = TableInfo.of(tableId, tableDefinition);
      bigquery.create(tableInfo);

      // Insert some data
      ImmutableMap.Builder<String, Object> builder1 = ImmutableMap.builder();
      builder1.put("ID", "1");
      builder1.put("FirstName", "first_name1");
      builder1.put("LastName", "last_name1");
      builder1.put("DOB", "1995-08-09");
      builder1.put(
          "Addresses",
          ImmutableList.of(
              ImmutableMap.of(
                  "Status", "single",
                  "Address", "123 this lane",
                  "City", "Toronto",
                  "State", "ON",
                  "Zip", "1h2j34",
                  "NumberOfYears", "3"),
              ImmutableMap.of(
                  "Status", "couple",
                  "Address", "345 that lane",
                  "City", "Maple",
                  "State", "ON",
                  "Zip", "1h2j34",
                  "NumberOfYears", "5")));

      ImmutableMap.Builder<String, Object> builder2 = ImmutableMap.builder();
      builder2.put("ID", "2");
      builder2.put("FirstName", "first_name2");
      builder2.put("LastName", "last_name2");
      builder2.put("DOB", "1992-03-19");
      builder2.put(
          "Addresses",
          ImmutableList.of(
              ImmutableMap.of(
                  "Status", "single",
                  "Address", "97 Kota lane",
                  "City", "Ottawa",
                  "State", "ON",
                  "Zip", "1h2j34",
                  "NumberOfYears", "3"),
              ImmutableMap.of(
                  "Status", "couple",
                  "Address", "75 Malta lane",
                  "City", "Victoria",
                  "State", "AL",
                  "Zip", "1h2j34",
                  "NumberOfYears", "5")));

      InsertAllRequest request =
          InsertAllRequest.newBuilder(tableInfo.getTableId())
              .addRow(builder1.build())
              .addRow(builder2.build())
              .build();
      bigquery.insertAll(request);

      // Query using a named parameter
      QueryParameterValue statusValue = QueryParameterValue.string("single");
      QueryParameterValue addressValue = QueryParameterValue.string("123 this lane");
      QueryParameterValue cityValue = QueryParameterValue.string("Toronto");
      QueryParameterValue stateValue = QueryParameterValue.string("ON");
      QueryParameterValue zipValue = QueryParameterValue.string("1h2j34");
      QueryParameterValue numberOfYearsValue = QueryParameterValue.string("3");

      Map<String, QueryParameterValue> struct = new LinkedHashMap<>();
      struct.put("statusValue", statusValue);
      struct.put("addressValue", addressValue);
      struct.put("cityValue", cityValue);
      struct.put("stateValue", stateValue);
      struct.put("zipValue", zipValue);
      struct.put("numberOfYearsValue", numberOfYearsValue);
      QueryParameterValue recordValue = QueryParameterValue.struct(struct);
      List<QueryParameterValue> tuples = new ArrayList<>();
      tuples.add(recordValue);

      QueryParameterValue repeatedRecord =
          QueryParameterValue.array(tuples.toArray(), StandardSQLTypeName.STRUCT);

      String query =
          "SELECT * FROM "
              + tableId.getTable()
              + ", UNNEST(@repeatedRecord) AS TEMP where TEMP IN UNNEST(addresses);";
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              .setDefaultDataset(datasetName)
              .setUseLegacySql(false)
              .addNamedParameter("repeatedRecord", repeatedRecord)
              .build();
      TableResult results = bigquery.query(queryConfig);
      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s\n", val.toString())));
      System.out.println("Query with Array of struct parameters performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_create_and_query_repeated_record]

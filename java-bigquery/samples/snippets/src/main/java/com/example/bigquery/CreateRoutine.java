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

// [START bigquery_create_routine]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.RoutineArgument;
import com.google.cloud.bigquery.RoutineId;
import com.google.cloud.bigquery.RoutineInfo;
import com.google.cloud.bigquery.StandardSQLDataType;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.common.collect.ImmutableList;

// Sample to create a routine
public class CreateRoutine {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String routineName = "MY_ROUTINE_NAME";
    createRoutine(datasetName, routineName);
  }

  public static void createRoutine(String datasetName, String routineName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      RoutineId routineId = RoutineId.of(datasetName, routineName);

      RoutineInfo routineInfo =
          RoutineInfo.newBuilder(routineId)
              .setRoutineType("SCALAR_FUNCTION")
              .setLanguage("SQL")
              .setBody("x * 3")
              .setArguments(
                  ImmutableList.of(
                      RoutineArgument.newBuilder()
                          .setName("x")
                          .setDataType(
                              StandardSQLDataType.newBuilder(StandardSQLTypeName.INT64).build())
                          .build()))
              .build();
      bigquery.create(routineInfo);
      System.out.println("Routine created successfully");
    } catch (BigQueryException e) {
      System.out.println("Routine was not created. \n" + e.toString());
    }
  }
}
// [END bigquery_create_routine]

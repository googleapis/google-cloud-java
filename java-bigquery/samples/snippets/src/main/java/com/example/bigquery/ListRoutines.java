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

// [START bigquery_list_routines]
import com.google.api.gax.paging.Page;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Routine;

// Sample to get list of routines
public class ListRoutines {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    listRoutines(datasetName);
  }

  public static void listRoutines(String datasetName) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      Page<Routine> routines =
          bigquery.listRoutines(datasetName, BigQuery.RoutineListOption.pageSize(100));
      if (routines == null) {
        System.out.println("Dataset does not contain any routines.");
        return;
      }
      routines
          .iterateAll()
          .forEach(routine -> System.out.printf("Success! Routine ID: %s", routine.getRoutineId()));
    } catch (BigQueryException e) {
      System.out.println("Routines not listed in dataset due to error: \n" + e.toString());
    }
  }
}
// [END bigquery_list_routines]

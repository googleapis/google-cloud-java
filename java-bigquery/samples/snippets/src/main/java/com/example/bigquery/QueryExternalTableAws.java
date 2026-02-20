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

// [START bigquery_omni_query_external_aws_s3]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;

// Sample to queries an external data source aws s3 using a permanent table
public class QueryExternalTableAws {

  public static void main(String[] args) throws InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String datasetName = "MY_DATASET_NAME";
    String externalTableName = "MY_EXTERNAL_TABLE_NAME";
    // Query to find states starting with 'W'
    String query =
        String.format(
            "SELECT * FROM s%.%s.%s WHERE name LIKE 'W%%'",
            projectId, datasetName, externalTableName);
    queryExternalTableAws(query);
  }

  public static void queryExternalTableAws(String query) throws InterruptedException {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      TableResult results = bigquery.query(QueryJobConfiguration.of(query));

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));

      System.out.println("Query on aws external permanent table performed successfully.");
    } catch (BigQueryException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_omni_query_external_aws_s3]

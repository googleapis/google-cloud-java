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

// [START bigquery_query_external_sheets_perm]
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.ExternalTableDefinition;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.GoogleSheetsOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import com.google.cloud.bigquery.TableResult;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;

// Sample to queries an external data source using a permanent table
public class QueryExternalSheetsPerm {

  public static void main(String[] args) {
    // TODO(developer): Replace these variables before running the sample.
    String datasetName = "MY_DATASET_NAME";
    String tableName = "MY_TABLE_NAME";
    String sourceUri =
        "https://docs.google.com/spreadsheets/d/1i_QCL-7HcSyUZmIbP9E6lO_T5u3HnpLe7dnpHaijg_E/edit?usp=sharing";
    Schema schema =
        Schema.of(
            Field.of("name", StandardSQLTypeName.STRING),
            Field.of("post_abbr", StandardSQLTypeName.STRING));
    String query =
        String.format("SELECT * FROM %s.%s WHERE name LIKE 'W%%'", datasetName, tableName);
    queryExternalSheetsPerm(datasetName, tableName, sourceUri, schema, query);
  }

  public static void queryExternalSheetsPerm(
      String datasetName, String tableName, String sourceUri, Schema schema, String query) {
    try {

      // Create credentials with Drive & BigQuery API scopes.
      // Both APIs must be enabled for your project before running this code.
      GoogleCredentials credentials =
          ServiceAccountCredentials.getApplicationDefault()
              .createScoped(
                  ImmutableSet.of(
                      "https://www.googleapis.com/auth/bigquery",
                      "https://www.googleapis.com/auth/drive"));

      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery =
          BigQueryOptions.newBuilder().setCredentials(credentials).build().getService();

      // Skip header row in the file.
      GoogleSheetsOptions sheetsOptions =
          GoogleSheetsOptions.newBuilder()
              .setSkipLeadingRows(1) // Optionally skip header row.
              .setRange("us-states!A20:B49") // Optionally set range of the sheet to query from.
              .build();

      TableId tableId = TableId.of(datasetName, tableName);
      // Create a permanent table linked to the Sheets file.
      ExternalTableDefinition externalTable =
          ExternalTableDefinition.newBuilder(sourceUri, sheetsOptions).setSchema(schema).build();
      bigquery.create(TableInfo.of(tableId, externalTable));

      // Example query to find states starting with 'W'
      TableResult results = bigquery.query(QueryJobConfiguration.of(query));

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s,", val.toString())));

      System.out.println("Query on external permanent table performed successfully.");
    } catch (BigQueryException | InterruptedException | IOException e) {
      System.out.println("Query not performed \n" + e.toString());
    }
  }
}
// [END bigquery_query_external_sheets_perm]

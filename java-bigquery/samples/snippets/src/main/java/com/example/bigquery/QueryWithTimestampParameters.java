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

// [START bigquery_query_params_timestamps]
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.TableResult;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;

// Sample to running a query with timestamp query parameters.
public class QueryWithTimestampParameters {

  public static void queryFromTableTimestampParameters() {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      ZonedDateTime timestamp = LocalDateTime.of(2016, 12, 7, 8, 0, 0).atZone(ZoneOffset.UTC);
      String query = "SELECT last_reported FROM "
          + "`bigquery-public-data`.new_york_citibike.citibike_stations"
          + " WHERE last_reported >= @ts_value LIMIT 5";
      // Note: Standard SQL is required to use query parameters.
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              .addNamedParameter(
                  "ts_value",
                  QueryParameterValue.timestamp(
                      // Timestamp takes microseconds since 1970-01-01T00:00:00 UTC
                      timestamp.toInstant().toEpochMilli() * 1000))
              .build();

      TableResult results = bigquery.query(queryConfig);

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s\n", val.toString())));

      System.out.println("Query with timestamp parameter performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e);
    }
  }

  public static void queryWithTimestampParameters() {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

      ZonedDateTime timestamp = LocalDateTime.of(2016, 12, 7, 8, 0, 0).atZone(ZoneOffset.UTC);
      String query = "SELECT TIMESTAMP_ADD(@ts_value, INTERVAL 1 HOUR);";
      // Note: Standard SQL is required to use query parameters.
      QueryJobConfiguration queryConfig =
          QueryJobConfiguration.newBuilder(query)
              .addNamedParameter(
                  "ts_value",
                  QueryParameterValue.timestamp(
                      // Timestamp takes microseconds since 1970-01-01T00:00:00 UTC
                      timestamp.toInstant().toEpochMilli() * 1000))
              .build();

      TableResult results = bigquery.query(queryConfig);

      results
          .iterateAll()
          .forEach(row -> row.forEach(val -> System.out.printf("%s", val.toString())));

      System.out.println("Query with timestamp parameter performed successfully.");
    } catch (BigQueryException | InterruptedException e) {
      System.out.println("Query not performed \n" + e);
    }
  }
}
// [END bigquery_query_params_timestamps]

/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.bigquery.cloudsnippets;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.TableId;
import java.util.concurrent.TimeoutException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * This class contains snippets for cloud.google.com documentation.
 */
public class CloudSnippets {

  private final BigQuery bigquery;

  public CloudSnippets(BigQuery bigquery) {
    this.bigquery = bigquery;
  }

  /**
   * Example of running a Legacy SQL query.
   */
  public void runLegacySqlQuery() throws InterruptedException {
    // [START bigquery_query_legacy]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String query = "SELECT corpus FROM [bigquery-public-data:samples.shakespeare] GROUP BY corpus;";
    QueryJobConfiguration queryConfig =
        // To use legacy SQL syntax, set useLegacySql to true.
        QueryJobConfiguration.newBuilder(query).setUseLegacySql(true).build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_legacy]
  }

  /**
   * Example of running a query with Standard SQL explicitly set.
   */
  public void runStandardSqlQuery() throws InterruptedException {
    // [START bigquery_query_standard]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String query = "SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    QueryJobConfiguration queryConfig =
        // Note that setUseLegacySql is set to false by default
        QueryJobConfiguration.newBuilder(query).setUseLegacySql(false).build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_standard]
  }

  /**
   * Example of running a query and saving the results to a table.
   */
  public void runQueryPermanentTable(String destinationDataset, String destinationTable)
      throws InterruptedException {
    // [START bigquery_query_destination_table]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    // String destinationDataset = 'my_destination_dataset';
    // String destinationTable = 'my_destination_table';
    String query = "SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    QueryJobConfiguration queryConfig =
        // Note that setUseLegacySql is set to false by default
        QueryJobConfiguration.newBuilder(query)
            // Save the results of the query to a permanent table.
            .setDestinationTable(TableId.of(destinationDataset, destinationTable))
            .build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_destination_table]
  }

  /**
   * Example of running a query and saving the results to a table.
   */
  public void runQueryLargeResults(String destinationDataset, String destinationTable)
      throws InterruptedException {
    // [START bigquery_query_legacy_large_results]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    // String destinationDataset = 'my_destination_dataset';
    // String destinationTable = 'my_destination_table';
    String query = "SELECT corpus FROM [bigquery-public-data:samples.shakespeare] GROUP BY corpus;";
    QueryJobConfiguration queryConfig =
        // To use legacy SQL syntax, set useLegacySql to true.
        QueryJobConfiguration.newBuilder(query)
            .setUseLegacySql(true)
            // Save the results of the query to a permanent table.
            .setDestinationTable(TableId.of(destinationDataset, destinationTable))
            // Allow results larger than the maximum response size.
            // If true, a destination table must be set.
            .setAllowLargeResults(true)
            .build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_legacy_large_results]
  }

  /**
   * Example of running a query with the cache disabled.
   */
  public void runUncachedQuery() throws TimeoutException, InterruptedException {
    // [START bigquery_query_no_cache]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String query = "SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            // Disable the query cache to force live query evaluation.
            .setUseQueryCache(false)
            .build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_no_cache]
  }

  /**
   * Example of running a batch query.
   */
  public void runBatchQuery() throws TimeoutException, InterruptedException {
    // [START bigquery_query_batch]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String query = "SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            // Run at batch priority, which won't count toward concurrent rate
            // limit. See:
            // https://cloud.google.com/bigquery/docs/running-queries#batch
            .setPriority(QueryJobConfiguration.Priority.BATCH)
            .build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_batch]
  }

  /**
   * Example of running a query with named query parameters.
   */
  public void runQueryWithNamedParameters() throws InterruptedException {
    // [START bigquery_query_params_named]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String corpus = "romeoandjuliet";
    long minWordCount = 250;
    String query =
        "SELECT word, word_count\n"
            + "FROM `bigquery-public-data.samples.shakespeare`\n"
            + "WHERE corpus = @corpus\n"
            + "AND word_count >= @min_word_count\n"
            + "ORDER BY word_count DESC";
    // Note: Standard SQL is required to use query parameters.
    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            .addNamedParameter("corpus", QueryParameterValue.string(corpus))
            .addNamedParameter("min_word_count", QueryParameterValue.int64(minWordCount))
            .build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_params_named]
  }

  /**
   * Example of running a query with array query parameters.
   */
  public void runQueryWithArrayParameters() throws InterruptedException {
    // [START bigquery_query_params_arrays]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String gender = "M";
    String[] states = {"WA", "WI", "WV", "WY"};
    String query =
        "SELECT name, sum(number) as count\n"
            + "FROM `bigquery-public-data.usa_names.usa_1910_2013`\n"
            + "WHERE gender = @gender\n"
            + "AND state IN UNNEST(@states)\n"
            + "GROUP BY name\n"
            + "ORDER BY count DESC\n"
            + "LIMIT 10;";
    // Note: Standard SQL is required to use query parameters.
    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            .addNamedParameter("gender", QueryParameterValue.string(gender))
            .addNamedParameter("states", QueryParameterValue.array(states, String.class))
            .build();

    // Print the results.
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      for (FieldValue val : row) {
        System.out.printf("%s,", val.toString());
      }
      System.out.printf("\n");
    }
    // [END bigquery_query_params_arrays]
  }

  /**
   * Example of running a query with timestamp query parameters.
   */
  public void runQueryWithTimestampParameters() throws InterruptedException {
    // [START bigquery_query_params_timestamps]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    DateTime timestamp = new DateTime(2016, 12, 7, 8, 0, 0, DateTimeZone.UTC);
    String query = "SELECT TIMESTAMP_ADD(@ts_value, INTERVAL 1 HOUR);";
    // Note: Standard SQL is required to use query parameters.
    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            .addNamedParameter(
                "ts_value",
                QueryParameterValue.timestamp(
                    // Timestamp takes microseconds since 1970-01-01T00:00:00 UTC
                    timestamp.getMillis() * 1000))
            .build();

    // Print the results.
    DateTimeFormatter formatter = ISODateTimeFormat.dateTimeNoMillis().withZoneUTC();
    for (FieldValueList row : bigquery.query(queryConfig).iterateAll()) {
      System.out.printf(
          "%s\n",
          formatter.print(
              new DateTime(
                  // Timestamp values are returned in microseconds since 1970-01-01T00:00:00 UTC,
                  // but org.joda.time.DateTime constructor accepts times in milliseconds.
                  row.get(0).getTimestampValue() / 1000, DateTimeZone.UTC)));
      System.out.printf("\n");
    }
    // [END bigquery_query_params_timestamps]
  }
}

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

package com.google.cloud.examples.bigquery.snippets;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.CopyJobConfiguration;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.FormatOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.LoadJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/** This class contains snippets for cloud.google.com documentation. */
public class CloudSnippets {

  private final BigQuery bigquery;

  public CloudSnippets(BigQuery bigquery) {
    this.bigquery = bigquery;
  }

  /** Example of running a Legacy SQL query. */
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

  /** Example of running a query and saving the results to a table. */
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

  /** Example of running a query and saving the results to a table. */
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

  /** Example of running a query with the cache disabled. */
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

  /** Example of running a batch query. */
  public void runBatchQuery() throws TimeoutException, InterruptedException {
    // [START bigquery_query_batch]
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    String query = "SELECT corpus FROM `bigquery-public-data.samples.shakespeare` GROUP BY corpus;";
    QueryJobConfiguration queryConfig =
        QueryJobConfiguration.newBuilder(query)
            // Run at batch priority, which won't count toward concurrent rate
            // limit.
            .setPriority(QueryJobConfiguration.Priority.BATCH)
            .build();

    // Location must match that of the dataset(s) referenced in the query.
    JobId jobId = JobId.newBuilder().setRandomJob().setLocation("US").build();
    String jobIdString = jobId.getJob();

    // API request - starts the query.
    bigquery.create(JobInfo.newBuilder(queryConfig).setJobId(jobId).build());

    // Check on the progress by getting the job's updated state. Once the state
    // is `DONE`, the results are ready.
    Job queryJob =
        bigquery.getJob(JobId.newBuilder().setJob(jobIdString).setLocation("US").build());
    System.out.printf(
        "Job %s in location %s currently in state: %s%n",
        queryJob.getJobId().getJob(),
        queryJob.getJobId().getLocation(),
        queryJob.getStatus().getState().toString());
    // [END bigquery_query_batch]
  }

  /** Example of running a query with named query parameters. */
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

  /** Example of running a query with array query parameters. */
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

  /** Example of running a query with timestamp query parameters. */
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

  /** Example of loading a parquet file from GCS to a table. */
  public void loadTableGcsParquet(String datasetName) throws InterruptedException {
    // [START bigquery_load_table_gcs_parquet]
    String sourceUri = "gs://cloud-samples-data/bigquery/us-states/us-states.parquet";
    TableId tableId = TableId.of(datasetName, "us_states");
    LoadJobConfiguration configuration =
        LoadJobConfiguration.builder(tableId, sourceUri)
            .setFormatOptions(FormatOptions.parquet())
            .build();
    // Load the table
    Job loadJob = bigquery.create(JobInfo.of(configuration));
    loadJob = loadJob.waitFor();
    // Check the table
    StandardTableDefinition destinationTable = bigquery.getTable(tableId).getDefinition();
    System.out.println("State: " + loadJob.getStatus().getState());
    System.out.printf("Loaded %d rows.\n", destinationTable.getNumRows());
    // [END bigquery_load_table_gcs_parquet]
  }

  private void generateTableWithDdl(String datasetId, String tableId) throws InterruptedException {
    String sql =
        String.format(
            "CREATE TABLE %s.%s "
                + "AS "
                + "SELECT "
                + "2000 + CAST(18 * RAND() as INT64) AS year, "
                + "IF(RAND() > 0.5,\"foo\",\"bar\") AS token "
                + "FROM "
                + "UNNEST(GENERATE_ARRAY(0,5,1)) AS r",
            datasetId, tableId);
    Job job = bigquery.create(JobInfo.of(QueryJobConfiguration.newBuilder(sql).build()));
    job.waitFor();
  }

  /** Example of copying multiple tables to a destination. */
  public void copyTables(String datasetId, String destinationTableId) throws InterruptedException {
    generateTableWithDdl(datasetId, "table1");
    generateTableWithDdl(datasetId, "table2");

    // [START bigquery_copy_table_multiple_source]
    TableId destinationTable = TableId.of(datasetId, destinationTableId);
    CopyJobConfiguration configuration =
        CopyJobConfiguration.newBuilder(
                destinationTable,
                Arrays.asList(TableId.of(datasetId, "table1"), TableId.of(datasetId, "table2")))
            .build();

    // Copy the tables.
    Job job = bigquery.create(JobInfo.of(configuration));
    job = job.waitFor();

    // Check the table
    StandardTableDefinition table = bigquery.getTable(destinationTable).getDefinition();
    System.out.println("State: " + job.getStatus().getState());
    System.out.printf("Copied %d rows.\n", table.getNumRows());
    // [END bigquery_copy_table_multiple_source]
  }

  /** Example of undeleting a table. */
  public void undeleteTable(String datasetId) throws InterruptedException {
    generateTableWithDdl(datasetId, "oops_undelete_me");

    // [START bigquery_undelete_table]
    // String datasetId = "my_dataset";
    String tableId = "oops_undelete_me";

    // Record the current time.  We'll use this as the snapshot time
    // for recovering the table.
    long snapTime = Instant.now().getMillis();

    // "Accidentally" delete the table.
    bigquery.delete(TableId.of(datasetId, tableId));

    // Construct the restore-from tableID using a snapshot decorator.
    String snapshotTableId = String.format("%s@%d", tableId, snapTime);
    // Choose a new table ID for the recovered table data.
    String recoverTableId = String.format("%s_recovered", tableId);

    // Construct and run a copy job.
    CopyJobConfiguration configuration =
        CopyJobConfiguration.newBuilder(
                TableId.of(datasetId, recoverTableId), TableId.of(datasetId, snapshotTableId))
            .build();
    Job job = bigquery.create(JobInfo.of(configuration));
    job = job.waitFor();

    // Check the table
    StandardTableDefinition table =
        bigquery.getTable(TableId.of(datasetId, recoverTableId)).getDefinition();
    System.out.println("State: " + job.getStatus().getState());
    System.out.printf("Recovered %d rows.\n", table.getNumRows());
    // [END bigquery_undelete_table]
  }
}

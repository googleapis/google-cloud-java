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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITCloudSnippets {

  private static final String DATASET = RemoteBigQueryHelper.generateDatasetName();

  private static BigQuery bigquery;
  private static CloudSnippets cloudSnippets;
  private static ByteArrayOutputStream bout;
  private static PrintStream out;

  @BeforeClass
  public static void beforeClass() {
    bigquery = RemoteBigQueryHelper.create().getOptions().getService();
    cloudSnippets = new CloudSnippets(bigquery);
    bigquery.create(DatasetInfo.newBuilder(DATASET).build());
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    bigquery.delete(DATASET, DatasetDeleteOption.deleteContents());
    System.setOut(null);
  }

  @Test
  public void testRunLegacySqlQuery() throws InterruptedException {
    cloudSnippets.runLegacySqlQuery();
    String got = bout.toString();
    assertTrue(got.contains("romeoandjuliet"));
  }

  @Test
  public void testRunQueryPermanentTable() throws InterruptedException {
    String tableName = "test_destination_table";
    cloudSnippets.runQueryPermanentTable(DATASET, tableName);
    String got = bout.toString();
    assertTrue(got.contains("romeoandjuliet"));
  }

  @Test
  public void testRunQueryLargeResults() throws InterruptedException {
    String tableName = "test_large_results";
    cloudSnippets.runQueryLargeResults(DATASET, tableName);
    String got = bout.toString();
    assertTrue(got.contains("romeoandjuliet"));
  }

  @Test
  public void testRunUncachedQuery() throws TimeoutException, InterruptedException {
    cloudSnippets.runUncachedQuery();
    String got = bout.toString();
    assertTrue(got.contains("romeoandjuliet"));
  }

  @Test
  public void testRunBatchQuery() throws TimeoutException, InterruptedException {
    cloudSnippets.runBatchQuery();
    String got = bout.toString();
    assertTrue(got.contains("in location US currently in state:"));
  }

  @Test
  public void testRunQueryWithNamedParameters() throws InterruptedException {
    cloudSnippets.runQueryWithNamedParameters();
    String got = bout.toString();
    assertTrue(got.contains("love"));
  }

  @Test
  public void testRunQueryWithArrayParameters() throws InterruptedException {
    cloudSnippets.runQueryWithArrayParameters();
    String got = bout.toString();
    assertTrue(got.contains("James"));
  }

  @Test
  public void testRunQueryWithTimestampParameters() throws InterruptedException {
    cloudSnippets.runQueryWithTimestampParameters();
    String got = bout.toString();
    assertTrue(got.contains("2016-12-07T09:00:00Z"));
  }

  @Test
  public void testLoadTableGcsParquet() throws InterruptedException {
    cloudSnippets.loadTableGcsParquet(DATASET);
    String got = bout.toString();
    assertTrue(got.contains("DONE"));
    assertTrue(got.contains("Loaded 50 rows."));
  }

  @Test
  public void testCopyTables() throws InterruptedException {
    cloudSnippets.copyTables(DATASET, "copytablesdestination");
    String got = bout.toString();
    assertTrue(got.contains("DONE"));
  }

  @Test
  public void testUndeleteTable() throws InterruptedException {
    cloudSnippets.undeleteTable(DATASET);
    String got = bout.toString();
    assertTrue(got.contains("DONE"));
  }

  @Test
  public void testQueryDdlCreateView() throws InterruptedException {
    String projectId = bigquery.getOptions().getProjectId();
    String datasetId = DATASET;
    String tableId = "query_ddl_create_view";

    // [START bigquery_ddl_create_view]
    // import com.google.cloud.bigquery.*;
    // String projectId = "my-project";
    // String datasetId = "my_dataset";
    // String tableId = "new_view";
    // BigQuery bigquery = BigQueryOptions.getDefaultInstance().toBuilder()
    //     .setProjectId(projectId)
    //     .build().getService();

    String sql =
        String.format(
            "CREATE VIEW `%s.%s.%s`\n"
                + "OPTIONS(\n"
                + "  expiration_timestamp=TIMESTAMP_ADD(\n"
                + "    CURRENT_TIMESTAMP(), INTERVAL 48 HOUR),\n"
                + "  friendly_name=\"new_view\",\n"
                + "  description=\"a view that expires in 2 days\",\n"
                + "  labels=[(\"org_unit\", \"development\")]\n"
                + ")\n"
                + "AS SELECT name, state, year, number\n"
                + "  FROM `bigquery-public-data.usa_names.usa_1910_current`\n"
                + "  WHERE state LIKE 'W%%';\n",
            projectId, datasetId, tableId);

    // Make an API request to run the query job.
    Job job = bigquery.create(JobInfo.of(QueryJobConfiguration.newBuilder(sql).build()));

    // Wait for the query to finish.
    job = job.waitFor();

    QueryJobConfiguration jobConfig = (QueryJobConfiguration) job.getConfiguration();
    System.out.printf(
        "Created new view \"%s.%s.%s\".\n",
        jobConfig.getDestinationTable().getProject(),
        jobConfig.getDestinationTable().getDataset(),
        jobConfig.getDestinationTable().getTable());
    // [END bigquery_ddl_create_view]

    String got = bout.toString();
    assertTrue(got.contains("Created new view "));

    // Test that listing query result rows succeeds so that generic query
    // processing tools work with DDL statements.
    TableResult results = job.getQueryResults();
    List<FieldValueList> rows = Lists.newArrayList(results.iterateAll());
    assertEquals(rows.size(), 0);
  }
}

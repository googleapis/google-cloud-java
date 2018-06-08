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

import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
  public void testRunStandardSqlQuery() throws InterruptedException {
    cloudSnippets.runStandardSqlQuery();
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
}

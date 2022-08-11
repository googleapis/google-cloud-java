/*
 * Copyright 2021 Google Inc.
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

package com.example.contactcenterinsights;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExportToBigqueryIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String BIGQUERY_PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String GCLOUD_TESTS_PREFIX = "java_samples_tests";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String bigqueryDatasetId;
  private String bigqueryTableId;

  private static void requireEnvVar(String varName) {
    assertNotNull(String.format(varName), String.format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws BigQueryException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    // Generate BigQuery table and dataset IDs.
    bigqueryDatasetId =
        String.format("%s_%s", GCLOUD_TESTS_PREFIX, UUID.randomUUID().toString().replace("-", "_"));
    bigqueryTableId =
        String.format("%s_%s", GCLOUD_TESTS_PREFIX, UUID.randomUUID().toString().replace("-", "_"));

    // Create a BigQuery dataset.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    DatasetInfo datasetInfo =
        DatasetInfo.newBuilder(DatasetId.of(BIGQUERY_PROJECT_ID, bigqueryDatasetId)).build();
    Dataset dataset = bigquery.create(datasetInfo);

    // Create a BigQuery table under the created dataset.
    Schema schema = Schema.of(new ArrayList<>());
    TableDefinition tableDefinition = StandardTableDefinition.of(schema);
    TableInfo tableInfo =
        TableInfo.newBuilder(TableId.of(bigqueryDatasetId, bigqueryTableId), tableDefinition)
            .build();
    Table table = bigquery.create(tableInfo);
  }

  @After
  public void tearDown() throws BigQueryException {
    // Delete the BigQuery dataset and table.
    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();
    boolean success =
        bigquery.delete(
            DatasetId.of(PROJECT_ID, bigqueryDatasetId),
            BigQuery.DatasetDeleteOption.deleteContents());
    System.setOut(null);
  }

  @Test
  public void testExportToBigquery() throws Exception, IOException {
    ExportToBigquery.exportToBigquery(
        PROJECT_ID, BIGQUERY_PROJECT_ID, bigqueryDatasetId, bigqueryTableId);
    assertThat(bout.toString()).contains("Exported data to BigQuery");
  }
}

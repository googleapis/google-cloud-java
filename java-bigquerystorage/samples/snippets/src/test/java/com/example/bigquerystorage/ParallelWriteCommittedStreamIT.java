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

package com.example.bigquerystorage;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.StandardTableDefinition;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.TableInfo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParallelWriteCommittedStreamIT {

  private static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private BigQuery bigquery;
  private String datasetName;
  private String tableName;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    bigquery = BigQueryOptions.getDefaultInstance().getService();

    // Create a new dataset and table for each test.
    datasetName = "PARALLEL_WRITE_STREAM_TEST" + UUID.randomUUID().toString().substring(0, 8);
    tableName = "PARALLEL_WRITE_STREAM_TEST" + UUID.randomUUID().toString().substring(0, 8);
    Schema schema = Schema.of(Field.of("col1", StandardSQLTypeName.STRING));
    bigquery.create(DatasetInfo.newBuilder(datasetName).build());
    TableInfo tableInfo =
        TableInfo.newBuilder(TableId.of(datasetName, tableName), StandardTableDefinition.of(schema))
            .build();
    bigquery.create(tableInfo);

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
    bigquery.delete(TableId.of(GOOGLE_CLOUD_PROJECT, datasetName, tableName));
    bigquery.delete(
        DatasetId.of(GOOGLE_CLOUD_PROJECT, datasetName), DatasetDeleteOption.deleteContents());
  }

  @Test
  public void testParallelWriteCommittedStream() throws Exception {
    ParallelWriteCommittedStream.writeCommittedStream(GOOGLE_CLOUD_PROJECT, datasetName, tableName);
    assertThat(bout.toString()).contains("All records are appended successfully.");
  }
}

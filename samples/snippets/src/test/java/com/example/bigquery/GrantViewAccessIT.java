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

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GrantViewAccessIT {

  private String datasetName;
  private String tableName;
  private String viewName;
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");
  private static final String BIGQUERY_DATASET_NAME = requireEnvVar("BIGQUERY_DATASET_NAME");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    // create a temporary dataset, table and view to be deleted.
    datasetName = "MY_DATASET_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    tableName = "MY_TABLE_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    viewName = "MY_VIEW_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);

    CreateDataset.createDataset(datasetName);

    Schema schema =
        Schema.of(
            Field.of("timestampField", StandardSQLTypeName.TIMESTAMP),
            Field.of("stringField", StandardSQLTypeName.STRING),
            Field.of("booleanField", StandardSQLTypeName.BOOL));
    CreateTable.createTable(BIGQUERY_DATASET_NAME, tableName, schema);

    String query =
        String.format(
            "SELECT timestampField, stringField, booleanField FROM %s.%s",
            BIGQUERY_DATASET_NAME, tableName);
    CreateView.createView(BIGQUERY_DATASET_NAME, viewName, query);

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, viewName);
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, tableName);
    DeleteDataset.deleteDataset(PROJECT_ID, datasetName);
    System.setOut(null);
  }

  @Test
  public void testGrantViewAccess() {
    GrantViewAccess.grantViewAccess(datasetName, BIGQUERY_DATASET_NAME, viewName);
    assertThat(bout.toString()).contains("Grant view access successfully");
  }
}

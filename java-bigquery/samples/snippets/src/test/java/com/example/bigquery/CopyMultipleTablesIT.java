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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CopyMultipleTablesIT {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String datasetName;
  private String tableName;
  private String sourceTable1Name;
  private String sourceTable2Name;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String PROJECT_ID = requireEnvVar("GOOGLE_CLOUD_PROJECT");

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
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    // Create a new destination table for each test since existing table cannot be overwritten
    datasetName = "MY_DATASET_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    tableName = "COPY_MULTIPLE_TABLE_TEST" + UUID.randomUUID().toString().substring(0, 8);
    sourceTable1Name =
        "COPY_MULTIPLE_TABLE_SOURCE1_TEST" + UUID.randomUUID().toString().substring(0, 8);
    sourceTable2Name =
        "COPY_MULTIPLE_TABLE_SOURCE2_TEST" + UUID.randomUUID().toString().substring(0, 8);
    CreateDataset.createDataset(datasetName);

    Schema schema =
        Schema.of(
            Field.of("timestampField", StandardSQLTypeName.TIMESTAMP),
            Field.of("stringField", StandardSQLTypeName.STRING),
            Field.of("booleanField", StandardSQLTypeName.BOOL));
    CreateTable.createTable(datasetName, tableName, schema);
    CreateTable.createTable(datasetName, sourceTable1Name, schema);
    CreateTable.createTable(datasetName, sourceTable2Name, schema);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteDataset.deleteDataset(PROJECT_ID, datasetName);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testCopyMultipleTables() {
    CopyMultipleTables.copyMultipleTables(
        datasetName, tableName, sourceTable1Name, sourceTable2Name);
    assertThat(bout.toString()).contains("Table copied successfully.");
  }
}

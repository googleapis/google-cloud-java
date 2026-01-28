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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddColumnLoadAppendIT {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String tableName;
  private Schema schema;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String BIGQUERY_DATASET_NAME = requireEnvVar("BIGQUERY_DATASET_NAME");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    Assert.assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    // create a test table.
    tableName = "ADD_COLUMN_LOAD_APPEND_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    schema =
        Schema.of(
            Field.newBuilder("name", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build());

    CreateTable.createTable(BIGQUERY_DATASET_NAME, tableName, schema);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, tableName);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testAddColumnLoadAppend() {
    String sourceUri = "gs://cloud-samples-data/bigquery/us-states/us-states.csv";
    // Adding below additional column during the load job
    Field newField =
        Field.newBuilder("post_abbr", LegacySQLTypeName.STRING)
            .setMode(Field.Mode.NULLABLE)
            .build();
    List<Field> newFields = new ArrayList<>(schema.getFields());
    newFields.add(newField);
    AddColumnLoadAppend.addColumnLoadAppend(
        BIGQUERY_DATASET_NAME, tableName, sourceUri, Schema.of(newFields));
    assertThat(bout.toString()).contains("Column successfully added during load append job");
  }
}

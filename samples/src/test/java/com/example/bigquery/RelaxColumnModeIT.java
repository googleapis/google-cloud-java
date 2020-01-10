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
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RelaxColumnModeIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String BIGQUERY_DATASET_NAME = System.getenv("BIGQUERY_DATASET_NAME");

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testRelaxColumnMode() {
    // Create a new table with REQUIRED columns for each test to relax its column mode since this is
    // a one-way operation
    String generatedTableName =
        "gcloud_test_table_temp_" + UUID.randomUUID().toString().replace('-', '_');
    Schema originalSchema =
        Schema.of(
            Field.newBuilder("word", LegacySQLTypeName.STRING).setMode(Mode.REQUIRED).build(),
            Field.newBuilder("word_count", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build(),
            Field.newBuilder("corpus", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build(),
            Field.newBuilder("corpus_date", LegacySQLTypeName.STRING)
                .setMode(Field.Mode.REQUIRED)
                .build());
    CreateTable.createTable(BIGQUERY_DATASET_NAME, generatedTableName, originalSchema);

    // Relax table column mode
    RelaxColumnMode.relaxColumnMode(BIGQUERY_DATASET_NAME, generatedTableName);
    assertThat(bout.toString()).contains("Table schema successfully relaxed.");

    // Clean up
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, generatedTableName);
  }
}

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
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UpdateTableDMLIT {

  private String tableName;
  private ByteArrayOutputStream bout;
  private PrintStream out;

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
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    // Create a test table
    tableName = "UserSessions_TEST_" + UUID.randomUUID().toString().replace('-', '_');
    Schema schema =
        Schema.of(
            Field.of("id", LegacySQLTypeName.STRING),
            Field.of("user_id", LegacySQLTypeName.STRING),
            Field.of("login_time", LegacySQLTypeName.STRING),
            Field.of("logout_time", LegacySQLTypeName.STRING),
            Field.of("ip_address", LegacySQLTypeName.STRING));

    CreateTable.createTable(BIGQUERY_DATASET_NAME, tableName, schema);

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, tableName);
    System.setOut(null);
  }

  @Test
  public void testUpdateTableDML() throws IOException, InterruptedException {
    UpdateTableDML.updateTableDML(BIGQUERY_DATASET_NAME, tableName);
    assertThat(bout.toString()).contains("Table updated successfully using DML");
  }
}

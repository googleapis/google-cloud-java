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
import com.google.cloud.bigquery.InsertAllRequest;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TableInsertRowsWithoutRowIdsIT {

  private String tableName;
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
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    tableName = "INSERT_ROW_WITHOUT_ROW_ID_TEST" + UUID.randomUUID().toString().substring(0, 8);
    Schema schema =
        Schema.of(
            Field.of("stringField", LegacySQLTypeName.STRING),
            Field.of("numericField", LegacySQLTypeName.NUMERIC));

    // Create table in dataset for testing
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
  public void testTableInsertRowsWithoutRowIds() {
    // Create rows to insert
    Map<String, Object> rowContent1 = new HashMap<>();
    rowContent1.put("stringField", "Phred Phlyntstone");
    rowContent1.put("numericField", 32);
    Map<String, Object> rowContent2 = new HashMap<>();
    rowContent2.put("stringField", "Wylma Phlyntstone");
    rowContent2.put("numericField", 29);
    List<InsertAllRequest.RowToInsert> rowContent = new ArrayList<>();
    rowContent.add(InsertAllRequest.RowToInsert.of(rowContent1));
    rowContent.add(InsertAllRequest.RowToInsert.of(rowContent2));
    TableInsertRowsWithoutRowIds.tableInsertRowsWithoutRowIds(
        BIGQUERY_DATASET_NAME, tableName, rowContent);
    assertThat(bout.toString()).contains("Rows successfully inserted into table without row ids");
  }
}

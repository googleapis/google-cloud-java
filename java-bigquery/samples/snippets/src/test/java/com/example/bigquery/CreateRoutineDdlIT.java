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
import static junit.framework.TestCase.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateRoutineDdlIT {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String routineName;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

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
    routineName = "MY_ROUTINE_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteRoutine.deleteRoutine(BIGQUERY_DATASET_NAME, routineName);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testCreateRoutineDdl() {
    String sql =
        "CREATE FUNCTION "
            + "`"
            + PROJECT_ID
            + "."
            + BIGQUERY_DATASET_NAME
            + "."
            + routineName
            + "`"
            + "( arr ARRAY<STRUCT<name STRING, val INT64>>) AS "
            + "( (SELECT SUM(IF(elem.name = \"foo\",elem.val,null)) FROM UNNEST(arr) AS elem))";
    CreateRoutineDdl.createRoutineDdl(sql);
    assertThat(bout.toString()).contains("Routine created successfully");
  }
}

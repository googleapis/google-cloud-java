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

public class DdlCreateViewIT {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String viewName;
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
    viewName = "MY_VIEW_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, viewName);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testDdlCreateView() {
    String sql =
        "CREATE VIEW "
            + "`"
            + PROJECT_ID
            + "."
            + BIGQUERY_DATASET_NAME
            + "."
            + viewName
            + "`"
            + " OPTIONS("
            + " expiration_timestamp=TIMESTAMP_ADD("
            + " CURRENT_TIMESTAMP(), INTERVAL 48 HOUR),"
            + " friendly_name=\"new_view\","
            + " description=\"a view that expires in 2 days\","
            + " labels=[(\"org_unit\", \"development\")]"
            + " )"
            + " AS SELECT name, state, year, number"
            + " FROM `bigquery-public-data.usa_names.usa_1910_current`"
            + " WHERE state LIKE 'W%'";
    DdlCreateView.ddlCreateView(sql);
    assertThat(bout.toString()).contains("View created successfully");
  }
}

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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueryScriptIT {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testQueryScript() {
    String script =
        "-- Declare a variable to hold names as an array.\n"
            + "DECLARE top_names ARRAY<STRING>;\n"
            + "-- Build an array of the top 100 names from the year 2017.\n"
            + "SET top_names = (\n"
            + "  SELECT ARRAY_AGG(name ORDER BY number DESC LIMIT 100)\n"
            + "  FROM `bigquery-public-data`.usa_names.usa_1910_current\n"
            + "  WHERE year = 2017\n"
            + ");\n"
            + "-- Which names appear as words in Shakespeare's plays?\n"
            + "SELECT\n"
            + "  name AS shakespeare_name\n"
            + "FROM UNNEST(top_names) AS name\n"
            + "WHERE name IN (\n"
            + "  SELECT word\n"
            + "  FROM `bigquery-public-data`.samples.shakespeare\n"
            + ");";

    QueryScript.queryScript(script);
    assertThat(bout.toString()).contains("Query script performed successfully.");
  }
}

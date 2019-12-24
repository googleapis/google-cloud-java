/*
 * Copyright 2019 Google LLC
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
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExtractTableToJsonIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;

  private static final String GCS_BUCKET = System.getenv("GCS_BUCKET");

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable '%s' is required to perform these tests.".format(varName),
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GCS_BUCKET");
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
  public void testExtractTableToJson() {
    String projectId = "bigquery-public-data";
    String datasetName = "samples";
    String tableName = "shakespeare";
    String destinationUri = "gs://" + GCS_BUCKET + "/extractTest.csv";
    System.out.println(destinationUri);

    // Extract table content to GCS in CSV format
    ExtractTableToJson.extractTableToJson(projectId, datasetName, tableName, destinationUri);
    assertThat(bout.toString())
        .contains("Table export successful. Check in GCS bucket for the CSV file.");
  }
}

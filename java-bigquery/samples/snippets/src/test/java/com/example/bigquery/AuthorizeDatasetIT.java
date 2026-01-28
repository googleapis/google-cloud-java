/*
 * Copyright 2022 Google LLC
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

import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AuthorizeDatasetIT {
  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String userDatasetName;
  private String srcDatasetName;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private static final String GOOGLE_CLOUD_PROJECT = System.getenv("GOOGLE_CLOUD_PROJECT");
  private DatasetId sourceDatasetId;
  private DatasetId userDatasetId;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() {
    userDatasetName = RemoteBigQueryHelper.generateDatasetName();
    srcDatasetName = RemoteBigQueryHelper.generateDatasetName();
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
    CreateDataset.createDataset(userDatasetName);
    CreateDataset.createDataset(srcDatasetName);
    userDatasetId = DatasetId.of(GOOGLE_CLOUD_PROJECT, userDatasetName);
    sourceDatasetId = DatasetId.of(GOOGLE_CLOUD_PROJECT, srcDatasetName);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteDataset.deleteDataset(GOOGLE_CLOUD_PROJECT, userDatasetName);
    DeleteDataset.deleteDataset(GOOGLE_CLOUD_PROJECT, srcDatasetName);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testCreateDataset() {
    AuthorizeDataset.authorizeDataset(sourceDatasetId, userDatasetId);
    assertThat(bout.toString()).contains(sourceDatasetId + " updated with the added authorization");
  }
}

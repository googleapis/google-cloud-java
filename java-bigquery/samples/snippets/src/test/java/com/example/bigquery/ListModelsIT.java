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

import static junit.framework.TestCase.assertNotNull;

import com.google.common.truth.Truth;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListModelsIT {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private String modelName;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

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
    originalPrintStream = System.out;
    System.setOut(out);

    // Create a new model to be deleted
    modelName = "MY_MODEL_NAME_TEST_" + UUID.randomUUID().toString().substring(0, 8);
    String sql =
        "CREATE MODEL `"
            + BIGQUERY_DATASET_NAME
            + "."
            + modelName
            + "`"
            + "OPTIONS ( "
            + "model_type='linear_reg', "
            + "max_iterations=1, "
            + "learn_rate=0.4, "
            + "learn_rate_strategy='constant' "
            + ") AS ( "
            + "SELECT 'a' AS f1, 2.0 AS label "
            + "UNION ALL "
            + "SELECT 'b' AS f1, 3.8 AS label "
            + ")";
    CreateModel.createModel(sql);
  }

  @After
  public void tearDown() {
    // Clean up
    DeleteModel.deleteModel(BIGQUERY_DATASET_NAME, modelName);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, "\n" + bout.toString());
  }

  @Test
  public void testListModels() {
    ListModels.listModels(BIGQUERY_DATASET_NAME);
    Truth.assertThat(bout.toString()).contains("Success! Model ID");
  }
}

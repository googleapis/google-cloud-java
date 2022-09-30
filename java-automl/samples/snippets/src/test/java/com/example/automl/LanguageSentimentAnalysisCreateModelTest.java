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

package com.example.automl;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class LanguageSentimentAnalysisCreateModelTest {

  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private static final String DATASET_ID = "TST00000000000000000";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        System.getenv(varName),
        "Environment variable '%s' is required to perform these tests.".format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("AUTOML_PROJECT_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(originalPrintStream);
  }

  @Test
  public void testLanguageSentimentAnalysisCreateModel() {
    // Create a model from a nonexistent dataset.
    try {
      // Create a random dataset name with a length of 32 characters (max allowed by AutoML)
      // To prevent name collisions when running tests in multiple java versions at once.
      // AutoML doesn't allow "-", but accepts "_"
      String modelName =
          String.format("test_%s", UUID.randomUUID().toString().replace("-", "_").substring(0, 26));
      LanguageSentimentAnalysisCreateModel.createModel(PROJECT_ID, DATASET_ID, modelName);
      String got = bout.toString();
      assertThat(got).contains("Dataset does not exist");
    } catch (IOException | ExecutionException | InterruptedException e) {
      assertThat(e.getMessage()).contains("Dataset does not exist");
    }
  }
}

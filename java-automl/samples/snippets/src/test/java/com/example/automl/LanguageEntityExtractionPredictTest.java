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

package com.example.automl;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.DeployModelRequest;
import com.google.cloud.automl.v1.Model;
import com.google.cloud.automl.v1.ModelName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class LanguageEntityExtractionPredictTest {
  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private static final String MODEL_ID = System.getenv("ENTITY_EXTRACTION_MODEL_ID");
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
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("AUTOML_PROJECT_ID");
    requireEnvVar("ENTITY_EXTRACTION_MODEL_ID");
  }

  @Before
  public void setUp() throws IOException, ExecutionException, InterruptedException {
    // Verify that the model is deployed for prediction
    try (AutoMlClient client = AutoMlClient.create()) {
      ModelName modelFullId = ModelName.of(PROJECT_ID, "us-central1", MODEL_ID);
      Model model = client.getModel(modelFullId);
      if (model.getDeploymentState() == Model.DeploymentState.UNDEPLOYED) {
        // Deploy the model if not deployed
        DeployModelRequest request =
            DeployModelRequest.newBuilder().setName(modelFullId.toString()).build();
        client.deployModelAsync(request).get();
      }
    }

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
  }

  @Test
  public void testPredict() throws IOException {
    String text = "Constitutional mutations in the WT1 gene in patients with Denys-Drash syndrome.";
    LanguageEntityExtractionPredict.predict(PROJECT_ID, MODEL_ID, text);
    String got = bout.toString();
    assertThat(got).contains("Text Extract Entity Type:");
  }
}

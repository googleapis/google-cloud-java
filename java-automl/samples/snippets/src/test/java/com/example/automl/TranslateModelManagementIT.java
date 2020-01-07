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

// Tests for Automl translation models.
@RunWith(JUnit4.class)
public class TranslateModelManagementIT {
  private static final String PROJECT_ID = System.getenv("AUTOML_PROJECT_ID");
  private static final String DATASET_ID = System.getenv("TRANSLATION_DATASET_ID");
  private static final String MODEL_NAME = "translation_test_create_model";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String modelId;
  private String modelEvaluationId;

  private static void requireEnvVar(String varName) {
    assertNotNull(
            System.getenv(varName),
            "Environment variable '%s' is required to perform these tests.".format(varName)
    );
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("AUTOML_PROJECT_ID");
    requireEnvVar("TRANSLATION_DATASET_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testModelApi() throws IOException {
    // LIST MODELS
    ListModels.listModels(PROJECT_ID);
    String got = bout.toString();
    modelId = got.split("Model id: ")[1].split("\n")[0];
    assertThat(got).contains("Model id:");

    // GET MODEL
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    GetModel.getModel(PROJECT_ID, modelId);
    got = bout.toString();
    assertThat(got).contains("Model id: " + modelId);

    // LIST MODEL EVALUATIONS
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    ListModelEvaluations.listModelEvaluations(PROJECT_ID, modelId);
    got = bout.toString();
    modelEvaluationId = got.split(modelId + "/modelEvaluations/")[1].split("\n")[0];
    assertThat(got).contains("Model Evaluation Name:");

    // Act
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    GetModelEvaluation.getModelEvaluation(PROJECT_ID, modelId, modelEvaluationId);
    got = bout.toString();
    assertThat(got).contains("Model Evaluation Name:");
  }

  @Test
  public void testOperationStatus() throws IOException {
    // Act
    ListOperationStatus.listOperationStatus(PROJECT_ID);

    // Assert
    String got = bout.toString();
    String operationId = got.split("\n")[1].split(":")[1].trim();
    assertThat(got).contains("Operation details:");

    // Act
    bout.reset();
    GetOperationStatus.getOperationStatus(operationId);

    // Assert
    got = bout.toString();
    assertThat(got).contains("Operation details:");
  }

  @Test
  public void testCreateModel() throws IOException, ExecutionException, InterruptedException {
    TranslateCreateModel.createModel(PROJECT_ID, DATASET_ID, MODEL_NAME);

    String got = bout.toString();
    assertThat(got).contains("Training started");

    String operationId = got.split("Training operation name: ")[1].split("\n")[0];

    try (AutoMlClient client = AutoMlClient.create()) {
      client.getOperationsClient().cancelOperation(operationId);
    }
  }
}

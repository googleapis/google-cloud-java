/*
 * Copyright 2018 Google Inc.
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

package com.google.cloud.translate.automl;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for translation "Model API" sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ModelApiIT {
  private static final String PROJECT_ID = "java-docs-samples-testing";
  private static final String COMPUTE_REGION = "us-central1";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private ModelApi app;
  private String modelId;
  private String modelEvaluationId;

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
  public void testModelApi() throws Exception {
    // Act
    ModelApi.listModels(PROJECT_ID, COMPUTE_REGION, "");

    // Assert
    String got = bout.toString();
    modelId = got.split("\n")[1].split("/")[got.split("\n")[1].split("/").length - 1];
    assertThat(got).contains("Model id:");

    // Act
    ModelApi.getModel(PROJECT_ID, COMPUTE_REGION, modelId);

    // Assert
    got = bout.toString();
    assertThat(got).contains("Model name:");

    // Act
    ModelApi.listModelEvaluations(PROJECT_ID, COMPUTE_REGION, modelId, "");

    // Assert
    got = bout.toString();
    modelEvaluationId = got.split("List of model evaluations:")[1].split("\"")[1].split("/")[7];
    assertThat(got).contains("name:");

    // Act
    ModelApi.getModelEvaluation(PROJECT_ID, COMPUTE_REGION, modelId, modelEvaluationId);

    // Assert
    got = bout.toString();
    assertThat(got).contains("name:");

  }
}


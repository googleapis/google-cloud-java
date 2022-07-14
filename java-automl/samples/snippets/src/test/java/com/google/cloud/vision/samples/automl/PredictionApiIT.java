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

package com.google.cloud.vision.samples.automl;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.DeployModelRequest;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.ModelName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for vision "PredictionAPI" sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class PredictionApiIT {
  private static final String COMPUTE_REGION = "us-central1";
  private static final String PROJECT_ID = "java-docs-samples-testing";
  private static final String modelId = "ICN620201829169141520";
  private static final String filePath = "./resources/dandelion.jpg";
  private static final String scoreThreshold = "0.7";
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    // Verify that the model is deployed for prediction
    try (AutoMlClient client = AutoMlClient.create()) {
      ModelName modelFullId = ModelName.of(PROJECT_ID, "us-central1", modelId);
      Model model = client.getModel(modelFullId);
      if (model.getDeploymentState() == Model.DeploymentState.UNDEPLOYED) {
        // Deploy the model if not deployed
        DeployModelRequest request =
            DeployModelRequest.newBuilder().setName(modelFullId.toString()).build();
        Future future = client.deployModelAsync(request);
        future.get(30, TimeUnit.MINUTES);
      }
    }

    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testPredict() {
    PredictionApi.predict(PROJECT_ID, COMPUTE_REGION, modelId, filePath, scoreThreshold);
    String got = bout.toString();
    assertThat(got).contains("dandelion");
  }
}

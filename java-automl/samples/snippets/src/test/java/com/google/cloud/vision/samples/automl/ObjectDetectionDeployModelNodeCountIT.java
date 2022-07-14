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

package com.google.cloud.vision.samples.automl;

import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for vision "Deploy Model Node Count" sample. */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ObjectDetectionDeployModelNodeCountIT {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String MODEL_ID = "0000000000000000000000";
  private ByteArrayOutputStream bout;
  private PrintStream out;

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
  public void testObjectDetectionDeployModelNodeCountApi() {
    // As model deployment can take a long time, instead try to deploy a
    // nonexistent model and confirm that the model was not found, but other
    // elements of the request were valid.
    try {
      ObjectDetectionDeployModelNodeCount.objectDetectionDeployModelNodeCount(PROJECT_ID, MODEL_ID);
      String got = bout.toString();
      assertThat(got).contains("The model does not exist");
    } catch (IOException | ExecutionException | InterruptedException e) {
      assertThat(e.getMessage()).contains("The model does not exist");
    }
  }
}

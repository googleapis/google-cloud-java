/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aiplatform;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FeaturestoreSamplesTest {

  private static final String PROJECT_ID = System.getenv("UCAIP_PROJECT_ID");
  private static final int MIN_NODE_COUNT = 1;
  private static final int MAX_NODE_COUNT = 5;
  private static final int FIXED_NODE_COUNT = 5;
  private static final boolean USE_FORCE = true;
  private static final String LOCATION = "us-central1";
  private static final String ENDPOINT = "us-central1-aiplatform.googleapis.com:443";
  private static final int TIMEOUT = 900;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String featurestoreId;

  private static void requireEnvVar(String varName) {
    String errorMessage =
        String.format("Environment variable '%s' is required to perform these tests.", varName);
    assertNotNull(errorMessage, System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("UCAIP_PROJECT_ID");
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {

    // Delete the featurestore
    DeleteFeaturestoreSample.deleteFeaturestoreSample(
        PROJECT_ID, featurestoreId, USE_FORCE, LOCATION, ENDPOINT, 60);

    // Assert
    String deleteFeaturestoreResponse = bout.toString();
    assertThat(deleteFeaturestoreResponse).contains("Deleted Featurestore");
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testCreateFeaturestoreSample()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Create the featurestore
    String tempUuid = UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26);
    String id = String.format("temp_create_featurestore_test_%s", tempUuid);
    CreateFeaturestoreFixedNodesSample.createFeaturestoreFixedNodesSample(
        PROJECT_ID, id, FIXED_NODE_COUNT, LOCATION, ENDPOINT, 900);

    // Assert
    String createFeaturestoreResponse = bout.toString();
    assertThat(createFeaturestoreResponse).contains("Create Featurestore Response");
    featurestoreId =
        createFeaturestoreResponse.split("Name: ")[1].split("featurestores/")[1].split("\n")[0]
            .trim();

    // Get the featurestore
    GetFeaturestoreSample.getFeaturestoreSample(PROJECT_ID, featurestoreId, LOCATION, ENDPOINT);

    // Assert
    String getFeaturestoreResponse = bout.toString();
    assertThat(getFeaturestoreResponse).contains("Get Featurestore Response");

    // Update the featurestore with autoscaling
    UpdateFeaturestoreSample.updateFeaturestoreSample(
        PROJECT_ID, featurestoreId, MIN_NODE_COUNT, MAX_NODE_COUNT, LOCATION, ENDPOINT, TIMEOUT);

    // Assert
    String updateFeaturestoreResponse = bout.toString();
    assertThat(updateFeaturestoreResponse).contains("Update Featurestore Response");

    // List featurestores
    ListFeaturestoresSample.listFeaturestoresSample(PROJECT_ID, LOCATION, ENDPOINT);

    // Assert
    String listFeaturestoresResponse = bout.toString();
    assertThat(listFeaturestoresResponse).contains("List Featurestores Response");

    // Update the featurestore with fixed nodes
    UpdateFeaturestoreFixedNodesSample.updateFeaturestoreFixedNodesSample(
        PROJECT_ID, featurestoreId, FIXED_NODE_COUNT, LOCATION, ENDPOINT, TIMEOUT);

    // Assert
    String updateFeaturestoreFixedNodesResponse = bout.toString();
    assertThat(updateFeaturestoreFixedNodesResponse)
        .contains("Update Featurestore Fixed Nodes Response");

    // List featurestores
    ListFeaturestoresAsyncSample.listFeaturestoresAsyncSample(PROJECT_ID, LOCATION, ENDPOINT);

    // Assert
    String listFeaturestoresAsyncResponse = bout.toString();
    assertThat(listFeaturestoresAsyncResponse).contains("List Featurestores Async Response");
  }
}

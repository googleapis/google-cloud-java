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

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.FeaturestoreName;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.protobuf.Empty;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CreateFeaturestoreSampleTest {

  private static final String PROJECT_ID = System.getenv("UCAIP_PROJECT_ID");
  private static final int MIN_NODE_COUNT = 1;
  private static final int MAX_NODE_COUNT = 5;
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

  static void deleteFeaturestoreSample(
      String project,
      String featurestoreId,
      boolean useForce,
      String location,
      String endpoint,
      int timeout)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {

    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {

      DeleteFeaturestoreRequest deleteFeaturestoreRequest =
          DeleteFeaturestoreRequest.newBuilder()
              .setName(FeaturestoreName.of(project, location, featurestoreId).toString())
              .setForce(useForce)
              .build();

      OperationFuture<Empty, DeleteOperationMetadata> operationFuture =
          featurestoreServiceClient.deleteFeaturestoreAsync(deleteFeaturestoreRequest);
      System.out.format("Operation name: %s%n", operationFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      operationFuture.get(timeout, TimeUnit.SECONDS);

      System.out.format("Deleted Featurestore.");
    }
  }

  @After
  public void tearDown()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {

    // Delete the featurestore
    deleteFeaturestoreSample(PROJECT_ID, featurestoreId, USE_FORCE, LOCATION, ENDPOINT, 60);

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
    CreateFeaturestoreSample.createFeaturestoreSample(
        PROJECT_ID, id, MIN_NODE_COUNT, MAX_NODE_COUNT, LOCATION, ENDPOINT, TIMEOUT);

    // Assert
    String createFeaturestoreResponse = bout.toString();
    assertThat(createFeaturestoreResponse).contains("Create Featurestore Response");
    featurestoreId =
        createFeaturestoreResponse.split("Name: ")[1].split("featurestores/")[1].split("\n")[0]
            .trim();
  }
}

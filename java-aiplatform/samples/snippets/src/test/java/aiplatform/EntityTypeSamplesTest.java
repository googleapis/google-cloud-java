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
public class EntityTypeSamplesTest {

  private static final String PROJECT_ID = System.getenv("UCAIP_PROJECT_ID");
  private static final int MIN_NODE_COUNT = 1;
  private static final int MAX_NODE_COUNT = 5;
  private static final String DESCRIPTION = "Test Description";
  private static final int MONITORING_INTERVAL_DAYS = 1;
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
  public void testEntityTypeSamples()
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

    // Create the entity type
    String entityTypeTempUuid = UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 16);
    String entityTypeId = String.format("temp_create_entity_type_test_%s", entityTypeTempUuid);
    CreateEntityTypeSample.createEntityTypeSample(
        PROJECT_ID, featurestoreId, entityTypeId, DESCRIPTION, LOCATION, ENDPOINT, TIMEOUT);

    // Assert
    String createEntityTypeResponse = bout.toString();
    assertThat(createEntityTypeResponse).contains("Create Entity Type Response");

    // Get the entity type
    GetEntityTypeSample.getEntityTypeSample(
        PROJECT_ID, featurestoreId, entityTypeId, LOCATION, ENDPOINT);

    // Assert
    String getEntityTypeResponse = bout.toString();
    assertThat(getEntityTypeResponse).contains("Get Entity Type Response");

    // Create the entity type
    String entityTypeMonitoringTempUuid =
        UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 16);
    String entityTypeMonitoringId =
        String.format("temp_create_entity_type_test_%s", entityTypeMonitoringTempUuid);
    CreateEntityTypeMonitoringSample.createEntityTypeMonitoringSample(
        PROJECT_ID,
        featurestoreId,
        entityTypeMonitoringId,
        DESCRIPTION,
        MONITORING_INTERVAL_DAYS,
        LOCATION,
        ENDPOINT,
        TIMEOUT);

    // Assert
    String createEntityTypeMonitoringResponse = bout.toString();
    assertThat(createEntityTypeMonitoringResponse)
        .contains("Create Entity Type Monitoring Response");

    // List entity types
    ListEntityTypesSample.listEntityTypesSample(PROJECT_ID, featurestoreId, LOCATION, ENDPOINT);

    // Assert
    String listEntityTypeResponse = bout.toString();
    assertThat(listEntityTypeResponse).contains("List Entity Types Response");

    // Update the entity type
    UpdateEntityTypeSample.updateEntityTypeSample(
        PROJECT_ID, featurestoreId, entityTypeId, DESCRIPTION, LOCATION, ENDPOINT);

    // Assert
    String updateEntityTypeResponse = bout.toString();
    assertThat(updateEntityTypeResponse).contains("Update Entity Type Response");

    // Update the entity type
    UpdateEntityTypeMonitoringSample.updateEntityTypeMonitoringSample(
        PROJECT_ID, featurestoreId, entityTypeId, MONITORING_INTERVAL_DAYS, LOCATION, ENDPOINT);

    // Assert
    String updateEntityTypeMonitoringResponse = bout.toString();
    assertThat(updateEntityTypeMonitoringResponse)
        .contains("Update Entity Type Monitoring Response");

    // List entity types
    ListEntityTypesAsyncSample.listEntityTypesAsyncSample(
        PROJECT_ID, featurestoreId, LOCATION, ENDPOINT);

    // Assert
    String listEntityTypeAsyncResponse = bout.toString();
    assertThat(listEntityTypeAsyncResponse).contains("List Entity Types Async Response");

    // Delete the entity type
    DeleteEntityTypeSample.deleteEntityTypeSample(
        PROJECT_ID, featurestoreId, entityTypeId, LOCATION, ENDPOINT, TIMEOUT);

    // Assert
    String deleteEntityTypeResponse = bout.toString();
    assertThat(deleteEntityTypeResponse).contains("Deleted Entity Type");
  }
}

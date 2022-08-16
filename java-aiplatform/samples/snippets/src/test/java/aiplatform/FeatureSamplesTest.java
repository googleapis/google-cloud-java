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

import com.google.cloud.aiplatform.v1.Feature.ValueType;
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
public class FeatureSamplesTest {

  private static final String PROJECT_ID = System.getenv("UCAIP_PROJECT_ID");
  private static final ValueType VALUE_TYPE = ValueType.STRING;
  private static final String DESCRIPTION = "Test Description";
  private static final String QUERY = "value_type=STRING";
  private static final String LOCATION = "us-central1";
  private static final String ENDPOINT = "us-central1-aiplatform.googleapis.com:443";
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String featurestoreId = "featurestore_sample";

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

    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testFeatureSamples()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {

    // Create the entity type
    String entityTypeTempUuid = UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 16);
    String entityTypeId = String.format("temp_create_entity_type_test_%s", entityTypeTempUuid);
    CreateEntityTypeSample.createEntityTypeSample(
        PROJECT_ID, featurestoreId, entityTypeId, DESCRIPTION, LOCATION, ENDPOINT, 900);

    // Assert
    String createEntityTypeResponse = bout.toString();
    assertThat(createEntityTypeResponse).contains("Create Entity Type Response");

    // Create the feature
    String featureTempUuid = UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 26);
    String featureId = String.format("temp_create_feature_test_%s", featureTempUuid);
    CreateFeatureSample.createFeatureSample(
        PROJECT_ID,
        featurestoreId,
        entityTypeId,
        featureId,
        DESCRIPTION,
        VALUE_TYPE,
        LOCATION,
        ENDPOINT,
        900);

    // Assert
    String createFeatureResponse = bout.toString();
    assertThat(createFeatureResponse).contains("Create Feature Response");

    // Get the feature
    GetFeatureSample.getFeatureSample(
        PROJECT_ID, featurestoreId, entityTypeId, featureId, LOCATION, ENDPOINT);

    // Assert
    String getFeatureResponse = bout.toString();
    assertThat(getFeatureResponse).contains("Get Feature Response");

    // List features
    ListFeaturesSample.listFeaturesSample(
        PROJECT_ID, featurestoreId, entityTypeId, LOCATION, ENDPOINT);

    // Assert
    String listfeatureResponse = bout.toString();
    assertThat(listfeatureResponse).contains("List Features Response");

    // List features
    ListFeaturesAsyncSample.listFeaturesAsyncSample(
        PROJECT_ID, featurestoreId, entityTypeId, LOCATION, ENDPOINT);

    // Assert
    String listfeatureAsyncResponse = bout.toString();
    assertThat(listfeatureAsyncResponse).contains("List Features Async Response");

    // Search features
    SearchFeaturesSample.searchFeaturesSample(PROJECT_ID, QUERY, LOCATION, ENDPOINT);

    // Assert
    String searchFeaturesResponse = bout.toString();
    assertThat(searchFeaturesResponse).contains("Search Features Response");

    // Search features
    SearchFeaturesAsyncSample.searchFeaturesAsyncSample(PROJECT_ID, QUERY, LOCATION, ENDPOINT);

    // Assert
    String searchFeaturesAsyncResponse = bout.toString();
    assertThat(searchFeaturesAsyncResponse).contains("Search Features Async Response");

    // Delete the feature
    DeleteFeatureSample.deleteFeatureSample(
        PROJECT_ID, featurestoreId, entityTypeId, featureId, LOCATION, ENDPOINT, 300);

    // Assert
    String deleteFeatureResponse = bout.toString();
    assertThat(deleteFeatureResponse).contains("Deleted Feature");
  }
}

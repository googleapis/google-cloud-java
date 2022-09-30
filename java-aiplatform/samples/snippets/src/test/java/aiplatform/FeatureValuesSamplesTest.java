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
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQuery.DatasetDeleteOption;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Dataset;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.DatasetInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
public class FeatureValuesSamplesTest {

  private static final String PROJECT_ID = System.getenv("UCAIP_PROJECT_ID");
  private static final int MIN_NODE_COUNT = 1;
  private static final int MAX_NODE_COUNT = 2;
  private static final String DESCRIPTION = "Test Description";
  private static final boolean USE_FORCE = true;
  private static final ValueType VALUE_TYPE = ValueType.STRING;
  private static final String QUERY = "value_type=STRING";
  private static final String ENTITY_ID_FIELD = "movie_id";
  private static final String FEATURE_TIME_FIELD = "update_time";
  private static final String GCS_SOURCE_URI =
      "gs://cloud-samples-data-us-central1/vertex-ai/feature-store/datasets/movies.avro";
  private static final int WORKER_COUNT = 2;
  private static final String INPUT_CSV_FILE =
      "gs://cloud-samples-data-us-central1/vertex-ai/feature-store/datasets/movie_prediction.csv";
  private static final List<String> FEATURE_SELECTOR_IDS =
      Arrays.asList("title", "genres", "average_rating");
  private static final String LOCATION = "us-central1";
  private static final String ENDPOINT = "us-central1-aiplatform.googleapis.com:443";
  private static final int TIMEOUT = 900;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;
  private String featurestoreId;
  private String destinationTableUri;
  private Date date;
  private SimpleDateFormat dateFormat;
  private String datasetName;
  private String destinationTableName;

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
    date = new Date();
    dateFormat = new SimpleDateFormat("yyyyMMddHHmmSSS");
    datasetName = "movie_predictions" + dateFormat.format(date);
    destinationTableName = "training_data";
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  static void createBigQueryDataset(String projectId, String datasetName, String location) {
    try {
      // Initialize client that will be used to send requests. This client only needs
      // to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery =
          BigQueryOptions.newBuilder()
              .setLocation(location)
              .setProjectId(projectId)
              .build()
              .getService();
      DatasetInfo datasetInfo = DatasetInfo.newBuilder(datasetName).build();

      Dataset newDataset = bigquery.create(datasetInfo);
      String newDatasetName = newDataset.getDatasetId().getDataset();
      System.out.println(newDatasetName + " created successfully");
    } catch (BigQueryException e) {
      System.out.format("Dataset was not created. %n%s", e.toString());
    }
  }

  static void deleteBigQueryDataset(String projectId, String datasetName, String location) {
    try {
      // Initialize client that will be used to send requests. This client only needs to be created
      // once, and can be reused for multiple requests.
      BigQuery bigquery =
          BigQueryOptions.newBuilder()
              .setLocation(location)
              .setProjectId(projectId)
              .build()
              .getService();

      DatasetId datasetId = DatasetId.of(projectId, datasetName);
      boolean success = bigquery.delete(datasetId, DatasetDeleteOption.deleteContents());
      if (success) {
        System.out.println("Dataset deleted successfully");
      } else {
        System.out.println("Dataset was not found");
      }
    } catch (BigQueryException e) {
      System.out.format("Dataset was not deleted. %n%s", e.toString());
    }
  }

  @After
  public void tearDown()
      throws InterruptedException, ExecutionException, IOException, TimeoutException {

    // Delete the featurestore
    DeleteFeaturestoreSample.deleteFeaturestoreSample(
        PROJECT_ID, featurestoreId, USE_FORCE, LOCATION, ENDPOINT, 300);

    // Assert
    String deleteFeaturestoreResponse = bout.toString();
    assertThat(deleteFeaturestoreResponse).contains("Deleted Featurestore");

    // Delete the big query dataset
    deleteBigQueryDataset(PROJECT_ID, datasetName, LOCATION);

    // Assert
    String deleteBigQueryResponse = bout.toString();
    assertThat(deleteBigQueryResponse).contains("Dataset deleted successfully");

    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testFeatureValuesSamples()
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // Create the featurestore
    String tempUuid = UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 23);
    String id = String.format("temp_feature_values_samples_test_%s", tempUuid);
    CreateFeaturestoreSample.createFeaturestoreSample(
        PROJECT_ID, id, MIN_NODE_COUNT, MAX_NODE_COUNT, LOCATION, ENDPOINT, 900);

    // Assert
    String createFeaturestoreResponse = bout.toString();
    assertThat(createFeaturestoreResponse).contains("Create Featurestore Response");
    featurestoreId =
        createFeaturestoreResponse.split("Name: ")[1].split("featurestores/")[1].split("\n")[0]
            .trim();

    // Create the entity type
    String entityTypeId = "movies";
    CreateEntityTypeSample.createEntityTypeSample(
        PROJECT_ID, featurestoreId, entityTypeId, DESCRIPTION, LOCATION, ENDPOINT, 900);

    // Assert
    String createEntityTypeResponse = bout.toString();
    assertThat(createEntityTypeResponse).contains("Create Entity Type Response");

    // Create the feature
    String featureTempUuid = UUID.randomUUID().toString().replaceAll("-", "_").substring(0, 25);
    String featureId = String.format("temp_feature_feature_test_%s", featureTempUuid);
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

    // Batch create features
    BatchCreateFeaturesSample.batchCreateFeaturesSample(
        PROJECT_ID, featurestoreId, entityTypeId, LOCATION, ENDPOINT, TIMEOUT);

    // Assert
    String batchCreateFeaturesResponse = bout.toString();
    assertThat(batchCreateFeaturesResponse).contains("Batch Create Features Response");

    // Import feature values
    ImportFeatureValuesSample.importFeatureValuesSample(
        PROJECT_ID,
        featurestoreId,
        entityTypeId,
        GCS_SOURCE_URI,
        ENTITY_ID_FIELD,
        FEATURE_TIME_FIELD,
        WORKER_COUNT,
        LOCATION,
        ENDPOINT,
        TIMEOUT);

    // Assert
    String importFeatureValuesResponse = bout.toString();
    assertThat(importFeatureValuesResponse).contains("Import Feature Values Response");

    // Create the big query dataset
    createBigQueryDataset(PROJECT_ID, datasetName, LOCATION);
    destinationTableUri =
        String.format("bq://%s.%s.%s_full", PROJECT_ID, datasetName, destinationTableName);

    // Assert
    String createBigQueryDatasetResponse = bout.toString();
    assertThat(createBigQueryDatasetResponse).contains(datasetName + " created successfully");

    // Export feature values
    ExportFeatureValuesSample.exportFeatureValuesSample(
        PROJECT_ID,
        featurestoreId,
        entityTypeId,
        destinationTableUri,
        FEATURE_SELECTOR_IDS,
        LOCATION,
        ENDPOINT,
        TIMEOUT);

    // Assert
    String exportFeatureValuesResponse = bout.toString();
    assertThat(exportFeatureValuesResponse).contains("Export Feature Values Response");

    destinationTableUri =
        String.format("bq://%s.%s.%s_snapshot", PROJECT_ID, datasetName, destinationTableName);

    // Snapshot export feature values
    ExportFeatureValuesSnapshotSample.exportFeatureValuesSnapshotSample(
        PROJECT_ID,
        featurestoreId,
        entityTypeId,
        destinationTableUri,
        FEATURE_SELECTOR_IDS,
        LOCATION,
        ENDPOINT,
        TIMEOUT);

    // Assert
    String snapshotResponse = bout.toString();
    assertThat(snapshotResponse).contains("Snapshot Export Feature Values Response");

    destinationTableUri =
        String.format("bq://%s.%s.%s_batchRead", PROJECT_ID, datasetName, destinationTableName);

    // Batch read feature values
    BatchReadFeatureValuesSample.batchReadFeatureValuesSample(
        PROJECT_ID,
        featurestoreId,
        entityTypeId,
        INPUT_CSV_FILE,
        destinationTableUri,
        FEATURE_SELECTOR_IDS,
        LOCATION,
        ENDPOINT,
        TIMEOUT);

    // Assert
    String batchReadFeatureValuesResponse = bout.toString();
    assertThat(batchReadFeatureValuesResponse).contains("Batch Read Feature Values Response");
  }
}

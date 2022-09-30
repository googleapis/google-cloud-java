/*
 * Copyright 2022 Google LLC
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
 *
 *
 * Batch read feature values from a featurestore, as determined by your
 * read instances list file, to export data. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_batch_read_feature_values_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.BatchReadFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest;
import com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest.EntityTypeSpec;
import com.google.cloud.aiplatform.v1.BatchReadFeatureValuesResponse;
import com.google.cloud.aiplatform.v1.BigQueryDestination;
import com.google.cloud.aiplatform.v1.CsvSource;
import com.google.cloud.aiplatform.v1.FeatureSelector;
import com.google.cloud.aiplatform.v1.FeatureValueDestination;
import com.google.cloud.aiplatform.v1.FeaturestoreName;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.GcsSource;
import com.google.cloud.aiplatform.v1.IdMatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BatchReadFeatureValuesSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    String inputCsvFile = "YOU_INPUT_CSV_FILE";
    String destinationTableUri = "YOUR_DESTINATION_TABLE_URI";
    List<String> featureSelectorIds = Arrays.asList("title", "genres", "average_rating");
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    int timeout = 300;
    batchReadFeatureValuesSample(
        project,
        featurestoreId,
        entityTypeId,
        inputCsvFile,
        destinationTableUri,
        featureSelectorIds,
        location,
        endpoint,
        timeout);
  }

  static void batchReadFeatureValuesSample(
      String project,
      String featurestoreId,
      String entityTypeId,
      String inputCsvFile,
      String destinationTableUri,
      List<String> featureSelectorIds,
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

      List<EntityTypeSpec> entityTypeSpecs = new ArrayList<>();

      FeatureSelector featureSelector =
          FeatureSelector.newBuilder()
              .setIdMatcher(IdMatcher.newBuilder().addAllIds(featureSelectorIds).build())
              .build();
      EntityTypeSpec entityTypeSpec =
          EntityTypeSpec.newBuilder()
              .setEntityTypeId(entityTypeId)
              .setFeatureSelector(featureSelector)
              .build();

      entityTypeSpecs.add(entityTypeSpec);

      BigQueryDestination bigQueryDestination =
          BigQueryDestination.newBuilder().setOutputUri(destinationTableUri).build();
      GcsSource gcsSource = GcsSource.newBuilder().addUris(inputCsvFile).build();
      BatchReadFeatureValuesRequest batchReadFeatureValuesRequest =
          BatchReadFeatureValuesRequest.newBuilder()
              .setFeaturestore(FeaturestoreName.of(project, location, featurestoreId).toString())
              .setCsvReadInstances(CsvSource.newBuilder().setGcsSource(gcsSource))
              .setDestination(
                  FeatureValueDestination.newBuilder().setBigqueryDestination(bigQueryDestination))
              .addAllEntityTypeSpecs(entityTypeSpecs)
              .build();

      OperationFuture<BatchReadFeatureValuesResponse, BatchReadFeatureValuesOperationMetadata>
          batchReadFeatureValuesFuture =
              featurestoreServiceClient.batchReadFeatureValuesAsync(batchReadFeatureValuesRequest);
      System.out.format(
          "Operation name: %s%n", batchReadFeatureValuesFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      BatchReadFeatureValuesResponse batchReadFeatureValuesResponse =
          batchReadFeatureValuesFuture.get(timeout, TimeUnit.SECONDS);
      System.out.println("Batch Read Feature Values Response");
      System.out.println(batchReadFeatureValuesResponse);
      featurestoreServiceClient.close();
    }
  }
}
// [END aiplatform_batch_read_feature_values_sample]

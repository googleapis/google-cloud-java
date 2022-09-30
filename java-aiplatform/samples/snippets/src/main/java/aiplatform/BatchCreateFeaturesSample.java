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
 * Create features in bulk for an existing entity type. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup
 * before running the code snippet
 */

package aiplatform;

// [START aiplatform_batch_create_features_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.BatchCreateFeaturesOperationMetadata;
import com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest;
import com.google.cloud.aiplatform.v1.BatchCreateFeaturesResponse;
import com.google.cloud.aiplatform.v1.CreateFeatureRequest;
import com.google.cloud.aiplatform.v1.EntityTypeName;
import com.google.cloud.aiplatform.v1.Feature;
import com.google.cloud.aiplatform.v1.Feature.ValueType;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BatchCreateFeaturesSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    int timeout = 300;
    batchCreateFeaturesSample(project, featurestoreId, entityTypeId, location, endpoint, timeout);
  }

  static void batchCreateFeaturesSample(
      String project,
      String featurestoreId,
      String entityTypeId,
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

      List<CreateFeatureRequest> createFeatureRequests = new ArrayList<>();

      Feature titleFeature =
          Feature.newBuilder()
              .setDescription("The title of the movie")
              .setValueType(ValueType.STRING)
              .build();
      Feature genresFeature =
          Feature.newBuilder()
              .setDescription("The genres of the movie")
              .setValueType(ValueType.STRING)
              .build();
      Feature averageRatingFeature =
          Feature.newBuilder()
              .setDescription("The average rating for the movie, range is [1.0-5.0]")
              .setValueType(ValueType.DOUBLE)
              .build();

      createFeatureRequests.add(
          CreateFeatureRequest.newBuilder().setFeature(titleFeature).setFeatureId("title").build());

      createFeatureRequests.add(
          CreateFeatureRequest.newBuilder()
              .setFeature(genresFeature)
              .setFeatureId("genres")
              .build());

      createFeatureRequests.add(
          CreateFeatureRequest.newBuilder()
              .setFeature(averageRatingFeature)
              .setFeatureId("average_rating")
              .build());

      BatchCreateFeaturesRequest batchCreateFeaturesRequest =
          BatchCreateFeaturesRequest.newBuilder()
              .setParent(
                  EntityTypeName.of(project, location, featurestoreId, entityTypeId).toString())
              .addAllRequests(createFeatureRequests)
              .build();

      OperationFuture<BatchCreateFeaturesResponse, BatchCreateFeaturesOperationMetadata>
          batchCreateFeaturesFuture =
              featurestoreServiceClient.batchCreateFeaturesAsync(batchCreateFeaturesRequest);
      System.out.format(
          "Operation name: %s%n", batchCreateFeaturesFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      BatchCreateFeaturesResponse batchCreateFeaturesResponse =
          batchCreateFeaturesFuture.get(timeout, TimeUnit.SECONDS);
      System.out.println("Batch Create Features Response");
      System.out.println(batchCreateFeaturesResponse);
      featurestoreServiceClient.close();
    }
  }
}
// [END aiplatform_batch_create_features_sample]

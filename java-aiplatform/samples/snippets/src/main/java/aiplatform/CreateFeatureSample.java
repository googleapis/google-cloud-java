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
 * Create a single feature for an existing entity type. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_create_feature_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.CreateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureRequest;
import com.google.cloud.aiplatform.v1.EntityTypeName;
import com.google.cloud.aiplatform.v1.Feature;
import com.google.cloud.aiplatform.v1.Feature.ValueType;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateFeatureSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    String featureId = "YOUR_FEATURE_ID";
    String description = "YOUR_FEATURE_DESCRIPTION";
    ValueType valueType = ValueType.STRING;
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    int timeout = 900;
    createFeatureSample(
        project,
        featurestoreId,
        entityTypeId,
        featureId,
        description,
        valueType,
        location,
        endpoint,
        timeout);
  }

  static void createFeatureSample(
      String project,
      String featurestoreId,
      String entityTypeId,
      String featureId,
      String description,
      ValueType valueType,
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

      Feature feature =
          Feature.newBuilder().setDescription(description).setValueType(valueType).build();

      CreateFeatureRequest createFeatureRequest =
          CreateFeatureRequest.newBuilder()
              .setParent(
                  EntityTypeName.of(project, location, featurestoreId, entityTypeId).toString())
              .setFeature(feature)
              .setFeatureId(featureId)
              .build();

      OperationFuture<Feature, CreateFeatureOperationMetadata> featureFuture =
          featurestoreServiceClient.createFeatureAsync(createFeatureRequest);
      System.out.format("Operation name: %s%n", featureFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      Feature featureResponse = featureFuture.get(timeout, TimeUnit.SECONDS);
      System.out.println("Create Feature Response");
      System.out.format("Name: %s%n", featureResponse.getName());
      featurestoreServiceClient.close();
    }
  }
}
// [END aiplatform_create_feature_sample]

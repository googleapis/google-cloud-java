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
 * Create an entity type so that you can create its related features. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_create_entity_type_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.CreateEntityTypeOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateEntityTypeRequest;
import com.google.cloud.aiplatform.v1.EntityType;
import com.google.cloud.aiplatform.v1.FeaturestoreName;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateEntityTypeSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    String description = "YOUR_ENTITY_TYPE_DESCRIPTION";
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    int timeout = 300;
    createEntityTypeSample(
        project, featurestoreId, entityTypeId, description, location, endpoint, timeout);
  }

  static void createEntityTypeSample(
      String project,
      String featurestoreId,
      String entityTypeId,
      String description,
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

      EntityType entityType = EntityType.newBuilder().setDescription(description).build();

      CreateEntityTypeRequest createEntityTypeRequest =
          CreateEntityTypeRequest.newBuilder()
              .setParent(FeaturestoreName.of(project, location, featurestoreId).toString())
              .setEntityType(entityType)
              .setEntityTypeId(entityTypeId)
              .build();

      OperationFuture<EntityType, CreateEntityTypeOperationMetadata> entityTypeFuture =
          featurestoreServiceClient.createEntityTypeAsync(createEntityTypeRequest);
      System.out.format(
          "Operation name: %s%n", entityTypeFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      EntityType entityTypeResponse = entityTypeFuture.get(timeout, TimeUnit.SECONDS);
      System.out.println("Create Entity Type Response");
      System.out.format("Name: %s%n", entityTypeResponse.getName());
    }
  }
}
// [END aiplatform_create_entity_type_sample]

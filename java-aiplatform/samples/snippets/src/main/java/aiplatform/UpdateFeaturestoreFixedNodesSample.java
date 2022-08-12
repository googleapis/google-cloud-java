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
 * Update featurestore. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_update_featurestore_fixed_nodes_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.Featurestore;
import com.google.cloud.aiplatform.v1.Featurestore.OnlineServingConfig;
import com.google.cloud.aiplatform.v1.FeaturestoreName;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.UpdateFeaturestoreOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UpdateFeaturestoreFixedNodesSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    int fixedNodeCount = 1;
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    int timeout = 300;
    updateFeaturestoreFixedNodesSample(
        project, featurestoreId, fixedNodeCount, location, endpoint, timeout);
  }

  static void updateFeaturestoreFixedNodesSample(
      String project,
      String featurestoreId,
      int fixedNodeCount,
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

      OnlineServingConfig.Builder builderValue =
          OnlineServingConfig.newBuilder().setFixedNodeCount(fixedNodeCount);
      Featurestore featurestore =
          Featurestore.newBuilder()
              .setName(FeaturestoreName.of(project, location, featurestoreId).toString())
              .setOnlineServingConfig(builderValue)
              .build();

      UpdateFeaturestoreRequest request =
          UpdateFeaturestoreRequest.newBuilder().setFeaturestore(featurestore).build();

      OperationFuture<Featurestore, UpdateFeaturestoreOperationMetadata> updateFeaturestoreFuture =
          featurestoreServiceClient.updateFeaturestoreAsync(request);
      System.out.format(
          "Operation name: %s%n", updateFeaturestoreFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      Featurestore featurestoreResponse = updateFeaturestoreFuture.get(timeout, TimeUnit.SECONDS);
      System.out.println("Update Featurestore Fixed Nodes Response");
      System.out.format("Name: %s%n", featurestoreResponse.getName());
    }
  }
}
// [END aiplatform_update_featurestore_fixed_nodes_sample]

/*
 * Copyright 2019 Google LLC
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
 */

package com.google.cloud.vision.samples.automl;

// [START automl_vision_classification_deploy_model]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.DeployModelRequest;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class ClassificationDeployModel {

  // Deploy a model
  static void classificationDeployModel(String projectId, String modelId)
      throws IOException, ExecutionException, InterruptedException {
    // String projectId = "YOUR_PROJECT_ID";
    // String modelId = "YOUR_MODEL_ID";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {

      // Get the full path of the model.
      ModelName modelFullId = ModelName.of(projectId, "us-central1", modelId);

      // Build deploy model request.
      DeployModelRequest deployModelRequest =
          DeployModelRequest.newBuilder().setName(modelFullId.toString()).build();

      // Deploy a model with the deploy model request.
      OperationFuture<Empty, OperationMetadata> future =
          client.deployModelAsync(deployModelRequest);

      future.get();

      // Display the deployment details of model.
      System.out.println("Model deployment finished");
    }
  }
}
// [END automl_vision_classification_deploy_model]

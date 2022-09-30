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

// [START automl_vision_object_detection_deploy_model_node_count]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.DeployModelRequest;
import com.google.cloud.automl.v1beta1.ImageObjectDetectionModelDeploymentMetadata;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class ObjectDetectionDeployModelNodeCount {

  static void objectDetectionDeployModelNodeCount(String projectId, String modelId)
      throws IOException, ExecutionException, InterruptedException {
    // String projectId = "YOUR_PROJECT_ID";
    // String modelId = "YOUR_MODEL_ID";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the full path of the model.
      ModelName modelFullId = ModelName.of(projectId, "us-central1", modelId);

      // Set how many nodes the model is deployed on
      ImageObjectDetectionModelDeploymentMetadata deploymentMetadata =
          ImageObjectDetectionModelDeploymentMetadata.newBuilder().setNodeCount(2).build();

      DeployModelRequest request =
          DeployModelRequest.newBuilder()
              .setName(modelFullId.toString())
              .setImageObjectDetectionModelDeploymentMetadata(deploymentMetadata)
              .build();
      // Deploy the model
      OperationFuture<Empty, OperationMetadata> future = client.deployModelAsync(request);
      future.get();
      System.out.println("Model deployment on 2 nodes finished");
    }
  }
}
// [END automl_vision_object_detection_deploy_model_node_count]

/*
 * Copyright 2020 Google LLC
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

package beta.automl;

// [START automl_tables_deploy_model]
// [START automl_deploy_model_beta]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.DeployModelRequest;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class DeployModel {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    deployModel(projectId, modelId);
  }

  // Deploy a model for prediction
  static void deployModel(String projectId, String modelId)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the full path of the model.
      ModelName modelFullId = ModelName.of(projectId, "us-central1", modelId);
      DeployModelRequest request =
          DeployModelRequest.newBuilder().setName(modelFullId.toString()).build();
      OperationFuture<Empty, OperationMetadata> future = client.deployModelAsync(request);

      future.get();
      System.out.println("Model deployment finished");
    }
  }
}
// [END automl_deploy_model_beta]
// [END automl_tables_deploy_model]

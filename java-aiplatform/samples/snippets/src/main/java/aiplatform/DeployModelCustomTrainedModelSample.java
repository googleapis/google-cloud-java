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

package aiplatform;

// [START aiplatform_deploy_model_custom_trained_model_sample]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.DedicatedResources;
import com.google.cloud.aiplatform.v1.DeployModelOperationMetadata;
import com.google.cloud.aiplatform.v1.DeployModelResponse;
import com.google.cloud.aiplatform.v1.DeployedModel;
import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.EndpointServiceClient;
import com.google.cloud.aiplatform.v1.EndpointServiceSettings;
import com.google.cloud.aiplatform.v1.MachineSpec;
import com.google.cloud.aiplatform.v1.ModelName;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DeployModelCustomTrainedModelSample {

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String endpointId = "ENDPOINT_ID";
    String modelName = "MODEL_NAME";
    String deployedModelDisplayName = "DEPLOYED_MODEL_DISPLAY_NAME";
    deployModelCustomTrainedModelSample(project, endpointId, modelName, deployedModelDisplayName);
  }

  static void deployModelCustomTrainedModelSample(
      String project, String endpointId, String model, String deployedModelDisplayName)
      throws IOException, ExecutionException, InterruptedException {
    EndpointServiceSettings settings =
        EndpointServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (EndpointServiceClient client = EndpointServiceClient.create(settings)) {
      MachineSpec machineSpec = MachineSpec.newBuilder().setMachineType("n1-standard-2").build();
      DedicatedResources dedicatedResources =
          DedicatedResources.newBuilder().setMinReplicaCount(1).setMachineSpec(machineSpec).build();

      String modelName = ModelName.of(project, location, model).toString();
      DeployedModel deployedModel =
          DeployedModel.newBuilder()
              .setModel(modelName)
              .setDisplayName(deployedModelDisplayName)
              // `dedicated_resources` must be used for non-AutoML models
              .setDedicatedResources(dedicatedResources)
              .build();
      // key '0' assigns traffic for the newly deployed model
      // Traffic percentage values must add up to 100
      // Leave dictionary empty if endpoint should not accept any traffic
      Map<String, Integer> trafficSplit = new HashMap<>();
      trafficSplit.put("0", 100);
      EndpointName endpoint = EndpointName.of(project, location, endpointId);
      OperationFuture<DeployModelResponse, DeployModelOperationMetadata> response =
          client.deployModelAsync(endpoint, deployedModel, trafficSplit);

      // You can use OperationFuture.getInitialFuture to get a future representing the initial
      // response to the request, which contains information while the operation is in progress.
      System.out.format("Operation name: %s\n", response.getInitialFuture().get().getName());

      // OperationFuture.get() will block until the operation is finished.
      DeployModelResponse deployModelResponse = response.get();
      System.out.format("deployModelResponse: %s\n", deployModelResponse);
    }
  }
}

// [END aiplatform_deploy_model_custom_trained_model_sample]

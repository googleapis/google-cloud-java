/*
 * Copyright 2020 Google LLC
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

// [START aiplatform_deploy_model_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.AutomaticResources;
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DeployModelSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String deployedModelDisplayName = "YOUR_DEPLOYED_MODEL_DISPLAY_NAME";
    String endpointId = "YOUR_ENDPOINT_NAME";
    String modelId = "YOUR_MODEL_ID";
    deployModelSample(project, deployedModelDisplayName, endpointId, modelId);
  }

  static void deployModelSample(
      String project, String deployedModelDisplayName, String endpointId, String modelId)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    EndpointServiceSettings endpointServiceSettings =
        EndpointServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (EndpointServiceClient endpointServiceClient =
        EndpointServiceClient.create(endpointServiceSettings)) {
      String location = "us-central1";
      EndpointName endpointName = EndpointName.of(project, location, endpointId);
      // key '0' assigns traffic for the newly deployed model
      // Traffic percentage values must add up to 100
      // Leave dictionary empty if endpoint should not accept any traffic
      Map<String, Integer> trafficSplit = new HashMap<>();
      trafficSplit.put("0", 100);
      ModelName modelName = ModelName.of(project, location, modelId);
      AutomaticResources automaticResourcesInput =
          AutomaticResources.newBuilder().setMinReplicaCount(1).setMaxReplicaCount(1).build();
      DeployedModel deployedModelInput =
          DeployedModel.newBuilder()
              .setModel(modelName.toString())
              .setDisplayName(deployedModelDisplayName)
              .setAutomaticResources(automaticResourcesInput)
              .build();

      OperationFuture<DeployModelResponse, DeployModelOperationMetadata> deployModelResponseFuture =
          endpointServiceClient.deployModelAsync(endpointName, deployedModelInput, trafficSplit);
      System.out.format(
          "Operation name: %s\n", deployModelResponseFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      DeployModelResponse deployModelResponse = deployModelResponseFuture.get(20, TimeUnit.MINUTES);

      System.out.println("Deploy Model Response");
      DeployedModel deployedModel = deployModelResponse.getDeployedModel();
      System.out.println("\tDeployed Model");
      System.out.format("\t\tid: %s\n", deployedModel.getId());
      System.out.format("\t\tmodel: %s\n", deployedModel.getModel());
      System.out.format("\t\tDisplay Name: %s\n", deployedModel.getDisplayName());
      System.out.format("\t\tCreate Time: %s\n", deployedModel.getCreateTime());

      DedicatedResources dedicatedResources = deployedModel.getDedicatedResources();
      System.out.println("\t\tDedicated Resources");
      System.out.format("\t\t\tMin Replica Count: %s\n", dedicatedResources.getMinReplicaCount());

      MachineSpec machineSpec = dedicatedResources.getMachineSpec();
      System.out.println("\t\t\tMachine Spec");
      System.out.format("\t\t\t\tMachine Type: %s\n", machineSpec.getMachineType());
      System.out.format("\t\t\t\tAccelerator Type: %s\n", machineSpec.getAcceleratorType());
      System.out.format("\t\t\t\tAccelerator Count: %s\n", machineSpec.getAcceleratorCount());

      AutomaticResources automaticResources = deployedModel.getAutomaticResources();
      System.out.println("\t\tAutomatic Resources");
      System.out.format("\t\t\tMin Replica Count: %s\n", automaticResources.getMinReplicaCount());
      System.out.format("\t\t\tMax Replica Count: %s\n", automaticResources.getMaxReplicaCount());
    }
  }
}
// [END aiplatform_deploy_model_sample]

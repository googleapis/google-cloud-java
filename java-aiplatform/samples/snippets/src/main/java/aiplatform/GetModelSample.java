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

// [START aiplatform_get_model_sample]

import com.google.cloud.aiplatform.v1.DeployedModelRef;
import com.google.cloud.aiplatform.v1.EnvVar;
import com.google.cloud.aiplatform.v1.Model;
import com.google.cloud.aiplatform.v1.Model.ExportFormat;
import com.google.cloud.aiplatform.v1.ModelContainerSpec;
import com.google.cloud.aiplatform.v1.ModelName;
import com.google.cloud.aiplatform.v1.ModelServiceClient;
import com.google.cloud.aiplatform.v1.ModelServiceSettings;
import com.google.cloud.aiplatform.v1.Port;
import com.google.cloud.aiplatform.v1.PredictSchemata;
import java.io.IOException;

public class GetModelSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    getModelSample(project, modelId);
  }

  static void getModelSample(String project, String modelId) throws IOException {
    ModelServiceSettings modelServiceSettings =
        ModelServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings)) {
      String location = "us-central1";
      ModelName modelName = ModelName.of(project, location, modelId);

      Model modelResponse = modelServiceClient.getModel(modelName);
      System.out.println("Get Model response");
      System.out.format("\tName: %s\n", modelResponse.getName());
      System.out.format("\tDisplay Name: %s\n", modelResponse.getDisplayName());
      System.out.format("\tDescription: %s\n", modelResponse.getDescription());

      System.out.format("\tMetadata Schema Uri: %s\n", modelResponse.getMetadataSchemaUri());
      System.out.format("\tMetadata: %s\n", modelResponse.getMetadata());
      System.out.format("\tTraining Pipeline: %s\n", modelResponse.getTrainingPipeline());
      System.out.format("\tArtifact Uri: %s\n", modelResponse.getArtifactUri());

      System.out.format(
          "\tSupported Deployment Resources Types: %s\n",
          modelResponse.getSupportedDeploymentResourcesTypesList());
      System.out.format(
          "\tSupported Input Storage Formats: %s\n",
          modelResponse.getSupportedInputStorageFormatsList());
      System.out.format(
          "\tSupported Output Storage Formats: %s\n",
          modelResponse.getSupportedOutputStorageFormatsList());

      System.out.format("\tCreate Time: %s\n", modelResponse.getCreateTime());
      System.out.format("\tUpdate Time: %s\n", modelResponse.getUpdateTime());
      System.out.format("\tLabels: %s\n", modelResponse.getLabelsMap());

      PredictSchemata predictSchemata = modelResponse.getPredictSchemata();
      System.out.println("\tPredict Schemata");
      System.out.format("\t\tInstance Schema Uri: %s\n", predictSchemata.getInstanceSchemaUri());
      System.out.format(
          "\t\tParameters Schema Uri: %s\n", predictSchemata.getParametersSchemaUri());
      System.out.format(
          "\t\tPrediction Schema Uri: %s\n", predictSchemata.getPredictionSchemaUri());

      for (ExportFormat exportFormat : modelResponse.getSupportedExportFormatsList()) {
        System.out.println("\tSupported Export Format");
        System.out.format("\t\tId: %s\n", exportFormat.getId());
      }

      ModelContainerSpec containerSpec = modelResponse.getContainerSpec();
      System.out.println("\tContainer Spec");
      System.out.format("\t\tImage Uri: %s\n", containerSpec.getImageUri());
      System.out.format("\t\tCommand: %s\n", containerSpec.getCommandList());
      System.out.format("\t\tArgs: %s\n", containerSpec.getArgsList());
      System.out.format("\t\tPredict Route: %s\n", containerSpec.getPredictRoute());
      System.out.format("\t\tHealth Route: %s\n", containerSpec.getHealthRoute());

      for (EnvVar envVar : containerSpec.getEnvList()) {
        System.out.println("\t\tEnv");
        System.out.format("\t\t\tName: %s\n", envVar.getName());
        System.out.format("\t\t\tValue: %s\n", envVar.getValue());
      }

      for (Port port : containerSpec.getPortsList()) {
        System.out.println("\t\tPort");
        System.out.format("\t\t\tContainer Port: %s\n", port.getContainerPort());
      }

      for (DeployedModelRef deployedModelRef : modelResponse.getDeployedModelsList()) {
        System.out.println("\tDeployed Model");
        System.out.format("\t\tEndpoint: %s\n", deployedModelRef.getEndpoint());
        System.out.format("\t\tDeployed Model Id: %s\n", deployedModelRef.getDeployedModelId());
      }
    }
  }
}
// [END aiplatform_get_model_sample]

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

// [START aiplatform_create_training_pipeline_sample]

import com.google.cloud.aiplatform.v1.DeployedModelRef;
import com.google.cloud.aiplatform.v1.EnvVar;
import com.google.cloud.aiplatform.v1.FilterSplit;
import com.google.cloud.aiplatform.v1.FractionSplit;
import com.google.cloud.aiplatform.v1.InputDataConfig;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.Model;
import com.google.cloud.aiplatform.v1.Model.ExportFormat;
import com.google.cloud.aiplatform.v1.ModelContainerSpec;
import com.google.cloud.aiplatform.v1.PipelineServiceClient;
import com.google.cloud.aiplatform.v1.PipelineServiceSettings;
import com.google.cloud.aiplatform.v1.Port;
import com.google.cloud.aiplatform.v1.PredefinedSplit;
import com.google.cloud.aiplatform.v1.PredictSchemata;
import com.google.cloud.aiplatform.v1.TimestampSplit;
import com.google.cloud.aiplatform.v1.TrainingPipeline;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import com.google.rpc.Status;
import java.io.IOException;

public class CreateTrainingPipelineSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String trainingPipelineDisplayName = "YOUR_TRAINING_PIPELINE_DISPLAY_NAME";
    String project = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    String trainingTaskDefinition = "YOUR_TRAINING_TASK_DEFINITION";
    String modelDisplayName = "YOUR_MODEL_DISPLAY_NAME";
    createTrainingPipelineSample(
        project, trainingPipelineDisplayName, datasetId, trainingTaskDefinition, modelDisplayName);
  }

  static void createTrainingPipelineSample(
      String project,
      String trainingPipelineDisplayName,
      String datasetId,
      String trainingTaskDefinition,
      String modelDisplayName)
      throws IOException {
    PipelineServiceSettings pipelineServiceSettings =
        PipelineServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PipelineServiceClient pipelineServiceClient =
        PipelineServiceClient.create(pipelineServiceSettings)) {
      String location = "us-central1";
      LocationName locationName = LocationName.of(project, location);

      String jsonString =
          "{\"multiLabel\": false, \"modelType\": \"CLOUD\", \"budgetMilliNodeHours\": 8000,"
              + " \"disableEarlyStopping\": false}";
      Value.Builder trainingTaskInputs = Value.newBuilder();
      JsonFormat.parser().merge(jsonString, trainingTaskInputs);

      InputDataConfig trainingInputDataConfig =
          InputDataConfig.newBuilder().setDatasetId(datasetId).build();
      Model model = Model.newBuilder().setDisplayName(modelDisplayName).build();
      TrainingPipeline trainingPipeline =
          TrainingPipeline.newBuilder()
              .setDisplayName(trainingPipelineDisplayName)
              .setTrainingTaskDefinition(trainingTaskDefinition)
              .setTrainingTaskInputs(trainingTaskInputs)
              .setInputDataConfig(trainingInputDataConfig)
              .setModelToUpload(model)
              .build();

      TrainingPipeline trainingPipelineResponse =
          pipelineServiceClient.createTrainingPipeline(locationName, trainingPipeline);

      System.out.println("Create Training Pipeline Response");
      System.out.format("Name: %s\n", trainingPipelineResponse.getName());
      System.out.format("Display Name: %s\n", trainingPipelineResponse.getDisplayName());

      System.out.format(
          "Training Task Definition %s\n", trainingPipelineResponse.getTrainingTaskDefinition());
      System.out.format(
          "Training Task Inputs: %s\n", trainingPipelineResponse.getTrainingTaskInputs());
      System.out.format(
          "Training Task Metadata: %s\n", trainingPipelineResponse.getTrainingTaskMetadata());
      System.out.format("State: %s\n", trainingPipelineResponse.getState());

      System.out.format("Create Time: %s\n", trainingPipelineResponse.getCreateTime());
      System.out.format("StartTime %s\n", trainingPipelineResponse.getStartTime());
      System.out.format("End Time: %s\n", trainingPipelineResponse.getEndTime());
      System.out.format("Update Time: %s\n", trainingPipelineResponse.getUpdateTime());
      System.out.format("Labels: %s\n", trainingPipelineResponse.getLabelsMap());

      InputDataConfig inputDataConfig = trainingPipelineResponse.getInputDataConfig();
      System.out.println("Input Data Config");
      System.out.format("Dataset Id: %s", inputDataConfig.getDatasetId());
      System.out.format("Annotations Filter: %s\n", inputDataConfig.getAnnotationsFilter());

      FractionSplit fractionSplit = inputDataConfig.getFractionSplit();
      System.out.println("Fraction Split");
      System.out.format("Training Fraction: %s\n", fractionSplit.getTrainingFraction());
      System.out.format("Validation Fraction: %s\n", fractionSplit.getValidationFraction());
      System.out.format("Test Fraction: %s\n", fractionSplit.getTestFraction());

      FilterSplit filterSplit = inputDataConfig.getFilterSplit();
      System.out.println("Filter Split");
      System.out.format("Training Filter: %s\n", filterSplit.getTrainingFilter());
      System.out.format("Validation Filter: %s\n", filterSplit.getValidationFilter());
      System.out.format("Test Filter: %s\n", filterSplit.getTestFilter());

      PredefinedSplit predefinedSplit = inputDataConfig.getPredefinedSplit();
      System.out.println("Predefined Split");
      System.out.format("Key: %s\n", predefinedSplit.getKey());

      TimestampSplit timestampSplit = inputDataConfig.getTimestampSplit();
      System.out.println("Timestamp Split");
      System.out.format("Training Fraction: %s\n", timestampSplit.getTrainingFraction());
      System.out.format("Validation Fraction: %s\n", timestampSplit.getValidationFraction());
      System.out.format("Test Fraction: %s\n", timestampSplit.getTestFraction());
      System.out.format("Key: %s\n", timestampSplit.getKey());

      Model modelResponse = trainingPipelineResponse.getModelToUpload();
      System.out.println("Model To Upload");
      System.out.format("Name: %s\n", modelResponse.getName());
      System.out.format("Display Name: %s\n", modelResponse.getDisplayName());
      System.out.format("Description: %s\n", modelResponse.getDescription());

      System.out.format("Metadata Schema Uri: %s\n", modelResponse.getMetadataSchemaUri());
      System.out.format("Metadata: %s\n", modelResponse.getMetadata());
      System.out.format("Training Pipeline: %s\n", modelResponse.getTrainingPipeline());
      System.out.format("Artifact Uri: %s\n", modelResponse.getArtifactUri());

      System.out.format(
          "Supported Deployment Resources Types: %s\n",
          modelResponse.getSupportedDeploymentResourcesTypesList());
      System.out.format(
          "Supported Input Storage Formats: %s\n",
          modelResponse.getSupportedInputStorageFormatsList());
      System.out.format(
          "Supported Output Storage Formats: %s\n",
          modelResponse.getSupportedOutputStorageFormatsList());

      System.out.format("Create Time: %s\n", modelResponse.getCreateTime());
      System.out.format("Update Time: %s\n", modelResponse.getUpdateTime());
      System.out.format("Labels: %sn\n", modelResponse.getLabelsMap());

      PredictSchemata predictSchemata = modelResponse.getPredictSchemata();
      System.out.println("Predict Schemata");
      System.out.format("Instance Schema Uri: %s\n", predictSchemata.getInstanceSchemaUri());
      System.out.format("Parameters Schema Uri: %s\n", predictSchemata.getParametersSchemaUri());
      System.out.format("Prediction Schema Uri: %s\n", predictSchemata.getPredictionSchemaUri());

      for (ExportFormat exportFormat : modelResponse.getSupportedExportFormatsList()) {
        System.out.println("Supported Export Format");
        System.out.format("Id: %s\n", exportFormat.getId());
      }

      ModelContainerSpec modelContainerSpec = modelResponse.getContainerSpec();
      System.out.println("Container Spec");
      System.out.format("Image Uri: %s\n", modelContainerSpec.getImageUri());
      System.out.format("Command: %s\n", modelContainerSpec.getCommandList());
      System.out.format("Args: %s\n", modelContainerSpec.getArgsList());
      System.out.format("Predict Route: %s\n", modelContainerSpec.getPredictRoute());
      System.out.format("Health Route: %s\n", modelContainerSpec.getHealthRoute());

      for (EnvVar envVar : modelContainerSpec.getEnvList()) {
        System.out.println("Env");
        System.out.format("Name: %s\n", envVar.getName());
        System.out.format("Value: %s\n", envVar.getValue());
      }

      for (Port port : modelContainerSpec.getPortsList()) {
        System.out.println("Port");
        System.out.format("Container Port: %s\n", port.getContainerPort());
      }

      for (DeployedModelRef deployedModelRef : modelResponse.getDeployedModelsList()) {
        System.out.println("Deployed Model");
        System.out.format("Endpoint: %s\n", deployedModelRef.getEndpoint());
        System.out.format("Deployed Model Id: %s\n", deployedModelRef.getDeployedModelId());
      }

      Status status = trainingPipelineResponse.getError();
      System.out.println("Error");
      System.out.format("Code: %s\n", status.getCode());
      System.out.format("Message: %s\n", status.getMessage());
    }
  }
}
// [END aiplatform_create_training_pipeline_sample]

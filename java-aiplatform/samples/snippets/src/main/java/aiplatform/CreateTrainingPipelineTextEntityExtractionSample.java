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

// [START aiplatform_create_training_pipeline_text_entity_extraction_sample]

import com.google.cloud.aiplatform.v1beta1.DeployedModelRef;
import com.google.cloud.aiplatform.v1beta1.EnvVar;
import com.google.cloud.aiplatform.v1beta1.ExplanationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExplanationParameters;
import com.google.cloud.aiplatform.v1beta1.ExplanationSpec;
import com.google.cloud.aiplatform.v1beta1.FilterSplit;
import com.google.cloud.aiplatform.v1beta1.FractionSplit;
import com.google.cloud.aiplatform.v1beta1.InputDataConfig;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.cloud.aiplatform.v1beta1.Model;
import com.google.cloud.aiplatform.v1beta1.Model.ExportFormat;
import com.google.cloud.aiplatform.v1beta1.ModelContainerSpec;
import com.google.cloud.aiplatform.v1beta1.PipelineServiceClient;
import com.google.cloud.aiplatform.v1beta1.PipelineServiceSettings;
import com.google.cloud.aiplatform.v1beta1.Port;
import com.google.cloud.aiplatform.v1beta1.PredefinedSplit;
import com.google.cloud.aiplatform.v1beta1.PredictSchemata;
import com.google.cloud.aiplatform.v1beta1.SampledShapleyAttribution;
import com.google.cloud.aiplatform.v1beta1.TimestampSplit;
import com.google.cloud.aiplatform.v1beta1.TrainingPipeline;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import com.google.rpc.Status;
import java.io.IOException;

public class CreateTrainingPipelineTextEntityExtractionSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String trainingPipelineDisplayName = "YOUR_TRAINING_PIPELINE_DISPLAY_NAME";
    String project = "YOUR_PROJECT_ID";
    String datasetId = "YOUR_DATASET_ID";
    String modelDisplayName = "YOUR_MODEL_DISPLAY_NAME";

    createTrainingPipelineTextEntityExtractionSample(
        project, trainingPipelineDisplayName, datasetId, modelDisplayName);
  }

  static void createTrainingPipelineTextEntityExtractionSample(
      String project, String trainingPipelineDisplayName, String datasetId, String modelDisplayName)
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
      String trainingTaskDefinition =
          "gs://google-cloud-aiplatform/schema/trainingjob/definition/"
              + "automl_text_extraction_1.0.0.yaml";
      String jsonString = "{}";

      LocationName locationName = LocationName.of(project, location);

      // Training task inputs are empty for text entity extraction
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

      System.out.println("Create Training Pipeline Text Entity Extraction Response");
      System.out.format("\tName: %s\n", trainingPipelineResponse.getName());
      System.out.format("\tDisplay Name: %s\n", trainingPipelineResponse.getDisplayName());

      System.out.format(
          "\tTraining Task Definition %s\n", trainingPipelineResponse.getTrainingTaskDefinition());
      System.out.format(
          "\tTraining Task Inputs: %s\n", trainingPipelineResponse.getTrainingTaskInputs());
      System.out.format(
          "\tTraining Task Metadata: %s\n", trainingPipelineResponse.getTrainingTaskMetadata());
      System.out.format("State: %s\n", trainingPipelineResponse.getState());

      System.out.format("\tCreate Time: %s\n", trainingPipelineResponse.getCreateTime());
      System.out.format("\tStartTime %s\n", trainingPipelineResponse.getStartTime());
      System.out.format("\tEnd Time: %s\n", trainingPipelineResponse.getEndTime());
      System.out.format("\tUpdate Time: %s\n", trainingPipelineResponse.getUpdateTime());
      System.out.format("\tLabels: %s\n", trainingPipelineResponse.getLabelsMap());

      InputDataConfig inputDataConfig = trainingPipelineResponse.getInputDataConfig();
      System.out.println("\tInput Data Config");
      System.out.format("\t\tDataset Id: %s", inputDataConfig.getDatasetId());
      System.out.format("\t\tAnnotations Filter: %s\n", inputDataConfig.getAnnotationsFilter());

      FractionSplit fractionSplit = inputDataConfig.getFractionSplit();
      System.out.println("\t\tFraction Split");
      System.out.format("\t\t\tTraining Fraction: %s\n", fractionSplit.getTrainingFraction());
      System.out.format("\t\t\tValidation Fraction: %s\n", fractionSplit.getValidationFraction());
      System.out.format("\t\t\tTest Fraction: %s\n", fractionSplit.getTestFraction());

      FilterSplit filterSplit = inputDataConfig.getFilterSplit();
      System.out.println("\t\tFilter Split");
      System.out.format("\t\t\tTraining Filter: %s\n", filterSplit.getTrainingFilter());
      System.out.format("\t\t\tValidation Filter: %s\n", filterSplit.getValidationFilter());
      System.out.format("\t\t\tTest Filter: %s\n", filterSplit.getTestFilter());

      PredefinedSplit predefinedSplit = inputDataConfig.getPredefinedSplit();
      System.out.println("\t\tPredefined Split");
      System.out.format("\t\t\tKey: %s\n", predefinedSplit.getKey());

      TimestampSplit timestampSplit = inputDataConfig.getTimestampSplit();
      System.out.println("\t\tTimestamp Split");
      System.out.format("\t\t\tTraining Fraction: %s\n", timestampSplit.getTrainingFraction());
      System.out.format("\t\t\tValidation Fraction: %s\n", timestampSplit.getValidationFraction());
      System.out.format("\t\t\tTest Fraction: %s\n", timestampSplit.getTestFraction());
      System.out.format("\t\t\tKey: %s\n", timestampSplit.getKey());

      Model modelResponse = trainingPipelineResponse.getModelToUpload();
      System.out.println("\tModel To Upload");
      System.out.format("\t\tName: %s\n", modelResponse.getName());
      System.out.format("\t\tDisplay Name: %s\n", modelResponse.getDisplayName());
      System.out.format("\t\tDescription: %s\n", modelResponse.getDescription());

      System.out.format("\t\tMetadata Schema Uri: %s\n", modelResponse.getMetadataSchemaUri());
      System.out.format("\t\tMetadata: %s\n", modelResponse.getMetadata());
      System.out.format("\t\tTraining Pipeline: %s\n", modelResponse.getTrainingPipeline());
      System.out.format("\t\tArtifact Uri: %s\n", modelResponse.getArtifactUri());

      System.out.format(
          "\t\tSupported Deployment Resources Types: %s\n",
          modelResponse.getSupportedDeploymentResourcesTypesList());
      System.out.format(
          "\t\tSupported Input Storage Formats: %s\n",
          modelResponse.getSupportedInputStorageFormatsList());
      System.out.format(
          "\t\tSupported Output Storage Formats: %s\n",
          modelResponse.getSupportedOutputStorageFormatsList());

      System.out.format("\t\tCreate Time: %s\n", modelResponse.getCreateTime());
      System.out.format("\t\tUpdate Time: %s\n", modelResponse.getUpdateTime());
      System.out.format("\t\tLabels: %sn\n", modelResponse.getLabelsMap());

      PredictSchemata predictSchemata = modelResponse.getPredictSchemata();
      System.out.println("\t\tPredict Schemata");
      System.out.format("\t\t\tInstance Schema Uri: %s\n", predictSchemata.getInstanceSchemaUri());
      System.out.format(
          "\t\t\tParameters Schema Uri: %s\n", predictSchemata.getParametersSchemaUri());
      System.out.format(
          "\t\t\tPrediction Schema Uri: %s\n", predictSchemata.getPredictionSchemaUri());

      for (ExportFormat exportFormat : modelResponse.getSupportedExportFormatsList()) {
        System.out.println("\t\tSupported Export Format");
        System.out.format("\t\t\tId: %s\n", exportFormat.getId());
      }

      ModelContainerSpec modelContainerSpec = modelResponse.getContainerSpec();
      System.out.println("\t\tContainer Spec");
      System.out.format("\t\t\tImage Uri: %s\n", modelContainerSpec.getImageUri());
      System.out.format("\t\t\tCommand: %s\n", modelContainerSpec.getCommandList());
      System.out.format("\t\t\tArgs: %s\n", modelContainerSpec.getArgsList());
      System.out.format("\t\t\tPredict Route: %s\n", modelContainerSpec.getPredictRoute());
      System.out.format("\t\t\tHealth Route: %s\n", modelContainerSpec.getHealthRoute());

      for (EnvVar envVar : modelContainerSpec.getEnvList()) {
        System.out.println("\t\t\tEnv");
        System.out.format("\t\t\t\tName: %s\n", envVar.getName());
        System.out.format("\t\t\t\tValue: %s\n", envVar.getValue());
      }

      for (Port port : modelContainerSpec.getPortsList()) {
        System.out.println("\t\t\tPort");
        System.out.format("\t\t\t\tContainer Port: %s\n", port.getContainerPort());
      }

      for (DeployedModelRef deployedModelRef : modelResponse.getDeployedModelsList()) {
        System.out.println("\t\tDeployed Model");
        System.out.format("\t\t\tEndpoint: %s\n", deployedModelRef.getEndpoint());
        System.out.format("\t\t\tDeployed Model Id: %s\n", deployedModelRef.getDeployedModelId());
      }

      ExplanationSpec explanationSpec = modelResponse.getExplanationSpec();
      System.out.println("\t\tExplanation Spec");

      ExplanationParameters explanationParameters = explanationSpec.getParameters();
      System.out.println("\t\t\tParameters");

      SampledShapleyAttribution sampledShapleyAttribution =
          explanationParameters.getSampledShapleyAttribution();
      System.out.println("\t\t\t\tSampled Shapley Attribution");
      System.out.format("\t\t\t\t\tPath Count: %s\n", sampledShapleyAttribution.getPathCount());

      ExplanationMetadata explanationMetadata = explanationSpec.getMetadata();
      System.out.println("\t\t\tMetadata");
      System.out.format("\t\t\t\tInputs: %s\n", explanationMetadata.getInputsMap());
      System.out.format("\t\t\t\tOutputs: %s\n", explanationMetadata.getOutputsMap());
      System.out.format(
          "\t\t\t\tFeature Attributions Schema_uri: %s\n",
          explanationMetadata.getFeatureAttributionsSchemaUri());

      Status status = trainingPipelineResponse.getError();
      System.out.println("\tError");
      System.out.format("\t\tCode: %s\n", status.getCode());
      System.out.format("\t\tMessage: %s\n", status.getMessage());
    }
  }
}
// [END aiplatform_create_training_pipeline_text_entity_extraction_sample]

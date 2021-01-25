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

// [START aiplatform_create_training_pipeline_video_object_tracking_sample]

import com.google.cloud.aiplatform.util.ValueConverter;
import com.google.cloud.aiplatform.v1beta1.FilterSplit;
import com.google.cloud.aiplatform.v1beta1.FractionSplit;
import com.google.cloud.aiplatform.v1beta1.InputDataConfig;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.cloud.aiplatform.v1beta1.Model;
import com.google.cloud.aiplatform.v1beta1.PipelineServiceClient;
import com.google.cloud.aiplatform.v1beta1.PipelineServiceSettings;
import com.google.cloud.aiplatform.v1beta1.PredefinedSplit;
import com.google.cloud.aiplatform.v1beta1.TimestampSplit;
import com.google.cloud.aiplatform.v1beta1.TrainingPipeline;
import com.google.cloud.aiplatform.v1beta1.schema.trainingjob.definition.AutoMlVideoObjectTrackingInputs;
import com.google.cloud.aiplatform.v1beta1.schema.trainingjob.definition.AutoMlVideoObjectTrackingInputs.ModelType;
import com.google.rpc.Status;
import java.io.IOException;

public class CreateTrainingPipelineVideoObjectTrackingSample {

  public static void main(String[] args) throws IOException {
    String trainingPipelineVideoObjectTracking =
        "YOUR_TRAINING_PIPELINE_VIDEO_OBJECT_TRACKING_DISPLAY_NAME";
    String datasetId = "YOUR_DATASET_ID";
    String modelDisplayName = "YOUR_MODEL_DISPLAY_NAME";
    String project = "YOUR_PROJECT_ID";
    createTrainingPipelineVideoObjectTracking(
        trainingPipelineVideoObjectTracking, datasetId, modelDisplayName, project);
  }

  static void createTrainingPipelineVideoObjectTracking(
      String trainingPipelineVideoObjectTracking,
      String datasetId,
      String modelDisplayName,
      String project)
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
              + "automl_video_object_tracking_1.0.0.yaml";
      LocationName locationName = LocationName.of(project, location);

      AutoMlVideoObjectTrackingInputs trainingTaskInputs =
          AutoMlVideoObjectTrackingInputs.newBuilder()
              .setModelType(ModelType.CLOUD)
              .build();

      InputDataConfig inputDataConfig =
          InputDataConfig.newBuilder().setDatasetId(datasetId).build();
      Model modelToUpload = Model.newBuilder().setDisplayName(modelDisplayName).build();
      TrainingPipeline trainingPipeline =
          TrainingPipeline.newBuilder()
              .setDisplayName(trainingPipelineVideoObjectTracking)
              .setTrainingTaskDefinition(trainingTaskDefinition)
              .setTrainingTaskInputs(ValueConverter.toValue(trainingTaskInputs))
              .setInputDataConfig(inputDataConfig)
              .setModelToUpload(modelToUpload)
              .build();

      TrainingPipeline createTrainingPipelineResponse =
          pipelineServiceClient.createTrainingPipeline(locationName, trainingPipeline);

      System.out.println("Create Training Pipeline Video Object Tracking Response");
      System.out.format("Name: %s\n", createTrainingPipelineResponse.getName());
      System.out.format("Display Name: %s\n", createTrainingPipelineResponse.getDisplayName());

      System.out.format(
          "Training Task Definition %s\n",
          createTrainingPipelineResponse.getTrainingTaskDefinition());
      System.out.format(
          "Training Task Inputs: %s\n",
          createTrainingPipelineResponse.getTrainingTaskInputs().toString());
      System.out.format(
          "Training Task Metadata: %s\n",
          createTrainingPipelineResponse.getTrainingTaskMetadata().toString());

      System.out.format("State: %s\n", createTrainingPipelineResponse.getState().toString());
      System.out.format(
          "Create Time: %s\n", createTrainingPipelineResponse.getCreateTime().toString());
      System.out.format("StartTime %s\n", createTrainingPipelineResponse.getStartTime().toString());
      System.out.format("End Time: %s\n", createTrainingPipelineResponse.getEndTime().toString());
      System.out.format(
          "Update Time: %s\n", createTrainingPipelineResponse.getUpdateTime().toString());
      System.out.format("Labels: %s\n", createTrainingPipelineResponse.getLabelsMap().toString());

      InputDataConfig inputDataConfigResponse = createTrainingPipelineResponse.getInputDataConfig();
      System.out.println("Input Data config");
      System.out.format("Dataset Id: %s\n", inputDataConfigResponse.getDatasetId());
      System.out.format("Annotations Filter: %s\n", inputDataConfigResponse.getAnnotationsFilter());

      FractionSplit fractionSplit = inputDataConfigResponse.getFractionSplit();
      System.out.println("Fraction split");
      System.out.format("Training Fraction: %s\n", fractionSplit.getTrainingFraction());
      System.out.format("Validation Fraction: %s\n", fractionSplit.getValidationFraction());
      System.out.format("Test Fraction: %s\n", fractionSplit.getTestFraction());

      FilterSplit filterSplit = inputDataConfigResponse.getFilterSplit();
      System.out.println("Filter Split");
      System.out.format("Training Filter: %s\n", filterSplit.getTrainingFilter());
      System.out.format("Validation Filter: %s\n", filterSplit.getValidationFilter());
      System.out.format("Test Filter: %s\n", filterSplit.getTestFilter());

      PredefinedSplit predefinedSplit = inputDataConfigResponse.getPredefinedSplit();
      System.out.println("Predefined Split");
      System.out.format("Key: %s\n", predefinedSplit.getKey());

      TimestampSplit timestampSplit = inputDataConfigResponse.getTimestampSplit();
      System.out.println("Timestamp Split");
      System.out.format("Training Fraction: %s\n", timestampSplit.getTrainingFraction());
      System.out.format("Validation Fraction: %s\n", timestampSplit.getValidationFraction());
      System.out.format("Test Fraction: %s\n", timestampSplit.getTestFraction());
      System.out.format("Key: %s\n", timestampSplit.getKey());

      Model modelResponse = createTrainingPipelineResponse.getModelToUpload();
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
          modelResponse.getSupportedDeploymentResourcesTypesList().toString());
      System.out.format(
          "Supported Input Storage Formats: %s\n",
          modelResponse.getSupportedInputStorageFormatsList().toString());
      System.out.format(
          "Supported Output Storage Formats: %s\n",
          modelResponse.getSupportedOutputStorageFormatsList().toString());

      System.out.format("Create Time: %s\n", modelResponse.getCreateTime());
      System.out.format("Update Time: %s\n", modelResponse.getUpdateTime());
      System.out.format("Labels: %s\n", modelResponse.getLabelsMap());

      Status status = createTrainingPipelineResponse.getError();
      System.out.println("Error");
      System.out.format("Code: %s\n", status.getCode());
      System.out.format("Message: %s\n", status.getMessage());
    }
  }
}
// [END aiplatform_create_training_pipeline_video_object_tracking_sample]

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

// [START aiplatform_create_training_pipeline_video_classification_sample]

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
import com.google.rpc.Status;
import java.io.IOException;

public class CreateTrainingPipelineVideoClassificationSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String videoClassificationDisplayName =
        "YOUR_TRAINING_PIPELINE_VIDEO_CLASSIFICATION_DISPLAY_NAME";
    String datasetId = "YOUR_DATASET_ID";
    String modelDisplayName = "YOUR_MODEL_DISPLAY_NAME";
    String project = "YOUR_PROJECT_ID";
    createTrainingPipelineVideoClassification(
        videoClassificationDisplayName, datasetId, modelDisplayName, project);
  }

  static void createTrainingPipelineVideoClassification(
      String videoClassificationDisplayName,
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
      LocationName locationName = LocationName.of(project, location);
      String trainingTaskDefinition =
          "gs://google-cloud-aiplatform/schema/trainingjob/definition/"
              + "automl_video_classification_1.0.0.yaml";

      InputDataConfig inputDataConfig =
          InputDataConfig.newBuilder().setDatasetId(datasetId).build();
      Model model = Model.newBuilder().setDisplayName(modelDisplayName).build();

      TrainingPipeline trainingPipeline =
          TrainingPipeline.newBuilder()
              .setDisplayName(videoClassificationDisplayName)
              .setTrainingTaskDefinition(trainingTaskDefinition)
              .setTrainingTaskInputs(ValueConverter.EMPTY_VALUE)
              .setInputDataConfig(inputDataConfig)
              .setModelToUpload(model)
              .build();

      TrainingPipeline trainingPipelineResponse =
          pipelineServiceClient.createTrainingPipeline(locationName, trainingPipeline);

      System.out.println("Create Training Pipeline Video Classification Response");
      System.out.format("\tName: %s\n", trainingPipelineResponse.getName());
      System.out.format("\tDisplay Name: %s\n", trainingPipelineResponse.getDisplayName());
      System.out.format(
          "\tTraining Task Definition: %s\n", trainingPipelineResponse.getTrainingTaskDefinition());
      System.out.format(
          "\tTraining Task Inputs: %s\n", trainingPipelineResponse.getTrainingTaskInputs());
      System.out.format(
          "\tTraining Task Metadata: %s\n", trainingPipelineResponse.getTrainingTaskMetadata());
      System.out.format("\tState: %s\n", trainingPipelineResponse.getState());
      System.out.format("\tCreate Time: %s\n", trainingPipelineResponse.getCreateTime());
      System.out.format("\tStart Time: %s\n", trainingPipelineResponse.getStartTime());
      System.out.format("\tEnd Time: %s\n", trainingPipelineResponse.getEndTime());
      System.out.format("\tUpdate Time: %s\n", trainingPipelineResponse.getUpdateTime());
      System.out.format("\tLabels: %s\n", trainingPipelineResponse.getLabelsMap());

      InputDataConfig inputDataConfigResponse = trainingPipelineResponse.getInputDataConfig();
      System.out.println("\tInput Data Config");
      System.out.format("\t\tDataset Id: %s\n", inputDataConfigResponse.getDatasetId());
      System.out.format(
          "\t\tAnnotations Filter: %s\n", inputDataConfigResponse.getAnnotationsFilter());

      FractionSplit fractionSplit = inputDataConfigResponse.getFractionSplit();
      System.out.println("\t\tFraction Split");
      System.out.format("\t\t\tTraining Fraction: %s\n", fractionSplit.getTrainingFraction());
      System.out.format("\t\t\tValidation Fraction: %s\n", fractionSplit.getValidationFraction());
      System.out.format("\t\t\tTest Fraction: %s\n", fractionSplit.getTestFraction());

      FilterSplit filterSplit = inputDataConfigResponse.getFilterSplit();
      System.out.println("\t\tFilter Split");
      System.out.format("\t\t\tTraining Fraction: %s\n", filterSplit.getTrainingFilter());
      System.out.format("\t\t\tValidation Fraction: %s\n", filterSplit.getValidationFilter());
      System.out.format("\t\t\tTest Fraction: %s\n", filterSplit.getTestFilter());

      PredefinedSplit predefinedSplit = inputDataConfigResponse.getPredefinedSplit();
      System.out.println("\t\tPredefined Split");
      System.out.format("\t\t\tKey: %s\n", predefinedSplit.getKey());

      TimestampSplit timestampSplit = inputDataConfigResponse.getTimestampSplit();
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
      System.out.format("\t\tMeta Data: %s\n", modelResponse.getMetadata());
      System.out.format("\t\tTraining Pipeline: %s\n", modelResponse.getTrainingPipeline());
      System.out.format("\t\tArtifact Uri: %s\n", modelResponse.getArtifactUri());
      System.out.format(
          "\t\tSupported Deployment Resources Types: %s\n",
          modelResponse.getSupportedDeploymentResourcesTypesList().toString());
      System.out.format(
          "\t\tSupported Input Storage Formats: %s\n",
          modelResponse.getSupportedInputStorageFormatsList().toString());
      System.out.format(
          "\t\tSupported Output Storage Formats: %s\n",
          modelResponse.getSupportedOutputStorageFormatsList().toString());
      System.out.format("\t\tCreate Time: %s\n", modelResponse.getCreateTime());
      System.out.format("\t\tUpdate Time: %s\n", modelResponse.getUpdateTime());
      System.out.format("\t\tLables: %s\n", modelResponse.getLabelsMap());

      Status status = trainingPipelineResponse.getError();
      System.out.println("\tError");
      System.out.format("\t\tCode: %s\n", status.getCode());
      System.out.format("\t\tMessage: %s\n", status.getMessage());
    }
  }
}
// [END aiplatform_create_training_pipeline_video_classification_sample]

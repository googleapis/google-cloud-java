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

// [START aiplatform_create_training_pipeline_custom_training_managed_dataset_sample]
import com.google.cloud.aiplatform.v1.GcsDestination;
import com.google.cloud.aiplatform.v1.InputDataConfig;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.Model;
import com.google.cloud.aiplatform.v1.ModelContainerSpec;
import com.google.cloud.aiplatform.v1.PipelineServiceClient;
import com.google.cloud.aiplatform.v1.PipelineServiceSettings;
import com.google.cloud.aiplatform.v1.TrainingPipeline;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;

public class CreateTrainingPipelineCustomTrainingManagedDatasetSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String displayName = "DISPLAY_NAME";
    String modelDisplayName = "MODEL_DISPLAY_NAME";
    String datasetId = "DATASET_ID";
    String annotationSchemaUri = "ANNOTATION_SCHEMA_URI";
    String trainingContainerSpecImageUri = "TRAINING_CONTAINER_SPEC_IMAGE_URI";
    String modelContainerSpecImageUri = "MODEL_CONTAINER_SPEC_IMAGE_URI";
    String baseOutputUriPrefix = "BASE_OUTPUT_URI_PREFIX";
    createTrainingPipelineCustomTrainingManagedDatasetSample(
        project,
        displayName,
        modelDisplayName,
        datasetId,
        annotationSchemaUri,
        trainingContainerSpecImageUri,
        modelContainerSpecImageUri,
        baseOutputUriPrefix);
  }

  static void createTrainingPipelineCustomTrainingManagedDatasetSample(
      String project,
      String displayName,
      String modelDisplayName,
      String datasetId,
      String annotationSchemaUri,
      String trainingContainerSpecImageUri,
      String modelContainerSpecImageUri,
      String baseOutputUriPrefix)
      throws IOException {
    PipelineServiceSettings settings =
        PipelineServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PipelineServiceClient client = PipelineServiceClient.create(settings)) {
      JsonArray jsonArgs = new JsonArray();
      jsonArgs.add("--model-dir=$(AIP_MODEL_DIR)");
      // training_task_inputs
      JsonObject jsonTrainingContainerSpec = new JsonObject();
      jsonTrainingContainerSpec.addProperty("imageUri", trainingContainerSpecImageUri);
      // AIP_MODEL_DIR is set by the service according to baseOutputDirectory.
      jsonTrainingContainerSpec.add("args", jsonArgs);

      JsonObject jsonMachineSpec = new JsonObject();
      jsonMachineSpec.addProperty("machineType", "n1-standard-8");

      JsonObject jsonTrainingWorkerPoolSpec = new JsonObject();
      jsonTrainingWorkerPoolSpec.addProperty("replicaCount", 1);
      jsonTrainingWorkerPoolSpec.add("machineSpec", jsonMachineSpec);
      jsonTrainingWorkerPoolSpec.add("containerSpec", jsonTrainingContainerSpec);

      JsonArray jsonWorkerPoolSpecs = new JsonArray();
      jsonWorkerPoolSpecs.add(jsonTrainingWorkerPoolSpec);

      JsonObject jsonBaseOutputDirectory = new JsonObject();
      jsonBaseOutputDirectory.addProperty("outputUriPrefix", baseOutputUriPrefix);

      JsonObject jsonTrainingTaskInputs = new JsonObject();
      jsonTrainingTaskInputs.add("workerPoolSpecs", jsonWorkerPoolSpecs);
      jsonTrainingTaskInputs.add("baseOutputDirectory", jsonBaseOutputDirectory);

      Value.Builder trainingTaskInputsBuilder = Value.newBuilder();
      JsonFormat.parser().merge(jsonTrainingTaskInputs.toString(), trainingTaskInputsBuilder);
      Value trainingTaskInputs = trainingTaskInputsBuilder.build();
      // model_to_upload
      ModelContainerSpec modelContainerSpec =
          ModelContainerSpec.newBuilder().setImageUri(modelContainerSpecImageUri).build();
      Model model =
          Model.newBuilder()
              .setDisplayName(modelDisplayName)
              .setContainerSpec(modelContainerSpec)
              .build();
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(baseOutputUriPrefix).build();

      // input_data_config
      InputDataConfig inputDataConfig =
          InputDataConfig.newBuilder()
              .setDatasetId(datasetId)
              .setAnnotationSchemaUri(annotationSchemaUri)
              .setGcsDestination(gcsDestination)
              .build();

      // training_task_definition
      String customTaskDefinition =
          "gs://google-cloud-aiplatform/schema/trainingjob/definition/custom_task_1.0.0.yaml";

      TrainingPipeline trainingPipeline =
          TrainingPipeline.newBuilder()
              .setDisplayName(displayName)
              .setInputDataConfig(inputDataConfig)
              .setTrainingTaskDefinition(customTaskDefinition)
              .setTrainingTaskInputs(trainingTaskInputs)
              .setModelToUpload(model)
              .build();
      LocationName parent = LocationName.of(project, location);
      TrainingPipeline response = client.createTrainingPipeline(parent, trainingPipeline);
      System.out.format("response: %s\n", response);
      System.out.format("Name: %s\n", response.getName());
    }
  }
}

// [END aiplatform_create_training_pipeline_custom_training_managed_dataset_sample]

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

// [START aiplatform_create_batch_prediction_job_sample]
import com.google.cloud.aiplatform.v1beta1.AcceleratorType;
import com.google.cloud.aiplatform.v1beta1.BatchDedicatedResources;
import com.google.cloud.aiplatform.v1beta1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1beta1.GcsDestination;
import com.google.cloud.aiplatform.v1beta1.GcsSource;
import com.google.cloud.aiplatform.v1beta1.JobServiceClient;
import com.google.cloud.aiplatform.v1beta1.JobServiceSettings;
import com.google.cloud.aiplatform.v1beta1.LocationName;
import com.google.cloud.aiplatform.v1beta1.MachineSpec;
import com.google.cloud.aiplatform.v1beta1.ModelName;
import com.google.gson.JsonObject;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;

public class CreateBatchPredictionJobSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String displayName = "DISPLAY_NAME";
    String modelName = "MODEL_NAME";
    String instancesFormat = "INSTANCES_FORMAT";
    String gcsSourceUri = "GCS_SOURCE_URI";
    String predictionsFormat = "PREDICTIONS_FORMAT";
    String gcsDestinationOutputUriPrefix = "GCS_DESTINATION_OUTPUT_URI_PREFIX";
    createBatchPredictionJobSample(
        project,
        displayName,
        modelName,
        instancesFormat,
        gcsSourceUri,
        predictionsFormat,
        gcsDestinationOutputUriPrefix);
  }

  static void createBatchPredictionJobSample(
      String project,
      String displayName,
      String model,
      String instancesFormat,
      String gcsSourceUri,
      String predictionsFormat,
      String gcsDestinationOutputUriPrefix)
      throws IOException {
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient client = JobServiceClient.create(settings)) {

      // Passing in an empty Value object for model parameters
      JsonObject jsonModelParameters = new JsonObject();
      Value.Builder modelParametersBuilder = Value.newBuilder();
      JsonFormat.parser().merge(jsonModelParameters.toString(), modelParametersBuilder);
      Value modelParameters = modelParametersBuilder.build();

      GcsSource gcsSource = GcsSource.newBuilder().addUris(gcsSourceUri).build();
      BatchPredictionJob.InputConfig inputConfig =
          BatchPredictionJob.InputConfig.newBuilder()
              .setInstancesFormat(instancesFormat)
              .setGcsSource(gcsSource)
              .build();
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(gcsDestinationOutputUriPrefix).build();
      BatchPredictionJob.OutputConfig outputConfig =
          BatchPredictionJob.OutputConfig.newBuilder()
              .setPredictionsFormat(predictionsFormat)
              .setGcsDestination(gcsDestination)
              .build();
      MachineSpec machineSpec =
          MachineSpec.newBuilder()
              .setMachineType("n1-standard-2")
              .setAcceleratorType(AcceleratorType.NVIDIA_TESLA_K80)
              .setAcceleratorCount(1)
              .build();
      BatchDedicatedResources dedicatedResources =
          BatchDedicatedResources.newBuilder()
              .setMachineSpec(machineSpec)
              .setStartingReplicaCount(1)
              .setMaxReplicaCount(1)
              .build();
      String modelName = ModelName.of(project, location, model).toString();
      BatchPredictionJob batchPredictionJob =
          BatchPredictionJob.newBuilder()
              .setDisplayName(displayName)
              .setModel(modelName)
              .setModelParameters(modelParameters)
              .setInputConfig(inputConfig)
              .setOutputConfig(outputConfig)
              .setDedicatedResources(dedicatedResources)
              .build();
      LocationName parent = LocationName.of(project, location);
      BatchPredictionJob response = client.createBatchPredictionJob(parent, batchPredictionJob);
      System.out.format("response: %s\n", response);
      System.out.format("\tName: %s\n", response.getName());
    }
  }
}

// [END aiplatform_create_batch_prediction_job_sample]

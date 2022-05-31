/*
 * Copyright 2021 Google LLC
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

// [START aiplatform_create_batch_prediction_job_bigquery_sample]
import com.google.cloud.aiplatform.v1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1.BigQueryDestination;
import com.google.cloud.aiplatform.v1.BigQuerySource;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.JobServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.ModelName;
import com.google.gson.JsonObject;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;

public class CreateBatchPredictionJobBigquerySample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String displayName = "DISPLAY_NAME";
    String modelName = "MODEL_NAME";
    String instancesFormat = "INSTANCES_FORMAT";
    String bigquerySourceInputUri = "BIGQUERY_SOURCE_INPUT_URI";
    String predictionsFormat = "PREDICTIONS_FORMAT";
    String bigqueryDestinationOutputUri = "BIGQUERY_DESTINATION_OUTPUT_URI";
    createBatchPredictionJobBigquerySample(
        project,
        displayName,
        modelName,
        instancesFormat,
        bigquerySourceInputUri,
        predictionsFormat,
        bigqueryDestinationOutputUri);
  }

  static void createBatchPredictionJobBigquerySample(
      String project,
      String displayName,
      String model,
      String instancesFormat,
      String bigquerySourceInputUri,
      String predictionsFormat,
      String bigqueryDestinationOutputUri)
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
      JsonObject jsonModelParameters = new JsonObject();
      Value.Builder modelParametersBuilder = Value.newBuilder();
      JsonFormat.parser().merge(jsonModelParameters.toString(), modelParametersBuilder);
      Value modelParameters = modelParametersBuilder.build();
      BigQuerySource bigquerySource =
          BigQuerySource.newBuilder().setInputUri(bigquerySourceInputUri).build();
      BatchPredictionJob.InputConfig inputConfig =
          BatchPredictionJob.InputConfig.newBuilder()
              .setInstancesFormat(instancesFormat)
              .setBigquerySource(bigquerySource)
              .build();
      BigQueryDestination bigqueryDestination =
          BigQueryDestination.newBuilder().setOutputUri(bigqueryDestinationOutputUri).build();
      BatchPredictionJob.OutputConfig outputConfig =
          BatchPredictionJob.OutputConfig.newBuilder()
              .setPredictionsFormat(predictionsFormat)
              .setBigqueryDestination(bigqueryDestination)
              .build();
      String modelName = ModelName.of(project, location, model).toString();
      BatchPredictionJob batchPredictionJob =
          BatchPredictionJob.newBuilder()
              .setDisplayName(displayName)
              .setModel(modelName)
              .setModelParameters(modelParameters)
              .setInputConfig(inputConfig)
              .setOutputConfig(outputConfig)
              .build();
      LocationName parent = LocationName.of(project, location);
      BatchPredictionJob response = client.createBatchPredictionJob(parent, batchPredictionJob);
      System.out.format("response: %s\n", response);
      System.out.format("\tName: %s\n", response.getName());
    }
  }
}

// [END aiplatform_create_batch_prediction_job_bigquery_sample]

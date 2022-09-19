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

// [START aiplatform_create_batch_prediction_job_text_entity_extraction_sample]
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.aiplatform.v1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1.GcsDestination;
import com.google.cloud.aiplatform.v1.GcsSource;
import com.google.cloud.aiplatform.v1.JobServiceClient;
import com.google.cloud.aiplatform.v1.JobServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.ModelName;
import java.io.IOException;

public class CreateBatchPredictionJobTextEntityExtractionSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String location = "us-central1";
    String displayName = "DISPLAY_NAME";
    String modelId = "MODEL_ID";
    String gcsSourceUri = "GCS_SOURCE_URI";
    String gcsDestinationOutputUriPrefix = "GCS_DESTINATION_OUTPUT_URI_PREFIX";
    createBatchPredictionJobTextEntityExtractionSample(
        project, location, displayName, modelId, gcsSourceUri, gcsDestinationOutputUriPrefix);
  }

  static void createBatchPredictionJobTextEntityExtractionSample(
      String project,
      String location,
      String displayName,
      String modelId,
      String gcsSourceUri,
      String gcsDestinationOutputUriPrefix)
      throws IOException {
    // The AI Platform services require regional API endpoints.
    JobServiceSettings settings =
        JobServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (JobServiceClient client = JobServiceClient.create(settings)) {
      try {
        String modelName = ModelName.of(project, location, modelId).toString();
        GcsSource gcsSource = GcsSource.newBuilder().addUris(gcsSourceUri).build();
        BatchPredictionJob.InputConfig inputConfig =
            BatchPredictionJob.InputConfig.newBuilder()
                .setInstancesFormat("jsonl")
                .setGcsSource(gcsSource)
                .build();
        GcsDestination gcsDestination =
            GcsDestination.newBuilder().setOutputUriPrefix(gcsDestinationOutputUriPrefix).build();
        BatchPredictionJob.OutputConfig outputConfig =
            BatchPredictionJob.OutputConfig.newBuilder()
                .setPredictionsFormat("jsonl")
                .setGcsDestination(gcsDestination)
                .build();
        BatchPredictionJob batchPredictionJob =
            BatchPredictionJob.newBuilder()
                .setDisplayName(displayName)
                .setModel(modelName)
                .setInputConfig(inputConfig)
                .setOutputConfig(outputConfig)
                .build();
        LocationName parent = LocationName.of(project, location);
        BatchPredictionJob response = client.createBatchPredictionJob(parent, batchPredictionJob);
        System.out.format("response: %s\n", response);
        System.out.format("\tname:%s\n", response.getName());
      } catch (ApiException ex) {
        System.out.format("Exception: %s\n", ex.getLocalizedMessage());
      }
    }
  }
}

// [END aiplatform_create_batch_prediction_job_text_entity_extraction_sample]

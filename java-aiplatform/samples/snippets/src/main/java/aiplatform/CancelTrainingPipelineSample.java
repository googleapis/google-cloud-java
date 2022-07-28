/*
 * Copyright 2021 Google LLC
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

// [START aiplatform_cancel_training_pipeline_sample]

import com.google.cloud.aiplatform.v1.PipelineServiceClient;
import com.google.cloud.aiplatform.v1.PipelineServiceSettings;
import com.google.cloud.aiplatform.v1.TrainingPipelineName;
import java.io.IOException;

public class CancelTrainingPipelineSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String trainingPipelineId = "YOUR_TRAINING_PIPELINE_ID";
    String project = "YOUR_PROJECT_ID";
    cancelTrainingPipelineSample(project, trainingPipelineId);
  }

  static void cancelTrainingPipelineSample(String project, String trainingPipelineId)
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
      TrainingPipelineName trainingPipelineName =
          TrainingPipelineName.of(project, location, trainingPipelineId);

      pipelineServiceClient.cancelTrainingPipeline(trainingPipelineName);

      System.out.println("Cancelled the Training Pipeline");
    }
  }
}
// [END aiplatform_cancel_training_pipeline_sample]

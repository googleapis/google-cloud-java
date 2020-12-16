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

// [START aiplatform_get_model_evaluation_video_action_recognition_sample]
import com.google.cloud.aiplatform.v1beta1.ModelEvaluation;
import com.google.cloud.aiplatform.v1beta1.ModelEvaluationName;
import com.google.cloud.aiplatform.v1beta1.ModelServiceClient;
import com.google.cloud.aiplatform.v1beta1.ModelServiceSettings;
import java.io.IOException;

public class GetModelEvaluationVideoActionRecognitionSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "PROJECT";
    String modelId = "MODEL_ID";
    String evaluationId = "EVALUATION_ID";
    getModelEvaluationVideoActionRecognitionSample(project, modelId, evaluationId);
  }

  static void getModelEvaluationVideoActionRecognitionSample(
      String project, String modelId, String evaluationId) throws IOException {
    ModelServiceSettings settings =
        ModelServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();
    String location = "us-central1";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ModelServiceClient client = ModelServiceClient.create(settings)) {
      ModelEvaluationName name = ModelEvaluationName.of(project, location, modelId, evaluationId);
      ModelEvaluation response = client.getModelEvaluation(name);
      System.out.format("response: %s\n", response);
    }
  }
}

// [END aiplatform_get_model_evaluation_video_action_recognition_sample]

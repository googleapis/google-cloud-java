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

package beta.automl;

// [START automl_video_classification_get_model_evaluation_beta]
// [START automl_video_object_tracking_get_model_evaluation_beta]
// [START automl_tables_get_model_evaluation]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.ModelEvaluation;
import com.google.cloud.automl.v1beta1.ModelEvaluationName;
import java.io.IOException;

class GetModelEvaluation {

  static void getModelEvaluation() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    String modelEvaluationId = "YOUR_MODEL_EVALUATION_ID";
    getModelEvaluation(projectId, modelId, modelEvaluationId);
  }

  // Get a model evaluation
  static void getModelEvaluation(String projectId, String modelId, String modelEvaluationId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the full path of the model evaluation.
      ModelEvaluationName modelEvaluationFullId =
          ModelEvaluationName.of(projectId, "us-central1", modelId, modelEvaluationId);

      // Get complete detail of the model evaluation.
      ModelEvaluation modelEvaluation = client.getModelEvaluation(modelEvaluationFullId);

      System.out.format("Model Evaluation Name: %s%n", modelEvaluation.getName());
      System.out.format("Model Annotation Spec Id: %s", modelEvaluation.getAnnotationSpecId());
      System.out.println("Create Time:");
      System.out.format("\tseconds: %s%n", modelEvaluation.getCreateTime().getSeconds());
      System.out.format("\tnanos: %s", modelEvaluation.getCreateTime().getNanos() / 1e9);
      System.out.format(
          "Evalution Example Count: %d%n", modelEvaluation.getEvaluatedExampleCount());

      // [END automl_video_object_tracking_get_model_evaluation_beta]
      System.out.format(
          "Classification Model Evaluation Metrics: %s%n",
          modelEvaluation.getClassificationEvaluationMetrics());
      // [END automl_video_classification_get_model_evaluation_beta]

      // [START automl_video_object_tracking_get_model_evaluation_beta]
      System.out.format(
          "Video Object Tracking Evaluation Metrics: %s%n",
          modelEvaluation.getVideoObjectTrackingEvaluationMetrics());
      // [START automl_video_classification_get_model_evaluation_beta]
    }
  }
}
// [END automl_tables_get_model_evaluation]
// [END automl_video_object_tracking_get_model_evaluation_beta]
// [END automl_video_classification_get_model_evaluation_beta]

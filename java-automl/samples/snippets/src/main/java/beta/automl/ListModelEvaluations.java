/*
 * Copyright 2019 Google LLC
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

// [START automl_tables_list_model_evaluations]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest;
import com.google.cloud.automl.v1beta1.ModelEvaluation;
import com.google.cloud.automl.v1beta1.ModelName;
import java.io.IOException;

class ListModelEvaluations {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    listModelEvaluations(projectId, modelId);
  }

  // List model evaluations
  static void listModelEvaluations(String projectId, String modelId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (AutoMlClient client = AutoMlClient.create()) {
      // Get the full path of the model.
      ModelName modelFullId = ModelName.of(projectId, "us-central1", modelId);
      ListModelEvaluationsRequest modelEvaluationsrequest =
          ListModelEvaluationsRequest.newBuilder().setParent(modelFullId.toString()).build();

      // List all the model evaluations in the model by applying filter.
      System.out.println("List of model evaluations:");
      for (ModelEvaluation modelEvaluation :
          client.listModelEvaluations(modelEvaluationsrequest).iterateAll()) {

        System.out.format("Model Evaluation Name: %s%n", modelEvaluation.getName());
        System.out.format("Model Annotation Spec Id: %s", modelEvaluation.getAnnotationSpecId());
        System.out.println("Create Time:");
        System.out.format("\tseconds: %s%n", modelEvaluation.getCreateTime().getSeconds());
        System.out.format("\tnanos: %s", modelEvaluation.getCreateTime().getNanos() / 1e9);
        System.out.format(
            "Evalution Example Count: %d%n", modelEvaluation.getEvaluatedExampleCount());

        System.out.format(
            "Tables Model Evaluation Metrics: %s%n",
            modelEvaluation.getClassificationEvaluationMetrics());
      }
    }
  }
}
// [END automl_tables_list_model_evaluations]

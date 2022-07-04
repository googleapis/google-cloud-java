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

// [START aiplatform_get_model_evaluation_slice_sample]

import com.google.cloud.aiplatform.v1.ModelEvaluationSlice;
import com.google.cloud.aiplatform.v1.ModelEvaluationSlice.Slice;
import com.google.cloud.aiplatform.v1.ModelEvaluationSliceName;
import com.google.cloud.aiplatform.v1.ModelServiceClient;
import com.google.cloud.aiplatform.v1.ModelServiceSettings;
import java.io.IOException;

public class GetModelEvaluationSliceSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // To obtain evaluationId run the code block below after setting modelServiceSettings.
    //
    // try (ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings))
    // {
    //   String location = "us-central1";
    //   ModelName modelFullId = ModelName.of(project, location, modelId);
    //   ListModelEvaluationsRequest modelEvaluationsrequest =
    //   ListModelEvaluationsRequest.newBuilder().setParent(modelFullId.toString()).build();
    //   for (ModelEvaluation modelEvaluation :
    //     modelServiceClient.listModelEvaluations(modelEvaluationsrequest).iterateAll()) {
    //       System.out.format("Model Evaluation Name: %s%n", modelEvaluation.getName());
    //   }
    // }
    String project = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    String evaluationId = "YOUR_EVALUATION_ID";
    String sliceId = "YOUR_SLICE_ID";
    getModelEvaluationSliceSample(project, modelId, evaluationId, sliceId);
  }

  static void getModelEvaluationSliceSample(
      String project, String modelId, String evaluationId, String sliceId) throws IOException {
    ModelServiceSettings modelServiceSettings =
        ModelServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ModelServiceClient modelServiceClient = ModelServiceClient.create(modelServiceSettings)) {
      String location = "us-central1";
      ModelEvaluationSliceName modelEvaluationSliceName =
          ModelEvaluationSliceName.of(project, location, modelId, evaluationId, sliceId);

      ModelEvaluationSlice modelEvaluationSlice =
          modelServiceClient.getModelEvaluationSlice(modelEvaluationSliceName);

      System.out.println("Get Model Evaluation Slice Response");
      System.out.format("Model Evaluation Slice Name: %s\n", modelEvaluationSlice.getName());
      System.out.format("Metrics Schema Uri: %s\n", modelEvaluationSlice.getMetricsSchemaUri());
      System.out.format("Metrics: %s\n", modelEvaluationSlice.getMetrics());
      System.out.format("Create Time: %s\n", modelEvaluationSlice.getCreateTime());

      Slice slice = modelEvaluationSlice.getSlice();
      System.out.format("Slice Dimensions: %s\n", slice.getDimension());
      System.out.format("Slice Value: %s\n", slice.getValue());
    }
  }
}
// [END aiplatform_get_model_evaluation_slice_sample]

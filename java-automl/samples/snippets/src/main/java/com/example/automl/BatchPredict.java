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

package com.example.automl;

// [START automl_batch_predict]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1.BatchPredictInputConfig;
import com.google.cloud.automl.v1.BatchPredictOutputConfig;
import com.google.cloud.automl.v1.BatchPredictRequest;
import com.google.cloud.automl.v1.BatchPredictResult;
import com.google.cloud.automl.v1.GcsDestination;
import com.google.cloud.automl.v1.GcsSource;
import com.google.cloud.automl.v1.ModelName;
import com.google.cloud.automl.v1.OperationMetadata;
import com.google.cloud.automl.v1.PredictionServiceClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

class BatchPredict {

  static void batchPredict() throws IOException, ExecutionException, InterruptedException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    String inputUri = "gs://YOUR_BUCKET_ID/path_to_your_input_csv_or_jsonl";
    String outputUri = "gs://YOUR_BUCKET_ID/path_to_save_results/";
    batchPredict(projectId, modelId, inputUri, outputUri);
  }

  static void batchPredict(String projectId, String modelId, String inputUri, String outputUri)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PredictionServiceClient client = PredictionServiceClient.create()) {
      // Get the full path of the model.
      ModelName name = ModelName.of(projectId, "us-central1", modelId);
      GcsSource gcsSource = GcsSource.newBuilder().addInputUris(inputUri).build();
      BatchPredictInputConfig inputConfig =
          BatchPredictInputConfig.newBuilder().setGcsSource(gcsSource).build();
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setOutputUriPrefix(outputUri).build();
      BatchPredictOutputConfig outputConfig =
          BatchPredictOutputConfig.newBuilder().setGcsDestination(gcsDestination).build();
      BatchPredictRequest request =
          BatchPredictRequest.newBuilder()
              .setName(name.toString())
              .setInputConfig(inputConfig)
              .setOutputConfig(outputConfig)
              .build();

      OperationFuture<BatchPredictResult, OperationMetadata> future =
          client.batchPredictAsync(request);

      System.out.println("Waiting for operation to complete...");
      BatchPredictResult response = future.get();
      System.out.println("Batch Prediction results saved to specified Cloud Storage bucket.");
    }
  }
}
// [END automl_batch_predict]

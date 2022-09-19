/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.automl.v1.samples;

// [START automl_v1_generated_predictionserviceclient_batchpredict_sync]
import com.google.cloud.automl.v1.BatchPredictInputConfig;
import com.google.cloud.automl.v1.BatchPredictOutputConfig;
import com.google.cloud.automl.v1.BatchPredictRequest;
import com.google.cloud.automl.v1.BatchPredictResult;
import com.google.cloud.automl.v1.ModelName;
import com.google.cloud.automl.v1.PredictionServiceClient;
import java.util.HashMap;

public class SyncBatchPredict {

  public static void main(String[] args) throws Exception {
    syncBatchPredict();
  }

  public static void syncBatchPredict() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
      BatchPredictRequest request =
          BatchPredictRequest.newBuilder()
              .setName(ModelName.of("[PROJECT]", "[LOCATION]", "[MODEL]").toString())
              .setInputConfig(BatchPredictInputConfig.newBuilder().build())
              .setOutputConfig(BatchPredictOutputConfig.newBuilder().build())
              .putAllParams(new HashMap<String, String>())
              .build();
      BatchPredictResult response = predictionServiceClient.batchPredictAsync(request).get();
    }
  }
}
// [END automl_v1_generated_predictionserviceclient_batchpredict_sync]

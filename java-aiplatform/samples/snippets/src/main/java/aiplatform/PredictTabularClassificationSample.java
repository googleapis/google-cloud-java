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

// [START aiplatform_predict_tabular_classification_sample]

import com.google.cloud.aiplatform.util.ValueConverter;
import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.PredictResponse;
import com.google.cloud.aiplatform.v1.PredictionServiceClient;
import com.google.cloud.aiplatform.v1.PredictionServiceSettings;
import com.google.cloud.aiplatform.v1.schema.predict.prediction.TabularClassificationPredictionResult;
import com.google.protobuf.ListValue;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.util.List;

public class PredictTabularClassificationSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String instance = "[{ “feature_column_a”: “value”, “feature_column_b”: “value”}]";
    String endpointId = "YOUR_ENDPOINT_ID";
    predictTabularClassification(instance, project, endpointId);
  }

  static void predictTabularClassification(String instance, String project, String endpointId)
      throws IOException {
    PredictionServiceSettings predictionServiceSettings =
        PredictionServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PredictionServiceClient predictionServiceClient =
        PredictionServiceClient.create(predictionServiceSettings)) {
      String location = "us-central1";
      EndpointName endpointName = EndpointName.of(project, location, endpointId);

      ListValue.Builder listValue = ListValue.newBuilder();
      JsonFormat.parser().merge(instance, listValue);
      List<Value> instanceList = listValue.getValuesList();

      Value parameters = Value.newBuilder().setListValue(listValue).build();
      PredictResponse predictResponse =
          predictionServiceClient.predict(endpointName, instanceList, parameters);
      System.out.println("Predict Tabular Classification Response");
      System.out.format("\tDeployed Model Id: %s\n", predictResponse.getDeployedModelId());

      System.out.println("Predictions");
      for (Value prediction : predictResponse.getPredictionsList()) {
        TabularClassificationPredictionResult.Builder resultBuilder =
            TabularClassificationPredictionResult.newBuilder();
        TabularClassificationPredictionResult result =
            (TabularClassificationPredictionResult)
                ValueConverter.fromValue(resultBuilder, prediction);

        for (int i = 0; i < result.getClassesCount(); i++) {
          System.out.printf("\tClass: %s", result.getClasses(i));
          System.out.printf("\tScore: %f", result.getScores(i));
        }
      }
    }
  }
}
// [END aiplatform_predict_tabular_classification_sample]

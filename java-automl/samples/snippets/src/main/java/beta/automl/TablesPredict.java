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

// [START automl_tables_predict]
import com.google.cloud.automl.v1beta1.AnnotationPayload;
import com.google.cloud.automl.v1beta1.ExamplePayload;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.PredictRequest;
import com.google.cloud.automl.v1beta1.PredictResponse;
import com.google.cloud.automl.v1beta1.PredictionServiceClient;
import com.google.cloud.automl.v1beta1.Row;
import com.google.cloud.automl.v1beta1.TablesAnnotation;
import com.google.protobuf.Value;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class TablesPredict {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "YOUR_PROJECT_ID";
    String modelId = "YOUR_MODEL_ID";
    // Values should match the input expected by your model.
    List<Value> values = new ArrayList<>();
    // values.add(Value.newBuilder().setBoolValue(true).build());
    // values.add(Value.newBuilder().setNumberValue(10).build());
    // values.add(Value.newBuilder().setStringValue("YOUR_STRING").build());
    predict(projectId, modelId, values);
  }

  static void predict(String projectId, String modelId, List<Value> values) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PredictionServiceClient client = PredictionServiceClient.create()) {
      // Get the full path of the model.
      ModelName name = ModelName.of(projectId, "us-central1", modelId);
      Row row = Row.newBuilder().addAllValues(values).build();
      ExamplePayload payload = ExamplePayload.newBuilder().setRow(row).build();

      // Feature importance gives you visibility into how the features in a specific prediction
      // request informed the resulting prediction. For more info, see:
      // https://cloud.google.com/automl-tables/docs/features#local
      PredictRequest request =
          PredictRequest.newBuilder()
              .setName(name.toString())
              .setPayload(payload)
              .putParams("feature_importance", "true")
              .build();

      PredictResponse response = client.predict(request);

      System.out.println("Prediction results:");
      for (AnnotationPayload annotationPayload : response.getPayloadList()) {
        TablesAnnotation tablesAnnotation = annotationPayload.getTables();
        System.out.format(
            "Classification label: %s%n", tablesAnnotation.getValue().getStringValue());
        System.out.format("Classification score: %.3f%n", tablesAnnotation.getScore());
        // Get features of top importance
        tablesAnnotation
            .getTablesModelColumnInfoList()
            .forEach(
                info ->
                    System.out.format(
                        "\tColumn: %s - Importance: %.2f%n",
                        info.getColumnDisplayName(), info.getFeatureImportance()));
      }
    }
  }
}
// [END automl_tables_predict]

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

// [START aiplatform_predict_image_classification_sample]

import com.google.api.client.util.Base64;
import com.google.cloud.aiplatform.util.ValueConverter;
import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.PredictResponse;
import com.google.cloud.aiplatform.v1.PredictionServiceClient;
import com.google.cloud.aiplatform.v1.PredictionServiceSettings;
import com.google.cloud.aiplatform.v1.schema.predict.instance.ImageClassificationPredictionInstance;
import com.google.cloud.aiplatform.v1.schema.predict.params.ImageClassificationPredictionParams;
import com.google.cloud.aiplatform.v1.schema.predict.prediction.ClassificationPredictionResult;
import com.google.protobuf.Value;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PredictImageClassificationSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String fileName = "YOUR_IMAGE_FILE_PATH";
    String endpointId = "YOUR_ENDPOINT_ID";
    predictImageClassification(project, fileName, endpointId);
  }

  static void predictImageClassification(String project, String fileName, String endpointId)
      throws IOException {
    PredictionServiceSettings settings =
        PredictionServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (PredictionServiceClient predictionServiceClient =
        PredictionServiceClient.create(settings)) {
      String location = "us-central1";
      EndpointName endpointName = EndpointName.of(project, location, endpointId);

      byte[] contents = Base64.encodeBase64(Files.readAllBytes(Paths.get(fileName)));
      String content = new String(contents, StandardCharsets.UTF_8);

      ImageClassificationPredictionInstance predictionInstance =
          ImageClassificationPredictionInstance.newBuilder().setContent(content).build();

      List<Value> instances = new ArrayList<>();
      instances.add(ValueConverter.toValue(predictionInstance));

      ImageClassificationPredictionParams predictionParams =
          ImageClassificationPredictionParams.newBuilder()
              .setConfidenceThreshold((float) 0.5)
              .setMaxPredictions(5)
              .build();

      PredictResponse predictResponse =
          predictionServiceClient.predict(
              endpointName, instances, ValueConverter.toValue(predictionParams));
      System.out.println("Predict Image Classification Response");
      System.out.format("\tDeployed Model Id: %s\n", predictResponse.getDeployedModelId());

      System.out.println("Predictions");
      for (Value prediction : predictResponse.getPredictionsList()) {

        ClassificationPredictionResult.Builder resultBuilder =
            ClassificationPredictionResult.newBuilder();
        // Display names and confidences values correspond to
        // IDs in the ID list.
        ClassificationPredictionResult result =
            (ClassificationPredictionResult) ValueConverter.fromValue(resultBuilder, prediction);
        int counter = 0;
        for (Long id : result.getIdsList()) {
          System.out.printf("Label ID: %d\n", id);
          System.out.printf("Label: %s\n", result.getDisplayNames(counter));
          System.out.printf("Confidence: %.4f\n", result.getConfidences(counter));
          counter++;
        }
      }
    }
  }
}
// [END aiplatform_predict_image_classification_sample]

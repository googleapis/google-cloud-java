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

// [START aiplatform_predict_image_object_detection_sample]

import com.google.api.client.util.Base64;
import com.google.cloud.aiplatform.util.ValueConverter;
import com.google.cloud.aiplatform.v1beta1.EndpointName;
import com.google.cloud.aiplatform.v1beta1.PredictResponse;
import com.google.cloud.aiplatform.v1beta1.PredictionServiceClient;
import com.google.cloud.aiplatform.v1beta1.PredictionServiceSettings;
import com.google.cloud.aiplatform.v1beta1.schema.predict.instance.ImageObjectDetectionPredictionInstance;
import com.google.cloud.aiplatform.v1beta1.schema.predict.params.ImageObjectDetectionPredictionParams;
import com.google.cloud.aiplatform.v1beta1.schema.predict.prediction.ImageObjectDetectionPredictionResult;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PredictImageObjectDetectionSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String fileName = "YOUR_IMAGE_FILE_PATH";
    String endpointId = "YOUR_ENDPOINT_ID";
    predictImageObjectDetection(project, fileName, endpointId);
  }

  static void predictImageObjectDetection(String project, String fileName, String endpointId)
      throws IOException {
    PredictionServiceSettings settings =
        PredictionServiceSettings.newBuilder()
            .setEndpoint("us-central1-prediction-aiplatform.googleapis.com:443")
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

      ImageObjectDetectionPredictionParams params =
          ImageObjectDetectionPredictionParams.newBuilder()
              .setConfidenceThreshold((float) (0.5))
              .setMaxPredictions(5)
              .build();

      ImageObjectDetectionPredictionInstance instance =
          ImageObjectDetectionPredictionInstance.newBuilder()
              .setContent(content)
              .build();

      List<Value> instances = new ArrayList<>();
      instances.add(ValueConverter.toValue(instance));

      PredictResponse predictResponse =
          predictionServiceClient.predict(endpointName, instances, ValueConverter.toValue(params));
      System.out.println("Predict Image Object Detection Response");
      System.out.format("\tDeployed Model Id: %s\n", predictResponse.getDeployedModelId());

      System.out.println("Predictions");
      for (Value prediction : predictResponse.getPredictionsList()) {

        ImageObjectDetectionPredictionResult.Builder resultBuilder =
            ImageObjectDetectionPredictionResult.newBuilder();

        ImageObjectDetectionPredictionResult result =
            (ImageObjectDetectionPredictionResult) ValueConverter
                .fromValue(resultBuilder, prediction);

        for (int i = 0; i < result.getIdsCount(); i++) {
          System.out.printf("\tDisplay name: %s\n", result.getDisplayNames(i));
          System.out.printf("\tConfidences: %f\n", result.getConfidences(i));
          System.out.printf("\tIDs: %d\n", result.getIds(i));
          System.out.printf("\tBounding boxes: %s\n", result.getBboxes(i));
        }
      }
    }
  }
}
// [END aiplatform_predict_image_object_detection_sample]

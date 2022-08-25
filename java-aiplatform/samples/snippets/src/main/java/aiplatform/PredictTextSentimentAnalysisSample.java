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

// [START aiplatform_predict_text_sentiment_analysis_sample]

import com.google.cloud.aiplatform.v1.EndpointName;
import com.google.cloud.aiplatform.v1.PredictResponse;
import com.google.cloud.aiplatform.v1.PredictionServiceClient;
import com.google.cloud.aiplatform.v1.PredictionServiceSettings;
import com.google.protobuf.Value;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PredictTextSentimentAnalysisSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String content = "YOUR_TEXT_CONTENT";
    String endpointId = "YOUR_ENDPOINT_ID";

    predictTextSentimentAnalysis(project, content, endpointId);
  }

  static void predictTextSentimentAnalysis(String project, String content, String endpointId)
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
      String jsonString = "{\"content\": \"" + content + "\"}";

      EndpointName endpointName = EndpointName.of(project, location, endpointId);

      Value parameter = Value.newBuilder().setNumberValue(0).setNumberValue(5).build();
      Value.Builder instance = Value.newBuilder();
      JsonFormat.parser().merge(jsonString, instance);

      List<Value> instances = new ArrayList<>();
      instances.add(instance.build());

      PredictResponse predictResponse =
          predictionServiceClient.predict(endpointName, instances, parameter);
      System.out.println("Predict Text Sentiment Analysis Response");
      System.out.format("\tDeployed Model Id: %s\n", predictResponse.getDeployedModelId());

      System.out.println("Predictions");
      for (Value prediction : predictResponse.getPredictionsList()) {
        System.out.format("\tPrediction: %s\n", prediction);
      }
    }
  }
}
// [END aiplatform_predict_text_sentiment_analysis_sample]

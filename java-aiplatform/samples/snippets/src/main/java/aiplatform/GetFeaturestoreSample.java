/*
 * Copyright 2022 Google LLC
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
 *
 *
 * Gets details of a single featurestore. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_get_featurestore_sample]

import com.google.cloud.aiplatform.v1beta1.Featurestore;
import com.google.cloud.aiplatform.v1beta1.FeaturestoreName;
import com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1beta1.GetFeaturestoreRequest;
import java.io.IOException;

public class GetFeaturestoreSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    getFeaturestoreSample(project, featurestoreId, location, endpoint);
  }

  static void getFeaturestoreSample(
      String project, String featurestoreId, String location, String endpoint) throws IOException {

    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {

      GetFeaturestoreRequest getFeaturestoreRequest =
          GetFeaturestoreRequest.newBuilder()
              .setName(FeaturestoreName.of(project, location, featurestoreId).toString())
              .build();

      Featurestore featurestore = featurestoreServiceClient.getFeaturestore(getFeaturestoreRequest);
      System.out.println("Get Featurestore Response");
      System.out.println(featurestore);
    }
  }
}
// [END aiplatform_get_featurestore_sample]

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
 * List available feature details. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_list_features_sample]

import com.google.cloud.aiplatform.v1.EntityTypeName;
import com.google.cloud.aiplatform.v1.Feature;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.ListFeaturesRequest;
import java.io.IOException;

public class ListFeaturesSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String entityTypeId = "YOUR_ENTITY_TYPE_ID";
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";

    listFeaturesSample(project, featurestoreId, entityTypeId, location, endpoint);
  }

  static void listFeaturesSample(
      String project, String featurestoreId, String entityTypeId, String location, String endpoint)
      throws IOException {
    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {

      ListFeaturesRequest listFeaturesRequest =
          ListFeaturesRequest.newBuilder()
              .setParent(
                  EntityTypeName.of(project, location, featurestoreId, entityTypeId).toString())
              .build();
      System.out.println("List Features Response");
      for (Feature element :
          featurestoreServiceClient.listFeatures(listFeaturesRequest).iterateAll()) {
        System.out.println(element);
      }
      featurestoreServiceClient.close();
    }
  }
}
// [END aiplatform_list_features_sample]

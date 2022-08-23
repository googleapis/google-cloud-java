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
 * List available featurestore details. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_list_featurestores_sample]

import com.google.cloud.aiplatform.v1.Featurestore;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.ListFeaturestoresRequest;
import com.google.cloud.aiplatform.v1.LocationName;
import java.io.IOException;

public class ListFeaturestoresSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    listFeaturestoresSample(project, location, endpoint);
  }

  static void listFeaturestoresSample(String project, String location, String endpoint)
      throws IOException {
    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {

      ListFeaturestoresRequest listFeaturestoresRequest =
          ListFeaturestoresRequest.newBuilder()
              .setParent(LocationName.of(project, location).toString())
              .build();

      System.out.println("List Featurestores Response");
      for (Featurestore element :
          featurestoreServiceClient.listFeaturestores(listFeaturestoresRequest).iterateAll()) {
        System.out.println(element);
      }
    }
  }
}
// [END aiplatform_list_featurestores_sample]

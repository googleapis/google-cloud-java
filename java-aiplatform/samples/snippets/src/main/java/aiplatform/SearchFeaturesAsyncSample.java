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
 * Search for featurestore resources. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_search_features_async_sample]

import com.google.cloud.aiplatform.v1.Feature;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import com.google.cloud.aiplatform.v1.SearchFeaturesRequest;
import com.google.cloud.aiplatform.v1.SearchFeaturesResponse;
import com.google.common.base.Strings;
import java.io.IOException;

public class SearchFeaturesAsyncSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String query = "YOUR_QUERY";
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    searchFeaturesAsyncSample(project, query, location, endpoint);
  }

  static void searchFeaturesAsyncSample(
      String project, String query, String location, String endpoint) throws IOException {
    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {

      SearchFeaturesRequest searchFeaturesRequest =
          SearchFeaturesRequest.newBuilder()
              .setLocation(LocationName.of(project, location).toString())
              .setQuery(query)
              .build();
      System.out.println("Search Features Async Response");
      while (true) {
        SearchFeaturesResponse response =
            featurestoreServiceClient.searchFeaturesCallable().call(searchFeaturesRequest);
        for (Feature element : response.getFeaturesList()) {
          System.out.println(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          searchFeaturesRequest =
              searchFeaturesRequest.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
      featurestoreServiceClient.close();
    }
  }
}
// [END aiplatform_search_features_async_sample]

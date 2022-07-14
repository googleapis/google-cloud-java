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
 * List available entity type details of an existing featurestore resource. See
 * https://cloud.google.com/vertex-ai/docs/featurestore/setup before running
 * the code snippet
 */

package aiplatform;

// [START aiplatform_list_entity_types_async_sample]

import com.google.cloud.aiplatform.v1.EntityType;
import com.google.cloud.aiplatform.v1.FeaturestoreName;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceClient;
import com.google.cloud.aiplatform.v1.FeaturestoreServiceSettings;
import com.google.cloud.aiplatform.v1.ListEntityTypesRequest;
import com.google.cloud.aiplatform.v1.ListEntityTypesResponse;
import com.google.common.base.Strings;
import java.io.IOException;

public class ListEntityTypesAsyncSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String featurestoreId = "YOUR_FEATURESTORE_ID";
    String location = "us-central1";
    String endpoint = "us-central1-aiplatform.googleapis.com:443";
    listEntityTypesAsyncSample(project, featurestoreId, location, endpoint);
  }

  static void listEntityTypesAsyncSample(
      String project, String featurestoreId, String location, String endpoint) throws IOException {

    FeaturestoreServiceSettings featurestoreServiceSettings =
        FeaturestoreServiceSettings.newBuilder().setEndpoint(endpoint).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FeaturestoreServiceClient featurestoreServiceClient =
        FeaturestoreServiceClient.create(featurestoreServiceSettings)) {

      ListEntityTypesRequest listEntityTypeRequest =
          ListEntityTypesRequest.newBuilder()
              .setParent(FeaturestoreName.of(project, location, featurestoreId).toString())
              .build();
      System.out.println("List Entity Types Async Response");
      while (true) {
        ListEntityTypesResponse listEntityTypesResponse =
            featurestoreServiceClient.listEntityTypesCallable().call(listEntityTypeRequest);
        for (EntityType element : listEntityTypesResponse.getEntityTypesList()) {
          System.out.println(element);
        }
        String nextPageToken = listEntityTypesResponse.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          listEntityTypeRequest =
              listEntityTypeRequest.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END aiplatform_list_entity_types_async_sample]

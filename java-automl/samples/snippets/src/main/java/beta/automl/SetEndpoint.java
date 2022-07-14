/*
 * Copyright 2019 Google LLC
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

import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.AutoMlSettings;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.ListDatasetsRequest;
import com.google.cloud.automl.v1beta1.LocationName;
import java.io.IOException;

class SetEndpoint {

  // Change your endpoint
  static void setEndpoint(String projectId) throws IOException {
    // [START automl_set_endpoint]
    AutoMlSettings settings =
        AutoMlSettings.newBuilder().setEndpoint("eu-automl.googleapis.com:443").build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    AutoMlClient client = AutoMlClient.create(settings);

    // A resource that represents Google Cloud Platform location.
    LocationName projectLocation = LocationName.of(projectId, "eu");
    // [END automl_set_endpoint]

    ListDatasetsRequest request =
        ListDatasetsRequest.newBuilder()
            .setParent(projectLocation.toString())
            .setFilter("translation_dataset_metadata:*")
            .build();
    // List all the datasets available
    System.out.println("List of datasets:");
    for (Dataset dataset : client.listDatasets(request).iterateAll()) {
      System.out.println(dataset);
    }
    client.close();
  }
}

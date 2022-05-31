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

// [START aiplatform_create_endpoint_sample]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.aiplatform.v1.CreateEndpointOperationMetadata;
import com.google.cloud.aiplatform.v1.Endpoint;
import com.google.cloud.aiplatform.v1.EndpointServiceClient;
import com.google.cloud.aiplatform.v1.EndpointServiceSettings;
import com.google.cloud.aiplatform.v1.LocationName;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateEndpointSample {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    // TODO(developer): Replace these variables before running the sample.
    String project = "YOUR_PROJECT_ID";
    String endpointDisplayName = "YOUR_ENDPOINT_DISPLAY_NAME";
    createEndpointSample(project, endpointDisplayName);
  }

  static void createEndpointSample(String project, String endpointDisplayName)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    EndpointServiceSettings endpointServiceSettings =
        EndpointServiceSettings.newBuilder()
            .setEndpoint("us-central1-aiplatform.googleapis.com:443")
            .build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (EndpointServiceClient endpointServiceClient =
        EndpointServiceClient.create(endpointServiceSettings)) {
      String location = "us-central1";
      LocationName locationName = LocationName.of(project, location);
      Endpoint endpoint = Endpoint.newBuilder().setDisplayName(endpointDisplayName).build();

      OperationFuture<Endpoint, CreateEndpointOperationMetadata> endpointFuture =
          endpointServiceClient.createEndpointAsync(locationName, endpoint);
      System.out.format("Operation name: %s\n", endpointFuture.getInitialFuture().get().getName());
      System.out.println("Waiting for operation to finish...");
      Endpoint endpointResponse = endpointFuture.get(300, TimeUnit.SECONDS);

      System.out.println("Create Endpoint Response");
      System.out.format("Name: %s\n", endpointResponse.getName());
      System.out.format("Display Name: %s\n", endpointResponse.getDisplayName());
      System.out.format("Description: %s\n", endpointResponse.getDescription());
      System.out.format("Labels: %s\n", endpointResponse.getLabelsMap());
      System.out.format("Create Time: %s\n", endpointResponse.getCreateTime());
      System.out.format("Update Time: %s\n", endpointResponse.getUpdateTime());
    }
  }
}
// [END aiplatform_create_endpoint_sample]

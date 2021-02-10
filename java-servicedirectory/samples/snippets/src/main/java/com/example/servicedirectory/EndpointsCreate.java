/*
 * Copyright 2020 Google LLC
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

package com.example.servicedirectory;

// [START servicedirectory_create_endpoint]

import com.google.cloud.servicedirectory.v1.Endpoint;
import com.google.cloud.servicedirectory.v1.RegistrationServiceClient;
import com.google.cloud.servicedirectory.v1.ServiceName;
import java.io.IOException;

public class EndpointsCreate {

  public static void createEndpoint() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // These variables should refer to an existing Service Directory service.
    String projectId = "your-project-id";
    String locationId = "your-region";
    String namespaceId = "your-namespace";
    String serviceId = "your-service";
    // This is user-created; must be unique within the service above.
    String endpointId = "your-endpoint";
    createEndpoint(projectId, locationId, namespaceId, serviceId, endpointId);
  }

  // Create a new endpoint.
  public static void createEndpoint(
      String projectId, String locationId, String namespaceId, String serviceId, String endpointId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (RegistrationServiceClient client = RegistrationServiceClient.create()) {

      // The service to create the endpoint in.
      ServiceName parent = ServiceName.of(projectId, locationId, namespaceId, serviceId);

      // The endpoint to create, with fields filled in.
      // Optionally set an IP address and port for the endpoint.
      Endpoint endpoint = Endpoint.newBuilder().setAddress("10.0.0.1").setPort(443).build();

      // Send the request to create the endpoint.
      Endpoint createdEndpoint = client.createEndpoint(parent, endpoint, endpointId);

      // Process the response.
      System.out.println("Created Endpoint: " + createdEndpoint.getName());
      System.out.println("IP Address: " + createdEndpoint.getAddress());
      System.out.println("Port: " + createdEndpoint.getPort());
    }
  }
}
// [END servicedirectory_create_endpoint]

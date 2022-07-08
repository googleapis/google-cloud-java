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

// [START servicedirectory_resolve_service]

import com.google.cloud.servicedirectory.v1.Endpoint;
import com.google.cloud.servicedirectory.v1.LookupServiceClient;
import com.google.cloud.servicedirectory.v1.ResolveServiceRequest;
import com.google.cloud.servicedirectory.v1.ResolveServiceResponse;
import com.google.cloud.servicedirectory.v1.ServiceName;
import java.io.IOException;

public class ServicesResolve {

  public static void resolveService() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // These variables should refer to an existing Service Directory service.
    String projectId = "your-project-id";
    String locationId = "your-region";
    String namespaceId = "your-namespace";
    String serviceId = "your-service";
    resolveService(projectId, locationId, namespaceId, serviceId);
  }

  // Resolve a service.
  public static void resolveService(
      String projectId, String locationId, String namespaceId, String serviceId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (LookupServiceClient client = LookupServiceClient.create()) {
      // The service to resolve.
      ServiceName name = ServiceName.of(projectId, locationId, namespaceId, serviceId);

      // Construct the resolve request to be sent to the client.
      ResolveServiceRequest request =
          ResolveServiceRequest.newBuilder().setName(name.toString()).build();

      // Send the request to resolve the service.
      ResolveServiceResponse resolveResponse = client.resolveService(request);

      // Process the response.
      System.out.println("Resolved Service: " + resolveResponse.getService().getName());

      System.out.println("Endpoints found:");
      for (Endpoint endpoint : resolveResponse.getService().getEndpointsList()) {
        System.out.println(
            endpoint.getName() + " -- " + endpoint.getAddress() + ":" + endpoint.getPort());
      }
    }
  }
}
// [END servicedirectory_resolve_service]

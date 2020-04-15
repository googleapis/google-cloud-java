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

// [START servicedirectory_delete_endpoint]

import com.google.cloud.servicedirectory.v1beta1.EndpointName;
import com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient;
import java.io.IOException;

public class EndpointsDelete {

  public static void deleteEndpoint() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // These variables should refer to an existing Service Directory endpoint.
    String projectId = "your-project-id";
    String locationId = "your-region";
    String namespaceId = "your-namespace";
    String serviceId = "your-service";
    String endpointId = "your-endpoint";
    deleteEndpoint(projectId, locationId, namespaceId, serviceId, endpointId);
  }

  // Delete an endpoint.
  public static void deleteEndpoint(
      String projectId, String locationId, String namespaceId, String serviceId, String endpointId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (RegistrationServiceClient client = RegistrationServiceClient.create()) {

      // The endpoint to delete.
      EndpointName endpointName =
          EndpointName.of(projectId, locationId, namespaceId, serviceId, endpointId);

      // Send the request to delete the endpoint.
      client.deleteEndpoint(endpointName);

      // Log the action.
      System.out.println("Deleted Endpoint: " + endpointName.toString());
    }
  }
}
// [END servicedirectory_delete_endpoint]

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

// [START servicedirectory_create_service]

import com.google.cloud.servicedirectory.v1.NamespaceName;
import com.google.cloud.servicedirectory.v1.RegistrationServiceClient;
import com.google.cloud.servicedirectory.v1.Service;
import java.io.IOException;

public class ServicesCreate {

  public static void createService() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    // These variables should refer to an existing Service Directory namespace.
    String projectId = "your-project-id";
    String locationId = "your-region";
    String namespaceId = "your-namespace";
    // This is user-created; must be unique within the namespace above.
    String serviceId = "your-service";
    createService(projectId, locationId, namespaceId, serviceId);
  }

  // Create a new service.
  public static void createService(
      String projectId, String locationId, String namespaceId, String serviceId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (RegistrationServiceClient client = RegistrationServiceClient.create()) {

      // The namespace to create the service in.
      NamespaceName parent = NamespaceName.of(projectId, locationId, namespaceId);

      // The service object to create.
      // Optionally add some annotations for the service.
      Service service = Service.newBuilder().putAnnotations("protocol", "tcp").build();

      // Send the request to create the namespace.
      Service createdService = client.createService(parent, service, serviceId);

      // Process the response.
      System.out.println("Created Service: " + createdService.getName());
      System.out.println("Annotations: " + createdService.getAnnotations());
    }
  }
}
// [END servicedirectory_create_service]

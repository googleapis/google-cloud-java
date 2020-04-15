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

// [START servicedirectory_create_namespace]

import com.google.cloud.servicedirectory.v1beta1.LocationName;
import com.google.cloud.servicedirectory.v1beta1.Namespace;
import com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient;
import java.io.IOException;

public class NamespacesCreate {

  public static void createNamespace() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "your-region";
    // This is user-created; must be unique within the project/region above.
    String namespaceId = "your-namespace";
    createNamespace(projectId, locationId, namespaceId);
  }

  // Create a new namespace.
  public static void createNamespace(String projectId, String locationId, String namespaceId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (RegistrationServiceClient client = RegistrationServiceClient.create()) {

      // The project and location to create the namespace in.
      LocationName parent = LocationName.of(projectId, locationId);

      // The namespace object to create. Here, we use the default instance.
      Namespace namespace = Namespace.newBuilder().build();

      // Send the request to create the namespace.
      Namespace createdNamespace = client.createNamespace(parent, namespace, namespaceId);

      // Process the response.
      System.out.println("Created Namespace: " + createdNamespace.getName());
    }
  }
}
// [END servicedirectory_create_namespace]

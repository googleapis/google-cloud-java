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

// [START servicedirectory_quickstart]

import com.google.cloud.servicedirectory.v1beta1.LocationName;
import com.google.cloud.servicedirectory.v1beta1.Namespace;
import com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient;
import com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListNamespacesPagedResponse;
import java.io.IOException;

public class Quickstart {

  public static void quickstart() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "your-region";
    quickstart(projectId, locationId);
  }

  public static void quickstart(String projectId, String locationId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (RegistrationServiceClient client = RegistrationServiceClient.create()) {

      // The project and location that hold the namespace to list.
      LocationName parent = LocationName.of(projectId, locationId);

      // Call the API.
      ListNamespacesPagedResponse response = client.listNamespaces(parent);

      // Iterate over each namespace and print its name.
      System.out.println("Namespaces:");
      for (Namespace namespace : response.iterateAll()) {
        System.out.println(namespace.getName());
      }
    }
  }
}
// [END servicedirectory_quickstart]

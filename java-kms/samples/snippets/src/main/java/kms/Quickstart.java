/*
 * Copyright 2018 Google LLC
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

package kms;

// [START kms_quickstart]
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.LocationName;
import java.io.IOException;

public class Quickstart {

  public void quickstart() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    quickstart(projectId, locationId);
  }

  public void quickstart(String projectId, String locationId) throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent from the project and location.
      LocationName parent = LocationName.of(projectId, locationId);

      // Call the API.
      ListKeyRingsPagedResponse response = client.listKeyRings(parent);

      // Iterate over each key ring and print its name.
      System.out.println("key rings:");
      for (KeyRing keyRing : response.iterateAll()) {
        System.out.printf("%s%n", keyRing.getName());
      }
    }
  }
}
// [END kms_quickstart]

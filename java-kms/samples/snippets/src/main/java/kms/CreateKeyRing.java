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

package kms;

// [START kms_create_key_ring]
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.LocationName;
import java.io.IOException;

public class CreateKeyRing {

  public void createKeyRing() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String id = "my-asymmetric-signing-key";
    createKeyRing(projectId, locationId, id);
  }

  // Create a new key ring.
  public void createKeyRing(String projectId, String locationId, String id) throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent name from the project and location.
      LocationName locationName = LocationName.of(projectId, locationId);

      // Build the key ring to create.
      KeyRing keyRing = KeyRing.newBuilder().build();

      // Create the key ring.
      KeyRing createdKeyRing = client.createKeyRing(locationName, id, keyRing);
      System.out.printf("Created key ring %s%n", createdKeyRing.getName());
    }
  }
}
// [END kms_create_key_ring]

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

// [START kms_create_key_version]
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import java.io.IOException;

public class CreateKeyVersion {

  public void createKeyVersion() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    createKeyVersion(projectId, locationId, keyRingId, keyId);
  }

  // Create a new key version.
  public void createKeyVersion(String projectId, String locationId, String keyRingId, String keyId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent name from the project, location, and key ring.
      CryptoKeyName cryptoKeyName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      // Build the key version to create.
      CryptoKeyVersion keyVersion = CryptoKeyVersion.newBuilder().build();

      // Create the key.
      CryptoKeyVersion createdVersion = client.createCryptoKeyVersion(cryptoKeyName, keyVersion);
      System.out.printf("Created key version %s%n", createdVersion.getName());
    }
  }
}
// [END kms_create_key_version]

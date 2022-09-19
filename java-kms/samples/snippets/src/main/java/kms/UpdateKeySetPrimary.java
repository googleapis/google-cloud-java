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

// [START kms_update_key_set_primary]
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import java.io.IOException;

public class UpdateKeySetPrimary {

  public void updateKeySetPrimary() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String keyVersionId = "123";
    updateKeySetPrimary(projectId, locationId, keyRingId, keyId, keyVersionId);
  }

  // Update a key's primary version.
  public void updateKeySetPrimary(
      String projectId, String locationId, String keyRingId, String keyId, String keyVersionId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the name from the project, location, key ring, and keyId.
      CryptoKeyName cryptoKeyName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      // Create the key.
      CryptoKey createdKey = client.updateCryptoKeyPrimaryVersion(cryptoKeyName, keyVersionId);
      System.out.printf("Updated key primary version %s%n", createdKey.getName());
    }
  }
}
// [END kms_update_key_set_primary]

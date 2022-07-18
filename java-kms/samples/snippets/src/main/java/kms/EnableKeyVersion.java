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

// [START kms_enable_key_version]
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState;
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;

public class EnableKeyVersion {

  public void enableKeyVersion() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String keyVersionId = "123";
    enableKeyVersion(projectId, locationId, keyRingId, keyId, keyVersionId);
  }

  // Enable a disabled key version to be used again.
  public void enableKeyVersion(
      String projectId, String locationId, String keyRingId, String keyId, String keyVersionId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the key version name from the project, location, key ring, key,
      // and key version.
      CryptoKeyVersionName keyVersionName =
          CryptoKeyVersionName.of(projectId, locationId, keyRingId, keyId, keyVersionId);

      // Build the updated key version, setting it to enabled.
      CryptoKeyVersion keyVersion =
          CryptoKeyVersion.newBuilder()
              .setName(keyVersionName.toString())
              .setState(CryptoKeyVersionState.ENABLED)
              .build();

      // Create a field mask of updated values.
      FieldMask fieldMask = FieldMaskUtil.fromString("state");

      // Enable the key version.
      CryptoKeyVersion response = client.updateCryptoKeyVersion(keyVersion, fieldMask);
      System.out.printf("Enabled key version: %s%n", response.getName());
    }
  }
}
// [END kms_enable_key_version]

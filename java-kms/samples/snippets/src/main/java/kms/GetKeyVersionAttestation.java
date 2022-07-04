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

// [START kms_get_key_version_attestation]
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.KeyOperationAttestation;
import java.io.IOException;
import java.util.Base64;

public class GetKeyVersionAttestation {

  public void getKeyVersionAttestation() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String keyVersionId = "123";
    getKeyVersionAttestation(projectId, locationId, keyRingId, keyId, keyVersionId);
  }

  // Get the attestations for a key version
  public void getKeyVersionAttestation(
      String projectId, String locationId, String keyRingId, String keyId, String keyVersionId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the name from the project, location, key ring, and keyId.
      CryptoKeyVersionName keyVersionName =
          CryptoKeyVersionName.of(projectId, locationId, keyRingId, keyId, keyVersionId);

      // Get the key version.
      CryptoKeyVersion keyVersion = client.getCryptoKeyVersion(keyVersionName);

      // Only HSM keys have an attestation. For other key types, the attestion
      // will be nil.
      if (!keyVersion.hasAttestation()) {
        System.out.println("no attestation");
        return;
      }

      // Print the attestation, base64-encoded.
      KeyOperationAttestation attestation = keyVersion.getAttestation();
      String format = attestation.getFormat().toString();
      byte[] content = attestation.getContent().toByteArray();
      System.out.printf("%s: %s", format, Base64.getEncoder().encodeToString(content));
    }
  }
}
// [END kms_get_key_version_attestation]

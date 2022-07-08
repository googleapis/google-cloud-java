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

// [START kms_encrypt_symmetric]
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.ByteString;
import java.io.IOException;

public class EncryptSymmetric {

  public void encryptSymmetric() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String plaintext = "Plaintext to encrypt";
    encryptSymmetric(projectId, locationId, keyRingId, keyId, plaintext);
  }

  // Encrypt data with a given key.
  public void encryptSymmetric(
      String projectId, String locationId, String keyRingId, String keyId, String plaintext)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the key version name from the project, location, key ring, key,
      // and key version.
      CryptoKeyName keyVersionName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      // Encrypt the plaintext.
      EncryptResponse response = client.encrypt(keyVersionName, ByteString.copyFromUtf8(plaintext));
      System.out.printf("Ciphertext: %s%n", response.getCiphertext().toStringUtf8());
    }
  }
}
// [END kms_encrypt_symmetric]

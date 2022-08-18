/*
 * Copyright 2021 Google LLC
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

// [START kms_sign_mac]
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.MacSignResponse;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.Base64;

public class SignMac {

  public void signMac() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String keyVersionId = "123";
    String data = "Data to sign";
    signMac(projectId, locationId, keyRingId, keyId, keyVersionId, data);
  }

  // Sign data with a given mac key.
  public void signMac(
      String projectId,
      String locationId,
      String keyRingId,
      String keyId,
      String keyVersionId,
      String data)
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

      // Generate an HMAC of the data.
      MacSignResponse response = client.macSign(keyVersionName, ByteString.copyFromUtf8(data));

      // The data comes back as raw bytes, which may include non-printable
      // characters. This base64-encodes the result so it can be printed below.
      String encodedSignature = Base64.getEncoder().encodeToString(response.getMac().toByteArray());
      System.out.printf("Signature: %s%n", encodedSignature);
    }
  }
}
// [END kms_sign_mac]

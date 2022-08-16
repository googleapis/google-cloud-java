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

// [START kms_verify_mac]
import com.google.cloud.kms.v1.CryptoKeyVersionName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.MacVerifyResponse;
import com.google.protobuf.ByteString;
import java.io.IOException;

public class VerifyMac {

  public void verifyMac() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    String keyVersionId = "123";
    String data = "Data to sign";
    byte[] signature = null;
    verifyMac(projectId, locationId, keyRingId, keyId, keyVersionId, data, signature);
  }

  // Sign data with a given mac key.
  public void verifyMac(
      String projectId,
      String locationId,
      String keyRingId,
      String keyId,
      String keyVersionId,
      String data,
      byte[] signature)
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

      // Verify the signature
      MacVerifyResponse response =
          client.macVerify(
              keyVersionName, ByteString.copyFromUtf8(data), ByteString.copyFrom(signature));

      // The data comes back as raw bytes, which may include non-printable
      // characters. This base64-encodes the result so it can be printed below.
      System.out.printf("Success: %s%n", response.getSuccess());
    }
  }
}
// [END kms_verify_mac]

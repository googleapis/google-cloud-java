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

// [START kms_generate_random_bytes]
import com.google.cloud.kms.v1.GenerateRandomBytesResponse;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.LocationName;
import com.google.cloud.kms.v1.ProtectionLevel;
import java.io.IOException;
import java.util.Base64;

public class GenerateRandomBytes {

  public void generateRandomBytes() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    int numBytes = 256;
    generateRandomBytes(projectId, locationId, numBytes);
  }

  // Create a new key for use with MacSign.
  public void generateRandomBytes(String projectId, String locationId, int numBytes)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent name for the location.
      LocationName locationName = LocationName.of(projectId, locationId);

      // Generate the bytes.
      GenerateRandomBytesResponse response =
          client.generateRandomBytes(locationName.toString(), numBytes, ProtectionLevel.HSM);

      // The data comes back as raw bytes, which may include non-printable
      // characters. This base64-encodes the result so it can be printed below.
      String encodedData = Base64.getEncoder().encodeToString(response.getData().toByteArray());

      System.out.printf("Random bytes: %s", encodedData);
    }
  }
}
// [END kms_generate_random_bytes]

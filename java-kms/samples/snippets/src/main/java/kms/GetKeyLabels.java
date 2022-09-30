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

// [START kms_get_key_labels]
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import java.io.IOException;

public class GetKeyLabels {

  public void getKeyLabels() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    getKeyLabels(projectId, locationId, keyRingId, keyId);
  }

  // Get the labels associated with a key.
  public void getKeyLabels(String projectId, String locationId, String keyRingId, String keyId)
      throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the name from the project, location, key ring, and keyId.
      CryptoKeyName keyName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      // Get the key.
      CryptoKey key = client.getCryptoKey(keyName);

      // Print out each label.
      key.getLabelsMap().forEach((k, v) -> System.out.printf("%s=%s%n", k, v));
    }
  }
}
// [END kms_get_key_labels]

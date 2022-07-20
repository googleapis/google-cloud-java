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

// [START kms_update_key_update_labels]
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;

public class UpdateKeyUpdateLabels {

  public void updateKeyUpdateLabels() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    updateKeyUpdateLabels(projectId, locationId, keyRingId, keyId);
  }

  // Create a new key that is used for symmetric encryption and decryption.
  public void updateKeyUpdateLabels(
      String projectId, String locationId, String keyRingId, String keyId) throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the parent name from the project, location, and key ring.
      CryptoKeyName cryptoKeyName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      //
      // Step 1 - get the current set of labels on the key
      //

      // Get the current key.
      CryptoKey key = client.getCryptoKey(cryptoKeyName);

      //
      // Step 2 - add a label to the list of labels
      //

      // Add a new label.
      key = key.toBuilder().putLabels("new_label", "new_value").build();

      // Construct the field mask.
      FieldMask fieldMask = FieldMaskUtil.fromString("labels");

      // Update the key.
      CryptoKey updatedKey = client.updateCryptoKey(key, fieldMask);
      System.out.printf("Updated key %s%n", updatedKey.getName());
    }
  }
}
// [END kms_update_key_update_labels]

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

// [START kms_update_key_remove_rotation_schedule]
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;

public class UpdateKeyRemoveRotation {

  public void updateKeyRemoveRotation() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    updateKeyRemoveRotation(projectId, locationId, keyRingId, keyId);
  }

  // Update a key to remove all labels.
  public void updateKeyRemoveRotation(
      String projectId, String locationId, String keyRingId, String keyId) throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the name from the project, location, key ring, and keyId.
      CryptoKeyName cryptoKeyName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      // Build an empty key with no labels.
      CryptoKey key =
          CryptoKey.newBuilder()
              .setName(cryptoKeyName.toString())
              .clearRotationPeriod()
              .clearNextRotationTime()
              .build();

      // Construct the field mask.
      FieldMask fieldMask = FieldMaskUtil.fromString("rotation_period,next_rotation_time");

      // Create the key.
      CryptoKey createdKey = client.updateCryptoKey(key, fieldMask);
      System.out.printf("Updated key %s%n", createdKey.getName());
    }
  }
}
// [END kms_update_key_remove_rotation_schedule]

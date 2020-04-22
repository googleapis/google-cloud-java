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

// [START kms_update_key_add_rotation_schedule]
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose;
import com.google.cloud.kms.v1.CryptoKeyName;
import com.google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionAlgorithm;
import com.google.cloud.kms.v1.CryptoKeyVersionTemplate;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;
import java.time.temporal.ChronoUnit;

public class UpdateKeyAddRotation {

  public void updateKeyAddRotation() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String locationId = "us-east1";
    String keyRingId = "my-key-ring";
    String keyId = "my-key";
    updateKeyAddRotation(projectId, locationId, keyRingId, keyId);
  }

  // Update a key to add or change a rotation schedule.
  public void updateKeyAddRotation(
      String projectId, String locationId, String keyRingId, String keyId) throws IOException {
    // Initialize client that will be used to send requests. This client only
    // needs to be created once, and can be reused for multiple requests. After
    // completing all of your requests, call the "close" method on the client to
    // safely clean up any remaining background resources.
    try (KeyManagementServiceClient client = KeyManagementServiceClient.create()) {
      // Build the name from the project, location, and key ring.
      CryptoKeyName cryptoKeyName = CryptoKeyName.of(projectId, locationId, keyRingId, keyId);

      // Calculate the date 24 hours from now (this is used below).
      long tomorrow = java.time.Instant.now().plus(24, ChronoUnit.HOURS).getEpochSecond();

      // Build the key to update with a rotation schedule.
      CryptoKey key =
          CryptoKey.newBuilder()
              .setName(cryptoKeyName.toString())
              .setPurpose(CryptoKeyPurpose.ENCRYPT_DECRYPT)
              .setVersionTemplate(
                  CryptoKeyVersionTemplate.newBuilder()
                      .setAlgorithm(CryptoKeyVersionAlgorithm.GOOGLE_SYMMETRIC_ENCRYPTION))

              // Rotate every 30 days.
              .setRotationPeriod(
                  Duration.newBuilder().setSeconds(java.time.Duration.ofDays(30).getSeconds()))

              // Start the first rotation in 24 hours.
              .setNextRotationTime(Timestamp.newBuilder().setSeconds(tomorrow))
              .build();

      // Construct the field mask.
      FieldMask fieldMask = FieldMaskUtil.fromString("rotation_period,next_rotation_time");

      // Update the key.
      CryptoKey updatedKey = client.updateCryptoKey(key, fieldMask);
      System.out.printf("Updated key %s%n", updatedKey.getName());
    }
  }
}
// [END kms_update_key_add_rotation_schedule]

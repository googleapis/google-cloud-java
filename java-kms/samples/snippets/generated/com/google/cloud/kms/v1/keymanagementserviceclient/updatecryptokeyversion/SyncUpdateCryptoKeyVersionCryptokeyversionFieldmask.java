/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.kms.v1.samples;

// [START kms_v1_generated_keymanagementserviceclient_updatecryptokeyversion_cryptokeyversionfieldmask_sync]
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.protobuf.FieldMask;

public class SyncUpdateCryptoKeyVersionCryptokeyversionFieldmask {

  public static void main(String[] args) throws Exception {
    syncUpdateCryptoKeyVersionCryptokeyversionFieldmask();
  }

  public static void syncUpdateCryptoKeyVersionCryptokeyversionFieldmask() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (KeyManagementServiceClient keyManagementServiceClient =
        KeyManagementServiceClient.create()) {
      CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      CryptoKeyVersion response =
          keyManagementServiceClient.updateCryptoKeyVersion(cryptoKeyVersion, updateMask);
    }
  }
}
// [END kms_v1_generated_keymanagementserviceclient_updatecryptokeyversion_cryptokeyversionfieldmask_sync]

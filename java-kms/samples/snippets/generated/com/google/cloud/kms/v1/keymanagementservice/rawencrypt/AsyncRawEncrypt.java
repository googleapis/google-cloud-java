/*
 * Copyright 2023 Google LLC
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

// [START cloudkms_v1_generated_KeyManagementService_RawEncrypt_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.kms.v1.KeyManagementServiceClient;
import com.google.cloud.kms.v1.RawEncryptRequest;
import com.google.cloud.kms.v1.RawEncryptResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Int64Value;

public class AsyncRawEncrypt {

  public static void main(String[] args) throws Exception {
    asyncRawEncrypt();
  }

  public static void asyncRawEncrypt() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (KeyManagementServiceClient keyManagementServiceClient =
        KeyManagementServiceClient.create()) {
      RawEncryptRequest request =
          RawEncryptRequest.newBuilder()
              .setName("name3373707")
              .setPlaintext(ByteString.EMPTY)
              .setAdditionalAuthenticatedData(ByteString.EMPTY)
              .setPlaintextCrc32C(Int64Value.newBuilder().build())
              .setAdditionalAuthenticatedDataCrc32C(Int64Value.newBuilder().build())
              .setInitializationVector(ByteString.EMPTY)
              .setInitializationVectorCrc32C(Int64Value.newBuilder().build())
              .build();
      ApiFuture<RawEncryptResponse> future =
          keyManagementServiceClient.rawEncryptCallable().futureCall(request);
      // Do something.
      RawEncryptResponse response = future.get();
    }
  }
}
// [END cloudkms_v1_generated_KeyManagementService_RawEncrypt_async]

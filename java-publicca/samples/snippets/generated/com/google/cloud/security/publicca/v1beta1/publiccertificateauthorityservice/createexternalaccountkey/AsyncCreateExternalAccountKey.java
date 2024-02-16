/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.security.publicca.v1beta1.samples;

// [START publicca_v1beta1_generated_PublicCertificateAuthorityService_CreateExternalAccountKey_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest;
import com.google.cloud.security.publicca.v1beta1.ExternalAccountKey;
import com.google.cloud.security.publicca.v1beta1.LocationName;
import com.google.cloud.security.publicca.v1beta1.PublicCertificateAuthorityServiceClient;

public class AsyncCreateExternalAccountKey {

  public static void main(String[] args) throws Exception {
    asyncCreateExternalAccountKey();
  }

  public static void asyncCreateExternalAccountKey() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (PublicCertificateAuthorityServiceClient publicCertificateAuthorityServiceClient =
        PublicCertificateAuthorityServiceClient.create()) {
      CreateExternalAccountKeyRequest request =
          CreateExternalAccountKeyRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setExternalAccountKey(ExternalAccountKey.newBuilder().build())
              .build();
      ApiFuture<ExternalAccountKey> future =
          publicCertificateAuthorityServiceClient
              .createExternalAccountKeyCallable()
              .futureCall(request);
      // Do something.
      ExternalAccountKey response = future.get();
    }
  }
}
// [END publicca_v1beta1_generated_PublicCertificateAuthorityService_CreateExternalAccountKey_async]

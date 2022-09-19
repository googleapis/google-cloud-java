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

package com.google.cloud.security.privateca.v1beta1.samples;

// [START privateca_v1beta1_generated_certificateauthorityserviceclient_restorecertificateauthority_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthority;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthorityName;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1beta1.OperationMetadata;
import com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest;

public class AsyncRestoreCertificateAuthorityLRO {

  public static void main(String[] args) throws Exception {
    asyncRestoreCertificateAuthorityLRO();
  }

  public static void asyncRestoreCertificateAuthorityLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      RestoreCertificateAuthorityRequest request =
          RestoreCertificateAuthorityRequest.newBuilder()
              .setName(
                  CertificateAuthorityName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_AUTHORITY]")
                      .toString())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<CertificateAuthority, OperationMetadata> future =
          certificateAuthorityServiceClient
              .restoreCertificateAuthorityOperationCallable()
              .futureCall(request);
      // Do something.
      CertificateAuthority response = future.get();
    }
  }
}
// [END privateca_v1beta1_generated_certificateauthorityserviceclient_restorecertificateauthority_lro_async]

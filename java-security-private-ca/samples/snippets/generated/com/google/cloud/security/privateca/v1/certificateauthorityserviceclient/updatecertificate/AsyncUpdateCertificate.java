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

package com.google.cloud.security.privateca.v1.samples;

// [START privateca_v1_generated_certificateauthorityserviceclient_updatecertificate_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient;
import com.google.cloud.security.privateca.v1.UpdateCertificateRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateCertificate {

  public static void main(String[] args) throws Exception {
    asyncUpdateCertificate();
  }

  public static void asyncUpdateCertificate() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CertificateAuthorityServiceClient certificateAuthorityServiceClient =
        CertificateAuthorityServiceClient.create()) {
      UpdateCertificateRequest request =
          UpdateCertificateRequest.newBuilder()
              .setCertificate(Certificate.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      ApiFuture<Certificate> future =
          certificateAuthorityServiceClient.updateCertificateCallable().futureCall(request);
      // Do something.
      Certificate response = future.get();
    }
  }
}
// [END privateca_v1_generated_certificateauthorityserviceclient_updatecertificate_async]

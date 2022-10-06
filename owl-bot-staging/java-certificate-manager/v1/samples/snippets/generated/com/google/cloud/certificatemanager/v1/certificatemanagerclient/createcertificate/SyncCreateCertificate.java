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

package com.google.cloud.certificatemanager.v1.samples;

// [START certificatemanager_v1_generated_certificatemanagerclient_createcertificate_sync]
import com.google.cloud.certificatemanager.v1.Certificate;
import com.google.cloud.certificatemanager.v1.CertificateManagerClient;
import com.google.cloud.certificatemanager.v1.CreateCertificateRequest;
import com.google.cloud.certificatemanager.v1.LocationName;

public class SyncCreateCertificate {

  public static void main(String[] args) throws Exception {
    syncCreateCertificate();
  }

  public static void syncCreateCertificate() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
      CreateCertificateRequest request =
          CreateCertificateRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setCertificateId("certificateId-644529902")
              .setCertificate(Certificate.newBuilder().build())
              .build();
      Certificate response = certificateManagerClient.createCertificateAsync(request).get();
    }
  }
}
// [END certificatemanager_v1_generated_certificatemanagerclient_createcertificate_sync]

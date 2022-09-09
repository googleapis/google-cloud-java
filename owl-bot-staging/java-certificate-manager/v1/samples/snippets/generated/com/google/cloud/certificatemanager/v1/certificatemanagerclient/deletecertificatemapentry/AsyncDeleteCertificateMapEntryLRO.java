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

// [START certificatemanager_v1_generated_certificatemanagerclient_deletecertificatemapentry_lro_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.certificatemanager.v1.CertificateManagerClient;
import com.google.cloud.certificatemanager.v1.CertificateMapEntryName;
import com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.OperationMetadata;
import com.google.protobuf.Empty;

public class AsyncDeleteCertificateMapEntryLRO {

  public static void main(String[] args) throws Exception {
    asyncDeleteCertificateMapEntryLRO();
  }

  public static void asyncDeleteCertificateMapEntryLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
      DeleteCertificateMapEntryRequest request =
          DeleteCertificateMapEntryRequest.newBuilder()
              .setName(
                  CertificateMapEntryName.of(
                          "[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]", "[CERTIFICATE_MAP_ENTRY]")
                      .toString())
              .build();
      OperationFuture<Empty, OperationMetadata> future =
          certificateManagerClient.deleteCertificateMapEntryOperationCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END certificatemanager_v1_generated_certificatemanagerclient_deletecertificatemapentry_lro_async]

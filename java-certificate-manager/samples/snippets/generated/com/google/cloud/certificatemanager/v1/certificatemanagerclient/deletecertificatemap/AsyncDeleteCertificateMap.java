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

// [START certificatemanager_v1_generated_certificatemanagerclient_deletecertificatemap_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.certificatemanager.v1.CertificateManagerClient;
import com.google.cloud.certificatemanager.v1.CertificateMapName;
import com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest;
import com.google.longrunning.Operation;

public class AsyncDeleteCertificateMap {

  public static void main(String[] args) throws Exception {
    asyncDeleteCertificateMap();
  }

  public static void asyncDeleteCertificateMap() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
      DeleteCertificateMapRequest request =
          DeleteCertificateMapRequest.newBuilder()
              .setName(
                  CertificateMapName.of("[PROJECT]", "[LOCATION]", "[CERTIFICATE_MAP]").toString())
              .build();
      ApiFuture<Operation> future =
          certificateManagerClient.deleteCertificateMapCallable().futureCall(request);
      // Do something.
      future.get();
    }
  }
}
// [END certificatemanager_v1_generated_certificatemanagerclient_deletecertificatemap_async]

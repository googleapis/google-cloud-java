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

// [START certificatemanager_v1_generated_CertificateManager_UpdateCertificateMap_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.certificatemanager.v1.CertificateManagerClient;
import com.google.cloud.certificatemanager.v1.CertificateMap;
import com.google.cloud.certificatemanager.v1.OperationMetadata;
import com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateCertificateMapLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateCertificateMapLRO();
  }

  public static void asyncUpdateCertificateMapLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (CertificateManagerClient certificateManagerClient = CertificateManagerClient.create()) {
      UpdateCertificateMapRequest request =
          UpdateCertificateMapRequest.newBuilder()
              .setCertificateMap(CertificateMap.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      OperationFuture<CertificateMap, OperationMetadata> future =
          certificateManagerClient.updateCertificateMapOperationCallable().futureCall(request);
      // Do something.
      CertificateMap response = future.get();
    }
  }
}
// [END certificatemanager_v1_generated_CertificateManager_UpdateCertificateMap_LRO_async]

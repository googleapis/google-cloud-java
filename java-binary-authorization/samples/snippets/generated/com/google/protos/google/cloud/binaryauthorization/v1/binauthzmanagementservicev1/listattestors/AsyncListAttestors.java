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

package com.google.protos.google.cloud.binaryauthorization.v1.samples;

// [START binaryauthorization_v1_generated_BinauthzManagementServiceV1_ListAttestors_async]
import com.google.api.core.ApiFuture;
import com.google.protos.google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1Client;
import com.google.protos.google.cloud.binaryauthorization.v1.ProjectName;
import com.google.protos.google.cloud.binaryauthorization.v1.Resources;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;

public class AsyncListAttestors {

  public static void main(String[] args) throws Exception {
    asyncListAttestors();
  }

  public static void asyncListAttestors() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
        BinauthzManagementServiceV1Client.create()) {
      Service.ListAttestorsRequest request =
          Service.ListAttestorsRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      ApiFuture<Resources.Attestor> future =
          binauthzManagementServiceV1Client.listAttestorsPagedCallable().futureCall(request);
      // Do something.
      for (Resources.Attestor element : future.get().iterateAll()) {
        // doThingsWith(element);
      }
    }
  }
}
// [END binaryauthorization_v1_generated_BinauthzManagementServiceV1_ListAttestors_async]

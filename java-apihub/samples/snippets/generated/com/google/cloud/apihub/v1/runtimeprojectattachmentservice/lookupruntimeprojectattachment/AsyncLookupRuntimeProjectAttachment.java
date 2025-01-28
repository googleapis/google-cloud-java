/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.apihub.v1.samples;

// [START apihub_v1_generated_RuntimeProjectAttachmentService_LookupRuntimeProjectAttachment_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.apihub.v1.LocationName;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest;
import com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse;
import com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceClient;

public class AsyncLookupRuntimeProjectAttachment {

  public static void main(String[] args) throws Exception {
    asyncLookupRuntimeProjectAttachment();
  }

  public static void asyncLookupRuntimeProjectAttachment() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (RuntimeProjectAttachmentServiceClient runtimeProjectAttachmentServiceClient =
        RuntimeProjectAttachmentServiceClient.create()) {
      LookupRuntimeProjectAttachmentRequest request =
          LookupRuntimeProjectAttachmentRequest.newBuilder()
              .setName(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      ApiFuture<LookupRuntimeProjectAttachmentResponse> future =
          runtimeProjectAttachmentServiceClient
              .lookupRuntimeProjectAttachmentCallable()
              .futureCall(request);
      // Do something.
      LookupRuntimeProjectAttachmentResponse response = future.get();
    }
  }
}
// [END apihub_v1_generated_RuntimeProjectAttachmentService_LookupRuntimeProjectAttachment_async]

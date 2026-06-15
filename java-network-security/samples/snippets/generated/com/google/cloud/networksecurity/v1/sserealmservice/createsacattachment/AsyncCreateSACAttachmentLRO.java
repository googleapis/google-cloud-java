/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1.samples;

// [START networksecurity_v1_generated_SSERealmService_CreateSACAttachment_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest;
import com.google.cloud.networksecurity.v1.LocationName;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.SACAttachment;
import com.google.cloud.networksecurity.v1.SSERealmServiceClient;

public class AsyncCreateSACAttachmentLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateSACAttachmentLRO();
  }

  public static void asyncCreateSACAttachmentLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (SSERealmServiceClient sSERealmServiceClient = SSERealmServiceClient.create()) {
      CreateSACAttachmentRequest request =
          CreateSACAttachmentRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setSacAttachmentId("sacAttachmentId-476668397")
              .setSacAttachment(SACAttachment.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<SACAttachment, OperationMetadata> future =
          sSERealmServiceClient.createSACAttachmentOperationCallable().futureCall(request);
      // Do something.
      SACAttachment response = future.get();
    }
  }
}
// [END networksecurity_v1_generated_SSERealmService_CreateSACAttachment_LRO_async]

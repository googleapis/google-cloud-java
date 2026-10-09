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

package com.google.cloud.networkservices.v1beta1.samples;

// [START networkservices_v1beta1_generated_DepService_UpdateExtensionBinding_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.networkservices.v1beta1.DepServiceClient;
import com.google.cloud.networkservices.v1beta1.ExtensionBinding;
import com.google.cloud.networkservices.v1beta1.OperationMetadata;
import com.google.cloud.networkservices.v1beta1.UpdateExtensionBindingRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateExtensionBindingLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateExtensionBindingLRO();
  }

  public static void asyncUpdateExtensionBindingLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DepServiceClient depServiceClient = DepServiceClient.create()) {
      UpdateExtensionBindingRequest request =
          UpdateExtensionBindingRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setExtensionBinding(ExtensionBinding.newBuilder().build())
              .build();
      OperationFuture<ExtensionBinding, OperationMetadata> future =
          depServiceClient.updateExtensionBindingOperationCallable().futureCall(request);
      // Do something.
      ExtensionBinding response = future.get();
    }
  }
}
// [END networkservices_v1beta1_generated_DepService_UpdateExtensionBinding_LRO_async]

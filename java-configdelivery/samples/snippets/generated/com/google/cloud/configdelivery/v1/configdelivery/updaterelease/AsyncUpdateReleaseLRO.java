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

package com.google.cloud.configdelivery.v1.samples;

// [START configdelivery_v1_generated_ConfigDelivery_UpdateRelease_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.configdelivery.v1.ConfigDeliveryClient;
import com.google.cloud.configdelivery.v1.OperationMetadata;
import com.google.cloud.configdelivery.v1.Release;
import com.google.cloud.configdelivery.v1.UpdateReleaseRequest;
import com.google.protobuf.FieldMask;

public class AsyncUpdateReleaseLRO {

  public static void main(String[] args) throws Exception {
    asyncUpdateReleaseLRO();
  }

  public static void asyncUpdateReleaseLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
      UpdateReleaseRequest request =
          UpdateReleaseRequest.newBuilder()
              .setUpdateMask(FieldMask.newBuilder().build())
              .setRelease(Release.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Release, OperationMetadata> future =
          configDeliveryClient.updateReleaseOperationCallable().futureCall(request);
      // Do something.
      Release response = future.get();
    }
  }
}
// [END configdelivery_v1_generated_ConfigDelivery_UpdateRelease_LRO_async]

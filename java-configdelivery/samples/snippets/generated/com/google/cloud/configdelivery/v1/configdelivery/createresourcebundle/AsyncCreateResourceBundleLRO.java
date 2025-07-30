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

// [START configdelivery_v1_generated_ConfigDelivery_CreateResourceBundle_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.configdelivery.v1.ConfigDeliveryClient;
import com.google.cloud.configdelivery.v1.CreateResourceBundleRequest;
import com.google.cloud.configdelivery.v1.LocationName;
import com.google.cloud.configdelivery.v1.OperationMetadata;
import com.google.cloud.configdelivery.v1.ResourceBundle;

public class AsyncCreateResourceBundleLRO {

  public static void main(String[] args) throws Exception {
    asyncCreateResourceBundleLRO();
  }

  public static void asyncCreateResourceBundleLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConfigDeliveryClient configDeliveryClient = ConfigDeliveryClient.create()) {
      CreateResourceBundleRequest request =
          CreateResourceBundleRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setResourceBundleId("resourceBundleId1209359211")
              .setResourceBundle(ResourceBundle.newBuilder().build())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<ResourceBundle, OperationMetadata> future =
          configDeliveryClient.createResourceBundleOperationCallable().futureCall(request);
      // Do something.
      ResourceBundle response = future.get();
    }
  }
}
// [END configdelivery_v1_generated_ConfigDelivery_CreateResourceBundle_LRO_async]

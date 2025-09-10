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

package com.google.cloud.gdchardwaremanagement.v1alpha.samples;

// [START gdchardwaremanagement_v1alpha_generated_GDCHardwareManagement_CancelOrder_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.gdchardwaremanagement.v1alpha.CancelOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient;
import com.google.cloud.gdchardwaremanagement.v1alpha.OperationMetadata;
import com.google.cloud.gdchardwaremanagement.v1alpha.Order;
import com.google.cloud.gdchardwaremanagement.v1alpha.OrderName;

public class AsyncCancelOrderLRO {

  public static void main(String[] args) throws Exception {
    asyncCancelOrderLRO();
  }

  public static void asyncCancelOrderLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GDCHardwareManagementClient gDCHardwareManagementClient =
        GDCHardwareManagementClient.create()) {
      CancelOrderRequest request =
          CancelOrderRequest.newBuilder()
              .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
              .setRequestId("requestId693933066")
              .build();
      OperationFuture<Order, OperationMetadata> future =
          gDCHardwareManagementClient.cancelOrderOperationCallable().futureCall(request);
      // Do something.
      Order response = future.get();
    }
  }
}
// [END gdchardwaremanagement_v1alpha_generated_GDCHardwareManagement_CancelOrder_LRO_async]

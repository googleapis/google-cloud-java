/*
 * Copyright 2024 Google LLC
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

// [START gdchardwaremanagement_v1alpha_generated_GDCHardwareManagement_GetOrder_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.gdchardwaremanagement.v1alpha.GDCHardwareManagementClient;
import com.google.cloud.gdchardwaremanagement.v1alpha.GetOrderRequest;
import com.google.cloud.gdchardwaremanagement.v1alpha.Order;
import com.google.cloud.gdchardwaremanagement.v1alpha.OrderName;

public class AsyncGetOrder {

  public static void main(String[] args) throws Exception {
    asyncGetOrder();
  }

  public static void asyncGetOrder() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (GDCHardwareManagementClient gDCHardwareManagementClient =
        GDCHardwareManagementClient.create()) {
      GetOrderRequest request =
          GetOrderRequest.newBuilder()
              .setName(OrderName.of("[PROJECT]", "[LOCATION]", "[ORDER]").toString())
              .build();
      ApiFuture<Order> future = gDCHardwareManagementClient.getOrderCallable().futureCall(request);
      // Do something.
      Order response = future.get();
    }
  }
}
// [END gdchardwaremanagement_v1alpha_generated_GDCHardwareManagement_GetOrder_async]

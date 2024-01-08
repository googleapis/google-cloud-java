/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.commerce.consumer.procurement.v1alpha1.samples;

// [START cloudcommerceconsumerprocurement_v1alpha1_generated_ConsumerProcurementService_GetOrder_sync]
import com.google.cloud.commerce.consumer.procurement.v1alpha1.ConsumerProcurementServiceClient;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.GetOrderRequest;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.Order;

public class SyncGetOrder {

  public static void main(String[] args) throws Exception {
    syncGetOrder();
  }

  public static void syncGetOrder() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
        ConsumerProcurementServiceClient.create()) {
      GetOrderRequest request = GetOrderRequest.newBuilder().setName("name3373707").build();
      Order response = consumerProcurementServiceClient.getOrder(request);
    }
  }
}
// [END cloudcommerceconsumerprocurement_v1alpha1_generated_ConsumerProcurementService_GetOrder_sync]

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

package com.google.cloud.commerce.consumer.procurement.v1alpha1.samples;

// [START cloudcommerceconsumerprocurement_v1alpha1_generated_ConsumerProcurementService_ListOrders_Paged_async]
import com.google.cloud.commerce.consumer.procurement.v1alpha1.ConsumerProcurementServiceClient;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.ListOrdersRequest;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.ListOrdersResponse;
import com.google.cloud.commerce.consumer.procurement.v1alpha1.Order;
import com.google.common.base.Strings;

public class AsyncListOrdersPaged {

  public static void main(String[] args) throws Exception {
    asyncListOrdersPaged();
  }

  public static void asyncListOrdersPaged() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
        ConsumerProcurementServiceClient.create()) {
      ListOrdersRequest request =
          ListOrdersRequest.newBuilder()
              .setParent("parent-995424086")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      while (true) {
        ListOrdersResponse response =
            consumerProcurementServiceClient.listOrdersCallable().call(request);
        for (Order element : response.getOrdersList()) {
          // doThingsWith(element);
        }
        String nextPageToken = response.getNextPageToken();
        if (!Strings.isNullOrEmpty(nextPageToken)) {
          request = request.toBuilder().setPageToken(nextPageToken).build();
        } else {
          break;
        }
      }
    }
  }
}
// [END cloudcommerceconsumerprocurement_v1alpha1_generated_ConsumerProcurementService_ListOrders_Paged_async]

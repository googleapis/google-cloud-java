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

package com.google.shopping.merchant.loyaltycustomers.v1.samples;

// [START merchantapi_v1_generated_LoyaltyCustomerMatchService_ManageLoyaltyCustomerMatch_sync]
import com.google.shopping.merchant.loyaltycustomers.v1.AccountName;
import com.google.shopping.merchant.loyaltycustomers.v1.LoyaltyCustomer;
import com.google.shopping.merchant.loyaltycustomers.v1.LoyaltyCustomerMatchServiceClient;
import com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchRequest;
import com.google.shopping.merchant.loyaltycustomers.v1.ManageLoyaltyCustomerMatchResponse;

public class SyncManageLoyaltyCustomerMatch {

  public static void main(String[] args) throws Exception {
    syncManageLoyaltyCustomerMatch();
  }

  public static void syncManageLoyaltyCustomerMatch() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
        LoyaltyCustomerMatchServiceClient.create()) {
      ManageLoyaltyCustomerMatchRequest request =
          ManageLoyaltyCustomerMatchRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
              .build();
      ManageLoyaltyCustomerMatchResponse response =
          loyaltyCustomerMatchServiceClient.manageLoyaltyCustomerMatch(request);
    }
  }
}
// [END merchantapi_v1_generated_LoyaltyCustomerMatchService_ManageLoyaltyCustomerMatch_sync]

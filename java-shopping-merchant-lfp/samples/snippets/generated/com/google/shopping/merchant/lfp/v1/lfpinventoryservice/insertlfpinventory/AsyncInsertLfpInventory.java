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

package com.google.shopping.merchant.lfp.v1.samples;

// [START merchantapi_v1_generated_LfpInventoryService_InsertLfpInventory_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.lfp.v1.AccountName;
import com.google.shopping.merchant.lfp.v1.InsertLfpInventoryRequest;
import com.google.shopping.merchant.lfp.v1.LfpInventory;
import com.google.shopping.merchant.lfp.v1.LfpInventoryServiceClient;

public class AsyncInsertLfpInventory {

  public static void main(String[] args) throws Exception {
    asyncInsertLfpInventory();
  }

  public static void asyncInsertLfpInventory() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LfpInventoryServiceClient lfpInventoryServiceClient = LfpInventoryServiceClient.create()) {
      InsertLfpInventoryRequest request =
          InsertLfpInventoryRequest.newBuilder()
              .setParent(AccountName.of("[ACCOUNT]").toString())
              .setLfpInventory(LfpInventory.newBuilder().build())
              .build();
      ApiFuture<LfpInventory> future =
          lfpInventoryServiceClient.insertLfpInventoryCallable().futureCall(request);
      // Do something.
      LfpInventory response = future.get();
    }
  }
}
// [END merchantapi_v1_generated_LfpInventoryService_InsertLfpInventory_async]

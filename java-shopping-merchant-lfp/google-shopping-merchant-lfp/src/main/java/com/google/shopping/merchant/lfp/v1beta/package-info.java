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

/**
 * A client to Merchant API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= LfpInventoryServiceClient =======================
 *
 * <p>Service Description: Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit local inventories for a
 * merchant.
 *
 * <p>Sample for LfpInventoryServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LfpInventoryServiceClient lfpInventoryServiceClient = LfpInventoryServiceClient.create()) {
 *   InsertLfpInventoryRequest request =
 *       InsertLfpInventoryRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setLfpInventory(LfpInventory.newBuilder().build())
 *           .build();
 *   LfpInventory response = lfpInventoryServiceClient.insertLfpInventory(request);
 * }
 * }</pre>
 *
 * <p>======================= LfpSaleServiceClient =======================
 *
 * <p>Service Description: Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit sales data for a
 * merchant.
 *
 * <p>Sample for LfpSaleServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LfpSaleServiceClient lfpSaleServiceClient = LfpSaleServiceClient.create()) {
 *   InsertLfpSaleRequest request =
 *       InsertLfpSaleRequest.newBuilder()
 *           .setParent("parent-995424086")
 *           .setLfpSale(LfpSale.newBuilder().build())
 *           .build();
 *   LfpSale response = lfpSaleServiceClient.insertLfpSale(request);
 * }
 * }</pre>
 *
 * <p>======================= LfpStoreServiceClient =======================
 *
 * <p>Service Description: Service for a [LFP
 * partner](https://support.google.com/merchants/answer/7676652) to submit local stores for a
 * merchant.
 *
 * <p>Sample for LfpStoreServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LfpStoreServiceClient lfpStoreServiceClient = LfpStoreServiceClient.create()) {
 *   LfpStoreName name = LfpStoreName.of("[ACCOUNT]", "[TARGET_MERCHANT]", "[STORE_CODE]");
 *   LfpStore response = lfpStoreServiceClient.getLfpStore(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.shopping.merchant.lfp.v1beta;

import javax.annotation.Generated;

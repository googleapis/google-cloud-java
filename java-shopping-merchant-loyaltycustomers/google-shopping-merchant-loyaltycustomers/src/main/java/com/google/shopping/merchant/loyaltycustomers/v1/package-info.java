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

/**
 * A client to Merchant API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= LoyaltyCustomerMatchServiceClient =======================
 *
 * <p>Service Description: Manages customer loyalty program memberships for merchants.
 *
 * <p>This service allows all merchants, including non-advertisers, to share their first-party
 * customer data of loyalty program members. Google uses this data to personalize organic free
 * listing shopping experiences, in compliance with the [Merchant Center Terms of
 * Service](https://support.google.com/merchants/answer/160173).
 *
 * <p>The service follows a non-standard, imperative pattern, exposing a single
 * `ManageLoyaltyCustomerMatch` method rather than conventional resource identifiers and CRUD
 * operations. This design protects user privacy by preventing the discovery of a customer's
 * presence or membership status through standard GET or LIST methods.
 *
 * <p>Sample for LoyaltyCustomerMatchServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LoyaltyCustomerMatchServiceClient loyaltyCustomerMatchServiceClient =
 *     LoyaltyCustomerMatchServiceClient.create()) {
 *   ManageLoyaltyCustomerMatchRequest request =
 *       ManageLoyaltyCustomerMatchRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setLoyaltyCustomer(LoyaltyCustomer.newBuilder().build())
 *           .build();
 *   ManageLoyaltyCustomerMatchResponse response =
 *       loyaltyCustomerMatchServiceClient.manageLoyaltyCustomerMatch(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.shopping.merchant.loyaltycustomers.v1;

import javax.annotation.Generated;

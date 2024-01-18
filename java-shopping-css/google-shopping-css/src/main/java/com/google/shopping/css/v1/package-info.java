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

/**
 * A client to CSS API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AccountsServiceClient =======================
 *
 * <p>Service Description: Service for managing CSS/MC account information.
 *
 * <p>Sample for AccountsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccountsServiceClient accountsServiceClient = AccountsServiceClient.create()) {
 *   AccountName name = AccountName.of("[ACCOUNT]");
 *   Account response = accountsServiceClient.getAccount(name);
 * }
 * }</pre>
 *
 * <p>======================= AccountLabelsServiceClient =======================
 *
 * <p>Service Description: Manages Merchant Center and CSS accounts labels.
 *
 * <p>Sample for AccountLabelsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AccountLabelsServiceClient accountLabelsServiceClient =
 *     AccountLabelsServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   AccountLabel accountLabel = AccountLabel.newBuilder().build();
 *   AccountLabel response = accountLabelsServiceClient.createAccountLabel(parent, accountLabel);
 * }
 * }</pre>
 *
 * <p>======================= CssProductInputsServiceClient =======================
 *
 * <p>Service Description: Service to use CssProductInput resource. This service helps to
 * insert/update/delete CSS Products.
 *
 * <p>Sample for CssProductInputsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CssProductInputsServiceClient cssProductInputsServiceClient =
 *     CssProductInputsServiceClient.create()) {
 *   InsertCssProductInputRequest request =
 *       InsertCssProductInputRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setCssProductInput(CssProductInput.newBuilder().build())
 *           .setFeedId(-976011428)
 *           .build();
 *   CssProductInput response = cssProductInputsServiceClient.insertCssProductInput(request);
 * }
 * }</pre>
 *
 * <p>======================= CssProductsServiceClient =======================
 *
 * <p>Service Description: Service for doing get and list on Css Products(a.k.a Aggregate Offers
 * internally).
 *
 * <p>Sample for CssProductsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CssProductsServiceClient cssProductsServiceClient = CssProductsServiceClient.create()) {
 *   CssProductName name = CssProductName.of("[ACCOUNT]", "[CSS_PRODUCT]");
 *   CssProduct response = cssProductsServiceClient.getCssProduct(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.shopping.css.v1;

import javax.annotation.Generated;

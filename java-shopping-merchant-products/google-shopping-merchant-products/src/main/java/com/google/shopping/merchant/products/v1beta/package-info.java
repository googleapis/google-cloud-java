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
 * <p>======================= ProductInputsServiceClient =======================
 *
 * <p>Service Description: Service to use ProductInput resource. This service works for products
 * with online channel only.
 *
 * <p>Sample for ProductInputsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProductInputsServiceClient productInputsServiceClient =
 *     ProductInputsServiceClient.create()) {
 *   InsertProductInputRequest request =
 *       InsertProductInputRequest.newBuilder()
 *           .setParent(AccountName.of("[ACCOUNT]").toString())
 *           .setProductInput(ProductInput.newBuilder().build())
 *           .setDataSource("dataSource1272470629")
 *           .build();
 *   ProductInput response = productInputsServiceClient.insertProductInput(request);
 * }
 * }</pre>
 *
 * <p>======================= ProductsServiceClient =======================
 *
 * <p>Service Description: Service to use Product resource. This service works for products with
 * online channel only.
 *
 * <p>Sample for ProductsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProductsServiceClient productsServiceClient = ProductsServiceClient.create()) {
 *   ProductName name = ProductName.of("[ACCOUNT]", "[PRODUCT]");
 *   Product response = productsServiceClient.getProduct(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.shopping.merchant.products.v1beta;

import javax.annotation.Generated;

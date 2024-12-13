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
 * <p>======================= MerchantReviewsServiceClient =======================
 *
 * <p>Service Description: Service to manage merchant reviews.
 *
 * <p>Sample for MerchantReviewsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
 *     MerchantReviewsServiceClient.create()) {
 *   MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");
 *   MerchantReview response = merchantReviewsServiceClient.getMerchantReview(name);
 * }
 * }</pre>
 *
 * <p>======================= ProductReviewsServiceClient =======================
 *
 * <p>Service Description: Service to manage product reviews.
 *
 * <p>Sample for ProductReviewsServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ProductReviewsServiceClient productReviewsServiceClient =
 *     ProductReviewsServiceClient.create()) {
 *   ProductReviewName name = ProductReviewName.of("[ACCOUNT]", "[PRODUCTREVIEW]");
 *   ProductReview response = productReviewsServiceClient.getProductReview(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.shopping.merchant.reviews.v1beta;

import javax.annotation.Generated;

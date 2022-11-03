/*
 * Copyright 2022 Google LLC
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
 * A client to Cloud Commerce Consumer Procurement API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ConsumerProcurementServiceClient =======================
 *
 * <p>Service Description: ConsumerProcurementService allows customers to make purchases of products
 * served by the Cloud Commerce platform.
 *
 * <p>When purchases are made, the
 * [ConsumerProcurementService][google.cloud.commerce.consumer.procurement.v1alpha1.ConsumerProcurementService]
 * programs the appropriate backends, including both Google's own infrastructure, as well as
 * third-party systems, and to enable billing setup for charging for the procured item.
 *
 * <p>Sample for ConsumerProcurementServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ConsumerProcurementServiceClient consumerProcurementServiceClient =
 *     ConsumerProcurementServiceClient.create()) {
 *   GetOrderRequest request = GetOrderRequest.newBuilder().setName("name3373707").build();
 *   Order response = consumerProcurementServiceClient.getOrder(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.commerce.consumer.procurement.v1alpha1;

import javax.annotation.Generated;

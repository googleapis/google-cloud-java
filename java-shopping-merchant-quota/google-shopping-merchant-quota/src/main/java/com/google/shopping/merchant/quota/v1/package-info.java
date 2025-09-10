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

/**
 * A client to Merchant API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= QuotaServiceClient =======================
 *
 * <p>Service Description: Service to get method call quota information per Merchant API method.
 *
 * <p>Sample for QuotaServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (QuotaServiceClient quotaServiceClient = QuotaServiceClient.create()) {
 *   AccountName parent = AccountName.of("[ACCOUNT]");
 *   for (QuotaGroup element : quotaServiceClient.listQuotaGroups(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.shopping.merchant.quota.v1;

import javax.annotation.Generated;

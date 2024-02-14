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
 * A client to KMS Inventory API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= KeyDashboardServiceClient =======================
 *
 * <p>Service Description: Provides a cross-region view of all Cloud KMS keys in a given Cloud
 * project.
 *
 * <p>Sample for KeyDashboardServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (KeyDashboardServiceClient keyDashboardServiceClient = KeyDashboardServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   for (CryptoKey element : keyDashboardServiceClient.listCryptoKeys(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>======================= KeyTrackingServiceClient =======================
 *
 * <p>Service Description: Returns information about the resources in an org that are protected by a
 * given Cloud KMS key via CMEK.
 *
 * <p>Sample for KeyTrackingServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (KeyTrackingServiceClient keyTrackingServiceClient = KeyTrackingServiceClient.create()) {
 *   ProtectedResourcesSummaryName name =
 *       ProtectedResourcesSummaryName.ofProjectLocationKeyRingCryptoKeyName(
 *           "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
 *   ProtectedResourcesSummary response =
 *       keyTrackingServiceClient.getProtectedResourcesSummary(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.kms.inventory.v1;

import javax.annotation.Generated;

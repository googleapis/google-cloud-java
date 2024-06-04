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
 * A client to Cloud Identity-Aware Proxy API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= IdentityAwareProxyAdminServiceClient =======================
 *
 * <p>Service Description: APIs for Identity-Aware Proxy Admin configurations.
 *
 * <p>Sample for IdentityAwareProxyAdminServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
 *     IdentityAwareProxyAdminServiceClient.create()) {
 *   SetIamPolicyRequest request =
 *       SetIamPolicyRequest.newBuilder()
 *           .setResource("resource-341064690")
 *           .setPolicy(Policy.newBuilder().build())
 *           .setUpdateMask(FieldMask.newBuilder().build())
 *           .build();
 *   Policy response = identityAwareProxyAdminServiceClient.setIamPolicy(request);
 * }
 * }</pre>
 *
 * <p>======================= IdentityAwareProxyOAuthServiceClient =======================
 *
 * <p>Service Description: API to programmatically create, list and retrieve Identity Aware Proxy
 * (IAP) OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth clients.
 *
 * <p>Sample for IdentityAwareProxyOAuthServiceClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (IdentityAwareProxyOAuthServiceClient identityAwareProxyOAuthServiceClient =
 *     IdentityAwareProxyOAuthServiceClient.create()) {
 *   ListBrandsRequest request =
 *       ListBrandsRequest.newBuilder().setParent("parent-995424086").build();
 *   ListBrandsResponse response = identityAwareProxyOAuthServiceClient.listBrands(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.iap.v1;

import javax.annotation.Generated;

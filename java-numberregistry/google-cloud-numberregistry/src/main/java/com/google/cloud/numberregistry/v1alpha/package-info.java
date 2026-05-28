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
 * A client to Cloud Number Registry API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CloudNumberRegistryClient =======================
 *
 * <p>Service Description: The Cloud Number Registry service manages IP address space visibility and
 * tracking. It enables the discovery, organization, and monitoring of IP address ranges across
 * different cloud infrastructure platforms.
 *
 * <p>Sample for CloudNumberRegistryClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudNumberRegistryClient cloudNumberRegistryClient = CloudNumberRegistryClient.create()) {
 *   IpamAdminScopeName name =
 *       IpamAdminScopeName.of("[PROJECT]", "[LOCATION]", "[IPAM_ADMIN_SCOPE]");
 *   IpamAdminScope response = cloudNumberRegistryClient.getIpamAdminScope(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.numberregistry.v1alpha;

import javax.annotation.Generated;

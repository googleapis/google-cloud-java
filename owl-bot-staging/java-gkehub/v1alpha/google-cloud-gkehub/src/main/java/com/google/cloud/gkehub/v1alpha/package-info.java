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
 * The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= GkeHubClient =======================
 *
 * <p>Service Description: The GKE Hub service handles the registration of many Kubernetes clusters
 * to Google Cloud, and the management of multi-cluster features over those clusters.
 *
 * <p>The GKE Hub service operates on the following resources:
 *
 * <ul>
 *   <li>[Membership][google.cloud.gkehub.v1alpha.Membership]
 *   <li>[Feature][google.cloud.gkehub.v1alpha.Feature]
 * </ul>
 *
 * <p>GKE Hub is currently only available in the global region.
 *
 * <p>&#42;&#42;Membership management may be non-trivial:&#42;&#42; it is recommended to use one of
 * the Google-provided client libraries or tools where possible when working with Membership
 * resources.
 *
 * <p>Sample for GkeHubClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (GkeHubClient gkeHubClient = GkeHubClient.create()) {
 *   String name = "name3373707";
 *   Feature response = gkeHubClient.getFeature(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.gkehub.v1alpha;

import javax.annotation.Generated;

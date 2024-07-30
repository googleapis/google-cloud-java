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
 * A client to Privileged Access Manager API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= PrivilegedAccessManagerClient =======================
 *
 * <p>Service Description: This API allows customers to manage temporary, request based privileged
 * access to their resources.
 *
 * <p>It defines the following resource model:
 *
 * <ul>
 *   <li>A collection of `Entitlement` resources. An entitlement allows configuring (among other
 *       things):
 * </ul>
 *
 * <p>&#42; Some kind of privileged access that users can request. &#42; A set of users called
 * _requesters_ who can request this access. &#42; A maximum duration for which the access can be
 * requested. &#42; An optional approval workflow which must be satisfied before access is granted.
 *
 * <ul>
 *   <li>A collection of `Grant` resources. A grant is a request by a requester to get the
 *       privileged access specified in an entitlement for some duration.
 * </ul>
 *
 * <p>After the approval workflow as specified in the entitlement is satisfied, the specified access
 * is given to the requester. The access is automatically taken back after the requested duration is
 * over.
 *
 * <p>Sample for PrivilegedAccessManagerClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PrivilegedAccessManagerClient privilegedAccessManagerClient =
 *     PrivilegedAccessManagerClient.create()) {
 *   CheckOnboardingStatusRequest request =
 *       CheckOnboardingStatusRequest.newBuilder()
 *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
 *           .build();
 *   CheckOnboardingStatusResponse response =
 *       privilegedAccessManagerClient.checkOnboardingStatus(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.privilegedaccessmanager.v1;

import javax.annotation.Generated;

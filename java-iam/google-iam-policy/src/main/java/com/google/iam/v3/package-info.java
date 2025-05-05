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
 * A client to Identity and Access Management (IAM) API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= PolicyBindingsClient =======================
 *
 * <p>Service Description: An interface for managing Identity and Access Management (IAM) policy
 * bindings.
 *
 * <p>Sample for PolicyBindingsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PolicyBindingsClient policyBindingsClient = PolicyBindingsClient.create()) {
 *   PolicyBindingName name =
 *       PolicyBindingName.ofProjectLocationPolicyBindingName(
 *           "[PROJECT]", "[LOCATION]", "[POLICY_BINDING]");
 *   PolicyBinding response = policyBindingsClient.getPolicyBinding(name);
 * }
 * }</pre>
 *
 * <p>======================= PrincipalAccessBoundaryPoliciesClient =======================
 *
 * <p>Service Description: Manages Identity and Access Management (IAM) principal access boundary
 * policies.
 *
 * <p>Sample for PrincipalAccessBoundaryPoliciesClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (PrincipalAccessBoundaryPoliciesClient principalAccessBoundaryPoliciesClient =
 *     PrincipalAccessBoundaryPoliciesClient.create()) {
 *   PrincipalAccessBoundaryPolicyName name =
 *       PrincipalAccessBoundaryPolicyName.of(
 *           "[ORGANIZATION]", "[LOCATION]", "[PRINCIPAL_ACCESS_BOUNDARY_POLICY]");
 *   PrincipalAccessBoundaryPolicy response =
 *       principalAccessBoundaryPoliciesClient.getPrincipalAccessBoundaryPolicy(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.iam.v3;

import javax.annotation.Generated;

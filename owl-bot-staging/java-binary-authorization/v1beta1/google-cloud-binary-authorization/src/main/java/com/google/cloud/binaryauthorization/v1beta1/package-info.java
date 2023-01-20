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
 * <p>======================= BinauthzManagementServiceV1Beta1Client =======================
 *
 * <p>Service Description: Google Cloud Management Service for Binary Authorization admission
 * policies and attestation authorities.
 *
 * <p>This API implements a REST model with the following objects:
 *
 * <ul>
 *   <li>[Policy][google.cloud.binaryauthorization.v1beta1.Policy]
 *   <li>[Attestor][google.cloud.binaryauthorization.v1beta1.Attestor]
 * </ul>
 *
 * <p>Sample for BinauthzManagementServiceV1Beta1Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BinauthzManagementServiceV1Beta1Client binauthzManagementServiceV1Beta1Client =
 *     BinauthzManagementServiceV1Beta1Client.create()) {
 *   PolicyName name = PolicyName.ofProjectName("[PROJECT]");
 *   Policy response = binauthzManagementServiceV1Beta1Client.getPolicy(name);
 * }
 * }</pre>
 *
 * <p>======================= SystemPolicyV1Beta1Client =======================
 *
 * <p>Service Description: API for working with the system policy.
 *
 * <p>Sample for SystemPolicyV1Beta1Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SystemPolicyV1Beta1Client systemPolicyV1Beta1Client = SystemPolicyV1Beta1Client.create()) {
 *   PolicyName name = PolicyName.ofLocationName("[LOCATION]");
 *   Policy response = systemPolicyV1Beta1Client.getSystemPolicy(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.binaryauthorization.v1beta1;

import javax.annotation.Generated;

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
 * A client to Binary Authorization API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= BinauthzManagementServiceV1Client =======================
 *
 * <p>Service Description: Google Cloud Management Service for Binary Authorization admission
 * policies and attestation authorities.
 *
 * <p>This API implements a REST model with the following objects:
 *
 * <ul>
 *   <li>[Policy][google.cloud.binaryauthorization.v1.Policy]
 *   <li>[Attestor][google.cloud.binaryauthorization.v1.Attestor]
 * </ul>
 *
 * <p>Sample for BinauthzManagementServiceV1Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (BinauthzManagementServiceV1Client binauthzManagementServiceV1Client =
 *     BinauthzManagementServiceV1Client.create()) {
 *   PolicyName name = PolicyName.ofProjectName("[PROJECT]");
 *   Resources.Policy response = binauthzManagementServiceV1Client.getPolicy(name);
 * }
 * }</pre>
 *
 * <p>======================= SystemPolicyV1Client =======================
 *
 * <p>Service Description: API for working with the system policy.
 *
 * <p>Sample for SystemPolicyV1Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SystemPolicyV1Client systemPolicyV1Client = SystemPolicyV1Client.create()) {
 *   PolicyName name = PolicyName.ofLocationName("[LOCATION]");
 *   Resources.Policy response = systemPolicyV1Client.getSystemPolicy(name);
 * }
 * }</pre>
 *
 * <p>======================= ValidationHelperV1Client =======================
 *
 * <p>Service Description: BinAuthz Attestor verification
 *
 * <p>Sample for ValidationHelperV1Client:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ValidationHelperV1Client validationHelperV1Client = ValidationHelperV1Client.create()) {
 *   Service.ValidateAttestationOccurrenceRequest request =
 *       Service.ValidateAttestationOccurrenceRequest.newBuilder()
 *           .setAttestor("attestor542920680")
 *           .setAttestation(AttestationOccurrence.newBuilder().build())
 *           .setOccurrenceNote("occurrenceNote1722072419")
 *           .setOccurrenceResourceUri("occurrenceResourceUri1001424877")
 *           .build();
 *   Service.ValidateAttestationOccurrenceResponse response =
 *       validationHelperV1Client.validateAttestationOccurrence(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.protos.google.cloud.binaryauthorization.v1;

import javax.annotation.Generated;

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
 * A client to SaaS Runtime API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= SaasDeploymentsClient =======================
 *
 * <p>Service Description: Manages the deployment of SaaS services.
 *
 * <p>Sample for SaasDeploymentsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SaasDeploymentsClient saasDeploymentsClient = SaasDeploymentsClient.create()) {
 *   SaasName name = SaasName.of("[PROJECT]", "[LOCATION]", "[SAAS]");
 *   Saas response = saasDeploymentsClient.getSaas(name);
 * }
 * }</pre>
 *
 * <p>======================= SaasRolloutsClient =======================
 *
 * <p>Service Description: Manages the rollout of SaaS services.
 *
 * <p>Sample for SaasRolloutsClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (SaasRolloutsClient saasRolloutsClient = SaasRolloutsClient.create()) {
 *   RolloutName name = RolloutName.of("[PROJECT]", "[LOCATION]", "[ROLLOUT_ID]");
 *   Rollout response = saasRolloutsClient.getRollout(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import javax.annotation.Generated;

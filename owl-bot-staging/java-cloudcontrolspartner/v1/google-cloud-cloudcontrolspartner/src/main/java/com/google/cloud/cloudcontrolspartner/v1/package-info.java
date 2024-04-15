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
 * A client to Cloud Controls Partner API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= CloudControlsPartnerCoreClient =======================
 *
 * <p>Service Description: Service describing handlers for resources
 *
 * <p>Sample for CloudControlsPartnerCoreClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudControlsPartnerCoreClient cloudControlsPartnerCoreClient =
 *     CloudControlsPartnerCoreClient.create()) {
 *   WorkloadName name =
 *       WorkloadName.of("[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]");
 *   Workload response = cloudControlsPartnerCoreClient.getWorkload(name);
 * }
 * }</pre>
 *
 * <p>======================= CloudControlsPartnerMonitoringClient =======================
 *
 * <p>Service Description: Service describing handlers for resources
 *
 * <p>Sample for CloudControlsPartnerMonitoringClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (CloudControlsPartnerMonitoringClient cloudControlsPartnerMonitoringClient =
 *     CloudControlsPartnerMonitoringClient.create()) {
 *   ViolationName name =
 *       ViolationName.of(
 *           "[ORGANIZATION]", "[LOCATION]", "[CUSTOMER]", "[WORKLOAD]", "[VIOLATION]");
 *   Violation response = cloudControlsPartnerMonitoringClient.getViolation(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.cloudcontrolspartner.v1;

import javax.annotation.Generated;

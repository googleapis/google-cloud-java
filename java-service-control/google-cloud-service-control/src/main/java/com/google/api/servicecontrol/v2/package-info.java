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
 * A client to Service Control API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ServiceControllerClient =======================
 *
 * <p>Service Description: [Service Control API
 * v2](https://cloud.google.com/service-infrastructure/docs/service-control/access-control)
 *
 * <p>Private Preview. This feature is only available for approved services.
 *
 * <p>This API provides admission control and telemetry reporting for services that are integrated
 * with [Service Infrastructure](https://cloud.google.com/service-infrastructure).
 *
 * <p>Sample for ServiceControllerClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (ServiceControllerClient serviceControllerClient = ServiceControllerClient.create()) {
 *   CheckRequest request =
 *       CheckRequest.newBuilder()
 *           .setServiceName("serviceName-1928572192")
 *           .setServiceConfigId("serviceConfigId650537426")
 *           .setAttributes(AttributeContext.newBuilder().build())
 *           .addAllResources(new ArrayList<ResourceInfo>())
 *           .setFlags("flags97513095")
 *           .build();
 *   CheckResponse response = serviceControllerClient.check(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.api.servicecontrol.v2;

import javax.annotation.Generated;

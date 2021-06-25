/*
 * Copyright 2021 Google LLC
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
 * <p>======================= QuotaControllerClient =======================
 *
 * <p>Service Description: [Google Quota Control API](/service-control/overview)
 *
 * <p>Allows clients to allocate and release quota against a [managed
 * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
 *
 * <p>Sample for QuotaControllerClient:
 *
 * <pre>{@code
 * try (QuotaControllerClient quotaControllerClient = QuotaControllerClient.create()) {
 *   AllocateQuotaRequest request =
 *       AllocateQuotaRequest.newBuilder()
 *           .setServiceName("serviceName-1928572192")
 *           .setAllocateOperation(QuotaOperation.newBuilder().build())
 *           .setServiceConfigId("serviceConfigId650537426")
 *           .build();
 *   AllocateQuotaResponse response = quotaControllerClient.allocateQuota(request);
 * }
 * }</pre>
 *
 * <p>======================= ServiceControllerClient =======================
 *
 * <p>Service Description: [Google Service Control API](/service-control/overview)
 *
 * <p>Lets clients check and report operations against a [managed
 * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
 *
 * <p>Sample for ServiceControllerClient:
 *
 * <pre>{@code
 * try (ServiceControllerClient serviceControllerClient = ServiceControllerClient.create()) {
 *   CheckRequest request =
 *       CheckRequest.newBuilder()
 *           .setServiceName("serviceName-1928572192")
 *           .setOperation(Operation.newBuilder().build())
 *           .setServiceConfigId("serviceConfigId650537426")
 *           .build();
 *   CheckResponse response = serviceControllerClient.check(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.api.servicecontrol.v1;

import javax.annotation.Generated;

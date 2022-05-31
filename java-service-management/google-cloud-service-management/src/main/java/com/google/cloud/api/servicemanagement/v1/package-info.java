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
 * A client to Service Management API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= ServiceManagerClient =======================
 *
 * <p>Service Description: [Google Service Management
 * API](https://cloud.google.com/service-infrastructure/docs/overview)
 *
 * <p>Sample for ServiceManagerClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * try (ServiceManagerClient serviceManagerClient = ServiceManagerClient.create()) {
 *   String serviceName = "serviceName-1928572192";
 *   ManagedService response = serviceManagerClient.getService(serviceName);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.api.servicemanagement.v1;

import javax.annotation.Generated;

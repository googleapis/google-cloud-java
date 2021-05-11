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
 * <p>======================= ServiceUsageClient =======================
 *
 * <p>Service Description: [Service Usage API](/service-usage/docs/overview)
 *
 * <p>Sample for ServiceUsageClient:
 *
 * <pre>{@code
 * try (ServiceUsageClient serviceUsageClient = ServiceUsageClient.create()) {
 *   GetServiceRequest request = GetServiceRequest.newBuilder().setName("name3373707").build();
 *   Service response = serviceUsageClient.getService(request);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.api.serviceusage.v1;

import javax.annotation.Generated;
